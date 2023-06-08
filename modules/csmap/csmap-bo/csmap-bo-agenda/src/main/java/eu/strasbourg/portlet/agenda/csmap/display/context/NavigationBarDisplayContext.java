package eu.strasbourg.portlet.agenda.csmap.display.context;

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

import static eu.strasbourg.portlet.agenda.csmap.constants.CsmapBoAgendaConstants.*;

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
                .orElse(AGENDA_PRINCIPAL);
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
        publikUser.setLabel(LanguageUtil.get(bundle, "agendaPrincipal"));
        publikUser.setActive(this.selectedTab.equals(AGENDA_PRINCIPAL));
        publikUser.setHref(this.response.createRenderURL(), URL_PARAM_TAB, AGENDA_PRINCIPAL, URL_PARAM_MVCPATH, AGENDA_PRINCIPAL_PATH);
        navigationItems.add(publikUser);

        NavigationItem anonymisationhistoric = new NavigationItem();
        anonymisationhistoric.setLabel(LanguageUtil.get(bundle, "agendaThematique"));
        anonymisationhistoric.setActive(this.selectedTab.equals(AGENDA_THEMATIQUES));
        anonymisationhistoric.setHref(this.response.createRenderURL(), URL_PARAM_TAB, AGENDA_THEMATIQUES, URL_PARAM_MVCPATH, AGENDA_THEMATIQUES_PATH);
        navigationItems.add(anonymisationhistoric);

        return navigationItems;
    }
}