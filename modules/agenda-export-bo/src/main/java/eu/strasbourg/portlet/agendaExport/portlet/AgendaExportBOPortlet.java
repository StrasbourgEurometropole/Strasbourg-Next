package eu.strasbourg.portlet.agendaExport.portlet;

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

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import eu.strasbourg.portlet.agendaExport.displayContext.ManagementAgendaExportToolBarDisplayContext;
import eu.strasbourg.portlet.agendaExport.displayContext.NavigationBarDisplayContext;
import org.osgi.service.component.annotations.Component;

import eu.strasbourg.portlet.agendaExport.displayContext.EditAgendaExportDisplayContext;
import eu.strasbourg.portlet.agendaExport.displayContext.ViewAgendaExportDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import static eu.strasbourg.portlet.agendaExport.constants.agendaExportConstants.*;

/**
 * @author jeremy.zwickert
 */
@Component(
        immediate=true,
        property= {
                "javax.portlet.version=3.0",
                "com.liferay.portlet.instanceable=false",
                "com.liferay.portlet.footer-portlet-javascript=/js/agenda-export-bo-main.js",
                "com.liferay.portlet.header-portlet-css=/css/vendors/daterangepicker.css",
                "com.liferay.portlet.header-portlet-css=/css/agenda-export-bo-main.css",
                "com.liferay.portlet.single-page-application=false",
                "javax.portlet.init-param.template-path=/META-INF/resources/",
                "javax.portlet.init-param.view-template=/agenda-export-bo-view-agenda-export.jsp",
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user",
        		"javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_EXPORT_BO
        },
        service = Portlet.class
)
public class AgendaExportBOPortlet extends MVCPortlet {
	
	@Override
    public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();
        
        String toExport = ParamUtil.getString(renderRequest, "toExport");
        
        renderResponse.setTitle("Export Agenda");

        //si on est sur la page d'ajout, on affiche bien �videmment un lien de retour
        String returnURL = ParamUtil.getString(renderRequest,"backURL");
        boolean showBackButton = Validator.isNotNull(returnURL);
        if (showBackButton){
            portletDisplay.setShowBackIcon(true);
            portletDisplay.setURLBack(returnURL);
        }

        try {
            NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
            renderRequest.setAttribute("navigationDC", navigationDC);
            HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);

            switch (navigationDC.getSelectedTab()) {
                case AGENDA_EXPORTS:
                default:
                    if(navigationDC.getSelectedCmd().equals(EDIT_AGENDA_EXPORTS)
                            || navigationDC.getSelectedCmd().equals(COPY_AGENDA_EXPORTS) || navigationDC.getSelectedCmd().equals(EXPORT_AGENDA_EXPORTS)){
                        EditAgendaExportDisplayContext dc = new EditAgendaExportDisplayContext(renderRequest,renderResponse);
                        dc.setToExport(toExport);
                        renderRequest.setAttribute("dc",dc);
                    } else {
                        ViewAgendaExportDisplayContext dc = new ViewAgendaExportDisplayContext(renderRequest, renderResponse);
                        ManagementAgendaExportToolBarDisplayContext managementDC = new ManagementAgendaExportToolBarDisplayContext(
                                servletRequest, (LiferayPortletRequest) renderRequest,
                                (LiferayPortletResponse) renderResponse, dc.getSearchContainer());
                        renderRequest.setAttribute("dc", dc);
                        renderRequest.setAttribute("managementDC", managementDC);
                    }
                    break;
            }

            } catch (PortalException e) {
                e.printStackTrace();
            }

        super.render(renderRequest, renderResponse);
	}
}