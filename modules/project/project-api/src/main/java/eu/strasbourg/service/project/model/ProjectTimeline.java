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
 * The extended model interface for the ProjectTimeline service. Represents a row in the &quot;project_ProjectTimeline&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see ProjectTimelineModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.ProjectTimelineImpl"
)
@ProviderType
public interface ProjectTimeline extends PersistedModel, ProjectTimelineModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.ProjectTimelineImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProjectTimeline, Long>
		PROJECT_TIMELINE_ID_ACCESSOR = new Accessor<ProjectTimeline, Long>() {

			@Override
			public Long get(ProjectTimeline projectTimeline) {
				return projectTimeline.getProjectTimelineId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProjectTimeline> getTypeClass() {
				return ProjectTimeline.class;
			}

		};

	/**
	 * Retourne l'equivalent en Freeemarker du format de date de la timeline
	 *
	 * @return Le format de date en freemarker, JJ/MM/AAAA dans le cas d'une timeline sans format encore defini
	 */
	public String getFreeMarkerFormatDate();

	/**
	 * Retourne la version JSON de l'entité
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

}