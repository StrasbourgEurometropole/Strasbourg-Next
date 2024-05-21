package eu.strasbourg.portlet.council.action;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import eu.strasbourg.service.council.constants.StageDeliberation;
import eu.strasbourg.service.council.model.CouncilSession;
import eu.strasbourg.service.council.model.Deliberation;
import eu.strasbourg.service.council.model.DeliberationModel;
import eu.strasbourg.service.council.model.Procuration;
import eu.strasbourg.service.council.service.CouncilSessionLocalService;
import eu.strasbourg.service.council.service.DeliberationLocalService;
import eu.strasbourg.service.council.service.ProcurationLocalService;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component(
	immediate = true,
	property = { "javax.portlet.name=" + StrasbourgPortletKeys.COUNCIL_BO,
		"mvc.command.name=selectionAction" },
	service = MVCActionCommand.class)
public class SelectionActionCommand implements MVCActionCommand {

	@Override
	public boolean processAction(ActionRequest actionRequest,
		ActionResponse actionResponse) {
		long[] deliberationIds = ParamUtil.getLongValues(actionRequest, "rowIds");

		for (long deliberationId : deliberationIds) {
			try {
				// Partie procuration
				Deliberation deliberation = deliberationLocalService.getDeliberation(deliberationId);
				// Récupération des procurations du conseil de la deliberation
				List<Procuration> procurations = councilSessionLocalService.getCouncilSession(deliberation.getCouncilSessionId()).getProcurations();
				// Récupère les delibs qui ne sont pas en CREE
				List<Deliberation> notCreated = deliberationLocalService.findByCouncilSessionId(deliberation.getCouncilSessionId()).stream()
						.filter(d -> !d.getStage().equals(StageDeliberation.CREE.getName()))
						.collect(Collectors.toList());
				List<Deliberation> filtered = notCreated.stream().filter(d -> d.getDeliberationId() != deliberationId).collect(Collectors.toList());
				for (Procuration procuration : procurations) {
					boolean updateProc = false;
					// Verifie si la procuration a pour startDelib la delib qui va être supprimé si oui on set à -1
					if (procuration.getStartDelib() == deliberationId) {
						procuration.setStartDelib(-1);
						// Si la procuration n'a pas de delib de fin
						// //Et que c'est la dernière délib différente du statut "CREEE" alors on set le isAfterVote a true
						// Utile lors de la suppression des Délibérations de TEST
						if (Validator.isNull(procuration.getEndHour()) && notCreated.size() == 1 && notCreated.contains(deliberation)) {
							procuration.setIsAfterVote(true);
						}
						updateProc = true;
					}
					//Dans le cas où la délib en cours de suppression est la délibération de fin de la procuration
					if (procuration.getEndDelib() == deliberationId) {
						// Verifie si la liste des delibs contient seulement la delib en cours de suppression
						if (notCreated.size() == 1 && notCreated.contains(deliberation)) {
							// Si oui mettre -1 en endDelib car pas d'autre deliberation possible
							procuration.setEndDelib(-1);
							updateProc = true;
						} else {
							// Sinon recuperer les delib qui sont comprises entre start et end Hour de la proc et utiliser la derniere pour set endDelib
							if (Validator.isNotNull(procuration.getEndHour())) {
								List<Deliberation> voteds = filtered.stream()
										.filter(d -> Validator.isNotNull(d.getEndVoteDate()))
										.filter(d -> d.getEndVoteDate().after(procuration.getStartHour()) && d.getEndVoteDate().before(procuration.getEndHour()))
										.sorted(Comparator.comparing(DeliberationModel::getEndVoteDate))
										.collect(Collectors.toList());
								if (voteds.isEmpty()) {
									// Si pas de delib dans la liste set à -1
									procuration.setEndDelib(-1);
								} else {
									Deliberation voted = voteds.get(voteds.size() - 1);
									procuration.setEndDelib(voted.getDeliberationId());
								}
								updateProc = true;
							}
						}
					}
					if (updateProc)
						procurationLocalService.updateProcuration(procuration);
				}

				CouncilSession council = councilSessionLocalService.fetchCouncilSession(deliberation.getCouncilSessionId());

				if(council != null) {
					// Si la dernière délibération traitée du conseil est celle qu'on supprime
					if(council.getLastDelibProcessed() == deliberationId) {
						// On cherche la dernière délibération votée avant celle là
						List<Deliberation> lastVotedDelibs = filtered.stream()
								.filter(d -> d.getEndVoteDate() != null)
								.sorted(Comparator.comparing(DeliberationModel::getEndVoteDate).reversed())
								.collect(Collectors.toList());

						if (lastVotedDelibs.isEmpty()) {
							// Si pas de delib voté avant, on repasse la dernière délib traitée du conseil à 0
							council.setLastDelibProcessed(0);
						} else {
							// Sinon c'est cette délib qui devient la dernière délib traitée du conseil
							Deliberation lastVoted = lastVotedDelibs.get(0);
							council.setLastDelibProcessed(lastVoted.getDeliberationId());
						}
						councilSessionLocalService.updateCouncilSession(council);
					}
				}

				// Suppression de l'entité
				deliberationLocalService.removeDeliberation(deliberationId);
			} catch (PortalException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	private DeliberationLocalService deliberationLocalService;

	@Reference(unbind = "-")
	protected void setDeliberationLocalService(
			DeliberationLocalService deliberationLocalService) {
		this.deliberationLocalService = deliberationLocalService;
	}

	private CouncilSessionLocalService councilSessionLocalService;

	@Reference(unbind = "-")
	protected void setCouncilSessionLocalService(
			CouncilSessionLocalService councilSessionLocalService) {
		this.councilSessionLocalService = councilSessionLocalService;
	}

	private ProcurationLocalService procurationLocalService;

	@Reference(unbind = "-")
	protected void setProcurationLocalService(
			ProcurationLocalService procurationLocalService) {
		this.procurationLocalService = procurationLocalService;
	}

	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());
}
