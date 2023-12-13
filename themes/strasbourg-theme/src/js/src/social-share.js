// Affichage des liens de partage
(function () {
    const socialShare = document.querySelector('.st-js-social-share');
    if (socialShare) {
        const btn = socialShare.querySelector('.st-social-share__toggle');

        btn.addEventListener('click', (e) => {
            if (btn.getAttribute('aria-expanded') === 'true') {
                btn.setAttribute('aria-expanded', 'false');
            } else {
                btn.setAttribute('aria-expanded', 'true');
            }
        });
    }
})();