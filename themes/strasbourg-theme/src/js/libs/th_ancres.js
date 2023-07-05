var th_ancres = {
    selectors: {
        blocAncre: '.st-bloc-ancre',
        ancres: '.st-ancres',
        menuAncre: '.st-menu-ancre',
        sliderAncre: '.st-js-slider-ancres'
    },
    scrollOffset: 180,
    scrollSpeed: 'slow',

    init: function () {
        // Système des ancres complétement désactivé si < de tablette
        if (document.body.clientWidth > thConfig.tabletPaysageBreakpoint) {
            th_ancres.ancreClick();
            th_ancres.observer();
        }
    },

    // gestion du scroll smooth
    ancreClick: function () {
        $(th_ancres.selectors.ancres + ' a').each(function () {
            $(this).on('click', function (e) {
                e.preventDefault();
                $('html, body').animate({scrollTop: $($(this).attr('href')).offset().top - th_ancres.scrollOffset}, th_ancres.scrollSpeed);

                var currentHref = $(this).attr('href');
                var sectionId = $(currentHref);
                sectionId.focus();
                return false;
            });
        });
    },

    // callback de l'intersection observer
    obsCallback: function (entries, observer) {
        for (var i = 0; i < entries.length; i++) {
            var entry = entries[i];
            var entryId = entry.target.id;

            if (entry.isIntersecting) {
                $(th_ancres.selectors.menuAncre).each(function () {
                    $(this).removeClass('is-active');
                    $(this).find(".sr-only").css("display", "none");
                });
                var currentAncre = $(th_ancres.selectors.menuAncre + "[href='#" + entryId + "']");

                currentAncre.addClass('is-active');
                currentAncre.find(".sr-only").css("display", "block");

                // Synchronise le slider avec l'élément courant
                var onlyIdNumber = parseInt(entryId.replace(/\D/g, ""));
                sliderAncre.go(onlyIdNumber - 1);
            }
        }
    },

    observer: function () {
        if ('IntersectionObserver' in window) { // on vérifie si c'est compatible avec le navigateur
            var observer = new IntersectionObserver(th_ancres.obsCallback);

            $(th_ancres.selectors.blocAncre).each(function () {
                observer.observe($(this)[0]);
            })
        }
    },
}

