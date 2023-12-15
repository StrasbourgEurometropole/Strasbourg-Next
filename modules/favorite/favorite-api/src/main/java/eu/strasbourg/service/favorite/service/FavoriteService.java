/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.favorite.service;

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
 * Provides the remote service interface for Favorite. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author BenjaminBini
 * @see FavoriteServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=favorite",
		"json.web.service.context.path=Favorite"
	},
	service = FavoriteService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface FavoriteService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.favorite.service.impl.FavoriteServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the favorite remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link FavoriteServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Ajoute un favoris à un utilisateur
	 */
	public JSONObject addFavorite(
		String title, String url, long typeId, String userId, long entityId);

	/**
	 * Ajoute un favori à un utilisateur
	 */
	public JSONObject addFavoriteLink(
		String title, String url, long typeId, long entityId,
		long entityGroupId);

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public JSONObject deleteFavorite(String userId, long favoriteId);

	/**
	 * Supprime un favoris d'un utilisateur
	 */
	public JSONObject deleteFavoriteLink(
		String title, String url, long typeId, long entityId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * Retourne la liste des types de favoris
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getTypes();

	/**
	 * Retourne les favoris d'un utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getUserFavorites(String userId);

}