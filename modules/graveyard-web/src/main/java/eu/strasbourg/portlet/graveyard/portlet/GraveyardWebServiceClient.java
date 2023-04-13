package eu.strasbourg.portlet.graveyard.portlet;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class GraveyardWebServiceClient {

	public static GraveyardResponse getResponse(String name, String firstName, Date birthDateStart, Date birthDateEnd,
			Date deathDateStart, Date deathDateEnd, String deathPlace, String graveyard, String limit) {
		GraveyardResponse graveyardResponse = new GraveyardResponse();

		Map<String, Object> params = new LinkedHashMap<String, Object>();
		params.put("prenom", firstName);
		params.put("nom", name);
		params.put("limite", limit);
		if (Validator.isNotNull(deathDateStart)) {
			params.put("date_debut", new SimpleDateFormat("dd/MM/yyyy").format(deathDateStart));
		}
		if (Validator.isNotNull(deathDateEnd)) {
			params.put("date_fin", new SimpleDateFormat("dd/MM/yyyy").format(deathDateEnd));
		} 
		if (Validator.isNotNull(birthDateStart)) {
			params.put("date_naissance_debut", new SimpleDateFormat("dd/MM/yyyy").format(birthDateStart));
		} 
		if (Validator.isNotNull(birthDateEnd)) {
			params.put("date_naissance_fin", new SimpleDateFormat("dd/MM/yyyy").format(birthDateEnd));
		}
		params.put("cimetieres", graveyard);

		StringBuilder postData = new StringBuilder();
		try {
			for (Map.Entry<String, Object> param : params.entrySet()) {
				if (postData.length() != 0)
					postData.append('&');
				postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
				postData.append('=');
				postData.append(URLEncoder.encode(String.valueOf(param.getValue()), "UTF-8"));
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		try {
			// On récupère le JSON
			String url = StrasbourgPropsUtil.getGraveyardURL() + "?" + postData;
			JSONObject jsonResponse = PasserelleHelper.readJsonFromURL(url);
			graveyardResponse = new GraveyardResponse(jsonResponse);
		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}

		return graveyardResponse;
	}
}
