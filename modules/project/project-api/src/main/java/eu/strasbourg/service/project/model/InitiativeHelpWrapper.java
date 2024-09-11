/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link InitiativeHelp}.
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeHelp
 * @generated
 */
public class InitiativeHelpWrapper
	extends BaseModelWrapper<InitiativeHelp>
	implements InitiativeHelp, ModelWrapper<InitiativeHelp> {

	public InitiativeHelpWrapper(InitiativeHelp initiativeHelp) {
		super(initiativeHelp);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("initiativeHelpId", getInitiativeHelpId());
		attributes.put("createDate", getCreateDate());
		attributes.put("publikUserId", getPublikUserId());
		attributes.put("initiativeId", getInitiativeId());
		attributes.put("helpTypes", getHelpTypes());
		attributes.put("groupId", getGroupId());
		attributes.put("message", getMessage());
		attributes.put("helpDisplay", isHelpDisplay());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long initiativeHelpId = (Long)attributes.get("initiativeHelpId");

		if (initiativeHelpId != null) {
			setInitiativeHelpId(initiativeHelpId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String publikUserId = (String)attributes.get("publikUserId");

		if (publikUserId != null) {
			setPublikUserId(publikUserId);
		}

		Long initiativeId = (Long)attributes.get("initiativeId");

		if (initiativeId != null) {
			setInitiativeId(initiativeId);
		}

		String helpTypes = (String)attributes.get("helpTypes");

		if (helpTypes != null) {
			setHelpTypes(helpTypes);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String message = (String)attributes.get("message");

		if (message != null) {
			setMessage(message);
		}

		Boolean helpDisplay = (Boolean)attributes.get("helpDisplay");

		if (helpDisplay != null) {
			setHelpDisplay(helpDisplay);
		}
	}

	@Override
	public InitiativeHelp cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Retourne l'utilisateur Publik depositaire
	 *
	 * @return
	 */
	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getAuthor() {
		return model.getAuthor();
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		return model.getAuthorImageURL();
	}

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		return model.getAuthorLabel();
	}

	/**
	 * Returns the create date of this initiative help.
	 *
	 * @return the create date of this initiative help
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	/**
	 * Retourne le message d'accompagnement sans les balises et autres fioritures
	 *
	 * @return
	 */
	@Override
	public String getFormatedMessage() {
		return model.getFormatedMessage();
	}

	/**
	 * Returns the group ID of this initiative help.
	 *
	 * @return the group ID of this initiative help
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the help display of this initiative help.
	 *
	 * @return the help display of this initiative help
	 */
	@Override
	public boolean getHelpDisplay() {
		return model.getHelpDisplay();
	}

	/**
	 * Returns the help types of this initiative help.
	 *
	 * @return the help types of this initiative help
	 */
	@Override
	public String getHelpTypes() {
		return model.getHelpTypes();
	}

	/**
	 * Retourne l'initiative de l'aide
	 *
	 * @return
	 * @throws PortalException
	 */
	@Override
	public eu.strasbourg.service.project.model.Initiative getInitiative() {
		return model.getInitiative();
	}

	/**
	 * Returns the initiative help ID of this initiative help.
	 *
	 * @return the initiative help ID of this initiative help
	 */
	@Override
	public long getInitiativeHelpId() {
		return model.getInitiativeHelpId();
	}

	/**
	 * Returns the initiative ID of this initiative help.
	 *
	 * @return the initiative ID of this initiative help
	 */
	@Override
	public long getInitiativeId() {
		return model.getInitiativeId();
	}

	/**
	 * Returns the message of this initiative help.
	 *
	 * @return the message of this initiative help
	 */
	@Override
	public String getMessage() {
		return model.getMessage();
	}

	/**
	 * Returns the primary key of this initiative help.
	 *
	 * @return the primary key of this initiative help
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik user ID of this initiative help.
	 *
	 * @return the publik user ID of this initiative help
	 */
	@Override
	public String getPublikUserId() {
		return model.getPublikUserId();
	}

	/**
	 * Retourne le label des types d'aide
	 */
	@Override
	public String getTypesLabel() {
		return model.getTypesLabel();
	}

	/**
	 * Returns the uuid of this initiative help.
	 *
	 * @return the uuid of this initiative help
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this initiative help is help display.
	 *
	 * @return <code>true</code> if this initiative help is help display; <code>false</code> otherwise
	 */
	@Override
	public boolean isHelpDisplay() {
		return model.isHelpDisplay();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the create date of this initiative help.
	 *
	 * @param createDate the create date of this initiative help
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this initiative help.
	 *
	 * @param groupId the group ID of this initiative help
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets whether this initiative help is help display.
	 *
	 * @param helpDisplay the help display of this initiative help
	 */
	@Override
	public void setHelpDisplay(boolean helpDisplay) {
		model.setHelpDisplay(helpDisplay);
	}

	/**
	 * Sets the help types of this initiative help.
	 *
	 * @param helpTypes the help types of this initiative help
	 */
	@Override
	public void setHelpTypes(String helpTypes) {
		model.setHelpTypes(helpTypes);
	}

	/**
	 * Sets the initiative help ID of this initiative help.
	 *
	 * @param initiativeHelpId the initiative help ID of this initiative help
	 */
	@Override
	public void setInitiativeHelpId(long initiativeHelpId) {
		model.setInitiativeHelpId(initiativeHelpId);
	}

	/**
	 * Sets the initiative ID of this initiative help.
	 *
	 * @param initiativeId the initiative ID of this initiative help
	 */
	@Override
	public void setInitiativeId(long initiativeId) {
		model.setInitiativeId(initiativeId);
	}

	/**
	 * Sets the message of this initiative help.
	 *
	 * @param message the message of this initiative help
	 */
	@Override
	public void setMessage(String message) {
		model.setMessage(message);
	}

	/**
	 * Sets the primary key of this initiative help.
	 *
	 * @param primaryKey the primary key of this initiative help
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik user ID of this initiative help.
	 *
	 * @param publikUserId the publik user ID of this initiative help
	 */
	@Override
	public void setPublikUserId(String publikUserId) {
		model.setPublikUserId(publikUserId);
	}

	/**
	 * Sets the uuid of this initiative help.
	 *
	 * @param uuid the uuid of this initiative help
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
	protected InitiativeHelpWrapper wrap(InitiativeHelp initiativeHelp) {
		return new InitiativeHelpWrapper(initiativeHelp);
	}

}