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
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.project.util.BudgetParticipatifsActionDropdownItemsProvider;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author alexandre.quere
 */
public class ViewBudgetParticipatifDisplayContext extends ViewBaseDisplayContext<BudgetParticipatif> {


    public ViewBudgetParticipatifDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, BudgetParticipatif.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Retourne le dropdownItemsProvider de budgetParticipatif
     *
     */
    @SuppressWarnings("unused")
    public BudgetParticipatifsActionDropdownItemsProvider getActionsBudgetParticipatif(BudgetParticipatif budgetParticipatif) {
        return new BudgetParticipatifsActionDropdownItemsProvider(budgetParticipatif, _request,
                _response);
    }

    private List<BudgetParticipatif> createObjectList(Hits hits) {
        //création de la liste d'objet
        List<BudgetParticipatif> results = new ArrayList<>();
        if (hits != null){
            for (Document document : hits.getDocs()){
                BudgetParticipatif budget = BudgetParticipatifLocalServiceUtil.fetchBudgetParticipatif(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (budget != null)
                    results.add(budget);
            }
        }
        return results;
    }

    /**
     * Retourne la liste des PK de tous les budgets
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getBudgetParticipatifIds() throws PortalException {
        StringBuilder budgetIds = new StringBuilder();
        for (BudgetParticipatif budgetParticipatif : this.createObjectList(_hits)) {
            if (budgetIds.length() > 0) {
                budgetIds.append(",");
            }
            budgetIds.append(budgetParticipatif.getBudgetParticipatifId());
        }
        return budgetIds.toString();
    }

    /**
     * Retourne le searchContainer des Budget Participatifs
     *
     */
    @Override
    public SearchContainer<BudgetParticipatif> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/project-bo-view-budgets-participatifs.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab", "budgets-participatifs")
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
                        List<BudgetParticipatif> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                BudgetParticipatif budgetParticipatif = BudgetParticipatifLocalServiceUtil
                                        .fetchBudgetParticipatif(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (budgetParticipatif != null) {
                                    results.add(budgetParticipatif);
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

    protected SearchContainer<BudgetParticipatif> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
}
