/**
 * Copyright (c) 2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.List;

import org.eclipse.emf.common.util.ECollections;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.EventBEventGroup;
import ac.soton.eventb.emf.core.extension.coreextension.EventBLabeled;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * Refines property section for Method.
 * 
 *
 */
public class RefinesMethodPropertySection extends AbstractEnumerationPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof ClassMethod;
		}
	}
	
	@Override
	protected EStructuralFeature getFeature() {
		return CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__REFINES;
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		EList<EObject> methodsToRefine = getMethodsToRefine();
		String[] values = new String[methodsToRefine.size()];
		int i = 0;
		for (EObject m : methodsToRefine) {
			values[i++] = m == null ? ""
					: ((ClassMethod) m).getLabel();
		}
		return values;
	}

	@Override
	protected String getFeatureAsText() {
		EventBEventGroup m = ((ClassMethod) eObject).getRefines();
		return m == null ? "" 
				: ((EventBLabeled) m).getLabel();
	}

	@Override
	protected String getLabelText() {
		return "Refines:";
	}

	@Override
	protected List<EObject> getAvailableDataElements(){
		return (List<EObject>)getMethodsToRefine();
	}
	
	@SuppressWarnings("unchecked")
	private EList<EObject> getMethodsToRefine(){
		Classdiagram cd = (Classdiagram) ((EventBElement) eObject).getContaining(ClassdiagramsPackage.Literals.CLASSDIAGRAM);
		Classdiagram rcd = cd==null? null : cd.getRefines();
		if (rcd==null) {
			return (EList<EObject>) ECollections.EMPTY_ELIST;
		}else{
			return rcd.getAllContained(ClassdiagramsPackage.Literals.CLASS_METHOD, true);
		}
	}
	
}
