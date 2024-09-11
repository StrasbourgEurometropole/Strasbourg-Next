function createDialog(title, description = "", buttonLabel = "OK") {
    document.getElementById("alert-title").innerHTML = title;
    document.getElementById("alert-description").innerHTML = description;
    document.getElementById("alert-action").innerHTML = createActionButton("alert-confirm", buttonLabel);
    th_overlay.open("st-overlay-alert");
}

function createActionButton(id, label = "", isSecondary = false, closeOnClick = true, isLink = false) {
    return `
    <div class="st-col-6">
        <${isLink ? "a href='#'" : "button"} class="st-btn st--btn-full-width ${isSecondary ? "st--btn-secondary" : ""}" 
                ${closeOnClick ? "data-overlay-close='st-overlay-alert'" : ""}
                id="${id}" ${closeOnClick ? `onclick='th_overlay.close("st-overlay-alert")'` : ""}>
            ${label}
        </${isLink ? "a" : "button"}>
    </div>
`;
}

function createConfirmationDialog(title, description = "", buttonLabel = "OK", buttonLabelCancel = "Annuler", callbackConfirm = undefined , isLink = false) {
    document.getElementById("alert-title").innerHTML = title;
    document.getElementById("alert-description").innerHTML = description;
    document.getElementById("alert-action").innerHTML = "";
    // Add confirm and cancel buttons to the div alert-action
    document.getElementById("alert-action").innerHTML += createActionButton("alert-confirm", buttonLabel, false, false, isLink);
    document.getElementById("alert-action").innerHTML += createActionButton("alert-cancel", buttonLabelCancel, true, true);
    // Add click event to confirm button
    document.getElementById("alert-confirm").addEventListener("click", callbackConfirm);
    th_overlay.open("st-overlay-alert");
}

// function that simulate on click event when onkeydown event is triggered (this is called by onkeydown event)
function simulateClick(event) {
    // if the key is enter or space
    if (event.keyCode === 13 || event.keyCode === 32) {
        event.target.click();
    }
}