/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.tipi.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link TipiEntry}.
 * </p>
 *
 * @author Angelique Zunino Champougny
 * @see TipiEntry
 * @generated
 */
public class TipiEntryWrapper
	extends BaseModelWrapper<TipiEntry>
	implements ModelWrapper<TipiEntry>, TipiEntry {

	public TipiEntryWrapper(TipiEntry tipiEntry) {
		super(tipiEntry);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("id", getId());
		attributes.put("date", getDate());
		attributes.put("total", getTotal());
		attributes.put("paidCount", getPaidCount());
		attributes.put("refusedCount", getRefusedCount());
		attributes.put("canceledCount", getCanceledCount());
		attributes.put("type", getType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		Integer total = (Integer)attributes.get("total");

		if (total != null) {
			setTotal(total);
		}

		Integer paidCount = (Integer)attributes.get("paidCount");

		if (paidCount != null) {
			setPaidCount(paidCount);
		}

		Integer refusedCount = (Integer)attributes.get("refusedCount");

		if (refusedCount != null) {
			setRefusedCount(refusedCount);
		}

		Integer canceledCount = (Integer)attributes.get("canceledCount");

		if (canceledCount != null) {
			setCanceledCount(canceledCount);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}
	}

	@Override
	public TipiEntry cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the canceled count of this tipi entry.
	 *
	 * @return the canceled count of this tipi entry
	 */
	@Override
	public int getCanceledCount() {
		return model.getCanceledCount();
	}

	/**
	 * Returns the date of this tipi entry.
	 *
	 * @return the date of this tipi entry
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the ID of this tipi entry.
	 *
	 * @return the ID of this tipi entry
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the paid count of this tipi entry.
	 *
	 * @return the paid count of this tipi entry
	 */
	@Override
	public int getPaidCount() {
		return model.getPaidCount();
	}

	/**
	 * Returns the primary key of this tipi entry.
	 *
	 * @return the primary key of this tipi entry
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the refused count of this tipi entry.
	 *
	 * @return the refused count of this tipi entry
	 */
	@Override
	public int getRefusedCount() {
		return model.getRefusedCount();
	}

	/**
	 * Returns the total of this tipi entry.
	 *
	 * @return the total of this tipi entry
	 */
	@Override
	public int getTotal() {
		return model.getTotal();
	}

	/**
	 * Returns the type of this tipi entry.
	 *
	 * @return the type of this tipi entry
	 */
	@Override
	public String getType() {
		return model.getType();
	}

	/**
	 * Returns the uuid of this tipi entry.
	 *
	 * @return the uuid of this tipi entry
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the canceled count of this tipi entry.
	 *
	 * @param canceledCount the canceled count of this tipi entry
	 */
	@Override
	public void setCanceledCount(int canceledCount) {
		model.setCanceledCount(canceledCount);
	}

	/**
	 * Sets the date of this tipi entry.
	 *
	 * @param date the date of this tipi entry
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the ID of this tipi entry.
	 *
	 * @param id the ID of this tipi entry
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the paid count of this tipi entry.
	 *
	 * @param paidCount the paid count of this tipi entry
	 */
	@Override
	public void setPaidCount(int paidCount) {
		model.setPaidCount(paidCount);
	}

	/**
	 * Sets the primary key of this tipi entry.
	 *
	 * @param primaryKey the primary key of this tipi entry
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the refused count of this tipi entry.
	 *
	 * @param refusedCount the refused count of this tipi entry
	 */
	@Override
	public void setRefusedCount(int refusedCount) {
		model.setRefusedCount(refusedCount);
	}

	/**
	 * Sets the total of this tipi entry.
	 *
	 * @param total the total of this tipi entry
	 */
	@Override
	public void setTotal(int total) {
		model.setTotal(total);
	}

	/**
	 * Sets the type of this tipi entry.
	 *
	 * @param type the type of this tipi entry
	 */
	@Override
	public void setType(String type) {
		model.setType(type);
	}

	/**
	 * Sets the uuid of this tipi entry.
	 *
	 * @param uuid the uuid of this tipi entry
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
	protected TipiEntryWrapper wrap(TipiEntry tipiEntry) {
		return new TipiEntryWrapper(tipiEntry);
	}

}