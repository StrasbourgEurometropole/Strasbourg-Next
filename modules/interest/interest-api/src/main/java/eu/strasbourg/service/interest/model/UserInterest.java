/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.interest.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

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

	public Interest getInterest();

}