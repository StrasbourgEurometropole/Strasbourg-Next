package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Child {

    public String firstName;
    public String lastName;
    public LocalDate birth;
    public String sex;
    public List<Inscription> inscriptions;

    public Child(JSONObject json) {
        firstName = json.getString("prenom");
        lastName = json.getString("nom");
        /* inutile pour le moment
        if(Validator.isNotNull(json.getString("date_naissance")))
            birth = LocalDate.parse(json.getString("date_naissance"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        sex = json.getString("sexe");*/
        try {
            JSONArray jsonInscriptions = JSONFactoryUtil.createJSONArray(json.getString("liste_inscriptions"));
            inscriptions = new ArrayList<>();
            for (Object inscription : jsonInscriptions) {
                inscriptions.add(new Inscription(JSONFactoryUtil.createJSONObject(inscription.toString())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Child() {
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

    public List<Inscription> getAllInscriptions() {
        return inscriptions;
    }

    public List<Inscription> getInscriptionsByTypeActifAndYear(String type, int actif, int year) {
        return inscriptions.stream()
                .filter(i -> i.getTypact().equals(type) && i.getActif() == actif && i.getThisYear() == year)
                .sorted(Comparator.comparing(Inscription::getMaxDateBooking))
                .collect(Collectors.toList());
    }
}
