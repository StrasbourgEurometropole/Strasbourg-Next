function updateModalOfficial(clickedElement) {
	var parentElement = clickedElement.parentElement
	var fullName = clickedElement.querySelector('.st-title-card')?.textContent;
	var roleCity = clickedElement.querySelector('.st-role')?.textContent;
	var roleEMS = clickedElement.querySelector('.st-surtitre-cat')?.textContent; // Find the description element using class name
	var descriptionDiv = parentElement.querySelector('.st-description')?.innerHTML
	var detailURL = clickedElement.getAttribute("data-detailurl");
	var mailAddress = clickedElement.getAttribute("data-mailaddress");
	var imageURL = clickedElement.querySelector('.st-image img')?.src

	var overlayDiv = document.getElementById('st-overlay-preview-person'); // Get the description-overlay element
	overlayDiv.setAttribute("aria-label", fullName);
	overlayDiv.querySelector(".st-title-overlay").textContent = fullName;
	overlayDiv.querySelector(".st-surtitre-cat").textContent = roleEMS;
	overlayDiv.querySelector(".st-role").textContent = roleCity;
	overlayDiv.querySelector(".st-overlay__content").innerHTML = descriptionDiv;
	if(mailAddress != "") {
		overlayDiv.querySelector(".mail-button").href = mailAddress;
	} else {
		overlayDiv.querySelector(".mail-button").classList.add("st-hide");
	}
	overlayDiv.querySelector(".detail-button").href = detailURL;
	overlayDiv.querySelector(".st-image img").src = imageURL;
}

function synchroniseFilter() {
	// synchroise both elements at change
	var sourceElements = document.querySelectorAll('#st-overlay-filters .st-overlay__inner .st-group-field');
	sourceElements.forEach(function (sourceElement) {
		var inputElement = sourceElement.querySelector('input, select');
		var name = inputElement.getAttribute('name');
		var destinationElement = document.querySelector('.st-barre-listing-sit .st-barre-inner.st-wrapper.form-styles [data-name="' + name + '"]');
		if(!destinationElement) {
			return;
		}
		inputElement.addEventListener('change', function () {
			destinationElement.value = inputElement.value;
		});
		// also trigger change event on destination element, but change on inputElement
		destinationElement.addEventListener('change', function () {
			inputElement.value = destinationElement.value;
		});
	});
}

document.addEventListener("DOMContentLoaded", function() {
	synchroniseFilter();
});
