// Gestion de la tabulation dans les modales
(function () {
    // éléments focalisables contenus dans la fenêtre modale
    const focusableElementsArray = [
        '[href]',
        'button:not([disabled])',
        'input:not([disabled])',
        'select:not([disabled])',
        'textarea:not([disabled])',
        '[tabindex]:not([tabindex="-1"])',
    ];

    let focusableElements;
    let firstFocusableElement;
    let lastFocusableElement;

    // Boucle de la tabulation suivante / précédente au sein de la modale
    function onKeyDown(event) {
       //console.log('\n•onKeyDown', event.target);

        if (event.key !== 'Tab') return;
        if (event.shiftKey) {
            if (event.target === firstFocusableElement) { // shift + tab
                event.preventDefault();
                lastFocusableElement.focus();
            }
        } else if (event.target === lastFocusableElement) { // tab
            event.preventDefault();
            firstFocusableElement.focus();
        }
    }

    // Ouverture de la modale
    function onOverlayOpen(overlayId) {
        const overlay = document.getElementById(overlayId);

        if(overlay) {
            focusableElements = overlay.querySelectorAll(focusableElementsArray);
            firstFocusableElement= focusableElements[0];
            lastFocusableElement = focusableElements[focusableElements.length - 1];

            // return if no focusable element
            if (!firstFocusableElement) {
                return;
            }

            setTimeout(() => {
                firstFocusableElement.focus();

                // trapping focus inside the dialog
                focusableElements.forEach((focusableElement) => {
                    if (focusableElement.addEventListener) {
                        focusableElement.addEventListener('keydown', onKeyDown);
                    }
                });
            }, 100);
        }
    }

    th_overlay.addCallbackOpen(onOverlayOpen);
})();