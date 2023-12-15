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
 * This class is a wrapper for {@link Deliberation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Deliberation
 * @generated
 */
public class DeliberationWrapper
	extends BaseModelWrapper<Deliberation>
	implements Deliberation, ModelWrapper<Deliberation> {

	public DeliberationWrapper(Deliberation deliberation) {
		super(deliberation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("deliberationId", getDeliberationId());
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
		attributes.put("order", getOrder());
		attributes.put("stage", getStage());
		attributes.put("countOfficialsVoting", getCountOfficialsVoting());
		attributes.put("countOfficialsActive", getCountOfficialsActive());
		attributes.put("quorum", getQuorum());
		attributes.put("beginningVoteDate", getBeginningVoteDate());
		attributes.put("endVoteDate", getEndVoteDate());
		attributes.put("councilSessionId", getCouncilSessionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long deliberationId = (Long)attributes.get("deliberationId");

		if (deliberationId != null) {
			setDeliberationId(deliberationId);
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

		Integer order = (Integer)attributes.get("order");

		if (order != null) {
			setOrder(order);
		}

		String stage = (String)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		Integer countOfficialsVoting = (Integer)attributes.get(
			"countOfficialsVoting");

		if (countOfficialsVoting != null) {
			setCountOfficialsVoting(countOfficialsVoting);
		}

		Integer countOfficialsActive = (Integer)attributes.get(
			"countOfficialsActive");

		if (countOfficialsActive != null) {
			setCountOfficialsActive(countOfficialsActive);
		}

		Integer quorum = (Integer)attributes.get("quorum");

		if (quorum != null) {
			setQuorum(quorum);
		}

		Date beginningVoteDate = (Date)attributes.get("beginningVoteDate");

		if (beginningVoteDate != null) {
			setBeginningVoteDate(beginningVoteDate);
		}

		Date endVoteDate = (Date)attributes.get("endVoteDate");

		if (endVoteDate != null) {
			setEndVoteDate(endVoteDate);
		}

		Long councilSessionId = (Long)attributes.get("councilSessionId");

		if (councilSessionId != null) {
			setCouncilSessionId(councilSessionId);
		}
	}

	@Override
	public Deliberation cloneWithOriginalValues() {
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
	 * Returns the beginning vote date of this deliberation.
	 *
	 * @return the beginning vote date of this deliberation
	 */
	@Override
	public Date getBeginningVoteDate() {
		return model.getBeginningVoteDate();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the company ID of this deliberation.
	 *
	 * @return the company ID of this deliberation
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	@Override
	public eu.strasbourg.service.council.model.CouncilSession
		getCouncilSession() {

		return model.getCouncilSession();
	}

	/**
	 * Returns the council session ID of this deliberation.
	 *
	 * @return the council session ID of this deliberation
	 */
	@Override
	public long getCouncilSessionId() {
		return model.getCouncilSessionId();
	}

	/**
	 * Returns the count officials active of this deliberation.
	 *
	 * @return the count officials active of this deliberation
	 */
	@Override
	public int getCountOfficialsActive() {
		return model.getCountOfficialsActive();
	}

	/**
	 * Returns the count officials voting of this deliberation.
	 *
	 * @return the count officials voting of this deliberation
	 */
	@Override
	public int getCountOfficialsVoting() {
		return model.getCountOfficialsVoting();
	}

	/**
	 * Returns the create date of this deliberation.
	 *
	 * @return the create date of this deliberation
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deliberation ID of this deliberation.
	 *
	 * @return the deliberation ID of this deliberation
	 */
	@Override
	public long getDeliberationId() {
		return model.getDeliberationId();
	}

	/**
	 * Returns the end vote date of this deliberation.
	 *
	 * @return the end vote date of this deliberation
	 */
	@Override
	public Date getEndVoteDate() {
		return model.getEndVoteDate();
	}

	/**
	 * Returns the group ID of this deliberation.
	 *
	 * @return the group ID of this deliberation
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this deliberation.
	 *
	 * @return the modified date of this deliberation
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the order of this deliberation.
	 *
	 * @return the order of this deliberation
	 */
	@Override
	public int getOrder() {
		return model.getOrder();
	}

	/**
	 * Returns the primary key of this deliberation.
	 *
	 * @return the primary key of this deliberation
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quorum of this deliberation.
	 *
	 * @return the quorum of this deliberation
	 */
	@Override
	public int getQuorum() {
		return model.getQuorum();
	}

	/**
	 * Returns the stage of this deliberation.
	 *
	 * @return the stage of this deliberation
	 */
	@Override
	public String getStage() {
		return model.getStage();
	}

	/**
	 * Returns the status of this deliberation.
	 *
	 * @return the status of this deliberation
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this deliberation.
	 *
	 * @return the status by user ID of this deliberation
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this deliberation.
	 *
	 * @return the status by user name of this deliberation
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this deliberation.
	 *
	 * @return the status by user uuid of this deliberation
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this deliberation.
	 *
	 * @return the status date of this deliberation
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the title of this deliberation.
	 *
	 * @return the title of this deliberation
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the user ID of this deliberation.
	 *
	 * @return the user ID of this deliberation
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this deliberation.
	 *
	 * @return the user name of this deliberation
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this deliberation.
	 *
	 * @return the user uuid of this deliberation
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this deliberation.
	 *
	 * @return the uuid of this deliberation
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public boolean isAdopte() {
		return model.isAdopte();
	}

	@Override
	public boolean isAffichageEnCours() {
		return model.isAffichageEnCours();
	}

	/**
	 * Returns <code>true</code> if this deliberation is approved.
	 *
	 * @return <code>true</code> if this deliberation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	@Override
	public boolean isCommunique() {
		return model.isCommunique();
	}

	@Override
	public boolean isCree() {
		return model.isCree();
	}

	/**
	 * Returns <code>true</code> if this deliberation is denied.
	 *
	 * @return <code>true</code> if this deliberation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this deliberation is a draft.
	 *
	 * @return <code>true</code> if this deliberation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this deliberation is expired.
	 *
	 * @return <code>true</code> if this deliberation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this deliberation is inactive.
	 *
	 * @return <code>true</code> if this deliberation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this deliberation is incomplete.
	 *
	 * @return <code>true</code> if this deliberation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this deliberation is pending.
	 *
	 * @return <code>true</code> if this deliberation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	@Override
	public boolean isRejete() {
		return model.isRejete();
	}

	@Override
	public boolean isRetire() {
		return model.isRetire();
	}

	/**
	 * Returns <code>true</code> if this deliberation is scheduled.
	 *
	 * @return <code>true</code> if this deliberation is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public boolean isVoteOuvert() {
		return model.isVoteOuvert();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the beginning vote date of this deliberation.
	 *
	 * @param beginningVoteDate the beginning vote date of this deliberation
	 */
	@Override
	public void setBeginningVoteDate(Date beginningVoteDate) {
		model.setBeginningVoteDate(beginningVoteDate);
	}

	/**
	 * Sets the company ID of this deliberation.
	 *
	 * @param companyId the company ID of this deliberation
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the council session ID of this deliberation.
	 *
	 * @param councilSessionId the council session ID of this deliberation
	 */
	@Override
	public void setCouncilSessionId(long councilSessionId) {
		model.setCouncilSessionId(councilSessionId);
	}

	/**
	 * Sets the count officials active of this deliberation.
	 *
	 * @param countOfficialsActive the count officials active of this deliberation
	 */
	@Override
	public void setCountOfficialsActive(int countOfficialsActive) {
		model.setCountOfficialsActive(countOfficialsActive);
	}

	/**
	 * Sets the count officials voting of this deliberation.
	 *
	 * @param countOfficialsVoting the count officials voting of this deliberation
	 */
	@Override
	public void setCountOfficialsVoting(int countOfficialsVoting) {
		model.setCountOfficialsVoting(countOfficialsVoting);
	}

	/**
	 * Sets the create date of this deliberation.
	 *
	 * @param createDate the create date of this deliberation
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deliberation ID of this deliberation.
	 *
	 * @param deliberationId the deliberation ID of this deliberation
	 */
	@Override
	public void setDeliberationId(long deliberationId) {
		model.setDeliberationId(deliberationId);
	}

	/**
	 * Sets the end vote date of this deliberation.
	 *
	 * @param endVoteDate the end vote date of this deliberation
	 */
	@Override
	public void setEndVoteDate(Date endVoteDate) {
		model.setEndVoteDate(endVoteDate);
	}

	/**
	 * Sets the group ID of this deliberation.
	 *
	 * @param groupId the group ID of this deliberation
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this deliberation.
	 *
	 * @param modifiedDate the modified date of this deliberation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the order of this deliberation.
	 *
	 * @param order the order of this deliberation
	 */
	@Override
	public void setOrder(int order) {
		model.setOrder(order);
	}

	/**
	 * Sets the primary key of this deliberation.
	 *
	 * @param primaryKey the primary key of this deliberation
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quorum of this deliberation.
	 *
	 * @param quorum the quorum of this deliberation
	 */
	@Override
	public void setQuorum(int quorum) {
		model.setQuorum(quorum);
	}

	/**
	 * Sets the stage of this deliberation.
	 *
	 * @param stage the stage of this deliberation
	 */
	@Override
	public void setStage(String stage) {
		model.setStage(stage);
	}

	/**
	 * Sets the status of this deliberation.
	 *
	 * @param status the status of this deliberation
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this deliberation.
	 *
	 * @param statusByUserId the status by user ID of this deliberation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this deliberation.
	 *
	 * @param statusByUserName the status by user name of this deliberation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this deliberation.
	 *
	 * @param statusByUserUuid the status by user uuid of this deliberation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this deliberation.
	 *
	 * @param statusDate the status date of this deliberation
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the title of this deliberation.
	 *
	 * @param title the title of this deliberation
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the user ID of this deliberation.
	 *
	 * @param userId the user ID of this deliberation
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this deliberation.
	 *
	 * @param userName the user name of this deliberation
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this deliberation.
	 *
	 * @param userUuid the user uuid of this deliberation
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this deliberation.
	 *
	 * @param uuid the uuid of this deliberation
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
	protected DeliberationWrapper wrap(Deliberation deliberation) {
		return new DeliberationWrapper(deliberation);
	}

}