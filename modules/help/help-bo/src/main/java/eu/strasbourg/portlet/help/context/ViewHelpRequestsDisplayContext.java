package eu.strasbourg.portlet.help.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.search.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.portlet.help.constants.HelpBOConstants;
import eu.strasbourg.portlet.help.util.RequestHelpActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.*;
import javax.servlet.http.HttpServletRequest;
import java.util.*;


public class ViewHelpRequestsDisplayContext  {

    private List<HelpRequest> _helpRequests;
    private HashMap<String, Integer> _studentImagesCount;

    public ViewHelpRequestsDisplayContext(RenderRequest request, RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector = itemSelector;
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
    public SearchContainer<HelpRequest> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/help-bo-view-help-requests.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
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
                        List<HelpRequest> results = new ArrayList<>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                HelpRequest helpRequest = HelpRequestLocalServiceUtil.fetchHelpRequest(
                                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (helpRequest != null) {
                                    results.add(helpRequest);
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
                getSearchContainer().getEnd(), HelpRequest.class.getName(), groupId,
                "", keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }
    public String getOrderByType() {
        return ParamUtil.getString(_request, "orderByType", "desc");
    }
    public boolean hasVocabulary(String vocabularyName){
        return getCategVocabularies().containsKey(vocabularyName);
    }

    public Map<String, String> getCategVocabularies() {
        if (_categVocabularies == null) {
            _categVocabularies = new HashMap<>();
            _categVocabularies.put("vocabulary1", ParamUtil.getString(
                    _httpServletRequest, "vocabulary1", ""));
        }

        return _categVocabularies;
    }


    public String getCurrentURL() {
        return PortalUtil.getCurrentURL(this._request);
    }

    public String getPublikUserEditURL(String publikUserId) throws WindowStateException, PortletModeException {
        PortletURL myPortletURL = PortletURLFactoryUtil.create(this._request, StrasbourgPortletKeys.OIDC_BO,
                this._themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
        myPortletURL.setWindowState(WindowState.MAXIMIZED);
        myPortletURL.setPortletMode(PortletMode.VIEW);

        myPortletURL.setParameter(HelpBOConstants.PARAM_CMD, HelpBOConstants.PARAM_EDIT_PUBLIK_USER);
        myPortletURL.setParameter(HelpBOConstants.PARAM_PUBLIK_ID, publikUserId);
        myPortletURL.setParameter(HelpBOConstants.PARAM_RETURN_URL, PortalUtil.getCurrentURL(this._request));
        myPortletURL.setParameter(HelpBOConstants.PARAM_MVC_PATH, HelpBOConstants.URL_OIDC_EDIT_USER);

        return myPortletURL.toString();
    }


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
    public String getOrderByCol() {
        return ParamUtil.getString(_request, "orderByCol", "modified-date");
    }
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
            "eu.help.delete.student.card.images") +" ("+_studentImagesCount.get(publikId)+")"; }

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
    private Hits _hits;
    protected SearchContainer<HelpRequest> _searchContainer;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;

    private Map<String, String> _categVocabularies;

}