package eu.strasbourg.portlet.comment.display.context;

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
import eu.strasbourg.portlet.comment.util.CommentActionDropdownItemsProvider;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.utils.display.context.ViewBaseDisplayContext;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;

public class ViewCommentDisplayContext extends ViewBaseDisplayContext<Comment> {

    public ViewCommentDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response, Comment.class);
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
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
    @Override
    public SearchContainer<Comment> getSearchContainer() {

        if (_searchContainer == null) {

            PortletURL portletURL = PortletURLBuilder.createRenderURL(_response)
                    .setMVCPath("/comment-bo-view-comments.jsp")
                    .setKeywords(ParamUtil.getString(_request, "keywords"))
                    .setParameter("delta", String.valueOf(SearchContainer.DEFAULT_DELTA))
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
                        List<Comment> results = new ArrayList<>();
                        if (hits != null) {
                            for (Document document : hits.getDocs()) {
                                Comment comment = CommentLocalServiceUtil.fetchComment(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                                if (comment!= null)
                                    results.add(comment);
                            }
                        }

                        return results;
                    }, hits.getLength()
            );
        }
        _searchContainer.setRowChecker(new EmptyOnClickRowChecker(_response));
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

    protected SearchContainer<Comment> _searchContainer;
    private final RenderRequest _request;
    private final RenderResponse _response;
    protected ThemeDisplay _themeDisplay;
    private List<Comment> _comments;

}
