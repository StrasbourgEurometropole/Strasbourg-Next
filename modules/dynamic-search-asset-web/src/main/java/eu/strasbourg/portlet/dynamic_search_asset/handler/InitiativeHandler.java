package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.service.InitiativeLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class InitiativeHandler extends AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse,
                     AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay,
                     String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        Initiative initiative = InitiativeLocalServiceUtil.fetchInitiative(assetEntry.getClassPK());
        if (initiative == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonInitiative = JSONSearchHelper.createInitiativeSearchJson(initiative, getImageURL(fileEntryHelperService, initiative.getImageId()), themeDisplay, configAffichage);
        jsonInitiative = JSONSearchHelper.createAssetEntrySearchJson(jsonInitiative, assetEntry);
        jsonResponse.put(jsonInitiative);
    }
}
