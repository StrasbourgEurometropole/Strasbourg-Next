$(window).scroll(function () {
    if ($(window).scrollTop() > 100) {
        $('.mns-share-button').addClass('fadein');
    }
    else {
        $('.mns-share-button').removeClass('fadein');
    }
});

// Lancement du script de ObjectFit
objectFitImages('.fit-cover img');

// Flexibility
flexibility(document.documentElement);

// FastClick
$(function () {
    FastClick.attach(document.body);
});

// Page Marché - Ouverture / Fermeture du volet
$('.mns-volet-map').click(function () {
    $('#mns-wrapper-volet').toggleClass('expand');
});

// Détecte si l'utilisateur est sur une tablette ou un smartphone
function is_touch_device() {
    try {
        document.createEvent("TouchEvent");
        return true;
    } catch (e) {
        return false;
    }
}

if (is_touch_device() && document.body.clientWidth <= 1024) {
    $('html').addClass('touch-device');
} else {
    $('html').addClass('not-touch-device');
}

$(window).on('resize', function () {
    if (is_touch_device() && document.body.clientWidth <= 1024) {
        $('html').addClass('touch-device');
        $('html').removeClass('not-touch-device');
    } else {
        $('html').removeClass('touch-device');
        $('html').addClass('not-touch-device');
    }
});

var nua = navigator.userAgent;
var is_android_native_browser = ((nua.indexOf('Mozilla/5.0') > -1 && nua.indexOf('Android ') > -1 && nua.indexOf('AppleWebKit') > -1));
if (nua.indexOf('Chrome') > -1) {
    is_android_native_browser = false;
}
if (is_android_native_browser) {
    $('html').addClass('android_browser');
} else {
    $('html').addClass('not_android_b');
}

// Affichage de la Barre de recherche
$('.menu-search').click(function () {
    $('.mns-search-bar').addClass('search-display');
    $('.mns-navbar-wrapper').addClass('mns-navbar-top-translate');
    $('#search').focus();
    $('#layer').addClass('mns-layer');
    if ($('#search-bar').hasClass('search-display')) {
        $('nav').addClass('mns-bigger');
    }
    else {
        $('nav').removeClass('mns-bigger');
    }
});

// Affichage du Masque quand la barre de recherche est ouverte
$('#layer').click(function () {
    $(this).removeClass('mns-layer');
    $('#search-bar').removeClass('search-display');
    $('.mns-navbar-wrapper').removeClass('mns-navbar-top-translate');
    $('nav').removeClass('mns-bigger');
});

$('.menu-search > a').click(function (e) {
    e.preventDefault();
});

// Changement de comportement de la NavBar si nous sommes sur un iPad ou une tablette Android en mode portrait
if ((navigator.userAgent).match(/iPad/i) || ((navigator.userAgent).match(/Tablet/i) && height > width)) {
    $('nav').addClass('mns-nav-scroll', 'mns-nav-ipad');
}
else if ((navigator.userAgent).match(/Android/i)) {
    $('nav').removeClass('mns-nav-scroll', 'mns-nav-ipad');
}
if ($(window).width() > 1200) {
    $('.navbar-nav > li.dropdown').mouseenter(function () {
        $(this).addClass('open');
    });

    $('.navbar-nav > li.dropdown').mouseleave(function () {
        $(this).removeClass('open');
    });

    $(document).keyup(function(e) {
       if (e.key === "Escape") { 
        $('.navbar-nav > li.dropdown.open').removeClass('open');
       }
    });
}


if ((navigator.userAgent).match(/iPad/i) || ((navigator.userAgent).match(/Android/i))) {
    $('.mns-header > video').css('display', 'none');
}

/* Search filtres on mobile */
$('#search-mobile-filtres').click(function (e) {
    e.preventDefault();
    var otop = $('.mns-m-filtres-search').offset().top;
    $('body,html').animate({scrollTop: otop - 80}, 500, function () {

    });
    $('.mns-filtres').slideDown('500');
    $('#search-mobile-filtres').parent().parent().addClass('hide-button');
});

$('#cross-mobile').click(function () {
    $('.mns-filtres').slideUp('500');
    $('.mns-m-filtres-search').removeClass('hide-button');
});

