package eu.strasbourg.service.video.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.video.service.VideoGalleryLocalService;
import eu.strasbourg.service.video.service.VideoLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(service = SchedulerJobConfiguration.class)
public class CheckVideoMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les 15 minutes"
		return TriggerConfiguration.createTriggerConfiguration(15, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			_videoLocalService.checkVideos();
			_videoGalleryLocalService.checkGalleries();
		};
	}

	@Reference(unbind = "-")
	protected void setVideoLocalService(VideoLocalService videoLocalService) {
		_videoLocalService = videoLocalService;
	}
	
	@Reference(unbind = "-")
	protected void setVideoGalleryLocalService(VideoGalleryLocalService videoGalleryLocalService) {
		_videoGalleryLocalService = videoGalleryLocalService;
	}
	private VideoLocalService _videoLocalService;
	private VideoGalleryLocalService _videoGalleryLocalService;
}
