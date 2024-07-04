package eu.strasbourg.portlet.dynamic_search_asset.handler;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.portlet.dynamic_search_asset.JSONSearchHelper;
import eu.strasbourg.portlet.dynamic_search_asset.constants.Constants;
import eu.strasbourg.utils.JournalArticleHelper;
import eu.strasbourg.utils.api.FileEntryHelperService;

import java.text.Collator;
import java.util.Locale;

public class JournalArticleHandler extends AssetHandler{
    @Override
    public void handleAsset(FileEntryHelperService fileEntryHelperService, JSONArray jsonResponse, AssetEntry assetEntry, Locale locale, ThemeDisplay themeDisplay, String publikUserId, String configAffichage, int descriptionMaxLength) throws PortalException {
        String[] tagNames = assetEntry.getTagNames();

        // Outil permettant de passer outre les accents lors d'un test d'équivalence
        Collator collator = Collator.getInstance();
        collator.setStrength(Collator.NO_DECOMPOSITION);
        boolean containsNewsTagName = false;

        // Vérification de la véracité d'un JournalArticle de type actualité pour placit
        for (String nameToTest : tagNames) {
            if (collator.compare(nameToTest, Constants.NEWS_TAG_NAME) == 0 || collator.compare(nameToTest, Constants.ARTICLES_TAG_NAME) == 0) {
                containsNewsTagName = true;
            }
        }

        // Si tel est le cas
        if (containsNewsTagName || !configAffichage.equals(Constants.SEARCH_FORM_PLACIT)) {
            try {
                JournalArticle journalArticle = JournalArticleServiceUtil.getLatestArticle(assetEntry.getClassPK());
                String documentStructure = JournalArticleHelper.getJournalArticleFieldValue(journalArticle, "thumbnail", locale);
                // Parse les données JSON
                JSONObject documentJSONObject = JSONFactoryUtil.createJSONObject(documentStructure);

                JSONObject jsonArticle = JSONSearchHelper.createJournalArticleSearchJson(assetEntry, journalArticle, getImageURL(fileEntryHelperService, documentJSONObject.getLong("fileEntryId")), locale, themeDisplay, configAffichage, descriptionMaxLength, publikUserId);
                jsonArticle = JSONSearchHelper.createAssetEntrySearchJson(jsonArticle, assetEntry);
                jsonResponse.put(jsonArticle);
            } catch (Exception e) {
                _log.error(e);
            }
        }
    }
}
