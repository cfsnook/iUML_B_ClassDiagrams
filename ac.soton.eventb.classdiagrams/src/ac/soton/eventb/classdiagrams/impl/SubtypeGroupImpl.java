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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eventb.emf.core.EventBObject;
import org.eventb.emf.core.impl.EventBNamedCommentedElementImpl;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.SubtypeGroup;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Subtype Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.SubtypeGroupImpl#getClass_ <em>Class</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.SubtypeGroupImpl#isCover <em>Cover</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.SubtypeGroupImpl#isDisjoint <em>Disjoint</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.SubtypeGroupImpl#getSubtypes <em>Subtypes</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SubtypeGroupImpl extends EventBNamedCommentedElementImpl implements SubtypeGroup {
	/**
	 * The cached value of the '{@link #getClass_() <em>Class</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClass_()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class class_;

	/**
	 * The default value of the '{@link #isCover() <em>Cover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCover()
	 * @generated
	 * @ordered
	 */
	protected static final boolean COVER_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isCover() <em>Cover</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isCover()
	 * @generated
	 * @ordered
	 */
	protected boolean cover = COVER_EDEFAULT;

	/**
	 * The default value of the '{@link #isDisjoint() <em>Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DISJOINT_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isDisjoint() <em>Disjoint</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDisjoint()
	 * @generated
	 * @ordered
	 */
	protected boolean disjoint = DISJOINT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SubtypeGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.SUBTYPE_GROUP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getClass_() {
		if (class_ != null && class_.eIsProxy()) {
			InternalEObject oldClass = (InternalEObject)class_;
			class_ = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldClass);
			if (class_ != oldClass) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.SUBTYPE_GROUP__CLASS, oldClass, class_));
			}
		}
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetClass() {
		return class_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setClass(ac.soton.eventb.classdiagrams.Class newClass) {
		ac.soton.eventb.classdiagrams.Class oldClass = class_;
		class_ = newClass;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.SUBTYPE_GROUP__CLASS, oldClass, class_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isCover() {
		return cover;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCover(boolean newCover) {
		boolean oldCover = cover;
		cover = newCover;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.SUBTYPE_GROUP__COVER, oldCover, cover));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDisjoint() {
		return disjoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDisjoint(boolean newDisjoint) {
		boolean oldDisjoint = disjoint;
		disjoint = newDisjoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.SUBTYPE_GROUP__DISJOINT, oldDisjoint, disjoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * This returns a list of the iUML-B Classes which target this SubtypeGroup as (one of) their supertypes.
	 * <!-- end-user-doc -->
	 * @generated  NOT
	 */
	public EList<ac.soton.eventb.classdiagrams.Class> getSubtypes() {
		List<ac.soton.eventb.classdiagrams.Class> subtypes = new  ArrayList<Class>();
		EventBObject cd = this.getContaining(ClassdiagramsPackage.Literals.CLASSDIAGRAM);
		for (EObject c : cd.getAllContained(ClassdiagramsPackage.Literals.CLASS, true)){
			if (c instanceof Class && ((Class)c).getSupertypes().contains(this) ) {
				subtypes.add((Class)c);
			}
		}
		return new BasicEList.UnmodifiableEList<Class>(subtypes.size(),subtypes.toArray()) ;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.SUBTYPE_GROUP__CLASS:
				if (resolve) return getClass_();
				return basicGetClass();
			case ClassdiagramsPackage.SUBTYPE_GROUP__COVER:
				return isCover();
			case ClassdiagramsPackage.SUBTYPE_GROUP__DISJOINT:
				return isDisjoint();
			case ClassdiagramsPackage.SUBTYPE_GROUP__SUBTYPES:
				return getSubtypes();
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
			case ClassdiagramsPackage.SUBTYPE_GROUP__CLASS:
				setClass((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.SUBTYPE_GROUP__COVER:
				setCover((Boolean)newValue);
				return;
			case ClassdiagramsPackage.SUBTYPE_GROUP__DISJOINT:
				setDisjoint((Boolean)newValue);
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
			case ClassdiagramsPackage.SUBTYPE_GROUP__CLASS:
				setClass((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.SUBTYPE_GROUP__COVER:
				setCover(COVER_EDEFAULT);
				return;
			case ClassdiagramsPackage.SUBTYPE_GROUP__DISJOINT:
				setDisjoint(DISJOINT_EDEFAULT);
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
			case ClassdiagramsPackage.SUBTYPE_GROUP__CLASS:
				return class_ != null;
			case ClassdiagramsPackage.SUBTYPE_GROUP__COVER:
				return cover != COVER_EDEFAULT;
			case ClassdiagramsPackage.SUBTYPE_GROUP__DISJOINT:
				return disjoint != DISJOINT_EDEFAULT;
			case ClassdiagramsPackage.SUBTYPE_GROUP__SUBTYPES:
				return !getSubtypes().isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (cover: ");
		result.append(cover);
		result.append(", disjoint: ");
		result.append(disjoint);
		result.append(')');
		return result.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * Returns the iUML-B Class that this SuperType represents
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Class toSuperClass() {
		return this.getClass_();
	}

} //SuperTypeConnectorImpl
