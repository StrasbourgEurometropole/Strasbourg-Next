package eu.strasbourg.listener.dlFolder;

import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.role.RoleConstants;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author AZC
 *
 */
@Component(immediate = true, service = ModelListener.class)
public class DLFolderListener extends BaseModelListener<DLFolder>
{

	/**
	 *  A la création d'un dossier, on vérifie si c'est un descendant de Espace Presse pour y ajouter des droits
	 */
	@Override
	public void onAfterCreate(DLFolder model) throws ModelListenerException
	{
		try {
			// on vérifie qu'on est sur strasbourg.eu
			Group group = GroupLocalServiceUtil.fetchGroup(model.getGroupId());
			if(Validator.isNotNull(group) &&
					group.getGroupKey().equals("Strasbourg.eu")) {
				// on vérifie si le dossier à le dossier "Article-Rubrique"/"Espace presse" comme ancètre
				List<DLFolder> ancestors = model.getAncestors();
				if (ancestors.size() >= 2 &&
						ancestors.get(ancestors.size() - 1).getName().equals("Article-Rubrique") &&
						ancestors.get(ancestors.size() - 2).getName().equals("Espace presse")) {
					// on ajoute les droits au role "Espace presse régulier"
					Role espacePresseRole = RoleLocalServiceUtil.getRole(group.getCompanyId(), LanguageUtil.get(Locale.FRANCE, "role-presse"));
					if (Validator.isNotNull(espacePresseRole)) {
						ResourcePermissionLocalServiceUtil.setResourcePermissions(group.getCompanyId(),"com.liferay.document.library.kernel.model.DLFolder",
								ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFolderId(), espacePresseRole.getRoleId(),
								new String[]{ActionKeys.ADD_SUBFOLDER,ActionKeys.ADD_DOCUMENT,ActionKeys.VIEW, ActionKeys.DELETE, ActionKeys.UPDATE});
					}
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		super.onAfterCreate(model);
	}
	
}
