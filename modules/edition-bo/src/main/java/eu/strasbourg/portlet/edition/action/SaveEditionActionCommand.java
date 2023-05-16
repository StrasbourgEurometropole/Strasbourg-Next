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
package eu.strasbourg.portlet.edition.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.*;
import eu.strasbourg.service.edition.model.Edition;
import eu.strasbourg.service.edition.model.EditionGallery;
import eu.strasbourg.service.edition.service.EditionLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

@Component(
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.EDITION_BO,
		"mvc.command.name=saveEdition" },
	service = MVCActionCommand.class)
public class SaveEditionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			ServiceContext sc = ServiceContextFactory.getInstance(request);
			sc.setScopeGroupId(
				((ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY))
					.getScopeGroupId());

			// Validation
			boolean isValid = validate(request);
			if (!isValid) {
				// Si pas valide : on reste sur la page d'édition
				PortalUtil.copyRequestParameters(request, response);

				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);
				String portletName = (String) request
						.getAttribute(WebKeys.PORTLET_ID);
				PortletURL returnURL = PortletURLFactoryUtil.create(request,
						portletName, themeDisplay.getPlid(),
						PortletRequest.RENDER_PHASE);
				returnURL.setParameter("tab", request.getParameter("tab"));

				response.setRenderParameter("returnURL", returnURL.toString());
				response.setRenderParameter("mvcPath",
						"/edition-bo-edit-edition.jsp");
				response.setRenderParameter("cmd", "saveEdition");
				return false;
			}

			long editionId = ParamUtil.getLong(request, "editionId");
			Edition edition;
			if (editionId == 0) {
				edition = _editionLocalService.createEdition(sc);
			} else {
				edition = _editionLocalService.getEdition(editionId);
			}

			Map<Locale, String> title = LocalizationUtil
				.getLocalizationMap(request, "title");
			edition.setTitleMap(title);

			Long imageId = ParamUtil.getLong(request, "imageId");
			edition.setImageId(imageId);

			Map<Locale, String> subtitle = LocalizationUtil
				.getLocalizationMap(request, "subtitle");
			edition.setSubtitleMap(subtitle);

			Map<Locale, String> description = LocalizationUtil
				.getLocalizationMap(request, "description");
			edition.setDescriptionMap(description);

			Map<Locale, String> author = LocalizationUtil
				.getLocalizationMap(request, "author");
			edition.setAuthorMap(author);

			Map<Locale, String> editor = LocalizationUtil
				.getLocalizationMap(request, "editor");
			edition.setEditorMap(editor);

			Map<Locale, String> URL = LocalizationUtil
				.getLocalizationMap(request, "URL");
			edition.setURLMap(URL);

			Map<Locale, String> fileId = LocalizationUtil
				.getLocalizationMap(request, "fileId");
			edition.setFileIdMap(fileId);

			String distribution = ParamUtil.getString(request, "distribution");
			edition.setDistribution(distribution);

			String ISBN = ParamUtil.getString(request, "ISBN");
			edition.setISBN(ISBN);

			String price = ParamUtil.getString(request, "price");
			edition.setPrice(price);

			boolean availableForExchange = ParamUtil.getBoolean(request,
				"availableForExchange");
			edition.setAvailableForExchange(availableForExchange);

			boolean inStock = ParamUtil.getBoolean(request, "inStock");
			edition.setInStock(inStock);

			String diffusionDateYear = ParamUtil.getString(request,
				"diffusionDateYear");
			edition.setDiffusionDateYear(diffusionDateYear);

			String diffusionDateMonth = ParamUtil.getString(request,
				"diffusionDateMonth");
			edition.setDiffusionDateMonth(diffusionDateMonth);

			String pageNumber = ParamUtil.getString(request, "pageNumber");
			edition.setPageNumber(pageNumber);

			String pictureNumber = ParamUtil.getString(request,
				"pictureNumber");
			edition.setPictureNumber(pictureNumber);

			String publicationDateString = ParamUtil.getString(request,
				"publicationDate");
			String publicationDateTimeString = ParamUtil.getString(request,
				"publicationDateTime");
			Date publicationDate = GetterUtil.getDate(
				publicationDateString + " " + publicationDateTimeString,
				new SimpleDateFormat("dd/MM/yyyy hh:mm"));
			edition.setPublicationDate(publicationDate);

			List<EditionGallery> oldGalleries = edition.getEditionGalleries();
			for (EditionGallery gallery : oldGalleries) {
				_editionLocalService.deleteEditionGalleryEdition(
					gallery.getGalleryId(), edition);
			}
			long[] galleriesIds = ParamUtil.getLongValues(request,
				"galleriesIds");
			for (long galleryId : galleriesIds) {
				if (galleryId > 0) {
					_editionLocalService.addEditionGalleryEdition(galleryId,
						edition);
				}
			}

			_editionLocalService.updateEdition(edition, sc);
		} catch (PortalException e) {
			_log.error(e);
		}

		return true;
	}

	/**
	 * Validation des champs obligatoires
	 */
	private boolean validate(ActionRequest request) {
		boolean isValid = true;

		// Titre
		if (Validator.isNull(ParamUtil.getString(request, "title"))) {
			SessionErrors.add(request, "title-error");
			isValid = false;
		}

		// Description
		if (Validator.isNull(ParamUtil.getString(request, "descriptionEditor"))) {
			SessionErrors.add(request, "description-error");
			isValid = false;
		}

		// Image
		long imageId = ParamUtil.getLong(request, "imageId");
		if (imageId == 0) {
			SessionErrors.add(request, "image-error");
			isValid = false;
		}

		// année
		long annee = ParamUtil.getLong(request, "diffusionDateYear");
		if(annee == 0){
			SessionErrors.add(request, "year-error");
			isValid = false;
		}

		return isValid;
	}

	private EditionLocalService _editionLocalService;

	@Reference(unbind = "-")
	protected void setEditionLocalService(
		EditionLocalService editionLocalService) {

		_editionLocalService = editionLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}