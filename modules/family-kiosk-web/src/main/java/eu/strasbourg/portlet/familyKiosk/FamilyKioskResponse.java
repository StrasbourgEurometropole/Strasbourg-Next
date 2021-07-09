package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.familyKiosk.entities.Family;
import eu.strasbourg.portlet.familyKiosk.entities.Finance;
import eu.strasbourg.portlet.familyKiosk.entities.Requests;

public class FamilyKioskResponse {

	public int codeRetour;
	public String erreurDescription;
	public Family family;
	public Requests requests;
	public Finance finance;

	public FamilyKioskResponse(JSONObject json) {
		codeRetour = json.getInt("erreur");
		erreurDescription = json.getString("detail_erreur");
		if (codeRetour == 0) {
			try {
				if(Validator.isNotNull(json.getString("famille")))
					family = new Family(JSONFactoryUtil.createJSONObject(json.getString("famille")));
				if(Validator.isNotNull(json.getString("demandes")))
					requests = new Requests(JSONFactoryUtil.createJSONObject(json.getString("demandes")));
				if(Validator.isNotNull(json.getString("finances")))
					finance = new Finance(JSONFactoryUtil.createJSONObject(json.getString("finances")));
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}
	public FamilyKioskResponse() {
	}

	public int getCodeRetour() {
		return codeRetour;
	}

	public void setCodeRetour(int codeRetour) {
		this.codeRetour = codeRetour;
	}

	public String getErreurDescription() {
		return erreurDescription;
	}

	public void setErreurDescription(String erreurDescription) {
		this.erreurDescription = erreurDescription;
	}

	public Family getFamily() {
		return family;
	}

	public Requests getRequests() {
		return requests;
	}

	public Finance getFinance() {
		return finance;
	}

}
