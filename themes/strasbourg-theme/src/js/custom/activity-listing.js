function updateModalActivity(clickedElement) {
    var parentElement = clickedElement.parentElement
    var title = clickedElement.querySelector('.st-title-card')?.textContent;
    var categories = clickedElement.querySelector('.st-surtitre-cat')?.textContent;
    var description = clickedElement.querySelector('.st-all-text')?.textContent;
    var courseDiv = parentElement.querySelector('.cours-list')?.innerHTML


    var overlayDiv = document.getElementById('st-overlay-preview-activite');
    overlayDiv.querySelector(".st-title-overlay").textContent = title;
    overlayDiv.querySelector(".st-surtitre-cat").textContent = categories;
    overlayDiv.querySelector(".st-overlay__content .st-intro p").textContent = description;
    overlayDiv.querySelector(".st-overlay__content .cours").innerHTML = courseDiv;


    th_overlay.open('st-overlay-preview-activite');
}

function submitFilterForm(e) {
    var form = e.target;
    // remove empty fields
    form.querySelectorAll('input, select').forEach(function (input) {
        if (input.value === ''
            || input.getAttribute('name')?.startsWith('_com_liferay_portal_search_web_category_facet_portlet_CategoryFacetPortlet')
            || input.getAttribute('name')?.startsWith('_com_liferay_portal_search_web_search_bar_portlet_SearchBarPortlet')
        ) {
            // remove name attribute to prevent server side processing
            input.removeAttribute('name');
        }
    });
    return true;
}