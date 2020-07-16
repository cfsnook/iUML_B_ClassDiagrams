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

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.EObject;

import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.MethodKind;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.emf.translator.configuration.IRule;

public class ClassMethodRule extends AbstractClassMethodRule  implements IRule {

	@Override
	public boolean enabled(EObject sourceElement) throws Exception{
		assert(sourceElement instanceof ClassMethod);
		return super.enabled(sourceElement) &&
				((ClassMethod)sourceElement).getKind()==MethodKind.NORMAL;
	}

	@Override
	protected String getInstanceParameterGuardPredicate(ClassMethod method) {
		Class parentClass = (Class) method.getContaining(ClassdiagramsPackage.Literals.CLASS);
		return Strings.CLASS_PARAMETER_GUARD_PRED(parentClass.getSelfName(), parentClass.getElaborates().getName());
	}
	
	@Override
	protected String getInstanceParameterActionExpression(ClassMethod method) {
		return null;
	}

	@Override
	protected List<Object> getInstanceActions(ClassMethod method) {
		return Collections.emptyList();
	}



}
