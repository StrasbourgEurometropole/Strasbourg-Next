package eu.strasbourg.service.agenda.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import eu.strasbourg.service.agenda.model.Event;
import eu.strasbourg.service.agenda.model.Manifestation;
import eu.strasbourg.service.agenda.service.EventLocalService;
import eu.strasbourg.service.agenda.service.ManifestationLocalService;
import eu.strasbourg.service.place.service.PlaceLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Réindexe les événements et les manifestations. Utile car on souhaite que
 * seules les dates futures de l'événement soient indexées.
 */
@Component(service = SchedulerJobConfiguration.class)
public class ReindexEventsMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 2 heures"
		return TriggerConfiguration.createTriggerConfiguration(2, TimeUnit.HOUR);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			long companyId = PortalUtil.getDefaultCompanyId();
			String companyIdString = String.valueOf(companyId);
			String[] companyIdStringArray = new String[]{companyIdString};
			this._log.info("Start reindexing events and manifestations");
			Indexer<Event> eventIndexer = IndexerRegistryUtil
					.getIndexer(Event.class);
			if (eventIndexer != null) {
				try {
					eventIndexer.reindex(companyIdStringArray);
				} catch (Exception ex) {
					this._log.warn("Fail to reindex events");
				}
			}
			Indexer<Manifestation> manifestationIndexer = IndexerRegistryUtil
					.getIndexer(Manifestation.class);
			if (manifestationIndexer != null) {
				try {
					manifestationIndexer.reindex(companyIdStringArray);
				} catch (Exception ex) {
					this._log.warn("Fail to reindex events");
				}
			}
			this._log.info("Finish reindexing events and manifestations");
		};
	}

	@Reference(unbind = "-")
	protected void setEventLocalService(EventLocalService eventLocalService) {
		_eventLocalService = eventLocalService;
	}

	@Reference(unbind = "-")
	protected void setManifestationLocalService(ManifestationLocalService manifestationLocalService) {
		_manifestationLocalService = manifestationLocalService;
	}

	@Reference(unbind = "-")
	protected void setPlaceLocalService(PlaceLocalService placeLocalService) {
		_placeLocalService = placeLocalService;
	}

	private EventLocalService _eventLocalService;
	private ManifestationLocalService _manifestationLocalService;
	private PlaceLocalService _placeLocalService;
	private final Log _log = LogFactoryUtil.getLog(this.getClass());
}
