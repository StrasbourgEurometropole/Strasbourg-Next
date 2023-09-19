package eu.strasbourg.portlet.agenda.portlet.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.portlet.agenda.portlet.util.CampaignEventActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.service.CampaignEventLocalServiceUtil;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ViewCampaignEventsDisplayContext extends ViewBaseDisplayContext<CampaignEvent> {

	protected SearchContainer<CampaignEvent> _searchContainer;
	private Integer _status;
	private Long _themeId;
	private Long _typeId;
	private Long _campaignId;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private List<CampaignEvent> _campaignEvents;

	public ViewCampaignEventsDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, CampaignEvent.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
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

	/**
	 * Retourne le SearchContainer
	 */
	@Override
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
					() -> _campaignEvents, (int) CampaignEventLocalServiceUtil
							.findByKeywordThemeTypeCampaignAndStatusCount(this.getKeywords(),
									this.getThemeId(), this.getTypeId(), this.getCampaignId(), this.getStatusId(),
									this._themeDisplay.getUserId(),
									this._themeDisplay.getScopeGroupId())
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
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
	 * Retourne le filtre "thème"
	 */
	public long getThemeId() {
		if (Validator.isNull(_themeId)) {
			_themeId = ParamUtil.getLong(_request, "themeId", -1);
		}
		return _themeId;
	}

	/**
	 * Retourne le filtre "type"
	 */
	public long getTypeId() {
		if (Validator.isNull(_typeId)) {
			_typeId = ParamUtil.getLong(_request, "typeId",-1);
		}
		return _typeId;
	}

	/**
	 * Retourne le filtre "campagne"
	 */
	public long getCampaignId() {
		if (Validator.isNull(_campaignId)) {
			_campaignId = ParamUtil.getLong(_request, "campaignId", -1);
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

}
