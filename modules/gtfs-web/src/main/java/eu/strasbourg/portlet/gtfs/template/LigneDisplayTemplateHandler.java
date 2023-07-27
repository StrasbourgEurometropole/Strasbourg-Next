package eu.strasbourg.portlet.gtfs.template;

import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + StrasbourgPortletKeys.GTFS_WEB
    },
	service = TemplateHandler.class
)
public class LigneDisplayTemplateHandler extends BaseDDMTemplateHandler {

	@Override
	public String getClassName() {
		return Ligne.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Ligne";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.GTFS_WEB;
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
			"Lignes", List.class,
				PortletDisplayTemplateManager.ENTRIES,
			"Ligne",
			Ligne.class,
				"currentLigne",
				"getTitle(locale)");
		
		fieldsTemplateVariableGroup.addVariable("Ligne", Ligne.class, "entry");
		fieldsTemplateVariableGroup.addVariable("Featured", Boolean.class, "isFeatured");
		return templateVariableGroups;
	}

	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler ;
	}

	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
					LigneDisplayTemplateHandler.class.getClassLoader(),
					null,
					null);

}
