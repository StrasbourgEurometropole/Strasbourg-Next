package eu.strasbourg.portlet.helppopup.action;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayPortletRequest;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.SessionParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.service.HelpProposalLocalService;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static eu.strasbourg.portlet.helppopup.HelpPopupPortlet.REDIRECT_URL_PARAM;

/**
 * @author romain.vergnais
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.HELP_POPUP_WEB,
                "mvc.command.name=editHelpProposal"
        },
        service = MVCActionCommand.class
)
public class EditHelpProposalActionCommand implements MVCActionCommand {

    // Id de recuperation des champs
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String POSTAL_CODE = "postalcode";
    private static final String PHONE_NUMBER = "phoneNumber";

    private static final String TITLE = "title";
    private static final String TYPES = "types";
    private static final String DESCRIPTION = "helpproposaldescription";
    private static final String HELPER = "helper";
    private static final String IN_THE_NAME_OF = "inTheNameOf";
    private static final String LANGUAGE = "language";
    private static final String LOCALISATION = "localisation";
    private static final String PHOTO = "photo";
    private static final String DELETE_PHOTO = "deletePhoto";

    // Champs
    private String address;
    private String city;
    private long postalcode;
    private String phoneNumber;

    private String title;
    private String types;
    private String description;
    private long helperId;
    private String inTheNameOf;
    private String language;
    private long localisationId;
    private boolean deletePhoto;
    private long entryId;

    // Gestion et contexte de la requete
    private String publikID;
    private String messageKey;


    @Override
	public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {

		boolean result = false;
		
		// Recuperation des identifiants assujetis a la requete
        this.entryId = ParamUtil.getLong(request, "entryId");
        this.publikID = getPublikID(request);
        
		// Recuperation de l'URL de redirection
        String redirectURL = ParamUtil.getString(request, REDIRECT_URL_PARAM);
        
        // Recuperation des informations du budget participatif du formulaire
        this.address = HtmlUtil.stripHtml(ParamUtil.getString(request, ADDRESS));
        this.city = HtmlUtil.stripHtml(ParamUtil.getString(request, CITY));
        this.postalcode = ParamUtil.getLong(request, POSTAL_CODE);
        this.phoneNumber = HtmlUtil.stripHtml(ParamUtil.getString(request, PHONE_NUMBER));

        this.title = HtmlUtil.stripHtml(ParamUtil.getString(request, TITLE));
        this.types = ParamUtil.getString(request, TYPES);
        this.description = HtmlUtil.stripHtml(ParamUtil.getString(request, DESCRIPTION));
        this.helperId = ParamUtil.getLong(request, HELPER);
        this.inTheNameOf = HtmlUtil.stripHtml(ParamUtil.getString(request, IN_THE_NAME_OF));
        this.language = HtmlUtil.stripHtml(ParamUtil.getString(request, LANGUAGE));
        this.localisationId = ParamUtil.getLong(request, LOCALISATION);
        this.deletePhoto = ParamUtil.getString(request, DELETE_PHOTO).equals("true") ? true : false;

        // Verification de la validite des informations
        if (validate()) {
            // Envoi de la demande de modification du budget
            result = editHelpProposal(request);
        }else{
            SessionErrors.add(request, this.messageKey);
            return false;
        }
        
        try {
            response.sendRedirect(redirectURL);
        } catch (IOException e) {
            _log.error("erreur de redirection dans la command action editHelpProposal : ", e);
            throw new PortletException(e);
        }

        
		return result;
	}
	
	private boolean editHelpProposal(ActionRequest request) throws PortletException {
        
        try {
        	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(this.entryId);
        	HelpProposal helpProposal = _helpProposalLocalService.getHelpProposal(assetEntry.getClassPK());
        	ServiceContext sc = ServiceContextFactory.getInstance(request);

            List<Long> identifiants = new ArrayList<>();
            String[] typeIds = this.types.split("-");
            for (String typeId : typeIds) {
                if (typeId != "-") {
                    identifiants.add(Long.parseLong(typeId));
                }
            }
            identifiants.add(helperId);
            identifiants.add(localisationId);
            // Mise de la ville de strasbourg si c'est un quartier
            AssetCategory parent = AssetCategoryLocalServiceUtil.fetchAssetCategory(localisationId).getParentCategory();
            if(parent.getName().equals("Strasbourg")) {
                identifiants.add(parent.getCategoryId());
            }
            // Ajout active
            AssetCategory active = AssetVocabularyHelper.getCategory("Active", sc.getScopeGroupId());
            if (active != null)
                identifiants.add(active.getCategoryId());
            // Ajout non lue
            AssetCategory nonLu = AssetVocabularyHelper.getCategory("Non Lue", sc.getScopeGroupId());
            if (nonLu != null)
                identifiants.add(nonLu.getCategoryId());

            long[] ids = new long[identifiants.size()];
            for (int i = 0; i < identifiants.size(); i++) {
                ids[i] = identifiants.get(i);
            }

            sc.setAssetCategoryIds(ids);

            helpProposal.setAddress(this.address);
            helpProposal.setCity(this.city);
            helpProposal.setPostalCode(this.postalcode);
            helpProposal.setPhoneNumber(this.phoneNumber);

            helpProposal.setTitle(this.title, Locale.FRANCE);
            helpProposal.setDescription(this.description, Locale.FRANCE);
            helpProposal.setInTheNameOf(this.inTheNameOf);
            helpProposal.setSpokenLanguages(this.language, Locale.FRANCE);
            helpProposal.setModifiedByUserDate(new Date());
            
            UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
            String fileName = uploadRequest.getFileName("photo");
            if(this.deletePhoto && (fileName == null || fileName.isEmpty()))
                helpProposal.setImageId(0);
            else
            	uploadFile(helpProposal, request);

            //Mise à jour du BP
            _helpProposalLocalService.updateHelpProposal(helpProposal, sc);
            
        } catch (PortalException e) {
            _log.error(e);
            throw new PortletException(e);
        } catch (IOException e) {
        	_log.error(e);
        	throw new PortletException(e);
		}
        return true;
    }
	
	/**
     * Recuperer l'image uploadée par l'utilisateur.
     *
     * @param helpProposal la proposaition d'aide correspondante.
     * @param request            la request
     * @throws IOException
     * @throws PortalException
     */
    private Boolean uploadFile(HelpProposal helpProposal, ActionRequest request) throws PortalException, IOException{
    	
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
                        													"Proposition d'aide");
                // Dossier d'upload de l'entite
                DLFolder folder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(),
                                									folderparent.getFolderId(),
                                									"uploads");
                // Ajout du fichier
                FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
                        sc.getUserId(), folder.getRepositoryId(),
                        folder.getFolderId(), photo.getName(),
                        MimeTypesUtil.getContentType(photo),
                        photo.getName(), title,
                        "", imageBytes, sc);
                // Lien de l'image a l'entite
                helpProposal.setImageId(fileEntry.getFileEntryId());
                
                _log.info("Photo proposition d'aide uploade : [" + photo + "]");

            }
        } else {
            this.messageKey = "extension";
            return false;
        }

        return true;
    }

   private boolean validateFileName(ActionRequest request) {
        boolean result = true;
        UploadRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);
        String fileName = uploadRequest.getFileName(PHOTO);
        if (fileName != null && !fileName.isEmpty()) {
            String type = fileName.substring(fileName.lastIndexOf(".")).toLowerCase();
            result = type.equals(".jpg") || type.equals(".jpeg") || type.equals(".png");
        }
        return result;
    }
	
	/**
	 * Validation des champs de la requete (excpet photo)
	 * @return Valide ou pas
	 */
	private boolean validate() {

        // address
        if (Validator.isNull(this.address)) {
            this.messageKey = "Adresse non valide";
            return false;
        }

        // city
        if (Validator.isNull(this.city)) {
            this.messageKey = "Ville non valide";
            return false;
        }

        // postalcode
        if (Validator.isNull(this.postalcode)) {
            this.messageKey = "Code postal non valide";
            return false;
        }
        Pattern p = Pattern.compile("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");
        Matcher m = p.matcher(String.valueOf(this.postalcode));
        if (!m.matches()) {
            this.messageKey = "Code postal non valide";
            return false;
        }

        // Téléphone
        if (Validator.isNull(this.phoneNumber)) {
            this.messageKey = "Téléphone non valide";
            return false;
        }

        // utilisateur
        if (this.publikID == null || this.publikID.isEmpty()) {
            this.messageKey = "user";
            return false;
        }

        // title
        if (Validator.isNull(this.title)) {
            this.messageKey = "title";
            return false;
        }

        // Types d'aide
        if (Validator.isNull(this.types)) {
            this.messageKey = "types";
            return false;
        }

        // Description
        if (Validator.isNull(this.description)) {
            this.messageKey = "description";
            return false;
        }

        // type d'aidant
        if (Validator.isNull(this.helperId)) {
            this.messageKey = "helper";
            return false;
        }

        // Déposé au nom de
        if (Validator.isNull(this.inTheNameOf)) {
            this.messageKey = "name";
            return false;
        }

        // Localisation
        if (Validator.isNull(this.localisationId)) {
            this.messageKey = "localisation";
            return false;
        }

        return true;
    }
	
	/**
     * Récupération du publik ID avec la session
     */
    private String getPublikID(PortletRequest request) {
        LiferayPortletRequest liferayPortletRequest = PortalUtil.getLiferayPortletRequest(request);
        HttpServletRequest originalRequest = liferayPortletRequest.getHttpServletRequest();
        return SessionParamUtil.getString(originalRequest, "publik_internal_id");
    }
	
	/**
     * le log
     */
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Reference(unbind = "-")
    protected void setHelpProposalLocalService(HelpProposalLocalService helpProposalLocalService) {
        _helpProposalLocalService = helpProposalLocalService;
    }

    private HelpProposalLocalService _helpProposalLocalService;

}