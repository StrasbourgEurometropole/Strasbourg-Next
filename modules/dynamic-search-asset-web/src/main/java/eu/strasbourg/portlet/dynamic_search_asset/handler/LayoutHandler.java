package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class LayoutHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        Layout layout = LayoutLocalServiceUtil.fetchLayout(assetEntry.getClassPK());
        if (layout == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonArticle = JSONSearchHelper.createLayoutSearchJson(assetEntry, layout, themeDisplay, publikUserId, 100);
        jsonArticle = JSONSearchHelper.createAssetEntrySearchJson(jsonArticle, assetEntry);
        jsonResponse.put(jsonArticle);
    }
}
