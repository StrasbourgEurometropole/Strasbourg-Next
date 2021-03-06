// Transformation des champs select-multiple
new Choices('.choices-element', {
	removeItemButton: true
});

// Périodes
var autoFields = undefined; // Référence au champ répétable (setté plus loin)
(function($) {
	var namespace = "_eu_strasbourg_portlet_agendaExport_AgendaExportBOPortlet_"; // Namespace du portlet
	var dateRangePickerLocaleSettings =  { // Configuration française du dateRangePicker
		format: 'DD/MM/YYYY',
		applyLabel: 'Ajouter',
		cancelLabel: 'Fermer',
		 daysOfWeek: [
            "Di",
            "Lu",
            "Ma",
            "Me",
            "Je",
            "Ve",
            "Sa"
        ],
        monthNames: [
            "Janvier",
            "Février",
            "Mars",
            "Avril",
            "Mai",
            "Juin",
            "Juillet",
            "Août",
            "Septembre",
            "Octobre",
            "Novembre",
            "Décembre"
        ],
        firstDay: 1
	};
	/**
	 * RangePicker
	 */

	var options = {
		autoApply: false,
		parentEl: '.portlet-body',
		opens: 'right',
		autoUpdateInput: false,
		locale: dateRangePickerLocaleSettings
	};
	// Fonction appelée lors du choix d'une nouvelle range
	var onDateChange = function(ev, picker) {
		// Set du texte du label
		$(this).text(picker.startDate.format('DD/MM/YYYY') + ' - ' + picker.endDate.format('DD/MM/YYYY'));
		// Set des champs input cachés
		$('.startDate', $(this).parent()).val(picker.startDate.format('DD/MM/YYYY'));
		$('.endDate', $(this).parent()).val(picker.endDate.format('DD/MM/YYYY'));
	};
	// On active le composant
	$('span.date-range').daterangepicker(options);
	// On attache l'événement de changement de range de date
	$('span.date-range').on('apply.daterangepicker', onDateChange);
})(jQuery);


// Validation des périodes
function validatePeriods(event) {
	var allValidated = true;
	var dateRanges = document.querySelectorAll('#date-fields .date-range')
	for (var i = 0; i < dateRanges.length; i++) {
		var dateRange = dateRanges[i];
		var validated = true;
		var id = $(dateRange).attr('id');
		// On ne lance la validation que si une période a déjà été sélectionnée
		// et que l'élément ne contient pas la classe "hide"
		if ($(dateRange).text().indexOf('-') > 0
				&& $(dateRange).parents('.lfr-form-row').attr('class').indexOf('hide') === -1) {
			var startDate = moment($(dateRange).text().split(' - ')[0], 'DD/MM/YYYY');
			var endDate = moment($(dateRange).text().split(' - ')[1], 'DD/MM/YYYY');
			var otherDateRanges = document.querySelectorAll('#date-fields .date-range');
			for (var j = 0; j < otherDateRanges.length; j++) {
				var otherDateRange = document.querySelectorAll('#date-fields .date-range')[j];
				var otherId = $(otherDateRange).attr('id');
				if (otherId !== id && $(otherDateRange).text().indexOf('-') > 0
						&& $(otherDateRange).parents('.lfr-form-row').attr('class').indexOf('hide') === -1) {
					var otherStartDate = moment($(otherDateRange).text().split(' - ')[0], 'DD/MM/YYYY');
					var otherEndDate = moment($(otherDateRange).text().split(' - ')[1], 'DD/MM/YYYY');
				    if (startDate.isSameOrBefore(otherEndDate) && endDate.isSameOrAfter(otherStartDate)) {
				    	validated = false;
				    	break;
				    }
				}
			}
		}
		if (!validated) {
			$('.event-period-conflict', $(dateRange).parent()).show();
			allValidated = false;
		}

	}

	if (!allValidated) {
		event.preventDefault();
	} else {
		autoFields.save(event.target);
	}
	return allValidated;
}

