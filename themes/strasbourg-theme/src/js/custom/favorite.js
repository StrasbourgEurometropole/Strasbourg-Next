// Add favorite
function toggleFavorite(element) {
    var favoriteToAdd = {
        title: element.getAttribute("data-title"),
        url: element.getAttribute("data-url"),
        typeId: element.getAttribute("data-type"),
        entityId: element.getAttribute("data-id"),
        entityGroupId: element.getAttribute("data-groupId")
    };
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
                } else if (obj.hasOwnProperty('error')) {
                    if (obj['error'] == 'notConnected') {
                        createConfirmationDialog(Liferay.Language.get('log-in-to-add-favorite'), "", Liferay.Language.get('eu.login'), Liferay.Language.get('eu.cancel'), function() {
                            window.location = window.loginURL;
                        });
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
                    } else if (obj.hasOwnProperty('error')) {
                        if (obj['error'] == 'notConnected') {
                            createConfirmationDialog(Liferay.Language.get('log-in-to-add-favorite'), "", Liferay.Language.get('eu.login'), Liferay.Language.get('eu.cancel'), function() {
                                window.location = window.loginURL;
                            });
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
    document.querySelectorAll("button.st-btn-favorite-card").forEach(function(element) {
        element.addEventListener("click", function(e) {
            // prevent default behavior
            e.preventDefault();
            e.stopPropagation();
            toggleFavorite(element);
        });
    });
}