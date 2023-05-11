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

import static eu.strasbourg.portlet.agenda.constants.agendaConstants.*;

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
                .orElse(EVENTS[0]);
        this.selectedMvcPath = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_MVCPATH))
                .filter(Validator::isNotNull)
                .orElse(EVENTS_PATH);
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
        events.setActive(this.selectedTab.equals(EVENTS));
        events.setHref(this.response.createRenderURL(), URL_PARAM_TAB, EVENTS, URL_PARAM_MVCPATH, EVENTS_PATH);
        navigationItems.add(events);

        NavigationItem manifs = new NavigationItem();
        manifs.setLabel(LanguageUtil.get(bundle, "manifestations"));
        manifs.setActive(this.selectedTab.equals(MANIFS));
        manifs.setHref(this.response.createRenderURL(), URL_PARAM_TAB, MANIFS, URL_PARAM_MVCPATH, MANIFS_PATH);
        navigationItems.add(manifs);

        NavigationItem importation = new NavigationItem();
        importation.setLabel(LanguageUtil.get(bundle, "import"));
        importation.setActive(this.selectedTab.equals(IMPORT));
        importation.setHref(this.response.createRenderURL(), URL_PARAM_TAB, IMPORT, URL_PARAM_MVCPATH, IMPORT_PATH);
        navigationItems.add(importation);

        NavigationItem campaign = new NavigationItem();
        campaign.setLabel(LanguageUtil.get(bundle, "campaigns"));
        campaign.setActive(this.selectedTab.equals(CAMPAIGNS));
        campaign.setHref(this.response.createRenderURL(), URL_PARAM_TAB, CAMPAIGNS, URL_PARAM_MVCPATH, CAMPAIGNS_PATH);
        navigationItems.add(campaign);

        return navigationItems;
    }
}