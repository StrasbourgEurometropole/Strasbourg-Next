/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceNotif}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceNotif
 * @generated
 */
public class ServiceNotifWrapper
	extends BaseModelWrapper<ServiceNotif>
	implements ModelWrapper<ServiceNotif>, ServiceNotif {

	public ServiceNotifWrapper(ServiceNotif serviceNotif) {
		super(serviceNotif);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("serviceId", getServiceId());
		attributes.put("organisationId", getOrganisationId());
		attributes.put("name", getName());
		attributes.put("pictoId", getPictoId());
		attributes.put("csmapSubscriptionLabel", getCsmapSubscriptionLabel());
		attributes.put(
			"csmapSubscriptionMandatory", isCsmapSubscriptionMandatory());
		attributes.put("csmapTopic", getCsmapTopic());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		Long organisationId = (Long)attributes.get("organisationId");

		if (organisationId != null) {
			setOrganisationId(organisationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long pictoId = (Long)attributes.get("pictoId");

		if (pictoId != null) {
			setPictoId(pictoId);
		}

		String csmapSubscriptionLabel = (String)attributes.get(
			"csmapSubscriptionLabel");

		if (csmapSubscriptionLabel != null) {
			setCsmapSubscriptionLabel(csmapSubscriptionLabel);
		}

		Boolean csmapSubscriptionMandatory = (Boolean)attributes.get(
			"csmapSubscriptionMandatory");

		if (csmapSubscriptionMandatory != null) {
			setCsmapSubscriptionMandatory(csmapSubscriptionMandatory);
		}

		String csmapTopic = (String)attributes.get("csmapTopic");

		if (csmapTopic != null) {
			setCsmapTopic(csmapTopic);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public ServiceNotif cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create date of this service notif.
	 *
	 * @return the create date of this service notif
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the csmap subscription label of this service notif.
	 *
	 * @return the csmap subscription label of this service notif
	 */
	@Override
	public String getCsmapSubscriptionLabel() {
		return model.getCsmapSubscriptionLabel();
	}

	/**
	 * Returns the csmap subscription mandatory of this service notif.
	 *
	 * @return the csmap subscription mandatory of this service notif
	 */
	@Override
	public boolean getCsmapSubscriptionMandatory() {
		return model.getCsmapSubscriptionMandatory();
	}

	/**
	 * Returns the csmap topic of this service notif.
	 *
	 * @return the csmap topic of this service notif
	 */
	@Override
	public String getCsmapTopic() {
		return model.getCsmapTopic();
	}

	/**
	 * Retourne les Messages du service
	 */
	@Override
	public java.util.List<Message> getMessages() {
		return model.getMessages();
	}

	/**
	 * Returns the modified date of this service notif.
	 *
	 * @return the modified date of this service notif
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the name of this service notif.
	 *
	 * @return the name of this service notif
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Retourne les Natures du service
	 */
	@Override
	public java.util.List<NatureNotif> getNatures() {
		return model.getNatures();
	}

	/**
	 * Returns the organisation ID of this service notif.
	 *
	 * @return the organisation ID of this service notif
	 */
	@Override
	public long getOrganisationId() {
		return model.getOrganisationId();
	}

	/**
	 * Returns the picto ID of this service notif.
	 *
	 * @return the picto ID of this service notif
	 */
	@Override
	public long getPictoId() {
		return model.getPictoId();
	}

	/**
	 * Returns the primary key of this service notif.
	 *
	 * @return the primary key of this service notif
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service ID of this service notif.
	 *
	 * @return the service ID of this service notif
	 */
	@Override
	public long getServiceId() {
		return model.getServiceId();
	}

	/**
	 * Returns <code>true</code> if this service notif is csmap subscription mandatory.
	 *
	 * @return <code>true</code> if this service notif is csmap subscription mandatory; <code>false</code> otherwise
	 */
	@Override
	public boolean isCsmapSubscriptionMandatory() {
		return model.isCsmapSubscriptionMandatory();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this service notif.
	 *
	 * @param createDate the create date of this service notif
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the csmap subscription label of this service notif.
	 *
	 * @param csmapSubscriptionLabel the csmap subscription label of this service notif
	 */
	@Override
	public void setCsmapSubscriptionLabel(String csmapSubscriptionLabel) {
		model.setCsmapSubscriptionLabel(csmapSubscriptionLabel);
	}

	/**
	 * Sets whether this service notif is csmap subscription mandatory.
	 *
	 * @param csmapSubscriptionMandatory the csmap subscription mandatory of this service notif
	 */
	@Override
	public void setCsmapSubscriptionMandatory(
		boolean csmapSubscriptionMandatory) {

		model.setCsmapSubscriptionMandatory(csmapSubscriptionMandatory);
	}

	/**
	 * Sets the csmap topic of this service notif.
	 *
	 * @param csmapTopic the csmap topic of this service notif
	 */
	@Override
	public void setCsmapTopic(String csmapTopic) {
		model.setCsmapTopic(csmapTopic);
	}

	/**
	 * Sets the modified date of this service notif.
	 *
	 * @param modifiedDate the modified date of this service notif
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the name of this service notif.
	 *
	 * @param name the name of this service notif
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the organisation ID of this service notif.
	 *
	 * @param organisationId the organisation ID of this service notif
	 */
	@Override
	public void setOrganisationId(long organisationId) {
		model.setOrganisationId(organisationId);
	}

	/**
	 * Sets the picto ID of this service notif.
	 *
	 * @param pictoId the picto ID of this service notif
	 */
	@Override
	public void setPictoId(long pictoId) {
		model.setPictoId(pictoId);
	}

	/**
	 * Sets the primary key of this service notif.
	 *
	 * @param primaryKey the primary key of this service notif
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service ID of this service notif.
	 *
	 * @param serviceId the service ID of this service notif
	 */
	@Override
	public void setServiceId(long serviceId) {
		model.setServiceId(serviceId);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected ServiceNotifWrapper wrap(ServiceNotif serviceNotif) {
		return new ServiceNotifWrapper(serviceNotif);
	}

}