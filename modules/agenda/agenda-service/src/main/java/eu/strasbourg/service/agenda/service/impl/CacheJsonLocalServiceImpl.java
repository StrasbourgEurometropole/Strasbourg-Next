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

package eu.strasbourg.service.agenda.service.impl;

import eu.strasbourg.service.agenda.model.CacheJson;
import eu.strasbourg.service.agenda.service.base.CacheJsonLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the cache json local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.agenda.service.CacheJsonLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author BenjaminBini
 * @see CacheJsonLocalServiceBaseImpl
 */
public class CacheJsonLocalServiceImpl extends CacheJsonLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>eu.strasbourg.service.agenda.service.CacheJsonLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.agenda.service.CacheJsonLocalServiceUtil</code>.
	 */

	/**
	 * Retourne le cache d'un event s'il est approuvé sinon null
	 */
	@Override
	public CacheJson getByEventIdAndIsApproved(long eventId) {
		return this.cacheJsonPersistence.fetchByeventIdAndIsApproved(eventId, true);
	}

	/**
	 * Retourne la list  cache d'un event s'il est approuvé sinon envoi une erreur
	 */
	@Override
	public List<CacheJson> getAllIsApproved() {
		return this.cacheJsonPersistence.findByisApproved(true);
	}
}