package eu.strasbourg.service.agenda.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.*;
import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.service.agenda.service.ImportReportLocalService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;

/**
 * Importe automatiquement les événements et les manifestations des fichiers
 * JSON présents dans le dossier d'import.
 */
@Component(immediate = true, service = ImportEventsMessageListener.class)
public class ImportEventsMessageListener
	extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate() {
		log.info("Start import events scheduler activation");

		String listenerClass = getClass().getName();

		// Maintenant + 5 min pour ne pas lancer le scheduler au Startup du module
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 5);
		Date fiveMinutesFromNow = now.getTime();

		// Création du trigger "Tous les jours à 4h"
		Trigger trigger = _triggerFactory.createTrigger(
				listenerClass, listenerClass, fiveMinutesFromNow, null,
				"0 0 4 * * ?");

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
				listenerClass, trigger);

		_schedulerEngineHelper.register(
				this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);

		log.info("Finish import events scheduler activation");
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		log.info("Start importing events");
		// Import des événements =
		_eventLocalService.doImport();
		log.info("Finish importing events");
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

	@Reference(unbind = "-")
	protected void setSchedulerEngineHelper(
			SchedulerEngineHelper schedulerEngineHelper) {

		_schedulerEngineHelper = schedulerEngineHelper;
	}

	@Reference(unbind = "-")
	protected void setTriggerFactory(TriggerFactory triggerFactory) {
		_triggerFactory = triggerFactory;
	}

	private volatile SchedulerEngineHelper _schedulerEngineHelper;
	private EventLocalService _eventLocalService;
	private PlaceLocalService _placeLocalService;
	private ImportReportLocalService _importReportLocalService;
	private TriggerFactory _triggerFactory;

	private Log log = LogFactoryUtil.getLog(this.getClass());
}
