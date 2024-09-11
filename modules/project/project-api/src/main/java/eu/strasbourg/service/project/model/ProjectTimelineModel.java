/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the ProjectTimeline service. Represents a row in the &quot;project_ProjectTimeline&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.ProjectTimelineModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.ProjectTimelineImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectTimeline
 * @generated
 */
@ProviderType
public interface ProjectTimelineModel extends BaseModel<ProjectTimeline> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a project timeline model instance should use the {@link ProjectTimeline} interface instead.
	 */

	/**
	 * Returns the primary key of this project timeline.
	 *
	 * @return the primary key of this project timeline
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this project timeline.
	 *
	 * @param primaryKey the primary key of this project timeline
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the project timeline ID of this project timeline.
	 *
	 * @return the project timeline ID of this project timeline
	 */
	public long getProjectTimelineId();

	/**
	 * Sets the project timeline ID of this project timeline.
	 *
	 * @param projectTimelineId the project timeline ID of this project timeline
	 */
	public void setProjectTimelineId(long projectTimelineId);

	/**
	 * Returns the start day of this project timeline.
	 *
	 * @return the start day of this project timeline
	 */
	public int getStartDay();

	/**
	 * Sets the start day of this project timeline.
	 *
	 * @param startDay the start day of this project timeline
	 */
	public void setStartDay(int startDay);

	/**
	 * Returns the spacing of this project timeline.
	 *
	 * @return the spacing of this project timeline
	 */
	public int getSpacing();

	/**
	 * Sets the spacing of this project timeline.
	 *
	 * @param spacing the spacing of this project timeline
	 */
	public void setSpacing(int spacing);

	/**
	 * Returns the date of this project timeline.
	 *
	 * @return the date of this project timeline
	 */
	public Date getDate();

	/**
	 * Sets the date of this project timeline.
	 *
	 * @param date the date of this project timeline
	 */
	public void setDate(Date date);

	/**
	 * Returns the date format of this project timeline.
	 *
	 * @return the date format of this project timeline
	 */
	@AutoEscape
	public String getDateFormat();

	/**
	 * Sets the date format of this project timeline.
	 *
	 * @param dateFormat the date format of this project timeline
	 */
	public void setDateFormat(String dateFormat);

	/**
	 * Returns the title of this project timeline.
	 *
	 * @return the title of this project timeline
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this project timeline.
	 *
	 * @param title the title of this project timeline
	 */
	public void setTitle(String title);

	/**
	 * Returns the link of this project timeline.
	 *
	 * @return the link of this project timeline
	 */
	@AutoEscape
	public String getLink();

	/**
	 * Sets the link of this project timeline.
	 *
	 * @param link the link of this project timeline
	 */
	public void setLink(String link);

	/**
	 * Returns the project ID of this project timeline.
	 *
	 * @return the project ID of this project timeline
	 */
	public long getProjectId();

	/**
	 * Sets the project ID of this project timeline.
	 *
	 * @param projectId the project ID of this project timeline
	 */
	public void setProjectId(long projectId);

	/**
	 * Returns the budget participatif ID of this project timeline.
	 *
	 * @return the budget participatif ID of this project timeline
	 */
	public long getBudgetParticipatifId();

	/**
	 * Sets the budget participatif ID of this project timeline.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this project timeline
	 */
	public void setBudgetParticipatifId(long budgetParticipatifId);

	@Override
	public ProjectTimeline cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}