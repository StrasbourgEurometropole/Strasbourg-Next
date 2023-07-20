package eu.strasbourg.portlet.activity.template;

import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.activity.model.Practice;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(immediate = true, property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_WEB }, service = TemplateHandler.class)
public class PracticeDisplayTemplateHandler extends BaseDDMTemplateHandler {

	@Override
	public String getClassName() {
		return Practice.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Domaine de pratique";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.ACTIVITY_WEB;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(long classPK, String language, Locale locale)
			throws Exception {
		Map<String, TemplateVariableGroup> templateVariableGroups = super.getTemplateVariableGroups(classPK, language,
				locale);

		TemplateVariableGroup fieldsTemplateVariableGroup = templateVariableGroups.get("fields");
		fieldsTemplateVariableGroup.empty();

		fieldsTemplateVariableGroup.addCollectionVariable("Activities", List.class,
				PortletDisplayTemplateManager.ENTRIES, "Practice", Practice.class,
				"currentPractice", "getTitle(locale)");

		fieldsTemplateVariableGroup.addVariable("Practice", Practice.class, "entry");

		return templateVariableGroups;
	}

	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler ;
	}

	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
					PracticeDisplayTemplateHandler.class.getClassLoader(),
					null,
					null);
}