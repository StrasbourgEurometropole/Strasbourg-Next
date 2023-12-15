/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.service;

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

import eu.strasbourg.service.project.model.Signataire;

import java.io.Serializable;

import java.util.List;

import javax.portlet.PortletException;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Signataire. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Cedric Henry
 * @see SignataireLocalServiceUtil
 * @generated
 */
@OSGiBeanProperties(
	property = {
		"model.class.name=eu.strasbourg.service.project.model.Signataire"
	}
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface SignataireLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.project.service.impl.SignataireLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the signataire local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link SignataireLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the signataire to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Signataire addSignataire(Signataire signataire);

	/**
	 * méthode permettant de compter le nombre de faux signataire
	 *
	 * @param petitionId la pétition concernée
	 * @return le nombre de signataires
	 */
	public int countFakeSignataireByPetition(long petitionId);

	/**
	 * méthode permettant de récuperer les signataires par l'identifiant de la pétition.
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	public int countSignataireByPetitionId(long petitionId);

	/**
	 * méthode de création de faux signataires
	 *
	 * @param petitionId la pétition concernée
	 * @param nombreCreation le nombre de creation souhaité.
	 */
	public void createFakeSignataire(long petitionId, int nombreCreation);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new signataire with the primary key. Does not add the signataire to the database.
	 *
	 * @param signataireId the primary key for the new signataire
	 * @return the new signataire
	 */
	@Transactional(enabled = false)
	public Signataire createSignataire(long signataireId);

	/**
	 * méthode de creation de signataire.
	 *
	 * @param sc le context.
	 * @return le signataire crée.
	 */
	public Signataire createSignataire(ServiceContext sc);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the signataire with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire that was removed
	 * @throws PortalException if a signataire with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Signataire deleteSignataire(long signataireId)
		throws PortalException;

	/**
	 * Deletes the signataire from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Signataire deleteSignataire(Signataire signataire);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
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
	public Signataire fetchSignataire(long signataireId);

	/**
	 * Returns the signataire matching the UUID and group.
	 *
	 * @param uuid the signataire's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signataire, or <code>null</code> if a matching signataire could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Signataire fetchSignataireByUuidAndGroupId(
		String uuid, long groupId);

	public List<Signataire> findSignatairesByPetitionIdAndPublikUserId(
			long petitionId, String publikUserId)
		throws PortletException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * méthode permettant de récuperer tous les signataires par l'identifiant de la pétition y compris les entree anonymes (Signatures papiers)
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getAllSignatairesByPetitionId(long petitionId);

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

	/**
	 * Returns the signataire with the primary key.
	 *
	 * @param signataireId the primary key of the signataire
	 * @return the signataire
	 * @throws PortalException if a signataire with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Signataire getSignataire(long signataireId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getSignataireByPublikId(String publikId);

	/**
	 * Returns the signataire matching the UUID and group.
	 *
	 * @param uuid the signataire's UUID
	 * @param groupId the primary key of the group
	 * @return the matching signataire
	 * @throws PortalException if a matching signataire could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Signataire getSignataireByUuidAndGroupId(String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the signataires.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>eu.strasbourg.service.project.model.impl.SignataireModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @return the range of signataires
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getSignataires(int start, int end);

	/**
	 * méthode permettant de récuperer les signataires par l'identifiant de la pétition. Ne prend pas les entree anonymes (Signatures papiers)
	 *
	 * @param petitionId l'identifiant de la pétition.
	 * @return la liste des signataires.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getSignatairesByPetitionId(long petitionId);

	/**
	 * Returns all the signataires matching the UUID and company.
	 *
	 * @param uuid the UUID of the signataires
	 * @param companyId the primary key of the company
	 * @return the matching signataires, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getSignatairesByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of signataires matching the UUID and company.
	 *
	 * @param uuid the UUID of the signataires
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of signataires
	 * @param end the upper bound of the range of signataires (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching signataires, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Signataire> getSignatairesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Signataire> orderByComparator);

	/**
	 * Returns the number of signataires.
	 *
	 * @return the number of signataires
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getSignatairesCount();

	public void removeSignataire(long signataireId);

	/**
	 * Updates the signataire in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SignataireLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param signataire the signataire
	 * @return the signataire that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Signataire updateSignataire(Signataire signataire);

}