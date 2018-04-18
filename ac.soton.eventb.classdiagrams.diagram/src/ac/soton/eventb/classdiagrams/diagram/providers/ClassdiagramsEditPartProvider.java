/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.providers;

import java.lang.ref.WeakReference;

import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPartFactory;
import org.eclipse.gmf.runtime.common.core.service.IOperation;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.AbstractEditPartProvider;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.CreateGraphicEditPartOperation;
import org.eclipse.gmf.runtime.diagram.ui.services.editpart.IEditPartOperation;
import org.eclipse.gmf.runtime.notation.View;

import org.eclipse.gmf.tooling.runtime.providers.DefaultEditPartProvider;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramsEditPartFactory;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsVisualIDRegistry;

/**
 * @generated
 */
public class ClassdiagramsEditPartProvider extends DefaultEditPartProvider {

	/**
	 * @generated
	 */
	public ClassdiagramsEditPartProvider() {
		super(new ClassdiagramsEditPartFactory(), ClassdiagramsVisualIDRegistry.TYPED_INSTANCE,
				ClassdiagramEditPart.MODEL_ID);
	}
}
