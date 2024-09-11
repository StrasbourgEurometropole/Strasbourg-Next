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
import com.liferay.asset.link.model.AssetLink;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.WorkflowInstanceLinkLocalServiceUtil;
import eu.strasbourg.service.comment.exception.NoSuchCommentException;
import eu.strasbourg.service.comment.model.Comment;
import eu.strasbourg.service.comment.service.CommentLocalServiceUtil;
import eu.strasbourg.service.like.model.Like;
import eu.strasbourg.service.like.model.LikeType;
import eu.strasbourg.service.like.service.LikeLocalServiceUtil;
import eu.strasbourg.service.project.model.Petition;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.model.SaisineObservatoire;
import eu.strasbourg.service.project.model.Signataire;
import eu.strasbourg.service.project.service.base.SaisineObservatoireServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the saisine observatoire remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.project.service.SaisineObservatoireService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Joshua Chacha
 * @see SaisineObservatoireServiceBaseImpl
 */
public class SaisineObservatoireServiceImpl
        extends SaisineObservatoireServiceBaseImpl {

    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this class directly. Always use <code>eu.strasbourg.service.project.service.SaisineObservatoireServiceUtil</code> to access the saisine observatoire remote service.
     */

}