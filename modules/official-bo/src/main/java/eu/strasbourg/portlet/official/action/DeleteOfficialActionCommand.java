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
package eu.strasbourg.portlet.official.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import eu.strasbourg.service.official.service.OfficialLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

import java.io.IOException;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.OFFICIAL_BO,
		"mvc.command.name=deleteOfficial" },
	service = MVCActionCommand.class)
public class DeleteOfficialActionCommand
	implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {

		try {
			long officialId = ParamUtil.getLong(request, "officialId");
			_officialLocalService.removeOfficial(officialId);
			response.sendRedirect(ParamUtil.getString(request, "backURL"));
		} catch (PortalException e) {
			_log.error(e);
		} catch (IOException e) {
			_log.error(e);
        }
        return true;
	}

	private OfficialLocalService _officialLocalService;

	@Reference(unbind = "-")
	protected void setOfficialLocalService(
			OfficialLocalService officialLocalService) {

		_officialLocalService = officialLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}