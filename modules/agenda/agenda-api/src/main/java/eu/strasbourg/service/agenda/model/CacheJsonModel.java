/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CacheJson service. Represents a row in the &quot;agenda_CacheJson&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>eu.strasbourg.service.agenda.model.impl.CacheJsonModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>eu.strasbourg.service.agenda.model.impl.CacheJsonImpl</code>.
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJson
 * @generated
 */
@ProviderType
public interface CacheJsonModel extends BaseModel<CacheJson> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cache json model instance should use the {@link CacheJson} interface instead.
	 */

	/**
	 * Returns the primary key of this cache json.
	 *
	 * @return the primary key of this cache json
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cache json.
	 *
	 * @param primaryKey the primary key of this cache json
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event ID of this cache json.
	 *
	 * @return the event ID of this cache json
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this cache json.
	 *
	 * @param eventId the event ID of this cache json
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the json event of this cache json.
	 *
	 * @return the json event of this cache json
	 */
	@AutoEscape
	public String getJsonEvent();

	/**
	 * Sets the json event of this cache json.
	 *
	 * @param jsonEvent the json event of this cache json
	 */
	public void setJsonEvent(String jsonEvent);

	/**
	 * Returns the json event legacy of this cache json.
	 *
	 * @return the json event legacy of this cache json
	 */
	@AutoEscape
	public String getJsonEventLegacy();

	/**
	 * Sets the json event legacy of this cache json.
	 *
	 * @param jsonEventLegacy the json event legacy of this cache json
	 */
	public void setJsonEventLegacy(String jsonEventLegacy);

	/**
	 * Returns the create event of this cache json.
	 *
	 * @return the create event of this cache json
	 */
	public Date getCreateEvent();

	/**
	 * Sets the create event of this cache json.
	 *
	 * @param createEvent the create event of this cache json
	 */
	public void setCreateEvent(Date createEvent);

	/**
	 * Returns the modified event of this cache json.
	 *
	 * @return the modified event of this cache json
	 */
	public Date getModifiedEvent();

	/**
	 * Sets the modified event of this cache json.
	 *
	 * @param modifiedEvent the modified event of this cache json
	 */
	public void setModifiedEvent(Date modifiedEvent);

	/**
	 * Returns the is approved of this cache json.
	 *
	 * @return the is approved of this cache json
	 */
	public boolean getIsApproved();

	/**
	 * Returns <code>true</code> if this cache json is is approved.
	 *
	 * @return <code>true</code> if this cache json is is approved; <code>false</code> otherwise
	 */
	public boolean isIsApproved();

	/**
	 * Sets whether this cache json is is approved.
	 *
	 * @param isApproved the is approved of this cache json
	 */
	public void setIsApproved(boolean isApproved);

	@Override
	public CacheJson cloneWithOriginalValues();

	public default String toXmlString() {
		return null;
	}

}