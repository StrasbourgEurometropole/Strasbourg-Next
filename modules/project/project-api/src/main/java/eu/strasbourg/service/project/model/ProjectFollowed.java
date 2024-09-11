/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ProjectFollowed service. Represents a row in the &quot;project_ProjectFollowed&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see ProjectFollowedModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.ProjectFollowedImpl"
)
@ProviderType
public interface ProjectFollowed extends PersistedModel, ProjectFollowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.ProjectFollowedImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectFollowed, Long>
		PROJECT_FOLLOWED_ID_ACCESSOR = new Accessor<ProjectFollowed, Long>() {

			@Override
			public Long get(ProjectFollowed projectFollowed) {
				return projectFollowed.getProjectFollowedId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectFollowed> getTypeClass() {
				return ProjectFollowed.class;
			}

		};

}