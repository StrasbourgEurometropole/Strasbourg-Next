package eu.strasbourg.portlet.help.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.util.RequestHelpActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;


public class ViewHelpRequestsDisplayContext extends ViewBaseDisplayContext<HelpRequest> {

    private HashMap<String, Integer> _studentImagesCount;

    public ViewHelpRequestsDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, HelpRequest.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
    }

    /**
     * Retourne le dropdownItemsProvider
     *
     */
    @SuppressWarnings("unused")
    public RequestHelpActionDropdownItemsProvider getActionsHelpRequest(HelpRequest helpRequest) {
        return new RequestHelpActionDropdownItemsProvider(helpRequest, _request,
                _response);
    }

    /**
     * Retourne le searchContainer des help Request
     *
     */
    @Override
    public SearchContainer<HelpRequest> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/help-bo-view-help-requests.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","helpRequests")
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
                        List<HelpRequest> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                HelpRequest helpRequest = HelpRequestLocalServiceUtil.fetchHelpRequest(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (helpRequest != null) {
                                    results.add(helpRequest);
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
    public String getCurrentURL() {
        return PortalUtil.getCurrentURL(this._request);
    }

    /*public String getPublikUserEditURL(String publikUserId) throws WindowStateException, PortletModeException {
        PortletURL myPortletURL = PortletURLFactoryUtil.create(this._request, StrasbourgPortletKeys.OIDC_BO,
                this._themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
        myPortletURL.setWindowState(WindowState.MAXIMIZED);
        myPortletURL.setPortletMode(PortletMode.VIEW);

        myPortletURL.setParameter(HelpBOConstants.PARAM_CMD, HelpBOConstants.PARAM_EDIT_PUBLIK_USER);
        myPortletURL.setParameter(HelpBOConstants.PARAM_PUBLIK_ID, publikUserId);
        myPortletURL.setParameter(HelpBOConstants.PARAM_RETURN_URL, PortalUtil.getCurrentURL(this._request));
        myPortletURL.setParameter(HelpBOConstants.PARAM_MVC_PATH, HelpBOConstants.URL_OIDC_EDIT_USER);

        return myPortletURL.toString();
    }*/


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
            case "create-date":
                return "createDate_sortable";
            default:
                return "createDate_sortable";
        }
    }

    @SuppressWarnings("unused")
    public String getImagesCount(String publikId) {
        if (_studentImagesCount == null) {
            _studentImagesCount = new HashMap<>();
            // Recuperation de toutes les requetes d'aide
            List<HelpRequest> helpRequests = HelpRequestLocalServiceUtil.getHelpRequests(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            HashSet<Long> studentImagesIds = new HashSet<>();

            for (HelpRequest helpRequest : helpRequests) {
                String helpSeekerId = helpRequest.getPublikId();
                // On a deja des requetes pour cet utilisateur
                if (_studentImagesCount.containsKey(helpSeekerId)) {
                    int seeker_count = this._studentImagesCount.get(helpSeekerId);
                    // Mise a jour nombre de justificatifs si necessaire
                    long studentCardImageId = helpRequest.getStudentCardImageId();
                    if (studentCardImageId > 0 && !studentImagesIds.contains(studentCardImageId)) {
                        this._studentImagesCount.put(helpSeekerId, seeker_count + 1);
                        studentImagesIds.add(studentCardImageId);
                    }
                }
                // Premiere requete trouvee de cet utilisateur
                else {
                    // Ajout dans la liste
                    _studentImagesCount.put(helpSeekerId, 0);
                    long studentCardImageId = helpRequest.getStudentCardImageId();
                    if (studentCardImageId > 0) {
                        this._studentImagesCount.put(helpSeekerId, 1);
                        studentImagesIds.add(studentCardImageId);
                    }
                }

            }
        }
        return LanguageUtil.get(Locale.FRANCE,
            "eu.help.delete.student.card.images") +" ("+_studentImagesCount.get(publikId)+")";
    }

    protected SearchContainer<HelpRequest> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
}