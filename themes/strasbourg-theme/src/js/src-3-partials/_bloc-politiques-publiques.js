(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-politiques-publiques');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            arrows: false,
            mediaQuery: 'min',

            breakpoints: {
                980: {
                    destroy: true,
                }
            }
        }).mount();


        // Accessibilité sur les slides masqués par le view-more
        const slides = slider.querySelectorAll('.splide__slide:nth-child(n+9)');

        // Container des slides masqué
        function removeSlidesAccessibility() {
            slides.forEach(slide => {
                slide.setAttribute("aria-hidden", "true");

                const card = slide.querySelector('a.st-card');
                if(card) card.setAttribute("tabindex", "-1");
            });
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
        }



    });


    // Init des sliders
    const slidersLinks = document.querySelectorAll('.st-js-slider-politiques-publiques-links');
    slidersLinks.forEach(slider => {

        const splide = new Splide(slider, {
            arrows: false,
            mediaQuery: 'min',

            breakpoints: {
                980: {
                    destroy: true,
                }
            }
        }).mount();
    });

})();