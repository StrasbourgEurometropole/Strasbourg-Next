/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Agency}.
 * </p>
 *
 * @author Cedric Henry
 * @see Agency
 * @generated
 */
public class AgencyWrapper
	extends BaseModelWrapper<Agency> implements Agency, ModelWrapper<Agency> {

	public AgencyWrapper(Agency agency) {
		super(agency);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("agency_name", getAgency_name());
		attributes.put("agency_url", getAgency_url());
		attributes.put("agency_timezone", getAgency_timezone());
		attributes.put("agency_phone", getAgency_phone());
		attributes.put("agency_fare_url", getAgency_fare_url());
		attributes.put("agency_lang", getAgency_lang());

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

		String agency_name = (String)attributes.get("agency_name");

		if (agency_name != null) {
			setAgency_name(agency_name);
		}

		String agency_url = (String)attributes.get("agency_url");

		if (agency_url != null) {
			setAgency_url(agency_url);
		}

		String agency_timezone = (String)attributes.get("agency_timezone");

		if (agency_timezone != null) {
			setAgency_timezone(agency_timezone);
		}

		String agency_phone = (String)attributes.get("agency_phone");

		if (agency_phone != null) {
			setAgency_phone(agency_phone);
		}

		String agency_fare_url = (String)attributes.get("agency_fare_url");

		if (agency_fare_url != null) {
			setAgency_fare_url(agency_fare_url);
		}

		String agency_lang = (String)attributes.get("agency_lang");

		if (agency_lang != null) {
			setAgency_lang(agency_lang);
		}
	}

	@Override
	public Agency cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the agency_fare_url of this agency.
	 *
	 * @return the agency_fare_url of this agency
	 */
	@Override
	public String getAgency_fare_url() {
		return model.getAgency_fare_url();
	}

	/**
	 * Returns the agency_lang of this agency.
	 *
	 * @return the agency_lang of this agency
	 */
	@Override
	public String getAgency_lang() {
		return model.getAgency_lang();
	}

	/**
	 * Returns the agency_name of this agency.
	 *
	 * @return the agency_name of this agency
	 */
	@Override
	public String getAgency_name() {
		return model.getAgency_name();
	}

	/**
	 * Returns the agency_phone of this agency.
	 *
	 * @return the agency_phone of this agency
	 */
	@Override
	public String getAgency_phone() {
		return model.getAgency_phone();
	}

	/**
	 * Returns the agency_timezone of this agency.
	 *
	 * @return the agency_timezone of this agency
	 */
	@Override
	public String getAgency_timezone() {
		return model.getAgency_timezone();
	}

	/**
	 * Returns the agency_url of this agency.
	 *
	 * @return the agency_url of this agency
	 */
	@Override
	public String getAgency_url() {
		return model.getAgency_url();
	}

	/**
	 * Returns the ID of this agency.
	 *
	 * @return the ID of this agency
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the primary key of this agency.
	 *
	 * @return the primary key of this agency
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the uuid of this agency.
	 *
	 * @return the uuid of this agency
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
	 * Sets the agency_fare_url of this agency.
	 *
	 * @param agency_fare_url the agency_fare_url of this agency
	 */
	@Override
	public void setAgency_fare_url(String agency_fare_url) {
		model.setAgency_fare_url(agency_fare_url);
	}

	/**
	 * Sets the agency_lang of this agency.
	 *
	 * @param agency_lang the agency_lang of this agency
	 */
	@Override
	public void setAgency_lang(String agency_lang) {
		model.setAgency_lang(agency_lang);
	}

	/**
	 * Sets the agency_name of this agency.
	 *
	 * @param agency_name the agency_name of this agency
	 */
	@Override
	public void setAgency_name(String agency_name) {
		model.setAgency_name(agency_name);
	}

	/**
	 * Sets the agency_phone of this agency.
	 *
	 * @param agency_phone the agency_phone of this agency
	 */
	@Override
	public void setAgency_phone(String agency_phone) {
		model.setAgency_phone(agency_phone);
	}

	/**
	 * Sets the agency_timezone of this agency.
	 *
	 * @param agency_timezone the agency_timezone of this agency
	 */
	@Override
	public void setAgency_timezone(String agency_timezone) {
		model.setAgency_timezone(agency_timezone);
	}

	/**
	 * Sets the agency_url of this agency.
	 *
	 * @param agency_url the agency_url of this agency
	 */
	@Override
	public void setAgency_url(String agency_url) {
		model.setAgency_url(agency_url);
	}

	/**
	 * Sets the ID of this agency.
	 *
	 * @param id the ID of this agency
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the primary key of this agency.
	 *
	 * @param primaryKey the primary key of this agency
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the uuid of this agency.
	 *
	 * @param uuid the uuid of this agency
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
	protected AgencyWrapper wrap(Agency agency) {
		return new AgencyWrapper(agency);
	}

}