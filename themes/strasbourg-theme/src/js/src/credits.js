// Affichage des crédits sur les images
(function () {
    const btnsCredits = document.querySelectorAll('.st-js-credits');
    btnsCredits.forEach(btn => {
        // Affichage / masquage au click
        btn.addEventListener('click', (e) => {
            if (btn.getAttribute('aria-expanded') === 'true') {
                btn.setAttribute('aria-expanded', 'false');
            } else {
                btn.setAttribute('aria-expanded', 'true');
            }
        });

        // Affichage au survol
        btn.addEventListener('mouseenter', (e) => {
            if (btn.getAttribute('aria-expanded') === 'false') {
                btn.setAttribute('aria-expanded', 'true');
            }
        });

        btn.addEventListener('mouseleave', (e) => {
            if (btn.getAttribute('aria-expanded') === 'true') {
                btn.setAttribute('aria-expanded', 'false');
            }
        });
    });
})();