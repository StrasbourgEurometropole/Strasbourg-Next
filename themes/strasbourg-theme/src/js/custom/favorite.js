function addEvent(parent, evt, selector, handler) {
    parent.addEventListener(evt, function(event) {
        if (event.target.matches(selector + ', ' + selector + ' *')) {
            handler.apply(event.target.closest(selector), arguments);
        }
    }, false);
}


// Add favorite
function toggleFavorite(element, isLegacy = false) {
    var favoriteToAdd = {
        title: element.getAttribute("data-title"),
        url: element.getAttribute("data-url"),
        typeId: element.getAttribute("data-type"),
        entityId: element.getAttribute("data-id"),
        entityGroupId: element.getAttribute("data-groupId")
    };
    if(isLegacy) {
        favoriteToAdd = {
            title: element.getAttribute("data-title"),
            url: element.getAttribute("data-url"),
            typeId: element.getAttribute("data-type"),
            entityId: element.getAttribute("data-id"),
            entityGroupId: 0
        };
    }

    th_overlay.focusElOnClose["st-overlay-alert"] = element;

    // check if it is already in the favorites by checking if st-is-favorite class is present
    if (element.classList.contains('st-is-favorite')) {
        // remove from favorites
        Liferay.Service(
            '/favorite.favorite/delete-favorite-link',
            favoriteToAdd,
            function(obj) {
                if (obj.hasOwnProperty('success')) {
                    // remove class st-is-favorite
                    element.classList.remove('st-is-favorite');
                    //set aria-preesed to false
                    element.ariaPressed = false;
                    element.textContent = Liferay.Language.get("eu.add-to-favorite");
                } else if (obj.hasOwnProperty('error')) {
                    if (obj['error'] == 'notConnected') {
                        createConfirmationDialog(Liferay.Language.get('log-in-to-add-favorite'), "", Liferay.Language.get('eu.login'), Liferay.Language.get('eu.cancel'), function() {
                            window.location = window.loginURL;
                        },true);
                    }
                    else {
                        console.error(obj['error']);
                        createDialog(Liferay.Language.get('error-occured'));
                    }
                }
            }
        );}
        else {
            Liferay.Service(
                '/favorite.favorite/add-favorite-link',
                favoriteToAdd,
                function(obj) {
                    if (obj.hasOwnProperty('success')) {
                        element.classList.add('st-is-favorite');
                        //set aria-preesed to true
                        element.ariaPressed = true;
                        element.textContent = Liferay.Language.get('eu.remove-from-favorite');
                    } else if (obj.hasOwnProperty('error')) {
                        if (obj['error'] == 'notConnected') {
                            createConfirmationDialog(Liferay.Language.get('log-in-to-add-favorite'), "", Liferay.Language.get('eu.login'), Liferay.Language.get('eu.cancel'), function() {
                                window.location = window.loginURL;
                            },true);
                        }
                        else {
                            console.error(obj['error']);
                            createDialog(Liferay.Language.get('error-occured'));
                        }
                    }
                }
            );
        }

}

// add click event to all favorite buttons with button.st-btn-favorite-card in document ready in pure js
document.addEventListener("DOMContentLoaded", function() {
    addClickEventToFavoriteButtons();
});



function addClickEventToFavoriteButtons() {
    document.querySelectorAll("button.st-btn-favorite-card, button.st-btn-favorite-sticky").forEach(function(element) {
        element.removeEventListener("click", addClickEventToFavoriteButtonsNoLegacy);
        element.addEventListener("click", addClickEventToFavoriteButtonsNoLegacy);
    });


    addEvent(document, 'click', '#aroundme .add-favorites', function(e) {
        console.log(e)
        console.log(this)
        // prevent default behavior
        e.preventDefault();
        e.stopPropagation();
        toggleFavorite(this, true);
    })
}

function addClickEventToFavoriteButtonsNoLegacy(e) {
    // prevent default behavior
    e.preventDefault();
    e.stopPropagation();
    toggleFavorite(this);
}