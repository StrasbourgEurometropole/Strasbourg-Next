package eu.strasbourg.utils;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.petra.string.StringBundler;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.*;

public class IndexHelper {

    //Anciennement dans BaseIndexer (7.2) mais a été supprimé en 7.4
    public static void addAssetCategoryTitles(
            Document document, String field, List<AssetCategory> assetCategories) {

        Map<Locale, List<String>> assetCategoryTitles = new HashMap<>();

        for (AssetCategory assetCategory : assetCategories) {
            Map<Locale, String> titleMap = assetCategory.getTitleMap();

            for (Map.Entry<Locale, String> entry : titleMap.entrySet()) {
                String title = entry.getValue();

                if (Validator.isNull(title)) {
                    continue;
                }

                Locale locale = entry.getKey();

                List<String> titles = assetCategoryTitles.computeIfAbsent(
                        locale, k -> new ArrayList<>());

                titles.add(StringUtil.toLowerCase(title));
            }
        }

        for (Map.Entry<Locale, List<String>> entry :
                assetCategoryTitles.entrySet()) {

            Locale locale = entry.getKey();

            List<String> titles = entry.getValue();

            String[] titlesArray = titles.toArray(new String[0]);

            document.addText(
                    StringBundler.concat(field, StringPool.UNDERLINE, locale),
                    titlesArray);
        }
    }
}
