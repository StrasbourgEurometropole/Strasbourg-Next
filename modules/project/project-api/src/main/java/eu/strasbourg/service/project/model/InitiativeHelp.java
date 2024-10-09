/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.project.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the InitiativeHelp service. Represents a row in the &quot;project_InitiativeHelp&quot; database table, with each column mapped to a property of this class.
 *
 * @author Cedric Henry
 * @see InitiativeHelpModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.project.model.impl.InitiativeHelpImpl"
)
@ProviderType
public interface InitiativeHelp extends InitiativeHelpModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.project.model.impl.InitiativeHelpImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<InitiativeHelp, Long>
		INITIATIVE_HELP_ID_ACCESSOR = new Accessor<InitiativeHelp, Long>() {

			@Override
			public Long get(InitiativeHelp initiativeHelp) {
				return initiativeHelp.getInitiativeHelpId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<InitiativeHelp> getTypeClass() {
				return InitiativeHelp.class;
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
	 * Retourne le label des types d'aide
	 */
	public String getTypesLabel();

	/**
	 * Retourne l'initiative de l'aide
	 *
	 * @return
	 * @throws PortalException
	 */
	public Initiative getInitiative();

}