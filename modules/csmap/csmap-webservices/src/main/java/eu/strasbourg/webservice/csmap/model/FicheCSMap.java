package eu.strasbourg.webservice.csmap.model;

import com.liferay.portal.json.JSONArrayImpl;
import com.liferay.portal.json.JSONObjectImpl;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.HashMap;

public class FicheCSMap {
    private final String uuid;
    private final String id;
    private final String internalId;
    private final String displayId;
    private final String displayName;
    private final String digests;
    private final String text;
    private final String url;
    private final String receiptTime;
    private final String lastUpdateTime;
    private final int criticalityLevel;
    private final String apiUrl;
    private final String backofficeUrl;
    private final HashMap<String, Object> fields;

    public FicheCSMap(JSONObject jsonObject) {
        this.uuid = jsonObject.getString("uuid");
        this.id = jsonObject.getString("id");
        this.internalId = jsonObject.getString("internalId");
        this.displayId = jsonObject.getString("displayId");
        this.displayName = jsonObject.getString("displayName");
        this.digests = jsonObject.getString("digests");
        this.text = jsonObject.getString("text");
        this.url = jsonObject.getString("url");
        this.receiptTime = jsonObject.getString("receiptTime");
        this.lastUpdateTime = jsonObject.getString("lastUpdateTime");
        this.criticalityLevel = jsonObject.getInt("criticalityLevel");
        this.apiUrl = jsonObject.getString("apiUrl");
        this.backofficeUrl = jsonObject.getString("backofficeUrl");
        this.fields = new HashMap<>();
        JSONObject fields = jsonObject.getJSONObject("fields");
        for (String key : fields.keySet()) {
            this.fields.put(key, fields.get(key));
        }
    }

    // Getters
    public String getPublikId() {
        return uuid;
    }

    public String getId() {
        return id;
    }

    public String getInternalId() {
        return internalId;
    }

    public String getDisplayId() {
        return displayId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDigests() {
        return digests;
    }

    public String getText() {
        return text;
    }

    public String getUrl() {
        return url;
    }

    public String getReceiptTime() {
        return receiptTime;
    }

    public String getLastUpdateTime() {
        return lastUpdateTime;
    }

    public int getCriticalityLevel() {
        return criticalityLevel;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getBackofficeUrl() {
        return backofficeUrl;
    }

    public HashMap<String, Object> getFields() {
        return fields;
    }

    public JSONArray constructStatusJsonArray() {
        JSONArray jsonArray = new JSONArrayImpl();
        for (String key : fields.keySet()) {
            if (key.startsWith("statut_")) {
                JSONObject statusObject = new JSONObjectImpl();
                statusObject.put("label", key);
                statusObject.put("value", fields.get(key));
                jsonArray.put(statusObject);
            }
        }
        return jsonArray;
    }
}
