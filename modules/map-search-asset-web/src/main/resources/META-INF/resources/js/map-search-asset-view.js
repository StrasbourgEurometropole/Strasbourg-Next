// Initialisation des variables de références
var leafletMap = null;
var markersCluster = null;

// Listes des entités
var projects = null;
var participations = null;
var petitions = null;
var saisines = null;
var budgets = null;
var initiatives = null;
var events = null;

// Listes des marqueurs
var projectMarkers = [];
var participationMarkers = [];
var petitionMarkers = [];
var saisineMarkers = [];
var budgetMarkers = [];
var initiativeMarkers = [];
var eventMarkers = [];

var entityType = {
		PROJECT : 'project',
		PARTICIPATION : 'participation',
		PETITION : 'petition',
		SAISINE : 'saisine',
		BUDGET : 'budget',
		INITIATIVE : 'initiative',
		EVENT : 'event'
}

/**
 * Suppression des éléments du filtre
 */
function removeFilterElements() {
	
	for (var key in entityType) {
		$("input[id^='" + entityType[key] + "_']").each(function() {
			$(this).parent().remove();
		});
	}

}

/**
 * (Re)création des éléments du filtre
 */ 
function updateFilterElements() {
	
	// Suppression des éléments du filtre
    removeFilterElements();
    
    var checker =  "checked";

	// (re)création des éléments du filtre, filtrés sur le quartier choisi ou non
	if (projects != null) {
		projects.forEach(function(project, index) {
			$("fieldset[id='projects_fieldset']").append(
				"<div>" + 
                    "<input type='checkbox' id='project_" + project.id + "' class='hide-checkbox' value='" + project.id + "' " + checker + ">" +
                    "<label for='project_" + project.id + "'>" + project.title + "</label>" +
                "</div>"
			);
		});
	}

	if (participations != null) {
		participations.forEach(function(participation, index) {
			$("fieldset[id='participations_fieldset']").append(
				"<div>" + 
                    "<input type='checkbox' id='participation_" + participation.id + "' class='hide-checkbox' value='" + participation.id + "' " + checker + ">" +
                    "<label for='participation_" + participation.id + "'>" + participation.title + "</label>" +
                "</div>"
			);
		});
	}

	if (petitions != null) {
		petitions.forEach(function(petition, index) {
			$("fieldset[id='petitions_fieldset']").append(
				"<div>" + 
	                "<input type='checkbox' id='petition_" + petition.id + "' class='hide-checkbox' value='" + petition.id + "' " + checker + ">" +
	                "<label for='petition_" + petition.id + "'>" + petition.title + "</label>" +
	            "</div>"
			);
		});
	}

	if (saisines != null) {
		saisines.forEach(function(saisine, index) {
			$("fieldset[id='saisines_fieldset']").append(
				"<div>" +
				"<input type='checkbox' id='saisine_" + saisine.id + "' class='hide-checkbox' value='" + saisine.id + "' " + checker + ">" +
				"<label for='saisine_" + saisine.id + "'>" + saisine.title + "</label>" +
				"</div>"
			);
		});
	}
	
	if (budgets != null) {
		budgets.forEach(function(budget, index) {
			$("fieldset[id='budgets_fieldset']").append(
				"<div>" + 
					"<input type='checkbox' id='budget_" + budget.id +
						"' class='hide-checkbox' value='" + budget.id + "' " + checker + ">" +
					"<label for='budget_" + budget.id + "'>" + budget.title + "</label>" +
				"</div>"
			);
		});
	}
	
	if (initiatives != null) {
		initiatives.forEach(function(initiative, index) {
			$("fieldset[id='initiatives_fieldset']").append(
					"<div>" + 
						"<input type='checkbox' id='initiative_" + initiative.id +
						"' class='hide-checkbox' value='" + initiative.id + "' " + checker + ">" +
						"<label for='initiative_" + initiative.id + "'>" + initiative.title + "</label>" +
					"</div>"
			);
		});
	}

	if (events != null) {
		events.forEach(function(event, index) {
			$("fieldset[id='events_fieldset']").append(
				"<div>" + 
                    "<input type='checkbox' id='event_" + event.id + "' class='hide-checkbox' value='" + event.id + "' " + checker + ">" +
                    "<label for='event_" + event.id + "'>" + event.title.fr_FR + "</label>" +
                "</div>"
			);
		});
	}

}

/**
 * Suppression des marqueurs selon le nom de l'entité demandée (projets, participations...)
 */
