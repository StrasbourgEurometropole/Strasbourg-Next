/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the InitiativeHelp service. Represents a row in the &quot;project_InitiativeHelp&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.project.model.impl.InitiativeHelpImpl</code>.
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeHelp
 * @generated
 */
@ProviderType
public interface InitiativeHelpModel extends BaseModel<InitiativeHelp> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a initiative help model instance should use the {@link InitiativeHelp} interface instead.
	 */

	/**
	 * Returns the primary key of this initiative help.
	 *
	 * @return the primary key of this initiative help
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this initiative help.
	 *
	 * @param primaryKey the primary key of this initiative help
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this initiative help.
	 *
	 * @return the uuid of this initiative help
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this initiative help.
	 *
	 * @param uuid the uuid of this initiative help
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the initiative help ID of this initiative help.
	 *
	 * @return the initiative help ID of this initiative help
	 */
	public long getInitiativeHelpId();

	/**
	 * Sets the initiative help ID of this initiative help.
	 *
	 * @param initiativeHelpId the initiative help ID of this initiative help
	 */
	public void setInitiativeHelpId(long initiativeHelpId);

	/**
	 * Returns the create date of this initiative help.
	 *
	 * @return the create date of this initiative help
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this initiative help.
	 *
	 * @param createDate the create date of this initiative help
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the publik user ID of this initiative help.
	 *
	 * @return the publik user ID of this initiative help
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this initiative help.
	 *
	 * @param publikUserId the publik user ID of this initiative help
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the initiative ID of this initiative help.
	 *
	 * @return the initiative ID of this initiative help
	 */
	public long getInitiativeId();

	/**
	 * Sets the initiative ID of this initiative help.
	 *
	 * @param initiativeId the initiative ID of this initiative help
	 */
	public void setInitiativeId(long initiativeId);

	/**
	 * Returns the help types of this initiative help.
	 *
	 * @return the help types of this initiative help
	 */
	@AutoEscape
	public String getHelpTypes();

	/**
	 * Sets the help types of this initiative help.
	 *
	 * @param helpTypes the help types of this initiative help
	 */
	public void setHelpTypes(String helpTypes);

	/**
	 * Returns the group ID of this initiative help.
	 *
	 * @return the group ID of this initiative help
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this initiative help.
	 *
	 * @param groupId the group ID of this initiative help
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the message of this initiative help.
	 *
	 * @return the message of this initiative help
	 */
	@AutoEscape
	public String getMessage();

	/**
	 * Sets the message of this initiative help.
	 *
	 * @param message the message of this initiative help
	 */
	public void setMessage(String message);

	/**
	 * Returns the help display of this initiative help.
	 *
	 * @return the help display of this initiative help
	 */
	public boolean getHelpDisplay();

	/**
	 * Returns <code>true</code> if this initiative help is help display.
	 *
	 * @return <code>true</code> if this initiative help is help display; <code>false</code> otherwise
	 */
	public boolean isHelpDisplay();

	/**
	 * Sets whether this initiative help is help display.
	 *
	 * @param helpDisplay the help display of this initiative help
	 */
	public void setHelpDisplay(boolean helpDisplay);

	@Override
	public InitiativeHelp cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}