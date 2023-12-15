/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PlaceCategories}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PlaceCategories
 * @generated
 */
public class PlaceCategoriesWrapper
	extends BaseModelWrapper<PlaceCategories>
	implements ModelWrapper<PlaceCategories>, PlaceCategories {

	public PlaceCategoriesWrapper(PlaceCategories placeCategories) {
		super(placeCategories);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("placeCategoriesId", getPlaceCategoriesId());
		attributes.put("categoriesIds", getCategoriesIds());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long placeCategoriesId = (Long)attributes.get("placeCategoriesId");

		if (placeCategoriesId != null) {
			setPlaceCategoriesId(placeCategoriesId);
		}

		String categoriesIds = (String)attributes.get("categoriesIds");

		if (categoriesIds != null) {
			setCategoriesIds(categoriesIds);
		}
	}

	@Override
	public PlaceCategories cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the categories IDs of this place categories.
	 *
	 * @return the categories IDs of this place categories
	 */
	@Override
	public String getCategoriesIds() {
		return model.getCategoriesIds();
	}

	/**
	 * Returns the place categories ID of this place categories.
	 *
	 * @return the place categories ID of this place categories
	 */
	@Override
	public long getPlaceCategoriesId() {
		return model.getPlaceCategoriesId();
	}

	/**
	 * Returns the primary key of this place categories.
	 *
	 * @return the primary key of this place categories
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this place categories.
	 *
	 * @return the uuid of this place categories
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
	 * Sets the categories IDs of this place categories.
	 *
	 * @param categoriesIds the categories IDs of this place categories
	 */
	@Override
	public void setCategoriesIds(String categoriesIds) {
		model.setCategoriesIds(categoriesIds);
	}

	/**
	 * Sets the place categories ID of this place categories.
	 *
	 * @param placeCategoriesId the place categories ID of this place categories
	 */
	@Override
	public void setPlaceCategoriesId(long placeCategoriesId) {
		model.setPlaceCategoriesId(placeCategoriesId);
	}

	/**
	 * Sets the primary key of this place categories.
	 *
	 * @param primaryKey the primary key of this place categories
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this place categories.
	 *
	 * @param uuid the uuid of this place categories
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
	protected PlaceCategoriesWrapper wrap(PlaceCategories placeCategories) {
		return new PlaceCategoriesWrapper(placeCategories);
	}

}