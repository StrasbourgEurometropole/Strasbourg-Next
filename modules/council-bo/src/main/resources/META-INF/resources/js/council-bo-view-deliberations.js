jQuery(function() {
    // Cache du sélecteur de delta
    $(".pagination-items-per-page").hide();

    document.addEventListener('focusin', function() {

// Get the value of the specific query parameter
        const deliberationId = getQueryParam("_eu_strasbourg_portlet_council_CouncilBOPortlet_deliberationId");

// Scroll the element with the obtained ID into view
        if (deliberationId && deliberationId !== "") {
            scrollElementIntoViewById("delib-" + deliberationId);
        }
    }, { once: true });


});


// Function to get the value of a query parameter from the URL
function getQueryParam(param) {
    const urlParams = new URLSearchParams(window.location.search);
    return urlParams.get(param);
}

// Function to scroll the element into view
function scrollElementIntoViewById(id) {
    const element = document.getElementById(id);
    if (element) {
        element.scrollIntoView({ behavior: 'smooth', block: 'center' });
    }
}

