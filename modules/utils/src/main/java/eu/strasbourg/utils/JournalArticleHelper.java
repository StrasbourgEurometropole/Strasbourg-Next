package eu.strasbourg.utils;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.StringReader;
import java.util.Locale;

/**
 * Classe helper pour tout ce qui concerne les layouts
 *
 * @author Benjamin Bini
 *
 */
public class JournalArticleHelper {

    public static String getJournalArticleFieldValue(JournalArticle article, String field, Locale locale) {
        String content = article.getContentByLocale(locale.toString());

        String value = "";

        com.liferay.portal.kernel.xml.Document document = null;

        try {
            document = SAXReaderUtil.read(new StringReader(content));
            Node node = document.selectSingleNode("/root/dynamic-element[@name='" + field + "']/dynamic-content");
            if (node != null && node.getText().length() > 0) {
                value = node.getText();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return value;
    }

    private static final Log _log = LogFactoryUtil.getLog(LayoutHelper.class.getName());
}
