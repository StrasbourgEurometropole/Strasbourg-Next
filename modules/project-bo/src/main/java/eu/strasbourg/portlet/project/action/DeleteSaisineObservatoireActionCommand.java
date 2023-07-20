package eu.strasbourg.portlet.project.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import eu.strasbourg.service.project.service.PetitionLocalService;
import eu.strasbourg.service.project.service.SaisineObservatoireLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

/**
 * @author Joshua Chacha
 */
@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
                "mvc.command.name=deleteSaisineObservatoire"
        },
        service = MVCActionCommand.class
)
public class DeleteSaisineObservatoireActionCommand implements MVCActionCommand{

    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    private SaisineObservatoireLocalService _saisineObservatoireLocalService;

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {

        long saisineObservatoireId = ParamUtil.getLong(request, "saisineObservatoireId");
        try {
            _saisineObservatoireLocalService.removeSaisineObservatoire(saisineObservatoireId);
        } catch (PortalException e) {
            _log.error("erreur dans le delete : ",e);
            throw new PortletException(e);
        }
        return false;
    }


    @Reference(unbind = "-")
    protected void setSaisineObservatoireLocalService(SaisineObservatoireLocalService saisineObservatoireLocalService) {
        _saisineObservatoireLocalService = saisineObservatoireLocalService;
    }


}
