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

package eu.strasbourg.service.gtfs.model;

import aQute.bnd.annotation.ProviderType;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public class TripSoap implements Serializable {

	public static TripSoap toSoapModel(Trip model) {
		TripSoap soapModel = new TripSoap();

		soapModel.setRoute_id(model.getRoute_id());
		soapModel.setService_id(model.getService_id());
		soapModel.setTrip_id(model.getTrip_id());
		soapModel.setTrip_headsign(model.getTrip_headsign());

		return soapModel;
	}

	public static TripSoap[] toSoapModels(Trip[] models) {
		TripSoap[] soapModels = new TripSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static TripSoap[][] toSoapModels(Trip[][] models) {
		TripSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new TripSoap[models.length][models[0].length];
		}
		else {
			soapModels = new TripSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static TripSoap[] toSoapModels(List<Trip> models) {
		List<TripSoap> soapModels = new ArrayList<TripSoap>(models.size());

		for (Trip model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new TripSoap[soapModels.size()]);
	}

	public TripSoap() {
	}

	public String getPrimaryKey() {
		return _trip_id;
	}

	public void setPrimaryKey(String pk) {
		setTrip_id(pk);
	}

	public String getRoute_id() {
		return _route_id;
	}

	public void setRoute_id(String route_id) {
		_route_id = route_id;
	}

	public String getService_id() {
		return _service_id;
	}

	public void setService_id(String service_id) {
		_service_id = service_id;
	}

	public String getTrip_id() {
		return _trip_id;
	}

	public void setTrip_id(String trip_id) {
		_trip_id = trip_id;
	}

	public String getTrip_headsign() {
		return _trip_headsign;
	}

	public void setTrip_headsign(String trip_headsign) {
		_trip_headsign = trip_headsign;
	}

	private String _route_id;
	private String _service_id;
	private String _trip_id;
	private String _trip_headsign;

}