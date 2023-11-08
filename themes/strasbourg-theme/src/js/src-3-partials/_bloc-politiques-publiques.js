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