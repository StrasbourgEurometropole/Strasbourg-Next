/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import eu.strasbourg.service.gtfs.model.Trip;
import eu.strasbourg.service.gtfs.service.persistence.TripPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Cedric Henry
 * @generated
 */
public class TripFinderBaseImpl extends BasePersistenceImpl<Trip> {

	public TripFinderBaseImpl() {
		setModelClass(Trip.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("id", "id_");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getTripPersistence().getBadColumnNames();
	}

	/**
	 * Returns the trip persistence.
	 *
	 * @return the trip persistence
	 */
	public TripPersistence getTripPersistence() {
		return tripPersistence;
	}

	/**
	 * Sets the trip persistence.
	 *
	 * @param tripPersistence the trip persistence
	 */
	public void setTripPersistence(TripPersistence tripPersistence) {
		this.tripPersistence = tripPersistence;
	}

	@BeanReference(type = TripPersistence.class)
	protected TripPersistence tripPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		TripFinderBaseImpl.class);

}