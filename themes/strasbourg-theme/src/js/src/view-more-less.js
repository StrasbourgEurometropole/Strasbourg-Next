(function () {

    class ViewMoreLess {
        // éléments focalisables
        static focusableElementsArray = [
            '[href]',
            'button:not([disabled])',
            'input:not([disabled])',
            'select:not([disabled])',
            'textarea:not([disabled])',
            '[tabindex]:not([tabindex="-1"])',
        ];
        constructor(container) {
            this.container = container;
            this.height = container.offsetHeight;
            this.btnClamp = container.nextElementSibling.querySelector(".st-btn-show-more");

            this.maxHeightVariable = getComputedStyle(container).getPropertyValue('--max-height-desktop')
            this.maxHeightValue = parseInt(this.maxHeightVariable);
            this.showLabel = this.btnClamp.getAttribute("data-open-label");
            this.hideLabel = this.btnClamp.getAttribute("data-close-label");

            this.showEvent = new Event('showViewMore', { bubbles: true });
            this.hideEvent = new Event('hideViewMore', { bubbles: true });

            // éléments qui dépassent du container
            this.childrenHidden = [];

            this.showClampBtn();
            this.btnClampHandler();
        }

        // Détecte si un élément est inclus complétement dans son parent
        isInParent(child, parent) {
            const parentCoords = parent.getBoundingClientRect();
            const childCoords = child.getBoundingClientRect();

            if(childCoords.top >= parentCoords.top &&
               childCoords.right <= parentCoords.right &&
                childCoords.bottom <= parentCoords.bottom &&
                childCoords.left >= parentCoords.left
                ) {
                return true;
            } else {
                return false;
            }
        }

        // Gestion de l'accessibilité des éléments qui sont masqués ou partiellement masqués dans le container
        initRGAA() {
            for (let child of this.container.children) {
                const isInside = this.isInParent(child, child.parentNode);

               // élément en dehors du parent
                if(!isInside) {
                    this.childrenHidden.push(child);
                    this.hideChildrenForSR(child);
                }
            }
        }


        // Rend inaccessible au clavier les enfants qui sont masqués ou partiellement masqués dans le container
        hideChildrenForSR(el) {
            el.setAttribute("aria-hidden", 'false');
            if (el.matches(ViewMoreLess.focusableElementsArray)) {
                el.setAttribute("tabindex", "-1");
            }

            const focusableElements = el.querySelectorAll(ViewMoreLess.focusableElementsArray);
            focusableElements.forEach(focusableElement => {
                focusableElement.setAttribute("tabindex", "-1");
            });
        }


        // Quand on ouvre le view-more affiche les enfants précédemment masqués
        showChildrenForSR(el) {
            el.removeAttribute("aria-hidden");
            el.removeAttribute("tabindex");
            if (this.firstChildFocus === null && el.matches(ViewMoreLess.focusableElementsArray)) {
                this.firstChildFocus = el;
                this.firstChildFocus.focus();
            }

            const focusableElements = el.querySelectorAll(ViewMoreLess.focusableElementsArray);
            focusableElements.forEach(focusableElement => {
                focusableElement.removeAttribute("tabindex");

                // Focus sur le 1er élément cliquable
                if(this.firstChildFocus === null) {
                    this.firstChildFocus = focusableElement;
                    this.firstChildFocus.focus();
                }
            });
        }


        showClampBtn() {
            if (this.height >= this.maxHeightValue) {
                this.container.classList.add("st--is-overflowing");

                if (!this.container.classList.contains('st-no-auto-rgaa')) {
                    this.initRGAA();
                }
            } else {
                this.container.classList.remove("st--is-overflowing");
            }
        }

        btnClampHandler() {
             this.btnClamp.addEventListener('click',  (e) => {
                if (this.btnClamp.getAttribute('aria-expanded') === 'false') {
                    this.showContent();
                } else {
                    this.hideContent();
                }
            });
        }

        // Déploie le container
        showContent() {
            // Accessible attributes
            this.btnClamp.setAttribute("aria-expanded", 'true');
            this.container.setAttribute("tabindex", "-1");

            // Styles
            this.btnClamp.classList.add("st--btn-outline");
            this.btnClamp.classList.remove("st--down");
            this.btnClamp.classList.add("st--up");
            this.container.style.setProperty('--max-height-desktop', 'none');

            this.btnClamp.textContent = this.hideLabel;
            this.btnClamp.dispatchEvent(this.showEvent);

            // Rend accessible les éléments précédemment masqués
            this.firstChildFocus = null;        // focus sur le 1er élément interactif
            this.childrenHidden.forEach(child => {
                this.showChildrenForSR(child);
            });
        }

        // Referme le container
        hideContent() {
            // Accessible attributes
            this.btnClamp.setAttribute("aria-expanded", 'false');
            this.container.setAttribute("tabindex", "0");

            // Styles
            this.btnClamp.classList.remove("st--btn-outline");
            this.btnClamp.classList.add("st--down");
            this.btnClamp.classList.remove("st--up");
            this.container.style.setProperty('--max-height-desktop', this.maxHeightVariable);

            this.btnClamp.textContent = this.showLabel;
            this.btnClamp.dispatchEvent(this.hideEvent);

            // Masque les éléments en dehors du container
            this.childrenHidden.forEach(child => {
                this.hideChildrenForSR(child);
            });
        }
    }

    // Initialisation de la classe
    const limitedContainers = document.querySelectorAll(".st-limit-height");
    limitedContainers.forEach(container => {
        new ViewMoreLess(container);
    });


})();