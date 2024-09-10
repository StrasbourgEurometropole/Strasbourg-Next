package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.service.EditionLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class EditionHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        Edition edition = EditionLocalServiceUtil.fetchEdition(assetEntry.getClassPK());
        if (edition == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
                JSONObject jsonEdition = JSONSearchHelper.createEditionSearchJson(edition, getImageURL(fileEntryHelperService, edition.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength, publikUserId);
                jsonEdition = JSONSearchHelper.createAssetEntrySearchJson(jsonEdition, assetEntry);
                jsonResponse.put(jsonEdition);
    }
}
