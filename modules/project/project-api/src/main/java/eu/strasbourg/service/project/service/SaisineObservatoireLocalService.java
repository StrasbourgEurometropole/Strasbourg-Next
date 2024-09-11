/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

import static eu.strasbourg.service.project.constants.ParticiperCategories.*;

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

import eu.strasbourg.service.project.model.SaisineObservatoire;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for SaisineObservatoire. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see SaisineObservatoireLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.project.model.SaisineObservatoire"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SaisineObservatoireLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.SaisineObservatoireLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the saisine observatoire local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SaisineObservatoireLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the saisine observatoire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SaisineObservatoire addSaisineObservatoire(
		SaisineObservatoire saisineObservatoire);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new saisine observatoire with the primary key. Does not add the saisine observatoire to the database.
	 *
	 * @param saisineObservatoireId the primary key for the new saisine observatoire
	 * @return the new saisine observatoire
	 */
	@Transactional(enabled = false)
	public SaisineObservatoire createSaisineObservatoire(
		long saisineObservatoireId);

	/**
	 * Crée une saisine vide avec une PK, non ajouté à la base de donnée
	 */
	public SaisineObservatoire createSaisineObservatoire(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the saisine observatoire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire that was removed
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public SaisineObservatoire deleteSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException;

	/**
	 * Deletes the saisine observatoire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public SaisineObservatoire deleteSaisineObservatoire(
		SaisineObservatoire saisineObservatoire);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
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
	public SaisineObservatoire fetchSaisineObservatoire(
		long saisineObservatoireId);

	public List<SaisineObservatoire> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SaisineObservatoire> getByPublikUserID(String publikId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

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
	 * Retourne toutes les saisines publiées d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SaisineObservatoire> getPublishedByGroupId(long groupId);

	/**
	 * Returns the saisine observatoire with the primary key.
	 *
	 * @param saisineObservatoireId the primary key of the saisine observatoire
	 * @return the saisine observatoire
	 * @throws PortalException if a saisine observatoire with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public SaisineObservatoire getSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException;

	/**
	 * Returns a range of all the saisine observatoires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SaisineObservatoireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of saisine observatoires
	 * @param end the upper bound of the range of saisine observatoires (not inclusive)
	 * @return the range of saisine observatoires
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SaisineObservatoire> getSaisineObservatoires(
		int start, int end);

	/**
	 * Returns the number of saisine observatoires.
	 *
	 * @return the number of saisine observatoires
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSaisineObservatoiresCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<SaisineObservatoire> getTheMostCommented(long groupId);

	/**
	 * Supprime une saisine
	 */
	public SaisineObservatoire removeSaisineObservatoire(
			long saisineObservatoireId)
		throws PortalException;

	public void updateAllSaisineObservatoireStatus() throws PortalException;

	/**
	 * Updates the saisine observatoire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SaisineObservatoireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param saisineObservatoire the saisine observatoire
	 * @return the saisine observatoire that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public SaisineObservatoire updateSaisineObservatoire(
		SaisineObservatoire saisineObservatoire);

	public SaisineObservatoire updateSaisineObservatoire(
			SaisineObservatoire saisineObservatoire, ServiceContext sc)
		throws PortalException;

}