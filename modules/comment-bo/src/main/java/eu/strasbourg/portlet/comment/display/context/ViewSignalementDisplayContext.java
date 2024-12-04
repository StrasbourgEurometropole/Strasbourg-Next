package eu.strasbourg.portlet.comment.display.context;

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
import eu.strasbourg.service.comment.model.Signalement;
import eu.strasbourg.service.comment.service.SignalementLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexandre.quere
 */
public class ViewSignalementDisplayContext extends ViewBaseDisplayContext<Signalement> {

    @SuppressWarnings("unused")
    public List<Signalement> getSignalements() {
        if (_signalements == null) {
            this._signalements = populateSignalements(_hits);
        }
        return _signalements;
    }

    public ViewSignalementDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, Signalement.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Méthode permettant la création de liste d'objets.
     * @param hits les hits d'elastic search
     * @return la liste d'objet.
     */
    private List<Signalement> populateSignalements(Hits hits) {
        List<Signalement> results = new ArrayList<>();
        if (hits != null) {
            for (Document document :
                    hits.getDocs()) {
                long id = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));
                Signalement signalement = SignalementLocalServiceUtil.fetchSignalement(id);
                if (signalement != null) {

                    results.add(signalement);
                }
            }
        }
        return results;
    }

    public String getOrderByColSearchField() {
        switch (getOrderByCol()) {
            case "userName":
                return "userName_String_sortable";
            case "reportType":
                return "reportType_String_sortable";
            case "modified-date":
                return "modified_sortable";
            case "reporting-date":
            default:
                return "createDate_sortable";
        }
    }

    /**
     * Retourne le searchContainer des commentaires
     *
     * @return SearchContainer<Comment>
     */
    @Override
    public SearchContainer<Signalement> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/comment-bo-view-signalements.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","reportings")
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
                        List<Signalement> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                Signalement signalement = SignalementLocalServiceUtil.fetchSignalement(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (signalement!= null)
                                    results.add(signalement);
                            }
                        }

                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }

    protected SearchContainer<Signalement> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private List<Signalement> _signalements;
}
