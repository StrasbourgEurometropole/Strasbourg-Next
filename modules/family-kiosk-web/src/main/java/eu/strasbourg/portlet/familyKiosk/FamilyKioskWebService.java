package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.io.IOException;
import java.net.HttpURLConnection;

public class FamilyKioskWebService {

	public static FamilyKioskResponse getResponse(String publikInternalId) {

		FamilyKioskResponse familyKioskResponse = null;
		try {
			// On récupère le JSON
			String url = StrasbourgPropsUtil.getFamilyKiosk() + publikInternalId;
			url = "https://wipesco.strasbourg.eu/kiosque/restapi/GetTableauBordFamille?codeappli=fghy-51&type_id=0&type_data=1&external_id=" + publikInternalId;
			HttpURLConnection httpConn = PasserelleHelper.readFromURL(url);
//			if(httpConn.getContentType().contains("application/json")) {
				JSONObject jsonResponse = PasserelleHelper.readJson(httpConn);
				familyKioskResponse = new FamilyKioskResponse(jsonResponse);
//			}
		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}

		return familyKioskResponse;
	}

}
