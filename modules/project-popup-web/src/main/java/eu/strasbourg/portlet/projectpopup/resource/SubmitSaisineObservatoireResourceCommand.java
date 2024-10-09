package eu.strasbourg.portlet.projectpopup.resource;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetCategoryModel;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.template.*;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.*;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.MailHelper;
import eu.strasbourg.utils.PublikApiClient;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.mail.internet.InternetAddress;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

import static eu.strasbourg.portlet.projectpopup.ProjectPopupPortlet.CITY_NAME;
import static eu.strasbourg.portlet.projectpopup.utils.ProjectPopupUtils.getPublikID;

/**
 * @author Joshua Chacha
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_POPUP_WEB,
                "mvc.command.name=submitSaisineObservatoire"
        },
        service = MVCResourceCommand.class
)
public class SubmitSaisineObservatoireResourceCommand implements MVCResourceCommand {

    private static final String BIRTHDAY = "birthday";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String POSTALCODE = "postalcode";
    private static final String PHONE = "phone";
    private static final String MOBILE = "mobile";
    private static final String SAISINETITLE = "title";
    private static final String SAISINEDESCRIPTION = "description";
    private static final String PROJECTTARGET = "projectTarget";
    private static final String COLLECTIVENAME = "collectiveName";
    private static final String OTHERMECHANISM = "otherMechanism";
    private static final String DISPOSITIF = "dispositif";
    private static final String AKA = "aka";
    private static final String PHOTO = "photo";
    private static final String LIEU = "consultationPlacesText";
    private static final String PROJECT = "project";
    private static final String QUARTIER = "quartier";
    private static final String THEME = "theme";
    private static final String SAVEINFO = "saveinfo";
    private static final String LASTNAME = "lastname";
    private static final String FIRSTNAME = "firstname";
    private static final String EMAIL = "email";
    private static final String PATTERN = "dd/MM/yyyy";

    /**
     * le log
     */
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public boolean serveResource(ResourceRequest request, ResourceResponse response) {
        // Recuperation du contexte de la requete
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        ServiceContext sc = null;
        try {
            sc = ServiceContextFactory.getInstance(request);
        } catch (PortalException e) {
            _log.error(e);
        }

        // Initialisations respectives de : resultat probant de la requete, sauvegarde ou non des informations Publik, message de retour
        boolean result = false;
        boolean savedInfo = false;

        // Recuperation de l'utilsiteur Publik ayant lance la demande
        PublikUser user = null;
        String publikID = getPublikID(request);
        if (publikID != null && !publikID.isEmpty()) {
            user = PublikUserLocalServiceUtil.getByPublikUserId(publikID);
        }

        // Recuperation des informations du formulaire
        DateFormat dateFormat = new SimpleDateFormat(PATTERN);
        Date birthday = ParamUtil.getDate(request, BIRTHDAY, dateFormat);
        String address = HtmlUtil.stripHtml(ParamUtil.getString(request, ADDRESS));
        String city = HtmlUtil.stripHtml(ParamUtil.getString(request, CITY));
        long postalcode = ParamUtil.getLong(request, POSTALCODE);
        String phone = HtmlUtil.stripHtml(ParamUtil.getString(request, PHONE));
        String collectiveName = HtmlUtil.stripHtml(ParamUtil.getString(request, COLLECTIVENAME));
        String otherMechanism = HtmlUtil.stripHtml(ParamUtil.getString(request, OTHERMECHANISM));
        String mobile = HtmlUtil.stripHtml(ParamUtil.getString(request, MOBILE));
        String lastname = HtmlUtil.stripHtml(ParamUtil.getString(request, LASTNAME));
        String firstname = HtmlUtil.stripHtml(ParamUtil.getString(request, FIRSTNAME));
        String email = HtmlUtil.stripHtml(ParamUtil.getString(request, EMAIL));
        String lieu = HtmlUtil.stripHtml(ParamUtil.getString(request, LIEU));
        String title = HtmlUtil.stripHtml(ParamUtil.getString(request, SAISINETITLE));
        String description = HtmlUtil.stripHtml(ParamUtil.getString(request, SAISINEDESCRIPTION).replace("\n", "<br>"));
        String projectTarget = HtmlUtil.stripHtml(ParamUtil.getString(request, PROJECTTARGET));
        long projectId = ParamUtil.getLong(request, PROJECT);
        long quartierId = ParamUtil.getLong(request, QUARTIER);
        long themeId = ParamUtil.getLong(request, THEME);
        long dispositifId = ParamUtil.getLong(request, DISPOSITIF);
        long enTantQueId = ParamUtil.getLong(request, AKA);

        // Verification de la validite des informations
        String message = validate(publikID, user, title,
                description, birthday, city, address, postalcode);
        if (message.equals("")) {

            // Mise a jour des informations du compte Publik si requete valide et demande par l'utilisateur
            savedInfo = ParamUtil.getBoolean(request, SAVEINFO);
            if (savedInfo) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateNaiss = sdf.format(birthday);
                PublikApiClient.setAllUserDetails(
                        publikID,
                        user != null ? user.getLastName() : null,
                        address,
                        "" + postalcode,
                        city,
                        dateNaiss,
                        phone,
                        mobile
                );
            }

            List<Long> identifiants = new ArrayList<>();
            if (quartierId == 0) {
                List<AssetCategory> districts = AssetVocabularyHelper.getAllDistrictsFromCity(CITY_NAME);
                assert districts != null;
                identifiants = districts.stream()
                        .map(AssetCategoryModel::getCategoryId)
                        .collect(Collectors.toList());
            } else {
                identifiants.add(quartierId);
            }
            if (projectId != 0) {
                identifiants.add(projectId);
            }
            if (themeId != 0) {
                identifiants.add(themeId);
            }
            if (dispositifId != 0) {
                identifiants.add(dispositifId);
            }
            if (enTantQueId != 0) {
                identifiants.add(enTantQueId);
            }
            long[] ids = new long[identifiants.size()];
            for (int i = 0; i < identifiants.size(); i++) {
                ids[i] = identifiants.get(i);
            }

            if (sc != null) {
                sc.setWorkflowAction(WorkflowConstants.ACTION_SAVE_DRAFT);
                sc.setAssetCategoryIds(ids);
            }

            SaisineObservatoire saisineObservatoire = null;
            try {
                saisineObservatoire = SaisineObservatoireLocalServiceUtil.createSaisineObservatoire(sc);
                saisineObservatoire.setTitle(title);
                saisineObservatoire.setDescription(description);
                saisineObservatoire.setOtherMechanism(otherMechanism);
                saisineObservatoire.setCollectiveName(collectiveName);
                saisineObservatoire.setProjectTarget(projectTarget);
                saisineObservatoire.setPetitionnaireAdresse(address);
                saisineObservatoire.setPetitionnaireBirthday(birthday);
                saisineObservatoire.setPetitionnaireCity(city);
                saisineObservatoire.setPlaceTextArea(lieu);
                saisineObservatoire.setPetitionnaireFirstname(firstname);
                saisineObservatoire.setPetitionnaireLastname(lastname);
                saisineObservatoire.setPetitionnairePostalCode(postalcode);
                saisineObservatoire.setPetitionnairePhone(phone);
                if (!mobile.isEmpty()) {
                    saisineObservatoire.setPetitionnairePhone(mobile);
                }
                saisineObservatoire.setPetitionnaireEmail(email);
                saisineObservatoire.setPublikId(publikID);
                saisineObservatoire = uploadFile(saisineObservatoire, request);
                saisineObservatoire = SaisineObservatoireLocalServiceUtil.updateSaisineObservatoire(saisineObservatoire, sc);
                AssetEntry assetEntry = saisineObservatoire.getAssetEntry();
                if (assetEntry == null)
                    throw new PortalException("aucune assetCategory pour la saisine "
                            + saisineObservatoire.getSaisineObservatoireId());
            } catch (PortalException | IOException e) {
                _log.error(e);
                message = "error";
            }
            _log.info("saisine créé : " + saisineObservatoire);

            if (message.equals("")) {
                result = true;
                sendSaisineObservatoireMailConfirmation(request, title, description, email);
            }
        }

        // Récupération du json des entités
        JSONObject jsonResponse = JSONFactoryUtil.createJSONObject();
        jsonResponse.put("result", result);
        jsonResponse.put("message", message);
        jsonResponse.put("savedInfo", savedInfo);

        // Recuperation de l'élément d'écriture de la réponse
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
        } catch (IOException e) {
            _log.error(e.getMessage());
        }
        if (writer != null) {
            writer.print(jsonResponse.toString());
        }

        return result;
    }

    /**
     * Envoi du mail de confirmation de soumission de la saisine
     */
    private void sendSaisineObservatoireMailConfirmation(ResourceRequest request, String title,
                                              String description, String email) {

        try {
            ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
            // récupération des images
            StringBuilder hostUrl = new StringBuilder("https://");
            hostUrl.append(request.getServerName());
            String headerImage = hostUrl +
                    "/o/plateforme-citoyenne-theme/images/logos/mail-img-header-pcs.png";
            String btnImage = hostUrl +
                    "/o/plateforme-citoyenne-theme/images/logos/mail-btn-knowmore.png";

            // préparation du template de mail
            Map<String, Object> context = new HashMap<>();
            context.put("link", themeDisplay.getURLPortal() + themeDisplay.getURLCurrent());
            context.put("headerImage", headerImage);
            context.put("footerImage", btnImage);
            context.put("Title", title);
            context.put("Message", description);

            StringWriter out = new StringWriter();

            // Chargement du template contenant le corps du mail
            TemplateResource templateResourceBody = new URLTemplateResource("0",
                    Objects.requireNonNull(this.getClass().getClassLoader()
                            .getResource("META-INF/resources/templates/contact-mail-saisine-observatoire-copy-body-fr_FR.ftl")));
            Template bodyTemplate = TemplateManagerUtil.getTemplate(
                    TemplateConstants.LANG_TYPE_FTL, templateResourceBody, false);

            // Traitement du template corps
            bodyTemplate.putAll(context);
            bodyTemplate.processTemplate(out);
            String mailBody = out.toString();

            String subject = LanguageUtil.get(PortalUtil.getHttpServletRequest(request), "modal.submitsaisineobservatoire.mail.information");

            InternetAddress fromAddress = new InternetAddress("no-reply@no-reply.strasbourg.eu",
                    themeDisplay.getScopeGroup().getName(request.getLocale()));

            InternetAddress[] toAddresses = new InternetAddress[0];
            InternetAddress address = new InternetAddress(email);
            toAddresses = ArrayUtil.append(toAddresses, address);

            // Copie carbone invisible
            InternetAddress bccAddress = new InternetAddress("participer@strasbourg.eu");

            // envoi du mail aux utilisateurs
            MailHelper.sendMailWithBCCWithHTML(fromAddress, toAddresses, bccAddress, subject, mailBody);
        } catch (Exception e) {
            _log.error(e.getMessage(), e);
        }
    }

    /**
     * Recuperer l'image uploadée par l'utilisateur.
     *
     * @return la saisine avec l'imageId
     * @throws PortalException Fichier sans image
     * @throws IOException Pb récupération de la photo
     */
    private SaisineObservatoire uploadFile(SaisineObservatoire saisine, ResourceRequest request) throws PortalException, IOException {

        // Recuperation du contexte de la requete
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        ServiceContext sc = ServiceContextFactory.getInstance(request);
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

        // Verification du nom du fichier
        if (validateFileName(request)) {

            File photo = uploadRequest.getFile(PHOTO);

            // Verification de la bonne recuperation du contenu du fichier
            if (photo != null && photo.exists()) {

                byte[] imageBytes = FileUtil.getBytes(photo);

                // Dossier a la racine
                DLFolder folderparent = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                        DLFolderConstants.DEFAULT_PARENT_FOLDER_ID,
                        "[TECHNIQUE] Photo Saisine");
                // Dossier d'upload de l'entite
                DLFolder folder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                        folderparent.getFolderId(),
                        "Uploads");
                // Ajout du fichier
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                        null, sc.getUserId(), folder.getRepositoryId(),
                        folder.getFolderId(), photo.getName(),
                        MimeTypesUtil.getContentType(photo),
                        photo.getName(), "", saisine.getTitle(),
                        "", imageBytes, null, null, null, sc);
                // Lien de l'image a l'entite
                saisine.setImageId(fileEntry.getFileEntryId());

                _log.info("Photo saisine uploade : [" + photo + "]");

            }
            return saisine;

        } else {
            throw new PortalException("le fichier n'est pas une image");
        }
    }

    /**
     * Validation du nom du fichier photo
     * @return Valide ou pas
     */
    private boolean validateFileName(ResourceRequest request) {
        boolean result = true;
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        String fileName = uploadRequest.getFileName(PHOTO);
        if (fileName != null && !fileName.isEmpty()) {
            String type = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            result = type.equals(".jpg") || type.equals(".jpeg") || type.equals(".png");
        }
        return result;
    }


    private String validate(String publikID, PublikUser user, String title, String description,
                            Date birthday, String city, String address, long postalcode) {

        // utilisateur
        if (publikID == null || publikID.isEmpty()) {
            return "Utilisateur non reconnu";
        } else {
            if (user.isBanned()) {
                return "Vous ne pouvez soutenir ce projet";
            } else if (user.getPactSignature() == null) {
                return "Vous devez signer le Pacte pour soumettre un projet";
            }
        }

        // title
        if (Validator.isNull(title)) {
            return "Titre non valide";
        }
        if (title.length() > 45) {
            return "Taille du titre trop grande";
        }

        // description
        if (Validator.isNull(description)) {
            return "Description non valide";
        }

        // birthday
        if (Validator.isNull(birthday)) {
            return "Date de naissance non valide";
        }

        // city
        if (Validator.isNull(city)) {
            return "Ville non valide";
        }

        // address
        if (Validator.isNull(address)) {
            return "Adresse non valide";
        }

        // postalcode
        if (Validator.isNull(postalcode)) {
            return "Code postal non valide";
        }

        return "";
    }

}
