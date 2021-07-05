package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.familyKiosk.configuration.FamilyKioskConfiguration;
import eu.strasbourg.utils.PortletHelper;

import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Locale;
import java.util.Map;


public class FamilyKioskDisplayContext {

	private ThemeDisplay themeDisplay;
	private FamilyKioskConfiguration configuration;
	private String publikId;
	private FamilyKioskResponse familyKiosk;

	public FamilyKioskDisplayContext(ThemeDisplay themeDisplay) {
		this.themeDisplay = themeDisplay;
		try {
			this.configuration = themeDisplay.getPortletDisplay()
					.getPortletInstanceConfiguration(FamilyKioskConfiguration.class);
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	public FamilyKioskConfiguration getConfiguration() {
		return configuration;
	}

	public String getIntro() {
		String intro = "No configuration";
		Map<Locale, String> introMap = LocalizationUtil.getLocalizationMap(configuration.introXML());
		for (Map.Entry<Locale, String> map : introMap.entrySet()) {
			if (themeDisplay.getLocale().toString().equals(map.getKey().toString())) {
				intro = HtmlUtil.unescape(map.getValue());
				break;
			}
		}
		return intro;
	}

	public String getFamilyKioskURL() {
		String familyKioskURL = configuration.familyKioskURL();
		if (Validator.isNull(familyKioskURL)) {
			familyKioskURL = "#";
		}
		return familyKioskURL;
	}

	public void setFamilyKiosk(FamilyKioskResponse familyKiosk) {
		this.familyKiosk = familyKiosk;
	}

	public FamilyKioskResponse getFamilyKiosk() {
		return this.familyKiosk;
	}

	// Récupération de l'id utilisateur
	public String getPublikID(PortletRequest resourceRequest) {
		if (Validator.isNull(this.publikId)) {
			LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(resourceRequest);
			HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();

			this.publikId = SessionParamUtil.getString(originalRequest, "publik_internal_id");
		}

		return this.publikId;
	}

	public boolean showDeleteButton() {
		return PortletHelper.showDeleteButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}

	public boolean showRetractableButton() {
		return PortletHelper.showRetractableButtonOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}

	public boolean isFolded() {
		return PortletHelper.isPortletFoldedOnDashboard(themeDisplay, themeDisplay.getPortletDisplay().getId());
	}
}
