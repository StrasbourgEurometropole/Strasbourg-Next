package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.frontend.taglib.clay.servlet.taglib.display.context.SearchContainerManagementToolbarDisplayContext;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.*;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;

import javax.portlet.PortletURL;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
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
                            dropdownGroupItem.setDropdownItems(getFilterVocabularyDropdownItems());
                            dropdownGroupItem.setLabel(LanguageUtil.get(httpServletRequest, "filter-by-vocabulaire"));


                        }
                )
               .addGroup(
                        dropdownGroupItem -> {
                            dropdownGroupItem.setDropdownItems(getFilterCampaignDropdownItems());
                            dropdownGroupItem.setLabel(
                                    LanguageUtil.get(httpServletRequest, "filter-by-campaign")
                            );
                        }
                )
                .build();
    }

    protected List<DropdownItem> getFilterCampaignDropdownItems() throws PortalException {
        List<DropdownItem> filterCampagnDropdownItems = new DropdownItemList();
        PortletURL portletURL=getPortletURL();
        portletURL.setParameter("statusId",String.valueOf(_viewCampaignEventsDisplayContext.getStatusId()));
        portletURL.setParameter(ParamUtil.getString(request, _viewCampaignEventsDisplayContext.getKeywords()));
        portletURL.setParameter("campaignId", "");
        portletURL.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA));
        filterCampagnDropdownItems.add(
                DropdownItemBuilder
                        .setActive(_viewCampaignEventsDisplayContext.getStatusId()==0)
                        .setHref(portletURL)
                        .setLabel(LanguageUtil.get(httpServletRequest, "filter-by-campaign-any-of-theme"))
                        .build()
        );
        for (Campaign campaign : _viewCampaignEventsDisplayContext.getCampaigns()) {

            portletURL.setParameter("campaignId", String.valueOf(campaign.getCampaignId()));
            portletURL.setParameter(ParamUtil.getString(request, _viewCampaignEventsDisplayContext.getKeywords()));
            portletURL.setParameter("statusId", String.valueOf(_viewCampaignEventsDisplayContext.getStatusId()));
            portletURL.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA));

            filterCampagnDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewCampaignEventsDisplayContext.getCampaignId()==campaign.getCampaignId())
                            .setHref(portletURL)
                            .setLabel(campaign.getTitle(Locale.FRANCE))
                            .build()
            );
        }

        return filterCampagnDropdownItems;
    }
    protected List<DropdownItem> getFilterByStatusDropdownItems() throws PortalException {
        List<DropdownItem> filterStatusDropdownItems = new DropdownItemList();
        PortletURL portletURL=getPortletURL();
        portletURL.setParameter("campaignId",String.valueOf(_viewCampaignEventsDisplayContext.getCampaignId()));
        portletURL.setParameter(ParamUtil.getString(request, _viewCampaignEventsDisplayContext.getKeywords()));
        portletURL.setParameter("statusId", "");
        portletURL.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA));
        filterStatusDropdownItems.add(
                DropdownItemBuilder
                        .setActive(_viewCampaignEventsDisplayContext.getStatusId()==0)
                        .setHref(portletURL)
                        .setLabel(LanguageUtil.get(httpServletRequest, "filter-by-status-any-of-theme"))
                        .build()
        );
        for (Integer idStatus : _viewCampaignEventsDisplayContext.getStatuses().keySet()) {

            portletURL.setParameter("campaignId",String.valueOf(_viewCampaignEventsDisplayContext.getCampaignId()));
            portletURL.setParameter(ParamUtil.getString(request, _viewCampaignEventsDisplayContext.getKeywords()));
            portletURL.setParameter("statusId", String.valueOf(idStatus));
            portletURL.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA));
            filterStatusDropdownItems.add(
                    DropdownItemBuilder
                            .setActive(_viewCampaignEventsDisplayContext.getStatusId()==idStatus)
                            .setHref(portletURL)
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
        .buildString();
    }
    /**
     * Add filtering options to Vocabulary
     */
    protected List<DropdownItem> getFilterVocabularyDropdownItems() throws PortalException {

        List<DropdownItem> filterVocabularyDropdownItems = new DropdownItemList();
        for (AssetVocabulary vocabulary : getCompaignEventVocabularies()) {
            filterVocabularyDropdownItems.add(
                    DropdownItemBuilder
                            .setHref("javascript:getCategoriesByVocabulary("+vocabulary.getVocabularyId()+");")
                            .setLabel(vocabulary.getName())
                            .build()
            );
        }

        return filterVocabularyDropdownItems;
    }
    /**
     * Get Vocabularies
     */
    protected List<AssetVocabulary> getCompaignEventVocabularies() throws PortalException {
        if (Validator.isNull(_vocabularies)) {
            _vocabularies=new ArrayList<>();
            long companyId = PortalUtil.getDefaultCompanyId();
            long companyGroupId = CompanyLocalServiceUtil.getCompany(companyId)
                    .getGroup().getGroupId();
            AssetVocabulary vocabularyTheme = AssetVocabularyHelper
                    .getEntityVocabulary(Event.class.getName(), VocabularyNames.EVENT_THEME,
                            companyGroupId);
            if(vocabularyTheme!=null)
                _vocabularies.add(vocabularyTheme);
            AssetVocabulary vocabularyType = AssetVocabularyHelper
                    .getEntityVocabulary(Event.class.getName(), VocabularyNames.EVENT_TYPE,
                            companyGroupId);
            if(vocabularyType!=null)
                _vocabularies.add(vocabularyType);
        }
        return _vocabularies;
    }


    /**
     * The search form’s name
     */
    @Override
    public String getSearchFormName() {
        return "fm1";
    }

    @Override
    public Boolean isShowFiltersDoneButton() {
        return false;
    }


    private final ViewCampaignEventsDisplayContext _viewCampaignEventsDisplayContext;
    private final ThemeDisplay _themeDisplay;
    private List<AssetVocabulary> _vocabularies;

}