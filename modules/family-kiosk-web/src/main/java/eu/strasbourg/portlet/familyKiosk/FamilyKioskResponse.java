package eu.strasbourg.portlet.familyKiosk;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import eu.strasbourg.portlet.familyKiosk.entities.Family;
import eu.strasbourg.portlet.familyKiosk.entities.Finance;
import eu.strasbourg.portlet.familyKiosk.entities.Requests;

import java.util.ArrayList;
import java.util.List;

public class FamilyKioskResponse {

	public int codeRetour;
	public String erreurDescription;
	public Family family;
	public List<Requests> requests;
	public List<Finance> finances;

	public FamilyKioskResponse(JSONObject json) {
		codeRetour = json.getInt("erreur");
		erreurDescription = json.getString("detail_erreur");
		requests = new ArrayList<>();
		finances = new ArrayList<>();
		if (codeRetour == 0) {
			try {
				family = new Family(JSONFactoryUtil.createJSONObject(json.getString("famille")));
				JSONArray jsonRequests = JSONFactoryUtil.createJSONArray(json.getString("demandes"));
				for (Object request : jsonRequests) {
					requests.add(new Requests(JSONFactoryUtil.createJSONObject(request.toString())));
				}
				JSONArray jsonFinances = JSONFactoryUtil.createJSONArray(json.getString("finances"));
				for (Object finance : jsonFinances) {
					finances.add(new Finance(JSONFactoryUtil.createJSONObject(finance.toString())));
				}
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

	public void setFamily(Family family) {
		this.family = family;
	}

	public List<Requests> getRequests() {
		return requests;
	}

	public void setRequests(List<Requests> requests) {
		this.requests = requests;
	}

	public List<Finance> getFinances() {
		return finances;
	}

	public void setFinances(List<Finance> finances) {
		this.finances = finances;
	}
}
