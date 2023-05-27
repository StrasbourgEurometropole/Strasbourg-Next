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
        // onglet par défaut -> EVENTS
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

        NavigationItem events = new NavigationItem();
        events.setLabel(LanguageUtil.get(bundle, "activities"));
        events.setActive(this.selectedTab.equals(ACTIVITIES));
        events.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ACTIVITIES, URL_PARAM_MVCPATH, ACTIVITIES_PATH);
        navigationItems.add(events);

        NavigationItem manifs = new NavigationItem();
        manifs.setLabel(LanguageUtil.get(bundle, "activity-courses"));
        manifs.setActive(this.selectedTab.equals(COURSES));
        manifs.setHref(this.response.createRenderURL(), URL_PARAM_TAB, COURSES, URL_PARAM_MVCPATH, COURSES_PATH);
        navigationItems.add(manifs);

        NavigationItem importation = new NavigationItem();
        importation.setLabel(LanguageUtil.get(bundle, "activity-organizers"));
        importation.setActive(this.selectedTab.equals(ORGANIZERS));
        importation.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ORGANIZERS, URL_PARAM_MVCPATH, ORGANIZERS_PATH);
        navigationItems.add(importation);

        NavigationItem campaign = new NavigationItem();
        campaign.setLabel(LanguageUtil.get(bundle, "associations"));
        campaign.setActive(this.selectedTab.equals(ASSOCIATIONS));
        campaign.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ASSOCIATIONS, URL_PARAM_MVCPATH, ASSOCIATIONS_PATH);
        navigationItems.add(campaign);

        return navigationItems;
    }
}