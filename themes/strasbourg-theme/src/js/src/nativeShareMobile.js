/**
 * Permet d'afficher la popin de partage social des téléphones quand compatible
 * Si non compatible, comportement classique
 *
 */
if (typeof navigator.share !== 'undefined') {

    // selecteur a adapté suivant le site
    $('input,label,a', '.social-share').on('click', function (e) {

        e.preventDefault();
        e.stopPropagation();

        var descriptionEl = document.querySelector('meta[name="description"]');
        var description = "";
        if (descriptionEl) {
            description = descriptionEl.getAttribute("content");
        }
        var shareData = {
            title: document.title,
            text: description,
            url: document.location.href
        };
        try {
            navigator.share(shareData);
        } catch (e) {
            console.log('erreur de partage', e);
        }

    });

}