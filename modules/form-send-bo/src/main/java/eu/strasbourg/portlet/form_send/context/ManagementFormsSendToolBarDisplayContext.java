package eu.strasbourg.portlet.form_send.context;

import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.display.context.ManagementBaseToolBarDisplayContext;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ManagementFormsSendToolBarDisplayContext extends ManagementBaseToolBarDisplayContext<DDMFormInstanceRecord> {

    public ManagementFormsSendToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            SearchContainer searchContainer) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                DDMFormInstanceRecord.class, searchContainer);


        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * On ne veut pas d'options de sélection
     */
    @Override
    public List<DropdownItem> getActionDropdownItems() {
        return null;
    }


    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "formsSearchContainer";
    }



    /**
     * Fields that can be sorted
     */
    @Override
    protected String[] getOrderByKeys() {
        return new String[] { "create-date" };
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


    private final ThemeDisplay _themeDisplay;

}