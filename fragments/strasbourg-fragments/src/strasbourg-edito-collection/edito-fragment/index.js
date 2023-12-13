if(document.getElementsByClassName('has-edit-mode-menu').length != 0) {
// Initialisation de la classe
  let sliderAncre;        // instance de splide utililisé plus loin dans la lib th_ancres.js
  const slidersAncre = document.querySelector('.st-js-slider-ancres');
  if (slidersAncre) {
    new BarreDesAncres(slidersAncre);
  }
}
