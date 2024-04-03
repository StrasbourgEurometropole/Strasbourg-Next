function updateModalActivity(clickedElement) {
	var parentElement = clickedElement.parentElement
	var title = clickedElement.querySelector('.st-title-card')?.textContent;
	var categories = clickedElement.querySelector('.st-surtitre-cat')?.textContent;
	var description = clickedElement.querySelector('.st-text')?.textContent;
	var courseDiv = parentElement.querySelector('.cours-list')?.innerHTML

	var overlayDiv = document.getElementById('st-overlay-preview-activite');
	// set attributes
	overlayDiv.setAttribute("aria-label", title);
	overlayDiv.querySelector(".st-title-overlay").textContent = title;
	overlayDiv.querySelector(".st-surtitre-cat").textContent = categories;
	overlayDiv.querySelector(".st-overlay__content .st-intro p").textContent = description;
	overlayDiv.querySelector(".st-overlay__content .cours").innerHTML = courseDiv;
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
