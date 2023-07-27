package eu.strasbourg.portlet.edition.template;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;


@Component(
	immediate = true,
	property = {
        "javax.portlet.name=" + StrasbourgPortletKeys.EDITION_WEB
    },
	service = TemplateHandler.class
)
public class EditionDisplayTemplateHandler
	extends BasePortletDisplayTemplateHandler {

	@Override
	public String getClassName() {
		return Edition.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Edition";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.EDITION_WEB;
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
			"Editions", List.class, PortletDisplayTemplateManager.ENTRIES, 
			"Edition", Edition.class, "currentEdition", "getTitle(locale)");
		
		fieldsTemplateVariableGroup.addVariable("Edition", Edition.class, "entry");
		fieldsTemplateVariableGroup.addVariable("Featured", Boolean.class, "isFeatured");
		
		return templateVariableGroups;
	}
}