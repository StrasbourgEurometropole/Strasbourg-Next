package eu.strasbourg.portlet.project.display.context;

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

import static eu.strasbourg.portlet.project.constants.ProjectConstants.*;

public class NavigationBarDisplayContext {
    private final RenderResponse response;
    private final String selectedTab;
    private final String selectedCmd;
    private final String selectedMvcPath;
    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());


    public NavigationBarDisplayContext(RenderRequest request, RenderResponse response) {
        this.response = response;
        // onglet par défaut -> PLACES
        this.selectedTab = Optional
                .ofNullable(ParamUtil.getString(request, URL_PARAM_TAB))
                .filter(Validator::isNotNull)
                .orElse(PROJECTS);
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

        NavigationItem projectItem = new NavigationItem();
        projectItem.setLabel(LanguageUtil.get(bundle, "projects"));
        projectItem.setActive(this.selectedTab.equals(PROJECTS));
        projectItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PROJECTS, URL_PARAM_MVCPATH, PROJECTS_PATH);
        navigationItems.add(projectItem);

        NavigationItem participationItem = new NavigationItem();
        participationItem.setLabel(LanguageUtil.get(bundle, "participations"));
        participationItem.setActive(this.selectedTab.equals(PARTICIPATIONS));
        participationItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PARTICIPATIONS, URL_PARAM_MVCPATH, PARTICIPATIONS_PATH);
        navigationItems.add(participationItem);

        NavigationItem petitionItem = new NavigationItem();
        petitionItem.setLabel(LanguageUtil.get(bundle, "petitions"));
        petitionItem.setActive(this.selectedTab.equals(PETITIONS));
        petitionItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, PETITIONS, URL_PARAM_MVCPATH, PETITIONS_PATH);
        navigationItems.add(petitionItem);

        NavigationItem initiativeItem = new NavigationItem();
        initiativeItem.setLabel(LanguageUtil.get(bundle, "initiatives"));
        initiativeItem.setActive(this.selectedTab.equals(INITIATIVES));
        initiativeItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, INITIATIVES, URL_PARAM_MVCPATH,INITIATIVES_PATH);
        navigationItems.add(initiativeItem);

        NavigationItem budgetParticipatifItem = new NavigationItem();
        budgetParticipatifItem.setLabel(LanguageUtil.get(bundle, "budgets-participatifs"));
        budgetParticipatifItem.setActive(this.selectedTab.equals(BUDGET_PARICIPATIFS));
        budgetParticipatifItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, BUDGET_PARICIPATIFS,URL_PARAM_MVCPATH, BUDGET_PARICIPATIFS_PATH);
        navigationItems.add(budgetParticipatifItem);

        NavigationItem budgetPhaseItem = new NavigationItem();
        budgetPhaseItem.setLabel(LanguageUtil.get(bundle, "budget-phases"));
        budgetPhaseItem.setActive(this.selectedTab.equals(BUDGET_PHASES));
        budgetPhaseItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, BUDGET_PHASES,URL_PARAM_MVCPATH, BUDGET_PHASES_PATH);
        navigationItems.add(budgetPhaseItem);

        return navigationItems;
    }
}