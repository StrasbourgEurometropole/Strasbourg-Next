/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.agenda.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for EventParticipation. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author BenjaminBini
 * @see EventParticipationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=agenda",
		"json.web.service.context.path=EventParticipation"
	},
	service = EventParticipationService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EventParticipationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.agenda.service.impl.EventParticipationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the event participation remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EventParticipationServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Ajoute une participation à un utilisateur
	 */
	public JSONObject addEventParticipationLink(long eventId, long groupId);

	/**
	 * Supprime une participation d'evenement d'un utilisateur
	 */
	public JSONObject deleteEventParticipationLink(long eventId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Retourne les participation d'evenement d'un utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getUserEventParticipations(String userId);

	/**
	 * Verifie si l'utilisateur courant participe a l'evenement
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject isUserParticipates(long eventId);

}