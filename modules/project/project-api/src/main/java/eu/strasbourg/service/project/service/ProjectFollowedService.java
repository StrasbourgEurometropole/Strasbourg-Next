/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.service;

import aQute.bnd.annotation.ProviderType;

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
	 * Never modify or reference this interface directly. Always use {@link ProjectFollowedServiceUtil} to access the project followed remote service. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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