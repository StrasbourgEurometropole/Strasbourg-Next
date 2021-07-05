package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

public class Family {

    public String idFamily;
    public String civility;
    public String firstName;
    public String lastName;
    public List<Adult> adults;
    public List<Child> children;

    public Family(JSONObject json) {
        idFamily = json.getString("identifiantFamille");
        civility = json.getString("civilite");
        firstName = json.getString("prenom");
        lastName = json.getString("nom");
        try {
            JSONArray jsonAdults = JSONFactoryUtil.createJSONArray(json.getString("liste_adultes"));
            for (Object adult : jsonAdults) {
                adults.add(new Adult(JSONFactoryUtil.createJSONObject(adult.toString())));
            }
            JSONArray jsonChildren = JSONFactoryUtil.createJSONArray(json.getString("liste_enfants"));
            for (Object child : jsonChildren) {
                children.add(new Child(JSONFactoryUtil.createJSONObject(child.toString())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Family() {
    }

    public String getIdFamily() {
        return idFamily;
    }

    public String getCivility() {
        return civility;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public List<Adult> getAdults() {
        return adults;
    }

    public List<Child> getChildren() {
        return children;
    }
}
