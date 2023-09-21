package eu.strasbourg.service.council.upgrade.v1_2_0;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.StringUtil;

public class UpgradeSchema extends UpgradeProcess {

    @Override
    protected void doUpgrade() throws Exception {
        String template = StringUtil.read(
                UpgradeSchema.class.getResourceAsStream("dependencies/update.sql"));
        runSQLTemplateString(template, false, false);
    }
}