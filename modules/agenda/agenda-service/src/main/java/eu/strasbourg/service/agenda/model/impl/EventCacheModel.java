/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.agenda.model.Event;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Event in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class EventCacheModel implements CacheModel<Event>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EventCacheModel)) {
			return false;
		}

		EventCacheModel eventCacheModel = (EventCacheModel)object;

		if (eventId == eventCacheModel.eventId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, eventId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(127);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", lastPublishDate=");
		sb.append(lastPublishDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", title=");
		sb.append(title);
		sb.append(", subtitle=");
		sb.append(subtitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", externalImageURL=");
		sb.append(externalImageURL);
		sb.append(", externalImageThumbnailURL=");
		sb.append(externalImageThumbnailURL);
		sb.append(", externalImageCopyright=");
		sb.append(externalImageCopyright);
		sb.append(", imageWidth=");
		sb.append(imageWidth);
		sb.append(", imageHeight=");
		sb.append(imageHeight);
		sb.append(", placeSIGId=");
		sb.append(placeSIGId);
		sb.append(", placeName=");
		sb.append(placeName);
		sb.append(", placeStreetNumber=");
		sb.append(placeStreetNumber);
		sb.append(", placeStreetName=");
		sb.append(placeStreetName);
		sb.append(", placeZipCode=");
		sb.append(placeZipCode);
		sb.append(", placeCity=");
		sb.append(placeCity);
		sb.append(", placeCountry=");
		sb.append(placeCountry);
		sb.append(", mercatorX=");
		sb.append(mercatorX);
		sb.append(", mercatorY=");
		sb.append(mercatorY);
		sb.append(", access=");
		sb.append(access);
		sb.append(", accessForDisabled=");
		sb.append(accessForDisabled);
		sb.append(", accessForBlind=");
		sb.append(accessForBlind);
		sb.append(", accessForDeaf=");
		sb.append(accessForDeaf);
		sb.append(", accessForWheelchair=");
		sb.append(accessForWheelchair);
		sb.append(", accessForElder=");
		sb.append(accessForElder);
		sb.append(", accessForDeficient=");
		sb.append(accessForDeficient);
		sb.append(", promoter=");
		sb.append(promoter);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", email=");
		sb.append(email);
		sb.append(", websiteURL=");
		sb.append(websiteURL);
		sb.append(", websiteName=");
		sb.append(websiteName);
		sb.append(", free=");
		sb.append(free);
		sb.append(", price=");
		sb.append(price);
		sb.append(", bookingDescription=");
		sb.append(bookingDescription);
		sb.append(", bookingURL=");
		sb.append(bookingURL);
		sb.append(", subscriptionURL=");
		sb.append(subscriptionURL);
		sb.append(", source=");
		sb.append(source);
		sb.append(", idSource=");
		sb.append(idSource);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", distribution=");
		sb.append(distribution);
		sb.append(", composer=");
		sb.append(composer);
		sb.append(", concertId=");
		sb.append(concertId);
		sb.append(", program=");
		sb.append(program);
		sb.append(", firstStartDate=");
		sb.append(firstStartDate);
		sb.append(", lastEndDate=");
		sb.append(lastEndDate);
		sb.append(", createDateSource=");
		sb.append(createDateSource);
		sb.append(", modifiedDateSource=");
		sb.append(modifiedDateSource);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", registration=");
		sb.append(registration);
		sb.append(", registrationStartDate=");
		sb.append(registrationStartDate);
		sb.append(", registrationEndDate=");
		sb.append(registrationEndDate);
		sb.append(", maxGauge=");
		sb.append(maxGauge);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Event toEntityModel() {
		EventImpl eventImpl = new EventImpl();

		if (uuid == null) {
			eventImpl.setUuid("");
		}
		else {
			eventImpl.setUuid(uuid);
		}

		eventImpl.setEventId(eventId);
		eventImpl.setGroupId(groupId);
		eventImpl.setCompanyId(companyId);
		eventImpl.setUserId(userId);

		if (userName == null) {
			eventImpl.setUserName("");
		}
		else {
			eventImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			eventImpl.setCreateDate(null);
		}
		else {
			eventImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			eventImpl.setModifiedDate(null);
		}
		else {
			eventImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			eventImpl.setLastPublishDate(null);
		}
		else {
			eventImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		eventImpl.setStatus(status);
		eventImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			eventImpl.setStatusByUserName("");
		}
		else {
			eventImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			eventImpl.setStatusDate(null);
		}
		else {
			eventImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			eventImpl.setTitle("");
		}
		else {
			eventImpl.setTitle(title);
		}

		if (subtitle == null) {
			eventImpl.setSubtitle("");
		}
		else {
			eventImpl.setSubtitle(subtitle);
		}

		if (description == null) {
			eventImpl.setDescription("");
		}
		else {
			eventImpl.setDescription(description);
		}

		if (externalImageURL == null) {
			eventImpl.setExternalImageURL("");
		}
		else {
			eventImpl.setExternalImageURL(externalImageURL);
		}

		if (externalImageThumbnailURL == null) {
			eventImpl.setExternalImageThumbnailURL("");
		}
		else {
			eventImpl.setExternalImageThumbnailURL(externalImageThumbnailURL);
		}

		if (externalImageCopyright == null) {
			eventImpl.setExternalImageCopyright("");
		}
		else {
			eventImpl.setExternalImageCopyright(externalImageCopyright);
		}

		eventImpl.setImageWidth(imageWidth);
		eventImpl.setImageHeight(imageHeight);

		if (placeSIGId == null) {
			eventImpl.setPlaceSIGId("");
		}
		else {
			eventImpl.setPlaceSIGId(placeSIGId);
		}

		if (placeName == null) {
			eventImpl.setPlaceName("");
		}
		else {
			eventImpl.setPlaceName(placeName);
		}

		if (placeStreetNumber == null) {
			eventImpl.setPlaceStreetNumber("");
		}
		else {
			eventImpl.setPlaceStreetNumber(placeStreetNumber);
		}

		if (placeStreetName == null) {
			eventImpl.setPlaceStreetName("");
		}
		else {
			eventImpl.setPlaceStreetName(placeStreetName);
		}

		if (placeZipCode == null) {
			eventImpl.setPlaceZipCode("");
		}
		else {
			eventImpl.setPlaceZipCode(placeZipCode);
		}

		if (placeCity == null) {
			eventImpl.setPlaceCity("");
		}
		else {
			eventImpl.setPlaceCity(placeCity);
		}

		if (placeCountry == null) {
			eventImpl.setPlaceCountry("");
		}
		else {
			eventImpl.setPlaceCountry(placeCountry);
		}

		if (mercatorX == null) {
			eventImpl.setMercatorX("");
		}
		else {
			eventImpl.setMercatorX(mercatorX);
		}

		if (mercatorY == null) {
			eventImpl.setMercatorY("");
		}
		else {
			eventImpl.setMercatorY(mercatorY);
		}

		if (access == null) {
			eventImpl.setAccess("");
		}
		else {
			eventImpl.setAccess(access);
		}

		if (accessForDisabled == null) {
			eventImpl.setAccessForDisabled("");
		}
		else {
			eventImpl.setAccessForDisabled(accessForDisabled);
		}

		eventImpl.setAccessForBlind(accessForBlind);
		eventImpl.setAccessForDeaf(accessForDeaf);
		eventImpl.setAccessForWheelchair(accessForWheelchair);
		eventImpl.setAccessForElder(accessForElder);
		eventImpl.setAccessForDeficient(accessForDeficient);

		if (promoter == null) {
			eventImpl.setPromoter("");
		}
		else {
			eventImpl.setPromoter(promoter);
		}

		if (phone == null) {
			eventImpl.setPhone("");
		}
		else {
			eventImpl.setPhone(phone);
		}

		if (email == null) {
			eventImpl.setEmail("");
		}
		else {
			eventImpl.setEmail(email);
		}

		if (websiteURL == null) {
			eventImpl.setWebsiteURL("");
		}
		else {
			eventImpl.setWebsiteURL(websiteURL);
		}

		if (websiteName == null) {
			eventImpl.setWebsiteName("");
		}
		else {
			eventImpl.setWebsiteName(websiteName);
		}

		eventImpl.setFree(free);

		if (price == null) {
			eventImpl.setPrice("");
		}
		else {
			eventImpl.setPrice(price);
		}

		if (bookingDescription == null) {
			eventImpl.setBookingDescription("");
		}
		else {
			eventImpl.setBookingDescription(bookingDescription);
		}

		if (bookingURL == null) {
			eventImpl.setBookingURL("");
		}
		else {
			eventImpl.setBookingURL(bookingURL);
		}

		if (subscriptionURL == null) {
			eventImpl.setSubscriptionURL("");
		}
		else {
			eventImpl.setSubscriptionURL(subscriptionURL);
		}

		if (source == null) {
			eventImpl.setSource("");
		}
		else {
			eventImpl.setSource(source);
		}

		if (idSource == null) {
			eventImpl.setIdSource("");
		}
		else {
			eventImpl.setIdSource(idSource);
		}

		if (publicationDate == Long.MIN_VALUE) {
			eventImpl.setPublicationDate(null);
		}
		else {
			eventImpl.setPublicationDate(new Date(publicationDate));
		}

		if (distribution == null) {
			eventImpl.setDistribution("");
		}
		else {
			eventImpl.setDistribution(distribution);
		}

		if (composer == null) {
			eventImpl.setComposer("");
		}
		else {
			eventImpl.setComposer(composer);
		}

		if (concertId == null) {
			eventImpl.setConcertId("");
		}
		else {
			eventImpl.setConcertId(concertId);
		}

		if (program == null) {
			eventImpl.setProgram("");
		}
		else {
			eventImpl.setProgram(program);
		}

		if (firstStartDate == Long.MIN_VALUE) {
			eventImpl.setFirstStartDate(null);
		}
		else {
			eventImpl.setFirstStartDate(new Date(firstStartDate));
		}

		if (lastEndDate == Long.MIN_VALUE) {
			eventImpl.setLastEndDate(null);
		}
		else {
			eventImpl.setLastEndDate(new Date(lastEndDate));
		}

		if (createDateSource == Long.MIN_VALUE) {
			eventImpl.setCreateDateSource(null);
		}
		else {
			eventImpl.setCreateDateSource(new Date(createDateSource));
		}

		if (modifiedDateSource == Long.MIN_VALUE) {
			eventImpl.setModifiedDateSource(null);
		}
		else {
			eventImpl.setModifiedDateSource(new Date(modifiedDateSource));
		}

		eventImpl.setImageId(imageId);
		eventImpl.setRegistration(registration);

		if (registrationStartDate == Long.MIN_VALUE) {
			eventImpl.setRegistrationStartDate(null);
		}
		else {
			eventImpl.setRegistrationStartDate(new Date(registrationStartDate));
		}

		if (registrationEndDate == Long.MIN_VALUE) {
			eventImpl.setRegistrationEndDate(null);
		}
		else {
			eventImpl.setRegistrationEndDate(new Date(registrationEndDate));
		}

		eventImpl.setMaxGauge(maxGauge);

		eventImpl.resetOriginalValues();

		return eventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		eventId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		lastPublishDate = objectInput.readLong();

		status = objectInput.readInt();

		statusByUserId = objectInput.readLong();
		statusByUserName = objectInput.readUTF();
		statusDate = objectInput.readLong();
		title = objectInput.readUTF();
		subtitle = objectInput.readUTF();
		description = (String)objectInput.readObject();
		externalImageURL = objectInput.readUTF();
		externalImageThumbnailURL = objectInput.readUTF();
		externalImageCopyright = objectInput.readUTF();

		imageWidth = objectInput.readInt();

		imageHeight = objectInput.readInt();
		placeSIGId = objectInput.readUTF();
		placeName = objectInput.readUTF();
		placeStreetNumber = objectInput.readUTF();
		placeStreetName = objectInput.readUTF();
		placeZipCode = objectInput.readUTF();
		placeCity = objectInput.readUTF();
		placeCountry = objectInput.readUTF();
		mercatorX = objectInput.readUTF();
		mercatorY = objectInput.readUTF();
		access = (String)objectInput.readObject();
		accessForDisabled = (String)objectInput.readObject();

		accessForBlind = objectInput.readBoolean();

		accessForDeaf = objectInput.readBoolean();

		accessForWheelchair = objectInput.readBoolean();

		accessForElder = objectInput.readBoolean();

		accessForDeficient = objectInput.readBoolean();
		promoter = objectInput.readUTF();
		phone = objectInput.readUTF();
		email = objectInput.readUTF();
		websiteURL = objectInput.readUTF();
		websiteName = objectInput.readUTF();

		free = objectInput.readInt();
		price = (String)objectInput.readObject();
		bookingDescription = (String)objectInput.readObject();
		bookingURL = objectInput.readUTF();
		subscriptionURL = objectInput.readUTF();
		source = objectInput.readUTF();
		idSource = objectInput.readUTF();
		publicationDate = objectInput.readLong();
		distribution = objectInput.readUTF();
		composer = objectInput.readUTF();
		concertId = objectInput.readUTF();
		program = (String)objectInput.readObject();
		firstStartDate = objectInput.readLong();
		lastEndDate = objectInput.readLong();
		createDateSource = objectInput.readLong();
		modifiedDateSource = objectInput.readLong();

		imageId = objectInput.readLong();

		registration = objectInput.readBoolean();
		registrationStartDate = objectInput.readLong();
		registrationEndDate = objectInput.readLong();

		maxGauge = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(eventId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(lastPublishDate);

		objectOutput.writeInt(status);

		objectOutput.writeLong(statusByUserId);

		if (statusByUserName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (subtitle == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subtitle);
		}

		if (description == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(description);
		}

		if (externalImageURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageURL);
		}

		if (externalImageThumbnailURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageThumbnailURL);
		}

		if (externalImageCopyright == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(externalImageCopyright);
		}

		objectOutput.writeInt(imageWidth);

		objectOutput.writeInt(imageHeight);

		if (placeSIGId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeSIGId);
		}

		if (placeName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeName);
		}

		if (placeStreetNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeStreetNumber);
		}

		if (placeStreetName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeStreetName);
		}

		if (placeZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeZipCode);
		}

		if (placeCity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeCity);
		}

		if (placeCountry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(placeCountry);
		}

		if (mercatorX == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mercatorX);
		}

		if (mercatorY == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mercatorY);
		}

		if (access == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(access);
		}

		if (accessForDisabled == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(accessForDisabled);
		}

		objectOutput.writeBoolean(accessForBlind);

		objectOutput.writeBoolean(accessForDeaf);

		objectOutput.writeBoolean(accessForWheelchair);

		objectOutput.writeBoolean(accessForElder);

		objectOutput.writeBoolean(accessForDeficient);

		if (promoter == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(promoter);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (email == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(email);
		}

		if (websiteURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(websiteURL);
		}

		if (websiteName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(websiteName);
		}

		objectOutput.writeInt(free);

		if (price == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(price);
		}

		if (bookingDescription == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(bookingDescription);
		}

		if (bookingURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookingURL);
		}

		if (subscriptionURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(subscriptionURL);
		}

		if (source == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(source);
		}

		if (idSource == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idSource);
		}

		objectOutput.writeLong(publicationDate);

		if (distribution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(distribution);
		}

		if (composer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(composer);
		}

		if (concertId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(concertId);
		}

		if (program == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(program);
		}

		objectOutput.writeLong(firstStartDate);
		objectOutput.writeLong(lastEndDate);
		objectOutput.writeLong(createDateSource);
		objectOutput.writeLong(modifiedDateSource);

		objectOutput.writeLong(imageId);

		objectOutput.writeBoolean(registration);
		objectOutput.writeLong(registrationStartDate);
		objectOutput.writeLong(registrationEndDate);

		objectOutput.writeLong(maxGauge);
	}

	public String uuid;
	public long eventId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long lastPublishDate;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public String title;
	public String subtitle;
	public String description;
	public String externalImageURL;
	public String externalImageThumbnailURL;
	public String externalImageCopyright;
	public int imageWidth;
	public int imageHeight;
	public String placeSIGId;
	public String placeName;
	public String placeStreetNumber;
	public String placeStreetName;
	public String placeZipCode;
	public String placeCity;
	public String placeCountry;
	public String mercatorX;
	public String mercatorY;
	public String access;
	public String accessForDisabled;
	public boolean accessForBlind;
	public boolean accessForDeaf;
	public boolean accessForWheelchair;
	public boolean accessForElder;
	public boolean accessForDeficient;
	public String promoter;
	public String phone;
	public String email;
	public String websiteURL;
	public String websiteName;
	public int free;
	public String price;
	public String bookingDescription;
	public String bookingURL;
	public String subscriptionURL;
	public String source;
	public String idSource;
	public long publicationDate;
	public String distribution;
	public String composer;
	public String concertId;
	public String program;
	public long firstStartDate;
	public long lastEndDate;
	public long createDateSource;
	public long modifiedDateSource;
	public long imageId;
	public boolean registration;
	public long registrationStartDate;
	public long registrationEndDate;
	public long maxGauge;

}