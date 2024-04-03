/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ProjectTimelineService}.
 *
 * @author Cedric Henry
 * @see ProjectTimelineService
 * @generated
 */
public class ProjectTimelineServiceWrapper
	implements ProjectTimelineService, ServiceWrapper<ProjectTimelineService> {

	public ProjectTimelineServiceWrapper() {
		this(null);
	}

	public ProjectTimelineServiceWrapper(
		ProjectTimelineService projectTimelineService) {

		_projectTimelineService = projectTimelineService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _projectTimelineService.getOSGiServiceIdentifier();
	}

	@Override
	public ProjectTimelineService getWrappedService() {
		return _projectTimelineService;
	}

	@Override
	public void setWrappedService(
		ProjectTimelineService projectTimelineService) {

		_projectTimelineService = projectTimelineService;
	}

	private ProjectTimelineService _projectTimelineService;

}