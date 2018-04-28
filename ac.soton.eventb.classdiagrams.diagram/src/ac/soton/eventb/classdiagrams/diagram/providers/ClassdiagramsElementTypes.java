/*
 * Copyright (c) 2012 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.providers;

import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gmf.runtime.emf.type.core.ElementTypeRegistry;
import org.eclipse.gmf.runtime.emf.type.core.IElementType;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypeImages;
import org.eclipse.gmf.tooling.runtime.providers.DiagramElementTypes;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.swt.graphics.Image;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.context.ContextPackage;
import org.eventb.emf.core.machine.MachinePackage;
import org.eventb.emf.core.provider.EventbcoreEditPlugin;
import org.eventb.ui.IEventBSharedImages;

import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.AssociationEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassAttributeEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassConstraintEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassMethodEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassSupertypesEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.ClassdiagramEditPart;
import ac.soton.eventb.classdiagrams.diagram.edit.parts.StatemachineEditPart;
import ac.soton.eventb.classdiagrams.diagram.part.ClassdiagramsDiagramEditorPlugin;
import ac.soton.eventb.emf.core.extension.coreextension.EventBDataElaboration;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * @generated
 */
public class ClassdiagramsElementTypes {

	/**
	 * @generated
	 */
	private ClassdiagramsElementTypes() {
	}

	/**
	 * @generated
	 */
	private static Map<IElementType, ENamedElement> elements;

	/**
	* @generated
	*/
	private static DiagramElementTypeImages elementTypeImages = new DiagramElementTypeImages(
			ClassdiagramsDiagramEditorPlugin.getInstance().getItemProvidersAdapterFactory());

	/**
	 * @generated
	 */
	private static Set<IElementType> KNOWN_ELEMENT_TYPES;

