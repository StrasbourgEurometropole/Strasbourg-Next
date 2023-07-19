package eu.strasbourg.service.gtfs.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import eu.strasbourg.service.gtfs.model.ImportHistoric;
import eu.strasbourg.service.gtfs.service.ImportHistoricLocalService;
import eu.strasbourg.utils.constants.GlobalConstants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

@Component(service = SchedulerJobConfiguration.class)
public class ImportGTFSMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Tous les jours à 3h"
		return TriggerConfiguration.createTriggerConfiguration("0 0 3 * * ?");
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> {
			log.info("Start importing GTFS");

			// Creation du contexte de la requete pour effectuer les actions dans Global
			ServiceContext sc = new ServiceContext();
			try {
				Company defaultCompany = _companyLocalService.getCompanyByWebId("liferay.com");
				sc.setCompanyId(defaultCompany.getCompanyId());
				sc.setScopeGroupId(defaultCompany.getGroup().getGroupId());
				sc.setUserId(UserLocalServiceUtil.getDefaultUserId(sc.getCompanyId()));
				sc.setWorkflowAction(WorkflowConstants.ACTION_PUBLISH);
				sc.setModifiedDate(new Date());
			} catch (PortalException e) {
				log.error(e);
			}

			// Creation de l'entree d'historique d'import
			ImportHistoric importHistoric = _importHistoricLocalService.createImportHistoric(sc);

			// Effectue l'import
			this._importHistoricLocalService.doImportGTFS(sc, importHistoric);

			// Sauvegarde de l'entree d'historique d'import
			this._importHistoricLocalService.updateImportHistoric(importHistoric, sc);

			// Envoie du mail de rapport
			importHistoric.sendMail();

			log.info("Finish exporting GTFS");
		};
	}

	@Reference(unbind = "-")
	protected void setCompanyLocalService(CompanyLocalService companyLocalService) {
		_companyLocalService = companyLocalService;
	}
	
	@Reference(unbind = "-")
    protected void setImportHistoricLocalService(ImportHistoricLocalService importHistoricLocalService) {
		_importHistoricLocalService = importHistoricLocalService;
    }
	private CompanyLocalService _companyLocalService;
	private ImportHistoricLocalService _importHistoricLocalService;
	private Log log = LogFactoryUtil.getLog(this.getClass());

}
