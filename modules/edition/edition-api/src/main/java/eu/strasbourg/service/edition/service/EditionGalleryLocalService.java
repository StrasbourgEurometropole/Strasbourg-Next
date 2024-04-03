/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.edition.service;

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
import com.liferay.portal.kernel.search.Hits;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import eu.strasbourg.service.edition.model.EditionGallery;

import java.io.Serializable;

import java.util.List;
import java.util.Map;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for EditionGallery. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author BenjaminBini
 * @see EditionGalleryLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.edition.model.EditionGallery"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface EditionGalleryLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.edition.service.impl.EditionGalleryLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the edition gallery local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link EditionGalleryLocalServiceUtil} if injection and service tracking are not available.
	 */
	public boolean addEditionEditionGalleries(
		long editionId, List<EditionGallery> editionGalleries);

	public boolean addEditionEditionGalleries(
		long editionId, long[] galleryIds);

	public boolean addEditionEditionGallery(
		long editionId, EditionGallery editionGallery);

	public boolean addEditionEditionGallery(long editionId, long galleryId);

	/**
	 * Adds the edition gallery to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EditionGallery addEditionGallery(EditionGallery editionGallery);

	/**
	 * Modifie le statut de toutes les galeries au statut "SCHEDULED" qui ont
	 * une date de publication dans le futur
	 */
	public void checkGalleries() throws PortalException;

	public void clearEditionEditionGalleries(long editionId);

	/**
	 * Creates a new edition gallery with the primary key. Does not add the edition gallery to the database.
	 *
	 * @param galleryId the primary key for the new edition gallery
	 * @return the new edition gallery
	 */
	@Transactional(enabled = false)
	public EditionGallery createEditionGallery(long galleryId);

	/**
	 * Crée un lien vide avec une PK, non ajouté à la base de donnée
	 */
	public EditionGallery createEditionGallery(ServiceContext sc)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public void deleteEditionEditionGalleries(
		long editionId, List<EditionGallery> editionGalleries);

	public void deleteEditionEditionGalleries(
		long editionId, long[] galleryIds);

	public void deleteEditionEditionGallery(
		long editionId, EditionGallery editionGallery);

	public void deleteEditionEditionGallery(long editionId, long galleryId);

	/**
	 * Deletes the edition gallery from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public EditionGallery deleteEditionGallery(EditionGallery editionGallery);

	/**
	 * Deletes the edition gallery with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery that was removed
	 * @throws PortalException if a edition gallery with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public EditionGallery deleteEditionGallery(long galleryId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
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
	public EditionGallery fetchEditionGallery(long galleryId);

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery, or <code>null</code> if a matching edition gallery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EditionGallery fetchEditionGalleryByUuidAndGroupId(
		String uuid, long groupId);

	public List<EditionGallery> findByKeyword(
		String keyword, long groupId, int start, int end);

	public long findByKeywordCount(String keyword, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Retourne les vocabulaires rattrachés à ce type d'entité pour un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AssetVocabulary> getAttachedVocabularies(long groupId);

	/**
	 * Retourne toutes les galeries editions d'un groupe
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getByGroupId(long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionEditionGalleries(long editionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionEditionGalleries(
		long editionId, int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionEditionGalleries(
		long editionId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEditionEditionGalleriesCount(long editionId);

	/**
	 * Returns a range of all the edition galleries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.edition.model.impl.EditionGalleryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @return the range of edition galleries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionGalleries(int start, int end);

	/**
	 * Returns all the edition galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the edition galleries
	 * @param companyId the primary key of the company
	 * @return the matching edition galleries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionGalleriesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of edition galleries matching the UUID and company.
	 *
	 * @param uuid the UUID of the edition galleries
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of edition galleries
	 * @param end the upper bound of the range of edition galleries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching edition galleries, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<EditionGallery> getEditionGalleriesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<EditionGallery> orderByComparator);

	/**
	 * Returns the number of edition galleries.
	 *
	 * @return the number of edition galleries
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getEditionGalleriesCount();

	/**
	 * Returns the edition gallery with the primary key.
	 *
	 * @param galleryId the primary key of the edition gallery
	 * @return the edition gallery
	 * @throws PortalException if a edition gallery with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EditionGallery getEditionGallery(long galleryId)
		throws PortalException;

	/**
	 * Returns the edition gallery matching the UUID and group.
	 *
	 * @param uuid the edition gallery's UUID
	 * @param groupId the primary key of the group
	 * @return the matching edition gallery
	 * @throws PortalException if a matching edition gallery could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public EditionGallery getEditionGalleryByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns the editionIds of the editions associated with the edition gallery.
	 *
	 * @param galleryId the galleryId of the edition gallery
	 * @return long[] the editionIds of editions associated with the edition gallery
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long[] getEditionPrimaryKeys(long galleryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEditionEditionGalleries(long editionId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEditionEditionGallery(long editionId, long galleryId);

	/**
	 * Supprime une galerie
	 */
	public EditionGallery removeGallery(long galleryId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Hits search(SearchContext searchContext) throws SearchException;

	public void setEditionEditionGalleries(long editionId, long[] galleryIds);

	/**
	 * Updates the edition gallery in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect EditionGalleryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param editionGallery the edition gallery
	 * @return the edition gallery that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public EditionGallery updateEditionGallery(EditionGallery editionGallery);

	/**
	 * Met à jour un lien et l'enregistre en base de données
	 */
	public EditionGallery updateEditionGallery(
			EditionGallery gallery, ServiceContext sc)
		throws PortalException;

	/**
	 * Met à jour le statut de la galerie "manuellement" (pas via le workflow)
	 */
	public void updateStatus(EditionGallery gallery, int status)
		throws PortalException;

	/**
	 * Met à jour le statut de la galerie par le framework workflow
	 */
	public EditionGallery updateStatus(
			long userId, long entryId, int status, ServiceContext sc,
			Map<String, Serializable> workflowContext)
		throws PortalException;

}