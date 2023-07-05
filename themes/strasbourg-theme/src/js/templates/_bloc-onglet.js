(function () {

    var sliderThumbs = document.querySelectorAll(".st-js-slider-onglet");

    if (sliderThumbs) {
        sliderThumbs.forEach(slider => {

            // Init du slider avec les horaires sous forme d'onglet
            const thumbnails = new Splide(slider, {
                pagination: false,
                isNavigation: true,
                focus: "center",
                omitEnd: false,
            });

            let sliderContent = slider.nextElementSibling;

            // Init du slider avec les horaires sous forme d'onglets
            const main = new Splide(sliderContent, {
                type: 'fade',
                rewind: false,
                pagination: false,
                arrows: false,
                drag: false,
                focus: "center",
                omitEnd: false,
            });


            main.sync(thumbnails);
            main.mount();
            thumbnails.mount();
        });
    }

})();