package eu.strasbourg.webservice.csmap.service;

import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.security.auth.http.HttpAuthorizationHeader;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.security.auth.http.HttpAuthManagerUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.webservice.csmap.model.FicheCSMap;
import org.jsoup.HttpStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WSCamus {

    // Chemin de l'API Entrouvert
    public static final String PATH = "/api/cards/fiches-csmap/";


    /**
     * Récupérer une fiche CSMap en fonction de l'identifiant Publik de l'utilisateur.
     *
     * @param publikUserId L'identifiant Publik de l'utilisateur.
     * @return Un objet FicheCSMap correspondant à l'utilisateur, null si la fiche n'existe pas.
     * @throws WebApplicationException Si une erreur se produit lors de la récupération de la fiche.
     */
    public static FicheCSMap getFicheCSMap(String publikUserId) throws WebApplicationException {
        // Vérifier si l'identifiant Publik est valide
        if (publikUserId == null || publikUserId.isEmpty()) {
            throw new NotFoundException("publikId est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = "list?full=on&filter-user-uuid=" + publikUserId;
        try {
            // Appeler l'API Entrouvert et récupérer la réponse
            JSONObject response = getEntrouvertAPI(path);
            // Créer et retourner un objet FicheCSMap à partir de la réponse
            JSONObject fiche = response.getJSONArray("data").getJSONObject(0);
            if (fiche == null) {
                return null;
            }
            return new FicheCSMap(fiche);
        } catch (JSONException | IOException e) {
            // En cas d'erreur, enregistrer l'erreur et renvoyer une erreur 500
            _log.error(e);
            throw new InternalServerErrorException("Impossible de récupérer la fiche CSMap");
        }
    }

    /**
     * Créer une nouvelle fiche CSMap avec l'email de l'utilisateur Publik et les champs spécifiés.
     *
     * @param publikUserEmail L'email de l'utilisateur Publik.
     * @param jsonFields      Les champs à inclure dans la nouvelle fiche.
     * @throws WebApplicationException Si une erreur se produit lors de la création de la fiche.
     */
    public static void createFicheCSMap(String publikUserEmail, JSONObject jsonFields) throws WebApplicationException {
        // Vérifier si l'email de l'utilisateur Publik est valide
        if (publikUserEmail == null || publikUserEmail.isEmpty()) {
            throw new NotFoundException("publikUserEmail est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = "submit";
        try {
            // Construire le corps de la requête au format JSON
            JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
            jsonBody.put("data", jsonFields);
            JSONObject jsonEmail = JSONFactoryUtil.createJSONObject();
            jsonEmail.put("email", publikUserEmail);
            jsonBody.put("user", jsonEmail);

            // Envoyer la requête POST à l'API Entrouvert
            postEntrouvertAPI(path, jsonBody);
        } catch (JSONException | IOException e) {
            // En cas d'erreur, enregistrer l'erreur et renvoyer une erreur 500
            _log.error(e);
            throw new InternalServerErrorException("Impossible de récupérer la fiche CSMap");
        }
    }

    /**
     * Mettre à jour une fiche CSMap avec l'identifiant de la fiche et les champs spécifiés.
     *
     * @param ficheId L'identifiant de la fiche.
     * @param fields  Les champs à mettre à jour.
     * @throws WebApplicationException Si une erreur se produit lors de la mise à jour de la fiche.
     */
    public static void updateFicheCSMap(String ficheId, JSONObject fields) throws WebApplicationException {
        // Vérifier si l'identifiant de la fiche est valide
        if (ficheId == null || ficheId.isEmpty()) {
            throw new NotFoundException("ficheId est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = ficheId;
        try {
            // Construire le corps de la requête au format JSON
            JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
            jsonBody.put("data", fields);

            // Envoyer la requête POST à l'API Entrouvert
            postEntrouvertAPI(path, jsonBody);
        } catch (JSONException | IOException e) {
            // En cas d'erreur, enregistrer l'erreur et renvoyer une erreur 500
            _log.error(e);
            throw new InternalServerErrorException("Impossible de récupérer la fiche CSMap");
        }
    }

    /**
     * Appeler l'API Entrouvert et récupérer la réponse.
     *
     * @param path Le chemin de la requête API.
     * @return Un objet JSON contenant la réponse de l'API.
     * @throws JSONException En cas de problème de traitement JSON.
     * @throws IOException   En cas de problème d'entrée/sortie.
     */
    public static JSONObject getEntrouvertAPI(String path) throws JSONException, IOException {
        // Récupérer l'en-tête d'authentification HTTP
        HttpAuthorizationHeader httpAuthorizationHeader = getHttpAuthorizationHeader();

        // Construire les en-têtes de la requête
        Map<String, String> headers = HashMapBuilder.put(
                "Accept", "application/json"
        ).put(
                "Authorization", httpAuthorizationHeader.toString()
        ).build();

        // Configurer les options de la requête HTTP GET
        Http.Options httpOptions = new Http.Options();
        httpOptions.setLocation(StrasbourgPropsUtil.getPublikApiBase() + PATH + path);
        httpOptions.setHeaders(headers);
        httpOptions.setMethod(Http.Method.GET);

        // Envoyer la requête et récupérer la réponse JSON
        String response = HttpUtil.URLtoString(httpOptions);
        return JSONFactoryUtil.createJSONObject(response);
    }

    /**
     * Envoyer une requête POST à l'API Entrouvert avec le corps spécifié.
     *
     * @param path Le chemin de la requête API.
     * @param body Le corps de la requête au format JSON.
     * @throws JSONException En cas de problème de traitement JSON.
     * @throws IOException   En cas de problème d'entrée/sortie.
     */
    public static void postEntrouvertAPI(String path, JSONObject body) throws JSONException, IOException {
        // Récupérer l'en-tête d'authentification HTTP
        HttpAuthorizationHeader httpAuthorizationHeader = getHttpAuthorizationHeader();

        // Construire les en-têtes de la requête
        Map<String, String> headers = HashMapBuilder.put(
                "Accept", MediaType.APPLICATION_JSON
        ).put(
                "Authorization", httpAuthorizationHeader.toString()
        ).put(
                "Content-Type", MediaType.APPLICATION_JSON
        ).build();

        // Configurer les options de la requête HTTP POST
        Http.Options httpOptions = new Http.Options();
        httpOptions.setLocation(StrasbourgPropsUtil.getPublikApiBase() + PATH + path);
        httpOptions.setBody(body.toJSONString(), ContentTypes.APPLICATION_JSON, "UTF-8");
        httpOptions.setHeaders(headers);
        httpOptions.setMethod(Http.Method.POST);

        // Envoyer la requête POST et ignorer la réponse
        String response = HttpUtil.URLtoString(httpOptions);
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject(response);
        if (!jsonResponse.getString("err").equals("0")) {
            throw new IOException("API response :" + jsonResponse.getString("err_desc"));
        }
    }

    /**
     * Méthode privée pour récupérer l'en-tête d'authentification HTTP.
     *
     * @return L'en-tête d'authentification HTTP.
     */
    private static HttpAuthorizationHeader getHttpAuthorizationHeader() {
        HttpAuthorizationHeader httpAuthorizationHeader = new HttpAuthorizationHeader(HttpAuthorizationHeader.SCHEME_BASIC);
        httpAuthorizationHeader.setAuthParameter("username", StrasbourgPropsUtil.getCamusUserName());
        httpAuthorizationHeader.setAuthParameter("password", StrasbourgPropsUtil.getCamusPassword());

        // Retourner l'en-tête d'authentification HTTP
        return httpAuthorizationHeader;
    }

    /**
     * Vérifie si un utilisateur avec l'adresse email spécifiée est un participant.
     *
     * @param publikUserEmail L'adresse email de l'utilisateur Publik.
     * @return true si l'utilisateur est un participant, sinon false.
     */
    public static boolean isParticipant(String publikUserEmail) {
        try {
            HttpServletRequest request = _getHttpServletRequest();
            URLStringEncoder encoder = new URLStringEncoder();
            String query = encoder.encode(publikUserEmail) + "%27";
            String url = "http://localhost:" + request.getLocalPort() + "/o/c/camususers/?fields=email&filter=email%20eq%20%27" + query;
            String sessionId = request.getSession().getId();
            String csrfToken = AuthTokenUtil.getToken(request);
            JSONObject response = callLiferayAPI(url, sessionId, csrfToken);

            // Check if the response contains the "items" key and if it contains any elements
            if (response.has("items") && response.getJSONArray("items").length() > 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            // En cas d'erreur, on log l'exception et retourne false
            _log.error(e);
            return false;
        }
    }

    /**
     * Récupère l'objet HttpServletRequest à partir du contexte de service.
     *
     * @return L'objet HttpServletRequest.
     */
    private static HttpServletRequest _getHttpServletRequest() {
        ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
        return serviceContext.getRequest();
    }

    /**
     * Appelle l'API Liferay avec les paramètres spécifiés.
     *
     * @param url       L'URL de l'API.
     * @param sessionId L'ID de session de l'utilisateur.
     * @param csrfToken Le token CSRF pour l'authentification.
     * @return Un objet JSON contenant la réponse de l'API.
     * @throws IOException   En cas de problème d'entrée/sortie.
     * @throws JSONException En cas de problème de traitement JSON.
     */
    private static JSONObject callLiferayAPI(String url, String sessionId, String csrfToken) throws IOException, JSONException {

        // Récupère les identifiants de connexion
        String username = StrasbourgPropsUtil.getCamusWebserviceUserName();
        String password = StrasbourgPropsUtil.getCamusWebservicePassword();

        Map<String, String> headers = HashMapBuilder.put(
                        "Accept", "application/json"
                )
                .put(
                        "Authorization", "Basic " + Base64.encode((username + ":" + password).getBytes())
                ).build();

        Http.Options httpOptions = new Http.Options();
        httpOptions.setHeaders(headers);
        httpOptions.setLocation(url);
        httpOptions.setMethod(Http.Method.GET);

        // Effectue la requête et récupère la réponse sous forme de chaîne
        String responseString = HttpUtil.URLtoString(httpOptions);

        // Convertit la réponse en objet JSON
        return JSONFactoryUtil.createJSONObject(responseString);
    }

    // Déclaration du journal pour enregistrer les événements
    private static final Log _log = LogFactoryUtil.getLog(WSCamus.class.getName());
}
