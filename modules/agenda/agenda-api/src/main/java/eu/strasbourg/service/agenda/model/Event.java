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

package eu.strasbourg.service.agenda.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Event service. Represents a row in the &quot;agenda_Event&quot; database table, with each column mapped to a property of this class.
 *
 * @author BenjaminBini
 * @see EventModel
 * @generated
 */
@ImplementationClassName("eu.strasbourg.service.agenda.model.impl.EventImpl")
@ProviderType
public interface Event extends EventModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.agenda.model.impl.EventImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Event, Long> EVENT_ID_ACCESSOR =
		new Accessor<Event, Long>() {

			@Override
			public Long get(Event event) {
				return event.getEventId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Event> getTypeClass() {
				return Event.class;
			}

		};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories();

	/**
	 * Retourne l'URL de l'image à partir de l'id du DLFileEntry
	 */
	public String getImageURL();

	/**
	 * Retourne le copyright de l'image principale
	 */
	public String getImageCopyright(java.util.Locale locale);

	/**
	 * Retourne la liste des manifestations auxquelles cette édition appartient
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Manifestation>
		getManifestations();

	/**
	 * Retourne la liste des IDs des manifestations auxquelles cette édition
	 * appartient sous forme de String
	 */
	public String getManifestationsIds();

	/**
	 * Retourne la liste des galeries publiées
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Manifestation>
		getPublishedManifestations();

	/**
	 * Retourne la liste des périodes auxquelles l'événement à lieu (classées par
	 * date de début croissante)
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getEventPeriods();

	/**
	 * Retourne la liste des périodes courantes et futures auxuqlles l'événement à
	 * lieu
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.EventPeriod>
		getCurrentAndFuturePeriods();

	/**
	 * Retourne la période courrante, ou la prochaine
	 */
	public eu.strasbourg.service.agenda.model.EventPeriod
		getCurrentOrFuturePeriod();

	/**
	 * Retourne la date de début de la future ou courante période de l'événement
	 */
	public java.util.Date getStartDateFirstCurrentAndFuturePeriod();

	/**
	 * Retourne la période principale de l'événement (de la première date de début à
	 * la dernière date de fin) sous forme de String dans la locale passée en
	 * paramètre
	 */
	public String getEventScheduleDisplay(java.util.Locale locale);

	/**
	 * Retourne la période principale de l'événement (de la première date de début à
	 * la dernière date de fin) sous forme de String dans la locale passée en
	 * paramètre
	 */
	public String getEventScheduleDisplay(
		java.util.Locale locale, boolean dispYear, boolean dispShortMonth);

	/**
	 * Retourne la version live de l'édition, si elle existe
	 */
	public eu.strasbourg.service.agenda.model.Event getLiveVersion();

	/**
	 * Retourne l'id du lieu de l'événement s'il existe, 0 sinon
	 */
	public long getPlaceId();

	/**
	 * Retourne le nom de la ville, provenant du lieu interne s'il existe, du lieu
	 * lié sinon
	 */
	public String getCity(java.util.Locale locale);

	/**
	 * Retourne le nom du lieu, provenant du lieu interne s'il existe, du lieu lié
	 * sinon
	 */
	public String getPlaceAlias(java.util.Locale locale);

	/**
	 * Retourne l'adresse sans la ville
	 */
	public String getPlaceAddress(java.util.Locale locale);

	/**
	 * Retourne la ville
	 */
	public String getPlaceCity(java.util.Locale locale);

	/**
	 * Retourne l'adresse complete du lieu SIG ou "manuel"
	 */
	public String getCompleteAddress(java.util.Locale locale);

	/**
	 * Retourne les coordonnees mercator en axe X (longitude)
	 */
	public String getMercatorX();

	/**
	 * Retourne les coordonnees mercator en axe Y (latitude)
	 */
	public String getMercatorY();

	/**
	 * Retourne les coordonnees mercator en axe X et Y Notes : permet de ne pas
	 * multiplier les appels
	 *
	 * @return tableau [mercatorX, mercatorY] sinon tableau vide
	 */
	public java.util.List<String> getMercators();

	/**
	 * Retourne la liste des participations de l'evenement
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.EventParticipation>
		getEventParticipations();

	/**
	 * Retourne le nombre de participation a l'evenement
	 */
	public int getNbEventParticipations();

	/**
	 * Retourne les commentaires de l'entité
	 */
	public java.util.List<eu.strasbourg.service.comment.model.Comment>
		getApprovedComments();

	/**
	 * Retourne le nombre de commentaires de l'entité
	 */
	public int getNbApprovedComments();

	/**
	 * L'evenement est-il terminee ?
	 */
	public boolean isFinished();

	/**
	 * Retourne le label de 5 digits du nombre de participation a l'evenement
	 */
	public String getNbEventParticipationsLabel();

	/**
	 * Retourne true si l'événement est accessible pour au moins un type de handicap
	 */
	public boolean hasAnyAccessForDisabled();

	/**
	 * Retourne l'adresse complète du lieu, provenant du lieu interne s'il existe,
	 * du lieu lié sinon
	 */
	public String getPlaceAddressHTML(java.util.Locale locale);

	/**
	 * Retourne les types de l'événement
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypes();

	/**
	 * Retourne les typologie de l'événement (Catégorie du site de l'OPS)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTypologies();

	/**
	 * Retourne le label des typologies de l'événement (Catégorie du site de l'OPS)
	 */
	public String getLabelTypologies(java.util.Locale locale);

	/**
	 * Retourne le label des types de l'événement
	 */
	public String getTypeLabel(java.util.Locale locale);

	/**
	 * Retourne les themes de l'événement
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getThemes();

	/**
	 * Retourne le label des thèmes de l'événement
	 */
	public String getThemeLabel(java.util.Locale locale);

	/**
	 * Retourne les publics de l'événement
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getPublics();

	/**
	 * Retourne le label des publics de l'événement
	 */
	public String getPublicLabel(java.util.Locale locale);

	/**
	 * Retourne les territoires de l'événement
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getTerritories();

	/**
	 * Retourne le label des territoires de l'événement
	 */
	public String getTerritoryLabel(java.util.Locale locale);

	/**
	 * Retourne les territoires de l'événement
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getServices();

	public java.time.LocalDate getNextOpenDate();

	/**
	 * Demande si l'utilisateur demandé participe à l'événement
	 */
	public boolean isUserParticipates(String publikUserId);

	/**
	 * Retourne la version JSON de l'événenement
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON();

	/**
	 * Retourne la version JSON de l'événenement avec la participation ou non d'un
	 * utilisateur potentiel en incluant l'escape des caractères / balises pouvant
	 * casser l'utilisation des données et le split de l'HTML en général
	 */
	public com.liferay.portal.kernel.json.JSONObject toJSON(
		String publikUserID);

	public String getCurrentOrFuturePeriodStringDate();

	/**
	 * Retourne X suggestions max pour un événement
	 *
	 * @param request  la requete
	 * @param nbSuggestions le nombre de suggestions.
	 * @param tag le tag a appliquer
	 * @param category la categorie a appliquer
	 * @return la liste d'événements.
	 */
	public java.util.List<eu.strasbourg.service.agenda.model.Event>
			getSuggestions(
				javax.servlet.http.HttpServletRequest request,
				int nbSuggestions, String tag, String category)
		throws com.liferay.portal.kernel.exception.PortalException,
			SearchException;

	/**
	 * Renvoi les sessions de l'evenement obtenues par le webService Rodrigue
	 *
	 * @return
	 */
	public java.util.List<eu.strasbourg.utils.models.RodrigueEventSession>
		getSessionsFromRodrigue();

	/**
	 * Renvoi les sessions de l'evenement obtenues par le webService Rodriguesous format JSON
	 *
	 * @return
	 */
	public com.liferay.portal.kernel.json.JSONArray
		getSessionsFromRodrigueInJSON();

}