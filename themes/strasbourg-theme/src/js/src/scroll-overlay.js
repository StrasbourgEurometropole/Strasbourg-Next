// Fait défiler un contenu en overflow avec un bouton de flèche
(function () {
    const btns = document.querySelectorAll('.st-js-scroll-overlay');
    btns.forEach(btn => {
        btn.addEventListener('click', (e) => {
            const content = btn.parentNode.querySelector('.st-overlay__body');
            if(content) content.scrollBy({ top: 200, behavior: "smooth" });
        });
    });
})();