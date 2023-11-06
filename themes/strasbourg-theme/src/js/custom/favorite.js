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
                }
            }
        );}
        else {
            Liferay.Service(
                '/favorite.favorite/add-favorite-link',
                favoriteToAdd,
                function(obj) {
                    if (obj.hasOwnProperty('success')) {
// add class st-is-favorite
                        element.classList.add('st-is-favorite');
                    }
                }
            );
        }

}

// add click event to all favorite buttons with button.st-btn-favorite-card in document ready in pure js
document.addEventListener("DOMContentLoaded", function() {
    document.querySelectorAll("button.st-btn-favorite-card").forEach(function(element) {
        element.addEventListener("click", function(e) {
            // prevent default behavior
            e.preventDefault();
            e.stopPropagation();
            toggleFavorite(element);
        });
    });
});
