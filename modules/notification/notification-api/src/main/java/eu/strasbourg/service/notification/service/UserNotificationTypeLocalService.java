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

package eu.strasbourg.service.notification.service;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import eu.strasbourg.service.notification.model.UserNotificationType;
import eu.strasbourg.service.notification.service.persistence.UserNotificationTypePK;
import eu.strasbourg.service.oidc.model.PublikUser;
import org.osgi.annotation.versioning.ProviderType;

import java.io.Serializable;
import java.util.List;

/**
 * Provides the local service interface for UserNotificationType. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author BenjaminBini
 * @see UserNotificationTypeLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface UserNotificationTypeLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.notification.service.impl.UserNotificationTypeLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the user notification type local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link UserNotificationTypeLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the user notification type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserNotificationType addUserNotificationType(
		UserNotificationType userNotificationType);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new user notification type with the primary key. Does not add the user notification type to the database.
	 *
	 * @param userNotificationTypePK the primary key for the new user notification type
	 * @return the new user notification type
	 */
	@Transactional(enabled = false)
	public UserNotificationType createUserNotificationType(
		UserNotificationTypePK userNotificationTypePK);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the user notification type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserNotificationType deleteUserNotificationType(
		UserNotificationType userNotificationType);

	/**
	 * Deletes the user notification type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type that was removed
	 * @throws PortalException if a user notification type with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public UserNotificationType deleteUserNotificationType(
			UserNotificationTypePK userNotificationTypePK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> T dslQuery(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int dslQueryCount(DSLQuery dslQuery);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserNotificationType fetchUserNotificationType(
		UserNotificationTypePK userNotificationTypePK);

	/**
	 * Retourne la liste des statuts de notification pour un utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserNotificationType> getByPublikUserId(String publikUserId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the user notification type with the primary key.
	 *
	 * @param userNotificationTypePK the primary key of the user notification type
	 * @return the user notification type
	 * @throws PortalException if a user notification type with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public UserNotificationType getUserNotificationType(
			UserNotificationTypePK userNotificationTypePK)
		throws PortalException;

	/**
	 * Returns a range of all the user notification types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.notification.model.impl.UserNotificationTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user notification types
	 * @param end the upper bound of the range of user notification types (not inclusive)
	 * @return the range of user notification types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<UserNotificationType> getUserNotificationTypes(
		int start, int end);

	/**
	 * Retourne la liste des types de notifications auxquels l'utilisateur est
	 * abonné
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetCategory> getUserNotificationTypes(String publikUserId);

	/**
	 * Returns the number of user notification types.
	 *
	 * @return the number of user notification types
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getUserNotificationTypesCount();

	/**
	 * Retourne la liste des utilisateurs abonnés à un type de notification
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PublikUser> getUsersSubscribedToType(long typeId);

	/**
	 * Retourne true si l'utilisateur est abonné au type passé en paramètre
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isUserSubscribedToType(String publikUserId, long typeId);

	/**
	 * Remplace les abonnement existant de l'utilisateur par des nouveaux
	 */
	public void replaceUserSubscriptions(
		String publikUserId, List<AssetCategory> types);

	/**
	 * Updates the user notification type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect UserNotificationTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param userNotificationType the user notification type
	 * @return the user notification type that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public UserNotificationType updateUserNotificationType(
		UserNotificationType userNotificationType);

}