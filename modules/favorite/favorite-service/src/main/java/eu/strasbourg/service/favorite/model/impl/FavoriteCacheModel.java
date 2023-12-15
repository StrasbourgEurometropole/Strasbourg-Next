/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.favorite.model.Favorite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Favorite in entity cache.
 *
 * @author BenjaminBini
 * @generated
 */
public class FavoriteCacheModel
	implements CacheModel<Favorite>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof FavoriteCacheModel)) {
			return false;
		}

		FavoriteCacheModel favoriteCacheModel = (FavoriteCacheModel)object;

		if (favoriteId == favoriteCacheModel.favoriteId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, favoriteId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{favoriteId=");
		sb.append(favoriteId);
		sb.append(", publikUserId=");
		sb.append(publikUserId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", url=");
		sb.append(url);
		sb.append(", typeId=");
		sb.append(typeId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", entityGroupId=");
		sb.append(entityGroupId);
		sb.append(", onDashboardDate=");
		sb.append(onDashboardDate);
		sb.append(", order=");
		sb.append(order);
		sb.append(", content=");
		sb.append(content);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Favorite toEntityModel() {
		FavoriteImpl favoriteImpl = new FavoriteImpl();

		favoriteImpl.setFavoriteId(favoriteId);

		if (publikUserId == null) {
			favoriteImpl.setPublikUserId("");
		}
		else {
			favoriteImpl.setPublikUserId(publikUserId);
		}

		if (title == null) {
			favoriteImpl.setTitle("");
		}
		else {
			favoriteImpl.setTitle(title);
		}

		if (url == null) {
			favoriteImpl.setUrl("");
		}
		else {
			favoriteImpl.setUrl(url);
		}

		favoriteImpl.setTypeId(typeId);
		favoriteImpl.setEntityId(entityId);
		favoriteImpl.setEntityGroupId(entityGroupId);

		if (onDashboardDate == Long.MIN_VALUE) {
			favoriteImpl.setOnDashboardDate(null);
		}
		else {
			favoriteImpl.setOnDashboardDate(new Date(onDashboardDate));
		}

		favoriteImpl.setOrder(order);

		if (content == null) {
			favoriteImpl.setContent("");
		}
		else {
			favoriteImpl.setContent(content);
		}

		if (createDate == Long.MIN_VALUE) {
			favoriteImpl.setCreateDate(null);
		}
		else {
			favoriteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			favoriteImpl.setModifiedDate(null);
		}
		else {
			favoriteImpl.setModifiedDate(new Date(modifiedDate));
		}

		favoriteImpl.resetOriginalValues();

		return favoriteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		favoriteId = objectInput.readLong();
		publikUserId = objectInput.readUTF();
		title = objectInput.readUTF();
		url = objectInput.readUTF();

		typeId = objectInput.readLong();

		entityId = objectInput.readLong();

		entityGroupId = objectInput.readLong();
		onDashboardDate = objectInput.readLong();

		order = objectInput.readInt();
		content = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(favoriteId);

		if (publikUserId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(publikUserId);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (url == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeLong(typeId);

		objectOutput.writeLong(entityId);

		objectOutput.writeLong(entityGroupId);
		objectOutput.writeLong(onDashboardDate);

		objectOutput.writeInt(order);

		if (content == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long favoriteId;
	public String publikUserId;
	public String title;
	public String url;
	public long typeId;
	public long entityId;
	public long entityGroupId;
	public long onDashboardDate;
	public int order;
	public String content;
	public long createDate;
	public long modifiedDate;

}