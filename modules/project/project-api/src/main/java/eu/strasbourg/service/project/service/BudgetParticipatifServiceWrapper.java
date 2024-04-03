/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BudgetParticipatifService}.
 *
 * @author Cedric Henry
 * @see BudgetParticipatifService
 * @generated
 */
public class BudgetParticipatifServiceWrapper
	implements BudgetParticipatifService,
			   ServiceWrapper<BudgetParticipatifService> {

	public BudgetParticipatifServiceWrapper() {
		this(null);
	}

	public BudgetParticipatifServiceWrapper(
		BudgetParticipatifService budgetParticipatifService) {

		_budgetParticipatifService = budgetParticipatifService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _budgetParticipatifService.getOSGiServiceIdentifier();
	}

	@Override
	public BudgetParticipatifService getWrappedService() {
		return _budgetParticipatifService;
	}

	@Override
	public void setWrappedService(
		BudgetParticipatifService budgetParticipatifService) {

		_budgetParticipatifService = budgetParticipatifService;
	}

	private BudgetParticipatifService _budgetParticipatifService;

}