class DisclosureButtonTranscription {
    constructor(buttonNode) {
        this.buttonNode = buttonNode;
        this.controlledNode = false;
        this.showLabel = this.buttonNode.getAttribute("data-open-label");
        this.hideLabel = this.buttonNode.getAttribute("data-close-label");

        var id = this.buttonNode.getAttribute('aria-controls');

        if (id) {
            this.controlledNode = document.getElementById(id);
        }

        this.buttonNode.setAttribute('aria-expanded', 'false');
        this.hideContent();

        this.buttonNode.addEventListener('click', this.onClick.bind(this));
        this.buttonNode.addEventListener('focus', this.onFocus.bind(this));
        this.buttonNode.addEventListener('blur', this.onBlur.bind(this));
    }

    showContent() {
        if (this.controlledNode) this.controlledNode.classList.remove('st-is-hidden');
        if (this.hideLabel) this.buttonNode.textContent = this.hideLabel;
    }

    hideContent() {
        if (this.controlledNode) this.controlledNode.classList.add('st-is-hidden');
        if (this.showLabel) this.buttonNode.textContent = this.showLabel;
    }

    toggleExpand() {
        if (this.buttonNode.getAttribute('aria-expanded') === 'true') {
            this.buttonNode.setAttribute('aria-expanded', 'false');
            this.hideContent();
        } else {
            this.buttonNode.setAttribute('aria-expanded', 'true');
            this.showContent();
        }
    }

    /* EVENT HANDLERS */

    onClick() {
        this.toggleExpand();
    }

    onFocus() {
        this.buttonNode.classList.add('focus');
    }

    onBlur() {
        this.buttonNode.classList.remove('focus');
    }
}

/* Initialize Hide/Show Buttons */

window.addEventListener(
    'load',
    function () {
        var buttons = document.querySelectorAll(
            '.st-js-btn-disclosure-transcription[aria-expanded][aria-controls]'
        );

        for (var i = 0; i < buttons.length; i++) {
            new DisclosureButtonTranscription(buttons[i]);
        }
    },
    false
);