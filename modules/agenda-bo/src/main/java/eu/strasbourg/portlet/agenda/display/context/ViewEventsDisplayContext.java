package eu.strasbourg.portlet.agenda.display.context;

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
import eu.strasbourg.portlet.agenda.util.EventActionDropdownItemsProvider;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewEventsDisplayContext extends ViewBaseDisplayContext<Event> {

	public ViewEventsDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response, Event.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * Retourne le dropdownItemsProvider de l'event
	 *
	 * @return EventActionDropdownItemsProvider
	 */
	@SuppressWarnings("unused")
	public EventActionDropdownItemsProvider getActionsEvent(Event event) {
		return new EventActionDropdownItemsProvider(event, _request,
				_response);
	}

	/**
	 * Retourne le searchContainer des events
	 *
	 * @return SearchContainer<Event>
	 */
	@Override
	public SearchContainer<Event> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/agenda-bo-view-events.jsp")
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
						List<Event> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								Event event = EventLocalServiceUtil
										.fetchEvent(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (event != null) {
									results.add(event);
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
	public String getAllEventIds() throws PortalException {
		StringBuilder eventIds = new StringBuilder();
		for (Event event : this.getAllEvents()) {
			if (eventIds.length() > 0) {
				eventIds.append(",");
			}
			eventIds.append(event.getEventId());
		}
		return eventIds.toString();
	}

	/**
	 * Retourne la liste des événements correspondant à la recherche lancée en ignorant la pagination
	 */
	private List<Event> getAllEvents() throws PortalException {
		Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());
		
		// Création de la liste d'objet
		List<Event> results = new ArrayList<Event>();
		if (hits != null) {
			for (Document document : hits.getDocs()) {
				Event event = EventLocalServiceUtil.fetchEvent(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
				if (event != null) {
					results.add(event);
				}
			}
		}
		return results;
	}

	protected SearchContainer<Event> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;

}
