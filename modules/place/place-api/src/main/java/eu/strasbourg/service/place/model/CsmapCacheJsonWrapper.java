/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CsmapCacheJson}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see CsmapCacheJson
 * @generated
 */
public class CsmapCacheJsonWrapper
	extends BaseModelWrapper<CsmapCacheJson>
	implements CsmapCacheJson, ModelWrapper<CsmapCacheJson> {

	public CsmapCacheJsonWrapper(CsmapCacheJson csmapCacheJson) {
		super(csmapCacheJson);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("sigId", getSigId());
		attributes.put("jsonLieu", getJsonLieu());
		attributes.put("jsonHoraire", getJsonHoraire());
		attributes.put("createPlace", getCreatePlace());
		attributes.put("modifiedPlace", getModifiedPlace());
		attributes.put("isActive", isIsActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		String sigId = (String)attributes.get("sigId");

		if (sigId != null) {
			setSigId(sigId);
		}

		String jsonLieu = (String)attributes.get("jsonLieu");

		if (jsonLieu != null) {
			setJsonLieu(jsonLieu);
		}

		String jsonHoraire = (String)attributes.get("jsonHoraire");

		if (jsonHoraire != null) {
			setJsonHoraire(jsonHoraire);
		}

		Date createPlace = (Date)attributes.get("createPlace");

		if (createPlace != null) {
			setCreatePlace(createPlace);
		}

		Date modifiedPlace = (Date)attributes.get("modifiedPlace");

		if (modifiedPlace != null) {
			setModifiedPlace(modifiedPlace);
		}

		Boolean isActive = (Boolean)attributes.get("isActive");

		if (isActive != null) {
			setIsActive(isActive);
		}
	}

	@Override
	public CsmapCacheJson cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the create place of this csmap cache json.
	 *
	 * @return the create place of this csmap cache json
	 */
	@Override
	public Date getCreatePlace() {
		return model.getCreatePlace();
	}

	/**
	 * Returns the is active of this csmap cache json.
	 *
	 * @return the is active of this csmap cache json
	 */
	@Override
	public boolean getIsActive() {
		return model.getIsActive();
	}

	/**
	 * Returns the json horaire of this csmap cache json.
	 *
	 * @return the json horaire of this csmap cache json
	 */
	@Override
	public String getJsonHoraire() {
		return model.getJsonHoraire();
	}

	/**
	 * Returns the json lieu of this csmap cache json.
	 *
	 * @return the json lieu of this csmap cache json
	 */
	@Override
	public String getJsonLieu() {
		return model.getJsonLieu();
	}

	/**
	 * Returns the modified place of this csmap cache json.
	 *
	 * @return the modified place of this csmap cache json
	 */
	@Override
	public Date getModifiedPlace() {
		return model.getModifiedPlace();
	}

	/**
	 * Returns the primary key of this csmap cache json.
	 *
	 * @return the primary key of this csmap cache json
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sig ID of this csmap cache json.
	 *
	 * @return the sig ID of this csmap cache json
	 */
	@Override
	public String getSigId() {
		return model.getSigId();
	}

	/**
	 * Returns the uuid of this csmap cache json.
	 *
	 * @return the uuid of this csmap cache json
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this csmap cache json is is active.
	 *
	 * @return <code>true</code> if this csmap cache json is is active; <code>false</code> otherwise
	 */
	@Override
	public boolean isIsActive() {
		return model.isIsActive();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create place of this csmap cache json.
	 *
	 * @param createPlace the create place of this csmap cache json
	 */
	@Override
	public void setCreatePlace(Date createPlace) {
		model.setCreatePlace(createPlace);
	}

	/**
	 * Sets whether this csmap cache json is is active.
	 *
	 * @param isActive the is active of this csmap cache json
	 */
	@Override
	public void setIsActive(boolean isActive) {
		model.setIsActive(isActive);
	}

	/**
	 * Sets the json horaire of this csmap cache json.
	 *
	 * @param jsonHoraire the json horaire of this csmap cache json
	 */
	@Override
	public void setJsonHoraire(String jsonHoraire) {
		model.setJsonHoraire(jsonHoraire);
	}

	/**
	 * Sets the json lieu of this csmap cache json.
	 *
	 * @param jsonLieu the json lieu of this csmap cache json
	 */
	@Override
	public void setJsonLieu(String jsonLieu) {
		model.setJsonLieu(jsonLieu);
	}

	/**
	 * Sets the modified place of this csmap cache json.
	 *
	 * @param modifiedPlace the modified place of this csmap cache json
	 */
	@Override
	public void setModifiedPlace(Date modifiedPlace) {
		model.setModifiedPlace(modifiedPlace);
	}

	/**
	 * Sets the primary key of this csmap cache json.
	 *
	 * @param primaryKey the primary key of this csmap cache json
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sig ID of this csmap cache json.
	 *
	 * @param sigId the sig ID of this csmap cache json
	 */
	@Override
	public void setSigId(String sigId) {
		model.setSigId(sigId);
	}

	/**
	 * Sets the uuid of this csmap cache json.
	 *
	 * @param uuid the uuid of this csmap cache json
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
	protected CsmapCacheJsonWrapper wrap(CsmapCacheJson csmapCacheJson) {
		return new CsmapCacheJsonWrapper(csmapCacheJson);
	}

}