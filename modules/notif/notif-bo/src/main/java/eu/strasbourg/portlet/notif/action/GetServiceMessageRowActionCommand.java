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
package eu.strasbourg.portlet.notif.action;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

@Component(immediate = true, property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.NOTIF_BO,
		"mvc.command.name=getServiceMessageRow" }, service = MVCActionCommand.class)
public class GetServiceMessageRowActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response){
		request.setAttribute("fromAjaxMessage", true);
		return true;
	}
}