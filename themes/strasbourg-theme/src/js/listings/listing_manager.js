class thListingManager {

    loaded = false;

    maps = {
        map: null,
        mapOverlay: null,
    };

    form;

    formEventHandler;
    ajaxHandler;
    paginationHandler;

    options = {
        selectors: {
            listing: '.js-listing-default',
            cards: '.card',
            cardsContainer: '.js-listing-card-container',
            cardsOverlayContainer: '.js-listing-overlay-card-container',

            scrollable: 'html,body',

            pagination: '.js-listing-pagination',
            paginationLight: '.js-listing-pagination-light',
            paginationOverlay: '.js-listing-pagination-overlay',

            map: null, // par prérempli car on peut ne pas avoir de map du tout sur un listing
            mapoverlay: null, // par prérempli car on peut ne pas avoir de map du tout sur un listing

            form: '.js-listing-form-facette',
            btn_loc: null,
            autocomplete: null, //'.autocomplete select'
            outoverlay: '.js-listing-barre-filtre',
            outoverlay_facette: '.js-listing-outoverlay-facettes',
            selectedfacette: null,
            nb_results: '.js-listing-nb-resultats',
            nb_filters: '.js-listing-nb-filtres-actifs',
        },
        mapOptions: {
            selector: null,
            breakpointMobile: 980,
            markerIcon: 'default',
            markerIconHover: 'hover',
            markerWidth: 300,
            layersMaxZoom: 18,
            useCluster: false,
            onlyMobile: false,
            onlyDesktop: true,
        },
        mapOverlayOptions: {
            selector: null,
            breakpointMobile: 980,
            markerIcon: 'default',
            markerIconHover: 'hover',
            markerWidth: 300,
            layersMaxZoom: 18,
            useCluster: false,
            onlyMobile: false,
            onlyDesktop: false,
        },
        scrollTop: 50,
        scrollSpeed: 250,
        update_form: false,
        afterUpdate: null, // mettre ici une fonction de callback si besoin
    };

    constructor(options) {

        options = $.extend(true, this.options, options);
        this.options = options;

        // on regarde si les selecteurs indispensables sont bien présents dans la page,
        // sinon cette lib ne sera pas fonctionnelle
        if (document.querySelector(this.options.selectors.listing) === null
            || document.querySelector(this.options.selectors.form) === null
            || document.querySelector(this.options.selectors.cardsContainer) === null
            || document.querySelector(this.options.selectors.pagination) === null
        ) {
            return;
        }

        this.loaded = true;

        this.ajaxHandler = new thListingAjax(this);

        // formulaire et events liés
        this.formEventHandler = new thListingFormEvent(this.options.selectors.form, this);

        // pagination
        this.paginationHandler = new thListingPagination({
            selectorpagination: this.options.selectors.pagination,
            selectorpaginationOverlay: this.options.selectors.paginationOverlay,
            selectorpaginationLight: this.options.selectors.paginationLight,
        }, this);


        // on essaye uniquement d'inialiser la map du listing
        this.initMap();
    }

    initMap() {
        // initialisation des maps
        setTimeout(() => {
            if (!this.maps.map && document.querySelector(this.options.selectors.map)) {
                var mapoptions = this.options.mapOptions;
                mapoptions.selector = this.options.selectors.map;
                this.maps.map = new thListingMap(mapoptions);
                this.maps.map.setCards($(this.options.selectors.cards, this.options.selectors.cardsContainer));
                this.maps.map.update();
                this.maps.map.fitMap();
            }
        }, 250);
    }

    // utilisée dans le th_overlay.addCallbackOpen() de l'overlay en question
    initMapOverlay() {
        if (!this.maps.mapOverlay && document.querySelector(this.options.selectors.mapoverlay)) {
            var mapoptions = this.options.mapOverlayOptions;
            mapoptions.selector = this.options.selectors.mapoverlay;
            this.maps.mapOverlay = new thListingMap(mapoptions);
            this.maps.mapOverlay.setCards($(this.options.selectors.cards, this.options.selectors.cardsOverlayContainer));
            this.maps.mapOverlay.update();
            this.maps.mapOverlay.fitMap();
        }
    }

    ajaxCall(url, goTop, ignoreHistory) {
        this.ajaxHandler.call(url, ignoreHistory);

        // on fixe la hauteur du container des cards si il y a une map en sticky pour éviter les soucis de chevauchement de pagination quand il y a moins de résultats après action
        if (this.maps.map) {
            $(this.options.selectors.cardsContainer).height($(this.options.selectors.cardsContainer).height());
        }

        // affichage du texte chargement en cours
        $(this.options.selectors.cardsContainer).html('<p class="chargement-en-cours" role="alert">' + $(this.options.selectors.cardsContainer).data('loading') + '</p>');
        if (this.options.selectors.cardsOverlayContainer) {
            $(this.options.selectors.cardsOverlayContainer).html('<p class="chargement-en-cours" role="alert">' + $(this.options.selectors.cardsContainer).data('loading') + '</p>');
        }

        // on vide les maps
        for (const [typemap, map] of Object.entries(this.maps)) {
            if (map) {
                map.emptyMap();
            }
        }

        // on retourne en haut de la page après action d'update
        if (goTop) {
            this.goTopListing();
        }

    }

    goTopListing() {
        $(this.options.selectors.scrollable).animate({scrollTop: this.options.scrollTop}, this.options.scrollSpeed);
    }

    handleResponse(html) {

        // nb de filtres utilisés
        var nb_filters = parseInt($(html).find(this.options.selectors.nb_filters).text());
        $(this.options.selectors.nb_filters).text(nb_filters);

        // nb de résultats
        var nb_results = $(html).find(this.options.selectors.nb_results).text();
        $(this.options.selectors.nb_results).text(nb_results);

        // contenu des formulaires
        if (this.options.update_form) {
            if (html) {

                $('select', this.options.selectors.form).selectric('destroy');
                $('select', this.options.selectors.outoverlay).selectric('destroy');

                var form_html = $(html).find(this.options.selectors.form).html();
                $(this.options.selectors.form).html(form_html);

                var outoverlay_html = $(html).find(this.options.selectors.outoverlay_facette).html();
                $(this.options.selectors.outoverlay_facette).html(outoverlay_html);

                // TYPE SELECT
                $('select', this.options.selectors.form).selectric();
                $('select', this.options.selectors.outoverlay).selectric();

                this.formEventHandler = new thListingFormEvent(this.options.selectors.form, this);
            }

        }

        // contenu du listing
        var listingcards = $(html).find(this.options.selectors.cardsContainer).html();
        var listingcardsOverlay = $(html).find(this.options.selectors.cardsOverlayContainer).html();
        if (html) {
            $(this.options.selectors.cardsContainer).html(listingcards);
            $(this.options.selectors.cardsOverlayContainer).html(listingcardsOverlay);
        }

        // cartes
        for (const [typemap, map] of Object.entries(this.maps)) {
            if (map) {
                if (typemap == 'map') {
                    var cards = $(this.options.selectors.cards, this.options.selectors.cardsContainer);
                } else {
                    var cards = $(this.options.selectors.cards, this.options.selectors.cardsOverlayContainer);
                }

                map.setCards(cards);
                map.update();
            }
        }

        // pagination
        this.paginationHandler.update(html);

        // on relance le lazyload sur les images
        var lazyLoadInstance = new LazyLoad({
            elements_selector: ".lazy"
        });

        // callback
        if (typeof this.options.afterUpdate == 'function') {
            this.options.afterUpdate(html);
        }

        $(this.options.selectors.cardsContainer).removeAttr('style');

    }

}