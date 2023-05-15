package eu.strasbourg.service.ejob.upgrade.v1_1_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;
import eu.strasbourg.service.ejob.model.Alert;
import eu.strasbourg.service.ejob.model.Offer;
import eu.strasbourg.service.ejob.service.AlertLocalServiceUtil;
import eu.strasbourg.service.ejob.service.OfferLocalServiceUtil;

import java.util.List;

public class UpgradeSchema extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {
        List<Alert> alerts = AlertLocalServiceUtil.getAlerts(-1,-1);
        for (Alert alert : alerts) {
            try{
                AlertLocalServiceUtil.removeAlert(alert.getAlertId());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        List<Offer> offers = OfferLocalServiceUtil.getOffers(-1,-1);
        for (Offer offer : offers) {
            try{
                OfferLocalServiceUtil.removeOffer(offer.getOfferId());
            }catch(Exception e){
                e.printStackTrace();
            }
        }

        String template = StringUtil.read(
                UpgradeSchema.class.getResourceAsStream("dependencies/update.sql"));
        runSQLTemplateString(template, false, false);
    }
}