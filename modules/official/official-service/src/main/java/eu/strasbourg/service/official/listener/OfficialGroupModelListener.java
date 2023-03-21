package eu.strasbourg.service.official.listener;


import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import eu.strasbourg.service.official.model.Official;
import eu.strasbourg.service.official.service.OfficialLocalServiceUtil;
import org.osgi.service.component.annotations.Component;

import java.util.List;

@Component(
	immediate = true,
	service = ModelListener.class
)
public class OfficialGroupModelListener extends BaseModelListener<Group> {
	
	/**
	 *  A la suppression d'un groupe, on supprime les entités rattachées à ce groupe
	 */
	@Override
	public void onAfterRemove(Group model) throws ModelListenerException {
    			
		// Editions
		List<Official> officials = OfficialLocalServiceUtil.getByGroupId(model.getGroupId());
		for (Official official : officials) {
			try {
				OfficialLocalServiceUtil.removeOfficial(official.getOfficialId());
			} catch (PortalException e) {
				_log.error(e);
			}
		}
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}