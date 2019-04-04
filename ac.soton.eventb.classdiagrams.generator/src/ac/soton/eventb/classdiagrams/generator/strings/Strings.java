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
package ac.soton.eventb.classdiagrams.generator.strings;

import java.text.MessageFormat;
import java.util.List;

import org.eclipse.osgi.util.NLS;
import org.eventb.emf.core.EventBNamed;

import ac.soton.eventb.classdiagrams.Association;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassAttribute;
import ac.soton.eventb.classdiagrams.EventBInitialisable;
import ac.soton.eventb.emf.core.extension.coreextension.EventBRelationKind;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

public class Strings {

	private static final String BUNDLE_NAME = "ac.soton.eventb.classdiagrams.generator.strings.Strings"; //$NON-NLS-1$
	private static final String IDENTIFIER_SEPARATOR = "\\W+";

	private Strings() {
		// Do not instantiate
	}
	
	// //////////////////////////////////////////////////////////
	// ADMIN and HELPER methods
	// /////////////////////////////////////////////////////////
	static {
		NLS.initializeMessages(BUNDLE_NAME, Strings.class);
	}

	/**
	 * Bind the given message's substitution locations with the given string
	 * values.
	 * 
	 * @param message
	 *            the message to be manipulated
	 * @param bindings
	 *            An array of objects to be inserted into the message
	 * @return the manipulated String
	 */
	private static String bind(String message, Object... bindings) {
		if (message == null) {
			return "NULL STRING!!!";
		}
		return MessageFormat.format(message, bindings);
	}

	public static String INSTANCES(Class cl){
		return cl.getElaborates() == null? "("+cl.getName()+")" : cl.getName();
	}
	
	public static String CLASS_SUPERTYPE_PRED;
	public static String CLASS_SUPERTYPE_PRED(Class cp, Class sc) {
		return bind(CLASS_SUPERTYPE_PRED, INSTANCES(cp), INSTANCES(sc));
	}

	public static String CLASS_SUPERTYPE_NAME;
	public static String CLASS_SUPERTYPE_NAME(Class cp, Class sc) {
		return bind(CLASS_SUPERTYPE_NAME, cp.getName(), sc.getName());
	}
	
	public static String SUBTYPEGROUP_NAME;
	public static String SUBTYPEGROUP_NAME(String name) {
		return bind(SUBTYPEGROUP_NAME, name);
	}
	
	public static String SUBTYPEGROUP_PARTITION_PRED;
	public static String SUBTYPEGROUP_PARTITION_PRED(String superSetName, List<String>subtypeNames) {
		String subsets = subtypeNames.toString();
		subsets = subsets.substring(1, subsets.length()-1);
		return bind(SUBTYPEGROUP_PARTITION_PRED, superSetName, subsets);
	}

	public static String SUBTYPEGROUP_UNION_PRED;
	public static String SUBTYPEGROUP_UNION_PRED(String superSetName, String expression) {
		return bind(SUBTYPEGROUP_UNION_PRED, superSetName, expression);
	}
	
	public static String ENUMERATION_NAME;
	public static String ENUMERATION_NAME(Class class_) {
		return bind(ENUMERATION_NAME, class_.getName());
	}

	public static String ENUMERATION_PRED;
	public static String ENUMERATION_PRED(Class class_, String instances) {
		return bind(ENUMERATION_PRED, class_.getName(), instances);
	}
	
	public static String ASSOCIATION_PRED;

	public static String ASSOCIATION_PRED(Association element) {
		return bind(ASSOCIATION_PRED, 
				element.getName(), 
				element.getSource().getName(), 
				getRelationType(element), 
				element.getTarget().getName());
	}

	public static String REL_TOTAL_BIJECTION;				
	public static String REL_TOTAL_SURJECTION;									
	public static String REL_TOTAL_INJECTION;
	public static String REL_TOTAL_FUNCTION;
	public static String REL_PARTIAL_SURJECTION;
	public static String REL_PARTIAL_INJECTION;
	public static String REL_PARTIAL_FUNCTION;
	public static String REL_TOTAL_SURJECTIVE_REL;
	public static String REL_TOTAL_RELATION;
	public static String REL_PARTIAL_SURJECTIVE_RELATION;
	public static String REL_PARTIAL_RELATION;
	
