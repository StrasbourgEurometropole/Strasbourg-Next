package eu.strasbourg.service.notification.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.notification.service.NotificationLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Publie toutes les notifications non publiées dont la date de publication a
 * été dépassée, dépublie ceux dont la date de dépublication a été dépassée et
 * supprime les plus anciennes
 */
@Component(service = SchedulerJobConfiguration.class)
public class CheckNotificationMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 5 minutes"
		return TriggerConfiguration.createTriggerConfiguration(5, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_notificationLocalService.publishRelevantNotifications();
			_notificationLocalService.unpublishPastNotifications();
			_notificationLocalService.deleteOldUnpublishedNotifications();
		};
	}

	@Reference(unbind = "-")
	protected void setNotificationLocalService(NotificationLocalService notificationLocalService) {
		_notificationLocalService = notificationLocalService;
	}
	private NotificationLocalService _notificationLocalService;

}
