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
 * This class is a wrapper for {@link OfficialTypeCouncil}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialTypeCouncil
 * @generated
 */
public class OfficialTypeCouncilWrapper
	extends BaseModelWrapper<OfficialTypeCouncil>
	implements ModelWrapper<OfficialTypeCouncil>, OfficialTypeCouncil {

	public OfficialTypeCouncilWrapper(OfficialTypeCouncil officialTypeCouncil) {
		super(officialTypeCouncil);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
		attributes.put("typeId", getTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("result", getResult());

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

		Long typeId = (Long)attributes.get("typeId");

		if (typeId != null) {
			setTypeId(typeId);
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
	}

	@Override
	public OfficialTypeCouncil cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the company ID of this official type council.
	 *
	 * @return the company ID of this official type council
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this official type council.
	 *
	 * @return the create date of this official type council
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this official type council.
	 *
	 * @return the group ID of this official type council
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the official ID of this official type council.
	 *
	 * @return the official ID of this official type council
	 */
	@Override
	public long getOfficialId() {
		return model.getOfficialId();
	}

	/**
	 * Returns the primary key of this official type council.
	 *
	 * @return the primary key of this official type council
	 */
	@Override
	public
		eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPK
			getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the result of this official type council.
	 *
	 * @return the result of this official type council
	 */
	@Override
	public String getResult() {
		return model.getResult();
	}

	/**
	 * Returns the type ID of this official type council.
	 *
	 * @return the type ID of this official type council
	 */
	@Override
	public long getTypeId() {
		return model.getTypeId();
	}

	/**
	 * Returns the uuid of this official type council.
	 *
	 * @return the uuid of this official type council
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
	 * Sets the company ID of this official type council.
	 *
	 * @param companyId the company ID of this official type council
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this official type council.
	 *
	 * @param createDate the create date of this official type council
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this official type council.
	 *
	 * @param groupId the group ID of this official type council
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the official ID of this official type council.
	 *
	 * @param officialId the official ID of this official type council
	 */
	@Override
	public void setOfficialId(long officialId) {
		model.setOfficialId(officialId);
	}

	/**
	 * Sets the primary key of this official type council.
	 *
	 * @param primaryKey the primary key of this official type council
	 */
	@Override
	public void setPrimaryKey(
		eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the result of this official type council.
	 *
	 * @param result the result of this official type council
	 */
	@Override
	public void setResult(String result) {
		model.setResult(result);
	}

	/**
	 * Sets the type ID of this official type council.
	 *
	 * @param typeId the type ID of this official type council
	 */
	@Override
	public void setTypeId(long typeId) {
		model.setTypeId(typeId);
	}

	/**
	 * Sets the uuid of this official type council.
	 *
	 * @param uuid the uuid of this official type council
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
	protected OfficialTypeCouncilWrapper wrap(
		OfficialTypeCouncil officialTypeCouncil) {

		return new OfficialTypeCouncilWrapper(officialTypeCouncil);
	}

}