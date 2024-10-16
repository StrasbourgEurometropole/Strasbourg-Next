package eu.strasbourg.portlet.contact.action;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.portal.configuration.module.configuration.ConfigurationProviderUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.module.configuration.ConfigurationException;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.template.Template;
import com.liferay.portal.kernel.template.TemplateConstants;
import com.liferay.portal.kernel.template.TemplateManagerUtil;
import com.liferay.portal.kernel.template.TemplateResource;
import com.liferay.portal.kernel.template.URLTemplateResource;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.contact.configuration.ContactFormConfiguration;
import eu.strasbourg.utils.FriendlycaptchaHelper;
import eu.strasbourg.utils.MailHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;
import java.io.StringWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.apache.commons.text.StringEscapeUtils.escapeHtml4;

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.CONTACT_FORM_WEB,
                "mvc.command.name=contact"
        },
        service = MVCActionCommand.class
)
public class ContactFormContactAction implements MVCActionCommand {

    private final Log log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        ContactFormConfiguration portletConfiguration = null;
        try {
            portletConfiguration = ConfigurationProviderUtil.getPortletInstanceConfiguration(ContactFormConfiguration.class, themeDisplay);
        } catch (ConfigurationException e) {
            SessionErrors.add(request, "unknown-error");
            return false;
        }

        // On récupère les informations du mail à envoyer
        String emailFrom = escapeHtml4(ParamUtil.getString(request, "emailFrom"));
        String emailTo = portletConfiguration.email();
        String content = escapeHtml4(ParamUtil.getString(request, "content"));
        String firstName = escapeHtml4(ParamUtil.getString(request, "firstName"));
        String lastName = escapeHtml4(ParamUtil.getString(request, "lastName"));
        String object = escapeHtml4(ParamUtil.getString(request, "contact.object"));
        String phone = escapeHtml4(ParamUtil.getString(request, "contact.phone"));
        //adaptation du formulaire pour placit
        if (emailFrom==null||emailFrom.isEmpty())
            emailFrom = escapeHtml4(ParamUtil.getString(request, "contact.mail"));
        if (content==null||content.isEmpty())
            content = escapeHtml4(ParamUtil.getString(request, "contact.request"));
        if (firstName==null||firstName.isEmpty())
            firstName = escapeHtml4(ParamUtil.getString(request, "contact.firstname"));
        if (lastName==null||lastName.isEmpty())
            lastName = escapeHtml4(ParamUtil.getString(request, "contact.lastname"));


        // Validation
        boolean hasError = false;
        String friendlycaptchaResponse = ParamUtil.getString(request, "frc-captcha-solution");
        String placit= ParamUtil.getString(request, "placit");
        if (!FriendlycaptchaHelper.verify(friendlycaptchaResponse)) {
            // Friendlycaptcha
            SessionErrors.add(request, "friendlycaptcha-error");
            hasError = true;
        }
        if (Validator.isNull(emailFrom)) {
            // Email obligatoires
            SessionErrors.add(request, "email-error");
            hasError = true;
        }
        if (Validator.isNull(firstName)) {
            // Prénom obligatoires
            SessionErrors.add(request, "firstname-error");
            hasError = true;
        }
        if (Validator.isNull(lastName)) {
            // Nom obligatoires
            SessionErrors.add(request, "lastname-error");
            hasError = true;
        }
        if (Validator.isNull(content)) {
            // Message obligatoires
            SessionErrors.add(request, "content-error");
            hasError = true;
        }
        if (!Validator.isEmailAddress(emailFrom)) {
            // Validité de l'adresse mail
            SessionErrors.add(request, "invalid-mail-error");
            hasError = true;
        }
        if (hasError) {
            return true;
        }

        // Envoi du mail au service
        Map<String, Object> context = new HashMap<>();
        context.put("website", themeDisplay.getScopeGroup().getName(request.getLocale()));
        String formName = LocalizationUtil.getLocalization(portletConfiguration.title(),
                LocaleUtil.toLanguageId(themeDisplay.getLocale()));
        context.put("formName", formName);
        context.put("firstName", firstName);
        context.put("lastName", lastName);
        context.put("content", content);
        context.put("emailFrom", emailFrom);
        if (object != null && !object.isEmpty())
            context.put("object", object);
        if (phone != null && !phone.isEmpty())
            context.put("phone", phone);

