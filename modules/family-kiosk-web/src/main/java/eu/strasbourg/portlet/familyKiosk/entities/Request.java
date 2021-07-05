package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request {

    public String libelle;
    public LocalDate date;
    public String beneficiary;

    public Request(JSONObject json) {
        libelle = json.getString("libelle");
        date = LocalDate.parse(json.getString("date_demande"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        beneficiary = json.getString("beneficiaire");
    }

    public Request() {
    }

    public String getLibelle() {
        return libelle;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getBeneficiary() {
        return beneficiary;
    }
}
