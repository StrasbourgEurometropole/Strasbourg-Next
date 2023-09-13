package eu.strasbourg.portlet.council.display.context;

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
import eu.strasbourg.portlet.council.util.TypesActionDropdownItemsProvider;
import eu.strasbourg.service.council.model.Type;
import eu.strasbourg.service.council.service.TypeLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewTypesDisplayContext extends ViewBaseDisplayContext<Type> {
    public ViewTypesDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, Type.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
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
    private List<Type> getAllTypes() {
        Hits hits;
        try {
            hits = getAllHits(this._themeDisplay.getCompanyGroupId());
        } catch (PortalException e) {
            throw new RuntimeException(e);
        }

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
     * Retourne la liste des PK de tous les types
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllTypeIds() {
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
    @Override
    public SearchContainer<Type> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-types.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","types")
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
                        List<Type> results = new ArrayList<Type>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                Type type = TypeLocalServiceUtil.fetchType(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (type != null) {
                                    results.add(type);
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
                return "title";
            default:
                return "modified_sortable";
        }
    }

    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    protected SearchContainer<Type> _searchContainer;

    private final RenderResponse _response;
}
