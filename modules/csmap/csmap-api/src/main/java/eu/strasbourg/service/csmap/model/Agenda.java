/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.csmap.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Agenda service. Represents a row in the &quot;csmap_Agenda&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AgendaModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.csmap.model.impl.AgendaImpl")
@ProviderType
public interface Agenda extends AgendaModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.csmap.model.impl.AgendaImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Agenda, Long> AGENDA_ID_ACCESSOR =
		new Accessor<Agenda, Long>() {

			@Override
			public Long get(Agenda agenda) {
				return agenda.getAgendaId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Agenda> getTypeClass() {
				return Agenda.class;
			}

		};

}