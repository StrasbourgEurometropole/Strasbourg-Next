/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ProjectTimeline}.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectTimeline
 * @generated
 */
public class ProjectTimelineWrapper
	extends BaseModelWrapper<ProjectTimeline>
	implements ModelWrapper<ProjectTimeline>, ProjectTimeline {

	public ProjectTimelineWrapper(ProjectTimeline projectTimeline) {
		super(projectTimeline);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("projectTimelineId", getProjectTimelineId());
		attributes.put("startDay", getStartDay());
		attributes.put("spacing", getSpacing());
		attributes.put("date", getDate());
		attributes.put("dateFormat", getDateFormat());
		attributes.put("title", getTitle());
		attributes.put("link", getLink());
		attributes.put("projectId", getProjectId());
		attributes.put("budgetParticipatifId", getBudgetParticipatifId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long projectTimelineId = (Long)attributes.get("projectTimelineId");

		if (projectTimelineId != null) {
			setProjectTimelineId(projectTimelineId);
		}

		Integer startDay = (Integer)attributes.get("startDay");

		if (startDay != null) {
			setStartDay(startDay);
		}

		Integer spacing = (Integer)attributes.get("spacing");

		if (spacing != null) {
			setSpacing(spacing);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String dateFormat = (String)attributes.get("dateFormat");

		if (dateFormat != null) {
			setDateFormat(dateFormat);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Long projectId = (Long)attributes.get("projectId");

		if (projectId != null) {
			setProjectId(projectId);
		}

		Long budgetParticipatifId = (Long)attributes.get(
			"budgetParticipatifId");

		if (budgetParticipatifId != null) {
			setBudgetParticipatifId(budgetParticipatifId);
		}
	}

	@Override
	public ProjectTimeline cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the budget participatif ID of this project timeline.
	 *
	 * @return the budget participatif ID of this project timeline
	 */
	@Override
	public long getBudgetParticipatifId() {
		return model.getBudgetParticipatifId();
	}

	/**
	 * Returns the date of this project timeline.
	 *
	 * @return the date of this project timeline
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the date format of this project timeline.
	 *
	 * @return the date format of this project timeline
	 */
	@Override
	public String getDateFormat() {
		return model.getDateFormat();
	}

	/**
	 * Retourne l'equivalent en Freeemarker du format de date de la timeline
	 *
	 * @return Le format de date en freemarker, JJ/MM/AAAA dans le cas d'une timeline sans format encore defini
	 */
	@Override
	public String getFreeMarkerFormatDate() {
		return model.getFreeMarkerFormatDate();
	}

	/**
	 * Returns the link of this project timeline.
	 *
	 * @return the link of this project timeline
	 */
	@Override
	public String getLink() {
		return model.getLink();
	}

	/**
	 * Returns the primary key of this project timeline.
	 *
	 * @return the primary key of this project timeline
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the project ID of this project timeline.
	 *
	 * @return the project ID of this project timeline
	 */
	@Override
	public long getProjectId() {
		return model.getProjectId();
	}

	/**
	 * Returns the project timeline ID of this project timeline.
	 *
	 * @return the project timeline ID of this project timeline
	 */
	@Override
	public long getProjectTimelineId() {
		return model.getProjectTimelineId();
	}

	/**
	 * Returns the spacing of this project timeline.
	 *
	 * @return the spacing of this project timeline
	 */
	@Override
	public int getSpacing() {
		return model.getSpacing();
	}

	/**
	 * Returns the start day of this project timeline.
	 *
	 * @return the start day of this project timeline
	 */
	@Override
	public int getStartDay() {
		return model.getStartDay();
	}

	/**
	 * Returns the title of this project timeline.
	 *
	 * @return the title of this project timeline
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the budget participatif ID of this project timeline.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this project timeline
	 */
	@Override
	public void setBudgetParticipatifId(long budgetParticipatifId) {
		model.setBudgetParticipatifId(budgetParticipatifId);
	}

	/**
	 * Sets the date of this project timeline.
	 *
	 * @param date the date of this project timeline
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the date format of this project timeline.
	 *
	 * @param dateFormat the date format of this project timeline
	 */
	@Override
	public void setDateFormat(String dateFormat) {
		model.setDateFormat(dateFormat);
	}

	/**
	 * Sets the link of this project timeline.
	 *
	 * @param link the link of this project timeline
	 */
	@Override
	public void setLink(String link) {
		model.setLink(link);
	}

	/**
	 * Sets the primary key of this project timeline.
	 *
	 * @param primaryKey the primary key of this project timeline
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the project ID of this project timeline.
	 *
	 * @param projectId the project ID of this project timeline
	 */
	@Override
	public void setProjectId(long projectId) {
		model.setProjectId(projectId);
	}

	/**
	 * Sets the project timeline ID of this project timeline.
	 *
	 * @param projectTimelineId the project timeline ID of this project timeline
	 */
	@Override
	public void setProjectTimelineId(long projectTimelineId) {
		model.setProjectTimelineId(projectTimelineId);
	}

	/**
	 * Sets the spacing of this project timeline.
	 *
	 * @param spacing the spacing of this project timeline
	 */
	@Override
	public void setSpacing(int spacing) {
		model.setSpacing(spacing);
	}

	/**
	 * Sets the start day of this project timeline.
	 *
	 * @param startDay the start day of this project timeline
	 */
	@Override
	public void setStartDay(int startDay) {
		model.setStartDay(startDay);
	}

	/**
	 * Sets the title of this project timeline.
	 *
	 * @param title the title of this project timeline
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Retourne la version JSON de l'entité
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject toJSON() {
		return model.toJSON();
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ProjectTimelineWrapper wrap(ProjectTimeline projectTimeline) {
		return new ProjectTimelineWrapper(projectTimeline);
	}

}