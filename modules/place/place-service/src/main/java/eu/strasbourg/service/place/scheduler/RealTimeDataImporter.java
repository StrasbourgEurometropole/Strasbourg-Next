package eu.strasbourg.service.place.scheduler;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import eu.strasbourg.service.opendata.realtime.parking.OpenDataRealTimeParkingService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Met à jour le temps réel des lieux qui sont concernés
 */
@Component(immediate = true, service = RealTimeDataImporter.class)
public class RealTimeDataImporter extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate() {
		String listenerClass = getClass().getName();

		// Maintenant + 5 min pour ne pas lancer le scheduler au Startup du module
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 5);
		Date fiveMinutesFromNow = now.getTime();

		// Création du trigger "Toutes les 2 minutes"
		Trigger trigger = _triggerFactory.createTrigger(
				listenerClass, listenerClass, fiveMinutesFromNow, null,
				2, TimeUnit.MINUTE);

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(
				listenerClass, trigger);

		_schedulerEngineHelper.register(
				this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_schedulerEngineHelper.unregister(this);
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		this.log.info("Start updating real time");
		JSONArray parkingJsonArray = JSONFactoryUtil.createJSONArray();
		try {
			parkingJsonArray = openDataRealTimeParkingService.getParkingJSON();
		}catch (IOException e){
			// erreur avec url remontée directement dans eu.strasbourg.utils.JSONHelper.readJsonFromURL
		}
	    _placeLocalService.updateRealTime(parkingJsonArray);
		this.log.info("End updating real time");
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
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

	@Reference(unbind = "-")
	public void setOpenDataRealTimeParkingService(OpenDataRealTimeParkingService openDataRealTimeParkingService) {
		this.openDataRealTimeParkingService = openDataRealTimeParkingService;
	}

	private OpenDataRealTimeParkingService openDataRealTimeParkingService;
	private volatile SchedulerEngineHelper _schedulerEngineHelper;
	private PlaceLocalService _placeLocalService;
	private TriggerFactory _triggerFactory;
	private final Log log = LogFactoryUtil.getLog(this.getClass());

}
