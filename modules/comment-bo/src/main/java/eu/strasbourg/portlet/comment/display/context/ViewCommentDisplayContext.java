package eu.strasbourg.portlet.comment.display.context;

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
import eu.strasbourg.portlet.comment.util.CommentActionDropdownItemsProvider;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.utils.SearchHelper;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class ViewCommentDisplayContext {

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());



    public ViewCommentDisplayContext(RenderRequest request, RenderResponse response) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
    }

    @SuppressWarnings("unused")
    public String getAllCommentIds() throws PortalException {
        StringBuilder commentIds = new StringBuilder();
        for (Comment comment : this.getComments()) {
            if (commentIds.length() > 0) {
                commentIds.append(",");
            }
            commentIds.append(comment.getCommentId());
        }
        return commentIds.toString();
    }

    public List<Comment> getComments() throws PortalException {

        if (this._comments == null) {
            Hits hits = getAllHits(this._themeDisplay.getScopeGroupId());
            //Création de la liste d'objet
            this._comments = populateComments(hits);
        }
        return this._comments;
    }

    private Hits getAllHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil
                .getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory
                .getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");

        return SearchHelper.getBOSearchHits(searchContext,
                -1, -1, Comment.class.getName(), groupId,
                new ArrayList<>(), keywords,
                getOrderByColSearchField(),
                "desc".equals(getOrderByType()));
    }

    /**
     * Retourne le dropdownItemsProvider de commentaire
     *
     * @return CommentActionDropdownItemsProvider
     */
    @SuppressWarnings("unused")
    public CommentActionDropdownItemsProvider getActionsComment(Comment comment) {
        return new CommentActionDropdownItemsProvider(comment, _request,
                _response);
    }



    private List<Comment> populateComments(Hits hits) {
        List<Comment> results = new ArrayList<>();
        if (hits != null) {
            for (Document document :
                    hits.getDocs()) {
                Comment comment = CommentLocalServiceUtil.fetchComment(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (comment != null) {

                    results.add(comment);
                }
            }
        }
        return results;
    }

    /**
     * Retourne le searchContainer des commentaires
     *
     * @return SearchContainer<Comment>
     */
    public SearchContainer<Comment> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/comment-bo-view-comments.jsp")
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
                        List<Comment> results = new ArrayList<>();
                        if (_hits != null) {
                            for (Document document : _hits.getDocs()) {
                                Comment comment = CommentLocalServiceUtil.fetchComment(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (comment!= null)
                                    results.add(comment);
                            }
                        }

                        return results;
                    }, _hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
        return _searchContainer;
    }

    /**
     * Retourne les Hits de recherche pour un delta
     */
    private void getHits(long groupId) throws PortalException {
        HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(_request);
        SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

        // Recherche des hits
        String keywords = ParamUtil.getString(servletRequest, "keywords");
        _hits = SearchHelper.getBOSearchHits(searchContext,
                getSearchContainer().getStart(),
                getSearchContainer().getEnd(), Comment.class.getName(), groupId,
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
            case "userName":
                return "userName_String_sortable";
            case "reportings":
                return "reportings";
            case "status":
                return "entityType";
            case "entityType_String_sortable":
                return "entityType_String_sortable";
            case "entityName":
                return "entityName_String_sortable";
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


    private Hits _hits;
    protected SearchContainer<Comment> _searchContainer;
    private String _keywords;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private List<Comment> _comments;

}
