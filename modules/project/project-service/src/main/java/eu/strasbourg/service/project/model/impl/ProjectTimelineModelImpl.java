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
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import eu.strasbourg.service.project.model.ProjectTimeline;
import eu.strasbourg.service.project.model.ProjectTimelineModel;
import eu.strasbourg.service.project.model.ProjectTimelineSoap;

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
 * The base model implementation for the ProjectTimeline service. Represents a row in the &quot;project_ProjectTimeline&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ProjectTimelineModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProjectTimelineImpl}.
 * </p>
 *
 * @author Cedric Henry
 * @see ProjectTimelineImpl
 * @generated
 */
@JSON(strict = true)
public class ProjectTimelineModelImpl
	extends BaseModelImpl<ProjectTimeline> implements ProjectTimelineModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a project timeline model instance should use the <code>ProjectTimeline</code> interface instead.
	 */
	public static final String TABLE_NAME = "project_ProjectTimeline";

	public static final Object[][] TABLE_COLUMNS = {
		{"projectTimelineId", Types.BIGINT}, {"startDay", Types.INTEGER},
		{"spacing", Types.INTEGER}, {"date_", Types.TIMESTAMP},
		{"dateFormat", Types.VARCHAR}, {"title", Types.VARCHAR},
		{"link", Types.VARCHAR}, {"projectId", Types.BIGINT},
		{"budgetParticipatifId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("projectTimelineId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("startDay", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("spacing", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("date_", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("dateFormat", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("title", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("link", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("projectId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("budgetParticipatifId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table project_ProjectTimeline (projectTimelineId LONG not null primary key,startDay INTEGER,spacing INTEGER,date_ DATE null,dateFormat VARCHAR(75) null,title VARCHAR(400) null,link VARCHAR(400) null,projectId LONG,budgetParticipatifId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table project_ProjectTimeline";

	public static final String ORDER_BY_JPQL =
		" ORDER BY projectTimeline.date ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY project_ProjectTimeline.date_ ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.entity.cache.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.finder.cache.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"value.object.column.bitmask.enabled.eu.strasbourg.service.project.model.ProjectTimeline"),
		true);

	public static final long BUDGETPARTICIPATIFID_COLUMN_BITMASK = 1L;

	public static final long PROJECTID_COLUMN_BITMASK = 2L;

	public static final long DATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static ProjectTimeline toModel(ProjectTimelineSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		ProjectTimeline model = new ProjectTimelineImpl();

		model.setProjectTimelineId(soapModel.getProjectTimelineId());
		model.setStartDay(soapModel.getStartDay());
		model.setSpacing(soapModel.getSpacing());
		model.setDate(soapModel.getDate());
		model.setDateFormat(soapModel.getDateFormat());
		model.setTitle(soapModel.getTitle());
		model.setLink(soapModel.getLink());
		model.setProjectId(soapModel.getProjectId());
		model.setBudgetParticipatifId(soapModel.getBudgetParticipatifId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<ProjectTimeline> toModels(
		ProjectTimelineSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<ProjectTimeline> models = new ArrayList<ProjectTimeline>(
			soapModels.length);

		for (ProjectTimelineSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		eu.strasbourg.service.project.service.util.PropsUtil.get(
			"lock.expiration.time.eu.strasbourg.service.project.model.ProjectTimeline"));

	public ProjectTimelineModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _projectTimelineId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setProjectTimelineId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _projectTimelineId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ProjectTimeline.class;
	}

	@Override
	public String getModelClassName() {
		return ProjectTimeline.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ProjectTimeline, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ProjectTimeline, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectTimeline, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ProjectTimeline)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ProjectTimeline, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ProjectTimeline, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ProjectTimeline)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ProjectTimeline, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ProjectTimeline, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ProjectTimeline>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ProjectTimeline.class.getClassLoader(), ProjectTimeline.class,
			ModelWrapper.class);

		try {
			Constructor<ProjectTimeline> constructor =
				(Constructor<ProjectTimeline>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ProjectTimeline, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ProjectTimeline, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ProjectTimeline, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<ProjectTimeline, Object>>();
		Map<String, BiConsumer<ProjectTimeline, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<ProjectTimeline, ?>>();

		attributeGetterFunctions.put(
			"projectTimelineId",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getProjectTimelineId();
				}

			});
		attributeSetterBiConsumers.put(
			"projectTimelineId",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline,
					Object projectTimelineIdObject) {

					projectTimeline.setProjectTimelineId(
						(Long)projectTimelineIdObject);
				}

			});
		attributeGetterFunctions.put(
			"startDay",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getStartDay();
				}

			});
		attributeSetterBiConsumers.put(
			"startDay",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object startDayObject) {

					projectTimeline.setStartDay((Integer)startDayObject);
				}

			});
		attributeGetterFunctions.put(
			"spacing",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getSpacing();
				}

			});
		attributeSetterBiConsumers.put(
			"spacing",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object spacingObject) {

					projectTimeline.setSpacing((Integer)spacingObject);
				}

			});
		attributeGetterFunctions.put(
			"date",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getDate();
				}

			});
		attributeSetterBiConsumers.put(
			"date",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object dateObject) {

					projectTimeline.setDate((Date)dateObject);
				}

			});
		attributeGetterFunctions.put(
			"dateFormat",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getDateFormat();
				}

			});
		attributeSetterBiConsumers.put(
			"dateFormat",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object dateFormatObject) {

					projectTimeline.setDateFormat((String)dateFormatObject);
				}

			});
		attributeGetterFunctions.put(
			"title",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getTitle();
				}

			});
		attributeSetterBiConsumers.put(
			"title",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object titleObject) {

					projectTimeline.setTitle((String)titleObject);
				}

			});
		attributeGetterFunctions.put(
			"link",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getLink();
				}

			});
		attributeSetterBiConsumers.put(
			"link",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object linkObject) {

					projectTimeline.setLink((String)linkObject);
				}

			});
		attributeGetterFunctions.put(
			"projectId",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getProjectId();
				}

			});
		attributeSetterBiConsumers.put(
			"projectId",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline, Object projectIdObject) {

					projectTimeline.setProjectId((Long)projectIdObject);
				}

			});
		attributeGetterFunctions.put(
			"budgetParticipatifId",
			new Function<ProjectTimeline, Object>() {

				@Override
				public Object apply(ProjectTimeline projectTimeline) {
					return projectTimeline.getBudgetParticipatifId();
				}

			});
		attributeSetterBiConsumers.put(
			"budgetParticipatifId",
			new BiConsumer<ProjectTimeline, Object>() {

				@Override
				public void accept(
					ProjectTimeline projectTimeline,
					Object budgetParticipatifIdObject) {

					projectTimeline.setBudgetParticipatifId(
						(Long)budgetParticipatifIdObject);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getProjectTimelineId() {
		return _projectTimelineId;
	}

	@Override
	public void setProjectTimelineId(long projectTimelineId) {
		_projectTimelineId = projectTimelineId;
	}

	@JSON
	@Override
	public int getStartDay() {
		return _startDay;
	}

	@Override
	public void setStartDay(int startDay) {
		_startDay = startDay;
	}

	@JSON
	@Override
	public int getSpacing() {
		return _spacing;
	}

	@Override
	public void setSpacing(int spacing) {
		_spacing = spacing;
	}

	@JSON
	@Override
	public Date getDate() {
		return _date;
	}

	@Override
	public void setDate(Date date) {
		_columnBitmask = -1L;

		_date = date;
	}

	@JSON
	@Override
	public String getDateFormat() {
		if (_dateFormat == null) {
			return "";
		}
		else {
			return _dateFormat;
		}
	}

	@Override
	public void setDateFormat(String dateFormat) {
		_dateFormat = dateFormat;
	}

	@JSON
	@Override
	public String getTitle() {
		if (_title == null) {
			return "";
		}
		else {
			return _title;
		}
	}

	@Override
	public void setTitle(String title) {
		_title = title;
	}

	@JSON
	@Override
	public String getLink() {
		if (_link == null) {
			return "";
		}
		else {
			return _link;
		}
	}

	@Override
	public void setLink(String link) {
		_link = link;
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
	public long getBudgetParticipatifId() {
		return _budgetParticipatifId;
	}

	@Override
	public void setBudgetParticipatifId(long budgetParticipatifId) {
		_columnBitmask |= BUDGETPARTICIPATIFID_COLUMN_BITMASK;

		if (!_setOriginalBudgetParticipatifId) {
			_setOriginalBudgetParticipatifId = true;

			_originalBudgetParticipatifId = _budgetParticipatifId;
		}

		_budgetParticipatifId = budgetParticipatifId;
	}

	public long getOriginalBudgetParticipatifId() {
		return _originalBudgetParticipatifId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, ProjectTimeline.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ProjectTimeline toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ProjectTimeline>
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
		ProjectTimelineImpl projectTimelineImpl = new ProjectTimelineImpl();

		projectTimelineImpl.setProjectTimelineId(getProjectTimelineId());
		projectTimelineImpl.setStartDay(getStartDay());
		projectTimelineImpl.setSpacing(getSpacing());
		projectTimelineImpl.setDate(getDate());
		projectTimelineImpl.setDateFormat(getDateFormat());
		projectTimelineImpl.setTitle(getTitle());
		projectTimelineImpl.setLink(getLink());
		projectTimelineImpl.setProjectId(getProjectId());
		projectTimelineImpl.setBudgetParticipatifId(getBudgetParticipatifId());

		projectTimelineImpl.resetOriginalValues();

		return projectTimelineImpl;
	}

	@Override
	public int compareTo(ProjectTimeline projectTimeline) {
		int value = 0;

		value = DateUtil.compareTo(getDate(), projectTimeline.getDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProjectTimeline)) {
			return false;
		}

		ProjectTimeline projectTimeline = (ProjectTimeline)object;

		long primaryKey = projectTimeline.getPrimaryKey();

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
		ProjectTimelineModelImpl projectTimelineModelImpl = this;

		projectTimelineModelImpl._originalProjectId =
			projectTimelineModelImpl._projectId;

		projectTimelineModelImpl._setOriginalProjectId = false;

		projectTimelineModelImpl._originalBudgetParticipatifId =
			projectTimelineModelImpl._budgetParticipatifId;

		projectTimelineModelImpl._setOriginalBudgetParticipatifId = false;

		projectTimelineModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ProjectTimeline> toCacheModel() {
		ProjectTimelineCacheModel projectTimelineCacheModel =
			new ProjectTimelineCacheModel();

		projectTimelineCacheModel.projectTimelineId = getProjectTimelineId();

		projectTimelineCacheModel.startDay = getStartDay();

		projectTimelineCacheModel.spacing = getSpacing();

		Date date = getDate();

		if (date != null) {
			projectTimelineCacheModel.date = date.getTime();
		}
		else {
			projectTimelineCacheModel.date = Long.MIN_VALUE;
		}

		projectTimelineCacheModel.dateFormat = getDateFormat();

		String dateFormat = projectTimelineCacheModel.dateFormat;

		if ((dateFormat != null) && (dateFormat.length() == 0)) {
			projectTimelineCacheModel.dateFormat = null;
		}

		projectTimelineCacheModel.title = getTitle();

		String title = projectTimelineCacheModel.title;

		if ((title != null) && (title.length() == 0)) {
			projectTimelineCacheModel.title = null;
		}

		projectTimelineCacheModel.link = getLink();

		String link = projectTimelineCacheModel.link;

		if ((link != null) && (link.length() == 0)) {
			projectTimelineCacheModel.link = null;
		}

		projectTimelineCacheModel.projectId = getProjectId();

		projectTimelineCacheModel.budgetParticipatifId =
			getBudgetParticipatifId();

		return projectTimelineCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ProjectTimeline, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ProjectTimeline, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectTimeline, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ProjectTimeline)this));
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
		Map<String, Function<ProjectTimeline, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ProjectTimeline, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ProjectTimeline, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ProjectTimeline)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ProjectTimeline>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private long _projectTimelineId;
	private int _startDay;
	private int _spacing;
	private Date _date;
	private String _dateFormat;
	private String _title;
	private String _link;
	private long _projectId;
	private long _originalProjectId;
	private boolean _setOriginalProjectId;
	private long _budgetParticipatifId;
	private long _originalBudgetParticipatifId;
	private boolean _setOriginalBudgetParticipatifId;
	private long _columnBitmask;
	private ProjectTimeline _escapedModel;

}