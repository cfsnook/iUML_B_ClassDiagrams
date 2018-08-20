/**
 * Copyright (c) 2012-2018 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams;

import org.eclipse.emf.common.util.EList;
import org.eventb.emf.core.EventBNamedCommentedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subtype Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.SubtypeGroup#getClass_ <em>Class</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.SubtypeGroup#isCover <em>Cover</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.SubtypeGroup#isDisjoint <em>Disjoint</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.SubtypeGroup#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 * </p>
 *
 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getSubtypeGroup()
 * @model
 * @generated
 */
public interface SubtypeGroup extends EventBNamedCommentedElement, EventBSuperType {
	/**
	 * Returns the value of the '<em><b>Class</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class</em>' reference.
	 * @see #setClass(ac.soton.eventb.classdiagrams.Class)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getSubtypeGroup_Class()
	 * @model
	 * @generated
	 */
	ac.soton.eventb.classdiagrams.Class getClass_();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.SubtypeGroup#getClass_ <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class</em>' reference.
	 * @see #getClass_()
	 * @generated
	 */
	void setClass(ac.soton.eventb.classdiagrams.Class value);

	/**
	 * Returns the value of the '<em><b>Cover</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cover</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cover</em>' attribute.
	 * @see #setCover(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getSubtypeGroup_Cover()
	 * @model default="true"
	 * @generated
	 */
	boolean isCover();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.SubtypeGroup#isCover <em>Cover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cover</em>' attribute.
	 * @see #isCover()
	 * @generated
	 */
	void setCover(boolean value);

	/**
	 * Returns the value of the '<em><b>Disjoint</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disjoint</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disjoint</em>' attribute.
	 * @see #setDisjoint(boolean)
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getSubtypeGroup_Disjoint()
	 * @model default="true"
	 * @generated
	 */
	boolean isDisjoint();

	/**
	 * Sets the value of the '{@link ac.soton.eventb.classdiagrams.SubtypeGroup#isDisjoint <em>Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Disjoint</em>' attribute.
	 * @see #isDisjoint()
	 * @generated
	 */
	void setDisjoint(boolean value);

	/**
	 * Returns the value of the '<em><b>Subtypes</b></em>' reference list.
	 * The list contents are of type {@link ac.soton.eventb.classdiagrams.Class}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subtypes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subtypes</em>' reference list.
	 * @see ac.soton.eventb.classdiagrams.ClassdiagramsPackage#getSubtypeGroup_Subtypes()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EList<ac.soton.eventb.classdiagrams.Class> getSubtypes();

} // SubtypeGroup