	private static String getRelationType(EventBRelationKind element) {
		if (element.isFunctional()){
			if (element.isTotal()) {
				if (element.isSurjective()){
					if (element.isInjective()){
						return REL_TOTAL_BIJECTION;				//total bijection
					}else{
						return REL_TOTAL_SURJECTION;				//total surjection						
					}
				}else{
					if (element.isInjective()){
						return REL_TOTAL_INJECTION;				//total injection
					}else{
						return REL_TOTAL_FUNCTION;				//total function
					}				
				}
			}else{
				if (element.isSurjective()){
					if (element.isInjective()){
						return REL_PARTIAL_SURJECTION;				//partial bijection - but not supported by Rodin so we have to add an extra predicate elsewhere	
					}else{
						return REL_PARTIAL_SURJECTION;				//partial surjection
					}
				}else{
					if (element.isInjective()){
						return REL_PARTIAL_INJECTION;				//partial injection	
					}else{
						return REL_PARTIAL_FUNCTION;				//partial function		
					}					
				}				
			}
		}else{
			if (element.isTotal()) {
				if (element.isSurjective()){
					return REL_TOTAL_SURJECTIVE_REL;			//total surjective relation
				}else{
					return REL_TOTAL_RELATION;				//total relation		
				}					
			}else{
				if (element.isSurjective()){
					return REL_PARTIAL_SURJECTIVE_RELATION;				//partial surjective relation
				}else{
					return REL_PARTIAL_RELATION;				//partial relation		
				}					
			}
		}
	}
	
	public static String ASSOCIATION_INJECTIVE_PRED;
	public static String ASSOCIATION_INJECTIVE_PRED(Association element) {
		return bind(ASSOCIATION_INJECTIVE_PRED, 
				element.getName(), 
				element.getTarget().getName(),
				element.getSource().getName());
	}
	
	public static String ASSOCIATION_PRED_NAME;
	public static String ASSOCIATION_PRED_NAME(String name) {
		return bind(ASSOCIATION_PRED_NAME, name);
	}

	public static String ASSOCIATION_INJECTIVE_PRED_NAME;
	public static String ASSOCIATION_INJECTIVE_PRED_NAME(String name) {
		return bind(ASSOCIATION_INJECTIVE_PRED_NAME, name);
	}
	
	
	//CLASS ATTRIBUTE
	public static String CLASS_ATTRIBUTE_PRED;
	public static String CLASS_ATTRIBUTE_PRED(ClassAttribute element) {
		return bind(CLASS_ATTRIBUTE_PRED, 
				element.getName(), 
				((Class)element.eContainer()).getName(), 
				getRelationType(element), 
				element.getTarget());
	}
	
	public static String CLASS_ATTRIBUTE_INJECTIVE_PRED;
	public static String CLASS_ATTRIBUTE_INJECTIVE_PRED(ClassAttribute element) {
		return bind(CLASS_ATTRIBUTE_INJECTIVE_PRED, 
				element.getName(), 
				element.getTarget(),
				((Class)element.eContainer()).getName());
	}
	
	public static String CLASS_ATTRIBUTE_PRED_NAME;
	public static String CLASS_ATTRIBUTE_PRED_NAME(String name) {
		return bind(CLASS_ATTRIBUTE_PRED_NAME, name);
	}

	public static String CLASS_ATTRIBUTE_INJECTIVE_PRED_NAME;
	public static String CLASS_ATTRIBUTE_INJECTIVE_PRED_NAME(String name) {
		return bind(CLASS_ATTRIBUTE_INJECTIVE_PRED_NAME, name);
	}
	
	public static String CLASS_CONSTRAINT_NAME;
	public static String CLASS_CONSTRAINT_NAME(String name) {
		return bind(CLASS_CONSTRAINT_NAME, name);
	}
	
	public static String CLASS_CONSTRAINT_PRED;
	public static String CLASS_CONSTRAINT_PRED(String selfName, String instances, String predicate) {
		String[] tokens = predicate.split(IDENTIFIER_SEPARATOR);
		for (String tok : tokens) {
			if (tok.equals(selfName) ) {
				return bind(CLASS_CONSTRAINT_PRED, selfName, instances, predicate);
			}
		}
		return predicate;

	}
	
	public static String CLASS_PARAMETER_NAME;
	public static String CLASS_PARAMETER_NAME(String name) {
		return bind(CLASS_PARAMETER_NAME, name);
	}
	
	////guard for selecting an instance parameter
	
	public static String CLASS_PARAMETER_GUARD_NAME;
	public static String CLASS_PARAMETER_GUARD_NAME(String name) {
		return bind(CLASS_PARAMETER_GUARD_NAME, name);
	}
	
	public static String CLASS_PARAMETER_CONSTRUCTOR_GUARD_PRED;
	public static String CLASS_PARAMETER_CONSTRUCTOR_GUARD_PRED(String selfName, String instances) {
		return bind(CLASS_PARAMETER_CONSTRUCTOR_GUARD_PRED, 
				selfName,
				instances);
	}
	
