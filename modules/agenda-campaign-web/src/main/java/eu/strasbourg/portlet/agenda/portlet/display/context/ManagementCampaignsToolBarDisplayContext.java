package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class ManagementCampaignsToolBarDisplayContext extends SearchContainerManagementToolbarDisplayContext {

    public ManagementCampaignsToolBarDisplayContext(
            HttpServletRequest httpServletRequest,
            LiferayPortletRequest liferayPortletRequest,
            LiferayPortletResponse liferayPortletResponse,
            ViewCampaignEventsDisplayContext viewCampaignEventsDisplayContext) throws PortalException {
        super(httpServletRequest, liferayPortletRequest, liferayPortletResponse,
                viewCampaignEventsDisplayContext.getSearchContainer());
        _viewCampaignEventsDisplayContext = viewCampaignEventsDisplayContext;

        _themeDisplay = (ThemeDisplay)liferayPortletRequest.getAttribute(
                WebKeys.THEME_DISPLAY);
    }

    /**
     * The ID of the search container connected to the Management Toolbar
     */
    @Override
    public String getSearchContainerId() {
        return "campaignEventsSearchContainer";
    }

    /**
     * Sets the search container’s filtering options
     */
    @Override
    public List<DropdownItem> getFilterDropdownItems() {
        return DropdownItemListBuilder
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(
                                    getFilterByStatusDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-status"));
                        }
                )
              .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(getFilterByThemeDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-theme")
                            );
                        }
                )
                .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(getFilterByTypeDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-type")
                            );
                        }
                ).addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(getFilterCampaignDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-campaign")
                            );
                        }
                )
                .build();
    }

    protected List<DropdownItem> getFilterByThemeDropdownItems() throws PortalException {
        List<DropdownItem> filterStatusDropdownItems = new DropdownItemList();

        for (AssetCategory assetCategory : _viewCampaignEventsDisplayContext.getThemes()) {
            filterStatusDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(true)
                            .setLabel(assetCategory.getName())
                            .build()
            );
        }

        return filterStatusDropdownItems;
    }
    protected List<DropdownItem> getFilterByTypeDropdownItems() throws PortalException {
        List<DropdownItem> filterStatusDropdownItems = new DropdownItemList();

        for (AssetCategory assetCategory : _viewCampaignEventsDisplayContext.getTypes()) {
            filterStatusDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(true)
                            .setLabel(assetCategory.getName())
                            .build()
            );
        }

        return filterStatusDropdownItems;
    }
    protected List<DropdownItem> getFilterCampaignDropdownItems() throws PortalException {
        List<DropdownItem> filterCampagnDropdownItems = new DropdownItemList();

        for (Campaign campaign : _viewCampaignEventsDisplayContext.getCampaigns()) {
            filterCampagnDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(true)
                            .setHref("javascript:getCategoriesByVocabulary("+campaign.getCampaignId()+");")
                            .setLabel(campaign.getTitle(Locale.FRANCE))
                            .build()
            );
        }

        return filterCampagnDropdownItems;
    }
    protected List<DropdownItem> getFilterByStatusDropdownItems() throws PortalException {
        List<DropdownItem> filterStatusDropdownItems = new DropdownItemList();

        for (Integer idStatus : _viewCampaignEventsDisplayContext.getStatuses().keySet()) {
            filterStatusDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(true)
                            .setLabel(_viewCampaignEventsDisplayContext.getStatuses().get(idStatus))
                            .build()
            );
        }

        return filterStatusDropdownItems;
    }
    /**
     * The URL to reset the search
     */
    @Override
    public String getClearResultsURL() {
        return PortletURLBuilder.create(getPortletURL())
                .setKeywords("")
                .setParameter( "orderByCol", "modified-date")
                .setParameter( "orderByType", "desc")
                .buildString();
    }

    /**
     * The action URL to send the search form
     */
    @Override
    public String getSearchActionURL() {
        return PortletURLBuilder.createRenderURL(liferayPortletResponse)
                .setMVCPath("/campaign-view.jsp")
                .setParameter("O")
                .setParameter( "orderByCol", ParamUtil.getString( liferayPortletRequest, "orderByCol"))
                .setParameter( "orderByType", ParamUtil.getString(liferayPortletRequest, " orderByType "))
                .setParameter("tab","campaigns").buildString();
    }

    /**
     * The search form’s name
     */
    @Override
    public String getSearchFormName() {
        return "fm1";
    }


    @Override
    public Boolean isSearchInputAutoFocus() {
        return false;
    }
    @Override
    public Boolean isShowAdvancedSearch() {
        return false;
    }
    @Override
    public Boolean isShowFiltersDoneButton() {
        return false;
    }


    private final ViewCampaignEventsDisplayContext _viewCampaignEventsDisplayContext;
    private final ThemeDisplay _themeDisplay;
    private List<AssetVocabulary> _vocabularies;

}