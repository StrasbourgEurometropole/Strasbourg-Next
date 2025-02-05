package eu.strasbourg.service.office.exporter.api;

import aQute.bnd.annotation.ProviderType;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.BudgetSupport;

import java.io.OutputStream;
import java.util.List;

@ProviderType
public interface BudgetPhaseSupportsXlsxExporter {
	
	public void exportBudgetPhaseSupports(OutputStream stream, long budgetPhaseId);

	public void exportBudgetPhaseSupports(OutputStream stream, String budgetPhaseTitle, List<BudgetParticipatif> budgetParticipatifs);

	public Object[][] exportBudgetPhaseSupports(Object[][] supportData, String budgetPhaseTitle, String budgetParticipatifTitle, List<BudgetSupport> budgetSupports);
}
