package eu.strasbourg.external.video.provider;


import com.liferay.document.library.video.external.shortcut.DLVideoExternalShortcut;
import com.liferay.document.library.video.external.shortcut.provider.DLVideoExternalShortcutProvider;
import com.liferay.portal.json.JSONFactoryImpl;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringBundler;
import eu.strasbourg.utils.JSONHelper;
import org.osgi.service.component.annotations.Component;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.SecureRandom;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author thomas.tse
 */
@Component(service = DLVideoExternalShortcutProvider.class)
public class DailymotionDLVideoExternalShortcutProvider implements DLVideoExternalShortcutProvider  {


	private JSONObject getVideoMetadata(String videoId) {
// Get the response and parse it to JSON
		try {
			JSONObject json = JSONHelper.readJsonFromURL("https://www.dailymotion.com/player/metadata/video/" + videoId);
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return new JSONFactoryImpl().createJSONObject();
		}
	}

	private String getVideoTranscript(String subtitleUrl) {
		if(subtitleUrl == null || subtitleUrl.isEmpty()){
			return "";
		}
		try {
			// httpClient
			HttpClient client = HttpClient.newBuilder().build();
			// request
			HttpRequest request = HttpRequest.newBuilder()
					.uri(URI.create(subtitleUrl))
					.build();
			// send request and parse as text
			String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
			// String is in srt format, keep only the subtitle without timestamp
			response = response.replaceAll("\\d+\\n\\d+:\\d+:\\d+,\\d+ --> \\d+:\\d+:\\d+,\\d+\\n", "");
			return response;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

	}

	@Override
	public DLVideoExternalShortcut getDLVideoExternalShortcut(String url) {
		Matcher matcher = _pattern.matcher(url);

		if (!matcher.matches()) {
			return null;
		}

		JSONObject videoMetadata = getVideoMetadata(matcher.group(1));
		String title = videoMetadata.getString("title");
		String thumbnailURL = videoMetadata.getJSONObject("posters").getString("1080");
		String subtitleUrl = "";
		if(videoMetadata.getJSONObject("subtitles").getJSONObject("data") != null){
			subtitleUrl = videoMetadata.getJSONObject("subtitles").getJSONObject("data").getJSONObject("fr-auto").getJSONArray("urls").getString(0);
		}

		String transcript = getVideoTranscript(subtitleUrl);




		return new DLVideoExternalShortcut() {

			@Override
			public String getThumbnailURL() {
				return thumbnailURL;
			}

			@Override
			public String getTitle() {
				return title;
			}

			@Override
			public String getURL() {
				return url;
			}

			@Override
			public String getDescription() {
				return transcript;
			}


			@Override
			public String renderHTML(HttpServletRequest httpServletRequest) {
				String iframeSrc =
						"https://www.dailymotion.com/embed/video/" +
								matcher.group(1) + "?rel=0&autoplay=0";

				return StringBundler.concat(
						"<iframe data-thumbnail=\"", this.getThumbnailURL() , "\" allow=\"autoplay; encrypted-media\" ",
						"allowfullscreen frameborder=\"0\" ",
						"src=\"", iframeSrc, "\"></iframe>");
			}

		};
	}

	// pattern using dai.ly or dailymotion.com
	private static final Pattern _pattern = Pattern.compile(
			"https?:\\/\\/(?:www\\.)?(?:dai\\.ly\\/|dailymotion\\.com\\/video\\/)([a-zA-Z0-9]+)"
	);

}