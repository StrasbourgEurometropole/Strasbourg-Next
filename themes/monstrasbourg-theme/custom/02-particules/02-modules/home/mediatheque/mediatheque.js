(function ($) {
    $('#borrowingSeeMore').on('click', function() {
        for (i = 3; i < $("#borrowingCount").val(); i++) {
            $('#borrowing_' + i).show();
            $('#borrowing_' + i).removeClass("hidden");
        }
        $('#borrowingSeeMore').hide();
        $('#borrowingSeeLess').removeClass("hidden");
        $('#borrowingSeeLess').show();
    });
    $('#reservationSeeMore').on('click', function() {
        for (i = 3; i < $("#reservationCount").val(); i++) {
            $('#reservation_' + i).show();
            $('#reservation_' + i).removeClass("hidden");
        }
        $('#reservationSeeMore').hide();
        $('#reservationSeeLess').removeClass("hidden");
        $('#reservationSeeLess').show();
    });
    $('#borrowingSeeLess').on('click', function() {
        for (i = 3; i < $("#borrowingCount").val(); i++) {
            $('#borrowing_' + i).hide();
        }
        $('#borrowingSeeMore').show();
        $('#borrowingSeeLess').hide();
    });
    $('#reservationSeeLess').on('click', function() {
        for (i = 3; i < $("#reservationCount").val(); i++) {
            $('#reservation_' + i).hide();
        }
        $('#reservationSeeMore').show();
        $('#reservationSeeLess').hide();
    });
 }(jQuery));