function removeMarkerElements(entityName) {

	switch (entityName) {
		case entityType.PROJECT:
			if (projectMarkers != null) {
				projectMarkers.forEach(function(projectMarker) {
					markersCluster.removeLayer(projectMarker);
				});
				projectMarkers = [];
			}
			break;

		case entityType.PARTICIPATION:
			if (participationMarkers != null) {
				participationMarkers.forEach(function(participationMarker) {
					markersCluster.removeLayer(participationMarker);
				});
				participationMarkers = [];
			}
			break;

		case entityType.PETITION:
			if (petitionMarkers != null) {
				petitionMarkers.forEach(function(petitionMarker) {
					markersCluster.removeLayer(petitionMarker);
				});
				petitionMarkers = [];
			}
			break;

		case entityType.SAISINE:
			if (saisineMarkers != null) {
				saisineMarkers.forEach(function(saisineMarker) {
					markersCluster.removeLayer(saisineMarker);
				})
				saisineMarkers = [];
			}
			break;

		case entityType.BUDGET:
			if (budgetMarkers != null) {
				budgetMarkers.forEach(function(budgetMarker) {
					markersCluster.removeLayer(budgetMarker);
				});
				budgetMarkers = [];
			}
			break;

		case entityType.INITIATIVE:
			if (initiativeMarkers != null) {
				initiativeMarkers.forEach(function(initiativeMarker) {
					markersCluster.removeLayer(initiativeMarker);
				});
				initiativeMarkers = [];
			}
			break;

		case entityType.EVENT:
			if (eventMarkers != null) {
				eventMarkers.forEach(function(eventMarker) {
					markersCluster.removeLayer(eventMarker);
				});
				eventMarkers = [];
			}
			break;
	}
}

/**
 * Mise à jour des markers
 * @param entityName Nom de l'entité à partir duquel mettre à jour(projets, participations...)
 */
function updateMarkerElements(entityName) {

	// Suppression des markers
	removeMarkerElements(entityName);
	
	switch (entityName) {
		case entityType.PROJECT:
			if (projects != null) {
				// Parcours des projets
				projects.forEach(function(project) {
					// Le projet doit-il être affiché ?
					if (checkPrintatorState(entityType.PROJECT) && checkMarkerState(entityType.PROJECT, project.id)) {
						// Parcours des lieux du projet
						project.placitPlaces.forEach(function(placitPlace) {
							// Le lieux est-il repérable ?
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								// Création du marqueur
								var marker = getProjectMarker(project, [placitPlace.mercatorY, placitPlace.mercatorX]);
								// Ajout du marqueur sur la carte
								markersCluster.addLayer(marker);
								// Ajout du marqueur dans le tableau de références
								projectMarkers.push(marker);
							}
						});
					}
				});
			}
			break;

		case entityType.PARTICIPATION:
			// Même processus que l'entité Project
			if (participations != null) {
				participations.forEach(function(participation, index) {
					if (checkPrintatorState(entityType.PARTICIPATION) && checkMarkerState(entityType.PARTICIPATION, participation.id)) {
						participation.placitPlaces.forEach(function(placitPlace) {
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								var marker = getParticipationMarker(participation, [placitPlace.mercatorY, placitPlace.mercatorX]);
								markersCluster.addLayer(marker);
								participationMarkers.push(marker);
							}
						});
					}
				});
			}
			break;
			
		case entityType.PETITION:
			// Même processus que l'entité Project
			if (petitions != null) {
				petitions.forEach(function(petition, index) {
					if (checkPrintatorState(entityType.PETITION) && checkMarkerState(entityType.PETITION, petition.id)) {
						petition.placitPlaces.forEach(function(placitPlace) {
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								var marker = getPetitionMarker(petition, [placitPlace.mercatorY, placitPlace.mercatorX]);
								markersCluster.addLayer(marker);
								petitionMarkers.push(marker);
							}
						});
					}
				});
			}
			break;

		case entityType.SAISINE:
			// Même processus que l'entité Pétition
			if (saisines != null) {
				saisines.forEach(function(saisine, index) {
					if (checkPrintatorState(entityType.SAISINE) && checkMarkerState(entityType.SAISINE, saisine.id)) {
						saisine.placitPlaces.forEach(function(placitPlace) {
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								var marker = getSaisineMarker(saisine, [placitPlace.mercatorY, placitPlace.mercatorX]);
								markersCluster.addLayer(marker);
								petitionMarkers.push(marker);
							}
						})
					}
				})
			}
			break;
			
		case entityType.BUDGET:
			// Même processus que l'entité Project
			if (budgets != null) {
				budgets.forEach(function(budget, index) {
					if (checkPrintatorState(entityType.BUDGET) && checkMarkerState(entityType.BUDGET, budget.id)) {
						budget.placitPlaces.forEach(function(placitPlace) {
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								var marker = getBudgetParticipatifMarker(budget, [placitPlace.mercatorY, placitPlace.mercatorX]);
								markersCluster.addLayer(marker);
								budgetMarkers.push(marker);
							}
						});
					}
				});
			}
			break;
			
		case entityType.INITIATIVE:
			// Même processus que l'entité Project
			if (initiatives != null) {
				initiatives.forEach(function(initiative, index) {
					if (checkPrintatorState(entityType.INITIATIVE) && checkMarkerState(entityType.INITIATIVE, initiative.id)) {
						initiative.placitPlaces.forEach(function(placitPlace) {
							if (placitPlace.mercatorY != 0 && placitPlace.mercatorX != 0) {
								var marker = getInitiativeMarker(initiative, [placitPlace.mercatorY, placitPlace.mercatorX]);
								markersCluster.addLayer(marker);
								initiativeMarkers.push(marker);
							}
						});
					}
				});
			}
			break;
			
		case entityType.EVENT:
			// Même processus que l'entité Project
			if (events != null) {
				events.forEach(function(event, index) {
					if (checkPrintatorState(entityType.EVENT) && checkMarkerState(entityType.EVENT, event.id)) {
						if (event.mercatorY != 0 && event.mercatorX != 0) {
							var marker = getEventMarker(event);
							markersCluster.addLayer(marker);
							eventMarkers.push(marker);
						}
					}
				});
			}
			break;
	}
}

