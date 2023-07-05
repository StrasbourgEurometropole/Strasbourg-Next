package eu.strasbourg.portlet.agenda.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.portlet.agenda.portlet.display.context.EditCampaignEventDisplayContext;
import eu.strasbourg.portlet.agenda.portlet.display.context.ManagementCampaignsToolBarDisplayContext;
import eu.strasbourg.portlet.agenda.portlet.display.context.ViewCampaignEventsDisplayContext;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component(
	immediate = true,
	property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/vendors/daterangepicker.css",
		"com.liferay.portlet.header-portlet-css=/css/campaign.css",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.single-page-application=false",
		"com.liferay.portlet.requires-namespaced-parameters=false",
		"com.liferay.portlet.css-class-wrapper=campaign-web",
		"javax.portlet.display-name=agenda-campaign-web Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/campaign-view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class AgendaCampaignPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {
		HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
		String mvcPath = ParamUtil.getString(renderRequest, "mvcPath");
		if (mvcPath.equals("/campaign-edit.jsp")) {
			EditCampaignEventDisplayContext dc = new EditCampaignEventDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
		} else {
			ViewCampaignEventsDisplayContext dc = new ViewCampaignEventsDisplayContext(
				renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
			ManagementCampaignsToolBarDisplayContext managementDC = null;
			try {
				managementDC = new ManagementCampaignsToolBarDisplayContext(
						servletRequest, (LiferayPortletRequest) renderRequest,
						(LiferayPortletResponse) renderResponse, dc);
			} catch (PortalException e) {
				throw new RuntimeException(e);
			}
			renderRequest.setAttribute("managementDC", managementDC);
		}

		super.render(renderRequest, renderResponse);
	}
}