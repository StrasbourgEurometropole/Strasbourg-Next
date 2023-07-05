var calendarDateFormat = 'DD/MM/YYYY';
var calendarDateLanguage = ($('html').attr('lang')).substring(0, 2);
var startDate = moment(new Date()).format(calendarDateFormat);

var groupes_input_dates = $('[data-jsgroupdate]').data('jsgroupdate');

if (groupes_input_dates) {

    var $spefilters = $('[name="date_spe"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]');
    var $spefiltersMea = $('[name="date_spe"]', '.js-listing-fma [data-jsgroupdate="' + groupes_input_dates + '"]');

    var $InputFrom = $('[data-jsdatestatus="from"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]');
    var $InputTo = $('[data-jsdatestatus="to"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]');

    var $InputFromMea = $('[data-jsdatestatus="from"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]');
    var $InputToMea = $('[data-jsdatestatus="to"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]');


    $('input.date', '[data-jsgroupdate="' + groupes_input_dates + '"]').each(function () {
        var container = '.js-listing-barre-filtre  .facettes-wrapper';
        var inline = false;

        if ($(this).parents('#overlay-filtres .group-dates').length > 0) {
            container = '#overlay-filtres .group-dates';
            inline = true;
        }

        if (!isTouchDevice()) {
            $(this).attr('type', 'text');
            $(this).attr('placeholder', '');
            $(this).dateRangePicker({
                inline: inline,
                stickyMonths: true,
                singleDate: false,
                alwaysOpen: false,
                singleMonth: false,
                showShortcuts: false,
                showTopbar: false,
                monthSelect: true,
                hoveringTooltip: false,
                selectForward: false,
                yearSelect: [2022, 2030],
                startOfWeek: 'monday',
                startDate: startDate,
                customArrowPrevSymbol: '<span class="icon-arrow-left"></span>',
                customArrowNextSymbol: '<span class="icon-arrow-right"></span>',
                format: calendarDateFormat,
                language: calendarDateLanguage,
                container: container,
                separator: ' to ',
                getValue: function () {
                    if ($('[data-jsdatestatus="from"]').val() && $('[data-jsdatestatus="to"]').val())
                        return $('[data-jsdatestatus="from"]').val() + ' to ' + $('[data-jsdatestatus="to"]').val();
                    else
                        return '';
                },
                setValue: function (s, s1, s2) {
                    $('[data-jsdatestatus="from"]').each(function () {
                        if ($(this).attr('type') == 'date') {
                            $(this).val(s1.split('/').reverse().join('-'));
                        } else {
                            $(this).val(s1);
                        }
                    });
                    $('[data-jsdatestatus="to"]').each(function () {
                        if ($(this).attr('type') == 'date') {
                            $(this).val(s2.split('/').reverse().join('-'));
                        } else {
                            $(this).val(s2);
                        }
                    });

                    // on deselectionne les filtres spe
                    $('[name="date_spe"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', false);
                    ;
                    $('[name="date_spe"]', '.js-listing-fma [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', false);
                    ;
                },
            }).bind('datepicker-open', function (event, obj) {
                $('[data-jsdatestatus="from"]').parent('.wrapper-date').addClass('focus');
            }).bind('datepicker-first-date-selected', function (event, obj) {
                $('[data-jsdatestatus="from"]').parent('.wrapper-date').removeClass('focus');
                $('[data-jsdatestatus="to"]').parent('.wrapper-date').addClass('focus');
            }).bind('datepicker-close', function (event, obj) {
                $('[data-jsdatestatus="to"]').parent('.wrapper-date').removeClass('focus');
                $('[data-jsdatestatus="from"]').parent('.wrapper-date').removeClass('focus');

                if ($('[data-jsdatestatus="to"]').val() && $('[data-jsdatestatus="from"]').val()) {
                    $InputFrom.trigger('force-change');
                }
            });
        } else {
            var data_date = $(this).val();
            data_date = data_date.split('/').reverse().join('-');
            $(this).val(data_date);
            $(this).attr('type', 'date');

            // on passe en readonly les input date de la barre de filtre
            $('[data-jsdatestatus]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]').attr("readonly", "readonly");

            $(this).on('change', function (eventObject) {
                var date_status = $(this).data('jsdatestatus');
                $('[data-jsdatestatus="' + date_status + '"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]').val($(this).val());
            })
        }
    });


    /** Gestion des filtres spés */

    $spefiltersMea.on('change', function () {
        var data_date = $(this).data();

        if (!isTouchDevice()) {
            calendarListingData.set(data_date.start, data_date.end);
        } else {

            $('[data-jsdatestatus="from"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.start);
            $('[data-jsdatestatus="from"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.start);

            $('[data-jsdatestatus="to"]', '.js-listing-barre-filtre[data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.end);
            $('[data-jsdatestatus="to"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.end);

            $InputFrom.trigger('force-change');
        }

        // on met à jour l'équivalent dans l'overlay
        $('[name="date_spe"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', false);
        ;
        $('[value="' + $(this).val() + '"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', true);
        ;
    })

    $spefilters.on('change', function () {
        var data_date = $(this).data();

        if (!isTouchDevice()) {
            calendarListingData.set(data_date.start, data_date.end);
        } else {
            $('[data-jsdatestatus="from"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.start);
            $('[data-jsdatestatus="from"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.start);

            $('[data-jsdatestatus="to"]', '.js-listing-barre-filtre [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.end);
            $('[data-jsdatestatus="to"]', '#overlay-filtres [data-jsgroupdate="' + groupes_input_dates + '"]').val(data_date.end);

            $InputFrom.trigger('force-change');
        }

        // on met à jour l'équivalent dans le contenu de la page
        $('[name="date_spe"]', '.js-listing-fma [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', false);
        $('[value="' + $(this).val() + '"]', '.js-listing-fma [data-jsgroupdate="' + groupes_input_dates + '"]').prop('checked', true);
    })


    var calendarListingData = {

        from: null,
        to: null,
        submit: true,

        timeout: null,

        set: function (from, to, submit) {

            if (typeof submit != 'undefined') {
                calendarListingData.submit = submit;
            }

            if (from && from.match(/\//)) {
                from = from.split('/').reverse().join('-');
            }
            if (to && to.match(/\//)) {
                to = to.split('/').reverse().join('-');
            }
            if (from !== calendarListingData.from || to !== calendarListingData.to) {
                calendarListingData.from = from;
                calendarListingData.to = to;

                calendarListingData.onchange();
                return true;
            }
            return false;
        },

        onchange: function () {

            clearTimeout(calendarListingData.timeout);
            calendarListingData.timeout = setTimeout(function () {
                calendarListingData.onchangeDelais();
            }, 100);

        },

        onchangeDelais: function () {

            if (calendarListingData.from && calendarListingData.to) {
                var fromSlash = calendarListingData.from.split('-').reverse().join('/');
                var toSlash = calendarListingData.to.split('-').reverse().join('/');

                if (fromSlash && toSlash) {
                    $InputFrom.val(fromSlash);
                    $InputTo.val(toSlash);
                    $InputFromMea.val(fromSlash);
                    $InputToMea.val(toSlash);
                }
            }

            // force la soumission des filtres
            if (calendarListingData.submit) {
                $InputFrom.trigger('force-change');
            }
        }
    };
}