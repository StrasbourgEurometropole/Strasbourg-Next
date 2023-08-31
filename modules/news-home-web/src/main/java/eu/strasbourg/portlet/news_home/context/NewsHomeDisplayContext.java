package eu.strasbourg.portlet.news_home.context;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.publisher.util.AssetPublisherHelper;
import com.liferay.journal.model.JournalArticle;
import com.liferay.journal.service.JournalArticleLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;
import eu.strasbourg.portlet.news_home.NewsHomeItem;
import eu.strasbourg.portlet.news_home.configuration.NewsHomeConfiguration;
import eu.strasbourg.utils.AssetPublisherTemplateHelper;
import eu.strasbourg.utils.PortalHelper;
import eu.strasbourg.utils.UriHelper;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
public class NewsHomeDisplayContext extends BaseDisplayContext {

    private NewsHomeConfiguration configuration;
    private List<AssetEntry> assetEntries;
    private ThemeDisplay _themeDisplay;

    public NewsHomeDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response);
        try {
            this.configuration = _themeDisplay.getPortletDisplay()
                    .getPortletInstanceConfiguration(NewsHomeConfiguration.class);
        } catch (ConfigurationException e) {
            _log.error(e.getMessage(), e);
        }
    }

    /**
     * Récupère la configuration du portlet NewsHome.
     *
     * @return Configuration du portlet NewsHome.
     */
    public NewsHomeConfiguration getConfiguration() {
        return configuration;
    }

    /**
     * Récupère l'URL de la page d'accueil.
     *
     * @return URL de la page d'accueil.
     */
    public String getHomeURL() {
        return PortalHelper.getHomeURL(_themeDisplay);
    }

    /**
     * Récupère l'URL du portail.
     *
     * @return URL du portail.
     */
    public String getPortalURL() {
        return PortalHelper.getPortalURL(_themeDisplay);
    }

    /**
     * Récupère le lien configuré dans la portlet.
     *
     * @return Lien configuré.
     */
    public String getLink() {
        return configuration.link();
    }

    /**
     * Récupère et retourne une liste de NewsHomeItem à partir des configurations des actualités.
     *
     * @return Liste de NewsHomeItem contenant les actualités configurées.
     */
    public List<NewsHomeItem> getAssetEntries() {
        List<NewsHomeItem> newsItems = Arrays.stream(configuration.classPKs().split(","))
                .map(s -> s.isEmpty() ? null : Long.parseLong(s))
                .map(classPK -> {
                    if (classPK == null) {
                        return null;
                    }
                    try {
                        AssetEntry entry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);
                        JournalArticle journalArticle = JournalArticleLocalServiceUtil.fetchLatestArticle(classPK, 0);
                        // Crée un nouvel objet NewsHomeItem si l'article existe, sinon retourne null
                        return journalArticle != null ? new NewsHomeItem(journalArticle, entry ,  _themeDisplay.getLocale(), _request, _response) : null;
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }

                })
                .collect(Collectors.toList());

        return newsItems;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass());
}