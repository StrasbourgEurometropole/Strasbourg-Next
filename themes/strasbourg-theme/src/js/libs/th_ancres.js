var th_ancres = {
    selectors: {
        barreAncres: '.st-ancres',
        blocAncre: '.st-bloc-ancre',
        linkAncre: '.st-ancres__link',
    },
    scrollOffset: 180,
    scrollSpeed: 'slow',

    init: function () {
        th_ancres.ancreClick();
        th_ancres.observer();
    },

    // gestion du scroll smooth
    ancreClick: function () {
        $(th_ancres.selectors.linkAncre).each(function () {
            $(this).on('click', function (e) {
                e.preventDefault();
                $('html, body').animate({scrollTop: $($(this).attr('href')).offset().top - th_ancres.scrollOffset}, th_ancres.scrollSpeed);

                const currentHref = $(this).attr('href');
                const sectionId = $(currentHref);
                sectionId.focus();
                return false;
            });
        });
    },

    // callback de l'intersection observer
    obsCallback: function (entries, observer) {
        for (let i = 0; i < entries.length; i++) {
            const entry = entries[i];
            const entryId = entry.target.id;

            if (entry.isIntersecting) {
                $(th_ancres.selectors.linkAncre).each(function () {
                    $(this).removeClass('is-active');
                    $(this).removeAttr('aria-current');
                });

                const currentLink = $(th_ancres.selectors.linkAncre + "[href='#" + entryId + "']");
                currentLink.addClass('is-active');
                currentLink.attr('aria-current', 'true');

               currentLink[0].scrollIntoView({ behavior: 'auto', block: 'nearest', inline: 'start' });
                //console.log('currentLink[0]', currentLink[0]);
            }
        }
    },

    observer: function () {
        if ('IntersectionObserver' in window) { // on vérifie si c'est compatible avec le navigateur
            const observerOptions = {
                root: null,
                rootMargin: '0px 0px -50% 0px', // Center the observed area
                threshold: 0 // Trigger when any part of the section is in the center area
            };

            const observer = new IntersectionObserver(th_ancres.obsCallback,observerOptions);

            $(th_ancres.selectors.blocAncre).each(function () {
                observer.observe($(this)[0]);
            })
        }
    },
}

