package eu.strasbourg.portlet.contact.context;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.servlet.MultiSessionErrors;
import com.liferay.portal.kernel.servlet.SessionErrors;
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
}
