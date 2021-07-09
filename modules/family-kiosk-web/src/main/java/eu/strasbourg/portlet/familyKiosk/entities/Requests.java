package eu.strasbourg.portlet.familyKiosk.entities;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import eu.strasbourg.portlet.familyKiosk.constants.Constants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Requests {

    public LocalDate startDate;
    public LocalDate endDate;
    public List<Request> allRequest;

    public Requests(JSONObject json) {
        /* inutile pour le moment
        if(Validator.isNotNull(json.getString("debut")))
            startDate = LocalDate.parse(json.getString("debut"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        if(Validator.isNotNull(json.getString("fin")))
            endDate = LocalDate.parse(json.getString("fin"),
                DateTimeFormatter.ofPattern("dd/MM/yyyy"));*/
        try {
            allRequest = new ArrayList<>();
            JSONArray jsonRequestsInProgress = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_en_cours"));
            for (Object requestInProgress : jsonRequestsInProgress) {
                allRequest.add(new Request(JSONFactoryUtil.createJSONObject(requestInProgress.toString()), Constants.IN_PROGRESS));
            }
            JSONArray jsonRequestsAccepted = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_acceptee"));
            for (Object requestAccepted : jsonRequestsAccepted) {
                allRequest.add(new Request(JSONFactoryUtil.createJSONObject(requestAccepted.toString()), Constants.ACCEPTED));
            }
            JSONArray jsonRequestsRefused = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_refusee"));
            for (Object requestRefused : jsonRequestsRefused) {
                allRequest.add(new Request(JSONFactoryUtil.createJSONObject(requestRefused.toString()), Constants.REFUSED));
            }
            JSONArray jsonRequestsRegistered = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_prise_compte" +
                    "_service"));
            for (Object requestRegistered : jsonRequestsRegistered) {
                allRequest.add(new Request(JSONFactoryUtil.createJSONObject(requestRegistered.toString()), Constants.REGISTERED));
            }
            JSONArray jsonRequestsToComplet = JSONFactoryUtil.createJSONArray(json.getString("liste_demande_a_completer"));
            for (Object requestToComplet : jsonRequestsToComplet) {
                allRequest.add(new Request(JSONFactoryUtil.createJSONObject(requestToComplet.toString()), Constants.TO_COMPLET));
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

    public List<Request> getXRequests() {
        return allRequest;
    }

    public List<Request> getXRequests(int nb) {
        return allRequest.stream()
            .filter(r -> r.getDate().isAfter(LocalDate.now().minusDays(31)))
            .sorted(Comparator.comparing(Request::getDate))
            .limit(nb)
            .collect(Collectors.toList());
    }

}
