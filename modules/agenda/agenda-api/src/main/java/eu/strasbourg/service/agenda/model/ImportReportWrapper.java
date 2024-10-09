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
 * This class is a wrapper for {@link ImportReport}.
 * </p>
 *
 * @author BenjaminBini
 * @see ImportReport
 * @generated
 */
public class ImportReportWrapper
	extends BaseModelWrapper<ImportReport>
	implements ImportReport, ModelWrapper<ImportReport> {

	public ImportReportWrapper(ImportReport importReport) {
		super(importReport);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("reportId", getReportId());
		attributes.put("provider", getProvider());
		attributes.put("filename", getFilename());
		attributes.put("status", getStatus());
		attributes.put("globalErrorCause", getGlobalErrorCause());
		attributes.put("newEventsCount", getNewEventsCount());
		attributes.put("modifiedEventsCount", getModifiedEventsCount());
		attributes.put("errorEventsCount", getErrorEventsCount());
		attributes.put("unmodifiedEventsCount", getUnmodifiedEventsCount());
		attributes.put("deletedEventsCount", getDeletedEventsCount());
		attributes.put("newManifestationsCount", getNewManifestationsCount());
		attributes.put(
			"modifiedManifestationsCount", getModifiedManifestationsCount());
		attributes.put(
			"errorManifestationsCount", getErrorManifestationsCount());
		attributes.put(
			"unmodifiedManifestationsCount",
			getUnmodifiedManifestationsCount());
		attributes.put(
			"deletedManifestationsCount", getDeletedManifestationsCount());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long reportId = (Long)attributes.get("reportId");

		if (reportId != null) {
			setReportId(reportId);
		}

		String provider = (String)attributes.get("provider");

		if (provider != null) {
			setProvider(provider);
		}

		String filename = (String)attributes.get("filename");

		if (filename != null) {
			setFilename(filename);
		}

		Long status = (Long)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String globalErrorCause = (String)attributes.get("globalErrorCause");

		if (globalErrorCause != null) {
			setGlobalErrorCause(globalErrorCause);
		}

		Long newEventsCount = (Long)attributes.get("newEventsCount");

		if (newEventsCount != null) {
			setNewEventsCount(newEventsCount);
		}

		Long modifiedEventsCount = (Long)attributes.get("modifiedEventsCount");

		if (modifiedEventsCount != null) {
			setModifiedEventsCount(modifiedEventsCount);
		}

		Long errorEventsCount = (Long)attributes.get("errorEventsCount");

		if (errorEventsCount != null) {
			setErrorEventsCount(errorEventsCount);
		}

		Long unmodifiedEventsCount = (Long)attributes.get(
			"unmodifiedEventsCount");

		if (unmodifiedEventsCount != null) {
			setUnmodifiedEventsCount(unmodifiedEventsCount);
		}

		Long deletedEventsCount = (Long)attributes.get("deletedEventsCount");

		if (deletedEventsCount != null) {
			setDeletedEventsCount(deletedEventsCount);
		}

		Long newManifestationsCount = (Long)attributes.get(
			"newManifestationsCount");

		if (newManifestationsCount != null) {
			setNewManifestationsCount(newManifestationsCount);
		}

		Long modifiedManifestationsCount = (Long)attributes.get(
			"modifiedManifestationsCount");

		if (modifiedManifestationsCount != null) {
			setModifiedManifestationsCount(modifiedManifestationsCount);
		}

		Long errorManifestationsCount = (Long)attributes.get(
			"errorManifestationsCount");

		if (errorManifestationsCount != null) {
			setErrorManifestationsCount(errorManifestationsCount);
		}

		Long unmodifiedManifestationsCount = (Long)attributes.get(
			"unmodifiedManifestationsCount");

		if (unmodifiedManifestationsCount != null) {
			setUnmodifiedManifestationsCount(unmodifiedManifestationsCount);
		}

		Long deletedManifestationsCount = (Long)attributes.get(
			"deletedManifestationsCount");

		if (deletedManifestationsCount != null) {
			setDeletedManifestationsCount(deletedManifestationsCount);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}
	}

	@Override
	public ImportReport cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the deleted events count of this import report.
	 *
	 * @return the deleted events count of this import report
	 */
	@Override
	public long getDeletedEventsCount() {
		return model.getDeletedEventsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getDeletedEventsLines() {
		return model.getDeletedEventsLines();
	}

	/**
	 * Returns the deleted manifestations count of this import report.
	 *
	 * @return the deleted manifestations count of this import report
	 */
	@Override
	public long getDeletedManifestationsCount() {
		return model.getDeletedManifestationsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getDeletedManifestationsLines() {
		return model.getDeletedManifestationsLines();
	}

	/**
	 * Returns the end date of this import report.
	 *
	 * @return the end date of this import report
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the error events count of this import report.
	 *
	 * @return the error events count of this import report
	 */
	@Override
	public long getErrorEventsCount() {
		return model.getErrorEventsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getErrorEventsLines() {
		return model.getErrorEventsLines();
	}

	/**
	 * Returns the error manifestations count of this import report.
	 *
	 * @return the error manifestations count of this import report
	 */
	@Override
	public long getErrorManifestationsCount() {
		return model.getErrorManifestationsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getErrorManifestationsLines() {
		return model.getErrorManifestationsLines();
	}

	/**
	 * Returns the filename of this import report.
	 *
	 * @return the filename of this import report
	 */
	@Override
	public String getFilename() {
		return model.getFilename();
	}

	/**
	 * Returns the global error cause of this import report.
	 *
	 * @return the global error cause of this import report
	 */
	@Override
	public String getGlobalErrorCause() {
		return model.getGlobalErrorCause();
	}

	@Override
	public java.util.List<ImportReportLine> getLines() {
		return model.getLines();
	}

	/**
	 * Returns the modified events count of this import report.
	 *
	 * @return the modified events count of this import report
	 */
	@Override
	public long getModifiedEventsCount() {
		return model.getModifiedEventsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getModifiedEventsLines() {
		return model.getModifiedEventsLines();
	}

	/**
	 * Returns the modified manifestations count of this import report.
	 *
	 * @return the modified manifestations count of this import report
	 */
	@Override
	public long getModifiedManifestationsCount() {
		return model.getModifiedManifestationsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getModifiedManifestationsLines() {
		return model.getModifiedManifestationsLines();
	}

	/**
	 * Returns the new events count of this import report.
	 *
	 * @return the new events count of this import report
	 */
	@Override
	public long getNewEventsCount() {
		return model.getNewEventsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getNewEventsLines() {
		return model.getNewEventsLines();
	}

	/**
	 * Returns the new manifestations count of this import report.
	 *
	 * @return the new manifestations count of this import report
	 */
	@Override
	public long getNewManifestationsCount() {
		return model.getNewManifestationsCount();
	}

	@Override
	public java.util.List<ImportReportLine> getNewManifestationsLines() {
		return model.getNewManifestationsLines();
	}

	/**
	 * Returns the primary key of this import report.
	 *
	 * @return the primary key of this import report
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the provider of this import report.
	 *
	 * @return the provider of this import report
	 */
	@Override
	public String getProvider() {
		return model.getProvider();
	}

	/**
	 * Returns the report ID of this import report.
	 *
	 * @return the report ID of this import report
	 */
	@Override
	public long getReportId() {
		return model.getReportId();
	}

	/**
	 * Returns the start date of this import report.
	 *
	 * @return the start date of this import report
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this import report.
	 *
	 * @return the status of this import report
	 */
	@Override
	public long getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the unmodified events count of this import report.
	 *
	 * @return the unmodified events count of this import report
	 */
	@Override
	public long getUnmodifiedEventsCount() {
		return model.getUnmodifiedEventsCount();
	}

	/**
	 * Returns the unmodified manifestations count of this import report.
	 *
	 * @return the unmodified manifestations count of this import report
	 */
	@Override
	public long getUnmodifiedManifestationsCount() {
		return model.getUnmodifiedManifestationsCount();
	}

	/**
	 * Returns the uuid of this import report.
	 *
	 * @return the uuid of this import report
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void globalError(String cause) {
		model.globalError(cause);
	}

	@Override
	public void incrementDeletedEvents() {
		model.incrementDeletedEvents();
	}

	@Override
	public void incrementDeletedManifestations() {
		model.incrementDeletedManifestations();
	}

	@Override
	public void incrementErrorEvents() {
		model.incrementErrorEvents();
	}

	@Override
	public void incrementErrorManifestations() {
		model.incrementErrorManifestations();
	}

	@Override
	public void incrementModifiedEvents() {
		model.incrementModifiedEvents();
	}

	@Override
	public void incrementModifiedManifestations() {
		model.incrementModifiedManifestations();
	}

	@Override
	public void incrementNewEvents() {
		model.incrementNewEvents();
	}

	@Override
	public void incrementNewManifestations() {
		model.incrementNewManifestations();
	}

	@Override
	public void incrementUnmodifiedEvents() {
		model.incrementUnmodifiedEvents();
	}

	@Override
	public void incrementUnmodifiedManifestations() {
		model.incrementUnmodifiedManifestations();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void sendMail() {
		model.sendMail();
	}

	/**
	 * Sets the deleted events count of this import report.
	 *
	 * @param deletedEventsCount the deleted events count of this import report
	 */
	@Override
	public void setDeletedEventsCount(long deletedEventsCount) {
		model.setDeletedEventsCount(deletedEventsCount);
	}

	/**
	 * Sets the deleted manifestations count of this import report.
	 *
	 * @param deletedManifestationsCount the deleted manifestations count of this import report
	 */
	@Override
	public void setDeletedManifestationsCount(long deletedManifestationsCount) {
		model.setDeletedManifestationsCount(deletedManifestationsCount);
	}

	/**
	 * Sets the end date of this import report.
	 *
	 * @param endDate the end date of this import report
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the error events count of this import report.
	 *
	 * @param errorEventsCount the error events count of this import report
	 */
	@Override
	public void setErrorEventsCount(long errorEventsCount) {
		model.setErrorEventsCount(errorEventsCount);
	}

	/**
	 * Sets the error manifestations count of this import report.
	 *
	 * @param errorManifestationsCount the error manifestations count of this import report
	 */
	@Override
	public void setErrorManifestationsCount(long errorManifestationsCount) {
		model.setErrorManifestationsCount(errorManifestationsCount);
	}

	/**
	 * Sets the filename of this import report.
	 *
	 * @param filename the filename of this import report
	 */
	@Override
	public void setFilename(String filename) {
		model.setFilename(filename);
	}

	/**
	 * Sets the global error cause of this import report.
	 *
	 * @param globalErrorCause the global error cause of this import report
	 */
	@Override
	public void setGlobalErrorCause(String globalErrorCause) {
		model.setGlobalErrorCause(globalErrorCause);
	}

	/**
	 * Sets the modified events count of this import report.
	 *
	 * @param modifiedEventsCount the modified events count of this import report
	 */
	@Override
	public void setModifiedEventsCount(long modifiedEventsCount) {
		model.setModifiedEventsCount(modifiedEventsCount);
	}

	/**
	 * Sets the modified manifestations count of this import report.
	 *
	 * @param modifiedManifestationsCount the modified manifestations count of this import report
	 */
	@Override
	public void setModifiedManifestationsCount(
		long modifiedManifestationsCount) {

		model.setModifiedManifestationsCount(modifiedManifestationsCount);
	}

	/**
	 * Sets the new events count of this import report.
	 *
	 * @param newEventsCount the new events count of this import report
	 */
	@Override
	public void setNewEventsCount(long newEventsCount) {
		model.setNewEventsCount(newEventsCount);
	}

	/**
	 * Sets the new manifestations count of this import report.
	 *
	 * @param newManifestationsCount the new manifestations count of this import report
	 */
	@Override
	public void setNewManifestationsCount(long newManifestationsCount) {
		model.setNewManifestationsCount(newManifestationsCount);
	}

	/**
	 * Sets the primary key of this import report.
	 *
	 * @param primaryKey the primary key of this import report
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the provider of this import report.
	 *
	 * @param provider the provider of this import report
	 */
	@Override
	public void setProvider(String provider) {
		model.setProvider(provider);
	}

	/**
	 * Sets the report ID of this import report.
	 *
	 * @param reportId the report ID of this import report
	 */
	@Override
	public void setReportId(long reportId) {
		model.setReportId(reportId);
	}

	/**
	 * Sets the start date of this import report.
	 *
	 * @param startDate the start date of this import report
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this import report.
	 *
	 * @param status the status of this import report
	 */
	@Override
	public void setStatus(long status) {
		model.setStatus(status);
	}

	/**
	 * Sets the unmodified events count of this import report.
	 *
	 * @param unmodifiedEventsCount the unmodified events count of this import report
	 */
	@Override
	public void setUnmodifiedEventsCount(long unmodifiedEventsCount) {
		model.setUnmodifiedEventsCount(unmodifiedEventsCount);
	}

	/**
	 * Sets the unmodified manifestations count of this import report.
	 *
	 * @param unmodifiedManifestationsCount the unmodified manifestations count of this import report
	 */
	@Override
	public void setUnmodifiedManifestationsCount(
		long unmodifiedManifestationsCount) {

		model.setUnmodifiedManifestationsCount(unmodifiedManifestationsCount);
	}

	/**
	 * Sets the uuid of this import report.
	 *
	 * @param uuid the uuid of this import report
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
	protected ImportReportWrapper wrap(ImportReport importReport) {
		return new ImportReportWrapper(importReport);
	}

}