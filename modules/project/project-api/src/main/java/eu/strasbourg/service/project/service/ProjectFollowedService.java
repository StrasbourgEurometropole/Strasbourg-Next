/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import eu.strasbourg.service.project.model.ProjectFollowed;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for ProjectFollowed. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Cedric Henry
 * @see ProjectFollowedServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=project",
		"json.web.service.context.path=ProjectFollowed"
	},
	service = ProjectFollowedService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ProjectFollowedService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the project followed remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ProjectFollowedServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Ajoute un projet à un utilisateur
	 */
	public JSONObject addFollowerLink(long projectId, long groupId);

	public List<ProjectFollowed> findProjectFollowedByPublikUserId(
		String publikId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Verifie si l'utilisateur courant suit le projet
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject isFollower(long projectId);

}