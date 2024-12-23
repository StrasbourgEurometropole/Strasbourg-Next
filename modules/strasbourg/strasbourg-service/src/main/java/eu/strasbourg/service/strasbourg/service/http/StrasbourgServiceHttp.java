/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.strasbourg.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

import eu.strasbourg.service.strasbourg.service.StrasbourgServiceUtil;

/**
 * Provides the HTTP utility for the
 * <code>StrasbourgServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class StrasbourgServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject getCopyright(
		HttpPrincipal httpPrincipal, long groupId, String uuid,
		String language) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getCopyright",
				_getCopyrightParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, uuid, language);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getFileDetails(
		HttpPrincipal httpPrincipal, String friendlyUrl, String language) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getFileDetails",
				_getFileDetailsParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, friendlyUrl, language);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		HttpPrincipal httpPrincipal, String query) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "searchStreets",
				_searchStreetsParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, query);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject searchStreets(
		HttpPrincipal httpPrincipal, String query, String city) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "searchStreets",
				_searchStreetsParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, query, city);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static String getArticleHTMLContent(
		HttpPrincipal httpPrincipal, long groupId, String articleId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getArticleHTMLContent",
				_getArticleHTMLContentParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, articleId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getInterestsPois(
		HttpPrincipal httpPrincipal, String interests, long groupId,
		String typeContenu, String localeId, long globalGroupId,
		java.util.List<String> alertsArret, long territoryVocabularyId,
		long placeTypeVocabularyId, long eventTypeVocabularyId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getInterestsPois",
				_getInterestsPoisParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, interests, groupId, typeContenu, localeId,
				globalGroupId, alertsArret, territoryVocabularyId,
				placeTypeVocabularyId, eventTypeVocabularyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getCategoriesPois(
		HttpPrincipal httpPrincipal, String categories,
		String vocabulariesEmptyIds, String prefilters, String tags,
		long groupId, String typeContenu, boolean dateField, String fromDate,
		String toDate, String localeId, long globalGroupId,
		java.util.List<String> alertsArret, long territoryVocabularyId,
		long placeTypeVocabularyId, long eventTypeVocabularyId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getCategoriesPois",
				_getCategoriesPoisParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, categories, vocabulariesEmptyIds, prefilters, tags,
				groupId, typeContenu, dateField, fromDate, toDate, localeId,
				globalGroupId, alertsArret, territoryVocabularyId,
				placeTypeVocabularyId, eventTypeVocabularyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getFavoritesPois(
		HttpPrincipal httpPrincipal, long groupId, String typeContenu,
		String localeId, java.util.List<String> alertsArret,
		long territoryVocabularyId, long placeTypeVocabularyId,
		long eventTypeVocabularyId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getFavoritesPois",
				_getFavoritesPoisParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, typeContenu, localeId, alertsArret,
				territoryVocabularyId, placeTypeVocabularyId,
				eventTypeVocabularyId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void hidePortlet(
		HttpPrincipal httpPrincipal, String portletId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "hidePortlet",
				_hidePortletParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, portletId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCoordinateForAddress(
			HttpPrincipal httpPrincipal, String address, String zipCode,
			String city) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getCoordinateForAddress",
				_getCoordinateForAddressParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, address, zipCode, city);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getTraffic(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getTraffic",
				_getTrafficParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject getAlerts(
		HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getAlerts",
				_getAlertsParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void unfoldPortlet(
		HttpPrincipal httpPrincipal, String portletId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "unfoldPortlet",
				_unfoldPortletParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, portletId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static void foldPortlet(
		HttpPrincipal httpPrincipal, String portletId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "foldPortlet",
				_foldPortletParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, portletId);

			try {
				TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getPracticeCategories(
			HttpPrincipal httpPrincipal, long parentCategoryId,
			String localeId) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getPracticeCategories",
				_getPracticeCategoriesParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, parentCategoryId, localeId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject addActe(
		HttpPrincipal httpPrincipal, java.io.File fileContent, String fileName,
		String commissionName, String publicationDate,
		String publicationDateFin, String documentType, String documentName) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "addActe",
				_addActeParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileContent, fileName, commissionName,
				publicationDate, publicationDateFin, documentType,
				documentName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject addDocument(
		HttpPrincipal httpPrincipal, String fileContent, String fileName,
		String commissionName, String publicationDate,
		String publicationDateFin, String documentType, String documentName) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "addDocument",
				_addDocumentParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, fileContent, fileName, commissionName,
				publicationDate, publicationDateFin, documentType,
				documentName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getStructuresByGroupIds(HttpPrincipal httpPrincipal, long[] groupIds) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getStructuresByGroupIds",
				_getStructuresByGroupIdsParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONObject
		getTagsAndCategoriesByGroupIdsAndClassName(
			HttpPrincipal httpPrincipal, long[] groupIds, String className,
			long classType) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class,
				"getTagsAndCategoriesByGroupIdsAndClassName",
				_getTagsAndCategoriesByGroupIdsAndClassNameParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds, className, classType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray getTagsByGroupIds(
		HttpPrincipal httpPrincipal, long[] groupIds) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getTagsByGroupIds",
				_getTagsByGroupIdsParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCategoriesByClassNameAndGroupIds(
			HttpPrincipal httpPrincipal, long[] groupIds, String className,
			long classType) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class,
				"getCategoriesByClassNameAndGroupIds",
				_getCategoriesByClassNameAndGroupIdsParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds, className, classType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getCategoriesByGroupIds(HttpPrincipal httpPrincipal, long[] groupIds) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getCategoriesByGroupIds",
				_getCategoriesByGroupIdsParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.liferay.portal.kernel.json.JSONArray
		getVocabulariesByGroupIds(
			HttpPrincipal httpPrincipal, long[] groupIds) {

		try {
			MethodKey methodKey = new MethodKey(
				StrasbourgServiceUtil.class, "getVocabulariesByGroupIds",
				_getVocabulariesByGroupIdsParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupIds);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONArray)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		StrasbourgServiceHttp.class);

	private static final Class<?>[] _getCopyrightParameterTypes3 = new Class[] {
		long.class, String.class, String.class
	};
	private static final Class<?>[] _getFileDetailsParameterTypes4 =
		new Class[] {String.class, String.class};
	private static final Class<?>[] _searchStreetsParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _searchStreetsParameterTypes6 =
		new Class[] {String.class, String.class};
	private static final Class<?>[] _getArticleHTMLContentParameterTypes7 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _getInterestsPoisParameterTypes8 =
		new Class[] {
			String.class, long.class, String.class, String.class, long.class,
			java.util.List.class, long.class, long.class, long.class
		};
	private static final Class<?>[] _getCategoriesPoisParameterTypes9 =
		new Class[] {
			String.class, String.class, String.class, String.class, long.class,
			String.class, boolean.class, String.class, String.class,
			String.class, long.class, java.util.List.class, long.class,
			long.class, long.class
		};
	private static final Class<?>[] _getFavoritesPoisParameterTypes10 =
		new Class[] {
			long.class, String.class, String.class, java.util.List.class,
			long.class, long.class, long.class
		};
	private static final Class<?>[] _hidePortletParameterTypes11 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getCoordinateForAddressParameterTypes12 =
		new Class[] {String.class, String.class, String.class};
	private static final Class<?>[] _getTrafficParameterTypes13 =
		new Class[] {};
	private static final Class<?>[] _getAlertsParameterTypes14 = new Class[] {};
	private static final Class<?>[] _unfoldPortletParameterTypes15 =
		new Class[] {String.class};
	private static final Class<?>[] _foldPortletParameterTypes16 = new Class[] {
		String.class
	};
	private static final Class<?>[] _getPracticeCategoriesParameterTypes17 =
		new Class[] {long.class, String.class};
	private static final Class<?>[] _addActeParameterTypes18 = new Class[] {
		java.io.File.class, String.class, String.class, String.class,
		String.class, String.class, String.class
	};
	private static final Class<?>[] _addDocumentParameterTypes19 = new Class[] {
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class
	};
	private static final Class<?>[] _getStructuresByGroupIdsParameterTypes20 =
		new Class[] {long[].class};
	private static final Class<?>[]
		_getTagsAndCategoriesByGroupIdsAndClassNameParameterTypes21 =
			new Class[] {long[].class, String.class, long.class};
	private static final Class<?>[] _getTagsByGroupIdsParameterTypes22 =
		new Class[] {long[].class};
	private static final Class<?>[]
		_getCategoriesByClassNameAndGroupIdsParameterTypes24 = new Class[] {
			long[].class, String.class, long.class
		};
	private static final Class<?>[] _getCategoriesByGroupIdsParameterTypes25 =
		new Class[] {long[].class};
	private static final Class<?>[] _getVocabulariesByGroupIdsParameterTypes26 =
		new Class[] {long[].class};

}