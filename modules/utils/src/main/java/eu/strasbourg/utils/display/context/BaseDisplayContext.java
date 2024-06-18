package eu.strasbourg.utils.display.context;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class BaseDisplayContext {
	protected RenderRequest _request = null;
	protected RenderResponse _response = null;
	protected ThemeDisplay _themeDisplay = null;

	public BaseDisplayContext(RenderRequest request, RenderResponse response) {
		this._request = request;
		this._response = response;
		this._themeDisplay = (ThemeDisplay) _request
			.getAttribute(WebKeys.THEME_DISPLAY);
	}

	public String getLayoutTitle() {
		String title = this._themeDisplay.getLayout().getName(_themeDisplay.getLocale());
		// title is xml, so we need to extract the text from title tag
		title = HtmlUtil.stripHtml(title);
		return title;
	}

	/**
	 * Retourne le message d'erreur en HTML
	 */
	public String getAlertError(String key, String message, String ancre) {
		if(SessionErrors.contains(_request, key))

			return
					"<li>" +
							"<p class=\"st-alert-form__content\">" +
							"<a href=\"#" + ancre + "\">" + LanguageUtil.get(PortalUtil.getHttpServletRequest(_request), message) + "</a>" +
							"</p>" +
							"</li>";


		return "";
	}

	/**
	 * hasError: Retourne si le formulaire a au moin une erreur
	 */
	public boolean hasError() {
		return !SessionErrors.isEmpty(_request);
	}



}
