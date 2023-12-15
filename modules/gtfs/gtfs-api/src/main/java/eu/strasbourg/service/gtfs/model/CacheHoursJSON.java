/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.gtfs.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the CacheHoursJSON service. Represents a row in the &quot;gtfs_CacheHoursJSON&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see CacheHoursJSONModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONImpl"
)
@ProviderType
public interface CacheHoursJSON extends CacheHoursJSONModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.gtfs.model.impl.CacheHoursJSONImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<CacheHoursJSON, String> STOP_CODE_ACCESSOR =
		new Accessor<CacheHoursJSON, String>() {

			@Override
			public String get(CacheHoursJSON cacheHoursJSON) {
				return cacheHoursJSON.getStopCode();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<CacheHoursJSON> getTypeClass() {
				return CacheHoursJSON.class;
			}

		};
	public static final Accessor<CacheHoursJSON, Integer> TYPE_ACCESSOR =
		new Accessor<CacheHoursJSON, Integer>() {

			@Override
			public Integer get(CacheHoursJSON cacheHoursJSON) {
				return cacheHoursJSON.getType();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<CacheHoursJSON> getTypeClass() {
				return CacheHoursJSON.class;
			}

		};

}