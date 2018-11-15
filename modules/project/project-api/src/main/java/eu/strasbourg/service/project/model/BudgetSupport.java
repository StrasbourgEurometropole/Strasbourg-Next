/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the BudgetSupport service. Represents a row in the &quot;project_BudgetSupport&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see BudgetSupportModel
 * @see eu.strasbourg.service.project.model.impl.BudgetSupportImpl
 * @see eu.strasbourg.service.project.model.impl.BudgetSupportModelImpl
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.project.model.impl.BudgetSupportImpl")
@ProviderType
public interface BudgetSupport extends BudgetSupportModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link eu.strasbourg.service.project.model.impl.BudgetSupportImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<BudgetSupport, Long> BUDGET_SUPPORT_ID_ACCESSOR =
		new Accessor<BudgetSupport, Long>() {
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