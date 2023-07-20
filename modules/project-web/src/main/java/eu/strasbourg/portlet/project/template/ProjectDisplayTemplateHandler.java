package eu.strasbourg.portlet.project.template;

import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_WEB
    },
	service = TemplateHandler.class
)
public class ProjectDisplayTemplateHandler extends BaseDDMTemplateHandler {
	
	@Override
	public String getClassName() {
		return Project.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Projet";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.PROJECT_WEB;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
		long classPK, String language, Locale locale) throws Exception {
		Map<String, TemplateVariableGroup> templateVariableGroups = super.getTemplateVariableGroups(
			classPK, language, locale);
		TemplateVariableGroup fieldsTemplateVariableGroup =
			templateVariableGroups.get("fields");
		fieldsTemplateVariableGroup.empty();
		
		fieldsTemplateVariableGroup.addCollectionVariable(
			"Projets", List.class,
				PortletDisplayTemplateManager.ENTRIES,
			"Projet",
				Project.class,
				"currentProject",
				"getTitle(locale)");
		
		fieldsTemplateVariableGroup.addVariable("Projet", Project.class, "entry");
		fieldsTemplateVariableGroup.addVariable("Featured", Boolean.class, "isFeatured");
		return templateVariableGroups;
	}

	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler ;
	}

	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
					ProjectDisplayTemplateHandler.class.getClassLoader(),
					null,
					null);
}
