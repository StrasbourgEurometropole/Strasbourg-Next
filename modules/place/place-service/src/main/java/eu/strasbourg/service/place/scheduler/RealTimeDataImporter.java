package eu.strasbourg.service.place.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.opendata.realtime.parking.OpenDataRealTimeParkingService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.io.IOException;

/**
 * Met à jour le temps réel des lieux qui sont concernés
 */
@Component(service = SchedulerJobConfiguration.class)
public class RealTimeDataImporter
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 2 minutes"
		return TriggerConfiguration.createTriggerConfiguration(2, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			this.log.info("Start updating real time");
			JSONArray parkingJsonArray = JSONFactoryUtil.createJSONArray();
			try {
				parkingJsonArray = openDataRealTimeParkingService.getParkingJSON();
			} catch (IOException e) {
				// erreur avec url remontée directement dans eu.strasbourg.utils.JSONHelper.readJsonFromURL
			}
			_placeLocalService.updateRealTime(parkingJsonArray);
			this.log.info("End updating real time");
		};
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
	}

	@Reference(unbind = "-")
	public void setOpenDataRealTimeParkingService(OpenDataRealTimeParkingService openDataRealTimeParkingService) {
		this.openDataRealTimeParkingService = openDataRealTimeParkingService;
	}

	private OpenDataRealTimeParkingService openDataRealTimeParkingService;
	private PlaceLocalService _placeLocalService;
	private final Log log = LogFactoryUtil.getLog(this.getClass());

}
