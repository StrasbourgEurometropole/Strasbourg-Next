// Actualise la largeur d'un input select quand on change d'option
(function () {
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
            realSelect.style.width = `${tempSelectWidth}px`;
            tempSelect.remove();
        });

        // calcul une première fois
        select.dispatchEvent(new Event('change'));
    });
})();