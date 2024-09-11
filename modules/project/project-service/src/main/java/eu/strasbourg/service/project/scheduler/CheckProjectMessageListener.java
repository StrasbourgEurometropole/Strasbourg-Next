package eu.strasbourg.service.project.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.project.service.ParticipationLocalService;
import eu.strasbourg.service.project.service.PetitionLocalService;
import eu.strasbourg.service.project.service.SignataireLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Modifie le statut des participations
 * @author cedric.henry
 */
@Component(service = SchedulerJobConfiguration.class)
public class CheckProjectMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les heures"
		return TriggerConfiguration.createTriggerConfiguration(60, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_participationLocalService.updateAllParticipationsStatus();
			_petitionLocalService.updateAllPetitionsStatus();
		};
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
	private ParticipationLocalService _participationLocalService;
	private PetitionLocalService _petitionLocalService;
	private SignataireLocalService _signataireLocalService;
	
}
