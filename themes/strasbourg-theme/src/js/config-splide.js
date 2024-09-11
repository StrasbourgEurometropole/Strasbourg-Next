// Objet de traductions en fonction de la langue à passer aux options de Splide
const splideTranslations =  {
    prev       :"Slide précédente",
    next       :"Slide suivante",
    first      :"Aller à la première slide",
    last       :"Aller à la dernière slide",
    slideX     :"Aller à la slide %s",
    pageX      :"Aller à la page %s",
    play       :"Démarrer la lecture automatique",
    pause      :"Mettre en pause la lecture automatique",
    carousel   :"carousel",
    select     :"Sélectionner une slide à afficher",
    slide      :"slide",
    slideLabel :"%s de %s",
}

// Fichier contenant des configurations globales à tout les sliders Splide sur le site
Splide.defaults = {
    i18n: splideTranslations,
    easing: 'cubic-bezier(0.5, 1, 0.89, 1)',
    updateOnMove: true,         // ajoute la classe is-active au slide actif, dés que le slider bouge
    pagination: false,          // pas de dots ajoutés
    autoWidth: true,            // on laisse le css gèrer la largeur des slides, pas de surcharge en js
    focus: 0,                   // quand plusieurs slides visibles (ex: slider instagram, détermine quelle slide reçoit l'état actif
    omitEnd: true,              // quand plusieurs slides visibles, désactive le bouton next quand on est à la fin du slider (focus doit être à 0)
};