package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.emf.translator.TranslationDescriptor;
import ac.soton.emf.translator.configuration.IRule;
import ac.soton.emf.translator.eventb.rules.AbstractEventBGeneratorRule;
import ac.soton.emf.translator.eventb.utils.Make;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.EventBSuperType;
import ac.soton.eventb.classdiagrams.SubtypeGroup;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;

/**
 * Generator rule for iUML-B SubtypeGroup
 * 
 * 
 */

public class SubtypeGroupRule  extends AbstractEventBGeneratorRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EObject sourceElement) throws Exception{
		assert(sourceElement instanceof SubtypeGroup);
		return ((SubtypeGroup)sourceElement).getClass() != null &&
				(
						((SubtypeGroup)sourceElement).isDisjoint() ||
						((SubtypeGroup)sourceElement).isCover()
				);
	}
		
	@Override
	public List<TranslationDescriptor> fire(EObject sourceElement, List<TranslationDescriptor> generatedElements) throws Exception {
		List<TranslationDescriptor> ret = new ArrayList<TranslationDescriptor>();
	
		// generate supertype invariants/axioms
		SubtypeGroup subtypeGroup = (SubtypeGroup)sourceElement;
		Class superClass = subtypeGroup.toSuperClass();
		List<String> subtypeNames = new ArrayList<String>();
		for (Class st : subtypeGroup.getSubtypes()) {
			subtypeNames.add(st.getName());
		}
		String name = Strings.SUBTYPEGROUP_NAME(subtypeGroup.getName());
		String predicate;
		if (subtypeNames != null && subtypeNames.size() > 0){
			if (subtypeGroup.isDisjoint()) {
				if (subtypeGroup.isCover()) {
					//partition(S,A,B,C...)
					predicate = Strings.SUBTYPEGROUP_PARTITION_PRED(superClass.getName(), subtypeNames);
				}else {
					//partition(S,A,B,C...,S\(A U B U C..))
					subtypeNames.add(superClass.getName()+"\u2216("+theUnion(subtypeNames)+")");
					predicate = Strings.SUBTYPEGROUP_PARTITION_PRED(superClass.getName(), subtypeNames);
				}
			}else {
				if (subtypeGroup.isCover()) {
					//S= A U B U C...
					predicate = Strings.SUBTYPEGROUP_UNION_PRED(superClass.getName(), theUnion(subtypeNames));
				}else {
					//nothing to do (simple sub-setting is done in the Class Rule)
					predicate = null;
				}
			}
			
			EventBNamedCommentedComponentElement targetContainer = getTargetContainer(subtypeGroup);
									
			int pri = subsetPriority(superClass);
			if (targetContainer instanceof Machine){
				ret.add(Make.descriptor(targetContainer, invariants, Make.invariant(name,predicate, subtypeGroup.getComment()), pri));
			}else if (targetContainer instanceof Context){
				ret.add(Make.descriptor(targetContainer, axioms, Make.axiom(name,predicate, subtypeGroup.getComment()), pri));				
			}
		}
		return ret;
	}

	/**
	 * Returns a suitable component to put the constraint predicate for this supertypeGroup in.
	 * 
	 * starting from the source container (that contains the subtypeGroup, 
	 * searches down the hierarchy of in-scope components (sees and extends)
	 * until a component is found that contains one of the elaborated data elements.
	 * If all other components are in scope of this component, it is return.
	 * 
	 * If no such component can be found, the source container is returned.
	 * 
	 * 
	 * @param subtypeGroup
	 * @return
	 */
	private EventBNamedCommentedComponentElement getTargetContainer(SubtypeGroup subtypeGroup) {
		//get the components that contain the elaborated data elements
		List<EventBElement> elements = new ArrayList<EventBElement>();
		for (Class c : subtypeGroup.getSubtypes()) {
			elements.add((EventBElement) c.getElaborates());
		}
		elements.add((EventBElement) subtypeGroup.toSuperClass().getElaborates()); //the supertype must also be in scope 
		return CDRuleUtils.getTargetContainer((EventBNamedCommentedComponentElement) subtypeGroup.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT), elements);
	}
	
	/**
	 * returns a string expression giving the union of the given list of names
	 * @param subtypeNames
	 * @return string expression giving the union
	 */
	private String theUnion(List<String> subtypeNames) {
		String theUnion = "";
		for (String n : subtypeNames) {
			if (theUnion.length()==0) {
				theUnion = n;
			}else {
				theUnion = theUnion+"\u222A"+n;
			}
		}
		return theUnion;
	}
	

	/**
	 * calculates the priority of this subset constraint (1 high, 10 low)
	 * the priority must ensure that the superclass has got a type constraint with higher priority
	 * therefore we add one to the min distance (in supertype relations) of the supertype 
	 * from a carrier set (or class with no supertypes). If a class with no supertypes was found we
	 *  have to assume that the top class is defined in a context elsewhere.
	 * 
	 * @param element
	 * @return priority
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
