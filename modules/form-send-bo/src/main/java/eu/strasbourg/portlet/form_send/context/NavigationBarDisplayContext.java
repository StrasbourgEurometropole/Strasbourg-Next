package eu.strasbourg.portlet.form_send.context;

import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.NavigationItem;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import static eu.strasbourg.portlet.form_send.constants.FormSendConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private final Long selectedFormInstanceId;
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
        this.selectedFormInstanceId = Optional
                .ofNullable(ParamUtil.getLong(request, URL_PARAM_FORM_INSTANCE_ID))
                .filter(Validator::isNotNull)
                .orElse(-1L);
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
    @SuppressWarnings("unused")
    public Long getSelectedFormInstanceId() {
        return selectedFormInstanceId;
    }

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

        //récupère le nom du formulaire
        DDMFormInstance formInstance = DDMFormInstanceLocalServiceUtil.fetchFormInstance(this.selectedFormInstanceId);
        String formInstanceName = "Proposition";
        if(Validator.isNotNull(formInstance))
            formInstanceName = formInstance.getName(Locale.FRANCE);

        // récupère le backURL
        String backURL = PortletURLBuilder.createRenderURL(this.response)
                .setMVCPath("/form-send-bo-view-forms.jsp")
                .setParameter("tab", FORMS)
                .buildString();

        NavigationItem records = new NavigationItem();
        records.setLabel(formInstanceName);
        records.setActive(this.selectedTab.equals(RECORDS));
        records.setHref(this.response.createRenderURL(), URL_PARAM_BACK_URL, backURL, URL_PARAM_TAB, RECORDS, URL_PARAM_MVCPATH, RECORDS_PATH, URL_PARAM_FORM_INSTANCE_ID, this.selectedFormInstanceId);
        navigationItems.add(records);

        NavigationItem signalement = new NavigationItem();
        signalement.setLabel(LanguageUtil.get(bundle, "reportings"));
        signalement.setActive(this.selectedTab.equals(SIGNALEMENTS));
        signalement.setHref(this.response.createRenderURL(), URL_PARAM_BACK_URL, backURL, URL_PARAM_TAB, SIGNALEMENTS, URL_PARAM_MVCPATH,SIGNALEMENTS_PATH, URL_PARAM_FORM_INSTANCE_ID, this.selectedFormInstanceId);
        navigationItems.add(signalement);

        return navigationItems;
    }
}