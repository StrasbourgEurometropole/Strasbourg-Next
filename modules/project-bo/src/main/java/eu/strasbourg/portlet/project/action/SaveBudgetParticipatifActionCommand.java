package eu.strasbourg.portlet.project.action;

import static eu.strasbourg.service.project.constants.ParticiperCategories.BP_MERGED;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import eu.strasbourg.service.project.model.ProjectTimeline;
import eu.strasbourg.service.project.service.ProjectTimelineLocalService;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.asset.kernel.model.AssetCategory;
import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.service.AssetCategoryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import eu.strasbourg.service.project.constants.ParticiperCategories;
import eu.strasbourg.service.project.model.BudgetParticipatif;
import eu.strasbourg.service.project.model.PlacitPlace;
import eu.strasbourg.service.project.service.BudgetParticipatifLocalService;
import eu.strasbourg.service.project.service.PlacitPlaceLocalService;
import eu.strasbourg.utils.AssetVocabularyHelper;
import eu.strasbourg.utils.StringHelper;
import eu.strasbourg.utils.constants.StrasbourgPortletKeys;
import eu.strasbourg.utils.constants.VocabularyNames;

@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + StrasbourgPortletKeys.PROJECT_BO,
		"mvc.command.name=saveBudgetParticipatif"
	},
	service = MVCActionCommand.class
)
public class SaveBudgetParticipatifActionCommand implements MVCActionCommand {
	
