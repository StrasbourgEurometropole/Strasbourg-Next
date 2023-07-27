package eu.strasbourg.service.agenda.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.service.agenda.service.ManifestationLocalService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Passe au statut "APPROVED" tous les événements et les manifestations dont la
 * publication a été programmée et dont la date de publication est désormais
 * dépassée
 */
@Component(service = SchedulerJobConfiguration.class)
public class CheckEventMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 15 minutes"
		return TriggerConfiguration.createTriggerConfiguration(15, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_eventLocalService.checkEvents();
			_eventLocalService.unpublishPastEvents();
			_eventLocalService.deleteOldUnpublishedEvents();
			_manifestationLocalService.checkManifestations();
			_manifestationLocalService.unpublishPastManifestations();
			_manifestationLocalService.deleteOldUnpublishedManifestations();
		};
	}

	@Reference(unbind = "-")
	protected void setEventLocalService(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	@Reference(unbind = "-")
	protected void setEventManifestationLocalService(
		ManifestationLocalService manifestationLocalService) {
		_manifestationLocalService = manifestationLocalService;
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
	}

	private EventLocalService _eventLocalService;
	private ManifestationLocalService _manifestationLocalService;
	private PlaceLocalService _placeLocalService;

}
