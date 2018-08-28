/*
 * Copyright (c) 2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * Instances property section for Class.
 * 
 * @author cfs
 *
 */
public class InstancesPropertySection extends AbstractTextPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof Class;
		}
	}
	@Override
	protected String getPropertyNameLabel() {
		return "Instances:";
	}
	
	@Override
	protected void setPropertyValue(EObject object, Object value) {
		assert object instanceof Class;
		((Class) object).setInstances((String)value);
	}

	@Override
	protected String getPropertyValueString() {
		String ret = ((Class) getEObject()).getInstances();
		return ret==null? "" : ret;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change instances";
	}
	
	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() || 
				(eObject instanceof EventBNamedCommentedDataElaborationElement && 
						((EventBNamedCommentedDataElaborationElement)eObject).getDataKind()==DataKind.VARIABLE
				) ;
	}
	
	protected boolean isRodinKeyboard(){
		return true;
	}
	
	protected boolean isMultiLine(){
		return true;
	}
}
