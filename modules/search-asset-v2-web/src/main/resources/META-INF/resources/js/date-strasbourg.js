$(document).ready(function() {
    if($('input[data-type="date"]').length){
        $('input[data-type="date"]').on('change', function(value){
            // récupération du nom du champ
            var name = $(this).attr('name');

            // separation de la date en jour, mois et année 2018-01-01
            var date = $(this).val().split("-");

            // remove leading 0
            var day = date[2].replace(/^0+/, '');
            // turn month into a number then minus 1 to match the index of the month
            var month = parseInt(date[1], 10) - 1;
            var year = date[0];


            if ($('input[data-name="' + name + 'Day"').length) {
                var dayInput = $('input[data-name="' + name + 'Day"');
                var monthInput = $('input[data-name="' + name + 'Month"');
                var yearInput = $('input[data-name="' + name + 'Year"');
                dayInput[0].value = day;
                monthInput[0].value = month;
                yearInput[0].value = year;
            }
        });
    }
});