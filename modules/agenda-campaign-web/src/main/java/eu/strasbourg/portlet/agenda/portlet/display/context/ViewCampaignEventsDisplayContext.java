package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.asset.categories.item.selector.AssetCategoryTreeNodeItemSelectorReturnType;
import com.liferay.asset.categories.item.selector.criterion.AssetCategoryTreeNodeItemSelectorCriterion;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactory;
import com.liferay.portal.kernel.portlet.RequestBackedPortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.portlet.agenda.portlet.util.CampaignEventActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.CampaignEventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

public class ViewCampaignEventsDisplayContext {

	protected SearchContainer<CampaignEvent> _searchContainer;
	private String _keywords;
	private Integer _status;
	private Long _themeId;
	private Long _typeId;
	private Long _campaignId;
	private List<Campaign> _campaigns;
	private Map<Integer, String> _statuses;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private Map<String, String> _categVocabularies;
	private final HttpServletRequest _httpServletRequest;
	private final ItemSelector _itemSelector;
	private List<CampaignEvent> _campaignEvents;

	public ViewCampaignEventsDisplayContext(RenderRequest request,
		RenderResponse response, ItemSelector itemSelector) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
		_itemSelector = itemSelector;
	}
	/**
	 * Retourne le dropdownItemsProvider de CampaignEvent
	 *
	 */
	@SuppressWarnings("unused")
	public CampaignEventActionDropdownItemsProvider getActionsCampaignEvent(CampaignEvent campaignEvent) {
		return new CampaignEventActionDropdownItemsProvider(campaignEvent, _request,
				_response);
	}
	public boolean hasVocabulary(String vocabularyName){
		return getCategVocabularies().containsKey(vocabularyName);
	}
	public Map<String, String> getCategVocabularies() {
		if (_categVocabularies == null) {
			_categVocabularies = new HashMap<>();
			_categVocabularies.put("vocabulary1", ParamUtil.getString(
					_httpServletRequest, "vocabulary1", ""));
		}

		return _categVocabularies;
	}

	@SuppressWarnings("unused")
	public String getSelectCategoriesByVocabularyIdURL(long vocabularyId) {
		RequestBackedPortletURLFactory requestBackedPortletURLFactory =
				RequestBackedPortletURLFactoryUtil.create(_request);
		AssetCategoryTreeNodeItemSelectorCriterion categoryTreeNodeItemSelectorCriterion =
				new AssetCategoryTreeNodeItemSelectorCriterion();
		categoryTreeNodeItemSelectorCriterion.setDesiredItemSelectorReturnTypes(
				new AssetCategoryTreeNodeItemSelectorReturnType());

		return String.valueOf(
				_itemSelector.getItemSelectorURL(
						requestBackedPortletURLFactory,
						_response.getNamespace() + "selectAssetCategory",
						categoryTreeNodeItemSelectorCriterion));
	}

	/**
	 * Retourne le SearchContainer
	 */
	public SearchContainer<CampaignEvent> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/campaign-view.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("themeId", String.valueOf(this.getThemeId()))
					.setParameter("typeId", String.valueOf(this.getTypeId()))
					.setParameter("campaignId", String.valueOf(this.getCampaignId()))
					.setParameter("statusId", String.valueOf(this.getStatusId()))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			try {
				getHits();
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						int start = this._searchContainer.getStart();
						int end = this._searchContainer.getEnd();
						int total = this._searchContainer.getTotal();
						_campaignEvents = _campaignEvents.subList(start, end > total ? total : end);
						return _campaignEvents;
					}, _campaignEvents.size()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}

	/**
	 * Retourne la liste des campagnes
	 */
	public List<Campaign> getCampaigns() throws PortalException {
		if (Validator.isNull(_campaigns)) {
			_campaigns = CampaignLocalServiceUtil.getCampaigns(-1,
					-1);
		}
		return _campaigns;
	}
	/**
	 * Retourne les Hits de recherche pour un delta
	 */
	private void getHits() throws PortalException {
		if (_campaignEvents == null) {
			_campaignEvents = CampaignEventLocalServiceUtil
					.findByKeywordThemeTypeCampaignAndStatus(this.getKeywords(),
							this.getThemeId(), this.getTypeId(), this.getCampaignId(), this.getStatusId(),
							this._themeDisplay.getUserId(),
							this._themeDisplay.getScopeGroupId(),
							this.getSearchContainer().getStart(),
							this.getSearchContainer().getEnd());
		}
	}

	/**
	 * Retourne la liste des statuts possibles
	 */
	public Map<Integer, String> getStatuses() {
		if (Validator.isNull(_statuses)) {
			Map<Integer, String> statuses = new HashMap<Integer, String>();
			statuses.put(WorkflowConstants.STATUS_DRAFT, "draft");
			statuses.put(WorkflowConstants.STATUS_APPROVED, "approved");
			statuses.put(WorkflowConstants.STATUS_DENIED, "denied");
			statuses.put(WorkflowConstants.STATUS_PENDING, "submitted");
			statuses.put(WorkflowConstants.STATUS_IN_TRASH,
				"deletion-requested");
			_statuses = statuses;
		}
		return _statuses;
	}

	/**
	 * Retourne les mots clés de recherche saisis
	 */
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}

	/**
	 * Retourne le filtre "thème"
	 */
	public long getThemeId() {
		if (Validator.isNull(_themeId)) {
			_themeId = ParamUtil.getLong(_request, "themeId");
		}
		return _themeId;
	}

	/**
	 * Retourne le filtre "type"
	 */
	public long getTypeId() {
		if (Validator.isNull(_typeId)) {
			_typeId = ParamUtil.getLong(_request, "typeId");
		}
		return _typeId;
	}

	/**
	 * Retourne le filtre "campagne"
	 */
	public long getCampaignId() {
		if (Validator.isNull(_campaignId)) {
			_campaignId = ParamUtil.getLong(_request, "campaignId");
		}
		return _campaignId;
	}
	/**
	 * Retourne le filtre "statut"
	 */
	public int getStatusId() {
		if (Validator.isNull(_status)) {
			_status = ParamUtil.getInteger(_request, "statusId", -1);
		}
		return _status;
	}
	
	public boolean isUserAManager() {
		List<Campaign> campaigns = CampaignLocalServiceUtil.getCampaigns(-1,
			-1);
		for (Campaign campaign : campaigns) {
			if (campaign.isManagedByUser(this._themeDisplay.getUserId())) {
				return true;
			}
		}
		return false;
	}

}
