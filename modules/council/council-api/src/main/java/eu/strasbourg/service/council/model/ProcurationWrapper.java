/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Procuration}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Procuration
 * @generated
 */
public class ProcurationWrapper
	extends BaseModelWrapper<Procuration>
	implements ModelWrapper<Procuration>, Procuration {

	public ProcurationWrapper(Procuration procuration) {
		super(procuration);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("procurationId", getProcurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("officialVotersId", getOfficialVotersId());
		attributes.put("officialUnavailableId", getOfficialUnavailableId());
		attributes.put("councilSessionId", getCouncilSessionId());
		attributes.put("isAbsent", isIsAbsent());
		attributes.put("procurationMode", getProcurationMode());
		attributes.put("presential", getPresential());
		attributes.put("isAfterVote", isIsAfterVote());
		attributes.put("startHour", getStartHour());
		attributes.put("endHour", getEndHour());
		attributes.put("startDelib", getStartDelib());
		attributes.put("endDelib", getEndDelib());
		attributes.put("otherProcurationMode", getOtherProcurationMode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long procurationId = (Long)attributes.get("procurationId");

		if (procurationId != null) {
			setProcurationId(procurationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		Long officialVotersId = (Long)attributes.get("officialVotersId");

		if (officialVotersId != null) {
			setOfficialVotersId(officialVotersId);
		}

		Long officialUnavailableId = (Long)attributes.get(
			"officialUnavailableId");

		if (officialUnavailableId != null) {
			setOfficialUnavailableId(officialUnavailableId);
		}

		Long councilSessionId = (Long)attributes.get("councilSessionId");

		if (councilSessionId != null) {
			setCouncilSessionId(councilSessionId);
		}

		Boolean isAbsent = (Boolean)attributes.get("isAbsent");

		if (isAbsent != null) {
			setIsAbsent(isAbsent);
		}

		Integer procurationMode = (Integer)attributes.get("procurationMode");

		if (procurationMode != null) {
			setProcurationMode(procurationMode);
		}

		Integer presential = (Integer)attributes.get("presential");

		if (presential != null) {
			setPresential(presential);
		}

		Boolean isAfterVote = (Boolean)attributes.get("isAfterVote");

		if (isAfterVote != null) {
			setIsAfterVote(isAfterVote);
		}

		Date startHour = (Date)attributes.get("startHour");

		if (startHour != null) {
			setStartHour(startHour);
		}

		Date endHour = (Date)attributes.get("endHour");

		if (endHour != null) {
			setEndHour(endHour);
		}

		Long startDelib = (Long)attributes.get("startDelib");

		if (startDelib != null) {
			setStartDelib(startDelib);
		}

		Long endDelib = (Long)attributes.get("endDelib");

		if (endDelib != null) {
			setEndDelib(endDelib);
		}

		String otherProcurationMode = (String)attributes.get(
			"otherProcurationMode");

		if (otherProcurationMode != null) {
			setOtherProcurationMode(otherProcurationMode);
		}
	}

	@Override
	public Procuration cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this procuration.
	 *
	 * @return the company ID of this procuration
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the council session ID of this procuration.
	 *
	 * @return the council session ID of this procuration
	 */
	@Override
	public long getCouncilSessionId() {
		return model.getCouncilSessionId();
	}

	/**
	 * Returns the create date of this procuration.
	 *
	 * @return the create date of this procuration
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the end delib of this procuration.
	 *
	 * @return the end delib of this procuration
	 */
	@Override
	public long getEndDelib() {
		return model.getEndDelib();
	}

	/**
	 * Returns the end hour of this procuration.
	 *
	 * @return the end hour of this procuration
	 */
	@Override
	public Date getEndHour() {
		return model.getEndHour();
	}

	/**
	 * Returns the group ID of this procuration.
	 *
	 * @return the group ID of this procuration
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is absent of this procuration.
	 *
	 * @return the is absent of this procuration
	 */
	@Override
	public boolean getIsAbsent() {
		return model.getIsAbsent();
	}

	/**
	 * Returns the is after vote of this procuration.
	 *
	 * @return the is after vote of this procuration
	 */
	@Override
	public boolean getIsAfterVote() {
		return model.getIsAfterVote();
	}

	/**
	 * Returns the modified date of this procuration.
	 *
	 * @return the modified date of this procuration
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the official unavailable ID of this procuration.
	 *
	 * @return the official unavailable ID of this procuration
	 */
	@Override
	public long getOfficialUnavailableId() {
		return model.getOfficialUnavailableId();
	}

	/**
	 * Retourne le nom complet de l'élu reçevant la procuration
	 */
	@Override
	public String getOfficialVotersFullName() {
		return model.getOfficialVotersFullName();
	}

	/**
	 * Returns the official voters ID of this procuration.
	 *
	 * @return the official voters ID of this procuration
	 */
	@Override
	public long getOfficialVotersId() {
		return model.getOfficialVotersId();
	}

	/**
	 * Returns the other procuration mode of this procuration.
	 *
	 * @return the other procuration mode of this procuration
	 */
	@Override
	public String getOtherProcurationMode() {
		return model.getOtherProcurationMode();
	}

	/**
	 * Returns the presential of this procuration.
	 *
	 * @return the presential of this procuration
	 */
	@Override
	public int getPresential() {
		return model.getPresential();
	}

	/**
	 * Returns the primary key of this procuration.
	 *
	 * @return the primary key of this procuration
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the procuration ID of this procuration.
	 *
	 * @return the procuration ID of this procuration
	 */
	@Override
	public long getProcurationId() {
		return model.getProcurationId();
	}

	/**
	 * Returns the procuration mode of this procuration.
	 *
	 * @return the procuration mode of this procuration
	 */
	@Override
	public int getProcurationMode() {
		return model.getProcurationMode();
	}

	/**
	 * Returns the start delib of this procuration.
	 *
	 * @return the start delib of this procuration
	 */
	@Override
	public long getStartDelib() {
		return model.getStartDelib();
	}

	/**
	 * Returns the start hour of this procuration.
	 *
	 * @return the start hour of this procuration
	 */
	@Override
	public Date getStartHour() {
		return model.getStartHour();
	}

	/**
	 * Returns the status of this procuration.
	 *
	 * @return the status of this procuration
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this procuration.
	 *
	 * @return the status by user ID of this procuration
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this procuration.
	 *
	 * @return the status by user name of this procuration
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this procuration.
	 *
	 * @return the status by user uuid of this procuration
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this procuration.
	 *
	 * @return the status date of this procuration
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this procuration.
	 *
	 * @return the user ID of this procuration
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this procuration.
	 *
	 * @return the user name of this procuration
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this procuration.
	 *
	 * @return the user uuid of this procuration
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this procuration.
	 *
	 * @return the uuid of this procuration
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this procuration is approved.
	 *
	 * @return <code>true</code> if this procuration is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this procuration is denied.
	 *
	 * @return <code>true</code> if this procuration is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this procuration is a draft.
	 *
	 * @return <code>true</code> if this procuration is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this procuration is expired.
	 *
	 * @return <code>true</code> if this procuration is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this procuration is inactive.
	 *
	 * @return <code>true</code> if this procuration is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this procuration is incomplete.
	 *
	 * @return <code>true</code> if this procuration is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this procuration is is absent.
	 *
	 * @return <code>true</code> if this procuration is is absent; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsAbsent() {
		return model.isIsAbsent();
	}

	/**
	 * Returns <code>true</code> if this procuration is is after vote.
	 *
	 * @return <code>true</code> if this procuration is is after vote; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsAfterVote() {
		return model.isIsAfterVote();
	}

	/**
	 * Returns <code>true</code> if this procuration is pending.
	 *
	 * @return <code>true</code> if this procuration is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this procuration is scheduled.
	 *
	 * @return <code>true</code> if this procuration is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the company ID of this procuration.
	 *
	 * @param companyId the company ID of this procuration
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the council session ID of this procuration.
	 *
	 * @param councilSessionId the council session ID of this procuration
	 */
	@Override
	public void setCouncilSessionId(long councilSessionId) {
		model.setCouncilSessionId(councilSessionId);
	}

	/**
	 * Sets the create date of this procuration.
	 *
	 * @param createDate the create date of this procuration
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the end delib of this procuration.
	 *
	 * @param endDelib the end delib of this procuration
	 */
	@Override
	public void setEndDelib(long endDelib) {
		model.setEndDelib(endDelib);
	}

	/**
	 * Sets the end hour of this procuration.
	 *
	 * @param endHour the end hour of this procuration
	 */
	@Override
	public void setEndHour(Date endHour) {
		model.setEndHour(endHour);
	}

	/**
	 * Sets the group ID of this procuration.
	 *
	 * @param groupId the group ID of this procuration
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this procuration is is absent.
	 *
	 * @param isAbsent the is absent of this procuration
	 */
	@Override
	public void setIsAbsent(boolean isAbsent) {
		model.setIsAbsent(isAbsent);
	}

	/**
	 * Sets whether this procuration is is after vote.
	 *
	 * @param isAfterVote the is after vote of this procuration
	 */
	@Override
	public void setIsAfterVote(boolean isAfterVote) {
		model.setIsAfterVote(isAfterVote);
	}

	/**
	 * Sets the modified date of this procuration.
	 *
	 * @param modifiedDate the modified date of this procuration
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the official unavailable ID of this procuration.
	 *
	 * @param officialUnavailableId the official unavailable ID of this procuration
	 */
	@Override
	public void setOfficialUnavailableId(long officialUnavailableId) {
		model.setOfficialUnavailableId(officialUnavailableId);
	}

	/**
	 * Sets the official voters ID of this procuration.
	 *
	 * @param officialVotersId the official voters ID of this procuration
	 */
	@Override
	public void setOfficialVotersId(long officialVotersId) {
		model.setOfficialVotersId(officialVotersId);
	}

	/**
	 * Sets the other procuration mode of this procuration.
	 *
	 * @param otherProcurationMode the other procuration mode of this procuration
	 */
	@Override
	public void setOtherProcurationMode(String otherProcurationMode) {
		model.setOtherProcurationMode(otherProcurationMode);
	}

	/**
	 * Sets the presential of this procuration.
	 *
	 * @param presential the presential of this procuration
	 */
	@Override
	public void setPresential(int presential) {
		model.setPresential(presential);
	}

	/**
	 * Sets the primary key of this procuration.
	 *
	 * @param primaryKey the primary key of this procuration
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the procuration ID of this procuration.
	 *
	 * @param procurationId the procuration ID of this procuration
	 */
	@Override
	public void setProcurationId(long procurationId) {
		model.setProcurationId(procurationId);
	}

	/**
	 * Sets the procuration mode of this procuration.
	 *
	 * @param procurationMode the procuration mode of this procuration
	 */
	@Override
	public void setProcurationMode(int procurationMode) {
		model.setProcurationMode(procurationMode);
	}

	/**
	 * Sets the start delib of this procuration.
	 *
	 * @param startDelib the start delib of this procuration
	 */
	@Override
	public void setStartDelib(long startDelib) {
		model.setStartDelib(startDelib);
	}

	/**
	 * Sets the start hour of this procuration.
	 *
	 * @param startHour the start hour of this procuration
	 */
	@Override
	public void setStartHour(Date startHour) {
		model.setStartHour(startHour);
	}

	/**
	 * Sets the status of this procuration.
	 *
	 * @param status the status of this procuration
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this procuration.
	 *
	 * @param statusByUserId the status by user ID of this procuration
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this procuration.
	 *
	 * @param statusByUserName the status by user name of this procuration
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this procuration.
	 *
	 * @param statusByUserUuid the status by user uuid of this procuration
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this procuration.
	 *
	 * @param statusDate the status date of this procuration
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this procuration.
	 *
	 * @param userId the user ID of this procuration
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this procuration.
	 *
	 * @param userName the user name of this procuration
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this procuration.
	 *
	 * @param userUuid the user uuid of this procuration
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this procuration.
	 *
	 * @param uuid the uuid of this procuration
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected ProcurationWrapper wrap(Procuration procuration) {
		return new ProcurationWrapper(procuration);
	}

}