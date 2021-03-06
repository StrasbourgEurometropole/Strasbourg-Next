package eu.strasbourg.service.poi;

import com.liferay.portal.kernel.json.JSONObject;

public interface PoiService {
	
	public JSONObject getPois(String idInterests, long groupId);

	public JSONObject getFavoritesPois(String userId, long groupId);
	
	public JSONObject getPois(String idInterests, String idCategories, String prefilters, long groupId, String typesContenu);

	public JSONObject getFavoritesPois(String userId, long groupId, String typesContenu);
	
	public JSONObject getPois(String idInterests, long groupId, String localeId);

	public JSONObject getPois(String idInterests, String idCategories, String prefilters, long groupId,
							  String classNames, String localeId);
	
	public JSONObject getFavoritesPois(String userId, long groupId, String classNames, String LocaleId);
	
	public int getPoisCategoryCount(long idCategory, String prefilters, long groupId, String classNames);

	public int getPoisInterestCount(long idInterest, long groupId, String classNames);

	public int getFavoritesPoisCount(String userId, long groupId, String classNames);

}
