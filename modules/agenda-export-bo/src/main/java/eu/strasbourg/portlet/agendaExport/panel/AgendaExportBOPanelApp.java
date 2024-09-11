package eu.strasbourg.portlet.agendaExport.panel;

import com.liferay.application.list.BasePanelApp;
import com.liferay.application.list.PanelApp;
import com.liferay.application.list.constants.PanelCategoryKeys;

import com.liferay.portal.kernel.model.Portlet;
import org.osgi.service.component.annotations.Component;

import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Reference;

@Component(
        immediate = true,
        property = {
                "panel.app.order:Integer=467",
                "panel.category.key=" + PanelCategoryKeys.SITE_ADMINISTRATION_CONTENT
        },
        service = PanelApp.class
)
public class AgendaExportBOPanelApp extends BasePanelApp {
	@Override
    public String getPortletId() {
        return StrasbourgPortletKeys.AGENDA_EXPORT_BO;
    }

    @Override
    public Portlet getPortlet() {
        return _portlet;
    }

    @Reference(
            target = "(javax.portlet.name=" + StrasbourgPortletKeys.AGENDA_EXPORT_BO + ")"
    )
    private Portlet _portlet;
}
