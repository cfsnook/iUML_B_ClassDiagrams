/*
 * Copyright (c) 2012-2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsModelingAssistantProvider;

/**
 * @generated
 */
public class ClassdiagramsModelingAssistantProviderOfClassdiagramEditPart
		extends ClassdiagramsModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(1);
		types.add(ClassdiagramsElementTypes.Class_2003);
		return types;
	}

}
