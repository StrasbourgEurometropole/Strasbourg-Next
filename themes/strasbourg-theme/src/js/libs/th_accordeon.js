var th_accordeon = {

    init: function () {
        $('.accordeon:not(.initialized)').each(function () {
            $(this).addClass('initialized');
            th_accordeon.initSingle(this);
        });
    },

    initSingle: function (el) {

        var lastWindowWidth = $(window).width();
        var $link = $('.title-accordeon', el);
        var $wrapper = $('.item', el);
        var $parentWrapper = $wrapper.parents('.wrapper-hidden');

        var wrapperHeight = 0;
        $wrapper.attr('style', 'height:auto!important;max-height:5000px!important;');
        wrapperHeight = $wrapper.outerHeight();
        $wrapper.removeAttr('style').css('height', wrapperHeight + 'px');

        setTimeout(function () {
            $wrapper.addClass('anim');
        }, 100);

        var timeoutResize = null;

        $(el).on('refresh', function () {

            clearTimeout(timeoutResize);

            timeoutResize = setTimeout(function () {
                var calcWidth = th_accordeon.windowWidth(lastWindowWidth);

                if (calcWidth != false) {
                    lastWindowWidth = calcWidth;
                    $wrapper.removeClass('anim');
                    // timeout pour que le retrait de la class anim soit bien pris en compte
                    setTimeout(function () {
                        $wrapper.attr('style', 'height:auto!important;max-height:5000px!important;');
                        wrapperHeight = $wrapper.outerHeight();

                        if ($wrapper.parent().hasClass('open')) {
                            $wrapper.removeAttr('style').attr('style', 'max-height:' + wrapperHeight + 'px;');
                        } else {
                            $wrapper.removeAttr('style').attr('style', 'max-height:0px;');
                        }
                        // timeout pour que l'anim ne se joue pas a la remise en place du height
                        setTimeout(function () {
                            $wrapper.addClass('anim');
                        }, 100);
                    }, 100);
                }
            }, 250);
        });


        $(el).on('forcerefresh', function () {
            lastWindowWidth = 0;
            $(el).trigger('refresh');
        });

        $(window).on('resize', function () {
            $(el).trigger('refresh');
        });

        $link.on('click', function (e) {
            if (e.target.tagName != 'A') {
                if ($(this).parent().hasClass('open')) {
                    $wrapper.attr('style', 'max-height:0px').parent().removeClass('open');
                    $parentWrapper.removeClass('open');
                } else {
                    $wrapper.attr('style', 'max-height:' + wrapperHeight + 'px').parent().addClass('open');
                    $parentWrapper.addClass('open');
                }
            }
        });
    },

    windowWidth: function (lastWindowWidth) {
        /* Do not calculate the new window width twice.
         * Do it just once and store it in a variable. */
        var windowWidth = $(window).width();

        /* Use !== operator instead of !=. */
        if (lastWindowWidth !== windowWidth) {
            return windowWidth;
        } else {
            return false;
        }
    }
};


th_accordeon.init();