	@Override
	public boolean processAction(ActionRequest request, ActionResponse response) throws PortletException {
		try {
            ServiceContext sc = ServiceContextFactory.getInstance(request);
            
	        // Validation
 			boolean isValid = validate(request);
 			if (!isValid) {
 				setResponse(request, response);
 				return false;
 			}
 			
 			long budgetParticipatifId = ParamUtil.getLong(request,"budgetParticipatifId");
 			
 			BudgetParticipatif budgetParticipatif;
            if (budgetParticipatifId==0)
                budgetParticipatif = _budgetLocalService.createBudgetParticipatif(sc);
            else
                budgetParticipatif = _budgetLocalService.getBudgetParticipatif(budgetParticipatifId);
            
            // ---------------------------------------------------------------
 			// -------------------------- GENERALITES ------------------------
 			// ---------------------------------------------------------------
            
            // Titre
            String title = ParamUtil.getString(request, "title");
            budgetParticipatif.setTitle(title);
            
            // Description
            String description = ParamUtil.getString(request, "description");
            budgetParticipatif.setDescription(description);
            
            // Resume
            String summary = ParamUtil.getString(request, "summary");
            budgetParticipatif.setSummary(summary);
            
            // Budget
            String budget = ParamUtil.getString(request, "budget");
            budgetParticipatif.setBudget(budget);
            
            // Motif
            String motif = ParamUtil.getString(request, "motif");
            budgetParticipatif.setMotif(motif);
            
            // ---------------------------------------------------------------
 			// -------------------------- CITOYEN ----------------------------
 			// ---------------------------------------------------------------
            
            // Citoyen : Adresse
            String adresse = ParamUtil.getString(request, "citoyenAdresse");
            budgetParticipatif.setCitoyenAdresse(adresse);
            
            // Citoyen : Code postal
            long postalCode = ParamUtil.getLong(request, "citoyenPostalCode");
            budgetParticipatif.setCitoyenPostalCode(postalCode);
            
            // Citoyen : Ville
            String city = ParamUtil.getString(request, "citoyenCity");
            budgetParticipatif.setCitoyenCity(city);
            
            // Citoyen : Email
            String mail = ParamUtil.getString(request, "citoyenEmail");
            budgetParticipatif.setCitoyenEmail(mail);
            
            // Citoyen : Telephone
            String phone= ParamUtil.getString(request, "citoyenPhone");
            budgetParticipatif.setCitoyenPhone(phone);
            
            // Citoyen : Mobile
            String mobile = ParamUtil.getString(request, "citoyenMobile");
            budgetParticipatif.setCitoyenMobile(mobile);
            
            // ---------------------------------------------------------------
 			// -------------------------- FUSION -----------------------------
 			// ---------------------------------------------------------------
            
            budgetParticipatif.setInTheNameOf(ParamUtil.getString(request, "inTheNameOf"));
            
            // Sélection du projet partent
            budgetParticipatif.setParentId(ParamUtil.getLong(request, "budgetParentId"));
            
            //Si un projet parent est associé, le projet courant(Devenu fils) prend le statut "Fusionne"
            if(ParamUtil.getLong(request, "budgetParentId") != 0) {
            	long[] ids = sc.getAssetCategoryIds();
            	List<Long> idsLong = Arrays.stream(ids).boxed().collect(Collectors.toList());
            	List<AssetCategory> categories = AssetVocabularyHelper.getVocabulary(VocabularyNames.BUDGET_PARTICIPATIF_STATUS, sc.getScopeGroupId()).getCategories();
            	
            	AssetCategory selectedBPStatus = categories.stream().filter(status -> idsLong.contains(status.getCategoryId())).findFirst().orElse(null);
            	if(selectedBPStatus != null)
            		idsLong.remove(idsLong.indexOf(selectedBPStatus.getCategoryId()));
            	AssetCategory mergedBPStatus = categories.stream()
            			.filter(status -> StringHelper.compareIgnoringAccentuation(status.getTitle(Locale.FRENCH), BP_MERGED.getName())).findFirst().orElse(null);
            	
            	idsLong.add(mergedBPStatus.getCategoryId());
            	sc.setAssetCategoryIds(idsLong.stream().mapToLong(w -> w).toArray());
            }
            
            // ---------------------------------------------------------------
 			// -------------------------- IMAGE / VIDEO ----------------------
 			// ---------------------------------------------------------------
            
            // URL de la vidéo
            String videoUrl = ParamUtil.getString(request, "videoUrl");
            budgetParticipatif.setVideoUrl(videoUrl);
            
            // Image
            Long imageId = ParamUtil.getLong(request, "imageId");
            budgetParticipatif.setImageId(imageId);
            
            // ---------------------------------------------------------------
 			// -------------------------- LIEUX ------------------------------
 			// ---------------------------------------------------------------
            
            // Champ lieu libre rempli par l'usager publik
            String placeTextArea = ParamUtil.getString(request, "placeTextArea");
            budgetParticipatif.setPlaceTextArea(placeTextArea);
            
            // Lieux
 			for (PlacitPlace placitPlace : budgetParticipatif.getPlacitPlaces()) {
 				// On supprime d'abord les lieux existants
 				_placitPlaceLocalService.removePlacitPlace(placitPlace.getPlacitPlaceId());
 			}
 			
 			// Puis on cree les nouveaux
 			String placitPlacesIndexesString = ParamUtil.getString(request, "placeIndexes");
 			
 			for (String placitPlacesIndexe : placitPlacesIndexesString.split(",")) {
 				
 				// Recupere les valeurs de test pour savoir si il existe des lieux placit
 				String placeSIGId = ParamUtil.getString(request, "placeSIGId" + placitPlacesIndexe);
 				String placeName = ParamUtil.getString(request, "placeName" + placitPlacesIndexe);
 				long placeCityId = ParamUtil.getLong(request, "placeCityId" + placitPlacesIndexe);
 				
 				// Si il existe au moins un lieu SIG ou manuel
 				if (Validator.isNotNull(placitPlacesIndexe) 
 						&& (Validator.isNotNull(placeSIGId) 
 						|| (Validator.isNotNull(placeName) 
 						&& Validator.isNotNull(placeCityId)))) {
 					
 					// Initialisation de l'entite
 					PlacitPlace placitPlace = _placitPlaceLocalService.createPlacitPlace(sc);

 					if (Validator.isNotNull(placeSIGId)) {
 						// Lieu SIG
 						placitPlace.setPlaceSIGId(placeSIGId);
 					} else {
 						// Nom du lieu
 						placitPlace.setPlaceName(placeName);

 						// Numéro de rue
 						String placeStreetNumber = ParamUtil.getString(request,
 							"placeStreetNumber" + placitPlacesIndexe);
 						placitPlace.setPlaceStreetNumber(placeStreetNumber);

 						// Nom de la rue
 						String placeStreetName = ParamUtil.getString(request,
 							"placeStreetName" + placitPlacesIndexe);
 						placitPlace.setPlaceStreetName(placeStreetName);

 						// Code postal
 						String placeZipCode = ParamUtil.getString(request,
 							"placeZipCode" + placitPlacesIndexe);
 						placitPlace.setPlaceZipCode(placeZipCode);

 						// Ville
 						placitPlace.setPlaceCityId(placeCityId);
 						
 						// Image du lieu
 						long placeImageId = ParamUtil.getLong(request,
 							"placeImageId" + placitPlacesIndexe);
 						placitPlace.setImageId(placeImageId);
 					}

 					// Rattachement a la participation
 					placitPlace.setBudgetParticipatifId(budgetParticipatif.getBudgetParticipatifId());

 					// Mise à jour en base
 					_placitPlaceLocalService.updatePlacitPlace(placitPlace, sc);
 				}
 			}
 			
 			// ---------------------------------------------------------------
 			// ----------------------- <3 COUP DE COEUR <3 -------------------
 			// ---------------------------------------------------------------
            
 			// Est-ce un coup de coeur ?
            boolean isCrush = ParamUtil.getBoolean(request, "isCrush");
            budgetParticipatif.setIsCrush(isCrush);
            
            // Commentaire du coup de coeur
            String crushComment = ParamUtil.getString(request, "crushComment");
            budgetParticipatif.setCrushComment(crushComment);
            
            // ---------------------------------------------------------------
 			// ----------------------- SELECTION DE LA PHASE -----------------
 			// ---------------------------------------------------------------
            
            // Phase
            Long budgetPhaseId = ParamUtil.getLong(request, "budgetPhaseId");
            budgetParticipatif.setBudgetPhaseId(budgetPhaseId);

			// ---------------------------------------------------------------
			// -------------------------- DOCUMENTS --------------------------
			// ---------------------------------------------------------------

			// Documents associés
			String filesIds = ParamUtil.getString(request, "filesIds");
			budgetParticipatif.setFilesIds(filesIds);

			// ---------------------------------------------------------------
			// -------------------------- TIMELINE ---------------------------
			// ---------------------------------------------------------------


			Long imageTimeline = ParamUtil.getLong(request, "imageTimeline");
			budgetParticipatif.setImageTimeline(imageTimeline);

			// opacité de l'image
			Double opacityImage = ParamUtil.getDouble(request, "opacityImage");
			budgetParticipatif.setOpacityImage(opacityImage);

			// Suppression des anciennes entrées de timeline
			List<ProjectTimeline> oldTimelines = budgetParticipatif.getBudgetParticipatifTimelines();
			for (ProjectTimeline projectTimeline : oldTimelines) {
				_projectTimelineLocalService.deleteProjectTimeline(projectTimeline);
			}
			// Ajout des nouvelles
			String timelineIndexesString = ParamUtil.getString(request, "budgetParticipatifTimelineIndexes");
			for (String timelineIndex : timelineIndexesString.split(",")) {
				DateFormat paramDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				if (Validator.isNotNull(timelineIndex)
						&& Validator.isNotNull(ParamUtil.getString(request, "date" + timelineIndex))) {

					// Spacing
					Integer spacing = ParamUtil.getInteger(request, "spacing" + timelineIndex);

					// Date
					Date date = ParamUtil.getDate(request, "date" + timelineIndex, paramDateFormat);

					// Titre
					String timelineTitle = ParamUtil.getString(request, "title" + timelineIndex);

					// Lien
					String link = ParamUtil.getString(request, "link" + timelineIndex);

					// Format de date
					String dateFormat = ParamUtil.getString(request, "dateFormat" + timelineIndex);

					ProjectTimeline projectTimeline = _projectTimelineLocalService.createProjectTimeline();
					projectTimeline.setDate(date);
					projectTimeline.setSpacing(spacing);
					projectTimeline.setTitle(timelineTitle);
					projectTimeline.setLink(link);
					projectTimeline.setBudgetParticipatifId(budgetParticipatif.getBudgetParticipatifId());
					projectTimeline.setDateFormat(dateFormat);
					this._projectTimelineLocalService.updateProjectTimeline(projectTimeline);
				}
			}
            
            
            // ---------------------------------------------------------------
		// ----------------------- Contrôle du statut --------------------
		// ---------------------------------------------------------------
            
            //Si le motif n'est pas rempli, on vérifie que le statut  n'est pas dans la liste suivante : : Non Recevable, Non faisable, Non retenu, Annulé, Suspendu
            if(Validator.isNull(motif))
            {
	            AssetEntry entry = AssetEntryLocalServiceUtil.fetchEntry(
	                    BudgetParticipatif.class.getName(), budgetParticipatif.getBudgetParticipatifId());
	            if (entry != null) {
	                
	            	//Récupération des catégories de la requête
	            	List<AssetCategory> categories = new ArrayList<AssetCategory>();
	                for(long catid : sc.getAssetCategoryIds())
	                	categories.add(AssetCategoryLocalServiceUtil.getAssetCategory(catid));
	                	
	                boolean ok = Collections.disjoint(categories, Stream.of(
	                		AssetVocabularyHelper.getCategory(ParticiperCategories.BP_NON_ACCEPTABLE.getName(), sc.getScopeGroupId()),
	                		AssetVocabularyHelper.getCategory(ParticiperCategories.BP_NON_FEASIBLE.getName(), sc.getScopeGroupId()),
	                		AssetVocabularyHelper.getCategory(ParticiperCategories.BP_NON_SELECTED.getName(), sc.getScopeGroupId()),	               		
	                		AssetVocabularyHelper.getCategory(ParticiperCategories.BP_CANCELLED.getName(), sc.getScopeGroupId()),
	                		AssetVocabularyHelper.getCategory(ParticiperCategories.BP_SUSPENDED.getName(), sc.getScopeGroupId())
	                		).collect(Collectors.toList()));
	                
	                if(!ok) {
	                	SessionErrors.add(request, "motif-error");
	                	setResponse(request, response);
	                	return false;
	                }
	            } 
            }
            
            // Sauvegarde du budget
            _budgetLocalService.updateBudgetParticipatif(budgetParticipatif, sc);
            
        } catch (PortalException e) {
            _log.error("erreur lors de la mise à jour d'un budget : ",e);
        }
        return true;
	}
	
