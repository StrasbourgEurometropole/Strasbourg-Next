/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ScheduleException service. Represents a row in the &quot;place_ScheduleException&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angelique Zunino Champougny
 * @see ScheduleExceptionModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.place.model.impl.ScheduleExceptionImpl"
)
@ProviderType
public interface ScheduleException
	extends PersistedModel, ScheduleExceptionModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.place.model.impl.ScheduleExceptionImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ScheduleException, Long>
		EXCEPTION_ID_ACCESSOR = new Accessor<ScheduleException, Long>() {

			@Override
			public Long get(ScheduleException scheduleException) {
				return scheduleException.getExceptionId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ScheduleException> getTypeClass() {
				return ScheduleException.class;
			}

		};

	/**
	 * Retourne la version JSON des exceptions
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

	/**
	 * Retourne la version CSMap JSON des exceptions
	 */
	public com.liferay.portal.kernel.json.JSONObject toCSMapJSON();

	/**
	 * Retourne la liste des horaires d'ouvertures d'une exception
	 */
	public java.util.List
		<eu.strasbourg.utils.models.Pair
			<java.time.LocalTime, java.time.LocalTime>> getOpeningLocalTimes();

	/**
	 * Retourne la Nème heure de début
	 */
	public java.time.LocalTime getStartHour(int index);

	/**
	 * Retourne la Nème heure de début
	 */
	public java.time.LocalTime getEndHour(int index);

	/**
	 * Retourne liste des commentaires
	 */
	public String[] getComments();

}