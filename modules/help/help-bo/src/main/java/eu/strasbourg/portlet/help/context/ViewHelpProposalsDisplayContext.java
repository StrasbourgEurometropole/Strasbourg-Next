package eu.strasbourg.portlet.help.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.util.ProposalHelpActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ViewHelpProposalsDisplayContext extends ViewBaseDisplayContext<HelpProposal> {


	public ViewHelpProposalsDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response, HelpProposal.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider
	 *
	 */
	@SuppressWarnings("unused")
	public ProposalHelpActionDropdownItemsProvider getActionsHelpProposal(HelpProposal helpProposal) {
		return new ProposalHelpActionDropdownItemsProvider(helpProposal, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des help proposals
	 *
	 */
	@Override
	public SearchContainer<HelpProposal> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/help-bo-view-help-proposals.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			_searchContainer.setOrderByColParam("orderByCol");
			_searchContainer.setOrderByTypeParam("orderByType");
			_searchContainer.setOrderByCol(getOrderByCol());
			_searchContainer.setOrderByType(getOrderByType());
			Hits hits;
			try {
				hits = getHits(this._themeDisplay.getScopeGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						this._helpProposals= new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								HelpProposal helpProposal = HelpProposalLocalServiceUtil.fetchHelpProposal(
										GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (helpProposal != null) {
									_helpProposals.add(helpProposal);
								}
							}
						}

						return _helpProposals;
					}, hits.getLength()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}


	/**
	 * Renvoie le nom du champ sur laquelle on fait le tri pour
	 * ElasticSearch
	 *
	 * @return String
	 */
	@Override
	public String getOrderByColSearchField() {
		switch (getOrderByCol()) {
			case "title":
				return "localized_title_fr_FR_sortable";
			case "modified-date":
			default:
				return "modified_sortable";
		}
	}

	@SuppressWarnings("unused")
	public HashMap<Long, Integer> getHelpRequestsByProposal() throws PortalException {
		if (this._helpProposals == null) {
			getSearchContainer();
		}
		if (_helpRequestsByProposal == null) {
			_helpRequestsByProposal = new HashMap<>();
			for (HelpProposal helpProposal : this._helpProposals) {
				long proposalId = helpProposal.getHelpProposalId();
				List<HelpRequest> requests = HelpRequestLocalServiceUtil.getByHelpProposalId(proposalId);
				_helpRequestsByProposal.put(Long.valueOf(proposalId), Integer.valueOf(requests.size()));
			}
		}
		return _helpRequestsByProposal;
	}

	protected SearchContainer<HelpProposal> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private HashMap<Long, Integer> _helpRequestsByProposal;
	private List <HelpProposal> _helpProposals;
}
