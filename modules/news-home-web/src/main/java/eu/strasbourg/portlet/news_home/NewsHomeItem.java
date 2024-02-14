package eu.strasbourg.portlet.news_home;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetCategoryUtil;
import com.liferay.asset.publisher.util.AssetPublisherHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.LiferayPortletResponse;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.JournalArticleHelper;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.StringReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class NewsHomeItem {
    Date publicationDate;
    String category;
    String title;
    String description;
    String descriptionCourt;
    String imageURL;
    String detailURL;
    String titleCourt;

    /**
     * Construit un objet NewsHomeItem en utilisant les informations d'un JournalArticle et d'une AssetEntry.
     *
     * @param article   Le JournalArticle contenant les informations de la news.
     * @param entry     La AssetEntry représentant l'entrée de la news.
     * @param locale    La locale pour les données spécifiques à la langue.
     * @param request   Le RenderRequest pour des fins de rendu.
     * @param response  Le RenderResponse pour des fins de rendu.
     * @throws Exception S'il y a des erreurs lors de la construction.
     */
    public NewsHomeItem(JournalArticle article, AssetEntry entry, Locale locale, RenderRequest request, RenderResponse response) throws Exception {
        this.publicationDate = article.getModifiedDate();

        // Collecte les catégories et les joint avec un séparateur
        this.category = AssetVocabularyHelper.getAssetEntryCategoriesByVocabulary(entry, "type d'actualite")
                .stream().map(assetCategory -> assetCategory.getTitle(locale))
                .collect(Collectors.joining(" - "));

        this.title = JournalArticleHelper.getJournalArticleFieldValue(article, "title", locale);
        this.titleCourt = JournalArticleHelper.getJournalArticleFieldValue(article, "TitleShort", locale, true);
        this.description = JournalArticleHelper.getJournalArticleFieldValue(article, "chapo", locale);
        // truncate description to 80 character and add "..."
        if (this.description.length() > 80) {
            this.descriptionCourt = this.description.substring(0, 80) + "...";
        }
        else {
            this.descriptionCourt = this.description;
        }

        // Récupère la structure du document de la vignette et obtient l'URL de l'image
        String documentStructure = JournalArticleHelper.getJournalArticleFieldValue(article, "thumbnail", locale);
        this.imageURL = AssetPublisherTemplateHelper.getDocumentUrl(documentStructure);

        // Obtient l'URL pour afficher les détails de l'entrée de la news
        this.detailURL = entry.getAssetRenderer().getURLViewInContext((LiferayPortletRequest) request, (LiferayPortletResponse) response, null);
    }

    /**
     * Formate la date de publication au format "dd/MM/yyyy".
     *
     * @return Date de publication formatée.
     */
    public String getPublicationDate() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(publicationDate);
    }

    public String getCategory() {
        return category;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getDetailURL() {
        return detailURL;
    }

    public String getTitleCourt() {
        return titleCourt;
    }

    public String getDescriptionCourt() {
        return descriptionCourt;
    }
}