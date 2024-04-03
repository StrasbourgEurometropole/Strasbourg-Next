/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service.persistence.impl;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;

import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.service.persistence.EventPersistence;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author BenjaminBini
 * @generated
 */
public class EventFinderBaseImpl extends BasePersistenceImpl<Event> {

	public EventFinderBaseImpl() {
		setModelClass(Event.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("access", "access_");

		setDBColumnNames(dbColumnNames);
	}

	@Override
	public Set<String> getBadColumnNames() {
		return getEventPersistence().getBadColumnNames();
	}

	/**
	 * Returns the event persistence.
	 *
	 * @return the event persistence
	 */
	public EventPersistence getEventPersistence() {
		return eventPersistence;
	}

	/**
	 * Sets the event persistence.
	 *
	 * @param eventPersistence the event persistence
	 */
	public void setEventPersistence(EventPersistence eventPersistence) {
		this.eventPersistence = eventPersistence;
	}

	@BeanReference(type = EventPersistence.class)
	protected EventPersistence eventPersistence;

	private static final Log _log = LogFactoryUtil.getLog(
		EventFinderBaseImpl.class);

}