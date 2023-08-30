package eu.strasbourg.portlet.news_home;

import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetCategoryUtil;
import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Document;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.JournalArticleHelper;

import java.io.StringReader;
import java.util.Date;
import java.util.Locale;

public class NewsHomeItem {
    Date publicationDate;
    String category;
    String title;
    String description;
    String imageURL;

    public NewsHomeItem(JournalArticle article, Locale locale) {
        this.publicationDate = article.getLastPublishDate();
        this.category = AssetCategoryLocalServiceUtil.getCategories(JournalArticle.class.getName(), article.getClassPK()).stream().map(assetCategory -> assetCategory.getTitle(locale)).toString();
        this.title = JournalArticleHelper.getJournalArticleFieldValue(article, "title", locale);
        this.description = JournalArticleHelper.getJournalArticleFieldValue(article, "chapo", locale);
        String documentStructure = JournalArticleHelper.getJournalArticleFieldValue(article, "thumbnail", locale);
        this.imageURL = AssetPublisherTemplateHelper.getDocumentUrl(documentStructure);
    }

    public Date getPublicationDate() {
        return publicationDate;
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
}
