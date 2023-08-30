package eu.strasbourg.portlet.news_home.context;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
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

    public NewsHomeDisplayContext(RenderRequest request, RenderResponse response) {
        super(request, response);
        try {
            this.configuration = _themeDisplay.getPortletDisplay()
                    .getPortletInstanceConfiguration(NewsHomeConfiguration.class);
        } catch (ConfigurationException e) {
            _log.error(e.getMessage(), e);
        }
    }

    public NewsHomeConfiguration getConfiguration() {
        return configuration;
    }

    public boolean showTags() {
        return configuration.showTags();
    }

    public String getHomeURL() {
        return PortalHelper.getHomeURL(_themeDisplay);
    }

    public String getPortalURL() {
        return PortalHelper.getPortalURL(_themeDisplay);
    }

    public String getLink() {
        return configuration.link();
    }

    // récupération des actu
    public List<NewsHomeItem> getAssetEntries() {
        List<NewsHomeItem> newsHomeItemList = Arrays.stream(configuration.classPKs().split(","))
                .mapToLong(Long::parseLong)
                .filter(Validator::isNotNull)
                .mapToObj(classPK -> JournalArticleLocalServiceUtil.fetchLatestArticle(classPK, 0))
                .filter(Validator::isNotNull)
                .map(journalArticle -> new NewsHomeItem(journalArticle, _themeDisplay.getLocale()))
                .collect(Collectors.toList());

        return newsHomeItemList;
    }

    public String DeleteTag(String html) {
        Pattern p = Pattern.compile("<[^>]*>");
        Matcher m = p.matcher(html);
        return m.replaceAll("");
    }

    public String getJSONEncodedString(String source) {
        return HtmlUtil.escapeJS(source);
    }

    public boolean hasFocus(String[] tagNames) {
        if (Arrays.toString(tagNames).contains("focus"))
            return true;
        else
            return false;
    }

    private final Log _log = LogFactoryUtil.getLog(this.getClass());
}