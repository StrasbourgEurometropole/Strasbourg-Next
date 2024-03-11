(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-actu');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            arrows: false,
            mediaQuery: 'min',

            breakpoints: {
                981: {
                    destroy: true,
                }
            }
        });
        splide.on('mounted', function () {
            for (const list of splide.Components.Elements.slides) {
                list.setAttribute('role', 'presentation');
            }
        });
        splide.mount();


        /*
        Suppression du bouton "plus d'actualité"
        -> plus besoin de gérer l'accessibilité

        // Accessibilité sur les slides masqués par le view-more
        const slides = slider.querySelectorAll('.splide__slide:nth-child(n+3)');
        const btnCta = slider.querySelector('.st-btn-cta');

        // Container des slides masqué
        function removeSlidesAccessibility() {
            slides.forEach(slide => {
                slide.setAttribute("aria-hidden", "true");

                const card = slide.querySelector('a.st-card');
                if(card) card.setAttribute("tabindex", "-1");
            });

            if (btnCta) {
                btnCta.setAttribute("aria-hidden", "true");
                btnCta.setAttribute("tabindex", "-1");
            }
        }

        // Container des slides affiché
        function setSlidesAccessibility() {
            slides.forEach((slide, currentIndex) => {
                slide.removeAttribute("aria-hidden");

                const card = slide.querySelector('a.st-card');
                if(card) {
                    card.removeAttribute("tabindex");

                    // Focus sur la 1ere card précédemment masquée
                    if (currentIndex === 0 ) card.focus();
                }
            });

            if (btnCta) {
                btnCta.removeAttribute("aria-hidden");
                btnCta.removeAttribute("tabindex");
            }
        }

        // Accessibilité sur les slides masqués par le view-more
        if ( window.innerWidth > 980 ) {
            removeSlidesAccessibility();

            // Toggle de l'accessibilité en fonction de l'affichage / masquage du module view-more
            slider.addEventListener('showViewMore', function (e) {
                setSlidesAccessibility();
            });

            slider.addEventListener('hideViewMore', function (e) {
                removeSlidesAccessibility();
            });
        }*/
    });

})();