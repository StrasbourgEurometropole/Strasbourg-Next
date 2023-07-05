//spécificités listing Agenda
parseCardAgendaClickOverlay();

// OVERLAY MAP
function callbackMapOverlayMap(macarte) {
    macarte.zoomControl.setPosition('topleft');
}


// PAGE LISTING SIT
function callbackMapPageListingLEI(macarte) {
    macarte.zoomControl.setPosition('topright');
}


// listing SIT classique - uniquement une map en overlay
var listingSitDefault = new thListingManager({
    selectors: {
        mapoverlay: '.js-listing-overlay-map',
    },
    mapOptions: {
        onlyDesktop: true,
    },
    mapOverlayOptions: {
        onlyMobile: false,
    },
    // update_form: true, // permet de mettre à jour les valeurs de formulaire en fonction du filtrage utilisateur
    afterUpdate: function () {
        // si composant favoris :
        // th_favoris.parseItems();
        // th_favoris.addEvents();
        // $('.facette-radio, .facette-checkbox label, .facette-switch').append('<span></span>');
    }
});

// listing SIT classique - uniquement map en aside
var listingSitDefaultWithMap = new thListingManager({
    selectors: {
        listing: ".js-listing-default-map",
        mapoverlay: '.js-listing-overlay-map',
        map: '.js-listing-map',
    },
    mapOptions: {
        onlyDesktop: true,
    },
    mapOverlayOptions: {
        onlyMobile: false,
    },
    // update_form: true, // permet de mettre à jour les valeurs de formulaire en fonction du filtrage utilisateur
    afterUpdate: function () {
        // si composant favoris :
        // th_favoris.parseItems();
        // th_favoris.addEvents();
        // $('.facette-radio, .facette-checkbox label, .facette-switch').append('<span></span>');
    }
});

// listing SIT FMA - uniquement une map en overlay + overlay sur les cards
var listingSitFMA = new thListingManager({
    selectors: {
        listing: '.js-listing-fma',
        mapoverlay: '.js-listing-overlay-map',
    },
    afterUpdate: function () {
        // si composant favoris :
        // th_favoris.parseItems();
        // th_favoris.addEvents();
        parseCardAgendaClickOverlay();
    }
});

// listing CPT - pas de map
var listingCPT = new thListingManager({
    selectors: {
        listing: '.js-listing-cpt',
    },
    afterUpdate: function () {
        // si composant favoris :
        // th_favoris.parseItems();
        // th_favoris.addEvents();
    }
});

/* A l'ouverture de l'overlay, on charge la carte */
// cette fonction doit $etre déclarée avant le th_overlay.init()
th_overlay.addCallbackOpen(function (overlayId) {
    if (overlayId == 'overlay-map') {
        setTimeout(function () {
            if (listingSitDefaultWithMap.loaded) {
                listingSitDefaultWithMap.initMapOverlay();
            }
            if (listingSitDefault.loaded) {
                listingSitDefault.initMapOverlay();
            }
            if (listingSitFMA.loaded) {
                listingSitFMA.initMapOverlay();
            }
        }, 850);
    }
});


/* Initialisation du slider de la carte */
(function () {
    setTimeout(function () {

        // Init des sliders
        const sliders = document.querySelectorAll('.js-slider-overlay-map');
        sliders.forEach(function (slider) {
            initSlider(slider);
        });

        function initSlider(slider) {
            const splide = new Splide(slider, {
                breakpoints: {
                    600: {
                        arrows: false
                    },
                }
            }).mount();
        }

    }, 550);
})();
