package eu.strasbourg.portlet.sectorized.action;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.sectorized.configuration.SectorizedPlacesConfiguration;
import eu.strasbourg.portlet.sectorized.display.context.SectorizedPlacesDisplayContext;
import eu.strasbourg.service.adict.AdictService;
import eu.strasbourg.service.adict.Street;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import java.util.ArrayList;
import java.util.List;

@Component(immediate = true, property = { "javax.portlet.name=" + StrasbourgPortletKeys.SECTORIZED_PLACES_WEB,
		"mvc.command.name=search" }, service = MVCActionCommand.class)
public class SectorizedPlacesSearchAction implements MVCActionCommand {

	private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

	@Reference
	private AdictService adictService;

	private PlaceLocalService placeLocalService;

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		this.placeLocalService = placeLocalService;
	}

	/**
	 * Fonction appelée lors du clic sur le bouton rechercher
	 */
	@Override
	public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		SectorizedPlacesConfiguration configuration;
		try {
			configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(SectorizedPlacesConfiguration.class);

		} catch (Exception e) {
			SessionErrors.add(request, "unknown-error");
			log.error(e);
			return false;
		}

		// Requête de recherche
		String query = ParamUtil.getString(request, "query");
		request.setAttribute("query", query);

		// Requête vide
		if (Validator.isNull(query)) {
			SessionErrors.add(request, "address-required");
			return false;
		}

		// Récupération des rues correspondantes à la requête
		String city = "";
		if (configuration.forceStrasbourg()) {
			city = "Strasbourg";
		}
		List<Street> streets = adictService.searchStreetNumbers(query, city);
		if (streets.size() == 0) {
			SessionErrors.add(request, "no-result");
			return false;
		} else if (streets.size() > 1) {
			SessionErrors.add(request, "too-many-results");
			return false;
		}

		// Une seule rue récupérée, on peut désormais chercher les lieux
		// correspondants
		Street street = streets.get(0);
		String[] sectorTypes = configuration.types();
		List<String> sigIds = null;
		try {
			sigIds = adictService.getSectorizedPlaceIdsForCoordinates(street.getX(), street.getY(),
					sectorTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}
		List<Place> places = new ArrayList<Place>();
		for (String sigId : sigIds) {
			Place place = placeLocalService.getPlaceBySIGId(sigId);
			if (place != null) {
				places.add(place);
			}
		}
		request.setAttribute("streetName", street.getLabel());
		request.setAttribute("places", places);
		
		if (places.size() == 0) {
			SessionErrors.add(request, "no-result");
			return false;
		}

		// Tout ce qui est ADT
		PortletPreferences preferences = request.getPreferences();
		
		String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", StringPool.BLANK));
		request.setAttribute("displayStyle", displayStyle);

		long displayStyleGroupId = GetterUtil.getLong(preferences.getValue("displayStyleGroupId", null), 0);
		request.setAttribute("displayStyleGroupId", displayStyleGroupId);

		String className = Place.class.getName();
		request.setAttribute("className", className);
		
		List<Object> entries = new ArrayList<Object>();
		request.setAttribute("entries", entries);
		
		// Le display context
		request.setAttribute("dc", new SectorizedPlacesDisplayContext());

		return true;
	}

}
