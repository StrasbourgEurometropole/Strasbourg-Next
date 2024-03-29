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

package eu.strasbourg.service.project.model.impl;

import eu.strasbourg.service.project.model.Initiative;
import eu.strasbourg.service.project.service.InitiativeLocalServiceUtil;

/**
 * The extended model base implementation for the Initiative service. Represents a row in the &quot;project_Initiative&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link InitiativeImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see InitiativeImpl
 * @see Initiative
 * @generated
 */
public abstract class InitiativeBaseImpl
	extends InitiativeModelImpl implements Initiative {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a initiative model instance should use the <code>Initiative</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			InitiativeLocalServiceUtil.addInitiative(this);
		}
		else {
			InitiativeLocalServiceUtil.updateInitiative(this);
		}
	}

}