package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Validator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Finance {

    public String type;
    public long nb;
    public double total;
    public LocalDate lastReturnDate;

    public Finance(JSONObject json) {
        /* inutile pour le moment
        type = json.getString("type_impaye");*/
        nb = json.getLong("nb_impaye");
        total = json.getDouble("total_impaye");
        if(Validator.isNotNull(json.getString("date_dernier_retour_pes")))
            lastReturnDate = LocalDate.parse(json.getString("date_dernier_retour_pes"),
                    DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public Finance() {
    }

    public String getType() {
        return type;
    }

    public long getNb() {
        return nb;
    }

    public double getTotal() {
        return total;
    }

    public LocalDate getLastReturnDate() {
        return lastReturnDate;
    }
}
