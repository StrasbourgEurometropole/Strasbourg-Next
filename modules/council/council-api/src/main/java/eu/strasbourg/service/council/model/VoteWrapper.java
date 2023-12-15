/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Vote}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Vote
 * @generated
 */
public class VoteWrapper
	extends BaseModelWrapper<Vote> implements ModelWrapper<Vote>, Vote {

	public VoteWrapper(Vote vote) {
		super(vote);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
		attributes.put("deliberationId", getDeliberationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("result", getResult());
		attributes.put("officialProcurationId", getOfficialProcurationId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long officialId = (Long)attributes.get("officialId");

		if (officialId != null) {
			setOfficialId(officialId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}

		Long officialProcurationId = (Long)attributes.get(
			"officialProcurationId");

		if (officialProcurationId != null) {
			setOfficialProcurationId(officialProcurationId);
		}
	}

	@Override
	public Vote cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this vote.
	 *
	 * @return the company ID of this vote
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this vote.
	 *
	 * @return the create date of this vote
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the deliberation ID of this vote.
	 *
	 * @return the deliberation ID of this vote
	 */
	@Override
	public long getDeliberationId() {
		return model.getDeliberationId();
	}

	/**
	 * Renvoie le nom complet de l'élu l'élu qui a voté par procuration
	 */
	@Override
	public String getgetOfficialProcurationFullName() {
		return model.getgetOfficialProcurationFullName();
	}

	/**
	 * Returns the group ID of this vote.
	 *
	 * @return the group ID of this vote
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Renvoie l'élu à qui appartient le vote
	 */
	@Override
	public eu.strasbourg.service.council.model.Official getOfficial() {
		return model.getOfficial();
	}

	/**
	 * Renvoie le nom complet de l'élu à qui appartient le vote
	 */
	@Override
	public String getOfficialFullName() {
		return model.getOfficialFullName();
	}

	/**
	 * Returns the official ID of this vote.
	 *
	 * @return the official ID of this vote
	 */
	@Override
	public long getOfficialId() {
		return model.getOfficialId();
	}

	/**
	 * Renvoie l'élu qui a voté par procuration
	 */
	@Override
	public eu.strasbourg.service.council.model.Official
		getOfficialProcuration() {

		return model.getOfficialProcuration();
	}

	/**
	 * Returns the official procuration ID of this vote.
	 *
	 * @return the official procuration ID of this vote
	 */
	@Override
	public long getOfficialProcurationId() {
		return model.getOfficialProcurationId();
	}

	/**
	 * Returns the primary key of this vote.
	 *
	 * @return the primary key of this vote
	 */
	@Override
	public eu.strasbourg.service.council.service.persistence.VotePK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the result of this vote.
	 *
	 * @return the result of this vote
	 */
	@Override
	public String getResult() {
		return model.getResult();
	}

	/**
	 * Returns the uuid of this vote.
	 *
	 * @return the uuid of this vote
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
	 * Sets the company ID of this vote.
	 *
	 * @param companyId the company ID of this vote
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this vote.
	 *
	 * @param createDate the create date of this vote
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the deliberation ID of this vote.
	 *
	 * @param deliberationId the deliberation ID of this vote
	 */
	@Override
	public void setDeliberationId(long deliberationId) {
		model.setDeliberationId(deliberationId);
	}

	/**
	 * Sets the group ID of this vote.
	 *
	 * @param groupId the group ID of this vote
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the official ID of this vote.
	 *
	 * @param officialId the official ID of this vote
	 */
	@Override
	public void setOfficialId(long officialId) {
		model.setOfficialId(officialId);
	}

	/**
	 * Sets the official procuration ID of this vote.
	 *
	 * @param officialProcurationId the official procuration ID of this vote
	 */
	@Override
	public void setOfficialProcurationId(long officialProcurationId) {
		model.setOfficialProcurationId(officialProcurationId);
	}

	/**
	 * Sets the primary key of this vote.
	 *
	 * @param primaryKey the primary key of this vote
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.council.service.persistence.VotePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the result of this vote.
	 *
	 * @param result the result of this vote
	 */
	@Override
	public void setResult(String result) {
		model.setResult(result);
	}

	/**
	 * Sets the uuid of this vote.
	 *
	 * @param uuid the uuid of this vote
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
	protected VoteWrapper wrap(Vote vote) {
		return new VoteWrapper(vote);
	}

}