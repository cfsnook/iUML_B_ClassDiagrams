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
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.emf.translator.TranslationDescriptor;
import ac.soton.emf.translator.configuration.IRule;
import ac.soton.emf.translator.eventb.rules.AbstractEventBGeneratorRule;
import ac.soton.emf.translator.eventb.utils.Make;
import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;

public class AssociationRule extends AbstractEventBGeneratorRule  implements IRule {

protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	@Override
	public boolean enabled(EObject sourceElement) throws Exception{
		assert(sourceElement instanceof Association);
		return ((Association)sourceElement).getElaborates() != null  && !((Association)sourceElement).isRefinedElement();
	}

	@Override
	public List<TranslationDescriptor> fire(EObject sourceElement, List<TranslationDescriptor> generatedElements) throws Exception {
		List<TranslationDescriptor> ret = new ArrayList<TranslationDescriptor>();
		Association element = (Association)sourceElement;
		EventBElement elaborated = (EventBElement) element.getElaborates();
		EventBNamedCommentedComponentElement component = (EventBNamedCommentedComponentElement) elaborated.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT);		
		EventBElement newGeneratedTypePredicate = null;
		EReference newGeneratedTypePredicateContainer = null;
		EventBElement newGeneratedInjectionPredicate = null;
		switch (element.getDataKind().getValue()) {
		case DataKind.SET_VALUE :
			// should not get here - associations cannot be sets. make a constant instead.
		case DataKind.CONSTANT_VALUE :
			newGeneratedTypePredicate = (EventBElement) Make.axiom(Strings.ASSOCIATION_PRED_NAME(element.getName()), Strings.ASSOCIATION_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = axioms;
			if (element.isInjective() && (!element.isFunctional() || (element.isSurjective() && !element.isTotal()) )){
				newGeneratedInjectionPredicate = (EventBElement) Make.axiom(Strings.ASSOCIATION_INJECTIVE_PRED_NAME(element.getName()), Strings.ASSOCIATION_INJECTIVE_PRED(element), element.getComment());
			}
			break;
		case DataKind.VARIABLE_VALUE :
			newGeneratedTypePredicate = (EventBElement) Make.invariant(Strings.ASSOCIATION_PRED_NAME(element.getName()), Strings.ASSOCIATION_PRED(element), element.getComment());
			newGeneratedTypePredicateContainer = invariants;
			if (element.isInjective() && (!element.isFunctional() || (element.isSurjective() && !element.isTotal()) )){
				newGeneratedInjectionPredicate = (EventBElement) Make.invariant(Strings.ASSOCIATION_INJECTIVE_PRED_NAME(element.getName()), Strings.ASSOCIATION_INJECTIVE_PRED(element), element.getComment());
			}
			break;
		}
		ret.add(Make.descriptor(component, newGeneratedTypePredicateContainer,newGeneratedTypePredicate, 5));
		if (newGeneratedInjectionPredicate != null){
			ret.add(Make.descriptor(component, newGeneratedTypePredicateContainer, newGeneratedInjectionPredicate, 6));			
		}
		return ret;
	}

}
