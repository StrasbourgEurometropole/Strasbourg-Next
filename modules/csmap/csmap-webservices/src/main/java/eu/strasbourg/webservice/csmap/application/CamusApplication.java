package eu.strasbourg.webservice.csmap.application;

import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.model.JournalFolder;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.json.*;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.csmap.model.Thematic;
import eu.strasbourg.service.csmap.service.ThematicLocalService;
import eu.strasbourg.service.notif.exception.NoSuchServiceNotifException;
import eu.strasbourg.service.notif.model.ServiceNotif;
import eu.strasbourg.service.notif.service.ServiceNotifLocalService;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.utils.DateHelper;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.webservice.csmap.constants.WSConstants;
import eu.strasbourg.webservice.csmap.exception.InvalidJWTException;
import eu.strasbourg.webservice.csmap.exception.NoJWTInHeaderException;
import eu.strasbourg.webservice.csmap.model.FicheCSMap;
import eu.strasbourg.webservice.csmap.service.WSAuthenticator;
import eu.strasbourg.webservice.csmap.service.WSCamus;
import eu.strasbourg.webservice.csmap.service.WSSettings;
import eu.strasbourg.webservice.csmap.utils.CSMapJSonHelper;
import eu.strasbourg.webservice.csmap.utils.WSCSMapUtil;
import eu.strasbourg.webservice.csmap.utils.WSResponseUtil;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=" + WSConstants.APP_GROUP_BASE + WSConstants.APP_CAMUS_BASE,
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=" + WSConstants.APP_CAMUS_NAME,
                "auth.verifier.guest.allowed=true",
                "liferay.access.control.disable=true"
        },
        service = Application.class
)
/**
 * Classe CamusApplication qui gère les endpoints RESTful pour l'application.
 * Cette classe permet de gérer l'initialisation, la mise à jour, la récupération
 * d'informations et la vérification de la participation des utilisateurs.
 */
public class CamusApplication extends Application {

