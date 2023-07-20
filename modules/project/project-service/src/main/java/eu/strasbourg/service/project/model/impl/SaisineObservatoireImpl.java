/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package eu.strasbourg.service.project.model.impl;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.PlacitPlaceLocalServiceUtil;
import eu.strasbourg.service.project.service.SignataireLocalServiceUtil;
import eu.strasbourg.utils.AssetVocabularyHelper;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static eu.strasbourg.service.project.constants.ParticiperCategories.*;

/**
 * The extended model implementation for the SaisineObservatoire service. Represents a row in the &quot;project_SaisineObservatoire&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.project.model.SaisineObservatoire</code> interface.
 * </p>
 *
 * @author Joshua Chacha
 */
public class SaisineObservatoireImpl extends SaisineObservatoireBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. All methods that expect a saisine observatoire model instance should use the {@link eu.strasbourg.service.project.model.SaisineObservatoire} interface instead.
     */
    public SaisineObservatoireImpl() {
    }

    /**
     * Retourne l'AssetEntry rattaché cet item
     */
    @Override
    public AssetEntry getAssetEntry() {
        return AssetEntryLocalServiceUtil.fetchEntry(SaisineObservatoire.class.getName(), this.getSaisineObservatoireId());
    }

    /**
     * Renvoie la liste des AssetCategory rattachées à cet item (via l'assetEntry)
     */
    @Override
    public List<AssetCategory> getCategories() {
        return AssetVocabularyHelper.getAssetEntryCategories(this.getAssetEntry());
    }

    /**
     * méthode de récupération du status
     *
     * @return le status.
     */
    @Override
    public String getSaisineObservatoireStatus() {

        //Statut par défaut quand déposée
        String result = DRAFT.getName();

        // TODO : implémenter les bonnes propriétés

        return result;
    }

    @Override
    public String getAuthorLabel() {
        if (this.getInTheNameOf() != "" && this.getInTheNameOf() != null) {
            return this.getInTheNameOf();
        } else {
            return StringUtil.upperCaseFirstLetter(this.getPetitionnaireFirstname()) + " " + StringUtil.toUpperCase(StringUtil.shorten(this.getPetitionnaireLastname(), 2, "."));
        }
    }

    /**
     * Retourne la liste des lieux placit liés à la petition
     */
    @Override
    public List<PlacitPlace> getPlacitPlaces() {
        return PlacitPlaceLocalServiceUtil.getBySaisineObservatoire(this.getSaisineObservatoireId());
    }
}