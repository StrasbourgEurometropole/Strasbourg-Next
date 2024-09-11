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