/* For the Agenda's page */
$('.mns-affiner-m').click(function () {
    $('.mns-z-filtres-search').toggleClass('mns-show');
    // $('.mns-z-filtres-search').addClass('row');
    // $(this).parent().parent().toggleClass('hide-button');
});

// Dectect if scroll
// var positionElementInPage = $('.mns-nav').offset().top;

var height = $(window).height();
var width = $(window).width();

if ((navigator.userAgent).match(/iPad/i) || ((navigator.userAgent).match(/Tablet/i)) && height > width) {
    $('body').addClass('ipad');
    $('.mns-nav').addClass("mns-nav-scroll");
    $('.mns-nav').addClass("mns-nav-ipad");
    $(window).scroll(function () {

        if ($(window).scrollTop() == 0) {
            $('.mns-nav-ipad').removeClass('mns-top');
        }
        else {
            $('.mns-nav-ipad').addClass('mns-top');
        }
    });

} else {
    $(window).scroll(
        function () {
            if ($(window).scrollTop() > 0) {
                $('.mns-nav').addClass("mns-nav-scroll");
                $('#layer').addClass('mns-nav-scroll-layer')
            } else {
                $('.mns-nav').removeClass("mns-nav-scroll");
                $('#layer').removeClass('mns-nav-scroll-layer')
            }
        }
    );
}

// Page d'accueil - Comportement en hover sur les grandes bulles
if ($(window).width() >= 1025) {
    $('.mns-bloc-entry > div').mouseenter(function () {
        $(this).find('.caption').addClass('open');
    });
    $('.mns-bloc-entry > div').mouseleave(function () {
        $(this).find('.caption').removeClass('open');
    });
    $('.mns-bloc-entry > div a').on("focus",function () {
        $(this).find('.caption').addClass('open');
    });
    $('.mns-bloc-entry > div a').on("focusout", function () {
        $(this).find('.caption').removeClass('open');
    });
}

    $('.mns-expand-collapse').click(function(){
        var checkboxesId = $(this).data("checkboxes-id");
        var checkboxes = $('#checkbox-'+checkboxesId);
        if($(this).hasClass('expanded')){
           $(this).find('.mns-filter-expand').show();
           $(this).find('.mns-filter-collapse').hide();
           $(this).removeClass('expanded');
           checkboxes.height("0px");
        } else {
           $(this).find('.mns-filter-expand').hide();
           $(this).find('.mns-filter-collapse').show();
           $(this).addClass('expanded');
           checkboxes.height("100%");
        }
    });



/*
 *   @constructorDisclosureButton
 *
 *
 */
class DisclosureButton {
    constructor(buttonNode) {
        this.buttonNode = buttonNode;
        this.controlledNode = false;

        var controler = this.buttonNode.getAttribute('aria-controls');

        if (controler) {
            this.controlledNode = this.buttonNode.closest("div").querySelector("."+controler);
        }

        this.buttonNode.setAttribute('aria-expanded', 'false');
        this.hideContent();

        this.buttonNode.addEventListener('click', this.onClick.bind(this));
        this.buttonNode.addEventListener('focus', this.onFocus.bind(this));
        this.buttonNode.addEventListener('blur', this.onBlur.bind(this));
    }

    showContent() {
        if (this.controlledNode) {
            this.controlledNode.style.display = 'block';
        }
    }

    hideContent() {
        if (this.controlledNode) {
            this.controlledNode.style.display = 'none';
        }
    }

    toggleExpand() {
        if (this.buttonNode.getAttribute('aria-expanded') === 'true') {
            this.buttonNode.setAttribute('aria-expanded', 'false');
            this.hideContent();
        } else {
            this.buttonNode.setAttribute('aria-expanded', 'true');
            this.showContent();
        }
    }

    /* EVENT HANDLERS */

    onClick() {
        this.toggleExpand();
    }

    onFocus() {
        this.buttonNode.classList.add('focus');
    }

    onBlur() {
        this.buttonNode.classList.remove('focus');
    }
}

/* Initialize Hide/Show Buttons */

window.addEventListener(
    'DOMContentLoaded',
    function () {
        var buttons = document.querySelectorAll(
            '.mns-w-fixe-2[aria-expanded][aria-controls]'
        );

        for (var i = 0; i < buttons.length; i++) {
            new DisclosureButton(buttons[i]);
        }
    },
    false
);