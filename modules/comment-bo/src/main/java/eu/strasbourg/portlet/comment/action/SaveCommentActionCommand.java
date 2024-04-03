package eu.strasbourg.portlet.comment.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.model.Signalement;
import eu.strasbourg.service.comment.service.CommentLocalService;
import eu.strasbourg.service.comment.service.SignalementLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
        immediate = true,
        property = {
        "javax.portlet.name=" + StrasbourgPortletKeys.COMMENT_BO,
        "mvc.command.name=saveComment"
        },
        service = MVCActionCommand.class
        )
public class SaveCommentActionCommand implements MVCActionCommand{

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
    private CommentLocalService _commentLocalService;

    @Override
    public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) {
        try {
            ServiceContext sc = ServiceContextFactory.getInstance(actionRequest);
            boolean isValid = validate(actionRequest);
            if (!isValid){

                // Si pas valide : on reste sur la page d'édition
                PortalUtil.copyRequestParameters(actionRequest, actionResponse);

                ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
                        .getAttribute(WebKeys.THEME_DISPLAY);
                String portletName = (String) actionRequest
                        .getAttribute(WebKeys.PORTLET_ID);
                PortletURL backURL = PortletURLFactoryUtil.create(actionRequest,
                        portletName, themeDisplay.getPlid(),
                        PortletRequest.RENDER_PHASE);

                actionResponse.setRenderParameter("backURL", backURL.toString());
                actionResponse.setRenderParameter("mvcPath","/comment-bo-edit-comment.jsp");
                actionResponse.setRenderParameter("cmd", "saveComment");
                return false;
            }
            long commentId = ParamUtil.getLong(actionRequest,"commentId");
            Comment comment;
            if (commentId==0){
                comment = _commentLocalService.createComment("",sc);
                comment.setCreateDate(new Date());
            } else {
                comment = _commentLocalService.getComment(commentId);
                comment.setModifiedDate(new Date());
            }
            String userName = ParamUtil.getString(actionRequest,"userName");
            if (userName!=null&&!userName.isEmpty()){
                comment.setUserName(userName);
            }

            boolean deleteAllSignalements = ParamUtil.getBoolean(actionRequest,"signalementCheckBox");
            if (deleteAllSignalements){
                List<Signalement> signalements = SignalementLocalServiceUtil.findByCommentId(commentId);
                signalements.forEach(signalement -> {
                    signalement.setStatus(WorkflowConstants.STATUS_DENIED);
                    SignalementLocalServiceUtil.updateSignalement(signalement);
                });
            }
            boolean approved = ParamUtil.getBoolean(actionRequest,"status");
            comment.setStatus(approved ? 0 : 1);
//            String commentaire = ParamUtil.getString(actionRequest,"text");
//            _log.info("nouveau commentaire : "+commentaire);
//            comment.setText(commentaire);
            Map<Locale, String> commentaire = LocalizationUtil
                    .getLocalizationMap(actionRequest, "text");
            _log.info("nouveau commentaire : "+commentaire.get(Locale.FRANCE));
            comment.setTextMap(commentaire);

            // ---------------------------------------------------------------
            // -------------------------- BANNISSEMENT -----------------------
            // ---------------------------------------------------------------

            // Definir le format de recuperation de date
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

            // Date de bannissement
            Date banishDate = ParamUtil.getDate(actionRequest, "banishDate", dateFormat);

            Calendar todayDate = Calendar.getInstance();
            Calendar testDate = Calendar.getInstance();
            testDate.setTime(banishDate);

            boolean sameDay = todayDate.get(Calendar.YEAR) == testDate.get(Calendar.YEAR) &&
                    todayDate.get(Calendar.DAY_OF_YEAR) == testDate.get(Calendar.DAY_OF_YEAR);

            PublikUser publikUser = PublikUserLocalServiceUtil.getByPublikUserId(comment.getPublikId());

            if(!sameDay)
                publikUser.setBanishDate(banishDate);
            else
                publikUser.setBanishDate(null);

            // Description du bannissement
            String banishDescription = ParamUtil.getString(actionRequest, "banishDescription");
            if (banishDescription!=null&&!banishDescription.isEmpty()){
                publikUser.setBanishDescription(banishDescription);
            }else banishDescription="";
            PublikUserLocalServiceUtil.updatePublikUser(publikUser);
            _commentLocalService.updateComment(comment);
            actionResponse.setRenderParameter("mvcPath", "/comment-bo-view-comments.jsp");

        } catch (PortalException e) {
            _log.error(e);
        }
        return true;
    }

    /**
     * Validation des champs obligatoires
     */
    private boolean validate(ActionRequest request) {
        boolean result = true;
        if (Validator.isNull(ParamUtil.getString(request, "textEditor"))) {
            SessionErrors.add(request, "commentaire-error");
            result = false;
        }
        return result;
    }

    @Reference(unbind = "-")
    protected void setCommentLocalService(CommentLocalService commentLocalService){
        _commentLocalService = commentLocalService;
    }
}
