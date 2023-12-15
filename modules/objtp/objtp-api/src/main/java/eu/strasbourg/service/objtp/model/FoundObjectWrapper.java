/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.objtp.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link FoundObject}.
 * </p>
 *
 * @author JeremyZwickert
 * @see FoundObject
 * @generated
 */
public class FoundObjectWrapper
	extends BaseModelWrapper<FoundObject>
	implements FoundObject, ModelWrapper<FoundObject> {

	public FoundObjectWrapper(FoundObject foundObject) {
		super(foundObject);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("number", getNumber());
		attributes.put("date", getDate());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("categoryCode", getCategoryCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String number = (String)attributes.get("number");

		if (number != null) {
			setNumber(number);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String categoryCode = (String)attributes.get("categoryCode");

		if (categoryCode != null) {
			setCategoryCode(categoryCode);
		}
	}

	@Override
	public FoundObject cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the category code of this found object.
	 *
	 * @return the category code of this found object
	 */
	@Override
	public String getCategoryCode() {
		return model.getCategoryCode();
	}

	/**
	 * Returns the date of this found object.
	 *
	 * @return the date of this found object
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the image url of this found object.
	 *
	 * @return the image url of this found object
	 */
	@Override
	public String getImageUrl() {
		return model.getImageUrl();
	}

	/**
	 * Returns the number of this found object.
	 *
	 * @return the number of this found object
	 */
	@Override
	public String getNumber() {
		return model.getNumber();
	}

	/**
	 * Returns the primary key of this found object.
	 *
	 * @return the primary key of this found object
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
	 * Sets the category code of this found object.
	 *
	 * @param categoryCode the category code of this found object
	 */
	@Override
	public void setCategoryCode(String categoryCode) {
		model.setCategoryCode(categoryCode);
	}

	/**
	 * Sets the date of this found object.
	 *
	 * @param date the date of this found object
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the image url of this found object.
	 *
	 * @param imageUrl the image url of this found object
	 */
	@Override
	public void setImageUrl(String imageUrl) {
		model.setImageUrl(imageUrl);
	}

	/**
	 * Sets the number of this found object.
	 *
	 * @param number the number of this found object
	 */
	@Override
	public void setNumber(String number) {
		model.setNumber(number);
	}

	/**
	 * Sets the primary key of this found object.
	 *
	 * @param primaryKey the primary key of this found object
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
	protected FoundObjectWrapper wrap(FoundObject foundObject) {
		return new FoundObjectWrapper(foundObject);
	}

}