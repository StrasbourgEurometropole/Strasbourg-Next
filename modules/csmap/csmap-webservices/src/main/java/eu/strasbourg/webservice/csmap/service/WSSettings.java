package eu.strasbourg.webservice.csmap.service;

import com.liferay.journal.model.JournalArticle;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.xml.Element;
import com.liferay.portal.kernel.xml.Node;
import com.liferay.portal.kernel.xml.SAXReaderUtil;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class WSSettings {

    public static List<String> getModuleStatusFieldValue(JournalArticle article) {
        String content = article.getContentByLocale(Locale.FRANCE.toString());

        List<String> value  = new ArrayList<>();
        List<String> result = new ArrayList<String>();

        com.liferay.portal.kernel.xml.Document document = null;

        try {
            document = SAXReaderUtil.read(new StringReader(content));
            for (Element element : document.getRootElement().elements()) {
                String str = element.getStringValue();
                if (Validator.isNotNull(element) && Validator.isNotNull(str)) {
                    result.add(str);
                }
            }
        } catch (Exception ex) {
            _log.error(ex.getMessage(), ex);
        }
        return result;
    }

    private static final Log _log = LogFactoryUtil.getLog(WSSettings.class.getName());
}
