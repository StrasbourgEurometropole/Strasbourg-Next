// Initialisation des variables de références
var projects = null;

var entityType = {
	DISTRICT : 'vocabulary_1',
	THEMATIC : 'vocabulary_2',
}


$(document).ready(function(){
    getSelectedEntries();
});

/**
 * Renvoi la liste des IDs des entités demandées
 * @param entityName Nom de l'entité à sonder
 * @return liste des IDs sous forme d'une chaine de caractères séparée par des ","
 */
function getSelectedMarkerElements(entityName) {
	var results = "";
	
	$("input[id*='" + entityName + "_']:checked").each(function() {
		results =  results.concat(this.value, ',');
	});
	
	return results;
}

/**
 * Renvoi la liste des vidéos demandées
 * @return
 */
function getSelectedEntries(start = 0, delta = 20) {
	var selectedKeyWords = $('#name')[0].value;
	var selectedStatut = $('#statut-projet')[0].value;
	var selectedDistricts = getSelectedMarkerElements(entityType.DISTRICT);
	var selectedThematics = getSelectedMarkerElements(entityType.THEMATIC);


	fetchData('project', projectsSelectionURL,  {
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedKeyWords : selectedKeyWords,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStatut : selectedStatut,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedDistricts : selectedDistricts,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedThematics : selectedThematics,
	}, start, delta);
}

// Attach event listener with debounce and minimum character check
$('#name').on('input', debounce(function () {
	const inputValue = $(this).val().trim();
	if (inputValue.length >= 3) {
		getSelectedEntries();
	}
}, 750));

// Lors d'une selection de statut
$('#statut-projet').change(function() {
	getSelectedEntries();
});

// Lors d'une selection d'un quartier
$("fieldset[id='districts_fieldset'] input").change(function() {
	getSelectedEntries();
});

// Lors d'une selection d'une thématique
$("fieldset[id='thematics_fieldset'] input").change(function() {
	getSelectedEntries();
});
