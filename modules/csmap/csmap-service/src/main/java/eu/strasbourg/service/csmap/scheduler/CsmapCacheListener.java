package eu.strasbourg.service.csmap.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.csmap.constants.CodeCacheEnum;
import eu.strasbourg.service.csmap.service.CsmapCacheLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Passe au statut "APPROVED" tous les événements et les manifestations dont la
 * publication a été programmée et dont la date de publication est désormais
 * dépassée
 */
@Component(service = SchedulerJobConfiguration.class)
public class CsmapCacheListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 2 minutes"
		return TriggerConfiguration.createTriggerConfiguration(2, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			this.log.info("Start csmap agenda caching");
			_csmapCacheLocalService.generateCsmapCache(CodeCacheEnum.AGENDA.getId());
			this.log.info("End csmap agenda caching");
		};
	}

	@Reference(unbind = "-")
	protected void setCsmapCacheLocalService(CsmapCacheLocalService csmapCacheLocalService) {
		_csmapCacheLocalService = csmapCacheLocalService;
	}

	private CsmapCacheLocalService _csmapCacheLocalService;
	private final Log log = LogFactoryUtil.getLog(this.getClass());
}
