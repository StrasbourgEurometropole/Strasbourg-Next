(function () {

    // Init des sliders
    setTimeout(function() {
        const sliders = document.querySelectorAll('.st-js-slider-galerie');
        sliders.forEach(slider => {

            const splide = new Splide(slider, {
                pagination: true,

            });
            splide.on('mounted', function () {
                for (const list of splide.Components.Elements.slides) {
                    list.setAttribute('role', 'presentation');
                }
            });
            splide.mount();
        });
    }, 250);


})();