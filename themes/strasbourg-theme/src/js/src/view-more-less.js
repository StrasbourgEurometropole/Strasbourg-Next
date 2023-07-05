(function () {

    class ViewMoreLess {
        constructor(container) {
            this.container = container;
            this.height = container.offsetHeight;
            this.btnClamp = container.nextElementSibling.querySelector(".st-btn-arrow");
            this.maxHeightVariable = getComputedStyle(container).getPropertyValue('--max-height-desktop')
            this.maxHeightValue = parseInt(this.maxHeightVariable);

            this.showClampBtn(container);
            this.btnClampHandler();
        }

        showClampBtn(container) {

            if (this.height >= this.maxHeightValue) {
                container.classList.add("st--is-overflowing");
            } else {
                container.classList.remove("st--is-overflowing");
            }
        }

        btnClampHandler() {
            let btnClampClicked = false;

            let outerScope = this;

            this.btnClamp.addEventListener('click', function (e) {

                if (btnClampClicked === false) {
                    outerScope.btnClampIsActive();

                } else {
                    outerScope.btnClampIsInactive();
                }

                btnClampClicked = !btnClampClicked;
            });

        }

        btnClampIsActive() {
            this.setAccessibleAttributes();
            this.setActiveStyles();
        }

        setAccessibleAttributes() {
            let dataOpenLabel = this.btnClamp.getAttribute("data-open-label");
            let dataCloseLabel = this.btnClamp.getAttribute("data-close-label");

            this.btnClamp.setAttribute("aria-expanded", true);
            this.btnClamp.setAttribute("aria-label", dataCloseLabel);

            this.container.setAttribute("tabindex", "-1");
            this.container.focus();
        }

        updateAccessibleAttributes() {
            let dataOpenLabel = this.btnClamp.getAttribute("data-open-label");
            let dataCloseLabel = this.btnClamp.getAttribute("data-close-label");
            this.btnClamp.setAttribute("aria-expanded", false);
            this.btnClamp.setAttribute("aria-label", dataOpenLabel);
            this.container.setAttribute("tabindex", "0");
        }

        setActiveStyles() {
            this.btnClamp.classList.add("st--btn-outline");
            this.btnClamp.classList.remove("st--down");
            this.btnClamp.classList.add("st--up");
            this.container.style.setProperty('--max-height-desktop', 'none');
        }

        updateActiveStyles() {
            this.btnClamp.classList.remove("st--btn-outline");
            this.btnClamp.classList.add("st--down");
            this.btnClamp.classList.remove("st--up");
            this.container.style.setProperty('--max-height-desktop', this.maxHeightVariable);
        }

        btnClampIsInactive() {
            this.updateAccessibleAttributes();
            this.updateActiveStyles();
        }
    }

    // Initialisation de la classe
    const limitedContainers = document.querySelectorAll(".st-limit-height");
    limitedContainers.forEach(container => {
        new ViewMoreLess(container);
    });


})();