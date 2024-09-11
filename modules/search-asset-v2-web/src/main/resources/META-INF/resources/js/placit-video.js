// Initialisation des variables de références
var videos = null;

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
function getSelectedEntries() {
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

	AUI().use('aui-io-request', function(A) {
		A.io.request(videosSelectionURL, {
			method : 'post',
			dataType: 'json',
			data : {
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
			},
			on: {
                success: function(e) {
                	var data = this.get('responseData');
                	getResult('video', data);                               	
			 	}
			}
		});
	});	
}

// Lors d'une recherche par mots clés
$('#name').on('input',function() {
	getSelectedEntries();
});

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
