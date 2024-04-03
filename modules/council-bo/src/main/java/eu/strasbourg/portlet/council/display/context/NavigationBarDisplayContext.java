package eu.strasbourg.portlet.council.display.context;

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

import static eu.strasbourg.portlet.council.constants.CouncilConstants.*;

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
                .orElse(TYPES);
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

        NavigationItem types = new NavigationItem();
        types.setLabel(LanguageUtil.get(bundle, "councilTypes"));
        types.setActive(this.selectedTab.equals(TYPES));
        types.setHref(this.response.createRenderURL(), URL_PARAM_TAB, TYPES, URL_PARAM_MVCPATH, TYPES_PATH);
        navigationItems.add(types);

        NavigationItem councilSessions = new NavigationItem();
        councilSessions.setLabel(LanguageUtil.get(bundle, "councilSessions"));
        councilSessions.setActive(this.selectedTab.equals(COUNCIL_SESSIONS));
        councilSessions.setHref(this.response.createRenderURL(), URL_PARAM_TAB, COUNCIL_SESSIONS, URL_PARAM_MVCPATH, COUNCIL_SESSIONS_PATH);
        navigationItems.add(councilSessions);

        NavigationItem deliberations = new NavigationItem();
        deliberations.setLabel(LanguageUtil.get(bundle, "deliberations"));
        deliberations.setActive(this.selectedTab.equals(DELIBERATIONS));
        deliberations.setHref(this.response.createRenderURL(), URL_PARAM_TAB, DELIBERATIONS, URL_PARAM_MVCPATH, DELIBERATIONS_PATH);
        navigationItems.add(deliberations);

        NavigationItem  officials= new NavigationItem();
        officials.setLabel(LanguageUtil.get(bundle, "officials"));
        officials.setActive(this.selectedTab.equals(OFFICIALS));
        officials.setHref(this.response.createRenderURL(), URL_PARAM_TAB, OFFICIALS, URL_PARAM_MVCPATH, OFFICIALS_PATH);
        navigationItems.add(officials);

        NavigationItem  officialsConnection= new NavigationItem();
        officialsConnection.setLabel(LanguageUtil.get(bundle, "officialsConnection"));
        officialsConnection.setActive(this.selectedTab.equals(OFFICIAL_CONNECTIONS));
        officialsConnection.setHref(this.response.createRenderURL(), URL_PARAM_TAB, OFFICIAL_CONNECTIONS, URL_PARAM_MVCPATH, OFFICIAL_CONNECTIONS_PATH);
        navigationItems.add(officialsConnection);

        return navigationItems;
    }
}