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

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.Classdiagram;
import ac.soton.eventb.classdiagrams.ClassdiagramOwner;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.EventBSuperType;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.impl.EventBNamedCommentedDataElaborationElementImpl;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachineOwner;
import ac.soton.eventb.statemachines.StatemachinesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassdiagrams <em>Classdiagrams</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getStatemachines <em>Statemachines</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSupertypes <em>Supertypes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getClassAttributes <em>Class Attributes</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getIncoming <em>Incoming</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getOutgoing <em>Outgoing</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getRefines <em>Refines</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getConstraints <em>Constraints</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getMethods <em>Methods</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link ac.soton.eventb.classdiagrams.impl.ClassImpl#getInstances <em>Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ClassImpl extends EventBNamedCommentedDataElaborationElementImpl implements ac.soton.eventb.classdiagrams.Class {
	/**
	 * The cached value of the '{@link #getClassdiagrams() <em>Classdiagrams</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassdiagrams()
	 * @generated
	 * @ordered
	 */
	protected EList<Classdiagram> classdiagrams;

	/**
	 * The cached value of the '{@link #getStatemachines() <em>Statemachines</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatemachines()
	 * @generated
	 * @ordered
	 */
	protected EList<Statemachine> statemachines;

	/**
	 * The cached value of the '{@link #getSupertypes() <em>Supertypes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSupertypes()
	 * @generated
	 * @ordered
	 */
	protected EList<EventBSuperType> supertypes;

	/**
	 * The cached value of the '{@link #getClassAttributes() <em>Class Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassAttribute> classAttributes;

	/**
	 * The cached value of the '{@link #getIncoming() <em>Incoming</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIncoming()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> incoming;

	/**
	 * The cached value of the '{@link #getOutgoing() <em>Outgoing</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutgoing()
	 * @generated
	 * @ordered
	 */
	protected EList<Association> outgoing;

	/**
	 * The cached value of the '{@link #getRefines() <em>Refines</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefines()
	 * @generated
	 * @ordered
	 */
	protected ac.soton.eventb.classdiagrams.Class refines;

	/**
	 * The cached value of the '{@link #getConstraints() <em>Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassConstraint> constraints;

	/**
	 * The cached value of the '{@link #getMethods() <em>Methods</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethods()
	 * @generated
	 * @ordered
	 */
	protected EList<ClassMethod> methods;

	/**
	 * The default value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected static final String SELF_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSelfName() <em>Self Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSelfName()
	 * @generated
	 * @ordered
	 */
	protected String selfName = SELF_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getInstances() <em>Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected static final String INSTANCES_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getInstances() <em>Instances</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInstances()
	 * @generated
	 * @ordered
	 */
	protected String instances = INSTANCES_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ClassdiagramsPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Classdiagram> getClassdiagrams() {
		if (classdiagrams == null) {
			classdiagrams = new EObjectContainmentEList.Resolving<Classdiagram>(Classdiagram.class, this, ClassdiagramsPackage.CLASS__CLASSDIAGRAMS);
		}
		return classdiagrams;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statemachine> getStatemachines() {
		if (statemachines == null) {
			statemachines = new EObjectContainmentEList<Statemachine>(Statemachine.class, this, ClassdiagramsPackage.CLASS__STATEMACHINES);
		}
		return statemachines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EventBSuperType> getSupertypes() {
		if (supertypes == null) {
			supertypes = new EObjectResolvingEList<EventBSuperType>(EventBSuperType.class, this, ClassdiagramsPackage.CLASS__SUPERTYPES);
		}
		return supertypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassAttribute> getClassAttributes() {
		if (classAttributes == null) {
			classAttributes = new EObjectContainmentEList.Resolving<ClassAttribute>(ClassAttribute.class, this, ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES);
		}
		return classAttributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getIncoming() {
		if (incoming == null) {
			incoming = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassdiagramsPackage.CLASS__INCOMING, ClassdiagramsPackage.ASSOCIATION__TARGET);
		}
		return incoming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Association> getOutgoing() {
		if (outgoing == null) {
			outgoing = new EObjectWithInverseResolvingEList<Association>(Association.class, this, ClassdiagramsPackage.CLASS__OUTGOING, ClassdiagramsPackage.ASSOCIATION__SOURCE);
		}
		return outgoing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class getRefines() {
		if (refines != null && refines.eIsProxy()) {
			InternalEObject oldRefines = (InternalEObject)refines;
			refines = (ac.soton.eventb.classdiagrams.Class)eResolveProxy(oldRefines);
			if (refines != oldRefines) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ClassdiagramsPackage.CLASS__REFINES, oldRefines, refines));
			}
		}
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ac.soton.eventb.classdiagrams.Class basicGetRefines() {
		return refines;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRefines(ac.soton.eventb.classdiagrams.Class newRefines) {
		ac.soton.eventb.classdiagrams.Class oldRefines = refines;
		refines = newRefines;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__REFINES, oldRefines, refines));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassConstraint> getConstraints() {
		if (constraints == null) {
			constraints = new EObjectContainmentEList.Resolving<ClassConstraint>(ClassConstraint.class, this, ClassdiagramsPackage.CLASS__CONSTRAINTS);
		}
		return constraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ClassMethod> getMethods() {
		if (methods == null) {
			methods = new EObjectContainmentEList.Resolving<ClassMethod>(ClassMethod.class, this, ClassdiagramsPackage.CLASS__METHODS);
		}
		return methods;
	}

	/**
	 * <!-- begin-user-doc -->
	 * gets the name to be used for the contextual instance of the class
	 * if this class refines another the refined class' self name is returned, otherwise
	 * defaults to "this_<ClassName>" if null or empty
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public String getSelfName() {
		if (getRefines()!=null) {
			return  getRefines().getSelfName();
		}
		if (selfName ==null || selfName.trim().equals("")){
			return "this_"+ this.getName();
		}
		return selfName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSelfName(String newSelfName) {
		String oldSelfName = selfName;
		selfName = newSelfName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__SELF_NAME, oldSelfName, selfName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getInstances() {
		return instances;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInstances(String newInstances) {
		String oldInstances = instances;
		instances = newInstances;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ClassdiagramsPackage.CLASS__INSTANCES, oldInstances, instances));
	}

	/**
	 * <!-- begin-user-doc -->
	 * If this class is used as an EventBSuperType then this method will return the 
	 * class it represents.. i.e. itself
	 * <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public ac.soton.eventb.classdiagrams.Class toSuperClass() {
		return this;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIncoming()).basicAdd(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getOutgoing()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS:
				return ((InternalEList<?>)getClassdiagrams()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__STATEMACHINES:
				return ((InternalEList<?>)getStatemachines()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return ((InternalEList<?>)getClassAttributes()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__INCOMING:
				return ((InternalEList<?>)getIncoming()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return ((InternalEList<?>)getOutgoing()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return ((InternalEList<?>)getConstraints()).basicRemove(otherEnd, msgs);
			case ClassdiagramsPackage.CLASS__METHODS:
				return ((InternalEList<?>)getMethods()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS:
				return getClassdiagrams();
			case ClassdiagramsPackage.CLASS__STATEMACHINES:
				return getStatemachines();
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return getSupertypes();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return getClassAttributes();
			case ClassdiagramsPackage.CLASS__INCOMING:
				return getIncoming();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return getOutgoing();
			case ClassdiagramsPackage.CLASS__REFINES:
				if (resolve) return getRefines();
				return basicGetRefines();
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return getConstraints();
			case ClassdiagramsPackage.CLASS__METHODS:
				return getMethods();
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				return getSelfName();
			case ClassdiagramsPackage.CLASS__INSTANCES:
				return getInstances();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS:
				getClassdiagrams().clear();
				getClassdiagrams().addAll((Collection<? extends Classdiagram>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__STATEMACHINES:
				getStatemachines().clear();
				getStatemachines().addAll((Collection<? extends Statemachine>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				getSupertypes().addAll((Collection<? extends EventBSuperType>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
				getClassAttributes().addAll((Collection<? extends ClassAttribute>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				getIncoming().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				getOutgoing().addAll((Collection<? extends Association>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				setRefines((ac.soton.eventb.classdiagrams.Class)newValue);
				return;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				getConstraints().clear();
				getConstraints().addAll((Collection<? extends ClassConstraint>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__METHODS:
				getMethods().clear();
				getMethods().addAll((Collection<? extends ClassMethod>)newValue);
				return;
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				setSelfName((String)newValue);
				return;
			case ClassdiagramsPackage.CLASS__INSTANCES:
				setInstances((String)newValue);
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
			case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS:
				getClassdiagrams().clear();
				return;
			case ClassdiagramsPackage.CLASS__STATEMACHINES:
				getStatemachines().clear();
				return;
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				getSupertypes().clear();
				return;
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				getClassAttributes().clear();
				return;
			case ClassdiagramsPackage.CLASS__INCOMING:
				getIncoming().clear();
				return;
			case ClassdiagramsPackage.CLASS__OUTGOING:
				getOutgoing().clear();
				return;
			case ClassdiagramsPackage.CLASS__REFINES:
				setRefines((ac.soton.eventb.classdiagrams.Class)null);
				return;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				getConstraints().clear();
				return;
			case ClassdiagramsPackage.CLASS__METHODS:
				getMethods().clear();
				return;
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				setSelfName(SELF_NAME_EDEFAULT);
				return;
			case ClassdiagramsPackage.CLASS__INSTANCES:
				setInstances(INSTANCES_EDEFAULT);
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
			case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS:
				return classdiagrams != null && !classdiagrams.isEmpty();
			case ClassdiagramsPackage.CLASS__STATEMACHINES:
				return statemachines != null && !statemachines.isEmpty();
			case ClassdiagramsPackage.CLASS__SUPERTYPES:
				return supertypes != null && !supertypes.isEmpty();
			case ClassdiagramsPackage.CLASS__CLASS_ATTRIBUTES:
				return classAttributes != null && !classAttributes.isEmpty();
			case ClassdiagramsPackage.CLASS__INCOMING:
				return incoming != null && !incoming.isEmpty();
			case ClassdiagramsPackage.CLASS__OUTGOING:
				return outgoing != null && !outgoing.isEmpty();
			case ClassdiagramsPackage.CLASS__REFINES:
				return refines != null;
			case ClassdiagramsPackage.CLASS__CONSTRAINTS:
				return constraints != null && !constraints.isEmpty();
			case ClassdiagramsPackage.CLASS__METHODS:
				return methods != null && !methods.isEmpty();
			case ClassdiagramsPackage.CLASS__SELF_NAME:
				return SELF_NAME_EDEFAULT == null ? selfName != null : !SELF_NAME_EDEFAULT.equals(selfName);
			case ClassdiagramsPackage.CLASS__INSTANCES:
				return INSTANCES_EDEFAULT == null ? instances != null : !INSTANCES_EDEFAULT.equals(instances);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == EventBSuperType.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ClassdiagramOwner.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS__CLASSDIAGRAMS: return ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == StatemachineOwner.class) {
			switch (derivedFeatureID) {
				case ClassdiagramsPackage.CLASS__STATEMACHINES: return StatemachinesPackage.STATEMACHINE_OWNER__STATEMACHINES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == EventBSuperType.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == ClassdiagramOwner.class) {
			switch (baseFeatureID) {
				case ClassdiagramsPackage.CLASSDIAGRAM_OWNER__CLASSDIAGRAMS: return ClassdiagramsPackage.CLASS__CLASSDIAGRAMS;
				default: return -1;
			}
		}
		if (baseClass == StatemachineOwner.class) {
			switch (baseFeatureID) {
				case StatemachinesPackage.STATEMACHINE_OWNER__STATEMACHINES: return ClassdiagramsPackage.CLASS__STATEMACHINES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (selfName: ");
		result.append(selfName);
		result.append(", instances: ");
		result.append(instances);
		result.append(')');
		return result.toString();
	}

	
	////custom - override getters to return refined Class values for some attributes
	
	/**
	 * <!-- begin-user-doc -->
	 * gets the name of the class
	 * if this class refines another the refined class' name is returned, 
	 * otherwise the local Name attribute is returned
	 * <!-- end-user-doc -->
	 * @custom
	 */
	@Override
	public String getName() { 
		if (getRefines()!=null && getRefines()!=this) {
			return getRefines().getName();
		}
		return super.getName();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * gets the dataKind of the class
	 * if this class refines another the refined class' dataKind is returned, 
	 * otherwise the local dataKind attribute is returned
	 * <!-- end-user-doc -->
	 * @custom
	 */
	@Override
	public DataKind getDataKind() { 
		if (getRefines()!=null) {
			return getRefines().getDataKind();
		}
		return super.getDataKind();
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * gets the elaborates of the class
	 * if this class refines another the refined class' elaborates is returned, 
	 * otherwise the local elaborates attribute is returned
	 * <!-- end-user-doc -->
	 * @custom
	 */
	@Override
	public EventBNamed getElaborates() { 
		if (getRefines()!=null) {
			return getRefines().getElaborates();
		}
		return super.getElaborates();
	}
	
	
} //ClassImpl
