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

package eu.strasbourg.service.council.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.council.service.http.DeliberationServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class DeliberationSoap implements Serializable {

	public static DeliberationSoap toSoapModel(Deliberation model) {
		DeliberationSoap soapModel = new DeliberationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setDeliberationId(model.getDeliberationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setAmendement(model.getAmendement());
		soapModel.setTitle(model.getTitle());
		soapModel.setOrder(model.getOrder());
		soapModel.setStage(model.getStage());
		soapModel.setCountOfficialsVoting(model.getCountOfficialsVoting());
		soapModel.setCountOfficialsActive(model.getCountOfficialsActive());
		soapModel.setQuorum(model.getQuorum());
		soapModel.setBeginningVoteDate(model.getBeginningVoteDate());
		soapModel.setEndVoteDate(model.getEndVoteDate());
		soapModel.setCouncilSessionId(model.getCouncilSessionId());

		return soapModel;
	}

	public static DeliberationSoap[] toSoapModels(Deliberation[] models) {
		DeliberationSoap[] soapModels = new DeliberationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static DeliberationSoap[][] toSoapModels(Deliberation[][] models) {
		DeliberationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new DeliberationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new DeliberationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static DeliberationSoap[] toSoapModels(List<Deliberation> models) {
		List<DeliberationSoap> soapModels = new ArrayList<DeliberationSoap>(
			models.size());

		for (Deliberation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new DeliberationSoap[soapModels.size()]);
	}

	public DeliberationSoap() {
	}

	public long getPrimaryKey() {
		return _deliberationId;
	}

	public void setPrimaryKey(long pk) {
		setDeliberationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getDeliberationId() {
		return _deliberationId;
	}

	public void setDeliberationId(long deliberationId) {
		_deliberationId = deliberationId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
	}

	public String getAmendement() {
		return _amendement;
	}

	public void setAmendement(String amendement) {
		_amendement = amendement;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public int getOrder() {
		return _order;
	}

	public void setOrder(int order) {
		_order = order;
	}

	public String getStage() {
		return _stage;
	}

	public void setStage(String stage) {
		_stage = stage;
	}

	public int getCountOfficialsVoting() {
		return _countOfficialsVoting;
	}

	public void setCountOfficialsVoting(int countOfficialsVoting) {
		_countOfficialsVoting = countOfficialsVoting;
	}

	public int getCountOfficialsActive() {
		return _countOfficialsActive;
	}

	public void setCountOfficialsActive(int countOfficialsActive) {
		_countOfficialsActive = countOfficialsActive;
	}

	public int getQuorum() {
		return _quorum;
	}

	public void setQuorum(int quorum) {
		_quorum = quorum;
	}

	public Date getBeginningVoteDate() {
		return _beginningVoteDate;
	}

	public void setBeginningVoteDate(Date beginningVoteDate) {
		_beginningVoteDate = beginningVoteDate;
	}

	public Date getEndVoteDate() {
		return _endVoteDate;
	}

	public void setEndVoteDate(Date endVoteDate) {
		_endVoteDate = endVoteDate;
	}

	public long getCouncilSessionId() {
		return _councilSessionId;
	}

	public void setCouncilSessionId(long councilSessionId) {
		_councilSessionId = councilSessionId;
	}

	private String _uuid;
	private long _deliberationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _amendement;
	private String _title;
	private int _order;
	private String _stage;
	private int _countOfficialsVoting;
	private int _countOfficialsActive;
	private int _quorum;
	private Date _beginningVoteDate;
	private Date _endVoteDate;
	private long _councilSessionId;

}