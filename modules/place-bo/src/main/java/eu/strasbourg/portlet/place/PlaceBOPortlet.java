package eu.strasbourg.portlet.place;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.theme.PortletDisplay;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.place.display.context.EditGoogleDisplayContext;
import eu.strasbourg.portlet.place.display.context.EditPlaceDisplayContext;
import eu.strasbourg.portlet.place.display.context.EditPriceDisplayContext;
import eu.strasbourg.portlet.place.display.context.EditPublicHolidayDisplayContext;
import eu.strasbourg.portlet.place.display.context.EditSubPlaceDisplayContext;
import eu.strasbourg.portlet.place.display.context.ManagementPlacesToolBarDisplayContext;
import eu.strasbourg.portlet.place.display.context.ManagementPricesToolBarDisplayContext;
import eu.strasbourg.portlet.place.display.context.ManagementPublicHolidayToolBarDisplayContext;
import eu.strasbourg.portlet.place.display.context.ManagementSubPlaceToolBarDisplayContext;
import eu.strasbourg.portlet.place.display.context.NavigationBarDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewGoogleDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewPlacesDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewPricesDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewPublicHolidaysDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewSubPlacesDisplayContext;
import eu.strasbourg.portlet.place.display.context.ViewTokenDisplayContext;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static eu.strasbourg.portlet.place.constants.PlaceConstants.*;

@Component(immediate = true, property = {
		"javax.portlet.version=3.0",
		"javax.portlet.name=" + StrasbourgPortletKeys.PLACE_BO,
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.footer-portlet-javascript=/js/place-bo-main.js",
		"com.liferay.portlet.header-portlet-css=/css/place-bo-main.css",
		"com.liferay.portlet.single-page-application=false",
		"javax.portlet.init-param.template-path=/META-INF/resources/",
		"javax.portlet.init-param.view-template=/place-bo-view-places.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class PlaceBOPortlet extends MVCPortlet {

	public ThemeDisplay _themeDisplay;
	public ServiceContext _serviceContext;

	@Override
	public void render(RenderRequest renderRequest,
			RenderResponse renderResponse)
			throws IOException, PortletException {

		_themeDisplay = (ThemeDisplay) renderRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		PortletDisplay portletDisplay = _themeDisplay.getPortletDisplay();
		try {
			NavigationBarDisplayContext navigationDC = new NavigationBarDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("navigationDC", navigationDC);
			HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(renderRequest);
			switch (navigationDC.getSelectedTab()) {

				case PRICES: {
					if (navigationDC.getSelectedCmd().equals(EDIT_PRICE) || navigationDC.getSelectedCmd().equals(SAVE_PRICE)) {
						EditPriceDisplayContext dc = new EditPriceDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewPricesDisplayContext dc = new ViewPricesDisplayContext(renderRequest, renderResponse);
						ManagementPricesToolBarDisplayContext managementDC = new ManagementPricesToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				}
				case PUBLIC_HOLIDAYS: {
					if (navigationDC.getSelectedCmd().equals(EDIT_PUBLIC_HOLIDAY) || navigationDC.getSelectedCmd().equals(SAVE_PUBLIC_HOLIDAY)) {
						EditPublicHolidayDisplayContext dc = new EditPublicHolidayDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewPublicHolidaysDisplayContext dc = new ViewPublicHolidaysDisplayContext(renderRequest, renderResponse);
						ManagementPublicHolidayToolBarDisplayContext managementDC = new ManagementPublicHolidayToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				}
				case SUB_PLACES: {
					if (navigationDC.getSelectedCmd().equals(EDIT_SUB_PLACE) || navigationDC.getSelectedCmd().equals(SAVE_SUB_PLACE)) {
						EditSubPlaceDisplayContext dc = new EditSubPlaceDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewSubPlacesDisplayContext dc = new ViewSubPlacesDisplayContext(renderRequest, renderResponse);
						ManagementSubPlaceToolBarDisplayContext managementDC = new ManagementSubPlaceToolBarDisplayContext(servletRequest,(LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				}
				case GOOGLE: {
					if (navigationDC.getSelectedCmd().equals(EDIT_GOOGLE) || navigationDC.getSelectedCmd().equals(SAVE_PLACE)) {
						EditGoogleDisplayContext dc = new EditGoogleDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewGoogleDisplayContext dc = new ViewGoogleDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}
				case TOKEN: {
					if (navigationDC.getSelectedCmd().equals(SAVE_TOKEN)) {
						// met à jour le refreshToken
						// il suffit de faire un ajout unique avec comme valeurs obligatoire
						// className = "" , classPK = 0, type = 98
						String refreshToken = ParamUtil.getString(renderRequest, "refresh-token");
						TicketLocalServiceUtil.addDistinctTicket(_themeDisplay.getCompanyId(),"",0,98,
								refreshToken,null, _serviceContext);
					} else {
						ViewTokenDisplayContext dc = new ViewTokenDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					}
					break;
				}

				case PLACES: {
					if (navigationDC.getSelectedCmd().equals(EDIT_PLACE) || navigationDC.getSelectedCmd().equals(SAVE_PLACE)) {
						EditPlaceDisplayContext dc = new EditPlaceDisplayContext(renderRequest, renderResponse);
						renderRequest.setAttribute("dc", dc);
					} else {
						ViewPlacesDisplayContext dc = new ViewPlacesDisplayContext(renderRequest, renderResponse);
						ManagementPlacesToolBarDisplayContext managementDC = new ManagementPlacesToolBarDisplayContext(servletRequest, (LiferayPortletRequest) renderRequest,
								(LiferayPortletResponse) renderResponse, dc.getSearchContainer());
						renderRequest.setAttribute("dc", dc);
						renderRequest.setAttribute("managementDC", managementDC);
					}
					break;
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		try {
			_serviceContext = ServiceContextFactory.getInstance(renderRequest);
		} catch (PortalException e) {
			_log.error(e.getMessage() + " : " + renderRequest);
		}

		// Si on est sur la page d'ajout, on affiche un lien de retour
		String backURL = ParamUtil.getString(renderRequest, "backURL");
		boolean showBackButton = Validator.isNotNull(backURL);
		if (showBackButton) {
			portletDisplay.setShowBackIcon(true);
			portletDisplay.setURLBack(backURL);
		}

		// Admin ou pas
		renderRequest.setAttribute("isAdmin", _themeDisplay.getPermissionChecker().isOmniadmin());

		super.render(renderRequest, renderResponse);
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass());

}