/*******************************************************************************
 * Copyright (c) 2018 University of Southampton and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;
import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.eventb.classdiagrams.ClassConstraint;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.emf.diagrams.sheet.AbstractEnumerationPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

/**
 * property section for selecting container component.
 * 
 * @author cfs
 * @since 2.2
 *
 */
public class ConstraintContainerPropertySection extends AbstractEnumerationPropertySection {
	
	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof ClassConstraint;
		}
	}

	@Override
	protected String[] getEnumerationFeatureValues() {
		List<String> components = new ArrayList<String>();
		for (EventBNamedCommentedComponentElement c : 
			getComponentList((EventBNamedCommentedComponentElement)((EventBElement) eObject).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT))
			){
			components.add(c.getName());
		}
		return components.toArray(new String[components.size()]);
	}

	private List<EventBNamedCommentedComponentElement> getComponentList(EventBNamedCommentedComponentElement component) {
		List<EventBNamedCommentedComponentElement> list =  new ArrayList<EventBNamedCommentedComponentElement>() ;
		if (component instanceof Machine){
			Machine m = ((Machine)component);
			list.add(m);
			for (Context c : m.getSees()){
				list.addAll(getComponentList(c));
			}			
		}else if (component instanceof Context){
			Context c = ((Context)component);
			list.add(c);
			for (Context x : c.getExtends()){
				list.addAll(getComponentList(x));
			}
		}
		return list;
	}
	
	@Override
	protected String getFeatureAsText() {
		return ((ClassConstraint)eObject).getComponent().getName();
	}

//	@Override
//	protected Object getFeatureValue(String selection) {
//		return DataKind.get(selection).getValue();
//	}

	@Override
	protected String getLabelText() {
		return "Component:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS_CONSTRAINT__COMPONENT;
	}
	
//	@Override
//	protected Object getFeatureByValue(Object value) {
//		Integer ftValue = (Integer)value; 
//		return DataKind.get(ftValue);
//	}

	@Override
	protected List<EventBNamedCommentedComponentElement> getAvailableDataElements() {
		return	getComponentList((EventBNamedCommentedComponentElement)((EventBElement) eObject).getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT));
	}

//	@Override
//	protected boolean isReadOnly(){
//		return super.isReadOnly() || ((EventBDataElaboration)eObject).getElaborates() != null;
//	}
}
