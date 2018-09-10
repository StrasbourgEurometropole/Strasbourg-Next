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

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.GroupedModel;
import com.liferay.portal.kernel.model.ShardedModel;
import com.liferay.portal.kernel.model.StagedAuditedModel;
import com.liferay.portal.kernel.model.WorkflowedModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Participation service. Represents a row in the &quot;project_Participation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.project.model.impl.ParticipationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.project.model.impl.ParticipationImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see Participation
 * @see eu.strasbourg.service.project.model.impl.ParticipationImpl
 * @see eu.strasbourg.service.project.model.impl.ParticipationModelImpl
 * @generated
 */
@ProviderType
public interface ParticipationModel extends BaseModel<Participation>,
	GroupedModel, ShardedModel, StagedAuditedModel, WorkflowedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a participation model instance should use the {@link Participation} interface instead.
	 */

	/**
	 * Returns the primary key of this participation.
	 *
	 * @return the primary key of this participation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this participation.
	 *
	 * @param primaryKey the primary key of this participation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this participation.
	 *
	 * @return the uuid of this participation
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this participation.
	 *
	 * @param uuid the uuid of this participation
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the participation ID of this participation.
	 *
	 * @return the participation ID of this participation
	 */
	public long getParticipationId();

	/**
	 * Sets the participation ID of this participation.
	 *
	 * @param participationId the participation ID of this participation
	 */
	public void setParticipationId(long participationId);

	/**
	 * Returns the group ID of this participation.
	 *
	 * @return the group ID of this participation
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this participation.
	 *
	 * @param groupId the group ID of this participation
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this participation.
	 *
	 * @return the company ID of this participation
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this participation.
	 *
	 * @param companyId the company ID of this participation
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this participation.
	 *
	 * @return the user ID of this participation
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this participation.
	 *
	 * @param userId the user ID of this participation
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this participation.
	 *
	 * @return the user uuid of this participation
	 */
	@Override
	public String getUserUuid();

	/**
	 * Sets the user uuid of this participation.
	 *
	 * @param userUuid the user uuid of this participation
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this participation.
	 *
	 * @return the user name of this participation
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this participation.
	 *
	 * @param userName the user name of this participation
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this participation.
	 *
	 * @return the create date of this participation
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this participation.
	 *
	 * @param createDate the create date of this participation
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this participation.
	 *
	 * @return the modified date of this participation
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this participation.
	 *
	 * @param modifiedDate the modified date of this participation
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the status of this participation.
	 *
	 * @return the status of this participation
	 */
	@Override
	public int getStatus();

	/**
	 * Sets the status of this participation.
	 *
	 * @param status the status of this participation
	 */
	@Override
	public void setStatus(int status);

	/**
	 * Returns the status by user ID of this participation.
	 *
	 * @return the status by user ID of this participation
	 */
	@Override
	public long getStatusByUserId();

	/**
	 * Sets the status by user ID of this participation.
	 *
	 * @param statusByUserId the status by user ID of this participation
	 */
	@Override
	public void setStatusByUserId(long statusByUserId);

	/**
	 * Returns the status by user uuid of this participation.
	 *
	 * @return the status by user uuid of this participation
	 */
	@Override
	public String getStatusByUserUuid();

	/**
	 * Sets the status by user uuid of this participation.
	 *
	 * @param statusByUserUuid the status by user uuid of this participation
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid);

	/**
	 * Returns the status by user name of this participation.
	 *
	 * @return the status by user name of this participation
	 */
	@AutoEscape
	@Override
	public String getStatusByUserName();

	/**
	 * Sets the status by user name of this participation.
	 *
	 * @param statusByUserName the status by user name of this participation
	 */
	@Override
	public void setStatusByUserName(String statusByUserName);

	/**
	 * Returns the status date of this participation.
	 *
	 * @return the status date of this participation
	 */
	@Override
	public Date getStatusDate();

	/**
	 * Sets the status date of this participation.
	 *
	 * @param statusDate the status date of this participation
	 */
	@Override
	public void setStatusDate(Date statusDate);

	/**
	 * Returns the title of this participation.
	 *
	 * @return the title of this participation
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this participation.
	 *
	 * @param title the title of this participation
	 */
	public void setTitle(String title);

	/**
	 * Returns the author of this participation.
	 *
	 * @return the author of this participation
	 */
	@AutoEscape
	public String getAuthor();

	/**
	 * Sets the author of this participation.
	 *
	 * @param author the author of this participation
	 */
	public void setAuthor(String author);

	/**
	 * Returns the contact name of this participation.
	 *
	 * @return the contact name of this participation
	 */
	@AutoEscape
	public String getContactName();

	/**
	 * Sets the contact name of this participation.
	 *
	 * @param contactName the contact name of this participation
	 */
	public void setContactName(String contactName);

	/**
	 * Returns the contact line1 of this participation.
	 *
	 * @return the contact line1 of this participation
	 */
	@AutoEscape
	public String getContactLine1();

	/**
	 * Sets the contact line1 of this participation.
	 *
	 * @param contactLine1 the contact line1 of this participation
	 */
	public void setContactLine1(String contactLine1);

	/**
	 * Returns the contact line2 of this participation.
	 *
	 * @return the contact line2 of this participation
	 */
	@AutoEscape
	public String getContactLine2();

	/**
	 * Sets the contact line2 of this participation.
	 *
	 * @param contactLine2 the contact line2 of this participation
	 */
	public void setContactLine2(String contactLine2);

	/**
	 * Returns the contact phone number of this participation.
	 *
	 * @return the contact phone number of this participation
	 */
	@AutoEscape
	public String getContactPhoneNumber();

	/**
	 * Sets the contact phone number of this participation.
	 *
	 * @param contactPhoneNumber the contact phone number of this participation
	 */
	public void setContactPhoneNumber(String contactPhoneNumber);

	/**
	 * Returns the video url of this participation.
	 *
	 * @return the video url of this participation
	 */
	@AutoEscape
	public String getVideoUrl();

	/**
	 * Sets the video url of this participation.
	 *
	 * @param videoUrl the video url of this participation
	 */
	public void setVideoUrl(String videoUrl);

	/**
	 * Returns the external image url of this participation.
	 *
	 * @return the external image url of this participation
	 */
	@AutoEscape
	public String getExternalImageURL();

	/**
	 * Sets the external image url of this participation.
	 *
	 * @param externalImageURL the external image url of this participation
	 */
	public void setExternalImageURL(String externalImageURL);

	/**
	 * Returns the external image copyright of this participation.
	 *
	 * @return the external image copyright of this participation
	 */
	@AutoEscape
	public String getExternalImageCopyright();

	/**
	 * Sets the external image copyright of this participation.
	 *
	 * @param externalImageCopyright the external image copyright of this participation
	 */
	public void setExternalImageCopyright(String externalImageCopyright);

	/**
	 * Returns the media choice of this participation.
	 *
	 * @return the media choice of this participation
	 */
	public boolean getMediaChoice();

	/**
	 * Returns <code>true</code> if this participation is media choice.
	 *
	 * @return <code>true</code> if this participation is media choice; <code>false</code> otherwise
	 */
	public boolean isMediaChoice();

	/**
	 * Sets whether this participation is media choice.
	 *
	 * @param mediaChoice the media choice of this participation
	 */
	public void setMediaChoice(boolean mediaChoice);

	/**
	 * Returns the description chapeau of this participation.
	 *
	 * @return the description chapeau of this participation
	 */
	@AutoEscape
	public String getDescriptionChapeau();

	/**
	 * Sets the description chapeau of this participation.
	 *
	 * @param descriptionChapeau the description chapeau of this participation
	 */
	public void setDescriptionChapeau(String descriptionChapeau);

	/**
	 * Returns the description body of this participation.
	 *
	 * @return the description body of this participation
	 */
	@AutoEscape
	public String getDescriptionBody();

	/**
	 * Sets the description body of this participation.
	 *
	 * @param descriptionBody the description body of this participation
	 */
	public void setDescriptionBody(String descriptionBody);

	/**
	 * Returns the consultation places body of this participation.
	 *
	 * @return the consultation places body of this participation
	 */
	@AutoEscape
	public String getConsultationPlacesBody();

	/**
	 * Sets the consultation places body of this participation.
	 *
	 * @param consultationPlacesBody the consultation places body of this participation
	 */
	public void setConsultationPlacesBody(String consultationPlacesBody);

	/**
	 * Returns the image ID of this participation.
	 *
	 * @return the image ID of this participation
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this participation.
	 *
	 * @param imageId the image ID of this participation
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the files IDs of this participation.
	 *
	 * @return the files IDs of this participation
	 */
	@AutoEscape
	public String getFilesIds();

	/**
	 * Sets the files IDs of this participation.
	 *
	 * @param filesIds the files IDs of this participation
	 */
	public void setFilesIds(String filesIds);

	/**
	 * Returns the events IDs of this participation.
	 *
	 * @return the events IDs of this participation
	 */
	@AutoEscape
	public String getEventsIds();

	/**
	 * Sets the events IDs of this participation.
	 *
	 * @param eventsIds the events IDs of this participation
	 */
	public void setEventsIds(String eventsIds);

	/**
	 * Returns the publication date of this participation.
	 *
	 * @return the publication date of this participation
	 */
	public Date getPublicationDate();

	/**
	 * Sets the publication date of this participation.
	 *
	 * @param publicationDate the publication date of this participation
	 */
	public void setPublicationDate(Date publicationDate);

	/**
	 * Returns the expiration date of this participation.
	 *
	 * @return the expiration date of this participation
	 */
	public Date getExpirationDate();

	/**
	 * Sets the expiration date of this participation.
	 *
	 * @param expirationDate the expiration date of this participation
	 */
	public void setExpirationDate(Date expirationDate);

	/**
	 * Returns <code>true</code> if this participation is approved.
	 *
	 * @return <code>true</code> if this participation is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved();

	/**
	 * Returns <code>true</code> if this participation is denied.
	 *
	 * @return <code>true</code> if this participation is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied();

	/**
	 * Returns <code>true</code> if this participation is a draft.
	 *
	 * @return <code>true</code> if this participation is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft();

	/**
	 * Returns <code>true</code> if this participation is expired.
	 *
	 * @return <code>true</code> if this participation is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired();

	/**
	 * Returns <code>true</code> if this participation is inactive.
	 *
	 * @return <code>true</code> if this participation is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive();

	/**
	 * Returns <code>true</code> if this participation is incomplete.
	 *
	 * @return <code>true</code> if this participation is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete();

	/**
	 * Returns <code>true</code> if this participation is pending.
	 *
	 * @return <code>true</code> if this participation is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending();

	/**
	 * Returns <code>true</code> if this participation is scheduled.
	 *
	 * @return <code>true</code> if this participation is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled();

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
		eu.strasbourg.service.project.model.Participation participation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.project.model.Participation> toCacheModel();

	@Override
	public eu.strasbourg.service.project.model.Participation toEscapedModel();

	@Override
	public eu.strasbourg.service.project.model.Participation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}