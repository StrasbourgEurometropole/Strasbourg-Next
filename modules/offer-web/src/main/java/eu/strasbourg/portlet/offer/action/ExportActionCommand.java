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
package eu.strasbourg.portlet.offer.action;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.service.ejob.model.Offer;
import eu.strasbourg.service.ejob.service.OfferLocalService;
import eu.strasbourg.service.ejob.service.OfferLocalServiceUtil;
import eu.strasbourg.service.ejob.service.OfferService;
import eu.strasbourg.service.ejob.service.OfferServiceUtil;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Locale;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.OFFER_WEB,
		"mvc.command.name=exportPDF"
	},
	service = MVCActionCommand.class
)
public class ExportActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Locale locale = themeDisplay.getLocale();

			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			String refPoste = ParamUtil.getString(request, "refPoste");
			Offer offer = this._offerLocalService.findByPublicationId(refPoste);

			String titrePortlet = this._offerService.exportOffer(offer.getOfferId(), locale, baos);

			// ouverture du PDF dans le navigateur
			HttpServletResponse httpResponse = PortalUtil.getHttpServletResponse(response);
			httpResponse.setContentType("application/pdf");
			httpResponse.addHeader("Content-Disposition", "inline; filename=\"" + titrePortlet + ".pdf\"");

			httpResponse.setContentLength(baos.size());
			OutputStream os = null;
			os = httpResponse.getOutputStream();

			if (os != null) {
				baos.writeTo(os);
				os.flush();
				os.close();
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return true;
	}

	private OfferLocalService _offerLocalService;

	@Reference(unbind = "-")
	protected void setOfferLocalService(
			OfferLocalService offerLocalService) {

		_offerLocalService = offerLocalService;
	}

	private OfferService _offerService;

	@Reference(unbind = "-")
	protected void setOfferService(
			OfferService offerService) {

		_offerService = offerService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}