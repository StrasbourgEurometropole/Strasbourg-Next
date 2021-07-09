package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Adult {

    public String civility;
    public String firstName;
    public String lastName;
    public LocalDate birth;
    public String sex;

    public Adult(JSONObject json) {
        civility = json.getString("civilite");
        firstName = json.getString("prenom");
        lastName = json.getString("nom");
        if(Validator.isNotNull(json.getString("date_naissance")))
            birth = LocalDate.parse(json.getString("date_naissance"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        sex = json.getString("sexe");
    }

    public Adult() {
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

    public LocalDate getBirth() {
        return birth;
    }

    public String getSex() {
        return sex;
    }
}
