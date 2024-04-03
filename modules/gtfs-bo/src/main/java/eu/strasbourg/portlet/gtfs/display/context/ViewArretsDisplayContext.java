package eu.strasbourg.portlet.gtfs.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.gtfs.util.ArretActionDropdownItemsProvider;
import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.service.ArretLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewArretsDisplayContext extends ViewBaseDisplayContext<Arret> {

	public ViewArretsDisplayContext(RenderRequest request,
									RenderResponse response) {
		super(request, response, Arret.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/*public List<Arret> getArrets() throws PortalException {
		if (this._arrets == null) {
			List<Arret> results = new ArrayList<Arret>();
			Hits hits = getHits(this._themeDisplay.getCompanyGroupId());

			if (hits != null)
			{
				for (Document document : hits.getDocs())
				{
					Arret arret = ArretLocalServiceUtil.fetchArret(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
					if (arret != null)
					{
						results.add(arret);
					}
				}
			}
			this._arrets = results;
		}
		return this._arrets;
	}*/

	/**
	 * Retourne la liste des ids de categories sur lesquels la liste des arrêts
	 * est filtrée. Si l'utilisateur est un contributeur arrêt, on filtre
	 * toujours sur les catégories liées à l'utilisateur. Le front-end n'affiche
	 * que les catégories sur lesquels l'utilisateur a le droit de filtrer, on
	 * considère donc que getFilterCategories ne peut renvoyer que des
	 * catégories autorisées pour l'utilisateur
	 */

	/*public String getFilterCategoriesIds() throws PortalException {
		// Pas de filtre par l'utilisateur
		if (Validator.isNull(super.getFilterCategoriesIds())|| super.getFilterCategoriesIds().equals(","))
		{
			return this.getCategoriesIdsPermission();
		}
		else
		{
			return super.getFilterCategoriesIds();
		}
	}*/

	/**
	 * Retourne la liste des IDs des catégories que l'utilisateur peut voir
	 *
	 * @return
	 * @throws PortalException
	 */
	/*private String getCategoriesIdsPermission() throws PortalException {
		String categoriesIds = "";
		if (this.hasPermission("CONTRIBUTE")) {
			User user = _themeDisplay.getUser();
			AssetVocabulary placeTypeVocabulary = AssetVocabularyHelper
					.getGlobalVocabulary(VocabularyNames.PLACE_TYPE);
			if (placeTypeVocabulary != null) {
				long placeTypeVocabularyId = placeTypeVocabulary
						.getVocabularyId();
				List<AssetCategory> userCategories = AssetCategoryLocalServiceUtil
						.getCategories(User.class.getName(), user.getUserId());
				List<AssetCategory> userPlaceTypeCategories = userCategories
						.stream()
						.filter(c -> c.getVocabularyId() == placeTypeVocabularyId)
						.collect(Collectors.toList());

				for (AssetCategory category : userPlaceTypeCategories) {
					if (Validator.isNull(categoriesIds)) {
						categoriesIds += ",";
					}
					categoriesIds += String.valueOf(category.getCategoryId());
					categoriesIds += ",";
				}
			}
		}


		return categoriesIds;
	}*/
	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	/*public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
				this._themeDisplay.getCompanyGroupId(),
				StrasbourgPortletKeys.GTFS_BO, StrasbourgPortletKeys.GTFS_BO,
				actionId);
	}*/

	/**
	 * Retourne les Hits de recherche
	 */
	/*@Override
	protected Hits getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		Hits hits = SearchHelper.getBOSearchHits(searchContext,
				this.getSearchContainer().getStart(),
				this.getSearchContainer().getEnd(), Arret.class.getName(), groupId,
				this.getFilterCategoriesIds(), keywords,
				this.getOrderByColSearchField(),
				"desc".equals(this.getOrderByType()), BooleanClauseOccur.SHOULD);

		// Total
		int count = (int) SearchHelper.getBOSearchCount(searchContext,
				Arret.class.getName(), groupId,
				this.getFilterCategoriesIds(), keywords, BooleanClauseOccur.SHOULD);
		this.getSearchContainer().setTotal(count);

		// Dans le cas d'un contributeur lieu n'ayant pas de catégorie (l'admin peut tjrs tous les voir, même sans catégories)
		// Notes : pas utiliser pour le moment
//		if(!_themeDisplay.getPermissionChecker().isOmniadmin()  && this.getCategoriesIdsPermission().isEmpty())
//			return null;

		return hits;
	}*/

	/**
	 * Retourne les Hits de recherche en ignorant la pagination
	 */

	/*protected Hits getAllHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
				.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
				.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		Hits hits = SearchHelper.getBOSearchHits(searchContext,
				-1, -1, Arret.class.getName(), groupId,
				this.getFilterCategoriesIds(), keywords,
				this.getOrderByColSearchField(),
				"desc".equals(this.getOrderByType()), BooleanClauseOccur.SHOULD);

		// Total
		int count = (int) SearchHelper.getBOSearchCount(searchContext,
				Arret.class.getName(), groupId,
				this.getFilterCategoriesIds(), keywords, BooleanClauseOccur.SHOULD);
		this.getSearchContainer().setTotal(count);

		// Dans le cas d'un contributeur lieu n'ayant pas de catégorie (l'admin peut tjrs tous les voir, même sans catégories)
		// Notes : pas utiliser pour le moment
//		if(!_themeDisplay.getPermissionChecker().isOmniadmin()  && this.getCategoriesIdsPermission().isEmpty())
//			return null;

		return hits;
	}*/

    /**
     * Retourne le nom d'un utilisateur par son Id
     */
    public String getUserName(long userId) throws PortalException {
        User user = UserLocalServiceUtil.getUser(userId);
        if(Validator.isNotNull(user))
            return user.getFullName();

        return "";
    }

	/**
	 * Retourne le dropdownItemsProvider de l'arret
	 *
	 */
	@SuppressWarnings("unused")
	public ArretActionDropdownItemsProvider getActionsArret(Arret arret) {
		return new ArretActionDropdownItemsProvider(arret, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer
	 *
	 */
	@Override
	public SearchContainer<Arret> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/gtfs-bo-view-arrets.jsp")
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
				hits = getHits(_themeDisplay.getCompanyGroupId());
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<Arret> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								Arret arret = ArretLocalServiceUtil
										.fetchArret(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (arret != null) {
									results.add(arret);
								}
							}
						}

						return results;
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

	protected SearchContainer<Arret> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}
