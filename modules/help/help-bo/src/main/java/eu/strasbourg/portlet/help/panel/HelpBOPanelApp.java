package eu.strasbourg.portlet.help.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;
import com.liferay.portal.kernel.model.Portlet;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
    immediate = true,
    property = {
        "panel.app.order:Integer=464",
    	"panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
    },
    service = PanelApp.class
)
public class HelpBOPanelApp extends BasePanelApp {

	@Override
	public String getPortletId() {
		return StrasbourgPortletKeys.HELP_BO;
	}

	@Override
	public Portlet getPortlet() {
		return _portlet;
	}

	@Reference(
			target = "(javax.portlet.name=" + StrasbourgPortletKeys.HELP_BO + ")"
	)
	private Portlet _portlet;

}
