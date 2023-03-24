package eu.strasbourg.portlet.twitter;

import com.liferay.portal.kernel.cache.PortalCacheHelperUtil;
import com.liferay.portal.kernel.cache.PortalCacheManagerNames;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TwitterUtil {

	private static String twitterConsumerKey;
	private static String twitterConsumerSecret;

	private static String twitterAccessToken;
	private static String twitterAccessTokenSecret;

	private static Twitter twitter;

	static {
		// Initialisation du wrapper de l'API Twitter
		twitterConsumerKey = StrasbourgPropsUtil.getTwitterConsumerKey();
		twitterConsumerSecret = StrasbourgPropsUtil.getTwitterConsumerSecret();
		twitterAccessToken = StrasbourgPropsUtil.getTwitterToken();
		twitterAccessTokenSecret = StrasbourgPropsUtil.getTwitterTokenSecret();
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setDebugEnabled(true).setOAuthConsumerKey(twitterConsumerKey)
			.setOAuthConsumerSecret(twitterConsumerSecret)
			.setOAuthAccessToken(twitterAccessToken)
			.setOAuthAccessTokenSecret(twitterAccessTokenSecret);
		TwitterFactory tf = new TwitterFactory(cb.build());
		twitter = tf.getInstance();
	}

	public static List<Tweet> getUserTimeline(String username, int count) {

		Object timelineFromCache = PortalCacheHelperUtil
				.getPortalCache(PortalCacheManagerNames.MULTI_VM,"twitter_cache").get(username);
		Object lastTimelineUpdate = PortalCacheHelperUtil
				.getPortalCache(PortalCacheManagerNames.MULTI_VM,"twitter_cache").get(username + "_last_update");
		if (timelineFromCache != null && lastTimelineUpdate != null) {
			long now = new Date().getTime();
			long timeBeforeNextUpdate = 100
				- (now - ((Long) lastTimelineUpdate)) / 1000;
			if (timeBeforeNextUpdate > 0) {
				return (List<Tweet>) timelineFromCache;
			}
		}

		List<Tweet> tweets = new ArrayList<Tweet>();
		try {
			List<Status> statusList = twitter.getUserTimeline(username);
			int i = 0;			
			for (Status status : statusList) {
				Tweet tweet = new Tweet();
				tweet.setCreationDate(status.getCreatedAt());
				tweet.setScreenName(status.getUser().getScreenName());
				tweet.setUserName(status.getUser().getName());
				tweet.setRetweet(status.getRetweetedStatus() != null);
				tweet.setUrl(
					"https://twitter.com/" + status.getUser().getScreenName()
						+ "/status/" + status.getId());
				if (tweet.isRetweet()) {
					tweet.setRetweetUserName(
						status.getRetweetedStatus().getUser().getName());
					tweet.setRetweetScreenName(
						status.getRetweetedStatus().getUser().getScreenName());
					tweet.setText(status.getRetweetedStatus().getText());
				} else {
					tweet.setText(status.getText());
				}
				tweets.add(tweet);
				i++;
				if (i >= count) {
					break;
				}
			}
			PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
					"twitter_cache").remove(username);
			PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
							"twitter_cache").remove(username + "_last_update");
			PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
					"twitter_cache").put(username,(Serializable) tweets);
			PortalCacheHelperUtil.getPortalCache(PortalCacheManagerNames.MULTI_VM,
							"twitter_cache").put(username + "_last_update", new Date().getTime());
			return tweets;
		} catch (TwitterException e) {
			e.printStackTrace();
			// Si on a du cache, on le renvoie
			if (timelineFromCache != null) {
				return (List<Tweet>) timelineFromCache;
			}
			return tweets;
		}
	}

}
