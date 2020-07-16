/*******************************************************************************
 *  Copyright (c) 2011-2019 University of Southampton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *  Contributors:
 *  University of Southampton - Initial implementation
 *******************************************************************************/
package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamed;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.CarrierSet;
import org.eventb.emf.core.context.Constant;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Machine;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.machine.Variable;

import ac.soton.emf.translator.TranslationDescriptor;
import ac.soton.emf.translator.configuration.IRule;
import ac.soton.emf.translator.eventb.rules.AbstractEventBGeneratorRule;
import ac.soton.emf.translator.eventb.utils.Find;
import ac.soton.emf.translator.eventb.utils.Make;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.EventBSuperType;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;

/**
 * Generator rule for iUML-B Class
 * 
 * 
 */
public class ClassRule  extends AbstractEventBGeneratorRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EObject sourceElement) throws Exception{
		assert(sourceElement instanceof Class);
		return ((Class)sourceElement).getElaborates() != null;
	}
		
	@Override
	public List<TranslationDescriptor> fire(EObject sourceElement, List<TranslationDescriptor> generatedElements) throws Exception {
		List<TranslationDescriptor> ret = new ArrayList<TranslationDescriptor>();
		EventBNamedCommentedComponentElement targetContainer;
		
		// generate supertype invariants/axioms
		Class element = (Class)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		if (element.getSupertypes() != null && element.getSupertypes().size() > 0){
						
			for (EventBSuperType superType : element.getSupertypes()){
				//note: other constraints such as disjoint and partitioned sub classes, must be handled by other rules. Here we just handle simple subsets.
				Class superClass = 	superType.toSuperClass();
				int pri = subsetPriority(superClass);
				
				targetContainer = getTargetContainer(element, superClass);				
				if (targetContainer instanceof Machine){
					ret.add(Make.descriptor(targetContainer, invariants, Make.invariant(
							Strings.CLASS_SUPERTYPE_NAME(element, superClass), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));
				}else if (targetContainer instanceof Context){
					ret.add(Make.descriptor(targetContainer, axioms, Make.axiom(
							Strings.CLASS_SUPERTYPE_NAME(element, superClass), 
							Strings.CLASS_SUPERTYPE_PRED(element, superClass), element.getComment()),pri));					
				}
			}	
		}
		
		String instances = element.getInstances();
		if (instances!=null) instances = instances.trim();
		//for constant instance classes, initialise the instances set
		if ((elaborated instanceof Constant || elaborated instanceof CarrierSet) && instances!=null && instances.length()>0){
			if (instances.startsWith("{") && instances.endsWith("}")) {
				targetContainer = getTargetContext(element);
				//instances = instances.substring(1, instances.length()-1);
				instances = instances.replaceAll(" ", "");
				String[] instanceNames = instances.split("[,{}]");
				instances = instances.replaceAll(",", "},{");
				for (String iname : instanceNames) {
					if (iname.length()>0) {
					//create a constant
					ret.add(Make.descriptor(targetContainer, constants, Make.constant(iname, "instance of class "+element.getName()), 10));	
					}
				}
				// create the partition axiom
				ret.add(Make.descriptor(targetContainer, axioms, Make.axiom(
						Strings.ENUMERATION_NAME(element), 
						Strings.ENUMERATION_PRED(element, instances), element.getComment()), 10));	
			}
		}
		
		//for variable instance classes, initialise the instances set to empty
		if (elaborated instanceof Variable){
			Event initialisationEvent = (Event) Find.named(
					((Machine) elaborated.getContaining(MachinePackage.Literals.MACHINE)).getEvents(),
					"INITIALISATION"
					);
			ret.add(Make.descriptor(
					initialisationEvent,
					actions, 
					Make.action(
							Strings.INITIALISATION_NAME((EventBNamed)sourceElement),
							Strings.EMPTY_INITIALISATION_ACTION_EXPR((EventBNamed)sourceElement))
					, 5));
		}
		
		return ret;
	}

	/**
	 * returns the Context containing the element 
	 * or a suitable target container if it is not a context
	 * 
	 * @param element
	 * @return
	 */
	private EventBNamedCommentedComponentElement getTargetContext(Class element) {
		EventBNamedCommentedComponentElement container = (EventBNamedCommentedComponentElement) element.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);
		if (container instanceof Context) {
			return (Context)container;
		}else {
			return getTargetContainer(element, null);
		}
	}

	/**
	 * Returns a suitable component to put the constraint predicate for this supertype in.
	 * 
	 * starting from the source container, 
	 * searches down the hierarchy of in-scope components (sees and extends)
	 * until a component is found that contains one of the elaborated data elements.
	 * If all other components are in scope of this component, it is return.
	 * 
	 * If no such component can be found, the source container is returned.
	 * 
	 * 
	 * @param 
	 * @return
	 */
	private EventBNamedCommentedComponentElement getTargetContainer(Class class_, Class superClass) {
		//get the components that contain the elaborated data elements
		List<EventBElement> elements = new ArrayList<EventBElement>();
		elements.add((EventBElement) class_.getElaborates());
		if (superClass!= null) elements.add((EventBElement) superClass.getElaborates()); //the supertype must also be in scope 
		return CDRuleUtils.getTargetContainer(elements);
	}
	
	/**
	 * calculates the priority of this subset constraint (1 high, 10 low)
	 * the priority must ensure that the superclass has got a type constraint with higher priority
	 * therefore we add one to the min distance (in supertype relations) of the supertype 
	 * from a carrier set (or class with no supertypes). If a class with no supertypes was found we
	 *  have to assume that the top class is defined in a context elsewhere.
	 * 
	 * @param element
	 * @return
	 */
	private int subsetPriority(Class c) {
		if (c.getDataKind().equals(DataKind.SET)){
			return 1;
		}else if (c.getSupertypes().isEmpty()){
			return 1;
		}else{
			Integer p = 10; //FIXME: There is a limit to the number of priorities we can use.
			for (EventBSuperType st : c.getSupertypes()){
					int d = subsetPriority(st.toSuperClass());
					if (d<p) p = d;
			}
			return p+1;
		}
	}
	
}
