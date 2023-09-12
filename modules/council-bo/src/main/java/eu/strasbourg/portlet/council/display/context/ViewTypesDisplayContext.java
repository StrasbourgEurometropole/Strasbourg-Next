package eu.strasbourg.portlet.council.display.context;

import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.council.util.TypesActionDropdownItemsProvider;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.TypeLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewTypesDisplayContext {



    public ViewTypesDisplayContext(RenderRequest request, RenderResponse response) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
    }
    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     */
    @SuppressWarnings("unused")
    public TypesActionDropdownItemsProvider getActionsTypes(Type type) {
        return new TypesActionDropdownItemsProvider(type, this._request,
                this._response);
    }
    /**
     * Retourne la liste des types correspondant à la recherche lancée en ignorant la pagination
     */
    private List<Type> getAllTypes() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        List<Type> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Type type = TypeLocalServiceUtil
                        .fetchType(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (type != null) {
                    results.add(type);
                }
            }
        }
        return results;
    }

    /**
     * Retourne tous les Hits de recherche
     */
    private Hits getAllHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil
                .getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory
                .getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");

        return SearchHelper.getBOSearchHits(searchContext,
                -1, -1, Type.class.getName(), groupId,
                new ArrayList<>(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    /**
     * Retourne la liste des PK de tous les types
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllTypeIds() throws PortalException {
        StringBuilder typesIds = new StringBuilder();
        for (Type type : this.getAllTypes()) {
            if (typesIds.length() > 0) {
                typesIds.append(",");
            }
            typesIds.append(type.getTypeId());
        }
        return typesIds.toString();
    }
    /**
     * Retourne le searchContainer des types
     *
     */
    public SearchContainer<Type> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-types.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","types")
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
                        List<Type> results = new ArrayList<Type>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                Type type = TypeLocalServiceUtil.fetchType(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (type != null) {
                                    results.add(type);
                                }
                            }
                        }
                        return results;
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
                getSearchContainer().getEnd(), Type.class.getName(), groupId,
                new ArrayList<>(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
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
                return "title";
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

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private Hits _hits;
    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    private List<Type> types;
    protected SearchContainer<Type> _searchContainer;

    private final RenderResponse _response;
    private final HttpServletRequest _httpServletRequest;
    private String _keywords;

}
