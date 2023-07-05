// JS qui concerne les single SIT
(function () {

    if (document.body.classList.contains('single-fakesit')) {       /* à changer en single-sit sur un vrai projet */

        // Init des sliders de la page
        // ==========================================================================

        // Init du slider de galerie
        let sliders = document.querySelectorAll('.js-slider-sit-galerie');
        sliders.forEach(slider => {
            const splide = new Splide(slider, {
                breakpoints: {
                    600: {
                        arrows: false,
                    },
                }
            }).mount();
        });

        // Init du slider des horaires
        sliders = document.querySelectorAll('.js-slider-sit-horaires');
        sliders.forEach(slider => {
            const splide = new Splide(slider).mount();
        });

        // Init du slider du bloc relation
        sliders = document.querySelectorAll('.js-slider-sit-relation');
        sliders.forEach(slider => {
            const splide = new Splide(slider, {
                breakpoints: {
                    600: {
                        arrows: false,
                    },
                }
            }).mount();
        });


        // Boutons "Voir plus", quand texte tronqué sur les blocs "À propos"
        // ==========================================================================
        const blocViewMore = document.querySelectorAll('.single-fakesit .js-view-more');        /* à changer en single-sit sur un vrai projet */
        blocViewMore.forEach(item => {
            const content = item.querySelector('[data-view-more-content]');
            const trigger = item.querySelector('[data-view-more-trigger]');

            // Comportement de viewmore sur le bloc si sa hauteur est suffisante
            if (content && content.getBoundingClientRect().height >= 220) {
                item.classList.add('view-more-active');

                trigger.addEventListener('click', function () {
                    item.classList.toggle('is-expanded');
                });
            }
        });


        // Bouton dans la barre sticky pour scroller jusqu'au bloc "Carte"
        // ==========================================================================
        const btnMapAnchor = document.querySelector('.js-map-anchor');
        if (btnMapAnchor) {
            btnMapAnchor.addEventListener('click', function (e) {
                e.preventDefault();
                const hash = this.hash;
                const target = document.querySelector(hash);
                const header = document.querySelector('.js-barre-navigation');

                // Y offset pour le sticky header
                const offset = (header) ? header.offsetHeight : 0;
                const targetTop = window.scrollY + target.getBoundingClientRect().top - offset - 20;

                $('html, body').animate({
                    scrollTop: targetTop
                }, 800, function () {
                    window.location.hash = hash;
                });
            });
        }
    }


})();

