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

package eu.strasbourg.service.agenda.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the EventParticipation service. Represents a row in the &quot;agenda_EventParticipation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.agenda.model.impl.EventParticipationImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see EventParticipation
 * @see eu.strasbourg.service.agenda.model.impl.EventParticipationImpl
 * @see eu.strasbourg.service.agenda.model.impl.EventParticipationModelImpl
 * @generated
 */
@ProviderType
public interface EventParticipationModel extends BaseModel<EventParticipation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a event participation model instance should use the {@link EventParticipation} interface instead.
	 */

	/**
	 * Returns the primary key of this event participation.
	 *
	 * @return the primary key of this event participation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this event participation.
	 *
	 * @param primaryKey the primary key of this event participation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the event participation ID of this event participation.
	 *
	 * @return the event participation ID of this event participation
	 */
	public long getEventParticipationId();

	/**
	 * Sets the event participation ID of this event participation.
	 *
	 * @param eventParticipationId the event participation ID of this event participation
	 */
	public void setEventParticipationId(long eventParticipationId);

	/**
	 * Returns the create date of this event participation.
	 *
	 * @return the create date of this event participation
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this event participation.
	 *
	 * @param createDate the create date of this event participation
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the publik user ID of this event participation.
	 *
	 * @return the publik user ID of this event participation
	 */
	@AutoEscape
	public String getPublikUserId();

	/**
	 * Sets the publik user ID of this event participation.
	 *
	 * @param publikUserId the publik user ID of this event participation
	 */
	public void setPublikUserId(String publikUserId);

	/**
	 * Returns the event ID of this event participation.
	 *
	 * @return the event ID of this event participation
	 */
	public long getEventId();

	/**
	 * Sets the event ID of this event participation.
	 *
	 * @param eventId the event ID of this event participation
	 */
	public void setEventId(long eventId);

	/**
	 * Returns the group ID of this event participation.
	 *
	 * @return the group ID of this event participation
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this event participation.
	 *
	 * @param groupId the group ID of this event participation
	 */
	public void setGroupId(long groupId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.agenda.model.EventParticipation eventParticipation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.agenda.model.EventParticipation> toCacheModel();

	@Override
	public eu.strasbourg.service.agenda.model.EventParticipation toEscapedModel();

	@Override
	public eu.strasbourg.service.agenda.model.EventParticipation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}