	public static String CLASS_PARAMETER_GUARD_PRED;
	public static String CLASS_PARAMETER_GUARD_PRED(String selfName, String instances) {
		return bind(CLASS_PARAMETER_GUARD_PRED, 
				selfName,
				instances);
	}
	
	///action for constructing/destructing instances
	
	public static String CLASS_PARAMETER_ACTION_NAME;
	public static String CLASS_PARAMETER_ACTION_NAME(String name) {
		return bind(CLASS_PARAMETER_ACTION_NAME, name);
	}
	
	public static String CLASS_PARAMETER_CONSTRUCTOR_ACTION_EXPR;
	public static String CLASS_PARAMETER_CONSTRUCTOR_ACTION_EXPR(String selfName, String instances) {
		return bind(CLASS_PARAMETER_CONSTRUCTOR_ACTION_EXPR, 
				selfName,
				instances);
	}
	
	public static String CLASS_PARAMETER_DESTRUCTOR_ACTION_EXPR;
	public static String CLASS_PARAMETER_DESTRUCTOR_ACTION_EXPR(String selfName, String instances) {
		return bind(CLASS_PARAMETER_DESTRUCTOR_ACTION_EXPR, 
				selfName,
				instances);
	}
	
	///// extra user parameters in methods
	
	public static String USER_PARAMETER_TYPE_GUARD_NAME;
	public static String USER_PARAMETER_TYPE_GUARD_NAME(TypedParameter p) {
		return bind(USER_PARAMETER_TYPE_GUARD_NAME, p.getName());
	}
	
	public static String USER_PARAMETER_TYPE_GUARD_PRED;
	public static String USER_PARAMETER_TYPE_GUARD_PRED(TypedParameter p) {
		return bind(USER_PARAMETER_TYPE_GUARD_PRED, 
				p.getName(), 
				p.getType());
	}
	
	/// intialisation to initialValue of associations/attributes
	/// ....in fixed classes
	public static String INITIALISATION_NAME;
	public static String INITIALISATION_NAME(EventBNamed e) {
		return bind(INITIALISATION_NAME, e.getName());
	}

	public static String ATTR_VALUE_INITIALISATION_ACTION_EXPR_1;
	public static String ATTR_VALUE_INITIALISATION_ACTION_EXPR_2;
	public static String ATTR_VALUE_INITIALISATION_ACTION_EXPR(EventBNamed e) {
		String v = ((EventBInitialisable)e).getInitialValue();
		return v.startsWith("\u2254") || v.startsWith("\u003A\u2208") || v.startsWith("\u003A\u2223") ?
				bind(ATTR_VALUE_INITIALISATION_ACTION_EXPR_1, e.getName(),  v)			
				:
				bind(ATTR_VALUE_INITIALISATION_ACTION_EXPR_2, e.getName(), ((EventBNamed) e.eContainer()).getName(),  v);
	}
	//initialisation to empty set of associations/attributes etc.
	//... in variable classes
	public static String EMPTY_INITIALISATION_ACTION_EXPR;
	public static String EMPTY_INITIALISATION_ACTION_EXPR(EventBNamed e) {
		return bind(EMPTY_INITIALISATION_ACTION_EXPR, e.getName());
	}
	
	/// ....in constructors of variable classes	
	public static String ATTRIBUTE_INITIALISATION_ACTION_NAME;
	public static String ATTRIBUTE_INITIALISATION_ACTION_NAME(String name) {
		return bind(ATTRIBUTE_INITIALISATION_ACTION_NAME, name);
	}

	public static String ATTRIBUTE_INITIALISATION_ACTION_EXPR;
	public static String ATTRIBUTE_INITIALISATION_ACTION_EXPR(String name, String selfName, String intialValue) {
		return bind(ATTRIBUTE_INITIALISATION_ACTION_EXPR, 
				name, 
				selfName, 
				intialValue);
	}
	public static String ATTRIBUTE_DESTRUCTION_ACTION_NAME;
	public static String ATTRIBUTE_DESTRUCTION_ACTION_NAME(String name) {
		return bind(ATTRIBUTE_DESTRUCTION_ACTION_NAME, name);
	}

	public static String ATTRIBUTE_DESTRUCTION_ACTION_EXPR;
	public static String ATTRIBUTE_DESTRUCTION_ACTION_EXPR(String name, String selfName) {
		return bind(ATTRIBUTE_DESTRUCTION_ACTION_EXPR, 
				name, 
				selfName);
	}
}
