package eu.strasbourg.portlet.page_header.template;

import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutSet;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.Locale;
import java.util.Map;


@Component(
	immediate = true,
	property = {
        "javax.portlet.name=" + StrasbourgPortletKeys.PAGE_HEADER_WEB
    },
	service = TemplateHandler.class
)
public class PageHeaderPortletDisplayTemplateHandler
	extends BaseDDMTemplateHandler {

	@Override
	public String getClassName() {
		return LayoutSet.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Entete de page";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.RUBRIC_WEB;
	}

	@Override
	public Map<String, TemplateVariableGroup> getTemplateVariableGroups(
		long classPK, String language, Locale locale) throws Exception {
		Map<String, TemplateVariableGroup> templateVariableGroups = super.getTemplateVariableGroups(
			classPK, language, locale);
		
		
		TemplateVariableGroup fieldsTemplateVariableGroup =
			templateVariableGroups.get("fields");
		fieldsTemplateVariableGroup.empty();
		
		fieldsTemplateVariableGroup.addVariable("page", Layout.class, "page");
		fieldsTemplateVariableGroup.addVariable("image-credit", String.class, "imageCredit");
		
		return templateVariableGroups;
	}

	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler ;
	}

	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
					PageHeaderPortletDisplayTemplateHandler.class.getClassLoader(),
					null,
					null);
}