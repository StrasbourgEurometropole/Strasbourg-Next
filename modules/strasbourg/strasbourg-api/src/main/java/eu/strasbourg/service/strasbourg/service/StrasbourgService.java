/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.spring.osgi.OSGiBeanProperties;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Strasbourg. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@OSGiBeanProperties(
	property = {
		"json.web.service.context.name=strasbourg",
		"json.web.service.context.path=Strasbourg"
	},
	service = StrasbourgService.class
)
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface StrasbourgService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>eu.strasbourg.service.strasbourg.service.impl.StrasbourgServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the strasbourg remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link StrasbourgServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Envoie <code>error</code> si le document n'a pas été envoyé.
	 *
	 * Returns <code>succes</code> un document de commission.
	 *
	 * @param fileContent le fichier
	 * @param fileName le nom du fichier
	 * @param commissionName le nom de la commission
	 * @param publicationDate la date de publication au format yyyy-MM-ddThh:mm:ss
	 * @param publicationDateFin la date de fin de publication au format yyyy-MM-ddThh:mm:ss
	 * @param documentType Le type de document
	 * @param documentName Le nom du document
	 * @return <code>succes</code> un document de commission, sinon <code>error</code>.
	 */
	public JSONObject addActe(
		File fileContent, String fileName, String commissionName,
		String publicationDate, String publicationDateFin, String documentType,
		String documentName);

	/**
	 * @deprecated Remplacé par addActes qui gèrent l'envoi de fichier via multipart/form-data
	 Envoie <code>error</code> si le document n'a pas été envoyé.
	 Returns <code>succes</code> un document de commission.
	 * @param fileContent le fichier en base 64
	 * @param fileName le nom du fichier
	 * @param commissionName le nom de la commission
	 * @param publicationDate la date de publication au format yyyy-MM-ddThh:mm:ss
	 * @param publicationDateFin la date de fin de publication au format yyyy-MM-ddThh:mm:ss
	 * @param documentType Le type de document (Strasbourg, Eurométropole)
	 * @param documentName Le nom du document
	 * @return <code>succes</code> un document de commission, sinon <code>error</code>.
	 */
	public JSONObject addDocument(
		String fileContent, String fileName, String commissionName,
		String publicationDate, String publicationDateFin, String documentType,
		String documentName);

	public void foldPortlet(String portletId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getAlerts();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getArticleHTMLContent(long groupId, String articleId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getCategoriesByClassNameAndGroupIds(
		long[] groupIds, String className, long classType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getCategoriesByGroupIds(long[] groupIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getCategoriesPois(
		String categories, String vocabulariesEmptyIds, String prefilters,
		String tags, long groupId, String typeContenu, boolean dateField,
		String fromDate, String toDate, String localeId, long globalGroupId,
		List<String> alertsArret, long territoryVocabularyId,
		long placeTypeVocabularyId, long eventTypeVocabularyId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getCoordinateForAddress(
		String address, String zipCode, String city);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getCopyright(long groupId, String uuid, String language);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getFavoritesPois(
		long groupId, String typeContenu, String localeId,
		List<String> alertsArret, long territoryVocabularyId,
		long placeTypeVocabularyId, long eventTypeVocabularyId);

	/**
	 * Retourne les information d'un fichier de la doc lib à partir de sa friendly url
	 *
	 * @param friendlyUrl
	 * @param language
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getFileDetails(String friendlyUrl, String language);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getInterestsPois(
		String interests, long groupId, String typeContenu, String localeId,
		long globalGroupId, List<String> alertsArret,
		long territoryVocabularyId, long placeTypeVocabularyId,
		long eventTypeVocabularyId);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getPracticeCategories(
		long parentCategoryId, String localeId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getStructuresByGroupIds(long[] groupIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getTagsAndCategoriesByGroupIdsAndClassName(
		long[] groupIds, String className, long classType);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getTagsByGroupIds(long[] groupIds);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject getTraffic();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONArray getVocabulariesByGroupIds(long[] groupIds);

	public void hidePortlet(String portletId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject searchStreets(String query);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public JSONObject searchStreets(String query, String city);

	public void unfoldPortlet(String portletId);

}