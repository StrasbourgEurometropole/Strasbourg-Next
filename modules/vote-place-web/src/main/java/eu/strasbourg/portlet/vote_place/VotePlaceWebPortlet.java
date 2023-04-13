package eu.strasbourg.portlet.vote_place;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import eu.strasbourg.utils.PortalHelper;
import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.portlet.felec.portlet.FelecResponse;
import eu.strasbourg.portlet.felec.portlet.FelecWebServiceClient;
import eu.strasbourg.service.place.exception.NoSuchPlaceException;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.PortletHelper;
import eu.strasbourg.utils.PublikApiClient;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

/**
 * @author angelique.champougny
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=Strasbourg",
		"com.liferay.portlet.instanceable=true", "com.liferay.portlet.required-namespaced-parameters=false",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/vote-place-view.jsp",
		"javax.portlet.display-name=Mon bureau de vote", "javax.portlet.name=" + StrasbourgPortletKeys.VOTE_PLACE_WEB,
		"javax.portlet.resource-bundle=content.Language",
		"com.liferay.portlet.render-weight=0",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class VotePlaceWebPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response) throws IOException, PortletException {

		// récupération des infos de l'utilisateur
		String birthName = null;
		String firstName = null;
		String birthDate = null;
		String birthPlace = null;
		// Récupération du publik ID avec la session
		String internalId = getPublikID(request);
		if (Validator.isNotNull(internalId)) {
			JSONObject userDetail = PublikApiClient.getUserDetails(internalId);
			if (userDetail.toString().equals("{}")) {
				request.setAttribute("error", "publik");
			} else {
				birthName = userDetail.getString("nom_de_naissance");
				firstName = userDetail.getString("first_name");
				// date au format AAAA-MM-JJ
				birthDate = userDetail.getString("birthdate");
				if (birthDate.length() > 0) {
					LocalDate birthLocalDate = LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
					birthDate = birthLocalDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
				}
				birthPlace = userDetail.getString("birthplace");
				if (birthPlace != null && birthPlace.length() > 1) {
					birthPlace = birthPlace.substring(0, 1).toUpperCase() + birthPlace.substring(1);
				}
				request.setAttribute("lastName", birthName);
				request.setAttribute("firstName", firstName);
				request.setAttribute("birthDate", birthDate);
				request.setAttribute("birthPlace", birthPlace);

				FelecResponse felecResponse = null;
				if (Validator.isNotNull(birthPlace) && Validator.isNotNull(birthDate) && Validator.isNotNull(birthName)
						&& Validator.isNotNull(firstName)) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
						Date date = sdf.parse(birthDate);
						felecResponse = FelecWebServiceClient.getResponse(birthName, firstName, date, birthPlace);
						if(Validator.isNull(felecResponse.getResponseCode())) {
							request.setAttribute("error", "publik");
						}
						request.setAttribute("felecResponse", felecResponse);
						Place office = null;
						try {
							String stationNumber = felecResponse.getStationNumber();
							if (Validator.isNotNull(stationNumber)) {
								//retire les zéros devant le numéro
								stationNumber = stationNumber.replaceAll("^0+", "");
								List<Place> places = PlaceLocalServiceUtil.findByName("% " + stationNumber);
								if(!places.isEmpty())
									office = places.get(0);
							}
						} catch (NoSuchPlaceException e) {
							e.printStackTrace();
						}
						request.setAttribute("office", office);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				} else {
					List<String> champsNull = new ArrayList<String>();
					if (Validator.isNull(birthName)) {
						champsNull.add("Nom de naissance");
					}
					if (Validator.isNull(birthPlace)) {
						champsNull.add("Ville de naissance");
					}
					if (Validator.isNull(birthDate)) {
						champsNull.add("Date de naissance");
					}
					request.setAttribute("champsNull", champsNull);
				}
			}
		}
		ThemeDisplay themeDisplay = ((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY));
		Group group = GroupLocalServiceUtil.fetchFriendlyURLGroup(themeDisplay.getCompanyId(), "/strasbourg.eu");
		String virtualHostName = PortalHelper.getVirtualHostname(group,themeDisplay.getLanguageId());
		request.setAttribute("virtualHostName", virtualHostName);
		request.setAttribute("showDeleteButton",
				PortletHelper.showDeleteButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId()));

		// Affichage ou non de l'accordéon
		request.setAttribute("showRetractableButton",
				PortletHelper.showRetractableButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId()));

		// Affichage ou non de l'accordéon
		request.setAttribute("isFolded",
				PortletHelper.isPortletFoldedOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId()));
		
		// titre personnalisable
		request.setAttribute("title", PortletHelper.getPortletTitle("vote-place", request));
		
		super.render(request, response);
	}

	// Récupération de l'id utilisateur
	private String getPublikID(PortletRequest resourceRequest) {

		LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(resourceRequest);
		HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();

		return SessionParamUtil.getString(originalRequest, "publik_internal_id");
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}