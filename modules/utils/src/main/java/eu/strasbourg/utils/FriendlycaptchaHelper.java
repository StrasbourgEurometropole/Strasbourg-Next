package eu.strasbourg.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class FriendlycaptchaHelper {

	public static final String url = StrasbourgPropsUtil.getFriendlycaptchaURL();
	public static final String secret = StrasbourgPropsUtil.getFriendlycaptchaSecretKey();
	private final static String USER_AGENT = "Mozilla/5.0";

	public static boolean verify(String friendlycaptchaResponse) {
		if (friendlycaptchaResponse == null || "".equals(friendlycaptchaResponse)) {
			_log.warn("friendlyCaptchaResponse is null or empty");
			return false;
		}

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", USER_AGENT);
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
			String postParams = "secret=" + secret + "&solution="
				+ friendlycaptchaResponse;

			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(postParams);
			wr.flush();
			wr.close();

			BufferedReader in = new BufferedReader(
				new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONObject json = JSONFactoryUtil
				.createJSONObject(response.toString());

			_log.info("Boolean response : " +json.getBoolean("success"));
			_log.info("response : " +json);

			return json.getBoolean("success");
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(FriendlycaptchaHelper.class.getName());
}