package eu.strasbourg.portlet.activity.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import static eu.strasbourg.portlet.activity.constants.ActivityConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(ACTIVITIES);
        this.selectedCmd = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_CMD))
                .filter(Validator::isNotNull)
                .orElse("");
        this.selectedMvcPath = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_MVCPATH))
                .filter(Validator::isNotNull)
                .orElse("");
    }

    public String getSelectedTab() {
        return selectedTab;
    }
    @SuppressWarnings("unused")
    public String getSelectedCmd() {
        return selectedCmd;
    }
    @SuppressWarnings("unused")
    public String getSelectedMvcPath() {
        return selectedMvcPath;
    }

    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItems = new ArrayList<>();

        NavigationItem activities = new NavigationItem();
        activities.setLabel(LanguageUtil.get(bundle, "activities"));
        activities.setActive(this.selectedTab.equals(ACTIVITIES));
        activities.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ACTIVITIES, URL_PARAM_MVCPATH, ACTIVITIES_PATH);
        navigationItems.add(activities);

        NavigationItem courses = new NavigationItem();
        courses.setLabel(LanguageUtil.get(bundle, "activity-courses"));
        courses.setActive(this.selectedTab.equals(COURSES));
        courses.setHref(this.response.createRenderURL(), URL_PARAM_TAB, COURSES, URL_PARAM_MVCPATH, COURSES_PATH);
        navigationItems.add(courses);

        NavigationItem organizers = new NavigationItem();
        organizers.setLabel(LanguageUtil.get(bundle, "activity-organizers"));
        organizers.setActive(this.selectedTab.equals(ORGANIZERS));
        organizers.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ORGANIZERS, URL_PARAM_MVCPATH, ORGANIZERS_PATH);
        navigationItems.add(organizers);

        NavigationItem associations = new NavigationItem();
        associations.setLabel(LanguageUtil.get(bundle, "associations"));
        associations.setActive(this.selectedTab.equals(ASSOCIATIONS));
        associations.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ASSOCIATIONS, URL_PARAM_MVCPATH, ASSOCIATIONS_PATH);
        navigationItems.add(associations);

        return navigationItems;
    }
}