var calendarDateFormat = 'DD/MM/YYYY';
var calendarDateLanguage = $('html').data('lang');

/** Calendrier Formidable de base  */
$('.bloc-form input.frm_date').each(function () {
    if (!isTouchDevice()) {
        $(this).attr('type', 'text');
        $(this).attr('placeholder', '');
        $(this).dateRangePicker({
            inline: false,
            singleDate: true,
            alwaysOpen: false,
            singleMonth: true,
            showShortcuts: false,
            showTopbar: false,
            monthSelect: true,
            yearSelect: [2020, 2030],
            startOfWeek: 'monday',
            customArrowPrevSymbol: '<span class="icon-arrow-left"></span>',
            customArrowNextSymbol: '<span class="icon-arrow-right"></span>',
            format: calendarDateFormat,
            language: calendarDateLanguage,
            setValue: function (s, s1, s2, inst) {

                $(this).parent().addClass("has-content");
                $(this).val(s1);
                if (!$(this).hasClass('no-refresh')) {
                    $(this).trigger('force-change');
                }
            },
        });
    } else {
        $(this).attr('type', 'date');
    }
});