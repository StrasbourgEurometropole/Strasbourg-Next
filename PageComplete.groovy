import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import java.util.Locale;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.entry.rel.model.AssetEntryAssetCategoryRel;

	List<Long> layoutPLIDCategorie = new ArrayList<>()
		List<AssetCategory> categories = AssetVocabularyLocalServiceUtil.fetchGroupVocabulary(GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "strasbourg.eu").getGroupId(),"Complétion").getCategories();
		StringBuilder sb = new StringBuilder();
		for (AssetCategory category : categories) {

			List<AssetEntryAssetCategoryRel> assetEntriesRel =  AssetEntryAssetCategoryRelLocalServiceUtil.getAssetEntryAssetCategoryRelsByAssetCategoryId(category.getCategoryId());
			sb.append("<p>Total de pages pour la catégorie "+category.getName()+" : "+assetEntriesRel.size()+"</p>");
			sb.append("<table class=\"table table-autofit table-heading-nowrap table-list\">");
			sb.append("<thead>");
			sb.append("<tr class=\"portlet-section-header results-header\">");
			sb.append("<th>Nom</th><th>Friendly URL</th>");
			sb.append("</tr>");
			sb.append("</thead>");
			sb.append("<tbody>");

			for (AssetEntryAssetCategoryRel assetEntryRel: assetEntriesRel) {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchAssetEntry(assetEntryRel.getAssetEntryId());
				Layout layout = LayoutLocalServiceUtil.fetchLayout(assetEntry.getClassPK());
				layoutPLIDCategorie.add(layout.getPlid());
				sb.append("<tr class=\"entry-display-style\"><td>"+layout.getName(Locale.FRANCE)+"</td><td>"+layout.getFriendlyURL(Locale.FRANCE)+"</td></tr>");
			}
			sb.append("</tbody>");
			sb.append("</table>");
		}

		List<Layout> allLayouts = LayoutLocalServiceUtil.getLayouts(GroupLocalServiceUtil.fetchGroup(PortalUtil.getDefaultCompanyId(), "strasbourg.eu").getGroupId(),false);
		List<Layout> layoutWithoutCat = allLayouts.stream().filter {x -> !layoutPLIDCategorie.contains(x.getPlid())}.collect();
		sb.append("<p>Total de pages sans catégorie "+layoutWithoutCat.size()+"</p>");
		sb.append("<table class=\"table table-autofit table-heading-nowrap table-list\">");
		sb.append("<thead>");
		sb.append("<tr class=\"portlet-section-header results-header\">");
		sb.append("<th>Nom</th><th>Friendly URL</th>");
		sb.append("</tr>");
		sb.append("</thead>");
		sb.append("<tbody>");
		for (Layout layout: layoutWithoutCat) {
				sb.append("<tr class=\"entry-display-style\"><td>"+layout.getName(Locale.FRANCE)+"</td><td>"+layout.getFriendlyURL(Locale.FRANCE)+"</td></tr>");
		}
		sb.append("</tbody>");
		sb.append("</table>");

out.println(sb.toString());