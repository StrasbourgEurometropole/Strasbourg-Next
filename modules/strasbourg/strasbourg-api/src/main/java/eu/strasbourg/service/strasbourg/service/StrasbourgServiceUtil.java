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

package eu.strasbourg.service.strasbourg.service;

/**
 * Provides the remote service utility for Strasbourg. This utility wraps
 * <code>eu.strasbourg.service.strasbourg.service.impl.StrasbourgServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgService
 * @generated
 */
public class StrasbourgServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>eu.strasbourg.service.strasbourg.service.impl.StrasbourgServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
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
	 * @param documentType Le type de document (Strasbourg, Eurométropole)
	 * @param documentName Le nom du document
	 * @return <code>succes</code> un document de commission, sinon <code>error</code>.
	 */
	public static com.liferay.portal.kernel.json.JSONObject addActe(
		java.io.File fileContent, java.lang.String fileName,
		java.lang.String commissionName, java.lang.String publicationDate,
		java.lang.String publicationDateFin, java.lang.String documentType,
		java.lang.String documentName) {

		return getService().addActe(
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
	public static com.liferay.portal.kernel.json.JSONObject addDocument(
		java.lang.String fileContent, java.lang.String fileName,
		java.lang.String commissionName, java.lang.String publicationDate,
		java.lang.String publicationDateFin, java.lang.String documentType,
		java.lang.String documentName) {

		return getService().addDocument(
			fileContent, fileName, commissionName, publicationDate,
			publicationDateFin, documentType, documentName);
	}

	public static void foldPortlet(java.lang.String portletId) {
		getService().foldPortlet(portletId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getAlerts() {
		return getService().getAlerts();
	}

	public static java.lang.String getArticleHTMLContent(
		long groupId, java.lang.String articleId) {

		return getService().getArticleHTMLContent(groupId, articleId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCategoriesByClassNameAndGroupIds(
			long[] groupIds, java.lang.String className) {

		return getService().getCategoriesByClassNameAndGroupIds(
			groupIds, className);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCategoriesByGroupIds(long[] groupIds) {

		return getService().getCategoriesByGroupIds(groupIds);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCategoriesPois(
		java.lang.String categories, java.lang.String vocabulariesEmptyIds,
		java.lang.String prefilters, java.lang.String tags, long groupId,
		java.lang.String typeContenu, boolean dateField,
		java.lang.String fromDate, java.lang.String toDate,
		java.lang.String localeId, long globalGroupId) {

		return getService().getCategoriesPois(
			categories, vocabulariesEmptyIds, prefilters, tags, groupId,
			typeContenu, dateField, fromDate, toDate, localeId, globalGroupId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCoordinateForAddress(
			java.lang.String address, java.lang.String zipCode,
			java.lang.String city) {

		return getService().getCoordinateForAddress(address, zipCode, city);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCopyright(
		long groupId, java.lang.String uuid, java.lang.String language) {

		return getService().getCopyright(groupId, uuid, language);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		long groupId, java.lang.String typeContenu, java.lang.String localeId) {

		return getService().getFavoritesPois(groupId, typeContenu, localeId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFileDetails(
		long groupId, java.lang.String uuid, java.lang.String language) {

		return getService().getFileDetails(groupId, uuid, language);
	}

	public static com.liferay.portal.kernel.json.JSONObject getInterestsPois(
		java.lang.String interests, long groupId, java.lang.String typeContenu,
		java.lang.String localeId, long globalGroupId) {

		return getService().getInterestsPois(
			interests, groupId, typeContenu, localeId, globalGroupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getPracticeCategories(
			long parentCategoryId, java.lang.String localeId) {

		return getService().getPracticeCategories(parentCategoryId, localeId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getStructuresByGroupIds(long[] groupIds) {

		return getService().getStructuresByGroupIds(groupIds);
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getTagsAndCategoriesByGroupIdsAndClassName(
			long[] groupIds, java.lang.String className) {

		return getService().getTagsAndCategoriesByGroupIdsAndClassName(
			groupIds, className);
	}

	public static com.liferay.portal.kernel.json.JSONArray getTagsByGroupIds(
		long[] groupIds) {

		return getService().getTagsByGroupIds(groupIds);
	}

	public static com.liferay.portal.kernel.json.JSONObject getTraffic() {
		return getService().getTraffic();
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getVocabulariesByGroupIds(long[] groupIds) {

		return getService().getVocabulariesByGroupIds(groupIds);
	}

	public static void hidePortlet(java.lang.String portletId) {
		getService().hidePortlet(portletId);
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		java.lang.String query) {

		return getService().searchStreets(query);
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		java.lang.String query, java.lang.String city) {

		return getService().searchStreets(query, city);
	}

	public static void unfoldPortlet(java.lang.String portletId) {
		getService().unfoldPortlet(portletId);
	}

	public static StrasbourgService getService() {
		return _service;
	}

	private static volatile StrasbourgService _service;

}