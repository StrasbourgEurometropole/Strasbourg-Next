(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-dossiers');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            padding: { right: 40 }
        }).mount();
    });

})();