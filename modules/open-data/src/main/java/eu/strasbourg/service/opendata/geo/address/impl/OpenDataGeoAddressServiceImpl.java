package eu.strasbourg.service.opendata.geo.address.impl;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.opendata.geo.address.OpenDataGeoAddressService;
import eu.strasbourg.utils.JSONHelper;
import eu.strasbourg.utils.StrasbourgPropsUtil;
import org.osgi.service.component.annotations.Component;

/**
 * @author Angélique ZUNINO CHAMPOUGNY
 */
@Component(immediate = true, property = {}, service = OpenDataGeoAddressService.class)
public class OpenDataGeoAddressServiceImpl implements OpenDataGeoAddressService {

    private Log log = LogFactoryUtil.getLog(this.getClass());

    /**
     * Récupère l'URL du endPoint pour les adresses
     */
    private String getAddressesURL() {
        String openDataBaseURL = StrasbourgPropsUtil.getOpenDataBaseURL();
        String addressesURL = openDataBaseURL + StrasbourgPropsUtil.getOpenDataAddresses();

        return addressesURL;
    }

    /**
     * Récupère le json de la réponse de l'URL
     */
    private JSONArray getRecord(String url) throws Exception {
        return getRecord(url, StrasbourgPropsUtil.getWebServiceDefaultTimeout());
    }

    /**
     * Récupère le json de la réponse de l'URL
     */
    private JSONArray getRecord(String url, int timeOut) throws Exception {
        JSONObject response = JSONHelper.readJsonFromURL(url, timeOut);
        JSONArray records = response.getJSONArray("records");

        return records;
    }

    /**
     * Retourne les coordonnées d'une adresse en JSon
     */
    @Override
    public JSONArray getCoordinateForAddress(String address, String zipCode, String city) throws Exception {
        return getCoordinateForAddress(address, zipCode, city, StrasbourgPropsUtil.getWebServiceDefaultTimeout()) ;
    }

    /**
     * Retourne les coordonnées d'une adresse en JSon
     */
    @Override
    public JSONArray getCoordinateForAddress(String address, String zipCode, String city, int timeOut) throws Exception {
        JSONArray coordinates = JSONFactoryUtil.createJSONArray();
        if(Validator.isNotNull(address) && Validator.isNotNull(zipCode) && Validator.isNotNull(city)) {
            String url = getAddressesURL() + "&q=" + HtmlUtil.escapeURL(address) + "+and+code_postal=" + HtmlUtil.escapeURL(zipCode) + "+and+nom_commune=" + HtmlUtil.escapeURL(city);
            JSONArray records = getRecord(url, timeOut);
            if (records.length() > 0) {
                JSONObject fields = records.getJSONObject(0).getJSONObject("fields");
                coordinates = fields.getJSONArray("geo_pt");
            }
        }
        return coordinates;
    }

}