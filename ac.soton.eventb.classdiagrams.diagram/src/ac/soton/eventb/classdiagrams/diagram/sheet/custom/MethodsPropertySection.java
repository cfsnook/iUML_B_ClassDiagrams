/*******************************************************************************
 * Copyright (c) 20014 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEditTablePropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;


public class MethodsPropertySection extends AbstractEditTablePropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}

	@Override
	protected EReference getFeature() {
		return ClassdiagramsPackage.eINSTANCE.getClass_Methods();
	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CoreextensionPackage.eINSTANCE.getEventBLabeled_Label();
		case 1 : return CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__REFINES;
		case 2 : return CoreextensionPackage.Literals.EVENT_BEVENT_GROUP__EXTENDED;
		case 3 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
	}

	@Override
	protected boolean isMulti(final int col){
		return col==3 ? true : false;
	}
	
	
	@Override
	protected boolean isRodinKeyboard(final int col) {
		return  false;
	}
	
	@Override
	protected boolean isReadOnly(final int col) {
		return  col==0;
	}

	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 250;	//label field
		case 1 : return 100;	//refines field
		case 2 : return 100;	//extended field
		case 3 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

	@Override
	protected String getButtonLabelText() {
		return "Method  ";
	}
	
	@Override
	protected List<?> getPossibleValues(final int col){
		if (col==1) {
			Classdiagram cd = (Classdiagram) ((EventBElement) eObject).getContaining(ClassdiagramsPackage.Literals.CLASSDIAGRAM);
			Classdiagram rcd = cd.getRefines();
			EList<EObject> possibles = rcd.getAllContained(ClassdiagramsPackage.Literals.CLASS_METHOD, true);
			return possibles;
		}else
			return super.getPossibleValues(col);
	}
	
}
