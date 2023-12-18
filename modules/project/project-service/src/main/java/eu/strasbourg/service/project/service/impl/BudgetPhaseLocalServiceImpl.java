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

package eu.strasbourg.service.project.service.impl;

import com.liferay.asset.entry.rel.service.AssetEntryAssetCategoryRelLocalServiceUtil;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.kernel.model.AssetVocabulary;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetVocabularyLocalServiceUtil;
import com.liferay.asset.link.service.AssetLinkLocalService;
import com.liferay.asset.link.service.AssetLinkLocalServiceUtil;
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
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetPhase;
import eu.strasbourg.service.project.service.base.BudgetPhaseLocalServiceBaseImpl;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.LongStream;

/**
 * The implementation of the budget phase local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.project.service.BudgetPhaseLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Cedric Henry
 * @see BudgetPhaseLocalServiceBaseImpl
 * @see eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil
 */
public class BudgetPhaseLocalServiceImpl extends BudgetPhaseLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.project.service.BudgetPhaseLocalServiceUtil} to access the budget phase local service.
	 */
	
public final static Log log = LogFactoryUtil.getLog(ProjectLocalServiceImpl.class);
	
	/**
	 * Crée une phase vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public BudgetPhase createBudgetPhase(ServiceContext sc) throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());

		long pk = counterLocalService.increment();

		BudgetPhase budgetPhase = this.budgetPhaseLocalService.createBudgetPhase(pk);

		budgetPhase.setGroupId(sc.getScopeGroupId());
		budgetPhase.setUserName(user.getFullName());
		budgetPhase.setUserId(sc.getUserId());

		budgetPhase.setStatus(WorkflowConstants.STATUS_DRAFT);

		return budgetPhase;
	}

	/**
	 * Met à jour une phase et l'enregistre en base de données
	 * @throws IOException
	 */
	@Override
	public BudgetPhase updateBudgetPhase(BudgetPhase budgetPhase, ServiceContext sc)
			throws PortalException {
		User user = UserLocalServiceUtil.getUser(sc.getUserId());
		
		budgetPhase.setStatusByUserId(sc.getUserId());
		budgetPhase.setStatusByUserName(user.getFullName());
		budgetPhase.setStatusDate(sc.getModifiedDate());

		if (sc.getWorkflowAction() == WorkflowConstants.ACTION_PUBLISH) {
			budgetPhase.setStatus(WorkflowConstants.STATUS_APPROVED);
		} else {
			budgetPhase.setStatus(WorkflowConstants.STATUS_DRAFT);
		}
		
		budgetPhase = this.budgetPhaseLocalService.updateBudgetPhase(budgetPhase);
		
		this.updateAssetEntry(budgetPhase, sc);
		this.reindex(budgetPhase, false);

		return budgetPhase;
	}

	/**
	 * Met à jour l'AssetEntry rattachée à la phase
	 */
	private void updateAssetEntry(BudgetPhase budgetPhase, ServiceContext sc)
			throws PortalException {
		this.assetEntryLocalService.updateEntry(sc.getUserId(), // User ID
				sc.getScopeGroupId(), // Group ID
				budgetPhase.getCreateDate(), // Date of creation
				budgetPhase.getModifiedDate(), // Date of modification
				BudgetPhase.class.getName(), // Class name
				budgetPhase.getPrimaryKey(), // Class PK
				budgetPhase.getUuid(), // UUID
				0, // Class type ID
				sc.getAssetCategoryIds(), // Categories IDs
				sc.getAssetTagNames(), // Tags IDs
				true, // Listable
				budgetPhase.isApproved(), // Visible
				budgetPhase.getCreateDate(), // Start date
				null, // End date
				budgetPhase.getCreateDate(), // Publication date
				null, // Date of expiration
				ContentTypes.TEXT_HTML, // Content type
				budgetPhase.getTitle(), // Title
				budgetPhase.getDescription(), // Description
				budgetPhase.getDescription(), // Summary
				null, // URL
				null, // Layout uuid
				0, // Width
				0, // Height
				null); // Priority

		// Réindexe le projet
		this.reindex(budgetPhase, false);
	}

	/**
	 * Met à jour le statut de la phase par le framework workflow
	 */
	@Override
	public BudgetPhase updateStatus(long userId, long entryId, int status,
								ServiceContext sc, Map<String, Serializable> workflowContext)
			throws PortalException {
		
		Date now = new Date();
		
		// Statut de l'entité
		BudgetPhase budgetPhase = this.getBudgetPhase(entryId);
		budgetPhase.setStatus(status);
		User user = UserLocalServiceUtil.fetchUser(userId);
		if (user != null) {
			budgetPhase.setStatusByUserId(user.getUserId());
			budgetPhase.setStatusByUserName(user.getFullName());
		}
		budgetPhase.setStatusDate(new Date());
		budgetPhase = this.budgetPhaseLocalService.updateBudgetPhase(budgetPhase);

		// Statut de l'entry
		AssetEntry entry = this.assetEntryLocalService
				.getEntry(BudgetPhase.class.getName(), budgetPhase.getPrimaryKey());
		entry.setVisible(status == WorkflowConstants.STATUS_APPROVED);
		if (entry.isVisible()) {
			entry.setPublishDate(now);
		}
		this.assetEntryLocalService.updateAssetEntry(entry);

		this.reindex(budgetPhase, false);

		return budgetPhase;
	}

	/**
	 * Met à jour le statut de la phase "manuellement" (pas via le workflow)
	 */
	@Override
	public void updateStatus(BudgetPhase budgetPhase, int status) throws PortalException {
		this.updateStatus(budgetPhase.getUserId(), budgetPhase.getBudgetPhaseId(), status, null,
				null);
	}

	/**
	 * Supprime une phase
	 */
	@Override
	public BudgetPhase removeBudgetPhase(long budgetPhaseId) throws PortalException {
		
		AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(BudgetPhase.class.getName(), budgetPhaseId);

		if (entry != null) {
			// Delete the link with categories
			AssetEntryAssetCategoryRelLocalServiceUtil.
					deleteAssetEntryAssetCategoryRelByAssetEntryId(entry.getEntryId());
			// Delete the link with tags
			long[] tagIds = AssetEntryLocalServiceUtil.getAssetTagPrimaryKeys(entry.getEntryId());
			for (int i = 0; i < tagIds.length; i++) {
				AssetEntryLocalServiceUtil.deleteAssetTagAssetEntry(tagIds[i],
						entry.getEntryId());
			}

			// Supprime lien avec les autres entries
			List<AssetLink> links = AssetLinkLocalServiceUtil
					.getLinks(entry.getEntryId());
			for (AssetLink link : links) {
				this.assetLinkLocalService.deleteAssetLink(link);
			}

			// Delete the AssetEntry
			AssetEntryLocalServiceUtil.deleteEntry(BudgetPhase.class.getName(),
					budgetPhaseId);
		}

		// Supprime les BudgetParticipatif
		List<BudgetParticipatif> budgets = this.budgetParticipatifLocalService.getByBudgetPhase(budgetPhaseId);
		if (budgets != null && !budgets.isEmpty()) {
			for (BudgetParticipatif budget : budgets) {
				this.budgetParticipatifLocalService.removeBudgetParticipatif(budget.getBudgetParticipatifId());
			}
		}

		// Supprime le projet
		BudgetPhase budgetPhase = budgetPhasePersistence.remove(budgetPhaseId);

		// Delete the index
		this.reindex(budgetPhase, true);

		// Supprime ce qui a rapport au workflow
		WorkflowInstanceLinkLocalServiceUtil.deleteWorkflowInstanceLinks(
				budgetPhase.getCompanyId(), budgetPhase.getGroupId(), BudgetPhase.class.getName(),
				budgetPhase.getBudgetPhaseId());

		return budgetPhase;
	}

	/**
	 * Reindex la phase dans le moteur de recherche
	 */
	private void reindex(BudgetPhase budgetPhase, boolean delete) throws SearchException {
		Indexer<BudgetPhase> indexer = IndexerRegistryUtil
				.nullSafeGetIndexer(BudgetPhase.class);
		if (delete) {
			indexer.delete(budgetPhase);
		} else {
			indexer.reindex(budgetPhase);
		}
	}

	/**
	 * Renvoie la liste des vocabulaires rattachés à uen phase
	 */
	@Override
	public List<AssetVocabulary> getAttachedVocabularies(long groupId) {
		List<AssetVocabulary> vocabularies = AssetVocabularyLocalServiceUtil
				.getAssetVocabularies(-1, -1);
		List<AssetVocabulary> attachedVocabularies = new ArrayList<AssetVocabulary>();
		long classNameId = ClassNameLocalServiceUtil
				.getClassNameId(BudgetPhase.class);
		for (AssetVocabulary vocabulary : vocabularies) {
			if (vocabulary.getGroupId() == groupId
					&& LongStream.of(vocabulary.getSelectedClassNameIds())
					.anyMatch(c -> c == classNameId)) {
				attachedVocabularies.add(vocabulary);
			}
		}
		return attachedVocabularies;
	}
	
	/**
	 * Recherche par mot clés
	 */
	@Override
	public List<BudgetPhase> findByKeyword(String keyword, long groupId, int start, int end) {
		DynamicQuery dynamicQuery = dynamicQuery();

		if (keyword.length() > 0) {
			dynamicQuery.add(RestrictionsFactoryUtil.like("title", "%" + keyword + "%"));
		}
		if (groupId > 0) {
			dynamicQuery.add(PropertyFactoryUtil.forName("groupId").eq(groupId));
		}
		
		return budgetPhasePersistence.findWithDynamicQuery(dynamicQuery, start, end);
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
		return budgetPhasePersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Retourne toutes les phases d'un groupe
	 */
	@Override
	public List<BudgetPhase> getByGroupId(long groupId) {
		return this.budgetPhasePersistence.findByGroupId(groupId);
	}
	
	/**
	 * Retourne les phases d'un groupe ayant un statut actif (champ isActive et non le 
	 * statut du workFlow Liferay)
	 */
	@Override
	public List<BudgetPhase> getByIsActiveAndGroupId(boolean isActive, long groupId) {
		return this.budgetPhasePersistence.findByIsActiveAndGroupId(isActive, groupId);
	}
	
	/**
	 * Retourne la phase active si elle existe
	 * @param groupId ID du site
	 */
	@Override
	public BudgetPhase getActivePhase(long groupId) {
		List<BudgetPhase> budgetPhases = this.getByIsActiveAndGroupId(true, groupId);
		if (budgetPhases.size() > 0) {
			return budgetPhases.get(0);
		} else {
			return null;
		}
	}

	@Reference
	private AssetLinkLocalService assetLinkLocalService;
}