//option d'Export
(function($) {
    var namespace = "_eu_strasbourg_portlet_agendaExport_AgendaExportBOPortlet";

    /**
     * Retourne la valeur d'un champ dans une liste d'objet donnée
     */
    var getValueWithName = function(items, name) {
        for(var index in items) {
            if(items[index].name === name) {
                return items[index].value;
            }
        }
    };

    /**
     * Retourne les valeurs d'un champ dans une liste d'objet donnée
     */
    var getAllValuesWithName = function(items, name) {
        var values = [];
        for(var index in items) {
            if(items[index].name === name) {
                values.push(items[index].value);
            }
        }

        if(values.length === 0) {
            return undefined;
        }

        return values;
    }

    /**
     * Renvoit les categories triées par vocabulaires
     */
    var getCategories = function(items, token, idField, name) {

        var vocabularies = {};
        var key = 0;

        for(var index in items) {
            var itemName = items[index].name;
            var itemValue = items[index].value;

            key = itemName.replace(/\D/g,'');
            itemName = itemName.replace(/[0-9]/g, token);

            if(itemName === idField && key !== undefined) {
                var fieldToFind = name.replace("[index]", key);
                var values = getAllValuesWithName(items, fieldToFind);

                if(values !== undefined) {
                    vocabularies[itemValue] = values;
                }
            }
        }

        return vocabularies;
    }

    /**
     * Appel de l'export
     *
     */
    $("#"+ namespace + "_" + "export-btn").on("click", function() {

        //Récupération des valeurs du formulaire
        var values = $("#" + namespace + "_" + "fm").serializeArray();

        //Champs du formulaire
        var fields = {
            title: namespace + "_title",
            startDate: namespace + "_startDate[index]",
            endDate: namespace + "_endDate[index]",
            vocabularyId: namespace + "_vocabulary_[index]_id",
            vocabularySelect: namespace + "_vocabulary_[index]_select",
            vocabularyNumber: namespace + "_vocabulary_number",
            tags: namespace + "_assetTagNames",
            language: namespace + "_language",
            exportFormat: namespace + "_exportFormat",
            template: namespace + "_template",
            dataOrder: namespace + "_dataOrder",
        };

        //Fill data array
        var data = {};
        data[fields.title] = getValueWithName(values, fields.title);
        data[fields.startDate.replace("[index]", 0)] = getValueWithName(values, fields.startDate.replace("[index]", 0));
        data[fields.endDate.replace("[index]", 0)] = getValueWithName(values, fields.endDate.replace("[index]", 0));

        var vocabularies = getCategories(values, "[index]", fields.vocabularyId, fields.vocabularySelect);

        var i = 0;
        $.each(vocabularies, function(key, value) {
            data[fields.vocabularyId.replace("[index]", i)] = key;
            data[fields.vocabularySelect.replace("[index]", i)] = value;
            i++;
        });

        data[fields.vocabularyNumber] = getValueWithName(values, fields.vocabularyNumber);
        data[fields.tags] = getValueWithName(values, fields.tags).split(',');
        data[fields.language] = getValueWithName(values, fields.language);
        data[fields.exportFormat] = getValueWithName(values, fields.exportFormat);
        data[fields.template] = getValueWithName(values, fields.template);
        data[fields.dataOrder] = getValueWithName(values, fields.dataOrder);

        AUI().use('aui-io-request', function(A) {
            A.io.request(exportResourceUrl, {
                method : 'POST',
                data:data,
                on: {
                    success: function(data) {
                        $('#result').html(data);
                    }
                }
            });
        });
    });

})(jQuery);

