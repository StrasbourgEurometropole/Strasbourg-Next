function updateModalActivity(clickedElement) {
    var parentElement = clickedElement.parentElement
    var title = clickedElement.querySelector('.st-title-card')?.textContent;
    var categories = clickedElement.querySelector('.st-surtitre-cat')?.textContent;
    var description = clickedElement.querySelector('.st-text')?.textContent;
    var courseDiv = parentElement.querySelector('.cours-list')?.innerHTML


    var overlayDiv = document.getElementById('st-overlay-preview-activite');
    overlayDiv.querySelector(".st-title-overlay").textContent = title;
    overlayDiv.querySelector(".st-surtitre-cat").textContent = categories;
    overlayDiv.querySelector(".st-overlay__content .st-intro p").textContent = description;
    overlayDiv.querySelector(".st-overlay__content .cours").innerHTML = courseDiv;

}