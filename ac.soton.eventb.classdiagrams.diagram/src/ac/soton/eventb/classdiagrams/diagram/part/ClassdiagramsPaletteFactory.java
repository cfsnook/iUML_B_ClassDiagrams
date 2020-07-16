/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.part;

import java.util.Collections;
import java.util.List;

import org.eclipse.gef.Tool;
import org.eclipse.gef.palette.PaletteContainer;
import org.eclipse.gef.palette.PaletteDrawer;
import org.eclipse.gef.palette.PaletteRoot;
import org.eclipse.gef.palette.ToolEntry;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeConnectionTool;
import org.eclipse.gmf.runtime.diagram.ui.tools.UnspecifiedTypeCreationTool;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;

import org.eclipse.gmf.tooling.runtime.part.DefaultLinkToolEntry;
import org.eclipse.gmf.tooling.runtime.part.DefaultNodeToolEntry;
import ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes;

/**
 * @generated
 */
public class ClassdiagramsPaletteFactory {

	/**
	 * @generated
	 */
	public void fillPalette(PaletteRoot paletteRoot) {
		paletteRoot.add(createClasses1Group());
		paletteRoot.add(createFeatures2Group());
		paletteRoot.add(createConnections3Group());
	}

	/**
	 * Creates "Classes" palette tool group
	 * @generated
	 */
	private PaletteContainer createClasses1Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Classes1Group_title);
		paletteContainer.setId("createClasses1Group"); //$NON-NLS-1$
		paletteContainer.add(createClass1CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Features" palette tool group
	 * @generated
	 */
	private PaletteContainer createFeatures2Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Features2Group_title);
		paletteContainer.setId("createFeatures2Group"); //$NON-NLS-1$
		paletteContainer.add(createAttribute1CreationTool());
		paletteContainer.add(createStatemachine2CreationTool());
		paletteContainer.add(createMethod3CreationTool());
		paletteContainer.add(createConstraint4CreationTool());
		return paletteContainer;
	}

	/**
	 * Creates "Connections" palette tool group
	 * @generated
	 */
	private PaletteContainer createConnections3Group() {
		PaletteDrawer paletteContainer = new PaletteDrawer(Messages.Connections3Group_title);
		paletteContainer.setId("createConnections3Group"); //$NON-NLS-1$
		paletteContainer.add(createAssociation1CreationTool());
		paletteContainer.add(createSupertype2CreationTool());
		paletteContainer.add(createSubtypeGroup3CreationTool());
		return paletteContainer;
	}

	/**
	 * @generated
	 */
	private ToolEntry createClass1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Class1CreationTool_title,
				Messages.Class1CreationTool_desc, Collections.singletonList(ClassdiagramsElementTypes.Class_2003));
		entry.setId("createClass1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.Class_2003));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAttribute1CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Attribute1CreationTool_title,
				Messages.Attribute1CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.ClassAttribute_3022));
		entry.setId("createAttribute1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.ClassAttribute_3022));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createStatemachine2CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Statemachine2CreationTool_title,
				Messages.Statemachine2CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.Statemachine_3025));
		entry.setId("createStatemachine2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.classdiagrams.edit/icons/full/obj16/Statemachine.gif")); //$NON-NLS-1$
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createMethod3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Method3CreationTool_title,
				Messages.Method3CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.ClassMethod_3023));
		entry.setId("createMethod3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.ClassMethod_3023));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createConstraint4CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.Constraint4CreationTool_title,
				Messages.Constraint4CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.ClassConstraint_3024));
		entry.setId("createConstraint4CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(
				ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.ClassConstraint_3024));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createAssociation1CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Association1CreationTool_title,
				Messages.Association1CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.Association_4005));
		entry.setId("createAssociation1CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.Association_4005));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}

	/**
	 * @generated
	 */
	private ToolEntry createSupertype2CreationTool() {
		DefaultLinkToolEntry entry = new DefaultLinkToolEntry(Messages.Supertype2CreationTool_title,
				Messages.Supertype2CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.ClassSupertypes_4006));
		entry.setId("createSupertype2CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.classdiagrams.edit/icons/full/obj16/Supertype.gif")); //$NON-NLS-1$
		entry.setLargeIcon(ClassdiagramsDiagramEditorPlugin
				.findImageDescriptor("/ac.soton.eventb.classdiagrams.edit/icons/full/obj16/Supertype.gif")); //$NON-NLS-1$
		return entry;
	}

	/**
	* @generated
	*/
	private ToolEntry createSubtypeGroup3CreationTool() {
		DefaultNodeToolEntry entry = new DefaultNodeToolEntry(Messages.SubtypeGroup3CreationTool_title,
				Messages.SubtypeGroup3CreationTool_desc,
				Collections.singletonList(ClassdiagramsElementTypes.SubtypeGroup_3026));
		entry.setId("createSubtypeGroup3CreationTool"); //$NON-NLS-1$
		entry.setSmallIcon(ClassdiagramsElementTypes.getImageDescriptor(ClassdiagramsElementTypes.SubtypeGroup_3026));
		entry.setLargeIcon(entry.getSmallIcon());
		return entry;
	}
}
