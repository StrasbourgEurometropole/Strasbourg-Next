package eu.strasbourg.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class FriendlycaptchaHelper {

	public static final String url = StrasbourgPropsUtil.getFriendlycaptchaURL();
	public static final String secret = StrasbourgPropsUtil.getFriendlycaptchaSecretKey();

	public static boolean verify(String friendlycaptchaResponse) {
		if (friendlycaptchaResponse == null || "".equals(friendlycaptchaResponse)) {
			return false;
		}

		try {
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			// Configuration de la connexion
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			con.setDoOutput(true);

			// Données à envoyer
			String params = "secret=" + URLEncoder.encode(secret, StandardCharsets.UTF_8) +
					"&solution=" + URLEncoder.encode(friendlycaptchaResponse, StandardCharsets.UTF_8);

			// Écriture des données dans la requête
			try (OutputStream os = con.getOutputStream()) {
				byte[] input = params.getBytes(StandardCharsets.UTF_8);
				os.write(input, 0, input.length);
			}

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

			return json.getBoolean("success");
		} catch (Exception e) {
			_log.error(e);
			return false;
		}
	}
	
	private static final Log _log = LogFactoryUtil.getLog(FriendlycaptchaHelper.class.getName());
}