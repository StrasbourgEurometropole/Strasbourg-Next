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

package eu.strasbourg.service.council.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import eu.strasbourg.service.council.model.OfficialTypeCouncil;
import eu.strasbourg.service.council.service.base.OfficialTypeCouncilLocalServiceBaseImpl;
import eu.strasbourg.service.council.service.persistence.OfficialTypeCouncilPK;

import java.util.Date;
import java.util.List;

/**
 * The implementation of the official type council local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link eu.strasbourg.service.council.service.OfficialTypeCouncilLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see OfficialTypeCouncilLocalServiceBaseImpl
 * @see eu.strasbourg.service.council.service.OfficialTypeCouncilLocalServiceUtil
 */
public class OfficialTypeCouncilLocalServiceImpl
	extends OfficialTypeCouncilLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link eu.strasbourg.service.council.service.OfficialTypeCouncilLocalServiceUtil} to access the official type council local service.
	 */

	/**
	 *  Crée une entité vide avec une PK, non ajouté à la base de donnée
	 */
	@Override
	public OfficialTypeCouncil createOfficialTypeCouncil(long officialId, long typeId, ServiceContext sc) {

		OfficialTypeCouncilPK officialTypeCouncilPK = new OfficialTypeCouncilPK(officialId, typeId);
		OfficialTypeCouncil officialTypeCouncil = this.createOfficialTypeCouncil(officialTypeCouncilPK);

		officialTypeCouncil.setGroupId(sc.getScopeGroupId());
		officialTypeCouncil.setCreateDate(new Date());

		return officialTypeCouncil;
	}

	/**
	 * Retourne les types de Conseil d'un élu
	 * @return
	 */
	@Override
	public List<OfficialTypeCouncil> findByOfficialId(long officialId){
		return this.officialTypeCouncilPersistence.findByOfficialId(officialId);
	}

	/**
	 * Retourne la liste des votes d'une délibération
	 */
	@Override
	public List<OfficialTypeCouncil> findByTypeId(long typeId) {
		return this.officialTypeCouncilPersistence.findByTypeId(typeId);
	}

	/**
	 * Retourne le vote d'un élu pour une délibération
	 */
	@Override
	public OfficialTypeCouncil findByTypeIdandOfficialId(long typeId, long officialId) {
		return this.officialTypeCouncilPersistence.fetchByTypeIdAndOfficialId(typeId, officialId);
	}

	/**
	 * Supprime une entité
	 */
	@Override
	public OfficialTypeCouncil removeOfficialTypeCouncil(long  officialId, long  typeId) throws PortalException {
		OfficialTypeCouncilPK officialTypeCouncilPK = new OfficialTypeCouncilPK(officialId, typeId);
		return this.officialTypeCouncilPersistence.remove(officialTypeCouncilPK);
	}
}