package eu.strasbourg.portlet.place.util;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.util.ArrayList;
import java.util.List;

/*
    * Util class to check if a user has the permission to edit a place
    * A user has the permission to edit a place if he is an omniadmin or if he has the permission to edit the type of the place
    * or if he has the permission to edit a sub type of the type of the place
    * @param themeDisplay the theme display
    * @param place the place to check
    * @return true if the user has the permission to edit the place, false otherwise
    * @see AssetCategory
 */
public class PlacePermissionUtils {
    public static boolean hasEditPermission(ThemeDisplay themeDisplay, Place place) {
        List<AssetCategory> typeDeLieuVocab = place.getTypes();
        List<AssetCategory> categoriesUser = AssetCategoryLocalServiceUtil.getCategories(User.class.getName(), themeDisplay.getUserId());
        List<AssetCategory> subCategoriesUser = new ArrayList<>();
        // Make a copy of the list to avoid concurrent modification exception
        List<AssetCategory> categoriesUserCopy = new ArrayList<>(categoriesUser);
        // add all sub category
        for (AssetCategory category : categoriesUserCopy) {
            subCategoriesUser.addAll(AssetVocabularyHelper.getChild(category.getCategoryId()));
        }
        return themeDisplay.getPermissionChecker().isOmniadmin() ||
                typeDeLieuVocab.stream().anyMatch(categoriesUser::contains) ||
                typeDeLieuVocab.stream().anyMatch(subCategoriesUser::contains);
    }
}
