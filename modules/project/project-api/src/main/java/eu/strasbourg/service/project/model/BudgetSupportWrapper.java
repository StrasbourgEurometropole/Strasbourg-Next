/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BudgetSupport}.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetSupport
 * @generated
 */
public class BudgetSupportWrapper
	extends BaseModelWrapper<BudgetSupport>
	implements BudgetSupport, ModelWrapper<BudgetSupport> {

	public BudgetSupportWrapper(BudgetSupport budgetSupport) {
		super(budgetSupport);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("budgetSupportId", getBudgetSupportId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("citoyenLastName", getCitoyenLastName());
		attributes.put("citoyenFirstname", getCitoyenFirstname());
		attributes.put("citoyenBirthday", getCitoyenBirthday());
		attributes.put("citoyenAddress", getCitoyenAddress());
		attributes.put("citoyenMail", getCitoyenMail());
		attributes.put("citoyenPostalCode", getCitoyenPostalCode());
		attributes.put("citoyenMobilePhone", getCitoyenMobilePhone());
		attributes.put("citoyenPhone", getCitoyenPhone());
		attributes.put("citoyenCity", getCitoyenCity());
		attributes.put("isNegatif", getIsNegatif());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("budgetParticipatifId", getBudgetParticipatifId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long budgetSupportId = (Long)attributes.get("budgetSupportId");

		if (budgetSupportId != null) {
			setBudgetSupportId(budgetSupportId);
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

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String citoyenLastName = (String)attributes.get("citoyenLastName");

		if (citoyenLastName != null) {
			setCitoyenLastName(citoyenLastName);
		}

		String citoyenFirstname = (String)attributes.get("citoyenFirstname");

		if (citoyenFirstname != null) {
			setCitoyenFirstname(citoyenFirstname);
		}

		Date citoyenBirthday = (Date)attributes.get("citoyenBirthday");

		if (citoyenBirthday != null) {
			setCitoyenBirthday(citoyenBirthday);
		}

		String citoyenAddress = (String)attributes.get("citoyenAddress");

		if (citoyenAddress != null) {
			setCitoyenAddress(citoyenAddress);
		}

		String citoyenMail = (String)attributes.get("citoyenMail");

		if (citoyenMail != null) {
			setCitoyenMail(citoyenMail);
		}

		Long citoyenPostalCode = (Long)attributes.get("citoyenPostalCode");

		if (citoyenPostalCode != null) {
			setCitoyenPostalCode(citoyenPostalCode);
		}

		String citoyenMobilePhone = (String)attributes.get(
			"citoyenMobilePhone");

		if (citoyenMobilePhone != null) {
			setCitoyenMobilePhone(citoyenMobilePhone);
		}

		String citoyenPhone = (String)attributes.get("citoyenPhone");

		if (citoyenPhone != null) {
			setCitoyenPhone(citoyenPhone);
		}

		String citoyenCity = (String)attributes.get("citoyenCity");

		if (citoyenCity != null) {
			setCitoyenCity(citoyenCity);
		}

		Boolean isNegatif = (Boolean)attributes.get("isNegatif");

		if (isNegatif != null) {
			setIsNegatif(isNegatif);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long budgetParticipatifId = (Long)attributes.get(
			"budgetParticipatifId");

		if (budgetParticipatifId != null) {
			setBudgetParticipatifId(budgetParticipatifId);
		}
	}

	@Override
	public BudgetSupport cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the budget participatif ID of this budget support.
	 *
	 * @return the budget participatif ID of this budget support
	 */
	@Override
	public long getBudgetParticipatifId() {
		return model.getBudgetParticipatifId();
	}

	/**
	 * Returns the budget support ID of this budget support.
	 *
	 * @return the budget support ID of this budget support
	 */
	@Override
	public long getBudgetSupportId() {
		return model.getBudgetSupportId();
	}

	/**
	 * Returns the citoyen address of this budget support.
	 *
	 * @return the citoyen address of this budget support
	 */
	@Override
	public String getCitoyenAddress() {
		return model.getCitoyenAddress();
	}

	/**
	 * Returns the citoyen birthday of this budget support.
	 *
	 * @return the citoyen birthday of this budget support
	 */
	@Override
	public Date getCitoyenBirthday() {
		return model.getCitoyenBirthday();
	}

	/**
	 * Returns the citoyen city of this budget support.
	 *
	 * @return the citoyen city of this budget support
	 */
	@Override
	public String getCitoyenCity() {
		return model.getCitoyenCity();
	}

	/**
	 * Returns the citoyen firstname of this budget support.
	 *
	 * @return the citoyen firstname of this budget support
	 */
	@Override
	public String getCitoyenFirstname() {
		return model.getCitoyenFirstname();
	}

	/**
	 * Returns the citoyen last name of this budget support.
	 *
	 * @return the citoyen last name of this budget support
	 */
	@Override
	public String getCitoyenLastName() {
		return model.getCitoyenLastName();
	}

	/**
	 * Returns the citoyen mail of this budget support.
	 *
	 * @return the citoyen mail of this budget support
	 */
	@Override
	public String getCitoyenMail() {
		return model.getCitoyenMail();
	}

	/**
	 * Returns the citoyen mobile phone of this budget support.
	 *
	 * @return the citoyen mobile phone of this budget support
	 */
	@Override
	public String getCitoyenMobilePhone() {
		return model.getCitoyenMobilePhone();
	}

	/**
	 * Returns the citoyen phone of this budget support.
	 *
	 * @return the citoyen phone of this budget support
	 */
	@Override
	public String getCitoyenPhone() {
		return model.getCitoyenPhone();
	}

	/**
	 * Returns the citoyen postal code of this budget support.
	 *
	 * @return the citoyen postal code of this budget support
	 */
	@Override
	public long getCitoyenPostalCode() {
		return model.getCitoyenPostalCode();
	}

	/**
	 * Returns the company ID of this budget support.
	 *
	 * @return the company ID of this budget support
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this budget support.
	 *
	 * @return the create date of this budget support
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this budget support.
	 *
	 * @return the group ID of this budget support
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is negatif of this budget support.
	 *
	 * @return the is negatif of this budget support
	 */
	@Override
	public Boolean getIsNegatif() {
		return model.getIsNegatif();
	}

	/**
	 * Returns the modified date of this budget support.
	 *
	 * @return the modified date of this budget support
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the primary key of this budget support.
	 *
	 * @return the primary key of this budget support
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this budget support.
	 *
	 * @return the publik user ID of this budget support
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the status of this budget support.
	 *
	 * @return the status of this budget support
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this budget support.
	 *
	 * @return the status by user ID of this budget support
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this budget support.
	 *
	 * @return the status by user name of this budget support
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this budget support.
	 *
	 * @return the status by user uuid of this budget support
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this budget support.
	 *
	 * @return the status date of this budget support
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the uuid of this budget support.
	 *
	 * @return the uuid of this budget support
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this budget support is approved.
	 *
	 * @return <code>true</code> if this budget support is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this budget support is denied.
	 *
	 * @return <code>true</code> if this budget support is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this budget support is a draft.
	 *
	 * @return <code>true</code> if this budget support is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this budget support is expired.
	 *
	 * @return <code>true</code> if this budget support is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this budget support is inactive.
	 *
	 * @return <code>true</code> if this budget support is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this budget support is incomplete.
	 *
	 * @return <code>true</code> if this budget support is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this budget support is pending.
	 *
	 * @return <code>true</code> if this budget support is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this budget support is scheduled.
	 *
	 * @return <code>true</code> if this budget support is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the budget participatif ID of this budget support.
	 *
	 * @param budgetParticipatifId the budget participatif ID of this budget support
	 */
	@Override
	public void setBudgetParticipatifId(long budgetParticipatifId) {
		model.setBudgetParticipatifId(budgetParticipatifId);
	}

	/**
	 * Sets the budget support ID of this budget support.
	 *
	 * @param budgetSupportId the budget support ID of this budget support
	 */
	@Override
	public void setBudgetSupportId(long budgetSupportId) {
		model.setBudgetSupportId(budgetSupportId);
	}

	/**
	 * Sets the citoyen address of this budget support.
	 *
	 * @param citoyenAddress the citoyen address of this budget support
	 */
	@Override
	public void setCitoyenAddress(String citoyenAddress) {
		model.setCitoyenAddress(citoyenAddress);
	}

	/**
	 * Sets the citoyen birthday of this budget support.
	 *
	 * @param citoyenBirthday the citoyen birthday of this budget support
	 */
	@Override
	public void setCitoyenBirthday(Date citoyenBirthday) {
		model.setCitoyenBirthday(citoyenBirthday);
	}

	/**
	 * Sets the citoyen city of this budget support.
	 *
	 * @param citoyenCity the citoyen city of this budget support
	 */
	@Override
	public void setCitoyenCity(String citoyenCity) {
		model.setCitoyenCity(citoyenCity);
	}

	/**
	 * Sets the citoyen firstname of this budget support.
	 *
	 * @param citoyenFirstname the citoyen firstname of this budget support
	 */
	@Override
	public void setCitoyenFirstname(String citoyenFirstname) {
		model.setCitoyenFirstname(citoyenFirstname);
	}

	/**
	 * Sets the citoyen last name of this budget support.
	 *
	 * @param citoyenLastName the citoyen last name of this budget support
	 */
	@Override
	public void setCitoyenLastName(String citoyenLastName) {
		model.setCitoyenLastName(citoyenLastName);
	}

	/**
	 * Sets the citoyen mail of this budget support.
	 *
	 * @param citoyenMail the citoyen mail of this budget support
	 */
	@Override
	public void setCitoyenMail(String citoyenMail) {
		model.setCitoyenMail(citoyenMail);
	}

	/**
	 * Sets the citoyen mobile phone of this budget support.
	 *
	 * @param citoyenMobilePhone the citoyen mobile phone of this budget support
	 */
	@Override
	public void setCitoyenMobilePhone(String citoyenMobilePhone) {
		model.setCitoyenMobilePhone(citoyenMobilePhone);
	}

	/**
	 * Sets the citoyen phone of this budget support.
	 *
	 * @param citoyenPhone the citoyen phone of this budget support
	 */
	@Override
	public void setCitoyenPhone(String citoyenPhone) {
		model.setCitoyenPhone(citoyenPhone);
	}

	/**
	 * Sets the citoyen postal code of this budget support.
	 *
	 * @param citoyenPostalCode the citoyen postal code of this budget support
	 */
	@Override
	public void setCitoyenPostalCode(long citoyenPostalCode) {
		model.setCitoyenPostalCode(citoyenPostalCode);
	}

	/**
	 * Sets the company ID of this budget support.
	 *
	 * @param companyId the company ID of this budget support
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this budget support.
	 *
	 * @param createDate the create date of this budget support
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this budget support.
	 *
	 * @param groupId the group ID of this budget support
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is negatif of this budget support.
	 *
	 * @param isNegatif the is negatif of this budget support
	 */
	@Override
	public void setIsNegatif(Boolean isNegatif) {
		model.setIsNegatif(isNegatif);
	}

	/**
	 * Sets the modified date of this budget support.
	 *
	 * @param modifiedDate the modified date of this budget support
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the primary key of this budget support.
	 *
	 * @param primaryKey the primary key of this budget support
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this budget support.
	 *
	 * @param publikUserId the publik user ID of this budget support
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the status of this budget support.
	 *
	 * @param status the status of this budget support
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this budget support.
	 *
	 * @param statusByUserId the status by user ID of this budget support
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this budget support.
	 *
	 * @param statusByUserName the status by user name of this budget support
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this budget support.
	 *
	 * @param statusByUserUuid the status by user uuid of this budget support
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this budget support.
	 *
	 * @param statusDate the status date of this budget support
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the uuid of this budget support.
	 *
	 * @param uuid the uuid of this budget support
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
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected BudgetSupportWrapper wrap(BudgetSupport budgetSupport) {
		return new BudgetSupportWrapper(budgetSupport);
	}

}