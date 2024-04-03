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

package eu.strasbourg.service.project.service.impl;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.link.service.AssetLinkLocalService;
import com.liferay.asset.link.service.AssetLinkLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.comment.exception.NoSuchCommentException;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.service.base.SaisineObservatoireLocalServiceBaseImpl;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.constants.FriendlyURLs;
import eu.strasbourg.utils.constants.VocabularyNames;
import org.osgi.service.component.annotations.Reference;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static eu.strasbourg.service.project.constants.ParticiperCategories.*;

/**
 * The implementation of the saisine observatoire local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.project.service.SaisineObservatoireLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Joshua Chacha
 * @see SaisineObservatoireLocalServiceBaseImpl
 */
public class SaisineObservatoireLocalServiceImpl
        extends SaisineObservatoireLocalServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Use <code>eu.strasbourg.service.project.service.SaisineObservatoireLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.project.service.SaisineObservatoireLocalServiceUtil</code>.
     */

    public final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public SaisineObservatoire createSaisineObservatoire(long saisineObservatoireId) {
        return super.createSaisineObservatoire(saisineObservatoireId);
    }

    /**
     * Crée une saisine vide avec une PK, non ajouté à la base de donnée
     */
    @Override
    public SaisineObservatoire createSaisineObservatoire(ServiceContext sc)
            throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());

        long pk = counterLocalService.increment();

        SaisineObservatoire saisineObservatoire = this.saisineObservatoireLocalService.createSaisineObservatoire(pk);

        saisineObservatoire.setGroupId(sc.getScopeGroupId());
        saisineObservatoire.setUserName(user.getFullName());
        saisineObservatoire.setUserId(sc.getUserId());

        saisineObservatoire.setStatus(WorkflowConstants.STATUS_DRAFT);

        return saisineObservatoire;
    }

    @Override
    public SaisineObservatoire updateSaisineObservatoire(SaisineObservatoire saisineObservatoire, ServiceContext sc) throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());

        if (user != null) {
            saisineObservatoire.setStatusByUserId(sc.getUserId());
            saisineObservatoire.setStatusByUserName(user.getFullName());
            saisineObservatoire.setStatusDate(sc.getModifiedDate());
        }

        if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
            saisineObservatoire.setStatus(WorkflowConstants.STATUS_APPROVED);
        } else {
            saisineObservatoire.setStatus(WorkflowConstants.STATUS_DRAFT);
        }

        updateSaisineObservatoire(saisineObservatoire);
        updateAssetEntry(saisineObservatoire, sc);
        reindex(saisineObservatoire, false);

        this.updateAllSaisineObservatoireStatus();

        return saisineObservatoire;
    }

    /**
     * Met à jour l'AssetEntry rattachée à la petition
     */
    private void updateAssetEntry(SaisineObservatoire saisineObservatoire, ServiceContext sc)
            throws PortalException {
        assetEntryLocalService.updateEntry(sc.getUserId(), sc.getScopeGroupId(), saisineObservatoire.getCreateDate(),
                saisineObservatoire.getModifiedDate(), SaisineObservatoire.class.getName(), saisineObservatoire.getPrimaryKey(), null,
                0, sc.getAssetCategoryIds(), sc.getAssetTagNames(), true, saisineObservatoire.isApproved(),
                saisineObservatoire.getCreateDate(), null, saisineObservatoire.getCreateDate(), null, ContentTypes.TEXT_HTML,
                saisineObservatoire.getTitle(), saisineObservatoire.getDescription(), saisineObservatoire.getDescription(), null, null,
                0, 0, null);
        reindex(saisineObservatoire, false);
    }

    @Override
    public void updateAllSaisineObservatoireStatus() throws PortalException {
        _log.info("Start checking saisines status");

        // Recupere l'ID par defaut du portal
        long companyId = PortalUtil.getDefaultCompanyId();
        int saisineObservatoireUpdatedCount = 0;
        // Recupere le groupe du site via son nom
        Group group = GroupLocalServiceUtil.getFriendlyURLGroup(companyId, FriendlyURLs.PLACIT_URL);
        long groupId = group.getGroupId();
        List<SaisineObservatoire> saisineObservatoireList = getPublishedByGroupId(groupId);

        long vocId = AssetVocabularyHelper.getVocabulary(VocabularyNames.PLACIT_STATUS, groupId).getVocabularyId();
        AssetEntry entry = null;
        AssetCategory removedCategory = null;
        AssetCategory addedCategory = null;
        if (saisineObservatoireList != null && !saisineObservatoireList.isEmpty()) {
            for (SaisineObservatoire saisineObservatoire : saisineObservatoireList) {
                entry = saisineObservatoire.getAssetEntry();
                // Cherche le precedent statut
                for (AssetCategory cat : entry.getCategories()) {
                    if (cat.getVocabularyId() == vocId) {
                        removedCategory = cat;
                    }
                }
                String saisineObservatoireStatus = saisineObservatoire.getSaisineObservatoireStatus();
                if (ACCEPTED.getName().equals(saisineObservatoireStatus))
                    addedCategory = AssetVocabularyHelper.getCategory("accepted", groupId);
                else if (REFUSED.getName().equals(saisineObservatoireStatus))
                    addedCategory = AssetVocabularyHelper.getCategory("refused", groupId);
                else if (DRAFT.getName().equals(saisineObservatoireStatus))
                    addedCategory = AssetVocabularyHelper.getCategory("draft", groupId);
                else
                    addedCategory = AssetVocabularyHelper.getCategory("draft", groupId);

                // Si il y a eu changement de statut
                boolean isChanged = removedCategory != null && removedCategory.getCategoryId() != addedCategory.getCategoryId();
                if (isChanged) {
                    AssetVocabularyHelper.removeCategoryToAssetEntry(removedCategory, entry);
                }

                // Ajoute la categorie
                if ((addedCategory != null && removedCategory == null) || (addedCategory != null && isChanged)) {
                    AssetVocabularyHelper.addCategoryToAssetEntry(addedCategory, entry);
                    this.reindex(saisineObservatoire, false);
                    saisineObservatoireUpdatedCount++;
                }
            }
        }

        _log.info("Updated " + saisineObservatoireUpdatedCount + " saisines status");
    }

    /**
     * Supprime une saisine
     */
    @Override
    public SaisineObservatoire removeSaisineObservatoire(long saisineObservatoireId) throws PortalException {
        AssetEntry entry = AssetEntryLocalServiceUtil
                .fetchEntry(SaisineObservatoire.class.getName(), saisineObservatoireId);

        if (entry != null) {
            // Delete the link with categories
            AssetEntryAssetCategoryRelLocalServiceUtil.
                    deleteAssetEntryAssetCategoryRelByAssetEntryId(entry.getEntryId());

            // Delete the link with tags
            long[] tagIds = AssetEntryLocalServiceUtil
                    .getAssetTagPrimaryKeys(entry.getEntryId());
            if (tagIds != null && tagIds.length > 0) {
                for (long tagId : tagIds) {
                    AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagId,
                            entry.getEntryId());
                }
            }

            // Supprime lien avec les autres entries
            List<AssetLink> links = AssetLinkLocalServiceUtil
                    .getLinks(entry.getEntryId());
            if (links != null && !links.isEmpty()) {
                for (AssetLink link : links) {
                    this.assetLinkLocalService.deleteAssetLink(link);
                }
            }

            // Delete the AssetEntry
            AssetEntryLocalServiceUtil.deleteEntry(SaisineObservatoire.class.getName(),
                    saisineObservatoireId);

            // Supprime les lieux
            List<PlacitPlace> placitPlaces = this.placitPlaceLocalService
                    .getBySaisineObservatoire(saisineObservatoireId);
            if (placitPlaces != null && !placitPlaces.isEmpty()) {
                for (PlacitPlace placitPlace : placitPlaces) {
                    this.placitPlaceLocalService.removePlacitPlace(
                            placitPlace.getPlacitPlaceId());
                }
            }

            // Supprime les Comments
            try {
                // Récupère uniquement les commentaires de niveau 1, les enfants sont gérés par la méthode de supprssion
                List<Comment> comments = CommentLocalServiceUtil.getByAssetEntryAndLevel(entry.getEntryId(), 1, 0);
                if (comments != null && !comments.isEmpty()) {
                    for (Comment comment : comments) {
                        CommentLocalServiceUtil.removeComment(comment.getCommentId());
                    }
                }
            } catch (NoSuchCommentException e) {
                _log.error(e);
            }
        }

        // Supprime la saisine
        SaisineObservatoire saisineObservatoire = saisineObservatoirePersistence.remove(saisineObservatoireId);

        // Delete the index
        this.reindex(saisineObservatoire, true);

        // Supprime ce qui a rapport au workflow
        WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
                saisineObservatoire.getCompanyId(), saisineObservatoire.getGroupId(), SaisineObservatoire.class.getName(),
                saisineObservatoire.getSaisineObservatoireId());
        return saisineObservatoire;
    }

    /**
     * Reindex la saisine dans le moteur de recherche
     */
    private void reindex(SaisineObservatoire saisineObservatoire, boolean delete) throws SearchException {
        Indexer<SaisineObservatoire> indexer = IndexerRegistryUtil
                .nullSafeGetIndexer(SaisineObservatoire.class);
        if (delete) {
            indexer.delete(saisineObservatoire);
        } else {
            indexer.reindex(saisineObservatoire);
        }
    }

    @Override
    public List<SaisineObservatoire> findByKeyword(String keyword, long groupId, int start, int end) {
        DynamicQuery dynamicQuery = dynamicQuery();
        if (keyword.length() > 0) {
            dynamicQuery.add(
                    RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery
                    .add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }
        return saisineObservatoirePersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Recherche par mot clés (compte)
     */
    @Override
    public long findByKeywordCount(String keyword, long groupId) {
        DynamicQuery dynamicQuery = dynamicQuery();
        if (keyword.length() > 0) {
            dynamicQuery.add(
                    RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery
                    .add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }
        return saisineObservatoirePersistence.countWithDynamicQuery(dynamicQuery);
    }

    /**
     * Retourne toutes les saisines publiées d'un groupe
     */
    @Override
    public List<SaisineObservatoire> getPublishedByGroupId(long groupId) {
        return this.saisineObservatoirePersistence.findByStatusAndGroupId(WorkflowConstants.STATUS_APPROVED, groupId);
    }

    @Override
    public List<SaisineObservatoire> getTheMostCommented(long groupId) {
        List<SaisineObservatoire> saisineObservatoireList = getPublishedByGroupId(groupId);
        Comparator<SaisineObservatoire> reversedCommentSizeComparator
                = Comparator.comparingInt(SaisineObservatoire::getNbApprovedComments).reversed();
        List<SaisineObservatoire> temp = saisineObservatoireList.stream()
                .sorted(reversedCommentSizeComparator)
                .collect(Collectors.toList());
        if (temp.size() < 3) {
            return temp;
        }
        else {
            return temp.stream().limit(3).collect(Collectors.toList());
        }
    }

    @Override
    public List<SaisineObservatoire> getByPublikUserID(String publikId){
        return saisineObservatoirePersistence.findByPublikId(publikId);
    }

    @Reference
    private AssetLinkLocalService assetLinkLocalService;
}