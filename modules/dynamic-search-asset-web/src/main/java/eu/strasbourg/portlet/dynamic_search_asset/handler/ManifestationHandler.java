package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.ManifestationLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class ManifestationHandler extends AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        Manifestation manifestation = ManifestationLocalServiceUtil.fetchManifestation(assetEntry.getClassPK());
        if (manifestation == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonManifestation = JSONSearchHelper.createManifestationSearchJson(manifestation, locale, themeDisplay, configAffichage, descriptionMaxLength);
        jsonManifestation = JSONSearchHelper.createAssetEntrySearchJson(jsonManifestation, assetEntry);
        jsonResponse.put(jsonManifestation);
    }
}
