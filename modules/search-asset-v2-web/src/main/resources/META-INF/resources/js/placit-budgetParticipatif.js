// Initialisation des variables de références
var projetsBP = null;

var entityType = {
	BP_STATUS : 'vocabulary_0',
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
 * Renvoi la liste des projets bp demandés
 * @return
 */
function getSelectedEntries(start = 0) {
	var delta = 20;
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
	var selectedBPStatus = getSelectedMarkerElements(entityType.BP_STATUS);
	var selectedDistricts = getSelectedMarkerElements(entityType.DISTRICT);
	var selectedThematics = getSelectedMarkerElements(entityType.THEMATIC);

	AUI().use('aui-io-request', function(A) {
		A.io.request(budgetParticipatifsSelectionURL, {
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
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedBPStatus : selectedBPStatus,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedDistricts : selectedDistricts,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_selectedThematics : selectedThematics,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_start : start,
				_eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_delta : delta,
			},
			on: {
				success: function(e) {
					var data = this.get('responseData');
					getBudgetParticipatifResult('budget', data, start, delta);
				}
			}
		});
	});
}

// Debounce function
function debounce(func, delay) {
	let timeout;
	return function (...args) {
		const context = this;
		clearTimeout(timeout);
		timeout = setTimeout(() => func.apply(context, args), delay);
	};
}

// Attach event listener with debounce and minimum character check
$('#name').on('input', debounce(function () {
	const inputValue = $(this).val().trim();
	if (inputValue.length >= 3) {
		getSelectedEntries();
	}
}, 1000)); // 1 seconds delay

