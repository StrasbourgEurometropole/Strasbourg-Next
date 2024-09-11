package eu.strasbourg.portlet.contact;

import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.contact.configuration.ContactFormConfiguration;
import eu.strasbourg.portlet.contact.context.ContactFormDisplayContext;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import java.io.IOException;

@Component(
		immediate = true,
		configurationPid = "eu.strasbourg.portlet.contact.configuration.ContactFormConfiguration",
		property = {
			"com.liferay.portlet.display-category=Strasbourg", "com.liferay.portlet.instanceable=true",
			"com.liferay.portlet.requires-namespaced-parameters=false",
			"com.liferay.portlet.css-class-wrapper=contact-form-portlet", "javax.portlet.init-param.template-path=/",
			"javax.portlet.name=" + StrasbourgPortletKeys.CONTACT_FORM_WEB,
			"javax.portlet.resource-bundle=content.Language",
			"javax.portlet.security-role-ref=power-user,user"
		},
		service = Portlet.class
)
public class ContactFormPortlet extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(this.getClass());

	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			ContactFormConfiguration configuration = ConfigurationProviderUtil.getPortletInstanceConfiguration(ContactFormConfiguration.class, themeDisplay);

			// Titre du formulaire
			String title = LocalizationUtil.getLocalization(configuration.title(),
					LocaleUtil.toLanguageId(themeDisplay.getLocale()));
			renderRequest.setAttribute("title", title);

			// Template sélectionné
			String template = configuration.template();

			// Email du destinataire
			String email = configuration.email();
			if (Validator.isNull(email)) {
				email = LanguageUtil.get(PortalUtil.getHttpServletRequest(renderRequest), "contact.default-recipient");
			}

			// Texte de descriptipon
			String descriptionText = LocalizationUtil.getLocalization(configuration.descriptionText(),
					LocaleUtil.toLanguageId(themeDisplay.getLocale()));
			renderRequest.setAttribute("descriptionText", descriptionText);

			// Texte de "confidentialité"
			String privacyText = LocalizationUtil.getLocalization(configuration.privacyText(),
					LocaleUtil.toLanguageId(themeDisplay.getLocale()));
			if (Validator.isNull(privacyText)) {
				privacyText = LanguageUtil.get(PortalUtil.getHttpServletRequest(renderRequest), "contact.default-privacy");
			}
			renderRequest.setAttribute("privacyText", privacyText);

			// Création du display context
			ContactFormDisplayContext dc = new ContactFormDisplayContext(renderRequest, renderResponse);
			renderRequest.setAttribute("dc", dc);
			
			// Clé recaptcha
			String recaptchaKey = StrasbourgPropsUtil.getRecaptchaPublicKey();
			renderRequest.setAttribute("recaptchaKey", recaptchaKey);

			if (Validator.isNull(email) || Validator.isNull(template)) {
				include("/no-config.jsp", renderRequest, renderResponse);
			} else {
				include("/templates/" + template + ".jsp", renderRequest, renderResponse);
			}

		} catch (ConfigurationException e) {
			log.error(e);
		}
	}

}