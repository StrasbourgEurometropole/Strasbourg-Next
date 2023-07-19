package eu.strasbourg.service.notif.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.notif.service.NotificationLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Exporte automatiquement les campagnes au format JSON et les place dans le dossier d'import.
 */
@Component(service = SchedulerJobConfiguration.class)
public class SendNotificationMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 5 minutes"
		return TriggerConfiguration.createTriggerConfiguration(5, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			this.log.info("Start sending notifications");
			_notificationLocalService.sendNotifications();
			this.log.info("Finish sending notifications");
		};
	}

	@Reference(unbind = "-")
	protected void setNotificationLocalService(NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}
	private NotificationLocalService _notificationLocalService;
	private final Log log = LogFactoryUtil.getLog(this.getClass());
}
