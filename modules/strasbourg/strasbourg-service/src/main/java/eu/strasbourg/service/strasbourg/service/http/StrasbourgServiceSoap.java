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

package eu.strasbourg.service.strasbourg.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import eu.strasbourg.service.strasbourg.service.StrasbourgServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>StrasbourgServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>eu.strasbourg.service.strasbourg.model.StrasbourgSoap</code>. If the method in the
 * service utility returns a
 * <code>eu.strasbourg.service.strasbourg.model.Strasbourg</code>, that is translated to a
 * <code>eu.strasbourg.service.strasbourg.model.StrasbourgSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StrasbourgServiceHttp
 * @generated
 */
public class StrasbourgServiceSoap {

	public static String getCopyright(
			long groupId, String uuid, String language)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getCopyright(groupId, uuid, language);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getFileDetails(
			long groupId, String uuid, String language)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getFileDetails(groupId, uuid, language);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String searchStreets(String query) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.searchStreets(query);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String searchStreets(String query, String city)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.searchStreets(query, city);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getArticleHTMLContent(long groupId, String articleId)
		throws RemoteException {

		try {
			String returnValue = StrasbourgServiceUtil.getArticleHTMLContent(
				groupId, articleId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getInterestsPois(
			String interests, long groupId, String typeContenu, String localeId,
			long globalGroupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getInterestsPois(
					interests, groupId, typeContenu, localeId, globalGroupId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getCategoriesPois(
			String categories, String vocabulariesEmptyIds, String prefilters,
			String tags, long groupId, String typeContenu, boolean dateField,
			String fromDate, String toDate, String localeId, long globalGroupId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getCategoriesPois(
					categories, vocabulariesEmptyIds, prefilters, tags, groupId,
					typeContenu, dateField, fromDate, toDate, localeId,
					globalGroupId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getFavoritesPois(
			long groupId, String typeContenu, String localeId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getFavoritesPois(
					groupId, typeContenu, localeId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void hidePortlet(String portletId) throws RemoteException {
		try {
			StrasbourgServiceUtil.hidePortlet(portletId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getCoordinateForAddress(
			String address, String zipCode, String city)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getCoordinateForAddress(
					address, zipCode, city);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getTraffic() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getTraffic();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getAlerts() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.getAlerts();

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void unfoldPortlet(String portletId) throws RemoteException {
		try {
			StrasbourgServiceUtil.unfoldPortlet(portletId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static void foldPortlet(String portletId) throws RemoteException {
		try {
			StrasbourgServiceUtil.foldPortlet(portletId);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getPracticeCategories(
			long parentCategoryId, String localeId)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getPracticeCategories(
					parentCategoryId, localeId);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
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
	public static String addDocument(
			String fileContent, String fileName, String commissionName,
			String publicationDate, String publicationDateFin,
			String documentType, String documentName)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.addDocument(
					fileContent, fileName, commissionName, publicationDate,
					publicationDateFin, documentType, documentName);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getStructuresByGroupIds(long[] groupIds)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getStructuresByGroupIds(groupIds);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getTagsAndCategoriesByGroupIdsAndClassName(
			long[] groupIds, String className)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				StrasbourgServiceUtil.
					getTagsAndCategoriesByGroupIdsAndClassName(
						groupIds, className);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getTagsByGroupIds(long[] groupIds)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getTagsByGroupIds(groupIds);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getCategoriesByClassNameAndGroupIds(
			long[] groupIds, String className)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getCategoriesByClassNameAndGroupIds(
					groupIds, className);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static String getVocabulariesByGroupIds(long[] groupIds)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONArray returnValue =
				StrasbourgServiceUtil.getVocabulariesByGroupIds(groupIds);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		StrasbourgServiceSoap.class);

}