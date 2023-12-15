/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BaseNonce}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BaseNonce
 * @generated
 */
public class BaseNonceWrapper
	extends BaseModelWrapper<BaseNonce>
	implements BaseNonce, ModelWrapper<BaseNonce> {

	public BaseNonceWrapper(BaseNonce baseNonce) {
		super(baseNonce);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("baseNonceId", getBaseNonceId());
		attributes.put("createDate", getCreateDate());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long baseNonceId = (Long)attributes.get("baseNonceId");

		if (baseNonceId != null) {
			setBaseNonceId(baseNonceId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	@Override
	public BaseNonce cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the base nonce ID of this base nonce.
	 *
	 * @return the base nonce ID of this base nonce
	 */
	@Override
	public long getBaseNonceId() {
		return model.getBaseNonceId();
	}

	/**
	 * Returns the create date of this base nonce.
	 *
	 * @return the create date of this base nonce
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the primary key of this base nonce.
	 *
	 * @return the primary key of this base nonce
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the value of this base nonce.
	 *
	 * @return the value of this base nonce
	 */
	@Override
	public String getValue() {
		return model.getValue();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the base nonce ID of this base nonce.
	 *
	 * @param baseNonceId the base nonce ID of this base nonce
	 */
	@Override
	public void setBaseNonceId(long baseNonceId) {
		model.setBaseNonceId(baseNonceId);
	}

	/**
	 * Sets the create date of this base nonce.
	 *
	 * @param createDate the create date of this base nonce
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the primary key of this base nonce.
	 *
	 * @param primaryKey the primary key of this base nonce
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the value of this base nonce.
	 *
	 * @param value the value of this base nonce
	 */
	@Override
	public void setValue(String value) {
		model.setValue(value);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected BaseNonceWrapper wrap(BaseNonce baseNonce) {
		return new BaseNonceWrapper(baseNonce);
	}

}