// Gestion de la tabulation dans les modales

    // éléments focalisables contenus dans la fenêtre modale
    const focusableElementsArray = [
        '[href]',
        'button:not([disabled])',
        'input:not([disabled])',
        'select:not([disabled])',
        'textarea:not([disabled])',
        '[tabindex]:not([tabindex="-1"])',
    ];

    // dans l'overlay de recherche, exclusion des éléments interactifs du footer masqué en desktop
    const focusableElementsArrayInOverlaySearch = [
        '[href]:not(.st-btn-compte)',
        'button:not([disabled])',
        'input:not([disabled])',
        'select:not([disabled]):not(.select-lang)',
        'textarea:not([disabled])',
        '[tabindex]:not([tabindex="-1"])',
    ];

    let focusableElements;
    let firstFocusableElement;
    let lastFocusableElement;

    // Boucle de la tabulation suivante / précédente au sein de la modale
    function onKeyDown(e) {
        if (e.key !== 'Tab') return;

        // shift + tab
        if (e.shiftKey) {
           if (document.activeElement === firstFocusableElement) {
                e.preventDefault();
                lastFocusableElement.focus();
            }
        // tab
        } else {
            if (document.activeElement === lastFocusableElement) {
                e.preventDefault();
                firstFocusableElement.focus();
            }
        }
    }


    // Ouverture de la modale
    function onOverlayOpen(overlayId) {
        const overlay = document.getElementById(overlayId);

        if(overlay) {
            // exclusion de sélecteurs spécifiquement sur l'overlay de recherche
            if (overlayId === 'st-overlay-search') {
                focusableElements = overlay.querySelectorAll(focusableElementsArrayInOverlaySearch);
            } else {
                focusableElements = overlay.querySelectorAll(focusableElementsArray);
            }
            firstFocusableElement= focusableElements[0];
            lastFocusableElement = focusableElements[focusableElements.length - 1];

            // return if no focusable element
            if (!firstFocusableElement) {
                return;
            }

            setTimeout(() => {
                firstFocusableElement.focus();

                // trapping focus inside the dialog
                overlay.addEventListener('keydown', onKeyDown);
            }, 100);
        }
    }

    th_overlay.addCallbackOpen(onOverlayOpen);
