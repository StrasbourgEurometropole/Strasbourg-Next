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
 * This class is a wrapper for {@link Signataire}.
 * </p>
 *
 * @author Cedric Henry
 * @see Signataire
 * @generated
 */
public class SignataireWrapper
	extends BaseModelWrapper<Signataire>
	implements ModelWrapper<Signataire>, Signataire {

	public SignataireWrapper(Signataire signataire) {
		super(signataire);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("signataireId", getSignataireId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("signataireName", getSignataireName());
		attributes.put("signataireFirstname", getSignataireFirstname());
		attributes.put("birthday", getBirthday());
		attributes.put("address", getAddress());
		attributes.put("mail", getMail());
		attributes.put("postalCode", getPostalCode());
		attributes.put("mobilePhone", getMobilePhone());
		attributes.put("phone", getPhone());
		attributes.put("city", getCity());
		attributes.put("signatureDate", getSignatureDate());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("petitionId", getPetitionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long signataireId = (Long)attributes.get("signataireId");

		if (signataireId != null) {
			setSignataireId(signataireId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
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

		String signataireName = (String)attributes.get("signataireName");

		if (signataireName != null) {
			setSignataireName(signataireName);
		}

		String signataireFirstname = (String)attributes.get(
			"signataireFirstname");

		if (signataireFirstname != null) {
			setSignataireFirstname(signataireFirstname);
		}

		Date birthday = (Date)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		Long postalCode = (Long)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String mobilePhone = (String)attributes.get("mobilePhone");

		if (mobilePhone != null) {
			setMobilePhone(mobilePhone);
		}

		String phone = (String)attributes.get("phone");

		if (phone != null) {
			setPhone(phone);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		Date signatureDate = (Date)attributes.get("signatureDate");

		if (signatureDate != null) {
			setSignatureDate(signatureDate);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long petitionId = (Long)attributes.get("petitionId");

		if (petitionId != null) {
			setPetitionId(petitionId);
		}
	}

	@Override
	public Signataire cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the address of this signataire.
	 *
	 * @return the address of this signataire
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the birthday of this signataire.
	 *
	 * @return the birthday of this signataire
	 */
	@Override
	public Date getBirthday() {
		return model.getBirthday();
	}

	/**
	 * Returns the city of this signataire.
	 *
	 * @return the city of this signataire
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the company ID of this signataire.
	 *
	 * @return the company ID of this signataire
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the create date of this signataire.
	 *
	 * @return the create date of this signataire
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Returns the group ID of this signataire.
	 *
	 * @return the group ID of this signataire
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the mail of this signataire.
	 *
	 * @return the mail of this signataire
	 */
	@Override
	public String getMail() {
		return model.getMail();
	}

	/**
	 * Returns the mobile phone of this signataire.
	 *
	 * @return the mobile phone of this signataire
	 */
	@Override
	public String getMobilePhone() {
		return model.getMobilePhone();
	}

	/**
	 * Returns the modified date of this signataire.
	 *
	 * @return the modified date of this signataire
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the petition ID of this signataire.
	 *
	 * @return the petition ID of this signataire
	 */
	@Override
	public long getPetitionId() {
		return model.getPetitionId();
	}

	/**
	 * Returns the phone of this signataire.
	 *
	 * @return the phone of this signataire
	 */
	@Override
	public String getPhone() {
		return model.getPhone();
	}

	/**
	 * Returns the postal code of this signataire.
	 *
	 * @return the postal code of this signataire
	 */
	@Override
	public long getPostalCode() {
		return model.getPostalCode();
	}

	/**
	 * Returns the primary key of this signataire.
	 *
	 * @return the primary key of this signataire
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this signataire.
	 *
	 * @return the publik user ID of this signataire
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Returns the signataire firstname of this signataire.
	 *
	 * @return the signataire firstname of this signataire
	 */
	@Override
	public String getSignataireFirstname() {
		return model.getSignataireFirstname();
	}

	/**
	 * Returns the signataire ID of this signataire.
	 *
	 * @return the signataire ID of this signataire
	 */
	@Override
	public long getSignataireId() {
		return model.getSignataireId();
	}

	/**
	 * Returns the signataire name of this signataire.
	 *
	 * @return the signataire name of this signataire
	 */
	@Override
	public String getSignataireName() {
		return model.getSignataireName();
	}

	/**
	 * Returns the signature date of this signataire.
	 *
	 * @return the signature date of this signataire
	 */
	@Override
	public Date getSignatureDate() {
		return model.getSignatureDate();
	}

	/**
	 * Returns the status of this signataire.
	 *
	 * @return the status of this signataire
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this signataire.
	 *
	 * @return the status by user ID of this signataire
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this signataire.
	 *
	 * @return the status by user name of this signataire
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this signataire.
	 *
	 * @return the status by user uuid of this signataire
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this signataire.
	 *
	 * @return the status date of this signataire
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the user ID of this signataire.
	 *
	 * @return the user ID of this signataire
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this signataire.
	 *
	 * @return the user name of this signataire
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this signataire.
	 *
	 * @return the user uuid of this signataire
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this signataire.
	 *
	 * @return the uuid of this signataire
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this signataire is approved.
	 *
	 * @return <code>true</code> if this signataire is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this signataire is denied.
	 *
	 * @return <code>true</code> if this signataire is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this signataire is a draft.
	 *
	 * @return <code>true</code> if this signataire is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this signataire is expired.
	 *
	 * @return <code>true</code> if this signataire is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this signataire is inactive.
	 *
	 * @return <code>true</code> if this signataire is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this signataire is incomplete.
	 *
	 * @return <code>true</code> if this signataire is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this signataire is pending.
	 *
	 * @return <code>true</code> if this signataire is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this signataire is scheduled.
	 *
	 * @return <code>true</code> if this signataire is scheduled; <code>false</code> otherwise
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
	 * Sets the address of this signataire.
	 *
	 * @param address the address of this signataire
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the birthday of this signataire.
	 *
	 * @param birthday the birthday of this signataire
	 */
	@Override
	public void setBirthday(Date birthday) {
		model.setBirthday(birthday);
	}

	/**
	 * Sets the city of this signataire.
	 *
	 * @param city the city of this signataire
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the company ID of this signataire.
	 *
	 * @param companyId the company ID of this signataire
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this signataire.
	 *
	 * @param createDate the create date of this signataire
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this signataire.
	 *
	 * @param groupId the group ID of this signataire
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the mail of this signataire.
	 *
	 * @param mail the mail of this signataire
	 */
	@Override
	public void setMail(String mail) {
		model.setMail(mail);
	}

	/**
	 * Sets the mobile phone of this signataire.
	 *
	 * @param mobilePhone the mobile phone of this signataire
	 */
	@Override
	public void setMobilePhone(String mobilePhone) {
		model.setMobilePhone(mobilePhone);
	}

	/**
	 * Sets the modified date of this signataire.
	 *
	 * @param modifiedDate the modified date of this signataire
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the petition ID of this signataire.
	 *
	 * @param petitionId the petition ID of this signataire
	 */
	@Override
	public void setPetitionId(long petitionId) {
		model.setPetitionId(petitionId);
	}

	/**
	 * Sets the phone of this signataire.
	 *
	 * @param phone the phone of this signataire
	 */
	@Override
	public void setPhone(String phone) {
		model.setPhone(phone);
	}

	/**
	 * Sets the postal code of this signataire.
	 *
	 * @param postalCode the postal code of this signataire
	 */
	@Override
	public void setPostalCode(long postalCode) {
		model.setPostalCode(postalCode);
	}

	/**
	 * Sets the primary key of this signataire.
	 *
	 * @param primaryKey the primary key of this signataire
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this signataire.
	 *
	 * @param publikUserId the publik user ID of this signataire
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the signataire firstname of this signataire.
	 *
	 * @param signataireFirstname the signataire firstname of this signataire
	 */
	@Override
	public void setSignataireFirstname(String signataireFirstname) {
		model.setSignataireFirstname(signataireFirstname);
	}

	/**
	 * Sets the signataire ID of this signataire.
	 *
	 * @param signataireId the signataire ID of this signataire
	 */
	@Override
	public void setSignataireId(long signataireId) {
		model.setSignataireId(signataireId);
	}

	/**
	 * Sets the signataire name of this signataire.
	 *
	 * @param signataireName the signataire name of this signataire
	 */
	@Override
	public void setSignataireName(String signataireName) {
		model.setSignataireName(signataireName);
	}

	/**
	 * Sets the signature date of this signataire.
	 *
	 * @param signatureDate the signature date of this signataire
	 */
	@Override
	public void setSignatureDate(Date signatureDate) {
		model.setSignatureDate(signatureDate);
	}

	/**
	 * Sets the status of this signataire.
	 *
	 * @param status the status of this signataire
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this signataire.
	 *
	 * @param statusByUserId the status by user ID of this signataire
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this signataire.
	 *
	 * @param statusByUserName the status by user name of this signataire
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this signataire.
	 *
	 * @param statusByUserUuid the status by user uuid of this signataire
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this signataire.
	 *
	 * @param statusDate the status date of this signataire
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the user ID of this signataire.
	 *
	 * @param userId the user ID of this signataire
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this signataire.
	 *
	 * @param userName the user name of this signataire
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this signataire.
	 *
	 * @param userUuid the user uuid of this signataire
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this signataire.
	 *
	 * @param uuid the uuid of this signataire
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
	protected SignataireWrapper wrap(Signataire signataire) {
		return new SignataireWrapper(signataire);
	}

}