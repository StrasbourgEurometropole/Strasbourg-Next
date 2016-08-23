// Important : wrap it with AUI "all portlet ready" code

// Dropdown langues
(function ($) {
  $('.language-menu a').on('click', function(e) {
    e.preventDefault();
    $('.language-menu').toggleClass('open');
  });
}) (jQuery);

// Sticky (uniquement en desktop)
(function ($) {
  // Cas où il n'y a pas de menu musée
  if ($('.museum-header').length === 0) {
    $(document).on('scroll', function() {
      if($(this).scrollTop() > 132) {
        $('.menu-header').addClass('sticky');
        $('body').css('margin-top', '49px');
      } else {
        $('.menu-header').removeClass('sticky');
        $('body').css('margin-top', '0');
      }
    });
  } else { // Avec menu musée
    $(document).on('scroll', function() {
      if($(this).scrollTop() > 180) {
        $('.breadcrumb').addClass('sticky');
        $('.museum-header').addClass('sticky');
        $('body').css('margin-top', '86px');
      } else {
        $('.breadcrumb').removeClass('sticky');
        $('.museum-header').removeClass('sticky');
        $('body').css('margin-top', '0');
      }
    });
  }
}) (jQuery);

// Menu mobile
(function ($) {
  /*** 
   * Run this code when the #nav-toggle link has been tapped
   * or clicked
   */
  $('.mobile-menu-toggle').on('touchstart click', function (e) {
    e.preventDefault();
    $('.mobile-menu-toggle').toggleClass("active");
    var $body = $('body'),
      $page = $('#page'),

    /* Cross browser support for CSS "transition end" event */
      transitionEnd = 'transitionend webkitTransitionEnd otransitionend MSTransitionEnd';

    /* When the toggle menu link is clicked, animation starts */
    $body.addClass('animating');

    /***
     * Determine the direction of the animation and
     * add the correct direction class depending
     * on whether the menu was already visible.
     */
    if ($body.hasClass('menu-visible')) {
      $body.addClass('right');
      $page.off('touchstart click');
    } else {
      $body.addClass('left');
      $page.on('touchstart click', function (e) {
        if (!$body.hasClass('animating')) {
          e.preventDefault();
          $('#nav-toggle').trigger('click');
        }
      });
    }

    /***
     * When the animation (technically a CSS transition)
     * has finished, remove all animating classes and
     * either add or remove the "menu-visible" class 
     * depending whether it was visible or not previously.
     */
    $page.on(transitionEnd, function () {
      $body.removeClass('animating left right').toggleClass('menu-visible');
      $page.off(transitionEnd);
    });
  });
}) (jQuery);


// Gestion des sous-menus mobiles
(function ($) {
  $('.mobile-main-menu a.submenu-toggle').on('click', function(e) {
    e.preventDefault();
    $('.mobile-main-menu .open').removeClass('open');
    $(this).next().addClass('open');
    $('.mobile-main-menu-nav').show();
  });

  $('.mobile-main-menu-nav .to-start').on('click', function(e) {
    e.preventDefault();
    $('.mobile-main-menu .open').removeClass('open');
    $('.mobile-main-menu .main-menu').addClass('open');
    $('.mobile-main-menu-nav').hide();
  });

  $('.mobile-main-menu-nav .previous').on('click', function(e) {
    e.preventDefault();
    var openedSubmenu = $('.mobile-main-menu .open');
    var nextOneToBeOpened = openedSubmenu.parent().parent();
    if(nextOneToBeOpened.hasClass('main-menu') || nextOneToBeOpened.hasClass('submenu')) {
      $('.mobile-main-menu .open').removeClass('open');
      nextOneToBeOpened.addClass('open');
    }
    if (nextOneToBeOpened.hasClass('main-menu')) {
      $('.mobile-main-menu-nav').hide();
    }
  });
}) (jQuery);

// Menu "accès par public" mobile
(function ($) {
  $('.accessibility-mobile-menu .has-submenu > a').on('click', function(e) {
    e.preventDefault();
    $('.accessibility-mobile-menu .access-by-public-submenu').toggleClass('open');
  });
}) (jQuery);

// Carousel home
(function($) {
  $(document).ready(function() {
    var carousel = $('.home-carousel .owl-carousel').owlCarousel({
      items: 1,
      nav: true,
      loop: true,
      dotsContainer: '#carousel-custom-dots'
    });
    $('.home-carousel .owl-dot').click(function () {
      carousel.trigger('to.owl.carousel', [$(this).index(), 300]);
    });
  });
  $('.home-carousel .owl-dot').hover(function() {
    var dot = $(this);
    $('.home-carousel .museum-name').text(dot.data('title'));
  });
  $('.home-carousel #carousel-custom-dots').mouseleave(function() {
    var museumName = $('.home-carousel .museum-name');
    museumName.text(museumName.data('original'));
  });
}) (jQuery);

// Carousel home news
(function($) {
  $(document).ready(function() {
    var carousel = $('.news-carousel .owl-carousel').owlCarousel({
      items: 1,
      nav: true,
      stagePadding: 50,
      responsive: {
        601: {
          stagePadding: 0
        },
        901: {
          stagePadding: 0,
          items: 2
        }
      }
    });
  });
  $('.news-carousel .item-content').dotdotdot({
    watch: window
  });
}) (jQuery);
