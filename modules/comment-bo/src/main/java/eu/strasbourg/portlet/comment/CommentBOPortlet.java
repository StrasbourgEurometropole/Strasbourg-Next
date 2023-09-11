package eu.strasbourg.portlet.comment;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.comment.display.context.*;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.comment.constants.CommentConstants.*;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author alexandre.quere
 */
@Component(
        immediate=true,
        property= {
                "javax.portlet.version=3.0",
                "javax.portlet.name=" + StrasbourgPortletKeys.COMMENT_BO,
                "com.liferay.portlet.instanceable=false",
                "com.liferay.portlet.footer-portlet-javascript=/js/comment-bo-main.js",
                "com.liferay.portlet.header-portlet-css=/css/comment-bo-main.css",
                "com.liferay.portlet.single-page-application=false",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-template=/comment-bo-view-comments.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user"
        },
        service = Portlet.class
)
public class CommentBOPortlet extends MVCPortlet{

    @Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
        try {
            NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
            renderRequest.setAttribute("navigationDC", navigationDC);
            HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
            switch (navigationDC.getSelectedTab()) {
                case SIGNALEMENTS:
                    if (navigationDC.getSelectedCmd().equals(EDIT_COMMENT)) {
                        EditCommentDisplayContext dc = new EditCommentDisplayContext(renderRequest, renderResponse);
                        renderRequest.setAttribute("dc", dc);
                    } else {
                       ViewSignalementDisplayContext dc = new ViewSignalementDisplayContext(renderRequest, renderResponse);
                        renderRequest.setAttribute("dc", dc);
                       ManagementSignalementsToolBarDisplayContext managementDC=new ManagementSignalementsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
                          (LiferayPortletResponse) renderResponse, dc);
                        renderRequest.setAttribute("dc", dc);
                        renderRequest.setAttribute("managementDC", managementDC);
                    }
                    break;
                case COMMENTS:
                default:
                    if (navigationDC.getSelectedCmd().equals(EDIT_COMMENT) || navigationDC.getSelectedCmd().equals(SAVE_COMMENT)) {
                        EditCommentDisplayContext dc = new EditCommentDisplayContext(renderRequest, renderResponse);
                        renderRequest.setAttribute("dc", dc);
                    } else {
                        ViewCommentDisplayContext dc = new ViewCommentDisplayContext(renderRequest, renderResponse);
                        ManagementCommentsToolBarDisplayContext managementDC=new ManagementCommentsToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
                            (LiferayPortletResponse) renderResponse, dc);
                        renderRequest.setAttribute("dc", dc);
                        renderRequest.setAttribute("managementDC", managementDC);
                    }
                    break;
            }

        }catch (PortalException e) {
            e.printStackTrace();
        }

        //si on est sur la page d'ajout, on affiche bien évidemment un lien de retour
        String backURL = ParamUtil.getString(renderRequest,"backURL");
        boolean showBackButton = Validator.isNotNull(backURL);
        if (showBackButton){
            portletDisplay.setShowBackIcon(true);
            portletDisplay.setURLBack(backURL);
        }

        renderRequest.setAttribute("isAdmin",themeDisplay.getPermissionChecker().isOmniadmin());
        super.render(renderRequest, renderResponse);
    }
}
