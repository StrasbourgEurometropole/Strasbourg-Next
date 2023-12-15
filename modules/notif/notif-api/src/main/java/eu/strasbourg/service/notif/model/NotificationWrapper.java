/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.notif.model;

import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Notification}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Notification
 * @generated
 */
public class NotificationWrapper
	extends BaseModelWrapper<Notification>
	implements ModelWrapper<Notification>, Notification {

	public NotificationWrapper(Notification notification) {
		super(notification);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("notificationId", getNotificationId());
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
		attributes.put("serviceId", getServiceId());
		attributes.put("isAlert", getIsAlert());
		attributes.put("natureId", getNatureId());
		attributes.put("title", getTitle());
		attributes.put("subtitle", getSubtitle());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("broadcastDate", getBroadcastDate());
		attributes.put("messageId", getMessageId());
		attributes.put("content", getContent());
		attributes.put("labelUrl", getLabelUrl());
		attributes.put("url", getUrl());
		attributes.put("typeBroadcast", getTypeBroadcast());
		attributes.put("district", getDistrict());
		attributes.put("broadcastChannels", getBroadcastChannels());
		attributes.put("sendStatusCsmap", getSendStatusCsmap());
		attributes.put("sendStatusTwitter", getSendStatusTwitter());
		attributes.put("sendStatusMonst", getSendStatusMonst());
		attributes.put("sendStatusMail", getSendStatusMail());
		attributes.put("sendStatusSegur", getSendStatusSegur());
		attributes.put("isSend", getIsSend());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long notificationId = (Long)attributes.get("notificationId");

		if (notificationId != null) {
			setNotificationId(notificationId);
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

		Long serviceId = (Long)attributes.get("serviceId");

		if (serviceId != null) {
			setServiceId(serviceId);
		}

		Integer isAlert = (Integer)attributes.get("isAlert");

		if (isAlert != null) {
			setIsAlert(isAlert);
		}

		Long natureId = (Long)attributes.get("natureId");

		if (natureId != null) {
			setNatureId(natureId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String subtitle = (String)attributes.get("subtitle");

		if (subtitle != null) {
			setSubtitle(subtitle);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date broadcastDate = (Date)attributes.get("broadcastDate");

		if (broadcastDate != null) {
			setBroadcastDate(broadcastDate);
		}

		Long messageId = (Long)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String labelUrl = (String)attributes.get("labelUrl");

		if (labelUrl != null) {
			setLabelUrl(labelUrl);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Long typeBroadcast = (Long)attributes.get("typeBroadcast");

		if (typeBroadcast != null) {
			setTypeBroadcast(typeBroadcast);
		}

		Long district = (Long)attributes.get("district");

		if (district != null) {
			setDistrict(district);
		}

		String broadcastChannels = (String)attributes.get("broadcastChannels");

		if (broadcastChannels != null) {
			setBroadcastChannels(broadcastChannels);
		}

		Long sendStatusCsmap = (Long)attributes.get("sendStatusCsmap");

		if (sendStatusCsmap != null) {
			setSendStatusCsmap(sendStatusCsmap);
		}

		Long sendStatusTwitter = (Long)attributes.get("sendStatusTwitter");

		if (sendStatusTwitter != null) {
			setSendStatusTwitter(sendStatusTwitter);
		}

		Long sendStatusMonst = (Long)attributes.get("sendStatusMonst");

		if (sendStatusMonst != null) {
			setSendStatusMonst(sendStatusMonst);
		}

		Long sendStatusMail = (Long)attributes.get("sendStatusMail");

		if (sendStatusMail != null) {
			setSendStatusMail(sendStatusMail);
		}

		Long sendStatusSegur = (Long)attributes.get("sendStatusSegur");

		if (sendStatusSegur != null) {
			setSendStatusSegur(sendStatusSegur);
		}

		Boolean isSend = (Boolean)attributes.get("isSend");

		if (isSend != null) {
			setIsSend(isSend);
		}
	}

	@Override
	public Notification cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	@Override
	public String[] getAvailableLanguageIds() {
		return model.getAvailableLanguageIds();
	}

	/**
	 * Returns the broadcast channels of this notification.
	 *
	 * @return the broadcast channels of this notification
	 */
	@Override
	public String getBroadcastChannels() {
		return model.getBroadcastChannels();
	}

	/**
	 * Returns the broadcast date of this notification.
	 *
	 * @return the broadcast date of this notification
	 */
	@Override
	public Date getBroadcastDate() {
		return model.getBroadcastDate();
	}

	/**
	 * Returns the company ID of this notification.
	 *
	 * @return the company ID of this notification
	 */
	@Override
	public long getCompanyId() {
		return model.getCompanyId();
	}

	/**
	 * Returns the content of this notification.
	 *
	 * @return the content of this notification
	 */
	@Override
	public String getContent() {
		return model.getContent();
	}

	/**
	 * Returns the localized content of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized content of this notification
	 */
	@Override
	public String getContent(java.util.Locale locale) {
		return model.getContent(locale);
	}

	/**
	 * Returns the localized content of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getContent(java.util.Locale locale, boolean useDefault) {
		return model.getContent(locale, useDefault);
	}

	/**
	 * Returns the localized content of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized content of this notification
	 */
	@Override
	public String getContent(String languageId) {
		return model.getContent(languageId);
	}

	/**
	 * Returns the localized content of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized content of this notification
	 */
	@Override
	public String getContent(String languageId, boolean useDefault) {
		return model.getContent(languageId, useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return model.getContentCurrentLanguageId();
	}

	@Override
	public String getContentCurrentValue() {
		return model.getContentCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized contents of this notification.
	 *
	 * @return the locales and localized contents of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getContentMap() {
		return model.getContentMap();
	}

	/**
	 * Returns the create date of this notification.
	 *
	 * @return the create date of this notification
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
	 * Returns the district of this notification.
	 *
	 * @return the district of this notification
	 */
	@Override
	public long getDistrict() {
		return model.getDistrict();
	}

	/**
	 * Returns the end date of this notification.
	 *
	 * @return the end date of this notification
	 */
	@Override
	public Date getEndDate() {
		return model.getEndDate();
	}

	/**
	 * Returns the group ID of this notification.
	 *
	 * @return the group ID of this notification
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the is alert of this notification.
	 *
	 * @return the is alert of this notification
	 */
	@Override
	public int getIsAlert() {
		return model.getIsAlert();
	}

	/**
	 * Returns the is send of this notification.
	 *
	 * @return the is send of this notification
	 */
	@Override
	public Boolean getIsSend() {
		return model.getIsSend();
	}

	/**
	 * Returns the label url of this notification.
	 *
	 * @return the label url of this notification
	 */
	@Override
	public String getLabelUrl() {
		return model.getLabelUrl();
	}

	/**
	 * Returns the localized label url of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized label url of this notification
	 */
	@Override
	public String getLabelUrl(java.util.Locale locale) {
		return model.getLabelUrl(locale);
	}

	/**
	 * Returns the localized label url of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label url of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getLabelUrl(java.util.Locale locale, boolean useDefault) {
		return model.getLabelUrl(locale, useDefault);
	}

	/**
	 * Returns the localized label url of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized label url of this notification
	 */
	@Override
	public String getLabelUrl(String languageId) {
		return model.getLabelUrl(languageId);
	}

	/**
	 * Returns the localized label url of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized label url of this notification
	 */
	@Override
	public String getLabelUrl(String languageId, boolean useDefault) {
		return model.getLabelUrl(languageId, useDefault);
	}

	@Override
	public String getLabelUrlCurrentLanguageId() {
		return model.getLabelUrlCurrentLanguageId();
	}

	@Override
	public String getLabelUrlCurrentValue() {
		return model.getLabelUrlCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized label urls of this notification.
	 *
	 * @return the locales and localized label urls of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getLabelUrlMap() {
		return model.getLabelUrlMap();
	}

	/**
	 * Returns the message ID of this notification.
	 *
	 * @return the message ID of this notification
	 */
	@Override
	public long getMessageId() {
		return model.getMessageId();
	}

	/**
	 * Returns the modified date of this notification.
	 *
	 * @return the modified date of this notification
	 */
	@Override
	public Date getModifiedDate() {
		return model.getModifiedDate();
	}

	/**
	 * Returns the nature ID of this notification.
	 *
	 * @return the nature ID of this notification
	 */
	@Override
	public long getNatureId() {
		return model.getNatureId();
	}

	/**
	 * Returns the notification ID of this notification.
	 *
	 * @return the notification ID of this notification
	 */
	@Override
	public long getNotificationId() {
		return model.getNotificationId();
	}

	/**
	 * Returns the primary key of this notification.
	 *
	 * @return the primary key of this notification
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the send status csmap of this notification.
	 *
	 * @return the send status csmap of this notification
	 */
	@Override
	public long getSendStatusCsmap() {
		return model.getSendStatusCsmap();
	}

	/**
	 * Returns the send status mail of this notification.
	 *
	 * @return the send status mail of this notification
	 */
	@Override
	public long getSendStatusMail() {
		return model.getSendStatusMail();
	}

	/**
	 * Returns the send status monst of this notification.
	 *
	 * @return the send status monst of this notification
	 */
	@Override
	public long getSendStatusMonst() {
		return model.getSendStatusMonst();
	}

	/**
	 * Returns the send status segur of this notification.
	 *
	 * @return the send status segur of this notification
	 */
	@Override
	public long getSendStatusSegur() {
		return model.getSendStatusSegur();
	}

	/**
	 * Returns the send status twitter of this notification.
	 *
	 * @return the send status twitter of this notification
	 */
	@Override
	public long getSendStatusTwitter() {
		return model.getSendStatusTwitter();
	}

	/**
	 * Returns the service ID of this notification.
	 *
	 * @return the service ID of this notification
	 */
	@Override
	public long getServiceId() {
		return model.getServiceId();
	}

	/**
	 * Returns the start date of this notification.
	 *
	 * @return the start date of this notification
	 */
	@Override
	public Date getStartDate() {
		return model.getStartDate();
	}

	/**
	 * Returns the status of this notification.
	 *
	 * @return the status of this notification
	 */
	@Override
	public int getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the status by user ID of this notification.
	 *
	 * @return the status by user ID of this notification
	 */
	@Override
	public long getStatusByUserId() {
		return model.getStatusByUserId();
	}

	/**
	 * Returns the status by user name of this notification.
	 *
	 * @return the status by user name of this notification
	 */
	@Override
	public String getStatusByUserName() {
		return model.getStatusByUserName();
	}

	/**
	 * Returns the status by user uuid of this notification.
	 *
	 * @return the status by user uuid of this notification
	 */
	@Override
	public String getStatusByUserUuid() {
		return model.getStatusByUserUuid();
	}

	/**
	 * Returns the status date of this notification.
	 *
	 * @return the status date of this notification
	 */
	@Override
	public Date getStatusDate() {
		return model.getStatusDate();
	}

	/**
	 * Returns the subtitle of this notification.
	 *
	 * @return the subtitle of this notification
	 */
	@Override
	public String getSubtitle() {
		return model.getSubtitle();
	}

	/**
	 * Returns the localized subtitle of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized subtitle of this notification
	 */
	@Override
	public String getSubtitle(java.util.Locale locale) {
		return model.getSubtitle(locale);
	}

	/**
	 * Returns the localized subtitle of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getSubtitle(java.util.Locale locale, boolean useDefault) {
		return model.getSubtitle(locale, useDefault);
	}

	/**
	 * Returns the localized subtitle of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized subtitle of this notification
	 */
	@Override
	public String getSubtitle(String languageId) {
		return model.getSubtitle(languageId);
	}

	/**
	 * Returns the localized subtitle of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized subtitle of this notification
	 */
	@Override
	public String getSubtitle(String languageId, boolean useDefault) {
		return model.getSubtitle(languageId, useDefault);
	}

	@Override
	public String getSubtitleCurrentLanguageId() {
		return model.getSubtitleCurrentLanguageId();
	}

	@Override
	public String getSubtitleCurrentValue() {
		return model.getSubtitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized subtitles of this notification.
	 *
	 * @return the locales and localized subtitles of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getSubtitleMap() {
		return model.getSubtitleMap();
	}

	/**
	 * Returns the title of this notification.
	 *
	 * @return the title of this notification
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized title of this notification
	 */
	@Override
	public String getTitle(java.util.Locale locale) {
		return model.getTitle(locale);
	}

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getTitle(java.util.Locale locale, boolean useDefault) {
		return model.getTitle(locale, useDefault);
	}

	/**
	 * Returns the localized title of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized title of this notification
	 */
	@Override
	public String getTitle(String languageId) {
		return model.getTitle(languageId);
	}

	/**
	 * Returns the localized title of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized title of this notification
	 */
	@Override
	public String getTitle(String languageId, boolean useDefault) {
		return model.getTitle(languageId, useDefault);
	}

	@Override
	public String getTitleCurrentLanguageId() {
		return model.getTitleCurrentLanguageId();
	}

	@Override
	public String getTitleCurrentValue() {
		return model.getTitleCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized titles of this notification.
	 *
	 * @return the locales and localized titles of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getTitleMap() {
		return model.getTitleMap();
	}

	/**
	 * Returns the type broadcast of this notification.
	 *
	 * @return the type broadcast of this notification
	 */
	@Override
	public long getTypeBroadcast() {
		return model.getTypeBroadcast();
	}

	/**
	 * Returns the url of this notification.
	 *
	 * @return the url of this notification
	 */
	@Override
	public String getUrl() {
		return model.getUrl();
	}

	/**
	 * Returns the localized url of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param locale the locale of the language
	 * @return the localized url of this notification
	 */
	@Override
	public String getUrl(java.util.Locale locale) {
		return model.getUrl(locale);
	}

	/**
	 * Returns the localized url of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param locale the local of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this notification. If <code>useDefault</code> is <code>false</code> and no localization exists for the requested language, an empty string will be returned.
	 */
	@Override
	public String getUrl(java.util.Locale locale, boolean useDefault) {
		return model.getUrl(locale, useDefault);
	}

	/**
	 * Returns the localized url of this notification in the language. Uses the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @return the localized url of this notification
	 */
	@Override
	public String getUrl(String languageId) {
		return model.getUrl(languageId);
	}

	/**
	 * Returns the localized url of this notification in the language, optionally using the default language if no localization exists for the requested language.
	 *
	 * @param languageId the ID of the language
	 * @param useDefault whether to use the default language if no localization exists for the requested language
	 * @return the localized url of this notification
	 */
	@Override
	public String getUrl(String languageId, boolean useDefault) {
		return model.getUrl(languageId, useDefault);
	}

	@Override
	public String getUrlCurrentLanguageId() {
		return model.getUrlCurrentLanguageId();
	}

	@Override
	public String getUrlCurrentValue() {
		return model.getUrlCurrentValue();
	}

	/**
	 * Returns a map of the locales and localized urls of this notification.
	 *
	 * @return the locales and localized urls of this notification
	 */
	@Override
	public Map<java.util.Locale, String> getUrlMap() {
		return model.getUrlMap();
	}

	/**
	 * Returns the user ID of this notification.
	 *
	 * @return the user ID of this notification
	 */
	@Override
	public long getUserId() {
		return model.getUserId();
	}

	/**
	 * Returns the user name of this notification.
	 *
	 * @return the user name of this notification
	 */
	@Override
	public String getUserName() {
		return model.getUserName();
	}

	/**
	 * Returns the user uuid of this notification.
	 *
	 * @return the user uuid of this notification
	 */
	@Override
	public String getUserUuid() {
		return model.getUserUuid();
	}

	/**
	 * Returns the uuid of this notification.
	 *
	 * @return the uuid of this notification
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns <code>true</code> if this notification is approved.
	 *
	 * @return <code>true</code> if this notification is approved; <code>false</code> otherwise
	 */
	@Override
	public boolean isApproved() {
		return model.isApproved();
	}

	/**
	 * Returns <code>true</code> if this notification is denied.
	 *
	 * @return <code>true</code> if this notification is denied; <code>false</code> otherwise
	 */
	@Override
	public boolean isDenied() {
		return model.isDenied();
	}

	/**
	 * Returns <code>true</code> if this notification is a draft.
	 *
	 * @return <code>true</code> if this notification is a draft; <code>false</code> otherwise
	 */
	@Override
	public boolean isDraft() {
		return model.isDraft();
	}

	/**
	 * Returns <code>true</code> if this notification is expired.
	 *
	 * @return <code>true</code> if this notification is expired; <code>false</code> otherwise
	 */
	@Override
	public boolean isExpired() {
		return model.isExpired();
	}

	/**
	 * Returns <code>true</code> if this notification is inactive.
	 *
	 * @return <code>true</code> if this notification is inactive; <code>false</code> otherwise
	 */
	@Override
	public boolean isInactive() {
		return model.isInactive();
	}

	/**
	 * Returns <code>true</code> if this notification is incomplete.
	 *
	 * @return <code>true</code> if this notification is incomplete; <code>false</code> otherwise
	 */
	@Override
	public boolean isIncomplete() {
		return model.isIncomplete();
	}

	/**
	 * Returns <code>true</code> if this notification is pending.
	 *
	 * @return <code>true</code> if this notification is pending; <code>false</code> otherwise
	 */
	@Override
	public boolean isPending() {
		return model.isPending();
	}

	/**
	 * Returns <code>true</code> if this notification is scheduled.
	 *
	 * @return <code>true</code> if this notification is scheduled; <code>false</code> otherwise
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
	 * Sets the broadcast channels of this notification.
	 *
	 * @param broadcastChannels the broadcast channels of this notification
	 */
	@Override
	public void setBroadcastChannels(String broadcastChannels) {
		model.setBroadcastChannels(broadcastChannels);
	}

	/**
	 * Sets the broadcast date of this notification.
	 *
	 * @param broadcastDate the broadcast date of this notification
	 */
	@Override
	public void setBroadcastDate(Date broadcastDate) {
		model.setBroadcastDate(broadcastDate);
	}

	/**
	 * Sets the company ID of this notification.
	 *
	 * @param companyId the company ID of this notification
	 */
	@Override
	public void setCompanyId(long companyId) {
		model.setCompanyId(companyId);
	}

	/**
	 * Sets the content of this notification.
	 *
	 * @param content the content of this notification
	 */
	@Override
	public void setContent(String content) {
		model.setContent(content);
	}

	/**
	 * Sets the localized content of this notification in the language.
	 *
	 * @param content the localized content of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setContent(String content, java.util.Locale locale) {
		model.setContent(content, locale);
	}

	/**
	 * Sets the localized content of this notification in the language, and sets the default locale.
	 *
	 * @param content the localized content of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContent(
		String content, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setContent(content, locale, defaultLocale);
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		model.setContentCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized contents of this notification from the map of locales and localized contents.
	 *
	 * @param contentMap the locales and localized contents of this notification
	 */
	@Override
	public void setContentMap(Map<java.util.Locale, String> contentMap) {
		model.setContentMap(contentMap);
	}

	/**
	 * Sets the localized contents of this notification from the map of locales and localized contents, and sets the default locale.
	 *
	 * @param contentMap the locales and localized contents of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setContentMap(
		Map<java.util.Locale, String> contentMap,
		java.util.Locale defaultLocale) {

		model.setContentMap(contentMap, defaultLocale);
	}

	/**
	 * Sets the create date of this notification.
	 *
	 * @param createDate the create date of this notification
	 */
	@Override
	public void setCreateDate(Date createDate) {
		model.setCreateDate(createDate);
	}

	/**
	 * Sets the district of this notification.
	 *
	 * @param district the district of this notification
	 */
	@Override
	public void setDistrict(long district) {
		model.setDistrict(district);
	}

	/**
	 * Sets the end date of this notification.
	 *
	 * @param endDate the end date of this notification
	 */
	@Override
	public void setEndDate(Date endDate) {
		model.setEndDate(endDate);
	}

	/**
	 * Sets the group ID of this notification.
	 *
	 * @param groupId the group ID of this notification
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the is alert of this notification.
	 *
	 * @param isAlert the is alert of this notification
	 */
	@Override
	public void setIsAlert(int isAlert) {
		model.setIsAlert(isAlert);
	}

	/**
	 * Sets the is send of this notification.
	 *
	 * @param isSend the is send of this notification
	 */
	@Override
	public void setIsSend(Boolean isSend) {
		model.setIsSend(isSend);
	}

	/**
	 * Sets the label url of this notification.
	 *
	 * @param labelUrl the label url of this notification
	 */
	@Override
	public void setLabelUrl(String labelUrl) {
		model.setLabelUrl(labelUrl);
	}

	/**
	 * Sets the localized label url of this notification in the language.
	 *
	 * @param labelUrl the localized label url of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setLabelUrl(String labelUrl, java.util.Locale locale) {
		model.setLabelUrl(labelUrl, locale);
	}

	/**
	 * Sets the localized label url of this notification in the language, and sets the default locale.
	 *
	 * @param labelUrl the localized label url of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLabelUrl(
		String labelUrl, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setLabelUrl(labelUrl, locale, defaultLocale);
	}

	@Override
	public void setLabelUrlCurrentLanguageId(String languageId) {
		model.setLabelUrlCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized label urls of this notification from the map of locales and localized label urls.
	 *
	 * @param labelUrlMap the locales and localized label urls of this notification
	 */
	@Override
	public void setLabelUrlMap(Map<java.util.Locale, String> labelUrlMap) {
		model.setLabelUrlMap(labelUrlMap);
	}

	/**
	 * Sets the localized label urls of this notification from the map of locales and localized label urls, and sets the default locale.
	 *
	 * @param labelUrlMap the locales and localized label urls of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setLabelUrlMap(
		Map<java.util.Locale, String> labelUrlMap,
		java.util.Locale defaultLocale) {

		model.setLabelUrlMap(labelUrlMap, defaultLocale);
	}

	/**
	 * Sets the message ID of this notification.
	 *
	 * @param messageId the message ID of this notification
	 */
	@Override
	public void setMessageId(long messageId) {
		model.setMessageId(messageId);
	}

	/**
	 * Sets the modified date of this notification.
	 *
	 * @param modifiedDate the modified date of this notification
	 */
	@Override
	public void setModifiedDate(Date modifiedDate) {
		model.setModifiedDate(modifiedDate);
	}

	/**
	 * Sets the nature ID of this notification.
	 *
	 * @param natureId the nature ID of this notification
	 */
	@Override
	public void setNatureId(long natureId) {
		model.setNatureId(natureId);
	}

	/**
	 * Sets the notification ID of this notification.
	 *
	 * @param notificationId the notification ID of this notification
	 */
	@Override
	public void setNotificationId(long notificationId) {
		model.setNotificationId(notificationId);
	}

	/**
	 * Sets the primary key of this notification.
	 *
	 * @param primaryKey the primary key of this notification
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the send status csmap of this notification.
	 *
	 * @param sendStatusCsmap the send status csmap of this notification
	 */
	@Override
	public void setSendStatusCsmap(long sendStatusCsmap) {
		model.setSendStatusCsmap(sendStatusCsmap);
	}

	/**
	 * Sets the send status mail of this notification.
	 *
	 * @param sendStatusMail the send status mail of this notification
	 */
	@Override
	public void setSendStatusMail(long sendStatusMail) {
		model.setSendStatusMail(sendStatusMail);
	}

	/**
	 * Sets the send status monst of this notification.
	 *
	 * @param sendStatusMonst the send status monst of this notification
	 */
	@Override
	public void setSendStatusMonst(long sendStatusMonst) {
		model.setSendStatusMonst(sendStatusMonst);
	}

	/**
	 * Sets the send status segur of this notification.
	 *
	 * @param sendStatusSegur the send status segur of this notification
	 */
	@Override
	public void setSendStatusSegur(long sendStatusSegur) {
		model.setSendStatusSegur(sendStatusSegur);
	}

	/**
	 * Sets the send status twitter of this notification.
	 *
	 * @param sendStatusTwitter the send status twitter of this notification
	 */
	@Override
	public void setSendStatusTwitter(long sendStatusTwitter) {
		model.setSendStatusTwitter(sendStatusTwitter);
	}

	/**
	 * Sets the service ID of this notification.
	 *
	 * @param serviceId the service ID of this notification
	 */
	@Override
	public void setServiceId(long serviceId) {
		model.setServiceId(serviceId);
	}

	/**
	 * Sets the start date of this notification.
	 *
	 * @param startDate the start date of this notification
	 */
	@Override
	public void setStartDate(Date startDate) {
		model.setStartDate(startDate);
	}

	/**
	 * Sets the status of this notification.
	 *
	 * @param status the status of this notification
	 */
	@Override
	public void setStatus(int status) {
		model.setStatus(status);
	}

	/**
	 * Sets the status by user ID of this notification.
	 *
	 * @param statusByUserId the status by user ID of this notification
	 */
	@Override
	public void setStatusByUserId(long statusByUserId) {
		model.setStatusByUserId(statusByUserId);
	}

	/**
	 * Sets the status by user name of this notification.
	 *
	 * @param statusByUserName the status by user name of this notification
	 */
	@Override
	public void setStatusByUserName(String statusByUserName) {
		model.setStatusByUserName(statusByUserName);
	}

	/**
	 * Sets the status by user uuid of this notification.
	 *
	 * @param statusByUserUuid the status by user uuid of this notification
	 */
	@Override
	public void setStatusByUserUuid(String statusByUserUuid) {
		model.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	 * Sets the status date of this notification.
	 *
	 * @param statusDate the status date of this notification
	 */
	@Override
	public void setStatusDate(Date statusDate) {
		model.setStatusDate(statusDate);
	}

	/**
	 * Sets the subtitle of this notification.
	 *
	 * @param subtitle the subtitle of this notification
	 */
	@Override
	public void setSubtitle(String subtitle) {
		model.setSubtitle(subtitle);
	}

	/**
	 * Sets the localized subtitle of this notification in the language.
	 *
	 * @param subtitle the localized subtitle of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setSubtitle(String subtitle, java.util.Locale locale) {
		model.setSubtitle(subtitle, locale);
	}

	/**
	 * Sets the localized subtitle of this notification in the language, and sets the default locale.
	 *
	 * @param subtitle the localized subtitle of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitle(
		String subtitle, java.util.Locale locale,
		java.util.Locale defaultLocale) {

		model.setSubtitle(subtitle, locale, defaultLocale);
	}

	@Override
	public void setSubtitleCurrentLanguageId(String languageId) {
		model.setSubtitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized subtitles of this notification from the map of locales and localized subtitles.
	 *
	 * @param subtitleMap the locales and localized subtitles of this notification
	 */
	@Override
	public void setSubtitleMap(Map<java.util.Locale, String> subtitleMap) {
		model.setSubtitleMap(subtitleMap);
	}

	/**
	 * Sets the localized subtitles of this notification from the map of locales and localized subtitles, and sets the default locale.
	 *
	 * @param subtitleMap the locales and localized subtitles of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setSubtitleMap(
		Map<java.util.Locale, String> subtitleMap,
		java.util.Locale defaultLocale) {

		model.setSubtitleMap(subtitleMap, defaultLocale);
	}

	/**
	 * Sets the title of this notification.
	 *
	 * @param title the title of this notification
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the localized title of this notification in the language.
	 *
	 * @param title the localized title of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setTitle(String title, java.util.Locale locale) {
		model.setTitle(title, locale);
	}

	/**
	 * Sets the localized title of this notification in the language, and sets the default locale.
	 *
	 * @param title the localized title of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitle(
		String title, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setTitle(title, locale, defaultLocale);
	}

	@Override
	public void setTitleCurrentLanguageId(String languageId) {
		model.setTitleCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized titles of this notification from the map of locales and localized titles.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 */
	@Override
	public void setTitleMap(Map<java.util.Locale, String> titleMap) {
		model.setTitleMap(titleMap);
	}

	/**
	 * Sets the localized titles of this notification from the map of locales and localized titles, and sets the default locale.
	 *
	 * @param titleMap the locales and localized titles of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setTitleMap(
		Map<java.util.Locale, String> titleMap,
		java.util.Locale defaultLocale) {

		model.setTitleMap(titleMap, defaultLocale);
	}

	/**
	 * Sets the type broadcast of this notification.
	 *
	 * @param typeBroadcast the type broadcast of this notification
	 */
	@Override
	public void setTypeBroadcast(long typeBroadcast) {
		model.setTypeBroadcast(typeBroadcast);
	}

	/**
	 * Sets the url of this notification.
	 *
	 * @param url the url of this notification
	 */
	@Override
	public void setUrl(String url) {
		model.setUrl(url);
	}

	/**
	 * Sets the localized url of this notification in the language.
	 *
	 * @param url the localized url of this notification
	 * @param locale the locale of the language
	 */
	@Override
	public void setUrl(String url, java.util.Locale locale) {
		model.setUrl(url, locale);
	}

	/**
	 * Sets the localized url of this notification in the language, and sets the default locale.
	 *
	 * @param url the localized url of this notification
	 * @param locale the locale of the language
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setUrl(
		String url, java.util.Locale locale, java.util.Locale defaultLocale) {

		model.setUrl(url, locale, defaultLocale);
	}

	@Override
	public void setUrlCurrentLanguageId(String languageId) {
		model.setUrlCurrentLanguageId(languageId);
	}

	/**
	 * Sets the localized urls of this notification from the map of locales and localized urls.
	 *
	 * @param urlMap the locales and localized urls of this notification
	 */
	@Override
	public void setUrlMap(Map<java.util.Locale, String> urlMap) {
		model.setUrlMap(urlMap);
	}

	/**
	 * Sets the localized urls of this notification from the map of locales and localized urls, and sets the default locale.
	 *
	 * @param urlMap the locales and localized urls of this notification
	 * @param defaultLocale the default locale
	 */
	@Override
	public void setUrlMap(
		Map<java.util.Locale, String> urlMap, java.util.Locale defaultLocale) {

		model.setUrlMap(urlMap, defaultLocale);
	}

	/**
	 * Sets the user ID of this notification.
	 *
	 * @param userId the user ID of this notification
	 */
	@Override
	public void setUserId(long userId) {
		model.setUserId(userId);
	}

	/**
	 * Sets the user name of this notification.
	 *
	 * @param userName the user name of this notification
	 */
	@Override
	public void setUserName(String userName) {
		model.setUserName(userName);
	}

	/**
	 * Sets the user uuid of this notification.
	 *
	 * @param userUuid the user uuid of this notification
	 */
	@Override
	public void setUserUuid(String userUuid) {
		model.setUserUuid(userUuid);
	}

	/**
	 * Sets the uuid of this notification.
	 *
	 * @param uuid the uuid of this notification
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
	protected NotificationWrapper wrap(Notification notification) {
		return new NotificationWrapper(notification);
	}

}