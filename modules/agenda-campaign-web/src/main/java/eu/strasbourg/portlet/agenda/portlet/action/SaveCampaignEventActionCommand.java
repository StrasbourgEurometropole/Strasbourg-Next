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
package eu.strasbourg.portlet.agenda.portlet.action;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.service.ListTypeLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.agenda.model.Campaign;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.model.CampaignEventStatus;
import eu.strasbourg.service.agenda.model.EventPeriod;
import eu.strasbourg.service.agenda.service.CampaignEventLocalService;
import eu.strasbourg.service.agenda.service.CampaignEventStatusLocalService;
import eu.strasbourg.service.agenda.service.CampaignLocalServiceUtil;
import eu.strasbourg.service.agenda.service.EventPeriodLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.CAMPAIGN_WEB,
		"mvc.command.name=saveCampaignEvent" },
	service = MVCActionCommand.class)
public class SaveCampaignEventActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
			ServiceContext sc = ServiceContextFactory.getInstance(request);
			User user = UserLocalServiceUtil.getUser(sc.getUserId());
			long campaignEventId = ParamUtil.getLong(request,
				"campaignEventId");
			CampaignEvent campaignEvent;
			boolean isNewStatus = false;
			if (campaignEventId == 0) {
				campaignEvent = campaignEventLocalService
					.createCampaignEvent(sc);
				isNewStatus = true;
			} else {
				campaignEvent = campaignEventLocalService
					.getCampaignEvent(campaignEventId);
			}

			// Validation
			boolean isValid = this.validate(request);
			if (!isValid) {
				PortalUtil.copyRequestParameters(request, response);
				response.setRenderParameter("mvcPath", "/campaign-edit.jsp");
				return false;
			}

			/**
			 * Informations de contact privées
			 */
			// Nom, prénom, téléphone, mail
			String lastName = ParamUtil.getString(request, "lastName");
			String firstName = ParamUtil.getString(request, "firstName");
			String phoneNumber = ParamUtil.getString(request, "phone");
			String email = ParamUtil.getString(request, "email");
			campaignEvent.setLastName(lastName);
			campaignEvent.setFirstName(firstName);
			campaignEvent.setPhone(phoneNumber);
			campaignEvent.setEmail(email);

			// Enregistrement du numéro de téléphone si l'utilisateur n'en a pas
			// encore
			if (user.getPhones().size() == 0) {
				List<ListType> listTypes = ListTypeLocalServiceUtil
					.getListTypes(
						Contact.class.getName() + ListTypeConstants.PHONE);
				if (listTypes.size() > 0) {
					PhoneLocalServiceUtil.addPhone(user.getUserId(),
						Contact.class.getName(), user.getContactId(),
						phoneNumber, "", listTypes.get(0).getListTypeId(), true,
						sc);
				}
			}

			// Service
			Long serviceId = ParamUtil.getLong(request, "serviceId");
			String service = ParamUtil.getString(request, "service");
			if (Validator.isNull(service)) {
				campaignEvent.setServiceId(serviceId);
				campaignEvent.setService("");
			}
			if (Validator.isNull(serviceId)) {
				campaignEvent.setServiceId((long) 0);
				campaignEvent.setService(service);
			}

			// Personne sur place
			String onSiteFirstName = ParamUtil.getString(request,
				"onSiteFirstName");
			String onSiteLastName = ParamUtil.getString(request,
				"onSiteLastName");
			String onSitePhone = ParamUtil.getString(request, "onSitePhone");
			campaignEvent.setOnSiteFirstName(onSiteFirstName);
			campaignEvent.setOnSiteLastName(onSiteLastName);
			campaignEvent.setOnSitePhone(onSitePhone);

			/**
			 * Détail de l'événement
			 */
			// Titre, sous-titre, description
			Map<Locale, String> title = LocalizationUtil
				.getLocalizationMap(request, "title");
			Map<Locale, String> subtitle = LocalizationUtil
				.getLocalizationMap(request, "subtitle");
			Map<Locale, String> description = LocalizationUtil
				.getLocalizationMap(request, "description");
			
			// Le input étant un textarea et l'affichage sur stras.eu en html, on remplace les \des BR pour garder les sauts de ligne 
			for(Map.Entry<Locale, String> descripLang : description.entrySet()) {
				if(descripLang.getValue() != null) {
					String valueBr = descripLang.getValue().replaceAll("\n", "<br/>");
					descripLang.setValue(valueBr);
				}
			}
	
			campaignEvent.setTitleMap(title);
			campaignEvent.setSubtitleMap(subtitle);
			campaignEvent.setDescriptionMap(description);
			
			
			
			// Image et image web
			UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
			File image = uploadRequest.getFile("image");
			long imageId = 0;
			if (image != null && image.exists()) {
				byte[] imageBytes = FileUtil.getBytes(image);
				DLFolder folder = DLFolderLocalServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), 0, "uploads");
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
						null,
						sc.getUserId(),
						folder.getRepositoryId(),
						folder.getFolderId(),
						image.getName(),
						MimeTypesUtil.getContentType(image),
						image.getName(),
						null,
						"",
						"",
						imageBytes,
						null,
						null,
						sc);
				
				imageId = fileEntry.getFileEntryId();
				campaignEvent.setImageId(imageId);
			}

			// Dans le cas où le responsable clique sur le bouton pour récupérer l'image de l'auteur
			long webImageId = ParamUtil.getLong(request, "webImageId");
			
			File webImage = uploadRequest.getFile("webImage");
			if (webImage != null && webImage.exists()) {
				byte[] imageBytes = FileUtil.getBytes(webImage);
				DLFolder folder = DLFolderLocalServiceUtil
					.getFolder(themeDisplay.getScopeGroupId(), 0, "uploads");
				FileEntry fileEntry = DLAppLocalServiceUtil.addFileEntry(
						null,
						sc.getUserId(),
						folder.getRepositoryId(),
						folder.getFolderId(),
						webImage.getName(),
						MimeTypesUtil.getContentType(webImage),
						webImage.getName(),
						null,
						"",
						"",
						imageBytes,
						null,
						null,
						sc);
				campaignEvent.setWebImageId(fileEntry.getFileEntryId());
			}
			else {
				if(webImageId != 0)
					campaignEvent.setWebImageId(webImageId);
				else
					campaignEvent.setWebImageId(imageId);
			}

			String imageOwner = ParamUtil.getString(request, "imageOwner");
			campaignEvent.setImageOwner(imageOwner);

			// Lieu
			String placeSIGId = ParamUtil.getString(request, "placeSIGId");
			if (Validator.isNotNull(placeSIGId)) {
				campaignEvent.setPlaceSIGId(placeSIGId);
				campaignEvent.setPlaceName("");
				campaignEvent.setPlaceStreetNumber("");
				campaignEvent.setPlaceStreetName("");
				campaignEvent.setPlaceZipCode("");
				campaignEvent.setPlaceCountry("");
			} else {
				campaignEvent.setPlaceSIGId("");

				Map<Locale, String> placeName = LocalizationUtil
					.getLocalizationMap(request, "placeName");
				campaignEvent.setPlaceNameMap(placeName);

				String placeStreetNumber = ParamUtil.getString(request,
					"placeStreetNumber");
				campaignEvent.setPlaceStreetNumber(placeStreetNumber);

				String placeStreetName = ParamUtil.getString(request,
					"placeStreetName");
				campaignEvent.setPlaceStreetName(placeStreetName);

				String placeZipCode = ParamUtil.getString(request,
					"placeZipCode");
				campaignEvent.setPlaceZipCode(placeZipCode);

				long placeCityId = ParamUtil.getLong(request, "placeCityId");
				campaignEvent.setPlaceCityId(placeCityId);

				String placeCountry = ParamUtil.getString(request,
					"placeCountry");
				campaignEvent.setPlaceCountry(placeCountry);
			}

			/**
			 * Informations de contact public
			 */
			// Organisateur, téléphone, mail, adresse du site internet
			String promoter = ParamUtil.getString(request, "promoter");
			String publicPhone = ParamUtil.getString(request, "publicPhone");
			String publicEmail = ParamUtil.getString(request, "publicEmail");
			Map<Locale, String> websiteURL = LocalizationUtil
				.getLocalizationMap(request, "websiteURL");
			Map<Locale, String> websiteName = LocalizationUtil
				.getLocalizationMap(request, "websiteName");

			campaignEvent.setPromoter(promoter);
			campaignEvent.setPublicPhone(publicPhone);
			campaignEvent.setPublicEmail(publicEmail);
			campaignEvent.setWebsiteURLMap(websiteURL);
			campaignEvent.setWebsiteNameMap(websiteName);

			// Champ : Inscription
			boolean inscription = ParamUtil.getBoolean(request,
					"registrationValue");
			campaignEvent.setRegistration(inscription);

			if(inscription){
				// Champs : Registration start/end date
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				Date registrationStartDate = ParamUtil.getDate(request,
						"registrationStartDate", dateFormat);
				Date registrationEndDate = ParamUtil.getDate(request,
						"registrationEndDate", dateFormat);
				campaignEvent.setRegistrationStartDate(registrationStartDate);
				campaignEvent.setRegistrationEndDate(registrationEndDate);

				// Champ : JaugeMax
				Long jaugeMax = ParamUtil.getLong(request, "maxGauge");
				campaignEvent.setMaxGauge(jaugeMax);
			} else {
				campaignEvent.setRegistrationStartDate(null);
				campaignEvent.setRegistrationEndDate(null);
				campaignEvent.setMaxGauge(0);
			}

			/**
			 * Dates et horaires
			 */
			// Suppression des anciennes périodes
			List<EventPeriod> oldPeriods = campaignEvent.getPeriods();
			for (EventPeriod period : oldPeriods) {
				eventPeriodLocalService.deleteEventPeriod(period);
			}
			// Ajout des nouvelles
			String periodsIndexesString = ParamUtil.getString(request,
				"periodIndexes");
			for (String periodIndex : periodsIndexesString.split(",")) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				if (Validator.isNotNull(periodIndex)
					&& Validator.isNotNull(
						ParamUtil.getString(request, "startDate" + periodIndex))
					&& Validator.isNotNull(ParamUtil.getString(request,
						"endDate" + periodIndex))) {

					Date startDate = ParamUtil.getDate(request,
						"startDate" + periodIndex, dateFormat);
					Date endDate = ParamUtil.getDate(request,
						"endDate" + periodIndex, dateFormat);
					Map<Locale, String> timeDetail = LocalizationUtil
						.getLocalizationMap(request,
							"timeDetail" + periodIndex);

					EventPeriod eventPeriod = eventPeriodLocalService
						.createEventPeriod();
					eventPeriod.setStartDate(startDate);
					eventPeriod.setEndDate(endDate);
					eventPeriod.setTimeDetailMap(timeDetail);
					eventPeriod.setEventId(0);
					eventPeriod
						.setCampaignEventId(campaignEvent.getCampaignEventId());
					this.eventPeriodLocalService.updateEventPeriod(eventPeriod);
				}
			}

			/**
			 * Tarifs
			 */
			// Gratuité
			Integer free = ParamUtil.getInteger(request, "free");
			campaignEvent.setFree(free);

			// Tarifs
			Map<Locale, String> price = LocalizationUtil
				.getLocalizationMap(request, "price");
			
			// Le input étant un textarea et l'affichage sur stras.eu en html, on remplace les \des BR pour garder les sauts de ligne 
			for(Map.Entry<Locale, String> priceLang : price.entrySet()) {
				if(priceLang.getValue() != null) {
					String valueBr = priceLang.getValue().replaceAll("\n", "<br/>");
					priceLang.setValue(valueBr);
				}
			}
			
			campaignEvent.setPriceMap(price);

			// ---------------------------------------------------------------
			// ----------------- RESERVATION DE BILLETS ----------------------
			// ---------------------------------------------------------------

			// Description de la reservation
			Map<Locale, String> bookingDescriptionMap = LocalizationUtil
					.getLocalizationMap(request, "bookingDescription");
			campaignEvent.setBookingDescriptionMap(bookingDescriptionMap);

			// URL de la billeterie
			String bookingURL = ParamUtil.getString(request,
					"bookingURL");
			campaignEvent.setBookingURL(bookingURL);

			/**
			 * Autres informations
			 */
			// Campagne
			long campaignId = ParamUtil.getLong(request, "campaignId");
			campaignEvent.setCampaignId(campaignId);

			// Thème, type, publics
			long[] themesIds = ParamUtil.getLongValues(request, "themesIds");
			long[] typesIds = ParamUtil.getLongValues(request, "typesIds");
			long[] publicsIds = ParamUtil.getLongValues(request, "publicsIds");
			campaignEvent.setThemesIds(StringUtil.merge(themesIds));
			campaignEvent.setTypesIds(StringUtil.merge(typesIds));
			campaignEvent.setPublicsIds(StringUtil.merge(publicsIds));

			// Gestion du statut
			CampaignEventStatus status;
			if (isNewStatus) {
				// Création du premier statut
				int newStatus = ParamUtil.getInteger(request, "newStatus", -2);
				status = campaignEvent
					.updateStatus(newStatus, "", user);
				this.campaignEventStatusLocalService
					.updateCampaignEventStatus(status);
				
				// On envoie un mail si le statut est une demande de validation,
				// une validation ou une demande de suppression
				int[] statuses = { WorkflowConstants.STATUS_PENDING,
					WorkflowConstants.STATUS_APPROVED,
					WorkflowConstants.STATUS_IN_TRASH };
				if (ArrayUtil.contains(statuses, newStatus)) {
					campaignEvent.sendStatusMail();
				}
				
			} else {
				// Création du statut (au cas où l'utilisateur ne laisse pas de
				// commentaire)
				int newStatus = ParamUtil.getInteger(request, "newStatus", -2);
				status = campaignEvent.updateStatus(newStatus, "", user);
				this.campaignEventStatusLocalService
					.updateCampaignEventStatus(status);

				// On envoie un mail si le statut est une demande de validation,
				// une validation ou une demande de suppression
				int[] statuses = { WorkflowConstants.STATUS_PENDING,
					WorkflowConstants.STATUS_APPROVED,
					WorkflowConstants.STATUS_IN_TRASH };
				if (ArrayUtil.contains(statuses, newStatus)) {
					campaignEvent.sendStatusMail();
				}
			}

			// Modification de l'événement
			campaignEventLocalService.updateCampaignEvent(campaignEvent);

			// Redirection (évite double
			// requête POST si l'utilisateur actualise sa page)
			String portletName = (String) request
				.getAttribute(WebKeys.PORTLET_ID);
			PortletURL renderUrl = PortletURLFactoryUtil.create(request,
				portletName, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);

			// Redirection vers la page d'update de statut uniquement si le
			// statut cible n'est pas brouillon
			if (campaignEvent.getStatus() != WorkflowConstants.STATUS_DRAFT) {
				renderUrl.setParameter("mvcPath",
					"/campaign-update-status.jsp");

				// On passe l'id du statut en paramètre car la page pour
				// laisser un commentaire doit modifier le statut existant et
				// pas en ajouter un
				renderUrl.setParameter("newStatus",
					String.valueOf(status.getStatus()));
				renderUrl.setParameter("statusId",
					String.valueOf(status.getStatusId()));
				renderUrl.setParameter("campaignEventId",
					String.valueOf(campaignEvent.getCampaignEventId()));
			}

			response.sendRedirect(renderUrl.toString());
		} catch (Exception e) {
			_log.error(e);
		}

		return true;
	}

	/**
	 * Validation de la requête
	 */
	private boolean validate(ActionRequest request) {
		boolean isValid = true;

		// Nom
		if (Validator.isNull(ParamUtil.getString(request, "lastName"))) {
			SessionErrors.add(request, "last-name-error");
			isValid = false;
		}

		// Prénom
		if (Validator.isNull(ParamUtil.getString(request, "firstName"))) {
			SessionErrors.add(request, "first-name-error");
			isValid = false;
		}

		// Téléphone
		if (Validator.isNull(ParamUtil.getString(request, "phone"))) {
			SessionErrors.add(request, "phone-error");
			isValid = false;
		}

		// Email
		if (Validator.isNull(ParamUtil.getString(request, "email"))) {
			SessionErrors.add(request, "email-error");
			isValid = false;
		}

		// Titre
		if (Validator.isNull(ParamUtil.getString(request, "title"))) {
			SessionErrors.add(request, "title-error");
			isValid = false;
		}

		// Description
		if (Validator.isNull(ParamUtil.getString(request, "description"))) {
			SessionErrors.add(request, "description-error");
			isValid = false;
		}

		// Auteur si il y a une image
		UploadPortletRequest uploadRequest = PortalUtil
				.getUploadPortletRequest(request);
		File imageFile = uploadRequest.getFile("image");
		if (imageFile != null && imageFile.exists()){
			if (Validator.isNull(ParamUtil.getString(request, "imageOwner"))) {
				SessionErrors.add(request, "autor-error");
				isValid = false;
			}
		}

		// Lieu
		String placeSIGId = ParamUtil.getString(request, "placeSIGId");
		if (Validator.isNull(placeSIGId)) {
			String placeName = ParamUtil.getString(request, "placeName");
			String placeCityId = ParamUtil.getString(request, "placeCityId");
			if (Validator.isNull(placeName) && Validator.isNull(placeCityId)) {
				SessionErrors.add(request, "place-selected-error");
				isValid = false;
			}else {
				if (Validator.isNull(placeName)) {
					SessionErrors.add(request, "place-name-error");
					isValid = false;
				}else if (Validator.isNull(placeCityId)) {
					SessionErrors.add(request, "place-city-error");
					isValid = false;
				}
			}
		}

		// Périodes
		String periodsIndexesString = ParamUtil.getString(request,
			"periodIndexes");
		int periodsCount = 0;
        long campaignId = ParamUtil.getLong(request, "campaignId");
        Campaign campaign = CampaignLocalServiceUtil.fetchCampaign(campaignId);
        boolean eventIncluded = false;
		for (String periodIndex : periodsIndexesString.split(",")) {
            if (Validator.isNotNull(periodIndex)){
                String startDateString = ParamUtil.getString(request, "startDate" + periodIndex);
                String endDateString = ParamUtil.getString(request, "endDate" + periodIndex);
                if(Validator.isNotNull(startDateString) && Validator.isNotNull(endDateString)){
                    periodsCount++;
                    // Période de l'évènment comprises dans la période de la campagne
                    Date startDate = GetterUtil.getDate(startDateString, new SimpleDateFormat("dd/MM/yyyy"));
                    Date endDate = GetterUtil.getDate(endDateString, new SimpleDateFormat("dd/MM/yyyy"));
                    if(!(endDate.before(campaign.getStartDate()) || startDate.after(campaign.getEndDate()))){
                        eventIncluded = true;
                    }
                }
            }
		}
		if (periodsCount == 0) {
			SessionErrors.add(request, "periods-error");
			isValid = false;
		}else{
            if (!eventIncluded) {
                SessionErrors.add(request, "campaign-period-error");
                isValid = false;
            }
        }

		// Campagne
		if (Validator.isNull(ParamUtil.getString(request, "campaignId"))) {
			SessionErrors.add(request, "campaign-error");
			isValid = false;
		}
		
		// Types
		long[] typesIds = ParamUtil.getLongValues(request, "typesIds");
		if (typesIds.length == 0) {
			SessionErrors.add(request, "types-error");
			isValid = false;
		}

		// Thèmes
		long[] themesIds = ParamUtil.getLongValues(request, "themesIds");
		if (themesIds.length == 0) {
			SessionErrors.add(request, "themes-error");
			isValid = false;
		}

		return isValid;
	}

	private CampaignEventLocalService campaignEventLocalService;

	@Reference(unbind = "-")
	protected void setCampaignEventLocalService(
		CampaignEventLocalService campagnLocalService) {
		campaignEventLocalService = campagnLocalService;
	}

	private CampaignEventStatusLocalService campaignEventStatusLocalService;

	@Reference(unbind = "-")
	protected void setCampaignEventStatusLocalService(
		CampaignEventStatusLocalService campagnLocalService) {
		campaignEventStatusLocalService = campagnLocalService;
	}

	private EventPeriodLocalService eventPeriodLocalService;

	@Reference(unbind = "-")
	protected void setEventPeriodLocalService(
		EventPeriodLocalService campagnLocalService) {
		eventPeriodLocalService = campagnLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}