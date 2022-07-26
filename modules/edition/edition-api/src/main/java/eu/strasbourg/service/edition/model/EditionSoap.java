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

package eu.strasbourg.service.edition.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link eu.strasbourg.service.edition.service.http.EditionServiceSoap}.
 *
 * @author BenjaminBini
 * @generated
 */
public class EditionSoap implements Serializable {

	public static EditionSoap toSoapModel(Edition model) {
		EditionSoap soapModel = new EditionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setEditionId(model.getEditionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setLastPublishDate(model.getLastPublishDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setSubtitle(model.getSubtitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setURL(model.getURL());
		soapModel.setAuthor(model.getAuthor());
		soapModel.setEditor(model.getEditor());
		soapModel.setDistribution(model.getDistribution());
		soapModel.setISBN(model.getISBN());
		soapModel.setPrice(model.getPrice());
		soapModel.setAvailableForExchange(model.isAvailableForExchange());
		soapModel.setInStock(model.isInStock());
		soapModel.setDiffusionDateYear(model.getDiffusionDateYear());
		soapModel.setDiffusionDateMonth(model.getDiffusionDateMonth());
		soapModel.setPageNumber(model.getPageNumber());
		soapModel.setPictureNumber(model.getPictureNumber());
		soapModel.setPublicationDate(model.getPublicationDate());
		soapModel.setImageId(model.getImageId());
		soapModel.setFileId(model.getFileId());

		return soapModel;
	}

	public static EditionSoap[] toSoapModels(Edition[] models) {
		EditionSoap[] soapModels = new EditionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EditionSoap[][] toSoapModels(Edition[][] models) {
		EditionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EditionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EditionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EditionSoap[] toSoapModels(List<Edition> models) {
		List<EditionSoap> soapModels = new ArrayList<EditionSoap>(
			models.size());

		for (Edition model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EditionSoap[soapModels.size()]);
	}

	public EditionSoap() {
	}

	public long getPrimaryKey() {
		return _editionId;
	}

	public void setPrimaryKey(long pk) {
		setEditionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getEditionId() {
		return _editionId;
	}

	public void setEditionId(long editionId) {
		_editionId = editionId;
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

	public Date getLastPublishDate() {
		return _lastPublishDate;
	}

	public void setLastPublishDate(Date lastPublishDate) {
		_lastPublishDate = lastPublishDate;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getSubtitle() {
		return _subtitle;
	}

	public void setSubtitle(String subtitle) {
		_subtitle = subtitle;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getURL() {
		return _URL;
	}

	public void setURL(String URL) {
		_URL = URL;
	}

	public String getAuthor() {
		return _author;
	}

	public void setAuthor(String author) {
		_author = author;
	}

	public String getEditor() {
		return _editor;
	}

	public void setEditor(String editor) {
		_editor = editor;
	}

	public String getDistribution() {
		return _distribution;
	}

	public void setDistribution(String distribution) {
		_distribution = distribution;
	}

	public String getISBN() {
		return _ISBN;
	}

	public void setISBN(String ISBN) {
		_ISBN = ISBN;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	public boolean getAvailableForExchange() {
		return _availableForExchange;
	}

	public boolean isAvailableForExchange() {
		return _availableForExchange;
	}

	public void setAvailableForExchange(boolean availableForExchange) {
		_availableForExchange = availableForExchange;
	}

	public boolean getInStock() {
		return _inStock;
	}

	public boolean isInStock() {
		return _inStock;
	}

	public void setInStock(boolean inStock) {
		_inStock = inStock;
	}

	public String getDiffusionDateYear() {
		return _diffusionDateYear;
	}

	public void setDiffusionDateYear(String diffusionDateYear) {
		_diffusionDateYear = diffusionDateYear;
	}

	public String getDiffusionDateMonth() {
		return _diffusionDateMonth;
	}

	public void setDiffusionDateMonth(String diffusionDateMonth) {
		_diffusionDateMonth = diffusionDateMonth;
	}

	public String getPageNumber() {
		return _pageNumber;
	}

	public void setPageNumber(String pageNumber) {
		_pageNumber = pageNumber;
	}

	public String getPictureNumber() {
		return _pictureNumber;
	}

	public void setPictureNumber(String pictureNumber) {
		_pictureNumber = pictureNumber;
	}

	public Date getPublicationDate() {
		return _publicationDate;
	}

	public void setPublicationDate(Date publicationDate) {
		_publicationDate = publicationDate;
	}

	public Long getImageId() {
		return _imageId;
	}

	public void setImageId(Long imageId) {
		_imageId = imageId;
	}

	public String getFileId() {
		return _fileId;
	}

	public void setFileId(String fileId) {
		_fileId = fileId;
	}

	private String _uuid;
	private long _editionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _lastPublishDate;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private String _title;
	private String _subtitle;
	private String _description;

	private String _URL;

	private String _author;
	private String _editor;
	private String _distribution;

	private String _ISBN;

	private String _price;
	private boolean _availableForExchange;
	private boolean _inStock;
	private String _diffusionDateYear;
	private String _diffusionDateMonth;
	private String _pageNumber;
	private String _pictureNumber;
	private Date _publicationDate;
	private Long _imageId;
	private String _fileId;

}