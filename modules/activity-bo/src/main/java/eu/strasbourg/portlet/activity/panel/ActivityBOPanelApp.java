package eu.strasbourg.portlet.activity.panel;

import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=265",
    	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class ActivityBOPanelApp extends BasePanelApp {
	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Override
	public String getPortletId() {
		return StrasbourgPortletKeys.ACTIVITY_BO;
	}

	@Reference(
			target = "(javax.portlet.name=" + StrasbourgPortletKeys.ACTIVITY_BO + ")"
	)
	private Portlet _portlet;
}