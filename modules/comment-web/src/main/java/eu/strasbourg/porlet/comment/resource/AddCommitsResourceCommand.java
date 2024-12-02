package eu.strasbourg.porlet.comment.resource;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

@Component(
    immediate = true,
    property = {
    	"javax.portlet.name=" + StrasbourgPortletKeys.COMMENT_WEB,
    	"mvc.command.name=addComments"
    },
    service = MVCResourceCommand.class
)
public class AddCommitsResourceCommand implements MVCResourceCommand {

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    private ResourceBundle bundle = ResourceBundleUtil.getBundle("content.Language",
            this.getClass().getClassLoader());
	
	@Override
	public boolean serveResource(ResourceRequest request, ResourceResponse response) {
        Boolean result = true;
        int start = ParamUtil.getInteger(request, "start");
        int entryID = ParamUtil.getInteger(request, "entryID");
        String orderBy = ParamUtil.getString(request, "orderBy");

        // On réupère les commentaires publiés de l'entité triés par date
        List<Comment> comments = _commentLocalService.getByAssetEntryAndLevelOrderByDate(entryID, 1,
                WorkflowConstants.STATUS_APPROVED, start, (start + 20), orderBy.equals("asc"));

        // Retour des informations de la requete en JSON
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        jsonResponse.put("displayResult", start + comments.size());

        try {
            JSONArray jsonComments = JSONFactoryUtil.createJSONArray();
            for (Comment comment : comments) {
                JSONObject jsonComment = JSONFactoryUtil.createJSONObject();
                jsonComment.put("commentId", comment.getCommentId());
                jsonComment.put("imageURLOrSurrogate", comment.getPublikUser().getImageURLOrSurrogate());
                jsonComment.put("publikUserName", comment.getPublikUserName());
                jsonComment.put("userQuality", comment.getUserQuality());
                // date de créatione (dd MMM yyyy)
                DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat("DD MMM YYYY");
                jsonComment.put("createDate", dateFormat.format(comment.getCreateDate()));
                jsonComment.put("groupId", comment.getGroupId());
                jsonComment.put("nbLikes", comment.getNbLikes());
                jsonComment.put("nbDislikes", comment.getNbDislikes());
                jsonComment.put("publikId", comment.getPublikId());
                jsonComment.put("text", comment.getText(Locale.FRANCE));
                // date de modification (dd MMMM yyyy)
                DateFormat date2Format = DateFormatFactoryUtil.getSimpleDateFormat("dd MMMM yyyy");
                // heure de modification (HH:mm:ss)
                DateFormat timeFormat = DateFormatFactoryUtil.getSimpleDateFormat("HH:mm:ss");
                if(Validator.isNotNull(comment.getModifiedByUserDate())) {
                    jsonComment.put("modifiedByUserDate", date2Format.format(comment.getModifiedByUserDate()));
                    jsonComment.put("modifiedByUserHour", timeFormat.format(comment.getModifiedByUserDate()));
                }
                JSONArray jsonChilds = JSONFactoryUtil.createJSONArray();
                for (Comment commentChild : comment.getApprovedChildComments()) {
                    JSONObject jsonChild = JSONFactoryUtil.createJSONObject();
                    jsonChild.put("commentId", commentChild.getCommentId());
                    jsonChild.put("publikId", commentChild.getPublikId());
                    jsonChild.put("publikUserName", commentChild.getPublikUserName());
                    jsonChild.put("createDate", dateFormat.format(commentChild.getCreateDate()));
                    jsonChild.put("imageURLOrSurrogate", commentChild.getPublikUser().getImageURLOrSurrogate());
                    jsonChild.put("text", commentChild.getText(Locale.FRANCE));
                    if(Validator.isNotNull(commentChild.getModifiedByUserDate())) {
                        jsonChild.put("modifiedByUserDate", date2Format.format(commentChild.getModifiedByUserDate()));
                        jsonChild.put("modifiedByUserHour", timeFormat.format(commentChild.getModifiedByUserDate()));
                    }
                    jsonChilds.put(jsonChild);
                }
                jsonComment.put("approvedChildComments", jsonChilds);
                jsonComments.put(jsonComment);
            }
            jsonResponse.put("comments", jsonComments);
        }catch (Exception e){
            _log.error(e.getMessage(), e);
            e.getStackTrace();
        }

        // Recuperation de l'élément d'écriture de la réponse
        PrintWriter writer;
        try {
            writer = response.getWriter();
            writer.print(jsonResponse.toString());
        } catch (IOException e) {
            _log.error("erreur dans l'enregistrement de la proposition d'aide : ", e);
        }
        return result;
	}

    @Reference(unbind = "-")
    protected void setCommentLocalService(CommentLocalService commentLocalService) {
        _commentLocalService = commentLocalService;
    }

    private CommentLocalService _commentLocalService;

}
