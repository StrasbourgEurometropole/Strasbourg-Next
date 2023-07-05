// Fichier contenant des configurations globales à tout les sliders Splide sur le site

Splide.defaults = {
    easing: 'cubic-bezier(0.5, 1, 0.89, 1)',
    updateOnMove: true,         // ajoute la classe is-active au slide actif, dés que le slider bouge
    pagination: false,          // pas de dots ajoutés
    autoWidth: true,            // on laisse le css gèrer la largeur des slides, pas de surcharge en js
    focus: 0,                   // quand plusieurs slides visibles (ex: slider instagram), détermine quelle slide reçoit l'état actif
    omitEnd: true,              // quand plusieurs slides visibles, désactive le bouton next quand on est à la fin du slider (focus doit être à 0)
};