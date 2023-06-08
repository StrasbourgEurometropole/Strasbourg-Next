package eu.strasbourg.portlet.gtfs.display.context;

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

import static eu.strasbourg.portlet.gtfs.constants.GtfsConstants.*;

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
                .orElse(ARRETS);
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

        NavigationItem arret = new NavigationItem();
        arret.setLabel(LanguageUtil.get(bundle, "arrets"));
        arret.setActive(this.selectedTab.equals(ARRETS));
        arret.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ARRETS, URL_PARAM_MVCPATH, ARRETS_PATH);
        navigationItems.add(arret);

        NavigationItem importHistoric = new NavigationItem();
        importHistoric.setLabel(LanguageUtil.get(bundle, "importHistorics"));
        importHistoric.setActive(this.selectedTab.equals(IMPORT_HISTORICS));
        importHistoric.setHref(this.response.createRenderURL(), URL_PARAM_TAB, IMPORT_HISTORICS, URL_PARAM_MVCPATH, IMPORT_HISTORICS_PATH);
        navigationItems.add(importHistoric);


        return navigationItems;
    }
}