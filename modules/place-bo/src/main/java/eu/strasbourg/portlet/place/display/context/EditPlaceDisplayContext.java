package eu.strasbourg.portlet.place.display.context;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowDefinitionLinkLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class EditPlaceDisplayContext {
	public EditPlaceDisplayContext(RenderRequest request,
			RenderResponse response) {
		this._request = request;
		this._themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		List<AssetCategory> typeDeLieuVocab = getPlace().getTypes();
		List<AssetCategory> categoriesUser = AssetCategoryLocalServiceUtil.getCategories(User.class.getName(), _themeDisplay.getUserId());
		List<AssetCategory> subCategoriesUser = new ArrayList<>();
		// Make a copy of the list to avoid concurrent modification exception
		List<AssetCategory> categoriesUserCopy = new ArrayList<>(categoriesUser);
		// add all sub category
		for (AssetCategory category : categoriesUserCopy) {
			subCategoriesUser.addAll(AssetVocabularyHelper.getChild(category.getCategoryId()));
		}
		if(!_themeDisplay.getPermissionChecker().isOmniadmin() &&
				!typeDeLieuVocab.stream().anyMatch(categoriesUser::contains) &&
				!typeDeLieuVocab.stream().anyMatch(subCategoriesUser::contains)) {
			SessionErrors.add(_request, "permission-error");
			this.hasEditPermission = false;
		}
	}

	public Place getPlace() {
		long placeId = ParamUtil.getLong(_request, "placeId");
		if (_place == null && placeId > 0) {
			_place = PlaceLocalServiceUtil.fetchPlace(placeId);
		}
		return _place;
	}

	public String getDefaultIndexes(int length) {
		String indexes = "0";
		for (int i = 1; i < length; i++) {
				indexes += "," + i;
		}
		return indexes;
	}

	public Locale[] getAvailableLocales() {
		Set<Locale> availableLocalesSet = LanguageUtil.getSupportedLocales();
		Locale[] availableLocales = availableLocalesSet
				.toArray(new Locale[availableLocalesSet.size()]);
		return availableLocales;
	}

	public boolean isWorkflowEnabled() {
		return WorkflowDefinitionLinkLocalServiceUtil.hasWorkflowDefinitionLink(
				_themeDisplay.getCompanyId(), _themeDisplay.getCompanyGroupId(),
				Place.class.getName());
	}

	/**
	 * Wrapper autour du permission checker pour les permissions de module
	 */
	public boolean hasPermission(String actionId) throws PortalException {
		return _themeDisplay.getPermissionChecker().hasPermission(
				this._themeDisplay.getCompanyGroupId(),
				StrasbourgPortletKeys.PLACE_BO, StrasbourgPortletKeys.PLACE_BO,
				actionId);
	}

	public boolean hasEditPermission() {
		return hasEditPermission;
	}

	private Place _place;

	private final RenderRequest _request;
	private final ThemeDisplay _themeDisplay;
	public boolean hasEditPermission = true;

}
