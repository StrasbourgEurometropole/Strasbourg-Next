if (isNoHover()) {
    document.getElementsByTagName('body')[0].className += ' no-hover';
}

th_overlay.init();
th_ancres.init();


// affichage des overlays possible que a partie de 2s
setTimeout(function () {
    $('body').addClass('overlay-load');
}, 1000);

// Lazyload
var lazyLoadInstance = new LazyLoad({
    elements_selector: ".lazy"
});

/* Detect the scroll of the page down */
document.addEventListener('scroll', function () {
    var st = $(this).scrollTop();

    if (st > 100) {
        $("body").addClass("st-is-scrolled");
    } else {
        $("body").removeClass("st-is-scrolled");
    }
});



const selectA11ys = document.querySelectorAll('select[data-select-a11y]');
selectA11ys.forEach(select => {
    new Select(select);
});



// Gestion des inputs avec autocomplete avec la lib accessible-autocomplete
// https://alphagov.github.io/accessible-autocomplete/
// https://alphagov.github.io/accessible-autocomplete/examples/
// Exemple sur la barre des fitres du listing des associations
const autocompleteElement = '#filter-autocomplete-keywords-container';

if (document.querySelector(autocompleteElement)) {
    // Tableau avec les termes pour l'autocomplete
    const keywordsList = [
        'Chant',
        'Chorale',
        'Danse',
        'Danse classique',
        'Danse-contact',
        'Danse hip-hop',
        'Danse de rue',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Danse tango',
        'Écriture',
        'Dessin',
        'Poésie',
        'Musique',
        'Poterie',
        'Sport',
        'Sport nautique',
        'Théatre',
        'Vélo',
    ];

    accessibleAutocomplete({
        element: document.querySelector('#filter-autocomplete-keywords-container'),
        id: 'filter-autocomplete-keywords', // To match it to the existing <label>.
        source: keywordsList,
        displayMenu: 'overlay',
        placeholder: 'Saisir un mot clé…',
        minLength: 3,
        showAllValues: false,
        dropdownArrow: () => '<span class="st-icon-arrow-down"></span>',
        tNoResults: () => 'Aucun résultat trouvé',
        tStatusNoResults: () => 'Aucun résultat trouvé',
        tStatusQueryTooShort: (minQueryLength) => `Tapez ${minQueryLength} caractères ou plus pour avoir des résultats`,
        tStatusSelectedOption: (selectedOption, length, index) => `${selectedOption} ${index + 1} sur ${length} sont affichés`,
        tStatusResults: (length, contentSelectedOption) => {
            const words = {
                result: (length === 1) ? 'résultat' : 'resultats',
                is: (length === 1) ? 'est' : 'sont'
            }

            return `<span>{length} {words.result} {words.is} disponible. {contentSelectedOption}</span>`
        },
        tAssistiveHint: () => 'Lorsque les résultats de la saisie semi-automatique sont disponibles, utilisez les flèches haut et bas pour les consulter et taper sur entrée pour les sélectionner. Sur les appareils tactiles, explorez les au toucher ou avec des gestes de glissement.',
    });
}

