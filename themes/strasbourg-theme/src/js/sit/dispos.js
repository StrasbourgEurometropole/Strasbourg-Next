var calendarDateFormat = 'DD/MM/YYYY';
var calendarDateLanguage = ($('html').attr('lang')).substring(0, 2);
var startDate = moment(new Date()).format(calendarDateFormat);

var status_class = {
    0: 'nous-consulter',
    1: 'libre',
    2: 'ferme',
    3: 'complet',
    4: 'passe',
};

// calendrier des disponibilités
var $rangeCalendarAlwaysOpen = $('#calendar-range');
if ($rangeCalendarAlwaysOpen.length > 0) {
    $rangeCalendarAlwaysOpen.dateRangePicker({
        inline: true,
        container: '#calendar-range',
        alwaysOpen: true,
        stickyMonths: true,
        singleMonth: false,
        showShortcuts: false,
        showTopbar: false,
        startOfWeek: 'monday',
        customArrowPrevSymbol: '<span class="icon-arrow-left"></span>',
        customArrowNextSymbol: '<span class="icon-arrow-right"></span>',
        format: calendarDateFormat,
        language: calendarDateLanguage,
        beforeShowDay: function (t) {

            var valid = false;

            var day = (t.getDate());
            if (day < 10) {
                day = '0' + day;
            }
            var month = (t.getMonth() + 1);
            if (month < 10) {
                month = '0' + month;
            }
            var current_date = t.getFullYear() + '-' + month + '-' + day;

            var status = sit_dispos[current_date];
            if (typeof status != 'undefined') {
                status = status.status;
                if (status == 0 || status == 1) {
                    valid = true;
                }
            } else {
                status = 4;
            }

            var tooltip_text = $('.sit-dispos [data-status=' + status + ']').text();

            var valid = valid;
            var _class = status_class[status];
            var _tooltip = tooltip_text ? tooltip_text : '';
            return [valid, _class, _tooltip];
        }
    });
}
