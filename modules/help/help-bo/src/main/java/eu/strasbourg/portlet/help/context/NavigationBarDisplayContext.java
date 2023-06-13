package eu.strasbourg.portlet.help.context;

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

import static eu.strasbourg.portlet.help.constants.HelpBOConstants.*;

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
                .orElse(HELP_PROPOSALS);
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

        NavigationItem helpProposalItem = new NavigationItem();
        helpProposalItem.setLabel(LanguageUtil.get(bundle, "helpProposals"));
        helpProposalItem.setActive(this.selectedTab.equals(HELP_PROPOSALS));
        helpProposalItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, HELP_PROPOSALS, URL_PARAM_MVCPATH, HELP_PROPOSALS_PATH);
        navigationItems.add(helpProposalItem);

        NavigationItem helpSeekerItem = new NavigationItem();
        helpSeekerItem.setLabel(LanguageUtil.get(bundle, "helpSeekers"));
        helpSeekerItem.setActive(this.selectedTab.equals(HELP_SEEKERS));
        helpSeekerItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, HELP_SEEKERS, URL_PARAM_MVCPATH, HELP_SEEKERS_PATH);
        navigationItems.add(helpSeekerItem);

        NavigationItem helpRequestslItem = new NavigationItem();
        helpRequestslItem.setLabel(LanguageUtil.get(bundle, "helpRequests"));
        helpRequestslItem.setActive(this.selectedTab.equals(HELP_REQUESTS));
        helpRequestslItem.setHref(this.response.createRenderURL(), URL_PARAM_TAB, HELP_REQUESTS, URL_PARAM_MVCPATH, HELP_REQUESTS_PATH);
        navigationItems.add(helpRequestslItem);

        return navigationItems;
    }
}