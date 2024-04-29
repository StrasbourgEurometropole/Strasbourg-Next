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
import eu.strasbourg.portlet.council.util.DeliberationsActionDropdownItemsProvider;
import eu.strasbourg.service.council.constants.StageDeliberation;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.service.DeliberationLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewDeliberationsDisplayContext extends ViewBaseDisplayContext<Deliberation> {

    public ViewDeliberationsDisplayContext(RenderRequest request, RenderResponse response, String filterCategories) {
        super(request, response, Deliberation.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _filterCategories = filterCategories;
        // Hack : forçage du delta du SearchContainer
        // TODO : Changer le ViewListBaseDisplayContext pour mettre en place la prise en compte du delta par default
        this.getSearchContainer().setDelta(100);

    }

    /**
     * Retourne le dropdownItemsProvider de l’entité
     *
     */
    @SuppressWarnings("unused")
    public DeliberationsActionDropdownItemsProvider getActionsDeliberations(Deliberation deliberation) {
        return new DeliberationsActionDropdownItemsProvider(deliberation, this._request,
                this._response);
    }

    /**
     * Retourne la liste des délibérations correspondant à la recherche lancée en ignorant la pagination
     */
    private List<Deliberation> getAllDeliberations() throws PortalException {
        Hits hits = getAllHits(this._themeDisplay.getCompanyGroupId());

        List<Deliberation> results = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Deliberation deliberation = DeliberationLocalServiceUtil
                        .fetchDeliberation(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (deliberation != null) {
                    results.add(deliberation);
                }
            }
        }
        return results;
    }

    /**
     * Retourne la liste des PK de toutes les délibérations
     * @return liste de PK (ex: "1,5,7,8")
     */
    @SuppressWarnings("unused")
    public String getAllDeliberationIds() throws PortalException {
        StringBuilder deliberationsIds = new StringBuilder();
        for (Deliberation deliberation : this.getAllDeliberations()) {
            if (deliberationsIds.length() > 0) {
                deliberationsIds.append(",");
            }
            deliberationsIds.append(deliberation.getDeliberationId());
        }
        return deliberationsIds.toString();
    }

    /**
     * Retourne le searchContainer des Deliberations
     *
     */
    @Override
    public SearchContainer<Deliberation> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/council-bo-view-deliberations.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","deliberations")
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
                        List<Deliberation> results = new ArrayList<Deliberation>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                Deliberation deliberation = DeliberationLocalServiceUtil.fetchDeliberation(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (deliberation != null) {
                                    results.add(deliberation);
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

    @Override
    public String getOrderByColSearchField() {
        switch (this.getOrderByCol()) {
            case "title":
            case "alias":
                return "localized_title_fr_FR_sortable";
            case "modified-date":
                return "modified_sortable";
            case "publication-date":
                return "publishDate_sortable";
            case "status":
                return "status_sortable";
            case "order":
                return "orderAmendement_String_sortable";
            default:
                return "modified_sortable";
        }
    }

    @Override
    public String getOrderByCol() {
        return ParamUtil.getString(this._request, "orderByCol",
                "order");
    }

    @Override
    public String getOrderByType() {
        return ParamUtil.getString(this._request, "orderByType", "asc");
    }


        @SuppressWarnings("unused")
    public String getStageDeliberationName(long id) {
        return StageDeliberation.get(id).getName();
    }

    /**
     * Class CSS de la couleur du Statut
     */
    @SuppressWarnings("unused")
    public String getCSSClass(Deliberation deliberation) {
        String cssClass="";
        if(deliberation.isAdopte()) {
            cssClass="green";
        } else if (deliberation.isRejete()) {
            cssClass="red";
        } else if (deliberation.isAffichageEnCours() || deliberation.isVoteOuvert()) {
            cssClass="focus-stage";
        }

        return cssClass;
    }

    /**
     * Récupère le String des Vocabulaire/catégorie/categId sur lesquels on doit filtrer
     *  qui se présente comme suit :
     * "vocabularyName__categoryName__categoryId___..."
     * Utilisé dans tous les render et action URL des JSP de listing qui ont un
     * filtre par vocabulaire pour le garder à chaque action
     */
    public String getFilterCategoriesIdByVocabulariesName() {
        return _filterCategories;
    }

    /**
     * Récupère et ajoute à la liste la categorie correspondant à aucun conseil sélectionné
     */
    /*private void addCategorieAucunConseilSelectionne(ThemeDisplay themeDisplay, List<AssetCategory> authorizedRootCategories) {

        long groupId = themeDisplay.getScopeGroupId();
        AssetCategory categoryAucunConseil = AssetVocabularyHelper.getCategory(CouncilConstants.NO_COUNCIL_CATEGORY_NAME, groupId);
        authorizedRootCategories.add(categoryAucunConseil);
    }*/

    private final RenderRequest _request;
    private final ThemeDisplay _themeDisplay;
    protected SearchContainer<Deliberation> _searchContainer;
    private final RenderResponse _response;
    private final String _filterCategories;
}
