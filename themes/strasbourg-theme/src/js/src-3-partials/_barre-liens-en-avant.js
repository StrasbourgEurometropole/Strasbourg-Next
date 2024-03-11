(function () {

    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-slider-barre-liens');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            pagination: false,
            autoplay: false,
            easing: "ease",
            lazyLoad: 'nearby',
            autoWidth: true,
            focus: 0,
            omitEnd: true,
        });
        splide.on('mounted', function () {
            for (const list of splide.Components.Elements.slides) {
                list.setAttribute('role', 'presentation');
            }
        });
        splide.mount();
    });

})();