/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.model.impl;

import eu.strasbourg.service.search.log.model.SearchLog;
import eu.strasbourg.service.search.log.service.SearchLogLocalServiceUtil;

/**
 * The extended model base implementation for the SearchLog service. Represents a row in the &quot;search_SearchLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SearchLogImpl}.
 * </p>
 *
 * @author BenjaminBini
 * @see SearchLogImpl
 * @see SearchLog
 * @generated
 */
public abstract class SearchLogBaseImpl
	extends SearchLogModelImpl implements SearchLog {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a search log model instance should use the <code>SearchLog</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			SearchLogLocalServiceUtil.addSearchLog(this);
		}
		else {
			SearchLogLocalServiceUtil.updateSearchLog(this);
		}
	}

}