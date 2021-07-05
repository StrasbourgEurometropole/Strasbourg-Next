package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONObject;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import javax.portlet.PortletRequest;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

public class FamilyKioskWebService {

	public static FamilyKioskResponse getResponse(String publikInternalId, PortletRequest resourceRequest) {

		Map<String, Object> params = new LinkedHashMap<String, Object>();
		FamilyKioskResponse familyKioskResponse = null;
		try {
			// On récupère le JSON
			String url = StrasbourgPropsUtil.getFamilyKiosk() + publikInternalId;
			// url = "https://wipesco.strasbourg.eu/kiosque/restapi/GetTableauBordFamille?codeappli=KIOSQUE&type_id=0&type_data=1&external_id=";
			// url +=  "00e112a761d24a1ca57798e8867c97bc";
			HttpURLConnection httpConn = PasserelleHelper.readFromURL(url);
			//if(httpConn.getContentType().contains("application/json")) {
				JSONObject jsonResponse = PasserelleHelper.readJson(httpConn);
				familyKioskResponse = new FamilyKioskResponse(jsonResponse);
			//}
		} catch (IOException | JSONException ex) {
			ex.printStackTrace();
		}

		return familyKioskResponse;
	}

}
