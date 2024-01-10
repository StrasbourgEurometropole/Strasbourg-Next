(function () {

    class Accordion {
        constructor(domNode) {
            this.rootEl = domNode;
            this.btnTrigger = this.rootEl.querySelector('button[aria-expanded]');

            const controlsId = this.btnTrigger.getAttribute('aria-controls');
            this.contentEl = document.getElementById(controlsId);

            this.open = this.btnTrigger.getAttribute('aria-expanded') === 'true';

            // add event listeners
            this.btnTrigger.addEventListener('click', this.onButtonClick.bind(this));

            this.measureContentHeight();
            // recalculate content expanded height when resize
            window.addEventListener('resize', e => this.measureContentHeight(e) );
        }

        // Recalculate content expanded height when window resize
        measureContentHeight(e) {
            this.contentEl.style.setProperty('--height-open', this.contentEl.scrollHeight + 'px');
        }

        onButtonClick() {
            this.toggle(!this.open);
        }

        toggle(open) {
            // don't do anything if the open state doesn't change
            if (open === this.open) {
                return;
            }

            // update the internal state
            this.open = open;

            // handle DOM updates
            this.btnTrigger.setAttribute('aria-expanded', `${open}`);
            if (open) {
                this.measureContentHeight();
                this.contentEl.removeAttribute('aria-hidden');
                this.contentEl.removeAttribute('inert');
                this.rootEl.classList.add('st-is-open');
            } else {
                this.contentEl.setAttribute('aria-hidden', 'true');
                this.contentEl.setAttribute('inert', '');
                this.rootEl.classList.remove('st-is-open');
            }
        }

        // Add public open and close methods for convenience
        open() {
            this.toggle(true);
        }

        close() {
            this.toggle(false);
        }
    }

    // Initialisation de la classe
    const accordions = document.querySelectorAll(".st-js-accordion");
    accordions.forEach(container => {
        new Accordion(container);
    });
})();