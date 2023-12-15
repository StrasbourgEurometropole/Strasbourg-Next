/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.project.model.ProjectTimeline;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProjectTimeline in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class ProjectTimelineCacheModel
	implements CacheModel<ProjectTimeline>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectTimelineCacheModel)) {
			return false;
		}

		ProjectTimelineCacheModel projectTimelineCacheModel =
			(ProjectTimelineCacheModel)object;

		if (projectTimelineId == projectTimelineCacheModel.projectTimelineId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, projectTimelineId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{projectTimelineId=");
		sb.append(projectTimelineId);
		sb.append(", startDay=");
		sb.append(startDay);
		sb.append(", spacing=");
		sb.append(spacing);
		sb.append(", date=");
		sb.append(date);
		sb.append(", dateFormat=");
		sb.append(dateFormat);
		sb.append(", title=");
		sb.append(title);
		sb.append(", link=");
		sb.append(link);
		sb.append(", projectId=");
		sb.append(projectId);
		sb.append(", budgetParticipatifId=");
		sb.append(budgetParticipatifId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProjectTimeline toEntityModel() {
		ProjectTimelineImpl projectTimelineImpl = new ProjectTimelineImpl();

		projectTimelineImpl.setProjectTimelineId(projectTimelineId);
		projectTimelineImpl.setStartDay(startDay);
		projectTimelineImpl.setSpacing(spacing);

		if (date == Long.MIN_VALUE) {
			projectTimelineImpl.setDate(null);
		}
		else {
			projectTimelineImpl.setDate(new Date(date));
		}

		if (dateFormat == null) {
			projectTimelineImpl.setDateFormat("");
		}
		else {
			projectTimelineImpl.setDateFormat(dateFormat);
		}

		if (title == null) {
			projectTimelineImpl.setTitle("");
		}
		else {
			projectTimelineImpl.setTitle(title);
		}

		if (link == null) {
			projectTimelineImpl.setLink("");
		}
		else {
			projectTimelineImpl.setLink(link);
		}

		projectTimelineImpl.setProjectId(projectId);
		projectTimelineImpl.setBudgetParticipatifId(budgetParticipatifId);

		projectTimelineImpl.resetOriginalValues();

		return projectTimelineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		projectTimelineId = objectInput.readLong();

		startDay = objectInput.readInt();

		spacing = objectInput.readInt();
		date = objectInput.readLong();
		dateFormat = objectInput.readUTF();
		title = objectInput.readUTF();
		link = objectInput.readUTF();

		projectId = objectInput.readLong();

		budgetParticipatifId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(projectTimelineId);

		objectOutput.writeInt(startDay);

		objectOutput.writeInt(spacing);
		objectOutput.writeLong(date);

		if (dateFormat == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(dateFormat);
		}

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (link == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeLong(projectId);

		objectOutput.writeLong(budgetParticipatifId);
	}

	public long projectTimelineId;
	public int startDay;
	public int spacing;
	public long date;
	public String dateFormat;
	public String title;
	public String link;
	public long projectId;
	public long budgetParticipatifId;

}