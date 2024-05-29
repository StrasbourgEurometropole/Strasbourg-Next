package eu.strasbourg.portlet.place.resource;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.office.exporter.api.PlaceXlsxExporter;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component(immediate = true, property = { "javax.portlet.name=" + StrasbourgPortletKeys.PLACE_BO,
        "mvc.command.name=exportXlsx" }, service = MVCResourceCommand.class)
public class ExportPlacesToXlsxResourceCommand implements MVCResourceCommand {

    private PlaceXlsxExporter placesXlsExporter;

    @Reference(unbind = "-")
    public void setPlaceXlsxExporter(PlaceXlsxExporter placesXlsExporter) {
        this.placesXlsExporter = placesXlsExporter;
    }

    private PlaceLocalService placeLocalService;

    @Reference(unbind = "-")
    public void setPlaceLocalService(PlaceLocalService placeLocalService) {
        this.placeLocalService = placeLocalService;
    }

    @Override
    public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
            throws PortletException {
        resourceResponse.setContentType("application/force-download");
        // Add date to the file name in date format (places_YYYYMMDD.xlsx)
        resourceResponse.setProperty("content-disposition", "attachment; filename=places_" + DateUtil.getCurrentDate("yyyyMMdd", Locale.FRANCE) + ".xlsx");

        // Get the places by the ids
        String placeIds = ParamUtil.getString(resourceRequest, "placeIds");
        List<Place> places = fetchEvents(placeIds);



        try {
            placesXlsExporter.export(resourceResponse.getPortletOutputStream(), places);
            resourceResponse.getPortletOutputStream().flush();
        } catch (IOException e) {
            _log.error(e.getMessage(), e);
        }

        return true;
    }

    public List<Place> fetchEvents(String placeIdsStr) {
        return Stream.of(placeIdsStr.split(","))
                .filter(Validator::isNotNull)
                .map(this::tryParse)
                .filter(id -> id != null)
                .map(placeLocalService::fetchPlace)
                .filter(place -> place != null)
                .collect(Collectors.toList());
    }

    private Long tryParse(String value) {
        try {
            return Long.valueOf(value);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
