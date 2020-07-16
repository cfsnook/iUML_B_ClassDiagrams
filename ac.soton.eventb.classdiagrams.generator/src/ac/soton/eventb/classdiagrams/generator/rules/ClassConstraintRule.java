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
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.emf.translator.TranslationDescriptor;
import ac.soton.emf.translator.configuration.IRule;
import ac.soton.emf.translator.eventb.rules.AbstractEventBGeneratorRule;
import ac.soton.emf.translator.eventb.utils.Make;
import ac.soton.emf.translator.eventb.utils.Utils;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;

public class ClassConstraintRule extends AbstractEventBGeneratorRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;

	@Override
	public List<TranslationDescriptor> fire(EObject sourceElement, List<TranslationDescriptor> generatedElements) throws Exception {
		List<TranslationDescriptor> ret = new ArrayList<TranslationDescriptor>();
		ClassConstraint element = (ClassConstraint)sourceElement;
		Class parentClass = (Class) element.eContainer();
		String instances = parentClass.getElaborates() == null? "("+parentClass.getName()+")" : parentClass.getElaborates().getName();

		//create element
		EventBElement newGeneratedPredicateElement = null;
		EReference newGeneratedPredicateContainmentFeature = null;
		String predicate = Strings.CLASS_CONSTRAINT_PRED(parentClass.getSelfName(), instances, element.getPredicate());

		EventBNamedCommentedComponentElement component = element.getComponent();
		if (component==null) component = (EventBNamedCommentedComponentElement) Utils.getTranslationTarget();
				
		if (component instanceof Machine){
			newGeneratedPredicateContainmentFeature = invariants;
			newGeneratedPredicateElement = (EventBElement) Make.invariant(Strings.CLASS_CONSTRAINT_NAME(element.getName()), element.isTheorem(), predicate, element.getComment());			
		}else if (component instanceof Context){
			newGeneratedPredicateContainmentFeature = axioms;
			newGeneratedPredicateElement = (EventBElement) Make.axiom(Strings.CLASS_CONSTRAINT_NAME(element.getName()), element.isTheorem(), predicate, element.getComment());			
		}
		//return a descriptor
		if (newGeneratedPredicateElement != null){
			ret.add(Make.descriptor(component, newGeneratedPredicateContainmentFeature, newGeneratedPredicateElement, -1));			
		}
		return ret;
	}	
}
