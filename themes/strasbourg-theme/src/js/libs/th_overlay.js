var th_overlay = {
    selector_overlay: '.st-overlay',
    selector_overlay_shadow: '.st-shadow-overlay',

    callbackOpen: [],
    callbackClose: [],

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
            th_overlay.close();
        });
    },

    parse: function (el) {

        $(th_overlay.selector_overlay).each(function () {
            var overlayId = this.id;
            var targetOpen = $('a[href="#' + overlayId + '"]:not(.st-parsed-overlay):not(.st-close), [data-overlay-open="' + overlayId + '"]:not(.st-parsed-overlay)');

            targetOpen.addClass('st-parsed-overlay')
                .on('click', function (e) {
                    e.preventDefault();
                    var idOverlay = $(this).attr('href');
                    if (!idOverlay) {
                        idOverlay = $(this).attr('data-overlay-open');
                    } else {
                        idOverlay = idOverlay.replace('#', '');
                    }

                    // ajout de l'option data-overlay-disable-hash (sans valeur) pour désactiver à l'ouverture l'ajout du hash dans l'url
                    var disableHash = $(this).attr('data-overlay-disable-hash');
                    var enableHash = (typeof disableHash !== 'undefined' && disableHash !== false && disableHash !== 'false') ? false : true;

                    th_overlay.open(idOverlay, true, true, enableHash);
                });

            $('a[href="#' + overlayId + '"].close:not(.parsed-overlay), [data-overlay-close="' + overlayId + '"]:not(.parsed-overlay)')
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
                if (overlay_id && overlay_id.length) {
                    try {
                        var corresponding_overlay = $("#" + overlay_id);
                        var notOpenOnLoad = corresponding_overlay.attr('not-open-onload');

                        if ($(corresponding_overlay).hasClass("st-overlay") && notOpenOnLoad !== "true") {
                            return th_overlay.open(overlay_id);
                        }
                    } catch (error) {
                        return false;
                    }
                }
            });
        }
    },

    open: function (overlayId, openShadow, doCallback, enableHash) {

        if (openShadow !== false) {
            openShadow = true;
        }
        if (doCallback !== false) {
            doCallback = true;
        }
        if (enableHash !== false) {
            enableHash = true;
        }

        $(th_overlay.selector_overlay + ".st-open").each(function (e) {
            th_overlay.close($(this).attr('id'), false, true)
        });

        $('#' + overlayId).addClass('st-open');

        if (enableHash == true) {
            window.location.hash = overlayId;
        }

        if (openShadow == true) {
            $(th_overlay.selector_overlay_shadow).addClass('st-open');
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
            $('#' + overlayId).removeClass('st-open');
            if ($(th_overlay.selector_overlay + '.st-open').length == 0 && closeShadow) {
                $(th_overlay.selector_overlay_shadow).removeClass('st-open');
            }
        } else {
            $(th_overlay.selector_overlay + '.st-open').removeClass('st-open');
            if (closeShadow) {
                $(th_overlay.selector_overlay_shadow).removeClass('st-open');
            }
        }

        if (doCallback) {
            $.each(th_overlay.callbackClose, function (k, callback) {
                callback(overlayId);
            });
        }

    }

};
