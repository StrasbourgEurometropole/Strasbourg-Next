package eu.strasbourg.service.agenda.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.agenda.service.CsmapCacheJsonLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * remettre à jour le JSON des caches actifs dont regeneratedDate <= aujourd’hui – 30j
 */
@Component(service = SchedulerJobConfiguration.class)
public class RegenerateJsonEventMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 4h30"
		return TriggerConfiguration.createTriggerConfiguration("0 30 4 * * ?");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start updateJsonEvent");
			_csmapCacheJsonLocalService.updateJsonEvent();
			log.info("Finish updateJsonEvent");
		};
	}

	@Reference(unbind = "-")
	protected void setCsmapCacheJsonLocalService(CsmapCacheJsonLocalService csmapCacheJsonLocalService) {

		_csmapCacheJsonLocalService = csmapCacheJsonLocalService;
	}
	private CsmapCacheJsonLocalService _csmapCacheJsonLocalService;
	private Log log = LogFactoryUtil.getLog(this.getClass());
}
