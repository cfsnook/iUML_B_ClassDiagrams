/*
* Copyright (c) 2012-2018 University of Southampton.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*/
package ac.soton.eventb.classdiagrams.diagram.edit.policies;

import org.eclipse.gef.commands.Command;
import org.eclipse.gmf.runtime.emf.type.core.requests.CreateElementRequest;

import ac.soton.eventb.classdiagrams.diagram.edit.commands.StatemachineCreateCommand;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class StatemachinesCompartmentItemSemanticEditPolicy extends ClassdiagramsBaseItemSemanticEditPolicy {

	/**
	* @generated
	*/
	public StatemachinesCompartmentItemSemanticEditPolicy() {
		super(ClassdiagramsElementTypes.Class_2003);
	}

	/**
	* @generated
	*/
	protected Command getCreateCommand(CreateElementRequest req) {
		if (ClassdiagramsElementTypes.Statemachine_3025 == req.getElementType()) {
			return getGEFWrapper(new StatemachineCreateCommand(req));
		}
		return super.getCreateCommand(req);
	}

}
