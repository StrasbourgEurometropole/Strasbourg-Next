function updateDescription(clickedElement) {
	var parentElement = clickedElement.parentElement
	var address = clickedElement.getAttribute("data-address");
	var detailURL = clickedElement.getAttribute("data-detailurl");
	var descriptionHtml = parentElement.querySelector('.st-description').innerHTML; // Find the description element using class name
	var title = clickedElement.querySelector('.st-title-card').textContent
	var category = clickedElement.querySelector('.st-surtitre-cat').textContent
	var date = clickedElement.querySelector('.st-date').textContent
	var location = clickedElement.querySelector('.st-location').textContent
	var imageURL =  clickedElement.querySelector('.st-image img').src
	var bookingURL = clickedElement.getAttribute("data-bookingurl")
	var dateEvent = clickedElement.getAttribute("data-date")

	var overlayDiv = document.getElementById('st-overlay-preview-agenda'); // Get the description-overlay element
	overlayDiv.setAttribute("aria-label", title);
	overlayDiv.querySelector(".st-title-overlay").textContent = title;
	overlayDiv.querySelector(".st-surtitre-cat").textContent = category;
	overlayDiv.querySelector(".st-date").textContent = dateEvent;
	overlayDiv.querySelector(".st-location").innerHTML = `${location}<br> ${address}`;
	overlayDiv.querySelector(".st-overlay__content").innerHTML = descriptionHtml;
	overlayDiv.querySelector(".detail-button").href = detailURL;
	overlayDiv.querySelector(".st-img").src = imageURL;

	if(bookingURL) {
		var elementFooter = overlayDiv.querySelector(".st-overlay__footer")
		// Remove existing booking button
		elementFooter.querySelector(".st-btn-icon.st-btn-icon--white")?.remove()
		elementFooter.insertAdjacentHTML("afterbegin", `<a href="${bookingURL}" class="st-btn-icon st-btn-icon--white" title="Biletterie">
                <span class="st-icon-ticket" aria-hidden="true"></span>
                <span class="st-sr-only">Billeterie</span>
            </a>`)
	}

}

$(document).ready(function(){
	const autocompleteElement = '#filter-autocomplete-keywords-container';
	const source = [
		'Piscine de la Kibitzenau',
		'Piscine de la Robertsau',
		'Piscine de la Meinau',
		'Piscine de la Neudorf',
		'Parking de la Kibitzenau',
		'Parking de la Robertsau',
		'Parking de la Meinau',
		'Parking de la Neudorf'
	]

	accessibleAutocomplete.enhanceSelectElement({
		selectElement: document.querySelector('#place-select'),
		id: 'filter-autocomplete-keywords', // To match it to the existing <label>.
		source: source,
		displayMenu: 'overlay',
		placeholder: 'Saisir un mot clé…',
		minLength: 3,
		showAllValues: false,
		dropdownArrow: () => '<span class="st-icon-arrow-down"></span>',
		tNoResults: () => 'Aucun résultat trouvé',
		tStatusNoResults: () => 'Aucun résultat trouvé',
		tStatusQueryTooShort: (minQueryLength) => `Tapez ${minQueryLength} caractères ou plus pour avoir des résultats`,
		tStatusSelectedOption: (selectedOption, length, index) => `${selectedOption} ${index + 1} sur ${length} sont affichés`,
		tStatusResults: (length, contentSelectedOption) => {
			const words = {
				result: (length === 1) ? 'résultat' : 'resultats',
				is: (length === 1) ? 'est' : 'sont'
			}

			return `<span>{length} {words.result} {words.is} disponible. {contentSelectedOption}</span>`
		},
		tAssistiveHint: () => 'Lorsque les résultats de la saisie semi-automatique sont disponibles, utilisez les flèches haut et bas pour les consulter et taper sur entrée pour les sélectionner. Sur les appareils tactiles, explorez les au toucher ou avec des gestes de glissement.',
	});



	
	// $('select[name=idSIGPlace]').select2({
	// 	"language": {
	// 	       "noResults": function(){
	// 	           return "Aucun résultat";
	// 	       },
	// 	       "inputTooShort": function(){
	// 	           return 'Veuillez entrer au moins 3 caractères';
	// 	       },
	// 	       "searching": function(){
	// 	           return 'Recherche ...';
	// 	       }
	// 	   },
	// 	minimumInputLength : 3,
	// 	multiple : false,
	// 	allowClear:true,
	// 	placeholder: Liferay.Language.get("eu.event-choose-place"),
	// 	ajax : {
	// 		url : "/api/jsonws/place.place/get-places-by-name-and-language/",
	// 		dataType : 'json',
	// 		delay : 250,
	// 		data : function(params) {
	// 			return {
	// 				name : params.term,
	// 				language : 'fr_FR',
	// 				p_auth : Liferay.authToken
	// 			};
	// 		},
	// 		processResults : function(data, params) {
	// 			// parse the results into the format expected by Select2
	// 			// since we are using custom formatting functions we do not need to
	// 			// alter the remote JSON data, except to indicate that infinite
	// 			// scrolling can be used
	// 			params.page = params.page || 1;
	// 			 const results = [];
	// 		     data.forEach(function makeResults(element, index) {
	// 		        results.push({
	// 		        	text: element.name.fr_FR,
	// 		        	id: element.idSurfs
	// 		        });
	// 		      });
	// 		     return {
	// 		         results: results
	// 		       };
	// 		},
	// 	},
	// 	templateResult : formatPlace,
	// 	templateSelection : formatPlaceSelection
	//
	// });
	
	function formatPlace(place) {
		const markup = `${place.text}`;
		return markup;
	}
	
	
	function formatPlaceSelection (place) {
	  return place.text;
	}




	if(idSIGPlace != null && idSIGPlace != "") {
		 var placeSelect = $('select[name=idSIGPlace]');
		 
		 Liferay.Service(
		  '/place.place/get-place-by-id-sig',
		  {
		    sigId: idSIGPlace
		  }).then(function(data) {
			 // create the option and append to Select2
		     var option = new Option(data.name.fr_FR, data.idSurfs, true, true);
		     placeSelect.append(option).trigger('change');
	
		     // manually trigger the `select2:select` event
		     placeSelect.trigger({
		         type: 'select2:select',
		         params: {
		             data: data
		         }
		     });
		  }
		);
	}
 });