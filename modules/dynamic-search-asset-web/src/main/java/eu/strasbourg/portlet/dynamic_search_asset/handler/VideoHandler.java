package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.video.model.Video;
import eu.strasbourg.service.video.service.VideoLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class VideoHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse,
                     AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay,
                     String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {

        Video video = VideoLocalServiceUtil.fetchVideo(assetEntry.getClassPK());
        if (video == null) {
            return;
        }
        JSONObject jsonVideo = JSONSearchHelper.createVideoSearchJson(video, getImageURL(fileEntryHelperService, video.getImageId()), locale, themeDisplay, configAffichage);
        jsonVideo = JSONSearchHelper.createAssetEntrySearchJson(jsonVideo, assetEntry);
        jsonResponse.put(jsonVideo);
    }
}
