package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class EventHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) {
        Event event = EventLocalServiceUtil.fetchEvent(assetEntry.getClassPK());
        if(event == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonEvent = JSONSearchHelper.createEventSearchJson(event, getImageURL(fileEntryHelperService, event.getImageId()), locale, themeDisplay, publikUserId, configAffichage, descriptionMaxLength);
        jsonEvent = JSONSearchHelper.createAssetEntrySearchJson(jsonEvent, assetEntry);
        jsonResponse.put(jsonEvent);
    }
}