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

package eu.strasbourg.service.council.service.base;

import com.liferay.asset.kernel.service.persistence.AssetEntryPersistence;
import com.liferay.asset.kernel.service.persistence.AssetLinkPersistence;
import com.liferay.asset.kernel.service.persistence.AssetTagPersistence;
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

import eu.strasbourg.service.council.model.Official;
import eu.strasbourg.service.council.service.OfficialService;
import eu.strasbourg.service.council.service.persistence.CouncilSessionPersistence;
import eu.strasbourg.service.council.service.persistence.DeliberationPersistence;
import eu.strasbourg.service.council.service.persistence.OfficialPersistence;
import eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPersistence;
import eu.strasbourg.service.council.service.persistence.ProcurationPersistence;
import eu.strasbourg.service.council.service.persistence.TypePersistence;
import eu.strasbourg.service.council.service.persistence.VotePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the official remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link eu.strasbourg.service.council.service.impl.OfficialServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see eu.strasbourg.service.council.service.impl.OfficialServiceImpl
 * @generated
 */
public abstract class OfficialServiceBaseImpl
	extends BaseServiceImpl
	implements OfficialService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>OfficialService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>eu.strasbourg.service.council.service.OfficialServiceUtil</code>.
	 */

	/**
	 * Returns the council session local service.
	 *
	 * @return the council session local service
	 */
	public eu.strasbourg.service.council.service.CouncilSessionLocalService
		getCouncilSessionLocalService() {

		return councilSessionLocalService;
	}

	/**
	 * Sets the council session local service.
	 *
	 * @param councilSessionLocalService the council session local service
	 */
	public void setCouncilSessionLocalService(
		eu.strasbourg.service.council.service.CouncilSessionLocalService
			councilSessionLocalService) {

		this.councilSessionLocalService = councilSessionLocalService;
	}

	/**
	 * Returns the council session persistence.
	 *
	 * @return the council session persistence
	 */
	public CouncilSessionPersistence getCouncilSessionPersistence() {
		return councilSessionPersistence;
	}

	/**
	 * Sets the council session persistence.
	 *
	 * @param councilSessionPersistence the council session persistence
	 */
	public void setCouncilSessionPersistence(
		CouncilSessionPersistence councilSessionPersistence) {

		this.councilSessionPersistence = councilSessionPersistence;
	}

	/**
	 * Returns the deliberation local service.
	 *
	 * @return the deliberation local service
	 */
	public eu.strasbourg.service.council.service.DeliberationLocalService
		getDeliberationLocalService() {

		return deliberationLocalService;
	}

	/**
	 * Sets the deliberation local service.
	 *
	 * @param deliberationLocalService the deliberation local service
	 */
	public void setDeliberationLocalService(
		eu.strasbourg.service.council.service.DeliberationLocalService
			deliberationLocalService) {

		this.deliberationLocalService = deliberationLocalService;
	}

	/**
	 * Returns the deliberation remote service.
	 *
	 * @return the deliberation remote service
	 */
	public eu.strasbourg.service.council.service.DeliberationService
		getDeliberationService() {

		return deliberationService;
	}

	/**
	 * Sets the deliberation remote service.
	 *
	 * @param deliberationService the deliberation remote service
	 */
	public void setDeliberationService(
		eu.strasbourg.service.council.service.DeliberationService
			deliberationService) {

		this.deliberationService = deliberationService;
	}

	/**
	 * Returns the deliberation persistence.
	 *
	 * @return the deliberation persistence
	 */
	public DeliberationPersistence getDeliberationPersistence() {
		return deliberationPersistence;
	}

	/**
	 * Sets the deliberation persistence.
	 *
	 * @param deliberationPersistence the deliberation persistence
	 */
	public void setDeliberationPersistence(
		DeliberationPersistence deliberationPersistence) {

		this.deliberationPersistence = deliberationPersistence;
	}

	/**
	 * Returns the official local service.
	 *
	 * @return the official local service
	 */
	public eu.strasbourg.service.council.service.OfficialLocalService
		getOfficialLocalService() {

		return officialLocalService;
	}

	/**
	 * Sets the official local service.
	 *
	 * @param officialLocalService the official local service
	 */
	public void setOfficialLocalService(
		eu.strasbourg.service.council.service.OfficialLocalService
			officialLocalService) {

		this.officialLocalService = officialLocalService;
	}

	/**
	 * Returns the official remote service.
	 *
	 * @return the official remote service
	 */
	public OfficialService getOfficialService() {
		return officialService;
	}

	/**
	 * Sets the official remote service.
	 *
	 * @param officialService the official remote service
	 */
	public void setOfficialService(OfficialService officialService) {
		this.officialService = officialService;
	}

	/**
	 * Returns the official persistence.
	 *
	 * @return the official persistence
	 */
	public OfficialPersistence getOfficialPersistence() {
		return officialPersistence;
	}

	/**
	 * Sets the official persistence.
	 *
	 * @param officialPersistence the official persistence
	 */
	public void setOfficialPersistence(
		OfficialPersistence officialPersistence) {

		this.officialPersistence = officialPersistence;
	}

	/**
	 * Returns the official type council local service.
	 *
	 * @return the official type council local service
	 */
	public eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
		getOfficialTypeCouncilLocalService() {

		return officialTypeCouncilLocalService;
	}

	/**
	 * Sets the official type council local service.
	 *
	 * @param officialTypeCouncilLocalService the official type council local service
	 */
	public void setOfficialTypeCouncilLocalService(
		eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
			officialTypeCouncilLocalService) {

		this.officialTypeCouncilLocalService = officialTypeCouncilLocalService;
	}

	/**
	 * Returns the official type council persistence.
	 *
	 * @return the official type council persistence
	 */
	public OfficialTypeCouncilPersistence getOfficialTypeCouncilPersistence() {
		return officialTypeCouncilPersistence;
	}

	/**
	 * Sets the official type council persistence.
	 *
	 * @param officialTypeCouncilPersistence the official type council persistence
	 */
	public void setOfficialTypeCouncilPersistence(
		OfficialTypeCouncilPersistence officialTypeCouncilPersistence) {

		this.officialTypeCouncilPersistence = officialTypeCouncilPersistence;
	}

	/**
	 * Returns the procuration local service.
	 *
	 * @return the procuration local service
	 */
	public eu.strasbourg.service.council.service.ProcurationLocalService
		getProcurationLocalService() {

		return procurationLocalService;
	}

	/**
	 * Sets the procuration local service.
	 *
	 * @param procurationLocalService the procuration local service
	 */
	public void setProcurationLocalService(
		eu.strasbourg.service.council.service.ProcurationLocalService
			procurationLocalService) {

		this.procurationLocalService = procurationLocalService;
	}

	/**
	 * Returns the procuration remote service.
	 *
	 * @return the procuration remote service
	 */
	public eu.strasbourg.service.council.service.ProcurationService
		getProcurationService() {

		return procurationService;
	}

	/**
	 * Sets the procuration remote service.
	 *
	 * @param procurationService the procuration remote service
	 */
	public void setProcurationService(
		eu.strasbourg.service.council.service.ProcurationService
			procurationService) {

		this.procurationService = procurationService;
	}

	/**
	 * Returns the procuration persistence.
	 *
	 * @return the procuration persistence
	 */
	public ProcurationPersistence getProcurationPersistence() {
		return procurationPersistence;
	}

	/**
	 * Sets the procuration persistence.
	 *
	 * @param procurationPersistence the procuration persistence
	 */
	public void setProcurationPersistence(
		ProcurationPersistence procurationPersistence) {

		this.procurationPersistence = procurationPersistence;
	}

	/**
	 * Returns the type local service.
	 *
	 * @return the type local service
	 */
	public eu.strasbourg.service.council.service.TypeLocalService
		getTypeLocalService() {

		return typeLocalService;
	}

	/**
	 * Sets the type local service.
	 *
	 * @param typeLocalService the type local service
	 */
	public void setTypeLocalService(
		eu.strasbourg.service.council.service.TypeLocalService
			typeLocalService) {

		this.typeLocalService = typeLocalService;
	}

	/**
	 * Returns the type remote service.
	 *
	 * @return the type remote service
	 */
	public eu.strasbourg.service.council.service.TypeService getTypeService() {
		return typeService;
	}

	/**
	 * Sets the type remote service.
	 *
	 * @param typeService the type remote service
	 */
	public void setTypeService(
		eu.strasbourg.service.council.service.TypeService typeService) {

		this.typeService = typeService;
	}

	/**
	 * Returns the type persistence.
	 *
	 * @return the type persistence
	 */
	public TypePersistence getTypePersistence() {
		return typePersistence;
	}

	/**
	 * Sets the type persistence.
	 *
	 * @param typePersistence the type persistence
	 */
	public void setTypePersistence(TypePersistence typePersistence) {
		this.typePersistence = typePersistence;
	}

	/**
	 * Returns the vote local service.
	 *
	 * @return the vote local service
	 */
	public eu.strasbourg.service.council.service.VoteLocalService
		getVoteLocalService() {

		return voteLocalService;
	}

	/**
	 * Sets the vote local service.
	 *
	 * @param voteLocalService the vote local service
	 */
	public void setVoteLocalService(
		eu.strasbourg.service.council.service.VoteLocalService
			voteLocalService) {

		this.voteLocalService = voteLocalService;
	}

	/**
	 * Returns the vote persistence.
	 *
	 * @return the vote persistence
	 */
	public VotePersistence getVotePersistence() {
		return votePersistence;
	}

	/**
	 * Sets the vote persistence.
	 *
	 * @param votePersistence the vote persistence
	 */
	public void setVotePersistence(VotePersistence votePersistence) {
		this.votePersistence = votePersistence;
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

	/**
	 * Returns the asset entry local service.
	 *
	 * @return the asset entry local service
	 */
	public com.liferay.asset.kernel.service.AssetEntryLocalService
		getAssetEntryLocalService() {

		return assetEntryLocalService;
	}

	/**
	 * Sets the asset entry local service.
	 *
	 * @param assetEntryLocalService the asset entry local service
	 */
	public void setAssetEntryLocalService(
		com.liferay.asset.kernel.service.AssetEntryLocalService
			assetEntryLocalService) {

		this.assetEntryLocalService = assetEntryLocalService;
	}

	/**
	 * Returns the asset entry remote service.
	 *
	 * @return the asset entry remote service
	 */
	public com.liferay.asset.kernel.service.AssetEntryService
		getAssetEntryService() {

		return assetEntryService;
	}

	/**
	 * Sets the asset entry remote service.
	 *
	 * @param assetEntryService the asset entry remote service
	 */
	public void setAssetEntryService(
		com.liferay.asset.kernel.service.AssetEntryService assetEntryService) {

		this.assetEntryService = assetEntryService;
	}

	/**
	 * Returns the asset entry persistence.
	 *
	 * @return the asset entry persistence
	 */
	public AssetEntryPersistence getAssetEntryPersistence() {
		return assetEntryPersistence;
	}

	/**
	 * Sets the asset entry persistence.
	 *
	 * @param assetEntryPersistence the asset entry persistence
	 */
	public void setAssetEntryPersistence(
		AssetEntryPersistence assetEntryPersistence) {

		this.assetEntryPersistence = assetEntryPersistence;
	}

	/**
	 * Returns the asset link local service.
	 *
	 * @return the asset link local service
	 */
	public com.liferay.asset.kernel.service.AssetLinkLocalService
		getAssetLinkLocalService() {

		return assetLinkLocalService;
	}

	/**
	 * Sets the asset link local service.
	 *
	 * @param assetLinkLocalService the asset link local service
	 */
	public void setAssetLinkLocalService(
		com.liferay.asset.kernel.service.AssetLinkLocalService
			assetLinkLocalService) {

		this.assetLinkLocalService = assetLinkLocalService;
	}

	/**
	 * Returns the asset link persistence.
	 *
	 * @return the asset link persistence
	 */
	public AssetLinkPersistence getAssetLinkPersistence() {
		return assetLinkPersistence;
	}

	/**
	 * Sets the asset link persistence.
	 *
	 * @param assetLinkPersistence the asset link persistence
	 */
	public void setAssetLinkPersistence(
		AssetLinkPersistence assetLinkPersistence) {

		this.assetLinkPersistence = assetLinkPersistence;
	}

	/**
	 * Returns the asset tag local service.
	 *
	 * @return the asset tag local service
	 */
	public com.liferay.asset.kernel.service.AssetTagLocalService
		getAssetTagLocalService() {

		return assetTagLocalService;
	}

	/**
	 * Sets the asset tag local service.
	 *
	 * @param assetTagLocalService the asset tag local service
	 */
	public void setAssetTagLocalService(
		com.liferay.asset.kernel.service.AssetTagLocalService
			assetTagLocalService) {

		this.assetTagLocalService = assetTagLocalService;
	}

	/**
	 * Returns the asset tag remote service.
	 *
	 * @return the asset tag remote service
	 */
	public com.liferay.asset.kernel.service.AssetTagService
		getAssetTagService() {

		return assetTagService;
	}

	/**
	 * Sets the asset tag remote service.
	 *
	 * @param assetTagService the asset tag remote service
	 */
	public void setAssetTagService(
		com.liferay.asset.kernel.service.AssetTagService assetTagService) {

		this.assetTagService = assetTagService;
	}

	/**
	 * Returns the asset tag persistence.
	 *
	 * @return the asset tag persistence
	 */
	public AssetTagPersistence getAssetTagPersistence() {
		return assetTagPersistence;
	}

	/**
	 * Sets the asset tag persistence.
	 *
	 * @param assetTagPersistence the asset tag persistence
	 */
	public void setAssetTagPersistence(
		AssetTagPersistence assetTagPersistence) {

		this.assetTagPersistence = assetTagPersistence;
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
		return OfficialService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Official.class;
	}

	protected String getModelClassName() {
		return Official.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = officialPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = eu.strasbourg.service.council.service.CouncilSessionLocalService.class
	)
	protected eu.strasbourg.service.council.service.CouncilSessionLocalService
		councilSessionLocalService;

	@BeanReference(type = CouncilSessionPersistence.class)
	protected CouncilSessionPersistence councilSessionPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.DeliberationLocalService.class
	)
	protected eu.strasbourg.service.council.service.DeliberationLocalService
		deliberationLocalService;

	@BeanReference(
		type = eu.strasbourg.service.council.service.DeliberationService.class
	)
	protected eu.strasbourg.service.council.service.DeliberationService
		deliberationService;

	@BeanReference(type = DeliberationPersistence.class)
	protected DeliberationPersistence deliberationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.OfficialLocalService.class
	)
	protected eu.strasbourg.service.council.service.OfficialLocalService
		officialLocalService;

	@BeanReference(type = OfficialService.class)
	protected OfficialService officialService;

	@BeanReference(type = OfficialPersistence.class)
	protected OfficialPersistence officialPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService.class
	)
	protected
		eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService
			officialTypeCouncilLocalService;

	@BeanReference(type = OfficialTypeCouncilPersistence.class)
	protected OfficialTypeCouncilPersistence officialTypeCouncilPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.ProcurationLocalService.class
	)
	protected eu.strasbourg.service.council.service.ProcurationLocalService
		procurationLocalService;

	@BeanReference(
		type = eu.strasbourg.service.council.service.ProcurationService.class
	)
	protected eu.strasbourg.service.council.service.ProcurationService
		procurationService;

	@BeanReference(type = ProcurationPersistence.class)
	protected ProcurationPersistence procurationPersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.TypeLocalService.class
	)
	protected eu.strasbourg.service.council.service.TypeLocalService
		typeLocalService;

	@BeanReference(
		type = eu.strasbourg.service.council.service.TypeService.class
	)
	protected eu.strasbourg.service.council.service.TypeService typeService;

	@BeanReference(type = TypePersistence.class)
	protected TypePersistence typePersistence;

	@BeanReference(
		type = eu.strasbourg.service.council.service.VoteLocalService.class
	)
	protected eu.strasbourg.service.council.service.VoteLocalService
		voteLocalService;

	@BeanReference(type = VotePersistence.class)
	protected VotePersistence votePersistence;

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

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryLocalService
		assetEntryLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetEntryService.class
	)
	protected com.liferay.asset.kernel.service.AssetEntryService
		assetEntryService;

	@ServiceReference(type = AssetEntryPersistence.class)
	protected AssetEntryPersistence assetEntryPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetLinkLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetLinkLocalService
		assetLinkLocalService;

	@ServiceReference(type = AssetLinkPersistence.class)
	protected AssetLinkPersistence assetLinkPersistence;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagLocalService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagLocalService
		assetTagLocalService;

	@ServiceReference(
		type = com.liferay.asset.kernel.service.AssetTagService.class
	)
	protected com.liferay.asset.kernel.service.AssetTagService assetTagService;

	@ServiceReference(type = AssetTagPersistence.class)
	protected AssetTagPersistence assetTagPersistence;

}