package eu.strasbourg.portlet.activity.template;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.dynamic.data.mapping.template.BaseDDMTemplateHandler;
import com.liferay.dynamic.data.mapping.template.DDMTemplateVariableCodeHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableCodeHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;


@Component(
	immediate = true,
	property = {
        "javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_WEB
    },
	service = TemplateHandler.class
)
public class ActivityDisplayTemplateHandler
	extends BaseDDMTemplateHandler {

	@Override
	public String getClassName() {
		return Activity.class.getName();
	}

	@Override
	public String getName(Locale locale) {
		return "Template Activite";
	}

	@Override
	public String getResourceName() {
		return StrasbourgPortletKeys.ACTIVITY_WEB;
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
			"Activities", List.class, PortletDisplayTemplateManager.ENTRIES, 
			"Activity", Activity.class, "currentActivity", "getTitle(locale)");
		
		
		fieldsTemplateVariableGroup.addVariable("Activity", Activity.class, "entry");
		fieldsTemplateVariableGroup.addCollectionVariable(
			"Courses", List.class, "courses", 
			"Course", ActivityCourse.class, "currentCourse", "getName(locale)");

		fieldsTemplateVariableGroup.addCollectionVariable(
			"Periods", List.class, "periods", 
			"Period", AssetCategory.class, "currentPeriod", "getTitle(locale)");
		
		fieldsTemplateVariableGroup.addVariable("Page de detail", String.class, "detailPageFriendlyURL");
		
		fieldsTemplateVariableGroup.addVariable("Featured", Boolean.class, "isFeatured");
		
		return templateVariableGroups;
	}

	@Override
	protected TemplateVariableCodeHandler getTemplateVariableCodeHandler() {
		return _templateVariableCodeHandler ;
	}

	private final TemplateVariableCodeHandler _templateVariableCodeHandler =
			new DDMTemplateVariableCodeHandler(
					ActivityDisplayTemplateHandler.class.getClassLoader(),
					null,
					null);
}