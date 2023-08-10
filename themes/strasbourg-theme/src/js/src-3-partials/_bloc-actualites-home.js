(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-actu-home');
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
    });

})();