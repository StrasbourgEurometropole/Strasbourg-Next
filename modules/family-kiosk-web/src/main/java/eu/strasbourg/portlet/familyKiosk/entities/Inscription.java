package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Inscription {

    public String libelle;
    public String typact;
    public int actif;
    public int thisYear;
    public LocalDate startDateRegistration;
    public LocalDate endDateRegistration;
    public LocalDate minDateBooking;
    public LocalDate maxDateBooking;
    public List<Prestation> prestations;

    public Inscription(JSONObject json) {
        /*inutile pour le moment
        libelle = json.getString("libelle");*/
        typact = json.getString("typact");
        actif = json.getInt("actif");
        thisYear = json.getInt("anneecou");
        /*inutile pour le moment
        if(Validator.isNotNull(json.getString("date_debut_inscription")))
            startDateRegistration = LocalDate.parse(json.getString("date_debut_inscription"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("date_fin_inscription")))
            endDateRegistration = LocalDate.parse(json.getString("date_fin_inscription"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));*/
        if(Validator.isNotNull(json.getString("date_min_reservation")))
            minDateBooking = LocalDate.parse(json.getString("date_min_reservation"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("date_max_reservation")))
            maxDateBooking = LocalDate.parse(json.getString("date_max_reservation"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        /*inutile pour le moment
        try {
            JSONArray jsonPrestations = JSONFactoryUtil.createJSONArray(json.getString("liste_prestations"));
            prestations = new ArrayList<>();
            for (Object prestation : jsonPrestations) {
                prestations.add(new Prestation(JSONFactoryUtil.createJSONObject(prestation.toString())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    public Inscription() {
    }

    public String getLibelle() {
        return libelle;
    }

    public String getTypact() {
        return typact;
    }

    public int getActif() {
        return actif;
    }

    public int getThisYear() {
        return thisYear;
    }

    public LocalDate getStartDateRegistration() {
        return startDateRegistration;
    }

    public LocalDate getEndDateRegistration() {
        return endDateRegistration;
    }

    public LocalDate getMinDateBooking() {
        return minDateBooking;
    }

    public LocalDate getMaxDateBooking() {
        return maxDateBooking;
    }

    public List<Prestation> getPrestations() {
        return prestations;
    }

}