(function($) {

    /** Validation des champs dynamiques **/
    var namespace = "_eu_strasbourg_portlet_agendaExport_AgendaExportBOPortlet_"; // Namespace du portlet
    var fields = {
        period: {
            begin: "#"+namespace+"startDate0",
            end: "#"+namespace+"endDate0"
        },
        template: "#"+namespace+"template",
        aggregationTypes: {
            first: '#'+ namespace +'firstAggregationType',
            second: '#'+ namespace +'secondAggregationType'
        },
        categories: {
            first: '#'+ namespace +'firstAggregationCategory',
            second: '#'+ namespace +'secondAggregationCategory'
        }
    };

    var messages = {
        periods: "#required-period",
        template: "#required-template",
        aggregations: {
            categories: {
                first: "#required-first-category",
                second: "#required-second-category"
            }
        }
    }

    /**
     * Validation des champs pour la période
     */
    var periodValidation = function(e, valid) {

        var begin = $(fields.period.begin).val();
        var end = $(fields.period.end).val();

        if((begin === undefined || begin === "") && (end === undefined || end === "")) {
            $(messages.periods).addClass("dynamic-required");
            $(messages.periods).show();
            $([document.documentElement, document.body]).animate({
                scrollTop: $(fields.periods.begin).offset().top - 200
            }, 1000);
            valid = false;
        } else {
            $(messages.periods).removeClass("dynamic-required");
            $(messages.periods).hide();
        }

        return valid;
    }

    /**
     * Validation du champ template
     */
    var templateValidation = function(e, valid) {
        var template = $(fields.template).val();

        if(template === "0" || template === "0") {
            $(messages.template).addClass("dynamic-required");
            $(messages.template).show();
            $([document.documentElement, document.body]).animate({
                scrollTop: $(fields.template).offset().top - 200
            }, 1000);
            valid = false;
        } else {
            $(messages.template).removeClass("dynamic-required");
            $(messages.template).hide();
        }

        return valid;
    }

    /**
     * Vérifie que les champs categories ne sont pas vides à la soumission du formulaire
     */
    var categoriesValidation = function(e, valid) {
        var firstType = $(fields.aggregationTypes.first).val();
        var secondType = $(fields.aggregationTypes.second).val();
        var firstCategory = $(fields.categories.first).val();
        var secondCategory = $(fields.categories.second).val();

        if(firstType === "CATEGORY" && firstCategory === "") {
            $(messages.aggregations.categories.first).addClass("dynamic-required");
            $(messages.aggregations.categories.first).show();
            valid = false;
        } else {
            $(messages.aggregations.categories.first).removeClass("dynamic-required");
            $(messages.aggregations.categories.first).hide();
        }

        if(secondType === "CATEGORY" && secondCategory === "") {
            $(messages.aggregations.categories.second).addClass("dynamic-required");
            $(messages.aggregations.categories.second).show();
            valid = false;
        } else {
            $(messages.aggregations.categories.second).removeClass("dynamic-required");
            $(messages.aggregations.categories.second).hide();
        }

        return valid;
    }

    /**
     * Interception du form submit pour validation
     */
    $(":submit").on('click', function(e) {

        var valid = true;
        valid = periodValidation(e, valid);
        valid = templateValidation(e, valid);
        valid = categoriesValidation(e, valid);

        if(!valid) {
            e.preventDefault();
            e.stopPropagation();
        } else {
            return true
        }
    });
})(jQuery);

