// Initialisation des variables de références
var agendas = null;

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
 * Renvoi la liste des événements demandés
 * @return
 */
async function getSelectedEntries(start = 0, delta = 20) {
	var selectedKeyWords = $('#name')[0].value;

    var selectedStartDay ;
    var selectedStartMonth ;
    var selectedStartYear;
    var selectedEndDay;
    var selectedEndMonth ;
    var selectedEndYear;
	if($('.pro-facette-date').length > 0){
        selectedStartDay = $('input[data-name="fromDay"]')[0].value;
        selectedStartMonth = $('input[data-name="fromMonth"]')[0].value;
        selectedStartYear = $('input[data-name="fromYear"]')[0].value;
        selectedEndDay = $('input[data-name="toDay"]')[0].value;
        selectedEndMonth = $('input[data-name="toMonth"]')[0].value;
        selectedEndYear = $('input[data-name="toYear"]')[0].value;
	}
	var selectedProject = $('#projet')[0].value;
	var selectedDistricts = getSelectedMarkerElements(entityType.DISTRICT);
	var selectedThematics = getSelectedMarkerElements(entityType.THEMATIC);


	await fetchData('agenda',agendasSelectionURL,  {
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedKeyWords : selectedKeyWords,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartDay : selectedStartDay,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartMonth : selectedStartMonth,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartYear : selectedStartYear,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndDay : selectedEndDay,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndMonth : selectedEndMonth,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndYear : selectedEndYear,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedProject : selectedProject,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedDistricts : selectedDistricts,
		_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedThematics : selectedThematics,
	}, start, delta);

	updateLeafletMap();
}

// Attach event listener with debounce and minimum character check
$('#name').on('input', debounce(function () {
	const inputValue = $(this).val().trim();
	if (inputValue.length >= 3) {
		getSelectedEntries();
	}
}, 750));

// Lors d'une selection de projet
$('#projet').change(function() {
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



// Initialisation des "pointeurs" vers les elements utiles
var leafletMap = null;
var markersCluster = null;
eventMarkers = [];

// Mettre à jour 
function updateLeafletMap () {
	eventMarkers = [];
	markersCluster.clearLayers();
	
	$('.pro-bloc-listing-event > form  a').each(function () {		
		var mercators = [$(this).data('lat'), $(this).data('lng')];
		
		if (mercators[0] != "0" && mercators[1] != "0") {
			var link = $(this).attr('href');
			var publishDate = $('time', this).text();
			var place = $('p', this).text();
			var title = $('h3', this).text();
			
			var marker = getEventListingMarker(mercators, link, publishDate, place, title);
			
			markersCluster.addLayer(marker);
			
			eventMarkers.push(eventMarkers);
		}
	});
	
}

$(document).ready(function() {

    // Gestion de la carte interactive

    //Création de la carte au centre de strasbourg
    leafletMap = leafletMap = getLeafletMap();
    
    // Création du cluster permettant le regroupement de points et le centrage
    markersCluster = L.markerClusterGroup();
    
	leafletMap.addLayer(markersCluster);
    
    // Récuperation et placement des points
    updateLeafletMap();

});