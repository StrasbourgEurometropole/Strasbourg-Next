package eu.strasbourg.portlet.edition.display.context;

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

import static eu.strasbourg.portlet.edition.constants.EditionConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        // onglet par défaut -> EDITIONS
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(EDITIONS);
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

        NavigationItem editions = new NavigationItem();
        editions.setLabel(LanguageUtil.get(bundle, "editions"));
       editions.setActive(this.selectedTab.equals(EDITIONS));
        editions.setHref(this.response.createRenderURL(), URL_PARAM_TAB, EDITIONS, URL_PARAM_MVCPATH, EDITIONS_PATH);
        navigationItems.add(editions);


        NavigationItem gallery = new NavigationItem();
        gallery.setLabel(LanguageUtil.get(bundle, "galleries"));
        gallery.setActive(this.selectedTab.equals(GALERIES));
        gallery.setHref(this.response.createRenderURL(), URL_PARAM_TAB, GALERIES, URL_PARAM_MVCPATH, GALERIES_PATH);
        navigationItems.add(gallery);

        return navigationItems;
    }
}