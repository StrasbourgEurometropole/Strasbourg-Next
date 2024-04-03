package eu.strasbourg.service.gtfs.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import eu.strasbourg.service.gtfs.service.CacheAlertJSONLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;

/**
 * remettre à jour le JSON des caches actifs dont regeneratedDate <= aujourd’hui – 30j
 */
@Component(service = SchedulerJobConfiguration.class)
public class RegenerateJsonAlertMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 5 minutes"
		return TriggerConfiguration.createTriggerConfiguration(5, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start RegenerateJsonAlert");
			_cacheAlertJsonLocalService.updateJsonAlert();
			log.info("Finish RegenerateJsonAlert");
		};
	}

	@Reference(unbind = "-")
	protected void setCacheAlertJsonLocalService(CacheAlertJSONLocalService cacheAlertJsonLocalService) {

		_cacheAlertJsonLocalService = cacheAlertJsonLocalService;
	}
	private CacheAlertJSONLocalService _cacheAlertJsonLocalService;
	private Log log = LogFactoryUtil.getLog(this.getClass());
}
