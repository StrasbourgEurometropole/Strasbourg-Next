package eu.strasbourg.service.agenda.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.agenda.service.CampaignLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Exporte automatiquement les campagnes au format JSON et les place dans le dossier d'import.
 */
@Component(service = SchedulerJobConfiguration.class)
public class ExportCampaignsMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 1h25 ou 13h25"
		return TriggerConfiguration.createTriggerConfiguration("0 25 1,13 ? * * *");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			this.log.info("Start exporting campaigns");
			_campaignLocalService.exportCampaigns();
			this.log.info("Finish exporting campaigns");
		};
	}

	@Reference(unbind = "-")
	protected void setCampaignLocalService(CampaignLocalService campaignLocalService) {
		_campaignLocalService = campaignLocalService;
	}
	private CampaignLocalService _campaignLocalService;

	private final Log log = LogFactoryUtil.getLog(this.getClass());
}
