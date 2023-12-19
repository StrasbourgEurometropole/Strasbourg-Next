(function () {

    // Init des sliders
    setTimeout(function() {
        const sliders = document.querySelectorAll('.st-js-slider-focus');
        sliders.forEach(slider => {

            const splide = new Splide(slider, {
                pagination: true,

                breakpoints: {
                    600: {
                        pagination: false,
                    }
                }
            }).mount();
        });
    }, 250);


})();