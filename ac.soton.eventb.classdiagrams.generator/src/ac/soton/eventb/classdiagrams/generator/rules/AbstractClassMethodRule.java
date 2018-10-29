package ac.soton.eventb.classdiagrams.generator.rules;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eventb.emf.core.machine.Action;
import org.eventb.emf.core.machine.Event;
import org.eventb.emf.core.machine.Guard;
import org.eventb.emf.core.machine.Witness;

import ac.soton.emf.translator.TranslationDescriptor;
import ac.soton.emf.translator.configuration.IRule;
import ac.soton.emf.translator.eventb.rules.AbstractEventBGeneratorRule;
import ac.soton.emf.translator.eventb.utils.Make;
import ac.soton.eventb.classdiagrams.Class;
import ac.soton.eventb.classdiagrams.ClassMethod;
import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.generator.strings.Strings;
import ac.soton.eventb.emf.core.extension.coreextension.CoreextensionPackage;
import ac.soton.eventb.emf.core.extension.coreextension.TypedParameter;

public abstract class AbstractClassMethodRule extends AbstractEventBGeneratorRule  implements IRule {
	
	protected static final EReference elaborates = CoreextensionPackage.Literals.EVENT_BDATA_ELABORATION__ELABORATES;
	
	protected String selfName;
	protected String instancesName;
	
	protected abstract String getInstanceParameterGuardPredicate(ClassMethod method);
	protected abstract String getInstanceParameterActionExpression(ClassMethod method);
	protected abstract List<Object> getInstanceActions(ClassMethod method);
	
	@Override
	public boolean enabled(EObject sourceElement) throws Exception{
		assert(sourceElement instanceof ClassMethod);
		if (!(((ClassMethod)sourceElement).eContainer() instanceof Class)) return false;
		return ((Class)((ClassMethod)sourceElement).eContainer()).getElaborates() != null;
	}
	
	@Override
	public List<TranslationDescriptor> fire(EObject sourceElement, List<TranslationDescriptor> generatedElements) throws Exception {
		List<TranslationDescriptor> ret = new ArrayList<TranslationDescriptor>();
		ClassMethod method = (ClassMethod)sourceElement;	
		selfName = ((Class)method.eContainer()).getSelfName();
		instancesName = ((Class) method.getContaining(ClassdiagramsPackage.Literals.CLASS)).getElaborates().getName();
		//make the descriptors
		for (Event elaboratedEvent :  method.getElaborates()){
			if (!"INITIALISATION".equals(elaboratedEvent.getName())){
				ret.add(Make.descriptor(elaboratedEvent, parameters, Make.parameter(Strings.CLASS_PARAMETER_NAME(selfName), "generated class instance"), 1));
				ret.add(Make.descriptor(elaboratedEvent, guards, Make.guard(Strings.CLASS_PARAMETER_GUARD_NAME(selfName), getInstanceParameterGuardPredicate(method)), 1));
				String actionExpression;
				if ((actionExpression = getInstanceParameterActionExpression(method))!=null){
					ret.add(Make.descriptor(elaboratedEvent, actions, Make.action(Strings.CLASS_PARAMETER_ACTION_NAME(selfName), actionExpression), 1));
				}
				for (Object action : getInstanceActions(method)){
					ret.add(Make.descriptor(elaboratedEvent, actions, action, 5));
				}
				
				//generate users parameters 
				for (TypedParameter p : method.getExtendedParameters()){
					//parameter
					ret.add(Make.descriptor(elaboratedEvent,parameters,Make.parameter(p.getName(),p.getComment()),10));
					//guard for type of parameter
					ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(Strings.USER_PARAMETER_TYPE_GUARD_NAME(p), Strings.USER_PARAMETER_TYPE_GUARD_PRED(p)),2));
				}
				for (TypedParameter p : method.getParameters()){
					//parameter
					ret.add(Make.descriptor(elaboratedEvent,parameters,Make.parameter(p.getName(),p.getComment()),10));
					//guard for type of parameter
					ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(Strings.USER_PARAMETER_TYPE_GUARD_NAME(p), Strings.USER_PARAMETER_TYPE_GUARD_PRED(p)),2));
				}
				
				//generate users witnesses 
				for (Witness w : method.getWitnesses()){
					ret.add(Make.descriptor(elaboratedEvent,witnesses,Make.witness(w.getName(), w.getPredicate(), w.getComment()),10));				
				}
				
				//generate users guards 
				for (Guard g : method.getExtendedGuards()){
					ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(g.getName(), g.isTheorem(), g.getPredicate(), g.getComment()),10));				
				}
				for (Guard g : method.getGuards()){
					ret.add(Make.descriptor(elaboratedEvent,guards,Make.guard(g.getName(), g.isTheorem(), g.getPredicate(), g.getComment()),10));				
				}
				
			}		
			//generate users actions
			for (Action g : method.getExtendedActions()){
				ret.add(Make.descriptor(elaboratedEvent,guards,Make.action(g.getName(), g.getAction(), g.getComment()),10));				
			}
			for (Action a : method.getActions()){
				ret.add(Make.descriptor(elaboratedEvent,actions,Make.action(a.getName(), a.getAction(), a.getComment()),10));				
			}

		}
		return ret;
	}
	
}
