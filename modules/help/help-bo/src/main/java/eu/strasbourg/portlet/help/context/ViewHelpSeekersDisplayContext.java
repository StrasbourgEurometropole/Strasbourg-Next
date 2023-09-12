package eu.strasbourg.portlet.help.context;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.url.builder.PortletURLBuilder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.help.util.SeekerHelpActionDropdownItemsProvider;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpRequestLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;



public class ViewHelpSeekersDisplayContext {

    private List<HelpSeeker> _helpSeekers;

    public ViewHelpSeekersDisplayContext(RenderRequest request, RenderResponse response) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request.getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
    }
    @SuppressWarnings("unused")
    public SeekerHelpActionDropdownItemsProvider getActionsHelpSeeker(ViewHelpSeekersDisplayContext.HelpSeeker helpSeeker) {
        return new SeekerHelpActionDropdownItemsProvider(helpSeeker, _request,
                _response);
    }
    /**
     * Retourne le searchContainer des help seekers
     *
     */
    public SearchContainer<HelpSeeker> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL;
            portletURL = PortletURLBuilder.createRenderURL(_response)

                    .setMVCPath("/help-bo-view-help-seekers.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setTabs1("helpSeekers")
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
                    .setParameter("tab","helpSeekers")
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
                        _helpSeekers = _helpSeekers.subList(start, end > total ? total : end);
                        return _helpSeekers;
                    }, _helpSeekers.size()
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
        if (_helpSeekers == null) {

            // Recuperation de toutes les requetes d'aide
            List<HelpRequest> helpRequests = HelpRequestLocalServiceUtil.getHelpRequests(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
            HashMap<String, HelpSeeker> helpSeekersMap =  new HashMap<>();
            HashSet<Long> studentImagesIds = new HashSet<>();

            for (HelpRequest helpRequest : helpRequests) {
                String helpSeekerId = helpRequest.getPublikId();
                // On a deja des requetes pour cet utilisateur
                if (helpSeekersMap.containsKey(helpSeekerId)) {
                    HelpSeeker seeker = helpSeekersMap.get(helpSeekerId);
                    // Mise a jour nbre requetes
                    seeker.incrementRequestsNumber();
                    // Mise a jour derniere requete en date si necessaire
                    seeker.updateRequest(helpRequest);
                    // Mise a jour nombre de justificatifs si necessaire
                    long studentCardImageId = helpRequest.getStudentCardImageId();
                    if (studentCardImageId > 0 && !studentImagesIds.contains(studentCardImageId)) {
                        seeker.incrementStudentImageCount();
                        studentImagesIds.add(studentCardImageId);
                    }
                }
                // Premiere requete trouvee de cet utilisateur
                else {
                    // Ajout dans la liste
                    HelpSeeker helpSeeker = new HelpSeeker(PublikUserLocalServiceUtil.getByPublikUserId(helpSeekerId),
                            helpRequest);
                    helpSeekersMap.put( helpSeekerId, helpSeeker);
                    long studentCardImageId = helpRequest.getStudentCardImageId();
                    if (studentCardImageId > 0) {
                        helpSeeker.incrementStudentImageCount();
                        studentImagesIds.add(studentCardImageId);
                    }
                }

            }
            // Tri par Keywords
            List<HelpSeeker> unfilteredHelpSeekers = new ArrayList<>(helpSeekersMap.values());

            // Ordonnancement (Date de derniere demande par defaut)
            List<HelpSeeker> unsortedHelpSeekers = getFilteredHelpSeekers(unfilteredHelpSeekers);
            Comparator<HelpSeeker> comp = this.getComparator();
            if (this.getOrderByType().equals("desc")) {
                _helpSeekers = ListUtil.sort(unsortedHelpSeekers, comp.reversed());
            }
            else {
                _helpSeekers = ListUtil.sort(unsortedHelpSeekers, comp);
            }
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


    private List<HelpSeeker> getFilteredHelpSeekers(List<HelpSeeker> unfilteredSeekers) {
        List<HelpSeeker> filteredResults;
        if (!this.getKeywords().equals("")) {
            filteredResults = new ArrayList<>();
            List<PublikUser> users = PublikUserLocalServiceUtil.getPublikUsers(
                    -1,
                    -1,
                    this.getKeywords(),
                    this.getOrderByColSearchField(),
                    "desc".equals(this.getOrderByType()));
            for (HelpSeeker seeker : unfilteredSeekers) {
                for (PublikUser user : users) {
                    if (seeker.getPublikUser().equals(user)) {
                        filteredResults.add(seeker);
                        break;
                    }
                }
            }
        }
        else {
            filteredResults = unfilteredSeekers;
        }
        return filteredResults;
    }

    private Comparator<HelpSeeker> getComparator() {
        Comparator<HelpSeeker> comparator;
        switch (this.getOrderByCol()) {
            case "last-name":
                comparator = (c1, c2) -> String.valueOf(c1.getPublikUser().getLastName())
                        .compareTo(c2.getPublikUser().getLastName());
                break;
            case "first-name":
                comparator = (c1, c2) -> String.valueOf(c1.getPublikUser().getFirstName())
                        .compareTo(c2.getPublikUser().getFirstName());
                break;
            case "email":
                comparator = (c1, c2) -> String.valueOf(c1.getPublikUser().getEmail())
                        .compareTo(c2.getPublikUser().getEmail());
                break;
            case "nb-requests":
                comparator = (c1, c2) -> Integer.valueOf(c1.getRequestsNumber())
                        .compareTo(c2.getRequestsNumber());
                break;
            default:
                comparator = (c1, c2) -> Long.valueOf(c1.getLastRequest().getCreateDate().getTime())
                        .compareTo(c2.getLastRequest().getCreateDate().getTime());
        }
        return comparator;
    }

    public String getCurrentURL() {
        return PortalUtil.getCurrentURL(this._request);
    }
    public String getPublikUserEditURL(String publikUserId) throws WindowStateException, PortletModeException {
        PortletURL myPortletURL = PortletURLFactoryUtil.create(this._request, StrasbourgPortletKeys.OIDC_BO,
                this._themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
        myPortletURL.setWindowState(WindowState.MAXIMIZED);
        myPortletURL.setPortletMode(PortletMode.VIEW);

        myPortletURL.setParameter("cmd", "editHelpSeeker");
        myPortletURL.setParameter("publikUserLiferayId", publikUserId);
        myPortletURL.setParameter("returnURL", PortalUtil.getCurrentURL(this._request));
        myPortletURL.setParameter("mvcPath", "/oidc-bo-edit-publikuser.jsp");

        return myPortletURL.toString();
    }

    /**
     * Renvoie le nom de la colonne sur laquelle on fait le tri pour demandeurs (PublikUser)
     */
    public String getOrderByColSearchField() {
        switch (this.getOrderByCol()) {
            case "first-name":
                return "firstName";
            case "email":
                return "email";
            default:
                return "lastName";
        }
    }
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    // Classe nested pour aggreger les donnees d'un user
    public class HelpSeeker {
        private PublikUser _user = null;
        private HelpRequest _lastRequest = null;
        private int _requestsNumber = 1;
        private int _studentIdImagesCount = 0;

        public HelpSeeker(PublikUser user, HelpRequest request) {
            _user = user;
            _lastRequest = request;
        }

        public void updateRequest(HelpRequest request) {
            if (request.getCreateDate().getTime() <
                    _lastRequest.getCreateDate().getTime()) {
                _lastRequest = request;
            }
        }

        public void incrementRequestsNumber() {
            _requestsNumber++;
        }

        public PublikUser getPublikUser() {
            return _user;
        }

        public HelpRequest getLastRequest() {
            return _lastRequest;
        }

        public int getRequestsNumber() {
            return _requestsNumber;
        }

        public String getImagesCount() { return LanguageUtil.get(Locale.FRANCE,
                "eu.help.delete.student.card.images") +" ("+_studentIdImagesCount+")"; }

        public void incrementStudentImageCount() {
            _studentIdImagesCount++;
        }
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
    public Class<HelpSeeker> getHelpSeekerClass() {
        return HelpSeeker.class;
    }
    
    protected SearchContainer<HelpSeeker> _searchContainer;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
}