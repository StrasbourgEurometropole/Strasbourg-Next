package eu.strasbourg.portlet.comment.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * @author alexandre.quere
 */

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.COMMENT_BO,
                "mvc.command.name=selectionAction"
        },
        service = MVCActionCommand.class
)
public class SelectionActionCommand implements MVCActionCommand{

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private CommentLocalService commentLocalService;

    @Reference(unbind = "-")
    protected void setCommentLocalService(
            CommentLocalService commentLocalService) {

        this.commentLocalService = commentLocalService;
    }

    @Override
    public boolean processAction(ActionRequest actionRequest,
                                 ActionResponse actionResponse) throws PortletException {
        long[] selectionIds = ParamUtil.getLongValues(actionRequest, "rowIds");

        for (long entryId : selectionIds) {
            try {
                Comment comment = commentLocalService
                        .getComment(entryId);
                switch (ParamUtil.getString(actionRequest, "cmd")) {
                    case "delete":
                        commentLocalService.removeComment(entryId);
                        break;
                    case "publish":
                        commentLocalService.updateStatus(
                                comment,
                                WorkflowConstants.STATUS_APPROVED);
                        break;
                    case "unpublish":
                        commentLocalService.updateStatus(
                                comment,
                                WorkflowConstants.STATUS_DRAFT);
                        break;
                }
            } catch (PortalException e) {
                _log.error(e);
            }
        }
        return false;
    }
}
