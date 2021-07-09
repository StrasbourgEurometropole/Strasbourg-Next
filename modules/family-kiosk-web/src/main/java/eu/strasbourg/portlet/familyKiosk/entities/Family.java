package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Family {

    public String civility;
    public String firstName;
    public String lastName;
    public List<Adult> adults;
    public List<Child> children;

    public Family(JSONObject json) {
        /* inutile pour le moment
        civility = json.getString("civilite");
        firstName = json.getString("prenom");
        lastName = json.getString("nom");*/
        try {
            adults = new ArrayList<>();
            /* inutile pour le moment
            JSONArray jsonAdults = JSONFactoryUtil.createJSONArray(json.getString("liste_adultes"));
            for (Object adult : jsonAdults) {
                adults.add(new Adult((JSONObject) adult));
            }*/
            JSONArray jsonChildren = JSONFactoryUtil.createJSONArray(json.getString("liste_enfants"));
            children = new ArrayList<>();
            for (Object child : jsonChildren) {
                children.add(new Child((JSONObject) child));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Family() {
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

    public LocalDate getLastDateBookingByTypeActifAndYear(String type, int actif, int year) {
        LocalDate lastBookingDate = null;
        for (Child child : getChildren()) {
            Inscription inscription = child.getInscriptionsByTypeActifAndYear(type, actif, year).stream()
                    .sorted(Comparator.comparing(Inscription::getMaxDateBooking).reversed())
                    .findFirst().orElse(null);
            if(Validator.isNotNull(inscription)) {
                if (Validator.isNull(lastBookingDate))
                    lastBookingDate = inscription.getMaxDateBooking();
                else if(lastBookingDate.isAfter(inscription.getMaxDateBooking()))
                    lastBookingDate = inscription.getMaxDateBooking();
            }
        }
        return lastBookingDate;
    }

}
