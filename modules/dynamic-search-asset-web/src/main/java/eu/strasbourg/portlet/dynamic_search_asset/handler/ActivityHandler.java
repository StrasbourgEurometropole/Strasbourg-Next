package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.activity.model.Activity;
import eu.strasbourg.service.activity.service.ActivityLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class ActivityHandler  extends  AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        Activity activity = ActivityLocalServiceUtil.fetchActivity(assetEntry.getClassPK());
        if (activity == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
                JSONObject jsonActivity = JSONSearchHelper.createActivitySearchJson(activity, getImageURL(fileEntryHelperService, activity.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength);
                jsonActivity = JSONSearchHelper.createAssetEntrySearchJson(jsonActivity, assetEntry);
                jsonResponse.put(jsonActivity);
    }
}