        LocalDateTime dateTime = LocalDateTime.now();
        String date = dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String time = dateTime.format(DateTimeFormatter.ofPattern("hh:mm"));
        context.put("date", date);
        context.put("time", time);

        TemplateResource templateResourceSubject;
        TemplateResource templateResourceBody;
        Template subjectTemplate;
        Template bodyTemplate;
        String mailSubject;
        String mailBody;
        StringWriter out;

        boolean success = false;
        try {

            // Chargement du template contenant le sujet du mail
            templateResourceSubject = new URLTemplateResource("0",
                    Objects.requireNonNull(this.getClass().getClassLoader()
                            .getResource("/templates/contact-mail-subject.ftl")));
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
                            .getResource("/templates/contact-mail-body.ftl")));
            bodyTemplate = TemplateManagerUtil.getTemplate(
                    TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

            // Traitement du template corps
            out = new StringWriter();
            bodyTemplate.putAll(context);
            bodyTemplate.processTemplate(out);
            mailBody = out.toString();

            InternetAddress fromAddress = new InternetAddress("no-reply@no-reply.strasbourg.eu",
                    themeDisplay.getScopeGroup().getName(request.getLocale()));

            InternetAddress[] toAddresses = new InternetAddress[0];
            for (String toAddress : emailTo.split(",")) {
                try {
                    InternetAddress address = new InternetAddress(toAddress);
                    toAddresses = ArrayUtil.append(toAddresses, address);
                } catch (AddressException ex) {
                    log.error(ex);
                }
            }
            success = MailHelper.sendMailWithHTML(fromAddress, toAddresses, mailSubject, mailBody);
        } catch (Exception e) {
            log.error(e);
        }
        if (success) {
            SessionMessages.add(request, "mail-success");
        } else {
            SessionErrors.add(request, "unknown-error");
            return false;
        }

        // Envoi du mail au destinataire
        boolean sendCopy = ParamUtil.getBoolean(request, "sendCopy");
        if (sendCopy) {
            ExpandoBridge ed = themeDisplay.getScopeGroup().getExpandoBridge();
            try {
                String headerImage = GetterUtil.getString(ed.getAttribute("image_header_mail_contact"));
                String footerImage = GetterUtil.getString(ed.getAttribute("image_footer_mail_contact"));
                context.put("headerImage", headerImage);
                context.put("footerImage", footerImage);
            } catch (Exception ex) {
                log.error("Missing expando field");
            }

            try {
                String locale = request.getLocale().toString();
                if (!locale.equals("fr_FR") && !locale.equals("en_US") && !locale.equals("de_DE")) {
                    locale = "fr_FR";
                }

                // Chargement du template contenant le sujet du mail
                templateResourceSubject = new URLTemplateResource("0",
                        Objects.requireNonNull(this.getClass().getClassLoader()
                                .getResource("/templates/contact-mail-copy-subject-" + request.getLocale().toString() + ".ftl")));
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
                                .getResource("/templates/contact-mail-copy-body-" + request.getLocale().toString() + ".ftl")));
                bodyTemplate = TemplateManagerUtil.getTemplate(
                        TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

                // Traitement du template corps
                out = new StringWriter();
                bodyTemplate.putAll(context);
                bodyTemplate.processTemplate(out);
                mailBody = out.toString();

                InternetAddress fromAddress = new InternetAddress("no-reply@no-reply.strasbourg.eu",
                        themeDisplay.getScopeGroup().getName(request.getLocale()));
                InternetAddress to = new InternetAddress(emailFrom);
                InternetAddress[] toAddresses = new InternetAddress[]{to};
                MailHelper.sendMailWithHTML(fromAddress, toAddresses, mailSubject, mailBody);

            } catch (Exception e) {
                log.error(e);
            }
        }

        // Redirection (évite double requête POST si l'utilisateur actualise sa
        // page)
        String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
        PortletURL renderUrl = PortletURLFactoryUtil.create(request, portletName, themeDisplay.getPlid(),
                PortletRequest.RENDER_PHASE);
        renderUrl.setParameter("mailSent", "true");
        try {
            response.sendRedirect(renderUrl.toString());
        } catch (IOException e) {
            log.error(e);
        }
        return true;

    }

}
