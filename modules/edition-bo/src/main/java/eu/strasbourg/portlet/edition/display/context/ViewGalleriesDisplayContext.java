package eu.strasbourg.portlet.edition.display.context;

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
import eu.strasbourg.portlet.edition.util.GalleryActionDropdownItemsProvider;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionGalleryLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewGalleriesDisplayContext extends ViewBaseDisplayContext<EditionGallery> {

	public ViewGalleriesDisplayContext(RenderRequest request,
									  RenderResponse response) {
		super(request, response, EditionGallery.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de gallery
	 *
	 * @return GalleryActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public GalleryActionDropdownItemsProvider getActionsGallery(EditionGallery gallery) {
		return new GalleryActionDropdownItemsProvider(gallery, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des galleries
	 *
	 * @return SearchContainer<Edition>
	 */
	@Override
	public SearchContainer<EditionGallery> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/edition-bo-view-galleries.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab","galleries")
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
						List<EditionGallery> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								EditionGallery gallery = EditionGalleryLocalServiceUtil
										.fetchEditionGallery(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (gallery != null) {
									results.add(gallery);
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

	@SuppressWarnings("unused")
	public String getAllGalleryIds() throws PortalException {
		StringBuilder galleryIds = new StringBuilder();
		for (EditionGallery gallery : this.getAllGalleries()) {
			if (galleryIds.length() > 0) {
				galleryIds.append(",");
			}
			galleryIds.append(gallery.getGalleryId());
		}
		return galleryIds.toString();
	}

	/**
	 * Retourne la liste des galleries correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<EditionGallery> getAllGalleries() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		List<EditionGallery> results = new ArrayList<EditionGallery>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				EditionGallery gallery = EditionGalleryLocalServiceUtil.fetchEditionGallery(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (gallery != null) {
					results.add(gallery);
				}
			}
		}
		return results;
	}

	protected SearchContainer<EditionGallery> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}
