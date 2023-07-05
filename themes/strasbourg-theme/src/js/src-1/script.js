// Languages selector
$('.js-lang-dropdown-desktop > a').on("click", function (e) {
    e.preventDefault();
    $(this).next().toggleClass("is-open");
});

if (isIE()) {
    document.getElementsByTagName('body')[0].className += ' ie';
}

if (isNoHover()) {
    document.getElementsByTagName('body')[0].className += ' no-hover';
}

th_accordeon.init();
th_overlay.init();
th_expand.parse();
th_ancres.init();

thVheight.init();


// affichage des overlays possible que a partie de 2s
setTimeout(function () {
    $('body').addClass('overlay-load');
}, 1000);

// Lazyload
var lazyLoadInstance = new LazyLoad({
    elements_selector: ".lazy"
});

// Lancement du script Librairie Zoombox
$('.zoombox').zoombox();

/* Detect the scroll of the page down */
document.addEventListener('scroll', function () {
    var st = $(this).scrollTop();

    if (st > 100) {
        $("body").addClass("st-is-scrolled");
    } else {
        $("body").removeClass("st-is-scrolled");
    }
});


/* Detect the scroll of the page up */
var lastscrolltop = 0;
var lastIsDirTop = 0;
document.addEventListener('scroll', function () {
    var st = $(document).scrollTop();
    if (st < lastscrolltop && lastIsDirTop == 0) {
        lastIsDirTop = 1;
        $(document.body).addClass('scrolldir-top', true);
    }
    if (st > lastscrolltop && lastIsDirTop == 1) {
        lastIsDirTop = 0;
        $(document.body).removeClass('scrolldir-top', true);
    }
    lastscrolltop = st;
});

$('a figcaption').on('touchstart click', function (e) {
    e.stopPropagation();
    e.preventDefault();
});


