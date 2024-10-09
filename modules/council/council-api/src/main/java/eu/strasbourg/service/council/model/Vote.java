/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.council.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Vote service. Represents a row in the &quot;council_Vote&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see VoteModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.council.model.impl.VoteImpl")
@ProviderType
public interface Vote extends PersistedModel, VoteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.council.model.impl.VoteImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Vote, Long> OFFICIAL_ID_ACCESSOR =
		new Accessor<Vote, Long>() {

			@Override
			public Long get(Vote vote) {
				return vote.getOfficialId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Vote> getTypeClass() {
				return Vote.class;
			}

		};
	public static final Accessor<Vote, Long> DELIBERATION_ID_ACCESSOR =
		new Accessor<Vote, Long>() {

			@Override
			public Long get(Vote vote) {
				return vote.getDeliberationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Vote> getTypeClass() {
				return Vote.class;
			}

		};

	/**
	 * Renvoie l'élu à qui appartient le vote
	 */
	public Official getOfficial();

	/**
	 * Renvoie le nom complet de l'élu à qui appartient le vote
	 */
	public String getOfficialFullName();

	/**
	 * Renvoie l'élu qui a voté par procuration
	 */
	public Official getOfficialProcuration();

	/**
	 * Renvoie le nom complet de l'élu l'élu qui a voté par procuration
	 */
	public String getgetOfficialProcurationFullName();

}