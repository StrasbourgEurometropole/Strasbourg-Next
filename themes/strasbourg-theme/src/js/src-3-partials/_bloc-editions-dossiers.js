(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-dossiers');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            padding: { right: 40 }
        });
        splide.on('mounted', function () {
            for (const list of splide.Components.Elements.slides) {
                list.setAttribute('role', 'tabpanel');
            }
        });
        splide.mount();
    });

})();