// Lors d'une selection d'état
$("fieldset[id='bp_status_fieldset'] input").change(function() {
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


// Function copied from custom.js from placit theme TODO refactorise this
/**
 * Retoune le résultat
 */
function getBudgetParticipatifResult(searchPage, data, start, delta) {
	if(data != null) {
		var totalElements = data.total
		// afficahge résultat
		var proListing = $('.pro-listing-' + searchPage);
		var row = proListing.data('row');
		proListing.html('');
		var listing;
		if (row == true) {
			listing = '<div class="row pro-wi-grid unstyled" data-page="1">';
		} else {
			listing = '<div class="pro-wi-grid unstyled" data-page="1">';
		}
		var indexGrid = 2;
		$.each(data.entries, function (index, json) {
			if (index > 0 && index % delta == 0) {
				if (row == true) {
					listing += '</div><div class="row pro-wi-grid hidden unstyled" data-page="' + indexGrid + '">';
				} else {
					listing += '</div><div class="pro-wi-grid hidden unstyled" data-page="' + indexGrid + '">';
				}
				indexGrid++;
			}

			if (json.class == "eu.strasbourg.service.video.model.Video") {
				listing += createVideo(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.Project") {
				listing += createProject(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.Participation") {
				listing += createParticipation(json.json);
			}

			if (json.class == "eu.strasbourg.service.agenda.model.Event") {
				listing += createAgenda(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.Petition") {
				listing += createPetition(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.SaisineObservatoire") {
				listing += createSaisineObservatoire(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.BudgetParticipatif") {
				listing += createBudgetParticipatif(json.json);
			}

			if (json.class == "eu.strasbourg.service.project.model.Initiative") {
				listing += createInitiative(json.json);
			}

			if (json.class == "com.liferay.journal.model.JournalArticle") {

				if (searchPage == "project-workshop") {
					listing += createProjectWorkshop(json.json);
				} else {
					listing += createNews(json.json);
				}
			}

		});
		listing += '</div>';
		$('.pro-listing-' + searchPage).html(listing);

		// gestion de la pagination
		// selecteur de page + Label
		selecteur = '';
		if (totalElements > delta) {
			let currentPageIndex = Math.floor(start / delta) + 1;
			let selecteur = `
				<form method="get">
					<select id="change-page" name="change-page">
    		`;

			const totalPages = Math.ceil(totalElements / delta);

			// Generate options for all pages
			for (let indexPage = 1; indexPage <= totalPages; indexPage++) {
				const isLastPage = indexPage === totalPages;
				const nbEntitesRestantes = totalElements % delta;

				selecteur += `
					<option value="${indexPage}" ${currentPageIndex == indexPage ? "selected" : ""}>
						Page ${indexPage}
					</option>
				`;
			}

			// Close the select and form
			selecteur += `
            </select>
        </form>
     `;


			selecteur += '<p class="hidden-xs"></p>';

			$('.pro-pagination .pull-left').html(selecteur);
			$('#change-page').selectric();

			// Determine disabled states
			const isFirstDisabled = start === 0;
			const isLastDisabled = (start + delta) >= totalElements;

			link = `
				<ul>
					<!-- Lien vers la premiere page -->
					<li class="${isFirstDisabled ? 'pro-disabled' : ''}">
						<a href="#go-to-top" 
						   class="hidden-sm hidden-xs pro-first" 
						   title="Lien vers la premiere page du Listing" 
						   data-action="first">Premier</a>
					</li>
					<!-- Lien vers la page precedente -->
					<li class="${isFirstDisabled ? 'pro-disabled' : ''}">
						<a href="#go-to-top" 
						   title="Lien vers la page precedente du Listing" 
						   data-action="prev">Précédent</a>
					</li>
					<!-- Lien vers la page suivante -->
					<li class="${isLastDisabled ? 'pro-disabled' : ''}">
						<a href="#go-to-top" 
						   title="Lien vers la page suivante du Listing" 
						   data-action="next">Suivant</a>
					</li>
					<!-- Lien vers la derniere page -->
					<li class="${isLastDisabled ? 'pro-disabled' : ''}">
						<a href="#go-to-top" 
						   class="hidden-sm hidden-xs pro-last" 
						   title="Lien vers la derniere page du Listing" 
						   data-action="last">Dernier</a>
					</li>
				</ul>
			`;


			$('.pro-pagination .pull-right').html(link);
			const endIndex = Math.min(start + delta, totalElements);
			// Update pagination text
			const pageResult = `Affichage des résultats ${
				totalElements > 0 ? start + 1 : 0
			} - ${endIndex} parmi ${totalElements}`;
			$('.pro-pagination .pull-left .hidden-xs').text(pageResult);

			buildBudgetParticipatifPaginate(start, delta, totalElements);
		}
	}
}

function buildBudgetParticipatifPaginate(start, delta, totalElements) {
	$('.pro-search-listing').each(function (index, widget) {
		const wi = {
			$widget: $(widget),
			$list: $(widget).find('.pro-wi-grid'),
			$items: $(widget).find('.vignette'),
			itemsCount: totalElements,
			pageCount: Math.ceil(totalElements / delta),
		};

		let currentPageIndex = Math.floor(start / delta) + 1;

		// Navigate to a specific page
		const goToPage = (pageIndex) => {
			if (pageIndex < 1 || pageIndex > wi.pageCount) return;

			currentPageIndex = pageIndex;

			const startIndex = (currentPageIndex - 1) * delta;

			getSelectedEntries(startIndex)


		};

		// Event handlers
		wi.$widget.find('[data-action="first"]').on('click', () => goToPage(1));
		wi.$widget.find('[data-action="prev"]').on('click', () => goToPage(currentPageIndex - 1));
		wi.$widget.find('[data-action="next"]').on('click', () => goToPage(currentPageIndex + 1));
		wi.$widget.find('[data-action="last"]').on('click', () => goToPage(wi.pageCount));
		wi.$widget.find('#change-page').on('change', function () {
			const targetPage = parseInt($(this).val(), 10);
			goToPage(targetPage);
		});
	});

	// Refresh links of thumbnails (assumes `th_linkAll` is defined elsewhere)
	th_linkAll();
}