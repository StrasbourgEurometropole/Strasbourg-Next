package eu.strasbourg.portlet.activity;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import eu.strasbourg.portlet.activity.display.context.*;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import org.osgi.service.component.annotations.Reference;

import static eu.strasbourg.portlet.activity.constants.ActivityConstants.*;

@Component(
	immediate = true,
	property = {
		"javax.portlet.version=3.0",
			"javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/activity-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/activity-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
			"javax.portlet.init-param.template-path=/META-INF/resources/",
			"javax.portlet.init-param.view-template=/activity-bo-view-activities.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" },
	service = Portlet.class)
public class ActivityBOPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest renderRequest,
		RenderResponse renderResponse) throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest
			.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {
				case ORGANIZERS:
					if (navigationDC.getSelectedCmd().equals(EDIT_ORGANIZER) || navigationDC.getSelectedCmd().equals(SAVE_ORGANIZER)) {
						EditActivityOrganizerDisplayContext  dc = new EditActivityOrganizerDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewActivityOrganizersDisplayContext dc = new ViewActivityOrganizersDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementOrganizersToolBarDisplayContext managementDC = new ManagementOrganizersToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case ASSOCIATIONS:
					if (navigationDC.getSelectedCmd().equals(EDIT_ASSOCIATION) || navigationDC.getSelectedCmd().equals(SAVE_ASSOCIATION)) {
						EditAssociationDisplayContext  dc = new EditAssociationDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewAssociationsDisplayContext dc = new ViewAssociationsDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementAssociationsToolBarDisplayContext managementDC = new ManagementAssociationsToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case COURSES:
					if (navigationDC.getSelectedCmd().equals(EDIT_COURSE) || navigationDC.getSelectedCmd().equals(SAVE_COURSE)) {
						EditActivityCourseDisplayContext  dc = new EditActivityCourseDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewActivityCoursesDisplayContext dc = new ViewActivityCoursesDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementActivityCoursesToolBarDisplayContext managementDC = new ManagementActivityCoursesToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				case ACTIVITIES:
				default:
					if (navigationDC.getSelectedCmd().equals(EDIT_ACTIVITY) || navigationDC.getSelectedCmd().equals(SAVE_ACTIVITY)) {
						EditActivityDisplayContext dc = new EditActivityDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewActivitiesDisplayContext dc = new ViewActivitiesDisplayContext(renderRequest, renderResponse,_itemSelector);
						ManagementActivitiesToolBarDisplayContext managementDC = new ManagementActivitiesToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc);
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		PortletDisplay portletDisplay = themeDisplay.getPortletDisplay();

		String title = PortalUtil.getPortletTitle(renderRequest);
		title = LanguageUtil
				.get(PortalUtil.getHttpServletRequest(renderRequest), title);
		renderResponse.setTitle(title);

		// If we are on an "add" page, we set a return URL and show the "back"
		// button
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL.toString());
		}

		super.render(renderRequest, renderResponse);
	}
	@Reference
	private ItemSelector _itemSelector;

}