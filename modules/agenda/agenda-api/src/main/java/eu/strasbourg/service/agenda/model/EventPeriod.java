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
 * The extended model interface for the EventPeriod service. Represents a row in the &quot;agenda_EventPeriod&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see EventPeriodModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.agenda.model.impl.EventPeriodImpl"
)
@ProviderType
public interface EventPeriod extends EventPeriodModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.EventPeriodImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<EventPeriod, Long> EVENT_PERIOD_ID_ACCESSOR =
		new Accessor<EventPeriod, Long>() {

			@Override
			public Long get(EventPeriod eventPeriod) {
				return eventPeriod.getEventPeriodId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<EventPeriod> getTypeClass() {
				return EventPeriod.class;
			}

		};

	/**
	 * Si endDate = startDate OU
	 * Si (endDate = startDate + 1 ET endTime < startTime ET endTime ≤ 8H du matin) OU
	 * Si (endDate > startDate + 1 ET endDate - startDate <=5)
	 *  -> Le date/horaire (N fois)
	 * Sinon
	 * 	-> Du date[/heure de début] au date[/heure de début]/heure de fin
	 */
	public java.util.List<String> getDisplay(java.util.Locale locale);

	public String getDisplay(
		java.util.Locale locale, boolean dispYear, boolean dispShortMonth);

	/**
	 * Retourne la liste des dates
	 * 		pour une période non récurrente :
	 * 		- firstDate + startTime
	 * 		- toutes les autres dates à minuit
	 *
	 * 		pour une période récurrente :
	 * 		- toutes les dates à startTime
	 * 		- si endTime < startTime => ajouter endDate+1j à minuit
	 *
	 * 	Si pas de startTime -> minuit
	 *
	 * 	Utilisé pour l'indexer
	 */
	public java.util.List<java.util.Date> getDays();

	/**
	 * Retourne la vrai endDate :
	 * Si la période est récurrente et que endTime < startTime => endDate + 1
	 * Sinon endDate
	 */
	public java.util.Date getCalculateEndDate();

}