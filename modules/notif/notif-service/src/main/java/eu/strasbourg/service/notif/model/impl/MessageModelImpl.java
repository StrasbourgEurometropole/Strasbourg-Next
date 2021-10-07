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

package eu.strasbourg.service.notif.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.LocaleException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.Validator;

import eu.strasbourg.service.notif.model.Message;
import eu.strasbourg.service.notif.model.MessageModel;
import eu.strasbourg.service.notif.model.MessageSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the Message service. Represents a row in the &quot;notif_Message&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>MessageModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MessageImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MessageImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class MessageModelImpl
	extends BaseModelImpl<Message> implements MessageModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a message model instance should use the <code>Message</code> interface instead.
	 */
	public static final String TABLE_NAME = "notif_Message";

	public static final Object[][] TABLE_COLUMNS = {
		{"messageId", Types.BIGINT}, {"serviceId", Types.BIGINT},
		{"content", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("messageId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serviceId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("content", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table notif_Message (messageId LONG not null primary key,serviceId LONG,content STRING null)";

	public static final String TABLE_SQL_DROP = "drop table notif_Message";

	public static final String ORDER_BY_JPQL =
		" ORDER BY message.messageId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY notif_Message.messageId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notif.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.notif.model.Message"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notif.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.notif.model.Message"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.notif.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.notif.model.Message"),
		true);

	public static final long SERVICEID_COLUMN_BITMASK = 1L;

	public static final long MESSAGEID_COLUMN_BITMASK = 2L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Message toModel(MessageSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Message model = new MessageImpl();

		model.setMessageId(soapModel.getMessageId());
		model.setServiceId(soapModel.getServiceId());
		model.setContent(soapModel.getContent());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Message> toModels(MessageSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Message> models = new ArrayList<Message>(soapModels.length);

		for (MessageSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.notif.service.util.ServiceProps.get(
			"lock.expiration.time.eu.strasbourg.service.notif.model.Message"));

	public MessageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _messageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setMessageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _messageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Message.class;
	}

	@Override
	public String getModelClassName() {
		return Message.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<Message, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<Message, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Message, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName, attributeGetterFunction.apply((Message)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<Message, Object>> attributeSetterBiConsumers =
			getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<Message, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(Message)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<Message, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<Message, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, Message>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			Message.class.getClassLoader(), Message.class, ModelWrapper.class);

		try {
			Constructor<Message> constructor =
				(Constructor<Message>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<Message, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<Message, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<Message, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<Message, Object>>();
		Map<String, BiConsumer<Message, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<Message, ?>>();

		attributeGetterFunctions.put(
			"messageId",
			new Function<Message, Object>() {

				@Override
				public Object apply(Message message) {
					return message.getMessageId();
				}

			});
		attributeSetterBiConsumers.put(
			"messageId",
			new BiConsumer<Message, Object>() {

				@Override
				public void accept(Message message, Object messageId) {
					message.setMessageId((Long)messageId);
				}

			});
		attributeGetterFunctions.put(
			"serviceId",
			new Function<Message, Object>() {

				@Override
				public Object apply(Message message) {
					return message.getServiceId();
				}

			});
		attributeSetterBiConsumers.put(
			"serviceId",
			new BiConsumer<Message, Object>() {

				@Override
				public void accept(Message message, Object serviceId) {
					message.setServiceId((Long)serviceId);
				}

			});
		attributeGetterFunctions.put(
			"content",
			new Function<Message, Object>() {

				@Override
				public Object apply(Message message) {
					return message.getContent();
				}

			});
		attributeSetterBiConsumers.put(
			"content",
			new BiConsumer<Message, Object>() {

				@Override
				public void accept(Message message, Object content) {
					message.setContent((String)content);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getMessageId() {
		return _messageId;
	}

	@Override
	public void setMessageId(long messageId) {
		_messageId = messageId;
	}

	@JSON
	@Override
	public long getServiceId() {
		return _serviceId;
	}

	@Override
	public void setServiceId(long serviceId) {
		_columnBitmask |= SERVICEID_COLUMN_BITMASK;

		if (!_setOriginalServiceId) {
			_setOriginalServiceId = true;

			_originalServiceId = _serviceId;
		}

		_serviceId = serviceId;
	}

	public long getOriginalServiceId() {
		return _originalServiceId;
	}

	@JSON
	@Override
	public String getContent() {
		if (_content == null) {
			return "";
		}
		else {
			return _content;
		}
	}

	@Override
	public String getContent(Locale locale) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId);
	}

	@Override
	public String getContent(Locale locale, boolean useDefault) {
		String languageId = LocaleUtil.toLanguageId(locale);

		return getContent(languageId, useDefault);
	}

	@Override
	public String getContent(String languageId) {
		return LocalizationUtil.getLocalization(getContent(), languageId);
	}

	@Override
	public String getContent(String languageId, boolean useDefault) {
		return LocalizationUtil.getLocalization(
			getContent(), languageId, useDefault);
	}

	@Override
	public String getContentCurrentLanguageId() {
		return _contentCurrentLanguageId;
	}

	@JSON
	@Override
	public String getContentCurrentValue() {
		Locale locale = getLocale(_contentCurrentLanguageId);

		return getContent(locale);
	}

	@Override
	public Map<Locale, String> getContentMap() {
		return LocalizationUtil.getLocalizationMap(getContent());
	}

	@Override
	public void setContent(String content) {
		_content = content;
	}

	@Override
	public void setContent(String content, Locale locale) {
		setContent(content, locale, LocaleUtil.getDefault());
	}

	@Override
	public void setContent(
		String content, Locale locale, Locale defaultLocale) {

		String languageId = LocaleUtil.toLanguageId(locale);
		String defaultLanguageId = LocaleUtil.toLanguageId(defaultLocale);

		if (Validator.isNotNull(content)) {
			setContent(
				LocalizationUtil.updateLocalization(
					getContent(), "Content", content, languageId,
					defaultLanguageId));
		}
		else {
			setContent(
				LocalizationUtil.removeLocalization(
					getContent(), "Content", languageId));
		}
	}

	@Override
	public void setContentCurrentLanguageId(String languageId) {
		_contentCurrentLanguageId = languageId;
	}

	@Override
	public void setContentMap(Map<Locale, String> contentMap) {
		setContentMap(contentMap, LocaleUtil.getDefault());
	}

	@Override
	public void setContentMap(
		Map<Locale, String> contentMap, Locale defaultLocale) {

		if (contentMap == null) {
			return;
		}

		setContent(
			LocalizationUtil.updateLocalization(
				contentMap, getContent(), "Content",
				LocaleUtil.toLanguageId(defaultLocale)));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, Message.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public String[] getAvailableLanguageIds() {
		Set<String> availableLanguageIds = new TreeSet<String>();

		Map<Locale, String> contentMap = getContentMap();

		for (Map.Entry<Locale, String> entry : contentMap.entrySet()) {
			Locale locale = entry.getKey();
			String value = entry.getValue();

			if (Validator.isNotNull(value)) {
				availableLanguageIds.add(LocaleUtil.toLanguageId(locale));
			}
		}

		return availableLanguageIds.toArray(
			new String[availableLanguageIds.size()]);
	}

	@Override
	public String getDefaultLanguageId() {
		String xml = getContent();

		if (xml == null) {
			return "";
		}

		Locale defaultLocale = LocaleUtil.getDefault();

		return LocalizationUtil.getDefaultLanguageId(xml, defaultLocale);
	}

	@Override
	public void prepareLocalizedFieldsForImport() throws LocaleException {
		Locale defaultLocale = LocaleUtil.fromLanguageId(
			getDefaultLanguageId());

		Locale[] availableLocales = LocaleUtil.fromLanguageIds(
			getAvailableLanguageIds());

		Locale defaultImportLocale = LocalizationUtil.getDefaultImportLocale(
			Message.class.getName(), getPrimaryKey(), defaultLocale,
			availableLocales);

		prepareLocalizedFieldsForImport(defaultImportLocale);
	}

	@Override
	@SuppressWarnings("unused")
	public void prepareLocalizedFieldsForImport(Locale defaultImportLocale)
		throws LocaleException {

		Locale defaultLocale = LocaleUtil.getDefault();

		String modelDefaultLanguageId = getDefaultLanguageId();

		String content = getContent(defaultLocale);

		if (Validator.isNull(content)) {
			setContent(getContent(modelDefaultLanguageId), defaultLocale);
		}
		else {
			setContent(getContent(defaultLocale), defaultLocale, defaultLocale);
		}
	}

	@Override
	public Message toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		MessageImpl messageImpl = new MessageImpl();

		messageImpl.setMessageId(getMessageId());
		messageImpl.setServiceId(getServiceId());
		messageImpl.setContent(getContent());

		messageImpl.resetOriginalValues();

		return messageImpl;
	}

	@Override
	public int compareTo(Message message) {
		long primaryKey = message.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Message)) {
			return false;
		}

		Message message = (Message)obj;

		long primaryKey = message.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		MessageModelImpl messageModelImpl = this;

		messageModelImpl._originalServiceId = messageModelImpl._serviceId;

		messageModelImpl._setOriginalServiceId = false;

		messageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Message> toCacheModel() {
		MessageCacheModel messageCacheModel = new MessageCacheModel();

		messageCacheModel.messageId = getMessageId();

		messageCacheModel.serviceId = getServiceId();

		messageCacheModel.content = getContent();

		String content = messageCacheModel.content;

		if ((content != null) && (content.length() == 0)) {
			messageCacheModel.content = null;
		}

		return messageCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<Message, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<Message, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Message, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((Message)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<Message, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<Message, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<Message, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((Message)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, Message>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _messageId;
	private long _serviceId;
	private long _originalServiceId;
	private boolean _setOriginalServiceId;
	private String _content;
	private String _contentCurrentLanguageId;
	private long _columnBitmask;
	private Message _escapedModel;

}