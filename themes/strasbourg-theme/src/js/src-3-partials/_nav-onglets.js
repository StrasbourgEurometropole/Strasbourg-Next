(function () {
    // Barre de navigation sur les pages presse
    // Init des sliders
    const sliders = document.querySelectorAll('.st-js-nav-onglets');
    sliders.forEach(slider => {

        const splide = new Splide(slider, {
            padding: { left: 0, right: 40 }
        }).mount();
    });

    // Select sur la version mobile
    const select = document.querySelector('.st-js-nav-select');
    if(select) {
        select.addEventListener('change', (e) => {
            window.location.href = select.options[select.selectedIndex].value;
        });
    }
})();