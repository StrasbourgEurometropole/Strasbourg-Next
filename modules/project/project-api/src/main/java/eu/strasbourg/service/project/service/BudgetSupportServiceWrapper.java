/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BudgetSupportService}.
 *
 * @author Cedric Henry
 * @see BudgetSupportService
 * @generated
 */
public class BudgetSupportServiceWrapper
	implements BudgetSupportService, ServiceWrapper<BudgetSupportService> {

	public BudgetSupportServiceWrapper() {
		this(null);
	}

	public BudgetSupportServiceWrapper(
		BudgetSupportService budgetSupportService) {

		_budgetSupportService = budgetSupportService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _budgetSupportService.getOSGiServiceIdentifier();
	}

	@Override
	public BudgetSupportService getWrappedService() {
		return _budgetSupportService;
	}

	@Override
	public void setWrappedService(BudgetSupportService budgetSupportService) {
		_budgetSupportService = budgetSupportService;
	}

	private BudgetSupportService _budgetSupportService;

}