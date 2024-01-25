package eu.strasbourg.listener.dlFile;

import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.ResourceConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ResourcePermissionLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.util.Validator;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * @author AZC
 *
 */
@Component(immediate = true, service = ModelListener.class)
public class DLFileListener extends BaseModelListener<DLFileEntry>
{

	/**
	 *  A la création d'un fichier, on vérifie si c'est un descendant de Espace Presse pour y ajouter des droits
	 */
	@Override
	public void onAfterCreate(DLFileEntry model) throws ModelListenerException
	{
		try {
			// on vérifie qu'on est sur strasbourg.eu
			Group group = GroupLocalServiceUtil.fetchGroup(model.getGroupId());
			if(Validator.isNotNull(group) &&
					group.getGroupKey().equals("Strasbourg.eu")) {
				// on vérifie si le fichier à le dossier "Article-Rubrique"/"Espace presse" comme ancètre
				List<DLFolder> ancestors = new ArrayList<>();
				ancestors.add(model.getFolder());
				ancestors.addAll(model.getFolder().getAncestors());
				if (ancestors.size() >= 2 &&
						ancestors.get(ancestors.size() - 1).getName().equals("Article-Rubrique") &&
						ancestors.get(ancestors.size() - 2).getName().equals("Espace presse")) {
					// on ajoute les droits au role "Espace presse régulier"
					Role espacePresseRole = RoleLocalServiceUtil.getRole(group.getCompanyId(), LanguageUtil.get(Locale.FRANCE, "role-presse"));
					if (Validator.isNotNull(espacePresseRole)) {
						ResourcePermissionLocalServiceUtil.setResourcePermissions(group.getCompanyId(),"com.liferay.document.library.kernel.model.DLFileEntry",
								ResourceConstants.SCOPE_INDIVIDUAL,""+model.getFileEntryId(), espacePresseRole.getRoleId(),
								new String[]{ActionKeys.VIEW, ActionKeys.DELETE, ActionKeys.UPDATE});
					}
				}
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}

		super.onAfterCreate(model);
	}
	
}
