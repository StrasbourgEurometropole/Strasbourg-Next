/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package eu.strasbourg.portlet.entity_detail.action;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.activity.model.ActivityOrganizer;
import eu.strasbourg.service.activity.service.ActivityOrganizerLocalServiceUtil;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.EventLocalServiceUtil;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalServiceUtil;
import eu.strasbourg.utils.MailHelper;
import eu.strasbourg.utils.RecaptchaHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + StrasbourgPortletKeys.ENTITY_DETAIL_WEB,
				"mvc.command.name=contact"
		},
		service = MVCActionCommand.class
)
public class EntityDetailContactActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
		request.setAttribute("fromContactForm", true);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		Map<String, Object> context = new HashMap<>();
		
		String type = ParamUtil.getString(request, "type");
		String email = ParamUtil.getString(request, "email");
		String to = ParamUtil.getString(request, "to");
		String entityId = ParamUtil.getString(request, "entityId");
		String title = ParamUtil.getString(request, "title");
		String message = ParamUtil.getString(request, "message");
		String firstName = ParamUtil.getString(request, "firstName");
		String lastName = ParamUtil.getString(request, "lastName");
		String websiteName = themeDisplay.getScopeGroup().getName(request.getLocale());
		boolean notificationEmail = ParamUtil.getBoolean(request, "notificationEmail");
		
		LocalDateTime dateTime = LocalDateTime.now();
		String date = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm"));
		context.put("date", date);
		context.put("time", time);
		context.put("website", websiteName);
		context.put("firstName", firstName);
		context.put("lastName", lastName);
		context.put("content", message);
		context.put("emailFrom", email);
		context.put("type", type);
		context.put("title", title);

		TemplateResource templateResourceSubject;
		Template subjectTemplate;
		TemplateResource templateResourceBody;
		Template bodyTemplate;
		String mailSubject;
		String mailBody;

		// On récupère l'email de l'entité si elle existe, sinon on prend le "to" par défaut
		String mailTo = getEntityEmail(entityId, type, to);

		//Si on utilise l'email par défaut, on log un warning (il faut migrer les ADT pour utiliser les emails des entités via entityId)
		if(mailTo.equals(to)) {
			_log.warn("Using default email for contact form: " + to + ", type: " + type);
		}

		try {
			StringWriter out = new StringWriter();

			// Chargement du template contenant le sujet du mail
			templateResourceSubject = new URLTemplateResource("0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/contact-mail-subject.ftl")));
			subjectTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceSubject, false);

			// Traitement du template sujet
			subjectTemplate.putAll(context);
			subjectTemplate.processTemplate(out);
			mailSubject = out.toString();

			//Chargement du template contenant le corps du mail
			templateResourceBody = new URLTemplateResource("0",
					Objects.requireNonNull(this.getClass().getClassLoader()
							.getResource("/templates/contact-mail-body.ftl")));
			bodyTemplate = TemplateManagerUtil.getTemplate(
					TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

			// Traitement du template corps
			out = new StringWriter();
			bodyTemplate.putAll(context);
			bodyTemplate.processTemplate(out);
			mailBody = out.toString();

			// Validation
			String gRecaptchaResponse = ParamUtil.getString(request, "g-recaptcha-response");
			boolean hasError = false;
			if (!RecaptchaHelper.verify(gRecaptchaResponse)) { // Captcha
				SessionErrors.add(request, "recaptcha-error");
				hasError = true;
			}
			// Champs vides
			// Check each field individually and add specific errors
			if (Validator.isNull(email)) {
				SessionErrors.add(request, "email-required-error");
				hasError = true;
			}
			if (Validator.isNull(firstName)) {
				SessionErrors.add(request, "first-name-required-error");
				hasError = true;
			}
			if (Validator.isNull(lastName)) {
				SessionErrors.add(request, "last-name-required-error");
				hasError = true;
			}
			if (Validator.isNull(message)) {
				SessionErrors.add(request, "message-required-error");
				hasError = true;
			}

			// Mail invalide
			if (!Validator.isEmailAddress(email) && !Validator.isNull(email)) {
				SessionErrors.add(request, "invalid-mail");
				hasError = true;
			}
			// Pas d'erreur
			if (!hasError) {

				boolean success = MailHelper.sendMailWithHTML("no-reply@no-reply.strasbourg.eu", websiteName, mailTo,
						mailSubject, mailBody);
	
				// Envoi du mail à l'utilisateur
				if (success && notificationEmail) {
					ExpandoBridge ed = themeDisplay.getScopeGroup().getExpandoBridge();
					String headerImage;
					String footerImage;
					try {
						headerImage = GetterUtil.getString(ed.getAttribute("image_header_mail_contact"));
						footerImage = GetterUtil.getString(ed.getAttribute("image_footer_mail_contact"));
						context.put("headerImage", headerImage);
						context.put("footerImage", footerImage);
					} catch (Exception ex) {
						_log.error("Missing expando field");
					}

					// Chargement du template contenant le sujet du mail
					templateResourceSubject = new URLTemplateResource("0",
							Objects.requireNonNull(this.getClass().getClassLoader()
									.getResource("/templates/contact-mail-copy-subject.ftl")));
					subjectTemplate = TemplateManagerUtil.getTemplate(
							TemplateConstants.LANG_TYPE_FTL, templateResourceSubject, false);

					// Traitement du template sujet
					out = new StringWriter();
					subjectTemplate.putAll(context);
					subjectTemplate.processTemplate(out);
					mailSubject = out.toString();

					//Chargement du template contenant le corps du mail
					templateResourceBody = new URLTemplateResource("0",
							Objects.requireNonNull(this.getClass().getClassLoader()
									.getResource("/templates/contact-mail-copy-body.ftl")));
					bodyTemplate = TemplateManagerUtil.getTemplate(
							TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

					// Traitement du template corps
					out = new StringWriter();
					bodyTemplate.putAll(context);
					bodyTemplate.processTemplate(out);
					mailBody = out.toString();
					
					MailHelper.sendMailWithHTML("no-reply@no-reply.strasbourg.eu", websiteName, email,
							mailSubject, mailBody);

				}
				if (success) {
					String messageKey = notificationEmail ? "mail-success-with-copy" : "mail-success";
					SessionMessages.add(request, messageKey);
					request.setAttribute("mailSent", true);
				} else {
					SessionErrors.add(request, "mail-error");
					request.setAttribute("mailSent", false);
				}
				return success;
			}
		} catch (Exception e) {
			_log.error(e);
		}

		// On renvoie pour l'affichage
		request.setAttribute("firstName", firstName);
		request.setAttribute("lastName", lastName);
		request.setAttribute("email", email);
		request.setAttribute("message", message);
		request.setAttribute("message", message);
		request.setAttribute("notificationEmail", notificationEmail);

		return true;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());


	/**
	 * Function that returns the email of the entity if it exists, otherwise return the default "to" email.
	 * This function is used for Place, Event and Officials. Fetches the email from the entity depdending on the type. (entityClassName)
	 */
	private String getEntityEmail(String entityId, String entityClassName, String to) {
		String email = to;

		// If the entityId is null, we return the default email
		if(Validator.isNull(entityId) || Validator.isNull(entityClassName)) {
			return email;
		}
		
		if(entityClassName.equals("Place")) {
			Place place = PlaceLocalServiceUtil.fetchPlace(Long.parseLong(entityId));
			if(place != null && Validator.isNotNull(place.getMail())) {
				email = place.getMail();
			}
		}
		if(entityClassName.equals("Event")) {
			Event event = EventLocalServiceUtil.fetchEvent(Long.parseLong(entityId));
			if(event != null && Validator.isNotNull(event.getEmail())) {
				email = event.getEmail();
			}
		}
		if(entityClassName.equals("Official")) {
			Official official = OfficialLocalServiceUtil.fetchOfficial(Long.parseLong(entityId));
			if(official != null && Validator.isNotNull(official.getListeContact())) {
				email = official.getListeContact();
			}
		}
		if(entityClassName.equals("ActivityOrganizer")) {
			ActivityOrganizer activityOrganizer = ActivityOrganizerLocalServiceUtil.fetchActivityOrganizer(Long.parseLong(entityId));
			if(activityOrganizer != null && Validator.isNotNull(activityOrganizer.getMail())) {
				email = activityOrganizer.getMail();
			}
		}


		return email;
	}

}