package eu.strasbourg.portlet.agenda.csmap.display.context;

import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenu;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.CreationMenuBuilder;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import javax.servlet.http.HttpServletRequest;

public class ManagementCsmapThematiqueAgendaToolBarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    public ManagementCsmapThematiqueAgendaToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            ViewCsmapAgendaThematiqueDisplayContext viewCsmapAgendaThematiqueDisplayContext) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                viewCsmapAgendaThematiqueDisplayContext.getSearchContainer());

        _viewCsmapAgendaThematiqueDisplayContext = viewCsmapAgendaThematiqueDisplayContext;

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * The action URL to send the search form
     */
    @Override
    public String getSearchActionURL() {
        return PortletURLBuilder.createRenderURL(liferayPortletResponse)
                .buildString();
    }

    /**
     * creates an add menu button
     */
    @Override
    public CreationMenu getCreationMenu() {
        return CreationMenuBuilder.addPrimaryDropdownItem(
                dropdownItem -> {
                    ThemeDisplay themeDisplay =
                            (ThemeDisplay)httpServletRequest.getAttribute(
                                    WebKeys.THEME_DISPLAY);

                    dropdownItem.setHref(
                            liferayPortletResponse.createRenderURL(),
                            "tab", "agendaThematique",
                            "cmd", "editAgendaThematique",
                            "mvcPath", "/csmap-bo-agenda-edit-thematique.jsp",
                            "backURL", themeDisplay.getURLCurrent());

                    dropdownItem.setLabel(
                            LanguageUtil.get(httpServletRequest, "add"));
                }
        ).build();
    }
    // Masquer la case à cocher "la barre de recherche"
    @Override
    public Boolean isShowSearch() {
        return false;
    }

    // Masquer la case à cocher "Select All"
    @Override
    public Boolean isSelectable() {
        return false;
    }
    private final ViewCsmapAgendaThematiqueDisplayContext _viewCsmapAgendaThematiqueDisplayContext;
    private final ThemeDisplay _themeDisplay;
}