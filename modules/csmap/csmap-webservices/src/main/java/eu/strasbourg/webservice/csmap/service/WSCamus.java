package eu.strasbourg.webservice.csmap.service;

import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.http.HttpAuthorizationHeader;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.security.auth.http.HttpAuthManagerUtil;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.webservice.csmap.model.FicheCSMap;
import org.jsoup.HttpStatusException;

import javax.ws.rs.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WSCamus {

    // Chemin de l'API Entrouvert
    public static final String PATH = "api/cards/fiches-csmap/";

    // Récupérer une fiche CSMap en fonction de l'identifiant Publik de l'utilisateur
    public static FicheCSMap getFicheCSMap(String publikUserId) throws WebApplicationException {
        // Vérifier si l'identifiant Publik est valide
        if(publikUserId == null || publikUserId.isEmpty()){
            throw new NotFoundException("publikId est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = PATH + "list?full=on&filter-user-uuid=" + publikUserId;
        try{
            // Appeler l'API Entrouvert et récupérer la réponse
            JSONObject response = getEntrouvertAPI(path);
            // Créer et retourner un objet FicheCSMap à partir de la réponse
            return new FicheCSMap(response);
        } catch (JSONException | IOException e) {
            // En cas d'erreur, enregistrer l'erreur et renvoyer une erreur 500
            _log.error(e);
            throw new InternalServerErrorException("Impossible de récupérer la fiche CSMap");
        }
    }

    // Créer une nouvelle fiche CSMap avec l'email de l'utilisateur Publik et les champs spécifiés
    public static void createFicheCSMap(String publikUserEmail, HashMap<String, Object> fields) throws WebApplicationException {
        // Vérifier si l'email de l'utilisateur Publik est valide
        if(publikUserEmail == null || publikUserEmail.isEmpty()){
            throw new NotFoundException("publikUserEmail est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = PATH + "submit";
        try{
            // Construire le corps de la requête au format JSON
            JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
            JSONObject jsonFields = JSONFactoryUtil.createJSONObject(fields);
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

    // Mettre à jour une fiche CSMap avec l'identifiant de la fiche et les champs spécifiés
    public static void updateFicheCSMap(String ficheId, HashMap<String, Object> fields) throws WebApplicationException {
        // Vérifier si l'identifiant de la fiche est valide
        if(ficheId == null || ficheId.isEmpty()){
            throw new NotFoundException("ficheId est vide ou null");
        }

        // Construire le chemin complet pour la requête
        final String path = PATH + ficheId;
        try{
            // Construire le corps de la requête au format JSON
            JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
            JSONObject jsonFields = JSONFactoryUtil.createJSONObject(fields);
            jsonBody.put("data", jsonFields);

            // Envoyer la requête POST à l'API Entrouvert
            postEntrouvertAPI(path, jsonBody);
        } catch (JSONException | IOException e) {
            // En cas d'erreur, enregistrer l'erreur et renvoyer une erreur 500
            _log.error(e);
            throw new InternalServerErrorException("Impossible de récupérer la fiche CSMap");
        }
    }

    // Appeler l'API Entrouvert et récupérer la réponse
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
        httpOptions.setLocation(StrasbourgPropsUtil.getEntrouvertURL() + PATH + path);
        httpOptions.setHeaders(headers);
        httpOptions.setMethod(Http.Method.GET);

        // Envoyer la requête et récupérer la réponse JSON
        String response = HttpUtil.URLtoString(httpOptions);
        return JSONFactoryUtil.createJSONObject(response);
    }

    // Envoyer une requête POST à l'API Entrouvert avec le corps spécifié
    public static void postEntrouvertAPI(String path, JSONObject body) throws JSONException, IOException {
        // Récupérer l'en-tête d'authentification HTTP
        HttpAuthorizationHeader httpAuthorizationHeader = getHttpAuthorizationHeader();

        // Construire les en-têtes de la requête
        Map<String, String> headers = HashMapBuilder.put(
                "Accept", "application/json"
        ).put(
                "Authorization", httpAuthorizationHeader.toString()
        ).build();

        // Configurer les options de la requête HTTP POST
        Http.Options httpOptions = new Http.Options();
        httpOptions.setLocation(StrasbourgPropsUtil.getEntrouvertURL() + PATH + path);
        httpOptions.setBody(body.toJSONString(), ContentTypes.APPLICATION_JSON, "UTF-8");
        httpOptions.setHeaders(headers);
        httpOptions.setMethod(Http.Method.POST);

        // Envoyer la requête POST et ignorer la réponse
        String response = HttpUtil.URLtoString(httpOptions);
    }

    // Méthode privée pour récupérer l'en-tête d'authentification HTTP
    private static HttpAuthorizationHeader getHttpAuthorizationHeader() {
        HttpAuthorizationHeader httpAuthorizationHeader = new HttpAuthorizationHeader(HttpAuthorizationHeader.SCHEME_BASIC);
        httpAuthorizationHeader.setAuthParameter("username", StrasbourgPropsUtil.getPublikUserName());
        httpAuthorizationHeader.setAuthParameter("password", StrasbourgPropsUtil.getPublikPassword());

        // Retourner l'en-tête d'authentification HTTP
        return httpAuthorizationHeader;
    }

    // Déclaration du journal pour enregistrer les événements
    private static final Log _log = LogFactoryUtil.getLog(WSCamus.class.getName());
}