	/**
	 * @generated
	 */
	public static final IElementType Classdiagram_1000 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.Classdiagram_1000"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Class_2003 = getElementType("ac.soton.eventb.classdiagrams.diagram.Class_2003"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassAttribute_3022 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.ClassAttribute_3022"); //$NON-NLS-1$
	/**
	* @generated
	 * @since 2.0
	*/
	public static final IElementType Statemachine_3025 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.Statemachine_3025"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static final IElementType ClassMethod_3023 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.ClassMethod_3023"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassConstraint_3024 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.ClassConstraint_3024"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType Association_4005 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.Association_4005"); //$NON-NLS-1$
	/**
	 * @generated
	 */
	public static final IElementType ClassSupertypes_4006 = getElementType(
			"ac.soton.eventb.classdiagrams.diagram.ClassSupertypes_4006"); //$NON-NLS-1$

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(ENamedElement element) {
		return elementTypeImages.getImageDescriptor(element);
	}

	/**
	 * @generated
	 */
	public static Image getImage(ENamedElement element) {
		return elementTypeImages.getImage(element);
	}

	/**
	 * @generated
	 */
	public static ImageDescriptor getImageDescriptor(IAdaptable hint) {
		return getImageDescriptor(getElement(hint));
	}

	/**
	 * @generated
	 */
	public static Image getImage(IAdaptable hint) {
		return getImage(getElement(hint));
	}

	/**
	 * This is added to allow dynamic icons (dependent on model state) to be stored in the registry
	 * (to avoid creating multiple images).
	 * Be careful to make sure the key is unique to the icon!
	 * 
	 * @custom
	 * @param key
	 * @param imageDescriptor
	 * @return
	 */
	public static Image getImage(EventBElement element) {

		ENamedElement elementType = element.eClass();
		if (element instanceof EventBDataElaboration) {
			Object refines = element;
			while (refines instanceof EventBElement) {
				element = (EventBElement) refines;
				EStructuralFeature feature = element.eClass().getEStructuralFeature("refines");
				refines = (feature == null ? null : element.eGet(feature));
			}
			EStructuralFeature elaboratesfeature = element.eClass().getEStructuralFeature("elaborates");
			Object elabs = elaboratesfeature == null ? null : element.eGet(elaboratesfeature);
			if (elabs instanceof EventBElement) {
				elementType = ((EventBElement) elabs).eClass();
			}
		} else if (elementType == ClassdiagramsPackage.Literals.CLASS_CONSTRAINT) {
			if (((ClassConstraint) element).isTheorem()) {
				return IMAGE_THEOREM;
			}
			elementType = ((ClassConstraint) element).getContaining(ContextPackage.Literals.CONTEXT) == null
					? MachinePackage.Literals.INVARIANT : ContextPackage.Literals.AXIOM;
		}
		return getImage(elementType);
	}

	private static final Image IMAGE_THEOREM = EventbcoreEditPlugin.getEventBImage(IEventBSharedImages.IMG_THEOREM);

	/**
	 * Returns 'type' of the ecore object associated with the hint.
	 * 
	 * @generated
	 */
	public static ENamedElement getElement(IAdaptable hint) {
		Object type = hint.getAdapter(IElementType.class);
		if (elements == null) {
			elements = new IdentityHashMap<IElementType, ENamedElement>();

			elements.put(Classdiagram_1000, ClassdiagramsPackage.eINSTANCE.getClassdiagram());

			elements.put(Class_2003, ClassdiagramsPackage.eINSTANCE.getClass_());

			elements.put(ClassAttribute_3022, ClassdiagramsPackage.eINSTANCE.getClassAttribute());

			elements.put(Statemachine_3025, StatemachinesPackage.eINSTANCE.getStatemachine());

			elements.put(ClassMethod_3023, ClassdiagramsPackage.eINSTANCE.getClassMethod());

			elements.put(ClassConstraint_3024, ClassdiagramsPackage.eINSTANCE.getClassConstraint());

			elements.put(Association_4005, ClassdiagramsPackage.eINSTANCE.getAssociation());

			elements.put(ClassSupertypes_4006, ClassdiagramsPackage.eINSTANCE.getClass_Supertypes());
		}
		return (ENamedElement) elements.get(type);
	}

	/**
	 * @generated
	 */
	private static IElementType getElementType(String id) {
		return ElementTypeRegistry.getInstance().getType(id);
	}

	/**
	 * @generated
	 */
	public static boolean isKnownElementType(IElementType elementType) {
		if (KNOWN_ELEMENT_TYPES == null) {
			KNOWN_ELEMENT_TYPES = new HashSet<IElementType>();
			KNOWN_ELEMENT_TYPES.add(Classdiagram_1000);
			KNOWN_ELEMENT_TYPES.add(Class_2003);
			KNOWN_ELEMENT_TYPES.add(ClassAttribute_3022);
			KNOWN_ELEMENT_TYPES.add(Statemachine_3025);
			KNOWN_ELEMENT_TYPES.add(ClassMethod_3023);
			KNOWN_ELEMENT_TYPES.add(ClassConstraint_3024);
			KNOWN_ELEMENT_TYPES.add(Association_4005);
			KNOWN_ELEMENT_TYPES.add(ClassSupertypes_4006);
		}
		return KNOWN_ELEMENT_TYPES.contains(elementType);
	}

	/**
	 * @generated
	 */
	public static IElementType getElementType(int visualID) {
		switch (visualID) {
		case ClassdiagramEditPart.VISUAL_ID:
			return Classdiagram_1000;
		case ClassEditPart.VISUAL_ID:
			return Class_2003;
		case ClassAttributeEditPart.VISUAL_ID:
			return ClassAttribute_3022;
		case StatemachineEditPart.VISUAL_ID:
			return Statemachine_3025;
		case ClassMethodEditPart.VISUAL_ID:
			return ClassMethod_3023;
		case ClassConstraintEditPart.VISUAL_ID:
			return ClassConstraint_3024;
		case AssociationEditPart.VISUAL_ID:
			return Association_4005;
		case ClassSupertypesEditPart.VISUAL_ID:
			return ClassSupertypes_4006;
		}
		return null;
	}

	/**
	* @generated
	 * @since 2.0
	*/
	public static final DiagramElementTypes TYPED_INSTANCE = new DiagramElementTypes(elementTypeImages) {

		/**
		* @generated
		*/
		@Override

		public boolean isKnownElementType(IElementType elementType) {
			return ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes
					.isKnownElementType(elementType);
		}

		/**
		* @generated
		*/
		@Override

		public IElementType getElementTypeForVisualId(int visualID) {
			return ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes.getElementType(visualID);
		}

		/**
		* @generated
		*/
		@Override

		public ENamedElement getDefiningNamedElement(IAdaptable elementTypeAdapter) {
			return ac.soton.eventb.classdiagrams.diagram.providers.ClassdiagramsElementTypes
					.getElement(elementTypeAdapter);
		}
	};

}
