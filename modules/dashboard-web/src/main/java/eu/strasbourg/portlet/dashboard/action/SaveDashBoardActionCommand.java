package eu.strasbourg.portlet.dashboard.action;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.portlet.dashboard.utils.DashBoardUtils;
import eu.strasbourg.service.oidc.model.PublikUser;
import eu.strasbourg.service.oidc.service.PublikUserLocalServiceUtil;
import eu.strasbourg.utils.PublikApiClient;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static eu.strasbourg.portlet.dashboard.portlet.DashboardPortlet.REDIRECT_URL_PARAM;

/**
 * @author alexandre.quere
 */

@Component(
        immediate = true,
        property = {
                "javax.portlet.name=" + StrasbourgPortletKeys.DASHBOARD_WEB,
                "mvc.command.name=saveProfil"
        },
        service = MVCActionCommand.class
)
public class SaveDashBoardActionCommand implements MVCActionCommand {

    private static final String BIRTHDAY = "birthday";
    private static final String ADDRESS = "address";
    private static final String CITY = "city";
    private static final String POSTALCODE = "postalcode";
    private static final String PHONE = "phone";
    private static final String MOBILE = "mobile";
    private static final String EMAIL = "mail";
    private static final String USERNAME = "username";
    private static final String FIRSTNAME = "firstname";
    private static final String PATTERN = "dd/MM/yyyy";
    private static final String ENTROUVERT_PATTERN = "yyyy-MM-dd";
    private static final String IS_DISPLAY_LISTING = "displayListing";

    private PublikUser user;
    private Date birthday;
    private String address;
    private String city;
    private long postalcode;
    private String phone;
    private String mobile;
    private String lastname;
    private String firstname;
    private String email;
    private DateFormat dateFormat;
    private Boolean isDisplayListing;

    /**
     * le log
     */
    private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

    @Override
    public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
        String action = ParamUtil.getString(request, "cmd");
        // Recuperation de l'URL de redirection
        String redirectURL = ParamUtil.getString(request, REDIRECT_URL_PARAM);
        String publikID = DashBoardUtils.getPublikID(request);
        boolean result = false;
        if ("saveProfil".equals(action)) {
            if (publikID == null || publikID.isEmpty())
                throw new PortletException("veuillez vous identifier/enregistrer");
            this.dateFormat = new SimpleDateFormat(PATTERN);
            user = PublikUserLocalServiceUtil.getByPublikUserId(publikID);
            birthday = ParamUtil.getDate(request, BIRTHDAY, dateFormat);
            address = ParamUtil.getString(request, ADDRESS);
            city = ParamUtil.getString(request, CITY);
            postalcode = ParamUtil.getLong(request, POSTALCODE);
            phone = ParamUtil.getString(request, PHONE);
            mobile = ParamUtil.getString(request, MOBILE);
            lastname = ParamUtil.getString(request, USERNAME);
            firstname = ParamUtil.getString(request, FIRSTNAME);
            email = ParamUtil.getString(request, EMAIL);
            isDisplayListing = ParamUtil.getBoolean(request, IS_DISPLAY_LISTING);

            // Enregistrement du displayListing en base
            PublikUser publikUser = PublikUserLocalServiceUtil.getByPublikUserId(publikID);
            if (publikUser != null) {
                publikUser.setPactDisplay(isDisplayListing);
                PublikUserLocalServiceUtil.updatePublikUser(publikUser);
            }

            boolean isValid = validate(request);
            if (!isValid)
                throw new PortletException("la validation des champs n'est pas pass&eacute;e");

            SimpleDateFormat sdf = new SimpleDateFormat(ENTROUVERT_PATTERN);
            String dateNaiss = sdf.format(birthday);
            PublikApiClient.setAllUserDetails(publikID, user.getLastName(), address, "" + postalcode, city, dateNaiss, phone, mobile);
            try {
                response.sendRedirect(redirectURL);
            } catch (IOException e) {
                _log.error("erreur de redirection dans save profil : ", e);
                throw new PortletException(e);
            }

        }
        return result;
    }

    /**
     * méthode de validation des champs.
     *
     * @param request la request
     * @return la réponse.
     */
    private boolean validate(ActionRequest request) {
        boolean isValid = true;

        // birthday
        if (Validator.isNull(birthday)) {
            SessionErrors.add(request, "birthday-error");
            isValid = false;
        }

        // city
        if (Validator.isNull(city)) {
            SessionErrors.add(request, "city-error");
            isValid = false;
        }

        // address
        if (Validator.isNull(address)) {
            SessionErrors.add(request, "address-error");
            isValid = false;
        }

        // postalcode
        if (Validator.isNull(postalcode)) {
            SessionErrors.add(request, "postalcode-error");
            isValid = false;
        }

        return isValid;
    }

}
