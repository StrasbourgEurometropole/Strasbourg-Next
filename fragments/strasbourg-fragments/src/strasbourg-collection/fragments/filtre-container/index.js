if(document.getElementsByClassName('has-edit-mode-menu').length != 0) {
	var overlay = fragmentElement.querySelector("#st-overlay-filters")
overlay.className = "";
																																			}

    // get all the .st-filtre elements and clone them
    var filterElements = [...fragmentElement.querySelectorAll('#zone-bar .st-filtre')].map((filterElement) => filterElement.cloneNode(true)).reverse()
    // remove their name attribute and put it in data-name attribute
    filterElements.forEach(function (filterElement) {
        var inputElement = filterElement.querySelector('input, select');
        var name = inputElement.getAttribute('name');
        inputElement.setAttribute('data-name', name);
        inputElement.removeAttribute('name');
    });
    // copy them all to element with class st-barre-listing-sit
    var destinationElement = fragmentElement.querySelector('.st-barre-listing-sit .st-barre-inner.st-wrapper.form-styles');
    filterElements.forEach(function (filterElement) {
        destinationElement.prepend(filterElement.cloneNode(true));
    });

 // synchroise both elements at change
    var sourceElements = fragmentElement.querySelectorAll('#zone-bar .st-filtre');
    sourceElements.forEach(function (sourceElement) {
        var inputElement = sourceElement.querySelector('input, select');
			var name = inputElement.getAttribute('name');
        var destinationElement = document.querySelector('.st-barre-listing-sit .st-barre-inner.st-wrapper.form-styles [data-name="' + name + '"]');
        inputElement.addEventListener('change', function () {
            

            destinationElement.value = inputElement.value;
           
        });
        // also trigger change event on destination element, but change on inputElement
        destinationElement.addEventListener('change', function () {
            console.log('change');
            inputElement.value = destinationElement.value;
        });
    });

// function when submitting form