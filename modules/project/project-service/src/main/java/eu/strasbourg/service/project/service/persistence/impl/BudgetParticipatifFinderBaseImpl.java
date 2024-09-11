/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Cedric Henry
 * @generated
 */
public class BudgetParticipatifFinderBaseImpl
	extends BasePersistenceImpl<BudgetParticipatif> {

	public BudgetParticipatifFinderBaseImpl() {
		setModelClass(BudgetParticipatif.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getBudgetParticipatifPersistence().getBadColumnNames();
	}

	/**
	 * Returns the budget participatif persistence.
	 *
	 * @return the budget participatif persistence
	 */
	public BudgetParticipatifPersistence getBudgetParticipatifPersistence() {
		return budgetParticipatifPersistence;
	}

	/**
	 * Sets the budget participatif persistence.
	 *
	 * @param budgetParticipatifPersistence the budget participatif persistence
	 */
	public void setBudgetParticipatifPersistence(
		BudgetParticipatifPersistence budgetParticipatifPersistence) {

		this.budgetParticipatifPersistence = budgetParticipatifPersistence;
	}

	@BeanReference(type = BudgetParticipatifPersistence.class)
	protected BudgetParticipatifPersistence budgetParticipatifPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		BudgetParticipatifFinderBaseImpl.class);

}