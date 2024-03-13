var th_overlay = {
    selector_overlay: '.st-overlay',
    selector_overlay_shadow: '.st-shadow-overlay',

    callbackOpen: [],
    callbackClose: [],

    // RGAA
    isEscapeListening: false,
    lastOpenedId: [],
    focusElOnClose: {},
    noFocusOnPreviousOverlay: false,
    doNotCloseOverlay: false,

    preventDefault: true,

    init: function (settings) {
        th_overlay.parseOverlayShadow($('body'));
        th_overlay.parse($('body'));
        th_overlay.openOnLoad();

        if (settings) {
            $.each(settings, function (key, setting) {
                if (th_overlay[key]) {
                    th_overlay[key] = setting;
                }
            });
        }

        // RGAA on ecoute la touche echap pour fermer les overlay ouvert
        if (!th_overlay.isEscapeListening) {
            th_overlay.isEscapeListening = true;
            document.addEventListener('keydown', function (e) {
                if (th_overlay.lastOpenedId.length > 0 && e.key === "Escape") {
                    e.preventDefault();
                    e.stopPropagation();

                    // on ferme le dernier ouvert
                    if (th_overlay.doNotCloseOverlay === false || th_overlay.doNotCloseOverlay === null) {
                        th_overlay.close(th_overlay.lastOpenedId[th_overlay.lastOpenedId.length - 1]);
                    }

                }
            });
        }
    },

    addCallbackOpen: function (callback) {
        th_overlay.callbackOpen.push(callback);
    },

    addCallbackClose: function (callback) {
        th_overlay.callbackClose.push(callback);
    },

    parseOverlayShadow: function () {
        $(th_overlay.selector_overlay_shadow).on('click', function (e) {
            e.preventDefault();
            th_overlay.close(window.location.hash.substring(1));
        });
    },

    parse: function (el) {

        $(th_overlay.selector_overlay).each(function () {
            var overlayId = this.id;
            var targetOpen = $('a[href="#' + overlayId + '"]:not(.st-parsed-overlay):not(.close), [data-overlay-open="' + overlayId + '"]:not(.st-parsed-overlay)');

            targetOpen.addClass('st-parsed-overlay')
                .on('click', function (e) {
                    e.preventDefault();
                    var idOverlay = $(this).data("overlay-open");
                    if (!idOverlay) {
                        idOverlay = $(this).attr('href');
                        idOverlay = idOverlay.replace('#', '');
                    }

                    // RGAA : On stock l'element qui a ouvert l'overlay pour y revenir a sa fermeture
                    th_overlay.focusElOnClose[idOverlay] = this;

                    th_overlay.open(idOverlay);
                });

            $('a[href="#' + overlayId + '"].close:not(.st-parsed-overlay), [data-overlay-close="' + overlayId + '"]:not(.st-parsed-overlay)')
                .addClass('st-parsed-overlay')
                .on('click', function (e) {
                    e.preventDefault();
                    var idOverlay = $(this).attr('href');
                    if (!idOverlay) {
                        idOverlay = $(this).attr('data-overlay-close');
                    } else {
                        idOverlay = idOverlay.replace('#', '');
                    }

                    if (!idOverlay) {
                        idOverlay = null;
                    }

                    if (th_overlay.preventDefault) {
                        e.preventDefault();
                    }
                    th_overlay.close(idOverlay);
                });
        });
    },

    openOnLoad: function () {
        var current_hash = (window.location.hash).split('#');

        if (current_hash) {
            $.each(current_hash, function (index, overlay_id) {
                if (overlay_id && overlay_id.length && overlay_id != "st-overlay-preview-person") {
                    try {

                        var corresponding_overlay = $("#" + overlay_id);

                        if ($(corresponding_overlay).hasClass("st-overlay")) {
                            return th_overlay.open(overlay_id);
                        }
                    } catch(error) {
                        return false;
                    }
                }
            });
        }
    },

    open: function (overlayId, openShadow, doCallback) {
        if (openShadow !== false) {
            openShadow = true;
        }
        if (doCallback !== false) {
            doCallback = true;
        }

        // RGAA : On liste les overlay ouvert pour les fermer sur echap
        th_overlay.lastOpenedId.push(overlayId);
        // RGAA : Focus de la croix de fermeture a l'ouverture de l'overlay
        setTimeout(function () {
            // Focus sur le champ de recherche
            if (overlayId === 'st-overlay-search') {
                $('#' + overlayId).find('.st-js-input-search').first().focus();
            } else {
                $('#' + overlayId).find('button[data-overlay-close]').first().focus();
            }
        }, 250);

        if (!(overlayId == 'st-overlay-alert' || (overlayId == 'st-overlay-location' && isTabletPortraitOrSmalller()))) {
            $(th_overlay.selector_overlay + ".st-is-open").each(function (e) {
                th_overlay.close($(this).attr('id'), false, true)
            });
        }

        $('#' + overlayId).addClass('st-is-open');

        if (!$('#' + overlayId).attr("data-disable-hash")) {
            window.location.hash = overlayId;
        }
        if (openShadow == true && overlayId != 'st-overlay-search' && (overlayId != 'st-overlay-menu' || !isTabletPortraitOrSmalller())) {
            $(th_overlay.selector_overlay_shadow).addClass('st-is-open');
        }

        if (doCallback == true) {
            $.each(th_overlay.callbackOpen, function (k, callback) {
                callback(overlayId);
            });
        }
    },

    close: function (overlayId, closeShadow, doCallback) {

        if (closeShadow !== false) {
            closeShadow = true;
        }
        if (doCallback !== false) {
            doCallback = true;
        }

        window.location.hash = " ";
        history.replaceState(null, null, ' ');


        if (overlayId) {

            if (th_overlay.lastOpenedId[th_overlay.lastOpenedId.length - 1] == overlayId) {
                th_overlay.lastOpenedId.pop();
            }

            $('#' + overlayId).removeClass('st-is-open');

            if (($(th_overlay.selector_overlay + '.st-is-open').length == 0 ||
                    $($(th_overlay.selector_overlay + ".st-is-open")[0]).attr("id") == 'st-overlay-search' ||
                    ($($(th_overlay.selector_overlay + ".st-is-open")[0]).attr("id") == 'st-overlay-menu' && isTabletPortraitOrSmalller()))
                && closeShadow) {
                $(th_overlay.selector_overlay_shadow).removeClass('st-is-open');
            }
        } else {
            $(th_overlay.selector_overlay + '.st-is-open').removeClass('st-is-open');
            if (closeShadow) {
                $(th_overlay.selector_overlay_shadow).removeClass('st-is-open');
            }
        }

        if (doCallback) {
            $.each(th_overlay.callbackClose, function (k, callback) {
                callback();
            });
            if (th_overlay.lastOpenedId.length > 0) {
                $.each(th_overlay.callbackOpen, function (k, callback) {
                    callback(th_overlay.lastOpenedId[th_overlay.lastOpenedId.length - 1]);
                });
            }
        }

        // RGAA : focus a nouveau sur l'element qui a ouvert l'overlay
        if (th_overlay.focusElOnClose[overlayId]) {
            setTimeout(function () {
                if (!th_overlay.noFocusOnPreviousOverlay) {
                    $(th_overlay.focusElOnClose[overlayId]).focus();
                }
            }, 850);
        }

    }

};