	/**
	 * Pépare la reponse en cas d'echec de la mise à jour du BP
	 */
	public void setResponse(ActionRequest request, ActionResponse response) {
		// Si pas valide : on reste sur la page d'édition
			PortalUtil.copyRequestParameters(request, response);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String portletName = (String) request.getAttribute(WebKeys.PORTLET_ID);
			PortletURL returnURL = PortletURLFactoryUtil.create(request,
				portletName, themeDisplay.getPlid(),
				PortletRequest.RENDER_PHASE);

			response.setRenderParameter("returnURL", returnURL.toString());
			response.setRenderParameter("cmd","editBudgetParticipatif");
			response.setRenderParameter("mvcPath","/project-bo-edit-budget-participatif.jsp");
	}
	
	/**
	 * Validation des champs obligatoires
	 */
	private boolean validate(ActionRequest request) {
		boolean isValid = true;

		// Titre
		if (Validator.isNull(ParamUtil.getString(request, "title"))) {
			SessionErrors.add(request, "title-error");
			isValid = false;
		}

		// Description
		if (Validator.isNull(ParamUtil.getString(request, "description"))) {
			SessionErrors.add(request, "description-error");
			isValid = false;
		}
		
		return isValid;
	}

	private ProjectTimelineLocalService _projectTimelineLocalService;

	@Reference(unbind = "-")
	protected void setProjectTimelineLocalService(ProjectTimelineLocalService projectTimelineLocalService) {
		_projectTimelineLocalService = projectTimelineLocalService;
	}

	private BudgetParticipatifLocalService _budgetLocalService;
	
	@Reference(unbind = "-")
    protected void setbudgetLocalService(BudgetParticipatifLocalService budgetLocalService) {
        _budgetLocalService = budgetLocalService;
    }
	
	private PlacitPlaceLocalService _placitPlaceLocalService;

    @Reference(unbind = "-")
    protected void setPlacitPlaceLocalService(PlacitPlaceLocalService placitPlaceLocalService) {
        _placitPlaceLocalService = placitPlaceLocalService;
    }
	
	private final Log _log = LogFactoryUtil.getLog(this.getClass().getName());

}
