/*******************************************************************************
 * Copyright (c) 2020-2020 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.classdiagrams.navigator.actions;

import ac.soton.eventb.classdiagrams.ClassdiagramsFactory;
import ac.soton.eventb.emf.diagrams.Diagram;
import ac.soton.eventb.emf.diagrams.navigator.handler.AbstractAddDiagramHandler;

/**
 * Command handler for adding a new classdiagram to a suitable container (see extension point for enablement)
 * 
 * Based on ac.soton.eventb.emf.diagrams.navigator.handler.AbstractAddDiagramHandler
 * All we need to do is implement the method to create a new diagram.
 * 
 * @author cfsnook
 *
 */
public class AddClassdiagramHandler extends AbstractAddDiagramHandler {

	@Override
	public Diagram createNewDiagram() {
		return ClassdiagramsFactory.eINSTANCE.createClassdiagram();
	}
	
}
