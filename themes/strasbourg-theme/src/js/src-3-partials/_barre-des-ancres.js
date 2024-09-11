class BarreDesAncres {
    constructor(container) {
        this.container = container;
        this.btnPrev = this.container.querySelector('.st-btn-arrow.st--prev');
        this.btnNext = this.container.querySelector('.st-btn-arrow.st--next');
        this.list = this.container.querySelector('.st-ancres__list');

        if (this.list) this.initArrows();
        this.fadeOnSocialShareClick(container);
    }

    // Défilement de la liste des ancres en overflow avec les flèches sur mobile
    initArrows() {
        this.btnPrev.addEventListener('click', (e) => {
            this.list.scrollBy({ left: -200, behavior: "smooth" });
        });
        this.btnNext.addEventListener('click', (e) => {
            this.list.scrollBy({ left: 200, behavior: "smooth" });
        });

        // find .st-small-header and add class .st-header-with-sticky and remove class .st-small-header
        const smallHeader = document.querySelector('.st-small-header');
        if (smallHeader) {
            smallHeader.classList.remove('st-small-header');
            smallHeader.classList.add('st-header-with-sticky');
        }

    }

    fadeOnSocialShareClick(slider) {
        const toggleInput = this.container.querySelector(".st-social-share__toggle");

        if (toggleInput) {
            toggleInput.addEventListener("click", (e) => {
                this.container.classList.toggle("st-has-social-share-open");
            });
        }
    }
}

// Initialisation de la classe
const barreAncres = document.querySelector('.st-js-ancres');
if (barreAncres) {
    new BarreDesAncres(barreAncres);
}
