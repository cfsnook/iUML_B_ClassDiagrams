/**
 * Copyright (c) 2013 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.EventBNamedCommentedDerivedPredicateElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Class Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.ClassConstraint#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassConstraint()
 * @model
 * @generated
 */
public interface ClassConstraint extends EventBNamedCommentedDerivedPredicateElement {

	/**
	 * Returns the value of the '<em><b>Component</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Component</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Component</em>' reference.
	 * @see #setComponent(EventBNamedCommentedComponentElement)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getClassConstraint_Component()
	 * @model
	 * @generated
	 */
	EventBNamedCommentedComponentElement getComponent();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.ClassConstraint#getComponent <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Component</em>' reference.
	 * @see #getComponent()
	 * @generated
	 */
	void setComponent(EventBNamedCommentedComponentElement value);
} // ClassConstraint
