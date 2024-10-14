package eu.strasbourg.portlet.dynamic_search_asset.handler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.documentlibrary.lar.FileEntryUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;
import java.util.logging.Logger;

public abstract class AssetHandler {
    public abstract void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse,
                     AssetEntry assetEntry,
                     Locale locale,
                     ThemeDisplay themeDisplay,
                     String publikUserId,
                     String configAffichage,
                     int descriptionMaxLength) throws PortalException;

    protected String getImageURL(FileEntryHelperService fileEntryHelperService, long fileEntryId) {
        if (Validator.isNotNull(fileEntryId)) {
            FileEntry fileEntry = FileEntryUtil.fetchByPrimaryKey(fileEntryId);
            if (Validator.isNotNull(fileEntry)) {
                return fileEntryHelperService.getClosestSizeImageURL(fileEntry, 100);
            } else {
                _log.warn("DynamicSearchtAsset File not found : " + fileEntryId);
            }
        }
        return "";
    }

    protected static final Log _log = LogFactoryUtil.getLog(AssetHandler.class);

    protected void logNotFound(String className, long classPK) {
        _log.warn("DynamicSearchAsset " + className + " not found : " + classPK);
    }
}