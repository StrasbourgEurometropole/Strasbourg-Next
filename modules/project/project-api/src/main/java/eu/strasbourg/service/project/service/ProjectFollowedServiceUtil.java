/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import eu.strasbourg.service.project.model.ProjectFollowed;

import java.util.List;

/**
 * Provides the remote service utility for ProjectFollowed. This utility wraps
 * <code>eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Cedric Henry
 * @see ProjectFollowedService
 * @generated
 */
public class ProjectFollowedServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Ajoute un projet à un utilisateur
	 */
	public static com.liferay.portal.kernel.json.JSONObject addFollowerLink(
		long projectId, long groupId) {

		return getService().addFollowerLink(projectId, groupId);
	}

	public static List<ProjectFollowed> findProjectFollowedByPublikUserId(
		String publikId) {

		return getService().findProjectFollowedByPublikUserId(publikId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * Verifie si l'utilisateur courant suit le projet
	 */
	public static com.liferay.portal.kernel.json.JSONObject isFollower(
		long projectId) {

		return getService().isFollower(projectId);
	}

	public static ProjectFollowedService getService() {
		return _service;
	}

	public static void setService(ProjectFollowedService service) {
		_service = service;
	}

	private static volatile ProjectFollowedService _service;

}