package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.activity.model.ActivityCourse;
import eu.strasbourg.service.activity.service.ActivityCourseLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class ActivityCourseHandler extends  AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        ActivityCourse activityCourse = ActivityCourseLocalServiceUtil.fetchActivityCourse(assetEntry.getClassPK());
        if (activityCourse == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonActivityCourse = JSONSearchHelper.createActivityCourseSearchJson(activityCourse, getImageURL(fileEntryHelperService, activityCourse.getActivity().getImageId()), locale, themeDisplay, configAffichage);
        jsonActivityCourse = JSONSearchHelper.createAssetEntrySearchJson(jsonActivityCourse, assetEntry);
        jsonResponse.put(jsonActivityCourse);
    }
}
