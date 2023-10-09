package eu.strasbourg.portlet.video.display.context;

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
import eu.strasbourg.portlet.video.util.VideoActionDropdownItemsProvider;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewVideosDisplayContext extends ViewBaseDisplayContext<Video> {
	public ViewVideosDisplayContext(RenderRequest request,
									RenderResponse response) {
		super(request, response, Video.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider vidéo
	 *
	 * @return VideoActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public VideoActionDropdownItemsProvider getActionsVideo(Video video) {
		return new VideoActionDropdownItemsProvider(video, _request,
				_response);
	}

	/**
	 * Retourne le dropdownItemsProvider de Video
	 *
	 * @return VideoActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public VideoActionDropdownItemsProvider getActionsEvent(Video video) {
		return new VideoActionDropdownItemsProvider(video, _request,
				_response);
	}
	/**
	 * Retourne le searchContainer des Videos
	 *
	 * @return SearchContainer<video>
	 */
	@Override
	public SearchContainer<Video> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/video-bo-view-videos.jsp")
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
						List<Video> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								Video video = VideoLocalServiceUtil
										.fetchVideo(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (video != null) {
									results.add(video);
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
	public String getAllVideoIds() throws PortalException {
		StringBuilder videoIds = new StringBuilder();
		for (Video video : this.getAllVideos()) {
			if (videoIds.length() > 0) {
				videoIds.append(",");
			}
			videoIds.append(video.getVideoId());
		}
		return videoIds.toString();
	}

	/**
	 * Retourne la liste des videos correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<Video> getAllVideos() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

		// Création de la liste d'objet
		List<Video> results = new ArrayList<Video>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				Video video = VideoLocalServiceUtil.fetchVideo(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (video != null) {
					results.add(video);
				}
			}
		}
		return results;
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
			this._themeDisplay.getScopeGroupId(),
			StrasbourgPortletKeys.VIDEO_BO, StrasbourgPortletKeys.VIDEO_BO,
			actionId);
	}

	protected SearchContainer<Video> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}


