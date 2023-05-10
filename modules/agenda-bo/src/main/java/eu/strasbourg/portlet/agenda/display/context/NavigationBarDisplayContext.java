package eu.strasbourg.portlet.agenda.display.context;

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

public class NavigationBarDisplayContext {
    public static final String[] EVENTS = {"events", "/agenda-bo-view-events.jsp"};
    public static final String[] MANIFS = {"manifestations", "/agenda-bo-view-manifestations.jsp"};
    public static final String[] IMPORT = {"import", "/agenda-bo-view-import.jsp"};
    public static final String[] CAMPAIGNS = {"campaigns", "/agenda-bo-view-campaigns.jsp"};
    public static final String URL_PARAM_TAB = "tab";
    public static final String URL_PARAM_MVCPATH = "mvcPath";
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        // onglet par défaut -> EVENTS
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(EVENTS[0]);
        this.selectedMvcPath = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_MVCPATH))
                .filter(Validator::isNotNull)
                .orElse(EVENTS[1]);
    }

    public String getSelectedTab() {
        return selectedTab;
    }

    public String getSelectedMvcPath() {
        return selectedMvcPath;
    }

    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItems = new ArrayList<>();

        NavigationItem events = new NavigationItem();
        events.setLabel(LanguageUtil.get(bundle, "events"));
        events.setActive(this.selectedTab.equals(EVENTS[0]));
        events.setHref(this.response.createRenderURL(), URL_PARAM_TAB, EVENTS[0], URL_PARAM_MVCPATH, EVENTS[1]);
        navigationItems.add(events);

        NavigationItem manifs = new NavigationItem();
        manifs.setLabel(LanguageUtil.get(bundle, "manifestations"));
        manifs.setActive(this.selectedTab.equals(MANIFS[0]));
        manifs.setHref(this.response.createRenderURL(), URL_PARAM_TAB, MANIFS[0], URL_PARAM_MVCPATH, MANIFS[1]);
        navigationItems.add(manifs);

        NavigationItem importation = new NavigationItem();
        importation.setLabel(LanguageUtil.get(bundle, "import"));
        importation.setActive(this.selectedTab.equals(IMPORT[0]));
        importation.setHref(this.response.createRenderURL(), URL_PARAM_TAB, IMPORT[0], URL_PARAM_MVCPATH, IMPORT[1]);
        navigationItems.add(importation);

        NavigationItem campaign = new NavigationItem();
        campaign.setLabel(LanguageUtil.get(bundle, "campaigns"));
        campaign.setActive(this.selectedTab.equals(CAMPAIGNS[0]));
        campaign.setHref(this.response.createRenderURL(), URL_PARAM_TAB, CAMPAIGNS[0], URL_PARAM_MVCPATH, CAMPAIGNS[1]);
        navigationItems.add(campaign);

        return navigationItems;
    }
}