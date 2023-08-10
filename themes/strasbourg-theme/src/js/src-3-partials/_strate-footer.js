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

         splide.mount();
    });
})();