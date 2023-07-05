class thListingFormEvent {

    form;
    selectors;
    listingManager;

    options = {
        selectors: {
            form: '.js-listing-form-facette',
            btn_loc: null,
            autocomplete: null,
            outoverlay: '.js-listing-barre-filtre',
            selectedfacette: null,
            nb_results: '.js-listing-nb-resultats',
            nb_filters: '.js-listing-nb-filtres-actifs',
        },
    };

    constructor(options, listingManager) {

        options = $.extend(true, this.options, options);
        this.options = options;
        this.selectors = options.selectors;
        this.listingManager = listingManager;

        this.form = $(listingManager.options.selectors.form);
        var form = this.form;
        var that = this;

        this.initFormSubmit();
        this.outOfOverlayinit();

        $('input[type="checkbox"], input[type="date"], input[type="text"], input[type="radio"], select, .facette-slider input', this.selectors.form).on('change', function () {
            that.outOfOverlayUpdate($(this));
            form.submit();
        });
        $('input[type="checkbox"], input[type="date"], input[type="text"], input[type="radio"], select, .facette-slider input', this.selectors.form).on('force-change', function () {
            form.submit();
        });

        if (document.querySelector(this.selectors.btn_loc)) {
            this.geolocInit();
        }

        if (document.querySelector(this.selectors.autocomplete)) {
            this.aucompleteInit();
        }

    }

    initFormSubmit() {
        this.form = $(this.options.selectors.form);
        var listingManager = this.listingManager;

        $(this.form).on('submit', (e) => {
            e.preventDefault();
            e.stopPropagation();
            var query = $(":input", this.form)
                .filter(function (index, element) {
                    if (
                        $(element).val() != ''
                        && $(element).val() != 'empty'
                        && $(element).attr('name') != 'year' // élément provenants du datepicker
                        && $(element).attr('name') != 'month' // élément provenants du datepicker
                        && $(element).attr('name') != 'y' // élément provenants du datepicker
                        && $(element).attr('name') != 'm' // élément provenants du datepicker
                    ) {
                        return $(element).val();
                    }
                })
                .serialize();
            var url = this.form.get(0).getAttribute('action');

            listingManager.ajaxCall(url + '?' + query, true);
        });
    }

    /**
     * Mets en place les listener pour les facettes en dehors de l'overlay
     * - actualise l'équivalent dans l'overlay avec la bonne valeur
     * - mets à jours la liste de valeurs de facettes sélectionnées
     */
    outOfOverlayinit() {

        var that = this;


        // les dropdown en dehors de l'overlay
        $('input[type=checkbox]:not(.no-refresh)', this.options.selectors.outoverlay).on('change', function () {
            var input_name = $(this).attr('name');
            var input_id = $(this).attr('id').split('_mea')[0];
            var input_val = $(this).val();
            var input_checked = $(this).prop('checked');
            var input_displayname = $(this).parent().text();

            that.selectedFacetteAdd(input_id, input_name, input_displayname);

            $('#' + input_id, that.options.selectors.form).prop('checked', input_checked).trigger('force-change');
        })

        // les champs text en dehors de l'overlay
        $('input[type=text]:not(.no-refresh)', this.options.selectors.outoverlay).on('focusout', function () {
            var input_name = $(this).attr('name');
            var input_id = $(this).attr('id').split('_mea')[0];
            var input_val = $(this).val();
            var input_displayname = $(this).parent().text();

            that.selectedFacetteAdd(input_id, input_name, input_displayname);

            if (input_val) {
                $('#' + input_id, that.options.selectors.form).prop('value', input_val).trigger('force-change');
            }
        })


        // les select en dehors de l'overlay
        $('select:not(.no-refresh)', this.options.selectors.outoverlay).on('change', function () {
            var input_name = $(this).attr('name');
            var input_val = $(this).val();
            var input_displayname = $('option:selected', this).text();
            var input_index = $('[value="' + input_val + '"]', that.options.selectors.form).index();

            that.selectedFacetteAdd(input_val, input_name, input_displayname);
            that.outOfOverlayUpdate($(this));

            $('[name="' + input_name + '"]', that.options.selectors.form).val(input_val).trigger('force-change');
            $('[value="' + input_val + '"]', that.options.selectors.form).prop('selected', 'selected');

            // pour selectric
            if ($('.selectric-wrapper').length > 0) {
                $('#' + input_name, that.options.selectors.form).prop('selectedIndex', input_index).selectric('refresh');
            }

        })

        // les champs du moteur de reservation elloha n'entrainent pas de rafraichissement des données mais actualisent les input type hidden dans l'overlay
        $('.no-refresh', this.options.selectors.outoverlay).on('change', function () {
            input_name = $(this).attr('name')
            input_val = $(this).val();

            $('[name="' + input_name + '"]', that.options.selectors.form).val(input_val);
        })

        // la soumission du moteur de reservation elloha n'entrainent pas de rafraichissement des données
        $('.submit', this.options.selectors.outoverlay).on('click', function () {
            $(that.options.selectors.form).submit();
        });

    }


    /**
     * Mets à jour les valeurs sélectionnées dans les zones en dehors du formulaire de soumission
     *  - select et checkbox en dehors
     *  - zone d'affichage des valeurs séléctionnées
     *
     * @param $elem : input venant d'être activé par les actions utilisateur
     */
    outOfOverlayUpdate($elem) {
        var elem_type = $elem.attr('type');

        if (typeof elem_type == 'undefined') {
            elem_type = 'select';
        }
        var elem_name = $elem.attr('name');
        var input_val = $elem.val();

        switch (elem_type) {

            // les dropdowns en dehors de l'overlay
            case 'checkbox':
                var input_checked = $elem.prop('checked');
                var elem_id = $elem.attr('id');
                var input_displayname = $elem.parent().text();


                // lorsque la valeur est selectionnée
                if (input_checked) {
                    this.selectedFacetteAdd(elem_id, elem_name, input_displayname);
                } else {
                    // lorsque la valeur est déselectionnée
                    var $elem_to_remove = $('[data-facetteselectedvalue="' + elem_id + '"][data-facetteselectedname="' + elem_name + '"]');
                    this.selectedFacetteRemove($elem_to_remove);
                }

                // on met à jour la valeur du dropdown en dehors de l'overlay
                elem_id = elem_id + '_mea';
                $('#' + elem_id, this.options.selectors.outoverlay).prop("checked", input_checked);

                break;

            // les select en dehors de l'overlay
            case 'select':
                // il faut enlever toutes les valeurs correspondant à cette facette, car vu que c'est un select il ne peut y en avoir qu'une
                $('[data-facetteselectedname="' + elem_name + '"]').each(function () {
                    this.selectedFacetteRemove($(this));
                });

                // ensuite on ajoute celle qu'on vient de choisir
                input_displayname = $('option:selected', $elem).text();
                if (input_val != 'empty') {
                    this.selectedFacetteAdd(input_val, elem_name, input_displayname);
                }

                var input_index = $('[value="' + input_val + '"]', this.options.selectors.form).index();

                // on met à jour la valeur du select en dehors de l'overlay
                $('[name="' + elem_name + '"]', this.options.selectors.outoverlay).val(input_val);

                // selectric
                if ($('.selectric-wrapper').length > 0) {
                    $('#' + elem_name, this.options.selectors.outoverlay).prop('selectedIndex', input_index).selectric('refresh');
                }

                break;

            // fonctionnel pour la facette tarif
            case 'hidden':
                // il faut enlever toutes les valeurs correspondant à cette facette, car ce sont des choix uniques
                $('[data-facetteselectedname="' + elem_name + '"]').each(function () {
                    this.selectedFacetteRemove($(this));
                });

                // ensuite on ajoute celle qu'on vient de choisir
                var prepend_text = $elem.data('textprepend');
                input_displayname = prepend_text + input_val;

                this.selectedFacetteAdd(input_val, elem_name, input_displayname);

                break;

            // fonctionnel pour la facette classement
            case 'radio':
                //il faut déjà enlever toutes les valeurs correspondant à cette facette, car vu que c'est un radio il ne peut y en avoir qu'une
                $('[data-facetteselectedname=' + elem_name + ']').each(function () {
                    this.selectedFacetteRemove($(this));
                });

                // ensuite on ajoute celle qu'on vient de choisir
                prepend_text = $elem.data('textappend');
                if (input_val != 0) {
                    input_displayname = input_val + ' ' + prepend_text;
                    this.selectedFacetteAdd(input_val, elem_name, input_displayname);
                }

                break;

            // gestion de la facette disponibilités
            case 'date':

                if (elem_name == "dispo_du" || elem_name == "dispo_au") {
                    elem_id = $elem.attr('id');
                    this.selectedFacetteRemove($('[data-facetteselectedname="' + elem_name + '"]'));

                    var date = moment(new Date(Date.parse($elem.val()))).format('DD/MM/YYYY');
                    input_displayname = $('label[for=' + elem_id + ']').text() + ' ' + date;
                    this.selectedFacetteAdd(elem_id, elem_name, input_displayname);
                }


                break;

            // input text en dehors de l'overlay
            case 'text':

                var elem_id = $elem.attr('id');
                var elem_val = $elem.val();

                // on met à jour la valeur du text en dehors de l'overlay
                elem_id = elem_id + '_mea';
                $('#' + elem_id, this.options.selectors.outoverlay).prop("value", elem_val);

                break;
        }
    }

    /**
     * Ajout d'une valeur de facette dans la liste des valeurs sélectionnées
     * @TODO
     * @param value
     * @param name
     * @param display_name
     */
    selectedFacetteAdd(value, name, display_name) {

        var facette_list = $(this.options.selectors.selectedfacette);

        if (value) {
            var item_html = '<button class="gtm-liste-filtre-suppr" aria-label="Supprimer le filtre' + display_name + '" type="button" data-facetteselectedvalue="' + value + '" data-facetteselectedname="' + name + '">' + display_name + '</button>';
            facette_list.append(item_html);
            this.selectedFacetteInitRemove($('[data-facetteselectedvalue="' + value + '"]'));
        }

    }

    /**
     * déselectionne les inputs relatifs (en dehors et dans le form principal) aux valeurs cliquées dans la zone de valeurs sélectionnées affichées
     * @param $elem : valeur de facette "deselectionnée"
     */
    selectedFacetteInitRemove($elem) {

        var that = this;

        $elem.on('click', function () {

            var input_value = $elem.data('facetteselectedvalue');
            var input_name = $elem.data('facetteselectedname');

            var type = $("[name='" + input_name + "']").attr('type');

            // evo #9580 : traitement particulier pour la facette dispo
            var facette_key = input_name.split("_");

            if (facette_key[0] == 'dispo') {
                type = 'dispo';
            }

            if (typeof type == 'undefined') {
                type = 'select';
            }

            if (type == 'select') {
                // si c'est un select => on rétabli la valeur vide

                // actualisation dans l'overlay
                $('[name="' + input_name + '"]', this.options.selectors.form).val('empty').trigger('force-change');
                // actualisation en dehors de l'overlay
                $('[name="' + input_name + '"]', this.options.selectors.outoverlay).val('empty');

            } else if (type == 'checkbox') {
                // si c'est une dropdown => on deselectionne la case

                // actualisation dans l'overlay
                $('#' + input_value, this.options.selectors.form).prop('checked', false).trigger('force-change');

                // actualisation en dehors de l'overlay
                $('#' + input_value + '_mea', this.options.selectors.outoverlay).prop("checked", false);
            } else if (type == 'radio') {
                // si c'est un radio (classements) => on selectionne la valeur vide

                // actualisation dans l'overlay
                $('[name=' + input_name + '][value=0]', this.options.selectors.form).prop('checked', true).trigger('force-change');
            } else if (type == 'hidden') {
                // si c'est un hidden (tarifs/distance/denivelé) => on selectionne la valeur vide
                key_facette = input_name.split("_");
                key_slider = 'slider_' + key_facette[0];
                key_val = key_facette[1];

                if (typeof fmsliders[key_slider] != 'undefined') {
                    max = parseInt(fmsliders[key_slider].getAttribute('data-max'));
                    min = parseInt(fmsliders[key_slider].getAttribute('data-min'));
                    current_val = fmsliders[key_slider].noUiSlider.get();
                    start = current_val[0];
                    end = current_val[1];

                    if (key_val == 'min') {
                        new_start = [min, end];
                    } else {
                        new_start = [start, max];
                    }

                    fmsliders[key_slider].noUiSlider.updateOptions({
                        start: new_start
                    });
                }

                // actualisation dans l'overlay
                $('[name=' + input_name + ']', this.options.selectors.form).val('').trigger('force-change');
            } else if (type == 'dispo') {

                // il faut dans ce cas réinitialiser tous les inputs rattachés à cette facette (dates + select)
                $('[name^=dispo]', this.options.selectors.form).val('');

                // actualisation dans l'overlay, on joue le force-change sur un seul des inputs de la facette pour ne pas faire trop d'appels
                $('[name=dispo_du]', this.options.selectors.form).trigger('force-change');

                // mise à jour du slider de valeurs séléctionnées
                // il faut en effet supprimer du slider les 2 autres paramètres de cette facette
                var all_dispo_fields = ['dispo_nbpers', 'dispo_au', 'dispo_du'];
                var current_elem_index = all_dispo_fields.indexOf(input_name);
                all_dispo_fields.splice(current_elem_index, 1);

                $.each(all_dispo_fields, function (k, field) {
                    that.selectedFacetteRemove($('[data-facetteselectedname=' + field + ']'));
                });
            }

            // mise à jour du slider de valeurs séléctionnées
            that.selectedFacetteRemove($elem);
        })

    }

    /**
     * supprime une facette en particulier de la liste des valeurs sélectionnées
     * @TODO
     */
    selectedFacetteRemove($elem) {

        var facette_list = $(this.options.selectors.selectedfacette);
    }

    /**
     * une seule fois au chargement de la page
     * parcours toutes les facettes déjà selectionnées à l'affichage de la page pour initialiser l'action de remove au click
     */
    selectedFacettesRemove() {

        $('[data-facetteselectedvalue]').each(function () {
            this.selectedFacetteInitRemove($(this));
        })
    }

    /**
     * @TODO : pas encore implémenté dans un projet récent
     * ceci est du vieux code qui traine du coup de projet en projet mais peut être qu'un jour il pourra servir de base de travail
     */
    geolocInit() {
        $(this.selectors.btn_loc).click(function (e) {
            e.preventDefault();
            e.stopPropagation();
            $self = $(this);
            $self.parent().toggleClass('active');
            var positionDejaprise = false;
            setTimeout(function () {
                if ($self.parent().hasClass('active')) {
                    console.log('Activation de la geoloc');

                    if (navigator.geolocation) {

                        if (positionDejaprise !== false) {
                            console.log('Geoloc déjà récupéré, affichage');


                            var pos = positionDejaprise;
                            $('input[name="lat"]').val(pos.lat);
                            $('input[name="lng"]').val(pos.lng);
                            markerTargetCurrentGeo.setPosition(pos);
                            markerTargetCurrentGeo.setMap(macarte);
                            macarte.setCenter(pos);

                            $('.page-listing form').submit();
                        } else {
                            console.log('Demande de geoloc ...');
                            navigator.geolocation.getCurrentPosition(handleGeoloc, function (e) {
                                alert("Votre support ne nous permet pas de trouver votre position. Vérifiez les paramètres de localisation de votre appareil.");
                            });
                        }

                    } else {
                        alert("Votre support ne nous permet pas de trouver votre position. Vérifiez les paramètres de localisation de votre appareil.");
                    }
                } else {
                    console.log('Désactivation de la geoloc');

                    $('input[name="lat"]').val('');
                    $('input[name="lng"]').val('');
                    markerTargetCurrentGeo.setMap(null);
                    $('.page-listing form').submit();
                }
            }, 100);
        });
    }

    /**
     * @TODO : pas encore implémenté dans un projet récent
     * ceci est du vieux code qui traine du coup de projet en projet mais peut être qu'un jour il pourra servir de base de travail
     */
    aucompleteInit() {
        $('.rayon').hide();
        $(this.options.selectors.autocomplete);
        $(this.options.selectors.autocomplete).selectize({
            plugins: ['remove_button'],
            onFocus: function (value) {
                if ($('.selectize-input .item').data('value') == 'empty' && ($('.selectize-input .item').text())) {
                    //$('.selectize-input .item').data('value','');
                    //$('.selectize-input .item').text('');
                }
            },
            onItemAdd: function (value, $item) {
                var dataObject = {
                    'event': 'event-commune',
                    'category': 'Commune',
                    'action': 'Choix commune',
                    'label': $item.text().trim()
                };
                if (typeof dataLayer != 'undefined') {
                    dataLayer.push(dataObject);
                }

                $('.rayon').show(500);
            },
            onItemRemove: function (value, $item) {
                $('.rayon').hide();
            }
        });


    }

}