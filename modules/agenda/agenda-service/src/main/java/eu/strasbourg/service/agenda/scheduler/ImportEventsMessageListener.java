package eu.strasbourg.service.agenda.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.service.agenda.service.ImportReportLocalService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Importe automatiquement les événements et les manifestations des fichiers
 * JSON présents dans le dossier d'import.
 */
@Component(service = SchedulerJobConfiguration.class)
public class ImportEventsMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 1h30 ou 13h30"
		return TriggerConfiguration.createTriggerConfiguration("0 30 1,13 ? * * *");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start importing events");
			// Import des événements =
			_eventLocalService.doImport();
			log.info("Finish importing events");
		};
	}

	@Reference(unbind = "-")
	protected void setEventLocalService(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
	}

	@Reference(unbind = "-")
	protected void setImportReportLocalService(ImportReportLocalService importReportLocalService) {
		_importReportLocalService = importReportLocalService;
	}

	private volatile SchedulerEngineHelper _schedulerEngineHelper;
	private EventLocalService _eventLocalService;
	private PlaceLocalService _placeLocalService;
	private ImportReportLocalService _importReportLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
