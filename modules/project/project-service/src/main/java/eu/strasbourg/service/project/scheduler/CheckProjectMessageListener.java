package eu.strasbourg.service.project.scheduler;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import eu.strasbourg.service.project.service.ParticipationLocalService;
import eu.strasbourg.service.project.service.PetitionLocalService;
import eu.strasbourg.service.project.service.SignataireLocalService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;

/**
 * Modifie le statut des participations
 * @author cedric.henry
 */
@Component(
		immediate = true,
		service = CheckProjectMessageListener.class
)
public class CheckProjectMessageListener extends BaseMessageListener {

	@Activate
	@Modified
	protected void activate() {
		String listenerClass = getClass().getName();

		// Maintenant + 5 min pour ne pas lancer le scheduler au Startup du module
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, 5);
		Date fiveMinutesFromNow = now.getTime();

		// Création du trigger "Toutes les heures"
		Trigger trigger = _triggerFactory.createTrigger(
				listenerClass, listenerClass, fiveMinutesFromNow, null,
				60, TimeUnit.MINUTE);

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
		_participationLocalService.updateAllParticipationsStatus();
		_petitionLocalService.updateAllPetitionsStatus();
	}

    @Reference(unbind = "-")
    protected void setParticipationLocalService(ParticipationLocalService participationLocalService) {
        _participationLocalService = participationLocalService;
    }

    @Reference(unbind = "-")
    protected void setPetitionLocalService(PetitionLocalService petitionLocalService) {
        _petitionLocalService = petitionLocalService;
    }

	@Reference(unbind = "-")
	protected void setSignataireLocalService(SignataireLocalService signataireLocalService) {
		_signataireLocalService = signataireLocalService;
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
	private ParticipationLocalService _participationLocalService;
	private PetitionLocalService _petitionLocalService;
	private SignataireLocalService _signataireLocalService;
	private TriggerFactory _triggerFactory;
	
}
