/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the SearchLog service. Represents a row in the &quot;search_SearchLog&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see SearchLogModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.search.log.model.impl.SearchLogImpl"
)
@ProviderType
public interface SearchLog extends PersistedModel, SearchLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.search.log.model.impl.SearchLogImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<SearchLog, Long> SEARCH_LOG_ID_ACCESSOR =
		new Accessor<SearchLog, Long>() {

			@Override
			public Long get(SearchLog searchLog) {
				return searchLog.getSearchLogId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<SearchLog> getTypeClass() {
				return SearchLog.class;
			}

		};

}