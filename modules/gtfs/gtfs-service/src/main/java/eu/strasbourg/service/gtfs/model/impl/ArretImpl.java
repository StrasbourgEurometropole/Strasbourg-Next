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

package eu.strasbourg.service.gtfs.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.gtfs.model.Alert;
import eu.strasbourg.service.gtfs.model.Arret;
import eu.strasbourg.service.gtfs.model.CacheAlertJSON;
import eu.strasbourg.service.gtfs.model.Direction;
import eu.strasbourg.service.gtfs.model.Ligne;
import eu.strasbourg.service.gtfs.service.AlertLocalServiceUtil;
import eu.strasbourg.service.gtfs.service.ArretServiceUtil;
import eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalServiceUtil;
import eu.strasbourg.service.gtfs.service.DirectionLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.PortalHelper;
import org.osgi.annotation.versioning.ProviderType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The extended model implementation for the Arret service. Represents a row in the &quot;gtfs_Arret&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.gtfs.model.Arret} interface.
 * </p>
 *
 * @author Cedric Henry
 */
@ProviderType
public class ArretImpl extends ArretBaseImpl {

	private static final long serialVersionUID = 3843907860876078856L;
	
	public static final String TYPE_BUS = "Bus";
	public static final String TYPE_TRAM = "Tram";

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a arret model instance should use the {@link eu.strasbourg.service.gtfs.model.Arret} interface instead.
	 */
	public ArretImpl() {
	}
	
	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(Arret.class.getName(), this.getArretId());
	}
	
	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public List<AssetCategory> getCategories() {
		return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
	}

	/**
	 * Renvoie la liste des Directions de cet arret
	 */
	@Override
	public List<Direction> getDirections() {
		return DirectionLocalServiceUtil.getByStopId(this.getStopId());
	}

    /**
     * Renvoie la liste des Alertes de cet arret
     */
    @Override
    public List<Alert> getAlerts() {
        return AlertLocalServiceUtil.getByArretId(this.getArretId());
    }

    /**
     * Renvoie la liste des Alertes en cours ou à venir des lignes de cet arrêt
     */
    @Override
    public List<JSONObject> getAlertsActives() {
		// récupération des lignes de l'arrêt
		// Map <ligne, {nom de ligne, couleur background, couleur text}
		Map<String, JSONObject> lignes = new HashMap<>();
		List<Direction> lignesMap = this.getDirections();
		for (Direction direction : lignesMap) {
			Ligne line = direction.getLigne();
			JSONObject lineJson = JSONFactoryUtil.createJSONObject();
			lineJson.put("line",line.getShortName());
			lineJson.put("bg", line.getBackgroundColor());
			lineJson.put("text", line.getTextColor());
			lignes.put(line.getShortName(),lineJson);
		}

		// récupération des alertes
		CacheAlertJSON cache = CacheAlertJSONLocalServiceUtil.getCacheAlertJSONs(-1, -1).get(0);
		List<JSONObject> alertsByLine = new ArrayList<>();
		try {
			JSONObject json = JSONFactoryUtil.createJSONObject(cache.getJsonAlert());
			JSONArray alertsJson = json.getJSONArray("alerts");
			for (int i = 0; i < alertsJson.length() ; i++) {
				JSONObject alertJson = alertsJson.getJSONObject(i);
				// on récupère les lignes touchées par cette alerte
				JSONArray linesAlertJson = alertJson.getJSONArray("linesNumber");
				JSONArray linesJson = JSONFactoryUtil.createJSONArray();
				for (int j = 0; j < linesAlertJson.length() ; j++) {
					String lineNumber = linesAlertJson.getString(j);
					// vérifie si la ligne passe à cet arrêt
					JSONObject line = lignes.get(lineNumber);
					if(Validator.isNotNull(line)){
						linesJson.put(line);
					}
				}
				if(linesJson.length() > 0) {
					alertJson.put("lines", linesJson);
					alertsByLine.add(alertJson);
				}
			}
		} catch (JSONException e) {
			_log.error(e.getMessage(), e);
		}
        return  alertsByLine;
    }
	/**
	 * Renvoie le count des Alertes en cours ou à venir de cet arret
	 */
	public long getCountAlertsActives() {
	 	return  AlertLocalServiceUtil.getCountAlertsActives(this.getArretId());
	}

	/**
	 * Renvoie la correspondance du type d'arret en format texte
	 */
	@Override
	public String getTypeText() {
		return this.getType() == 0 ? TYPE_TRAM : TYPE_BUS;
	}

	/**
	 * Renvoie les directions sans doublon de lignes shortName, [bgColor, textColor, destinationName]
	 */
	@Override
	public Map<String, String[]> getDirectionsUniques() {
		Map<String, String[]> directions = new HashMap<String, String[]>();
		for (Direction direction : this.getDirections()) {
			Ligne ligne = direction.getLigne();
			// vérifie si la ligne existe déjà
			if(!directions.containsKey(ligne.getShortName())) {
				String[] ligneString = {ligne.getBackgroundColor(), ligne.getTextColor(), direction.getDestinationName()};
				directions.put(ligne.getShortName(),ligneString);
			}else{
				String destinations = directions.get(ligne.getShortName())[2];
				destinations = destinations.split(" \\(Variable suivant dates\\)")[0];
				// vérifie si la destination existe déjà
				if(!destinations.contains(direction.getDestinationName())){
					directions.get(ligne.getShortName())[2] = destinations + " / " + direction.getDestinationName()
							+ " (Variable suivant dates)";
				}
			}
		}
		return directions;
	}

	/**
	 * Renvoie les prochains passages
	 */
	@Override
	public List<JSONObject> getArretRealTime() {
		List<JSONObject> realTimeList = new ArrayList<JSONObject>();
		JSONArray realTimes = ArretServiceUtil.getArretRealTime(this.getCode());
		if(Validator.isNotNull(realTimes)) {
			for (int i = 0; i < realTimes.length(); i++) {
				JSONObject realTime = realTimes.getJSONObject(i);
				realTimeList.add(realTime);
			}
		}
		return realTimeList;
	}
	
	/**
	 * Renvoie le JSON de l'entite au format GeoJSON pour la map
	 */
	@Override
	public JSONObject getGeoJSON(long groupId, Locale locale, List<String> alertsArret) throws JSONException {
		JSONObject feature = JSONFactoryUtil.createJSONObject();
		feature.put("type", "Feature");

		JSONObject properties = JSONFactoryUtil.createJSONObject();
		properties.put("name", this.getTypeText() + " - " + this.getTitle());

		properties.put("icon", "/o/mapweb/images/picto_" + this.getTypeText().toLowerCase() + ".png");

		// récupère les numéros de lignes de l'arrêt
		JSONArray lignes = JSONFactoryUtil.createJSONArray();
		// retourne clé = shortName, value = [bgColor, textColor, destination]
		Map<String, String[]> lignesMap = this.getDirectionsUniques();
		for (Map.Entry<String, String[]> ligne : lignesMap.entrySet()) {
			JSONObject infoLigne = JSONFactoryUtil.createJSONObject();
			infoLigne.put("bgColor",ligne.getValue()[0]);
			infoLigne.put("textColor",ligne.getValue()[1]);
			infoLigne.put("numero",ligne.getKey());
			lignes.put(infoLigne);
			// vérifie si la ligne a une alerte
			if(alertsArret.contains(ligne.getKey()))
				properties.put("alert", true);
		}
		properties.put("lignes", lignes);

		// récupère l'url de détail du poi
		Group group = GroupLocalServiceUtil.fetchGroup(groupId);
		if (group == null) {
			group = GroupLocalServiceUtil.fetchFriendlyURLGroup(PortalUtil.getDefaultCompanyId(), "/strasbourg.eu");
		}
		String url = "";
		if (group != null) {
			String virtualHostName=PortalHelper.getVirtualHostname(group, Locale.FRANCE.getLanguage());
			if (virtualHostName.isEmpty()) {
				url = "/web" + group.getFriendlyURL() + "/";
			} else {
				url = "https://" + virtualHostName + "/";
			}
			url += "arret/-/entity/id/" + this.getArretId();
		}
		properties.put("url", url);

		// bouton favoris
		properties.put("type", "14");
		properties.put("id", this.getArretId());

		// pour la gestion des doublons qui a besoin d'un sigId et non un Id
		properties.put("sigId", this.getArretId());

		// affichage des prochains passages
		properties.put("codeArret", this.getCode());

		feature.put("properties", properties);

		JSONObject geometry = JSONFactoryUtil.createJSONObject();
		geometry.put("type", "Point");
		JSONArray coordinates = JSONFactoryUtil.createJSONArray();
		coordinates.put(Float.valueOf(this.getLongitude()));
		coordinates.put(Float.valueOf(this.getLatitude()));
		geometry.put("coordinates", coordinates);
		feature.put("geometry", geometry);

		return feature;
	}

	private static final Log _log = LogFactoryUtil.getLog(ArretImpl.class.getName());
}