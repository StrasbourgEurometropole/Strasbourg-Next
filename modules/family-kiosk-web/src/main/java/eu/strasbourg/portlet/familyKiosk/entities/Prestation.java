package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestation {

    public String libelle;
    public int actif;
    public int thisYear;
    public LocalDate startDateRegistration;
    public LocalDate endDateRegistration;
    public LocalDate minDateBooking;
    public LocalDate maxDateBooking;

    public Prestation(JSONObject json) {
        libelle = json.getString("libelle");
        actif = json.getInt("actif");
        thisYear = json.getInt("anneecou");
        if(Validator.isNotNull(json.getString("date_debut_inscription")))
            startDateRegistration = LocalDate.parse(json.getString("date_debut_inscription"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("date_fin_inscription")))
            endDateRegistration = LocalDate.parse(json.getString("date_fin_inscription"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("date_min_reservation")))
            minDateBooking = LocalDate.parse(json.getString("date_min_reservation"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("date_max_reservation")))
            maxDateBooking = LocalDate.parse(json.getString("date_max_reservation"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Prestation() {
    }

    public String getLibelle() {
        return libelle;
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
}
