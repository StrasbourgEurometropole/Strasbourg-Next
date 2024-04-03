package eu.strasbourg.portlet.oidc.display.context;

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

import static eu.strasbourg.portlet.oidc.constants.OidcConstants.*;

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
                .orElse(PUBLIK_USERS);
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

        NavigationItem publikUser = new NavigationItem();
        publikUser.setLabel(LanguageUtil.get(bundle, "publikusers"));
        publikUser.setActive(this.selectedTab.equals(PUBLIK_USERS));
        publikUser.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PUBLIK_USERS, URL_PARAM_MVCPATH, PUBLIK_USERS_PATH);
        navigationItems.add(publikUser);

        NavigationItem anonymisationhistoric = new NavigationItem();
        anonymisationhistoric.setLabel(LanguageUtil.get(bundle, "anonymisationhistorics"));
        anonymisationhistoric.setActive(this.selectedTab.equals(ANONYMISATION_HISTORICS));
        anonymisationhistoric.setHref(this.response.createRenderURL(), URL_PARAM_TAB, ANONYMISATION_HISTORICS, URL_PARAM_MVCPATH, ANONYMISATION_HISTORICS_PATH);
        navigationItems.add(anonymisationhistoric);

        return navigationItems;
    }
}