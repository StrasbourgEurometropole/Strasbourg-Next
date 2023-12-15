/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ImportReportLine}.
 * </p>
 *
 * @author BenjaminBini
 * @see ImportReportLine
 * @generated
 */
public class ImportReportLineWrapper
	extends BaseModelWrapper<ImportReportLine>
	implements ImportReportLine, ModelWrapper<ImportReportLine> {

	public ImportReportLineWrapper(ImportReportLine importReportLine) {
		super(importReportLine);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("lineId", getLineId());
		attributes.put("type", getType());
		attributes.put("status", getStatus());
		attributes.put("log", getLog());
		attributes.put("entityName", getEntityName());
		attributes.put("entityExternalId", getEntityExternalId());
		attributes.put("entityId", getEntityId());
		attributes.put("reportId", getReportId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long lineId = (Long)attributes.get("lineId");

		if (lineId != null) {
			setLineId(lineId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String log = (String)attributes.get("log");

		if (log != null) {
			setLog(log);
		}

		String entityName = (String)attributes.get("entityName");

		if (entityName != null) {
			setEntityName(entityName);
		}

		String entityExternalId = (String)attributes.get("entityExternalId");

		if (entityExternalId != null) {
			setEntityExternalId(entityExternalId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}
	}

	@Override
	public ImportReportLine cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public void error(String cause) {
		model.error(cause);
	}

	/**
	 * Returns the entity external ID of this import report line.
	 *
	 * @return the entity external ID of this import report line
	 */
	@Override
	public String getEntityExternalId() {
		return model.getEntityExternalId();
	}

	/**
	 * Returns the entity ID of this import report line.
	 *
	 * @return the entity ID of this import report line
	 */
	@Override
	public long getEntityId() {
		return model.getEntityId();
	}

	/**
	 * Returns the entity name of this import report line.
	 *
	 * @return the entity name of this import report line
	 */
	@Override
	public String getEntityName() {
		return model.getEntityName();
	}

	/**
	 * Returns the line ID of this import report line.
	 *
	 * @return the line ID of this import report line
	 */
	@Override
	public long getLineId() {
		return model.getLineId();
	}

	/**
	 * Returns the log of this import report line.
	 *
	 * @return the log of this import report line
	 */
	@Override
	public String getLog() {
		return model.getLog();
	}

	/**
	 * Returns the primary key of this import report line.
	 *
	 * @return the primary key of this import report line
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the report ID of this import report line.
	 *
	 * @return the report ID of this import report line
	 */
	@Override
	public long getReportId() {
		return model.getReportId();
	}

	/**
	 * Returns the status of this import report line.
	 *
	 * @return the status of this import report line
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the type of this import report line.
	 *
	 * @return the type of this import report line
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this import report line.
	 *
	 * @return the uuid of this import report line
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public boolean hasError() {
		return model.hasError();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the entity external ID of this import report line.
	 *
	 * @param entityExternalId the entity external ID of this import report line
	 */
	@Override
	public void setEntityExternalId(String entityExternalId) {
		model.setEntityExternalId(entityExternalId);
	}

	/**
	 * Sets the entity ID of this import report line.
	 *
	 * @param entityId the entity ID of this import report line
	 */
	@Override
	public void setEntityId(long entityId) {
		model.setEntityId(entityId);
	}

	/**
	 * Sets the entity name of this import report line.
	 *
	 * @param entityName the entity name of this import report line
	 */
	@Override
	public void setEntityName(String entityName) {
		model.setEntityName(entityName);
	}

	/**
	 * Sets the line ID of this import report line.
	 *
	 * @param lineId the line ID of this import report line
	 */
	@Override
	public void setLineId(long lineId) {
		model.setLineId(lineId);
	}

	/**
	 * Sets the log of this import report line.
	 *
	 * @param log the log of this import report line
	 */
	@Override
	public void setLog(String log) {
		model.setLog(log);
	}

	/**
	 * Sets the primary key of this import report line.
	 *
	 * @param primaryKey the primary key of this import report line
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the report ID of this import report line.
	 *
	 * @param reportId the report ID of this import report line
	 */
	@Override
	public void setReportId(long reportId) {
		model.setReportId(reportId);
	}

	/**
	 * Sets the status of this import report line.
	 *
	 * @param status the status of this import report line
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the type of this import report line.
	 *
	 * @param type the type of this import report line
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this import report line.
	 *
	 * @param uuid the uuid of this import report line
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
	protected ImportReportLineWrapper wrap(ImportReportLine importReportLine) {
		return new ImportReportLineWrapper(importReportLine);
	}

}