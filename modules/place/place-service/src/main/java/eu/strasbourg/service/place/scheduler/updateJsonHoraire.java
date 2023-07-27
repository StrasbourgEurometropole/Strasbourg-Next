package eu.strasbourg.service.place.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.place.model.Place;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Calcul les horaires de tous les lieux ayant des periodes
 */
@Component(service = SchedulerJobConfiguration.class)
public class updateJsonHoraire
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 0h01"
		return TriggerConfiguration.createTriggerConfiguration("0 1 0 * * ?");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start updateJsonHoraire");
			// récupère tous les lieux ayant des périodes
			List<Place> places = _placeLocalService.getPlaces(-1, -1).stream()
					.filter(p -> !p.getPeriods().isEmpty() && p.getStatus() == WorkflowConstants.STATUS_APPROVED)
					.collect(Collectors.toList());
			for (Place place : places) {
				_placeLocalService.updateJsonHoraire(place);
			}
			log.info("Finish updateJsonHoraire");
		};
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
	}

	private PlaceLocalService _placeLocalService;
	private Log log = LogFactoryUtil.getLog(this.getClass());

}
