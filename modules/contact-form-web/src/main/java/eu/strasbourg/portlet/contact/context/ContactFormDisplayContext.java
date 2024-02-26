package eu.strasbourg.portlet.contact.context;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.MultiSessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.utils.display.context.BaseDisplayContext;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

public class ContactFormDisplayContext extends BaseDisplayContext {

	private RenderRequest request;

	/**
	 * Constructeur
	 */
	public ContactFormDisplayContext(RenderRequest request, RenderResponse response) {
		super(request, response);
		this.request = request;
	}

	/**
	 * Retourne le message d'erreur en HTML
	 */
	public String getAlertError(String key, String message, String ancre) {
		if(MultiSessionErrors.contains(request, key))
			return "<div class='st-alert-form st--has-error mb-4'>" +
					"<p class='st-alert-form__content'>" +
					"<a href='#" + ancre + "'>"+
					LanguageUtil.get(PortalUtil.getHttpServletRequest(this.request), message)+
					"</a>" +
					"</p>" +
					"</div>";
		return "";
	}
}
