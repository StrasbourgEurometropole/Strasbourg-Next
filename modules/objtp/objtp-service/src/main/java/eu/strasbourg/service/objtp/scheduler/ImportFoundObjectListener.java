package eu.strasbourg.service.objtp.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.objtp.service.FoundObjectLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Importe automatiquement les objets trouvés et les catégories associées
 * JSON présents dans le dossier d'import.
 */
@Component(service = SchedulerJobConfiguration.class)
public class ImportFoundObjectListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 5h"
		return TriggerConfiguration.createTriggerConfiguration("0 0 5 * * ?");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start importing objtp");
			_foundObjectLocalService.doImport();
			log.info("Finish importing objtp");
		};
	}

	@Reference(unbind = "-")
	protected void setFoundObjectLocalService(FoundObjectLocalService foundObjectLocalService) {
		_foundObjectLocalService = foundObjectLocalService;
	}
	private FoundObjectLocalService _foundObjectLocalService;

	private Log log = LogFactoryUtil.getLog(this.getClass());
	
}
