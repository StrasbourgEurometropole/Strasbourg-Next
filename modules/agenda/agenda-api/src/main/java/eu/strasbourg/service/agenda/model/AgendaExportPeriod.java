/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AgendaExportPeriod service. Represents a row in the &quot;agenda_AgendaExportPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see AgendaExportPeriodModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodImpl"
)
@ProviderType
public interface AgendaExportPeriod
	extends AgendaExportPeriodModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.AgendaExportPeriodImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AgendaExportPeriod, Long>
		AGENDA_EXPORT_PERIOD_ID_ACCESSOR =
			new Accessor<AgendaExportPeriod, Long>() {

				@Override
				public Long get(AgendaExportPeriod agendaExportPeriod) {
					return agendaExportPeriod.getAgendaExportPeriodId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AgendaExportPeriod> getTypeClass() {
					return AgendaExportPeriod.class;
				}

			};

}