    /**
     * Retourne un ensemble contenant cette instance de CamusApplication.
     * @return un ensemble d'objets singleton.
     */
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }

    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    /**
     * Endpoint pour initialiser les données d'un utilisateur.
     * @param httpHeaders les en-têtes HTTP de la requête.
     * @return une réponse HTTP en JSON.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/init")
    public Response init(@Context HttpHeaders httpHeaders) {
        try {
            // Valide l'utilisateur à partir du JWT dans les en-têtes HTTP
            PublikUser user = authenticator.validateUserInJWTHeader(httpHeaders);

            // Récupère la fiche utilisateur via l'API Entrouvert
            FicheCSMap fiche = WSCamus.getFicheCSMap(user.getPublikId());

            if (fiche == null) {
                // Crée une nouvelle fiche avec consentement et services par défaut
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("consentement", true);
                json.put("statut_piscine", "inactif");
                json.put("statut_mediatheque", "inactif");
                WSCamus.createFicheCSMap(user.getEmail(), json);
            } else {
                // Met à jour la fiche existante avec le consentement
                JSONObject json = JSONFactoryUtil.createJSONObject();
                json.put("consentement", "true");
                WSCamus.updateFicheCSMap(fiche.getId(), json);
            }

        } catch (WebApplicationException e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(e.getResponse().getStatus(), e.getMessage());
        } catch (NoJWTInHeaderException e) {
            return WSResponseUtil.buildErrorResponse(401, "No JWT in header");
        } catch (Exception e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(500, e.getMessage());
        }
        return WSResponseUtil.buildOkResponse(JSONFactoryUtil.createJSONObject(), 200);
    }

    /**
     * Endpoint pour mettre à jour les données d'un utilisateur.
     *
     * @param jsonString le corps de la requête en JSON.
     * @param httpHeaders les en-têtes HTTP de la requête.
     * @return une réponse HTTP en JSON.
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/update")
    public Response update(String jsonString, @Context HttpHeaders httpHeaders) {
        try {
            // Valide l'utilisateur à partir du JWT dans les en-têtes HTTP
            PublikUser user = authenticator.validateUserInJWTHeader(httpHeaders);

            // Parse le JSON du corps de la requête
            JSONArray json = JSONFactoryUtil.createJSONArray(jsonString);

            JSONObject jsonToReturn = JSONFactoryUtil.createJSONObject();

            // Boucle à travers le tableau JSON
            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                String label = obj.getString("codeSecteur");
                String value = obj.getString("identifiant");
                // Vérifie que les valeurs ne sont pas vides
                if (!Validator.isNotNull(value) || !Validator.isNotNull(label)) {
                    return WSResponseUtil.buildErrorResponse(400, "identifiant or codeSecteur is empty");
                }

                // Ajoute la valeur au JSON de retour
                jsonToReturn.put("sector_" + label, value);
            }

            // Récupère la fiche utilisateur via l'API Entrouvert
            FicheCSMap fiche = WSCamus.getFicheCSMap(user.getPublikId());

            if (fiche == null) {
                throw new NotFoundException("Fiche non trouv\u00E9e");
            }

            // Met à jour la fiche avec les nouvelles données
            WSCamus.updateFicheCSMap(fiche.getId(), jsonToReturn);

        } catch (WebApplicationException e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(e.getResponse().getStatus(), e.getMessage());
        } catch (NoJWTInHeaderException e) {
            return WSResponseUtil.buildErrorResponse(401, "No JWT in header");
        } catch (JSONException e) {
            return WSResponseUtil.buildErrorResponse(403, "Invalid JSON :" + e.getMessage());
        } catch (Exception e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(500, e.getMessage());
        }
        return WSResponseUtil.buildOkResponse(JSONFactoryUtil.createJSONObject(), 200);
    }

    /**
     * Endpoint pour récupérer les informations d'un utilisateur.
     * @param httpHeaders les en-têtes HTTP de la requête.
     * @return une réponse HTTP en JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get-infos")
    public Response getInfos(@Context HttpHeaders httpHeaders) {
        try {
            // Valide l'utilisateur à partir du JWT dans les en-têtes HTTP
            PublikUser user = authenticator.validateUserInJWTHeader(httpHeaders);

            // Récupère la fiche utilisateur via l'API Entrouvert
            FicheCSMap fiche = WSCamus.getFicheCSMap(user.getPublikId());

            if (fiche == null) {
                throw new NotFoundException("Fiche non trouv\u00E9e");
            }

            // Construit le JSON des services à partir de la fiche
            JSONArray listService = fiche.constructStatusJsonArray();

            return WSResponseUtil.buildOkResponse(listService, 200);
        } catch (WebApplicationException e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(e.getResponse().getStatus(), e.getMessage());
        } catch (NoJWTInHeaderException e) {
            return WSResponseUtil.buildErrorResponse(401, "No JWT in header");
        } catch (Exception e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(500, e.getMessage());
        }
    }

    /**
     * Endpoint pour vérifier si un utilisateur est participant.
     * @param httpHeaders les en-têtes HTTP de la requête.
     * @return une réponse HTTP en JSON.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/is-participant")
    public Response isParticipant(@Context HttpHeaders httpHeaders) {
        try {
            // Valide l'utilisateur à partir du JWT dans les en-têtes HTTP
            PublikUser user = authenticator.validateUserInJWTHeader(httpHeaders);

            // Vérifie si l'utilisateur est participant via l'API Entrouvert
            boolean isParticipant = WSCamus.isParticipant(user.getEmail());

            JSONObject json = JSONFactoryUtil.createJSONObject();
            json.put("isParticipant", isParticipant);

            return WSResponseUtil.buildOkResponse(json, 200);
        } catch (WebApplicationException e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(e.getResponse().getStatus(), e.getMessage());
        } catch (NoJWTInHeaderException e) {
            return WSResponseUtil.buildErrorResponse(401, "No JWT in header");
        } catch (Exception e) {
            log.error(e);
            return WSResponseUtil.buildErrorResponse(500, e.getMessage());
        }
    }

    /**
     * Référence pour l'authentificateur de services web.
     * @param authenticator l'authentificateur à utiliser.
     */
    @Reference(unbind = "-")
    protected void setWSAuthenticator(WSAuthenticator authenticator) {
        this.authenticator = authenticator;
    }

    @Reference
    protected WSAuthenticator authenticator;
}
