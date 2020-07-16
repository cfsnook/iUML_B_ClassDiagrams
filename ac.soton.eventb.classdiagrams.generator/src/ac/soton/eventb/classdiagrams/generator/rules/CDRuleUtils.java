/*******************************************************************************
 *  Copyright (c) 2011-2019 University of Southampton.
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *   
 *  Contributors:
 *  University of Southampton - Initial implementation
 *******************************************************************************/
package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eventb.emf.core.CorePackage;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;
import org.eventb.emf.core.context.Context;
import org.eventb.emf.core.machine.Machine;

import ac.soton.emf.translator.eventb.utils.Utils;

/**
 * Some utility methods to help with the Class Diagram Rules
 * 
 * 
 */

public class CDRuleUtils {
	
	/**
	 * 
	 *  starting from the translation target, finds the best container component for something that refers to the given set of elements
	 *  if no sub-component has all elements in scope, returns the translation target itself.
	 *  
	 * @param elements (that are expected to be in scope of the translation target)
	 * @return
	 */
	public static EventBNamedCommentedComponentElement getTargetContainer(List<EventBElement> elements) {
		List<EventBNamedCommentedComponentElement> components = new ArrayList<EventBNamedCommentedComponentElement>();
		for (EventBElement element : elements) {
			components.add((EventBNamedCommentedComponentElement) element.getContaining(CorePackage.Literals.EVENT_BNAMED_COMMENTED_COMPONENT_ELEMENT));
		}
		EventBNamedCommentedComponentElement target = findTopContainer(components, Utils.getTranslationTarget());
		return target!=null ? target : Utils.getTranslationTarget();
	}

	/**
	 * search the in-scope components from 'root' to find one that is in the given list of containers
	 * 
	 * @param components
	 * @param root
	 * @return
	 */
	private static EventBNamedCommentedComponentElement findTopContainer(List<EventBNamedCommentedComponentElement> components, EventBNamedCommentedComponentElement root) {
		
		if  (components.contains(root)) {
			//check all others are in scope
			for (EventBNamedCommentedComponentElement c:components ) {
				if (!inScope(c,root)) return null;
			}
			return root;
		}
		
		EventBNamedCommentedComponentElement found;
		if (root instanceof Machine) {
			for (Context ctx : ((Machine)root).getSees()) {
				found  = findTopContainer(components, ctx);
				if (found!=null) return found;
			}
		}
		
		if (root instanceof Context) {
			for (Context ctx : ((Context)root).getExtends()) {
				found = findTopContainer(components, ctx);
				if (found!=null) return found;
			}
		}
		
		return null;
	}

	/**
	 * check whether the given component, c, is in-scope from the given root component
	 * 
	 * @param c
	 * @param candidate
	 * @return
	 */
	private static boolean inScope(EventBNamedCommentedComponentElement c, EventBNamedCommentedComponentElement root) {
		if (c==root) return true;

		if (root instanceof Machine) {
			for (Context ctx : ((Machine)root).getSees()) {
				if (inScope(c, ctx)) return true;
			}
		}

		if (root instanceof Context) {
			for (Context ctx : ((Context)root).getExtends()) {
				if (inScope(c, ctx)) return true;
			}
		}
		
		return false;
	}
	

	
}
