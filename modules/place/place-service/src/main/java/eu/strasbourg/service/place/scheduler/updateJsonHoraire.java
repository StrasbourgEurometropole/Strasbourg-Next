package eu.strasbourg.service.place.scheduler;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import eu.strasbourg.utils.constants.GlobalConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;

/**
 * Calcul les horaires de tous les lieux ayant des periodes
 */
@Component(immediate = true, service = updateJsonHoraire.class)
public class updateJsonHoraire extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate() {
		String listenerClass = getClass().getName();

		// Maintenant + 5 min pour ne pas lancer le scheduler au Startup du module
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 5);
		Date fiveMinutesFromNow = now.getTime();

		// Création du trigger "Tous les jours à 0h01"
		Trigger trigger = _triggerFactory.createTrigger(
				listenerClass, listenerClass, fiveMinutesFromNow, null,
				"0 1 0 * * ?", TimeZone.getTimeZone(GlobalConstants.TIMEZONE));

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
		log.info("Start updateJsonHoraire");
		// récupère tous les lieux ayant des périodes
		List<Place> places = _placeLocalService.getPlaces(-1,-1).stream()
				.filter(p -> !p.getPeriods().isEmpty() && p.getStatus() == WorkflowConstants.STATUS_APPROVED)
				.collect(Collectors.toList());
		for (Place place : places) {
			_placeLocalService.updateJsonHoraire(place);
		}
		log.info("Finish updateJsonHoraire");
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

	private volatile SchedulerEngineHelper _schedulerEngineHelper;
	private PlaceLocalService _placeLocalService;
	private TriggerFactory _triggerFactory;
	private Log log = LogFactoryUtil.getLog(this.getClass());

}
