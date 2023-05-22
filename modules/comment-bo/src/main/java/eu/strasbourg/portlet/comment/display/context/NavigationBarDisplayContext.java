package eu.strasbourg.portlet.comment.display.context;

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

import static eu.strasbourg.portlet.comment.constants.CommentConstants.*;

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
                .orElse(COMMENTS);
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

        NavigationItem comments = new NavigationItem();
        comments.setLabel(LanguageUtil.get(bundle, "comments"));
        comments.setActive(this.selectedTab.equals(COMMENTS));
        comments.setHref(this.response.createRenderURL(), URL_PARAM_TAB, COMMENTS, URL_PARAM_MVCPATH, COMMENTS_PATH);
        navigationItems.add(comments);

        NavigationItem signalements = new NavigationItem();
        signalements.setLabel(LanguageUtil.get(bundle, "reportings"));
        signalements.setActive(this.selectedTab.equals(SIGNALEMENTS));
        signalements.setHref(this.response.createRenderURL(), URL_PARAM_TAB, SIGNALEMENTS, URL_PARAM_MVCPATH, SIGNALEMENTS_PATH);
        navigationItems.add(signalements);

        return navigationItems;
    }
}