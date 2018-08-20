/**
 * Copyright (c) 2012-2018 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.EventBSuperType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event BSuper Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * </p>
 *
 * @generated
 */
public abstract class EventBSuperTypeImpl extends EObjectImpl implements EventBSuperType {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventBSuperTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.EVENT_BSUPER_TYPE;
	}
	
	/**
	 * 
	 * Return the actual iUML-B Class that this EventBSuperType represents
	 * 
	 * @custom
	 */
	public abstract ac.soton.eventb.classdiagrams.Class toSuperClass();

} //EventBSuperTypeImpl
