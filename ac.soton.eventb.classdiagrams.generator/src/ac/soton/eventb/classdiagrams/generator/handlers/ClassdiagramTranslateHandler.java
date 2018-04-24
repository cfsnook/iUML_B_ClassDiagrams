/*******************************************************************************
 * Copyright (c) 2018 University of Southampton.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package ac.soton.eventb.classdiagrams.generator.handlers;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.command.CompoundCommand;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.edit.command.SetCommand;
import org.eventb.emf.core.EventBElement;
import org.eventb.emf.core.EventBNamedCommentedComponentElement;

import ac.soton.emf.translator.TranslatorFactory;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.generator.Activator;
import ac.soton.eventb.emf.diagrams.generator.DiagramsGeneratorIdentifiers;
import ac.soton.eventb.emf.diagrams.generator.handlers.IUMLBTranslateHandler;
import ac.soton.eventb.statemachines.Statemachine;
import ac.soton.eventb.statemachines.StatemachinesPackage;


/**
 * <p>
 * 
 * </p>
 * 
 * @author cfs
 * @version
 * @see
 * @since 4.0
 */
public class ClassdiagramTranslateHandler extends IUMLBTranslateHandler {	
		
	/**
	 * For class diagrams we return the root translatable element irrespective of
	 * type. This is because the diagram can contain statemachines. 
	 * I.e. We run the classdiagram translation on the root component even if a statemachine
	 * is selected in the diagram.
	 * 
	 * @see ac.soton.eventb.emf.diagrams.generator.handlers.IUMLBTranslateHandler#getEObject(java.lang.Object)
	 **/
	@Override
	protected EObject getEObject (Object obj){
		EObject eObject = super.getEObject(obj);
		
		while (eObject.eContainer() instanceof EventBElement && 
				!(eObject.eContainer() instanceof EventBNamedCommentedComponentElement)){
			eObject = eObject.eContainer();
		}
		
		return eObject;
	}
	
	/**
	 * The pre-processing ensures that any ste-machines owned by classes have their instances and self-name set to 
	 * match that of the class. This ensures that when they are translated they are lifted to the class instances.
	 * 
	 * @see ac.soton.emf.translator.handler.TranslateHandler#preProcessing(org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 **/
	@Override
	protected IStatus  preProcessing(EObject sourceElement, String commandId, IProgressMonitor monitor) throws Exception {
		IStatus status = Status.OK_STATUS;
		if (sourceElement instanceof EventBElement){
			EList<EObject> statemachines = ((EventBElement)sourceElement).getAllContained(StatemachinesPackage.Literals.STATEMACHINE, true);
			for (EObject statemachine : statemachines){
				if (statemachine==null) continue;	//ignore initial null;
				if (statemachine.eContainer() instanceof Class){
					Class parentClass = (Class) statemachine.eContainer();
					CompoundCommand command = new CompoundCommand();
					command.append(SetCommand.create(getEditingDomain(), (Statemachine)statemachine, StatemachinesPackage.Literals.STATEMACHINE__INSTANCES, parentClass.getElaborates()));
					command.append(SetCommand.create(getEditingDomain(), (Statemachine)statemachine, StatemachinesPackage.Literals.STATEMACHINE__SELF_NAME, parentClass.getSelfName()));
					if (command.canExecute()) {
						getEditingDomain().getCommandStack().execute(command);
					}else {
						status = new Status(Status.ERROR, Activator.PLUGIN_ID, "unable to execute pre-processing");
					}
					command.dispose();
				}
			}
		} else {
			status = new Status(Status.ERROR, Activator.PLUGIN_ID, "pre-processing: source element is not an EventB element");
		}
		monitor.done();
        return status;
	}

	
	/**
	 * The post-processing translates the statemachines that are contained in the class diagram.
	 * 
	 * @see ac.soton.emf.translator.handler.TranslateHandler#postProcessing(org.eclipse.emf.ecore.EObject, java.lang.String, org.eclipse.core.runtime.IProgressMonitor)
	 **/
	@Override
	protected IStatus postProcessing(EObject sourceElement, String commandId, IProgressMonitor monitor) throws Exception {
		MultiStatus status = new MultiStatus(Activator.PLUGIN_ID, 0, "Post processing for class diagram translation", null); 
		
		status.merge(super.postProcessing(sourceElement, commandId, monitor));
		TranslatorFactory factory = TranslatorFactory.getFactory();
		if (sourceElement instanceof EventBElement){
			EList<EObject> statemachines = ((EventBElement)sourceElement).getAllContained(StatemachinesPackage.Literals.STATEMACHINE, true);
			for (EObject sm : statemachines){
				if (sm==null) continue;	//ignore initial null;
				String smname = ((Statemachine)sm).getName();				
				if (sm.eContainer() instanceof Class
						&& factory.canTranslate(DiagramsGeneratorIdentifiers.COMMAND_ID, sm.eClass())){
					SubMonitor submonitor = SubMonitor.convert(monitor, "Translating Statemachine "+smname, 2);
					status.merge(
							factory.translate(getEditingDomain(), sm, DiagramsGeneratorIdentifiers.COMMAND_ID, submonitor.newChild(2))
							);
					submonitor.worked(2);
				}
			}
		}
		return status;
	}
	


}
