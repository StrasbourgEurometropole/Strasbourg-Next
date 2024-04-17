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
		elementFooter.insertAdjacentHTML("afterbegin",
		`<a href="${bookingURL}" class="st-btn-icon st-btn-icon--white" title="`+ Liferay.Language.get("eu.ticket-office") + `">
                <span class="st-icon-ticket" aria-hidden="true"></span>
                <span class="st-sr-only">` + Liferay.Language.get("eu.ticket-office") + `</span>
            </a>`)
	}

}

window.selects = new Array();

$(document).ready(function(){







	
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
		var placeSelectBarre = $('select#place-selectBarre');
		 
		 Liferay.Service(
		  '/place.place/get-place-by-id-sig',
		  {
		    sigId: idSIGPlace
		  },function(data) {
				 // create the option and append to Select2
				 var option = new Option(data.name.fr_FR, data.idSurfs, true, true);
				 placeSelect.append(option);
				 placeSelectBarre.append(option);
				 initPlaceSelect();
			 }

			 );
	}
	else {
		initPlaceSelect();
	}

	function initPlaceSelect() {
		const selectAutocomplete = document.querySelectorAll('select.select-place');

		selectAutocomplete.forEach(select => {
			var selectAutocompleteClass = new Select(select, {
				onChange: function (selectClass, optionIndex) {
					if(typeof selectPlaceA11yOnChange !== 'undefined'){
						selectPlaceA11yOnChange(selectClass, optionIndex);
					}
				},

				onSearch: async function (searchTerm) {
					// Send GET request to get places with json
					// /api/jsonws/place.place/get-places-by-name-and-language/

					const response = await fetch(`/api/jsonws/place.place/get-places-by-name-and-language/?name=${searchTerm}&language=fr_FR&p_auth=${Liferay.authToken}`).then(response => response.json());
					const results = response.map(place => {
						return {
							value: place.idSurfs,
							label: place.name.fr_FR
						}
					})
					return results;
				}
			});

			window.selects.push(selectAutocompleteClass);
		});
	}


	function selectPlaceA11yOnChange (selectClass, optionIndex) {
		var select = selectClass
		var id = select.id
		// check if the id the Barre at the end of the id
		if(id.indexOf("Barre") > -1) {
			// get the id of the filter`
			var filterId = id.replace("Barre", "");
			// get the filter
			window.selects.forEach(function (selectA11y) {
				if(selectA11y.id == filterId) {
					removeOptions(selectA11y.el);
					selectA11y.suggestions = [];
					selectA11y.el.options.add(new Option(select.el.options[optionIndex].text, select.el.options[optionIndex].value, true, true));
					selectA11y._toggleSelection(0, true, false);
				}
			});

		}
		else {
			// get the id of the filter
			var filterId = id + "Barre";
			// get the filter
			window.selects.forEach(function (selectA11y) {
				if(selectA11y.id == filterId) {
					removeOptions(selectA11y.el);
					selectA11y.suggestions = [];
					selectA11y.el.options.add(new Option(select.el.options[optionIndex].text, select.el.options[optionIndex].value, true, true));
					selectA11y._toggleSelection(0, true, false);
				}
			});
		}
	}


	function removeOptions(selectElement) {
		var i, L = selectElement.options.length - 1;
		for(i = L; i >= 0; i--) {
			selectElement.remove(i);
		}
	}
 });