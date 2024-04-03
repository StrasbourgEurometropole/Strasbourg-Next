package eu.strasbourg.portlet.oidc.display.context;

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
import eu.strasbourg.service.oidc.model.AnonymisationHistoric;
import eu.strasbourg.service.oidc.service.AnonymisationHistoricLocalServiceUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewAnonymisationHistoricsDisplayContext extends ViewBaseDisplayContext<AnonymisationHistoric> {

	public ViewAnonymisationHistoricsDisplayContext(RenderRequest request,
                                                    RenderResponse response) {
		super(request, response, AnonymisationHistoric.class);
		_request = request;
		_response = response;
		_themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
	}

	/**
	 * @return True si on peut faire l'anonymisation
	 */
	@SuppressWarnings("unused")
	public boolean canAnonymise() {
		return Boolean.parseBoolean(StrasbourgPropsUtil.getAnonymisationActivated());
	}

	@Override
	public SearchContainer<AnonymisationHistoric> getSearchContainer() {

		if (_searchContainer == null) {

			PortletURL portletURL;
			portletURL = PortletURLBuilder.createRenderURL(_response)
					.setMVCPath("/oidc-bo-view-anonymisation-historics.jsp")
					.setKeywords(ParamUtil.getString(_request, "keywords"))
					.setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
					.setParameter("tab", "anonymisationHistorics")
					.buildPortletURL();
			_searchContainer = new SearchContainer<>(_request, null, null,
					SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
			_searchContainer.setEmptyResultsMessageCssClass(
					"taglib-empty-result-message-header-has-plus-btn");
			Hits hits;
			try {
				hits = getHits(this._themeDisplay.getCompanyGroupId());

			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			_searchContainer.setResultsAndTotal(
					() -> {
						// Création de la liste d'objet
						List<AnonymisationHistoric> results = new ArrayList<>();
						if (hits != null) {
							for (Document document : hits.getDocs()) {
								AnonymisationHistoric anonymisationHistoric = AnonymisationHistoricLocalServiceUtil
										.fetchAnonymisationHistoric(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
								if (anonymisationHistoric != null) {
									results.add(anonymisationHistoric);
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

	protected SearchContainer<AnonymisationHistoric> _searchContainer;
	private final RenderRequest _request;
	private final RenderResponse _response;
	protected ThemeDisplay _themeDisplay;
}
