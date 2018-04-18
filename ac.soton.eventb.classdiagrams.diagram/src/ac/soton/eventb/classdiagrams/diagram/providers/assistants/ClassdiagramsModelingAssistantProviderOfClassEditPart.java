/*
 * Copyright (c) 2012-2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.providers.assistants;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsModelingAssistantProvider;

/**
 * @generated
 */
public class ClassdiagramsModelingAssistantProviderOfClassEditPart extends ClassdiagramsModelingAssistantProvider {

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForPopupBar(IAdaptable host) {
		List<IElementType> types = new ArrayList<IElementType>(3);
		types.add(ClassdiagramsElementTypes.ClassAttribute_3022);
		types.add(ClassdiagramsElementTypes.ClassMethod_3023);
		types.add(ClassdiagramsElementTypes.ClassConstraint_3024);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSource(IAdaptable source) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSource((ClassEditPart) sourceEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSource(ClassEditPart source) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassdiagramsElementTypes.Association_4005);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnSourceAndTarget(IAdaptable source, IAdaptable target) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnSourceAndTarget((ClassEditPart) sourceEditPart, targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnSourceAndTarget(ClassEditPart source, IGraphicalEditPart targetEditPart) {
		List<IElementType> types = new LinkedList<IElementType>();
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassdiagramsElementTypes.Association_4005);
		}
		if (targetEditPart instanceof ClassEditPart) {
			types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForTarget(IAdaptable source, IElementType relationshipType) {
		IGraphicalEditPart sourceEditPart = (IGraphicalEditPart) source.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForTarget((ClassEditPart) sourceEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForTarget(ClassEditPart source, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4005) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4006) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		}
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getRelTypesOnTarget(IAdaptable target) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetRelTypesOnTarget((ClassEditPart) targetEditPart);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetRelTypesOnTarget(ClassEditPart target) {
		List<IElementType> types = new ArrayList<IElementType>(2);
		types.add(ClassdiagramsElementTypes.Association_4005);
		types.add(ClassdiagramsElementTypes.ClassSupertypes_4006);
		return types;
	}

	/**
	* @generated
	*/
	@Override

	public List<IElementType> getTypesForSource(IAdaptable target, IElementType relationshipType) {
		IGraphicalEditPart targetEditPart = (IGraphicalEditPart) target.getAdapter(IGraphicalEditPart.class);
		return doGetTypesForSource((ClassEditPart) targetEditPart, relationshipType);
	}

	/**
	* @generated
	*/
	public List<IElementType> doGetTypesForSource(ClassEditPart target, IElementType relationshipType) {
		List<IElementType> types = new ArrayList<IElementType>();
		if (relationshipType == ClassdiagramsElementTypes.Association_4005) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		} else if (relationshipType == ClassdiagramsElementTypes.ClassSupertypes_4006) {
			types.add(ClassdiagramsElementTypes.Class_2003);
		}
		return types;
	}

}
