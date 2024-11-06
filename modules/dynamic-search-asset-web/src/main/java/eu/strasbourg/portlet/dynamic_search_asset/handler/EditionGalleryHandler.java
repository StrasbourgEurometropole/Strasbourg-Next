package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionGalleryLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class EditionGalleryHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        EditionGallery editionGallery = EditionGalleryLocalServiceUtil.fetchEditionGallery(assetEntry.getClassPK());
        if (editionGallery == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonEditionGallery = JSONSearchHelper.createEditionGallerySearchJson(editionGallery, getImageURL(fileEntryHelperService, editionGallery.getImageId()), locale, themeDisplay, configAffichage, descriptionMaxLength);
        jsonEditionGallery = JSONSearchHelper.createAssetEntrySearchJson(jsonEditionGallery, assetEntry);
        jsonResponse.put(jsonEditionGallery);
    }
}
