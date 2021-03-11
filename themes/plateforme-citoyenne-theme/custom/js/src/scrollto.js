$('a[href^="#pro-link"]').bind('click.smoothscroll',function (e) {
    if(!$(this).hasClass('pro-btn-disabled')){
        e.preventDefault();
        var target = this.hash,
            $target = $(target);

        var pos = $target.offset().top - 120;

        $('html, body').stop().animate( {
            'scrollTop': pos
        }, 600, 'swing', function () {
            window.location.hash = pos;
        } );
    }
} );