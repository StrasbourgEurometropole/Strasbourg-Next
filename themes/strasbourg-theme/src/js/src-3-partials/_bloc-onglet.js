(function () {

    const sliderThumbs = document.querySelectorAll('.st-js-slider-onglet');
    sliderThumbs.forEach(slider => {

        // Init du slider avec les horaires sous forme d'onglet
        const splideThumbs = new Splide(slider, {
            isNavigation: true,
            omitEnd: false,
        });

        // Slider du contenu
        const container = slider.closest('.st-container');
        const sliderContent = container && container.querySelector('.st-js-slider-onglet-content');

        // Init du slider avec les horaires sous forme d'onglets
        if(sliderContent) {
            const splideContent = new Splide(sliderContent, {
                type: 'fade',
                rewind: false,
                arrows: false,
                drag: false,
                focus: "center",
                omitEnd: false,
            });

            splideContent.sync(splideThumbs);
            splideContent.mount();
            splideThumbs.mount();
        }
    });
})();