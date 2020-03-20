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

package eu.strasbourg.service.interest.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the UserInterest service. Represents a row in the &quot;interest_UserInterest&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see UserInterestModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.interest.model.impl.UserInterestImpl"
)
@ProviderType
public interface UserInterest extends PersistedModel, UserInterestModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.interest.model.impl.UserInterestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<UserInterest, Long> INTEREST_ID_ACCESSOR =
		new Accessor<UserInterest, Long>() {

			@Override
			public Long get(UserInterest userInterest) {
				return userInterest.getInterestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<UserInterest> getTypeClass() {
				return UserInterest.class;
			}

		};
	public static final Accessor<UserInterest, String> PUBLIK_USER_ID_ACCESSOR =
		new Accessor<UserInterest, String>() {

			@Override
			public String get(UserInterest userInterest) {
				return userInterest.getPublikUserId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<UserInterest> getTypeClass() {
				return UserInterest.class;
			}

		};

	public eu.strasbourg.service.interest.model.Interest getInterest();

}