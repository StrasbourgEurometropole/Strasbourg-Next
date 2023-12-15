/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ObjectCategory}.
 * </p>
 *
 * @author JeremyZwickert
 * @see ObjectCategory
 * @generated
 */
public class ObjectCategoryWrapper
	extends BaseModelWrapper<ObjectCategory>
	implements ModelWrapper<ObjectCategory>, ObjectCategory {

	public ObjectCategoryWrapper(ObjectCategory objectCategory) {
		super(objectCategory);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("code", getCode());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	@Override
	public ObjectCategory cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the code of this object category.
	 *
	 * @return the code of this object category
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the name of this object category.
	 *
	 * @return the name of this object category
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this object category.
	 *
	 * @return the primary key of this object category
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this object category.
	 *
	 * @param code the code of this object category
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the name of this object category.
	 *
	 * @param name the name of this object category
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this object category.
	 *
	 * @param primaryKey the primary key of this object category
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ObjectCategoryWrapper wrap(ObjectCategory objectCategory) {
		return new ObjectCategoryWrapper(objectCategory);
	}

}