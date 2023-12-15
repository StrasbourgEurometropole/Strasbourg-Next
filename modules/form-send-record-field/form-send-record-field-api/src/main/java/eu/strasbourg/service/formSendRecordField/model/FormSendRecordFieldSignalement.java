/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.formSendRecordField.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the FormSendRecordFieldSignalement service. Represents a row in the &quot;formSendRecordField_FormSendRecordFieldSignalement&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldSignalementModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementImpl"
)
@ProviderType
public interface FormSendRecordFieldSignalement
	extends FormSendRecordFieldSignalementModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldSignalementImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FormSendRecordFieldSignalement, Long>
		SIGNALEMENT_ID_ACCESSOR =
			new Accessor<FormSendRecordFieldSignalement, Long>() {

				@Override
				public Long get(
					FormSendRecordFieldSignalement
						formSendRecordFieldSignalement) {

					return formSendRecordFieldSignalement.getSignalementId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<FormSendRecordFieldSignalement> getTypeClass() {
					return FormSendRecordFieldSignalement.class;
				}

			};

	/**
	 * Retourne l'utilisateur auteur du signalement
	 */
	public eu.strasbourg.service.oidc.model.PublikUser getSignalementAuthor();

	/**
	 * Retourne le nom de l'auteur du signalement
	 */
	public String getSignalementAuthorLabel();

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategoriesByAssetEntry();

	public String getCategorieName();

}