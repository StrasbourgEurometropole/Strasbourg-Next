package eu.strasbourg.portlet.place.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.place.util.PlaceActionDropdownItemsProvider;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ViewPlacesDisplayContext extends ViewBaseDisplayContext<Place> {

	public ViewPlacesDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(request, response, Place.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	List<Place> _places = new ArrayList<>();

	//Set places
	public void setPlaces(List<Place> places) {
		_places = places;
	}

	/**
	 * Retourne le dropdownItemsProvider de place
	 *
	 */
	@SuppressWarnings("unused")
	public PlaceActionDropdownItemsProvider getActionsPlace(Place place) {
		return new PlaceActionDropdownItemsProvider(place, _request,
				_response);
	}

	/**
	 * Retourne la liste des lieux
	 */
	public List<Place> getPlaces() {
		return _places;
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 * Retourne le searchContainer des élus
	 *
	 * @return SearchContainer<price>
	 */
	@Override
	public SearchContainer<Place> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/place-bo-view-places.jsp")
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
				hits = getHits(this._themeDisplay.getCompanyGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<Place> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								Place place = PlaceLocalServiceUtil.fetchPlace(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (place!= null)
									results.add(place);
							}
						}

						setPlaces(results);

						return results;
					}, hits.getLength()
			);
		}
		_searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
		return _searchContainer;
	}


	@Override
	protected Hits getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

		AssetVocabulary typeDeLieuVocab = AssetVocabularyHelper.getVocabulary("Type de lieu", GroupLocalServiceUtil.fetchCompanyGroup(PortalUtil.getDefaultCompanyId()).getGroupId());
		List<AssetCategory> categoriesUser = AssetCategoryLocalServiceUtil.getCategories(User.class.getName(), _themeDisplay.getUserId());
		List<Long> categoriesTypeDeLieuUser = new ArrayList<>();
		for (AssetCategory assetCategory : categoriesUser) {
			if(typeDeLieuVocab.getVocabularyId() == assetCategory.getVocabularyId()) {
				categoriesTypeDeLieuUser.add(assetCategory.getCategoryId());
			}
		}

		List<Long[]> categoriesId = new ArrayList<>();

		if (categoriesTypeDeLieuUser.isEmpty()) {
			categoriesId = getFilterCategoriesIds();
		} else {
			categoriesId.add(ArrayUtil.toLongArray(categoriesTypeDeLieuUser.toArray()));
		}

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		_hits = SearchHelper.getBOSearchHits(searchContext,
				getSearchContainer().getStart(),
				getSearchContainer().getEnd(), Place.class.getName(), groupId,
				categoriesId, keywords,
				getOrderByColSearchField(),
				"desc".equals(getOrderByType()));
		return _hits;
	}


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

	public String getPlaceIds() {
		// get places from _places
		List<Place> places = getPlaces();
		String placeIds = "";
		for (Place place : places) {
			if (Validator.isNotNull(placeIds)) {
				placeIds += ",";
			}
			placeIds += place.getPlaceId();
		}
		return placeIds;
	}

	public List<Long[]> getFilterCategoriesIds() {
		if (_filterCategoriesIds == null) {
			List<Long[]> filterCategoriesIds = new ArrayList<>();

			// récupère les catégories triées par nom de vocabulaire
			List<String> filterCategoriesIdByVocabulariesName = getListFilterCategoriesIdByVocabulariesName();
			if(!filterCategoriesIdByVocabulariesName.isEmpty()) {
				List<String> listCategoriesIdByVocabulariesName = filterCategoriesIdByVocabulariesName
						.stream().sorted().collect(Collectors.toList());
				String oldVocabularyName = "";
				String categoriesIds = "";
				for (String filterCategoryIdByVocabularyName : listCategoriesIdByVocabulariesName) {
					if (Validator.isNotNull(filterCategoryIdByVocabularyName)) {
						String[] categorySelected = filterCategoryIdByVocabularyName.split("__");
						String vocabularyName = categorySelected[0];
						String categoryId = categorySelected[2];
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


	protected SearchContainer<Place> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}

