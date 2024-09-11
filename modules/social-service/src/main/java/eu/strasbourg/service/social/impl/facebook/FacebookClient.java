package eu.strasbourg.service.social.impl.facebook;

import com.liferay.portal.kernel.cache.PortalCacheHelperUtil;
import com.liferay.portal.kernel.cache.PortalCacheManagerNames;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.service.social.SocialPost;
import eu.strasbourg.service.social.impl.SocialMedia;
import eu.strasbourg.utils.JSONHelper;

import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FacebookClient {

	private static Log log = LogFactoryUtil.getLog(FacebookClient.class);
	
	public static List<SocialPost> getFacebookPosts(String accessToken, int count) {

		Object timelineFromCache = PortalCacheHelperUtil
			.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache").get(accessToken);
		Object lastTimelineUpdate = PortalCacheHelperUtil
			.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache").get(accessToken + "_last_update");
		if (timelineFromCache != null && lastTimelineUpdate != null) {
			long now = new Date().getTime();
			long timeBeforeNextUpdate = 100
				- (now - ((Long) lastTimelineUpdate)) / 1000;
			if (timeBeforeNextUpdate > 0) {
				return (List<SocialPost>) timelineFromCache;
			}
		}
		
		Object[] stringData = { accessToken, count };
		String apiURL = "https://graph.facebook.com/v6.0/me/posts?access_token=%s&fields=id,message,created_time,full_picture,permalink_url&limit=%s";
		apiURL = String.format(apiURL, stringData);

		List<SocialPost> posts = new ArrayList<SocialPost>();
		try {
			JSONObject json = JSONHelper.readJsonFromURL(apiURL);

			JSONArray jsonPostList = json.getJSONArray("data");

			for (int i = 0; i < jsonPostList.length(); i++) {
				SocialPost post = new SocialPost();
				post.setSocialMedia(SocialMedia.FACEBOOK);
				
				JSONObject jsonPost = jsonPostList.getJSONObject(i);
				
				String content = jsonPost.getString("message");
				post.setContent(content);

				String imageURL = jsonPost.getString("full_picture");
				post.setImageURL(imageURL);

				String url = jsonPost.getString("permalink_url");
				post.setUrl(url);

				String formattedDate = jsonPost.getString("created_time");
				LocalDateTime dateTime = LocalDateTime.parse(formattedDate, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ"));
				Date date = Date.from(dateTime.atZone(ZoneId.systemDefault()).toInstant());
				post.setDate(date);

				posts.add(post);
			}
		} catch (JSONException | IOException e) {
			log.error(e.getMessage());
		}

		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache").remove(accessToken);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache")
			.remove(accessToken + "_last_update");
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache").put(accessToken,
			(Serializable) posts);
		PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM, "facebook_cache")
			.put(accessToken + "_last_update", new Date().getTime());


		return posts;
	}
}
