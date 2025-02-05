package eu.strasbourg.service.agenda.webservices;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.CacheJsonLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.webservices.utils.WSResponseUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.SearchHelper;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Response;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author angelique.champougny
 */
@Component(
    property = {
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=" + "/strasbourg" + "/agenda",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=" + "Strasbourg.Agenda.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class EventApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-event/{id}")
    public Response getEvent(
            @PathParam("id") String idString) {
        long id = Long.parseLong(idString);

        try {
            JSONObject eventJSON = JSONFactoryUtil.createJSONObject(CacheJsonLocalServiceUtil.getByEventIdAndIsApproved(id).getJsonEvent());
            return WSResponseUtil.buildOkResponse(eventJSON);
        } catch (Exception e) {
            return WSResponseUtil.buildErrorResponse(500, e.getMessage());
        }
    }

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-events")
    public Response getEvents() {
        JSONObject result = JSONFactoryUtil.createJSONObject();
        List<CacheJson> caches = CacheJsonLocalServiceUtil.getAllIsApproved();

        if(caches.isEmpty())
            return WSResponseUtil.buildOkResponse(result, 201);

        JSONArray jsonEvents = JSONFactoryUtil.createJSONArray();
        for (CacheJson cache : caches) {
            try {
                jsonEvents.put(JSONFactoryUtil.createJSONObject(cache.getJsonEvent()));
            } catch (JSONException e) {
                log.error(e);
            }
        }
        result.put("events", jsonEvents);

        return WSResponseUtil.buildOkResponse(result);
    }

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-events-by-date/{date}")
    public Response getEventsByDate(
                @PathParam("date") String dateString) {

        LocalDate localDate = LocalDate.parse(dateString,
                DateTimeFormatter.ofPattern("ddMMyyyy"));

        Hits hits = SearchHelper.getEventWebServiceSearchHits(
                Event.class.getName(), localDate, 0, null);

        return this.getApprovedJSONEvents(hits);
    }

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-events-by-category/{categoryId}")
    public Response getEventsByCategory(
                @PathParam("categoryId") String categoryIdString) {

        // on récupère la catégorie liée à l'externalId de la catégorie (categoryId)
        long categId = 0;
        AssetCategory category = AssetVocabularyHelper.getCategoryByExternalId(categoryIdString);
        if(Validator.isNotNull(category))
            categId = category.getCategoryId();

        Hits hits = SearchHelper.getEventWebServiceSearchHits(
                Event.class.getName(), null, categId, null);

        return this.getApprovedJSONEvents(hits);
    }

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-events-by-place/{placeSIGId}")
    public Response getEventsByPlace(
                @PathParam("placeSIGId") String placeSIGIdString) {

        if (Validator.isNotNull(placeSIGIdString)) {
            List<Event> events = EventLocalServiceUtil.findByPlaceSIGId(placeSIGIdString);
            return this.getApprovedJSONEvents(events);
        } else {
            return WSResponseUtil.buildErrorResponse(500, "place-sig-id parameter is empty");
        }
    }

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-events-by-language/{language}")
    public Response getEventsByLanguage(
                @PathParam("language") String languageString) {

        Locale locale = LocaleUtil.fromLanguageId(languageString);

        Hits hits = SearchHelper.getEventWebServiceSearchHits(
                Event.class.getName(), null, 0, locale);

        return this.getApprovedJSONEvents(hits);
    }

    private Response getApprovedJSONEvents(Hits hits) {
        List<Event> events = new ArrayList<>();
        if (hits != null) {
            for (Document document : hits.getDocs()) {
                Event event = EventLocalServiceUtil.fetchEvent(
                        GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK)));
                if (event != null) {
                    events.add(event);
                }
            }
        }
        return this.getApprovedJSONEvents(events);
    }

    private Response getApprovedJSONEvents(List<Event> events) {

        JSONObject result = JSONFactoryUtil.createJSONObject();
        JSONArray jsonEvents = JSONFactoryUtil.createJSONArray();

        if(events.isEmpty())
            return WSResponseUtil.buildOkResponse(result, 201);

        List<Long> eventIds = events.stream().map(Event::getEventId).collect(Collectors.toList());
        DynamicQuery dq = CacheJsonLocalServiceUtil.dynamicQuery();
        Criterion cacheEventIds = RestrictionsFactoryUtil.in("eventId", eventIds);
        Criterion isApproved = RestrictionsFactoryUtil.eq("isApproved", true);
        dq.add(RestrictionsFactoryUtil.and(cacheEventIds, isApproved));
        List<CacheJson> cachesJson = CacheJsonLocalServiceUtil.dynamicQuery(dq);

        for (CacheJson cache : cachesJson) {
            try {
                jsonEvents.put(JSONFactoryUtil.createJSONObject(cache.getJsonEvent()));
            } catch (JSONException e) {
                log.error(e);
            }
        }
        result.put("events", jsonEvents);
        return WSResponseUtil.buildOkResponse(result);
    }

}
