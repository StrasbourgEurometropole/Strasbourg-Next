package eu.strasbourg.portlet.place.resource;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.search.*;
import eu.strasbourg.service.office.exporter.api.PlaceXlsxExporter;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
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
        resourceResponse.setProperty("content-disposition", "attachment; filename=liste_lieux_" + DateUtil.getCurrentDate("yyyyMMdd", Locale.FRANCE) + ".xlsx");

        HttpServletRequest servletRequest = PortalUtil.getHttpServletRequest(resourceRequest);
        SearchContext searchContext = SearchContextFactory.getInstance(servletRequest);

        try {
            // Get filtre parameters from post data
            String categoryIdsJSON = ParamUtil.getString(resourceRequest, "categoryIds");
            List<Long[]> categoryIds = JSONHelper.parseJsonList(categoryIdsJSON);
            String orderByCol = ParamUtil.getString(resourceRequest, "orderByCol");
            String keywords = ParamUtil.getString(resourceRequest, "keywords");


            // get themedisplay
            ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
            long companyGroupId = themeDisplay.getCompanyGroupId();

            // Get all places
            Hits hits = SearchHelper.getBOSearchHits(searchContext, 0, -1, Place.class.getName() , companyGroupId , categoryIds, keywords, orderByCol , true);

            List<Place> places = Stream.of(hits.getDocs())
                    .map(document -> {
                        return PlaceLocalServiceUtil.fetchPlace(GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                    })
                    .filter(place -> place != null)
                    .collect(Collectors.toList());


            placesXlsExporter.export(resourceResponse.getPortletOutputStream(), places);
            resourceResponse.getPortletOutputStream().flush();
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
            return false;
        }

        return true;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
