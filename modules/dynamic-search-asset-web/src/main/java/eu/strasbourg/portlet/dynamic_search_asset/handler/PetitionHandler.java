package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.service.PetitionLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class PetitionHandler extends AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse,
                     AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay,
                     String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {

        Petition petition = PetitionLocalServiceUtil.fetchPetition(assetEntry.getClassPK());
        if (petition == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonPetition = JSONSearchHelper.createPetitionSearchJson(petition, getImageURL(fileEntryHelperService, petition.getImageId()), themeDisplay, configAffichage);
        jsonPetition = JSONSearchHelper.createAssetEntrySearchJson(jsonPetition, assetEntry);
        jsonResponse.put(jsonPetition);
    }
}
