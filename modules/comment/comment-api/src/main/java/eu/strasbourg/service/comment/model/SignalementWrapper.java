/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Signalement}.
 * </p>
 *
 * @author Romain Vergnais
 * @see Signalement
 * @generated
 */
public class SignalementWrapper
	extends BaseModelWrapper<Signalement>
	implements ModelWrapper<Signalement>, Signalement {

	public SignalementWrapper(Signalement signalement) {
		super(signalement);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("signalementId", getSignalementId());
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
		attributes.put("commentId", getCommentId());
		attributes.put("publikId", getPublikId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long signalementId = (Long)attributes.get("signalementId");

		if (signalementId != null) {
			setSignalementId(signalementId);
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

		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}
	}

	@Override
	public Signalement cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	@Override
	public String getCategorieName() {
		return model.getCategorieName();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategoriesByAssetEntry() {

		return model.getCategoriesByAssetEntry();
	}

	/**
	 * méthode qui permet de récupérer le commmentaire lié au signalement.
	 *
	 * @return le commentaire.
	 */
	@Override
	public eu.strasbourg.service.comment.model.Comment getComment() {
		return model.getComment();
	}

	/**
	 * Retourne l'utilisateur auteur du commentaire
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getCommentAuthor() {
		return model.getCommentAuthor();
	}

	/**
	 * Retourne le nom de l'auteur du commentaire
	 */
	@Override
	public String getCommentAuthorLabel() {
		return model.getCommentAuthorLabel();
	}

	/**
	 * Recuperer le commmentaire lie au signalement.
	 *
	 * @return le commentaire.
	 */
	@Override
	public String getCommentContent() {
		return model.getCommentContent();
	}

	/**
	 * Returns the comment ID of this signalement.
	 *
	 * @return the comment ID of this signalement
	 */
	@Override
	public long getCommentId() {
		return model.getCommentId();
	}

	/**
	 * Returns the company ID of this signalement.
	 *
	 * @return the company ID of this signalement
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this signalement.
	 *
	 * @return the create date of this signalement
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this signalement.
	 *
	 * @return the group ID of this signalement
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the modified date of this signalement.
	 *
	 * @return the modified date of this signalement
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this signalement.
	 *
	 * @return the primary key of this signalement
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik ID of this signalement.
	 *
	 * @return the publik ID of this signalement
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	/**
	 * Retourne l'utilisateur auteur du signalement
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getSignalementAuthor() {
		return model.getSignalementAuthor();
	}

	/**
	 * Retourne le nom de l'auteur du signalement
	 */
	@Override
	public String getSignalementAuthorLabel() {
		return model.getSignalementAuthorLabel();
	}

	/**
	 * Returns the signalement ID of this signalement.
	 *
	 * @return the signalement ID of this signalement
	 */
	@Override
	public long getSignalementId() {
		return model.getSignalementId();
	}

	/**
	 * Returns the status of this signalement.
	 *
	 * @return the status of this signalement
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this signalement.
	 *
	 * @return the status by user ID of this signalement
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this signalement.
	 *
	 * @return the status by user name of this signalement
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this signalement.
	 *
	 * @return the status by user uuid of this signalement
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this signalement.
	 *
	 * @return the status date of this signalement
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this signalement.
	 *
	 * @return the user ID of this signalement
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this signalement.
	 *
	 * @return the user name of this signalement
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this signalement.
	 *
	 * @return the user uuid of this signalement
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this signalement.
	 *
	 * @return the uuid of this signalement
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this signalement is approved.
	 *
	 * @return <code>true</code> if this signalement is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this signalement is denied.
	 *
	 * @return <code>true</code> if this signalement is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this signalement is a draft.
	 *
	 * @return <code>true</code> if this signalement is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this signalement is expired.
	 *
	 * @return <code>true</code> if this signalement is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this signalement is inactive.
	 *
	 * @return <code>true</code> if this signalement is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this signalement is incomplete.
	 *
	 * @return <code>true</code> if this signalement is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this signalement is pending.
	 *
	 * @return <code>true</code> if this signalement is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this signalement is scheduled.
	 *
	 * @return <code>true</code> if this signalement is scheduled; <code>false</code> otherwise
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
	 * Sets the comment ID of this signalement.
	 *
	 * @param commentId the comment ID of this signalement
	 */
	@Override
	public void setCommentId(long commentId) {
		model.setCommentId(commentId);
	}

	/**
	 * Sets the company ID of this signalement.
	 *
	 * @param companyId the company ID of this signalement
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this signalement.
	 *
	 * @param createDate the create date of this signalement
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this signalement.
	 *
	 * @param groupId the group ID of this signalement
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the modified date of this signalement.
	 *
	 * @param modifiedDate the modified date of this signalement
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this signalement.
	 *
	 * @param primaryKey the primary key of this signalement
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik ID of this signalement.
	 *
	 * @param publikId the publik ID of this signalement
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the signalement ID of this signalement.
	 *
	 * @param signalementId the signalement ID of this signalement
	 */
	@Override
	public void setSignalementId(long signalementId) {
		model.setSignalementId(signalementId);
	}

	/**
	 * Sets the status of this signalement.
	 *
	 * @param status the status of this signalement
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this signalement.
	 *
	 * @param statusByUserId the status by user ID of this signalement
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this signalement.
	 *
	 * @param statusByUserName the status by user name of this signalement
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this signalement.
	 *
	 * @param statusByUserUuid the status by user uuid of this signalement
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this signalement.
	 *
	 * @param statusDate the status date of this signalement
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this signalement.
	 *
	 * @param userId the user ID of this signalement
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this signalement.
	 *
	 * @param userName the user name of this signalement
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this signalement.
	 *
	 * @param userUuid the user uuid of this signalement
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this signalement.
	 *
	 * @param uuid the uuid of this signalement
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
	protected SignalementWrapper wrap(Signalement signalement) {
		return new SignalementWrapper(signalement);
	}

}