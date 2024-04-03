/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public interface TripFinder {

	public java.util.List<eu.strasbourg.service.gtfs.model.Trip>
		getTripAvailable(String stopId);

}