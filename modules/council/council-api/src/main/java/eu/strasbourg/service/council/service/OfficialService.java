/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Official. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see OfficialServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=council",
		"json.web.service.context.path=Official"
	},
	service = OfficialService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface OfficialService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.council.service.impl.OfficialServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the official remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link OfficialServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Recherche des électeurs pour une session données groupés par statut de connexion et nom complet
	 *
	 * @param councilSessionId
	 * @param groupId          ID du site
	 * @return Tableaux des statuts possibles contenant la liste des électeurs assimilables auxdits statuts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getOfficialByConnexionStatus(
		long councilSessionId, long groupId);

	/**
	 * Recherche d'élu pour l'autocompletion
	 *
	 * @param fullName          Nom, prénom ou les deux de l'élu à trouver
	 * @param type              Type de l'élu recherché (peut être vide)
	 * @param removedOfficialId ID de l'élu à retirer de la liste des résultats (0 si non-utilisé)
	 * @param groupId           Site sur lequel cherchés
	 * @return Liste des élus au format JSON
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getOfficialByFullNameAndType(
		String fullName, String type, long removedOfficialId, long groupId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}