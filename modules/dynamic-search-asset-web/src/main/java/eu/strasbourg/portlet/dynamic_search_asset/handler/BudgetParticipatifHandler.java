package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class BudgetParticipatifHandler extends AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        BudgetParticipatif bp = BudgetParticipatifLocalServiceUtil.fetchBudgetParticipatif(assetEntry.getClassPK());
        if (bp == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonBP = JSONSearchHelper.createBudgetParticipatifSearchJson(bp, locale, themeDisplay, configAffichage);
        jsonBP = JSONSearchHelper.createAssetEntrySearchJson(jsonBP, assetEntry);
        jsonResponse.put(jsonBP);
    }
}
