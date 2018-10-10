package ac.soton.eventb.classdiagrams.diagram.sheet.custom;

import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jface.viewers.IFilter;

import ac.soton.eventb.classdiagrams.ClassdiagramsPackage;
import ac.soton.eventb.classdiagrams.SubtypeGroup;
import ac.soton.eventb.emf.diagrams.sheet.AbstractBooleanEnumerationPropertySection;
import ac.soton.eventb.emf.diagrams.util.custom.DiagramUtils;

public class CoverSection extends AbstractBooleanEnumerationPropertySection {

	/**
	 * Element Filter for this property section.
	 */
	public static final class Filter implements IFilter {
		@Override
		public boolean select(Object toTest) {
			return DiagramUtils.unwrap(toTest) instanceof SubtypeGroup;
		}
	}

	@Override
	protected String getFeatureAsText() {
		return Boolean.toString(((SubtypeGroup)(eObject)).isCover());
	}

	@Override
	protected String getLabelText() {
		return "Cover:";
	}

	@Override
	protected EStructuralFeature getFeature() {
		return ClassdiagramsPackage.Literals.SUBTYPE_GROUP__COVER;
	}

}
