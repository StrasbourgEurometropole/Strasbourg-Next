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
 * The extended model interface for the FormSendRecordField service. Represents a row in the &quot;formSendRecordField_FormSendRecordField&quot; database table, with each column mapped to a property of this class.
 *
 * @author Angélique Zunino
 * @see FormSendRecordFieldModel
 * @generated
 */
@ImplementationClassName(
	"eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldImpl"
)
@ProviderType
public interface FormSendRecordField
	extends FormSendRecordFieldModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>eu.strasbourg.service.formSendRecordField.model.impl.FormSendRecordFieldImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<FormSendRecordField, Long>
		FORM_SEND_RECORD_FIELD_ID_ACCESSOR =
			new Accessor<FormSendRecordField, Long>() {

				@Override
				public Long get(FormSendRecordField formSendRecordField) {
					return formSendRecordField.getFormSendRecordFieldId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<FormSendRecordField> getTypeClass() {
					return FormSendRecordField.class;
				}

			};

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry();

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes();

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 * @see eu.strasbourg.service.like.model.LikeType
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public int getNbLikes();

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	public int getNbDislikes();

	/**
	 * méthode qui renvoie la liste des signalements d'une réponse.
	 *
	 * @return la liste des signalements
	 */
	public java.util.List
		<eu.strasbourg.service.formSendRecordField.model.
			FormSendRecordFieldSignalement> findSignalements();

	/**
	 * méthode qui renvoie le nombre de signalement pour un commentaire.
	 *
	 * @return le nombre de signalement en int.
	 */
	public int getCountSignalements();

}