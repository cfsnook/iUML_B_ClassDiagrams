/**
 * Copyright (c) 2013 - University of Southampton.
 * All rights reserved. This program and the accompanying materials  are made
 * available under the terms of the Eclipse Public License v1.0 which accompanies this 
 * distribution, and is available at http://www.eclipse.org/legal/epl-v10.html
 * 
 *
 * $Id$
 */
package ac.soton.eventb.classdiagrams.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.impl.EventBNamedCommentedDerivedPredicateElementImpl;

import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import org.eclipse.emf.common.notify.Notification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class Constraint</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassConstraintImpl#getComponent <em>Component</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassConstraintImpl extends EventBNamedCommentedDerivedPredicateElementImpl implements ClassConstraint {
	/**
	 * The cached value of the '{@link #getComponent() <em>Component</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponent()
	 * @generated
	 * @ordered
	 */
	protected EventBNamedCommentedComponentElement component;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassConstraintImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS_CONSTRAINT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamedCommentedComponentElement getComponent() {
		if (component != null && component.eIsProxy()) {
			InternalEObject oldComponent = (InternalEObject)component;
			component = (EventBNamedCommentedComponentElement)eResolveProxy(oldComponent);
			if (component != oldComponent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT, oldComponent, component));
			}
		}
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventBNamedCommentedComponentElement basicGetComponent() {
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponent(EventBNamedCommentedComponentElement newComponent) {
		EventBNamedCommentedComponentElement oldComponent = component;
		component = newComponent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT, oldComponent, component));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT:
				if (resolve) return getComponent();
				return basicGetComponent();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT:
				setComponent((EventBNamedCommentedComponentElement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT:
				setComponent((EventBNamedCommentedComponentElement)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS_CONSTRAINT__COMPONENT:
				return component != null;
		}
		return super.eIsSet(featureID);
	}

} //ClassConstraintImpl
