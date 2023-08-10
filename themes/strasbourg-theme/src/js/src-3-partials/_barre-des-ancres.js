class BarreDesAncres {
    constructor(slider) {
        this.slider = slider;
        this.initSlider(slider);
        this.fadeOnSocialShareClick(slider);
        this.stickyPositionHandler(slider);
    }

    initSlider(slider) {
        sliderAncre = new Splide(slider, {
            wheel: true,
            releaseWheel: true,
            height: "321px",
            autoHeight: true,
            pagination: false,
            direction: 'ttb',
            arrows: false,
            breakpoints: {
                980: {
                    direction: 'ltr',
                    height: "60px",
                    arrows: true
                },
            }         // espace pour les flèches de navigation
        }).mount();
    }

    fadeOnSocialShareClick(slider) {
        let toggleInput = document.querySelector(".st-social-share .st-toggle");

        if (toggleInput) {
            let toggleParent = toggleInput.closest(".st-social-share");
            let slider = toggleParent.previousElementSibling;
            toggleInput.addEventListener("click", function () {
                slider.classList.toggle("st-js-toggle");
            });
        }

    }

    stickyPositionHandler(slider) {
        const footer = document.querySelector(".st-footer");
        const ancresContainer = document.querySelector(".st-ancres");

        let options = {
            rootMargin: "0px",
            threshold: 0.1,
        };

        let callback = (entries, observer) => {
            entries.forEach((entry) => {
                if (entry.isIntersecting) {
                    ancresContainer.classList.add("st-footer-is-visible");
                } else {
                    ancresContainer.classList.remove("st-footer-is-visible");
                }
            });
        };

        let observer = new IntersectionObserver(callback, options);

        observer.observe(footer);
    }

}

// Initialisation de la classe
let sliderAncre;        // instance de splide utililisé plus loin dans la lib th_ancres.js
const slidersAncre = document.querySelector('.st-js-slider-ancres');
if (slidersAncre) {
    new BarreDesAncres(slidersAncre);
}
