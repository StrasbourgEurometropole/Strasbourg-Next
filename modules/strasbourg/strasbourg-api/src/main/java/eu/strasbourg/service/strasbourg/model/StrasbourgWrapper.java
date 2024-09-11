/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Strasbourg}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Strasbourg
 * @generated
 */
public class StrasbourgWrapper
	extends BaseModelWrapper<Strasbourg>
	implements ModelWrapper<Strasbourg>, Strasbourg {

	public StrasbourgWrapper(Strasbourg strasbourg) {
		super(strasbourg);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}
	}

	@Override
	public Strasbourg cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the ID of this strasbourg.
	 *
	 * @return the ID of this strasbourg
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this strasbourg.
	 *
	 * @return the primary key of this strasbourg
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this strasbourg.
	 *
	 * @return the uuid of this strasbourg
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
	 * Sets the ID of this strasbourg.
	 *
	 * @param id the ID of this strasbourg
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this strasbourg.
	 *
	 * @param primaryKey the primary key of this strasbourg
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this strasbourg.
	 *
	 * @param uuid the uuid of this strasbourg
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
	protected StrasbourgWrapper wrap(Strasbourg strasbourg) {
		return new StrasbourgWrapper(strasbourg);
	}

}