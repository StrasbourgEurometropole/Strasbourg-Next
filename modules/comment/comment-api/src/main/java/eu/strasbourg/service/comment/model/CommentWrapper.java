/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.comment.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Comment}.
 * </p>
 *
 * @author Romain Vergnais
 * @see Comment
 * @generated
 */
public class CommentWrapper
	extends BaseModelWrapper<Comment>
	implements Comment, ModelWrapper<Comment> {

	public CommentWrapper(Comment comment) {
		super(comment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("commentId", getCommentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());
		attributes.put("statusByUserId", getStatusByUserId());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("statusDate", getStatusDate());
		attributes.put("text", getText());
		attributes.put("level", getLevel());
		attributes.put("userQuality", getUserQuality());
		attributes.put("modifiedByUserDate", getModifiedByUserDate());
		attributes.put("assetEntryId", getAssetEntryId());
		attributes.put("publikId", getPublikId());
		attributes.put("parentCommentId", getParentCommentId());
		attributes.put("urlProjectCommentaire", getUrlProjectCommentaire());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long commentId = (Long)attributes.get("commentId");

		if (commentId != null) {
			setCommentId(commentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long statusByUserId = (Long)attributes.get("statusByUserId");

		if (statusByUserId != null) {
			setStatusByUserId(statusByUserId);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		Date statusDate = (Date)attributes.get("statusDate");

		if (statusDate != null) {
			setStatusDate(statusDate);
		}

		String text = (String)attributes.get("text");

		if (text != null) {
			setText(text);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		String userQuality = (String)attributes.get("userQuality");

		if (userQuality != null) {
			setUserQuality(userQuality);
		}

		Date modifiedByUserDate = (Date)attributes.get("modifiedByUserDate");

		if (modifiedByUserDate != null) {
			setModifiedByUserDate(modifiedByUserDate);
		}

		Long assetEntryId = (Long)attributes.get("assetEntryId");

		if (assetEntryId != null) {
			setAssetEntryId(assetEntryId);
		}

		String publikId = (String)attributes.get("publikId");

		if (publikId != null) {
			setPublikId(publikId);
		}

		Long parentCommentId = (Long)attributes.get("parentCommentId");

		if (parentCommentId != null) {
			setParentCommentId(parentCommentId);
		}

		String urlProjectCommentaire = (String)attributes.get(
			"urlProjectCommentaire");

		if (urlProjectCommentaire != null) {
			setUrlProjectCommentaire(urlProjectCommentaire);
		}
	}

	@Override
	public Comment cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * méthode qui renvoie la liste des signalements d'un commentaire.
	 *
	 * @return la liste des signalements
	 */
	@Override
	public java.util.List<Signalement> findSignalements() {
		return model.findSignalements();
	}

	/**
	 * Retourne la liste des commentaires enfants de l'item
	 */
	@Override
	public java.util.List<Comment> getApprovedChildComments() {
		return model.getApprovedChildComments();
	}

	/**
	 * Retourne l'AssetEntry rattaché cet item
	 */
	@Override
	public com.liferay.asset.kernel.model.AssetEntry getAssetEntry() {
		return model.getAssetEntry();
	}

	/**
	 * Returns the asset entry ID of this comment.
	 *
	 * @return the asset entry ID of this comment
	 */
	@Override
	public long getAssetEntryId() {
		return model.getAssetEntryId();
	}

	@Override
	public String getAssetEntryTitle() {
		return model.getAssetEntryTitle();
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Renvoie la liste des AssetCategory rattachées à cet item (via
	 * l'assetEntry)
	 */
	@Override
	public java.util.List<com.liferay.asset.kernel.model.AssetCategory>
		getCategories() {

		return model.getCategories();
	}

	/**
	 * Returns the comment ID of this comment.
	 *
	 * @return the comment ID of this comment
	 */
	@Override
	public long getCommentId() {
		return model.getCommentId();
	}

	/**
	 * Returns the company ID of this comment.
	 *
	 * @return the company ID of this comment
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * méthode qui renvoie le nombre de signalement pour un commentaire.
	 *
	 * @return le nombre de signalement en int.
	 */
	@Override
	public int getCountSignalements() {
		return model.getCountSignalements();
	}

	/**
	 * Returns the create date of this comment.
	 *
	 * @return the create date of this comment
	 */
	@Override
	public Date getCreateDate() {
		return model.getCreateDate();
	}

	@Override
	public String getDefaultLanguageId() {
		return model.getDefaultLanguageId();
	}

	/**
	 * Retourne la liste des dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getDislikes() {
		return model.getDislikes();
	}

	/**
	 * méthode permettant de retourner le nom de l'utilisateur en entier.
	 *
	 * @return le nom de l'utilisateur.
	 */
	@Override
	public String getFullPublikUserName() {
		return model.getFullPublikUserName();
	}

	/**
	 * Returns the group ID of this comment.
	 *
	 * @return the group ID of this comment
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the level of this comment.
	 *
	 * @return the level of this comment
	 */
	@Override
	public int getLevel() {
		return model.getLevel();
	}

	/**
	 * Retourne la liste des likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like> getLikes() {
		return model.getLikes();
	}

	/**
	 * Retourne la liste des like/dislike de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public java.util.List<eu.strasbourg.service.like.model.Like>
		getLikesDislikes() {

		return model.getLikesDislikes();
	}

	/**
	 * Returns the modified by user date of this comment.
	 *
	 * @return the modified by user date of this comment
	 */
	@Override
	public Date getModifiedByUserDate() {
		return model.getModifiedByUserDate();
	}

	/**
	 * Returns the modified date of this comment.
	 *
	 * @return the modified date of this comment
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Retourne le nombre de dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbDislikes() {
		return model.getNbDislikes();
	}

	/**
	 * Retourne le nombre de likes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikes() {
		return model.getNbLikes();
	}

	/**
	 * Retourne le nombre de likes/dislikes de l'entité
	 *
	 * @see eu.strasbourg.service.like.model.LikeType
	 */
	@Override
	public int getNbLikesDislikes() {
		return model.getNbLikesDislikes();
	}

	/**
	 * Returns the parent comment ID of this comment.
	 *
	 * @return the parent comment ID of this comment
	 */
	@Override
	public long getParentCommentId() {
		return model.getParentCommentId();
	}

	/**
	 * Returns the primary key of this comment.
	 *
	 * @return the primary key of this comment
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publik ID of this comment.
	 *
	 * @return the publik ID of this comment
	 */
	@Override
	public String getPublikId() {
		return model.getPublikId();
	}

	@Override
	public eu.strasbourg.service.oidc.model.PublikUser getPublikUser() {
		return model.getPublikUser();
	}

	@Override
	public String getPublikUserName() {
		return model.getPublikUserName();
	}

	/**
	 * Returns the status of this comment.
	 *
	 * @return the status of this comment
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this comment.
	 *
	 * @return the status by user ID of this comment
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this comment.
	 *
	 * @return the status by user name of this comment
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this comment.
	 *
	 * @return the status by user uuid of this comment
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this comment.
	 *
	 * @return the status date of this comment
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the text of this comment.
	 *
	 * @return the text of this comment
	 */
	@Override
	public String getText() {
		return model.getText();
	}

	/**
	 * Returns the localized text of this comment in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized text of this comment
	 */
	@Override
	public String getText(java.util.Locale locale) {
		return model.getText(locale);
	}

	/**
	 * Returns the localized text of this comment in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized text of this comment. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getText(java.util.Locale locale, boolean useDefault) {
		return model.getText(locale, useDefault);
	}

	/**
	 * Returns the localized text of this comment in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized text of this comment
	 */
	@Override
	public String getText(String languageId) {
		return model.getText(languageId);
	}

	/**
	 * Returns the localized text of this comment in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized text of this comment
	 */
	@Override
	public String getText(String languageId, boolean useDefault) {
		return model.getText(languageId, useDefault);
	}

	@Override
	public String getTextCurrentLanguageId() {
		return model.getTextCurrentLanguageId();
	}

	@Override
	public String getTextCurrentValue() {
		return model.getTextCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized texts of this comment.
	 *
	 * @return the locales and localized texts of this comment
	 */
	@Override
	public Map<java.util.Locale, String> getTextMap() {
		return model.getTextMap();
	}

	@Override
	public String getTypeAssetEntry() {
		return model.getTypeAssetEntry();
	}

	/**
	 * Returns the url project commentaire of this comment.
	 *
	 * @return the url project commentaire of this comment
	 */
	@Override
	public String getUrlProjectCommentaire() {
		return model.getUrlProjectCommentaire();
	}

	/**
	 * Returns the user ID of this comment.
	 *
	 * @return the user ID of this comment
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this comment.
	 *
	 * @return the user name of this comment
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user quality of this comment.
	 *
	 * @return the user quality of this comment
	 */
	@Override
	public String getUserQuality() {
		return model.getUserQuality();
	}

	/**
	 * Returns the user uuid of this comment.
	 *
	 * @return the user uuid of this comment
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this comment.
	 *
	 * @return the uuid of this comment
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this comment is approved.
	 *
	 * @return <code>true</code> if this comment is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this comment is denied.
	 *
	 * @return <code>true</code> if this comment is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this comment is a draft.
	 *
	 * @return <code>true</code> if this comment is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this comment is expired.
	 *
	 * @return <code>true</code> if this comment is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this comment is inactive.
	 *
	 * @return <code>true</code> if this comment is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this comment is incomplete.
	 *
	 * @return <code>true</code> if this comment is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this comment is pending.
	 *
	 * @return <code>true</code> if this comment is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this comment is scheduled.
	 *
	 * @return <code>true</code> if this comment is scheduled; <code>false</code> otherwise
	 */
	@Override
	public boolean isScheduled() {
		return model.isScheduled();
	}

	@Override
	public void persist() {
		model.persist();
	}

	@Override
	public void prepareLocalizedFieldsForImport()
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport();
	}

	@Override
	public void prepareLocalizedFieldsForImport(
			java.util.Locale defaultImportLocale)
		throws com.liferay.portal.kernel.exception.LocaleException {

		model.prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	/**
	 * Sets the asset entry ID of this comment.
	 *
	 * @param assetEntryId the asset entry ID of this comment
	 */
	@Override
	public void setAssetEntryId(long assetEntryId) {
		model.setAssetEntryId(assetEntryId);
	}

	/**
	 * Sets the comment ID of this comment.
	 *
	 * @param commentId the comment ID of this comment
	 */
	@Override
	public void setCommentId(long commentId) {
		model.setCommentId(commentId);
	}

	/**
	 * Sets the company ID of this comment.
	 *
	 * @param companyId the company ID of this comment
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the create date of this comment.
	 *
	 * @param createDate the create date of this comment
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the group ID of this comment.
	 *
	 * @param groupId the group ID of this comment
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the level of this comment.
	 *
	 * @param level the level of this comment
	 */
	@Override
	public void setLevel(int level) {
		model.setLevel(level);
	}

	/**
	 * Sets the modified by user date of this comment.
	 *
	 * @param modifiedByUserDate the modified by user date of this comment
	 */
	@Override
	public void setModifiedByUserDate(Date modifiedByUserDate) {
		model.setModifiedByUserDate(modifiedByUserDate);
	}

	/**
	 * Sets the modified date of this comment.
	 *
	 * @param modifiedDate the modified date of this comment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the parent comment ID of this comment.
	 *
	 * @param parentCommentId the parent comment ID of this comment
	 */
	@Override
	public void setParentCommentId(long parentCommentId) {
		model.setParentCommentId(parentCommentId);
	}

	/**
	 * Sets the primary key of this comment.
	 *
	 * @param primaryKey the primary key of this comment
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publik ID of this comment.
	 *
	 * @param publikId the publik ID of this comment
	 */
	@Override
	public void setPublikId(String publikId) {
		model.setPublikId(publikId);
	}

	/**
	 * Sets the status of this comment.
	 *
	 * @param status the status of this comment
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this comment.
	 *
	 * @param statusByUserId the status by user ID of this comment
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this comment.
	 *
	 * @param statusByUserName the status by user name of this comment
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this comment.
	 *
	 * @param statusByUserUuid the status by user uuid of this comment
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this comment.
	 *
	 * @param statusDate the status date of this comment
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the text of this comment.
	 *
	 * @param text the text of this comment
	 */
	@Override
	public void setText(String text) {
		model.setText(text);
	}

	/**
	 * Sets the localized text of this comment in the language.
	 *
	 * @param text the localized text of this comment
	 * @param locale the locale of the language
	 */
	@Override
	public void setText(String text, java.util.Locale locale) {
		model.setText(text, locale);
	}

	/**
	 * Sets the localized text of this comment in the language, and sets the default locale.
	 *
	 * @param text the localized text of this comment
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setText(
		String text, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setText(text, locale, defaultLocale);
	}

	@Override
	public void setTextCurrentLanguageId(String languageId) {
		model.setTextCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized texts of this comment from the map of locales and localized texts.
	 *
	 * @param textMap the locales and localized texts of this comment
	 */
	@Override
	public void setTextMap(Map<java.util.Locale, String> textMap) {
		model.setTextMap(textMap);
	}

	/**
	 * Sets the localized texts of this comment from the map of locales and localized texts, and sets the default locale.
	 *
	 * @param textMap the locales and localized texts of this comment
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTextMap(
		Map<java.util.Locale, String> textMap, java.util.Locale defaultLocale) {

		model.setTextMap(textMap, defaultLocale);
	}

	/**
	 * Sets the url project commentaire of this comment.
	 *
	 * @param urlProjectCommentaire the url project commentaire of this comment
	 */
	@Override
	public void setUrlProjectCommentaire(String urlProjectCommentaire) {
		model.setUrlProjectCommentaire(urlProjectCommentaire);
	}

	/**
	 * Sets the user ID of this comment.
	 *
	 * @param userId the user ID of this comment
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this comment.
	 *
	 * @param userName the user name of this comment
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user quality of this comment.
	 *
	 * @param userQuality the user quality of this comment
	 */
	@Override
	public void setUserQuality(String userQuality) {
		model.setUserQuality(userQuality);
	}

	/**
	 * Sets the user uuid of this comment.
	 *
	 * @param userUuid the user uuid of this comment
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this comment.
	 *
	 * @param uuid the uuid of this comment
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	public StagedModelType getStagedModelType() {
		return model.getStagedModelType();
	}

	@Override
	protected CommentWrapper wrap(Comment comment) {
		return new CommentWrapper(comment);
	}

}