package eu.strasbourg.portlet.help.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.help.util.ProposalHelpActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ViewHelpProposalsDisplayContext{


	public ViewHelpProposalsDisplayContext(RenderRequest request, RenderResponse response) {
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
		_httpServletRequest = PortalUtil.getHttpServletRequest(request);
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
	public SearchContainer<HelpProposal> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/help-bo-view-help-proposals.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			_searchContainer.setOrderByColParam("orderByCol");
			_searchContainer.setOrderByTypeParam("orderByType");
			_searchContainer.setOrderByCol(getOrderByCol());
			_searchContainer.setOrderByType(getOrderByType());
			try {
				getHits(this._themeDisplay.getScopeGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						this._helpProposals= new ArrayList<>();
						if (_hits != null) {
							for (Document document : _hits.getDocs()) {
								HelpProposal helpProposal = HelpProposalLocalServiceUtil.fetchHelpProposal(
										GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (helpProposal != null) {
									_helpProposals.add(helpProposal);
								}
							}
						}

						return _helpProposals;
					}, _hits.getLength()
			);
		}
		_searchContainer.setRowChecker(
				new EmptyOnClickRowChecker(_response));

		return _searchContainer;
	}

	/**
	 * Retourne les Hits de recherche pour un delta
	 */
	private void getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		_hits = SearchHelper.getBOSearchHits(searchContext,
				getSearchContainer().getStart(),
				getSearchContainer().getEnd(), HelpProposal.class.getName(), groupId,
				getFilterCategoriesIds(), keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
	}

	public boolean hasVocabulary(String vocabularyName){
		return getFilterCategoriesIdByVocabulariesName().contains(vocabularyName+"_");
	}

	/**
	 * Retourne la liste des IDs des catégories sur lesquels on doit filtrer
	 *  chaque entrée de liste contient un tableau de String :
	 * [vocabularyName, categoryName, categoryId]
	 */
	public List<String[]> getCategVocabularies() {
		if (_categVocabularies == null) {
			_categVocabularies = new ArrayList<>();
			List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
					.split("__"));
			for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
				if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
					_categVocabularies.add(filterCategoryIdByVocabularyName.split("_"));
				}
			}
		}

		return _categVocabularies;
	}

	/**
	 * Retourne un String des IDs des catégories sur lesquels on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "vocabularyName_categoryName_categoryId__..."
	 */
	public String getFilterCategoriesIdByVocabulariesName() {
		return ParamUtil.getString(_httpServletRequest, "filterCategoriesIdByVocabulariesName","");
	}


	/**
	 * Renvoie le nom du champ sur laquelle on fait le tri pour
	 * ElasticSearch
	 *
	 * @return String
	 */
	public String getOrderByColSearchField() {
		switch (getOrderByCol()) {
			case "title":
				return "localized_title_fr_FR_sortable";
			case "modified-date":
			default:
				return "modified_sortable";
		}
	}
	/**
	 * Renvoie la colonne sur laquelle on fait le tri
	 *
	 * @return String
	 */
	public String getOrderByCol() {
		return ParamUtil.getString(_request, "orderByCol", "modified-date");
	}

	/**
	 * Retourne le type de tri (desc ou asc)
	 *
	 * @return String
	 */
	public String getOrderByType() {
		return ParamUtil.getString(_request, "orderByType", "desc");
	}

	/**
	 * Retourne les mots clés de recherche saisis
	 */
	@SuppressWarnings("unused")
	public String getKeywords() {
		if (Validator.isNull(_keywords)) {
			_keywords = ParamUtil.getString(_request, "keywords");
		}
		return _keywords;
	}
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

	/**
	 * Renvoie la liste des catégories sur lesquelles on souhaite filtrer les
	 * entries. L'opérateur entre chaque id de catégorie d'un array est un "OU", celui entre chaque liste d'array est un "ET"
	 */
	private List<Long[]> getFilterCategoriesIds() {
		if (_filterCategoriesIds == null) {
			List<Long[]> filterCategoriesIds = new ArrayList<Long[]>();

			// récupère les catégories triées par nom de vocabulaire
			List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
					.split("__")).stream().sorted().collect(Collectors.toList());
			if(!filterCategoriesIdByVocabulariesName.isEmpty()) {
				String oldVocabularyName = "";
				String categoriesIds = "";
				for (String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName) {
					if (Validator.isNotNull(filterCategoryIdByVocabularyName)) {
						String vocabularyName = filterCategoryIdByVocabularyName.split("_")[0];
						String categoryId = filterCategoryIdByVocabularyName.split("_")[2];
						if (oldVocabularyName.equals("") || oldVocabularyName.equals(vocabularyName)) {
							if (Validator.isNotNull(categoriesIds)) {
								categoriesIds += ",";
							}
							categoriesIds += categoryId;
							oldVocabularyName = vocabularyName;
						} else {
							Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
							filterCategoriesIds.add(categoriesIdsOr);
							oldVocabularyName = vocabularyName;
							categoriesIds = categoryId;
						}
					}
				}
				Long[] categoriesIdsOr = ArrayUtil.toLongArray(StringUtil.split(categoriesIds, ",", 0));
				filterCategoriesIds.add(categoriesIdsOr);
			}
			this._filterCategoriesIds = filterCategoriesIds;
		}
		return this._filterCategoriesIds;
	}

	/**
	 * Retourne la liste des IDs des catégories d'un vocabulaire, sur lequel on doit filtrer
	 *  sous forme de string qui se présente comme suit :
	 * "categoryId1,categoryId2,categoryId3,"
	 */
	public String getFilterCategoriesIdsByVocabularyName(String vocabularyName) {
		List<String> filterCategoriesIdByVocabulariesName = List.of(getFilterCategoriesIdByVocabulariesName()
				.split("__"));
		String filterCategoriesIdsByVocabulary = "";
		for(String filterCategoryIdByVocabularyName : filterCategoriesIdByVocabulariesName){
			if(Validator.isNotNull(filterCategoryIdByVocabularyName)) {
				String[] arrayCategoryIdByVocabularyName = filterCategoryIdByVocabularyName.split("_");
				if(arrayCategoryIdByVocabularyName[0].equals(vocabularyName))
					filterCategoriesIdsByVocabulary += arrayCategoryIdByVocabularyName[2] + ",";
			}
		}
		return filterCategoriesIdsByVocabulary;
	}
	private Hits _hits;
	protected SearchContainer<HelpProposal> _searchContainer;
	private String _keywords;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
	private final HttpServletRequest _httpServletRequest;

	private List<String[]> _categVocabularies;
	private HashMap<Long, Integer> _helpRequestsByProposal;
	private List <HelpProposal> _helpProposals;
	protected List<Long[]> _filterCategoriesIds;
}
