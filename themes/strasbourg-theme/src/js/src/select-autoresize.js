// Actualise la largeur d'un input select quand on change d'option
(function () {
    setTimeout(() => {
        const selectList = document.querySelectorAll('.st-js-select-autoresize');
        selectList.forEach(select => {
            select.addEventListener('change', (e) => {
                // Crée un faux select, remplit avec l'option courante, récupère la largeur et supprime le select
                let realSelect = e.target;
                let tempSelect = document.createElement('select'),
                    tempOption = document.createElement('option');

                tempOption.textContent = realSelect.options[realSelect.selectedIndex].text;
                tempSelect.style.cssText += 'visibility: hidden; position: fixed;';
                tempSelect.appendChild(tempOption);
                realSelect.after(tempSelect);

                const tempSelectWidth = tempSelect.getBoundingClientRect().width;
                tempSelect.remove();
                if (tempSelectWidth > 0) {
                    realSelect.style.width = `${tempSelectWidth}px`;
                }
            });

            // calcul une première fois
            select.dispatchEvent(new Event('change'));
        });
    }, 200);

})();