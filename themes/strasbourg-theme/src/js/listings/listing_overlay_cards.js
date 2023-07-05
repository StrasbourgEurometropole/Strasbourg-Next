// ouverture de l'overlay des cards agenda sur le listingfma
function parseCardAgendaClickOverlay() {
    $('.js-listing-fma .card:not(.parsed)').on('click', function (e) {
        e.preventDefault();

        var elem = $(this);

        var sit_url = elem.attr('href') + '?overlay';
        var overlay_id = 'overlay-agenda';

        var date = moment($('.dtstart', elem).attr('datetime'), "YYYY-MM-DD").format("Do MMMM");
        var h_from = $($('.hours-js span', elem).get(0)).text();
        var h_to = $($('.hours-js span', elem).get(1)).text();

        $('#' + overlay_id + ' .content-sit').html('');
        $('#' + overlay_id + ' .loader').removeClass('hide');
        $('#' + overlay_id + ' .bottom-part').addClass('hide');

        $.get(sit_url, function (responseHTML) {
            $('#' + overlay_id + ' .loader').addClass('hide');
            $('#' + overlay_id + ' .content-sit').html(responseHTML);
            $('#' + overlay_id + ' .content-sit .time').html($('time', elem).html());
            $('#' + overlay_id + ' .bottom-part a').attr('href', elem.attr('href'));
            $('#' + overlay_id + ' .bottom-part').removeClass('hide');
            $('#' + overlay_id + ' .date-js').text(date);

            if (!h_from && !h_to) {
                $('#' + overlay_id + ' .dt-schedule').addClass('hide');
            } else if (h_from && !h_to) {
                $('#' + overlay_id + ' .hours-js-from').removeClass('hide');
                $('#' + overlay_id + ' .hour-js-from').text(h_from);
            } else if (h_from && h_to) {
                console.log('date from and to !!!!');
                $('#' + overlay_id + ' .hours-js-from-to').removeClass('hide');
                $('#' + overlay_id + ' .hour-js-from').text(h_from);
                $('#' + overlay_id + ' .hour-js-to').text(h_to);
            }
        });

        th_overlay.open(overlay_id, true, true, false);


    }).addClass('parsed');
}

parseCardAgendaClickOverlay();