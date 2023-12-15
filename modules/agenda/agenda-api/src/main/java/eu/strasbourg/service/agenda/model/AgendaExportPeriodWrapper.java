/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AgendaExportPeriod}.
 * </p>
 *
 * @author BenjaminBini
 * @see AgendaExportPeriod
 * @generated
 */
public class AgendaExportPeriodWrapper
	extends BaseModelWrapper<AgendaExportPeriod>
	implements AgendaExportPeriod, ModelWrapper<AgendaExportPeriod> {

	public AgendaExportPeriodWrapper(AgendaExportPeriod agendaExportPeriod) {
		super(agendaExportPeriod);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("agendaExportPeriodId", getAgendaExportPeriodId());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("agendaExportId", getAgendaExportId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long agendaExportPeriodId = (Long)attributes.get(
			"agendaExportPeriodId");

		if (agendaExportPeriodId != null) {
			setAgendaExportPeriodId(agendaExportPeriodId);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Long agendaExportId = (Long)attributes.get("agendaExportId");

		if (agendaExportId != null) {
			setAgendaExportId(agendaExportId);
		}
	}

	@Override
	public AgendaExportPeriod cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agenda export ID of this agenda export period.
	 *
	 * @return the agenda export ID of this agenda export period
	 */
	@Override
	public long getAgendaExportId() {
		return model.getAgendaExportId();
	}

	/**
	 * Returns the agenda export period ID of this agenda export period.
	 *
	 * @return the agenda export period ID of this agenda export period
	 */
	@Override
	public long getAgendaExportPeriodId() {
		return model.getAgendaExportPeriodId();
	}

	/**
	 * Returns the end date of this agenda export period.
	 *
	 * @return the end date of this agenda export period
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the primary key of this agenda export period.
	 *
	 * @return the primary key of this agenda export period
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the start date of this agenda export period.
	 *
	 * @return the start date of this agenda export period
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the uuid of this agenda export period.
	 *
	 * @return the uuid of this agenda export period
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the agenda export ID of this agenda export period.
	 *
	 * @param agendaExportId the agenda export ID of this agenda export period
	 */
	@Override
	public void setAgendaExportId(long agendaExportId) {
		model.setAgendaExportId(agendaExportId);
	}

	/**
	 * Sets the agenda export period ID of this agenda export period.
	 *
	 * @param agendaExportPeriodId the agenda export period ID of this agenda export period
	 */
	@Override
	public void setAgendaExportPeriodId(long agendaExportPeriodId) {
		model.setAgendaExportPeriodId(agendaExportPeriodId);
	}

	/**
	 * Sets the end date of this agenda export period.
	 *
	 * @param endDate the end date of this agenda export period
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the primary key of this agenda export period.
	 *
	 * @param primaryKey the primary key of this agenda export period
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the start date of this agenda export period.
	 *
	 * @param startDate the start date of this agenda export period
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the uuid of this agenda export period.
	 *
	 * @param uuid the uuid of this agenda export period
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected AgendaExportPeriodWrapper wrap(
		AgendaExportPeriod agendaExportPeriod) {

		return new AgendaExportPeriodWrapper(agendaExportPeriod);
	}

}