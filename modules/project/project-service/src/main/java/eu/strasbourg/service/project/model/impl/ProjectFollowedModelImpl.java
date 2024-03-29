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

package eu.strasbourg.service.project.model.impl;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.project.model.ProjectFollowed;
import eu.strasbourg.service.project.model.ProjectFollowedModel;
import eu.strasbourg.service.project.model.ProjectFollowedSoap;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the ProjectFollowed service. Represents a row in the &quot;project_ProjectFollowed&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProjectFollowedModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectFollowedImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectFollowedImpl
 * @generated
 */
@JSON(strict = true)
public class ProjectFollowedModelImpl
	extends BaseModelImpl<ProjectFollowed> implements ProjectFollowedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project followed model instance should use the <code>ProjectFollowed</code> interface instead.
	 */
	public static final String TABLE_NAME = "project_ProjectFollowed";

	public static final Object[][] TABLE_COLUMNS = {
		{"projectFollowedId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"publikUserId", Types.VARCHAR}, {"projectId", Types.BIGINT},
		{"groupId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("projectFollowedId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("publikUserId", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table project_ProjectFollowed (projectFollowedId LONG not null primary key,createDate DATE null,publikUserId VARCHAR(75) null,projectId LONG,groupId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table project_ProjectFollowed";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projectFollowed.projectFollowedId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY project_ProjectFollowed.projectFollowedId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.project.model.ProjectFollowed"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.project.model.ProjectFollowed"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.project.model.ProjectFollowed"),
		true);

	public static final long PROJECTID_COLUMN_BITMASK = 1L;

	public static final long PUBLIKUSERID_COLUMN_BITMASK = 2L;

	public static final long PROJECTFOLLOWEDID_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectFollowed toModel(ProjectFollowedSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectFollowed model = new ProjectFollowedImpl();

		model.setProjectFollowedId(soapModel.getProjectFollowedId());
		model.setCreateDate(soapModel.getCreateDate());
		model.setPublikUserId(soapModel.getPublikUserId());
		model.setProjectId(soapModel.getProjectId());
		model.setGroupId(soapModel.getGroupId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectFollowed> toModels(
		ProjectFollowedSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ProjectFollowed> models = new ArrayList<ProjectFollowed>(
			soapModels.length);

		for (ProjectFollowedSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.project.model.ProjectFollowed"));

	public ProjectFollowedModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectFollowedId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectFollowedId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectFollowedId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectFollowed.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectFollowed.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProjectFollowed, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProjectFollowed, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectFollowed, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProjectFollowed)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProjectFollowed, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProjectFollowed, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProjectFollowed)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProjectFollowed, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProjectFollowed, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProjectFollowed>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProjectFollowed.class.getClassLoader(), ProjectFollowed.class,
			ModelWrapper.class);

		try {
			Constructor<ProjectFollowed> constructor =
				(Constructor<ProjectFollowed>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<ProjectFollowed, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProjectFollowed, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProjectFollowed, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ProjectFollowed, Object>>();
		Map<String, BiConsumer<ProjectFollowed, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProjectFollowed, ?>>();

		attributeGetterFunctions.put(
			"projectFollowedId",
			new Function<ProjectFollowed, Object>() {

				@Override
				public Object apply(ProjectFollowed projectFollowed) {
					return projectFollowed.getProjectFollowedId();
				}

			});
		attributeSetterBiConsumers.put(
			"projectFollowedId",
			new BiConsumer<ProjectFollowed, Object>() {

				@Override
				public void accept(
					ProjectFollowed projectFollowed,
					Object projectFollowedIdObject) {

					projectFollowed.setProjectFollowedId(
						(Long)projectFollowedIdObject);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<ProjectFollowed, Object>() {

				@Override
				public Object apply(ProjectFollowed projectFollowed) {
					return projectFollowed.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<ProjectFollowed, Object>() {

				@Override
				public void accept(
					ProjectFollowed projectFollowed, Object createDateObject) {

					projectFollowed.setCreateDate((Date)createDateObject);
				}

			});
		attributeGetterFunctions.put(
			"publikUserId",
			new Function<ProjectFollowed, Object>() {

				@Override
				public Object apply(ProjectFollowed projectFollowed) {
					return projectFollowed.getPublikUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"publikUserId",
			new BiConsumer<ProjectFollowed, Object>() {

				@Override
				public void accept(
					ProjectFollowed projectFollowed,
					Object publikUserIdObject) {

					projectFollowed.setPublikUserId((String)publikUserIdObject);
				}

			});
		attributeGetterFunctions.put(
			"projectId",
			new Function<ProjectFollowed, Object>() {

				@Override
				public Object apply(ProjectFollowed projectFollowed) {
					return projectFollowed.getProjectId();
				}

			});
		attributeSetterBiConsumers.put(
			"projectId",
			new BiConsumer<ProjectFollowed, Object>() {

				@Override
				public void accept(
					ProjectFollowed projectFollowed, Object projectIdObject) {

					projectFollowed.setProjectId((Long)projectIdObject);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<ProjectFollowed, Object>() {

				@Override
				public Object apply(ProjectFollowed projectFollowed) {
					return projectFollowed.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<ProjectFollowed, Object>() {

				@Override
				public void accept(
					ProjectFollowed projectFollowed, Object groupIdObject) {

					projectFollowed.setGroupId((Long)groupIdObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getProjectFollowedId() {
		return _projectFollowedId;
	}

	@Override
	public void setProjectFollowedId(long projectFollowedId) {
		_projectFollowedId = projectFollowedId;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getPublikUserId() {
		if (_publikUserId == null) {
			return "";
		}
		else {
			return _publikUserId;
		}
	}

	@Override
	public void setPublikUserId(String publikUserId) {
		_columnBitmask |= PUBLIKUSERID_COLUMN_BITMASK;

		if (_originalPublikUserId == null) {
			_originalPublikUserId = _publikUserId;
		}

		_publikUserId = publikUserId;
	}

	public String getOriginalPublikUserId() {
		return GetterUtil.getString(_originalPublikUserId);
	}

	@JSON
	@Override
	public long getProjectId() {
		return _projectId;
	}

	@Override
	public void setProjectId(long projectId) {
		_columnBitmask |= PROJECTID_COLUMN_BITMASK;

		if (!_setOriginalProjectId) {
			_setOriginalProjectId = true;

			_originalProjectId = _projectId;
		}

		_projectId = projectId;
	}

	public long getOriginalProjectId() {
		return _originalProjectId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, ProjectFollowed.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectFollowed toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProjectFollowed>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProjectFollowedImpl projectFollowedImpl = new ProjectFollowedImpl();

		projectFollowedImpl.setProjectFollowedId(getProjectFollowedId());
		projectFollowedImpl.setCreateDate(getCreateDate());
		projectFollowedImpl.setPublikUserId(getPublikUserId());
		projectFollowedImpl.setProjectId(getProjectId());
		projectFollowedImpl.setGroupId(getGroupId());

		projectFollowedImpl.resetOriginalValues();

		return projectFollowedImpl;
	}

	@Override
	public int compareTo(ProjectFollowed projectFollowed) {
		long primaryKey = projectFollowed.getPrimaryKey();

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
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectFollowed)) {
			return false;
		}

		ProjectFollowed projectFollowed = (ProjectFollowed)object;

		long primaryKey = projectFollowed.getPrimaryKey();

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
		ProjectFollowedModelImpl projectFollowedModelImpl = this;

		projectFollowedModelImpl._originalPublikUserId =
			projectFollowedModelImpl._publikUserId;

		projectFollowedModelImpl._originalProjectId =
			projectFollowedModelImpl._projectId;

		projectFollowedModelImpl._setOriginalProjectId = false;

		projectFollowedModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectFollowed> toCacheModel() {
		ProjectFollowedCacheModel projectFollowedCacheModel =
			new ProjectFollowedCacheModel();

		projectFollowedCacheModel.projectFollowedId = getProjectFollowedId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			projectFollowedCacheModel.createDate = createDate.getTime();
		}
		else {
			projectFollowedCacheModel.createDate = Long.MIN_VALUE;
		}

		projectFollowedCacheModel.publikUserId = getPublikUserId();

		String publikUserId = projectFollowedCacheModel.publikUserId;

		if ((publikUserId != null) && (publikUserId.length() == 0)) {
			projectFollowedCacheModel.publikUserId = null;
		}

		projectFollowedCacheModel.projectId = getProjectId();

		projectFollowedCacheModel.groupId = getGroupId();

		return projectFollowedCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProjectFollowed, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProjectFollowed, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectFollowed, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ProjectFollowed)this));
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
		Map<String, Function<ProjectFollowed, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProjectFollowed, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectFollowed, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProjectFollowed)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProjectFollowed>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _projectFollowedId;
	private Date _createDate;
	private String _publikUserId;
	private String _originalPublikUserId;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private long _groupId;
	private long _columnBitmask;
	private ProjectFollowed _escapedModel;

}