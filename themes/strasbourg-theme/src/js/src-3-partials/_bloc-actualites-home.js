(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-actu-home');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            arrows: false,
            autoplay: false,
            easing: "ease",
            lazyLoad: 'nearby',
            autoWidth: true,
            focus: 0,
            omitEnd: true,
            mediaQuery: 'min',
            destroy: false,
            breakpoints: {
                980: {
                    destroy: true,
                    pagination: false,
                }
            }
        }).mount();
    });

})();