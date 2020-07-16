/*******************************************************************************
 * Copyright (c) 2018-2019 University of Southampton and others.
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
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

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
		for (EventBNamedCommentedComponentElement c : getComponentsInScope() ) {
			components.add(c.getName());
		}
		return components.toArray(new String[components.size()]);
	}
	
	@Override
	protected String getFeatureAsText() {
		EventBNamedCommentedComponentElement cp = ((ClassConstraint)eObject).getComponent();
		return cp==null? "<not set>" : cp.getName();
	}

	@Override
	protected String getLabelText() {
		return "Component:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.CLASS_CONSTRAINT__COMPONENT;
	}

	@Override
	protected List<EventBNamedCommentedComponentElement> getAvailableDataElements() {
		return	getComponentsInScope();
	}

}
