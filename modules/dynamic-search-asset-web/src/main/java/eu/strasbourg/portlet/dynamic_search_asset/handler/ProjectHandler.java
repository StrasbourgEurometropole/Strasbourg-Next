package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.service.project.model.Project;
import eu.strasbourg.service.project.service.ProjectLocalServiceUtil;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.util.Locale;

public class ProjectHandler extends AssetHandler {
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService,
                     JSONArray jsonResponse, AssetEntry assetEntry,
                     Locale locale, ThemeDisplay themeDisplay,
                     String publikUserId, String configAffichage, int descriptionMaxLength) {
        Project project = ProjectLocalServiceUtil.fetchProject(assetEntry.getClassPK());
        if (project == null) {
            logNotFound(assetEntry.getClassName(), assetEntry.getClassPK());
            return;
        }
        JSONObject jsonProject = JSONSearchHelper.createProjectSearchJson(project, getImageURL(fileEntryHelperService, project.getImageId()), themeDisplay, configAffichage, descriptionMaxLength);
        jsonProject = JSONSearchHelper.createAssetEntrySearchJson(jsonProject, assetEntry);
        jsonResponse.put(jsonProject);
    }
}
