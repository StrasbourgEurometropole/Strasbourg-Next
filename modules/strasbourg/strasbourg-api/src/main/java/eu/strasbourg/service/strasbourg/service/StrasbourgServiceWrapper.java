/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link StrasbourgService}.
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgService
 * @generated
 */
public class StrasbourgServiceWrapper
	implements ServiceWrapper<StrasbourgService>, StrasbourgService {

	public StrasbourgServiceWrapper() {
		this(null);
	}

	public StrasbourgServiceWrapper(StrasbourgService strasbourgService) {
		_strasbourgService = strasbourgService;
	}

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
	@Override
	public com.liferay.portal.kernel.json.JSONObject addActe(
		java.io.File fileContent, String fileName, String commissionName,
		String publicationDate, String publicationDateFin, String documentType,
		String documentName) {

		return _strasbourgService.addActe(
			fileContent, fileName, commissionName, publicationDate,
			publicationDateFin, documentType, documentName);
	}

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
	@Override
	public com.liferay.portal.kernel.json.JSONObject addDocument(
		String fileContent, String fileName, String commissionName,
		String publicationDate, String publicationDateFin, String documentType,
		String documentName) {

		return _strasbourgService.addDocument(
			fileContent, fileName, commissionName, publicationDate,
			publicationDateFin, documentType, documentName);
	}

	@Override
	public void foldPortlet(String portletId) {
		_strasbourgService.foldPortlet(portletId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getAlerts() {
		return _strasbourgService.getAlerts();
	}

	@Override
	public String getArticleHTMLContent(long groupId, String articleId) {
		return _strasbourgService.getArticleHTMLContent(groupId, articleId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray
		getCategoriesByClassNameAndGroupIds(
			long[] groupIds, String className, long classType) {

		return _strasbourgService.getCategoriesByClassNameAndGroupIds(
			groupIds, className, classType);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCategoriesByGroupIds(
		long[] groupIds) {

		return _strasbourgService.getCategoriesByGroupIds(groupIds);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCategoriesPois(
		String categories, String vocabulariesEmptyIds, String prefilters,
		String tags, long groupId, String typeContenu, boolean dateField,
		String fromDate, String toDate, String localeId, long globalGroupId,
		java.util.List<String> alertsArret) {

		return _strasbourgService.getCategoriesPois(
			categories, vocabulariesEmptyIds, prefilters, tags, groupId,
			typeContenu, dateField, fromDate, toDate, localeId, globalGroupId,
			alertsArret);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCoordinateForAddress(
		String address, String zipCode, String city) {

		return _strasbourgService.getCoordinateForAddress(
			address, zipCode, city);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getCopyright(
		long groupId, String uuid, String language) {

		return _strasbourgService.getCopyright(groupId, uuid, language);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		long groupId, String typeContenu, String localeId,
		java.util.List<String> alertsArret) {

		return _strasbourgService.getFavoritesPois(
			groupId, typeContenu, localeId, alertsArret);
	}

	/**
	 * Retourne les information d'un fichier de la doc lib à partir de sa friendly url
	 *
	 * @param friendlyUrl
	 * @param language
	 * @return
	 */
	@Override
	public com.liferay.portal.kernel.json.JSONObject getFileDetails(
		String friendlyUrl, String language) {

		return _strasbourgService.getFileDetails(friendlyUrl, language);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getInterestsPois(
		String interests, long groupId, String typeContenu, String localeId,
		long globalGroupId, java.util.List<String> alertsArret) {

		return _strasbourgService.getInterestsPois(
			interests, groupId, typeContenu, localeId, globalGroupId,
			alertsArret);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _strasbourgService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPracticeCategories(
		long parentCategoryId, String localeId) {

		return _strasbourgService.getPracticeCategories(
			parentCategoryId, localeId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getStructuresByGroupIds(
		long[] groupIds) {

		return _strasbourgService.getStructuresByGroupIds(groupIds);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject
		getTagsAndCategoriesByGroupIdsAndClassName(
			long[] groupIds, String className, long classType) {

		return _strasbourgService.getTagsAndCategoriesByGroupIdsAndClassName(
			groupIds, className, classType);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getTagsByGroupIds(
		long[] groupIds) {

		return _strasbourgService.getTagsByGroupIds(groupIds);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getTraffic() {
		return _strasbourgService.getTraffic();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getVocabulariesByGroupIds(
		long[] groupIds) {

		return _strasbourgService.getVocabulariesByGroupIds(groupIds);
	}

	@Override
	public void hidePortlet(String portletId) {
		_strasbourgService.hidePortlet(portletId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject searchStreets(
		String query) {

		return _strasbourgService.searchStreets(query);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject searchStreets(
		String query, String city) {

		return _strasbourgService.searchStreets(query, city);
	}

	@Override
	public void unfoldPortlet(String portletId) {
		_strasbourgService.unfoldPortlet(portletId);
	}

	@Override
	public StrasbourgService getWrappedService() {
		return _strasbourgService;
	}

	@Override
	public void setWrappedService(StrasbourgService strasbourgService) {
		_strasbourgService = strasbourgService;
	}

	private StrasbourgService _strasbourgService;

}