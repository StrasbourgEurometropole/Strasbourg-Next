package eu.strasbourg.service.project.scheduler;

import com.liferay.petra.function.UnsafeRunnable;
import com.liferay.portal.kernel.scheduler.SchedulerJobConfiguration;
import com.liferay.portal.kernel.scheduler.TimeUnit;
import com.liferay.portal.kernel.scheduler.TriggerConfiguration;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * Randomise la date des Budgets participatifs
 * @author cedric.henry
 */
@Component(service = SchedulerJobConfiguration.class)
public class RandomizeBudgetMessageListener
		implements SchedulerJobConfiguration {

	@Override
	public TriggerConfiguration getTriggerConfiguration() {
		// Création du trigger "Toutes les heures"
		return TriggerConfiguration.createTriggerConfiguration(60, TimeUnit.MINUTE);
	}

	@Override
	public UnsafeRunnable<Exception> getJobExecutorUnsafeRunnable() {
		return () -> _budgetParticipatifLocalService.randomizeModifiedDate();
	}

    @Reference(unbind = "-")
    protected void setBudgetParticipatifLocalService(BudgetParticipatifLocalService budgetParticipatifLocalService) {
		_budgetParticipatifLocalService = budgetParticipatifLocalService;
    }
	private BudgetParticipatifLocalService _budgetParticipatifLocalService;
	
}