/**
 * Vérification de l'état de la checkbox d'affichage d'un type entité
 * @param 	entityName : Nom de l'entité à sonder
 * @returns Booléen
 */
function checkPrintatorState(entityName) {
	return $("input[id^='" + entityName + "s_printator_mk1']").is(':checked');
}

/**
 * Vérification de l'état de la checkbox d'affichage d'un élément d'une entité
 * @param 	entityName : Nom de l'entité à sonder
 * 			entityId : PK de l'élément à sonder
 * @returns Booléen
 */
function checkMarkerState(entityName, entityId) {
	return $("input[id^='" + entityName + "_" + entityId + "']").is(':checked');
}

$(document).ready(function() {
	// Création de la carte au centre de strasbourg
    leafletMap = getLeafletMap();
    markersCluster = L.markerClusterGroup();
    leafletMap.addLayer(markersCluster);
    
    // Cache du bouton de zoom de map
    $('.leaflet-control-fullscreen-button').hide();
    
    // Requête d'affichage de l'ensemble des filtres et marqueurs
    refreshEntitiesSelectionByDistrict(-1);
});

/**
 * Mise à jour de la carto (éléments du filtre, marqueurs) selon le quartier choisi
 * @param districtId Identifiant de la catégorie du teritoire demandé en filtre
 */
function refreshEntitiesSelectionByDistrict(districtId) {
	AUI().use('aui-io-request', function(A) {
		A.io.request(changeDistrictSelectionURL, {
			method : 'post',
			dataType: 'json',
			data : {
				_eu_strasbourg_portlet_map_search_asset_MapSearchAssetPortlet_selectedDistrictId : districtId
			},
			on: {
                success: function(e) {
                	
                	var data = this.get('responseData');
                	projects = data.projects;
                	participations = data.participations;
                	petitions = data.petitions;
					saisines = data.saisines;
                	budgets = data.budgets;
                	initiatives = data.initiatives;
                	events = data.events;
                	
                	updateFilterElements();
                	
                	for (var key in entityType) {
                		updateMarkerElements(entityType[key]);
                	}
			 	}
			 }
		});
	});
}

/**
 * Lors d'une selection de quartier
 */
$('#district').change(function() {
	var selectedDistrictId = this.value;
	
	refreshEntitiesSelectionByDistrict(selectedDistrictId);
});

/**
 * Lors d'un accordeonage ou desaccordeaonage d'une liste
 */
$("input[id$='_printator_mk1']").change(function() {
	var selectedEntity = this.value;
	
	updateMarkerElements(selectedEntity);
});

/**
 * Lors du clic sur un span "Tout effacer"
 */
$(".pro-remove-chk").click(function() {
	var selectedEntity = $(this).parent().siblings("input[id$='_printator_mk1']").val();

	// supprime les markers de l'entité
	removeMarkerElements(selectedEntity);
});

/**
 * Lors du clic sur une itération d'entité
 */
$(document).on('change', "fieldset[id$='_fieldset'] > div > input", function(){
	var selectedEntity = this.id.substring(0, this.id.indexOf("_"));
	var selectedId = this.id.substring(this.id.indexOf("_")+1);

	// met à jour les markers de l'entité
	updateMarkerElements(selectedEntity);
});
