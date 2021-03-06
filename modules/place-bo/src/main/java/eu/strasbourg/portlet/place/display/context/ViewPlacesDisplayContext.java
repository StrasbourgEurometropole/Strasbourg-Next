package eu.strasbourg.portlet.place.display.context;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.BooleanClauseOccur;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;
import eu.strasbourg.utils.display.context.ViewListBaseDisplayContext;

public class ViewPlacesDisplayContext
	extends ViewListBaseDisplayContext<Place> {

	public ViewPlacesDisplayContext(RenderRequest request,
		RenderResponse response) {
		super(Place.class, request, response);
	}

	public List<Place> getPlaces() throws PortalException {
		if (this._places == null) {
			List<Place> results = new ArrayList<Place>();

			// On essaye déjà de récupérer un lieu par id SIG
			Place place = PlaceLocalServiceUtil.getPlaceBySIGId(this.getKeywords());
			if (place != null) 
			{
				results.add(place);
			} 
			else 
			{ // Sinon recherche classique
				Hits hits = getHits(this._themeDisplay.getCompanyGroupId());

				if (hits != null) 
				{
					for (Document document : hits.getDocs()) 
					{
						place = PlaceLocalServiceUtil.fetchPlace(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
						if (place != null) 
						{
							results.add(place);
						}
					}
				}
			}
			this._places = results;
		}
		return this._places;
	}

	/**
	 * Retourne la liste des ids de categories sur lesquels la liste des lieux
	 * est filtrée. Si l'utilisateur est un contributeur lieu, on filtre
	 * toujours sur les catégories liées à l'utilisateur. Le front-end n'affiche
	 * que les catégories sur lesquels l'utilisateur a le droit de filtrer, on
	 * considère donc que getFilterCategories ne peut renvoyer que des
	 * catégories autorisées pour l'utilisateur
	 */
	@Override
	public String getFilterCategoriesIds() throws PortalException {
		// Pas de filtre par l'utilisateur
		if (Validator.isNull(super.getFilterCategoriesIds())|| super.getFilterCategoriesIds().equals(",")) 
		{
			return this.getCategoriesIdsPermission();
		} 
		else 
		{
			return super.getFilterCategoriesIds();
		}
	}

	/**
	 * Retourne la liste des IDs des catégories que l'utilisateur peut voir
	 * 
	 * @return
	 * @throws PortalException
	 */
	private String getCategoriesIdsPermission() throws PortalException {
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
	}
	

	
	/**
	 * Retourne les Hits de recherche
	 */
	@Override
	protected Hits getHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
			.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
			.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		Hits hits = SearchHelper.getBOSearchHits(searchContext,
			this.getSearchContainer().getStart(),
			this.getSearchContainer().getEnd(), Place.class.getName(), groupId,
			this.getFilterCategoriesIds(), keywords,
			this.getOrderByColSearchField(),
			"desc".equals(this.getOrderByType()), BooleanClauseOccur.SHOULD);

		// Total
		int count = (int) SearchHelper.getBOSearchCount(searchContext,
				Place.class.getName(), groupId,
			this.getFilterCategoriesIds(), keywords, BooleanClauseOccur.SHOULD);
		this.getSearchContainer().setTotal(count);
		
		// Dans le cas d'un contributeur lieu n'ayant pas de catégorie (l'admin peut tjrs tous les voir, même sans catégories)
		if(!_themeDisplay.getPermissionChecker().isOmniadmin()  && this.getCategoriesIdsPermission().isEmpty())
			return null;
		
		return hits;
	}


	/**
	 * Retourne les Hits de recherche en ignorant la pagination
	 */
	@Override
	protected Hits getAllHits(long groupId) throws PortalException {
		HttpServletRequest servletRequest = PortalUtil
			.getHttpServletRequest(_request);
		SearchContext searchContext = SearchContextFactory
			.getInstance(servletRequest);

		// Recherche des hits
		String keywords = ParamUtil.getString(servletRequest, "keywords");
		Hits hits = SearchHelper.getBOSearchHits(searchContext,
			-1, -1, Place.class.getName(), groupId,
			this.getFilterCategoriesIds(), keywords,
			this.getOrderByColSearchField(),
			"desc".equals(this.getOrderByType()), BooleanClauseOccur.SHOULD);

		// Total
		int count = (int) SearchHelper.getBOSearchCount(searchContext,
			Place.class.getName(), groupId,
			this.getFilterCategoriesIds(), keywords, BooleanClauseOccur.SHOULD);
		this.getSearchContainer().setTotal(count);

		// Dans le cas d'un contributeur lieu n'ayant pas de catégorie (l'admin peut tjrs tous les voir, même sans catégories)
		if(!_themeDisplay.getPermissionChecker().isOmniadmin()  && this.getCategoriesIdsPermission().isEmpty())
			return null;
		
		return hits;
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
			this._themeDisplay.getCompanyGroupId(),
			StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO,
			actionId);
	}

	private List<Place> _places;

}
