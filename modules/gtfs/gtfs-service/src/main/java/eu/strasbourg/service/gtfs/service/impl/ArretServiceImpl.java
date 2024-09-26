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

package eu.strasbourg.service.gtfs.service.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.service.gtfs.model.CacheAlertJSON;
import eu.strasbourg.service.gtfs.service.ArretService;
import eu.strasbourg.service.gtfs.service.ArretServiceUtil;
import eu.strasbourg.service.gtfs.service.base.ArretServiceBaseImpl;
import eu.strasbourg.service.gtfs.utils.CTSService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The implementation of the arret remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link ArretService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Cedric Henry
 * @see ArretServiceBaseImpl
 * @see ArretServiceUtil
 */
public class ArretServiceImpl extends ArretServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.gtfs.service.ArretServiceUtil} to access the arret remote service.
	 */

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 */
	@Override
	public JSONArray getArretRealTime(String stopCode) {
		return CTSService.stopMonitoring(stopCode);
	}

	/**
	 * Recuperer les donnees temps real de la CTS pour un arret
	 * @param stopCode code SMS de l'arret (ex: "275c" pour l'arret de tram Homme de fer)
	 * @param type type de l'arret (0 -> tram, 3 -> bus)
	 */
	@Override
	public JSONArray getArretRealTime(String stopCode, int type, int timeOut) {
		return CTSService.stopMonitoring(stopCode, type, timeOut);
	}
	
	/**
	 * Recuperer les lignes qui ont des alertes
	 */
	@Override
	public List<String> getAlerts() {
		CacheAlertJSON cache = cacheAlertJSONLocalService.getCacheAlertJSONs(-1, -1).get(0);
		List<String> alertsByLine = new ArrayList<>();
        try {
			JSONObject json = JSONFactoryUtil.createJSONObject(cache.getJsonAlert());
			JSONArray alerts = json.getJSONArray("alerts");
			for (int i = 0; i < alerts.length() ; i++) {
				JSONObject alert = alerts.getJSONObject(i);
				JSONObject alertJSON = JSONFactoryUtil.createJSONObject();
				// on récupère les lignes touchées
				JSONArray linesNumber = alert.getJSONArray("linesNumber");
				for (int j = 0; j < linesNumber.length() ; j++) {
					String lineNumber = linesNumber.getString(j);
					alertsByLine.add(lineNumber);
				}
			}
			// supprime les doublons
			alertsByLine = alertsByLine.stream()
					.distinct()
					.collect(Collectors.toList());
        } catch (JSONException e) {
			_log.error(e.getMessage(), e);
        }
		
		return alertsByLine;
	}
	private static final Log _log = LogFactoryUtil.getLog(ArretServiceImpl.class.getName());
	
}