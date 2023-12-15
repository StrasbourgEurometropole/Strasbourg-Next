/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.edition.model.Edition;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Edition in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class EditionCacheModel implements CacheModel<Edition>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EditionCacheModel)) {
			return false;
		}

		EditionCacheModel editionCacheModel = (EditionCacheModel)object;

		if (editionId == editionCacheModel.editionId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, editionId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(63);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", editionId=");
		sb.append(editionId);
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
		sb.append(", URL=");
		sb.append(URL);
		sb.append(", author=");
		sb.append(author);
		sb.append(", editor=");
		sb.append(editor);
		sb.append(", distribution=");
		sb.append(distribution);
		sb.append(", ISBN=");
		sb.append(ISBN);
		sb.append(", price=");
		sb.append(price);
		sb.append(", availableForExchange=");
		sb.append(availableForExchange);
		sb.append(", inStock=");
		sb.append(inStock);
		sb.append(", diffusionDateYear=");
		sb.append(diffusionDateYear);
		sb.append(", diffusionDateMonth=");
		sb.append(diffusionDateMonth);
		sb.append(", pageNumber=");
		sb.append(pageNumber);
		sb.append(", pictureNumber=");
		sb.append(pictureNumber);
		sb.append(", publicationDate=");
		sb.append(publicationDate);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", fileId=");
		sb.append(fileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Edition toEntityModel() {
		EditionImpl editionImpl = new EditionImpl();

		if (uuid == null) {
			editionImpl.setUuid("");
		}
		else {
			editionImpl.setUuid(uuid);
		}

		editionImpl.setEditionId(editionId);
		editionImpl.setGroupId(groupId);
		editionImpl.setCompanyId(companyId);
		editionImpl.setUserId(userId);

		if (userName == null) {
			editionImpl.setUserName("");
		}
		else {
			editionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			editionImpl.setCreateDate(null);
		}
		else {
			editionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			editionImpl.setModifiedDate(null);
		}
		else {
			editionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			editionImpl.setLastPublishDate(null);
		}
		else {
			editionImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		editionImpl.setStatus(status);
		editionImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			editionImpl.setStatusByUserName("");
		}
		else {
			editionImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			editionImpl.setStatusDate(null);
		}
		else {
			editionImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			editionImpl.setTitle("");
		}
		else {
			editionImpl.setTitle(title);
		}

		if (subtitle == null) {
			editionImpl.setSubtitle("");
		}
		else {
			editionImpl.setSubtitle(subtitle);
		}

		if (description == null) {
			editionImpl.setDescription("");
		}
		else {
			editionImpl.setDescription(description);
		}

		if (URL == null) {
			editionImpl.setURL("");
		}
		else {
			editionImpl.setURL(URL);
		}

		if (author == null) {
			editionImpl.setAuthor("");
		}
		else {
			editionImpl.setAuthor(author);
		}

		if (editor == null) {
			editionImpl.setEditor("");
		}
		else {
			editionImpl.setEditor(editor);
		}

		if (distribution == null) {
			editionImpl.setDistribution("");
		}
		else {
			editionImpl.setDistribution(distribution);
		}

		if (ISBN == null) {
			editionImpl.setISBN("");
		}
		else {
			editionImpl.setISBN(ISBN);
		}

		if (price == null) {
			editionImpl.setPrice("");
		}
		else {
			editionImpl.setPrice(price);
		}

		editionImpl.setAvailableForExchange(availableForExchange);
		editionImpl.setInStock(inStock);

		if (diffusionDateYear == null) {
			editionImpl.setDiffusionDateYear("");
		}
		else {
			editionImpl.setDiffusionDateYear(diffusionDateYear);
		}

		if (diffusionDateMonth == null) {
			editionImpl.setDiffusionDateMonth("");
		}
		else {
			editionImpl.setDiffusionDateMonth(diffusionDateMonth);
		}

		if (pageNumber == null) {
			editionImpl.setPageNumber("");
		}
		else {
			editionImpl.setPageNumber(pageNumber);
		}

		if (pictureNumber == null) {
			editionImpl.setPictureNumber("");
		}
		else {
			editionImpl.setPictureNumber(pictureNumber);
		}

		if (publicationDate == Long.MIN_VALUE) {
			editionImpl.setPublicationDate(null);
		}
		else {
			editionImpl.setPublicationDate(new Date(publicationDate));
		}

		editionImpl.setImageId(imageId);

		if (fileId == null) {
			editionImpl.setFileId("");
		}
		else {
			editionImpl.setFileId(fileId);
		}

		editionImpl.resetOriginalValues();

		return editionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput)
		throws ClassNotFoundException, IOException {

		uuid = objectInput.readUTF();

		editionId = objectInput.readLong();

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
		URL = objectInput.readUTF();
		author = objectInput.readUTF();
		editor = objectInput.readUTF();
		distribution = objectInput.readUTF();
		ISBN = objectInput.readUTF();
		price = objectInput.readUTF();

		availableForExchange = objectInput.readBoolean();

		inStock = objectInput.readBoolean();
		diffusionDateYear = objectInput.readUTF();
		diffusionDateMonth = objectInput.readUTF();
		pageNumber = objectInput.readUTF();
		pictureNumber = objectInput.readUTF();
		publicationDate = objectInput.readLong();

		imageId = objectInput.readLong();
		fileId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(editionId);

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

		if (URL == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(URL);
		}

		if (author == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(author);
		}

		if (editor == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(editor);
		}

		if (distribution == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(distribution);
		}

		if (ISBN == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ISBN);
		}

		if (price == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(price);
		}

		objectOutput.writeBoolean(availableForExchange);

		objectOutput.writeBoolean(inStock);

		if (diffusionDateYear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diffusionDateYear);
		}

		if (diffusionDateMonth == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(diffusionDateMonth);
		}

		if (pageNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pageNumber);
		}

		if (pictureNumber == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pictureNumber);
		}

		objectOutput.writeLong(publicationDate);

		objectOutput.writeLong(imageId);

		if (fileId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(fileId);
		}
	}

	public String uuid;
	public long editionId;
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

	public String URL;

	public String author;
	public String editor;
	public String distribution;

	public String ISBN;

	public String price;
	public boolean availableForExchange;
	public boolean inStock;
	public String diffusionDateYear;
	public String diffusionDateMonth;
	public String pageNumber;
	public String pictureNumber;
	public long publicationDate;
	public long imageId;
	public String fileId;

}