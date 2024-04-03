/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link BudgetPhaseService}.
 *
 * @author Cedric Henry
 * @see BudgetPhaseService
 * @generated
 */
public class BudgetPhaseServiceWrapper
	implements BudgetPhaseService, ServiceWrapper<BudgetPhaseService> {

	public BudgetPhaseServiceWrapper() {
		this(null);
	}

	public BudgetPhaseServiceWrapper(BudgetPhaseService budgetPhaseService) {
		_budgetPhaseService = budgetPhaseService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _budgetPhaseService.getOSGiServiceIdentifier();
	}

	@Override
	public BudgetPhaseService getWrappedService() {
		return _budgetPhaseService;
	}

	@Override
	public void setWrappedService(BudgetPhaseService budgetPhaseService) {
		_budgetPhaseService = budgetPhaseService;
	}

	private BudgetPhaseService _budgetPhaseService;

}