package eu.strasbourg.service.edition.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.edition.service.EditionGalleryLocalService;
import eu.strasbourg.service.edition.service.EditionLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SchedulerJobConfiguration.class)
public class CheckEditionMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 15 minutes"
		return TriggerConfiguration.createTriggerConfiguration(15, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_editionLocalService.checkEditions();
			_editionGalleryLocalService.checkGalleries();
		};
	}

	@Reference(unbind = "-")
	protected void setEditionLocalService(EditionLocalService editionLocalService) {
		_editionLocalService = editionLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setEditionGalleryLocalService(EditionGalleryLocalService editionGalleryLocalService) {
		_editionGalleryLocalService = editionGalleryLocalService;
	}

	private EditionLocalService _editionLocalService;
	private EditionGalleryLocalService _editionGalleryLocalService;
}
