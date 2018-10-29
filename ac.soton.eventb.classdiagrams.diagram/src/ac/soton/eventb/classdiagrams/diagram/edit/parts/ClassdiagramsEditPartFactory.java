/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.edit.parts;

import org.eclipse.draw2d.FigureUtilities;
import org.eclipse.draw2d.Label;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gef.tools.CellEditorLocator;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ITextAwareEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.WrappingLabel;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.gmf.tooling.runtime.directedit.locator.CellEditorLocatorAccess;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;

import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;

/**
 * @generated
 */
public class ClassdiagramsEditPartFactory implements EditPartFactory {

	/**
	 * @generated
	 */
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (ClassdiagramsVisualIDRegistry.getVisualID(view)) {

			case ClassdiagramEditPart.VISUAL_ID:
				return new ClassdiagramEditPart(view);

			case ClassEditPart.VISUAL_ID:
				return new ClassEditPart(view);

			case ClassNameEditPart.VISUAL_ID:
				return new ClassNameEditPart(view);

			case ClassAttributeEditPart.VISUAL_ID:
				return new ClassAttributeEditPart(view);

			case StatemachineEditPart.VISUAL_ID:
				return new StatemachineEditPart(view);

			case ClassMethodEditPart.VISUAL_ID:
				return new ClassMethodEditPart(view);

			case ClassConstraintEditPart.VISUAL_ID:
				return new ClassConstraintEditPart(view);

			case SubtypeGroupEditPart.VISUAL_ID:
				return new SubtypeGroupEditPart(view);

			case ClassAttributesCompartmentEditPart.VISUAL_ID:
				return new ClassAttributesCompartmentEditPart(view);

			case StatemachinesCompartmentEditPart.VISUAL_ID:
				return new StatemachinesCompartmentEditPart(view);

			case ClassMethodsCompartmentEditPart.VISUAL_ID:
				return new ClassMethodsCompartmentEditPart(view);

			case ClassConstraintsCompartmentEditPart.VISUAL_ID:
				return new ClassConstraintsCompartmentEditPart(view);

			case AssociationEditPart.VISUAL_ID:
				return new AssociationEditPart(view);

			case AssociationNameEditPart.VISUAL_ID:
				return new AssociationNameEditPart(view);

			case AssociationSurjectiveInjectiveEditPart.VISUAL_ID:
				return new AssociationSurjectiveInjectiveEditPart(view);

			case AssociationTotalFunctionalEditPart.VISUAL_ID:
				return new AssociationTotalFunctionalEditPart(view);

			case ClassSupertypesEditPart.VISUAL_ID:
				return new ClassSupertypesEditPart(view);

			}
		}
		return createUnrecognizedEditPart(context, model);
	}

	/**
	 * @generated
	 */
	private EditPart createUnrecognizedEditPart(EditPart context, Object model) {
		// Handle creation of unrecognized child node EditParts here
		return null;
	}

	/**
	 * @generated
	 */
	public static CellEditorLocator getTextCellEditorLocator(ITextAwareEditPart source) {
		return CellEditorLocatorAccess.INSTANCE.getTextCellEditorLocator(source);
	}
}
