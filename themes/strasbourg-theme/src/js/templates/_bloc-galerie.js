(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-galerie');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,

        }).mount();
    });

})();