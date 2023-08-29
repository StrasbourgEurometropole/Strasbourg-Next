function updateDescription(clickedElement) {
	var parentElement = clickedElement.parentElement
	var descriptionHtml = parentElement.querySelector('.st-description').innerHTML; // Find the description element using class name
	var title = clickedElement.querySelector('.st-title-card').textContent
	var category = clickedElement.querySelector('.st-surtitre-cat').textContent
	var date = clickedElement.querySelector('.st-date').textContent
	var location = clickedElement.querySelector('.st-location').textContent
	var imageURL =  clickedElement.querySelector('.st-img').src
	var bookingURL = clickedElement.getAttribute("data-bookingurl")

	var overlayDiv = document.getElementById('st-overlay-preview-agenda'); // Get the description-overlay element
	overlayDiv.querySelector(".st-title-overlay").textContent = title;
	overlayDiv.querySelector(".st-surtitre-cat").textContent = category;
	overlayDiv.querySelector(".st-date").textContent = date;
	overlayDiv.querySelector(".st-location").textContent = location;
	overlayDiv.querySelector(".st-overlay__content").innerHTML = descriptionHtml;
	overlayDiv.querySelector(".st-img").src = imageURL;
	if(bookingURL) {
		var elementFooter = overlayDiv.querySelector(".st-overlay__footer")
		elementFooter.insertAdjacentHTML("afterbegin", `<a href="${bookingURL}" class="st-btn-icon st-btn-icon--white" title="Biletterie">
                <span class="st-icon-ticket" aria-hidden="true"></span>
            </a>`)
	}

}

$(document).ready(function(){
	
	$('select[name=idSIGPlace]').select2({
		"language": {
		       "noResults": function(){
		           return "Aucun résultat";
		       },
		       "inputTooShort": function(){
		           return 'Veuillez entrer au moins 3 caractères';
		       },
		       "searching": function(){
		           return 'Recherche ...';
		       }
		   },
		minimumInputLength : 3,
		multiple : false,
		allowClear:true,
		placeholder: Liferay.Language.get("eu.event-choose-place"),
		ajax : {
			url : "/api/jsonws/place.place/get-places-by-name-and-language/",
			dataType : 'json',
			delay : 250,
			data : function(params) {
				return {
					name : params.term,
					language : 'fr_FR',
					p_auth : Liferay.authToken
				};
			},
			processResults : function(data, params) {
				// parse the results into the format expected by Select2
				// since we are using custom formatting functions we do not need to
				// alter the remote JSON data, except to indicate that infinite
				// scrolling can be used
				params.page = params.page || 1;
				 const results = [];
			     data.forEach(function makeResults(element, index) {
			        results.push({
			        	text: element.name.fr_FR,
			        	id: element.idSurfs
			        });
			      });
			     return {
			         results: results
			       };
			},
		},
		templateResult : formatPlace,
		templateSelection : formatPlaceSelection
	
	});
	
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