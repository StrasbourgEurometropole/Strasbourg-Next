(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-partenaires');
    sliders.forEach(slider => {
        const splide = new Splide(slider);

        // Masque / affiche le dégradé du track si on arrive à la fin du carousel
        splide.on( 'mounted move', function () {
            const end  = splide.Components.Controller.getEnd() + 1;
            const current = splide.index + 1;

            if (current === end) {
                slider.classList.add('has-ended');
            } else {
                slider.classList.remove('has-ended');
            }
        } );
        ;
        splide.on('mounted', function () {
            for (const list of splide.Components.Elements.slides) {
                list.setAttribute('role', 'presentation');
            }
        });
         splide.mount();




        // Affichage / masquage des infobulles des logo au survol
        function onLogoHover(e) {
             const logo = e.target;
            logo.classList.add('st-has-tooltip-show');
            document.addEventListener('keydown', keyHandler);
        }

        function onLogoLeave(e) {
            const logo = e.target;
            logo.classList.remove('st-has-tooltip-show');
            document.removeEventListener('keydown', keyHandler);
        }

        // Fermeture des infobulles avec ESC
        function keyHandler(e) {
            if (e.key === 'Escape') {
                logos.forEach(logo => {
                    if (logo.classList.contains('st-has-tooltip-show')) {
                        logo.classList.remove('st-has-tooltip-show');
                    }
                });
            }
        }

         // Affichage des infobulles au survol et au focus
        const logos = slider.querySelectorAll('.st-container');
        logos.forEach(logo => {
            logo.addEventListener('mouseenter', onLogoHover);
            logo.addEventListener('mouseleave', onLogoLeave);
            logo.addEventListener('focus', onLogoHover);
            logo.addEventListener('blur', onLogoLeave);
        });
    });



})();