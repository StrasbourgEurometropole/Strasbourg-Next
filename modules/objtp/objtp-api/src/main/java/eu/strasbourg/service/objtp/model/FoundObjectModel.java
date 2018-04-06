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

package eu.strasbourg.service.objtp.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the FoundObject service. Represents a row in the &quot;objtp_FoundObject&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link eu.strasbourg.service.objtp.model.impl.FoundObjectModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link eu.strasbourg.service.objtp.model.impl.FoundObjectImpl}.
 * </p>
 *
 * @author JeremyZwickert
 * @see FoundObject
 * @see eu.strasbourg.service.objtp.model.impl.FoundObjectImpl
 * @see eu.strasbourg.service.objtp.model.impl.FoundObjectModelImpl
 * @generated
 */
@ProviderType
public interface FoundObjectModel extends BaseModel<FoundObject> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a found object model instance should use the {@link FoundObject} interface instead.
	 */

	/**
	 * Returns the primary key of this found object.
	 *
	 * @return the primary key of this found object
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this found object.
	 *
	 * @param primaryKey the primary key of this found object
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the number of this found object.
	 *
	 * @return the number of this found object
	 */
	@AutoEscape
	public String getNumber();

	/**
	 * Sets the number of this found object.
	 *
	 * @param number the number of this found object
	 */
	public void setNumber(String number);

	/**
	 * Returns the date of this found object.
	 *
	 * @return the date of this found object
	 */
	@AutoEscape
	public String getDate();

	/**
	 * Sets the date of this found object.
	 *
	 * @param date the date of this found object
	 */
	public void setDate(String date);

	/**
	 * Returns the image url of this found object.
	 *
	 * @return the image url of this found object
	 */
	@AutoEscape
	public String getImageURL();

	/**
	 * Sets the image url of this found object.
	 *
	 * @param imageURL the image url of this found object
	 */
	public void setImageURL(String imageURL);

	/**
	 * Returns the category code of this found object.
	 *
	 * @return the category code of this found object
	 */
	@AutoEscape
	public String getCategoryCode();

	/**
	 * Sets the category code of this found object.
	 *
	 * @param categoryCode the category code of this found object
	 */
	public void setCategoryCode(String categoryCode);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		eu.strasbourg.service.objtp.model.FoundObject foundObject);

	@Override
	public int hashCode();

	@Override
	public CacheModel<eu.strasbourg.service.objtp.model.FoundObject> toCacheModel();

	@Override
	public eu.strasbourg.service.objtp.model.FoundObject toEscapedModel();

	@Override
	public eu.strasbourg.service.objtp.model.FoundObject toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}