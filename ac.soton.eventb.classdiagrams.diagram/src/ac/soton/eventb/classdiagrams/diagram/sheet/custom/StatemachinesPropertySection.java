/*******************************************************************************
 * Copyright (c) 2018 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEditTablePropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;
import ac.soton.eventb.statemachines.StatemachinesPackage;


public class StatemachinesPropertySection extends AbstractEditTablePropertySection {

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
		return StatemachinesPackage.Literals.STATEMACHINE_OWNER__STATEMACHINES;
	}

	@Override
	protected EStructuralFeature getFeatureForCol(final int col) {
		switch (col) {
		case 0 : return CorePackage.eINSTANCE.getEventBNamed_Name();
		case 1 : return StatemachinesPackage.Literals.STATEMACHINE__TRANSLATION;
		case 2 : return CorePackage.eINSTANCE.getEventBCommented_Comment();
		default : return null;
		}
	}

//	@Override
//	protected boolean isMulti(final int col){
//		return col==8 ? true : false;
//	}
	
	
//	@Override
//	protected boolean isRodinKeyboard(final int col) {
//		return  col==1;
//	}
	
//	@Override
//	protected boolean isReadOnly(final int col) {
//		return  col>1 && col<4 ? true : false;
//	}

	@Override
	protected int columnWidth(final int col){
		switch (col) {
		case 0 : return 100;	//name field
		case 1 : return 100;	//translationKind field
		case 2 : return 400;	//comment field
		default : return -1;	//unknown
		}
	}

	@Override
	protected String getButtonLabelText() {
		return "Statemachine  ";
	}
//
//	@Override
//	protected String getLabelText() {
//		return "Statemachine:";
//	}
	
}
