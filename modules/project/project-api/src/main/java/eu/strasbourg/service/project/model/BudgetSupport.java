/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the BudgetSupport service. Represents a row in the &quot;project_BudgetSupport&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see BudgetSupportModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.BudgetSupportImpl"
)
@ProviderType
public interface BudgetSupport extends BudgetSupportModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.BudgetSupportImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BudgetSupport, Long>
		BUDGET_SUPPORT_ID_ACCESSOR = new Accessor<BudgetSupport, Long>() {

			@Override
			public Long get(BudgetSupport budgetSupport) {
				return budgetSupport.getBudgetSupportId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<BudgetSupport> getTypeClass() {
				return BudgetSupport.class;
			}

		};

}