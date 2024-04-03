/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import eu.strasbourg.service.gtfs.model.Route;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Route in entity cache.
 *
 * @author Cedric Henry
 * @generated
 */
public class RouteCacheModel implements CacheModel<Route>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof RouteCacheModel)) {
			return false;
		}

		RouteCacheModel routeCacheModel = (RouteCacheModel)object;

		if (id == routeCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", id=");
		sb.append(id);
		sb.append(", route_id=");
		sb.append(route_id);
		sb.append(", route_short_name=");
		sb.append(route_short_name);
		sb.append(", route_long_name=");
		sb.append(route_long_name);
		sb.append(", route_desc=");
		sb.append(route_desc);
		sb.append(", route_type=");
		sb.append(route_type);
		sb.append(", route_color=");
		sb.append(route_color);
		sb.append(", route_text_color=");
		sb.append(route_text_color);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Route toEntityModel() {
		RouteImpl routeImpl = new RouteImpl();

		if (uuid == null) {
			routeImpl.setUuid("");
		}
		else {
			routeImpl.setUuid(uuid);
		}

		routeImpl.setId(id);

		if (route_id == null) {
			routeImpl.setRoute_id("");
		}
		else {
			routeImpl.setRoute_id(route_id);
		}

		if (route_short_name == null) {
			routeImpl.setRoute_short_name("");
		}
		else {
			routeImpl.setRoute_short_name(route_short_name);
		}

		if (route_long_name == null) {
			routeImpl.setRoute_long_name("");
		}
		else {
			routeImpl.setRoute_long_name(route_long_name);
		}

		if (route_desc == null) {
			routeImpl.setRoute_desc("");
		}
		else {
			routeImpl.setRoute_desc(route_desc);
		}

		routeImpl.setRoute_type(route_type);

		if (route_color == null) {
			routeImpl.setRoute_color("");
		}
		else {
			routeImpl.setRoute_color(route_color);
		}

		if (route_text_color == null) {
			routeImpl.setRoute_text_color("");
		}
		else {
			routeImpl.setRoute_text_color(route_text_color);
		}

		routeImpl.resetOriginalValues();

		return routeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		id = objectInput.readLong();
		route_id = objectInput.readUTF();
		route_short_name = objectInput.readUTF();
		route_long_name = objectInput.readUTF();
		route_desc = objectInput.readUTF();

		route_type = objectInput.readInt();
		route_color = objectInput.readUTF();
		route_text_color = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(id);

		if (route_id == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_id);
		}

		if (route_short_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_short_name);
		}

		if (route_long_name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_long_name);
		}

		if (route_desc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_desc);
		}

		objectOutput.writeInt(route_type);

		if (route_color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_color);
		}

		if (route_text_color == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(route_text_color);
		}
	}

	public String uuid;
	public long id;
	public String route_id;
	public String route_short_name;
	public String route_long_name;
	public String route_desc;
	public int route_type;
	public String route_color;
	public String route_text_color;

}