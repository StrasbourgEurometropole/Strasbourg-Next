/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BudgetPhase}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetPhase
 * @generated
 */
public class BudgetPhaseWrapper
	extends BaseModelWrapper<BudgetPhase>
	implements BudgetPhase, ModelWrapper<BudgetPhase> {

	public BudgetPhaseWrapper(BudgetPhase budgetPhase) {
		super(budgetPhase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("budgetPhaseId", getBudgetPhaseId());
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
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("numberOfVote", getNumberOfVote());
		attributes.put("isActive", isIsActive());
		attributes.put("beginDate", getBeginDate());
		attributes.put("endDate", getEndDate());
		attributes.put("beginVoteDate", getBeginVoteDate());
		attributes.put("endVoteDate", getEndVoteDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long budgetPhaseId = (Long)attributes.get("budgetPhaseId");

		if (budgetPhaseId != null) {
			setBudgetPhaseId(budgetPhaseId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long numberOfVote = (Long)attributes.get("numberOfVote");

		if (numberOfVote != null) {
			setNumberOfVote(numberOfVote);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}

		Date beginDate = (Date)attributes.get("beginDate");

		if (beginDate != null) {
			setBeginDate(beginDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date beginVoteDate = (Date)attributes.get("beginVoteDate");

		if (beginVoteDate != null) {
			setBeginVoteDate(beginVoteDate);
		}

		Date endVoteDate = (Date)attributes.get("endVoteDate");

		if (endVoteDate != null) {
			setEndVoteDate(endVoteDate);
		}
	}

	@Override
	public BudgetPhase cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the begin date of this budget phase.
	 *
	 * @return the begin date of this budget phase
	 */
	@Override
	public Date getBeginDate() {
		return model.getBeginDate();
	}

	/**
	 * Returns the begin vote date of this budget phase.
	 *
	 * @return the begin vote date of this budget phase
	 */
	@Override
	public Date getBeginVoteDate() {
		return model.getBeginVoteDate();
	}

	/**
	 * Returns the budget phase ID of this budget phase.
	 *
	 * @return the budget phase ID of this budget phase
	 */
	@Override
	public long getBudgetPhaseId() {
		return model.getBudgetPhaseId();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this budget phase.
	 *
	 * @return the company ID of this budget phase
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this budget phase.
	 *
	 * @return the create date of this budget phase
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the description of this budget phase.
	 *
	 * @return the description of this budget phase
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the end date of this budget phase.
	 *
	 * @return the end date of this budget phase
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the end vote date of this budget phase.
	 *
	 * @return the end vote date of this budget phase
	 */
	@Override
	public Date getEndVoteDate() {
		return model.getEndVoteDate();
	}

	/**
	 * Returns the group ID of this budget phase.
	 *
	 * @return the group ID of this budget phase
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is active of this budget phase.
	 *
	 * @return the is active of this budget phase
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Genere le label de haut de page affichant le temps restant avant de passer a la prochaine
	 * peridode de la phase en cours
	 */
	@Override
	public String getLivePeriodLabel() {
		return model.getLivePeriodLabel();
	}

	/**
	 * Returns the modified date of this budget phase.
	 *
	 * @return the modified date of this budget phase
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the number of vote of this budget phase.
	 *
	 * @return the number of vote of this budget phase
	 */
	@Override
	public long getNumberOfVote() {
		return model.getNumberOfVote();
	}

	/**
	 * Retourne la categorie "Phase du budget participatif" de la phase
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetCategory getPhaseCategory() {
		return model.getPhaseCategory();
	}

	/**
	 * La l'etat de la phase
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.project.constants.PhaseState getPhaseState() {
		return model.getPhaseState();
	}

	/**
	 * Returns the primary key of this budget phase.
	 *
	 * @return the primary key of this budget phase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the status of this budget phase.
	 *
	 * @return the status of this budget phase
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this budget phase.
	 *
	 * @return the status by user ID of this budget phase
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this budget phase.
	 *
	 * @return the status by user name of this budget phase
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this budget phase.
	 *
	 * @return the status by user uuid of this budget phase
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this budget phase.
	 *
	 * @return the status date of this budget phase
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this budget phase.
	 *
	 * @return the title of this budget phase
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this budget phase.
	 *
	 * @return the user ID of this budget phase
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this budget phase.
	 *
	 * @return the user name of this budget phase
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this budget phase.
	 *
	 * @return the user uuid of this budget phase
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this budget phase.
	 *
	 * @return the uuid of this budget phase
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this budget phase is approved.
	 *
	 * @return <code>true</code> if this budget phase is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this budget phase is denied.
	 *
	 * @return <code>true</code> if this budget phase is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this budget phase is a draft.
	 *
	 * @return <code>true</code> if this budget phase is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this budget phase is expired.
	 *
	 * @return <code>true</code> if this budget phase is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this budget phase is inactive.
	 *
	 * @return <code>true</code> if this budget phase is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this budget phase is incomplete.
	 *
	 * @return <code>true</code> if this budget phase is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Renvoie si la phase est en période de dépot
	 */
	@Override
	public boolean isInDepositPeriod() {
		return model.isInDepositPeriod();
	}

	/**
	 * Renvoie si la phase est en période de vote
	 */
	@Override
	public boolean isInVotingPeriod() {
		return model.isInVotingPeriod();
	}

	/**
	 * Returns <code>true</code> if this budget phase is is active.
	 *
	 * @return <code>true</code> if this budget phase is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	/**
	 * Returns <code>true</code> if this budget phase is pending.
	 *
	 * @return <code>true</code> if this budget phase is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this budget phase is scheduled.
	 *
	 * @return <code>true</code> if this budget phase is scheduled; <code>false</code> otherwise
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
	 * Sets the begin date of this budget phase.
	 *
	 * @param beginDate the begin date of this budget phase
	 */
	@Override
	public void setBeginDate(Date beginDate) {
		model.setBeginDate(beginDate);
	}

	/**
	 * Sets the begin vote date of this budget phase.
	 *
	 * @param beginVoteDate the begin vote date of this budget phase
	 */
	@Override
	public void setBeginVoteDate(Date beginVoteDate) {
		model.setBeginVoteDate(beginVoteDate);
	}

	/**
	 * Sets the budget phase ID of this budget phase.
	 *
	 * @param budgetPhaseId the budget phase ID of this budget phase
	 */
	@Override
	public void setBudgetPhaseId(long budgetPhaseId) {
		model.setBudgetPhaseId(budgetPhaseId);
	}

	/**
	 * Sets the company ID of this budget phase.
	 *
	 * @param companyId the company ID of this budget phase
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this budget phase.
	 *
	 * @param createDate the create date of this budget phase
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the description of this budget phase.
	 *
	 * @param description the description of this budget phase
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the end date of this budget phase.
	 *
	 * @param endDate the end date of this budget phase
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the end vote date of this budget phase.
	 *
	 * @param endVoteDate the end vote date of this budget phase
	 */
	@Override
	public void setEndVoteDate(Date endVoteDate) {
		model.setEndVoteDate(endVoteDate);
	}

	/**
	 * Sets the group ID of this budget phase.
	 *
	 * @param groupId the group ID of this budget phase
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this budget phase is is active.
	 *
	 * @param isActive the is active of this budget phase
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the modified date of this budget phase.
	 *
	 * @param modifiedDate the modified date of this budget phase
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the number of vote of this budget phase.
	 *
	 * @param numberOfVote the number of vote of this budget phase
	 */
	@Override
	public void setNumberOfVote(long numberOfVote) {
		model.setNumberOfVote(numberOfVote);
	}

	/**
	 * Sets the primary key of this budget phase.
	 *
	 * @param primaryKey the primary key of this budget phase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the status of this budget phase.
	 *
	 * @param status the status of this budget phase
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this budget phase.
	 *
	 * @param statusByUserId the status by user ID of this budget phase
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this budget phase.
	 *
	 * @param statusByUserName the status by user name of this budget phase
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this budget phase.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget phase
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this budget phase.
	 *
	 * @param statusDate the status date of this budget phase
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this budget phase.
	 *
	 * @param title the title of this budget phase
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this budget phase.
	 *
	 * @param userId the user ID of this budget phase
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this budget phase.
	 *
	 * @param userName the user name of this budget phase
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this budget phase.
	 *
	 * @param userUuid the user uuid of this budget phase
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this budget phase.
	 *
	 * @param uuid the uuid of this budget phase
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
	protected BudgetPhaseWrapper wrap(BudgetPhase budgetPhase) {
		return new BudgetPhaseWrapper(budgetPhase);
	}

}