/**
 * SPDX-FileCopyrightText: (c) 2023 Liferay, Inc. https://liferay.com
 * SPDX-License-Identifier: LGPL-2.1-or-later OR LicenseRef-Liferay-DXP-EULA-2.0.0-2023-06
 */

package eu.strasbourg.service.search.log.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SearchLog}.
 * </p>
 *
 * @author BenjaminBini
 * @see SearchLog
 * @generated
 */
public class SearchLogWrapper
	extends BaseModelWrapper<SearchLog>
	implements ModelWrapper<SearchLog>, SearchLog {

	public SearchLogWrapper(SearchLog searchLog) {
		super(searchLog);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("searchLogId", getSearchLogId());
		attributes.put("keywords", getKeywords());
		attributes.put("searchTime", getSearchTime());
		attributes.put("resultCount", getResultCount());
		attributes.put("result1ClassId", getResult1ClassId());
		attributes.put("result1ClassPK", getResult1ClassPK());
		attributes.put("result1Title", getResult1Title());
		attributes.put("result2ClassId", getResult2ClassId());
		attributes.put("result2ClassPK", getResult2ClassPK());
		attributes.put("result2Title", getResult2Title());
		attributes.put("result3ClassId", getResult3ClassId());
		attributes.put("result3ClassPK", getResult3ClassPK());
		attributes.put("result3Title", getResult3Title());
		attributes.put("userTargetClassId", getUserTargetClassId());
		attributes.put("userTargetClassPK", getUserTargetClassPK());
		attributes.put("userTargetTitle", getUserTargetTitle());
		attributes.put("groupId", getGroupId());
		attributes.put("layoutId", getLayoutId());
		attributes.put("layoutFriendlyURL", getLayoutFriendlyURL());
		attributes.put("language", getLanguage());
		attributes.put("date", getDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long searchLogId = (Long)attributes.get("searchLogId");

		if (searchLogId != null) {
			setSearchLogId(searchLogId);
		}

		String keywords = (String)attributes.get("keywords");

		if (keywords != null) {
			setKeywords(keywords);
		}

		Long searchTime = (Long)attributes.get("searchTime");

		if (searchTime != null) {
			setSearchTime(searchTime);
		}

		Long resultCount = (Long)attributes.get("resultCount");

		if (resultCount != null) {
			setResultCount(resultCount);
		}

		Long result1ClassId = (Long)attributes.get("result1ClassId");

		if (result1ClassId != null) {
			setResult1ClassId(result1ClassId);
		}

		Long result1ClassPK = (Long)attributes.get("result1ClassPK");

		if (result1ClassPK != null) {
			setResult1ClassPK(result1ClassPK);
		}

		String result1Title = (String)attributes.get("result1Title");

		if (result1Title != null) {
			setResult1Title(result1Title);
		}

		Long result2ClassId = (Long)attributes.get("result2ClassId");

		if (result2ClassId != null) {
			setResult2ClassId(result2ClassId);
		}

		Long result2ClassPK = (Long)attributes.get("result2ClassPK");

		if (result2ClassPK != null) {
			setResult2ClassPK(result2ClassPK);
		}

		String result2Title = (String)attributes.get("result2Title");

		if (result2Title != null) {
			setResult2Title(result2Title);
		}

		Long result3ClassId = (Long)attributes.get("result3ClassId");

		if (result3ClassId != null) {
			setResult3ClassId(result3ClassId);
		}

		Long result3ClassPK = (Long)attributes.get("result3ClassPK");

		if (result3ClassPK != null) {
			setResult3ClassPK(result3ClassPK);
		}

		String result3Title = (String)attributes.get("result3Title");

		if (result3Title != null) {
			setResult3Title(result3Title);
		}

		Long userTargetClassId = (Long)attributes.get("userTargetClassId");

		if (userTargetClassId != null) {
			setUserTargetClassId(userTargetClassId);
		}

		Long userTargetClassPK = (Long)attributes.get("userTargetClassPK");

		if (userTargetClassPK != null) {
			setUserTargetClassPK(userTargetClassPK);
		}

		String userTargetTitle = (String)attributes.get("userTargetTitle");

		if (userTargetTitle != null) {
			setUserTargetTitle(userTargetTitle);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		String layoutFriendlyURL = (String)attributes.get("layoutFriendlyURL");

		if (layoutFriendlyURL != null) {
			setLayoutFriendlyURL(layoutFriendlyURL);
		}

		String language = (String)attributes.get("language");

		if (language != null) {
			setLanguage(language);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}
	}

	@Override
	public SearchLog cloneWithOriginalValues() {
		return wrap(model.cloneWithOriginalValues());
	}

	/**
	 * Returns the date of this search log.
	 *
	 * @return the date of this search log
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the group ID of this search log.
	 *
	 * @return the group ID of this search log
	 */
	@Override
	public long getGroupId() {
		return model.getGroupId();
	}

	/**
	 * Returns the keywords of this search log.
	 *
	 * @return the keywords of this search log
	 */
	@Override
	public String getKeywords() {
		return model.getKeywords();
	}

	/**
	 * Returns the language of this search log.
	 *
	 * @return the language of this search log
	 */
	@Override
	public String getLanguage() {
		return model.getLanguage();
	}

	/**
	 * Returns the layout friendly url of this search log.
	 *
	 * @return the layout friendly url of this search log
	 */
	@Override
	public String getLayoutFriendlyURL() {
		return model.getLayoutFriendlyURL();
	}

	/**
	 * Returns the layout ID of this search log.
	 *
	 * @return the layout ID of this search log
	 */
	@Override
	public Long getLayoutId() {
		return model.getLayoutId();
	}

	/**
	 * Returns the primary key of this search log.
	 *
	 * @return the primary key of this search log
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the result1 class ID of this search log.
	 *
	 * @return the result1 class ID of this search log
	 */
	@Override
	public long getResult1ClassId() {
		return model.getResult1ClassId();
	}

	/**
	 * Returns the result1 class pk of this search log.
	 *
	 * @return the result1 class pk of this search log
	 */
	@Override
	public long getResult1ClassPK() {
		return model.getResult1ClassPK();
	}

	/**
	 * Returns the result1 title of this search log.
	 *
	 * @return the result1 title of this search log
	 */
	@Override
	public String getResult1Title() {
		return model.getResult1Title();
	}

	/**
	 * Returns the result2 class ID of this search log.
	 *
	 * @return the result2 class ID of this search log
	 */
	@Override
	public long getResult2ClassId() {
		return model.getResult2ClassId();
	}

	/**
	 * Returns the result2 class pk of this search log.
	 *
	 * @return the result2 class pk of this search log
	 */
	@Override
	public long getResult2ClassPK() {
		return model.getResult2ClassPK();
	}

	/**
	 * Returns the result2 title of this search log.
	 *
	 * @return the result2 title of this search log
	 */
	@Override
	public String getResult2Title() {
		return model.getResult2Title();
	}

	/**
	 * Returns the result3 class ID of this search log.
	 *
	 * @return the result3 class ID of this search log
	 */
	@Override
	public long getResult3ClassId() {
		return model.getResult3ClassId();
	}

	/**
	 * Returns the result3 class pk of this search log.
	 *
	 * @return the result3 class pk of this search log
	 */
	@Override
	public long getResult3ClassPK() {
		return model.getResult3ClassPK();
	}

	/**
	 * Returns the result3 title of this search log.
	 *
	 * @return the result3 title of this search log
	 */
	@Override
	public String getResult3Title() {
		return model.getResult3Title();
	}

	/**
	 * Returns the result count of this search log.
	 *
	 * @return the result count of this search log
	 */
	@Override
	public long getResultCount() {
		return model.getResultCount();
	}

	/**
	 * Returns the search log ID of this search log.
	 *
	 * @return the search log ID of this search log
	 */
	@Override
	public long getSearchLogId() {
		return model.getSearchLogId();
	}

	/**
	 * Returns the search time of this search log.
	 *
	 * @return the search time of this search log
	 */
	@Override
	public long getSearchTime() {
		return model.getSearchTime();
	}

	/**
	 * Returns the user target class ID of this search log.
	 *
	 * @return the user target class ID of this search log
	 */
	@Override
	public long getUserTargetClassId() {
		return model.getUserTargetClassId();
	}

	/**
	 * Returns the user target class pk of this search log.
	 *
	 * @return the user target class pk of this search log
	 */
	@Override
	public long getUserTargetClassPK() {
		return model.getUserTargetClassPK();
	}

	/**
	 * Returns the user target title of this search log.
	 *
	 * @return the user target title of this search log
	 */
	@Override
	public String getUserTargetTitle() {
		return model.getUserTargetTitle();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the date of this search log.
	 *
	 * @param date the date of this search log
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the group ID of this search log.
	 *
	 * @param groupId the group ID of this search log
	 */
	@Override
	public void setGroupId(long groupId) {
		model.setGroupId(groupId);
	}

	/**
	 * Sets the keywords of this search log.
	 *
	 * @param keywords the keywords of this search log
	 */
	@Override
	public void setKeywords(String keywords) {
		model.setKeywords(keywords);
	}

	/**
	 * Sets the language of this search log.
	 *
	 * @param language the language of this search log
	 */
	@Override
	public void setLanguage(String language) {
		model.setLanguage(language);
	}

	/**
	 * Sets the layout friendly url of this search log.
	 *
	 * @param layoutFriendlyURL the layout friendly url of this search log
	 */
	@Override
	public void setLayoutFriendlyURL(String layoutFriendlyURL) {
		model.setLayoutFriendlyURL(layoutFriendlyURL);
	}

	/**
	 * Sets the layout ID of this search log.
	 *
	 * @param layoutId the layout ID of this search log
	 */
	@Override
	public void setLayoutId(Long layoutId) {
		model.setLayoutId(layoutId);
	}

	/**
	 * Sets the primary key of this search log.
	 *
	 * @param primaryKey the primary key of this search log
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the result1 class ID of this search log.
	 *
	 * @param result1ClassId the result1 class ID of this search log
	 */
	@Override
	public void setResult1ClassId(long result1ClassId) {
		model.setResult1ClassId(result1ClassId);
	}

	/**
	 * Sets the result1 class pk of this search log.
	 *
	 * @param result1ClassPK the result1 class pk of this search log
	 */
	@Override
	public void setResult1ClassPK(long result1ClassPK) {
		model.setResult1ClassPK(result1ClassPK);
	}

	/**
	 * Sets the result1 title of this search log.
	 *
	 * @param result1Title the result1 title of this search log
	 */
	@Override
	public void setResult1Title(String result1Title) {
		model.setResult1Title(result1Title);
	}

	/**
	 * Sets the result2 class ID of this search log.
	 *
	 * @param result2ClassId the result2 class ID of this search log
	 */
	@Override
	public void setResult2ClassId(long result2ClassId) {
		model.setResult2ClassId(result2ClassId);
	}

	/**
	 * Sets the result2 class pk of this search log.
	 *
	 * @param result2ClassPK the result2 class pk of this search log
	 */
	@Override
	public void setResult2ClassPK(long result2ClassPK) {
		model.setResult2ClassPK(result2ClassPK);
	}

	/**
	 * Sets the result2 title of this search log.
	 *
	 * @param result2Title the result2 title of this search log
	 */
	@Override
	public void setResult2Title(String result2Title) {
		model.setResult2Title(result2Title);
	}

	/**
	 * Sets the result3 class ID of this search log.
	 *
	 * @param result3ClassId the result3 class ID of this search log
	 */
	@Override
	public void setResult3ClassId(long result3ClassId) {
		model.setResult3ClassId(result3ClassId);
	}

	/**
	 * Sets the result3 class pk of this search log.
	 *
	 * @param result3ClassPK the result3 class pk of this search log
	 */
	@Override
	public void setResult3ClassPK(long result3ClassPK) {
		model.setResult3ClassPK(result3ClassPK);
	}

	/**
	 * Sets the result3 title of this search log.
	 *
	 * @param result3Title the result3 title of this search log
	 */
	@Override
	public void setResult3Title(String result3Title) {
		model.setResult3Title(result3Title);
	}

	/**
	 * Sets the result count of this search log.
	 *
	 * @param resultCount the result count of this search log
	 */
	@Override
	public void setResultCount(long resultCount) {
		model.setResultCount(resultCount);
	}

	/**
	 * Sets the search log ID of this search log.
	 *
	 * @param searchLogId the search log ID of this search log
	 */
	@Override
	public void setSearchLogId(long searchLogId) {
		model.setSearchLogId(searchLogId);
	}

	/**
	 * Sets the search time of this search log.
	 *
	 * @param searchTime the search time of this search log
	 */
	@Override
	public void setSearchTime(long searchTime) {
		model.setSearchTime(searchTime);
	}

	/**
	 * Sets the user target class ID of this search log.
	 *
	 * @param userTargetClassId the user target class ID of this search log
	 */
	@Override
	public void setUserTargetClassId(long userTargetClassId) {
		model.setUserTargetClassId(userTargetClassId);
	}

	/**
	 * Sets the user target class pk of this search log.
	 *
	 * @param userTargetClassPK the user target class pk of this search log
	 */
	@Override
	public void setUserTargetClassPK(long userTargetClassPK) {
		model.setUserTargetClassPK(userTargetClassPK);
	}

	/**
	 * Sets the user target title of this search log.
	 *
	 * @param userTargetTitle the user target title of this search log
	 */
	@Override
	public void setUserTargetTitle(String userTargetTitle) {
		model.setUserTargetTitle(userTargetTitle);
	}

	@Override
	public String toXmlString() {
		return model.toXmlString();
	}

	@Override
	protected SearchLogWrapper wrap(SearchLog searchLog) {
		return new SearchLogWrapper(searchLog);
	}

}