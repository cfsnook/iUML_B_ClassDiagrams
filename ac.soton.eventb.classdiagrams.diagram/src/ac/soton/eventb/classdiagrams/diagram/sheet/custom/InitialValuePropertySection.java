/*
 * Copyright (c) 2010-2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.emf.core.extension.coreextension.DataKind;
import ac.soton.eventb.emf.core.extension.coreextension.EventBNamedCommentedDataElaborationElement;
import ac.soton.eventb.emf.diagrams.sheet.AbstractTextPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * InitialValue property section for Associations and Attributes.
 * 
 * @author cfs
 *
 */
public class InitialValuePropertySection extends AbstractTextPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			EObject model = DiagramUtils.unwrap(toTest);
			return (model instanceof Association || model instanceof ClassAttribute);
		}
	}
	@Override
	protected String getPropertyNameLabel() {
		return "Initial Value:";
	}
	
	@Override
	protected void setPropertyValue(EObject object, Object value) {
		if (eObject instanceof Association){
			((Association)eObject).setInitialValue((String)value);
		}else if (eObject instanceof ClassAttribute){
			((ClassAttribute)eObject).setInitialValue((String)value);
		}
	}

	@Override
	protected String getPropertyValueString() {
		String ret = null;
		if (((EventBNamedCommentedDataElaborationElement)eObject).getDataKind()!=DataKind.VARIABLE){
			return "";
		}
		if (eObject instanceof Association){
			ret= ((Association)eObject).getInitialValue();
		}else if (eObject instanceof ClassAttribute){
			ret= ((ClassAttribute)eObject).getInitialValue();
		}
		return ret==null? "":ret;
	}

	@Override
	protected String getPropertyChangeCommandName() {
		return "change initialValue";
	}
	
	@Override
	protected boolean isReadOnly() {
		return super.isReadOnly() || 
				(eObject instanceof EventBNamedCommentedDataElaborationElement && 
						((EventBNamedCommentedDataElaborationElement)eObject).getDataKind()!=DataKind.VARIABLE
				) ;
	}
	
	protected boolean isRodinKeyboard(){
		return true;
	}
	
}
