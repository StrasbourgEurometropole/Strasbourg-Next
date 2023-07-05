// Scripts pour ajouter ou supprimer la classe "no-scroll"
function addNoScroll() {
    if (!document.body.classList.contains("st-no-scroll")) {
        document.body.classList.add("st-no-scroll")
    }
}

function removeNoScroll() {
    if (document.body.classList.contains("st-no-scroll") && !$(th_overlay.selector_overlay_fiche_sit).hasClass('open')) {
        document.body.classList.remove("st-no-scroll");
    }
}

th_overlay.addCallbackOpen(addNoScroll);
th_overlay.addCallbackClose(removeNoScroll);