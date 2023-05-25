package eu.strasbourg.portlet.form_send.context;

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

import static eu.strasbourg.portlet.form_send.constants.FormSendConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        // onglet par défaut -> FORMS
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(FORMS);
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
    private String libele;

    public List<NavigationItem> getNavigationItems() {
        List<NavigationItem> navigationItems = new ArrayList<>();

        NavigationItem forms = new NavigationItem();
        forms.setLabel(LanguageUtil.get(bundle, "forms"));
        forms.setActive(this.selectedTab.equals(FORMS));
        forms.setHref(this.response.createRenderURL(), URL_PARAM_TAB, FORMS, URL_PARAM_MVCPATH, FORMS_PATH);
        navigationItems.add(forms);

        return navigationItems;
    }
    public List<NavigationItem> getNavigationUnderItems() {
        List<NavigationItem> navigationItems = new ArrayList<>();


        NavigationItem importation = new NavigationItem();
        importation.setLabel(getLibele());
        importation.setActive(this.selectedTab.equals(RECORDS));
        importation.setHref(this.response.createRenderURL(), URL_PARAM_TAB, RECORDS, URL_PARAM_MVCPATH, RECORDS_PATH);
        navigationItems.add(importation);

        NavigationItem campaign = new NavigationItem();
        campaign.setLabel(LanguageUtil.get(bundle, "reportings"));
        campaign.setActive(this.selectedTab.equals(SIGNALEMENTS));
        campaign.setHref(this.response.createRenderURL(), URL_PARAM_TAB, SIGNALEMENTS, URL_PARAM_MVCPATH,SIGNALEMENTS_PATH);
        navigationItems.add(campaign);

        return navigationItems;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }
    public String getLibele() {
        return libele;
    }
}