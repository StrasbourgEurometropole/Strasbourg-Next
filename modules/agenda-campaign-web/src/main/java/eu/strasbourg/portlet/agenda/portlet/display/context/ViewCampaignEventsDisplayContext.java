package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.CampaignEventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ViewCampaignEventsDisplayContext extends BaseDisplayContext {

	protected SearchContainer<CampaignEvent> _searchContainer;
	private String _keywords;
	private Integer _status;
	private Long _themeId;
	private Long _typeId;
	private Long _campaignId;
	private List<CampaignEvent> _campaignEvents;
	private List<AssetCategory> _themes;
	private List<AssetCategory> _types;
	private List<Campaign> _campaigns;
	private Map<Integer, String> _statuses;

	public ViewCampaignEventsDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response);
	}

	/**
	 * Retourne le SearchContainer
	 */
	public SearchContainer<CampaignEvent> getSearchContainer()
		throws PortalException {
		if (this._searchContainer == null) {
			PortletURL iteratorURL = this._response.createRenderURL();
			iteratorURL.setParameter("keywords", this.getKeywords());
			iteratorURL.setParameter("themeId", String.valueOf(this.getThemeId()));
			iteratorURL.setParameter("typeId", String.valueOf(this.getTypeId()));
			iteratorURL.setParameter("campaignId", String.valueOf(this.getCampaignId()));
			iteratorURL.setParameter("statusId", String.valueOf(this.getStatusId()));
			
			this._searchContainer = new SearchContainer<CampaignEvent>(
				this._request, iteratorURL, null, "no-entries-were-found");

			this._searchContainer.setEmptyResultsMessageCssClass(
				"taglib-empty-result-message-header-has-plus-btn");
			this._searchContainer
				.setRowChecker(new EmptyOnClickRowChecker(this._response));
			this._searchContainer.setOrderByColParam("orderByCol");
			this._searchContainer.setOrderByTypeParam("orderByType");
		}
		return _searchContainer;
	}

	/**
	 * Retourne la liste des thèmes
	 */
	public List<AssetCategory> getThemes() throws PortalException {
		if (Validator.isNull(_themes)) {
			long companyId = PortalUtil.getDefaultCompanyId();
			long companyGroupId = CompanyLocalServiceUtil.getCompany(companyId)
					.getGroup().getGroupId();
			AssetVocabulary vocabulary = AssetVocabularyHelper
					.getEntityVocabulary(Event.class.getName(), VocabularyNames.EVENT_THEME,
							companyGroupId);
			if (vocabulary != null) {
				_themes = vocabulary.getCategories();
			}
		}
		return _themes;
	}

	/**
	 * Retourne la liste des types
	 */
	public List<AssetCategory> getTypes() throws PortalException {
		if (Validator.isNull(_types)) {
			long companyId = PortalUtil.getDefaultCompanyId();
			long companyGroupId = CompanyLocalServiceUtil.getCompany(companyId)
					.getGroup().getGroupId();
			AssetVocabulary vocabulary = AssetVocabularyHelper
					.getEntityVocabulary(Event.class.getName(), VocabularyNames.EVENT_TYPE,
							companyGroupId);
			if (vocabulary != null) {
				_types
						= vocabulary.getCategories();
			}
		}
		return _types;
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
	 * Retourne le nom du filtre "thème" sélectionné
	 * @throws PortalException
	 */
	public String getThemeLabel() throws PortalException {
		Optional<AssetCategory> optionalTheme = this.getThemes().stream()
				.filter(t -> t.getCategoryId() == this.getThemeId()).findFirst();
		if(optionalTheme.isPresent()) {
			return optionalTheme.get().getTitleCurrentValue();
		} else {
			return "";
		}
	}

	/**
	 * Retourne le nom du filtre "type" sélectionné
	 * @throws PortalException
	 */
	public String getTypeLabel() throws PortalException {
		Optional<AssetCategory> optionalType = this.getTypes().stream()
				.filter(t -> t.getCategoryId() == this.getTypeId()).findFirst();
		if(optionalType.isPresent()) {
			return optionalType.get().getTitleCurrentValue();
		} else {
			return "";
		}
	}

	/**
	 * Retourne le nom du filtre "campagne" sélectionné
	 * @throws PortalException
	 */
	public String getCampaignLabel() throws PortalException {
		Optional<Campaign> optionalCampaign = this.getCampaigns().stream()
				.filter(t -> t.getCampaignId() == this.getCampaignId()).findFirst();
		if(optionalCampaign.isPresent()) {
			return optionalCampaign.get().getTitleCurrentValue();
		} else {
			return "";
		}
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

	public List<CampaignEvent> getCampaignEvents() throws PortalException {
		if (_campaignEvents == null) {
			_campaignEvents = CampaignEventLocalServiceUtil
				.findByKeywordThemeTypeCampaignAndStatus(this.getKeywords(),
					this.getThemeId(), this.getTypeId(), this.getCampaignId(), this.getStatusId(),
					this._themeDisplay.getUserId(),
					this._themeDisplay.getScopeGroupId(),
					this.getSearchContainer().getStart(),
					this.getSearchContainer().getEnd());
			long total = CampaignEventLocalServiceUtil
				.findByKeywordThemeTypeCampaignAndStatusCount(this.getKeywords(),
					this.getThemeId(), this.getTypeId(), this.getCampaignId(), this.getStatusId(),
					this._themeDisplay.getUserId(),
					this._themeDisplay.getScopeGroupId());
			this.getSearchContainer().setResultsAndTotal(null,(int) total);
		}
		return _campaignEvents;
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
