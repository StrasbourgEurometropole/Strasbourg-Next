package eu.strasbourg.portlet.agenda.csmap.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agenda.csmap.util.AgendaThematiqueActionDropdownItemsProvider;
import eu.strasbourg.service.csmap.model.Agenda;
import eu.strasbourg.service.csmap.service.AgendaLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewCsmapAgendaThematiqueDisplayContext extends ViewBaseDisplayContext<Agenda> {

    private List<Agenda> _agendas;

    public ViewCsmapAgendaThematiqueDisplayContext(RenderRequest request,
                                                   RenderResponse response) {
        super(request, response, Agenda.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Retourne le dropdownItemsProvider de l’entité
     */
    @SuppressWarnings("unused")
    public AgendaThematiqueActionDropdownItemsProvider getActionsAgendaThematique(Agenda agenda) {
        return new AgendaThematiqueActionDropdownItemsProvider(agenda, this._request,
                this._response);
    }

    /**
     * Class CSS de la couleur du Statut
     */
    @SuppressWarnings("unused")
    public String getCSSClass(Boolean isActif) {
        String cssClass="red";
        if(isActif) {
            cssClass="green";
        }

        return cssClass;
    }

    /**
     * Retourne le searchContainer
     *
     */
    @Override
    public SearchContainer<Agenda> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/csmap-bo-agenda-view-thematiques.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","agendaThematique")
                    .setParameter("filterCategoriesIdByVocabulariesName", getFilterCategoriesIdByVocabulariesName())
                    .buildPortletURL();
            _searchContainer = new SearchContainer<>(_request, null, null,
                    SearchContainer.DEFAULT_CUR_PARAM, SearchContainer.DEFAULT_DELTA, portletURL, null, "no-entries-were-found");
            _searchContainer.setEmptyResultsMessageCssClass(
                    "taglib-empty-result-message-header-has-plus-btn");
            _searchContainer.setOrderByColParam("orderByCol");
            _searchContainer.setOrderByTypeParam("orderByType");

            try {
                getHits();
            } catch (PortalException e) {
                throw new RuntimeException(e);
            }
            _searchContainer.setResultsAndTotal(

                    () -> {
                        // Création de la liste d'objet
                        int start = this._searchContainer.getStart();
                        int end = this._searchContainer.getEnd();
                        int total = this._searchContainer.getTotal();
                        _agendas= _agendas.subList(start, end > total ? total : end);
                        return _agendas;

                    },_agendas.size()

            );
        }
        _searchContainer.setRowChecker(
                new EmptyOnClickRowChecker(_response));

        return _searchContainer;
    }
    /**
     * Retourne les Hits de recherche pour un delta
     */
    private void getHits() throws PortalException {
        this._agendas = new ArrayList<>(AgendaLocalServiceUtil.getAgendasThematiqueInactif());
        Agenda agendaActif = AgendaLocalServiceUtil.getAgendaThematiqueActif();
        if(Validator.isNotNull(agendaActif))
            this._agendas.add(0, agendaActif);
    }

    protected SearchContainer<Agenda> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
}
