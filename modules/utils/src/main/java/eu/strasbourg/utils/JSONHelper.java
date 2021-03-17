package eu.strasbourg.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.Validator;

public class JSONHelper {

    public static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromURL(String URL, String basicAuthUser, String basicAuthPassword, int timeout)
            throws IOException, JSONException {
        HttpURLConnection httpConn = (HttpURLConnection) new URL(URL).openConnection();
        httpConn.setConnectTimeout(timeout);
        httpConn.setReadTimeout(timeout);
        if (basicAuthUser != null && basicAuthPassword != null) {
            String encoded = Base64.getEncoder()
                    .encodeToString((basicAuthUser + ":" + basicAuthPassword).getBytes(Charset.forName("UTF-8")));
            httpConn.setRequestProperty("Authorization", "Basic " + encoded);
        }
        InputStream is;
        if (httpConn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
            is = httpConn.getInputStream();
        } else {
            /* error from server */
            is = httpConn.getErrorStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String errorText = readAll(rd);
            LogFactoryUtil.getLog(JSONHelper.class).error(errorText);
            throw new IOException();
        }

        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONFactoryUtil.createJSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static void put(String URL, String lastName, String address, String zipCode, String city, String basicAuthUser,
                           String basicAuthPassword) throws IOException, JSONException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URL).openConnection();
        try {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("PUT");
            if (basicAuthUser != null && basicAuthPassword != null) {
                String encoded = Base64.getEncoder()
                        .encodeToString((basicAuthUser + ":" + basicAuthPassword).getBytes(Charset.forName("UTF-8")));
                httpURLConnection.setRequestProperty("Authorization", "Basic " + encoded);
            }
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            String jsonAddress = "{\"last_name\": \"" + lastName + "\",\"address\":\"" + address + "\", \"zipcode\":\"" + zipCode + "\", \"city\":\"" + city + "\"}";

            DataOutputStream out = new DataOutputStream(httpURLConnection.getOutputStream());
            out.writeBytes(jsonAddress);
            out.flush();
            out.close();

            httpURLConnection.connect();

            BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
            StringBuffer bfr = new StringBuffer();
            String output = "";
            while ((output = br.readLine()) != null) {
                bfr.append(output);
            }
            if (httpURLConnection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
                /* error from server */
                throw new IOException();
            }
        } catch (Exception e) {
        	LogFactoryUtil.getLog(JSONHelper.class).error(e.getMessage());
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static void put(String URL, String lastName, String address, String zipCode, String city, String phoneNumber, String cellNumber, String dateNaiss, String basicAuthUser,
                           String basicAuthPassword) throws IOException, JSONException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(URL).openConnection();
        try {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setRequestMethod("PUT");
            if (basicAuthUser != null && basicAuthPassword != null) {
                String encoded = Base64.getEncoder()
                        .encodeToString((basicAuthUser + ":" + basicAuthPassword).getBytes(Charset.forName("UTF-8")));
                httpURLConnection.setRequestProperty("Authorization", "Basic " + encoded);
            }
            httpURLConnection.setRequestProperty("Accept", "application/json");
            httpURLConnection.setRequestProperty("Content-Type", "application/json");

            String jsonInfos = "{\"last_name\": \"" + lastName + "\",\"address\":\"" + address + "\", \"zipcode\":\"" +
                    zipCode + "\", \"city\":\"" + city + "\", \"birthdate\":\"" + dateNaiss + "\"";
            if(Validator.isNotNull(phoneNumber)) {
                jsonInfos += ", \"phone\":\"" + phoneNumber + "\"";
            } else {
            	jsonInfos += ", \"phone\":\"\"";
            }
            if(Validator.isNotNull(cellNumber)) {
                jsonInfos += ", \"mobile\":\"" + cellNumber + "\"";
            } else {
            	jsonInfos += ", \"mobile\":\"\"";
            }
            jsonInfos += "}";
            
            Charset.forName("UTF-8").encode(jsonInfos);

            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8"));
            out.write(jsonInfos);
            out.flush();
            out.close();

            httpURLConnection.connect();
            
            // Dans le cas d'une erreur catchee par le serveur
            if (httpURLConnection.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
            	BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getErrorStream())));
                StringBuffer bfr = new StringBuffer();
                String output = "";
                while ((output = br.readLine()) != null) {
                    bfr.append(output);
                }
                