(function($) {

    var namespace = "_eu_strasbourg_portlet_agendaExport_AgendaExportBOPortlet_";
    var form = $('#'+namespace+'fm');
    var submitBtn = $('#'+namespace+'export-btn-submit');
    var aggregationLevelSelect = $('#'+ namespace +'aggregationLevel');
    var firstAggregationBlock = $('#firstAggregationBlock');
    var secondAggregationBlock = $('#secondAggregationBlock');
    var firstAggregationTypeSelect = $('#'+ namespace +'firstAggregationType');
    var secondAggregationTypeSelect = $('#'+ namespace +'secondAggregationType');
    var vocabulariesSelect = $('.vocabulary-select');
    var firstVocabularySelect = $('#'+ namespace +'firstAggregationVocabulary');
    var secondVocabularySelect = $('#'+ namespace +'secondAggregationVocabulary');
    var firstCategorySelect = $('#'+ namespace +'firstAggregationCategory');
    var secondCategorySelect = $('#'+ namespace +'secondAggregationCategory');
    var aggregationFields = $(".aggregationFields");

    var exportFormat = $('#'+ namespace +'exportFormat');
    var template = $('#'+ namespace +'template');

    /** Demarrage de la page **/
    var value = exportFormat.val();
    if(value === "JSON") {
        $('#'+ namespace +'template')[0].selectedIndex = 0;
        template.closest("div").slideUp("fast");
    }
    else {
        template.closest("div").slideDown("fast");
    }

    /**
     * Cache les selects qui n'ont pas de valeur au chargement de la page
     */
    var hideEmptySelects = function() {
        $(".aggregationFields select").each(function() {
            var value = $(this).find(":selected").val();
            if(value == "") {
                $(this).closest("div").hide();
            }
        })
    };
    hideEmptySelects();

    /**
     * Affichage ou non des checboxes au demarrage de la page
     */
    var filterCheckboxes = function() {
        $(".category-checkboxes").each(function() {
            var value = $(this).closest(".aggregationFields").find(".aggregation-type").val();
            if(value !== "CATEGORY") {
                $(this).closest("div").hide();
            }
        });
    }
    filterCheckboxes();

    /**
     * Reactivation du bouton submit au bout de X secondes
     */
    submitBtn.on('click', function() {
        var button = this;
        setTimeout(function(){
            $(button).prop("disabled", false);
            $(button).css("opacity", "");
        }, 3000);
    });

    /**
     * Reset la valeur des champs en fonction de l'aggregation choisie
     */
     var resetAggregation = function(firstType, firstVocabulary, firstCategory, secondType, secondVocabulary, secondCategory, ) {
          if(firstType){
             $('#'+ namespace +'firstAggregationType')[0].selectedIndex = 0;
          }
          if(secondType){
             $('#'+ namespace +'secondAggregationType')[0].selectedIndex = 0;
          }
          if(firstVocabulary){
             $('#'+ namespace +'firstAggregationVocabulary')[0].selectedIndex = 0;
          }
          if(secondVocabulary){
             $('#'+ namespace +'secondAggregationVocabulary')[0].selectedIndex = 0;
          }
          if(firstCategory){
             $('#'+ namespace +'firstAggregationCategory')[0].selectedIndex = 0;
          }
          if(secondCategory){
             $('#'+ namespace +'secondAggregationCategory')[0].selectedIndex = 0;
          }
     }

    //Affichage des templates
    exportFormat.on("change", function() {
        var value = $(this).val();
        if(value === "JSON") {
            $('#'+ namespace +'template')[0].selectedIndex = 0;
            template.closest("div").slideUp("fast");
        }
        else {
            template.closest("div").slideDown("fast");
        }
    });

    //Affichage des types d'agrégations
    aggregationLevelSelect.on("change", function() {
        var value = $(this).val();

        if(value === "0") {
            resetAggregation(true,true,true,true,true,true);
            firstAggregationBlock.slideUp("fast");
            secondAggregationBlock.slideUp("fast");
        } else if(value === "1") {
            resetAggregation(false,false,false,true,true,true);
            firstVocabularySelect.closest("div").hide();
            firstCategorySelect.closest("div").hide();
            firstAggregationTypeSelect.closest("div").show();
            firstAggregationBlock.slideDown("fast");
            secondAggregationBlock.slideUp("fast");
        } else if(value === "2") {
            firstVocabularySelect.closest("div").hide();
            firstCategorySelect.closest("div").hide();
            secondVocabularySelect.closest("div").hide();
            secondCategorySelect.closest("div").hide();
            firstAggregationTypeSelect.closest("div").show();
            secondAggregationTypeSelect.closest("div").show();
            firstAggregationBlock.slideDown("fast");
            secondAggregationBlock.slideDown("fast");
        }
    });

    //Affichage des champs (première agrégation)
    firstAggregationTypeSelect.on("change", function() {
        var value = $(this).val()
        if(value === "VOCABULARY"){
            resetAggregation(false,true,true,false,false,false);
            firstVocabularySelect.closest("div").slideDown("fast");
            firstCategorySelect.closest("div").slideUp("fast");
            firstCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        } else if(value === "CATEGORY") {
            resetAggregation(false,false,true,false,false,false);
            firstVocabularySelect.closest("div").slideDown("fast");
            firstCategorySelect.closest("div").slideDown("fast");
            firstCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").show();

            if(firstCategorySelect.closest("div").find("span.icon-asterisk").length === 0) {
                firstCategorySelect.closest("div").find("label").append(
                    '<span class="icon-asterisk text-warning"></span>'
                );
            }
        }  else if(value === "DAY") {
            if(secondAggregationTypeSelect.val()==="MONTH"){
                resetAggregation(false,false,false,true,false,false);
            }
            firstVocabularySelect.closest("div").slideUp("fast");
            firstCategorySelect.closest("div").slideUp("fast");
            firstCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        }  else {
            firstVocabularySelect.closest("div").slideUp("fast");
            firstCategorySelect.closest("div").slideUp("fast");
            firstCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        }
    });

    //Affichage des champs (deuxième agrégation)
    secondAggregationTypeSelect.on("change", function() {
        var value = $(this).val()
        if(value === "VOCABULARY"){
            resetAggregation(false,false,false,false,true,true);
            secondVocabularySelect.closest("div").slideDown("fast");
            secondCategorySelect.closest("div").slideUp("fast");
            secondCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        } else if(value === "CATEGORY") {
            resetAggregation(false,false,false,false,false,true);
            secondVocabularySelect.closest("div").slideDown("fast");
            secondCategorySelect.closest("div").slideDown("fast");
            secondCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").show();

            if(secondCategorySelect.closest("div").find("span.icon-asterisk").length === 0) {
                secondCategorySelect.closest("div").find("label").append(
                    '<span class="icon-asterisk text-warning"></span>'
                );
            }
        }  else if(value === "DAY") {
            if(secondAggregationTypeSelect.val()==="MONTH"){
                resetAggregation(true,false,false,false,false,false);
            }
            secondVocabularySelect.closest("div").slideUp("fast");
            secondCategorySelect.closest("div").slideUp("fast");
            secondCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        }  else {
            secondVocabularySelect.closest("div").slideUp("fast");
            secondCategorySelect.closest("div").slideUp("fast");
            secondCategorySelect.closest(".wrapper").find(".category-checkboxes").closest("div").hide();
        }
    });

    //Chargements des categories en fonction du vocabulaire choisi
    vocabulariesSelect.on("change", function() {
        var vocabularySelect = this;
        var select = null;
        if($(this).val() != ""){
            // on initialise le select des catégories parentes
            Liferay.Service(
                '/agenda.agendaexport/get-parent-categories', {
                    vocabularyId: $(this).val(),
                    localeId: Liferay.ThemeDisplay.getLanguageId()
            }).then(function(data) {

                //Choose the right select
                var name = $(vocabularySelect).attr("name");
                if(name === namespace+"firstAggregationVocabulary") {
                    select = firstCategorySelect;
                } else if (name === namespace+"secondAggregationVocabulary") {
                    select = secondCategorySelect;
                }

                $(select).find('option').remove();
                select.append('<option value="">Aucune</option>');
                jQuery.each(data, function(index, categ){
                    select.append('<option value="' + categ.id + '">' + categ.title + ' </option>');
                });
                select.show();
            });
        }else{
            firstCategorySelect.hide();
            secondCategorySelect.hide();
        }
    });
})(jQuery);