package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Requests {

    public LocalDate startDate;
    public LocalDate endDate;
    public List<Request> inProgress;
    public List<Request> accepted;
    public List<Request> refused;
    public List<Request> registered;
    public List<Request> toComplet;

    public Requests(JSONObject json) {
        startDate = LocalDate.parse(json.getString("debut"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        endDate = LocalDate.parse(json.getString("fin"),
                DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        try {
            JSONArray jsonRequestsInProgress = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_en_cours"));
            for (Object requestInProgress : jsonRequestsInProgress) {
                inProgress.add(new Request(JSONFactoryUtil.createJSONObject(requestInProgress.toString())));
            }
            JSONArray jsonRequestsAccepted = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_acceptee"));
            for (Object requestAccepted : jsonRequestsAccepted) {
                accepted.add(new Request(JSONFactoryUtil.createJSONObject(requestAccepted.toString())));
            }
            JSONArray jsonRequestsRefused = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_refusee"));
            for (Object requestRefused : jsonRequestsRefused) {
                refused.add(new Request(JSONFactoryUtil.createJSONObject(requestRefused.toString())));
            }
            JSONArray jsonRequestsRegistered = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_prise_compte" +
                    "_service"));
            for (Object requestRegistered : jsonRequestsRegistered) {
                registered.add(new Request(JSONFactoryUtil.createJSONObject(requestRegistered.toString())));
            }
            JSONArray jsonRequestsToComplet = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_a_completer"));
            for (Object requestToComplet : jsonRequestsToComplet) {
                toComplet.add(new Request(JSONFactoryUtil.createJSONObject(requestToComplet.toString())));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public Requests() {
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public List<Request> getInProgress() {
        return inProgress;
    }

    public List<Request> getAccepted() {
        return accepted;
    }

    public List<Request> getRefused() {
        return refused;
    }

    public List<Request> getRegistered() {
        return registered;
    }

    public List<Request> getToComplet() {
        return toComplet;
    }

    public void setToComplet(List<Request> toComplet) {
        this.toComplet = toComplet;
    }
}
