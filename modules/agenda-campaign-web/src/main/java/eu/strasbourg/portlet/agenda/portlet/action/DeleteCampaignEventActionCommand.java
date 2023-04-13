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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.agenda.model.CampaignEvent;
import eu.strasbourg.service.agenda.service.CampaignEventLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import java.io.IOException;

@Component(
	immediate = true,
	property = { "javaxaddFileEntry.portlet.name=" + StrasbourgPortletKeys.CAMPAIGN_WEB,
		"mvc.command.name=deleteCampaignEvent" },
	service = MVCActionCommand.class)
public class DeleteCampaignEventActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest request, ActionResponse response)
		throws PortletException {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
			long[] selectionIds = ParamUtil.getLongValues(request,
				"selectionIds");
			if (selectionIds.length == 0) {
				long campaignEventId = ParamUtil.getLong(request,
					"campaignEventId");
				selectionIds = new long[] { campaignEventId };
			}
			for (long campaignEventId : selectionIds) {
				CampaignEvent event = this.campaignEventLocalService
					.fetchCampaignEvent(campaignEventId);
				if (event == null
					|| !event.isUserManagerOfTheEvent(themeDisplay.getUserId())
					|| event.getStatus() != WorkflowConstants.STATUS_IN_TRASH) {
					continue;
				}
				event.sendDeleteMail();
				this.campaignEventLocalService
					.removeCampaignEvent(campaignEventId);
			}

			String portletName = (String) request
				.getAttribute(WebKeys.PORTLET_ID);
			PortletURL renderUrl = PortletURLFactoryUtil.create(request,
				portletName, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);
			renderUrl.setParameter("statusId", ParamUtil.getString(request, "statusId"));
			renderUrl.setParameter("themeId",
				ParamUtil.getString(request, "themeId"));
			response.sendRedirect(renderUrl.toString());
		} catch (PortalException e) {
			_log.error(e);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

	private CampaignEventLocalService campaignEventLocalService;

	@Reference(unbind = "-")
	protected void setCampaignEventLocalService(
		CampaignEventLocalService campagnLocalService) {
		campaignEventLocalService = campagnLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
