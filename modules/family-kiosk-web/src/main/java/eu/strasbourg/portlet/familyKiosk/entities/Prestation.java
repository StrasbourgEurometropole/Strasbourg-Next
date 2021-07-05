package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestation {

    public String libelle;
    public Boolean isActif;
    public Boolean isThisYear;
    public LocalDate startDateRegistration;
    public LocalDate endDateRegistration;
    public LocalDate minDateBooking;
    public LocalDate maxDateBooking;

    public Prestation(JSONObject json) {
        libelle = json.getString("libelle");
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
    }

    public Prestation() {
    }

    public String getLibelle() {
        return libelle;
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
}
