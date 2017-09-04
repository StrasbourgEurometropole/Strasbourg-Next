package eu.strasbourg.portlet.interest.action;

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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import eu.strasbourg.service.interest.model.Interest;
import eu.strasbourg.service.interest.service.InterestLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(immediate = true, property = { "javax.portlet.name=" + StrasbourgPortletKeys.INTEREST_BO,
		"mvc.command.name=selectionAction" }, service = MVCActionCommand.class)
public class SelectionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		String tab = ParamUtil.getString(actionRequest, "tab");

		long[] selectionIds = StringUtil.split(ParamUtil.getString(actionRequest, "selectionIds"), 0L);

		for (long entryId : selectionIds) {
			try {
				switch (ParamUtil.getString(actionRequest, "cmd")) {
				case "delete":
					if (tab.equals("interests")) {
						_interestLocalService.removeInterest(entryId);
					}
					break;
				case "publish":
					if (tab.equals("interests")) {
						Interest interest = _interestLocalService.getInterest(entryId);
						_interestLocalService.updateStatus(interest.getUserId(), interest.getInterestId(),
								WorkflowConstants.STATUS_APPROVED);
					}
					break;
				case "unpublish":
					if (tab.equals("interests")) {
						Interest interest = _interestLocalService.getInterest(entryId);
						_interestLocalService.updateStatus(interest.getUserId(), interest.getInterestId(),
								WorkflowConstants.STATUS_DRAFT);
					}
					break;
				}
			} catch (PortalException e) {
				_log.error(e);
			}
		}
		return false;
	}

	private InterestLocalService _interestLocalService;

	@Reference(unbind = "-")
	protected void setInterestLocalService(InterestLocalService interestLocalService) {

		_interestLocalService = interestLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
