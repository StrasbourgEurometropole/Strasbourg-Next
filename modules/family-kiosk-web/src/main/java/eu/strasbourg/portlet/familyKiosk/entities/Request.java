package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Request {

    public String libelle;
    public LocalDate date;
    public String beneficiary;
    public String status;

    public Request(JSONObject json, String status) {
        libelle = json.getString("libelle");
        if(Validator.isNotNull(json.getString("date_demande")))
            date = LocalDate.parse(json.getString("date_demande"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        /* inutile pour le moment
        beneficiary = json.getString("beneficiaire");*/
        this.status = status;
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

    public String getStatus() {
        return status;
    }
}
