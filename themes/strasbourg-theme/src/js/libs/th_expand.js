var th_expand = {
    parse: function (el) {
        if (!el) {
            el = document;
        }

        $('[data-expand]:not(.parsed)', el).each(function () {
            $(this).addClass('parsed');
            th_expand.initSingle(this);
        });
    },

    initSingle: function (el) {

        var $wrapper = $(el);
        var $link = $('button.cta-expand', el).first();
        if ($link.length === 0) {
            $link = $('button.cta-expand', $(el).parent()).first();
        }

        if ($wrapper.attr('data-expand')) {
            var minHeightToInit = $wrapper.attr('data-expand');
            if ($wrapper.height() < minHeightToInit) {
                $wrapper.addClass('expand');
                return false;
            }
        }

        $wrapper.addClass('to-expand');
        $link.removeClass('hide');

        if ($link.length == 0) {
            $link = $('button.cta-expand', $(this).parent()).first();
        }

        var wrapperHeight = 0;
        $wrapper.attr('style', 'height:auto!important;max-height:2000px!important;');
        wrapperHeight = $wrapper.height();
        $wrapper.removeAttr('style').css('height', wrapperHeight + 'px');

        $(window).on('resize', function () {
            $wrapper.attr('style', 'height:auto!important;');
            wrapperHeight = $wrapper.height();
            $wrapper.removeAttr('style').css('height', wrapperHeight + 'px');
        });

        $link.on('click', function (e) {
            e.preventDefault();
            $(this).addClass('fadeout');
            $wrapper.addClass('expand');
        });
    }
};