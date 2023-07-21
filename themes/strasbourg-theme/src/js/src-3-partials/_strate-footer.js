(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-partenaires');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: false,
            autoplay: false,
            easing: "ease",
            lazyLoad: 'nearby',
            autoWidth: true,
            focus: 0,
            omitEnd: true,
            breakpoints: {
                600: {
                    pagination: true,
                }
            }
        }).mount();
    });

})();