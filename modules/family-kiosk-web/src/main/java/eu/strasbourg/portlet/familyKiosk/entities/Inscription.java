package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Inscription {

    public String libelle;
    public String typact;
    public Boolean isActif;
    public Boolean isThisYear;
    public LocalDate startDateRegistration;
    public LocalDate endDateRegistration;
    public LocalDate minDateBooking;
    public LocalDate maxDateBooking;
    public List<Prestation> prestations;

    public Inscription(JSONObject json) {
        libelle = json.getString("libelle");
        typact = json.getString("typact");
        isActif = json.getBoolean("actif");
        isThisYear = json.getBoolean("anneecou");
        startDateRegistration = LocalDate.parse(json.getString("date_debut_inscription"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDateRegistration = LocalDate.parse(json.getString("date_fin_inscription"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        minDateBooking = LocalDate.parse(json.getString("date_min_reservation"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        maxDateBooking = LocalDate.parse(json.getString("date_max_reservation"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try {
            JSONArray jsonPrestations = JSONFactoryUtil.createJSONArray(json.getString("liste_prestations"));
            for (Object prestation : jsonPrestations) {
                prestations.add(new Prestation(JSONFactoryUtil.createJSONObject(prestation.toString())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Inscription() {
    }

    public String getLibelle() {
        return libelle;
    }

    public String getTypact() {
        return typact;
    }

    public Boolean getActif() {
        return isActif;
    }

    public Boolean getThisYear() {
        return isThisYear;
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

    public void setPrestations(List<Prestation> prestations) {
        this.prestations = prestations;
    }
}
