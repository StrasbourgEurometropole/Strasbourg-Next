function createDialog(title, description = "", buttonLabel = "OK") {
    document.getElementById("alert-title").innerHTML = title;
    document.getElementById("alert-description").innerHTML = description;
    document.getElementById("alert-action").innerHTML = createActionButton("alert-confirm", buttonLabel);
    th_overlay.open("st-overlay-alert");
}

function createActionButton(id, label = "", isSecondary = false, closeOnClick = true) {
    return `
    <div class="st-col-6">
        <button class="st-btn st--btn-full-width ${isSecondary ? "st--btn-secondary" : ""}" 
                ${closeOnClick ? "data-overlay-close='st-overlay-alert'" : ""}
                id="${id}" ${closeOnClick ? `onclick='th_overlay.close("st-overlay-alert")'` : ""}>
            ${label}
        </button>
    </div>
`;
}

function createConfirmationDialog(title, description = "", buttonLabel = "OK", buttonLabelCancel = "Annuler", callbackConfirm = undefined) {
    document.getElementById("alert-title").innerHTML = title;
    document.getElementById("alert-description").innerHTML = description;
    document.getElementById("alert-action").innerHTML = "";
    // Add confirm and cancel buttons to the div alert-action
    document.getElementById("alert-action").innerHTML += createActionButton("alert-confirm", buttonLabel, false, false);
    document.getElementById("alert-action").innerHTML += createActionButton("alert-cancel", buttonLabelCancel, true, true);
    // Add click event to confirm button
    document.getElementById("alert-confirm").addEventListener("click", callbackConfirm);
    th_overlay.open("st-overlay-alert");
}