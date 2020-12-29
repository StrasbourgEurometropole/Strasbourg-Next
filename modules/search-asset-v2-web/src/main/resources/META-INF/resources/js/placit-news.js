// Initialisation des variables de références
var news = null;

var entityType = {
	THEMATIC : 'vocabulary_0',
	DISTRICT : 'vocabulary_1',
}

var sortField = "publishDate_sortable";
var sortType = "ASC";


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
	var selectedThematics = getSelectedMarkerElements(entityType.THEMATIC);
	var selectedDistricts = getSelectedMarkerElements(entityType.DISTRICT);

	AUI().use('aui-io-request', function(A) {
		A.io.request(newsSelectionURL, {
			method : 'post',
			dataType: 'json',
			data : {
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartDay : selectedStartDay,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartMonth : selectedStartMonth,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedStartYear : selectedStartYear,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndDay : selectedEndDay,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndMonth : selectedEndMonth,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedEndYear : selectedEndYear,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedThematics : selectedThematics,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedDistricts : selectedDistricts,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_sortFieldAndType : sortField + ',' + sortType,
			},
			on: {
                success: function(e) {
                	var data = this.get('responseData');
                	getResult('news', data);
                    //Force la premiere tuille à  prendre deux fois plus de place en hauteur de largeur
                    $('.pro-wi-grid .col-md-3.col-sm-6.col-xs-12:first-child').removeClass('col-md-3').removeClass('col-sm-6').addClass('col-md-6').addClass('col-sm-12');
                    $('.pro-wi-grid .col-md-6.col-sm-12.col-xs-12 .pro-bloc-actu').addClass('pro-bloc-actu-large');
                    $('.pro-listing .pro-wi-grid>*').css('margin', '20px 0px');

                    egalizeAll();
			 	}
			}
		});
	});
}

// Lors d'une selection d'une thématique
$("fieldset[id='thematics_fieldset'] input").change(function() {
	getSelectedEntries();
});

// Lors d'une selection d'un quartier
$("fieldset[id='districts_fieldset'] input").change(function() {
	getSelectedEntries();
});

// Permet le tri des vidéos
function sortVideo(type) {
    sortType = type;
    // change l'affichage du tri
    if(type == "ASC"){
        $('#sortType').text = "Tri A-Z";
    }else{
        $('#sortType').text = "Tri Z-A";
    }
    getSelectedEntries();
}
