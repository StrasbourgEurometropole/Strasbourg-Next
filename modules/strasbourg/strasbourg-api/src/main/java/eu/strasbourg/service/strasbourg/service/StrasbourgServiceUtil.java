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

import aQute.bnd.annotation.ProviderType;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

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
@ProviderType
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
	 * @param fileContent le fichier en base 64
	 * @param fileName le nom du fichier
	 * @param commissionName le nom de la commission
	 * @param publicationDate la date de publication au format yyyy-MM-ddThh:mm:ss
	 * @param documentType Le type de docuemnt (Strasbourg, Eurométropole)
	 * @param documentName Le nom du document
	 * @return <code>succes</code> un document de commission, sinon <code>error</code>.
	 */
	public static com.liferay.portal.kernel.json.JSONObject addDocument(
		String fileContent, String fileName, String commissionName,
		String publicationDate, String documentType, String documentName) {

		return getService().addDocument(
			fileContent, fileName, commissionName, publicationDate,
			documentType, documentName);
	}

	public static void foldPortlet(String portletId) {
		getService().foldPortlet(portletId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getAlerts() {
		return getService().getAlerts();
	}

	public static String getArticleHTMLContent(long groupId, String articleId) {
		return getService().getArticleHTMLContent(groupId, articleId);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCoordinateForAddress(String address, String zipCode, String city) {

		return getService().getCoordinateForAddress(address, zipCode, city);
	}

	public static com.liferay.portal.kernel.json.JSONObject getCopyright(
		long groupId, String uuid, String language) {

		return getService().getCopyright(groupId, uuid, language);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		long groupId) {

		return getService().getFavoritesPois(groupId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		long groupId, String typeContenu) {

		return getService().getFavoritesPois(groupId, typeContenu);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		long groupId, String typeContenu, String localeId) {

		return getService().getFavoritesPois(groupId, typeContenu, localeId);
	}

	public static int getFavoritesPoisCount(long groupId, String typeContenu) {
		return getService().getFavoritesPoisCount(groupId, typeContenu);
	}

	public static com.liferay.portal.kernel.json.JSONObject getFileDetails(
		long groupId, String uuid, String language) {

		return getService().getFileDetails(groupId, uuid, language);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.liferay.portal.kernel.json.JSONObject getPois(
		String interests, long groupId) {

		return getService().getPois(interests, groupId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getPois(
		String interests, long groupId, String localeId) {

		return getService().getPois(interests, groupId, localeId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getPois(
		String interests, String categories, String prefilters, long groupId,
		String typeContenu) {

		return getService().getPois(
			interests, categories, prefilters, groupId, typeContenu);
	}

	public static com.liferay.portal.kernel.json.JSONObject getPois(
		String interests, String categories, String prefilters, long groupId,
		String typeContenu, String localeId) {

		return getService().getPois(
			interests, categories, prefilters, groupId, typeContenu, localeId);
	}

	public static int getPoisCategoryCount(
		long idCategory, String prefilters, long groupId, String typeContenu) {

		return getService().getPoisCategoryCount(
			idCategory, prefilters, groupId, typeContenu);
	}

	public static int getPoisInterestCount(
		long idCategory, long groupId, String typeContenu) {

		return getService().getPoisInterestCount(
			idCategory, groupId, typeContenu);
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getPracticeCategories(long parentCategoryId, String localeId) {

		return getService().getPracticeCategories(parentCategoryId, localeId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getTraffic() {
		return getService().getTraffic();
	}

	public static void hidePortlet(String portletId) {
		getService().hidePortlet(portletId);
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		String query) {

		return getService().searchStreets(query);
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		String query, String city) {

		return getService().searchStreets(query, city);
	}

	public static void unfoldPortlet(String portletId) {
		getService().unfoldPortlet(portletId);
	}

	public static StrasbourgService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<StrasbourgService, StrasbourgService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(StrasbourgService.class);

		ServiceTracker<StrasbourgService, StrasbourgService> serviceTracker =
			new ServiceTracker<StrasbourgService, StrasbourgService>(
				bundle.getBundleContext(), StrasbourgService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}