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

package eu.strasbourg.service.agenda.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.agenda.model.AgendaExport;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AgendaExport in entity cache.
 *
 * @author BenjaminBini
 * @see AgendaExport
 * @generated
 */
@ProviderType
public class AgendaExportCacheModel implements CacheModel<AgendaExport>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AgendaExportCacheModel)) {
			return false;
		}

		AgendaExportCacheModel agendaExportCacheModel = (AgendaExportCacheModel)obj;

		if (agendaExportId == agendaExportCacheModel.agendaExportId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, agendaExportId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", agendaExportId=");
		sb.append(agendaExportId);
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
		sb.append(", language=");
		sb.append(language);
		sb.append(", exportFormat=");
		sb.append(exportFormat);
		sb.append(", eventCategories=");
		sb.append(eventCategories);
		sb.append(", aggregations=");
		sb.append(aggregations);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AgendaExport toEntityModel() {
		AgendaExportImpl agendaExportImpl = new AgendaExportImpl();

		if (uuid == null) {
			agendaExportImpl.setUuid(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setUuid(uuid);
		}

		agendaExportImpl.setAgendaExportId(agendaExportId);
		agendaExportImpl.setGroupId(groupId);
		agendaExportImpl.setCompanyId(companyId);
		agendaExportImpl.setUserId(userId);

		if (userName == null) {
			agendaExportImpl.setUserName(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agendaExportImpl.setCreateDate(null);
		}
		else {
			agendaExportImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agendaExportImpl.setModifiedDate(null);
		}
		else {
			agendaExportImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (lastPublishDate == Long.MIN_VALUE) {
			agendaExportImpl.setLastPublishDate(null);
		}
		else {
			agendaExportImpl.setLastPublishDate(new Date(lastPublishDate));
		}

		agendaExportImpl.setStatus(status);
		agendaExportImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			agendaExportImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			agendaExportImpl.setStatusDate(null);
		}
		else {
			agendaExportImpl.setStatusDate(new Date(statusDate));
		}

		if (title == null) {
			agendaExportImpl.setTitle(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setTitle(title);
		}

		if (language == null) {
			agendaExportImpl.setLanguage(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setLanguage(language);
		}

		if (exportFormat == null) {
			agendaExportImpl.setExportFormat(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setExportFormat(exportFormat);
		}

		if (eventCategories == null) {
			agendaExportImpl.setEventCategories(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setEventCategories(eventCategories);
		}

		if (aggregations == null) {
			agendaExportImpl.setAggregations(StringPool.BLANK);
		}
		else {
			agendaExportImpl.setAggregations(aggregations);
		}

		agendaExportImpl.resetOriginalValues();

		return agendaExportImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		agendaExportId = objectInput.readLong();

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
		language = objectInput.readUTF();
		exportFormat = objectInput.readUTF();
		eventCategories = objectInput.readUTF();
		aggregations = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(agendaExportId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
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
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		objectOutput.writeLong(statusDate);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (language == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(language);
		}

		if (exportFormat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(exportFormat);
		}

		if (eventCategories == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eventCategories);
		}

		if (aggregations == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(aggregations);
		}
	}

	public String uuid;
	public long agendaExportId;
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
	public String language;
	public String exportFormat;
	public String eventCategories;
	public String aggregations;
}