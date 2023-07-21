package eu.strasbourg.portlet.project.template;

import com.liferay.portal.kernel.portletdisplaytemplate.BasePortletDisplayTemplateHandler;
import com.liferay.portal.kernel.portletdisplaytemplate.PortletDisplayTemplateManager;
import com.liferay.portal.kernel.template.TemplateHandler;
import com.liferay.portal.kernel.template.TemplateVariableGroup;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * @author Joshua Chacha
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_WEB
        },
        service = TemplateHandler.class
)
public class SaisineObservatoireDisplayTemplateHandler extends BasePortletDisplayTemplateHandler {
    @Override
    public String getClassName() {
        return SaisineObservatoire.class.getName();
    }

    @Override
    public String getName(Locale locale) {
        return "Template Saisine observatoire";
    }

    @Override
    public String getResourceName() {
        return StrasbourgPortletKeys.PROJECT_WEB;
    }

    @Override
    public Map<String, TemplateVariableGroup> getTemplateVariableGroups(long classPK, String language, Locale locale) throws Exception {
        Map<String, TemplateVariableGroup> templateVariableGroups =
                super.getTemplateVariableGroups(
                        classPK, language, locale);
        TemplateVariableGroup fieldsTemplateVariableGroup =
                templateVariableGroups.get("fields");
        fieldsTemplateVariableGroup.empty();

        fieldsTemplateVariableGroup.addCollectionVariable(
                "SaisinesObservatoire", List.class,
                PortletDisplayTemplateManager.ENTRIES,
                "SaisineObservatoire", SaisineObservatoire.class,
                "currentSaisineObservatoire",
                "getTitle(locale)");
        fieldsTemplateVariableGroup.addVariable("SaisineObservatoire", SaisineObservatoire.class, "entry");
        fieldsTemplateVariableGroup.addVariable("Featured", Boolean.class, "isFeatured");
        return templateVariableGroups;
    }
}
