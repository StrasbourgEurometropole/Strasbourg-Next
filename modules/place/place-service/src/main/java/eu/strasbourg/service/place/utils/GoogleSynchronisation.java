package eu.strasbourg.service.place.utils;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.model.PlaceSchedule;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.models.Pair;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class GoogleSynchronisation {

    public final static Log log = LogFactoryUtil.getLog(GoogleSynchronisation.class);

    private ServiceContext sc;
    private GoogleMyBusinessHistoric googleMyBusinessHistoric;

    /**
     * Constructeur de base
     * @param sc Contexte de la requete
     * @param googleMyBusinessHistoric Entite de suivi de la synchronisation
     */
    public GoogleSynchronisation (ServiceContext sc, GoogleMyBusinessHistoric googleMyBusinessHistoric) {
        this.sc = sc;
        this.googleMyBusinessHistoric = googleMyBusinessHistoric;
    }

    /**
     * Opere la synchronisation
     */
    public void doSynchronisation() {
        this.googleMyBusinessHistoric.setStartDate(new Date());

        // Import des donnees du flux
        synchronisationData();

        this.googleMyBusinessHistoric.setFinishDate(new Date());
    }

    /**
     * Envoi les données à google
     */
    private void synchronisationData() {
        Timestamp startTimestamp = new Timestamp(System.currentTimeMillis());
        this.googleMyBusinessHistoric.addNewOperation("############### Synchronisation horaires lieux ###############");
        String resultat = "";
        String message = "";
        int nbPlacesSynchronisated = 0;

        // on récupère les lieux actifs qui ont un location Id
        List<Place> places = PlaceLocalServiceUtil.getPlaces(-1,-1).stream()
                .filter(p -> p.isApproved() && Validator.isNotNull(p.getLocationId()))
                .collect(Collectors.toList());
        if(places.size() == 0){
            this.googleMyBusinessHistoric.addNewOperation("Aucun lieux &agrave; synchroniser");
        }else{
            this.googleMyBusinessHistoric.addNewOperation("Nombre de lieux &agrave; synchroniser : " + places.size());
            // récupère l'accès token
            JSONObject json = null;
            try {
                json = getJSONAccesToken();
            } catch (IOException | JSONException e) {
                message = ExceptionUtils.getStackTrace(e);
                resultat = "ERREUR";
            }
            String error = null;
            if (json != null) {
                error = json.getString("error");
            }
            if (Validator.isNotNull(error)) {
                message = json.getString("error_description");
                resultat = "ERREUR";
            }else {
                String accessToken = json.getString("access_token");
                this.googleMyBusinessHistoric.addNewOperation("Access_token : " + accessToken);
                for (Place place : places) {
                    try{
                        // on récupère les horaires de la semaine en cours du lieu
                        Map<String, List<PlaceSchedule>> schedules = place.getFollowingWeekSchedules(new Date(), Locale.FRANCE);
                        if (schedules != null) {
                            // récupère le locationId du lieu
                            String locationId = place.getLocationId();
                            // transforme le schedule en json
                            JSONObject jsonSchedules = toJson(place, schedules);
                            // Synchronise à google map
                            JSONObject jsonResult = getSynchronisationResult(locationId, accessToken, jsonSchedules);
                            if(Validator.isNull(jsonResult.get("error"))) {
                                nbPlacesSynchronisated++;
                                this.googleMyBusinessHistoric.addNewOperation("lieu " + place.getAliasCurrentValue() + " synchronis&eacute;");
                            }else {
                                this.googleMyBusinessHistoric.addNewOperation("le lieu " + place.getAliasCurrentValue() + " n'a pas pu &ecirc;tre synchronis&eacute; pour la raison suivante :");
                                this.googleMyBusinessHistoric.addNewOperation(jsonResult.toString());
                            }
                        }else{
                            this.googleMyBusinessHistoric.addNewOperation("le lieu " + place.getAliasCurrentValue() + " n'a pas d'horaires");
                        }
                    } catch (Exception e) {
                        this.googleMyBusinessHistoric.addNewOperation("le lieu " + place.getAliasCurrentValue() + " n'a pas pu &ecirc;tre synchronis&eacute; pour la raison suivante :");
                        this.googleMyBusinessHistoric.addNewOperation(e.getMessage());
                        // Récupère les messages d'erreurs déjà existant avant de rajouter celui du lieu
                        StringBuilder sb = new StringBuilder();
                        sb.append(this.googleMyBusinessHistoric.getErrorStackTrace());
                        sb.append("<br><br>");
                        sb.append(place.getAliasCurrentValue());
                        sb.append("<br>");
                        sb.append(ExceptionUtils.getStackTrace(e));
                        this.googleMyBusinessHistoric.setErrorStackTrace(sb.toString());
                    }
                }
            }
        }


        this.googleMyBusinessHistoric.addNewOperation("############### Synchronisation termin&eacute;e ###############");
        if(resultat.equals("ERREUR")) {
            this.googleMyBusinessHistoric.setErrorDescription("Probleme survenu lors de la synchronisation");
            this.googleMyBusinessHistoric.setErrorStackTrace(message);
            this.googleMyBusinessHistoric.setResult(0);
            log.error(message);
        }else {
            this.googleMyBusinessHistoric.addNewOperation("Nombre de lieux synchronis&eacute;s : " + nbPlacesSynchronisated);
            Timestamp endTimestamp = new Timestamp(System.currentTimeMillis());
            long processTime = (endTimestamp.getTime() - startTimestamp.getTime()) / 1000;
            this.googleMyBusinessHistoric.addNewOperation("Synchronisation effectu&eacute;e en  " + processTime + " secondes.");

            // Succes de l'anonymisation
            // Si on a pas eu de résulat = ERREUR mais qu'on a quand meme une stacktrace c'est qu'au moins un lieu n'a pas réussi à se synchroniser
            // On enregistre alors un résultat de 2 "Succès avec erreur"
            if(Validator.isNotNull(this.googleMyBusinessHistoric.getErrorStackTrace())) {
                this.googleMyBusinessHistoric.setResult(2);
            } else {
                this.googleMyBusinessHistoric.setResult(1);
            }
        }
    }

    public JSONObject getJSONAccesToken() throws IOException, JSONException {
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        //récupère le refreshToken (className = "" , classPK = 0, type = 98)
        Ticket ticket = TicketLocalServiceUtil.getTickets(-1, -1).stream()
                .filter(t -> t.getClassName().equals("") && t.getClassPK() == 0 && t.getType() == 98).findFirst().get();
        if(ticket != null) {
            StringBuilder postData = new StringBuilder();
            Map<String, Object> params = new LinkedHashMap<String, Object>();
            params.put("refresh_token", ticket.getExtraInfo());
            params.put("client_id", StrasbourgPropsUtil.getGMBClientId());
            params.put("client_secret", StrasbourgPropsUtil.getGMBSecretCode());
            params.put("grant_type", "refresh_token");

            for (Map.Entry<String, Object> param : params.entrySet()) {
                if (postData.length() != 0)
                    postData.append('&');
                postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
                postData.append('=');
                postData.append(URLEncoder
                        .encode(String.valueOf(param.getValue()), "UTF-8"));
            }

            String url = StrasbourgPropsUtil.getGMBAccessTokenURL() + "?" + postData;
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setConnectTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
            conn.setReadTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
            conn.setDoOutput(true);
            conn.setFixedLengthStreamingMode(0);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", ContentTypes.APPLICATION_JSON);
            conn.setRequestProperty("charset", "utf-8");
            jsonResponse = PasserelleHelper.readJson(conn);
        }
        return jsonResponse;
    }

    public JSONObject toJson(Place place, Map<String, List<PlaceSchedule>> schedules) throws Exception{
        JSONObject jsonLocation = JSONFactoryUtil.createJSONObject();

        JSONObject jsonBusinessHours = JSONFactoryUtil.createJSONObject();
        JSONArray jsonPeriods = JSONFactoryUtil.createJSONArray();

        JSONObject jsonSpecialHours = JSONFactoryUtil.createJSONObject();
        JSONArray jsonSpecialHourPeriods = JSONFactoryUtil.createJSONArray();

        for (Map.Entry<String,  List<PlaceSchedule>> schedule : schedules.entrySet()) {
            for (PlaceSchedule placeSchedule : schedule.getValue()) {
                // récupère le jour concerné
                SimpleDateFormat formatter2 = new SimpleDateFormat("EEEE dd MMM yyyy", Locale.FRANCE);
                Date date = formatter2.parse(schedule.getKey());
                LocalDate dateLocale = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

                if(placeSchedule.isPublicHoliday() || placeSchedule.isException()){
                    JSONObject jsonDate = JSONFactoryUtil.createJSONObject();
                    jsonDate.put("year", dateLocale.getYear());
                    jsonDate.put("month", dateLocale.getMonth().getValue());
                    jsonDate.put("day", dateLocale.getDayOfMonth());

                    if(placeSchedule.isAlwaysOpen()){
                        JSONObject jsonPeriod = JSONFactoryUtil.createJSONObject();
                        jsonPeriod.put("startDate", jsonDate);
                        JSONObject jsonOpenTime = JSONFactoryUtil.createJSONObject();
                        jsonOpenTime.put("seconds", 0);
                        jsonOpenTime.put("nanos", 0);
                        jsonOpenTime.put("hours", 0);
                        jsonOpenTime.put("minutes", 0);
                        jsonPeriod.put("openTime", jsonOpenTime);
                        JSONObject jsonCloseTime = JSONFactoryUtil.createJSONObject();
                        jsonCloseTime.put("seconds", 0);
                        jsonCloseTime.put("nanos", 0);
                        jsonCloseTime.put("hours", 24);
                        jsonCloseTime.put("minutes", 0);
                        jsonPeriod.put("closeTime", jsonCloseTime);
                        jsonPeriod.put("closed", false);
                        jsonSpecialHourPeriods.put(jsonPeriod);
                    }else if (placeSchedule.isClosed()) {
                        JSONObject jsonPeriod = JSONFactoryUtil.createJSONObject();
                        jsonPeriod.put("startDate", jsonDate);
                        jsonPeriod.put("closed", true);
                        jsonSpecialHourPeriods.put(jsonPeriod);
                    }else {
                        for (Pair<LocalTime, LocalTime> openingTime : placeSchedule.getOpeningTimes()) {
                            JSONObject jsonPeriod = JSONFactoryUtil.createJSONObject();
                            jsonPeriod.put("startDate", jsonDate);
                            String[] time = openingTime.getFirst().toString().split(":");
                            JSONObject jsonOpenTime = JSONFactoryUtil.createJSONObject();
                            jsonOpenTime.put("seconds", 0);
                            jsonOpenTime.put("nanos", 0);
                            jsonOpenTime.put("hours", time[0]);
                            jsonOpenTime.put("minutes", time[1]);
                            jsonPeriod.put("openTime", jsonOpenTime);
                            time = openingTime.getSecond().toString().split(":");
                            JSONObject jsonCloseTime = JSONFactoryUtil.createJSONObject();
                            jsonCloseTime.put("seconds", 0);
                            jsonCloseTime.put("nanos", 0);
                            jsonCloseTime.put("hours", time[0]);
                            jsonCloseTime.put("minutes", time[1]);
                            jsonPeriod.put("closeTime", jsonCloseTime);
                            jsonPeriod.put("closed", false);
                            jsonSpecialHourPeriods.put(jsonPeriod);
                        }
                    }

                    // dans tous les cas il faut renseigner l'horaire par défaut
                    // récupération des horaires habituels
                    GregorianCalendar jourSemaine = GregorianCalendar.from(dateLocale.atStartOfDay(ZoneId.systemDefault()));
                    placeSchedule = place.getRegularPlaceSchedule(jourSemaine, Locale.FRANCE);
                }

                // récupère les horaires réguliers
                String day = dateLocale.getDayOfWeek().name();
                if (placeSchedule.isAlwaysOpen()) {
                    JSONObject jsonPeriod = JSONFactoryUtil.createJSONObject();
                    jsonPeriod.put("openDay", day);
                    JSONObject jsonOpenTime = JSONFactoryUtil.createJSONObject();
                    jsonOpenTime.put("seconds", 0);
                    jsonOpenTime.put("nanos", 0);
                    jsonOpenTime.put("hours", 0);
                    jsonOpenTime.put("minutes", 0);
                    jsonPeriod.put("openTime", jsonOpenTime);
                    jsonPeriod.put("closeDay", day);
                    JSONObject jsonCloseTime = JSONFactoryUtil.createJSONObject();
                    jsonCloseTime.put("seconds", 0);
                    jsonCloseTime.put("nanos", 0);
                    jsonCloseTime.put("hours", 24);
                    jsonCloseTime.put("minutes", 0);
                    jsonPeriod.put("closeTime", jsonCloseTime);
                    jsonPeriods.put(jsonPeriod);
                } // Dans le cas où le lieu n'est pas fermé, il a des horaires d'ouverture
                else if (!placeSchedule.isClosed()) {
                    for (Pair<LocalTime, LocalTime> openingTime : placeSchedule.getOpeningTimes()) {
                        JSONObject jsonPeriod = JSONFactoryUtil.createJSONObject();
                        jsonPeriod.put("openDay", day);
                        String[] time = openingTime.getFirst().toString().split(":");
                        JSONObject jsonOpenTime = JSONFactoryUtil.createJSONObject();
                        jsonOpenTime.put("seconds", 0);
                        jsonOpenTime.put("nanos", 0);
                        jsonOpenTime.put("hours", time[0]);
                        jsonOpenTime.put("minutes", time[1]);
                        jsonPeriod.put("openTime", jsonOpenTime);
                        jsonPeriod.put("closeDay", day);
                        time = openingTime.getSecond().toString().split(":");
                        JSONObject jsonCloseTime = JSONFactoryUtil.createJSONObject();
                        jsonCloseTime.put("seconds", 0);
                        jsonCloseTime.put("nanos", 0);
                        jsonCloseTime.put("hours", time[0]);
                        jsonCloseTime.put("minutes", time[1]);
                        jsonPeriod.put("closeTime", jsonCloseTime);
                        jsonPeriods.put(jsonPeriod);
                    }
                }

            }
        }

        jsonBusinessHours.put("periods", jsonPeriods);
        jsonLocation.put("regularHours", jsonBusinessHours);

        jsonSpecialHours.put("specialHourPeriods", jsonSpecialHourPeriods);
        jsonLocation.put("specialHours", jsonSpecialHours);
        return jsonLocation;
    }

    public JSONObject getSynchronisationResult(String locationId, String accessToken, JSONObject jsonSchedule) throws Exception{
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();

        // Paramètres
        StringBuilder postData = new StringBuilder();
        Map<String, Object> params = new LinkedHashMap<String, Object>();
        params.put("updateMask", "regularHours,specialHours");
        params.put("validateOnly", "false");
        for (Map.Entry<String, Object> param : params.entrySet()) {
            if (postData.length() != 0)
                postData.append('&');
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder
                    .encode(String.valueOf(param.getValue()), "UTF-8"));
        }
        byte[] postDataByte = postData.toString().getBytes(StandardCharsets.UTF_8);

        String url = StrasbourgPropsUtil.getGMBUpdateUrl() + "/" + locationId + "?" + postData;
        URL u = new URL(url);
        HttpURLConnection conn = (HttpURLConnection) u.openConnection();
        conn.setConnectTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
        conn.setReadTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
        conn.setRequestProperty("Authorization", "Bearer " + accessToken);
        conn.setDoOutput(true);
        conn.setInstanceFollowRedirects(false);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-HTTP-Method-Override", "PATCH");
        conn.setRequestProperty("Content-Type", ContentTypes.APPLICATION_JSON);
        conn.setRequestProperty("Accept", ContentTypes.APPLICATION_JSON);
        conn.setRequestProperty("charset", "utf-8");
        conn.setRequestProperty("Content-Length", String.valueOf(postDataByte.length));

        // Paramètres du body
        byte[] postDataBodyByte = jsonSchedule.toString().getBytes(StandardCharsets.UTF_8);
        try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
            wr.write(postDataBodyByte);
        }

        jsonResponse = PasserelleHelper.readJson(conn);

        return jsonResponse;
    }

    public GoogleMyBusinessHistoric getGoogleMyBusinessHistoric() {
        return googleMyBusinessHistoric;
    }

    public void setGoogleMyBusinessHistoric(GoogleMyBusinessHistoric googleMyBusinessHistoric) {
        this.googleMyBusinessHistoric = googleMyBusinessHistoric;
    }
}
