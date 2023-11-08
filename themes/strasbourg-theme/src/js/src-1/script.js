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

