package eu.strasbourg.service.official.webservices;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.official.webservices.utils.WSResponseUtil;
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
        JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=" + "/strasbourg" + "/official",
        JaxrsWhiteboardConstants.JAX_RS_NAME + "=" + "Strasbourg.Official.Rest",
        "auth.verifier.guest.allowed=true",
        "liferay.access.control.disable=true"
    },
    service = Application.class
)
public class OfficialApplication extends Application {

    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @GET
    @Produces("application/json")
    @Path("/v1.0/get-officials")
    public Response getOfficials(
            @Context HttpHeaders httpHeaders) {

        JSONArray jsonOfficials = JSONFactoryUtil.createJSONArray();

        // On récupère toutes les procédures
        List<Official> officials = OfficialLocalServiceUtil.getOfficials(-1,-1);
        if(officials.isEmpty())
            return WSResponseUtil.buildOkResponse(jsonOfficials, 201);
        for (Official official: officials) {
            JSONObject jsonOfficial = official.toJSON();
            jsonOfficials.put(jsonOfficial);
        }

        return WSResponseUtil.buildOkResponse(jsonOfficials);
    }

}
