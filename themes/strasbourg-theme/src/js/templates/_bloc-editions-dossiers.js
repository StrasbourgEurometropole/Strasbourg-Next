(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-dossiers');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: true,
            autoplay: false,
            easing: "ease",
            lazyLoad: 'nearby',
            autoWidth: true,
            focus: 0,
            omitEnd: true,
        }).mount();
    });

})();