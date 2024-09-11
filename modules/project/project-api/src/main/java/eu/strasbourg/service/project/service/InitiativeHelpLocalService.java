/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.project.model.InitiativeHelp;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for InitiativeHelp. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see InitiativeHelpLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.project.model.InitiativeHelp"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface InitiativeHelpLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.InitiativeHelpLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the initiative help local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link InitiativeHelpLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the initiative help to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public InitiativeHelp addInitiativeHelp(InitiativeHelp initiativeHelp);

	/**
	 * Creates a new initiative help with the primary key. Does not add the initiative help to the database.
	 *
	 * @param initiativeHelpId the primary key for the new initiative help
	 * @return the new initiative help
	 */
	@Transactional(enabled = false)
	public InitiativeHelp createInitiativeHelp(long initiativeHelpId);

	/**
	 * Methode de creation d'une initiative
	 *
	 * @param sc Le contexte de la requete.
	 * @return L'aide cree.
	 */
	public InitiativeHelp createInitiativeHelp(ServiceContext sc);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the initiative help from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public InitiativeHelp deleteInitiativeHelp(InitiativeHelp initiativeHelp);

	/**
	 * Deletes the initiative help with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help that was removed
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public InitiativeHelp deleteInitiativeHelp(long initiativeHelpId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
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
	public InitiativeHelp fetchInitiativeHelp(long initiativeHelpId);

	/**
	 * Returns the initiative help matching the UUID and group.
	 *
	 * @param uuid the initiative help's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative help, or <code>null</code> if a matching initiative help could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InitiativeHelp fetchInitiativeHelpByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne la liste des aides d'une initiative
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InitiativeHelp> getByInitiativeId(long initiativeId);

	/**
	 * Retourne les aides proposees par un utilisateur
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InitiativeHelp> getByPublikUserId(String publikUserId);

	/**
	 * Retourne l'aide proposee par un utilisateur pour une initiative donnee
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InitiativeHelp getByPublikUserIdAndInitiativeId(
		String publikUserId, long initiativeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the initiative help with the primary key.
	 *
	 * @param initiativeHelpId the primary key of the initiative help
	 * @return the initiative help
	 * @throws PortalException if a initiative help with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InitiativeHelp getInitiativeHelp(long initiativeHelpId)
		throws PortalException;

	/**
	 * Returns the initiative help matching the UUID and group.
	 *
	 * @param uuid the initiative help's UUID
	 * @param groupId the primary key of the group
	 * @return the matching initiative help
	 * @throws PortalException if a matching initiative help could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public InitiativeHelp getInitiativeHelpByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the initiative helps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.InitiativeHelpModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of initiative helps
	 * @param end the upper bound of the range of initiative helps (not inclusive)
	 * @return the range of initiative helps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<InitiativeHelp> getInitiativeHelps(int start, int end);

	/**
	 * Returns the number of initiative helps.
	 *
	 * @return the number of initiative helps
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getInitiativeHelpsCount();

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
	 * Supprimer un soutien donne
	 *
	 * @param initiativeHelpId Id de l'aide inititative
	 */
	public InitiativeHelp removeInitiativeHelp(long initiativeHelpId);

	/**
	 * Updates the initiative help in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect InitiativeHelpLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param initiativeHelp the initiative help
	 * @return the initiative help that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public InitiativeHelp updateInitiativeHelp(InitiativeHelp initiativeHelp);

}