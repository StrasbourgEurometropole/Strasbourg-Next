package eu.strasbourg.service.agenda.webservices;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.agenda.webservices.utils.WSResponseUtil;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;
import java.util.Set;

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
    @Path("/v1.0/get-events")
    public Response getEvents(
            @Context HttpHeaders httpHeaders) {

        JSONArray jsonEvents = JSONFactoryUtil.createJSONArray();

        // On récupère toutes les procédures
        List<Event> events = EventLocalServiceUtil.getEvents(-1,-1);
        if(events.isEmpty())
            return WSResponseUtil.buildOkResponse(jsonEvents, 201);
        for (Event event: events) {
            JSONObject jsonEvent = event.toJSON(false);
            jsonEvents.put(jsonEvent);
        }

        return WSResponseUtil.buildOkResponse(jsonEvents);
    }

}
