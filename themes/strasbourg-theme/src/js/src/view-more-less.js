(function () {

    class ViewMoreLess {
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

            this.showClampBtn();
            this.btnClampHandler();
        }

        showClampBtn() {
            if (this.height >= this.maxHeightValue) {
                this.container.classList.add("st--is-overflowing");
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
            this.container.focus();

            // Styles
            this.btnClamp.classList.add("st--btn-outline");
            this.btnClamp.classList.remove("st--down");
            this.btnClamp.classList.add("st--up");
            this.container.style.setProperty('--max-height-desktop', 'none');

            this.btnClamp.textContent = this.hideLabel;
            this.btnClamp.dispatchEvent(this.showEvent);
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
        }
    }

    // Initialisation de la classe
    const limitedContainers = document.querySelectorAll(".st-limit-height");
    limitedContainers.forEach(container => {
        new ViewMoreLess(container);
    });


})();