/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.place.model.Place;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Place in entity cache.
 *
 * @author Angelique Zunino Champougny
 * @generated
 */
public class PlaceCacheModel implements CacheModel<Place>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PlaceCacheModel)) {
			return false;
		}

		PlaceCacheModel placeCacheModel = (PlaceCacheModel)object;

		if (placeId == placeCacheModel.placeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, placeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(139);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", placeId=");
		sb.append(placeId);
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
		sb.append(", SIGid=");
		sb.append(SIGid);
		sb.append(", name=");
		sb.append(name);
		sb.append(", addressComplement=");
		sb.append(addressComplement);
		sb.append(", addressStreet=");
		sb.append(addressStreet);
		sb.append(", addressDistribution=");
		sb.append(addressDistribution);
		sb.append(", addressZipCode=");
		sb.append(addressZipCode);
		sb.append(", addressCountry=");
		sb.append(addressCountry);
		sb.append(", mercatorX=");
		sb.append(mercatorX);
		sb.append(", mercatorY=");
		sb.append(mercatorY);
		sb.append(", RGF93X=");
		sb.append(RGF93X);
		sb.append(", RGF93Y=");
		sb.append(RGF93Y);
		sb.append(", locationId=");
		sb.append(locationId);
		sb.append(", alias=");
		sb.append(alias);
		sb.append(", presentation=");
		sb.append(presentation);
		sb.append(", serviceAndActivities=");
		sb.append(serviceAndActivities);
		sb.append(", characteristics=");
		sb.append(characteristics);
		sb.append(", subjectToPublicHoliday=");
		sb.append(subjectToPublicHoliday);
		sb.append(", exceptionalSchedule=");
		sb.append(exceptionalSchedule);
		sb.append(", displayEvents=");
		sb.append(displayEvents);
		sb.append(", additionalInformation=");
		sb.append(additionalInformation);
		sb.append(", contenuTooltipCarto=");
		sb.append(contenuTooltipCarto);
		sb.append(", hasURLSchedule=");
		sb.append(hasURLSchedule);
		sb.append(", scheduleLinkName=");
		sb.append(scheduleLinkName);
		sb.append(", scheduleLinkURL=");
		sb.append(scheduleLinkURL);
		sb.append(", phone=");
		sb.append(phone);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", siteURL=");
		sb.append(siteURL);
		sb.append(", siteLabel=");
		sb.append(siteLabel);
		sb.append(", bookingURL=");
		sb.append(bookingURL);
		sb.append(", facebookURL=");
		sb.append(facebookURL);
		sb.append(", facebookLabel=");
		sb.append(facebookLabel);
		sb.append(", instagramURL=");
		sb.append(instagramURL);
		sb.append(", instagramLabel=");
		sb.append(instagramLabel);
		sb.append(", accesMap=");
		sb.append(accesMap);
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
		sb.append(", RTEnabled=");
		sb.append(RTEnabled);
		sb.append(", RTType=");
		sb.append(RTType);
		sb.append(", RTExternalId=");
		sb.append(RTExternalId);
		sb.append(", RTAvailable=");
		sb.append(RTAvailable);
		sb.append(", RTOccupation=");
		sb.append(RTOccupation);
		sb.append(", RTCapacity=");
		sb.append(RTCapacity);
		sb.append(", RTStatus=");
		sb.append(RTStatus);
		sb.append(", RTLastUpdate=");
		sb.append(RTLastUpdate);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", imageWidth=");
		sb.append(imageWidth);
		sb.append(", imageHeight=");
		sb.append(imageHeight);
		sb.append(", imageIds=");
		sb.append(imageIds);
		sb.append(", videosIds=");
		sb.append(videosIds);
		sb.append(", priceId=");
		sb.append(priceId);
		sb.append(", documentsIds=");
		sb.append(documentsIds);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Place toEntityModel() {
		PlaceImpl placeImpl = new PlaceImpl();

		if (uuid == null) {
			placeImpl.setUuid("");
		}
		else {
			placeImpl.setUuid(uuid);
		}

		placeImpl.setPlaceId(placeId);
		placeImpl.setGroupId(groupId);
		placeImpl.setCompanyId(companyId);
		placeImpl.setUserId(userId);

		if (userName == null) {
			placeImpl.setUserName("");
		}
		else {
			placeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			placeImpl.setCreateDate(null);
		}
		else {
			placeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			placeImpl.setModifiedDate(null);
		}
		else {
			placeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			placeImpl.setLastPublishDate(null);
		}
		else {
			placeImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		placeImpl.setStatus(status);
		placeImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			placeImpl.setStatusByUserName("");
		}
		else {
			placeImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			placeImpl.setStatusDate(null);
		}
		else {
			placeImpl.setStatusDate(new Date(statusDate));
		}

		if (SIGid == null) {
			placeImpl.setSIGid("");
		}
		else {
			placeImpl.setSIGid(SIGid);
		}

		if (name == null) {
			placeImpl.setName("");
		}
		else {
			placeImpl.setName(name);
		}

		if (addressComplement == null) {
			placeImpl.setAddressComplement("");
		}
		else {
			placeImpl.setAddressComplement(addressComplement);
		}

		if (addressStreet == null) {
			placeImpl.setAddressStreet("");
		}
		else {
			placeImpl.setAddressStreet(addressStreet);
		}

		if (addressDistribution == null) {
			placeImpl.setAddressDistribution("");
		}
		else {
			placeImpl.setAddressDistribution(addressDistribution);
		}

		if (addressZipCode == null) {
			placeImpl.setAddressZipCode("");
		}
		else {
			placeImpl.setAddressZipCode(addressZipCode);
		}

		if (addressCountry == null) {
			placeImpl.setAddressCountry("");
		}
		else {
			placeImpl.setAddressCountry(addressCountry);
		}

		if (mercatorX == null) {
			placeImpl.setMercatorX("");
		}
		else {
			placeImpl.setMercatorX(mercatorX);
		}

		if (mercatorY == null) {
			placeImpl.setMercatorY("");
		}
		else {
			placeImpl.setMercatorY(mercatorY);
		}

		if (RGF93X == null) {
			placeImpl.setRGF93X("");
		}
		else {
			placeImpl.setRGF93X(RGF93X);
		}

		if (RGF93Y == null) {
			placeImpl.setRGF93Y("");
		}
		else {
			placeImpl.setRGF93Y(RGF93Y);
		}

		if (locationId == null) {
			placeImpl.setLocationId("");
		}
		else {
			placeImpl.setLocationId(locationId);
		}

		if (alias == null) {
			placeImpl.setAlias("");
		}
		else {
			placeImpl.setAlias(alias);
		}

		if (presentation == null) {
			placeImpl.setPresentation("");
		}
		else {
			placeImpl.setPresentation(presentation);
		}

		if (serviceAndActivities == null) {
			placeImpl.setServiceAndActivities("");
		}
		else {
			placeImpl.setServiceAndActivities(serviceAndActivities);
		}

		if (characteristics == null) {
			placeImpl.setCharacteristics("");
		}
		else {
			placeImpl.setCharacteristics(characteristics);
		}

		placeImpl.setSubjectToPublicHoliday(subjectToPublicHoliday);

		if (exceptionalSchedule == null) {
			placeImpl.setExceptionalSchedule("");
		}
		else {
			placeImpl.setExceptionalSchedule(exceptionalSchedule);
		}

		placeImpl.setDisplayEvents(displayEvents);

		if (additionalInformation == null) {
			placeImpl.setAdditionalInformation("");
		}
		else {
			placeImpl.setAdditionalInformation(additionalInformation);
		}

		if (contenuTooltipCarto == null) {
			placeImpl.setContenuTooltipCarto("");
		}
		else {
			placeImpl.setContenuTooltipCarto(contenuTooltipCarto);
		}

		placeImpl.setHasURLSchedule(hasURLSchedule);

		if (scheduleLinkName == null) {
			placeImpl.setScheduleLinkName("");
		}
		else {
			placeImpl.setScheduleLinkName(scheduleLinkName);
		}

		if (scheduleLinkURL == null) {
			placeImpl.setScheduleLinkURL("");
		}
		else {
			placeImpl.setScheduleLinkURL(scheduleLinkURL);
		}

		if (phone == null) {
			placeImpl.setPhone("");
		}
		else {
			placeImpl.setPhone(phone);
		}

		if (mail == null) {
			placeImpl.setMail("");
		}
		else {
			placeImpl.setMail(mail);
		}

		if (siteURL == null) {
			placeImpl.setSiteURL("");
		}
		else {
			placeImpl.setSiteURL(siteURL);
		}

		if (siteLabel == null) {
			placeImpl.setSiteLabel("");
		}
		else {
			placeImpl.setSiteLabel(siteLabel);
		}

		if (bookingURL == null) {
			placeImpl.setBookingURL("");
		}
		else {
			placeImpl.setBookingURL(bookingURL);
		}

		if (facebookURL == null) {
			placeImpl.setFacebookURL("");
		}
		else {
			placeImpl.setFacebookURL(facebookURL);
		}

		if (facebookLabel == null) {
			placeImpl.setFacebookLabel("");
		}
		else {
			placeImpl.setFacebookLabel(facebookLabel);
		}

		if (instagramURL == null) {
			placeImpl.setInstagramURL("");
		}
		else {
			placeImpl.setInstagramURL(instagramURL);
		}

		if (instagramLabel == null) {
			placeImpl.setInstagramLabel("");
		}
		else {
			placeImpl.setInstagramLabel(instagramLabel);
		}

		if (accesMap == null) {
			placeImpl.setAccesMap("");
		}
		else {
			placeImpl.setAccesMap(accesMap);
		}

		if (access == null) {
			placeImpl.setAccess("");
		}
		else {
			placeImpl.setAccess(access);
		}

		if (accessForDisabled == null) {
			placeImpl.setAccessForDisabled("");
		}
		else {
			placeImpl.setAccessForDisabled(accessForDisabled);
		}

		placeImpl.setAccessForBlind(accessForBlind);
		placeImpl.setAccessForDeaf(accessForDeaf);
		placeImpl.setAccessForWheelchair(accessForWheelchair);
		placeImpl.setAccessForElder(accessForElder);
		placeImpl.setAccessForDeficient(accessForDeficient);
		placeImpl.setRTEnabled(RTEnabled);

		if (RTType == null) {
			placeImpl.setRTType("");
		}
		else {
			placeImpl.setRTType(RTType);
		}

		if (RTExternalId == null) {
			placeImpl.setRTExternalId("");
		}
		else {
			placeImpl.setRTExternalId(RTExternalId);
		}

		placeImpl.setRTAvailable(RTAvailable);
		placeImpl.setRTOccupation(RTOccupation);
		placeImpl.setRTCapacity(RTCapacity);

		if (RTStatus == null) {
			placeImpl.setRTStatus("");
		}
		else {
			placeImpl.setRTStatus(RTStatus);
		}

		if (RTLastUpdate == Long.MIN_VALUE) {
			placeImpl.setRTLastUpdate(null);
		}
		else {
			placeImpl.setRTLastUpdate(new Date(RTLastUpdate));
		}

		placeImpl.setImageId(imageId);
		placeImpl.setImageWidth(imageWidth);
		placeImpl.setImageHeight(imageHeight);

		if (imageIds == null) {
			placeImpl.setImageIds("");
		}
		else {
			placeImpl.setImageIds(imageIds);
		}

		if (videosIds == null) {
			placeImpl.setVideosIds("");
		}
		else {
			placeImpl.setVideosIds(videosIds);
		}

		placeImpl.setPriceId(priceId);

		if (documentsIds == null) {
			placeImpl.setDocumentsIds("");
		}
		else {
			placeImpl.setDocumentsIds(documentsIds);
		}

		placeImpl.resetOriginalValues();

		return placeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		placeId = objectInput.readLong();

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
		SIGid = objectInput.readUTF();
		name = objectInput.readUTF();
		addressComplement = objectInput.readUTF();
		addressStreet = objectInput.readUTF();
		addressDistribution = objectInput.readUTF();
		addressZipCode = objectInput.readUTF();
		addressCountry = objectInput.readUTF();
		mercatorX = objectInput.readUTF();
		mercatorY = objectInput.readUTF();
		RGF93X = objectInput.readUTF();
		RGF93Y = objectInput.readUTF();
		locationId = objectInput.readUTF();
		alias = objectInput.readUTF();
		presentation = (String)objectInput.readObject();
		serviceAndActivities = (String)objectInput.readObject();
		characteristics = (String)objectInput.readObject();

		subjectToPublicHoliday = objectInput.readBoolean();
		exceptionalSchedule = (String)objectInput.readObject();

		displayEvents = objectInput.readBoolean();
		additionalInformation = (String)objectInput.readObject();
		contenuTooltipCarto = (String)objectInput.readObject();

		hasURLSchedule = objectInput.readBoolean();
		scheduleLinkName = objectInput.readUTF();
		scheduleLinkURL = objectInput.readUTF();
		phone = objectInput.readUTF();
		mail = objectInput.readUTF();
		siteURL = objectInput.readUTF();
		siteLabel = objectInput.readUTF();
		bookingURL = objectInput.readUTF();
		facebookURL = objectInput.readUTF();
		facebookLabel = objectInput.readUTF();
		instagramURL = objectInput.readUTF();
		instagramLabel = objectInput.readUTF();
		accesMap = objectInput.readUTF();
		access = (String)objectInput.readObject();
		accessForDisabled = (String)objectInput.readObject();

		accessForBlind = objectInput.readBoolean();

		accessForDeaf = objectInput.readBoolean();

		accessForWheelchair = objectInput.readBoolean();

		accessForElder = objectInput.readBoolean();

		accessForDeficient = objectInput.readBoolean();

		RTEnabled = objectInput.readBoolean();
		RTType = objectInput.readUTF();
		RTExternalId = objectInput.readUTF();

		RTAvailable = objectInput.readLong();

		RTOccupation = objectInput.readLong();

		RTCapacity = objectInput.readLong();
		RTStatus = objectInput.readUTF();
		RTLastUpdate = objectInput.readLong();

		imageId = objectInput.readLong();

		imageWidth = objectInput.readInt();

		imageHeight = objectInput.readInt();
		imageIds = objectInput.readUTF();
		videosIds = objectInput.readUTF();

		priceId = objectInput.readLong();
		documentsIds = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(placeId);

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

		if (SIGid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(SIGid);
		}

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (addressComplement == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressComplement);
		}

		if (addressStreet == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressStreet);
		}

		if (addressDistribution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressDistribution);
		}

		if (addressZipCode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressZipCode);
		}

		if (addressCountry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(addressCountry);
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

		if (RGF93X == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RGF93X);
		}

		if (RGF93Y == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RGF93Y);
		}

		if (locationId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(locationId);
		}

		if (alias == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(alias);
		}

		if (presentation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(presentation);
		}

		if (serviceAndActivities == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(serviceAndActivities);
		}

		if (characteristics == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(characteristics);
		}

		objectOutput.writeBoolean(subjectToPublicHoliday);

		if (exceptionalSchedule == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(exceptionalSchedule);
		}

		objectOutput.writeBoolean(displayEvents);

		if (additionalInformation == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(additionalInformation);
		}

		if (contenuTooltipCarto == null) {
			objectOutput.writeObject("");
		}
		else {
			objectOutput.writeObject(contenuTooltipCarto);
		}

		objectOutput.writeBoolean(hasURLSchedule);

		if (scheduleLinkName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scheduleLinkName);
		}

		if (scheduleLinkURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(scheduleLinkURL);
		}

		if (phone == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(phone);
		}

		if (mail == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (siteURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(siteURL);
		}

		if (siteLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(siteLabel);
		}

		if (bookingURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bookingURL);
		}

		if (facebookURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebookURL);
		}

		if (facebookLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(facebookLabel);
		}

		if (instagramURL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instagramURL);
		}

		if (instagramLabel == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(instagramLabel);
		}

		if (accesMap == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(accesMap);
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

		objectOutput.writeBoolean(RTEnabled);

		if (RTType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RTType);
		}

		if (RTExternalId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RTExternalId);
		}

		objectOutput.writeLong(RTAvailable);

		objectOutput.writeLong(RTOccupation);

		objectOutput.writeLong(RTCapacity);

		if (RTStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(RTStatus);
		}

		objectOutput.writeLong(RTLastUpdate);

		objectOutput.writeLong(imageId);

		objectOutput.writeInt(imageWidth);

		objectOutput.writeInt(imageHeight);

		if (imageIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(imageIds);
		}

		if (videosIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(videosIds);
		}

		objectOutput.writeLong(priceId);

		if (documentsIds == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(documentsIds);
		}
	}

	public String uuid;
	public long placeId;
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
	public String SIGid;
	public String name;
	public String addressComplement;
	public String addressStreet;
	public String addressDistribution;
	public String addressZipCode;
	public String addressCountry;
	public String mercatorX;
	public String mercatorY;

	public String RGF93X;

	public String RGF93Y;

	public String locationId;
	public String alias;
	public String presentation;
	public String serviceAndActivities;
	public String characteristics;
	public boolean subjectToPublicHoliday;
	public String exceptionalSchedule;
	public boolean displayEvents;
	public String additionalInformation;
	public String contenuTooltipCarto;
	public boolean hasURLSchedule;
	public String scheduleLinkName;
	public String scheduleLinkURL;
	public String phone;
	public String mail;
	public String siteURL;
	public String siteLabel;
	public String bookingURL;
	public String facebookURL;
	public String facebookLabel;
	public String instagramURL;
	public String instagramLabel;
	public String accesMap;
	public String access;
	public String accessForDisabled;
	public boolean accessForBlind;
	public boolean accessForDeaf;
	public boolean accessForWheelchair;
	public boolean accessForElder;
	public boolean accessForDeficient;
	public boolean RTEnabled;
	public String RTType;
	public String RTExternalId;
	public long RTAvailable;
	public long RTOccupation;
	public long RTCapacity;
	public String RTStatus;
	public long RTLastUpdate;
	public long imageId;
	public int imageWidth;
	public int imageHeight;
	public String imageIds;
	public String videosIds;
	public long priceId;
	public String documentsIds;

}