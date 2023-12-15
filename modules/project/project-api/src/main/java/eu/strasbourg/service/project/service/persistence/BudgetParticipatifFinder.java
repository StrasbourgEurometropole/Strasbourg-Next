/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Cedric Henry
 * @generated
 */
@ProviderType
public interface BudgetParticipatifFinder {

	public java.util.List
		<eu.strasbourg.service.project.model.BudgetParticipatif>
			findByStatusAndActivePhaseAndGroupId(int status, long groupId);

}