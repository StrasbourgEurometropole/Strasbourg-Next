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

package eu.strasbourg.service.help.model.impl;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.help.model.HelpProposal;
import eu.strasbourg.service.help.model.HelpRequest;
import eu.strasbourg.service.help.service.HelpProposalLocalServiceUtil;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model implementation for the HelpRequest service. Represents a row in the &quot;help_HelpRequest&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>eu.strasbourg.service.help.model.HelpRequest<code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
@ProviderType
public class HelpRequestImpl extends HelpRequestBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a help request model instance should use the {@link eu.strasbourg.service.help.model.HelpRequest} interface instead.
	 */
	public HelpRequestImpl() {
	}

	/**
	 * Retourne l'AssetEntry rattaché a cette proposition d'aide
	 */
	@Override
	public AssetEntry getAssetEntry() {
		return AssetEntryLocalServiceUtil.fetchEntry(HelpRequest.class.getName(),
				this.getHelpRequestId());
	}

	/**
	 * Retourne l'utilisateur Publik depositaire
	 * @return
	 */
	@Override
	public PublikUser getAuthor() {
		return PublikUserLocalServiceUtil.getByPublikUserId(this.getPublikId());
	}

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	@Override
	public String getAuthorLabel() {
		PublikUser author = this.getAuthor();
		if (author != null) {
			return StringUtil.upperCaseFirstLetter(author.getFirstName())
					+ " "
					+  StringUtil.toUpperCase(StringUtil.shorten(author.getLastName(), 2, "."));
		} else {
			return null;
		}
	}

	/**
	 * Retourne le nom prenom du depositaire s'il existe
	 */
	@Override
	public String getAuthorNameLabel() {
		PublikUser author = this.getAuthor();
		if (author != null) {
			return author.getFirstName()
					+ " "
					+  author.getLastName();
		} else {
			return "";
		}
	}

	/**
	 * Retourne l'email du demandeur d'aide
	 */
	@Override
	public String getAuthorEmail() {
		PublikUser author = this.getAuthor();
		if (author != null) {
			return author.getEmail();
		} else {
			return null;
		}
	}

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	@Override
	public String getAuthorImageURL() {
		PublikUser author =  this.getAuthor();
		if (author != null) {
			return author.getImageURLOrSurrogate();
		}
		return "";
	}

	/**
	 * Retourne le message d'accompagnement sans les balises et autres fioritures
	 * @return
	 */
	@Override
	public String getFormatedMessage() {
		return HtmlUtil.stripHtml(HtmlUtil.escape(this.getMessage()));
	}


	/**
	 * Retourne la proposition d'aide de la demande
	 * @return
	 * @throws PortalException
	 */
	@Override
	public HelpProposal getHelpProposal() {
		try {
			return HelpProposalLocalServiceUtil.getHelpProposal(this.getHelpProposalId());
		} catch (PortalException e) {
			e.printStackTrace();
			return null;
		}
	}
}