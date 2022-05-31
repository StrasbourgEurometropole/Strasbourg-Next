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

package eu.strasbourg.service.project.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.service.BaseServiceImpl;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import eu.strasbourg.service.project.model.ProjectFollowed;
import eu.strasbourg.service.project.service.ProjectFollowedService;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifFinder;
import eu.strasbourg.service.project.service.persistence.BudgetParticipatifPersistence;
import eu.strasbourg.service.project.service.persistence.BudgetPhasePersistence;
import eu.strasbourg.service.project.service.persistence.BudgetSupportPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativeHelpPersistence;
import eu.strasbourg.service.project.service.persistence.InitiativePersistence;
import eu.strasbourg.service.project.service.persistence.ParticipationPersistence;
import eu.strasbourg.service.project.service.persistence.PetitionPersistence;
import eu.strasbourg.service.project.service.persistence.PlacitPlacePersistence;
import eu.strasbourg.service.project.service.persistence.ProjectFollowedPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectPersistence;
import eu.strasbourg.service.project.service.persistence.ProjectTimelinePersistence;
import eu.strasbourg.service.project.service.persistence.SignatairePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the project followed remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see eu.strasbourg.service.project.service.impl.ProjectFollowedServiceImpl
 * @generated
 */
public abstract class ProjectFollowedServiceBaseImpl
	extends BaseServiceImpl
	implements IdentifiableOSGiService, ProjectFollowedService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ProjectFollowedService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.project.service.ProjectFollowedServiceUtil</code>.
	 */

	/**
	 * Returns the budget participatif local service.
	 *
	 * @return the budget participatif local service
	 */
	public eu.strasbourg.service.project.service.BudgetParticipatifLocalService
		getBudgetParticipatifLocalService() {

		return budgetParticipatifLocalService;
	}

	/**
	 * Sets the budget participatif local service.
	 *
	 * @param budgetParticipatifLocalService the budget participatif local service
	 */
	public void setBudgetParticipatifLocalService(
		eu.strasbourg.service.project.service.BudgetParticipatifLocalService
			budgetParticipatifLocalService) {

		this.budgetParticipatifLocalService = budgetParticipatifLocalService;
	}

	/**
	 * Returns the budget participatif remote service.
	 *
	 * @return the budget participatif remote service
	 */
	public eu.strasbourg.service.project.service.BudgetParticipatifService
		getBudgetParticipatifService() {

		return budgetParticipatifService;
	}

	/**
	 * Sets the budget participatif remote service.
	 *
	 * @param budgetParticipatifService the budget participatif remote service
	 */
	public void setBudgetParticipatifService(
		eu.strasbourg.service.project.service.BudgetParticipatifService
			budgetParticipatifService) {

		this.budgetParticipatifService = budgetParticipatifService;
	}

	/**
	 * Returns the budget participatif persistence.
	 *
	 * @return the budget participatif persistence
	 */
	public BudgetParticipatifPersistence getBudgetParticipatifPersistence() {
		return budgetParticipatifPersistence;
	}

	/**
	 * Sets the budget participatif persistence.
	 *
	 * @param budgetParticipatifPersistence the budget participatif persistence
	 */
	public void setBudgetParticipatifPersistence(
		BudgetParticipatifPersistence budgetParticipatifPersistence) {

		this.budgetParticipatifPersistence = budgetParticipatifPersistence;
	}

	/**
	 * Returns the budget participatif finder.
	 *
	 * @return the budget participatif finder
	 */
	public BudgetParticipatifFinder getBudgetParticipatifFinder() {
		return budgetParticipatifFinder;
	}

	/**
	 * Sets the budget participatif finder.
	 *
	 * @param budgetParticipatifFinder the budget participatif finder
	 */
	public void setBudgetParticipatifFinder(
		BudgetParticipatifFinder budgetParticipatifFinder) {

		this.budgetParticipatifFinder = budgetParticipatifFinder;
	}

	/**
	 * Returns the budget phase local service.
	 *
	 * @return the budget phase local service
	 */
	public eu.strasbourg.service.project.service.BudgetPhaseLocalService
		getBudgetPhaseLocalService() {

		return budgetPhaseLocalService;
	}

	/**
	 * Sets the budget phase local service.
	 *
	 * @param budgetPhaseLocalService the budget phase local service
	 */
	public void setBudgetPhaseLocalService(
		eu.strasbourg.service.project.service.BudgetPhaseLocalService
			budgetPhaseLocalService) {

		this.budgetPhaseLocalService = budgetPhaseLocalService;
	}

	/**
	 * Returns the budget phase remote service.
	 *
	 * @return the budget phase remote service
	 */
	public eu.strasbourg.service.project.service.BudgetPhaseService
		getBudgetPhaseService() {

		return budgetPhaseService;
	}

	/**
	 * Sets the budget phase remote service.
	 *
	 * @param budgetPhaseService the budget phase remote service
	 */
	public void setBudgetPhaseService(
		eu.strasbourg.service.project.service.BudgetPhaseService
			budgetPhaseService) {

		this.budgetPhaseService = budgetPhaseService;
	}

	/**
	 * Returns the budget phase persistence.
	 *
	 * @return the budget phase persistence
	 */
	public BudgetPhasePersistence getBudgetPhasePersistence() {
		return budgetPhasePersistence;
	}

	/**
	 * Sets the budget phase persistence.
	 *
	 * @param budgetPhasePersistence the budget phase persistence
	 */
	public void setBudgetPhasePersistence(
		BudgetPhasePersistence budgetPhasePersistence) {

		this.budgetPhasePersistence = budgetPhasePersistence;
	}

	/**
	 * Returns the budget support local service.
	 *
	 * @return the budget support local service
	 */
	public eu.strasbourg.service.project.service.BudgetSupportLocalService
		getBudgetSupportLocalService() {

		return budgetSupportLocalService;
	}

	/**
	 * Sets the budget support local service.
	 *
	 * @param budgetSupportLocalService the budget support local service
	 */
	public void setBudgetSupportLocalService(
		eu.strasbourg.service.project.service.BudgetSupportLocalService
			budgetSupportLocalService) {

		this.budgetSupportLocalService = budgetSupportLocalService;
	}

	/**
	 * Returns the budget support remote service.
	 *
	 * @return the budget support remote service
	 */
	public eu.strasbourg.service.project.service.BudgetSupportService
		getBudgetSupportService() {

		return budgetSupportService;
	}

	/**
	 * Sets the budget support remote service.
	 *
	 * @param budgetSupportService the budget support remote service
	 */
	public void setBudgetSupportService(
		eu.strasbourg.service.project.service.BudgetSupportService
			budgetSupportService) {

		this.budgetSupportService = budgetSupportService;
	}

	/**
	 * Returns the budget support persistence.
	 *
	 * @return the budget support persistence
	 */
	public BudgetSupportPersistence getBudgetSupportPersistence() {
		return budgetSupportPersistence;
	}

	/**
	 * Sets the budget support persistence.
	 *
	 * @param budgetSupportPersistence the budget support persistence
	 */
	public void setBudgetSupportPersistence(
		BudgetSupportPersistence budgetSupportPersistence) {

		this.budgetSupportPersistence = budgetSupportPersistence;
	}

	/**
	 * Returns the initiative local service.
	 *
	 * @return the initiative local service
	 */
	public eu.strasbourg.service.project.service.InitiativeLocalService
		getInitiativeLocalService() {

		return initiativeLocalService;
	}

	/**
	 * Sets the initiative local service.
	 *
	 * @param initiativeLocalService the initiative local service
	 */
	public void setInitiativeLocalService(
		eu.strasbourg.service.project.service.InitiativeLocalService
			initiativeLocalService) {

		this.initiativeLocalService = initiativeLocalService;
	}

	/**
	 * Returns the initiative remote service.
	 *
	 * @return the initiative remote service
	 */
	public eu.strasbourg.service.project.service.InitiativeService
		getInitiativeService() {

		return initiativeService;
	}

	/**
	 * Sets the initiative remote service.
	 *
	 * @param initiativeService the initiative remote service
	 */
	public void setInitiativeService(
		eu.strasbourg.service.project.service.InitiativeService
			initiativeService) {

		this.initiativeService = initiativeService;
	}

	/**
	 * Returns the initiative persistence.
	 *
	 * @return the initiative persistence
	 */
	public InitiativePersistence getInitiativePersistence() {
		return initiativePersistence;
	}

	/**
	 * Sets the initiative persistence.
	 *
	 * @param initiativePersistence the initiative persistence
	 */
	public void setInitiativePersistence(
		InitiativePersistence initiativePersistence) {

		this.initiativePersistence = initiativePersistence;
	}

	/**
	 * Returns the initiative help local service.
	 *
	 * @return the initiative help local service
	 */
	public eu.strasbourg.service.project.service.InitiativeHelpLocalService
		getInitiativeHelpLocalService() {

		return initiativeHelpLocalService;
	}

	/**
	 * Sets the initiative help local service.
	 *
	 * @param initiativeHelpLocalService the initiative help local service
	 */
	public void setInitiativeHelpLocalService(
		eu.strasbourg.service.project.service.InitiativeHelpLocalService
			initiativeHelpLocalService) {

		this.initiativeHelpLocalService = initiativeHelpLocalService;
	}

	/**
	 * Returns the initiative help remote service.
	 *
	 * @return the initiative help remote service
	 */
	public eu.strasbourg.service.project.service.InitiativeHelpService
		getInitiativeHelpService() {

		return initiativeHelpService;
	}

	/**
	 * Sets the initiative help remote service.
	 *
	 * @param initiativeHelpService the initiative help remote service
	 */
	public void setInitiativeHelpService(
		eu.strasbourg.service.project.service.InitiativeHelpService
			initiativeHelpService) {

		this.initiativeHelpService = initiativeHelpService;
	}

	/**
	 * Returns the initiative help persistence.
	 *
	 * @return the initiative help persistence
	 */
	public InitiativeHelpPersistence getInitiativeHelpPersistence() {
		return initiativeHelpPersistence;
	}

	/**
	 * Sets the initiative help persistence.
	 *
	 * @param initiativeHelpPersistence the initiative help persistence
	 */
	public void setInitiativeHelpPersistence(
		InitiativeHelpPersistence initiativeHelpPersistence) {

		this.initiativeHelpPersistence = initiativeHelpPersistence;
	}

	/**
	 * Returns the participation local service.
	 *
	 * @return the participation local service
	 */
	public eu.strasbourg.service.project.service.ParticipationLocalService
		getParticipationLocalService() {

		return participationLocalService;
	}

	/**
	 * Sets the participation local service.
	 *
	 * @param participationLocalService the participation local service
	 */
	public void setParticipationLocalService(
		eu.strasbourg.service.project.service.ParticipationLocalService
			participationLocalService) {

		this.participationLocalService = participationLocalService;
	}

	/**
	 * Returns the participation remote service.
	 *
	 * @return the participation remote service
	 */
	public eu.strasbourg.service.project.service.ParticipationService
		getParticipationService() {

		return participationService;
	}

	/**
	 * Sets the participation remote service.
	 *
	 * @param participationService the participation remote service
	 */
	public void setParticipationService(
		eu.strasbourg.service.project.service.ParticipationService
			participationService) {

		this.participationService = participationService;
	}

	/**
	 * Returns the participation persistence.
	 *
	 * @return the participation persistence
	 */
	public ParticipationPersistence getParticipationPersistence() {
		return participationPersistence;
	}

	/**
	 * Sets the participation persistence.
	 *
	 * @param participationPersistence the participation persistence
	 */
	public void setParticipationPersistence(
		ParticipationPersistence participationPersistence) {

		this.participationPersistence = participationPersistence;
	}

	/**
	 * Returns the petition local service.
	 *
	 * @return the petition local service
	 */
	public eu.strasbourg.service.project.service.PetitionLocalService
		getPetitionLocalService() {

		return petitionLocalService;
	}

	/**
	 * Sets the petition local service.
	 *
	 * @param petitionLocalService the petition local service
	 */
	public void setPetitionLocalService(
		eu.strasbourg.service.project.service.PetitionLocalService
			petitionLocalService) {

		this.petitionLocalService = petitionLocalService;
	}

	/**
	 * Returns the petition remote service.
	 *
	 * @return the petition remote service
	 */
	public eu.strasbourg.service.project.service.PetitionService
		getPetitionService() {

		return petitionService;
	}

	/**
	 * Sets the petition remote service.
	 *
	 * @param petitionService the petition remote service
	 */
	public void setPetitionService(
		eu.strasbourg.service.project.service.PetitionService petitionService) {

		this.petitionService = petitionService;
	}

	/**
	 * Returns the petition persistence.
	 *
	 * @return the petition persistence
	 */
	public PetitionPersistence getPetitionPersistence() {
		return petitionPersistence;
	}

	/**
	 * Sets the petition persistence.
	 *
	 * @param petitionPersistence the petition persistence
	 */
	public void setPetitionPersistence(
		PetitionPersistence petitionPersistence) {

		this.petitionPersistence = petitionPersistence;
	}

	/**
	 * Returns the placit place local service.
	 *
	 * @return the placit place local service
	 */
	public eu.strasbourg.service.project.service.PlacitPlaceLocalService
		getPlacitPlaceLocalService() {

		return placitPlaceLocalService;
	}

	/**
	 * Sets the placit place local service.
	 *
	 * @param placitPlaceLocalService the placit place local service
	 */
	public void setPlacitPlaceLocalService(
		eu.strasbourg.service.project.service.PlacitPlaceLocalService
			placitPlaceLocalService) {

		this.placitPlaceLocalService = placitPlaceLocalService;
	}

	/**
	 * Returns the placit place remote service.
	 *
	 * @return the placit place remote service
	 */
	public eu.strasbourg.service.project.service.PlacitPlaceService
		getPlacitPlaceService() {

		return placitPlaceService;
	}

	/**
	 * Sets the placit place remote service.
	 *
	 * @param placitPlaceService the placit place remote service
	 */
	public void setPlacitPlaceService(
		eu.strasbourg.service.project.service.PlacitPlaceService
			placitPlaceService) {

		this.placitPlaceService = placitPlaceService;
	}

	/**
	 * Returns the placit place persistence.
	 *
	 * @return the placit place persistence
	 */
	public PlacitPlacePersistence getPlacitPlacePersistence() {
		return placitPlacePersistence;
	}

	/**
	 * Sets the placit place persistence.
	 *
	 * @param placitPlacePersistence the placit place persistence
	 */
	public void setPlacitPlacePersistence(
		PlacitPlacePersistence placitPlacePersistence) {

		this.placitPlacePersistence = placitPlacePersistence;
	}

	/**
	 * Returns the project local service.
	 *
	 * @return the project local service
	 */
	public eu.strasbourg.service.project.service.ProjectLocalService
		getProjectLocalService() {

		return projectLocalService;
	}

	/**
	 * Sets the project local service.
	 *
	 * @param projectLocalService the project local service
	 */
	public void setProjectLocalService(
		eu.strasbourg.service.project.service.ProjectLocalService
			projectLocalService) {

		this.projectLocalService = projectLocalService;
	}

	/**
	 * Returns the project remote service.
	 *
	 * @return the project remote service
	 */
	public eu.strasbourg.service.project.service.ProjectService
		getProjectService() {

		return projectService;
	}

	/**
	 * Sets the project remote service.
	 *
	 * @param projectService the project remote service
	 */
	public void setProjectService(
		eu.strasbourg.service.project.service.ProjectService projectService) {

		this.projectService = projectService;
	}

	/**
	 * Returns the project persistence.
	 *
	 * @return the project persistence
	 */
	public ProjectPersistence getProjectPersistence() {
		return projectPersistence;
	}

	/**
	 * Sets the project persistence.
	 *
	 * @param projectPersistence the project persistence
	 */
	public void setProjectPersistence(ProjectPersistence projectPersistence) {
		this.projectPersistence = projectPersistence;
	}

	/**
	 * Returns the project followed local service.
	 *
	 * @return the project followed local service
	 */
	public eu.strasbourg.service.project.service.ProjectFollowedLocalService
		getProjectFollowedLocalService() {

		return projectFollowedLocalService;
	}

	/**
	 * Sets the project followed local service.
	 *
	 * @param projectFollowedLocalService the project followed local service
	 */
	public void setProjectFollowedLocalService(
		eu.strasbourg.service.project.service.ProjectFollowedLocalService
			projectFollowedLocalService) {

		this.projectFollowedLocalService = projectFollowedLocalService;
	}

	/**
	 * Returns the project followed remote service.
	 *
	 * @return the project followed remote service
	 */
	public ProjectFollowedService getProjectFollowedService() {
		return projectFollowedService;
	}

	/**
	 * Sets the project followed remote service.
	 *
	 * @param projectFollowedService the project followed remote service
	 */
	public void setProjectFollowedService(
		ProjectFollowedService projectFollowedService) {

		this.projectFollowedService = projectFollowedService;
	}

	/**
	 * Returns the project followed persistence.
	 *
	 * @return the project followed persistence
	 */
	public ProjectFollowedPersistence getProjectFollowedPersistence() {
		return projectFollowedPersistence;
	}

	/**
	 * Sets the project followed persistence.
	 *
	 * @param projectFollowedPersistence the project followed persistence
	 */
	public void setProjectFollowedPersistence(
		ProjectFollowedPersistence projectFollowedPersistence) {

		this.projectFollowedPersistence = projectFollowedPersistence;
	}

	/**
	 * Returns the project timeline local service.
	 *
	 * @return the project timeline local service
	 */
	public eu.strasbourg.service.project.service.ProjectTimelineLocalService
		getProjectTimelineLocalService() {

		return projectTimelineLocalService;
	}

	/**
	 * Sets the project timeline local service.
	 *
	 * @param projectTimelineLocalService the project timeline local service
	 */
	public void setProjectTimelineLocalService(
		eu.strasbourg.service.project.service.ProjectTimelineLocalService
			projectTimelineLocalService) {

		this.projectTimelineLocalService = projectTimelineLocalService;
	}

	/**
	 * Returns the project timeline remote service.
	 *
	 * @return the project timeline remote service
	 */
	public eu.strasbourg.service.project.service.ProjectTimelineService
		getProjectTimelineService() {

		return projectTimelineService;
	}

	/**
	 * Sets the project timeline remote service.
	 *
	 * @param projectTimelineService the project timeline remote service
	 */
	public void setProjectTimelineService(
		eu.strasbourg.service.project.service.ProjectTimelineService
			projectTimelineService) {

		this.projectTimelineService = projectTimelineService;
	}

	/**
	 * Returns the project timeline persistence.
	 *
	 * @return the project timeline persistence
	 */
	public ProjectTimelinePersistence getProjectTimelinePersistence() {
		return projectTimelinePersistence;
	}

	/**
	 * Sets the project timeline persistence.
	 *
	 * @param projectTimelinePersistence the project timeline persistence
	 */
	public void setProjectTimelinePersistence(
		ProjectTimelinePersistence projectTimelinePersistence) {

		this.projectTimelinePersistence = projectTimelinePersistence;
	}

	/**
	 * Returns the signataire local service.
	 *
	 * @return the signataire local service
	 */
	public eu.strasbourg.service.project.service.SignataireLocalService
		getSignataireLocalService() {

		return signataireLocalService;
	}

	/**
	 * Sets the signataire local service.
	 *
	 * @param signataireLocalService the signataire local service
	 */
	public void setSignataireLocalService(
		eu.strasbourg.service.project.service.SignataireLocalService
			signataireLocalService) {

		this.signataireLocalService = signataireLocalService;
	}

	/**
	 * Returns the signataire remote service.
	 *
	 * @return the signataire remote service
	 */
	public eu.strasbourg.service.project.service.SignataireService
		getSignataireService() {

		return signataireService;
	}

	/**
	 * Sets the signataire remote service.
	 *
	 * @param signataireService the signataire remote service
	 */
	public void setSignataireService(
		eu.strasbourg.service.project.service.SignataireService
			signataireService) {

		this.signataireService = signataireService;
	}

	/**
	 * Returns the signataire persistence.
	 *
	 * @return the signataire persistence
	 */
	public SignatairePersistence getSignatairePersistence() {
		return signatairePersistence;
	}

	/**
	 * Sets the signataire persistence.
	 *
	 * @param signatairePersistence the signataire persistence
	 */
	public void setSignatairePersistence(
		SignatairePersistence signatairePersistence) {

		this.signatairePersistence = signatairePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name remote service.
	 *
	 * @return the class name remote service
	 */
	public com.liferay.portal.kernel.service.ClassNameService
		getClassNameService() {

		return classNameService;
	}

	/**
	 * Sets the class name remote service.
	 *
	 * @param classNameService the class name remote service
	 */
	public void setClassNameService(
		com.liferay.portal.kernel.service.ClassNameService classNameService) {

		this.classNameService = classNameService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.kernel.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.kernel.service.UserService userService) {

		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
	}

	public void destroy() {
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ProjectFollowedService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ProjectFollowed.class;
	}

	protected String getModelClassName() {
		return ProjectFollowed.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = projectFollowedPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetParticipatifLocalService.class
	)
	protected
		eu.strasbourg.service.project.service.BudgetParticipatifLocalService
			budgetParticipatifLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetParticipatifService.class
	)
	protected eu.strasbourg.service.project.service.BudgetParticipatifService
		budgetParticipatifService;

	@BeanReference(type = BudgetParticipatifPersistence.class)
	protected BudgetParticipatifPersistence budgetParticipatifPersistence;

	@BeanReference(type = BudgetParticipatifFinder.class)
	protected BudgetParticipatifFinder budgetParticipatifFinder;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetPhaseLocalService.class
	)
	protected eu.strasbourg.service.project.service.BudgetPhaseLocalService
		budgetPhaseLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetPhaseService.class
	)
	protected eu.strasbourg.service.project.service.BudgetPhaseService
		budgetPhaseService;

	@BeanReference(type = BudgetPhasePersistence.class)
	protected BudgetPhasePersistence budgetPhasePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetSupportLocalService.class
	)
	protected eu.strasbourg.service.project.service.BudgetSupportLocalService
		budgetSupportLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.BudgetSupportService.class
	)
	protected eu.strasbourg.service.project.service.BudgetSupportService
		budgetSupportService;

	@BeanReference(type = BudgetSupportPersistence.class)
	protected BudgetSupportPersistence budgetSupportPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeLocalService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeLocalService
		initiativeLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeService
		initiativeService;

	@BeanReference(type = InitiativePersistence.class)
	protected InitiativePersistence initiativePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeHelpLocalService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeHelpLocalService
		initiativeHelpLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.InitiativeHelpService.class
	)
	protected eu.strasbourg.service.project.service.InitiativeHelpService
		initiativeHelpService;

	@BeanReference(type = InitiativeHelpPersistence.class)
	protected InitiativeHelpPersistence initiativeHelpPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ParticipationLocalService.class
	)
	protected eu.strasbourg.service.project.service.ParticipationLocalService
		participationLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ParticipationService.class
	)
	protected eu.strasbourg.service.project.service.ParticipationService
		participationService;

	@BeanReference(type = ParticipationPersistence.class)
	protected ParticipationPersistence participationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PetitionLocalService.class
	)
	protected eu.strasbourg.service.project.service.PetitionLocalService
		petitionLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PetitionService.class
	)
	protected eu.strasbourg.service.project.service.PetitionService
		petitionService;

	@BeanReference(type = PetitionPersistence.class)
	protected PetitionPersistence petitionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PlacitPlaceLocalService.class
	)
	protected eu.strasbourg.service.project.service.PlacitPlaceLocalService
		placitPlaceLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.PlacitPlaceService.class
	)
	protected eu.strasbourg.service.project.service.PlacitPlaceService
		placitPlaceService;

	@BeanReference(type = PlacitPlacePersistence.class)
	protected PlacitPlacePersistence placitPlacePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectLocalService
		projectLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectService.class
	)
	protected eu.strasbourg.service.project.service.ProjectService
		projectService;

	@BeanReference(type = ProjectPersistence.class)
	protected ProjectPersistence projectPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectFollowedLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectFollowedLocalService
		projectFollowedLocalService;

	@BeanReference(type = ProjectFollowedService.class)
	protected ProjectFollowedService projectFollowedService;

	@BeanReference(type = ProjectFollowedPersistence.class)
	protected ProjectFollowedPersistence projectFollowedPersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectTimelineLocalService.class
	)
	protected eu.strasbourg.service.project.service.ProjectTimelineLocalService
		projectTimelineLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.ProjectTimelineService.class
	)
	protected eu.strasbourg.service.project.service.ProjectTimelineService
		projectTimelineService;

	@BeanReference(type = ProjectTimelinePersistence.class)
	protected ProjectTimelinePersistence projectTimelinePersistence;

	@BeanReference(
		type = eu.strasbourg.service.project.service.SignataireLocalService.class
	)
	protected eu.strasbourg.service.project.service.SignataireLocalService
		signataireLocalService;

	@BeanReference(
		type = eu.strasbourg.service.project.service.SignataireService.class
	)
	protected eu.strasbourg.service.project.service.SignataireService
		signataireService;

	@BeanReference(type = SignatairePersistence.class)
	protected SignatairePersistence signatairePersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameService
		classNameService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserService.class
	)
	protected com.liferay.portal.kernel.service.UserService userService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

}