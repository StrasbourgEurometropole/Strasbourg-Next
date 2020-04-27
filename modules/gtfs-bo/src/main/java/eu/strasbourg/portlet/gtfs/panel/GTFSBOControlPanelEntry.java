package eu.strasbourg.portlet.gtfs.panel;

import com.liferay.portal.kernel.portlet.BaseControlPanelEntry;
import com.liferay.portal.kernel.portlet.ControlPanelEntry;

import org.osgi.service.component.annotations.Component;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.GTFS_BO
	},
	service = ControlPanelEntry.class
)
public class GTFSBOControlPanelEntry extends BaseControlPanelEntry {

}