                throw new Exception(bfr.toString());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((httpURLConnection.getInputStream())));
            StringBuffer bfr = new StringBuffer();
            String output = "";
            while ((output = br.readLine()) != null) {
                bfr.append(output);
            }            
            
        } catch (Exception e) {
        	LogFactoryUtil.getLog(JSONHelper.class).error(e.getMessage());
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public static JSONObject readJsonFromURL(String URL) throws IOException, JSONException {
        return JSONHelper.readJsonFromURL(URL, null, null, StrasbourgPropsUtil.getWebServiceDefaultTimeout());
    }

    public static JSONObject readJsonFromURL(String URL, int timeout) throws IOException, JSONException {
        return JSONHelper.readJsonFromURL(URL, null, null, timeout);
    }

    public static JSONObject readJsonFromURL(String URL, String basicAuthUser, String basicAuthPassword) throws IOException, JSONException {
        return JSONHelper.readJsonFromURL(URL, basicAuthUser, basicAuthPassword, StrasbourgPropsUtil.getWebServiceDefaultTimeout());
    }

    public static JSONArray readJsonArrayFromURL(String URL) throws IOException, JSONException {
        URL url = new URL(URL);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setConnectTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
        httpConn.setReadTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
        InputStream is;
        if (httpConn.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
            is = httpConn.getInputStream();
        } else {
            /* error from server */
            is = httpConn.getErrorStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String errorText = readAll(rd);
            LogFactoryUtil.getLog(JSONHelper.class).error(errorText);
            throw new IOException();
        }
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONArray json = JSONFactoryUtil.createJSONArray(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public static JSONObject getJSONFromI18nMap(Map<Locale, String> map) {
        JSONObject json = JSONFactoryUtil.createJSONObject();
        for (Map.Entry<Locale, String> entry : map.entrySet()) {
            json.put(entry.getKey().toString(), entry.getValue());
        }
        return json;
    }

    public static JSONArray getEntityVocabularyJSON(String className, String vocabularyName, long groupId) {
        long classNameId = ClassNameLocalServiceUtil.getClassName(className).getClassNameId();
        List<AssetVocabulary> vocabularies = AssetVocabularyHelper.getVocabulariesForAssetType(groupId, classNameId);
        for (AssetVocabulary vocabulary : vocabularies) {
            if (StringHelper.compareIgnoringAccentuation(vocabulary.getName().toLowerCase(), vocabularyName)) {
                return AssetVocabularyHelper.toJSON(vocabulary);
            }
        }
        return JSONFactoryUtil.createJSONArray();
    }

    public static List<Locale> getLocalesUsedInJSON(JSONObject json) {
        Iterator<String> keyIterator = json.keys();
        ArrayList<Locale> locales = new ArrayList<Locale>();
        while (keyIterator.hasNext()) {
            String key = keyIterator.next();
            JSONObject subJson = json.getJSONObject(key);
            JSONArray subJsonArray = json.getJSONArray(key);
            if (subJson != null) {
                locales.addAll(JSONHelper.getLocalesUsedInJSON(subJson));
            }
            if (subJsonArray != null) {
                for (int i = 0; i < subJsonArray.length(); i++) {
                    JSONObject subJsonArrayObject = subJsonArray.getJSONObject(i);
                    if (subJsonArrayObject != null) {
                        locales.addAll(JSONHelper.getLocalesUsedInJSON(subJsonArrayObject));
                    }
                }
            }
            if (subJson == null && subJsonArray == null) {
                Locale locale = LocaleUtil.fromLanguageId(key, true, false);
                if (locale != null && Validator.isNotNull(json.getString(key))) {
                    locales.add(locale);
                }
            }
        }
        return locales;
    }

    public static boolean validateI18nField(JSONObject json, List<Locale> locales) {
        boolean valid = true;
        if (json == null) {
            return false;
        }
        for (Locale locale : locales) {
            if (Validator.isNull(json.getString(locale.toString()))) {
                valid = false;
                break;
            }
        }
        return valid;
    }

    public static JSONObject readJsonFromInputStream(InputStream is) throws IOException, JSONException {
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = JSONFactoryUtil.createJSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

}
