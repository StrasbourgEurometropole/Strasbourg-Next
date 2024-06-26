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
package eu.strasbourg.portlet.agenda.action;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import eu.strasbourg.portlet.agenda.constants.agendaConstants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_BO,
		"mvc.command.name=startImport" },
	service = MVCActionCommand.class)
public class StartImportActionCommand
	implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {
		try {
			_eventLocalService.doImport();

			// Récupération du contexte de la requête
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
			PortletURL renderURL = PortletURLFactoryUtil.create(request,
					portletName, themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
			renderURL.setParameter("tab", request.getParameter("tab"));
			renderURL.setParameter("mvcPath", request.getParameter("mvcPath"));
			response.sendRedirect(renderURL.toString());
			return true;
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}

	private EventLocalService _eventLocalService;

	@Reference(unbind = "-")
	protected void setEventLocalService(
		EventLocalService eventLocalService) {

		_eventLocalService = eventLocalService;
	}
	
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}