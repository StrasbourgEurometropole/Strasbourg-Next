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

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil;
import eu.strasbourg.service.project.service.base.BudgetParticipatifLocalServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the budget participatif local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.project.service.BudgetParticipatifLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetParticipatifLocalServiceBaseImpl
 * @see eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil
 */
public class BudgetParticipatifLocalServiceImpl extends BudgetParticipatifLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use {@link eu.strasbourg.service.project.service.BudgetParticipatifLocalServiceUtil} to access the budget participatif local service.
     */

    /**
     * le logger
     */
    public final Log _log = LogFactoryUtil.getLog(this.getClass().getName());


    /**
     * Crée une participation vide avec une PK, non ajouté à la base de donnée
     */
    public BudgetParticipatif createBudgetParticipatif(ServiceContext sc)
            throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());

        long pk = counterLocalService.increment();

        BudgetParticipatif budget = this.budgetParticipatifLocalService.createBudgetParticipatif(pk);

        if (user != null) {
            budget.setUserName(user.getFullName());
            budget.setUserId(sc.getUserId());
        }

        budget.setGroupId(sc.getScopeGroupId());
        budget.setStatus(WorkflowConstants.STATUS_DRAFT);

        return budget;
    }

    @Override
    public void removeBudgetParticipatif(long budgetId) throws PortalException {
        AssetEntry entry = AssetEntryLocalServiceUtil
                .fetchEntry(BudgetParticipatif.class.getName(), budgetId);

        if (entry != null) {
            // Delete the link with categories
            for (long categoryId : entry.getCategoryIds()) {
                this.assetEntryLocalService.deleteAssetCategoryAssetEntry(
                        categoryId, entry.getEntryId());
            }

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
            List<AssetLink> links = this.assetLinkLocalService
                    .getLinks(entry.getEntryId());
            if (links != null && !links.isEmpty()) {
                for (AssetLink link : links) {
                    this.assetLinkLocalService.deleteAssetLink(link);
                }
            }

            // Delete the AssetEntry
            AssetEntryLocalServiceUtil.deleteEntry(BudgetParticipatif.class.getName(),
                    budgetId);

            // Supprime les lieux
            List<PlacitPlace> placitPlaces = this.placitPlaceLocalService
                    .getByPetition(budgetId);
            if (placitPlaces != null && !placitPlaces.isEmpty()) {
                for (PlacitPlace placitPlace : placitPlaces) {
                    this.placitPlaceLocalService.removePlacitPlace(
                            placitPlace.getPlacitPlaceId());
                }
            }

            // Supprime la petition
            BudgetParticipatif budgetParticipatif = budgetParticipatifPersistence.remove(budgetId);

            // Delete the index
            this.reindex(budgetParticipatif, true);

            // Supprime ce qui a rapport au workflow
            WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
                    budgetParticipatif.getCompanyId(), budgetParticipatif.getGroupId(), BudgetParticipatif.class.getName(),
                    budgetParticipatif.getBudgetParticipatifId());
            _log.info("BudgetParticipatif numero : " + budgetId + " supprimé");
        }
    }

    /**
     * Méthode de mise à jour d'un budget
     * @param budget le budget
     * @param sc le service context
     * @return le budget
     * @throws PortalException exception
     */
    public BudgetParticipatif updateBudgetParticipatif(BudgetParticipatif budget, ServiceContext sc) throws PortalException {
        User user = UserLocalServiceUtil.getUser(sc.getUserId());
        long groupId = sc.getThemeDisplay().getLayout().getGroupId();

        if (user != null) {
            budget.setStatusByUserId(sc.getUserId());
            budget.setStatusByUserName(user.getFullName());
            budget.setStatusDate(sc.getModifiedDate());
        }

        // Si la phase n'est pas definie, definir celle qui est active (si elle existe)
        if (budget.getBudgetPhaseId() < 1) {
            List<BudgetPhase> budgetPhaseActive = BudgetPhaseLocalServiceUtil.getByIsActiveAndGroupId(true, groupId);
            if (budgetPhaseActive.size() > 0) {
                budget.setBudgetPhaseId(budgetPhaseActive.get(0).getBudgetPhaseId());
            }
        }

        if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
            budget.setStatus(WorkflowConstants.STATUS_APPROVED);
        } else {
            budget.setStatus(WorkflowConstants.STATUS_DRAFT);
        }
        updateBudgetParticipatif(budget);
        updateAssetEntry(budget, sc);
        reindex(budget, false);
        return budget;
    }

    /**
     * Met à jour l'AssetEntry rattachée au budgetParticipatif
     */
    private void updateAssetEntry(BudgetParticipatif budget, ServiceContext sc)
            throws PortalException {
        assetEntryLocalService.updateEntry(sc.getUserId(), sc.getScopeGroupId(), budget.getCreateDate(),
                budget.getModifiedDate(), BudgetParticipatif.class.getName(), budget.getPrimaryKey(), budget.getUuid(),
                0, sc.getAssetCategoryIds(), sc.getAssetTagNames(), true, budget.isApproved(),
                budget.getCreateDate(), null, budget.getCreateDate(), null, ContentTypes.TEXT_HTML,
                budget.getTitle(), budget.getDescription(), budget.getDescription(), null, null,
                0, 0, null);
        reindex(budget, false);
    }

    /**
     * Reindex la budget dans le moteur de recherche
     */
    private void reindex(BudgetParticipatif budget, boolean delete) throws SearchException {
        Indexer<BudgetParticipatif> indexer = IndexerRegistryUtil
                .nullSafeGetIndexer(BudgetParticipatif.class);
        if (delete) {
            indexer.delete(budget);
        } else {
            indexer.reindex(budget);
        }
    }

    /**
     * Recherche par mot clés
     */
    @Override
    public List<BudgetParticipatif> findByKeyword(String keyword, long groupId, int start, int end) {
        DynamicQuery dynamicQuery = dynamicQuery();

        if (keyword.length() > 0) {
            dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }

        return budgetParticipatifPersistence.findWithDynamicQuery(dynamicQuery, start, end);
    }

    /**
     * Recherche par mot clés (compte)
     */
    @Override
    public long findByKeywordCount(String keyword, long groupId) {
        DynamicQuery dynamicQuery = dynamicQuery();
        if (keyword.length() > 0) {
            dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
        }
        if (groupId > 0) {
            dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
        }
        return budgetParticipatifPersistence.countWithDynamicQuery(dynamicQuery);
    }

}