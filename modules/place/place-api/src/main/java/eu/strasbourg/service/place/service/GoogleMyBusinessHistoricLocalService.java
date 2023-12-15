/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.place.service;

import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.petra.sql.dsl.query.DSLQuery;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import eu.strasbourg.service.place.model.GoogleMyBusinessHistoric;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for GoogleMyBusinessHistoric. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Angelique Zunino Champougny
 * @see GoogleMyBusinessHistoricLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.place.model.GoogleMyBusinessHistoric"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface GoogleMyBusinessHistoricLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.place.service.impl.GoogleMyBusinessHistoricLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the google my business historic local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link GoogleMyBusinessHistoricLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the google my business historic to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public GoogleMyBusinessHistoric addGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric);

	/**
	 * Creates a new google my business historic with the primary key. Does not add the google my business historic to the database.
	 *
	 * @param googleMyBusinessHistoricId the primary key for the new google my business historic
	 * @return the new google my business historic
	 */
	@Transactional(enabled = false)
	public GoogleMyBusinessHistoric createGoogleMyBusinessHistoric(
		long googleMyBusinessHistoricId);

	/**
	 * Crée une entrée googleMyBusiness vide avec une PK, non ajouté à la base de donnée
	 */
	public GoogleMyBusinessHistoric createGoogleMyBusinessHistoric(
			ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the google my business historic from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public GoogleMyBusinessHistoric deleteGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric);

	/**
	 * Deletes the google my business historic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic that was removed
	 * @throws PortalException if a google my business historic with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public GoogleMyBusinessHistoric deleteGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Effectue la synchronisation
	 */
	public void doSynchronisation(
		ServiceContext sc, GoogleMyBusinessHistoric googleMyBusinessHistoric);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
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
	public GoogleMyBusinessHistoric fetchGoogleMyBusinessHistoric(
		long googleMyBusinessHistoricId);

	/**
	 * Returns the google my business historic matching the UUID and group.
	 *
	 * @param uuid the google my business historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching google my business historic, or <code>null</code> if a matching google my business historic could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GoogleMyBusinessHistoric
		fetchGoogleMyBusinessHistoricByUuidAndGroupId(
			String uuid, long groupId);

	/**
	 * Recherche par mot clés
	 */
	public List<GoogleMyBusinessHistoric> findByKeyword(
		String keyword, long groupId, int start, int end);

	/**
	 * Recherche par mot clés (compte)
	 */
	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Renvoie la liste des vocabulaires rattachés à google mybusiness
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne tous les google mybusiness d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GoogleMyBusinessHistoric> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	/**
	 * Returns the google my business historic with the primary key.
	 *
	 * @param googleMyBusinessHistoricId the primary key of the google my business historic
	 * @return the google my business historic
	 * @throws PortalException if a google my business historic with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GoogleMyBusinessHistoric getGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException;

	/**
	 * Returns the google my business historic matching the UUID and group.
	 *
	 * @param uuid the google my business historic's UUID
	 * @param groupId the primary key of the group
	 * @return the matching google my business historic
	 * @throws PortalException if a matching google my business historic could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public GoogleMyBusinessHistoric getGoogleMyBusinessHistoricByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the google my business historics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.place.model.impl.GoogleMyBusinessHistoricModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @return the range of google my business historics
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GoogleMyBusinessHistoric> getGoogleMyBusinessHistorics(
		int start, int end);

	/**
	 * Returns all the google my business historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the google my business historics
	 * @param companyId the primary key of the company
	 * @return the matching google my business historics, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GoogleMyBusinessHistoric>
		getGoogleMyBusinessHistoricsByUuidAndCompanyId(
			String uuid, long companyId);

	/**
	 * Returns a range of google my business historics matching the UUID and company.
	 *
	 * @param uuid the UUID of the google my business historics
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of google my business historics
	 * @param end the upper bound of the range of google my business historics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching google my business historics, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<GoogleMyBusinessHistoric>
		getGoogleMyBusinessHistoricsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			OrderByComparator<GoogleMyBusinessHistoric> orderByComparator);

	/**
	 * Returns the number of google my business historics.
	 *
	 * @return the number of google my business historics
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getGoogleMyBusinessHistoricsCount();

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
	 * Supprime l'entree google mybusiness
	 */
	public GoogleMyBusinessHistoric removeGoogleMyBusinessHistoric(
			long googleMyBusinessHistoricId)
		throws PortalException;

	/**
	 * Updates the google my business historic in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect GoogleMyBusinessHistoricLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param googleMyBusinessHistoric the google my business historic
	 * @return the google my business historic that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public GoogleMyBusinessHistoric updateGoogleMyBusinessHistoric(
		GoogleMyBusinessHistoric googleMyBusinessHistoric);

	/**
	 * Met à jour une entree google mybusiness et l'enregistre en base de données
	 *
	 * @throws PortalException
	 */
	public GoogleMyBusinessHistoric updateGoogleMyBusinessHistoric(
			GoogleMyBusinessHistoric googleMyBusinessHistoric,
			ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entree google mybusiness "manuellement" (pas via le workflow)
	 */
	public void updateStatus(
			GoogleMyBusinessHistoric googleMyBusinessHistoric, int status)
		throws PortalException;

	/**
	 * Met à jour le statut de l'entree google mybusiness par le framework workflow
	 */
	public GoogleMyBusinessHistoric updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}