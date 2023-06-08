package eu.strasbourg.portlet.place.display.context;

import com.liferay.item.selector.ItemSelector;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Ticket;
import com.liferay.portal.kernel.service.TicketLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ViewTokenDisplayContext {

    private final RenderRequest _request;
    private final RenderResponse _response;
    private String refreshToken;
    private Ticket lastAccesToken;
    private List<String> _locationIds;

    public ViewTokenDisplayContext(RenderRequest request,
                                   RenderResponse response, ItemSelector itemSelector) {
        _request = request;
        _response = response;
        _themeDisplay = (ThemeDisplay) _request
                .getAttribute(WebKeys.THEME_DISPLAY);
        _httpServletRequest = PortalUtil.getHttpServletRequest(request);
        _itemSelector=itemSelector;
    }

    public String getOrderByCol() {
        return null;
    }

    public String getOrderByType() {
        return null;
    }

    public String getFilterCategoriesIds() throws PortalException {
        return null;
    }

    public String getRefeshToken() throws PortalException {
        if (this.refreshToken == null) {
            // récupération du ticket de type 98 (refresh-token)
            Ticket ticket = TicketLocalServiceUtil.getTickets(-1,-1).stream()
                    .filter(t -> t.getType() == 98).findFirst().orElse(null);
            if (ticket != null) {
                this.refreshToken = ticket.getExtraInfo();
            }
        }
        return this.refreshToken;
    }

    public Ticket getLastAccessToken() throws PortalException {
        if (this.lastAccesToken == null) {
            // récupération du ticket de type 99(acces-token)
            lastAccesToken = TicketLocalServiceUtil.getTickets(-1,-1).stream()
                    .filter(t -> t.getType() == 99).findFirst().orElse(null);
        }
        return this.lastAccesToken;
    }

    public Map<String, String> getLocationIds(){
        Map<String, String> locationIds = new HashMap<String, String>();
        //récupère les infos des lieux
        JSONObject json = null;
        try {
            json = getLocation();
        } catch (Exception e) {
            _log.error(e);
        }
        String error = json.getString("error");
        if (Validator.isNull(error)) {
            JSONArray locations = json.getJSONArray("locations");
            for (Object location : locations) {
                JSONObject jsonLocation = null;
                try {
                    jsonLocation = JSONFactoryUtil.createJSONObject(location.toString());
                } catch (JSONException e) {
                    _log.error(e);
                }
                String lieu = jsonLocation.getString("title");
                String locationId = jsonLocation.getString("name").split("locations/")[1];
                locationIds.put(lieu,locationId);
            }
        }else{
            _log.error(error);
        }
        return locationIds;
    }

    public JSONObject getLocation() throws Exception{
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        //récupère l'accessToken (className = "" , classPK = 0, type = 99)
        JSONObject json = getJSONAccesToken();
        String error = json.getString("error");
        if (Validator.isNull(error)) {
            String accessToken = json.getString("access_token");

            String url = StrasbourgPropsUtil.getGMBListUrl() + "?readMask=name,title&pageSize=100";
            URL u = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setConnectTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
            conn.setReadTimeout(StrasbourgPropsUtil.getWebServiceDefaultTimeout());
            conn.setRequestProperty("Authorization", "Bearer " + accessToken);
            conn.setDoOutput(true);
//            conn.setFixedLengthStreamingMode(0);
            conn.setRequestMethod("GET");
//            conn.setRequestProperty("Content-Type", ContentTypes.APPLICATION_JSON);
//            conn.setRequestProperty("charset", "utf-8");
            jsonResponse = PasserelleHelper.readJson(conn);
        }
        return jsonResponse;
    }

    public JSONObject getJSONAccesToken() throws Exception{
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

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    protected ThemeDisplay _themeDisplay;
    private final HttpServletRequest _httpServletRequest;
    private final ItemSelector _itemSelector;
}
