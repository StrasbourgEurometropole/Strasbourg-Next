// Afficher une date

$('.frm_date').each(function(){
    var picker = new Pikaday({ 
    	field: this,
    	value : function(date,field){
    	    var valueInput = field.value;
    	    if (valueInput!==""){
    	        var arrayDate = valueInput.split('/');
    	        if (arrayDate.length ===3){
    	             const day = parseInt(parts[0], 10);
                     const month = parseInt(parts[1] - 1, 10);
                     const year = parseInt(parts[1], 10);
                     date = new Date(year, month, day);
                     return date;
    	        }
    	    }
    	},
    	format: 'D/M/YYYY',
    	toString: function(date, format) {
	        const day = date.getDate() < 10 ? '0' + date.getDate() : date.getDate() ;
	        const month = (date.getMonth() + 1) < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1;
	        const year = date.getFullYear();
	        return day + '/' + month + '/' + year;
	    },
	    parse: function(dateString) {
	        // dateString is the result of `toString` method
	        const parts = dateString.split('/');
	        const day = parseInt(parts[0], 10);
	        const month = parseInt(parts[1] - 1, 10);
	        const year = parseInt(parts[2], 10);
	        return new Date(year, month, day);
    	},	
	    onSelect: function(date) {
            var name = picker._o.field.name;
            if ($('input[data-name="' + name + 'Day"').length) {
                var dayInput = $('input[data-name="' + name + 'Day"');
                var monthInput = $('input[data-name="' + name + 'Month"');
                var yearInput = $('input[data-name="' + name + 'Year"');
                dayInput[0].value = date.getDate();
                monthInput[0].value = date.getMonth();
                yearInput[0].value = date.getFullYear();
            }
            // Utilisé pour les recherches ajax
            if(this._o.field.className.indexOf('dynamic') >= 0){
                // Renvoi la liste des entités demandées
                getSelectedEntries();
            }
	    }
    });
});