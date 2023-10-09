package eu.strasbourg.portlet.project.display.context;

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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.project.util.SaisineObservatoireActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.Participation;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewSaisineObservatoireDisplayContext  extends ViewBaseDisplayContext<SaisineObservatoire> {

    public ViewSaisineObservatoireDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, SaisineObservatoire.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Retourne le dropdownItemsProvider de PROJECT
     *
     */
    @SuppressWarnings("unused")
    public SaisineObservatoireActionDropdownItemsProvider getActionsSaisineObservatoire(SaisineObservatoire saisineObservatoire) {
        return new SaisineObservatoireActionDropdownItemsProvider(saisineObservatoire, _request,
                _response);
    }

    /**
     * Retourne le searchContainer des Videos
     *
     * @return SearchContainer<video>
     */
    @Override
    public SearchContainer<SaisineObservatoire> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/project-bo-view-saisines-observatoire.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","saisines-observatoire")
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
                        List<SaisineObservatoire> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil
                                        .fetchSaisineObservatoire(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (saisineObservatoire != null) {
                                    results.add(saisineObservatoire);
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

    /**
     * Renvoie la colonne sur laquelle on fait le tri
     *
     * @return String
     */
    public String getOrderByCol() {
        return ParamUtil.getString(_request, "orderByCol", "modified-date");
    }

    private List<SaisineObservatoire> createObjectList(Hits hits) {
        // Création de la liste d'objet
        List<SaisineObservatoire> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                SaisineObservatoire saisineObservatoire = SaisineObservatoireLocalServiceUtil.fetchSaisineObservatoire(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (saisineObservatoire != null) {
                    results.add(saisineObservatoire);
                }
            }
        }
        return results;
    }

    /**
     * Retourne la liste des saisines observatoire correspondante à la recherche lancée en ignorant la pagination
     */
    private List<SaisineObservatoire> getAllSaisinesObservatoire() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        // Création de la liste d'objet
        return createObjectList(hits);
    }

    /**
     * Retourne la liste des PK de toutes les saisines observatoire
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllSaisineObservatoireIds() throws PortalException {
        StringBuilder saisineObservatoireIds = new StringBuilder();
        for (SaisineObservatoire saisineObservatoire : this.getAllSaisinesObservatoire()) {
            if (saisineObservatoireIds.length() > 0) {
                saisineObservatoireIds.append(",");
            }
            saisineObservatoireIds.append(saisineObservatoire.getSaisineObservatoireId());
        }
        return saisineObservatoireIds.toString();
    }


    protected SearchContainer<SaisineObservatoire> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;

    protected ThemeDisplay _themeDisplay;
}
