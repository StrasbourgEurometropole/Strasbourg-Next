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


var selects = document.querySelectorAll('select[data-select-a11y]');

var selectA11ys = Array.prototype.map.call(selects, function(select){
    return new Select(select);
});

// Exemple d'instanciation avec le paramètre "text" des libellés d'aide du composant
/*
var selects = document.querySelectorAll('select[data-select-a11y]');

var selectA11ys = Array.prototype.map.call(selects, function(select){
  new Select(select, {
    text:{
      help: 'Utilisez la tabulation (ou la touche flèche du bas) pour naviguer dans la liste des suggestions',
      placeholder: 'Rechercher dans la liste',
      noResult: 'Aucun résultat',
      results: '{x} suggestion(s) disponibles',
      deleteItem: 'Supprimer {t}',
      delete: 'Supprimer'
   }
  })
});
*/



