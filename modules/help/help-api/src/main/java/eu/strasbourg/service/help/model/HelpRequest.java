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

package eu.strasbourg.service.help.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the HelpRequest service. Represents a row in the &quot;help_HelpRequest&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see HelpRequestModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.help.model.impl.HelpRequestImpl"
)
@ProviderType
public interface HelpRequest extends HelpRequestModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.help.model.impl.HelpRequestImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<HelpRequest, Long> HELP_REQUEST_ID_ACCESSOR =
		new Accessor<HelpRequest, Long>() {

			@Override
			public Long get(HelpRequest helpRequest) {
				return helpRequest.getHelpRequestId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<HelpRequest> getTypeClass() {
				return HelpRequest.class;
			}

		};

	/**
	 * Retourne l'utilisateur Publik depositaire
	 *
	 * @return
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getAuthor();

	/**
	 * Retourne le nom de du depositaire sous forme "Truc M." ou le "Au nom de ..."
	 */
	public String getAuthorLabel();

	/**
	 * Retourne l'URL de l'image de l'utilisateur
	 */
	public String getAuthorImageURL();

	/**
	 * Retourne le message d'accompagnement sans les balises et autres fioritures
	 *
	 * @return
	 */
	public String getFormatedMessage();

	/**
	 * Retourne l'initiative de l'aide
	 *
	 * @return
	 * @throws PortalException
	 */
	public eu.strasbourg.service.help.model.HelpProposal getInitiative();

}