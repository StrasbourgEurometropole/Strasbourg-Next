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

package eu.strasbourg.service.council.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import eu.strasbourg.service.council.model.Vote;
import eu.strasbourg.service.council.model.VoteModel;
import eu.strasbourg.service.council.service.persistence.VotePK;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Vote service. Represents a row in the &quot;council_Vote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link VoteModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see VoteImpl
 * @see Vote
 * @see VoteModel
 * @generated
 */
@ProviderType
public class VoteModelImpl extends BaseModelImpl<Vote> implements VoteModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a vote model instance should use the {@link Vote} interface instead.
	 */
	public static final String TABLE_NAME = "council_Vote";
	public static final Object[][] TABLE_COLUMNS = {
			{ "uuid_", Types.VARCHAR },
			{ "officialId", Types.BIGINT },
			{ "deliberationId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "createDate", Types.TIMESTAMP },
			{ "result", Types.VARCHAR },
			{ "officialProcurationId", Types.BIGINT }
		};
	public static final Map<String, Integer> TABLE_COLUMNS_MAP = new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("deliberationId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("result", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("officialProcurationId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE = "create table council_Vote (uuid_ VARCHAR(75) null,officialId LONG not null,deliberationId LONG not null,groupId LONG,companyId LONG,createDate DATE null,result VARCHAR(75) null,officialProcurationId LONG,primary key (officialId, deliberationId))";
	public static final String TABLE_SQL_DROP = "drop table council_Vote";
	public static final String ORDER_BY_JPQL = " ORDER BY vote.id.deliberationId DESC";
	public static final String ORDER_BY_SQL = " ORDER BY council_Vote.deliberationId DESC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.entity.cache.enabled.eu.strasbourg.service.council.model.Vote"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.finder.cache.enabled.eu.strasbourg.service.council.model.Vote"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"value.object.column.bitmask.enabled.eu.strasbourg.service.council.model.Vote"),
			true);
	public static final long COMPANYID_COLUMN_BITMASK = 1L;
	public static final long DELIBERATIONID_COLUMN_BITMASK = 2L;
	public static final long GROUPID_COLUMN_BITMASK = 4L;
	public static final long OFFICIALID_COLUMN_BITMASK = 8L;
	public static final long UUID_COLUMN_BITMASK = 16L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(eu.strasbourg.service.council.service.util.ServiceProps.get(
				"lock.expiration.time.eu.strasbourg.service.council.model.Vote"));

	public VoteModelImpl() {
	}

	@Override
	public VotePK getPrimaryKey() {
		return new VotePK(_officialId, _deliberationId);
	}

	@Override
	public void setPrimaryKey(VotePK primaryKey) {
		setOfficialId(primaryKey.officialId);
		setDeliberationId(primaryKey.deliberationId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new VotePK(_officialId, _deliberationId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((VotePK)primaryKeyObj);
	}

	@Override
	public Class<?> getModelClass() {
		return Vote.class;
	}

	@Override
	public String getModelClassName() {
		return Vote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("officialId", getOfficialId());
		attributes.put("deliberationId", getDeliberationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("result", getResult());
		attributes.put("officialProcurationId", getOfficialProcurationId());

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long officialId = (Long)attributes.get("officialId");

		if (officialId != null) {
			setOfficialId(officialId);
		}

		Long deliberationId = (Long)attributes.get("deliberationId");

		if (deliberationId != null) {
			setDeliberationId(deliberationId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}

		Long officialProcurationId = (Long)attributes.get(
				"officialProcurationId");

		if (officialProcurationId != null) {
			setOfficialProcurationId(officialProcurationId);
		}
	}

	@Override
	public String getUuid() {
		if (_uuid == null) {
			return StringPool.BLANK;
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@Override
	public long getOfficialId() {
		return _officialId;
	}

	@Override
	public void setOfficialId(long officialId) {
		_columnBitmask |= OFFICIALID_COLUMN_BITMASK;

		if (!_setOriginalOfficialId) {
			_setOriginalOfficialId = true;

			_originalOfficialId = _officialId;
		}

		_officialId = officialId;
	}

	public long getOriginalOfficialId() {
		return _originalOfficialId;
	}

	@Override
	public long getDeliberationId() {
		return _deliberationId;
	}

	@Override
	public void setDeliberationId(long deliberationId) {
		_columnBitmask = -1L;

		if (!_setOriginalDeliberationId) {
			_setOriginalDeliberationId = true;

			_originalDeliberationId = _deliberationId;
		}

		_deliberationId = deliberationId;
	}

	public long getOriginalDeliberationId() {
		return _originalDeliberationId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public String getResult() {
		if (_result == null) {
			return StringPool.BLANK;
		}
		else {
			return _result;
		}
	}

	@Override
	public void setResult(String result) {
		_result = result;
	}

	@Override
	public long getOfficialProcurationId() {
		return _officialProcurationId;
	}

	@Override
	public void setOfficialProcurationId(long officialProcurationId) {
		_officialProcurationId = officialProcurationId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public Vote toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Vote)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VoteImpl voteImpl = new VoteImpl();

		voteImpl.setUuid(getUuid());
		voteImpl.setOfficialId(getOfficialId());
		voteImpl.setDeliberationId(getDeliberationId());
		voteImpl.setGroupId(getGroupId());
		voteImpl.setCompanyId(getCompanyId());
		voteImpl.setCreateDate(getCreateDate());
		voteImpl.setResult(getResult());
		voteImpl.setOfficialProcurationId(getOfficialProcurationId());

		voteImpl.resetOriginalValues();

		return voteImpl;
	}

	@Override
	public int compareTo(Vote vote) {
		int value = 0;

		if (getDeliberationId() < vote.getDeliberationId()) {
			value = -1;
		}
		else if (getDeliberationId() > vote.getDeliberationId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Vote)) {
			return false;
		}

		Vote vote = (Vote)obj;

		VotePK primaryKey = vote.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
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
		VoteModelImpl voteModelImpl = this;

		voteModelImpl._originalUuid = voteModelImpl._uuid;

		voteModelImpl._originalOfficialId = voteModelImpl._officialId;

		voteModelImpl._setOriginalOfficialId = false;

		voteModelImpl._originalDeliberationId = voteModelImpl._deliberationId;

		voteModelImpl._setOriginalDeliberationId = false;

		voteModelImpl._originalGroupId = voteModelImpl._groupId;

		voteModelImpl._setOriginalGroupId = false;

		voteModelImpl._originalCompanyId = voteModelImpl._companyId;

		voteModelImpl._setOriginalCompanyId = false;

		voteModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Vote> toCacheModel() {
		VoteCacheModel voteCacheModel = new VoteCacheModel();

		voteCacheModel.votePK = getPrimaryKey();

		voteCacheModel.uuid = getUuid();

		String uuid = voteCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			voteCacheModel.uuid = null;
		}

		voteCacheModel.officialId = getOfficialId();

		voteCacheModel.deliberationId = getDeliberationId();

		voteCacheModel.groupId = getGroupId();

		voteCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			voteCacheModel.createDate = createDate.getTime();
		}
		else {
			voteCacheModel.createDate = Long.MIN_VALUE;
		}

		voteCacheModel.result = getResult();

		String result = voteCacheModel.result;

		if ((result != null) && (result.length() == 0)) {
			voteCacheModel.result = null;
		}

		voteCacheModel.officialProcurationId = getOfficialProcurationId();

		return voteCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", officialId=");
		sb.append(getOfficialId());
		sb.append(", deliberationId=");
		sb.append(getDeliberationId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", result=");
		sb.append(getResult());
		sb.append(", officialProcurationId=");
		sb.append(getOfficialProcurationId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("eu.strasbourg.service.council.model.Vote");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officialId</column-name><column-value><![CDATA[");
		sb.append(getOfficialId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>deliberationId</column-name><column-value><![CDATA[");
		sb.append(getDeliberationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>officialProcurationId</column-name><column-value><![CDATA[");
		sb.append(getOfficialProcurationId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static final ClassLoader _classLoader = Vote.class.getClassLoader();
	private static final Class<?>[] _escapedModelInterfaces = new Class[] {
			Vote.class
		};
	private String _uuid;
	private String _originalUuid;
	private long _officialId;
	private long _originalOfficialId;
	private boolean _setOriginalOfficialId;
	private long _deliberationId;
	private long _originalDeliberationId;
	private boolean _setOriginalDeliberationId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private Date _createDate;
	private String _result;
	private long _officialProcurationId;
	private long _columnBitmask;
	private Vote _escapedModel;
}