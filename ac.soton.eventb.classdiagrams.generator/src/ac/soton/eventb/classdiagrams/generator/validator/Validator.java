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
package ac.soton.eventb.classdiagrams.generator.validator;

import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor;
import org.eclipse.jface.action.Action;

import ac.soton.eventb.classdiagrams.diagram.part.ValidateAction;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsMarkerNavigationProvider;
import ac.soton.eventb.emf.diagrams.generator.AbstractValidator;
import ac.soton.eventb.emf.diagrams.generator.IValidator;

public class Validator extends AbstractValidator implements IValidator {

	/* (non-Javadoc)
	 * @see ac.soton.eventb.emf.diagrams.generator.AbstractValidator#getMarkerType()
	 */
	@Override
	protected String getMarkerType() {
		return ClassdiagramsMarkerNavigationProvider.MARKER_TYPE;
	}

	/* (non-Javadoc)
	 * @see ac.soton.eventb.emf.diagrams.generator.AbstractValidator#getValidateAction(org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditor)
	 */
	@Override
	protected Action getValidateAction(DiagramEditor diagramDocumentEditor) {
		return new ValidateAction(diagramDocumentEditor.getSite().getPage());
	}
	
	
	
}
