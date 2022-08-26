package eu.strasbourg.portlet.resid.dossier;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import eu.strasbourg.utils.PasserelleHelper;
import eu.strasbourg.utils.SearchHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;

import java.net.HttpURLConnection;

public class DossiersWebService {

	public static DossiersResponse getResponse(String identifiantOpenId) {
		return getResponse(identifiantOpenId, StrasbourgPropsUtil.getWebServiceDefaultTimeout());
	}

	public static DossiersResponse getResponse(String identifiantOpenId, int timeOut) {
		DossiersResponse dossiersResponse = null;
		try {
			// On récupère le JSON
			String url = StrasbourgPropsUtil.getResidantWebServiceURL() + identifiantOpenId;
			HttpURLConnection httpConn = PasserelleHelper.readFromURL(url, timeOut);
			if(httpConn.getContentType().contains("application/json")) {
				dossiersResponse = new DossiersResponse(PasserelleHelper.readJson(httpConn));
			}
		} catch (Exception ex) {
			_log.error("identifiantOpenId : " + identifiantOpenId + ", timeOut : " + timeOut, ex);
		}

		return dossiersResponse;
	}

	private static final Log _log = LogFactoryUtil.getLog(DossiersWebService.class.getName());

}
