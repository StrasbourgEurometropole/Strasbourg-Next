package eu.strasbourg.portlet.place.display.context;

import java.util.Locale;
import java.util.Set;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;

import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.place.model.SubPlace;
import eu.strasbourg.service.place.service.SubPlaceLocalServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

public class EditSubPlaceDisplayContext {
	public EditSubPlaceDisplayContext(RenderRequest request,
			RenderResponse response) {
		this._request = request;
		this._themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public SubPlace getSubPlace() {
		long subPlaceId = ParamUtil.getLong(_request, "subPlaceId");
		if (_subPlace == null && subPlaceId > 0) {
			_subPlace = SubPlaceLocalServiceUtil.fetchSubPlace(subPlaceId);
		}
		return _subPlace;
	}

	public Locale[] getAvailableLocales() {
		Set<Locale> availableLocalesSet = LanguageUtil.getSupportedLocales();
		Locale[] availableLocales = availableLocalesSet
				.toArray(new Locale[availableLocalesSet.size()]);
		return availableLocales;
	}

	public String getDefaultIndexes(int length) {
		String indexes = "";
		for (int i = 1; i <= length; i++) {
			if (Validator.isNotNull(indexes)) {
				indexes += ",";
			}
			indexes += i;
		}
		return indexes;
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

	private SubPlace _subPlace;

	private final RenderRequest _request;
	private final ThemeDisplay _themeDisplay;

}
