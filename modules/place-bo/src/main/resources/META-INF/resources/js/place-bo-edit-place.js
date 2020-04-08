// Champs conditionnelles
jQuery(function() {
	var namespace = "_eu_strasbourg_portlet_place_PlaceBOPortlet_";
	var namespaceAUI = "#" + namespace;
    var allValidate = true;

	$(namespaceAUI + 'siteLabel').on('change', function(e) {
		setSiteConditionalValidators();
	});

	$(namespaceAUI + 'siteURL').on('change', function(e) {
		setSiteConditionalValidators();
	});

	$(namespaceAUI + 'facebookLabel').on('change', function(e) {
		setFacebookConditionalValidators();
	});

	$(namespaceAUI + 'facebookURL').on('change', function(e) {
		setFacebookConditionalValidators();
	});

	$(namespaceAUI + 'instagramLabel').on('change', function(e) {
		setInstagramConditionalValidators();
	});

	$(namespaceAUI + 'instagramURL').on('change', function(e) {
		setInstagramConditionalValidators();
	});

	// affichage ou non des périodes/exception et URL
    showScheduleBlock();
	$(namespaceAUI + 'hasURLSchedule').on('change', function(e) {
		showScheduleBlock();
	});

	$(namespaceAUI + 'scheduleLinkName').on('change', function(e) {
		setScheduleConditionalValidators();
	});

	$(namespaceAUI + 'scheduleLinkURL').on('change', function(e) {
		setScheduleConditionalValidators();
	});


	$(":submit").on('click', function(e) {
        allValidate = true;

		setSiteConditionalValidators(e);
		setFacebookConditionalValidators(e);
		setInstagramConditionalValidators();
        setScheduleConditionalValidators(e);
        if(!$(namespaceAUI + 'hasURLSchedule').is(':checked')){
            setScheduleExceptionValidators(e);
            setPeriodValidators(e);
        }

		if (!allValidate) {
			event.preventDefault();
		}
	});

	function setSiteConditionalValidators(event) {
		// Validation des champos obligatoires conditionnels
		AUI().use('liferay-form',function() {
			var rules = Liferay.Form.get(namespace + 'fm').formValidator
					.get('rules');
			var labelHasValue = $(namespaceAUI + 'siteLabel')
					.val().length > 0;
			var URLHasValue = $(namespaceAUI + 'siteURL').val().length > 0;
			if (labelHasValue && !URLHasValue) {
				rules[namespace + 'siteLabel'].required = false;
				rules[namespace + 'siteURL'].required = true;
			} else {
				if (!labelHasValue && URLHasValue) {
					rules[namespace + 'siteLabel'].required = true;
					rules[namespace + 'siteURL'].required = false;
				} else {
					rules[namespace + 'siteLabel'].required = false;
					rules[namespace + 'siteURL'].required = false;
				}
			}
		});
	}

	function setFacebookConditionalValidators(event) {
		// Validation des champos obligatoires conditionnels
		AUI().use('liferay-form',function() {
			var rules = Liferay.Form.get(namespace + 'fm').formValidator
					.get('rules');
			var labelHasValue = $(
					namespaceAUI + 'facebookLabel').val().length > 0;
			var URLHasValue = $(namespaceAUI + 'facebookURL')
					.val().length > 0;
			if (labelHasValue && !URLHasValue) {
				rules[namespace + 'facebookLabel'].required = false;
				rules[namespace + 'facebookURL'].required = true;
			} else {
				if (!labelHasValue && URLHasValue) {
					rules[namespace + 'facebookLabel'].required = true;
					rules[namespace + 'facebookURL'].required = false;
				} else {
					rules[namespace + 'facebookLabel'].required = false;
					rules[namespace + 'facebookURL'].required = false;
				}
			}
		});
	}

	function setInstagramConditionalValidators(event) {
		// Validation des champos obligatoires conditionnels
		AUI().use('liferay-form',function() {
			var rules = Liferay.Form.get(namespace + 'fm').formValidator
					.get('rules');
			var labelHasValue = $(
					namespaceAUI + 'instagramLabel').val().length > 0;
			var URLHasValue = $(namespaceAUI + 'instagramURL')
					.val().length > 0;
			if (labelHasValue && !URLHasValue) {
				rules[namespace + 'instagramLabel'].required = false;
				rules[namespace + 'instagramURL'].required = true;
			} else {
				if (!labelHasValue && URLHasValue) {
					rules[namespace + 'instagramLabel'].required = true;
					rules[namespace + 'instagramURL'].required = false;
				} else {
					rules[namespace + 'instagramLabel'].required = false;
					rules[namespace + 'instagramURL'].required = false;
				}
			}
		});
	}

	function showScheduleBlock() {
        if($(namespaceAUI + 'hasURLSchedule').is(':checked')){
            $('.URLSchedule').show();
            $('.PeriodTime').hide();
        }else{
            $('.URLSchedule').hide();
            $('.PeriodTime').show();
        }
	}

	function setScheduleConditionalValidators(event) {
		// Validation des champs obligatoires conditionnels
		AUI().use('liferay-form',function() {
			var rules = Liferay.Form.get(namespace + 'fm').formValidator
					.get('rules');
			var labelHasValue = $(
					namespaceAUI + 'scheduleLinkName').val().length > 0;
			var URLHasValue = $(namespaceAUI + 'scheduleLinkURL')
					.val().length > 0;
            if($(namespaceAUI + 'hasURLSchedule').is(':checked')){
                if (!URLHasValue) {
                    rules[namespace + 'scheduleLinkURL'].required = true;
                } else {
                     rules[namespace + 'scheduleLinkURL'].required = false;
                 }
                if (!labelHasValue) {
                    rules[namespace + 'scheduleLinkName'].required = true;
                } else {
                    rules[namespace + 'scheduleLinkName'].required = false;
                }
            }else{
                    rules[namespace + 'scheduleLinkName'].required = false;
                    rules[namespace + 'scheduleLinkURL'].required = false;
            }
		});
	}

	function setPeriodValidators(event) {
		var periodLabels = $('.tab-content > div[id*=period]');
		var nbPeriodDefault = 0;
		var periodsIndexes = "";
		for (var i = 0; i < periodLabels.length; i++) {
			var periodLabel = periodLabels[i];
			var index = $(periodLabel).children('input[id*=numPeriod]').val();
			periodsIndexes += index + ",";
			var nom = $(namespaceAUI + "namePeriod" + index).val();			
			if (nom == "") {
				$('.place-period-name', $(periodLabel)).show();
				if(allValidate){
				    activePeriod(index);
                    $('html,body').animate({scrollTop: $(namespaceAUI + "namePeriod" + index).offset().top - 100}, 'slow');
                    allValidate = false;
                }
			}else{
				$('.place-period-name', $(periodLabel)).hide();
			}

			var periodDefault = $(namespaceAUI + "defaultPeriod" + index).get(0).checked;
			if (periodDefault) {
				$('.place-period-start-date', $(periodLabel)).hide();
				$('.place-period-end-date', $(periodLabel)).hide();
				if (nbPeriodDefault == 0) {
					nbPeriodDefault++;
					$('.place-period-default', $(periodLabel)).hide();
				} else {
					$('.place-period-default', $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(index);
                        $('html,body').animate({scrollTop: $(namespaceAUI + "defaultPeriod" + index).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}
			} else{
				$('.place-period-default', $(periodLabel)).hide();
				var startDatePeriod = $(namespaceAUI + "startDatePeriod" + index).val();
				if(startDatePeriod == ""){
					$('.place-period-start-date', $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(index);
                        $('html,body').animate({scrollTop: $(namespaceAUI + "startDatePeriod" + index).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('.place-period-start-date', $(periodLabel)).hide();
				}
				var endDatePeriod = $(namespaceAUI + "endDatePeriod" + index).val();
				if(endDatePeriod == ""){
					$('.place-period-end-date', $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(index);
                        $('html,body').animate({scrollTop: $(namespaceAUI + "endDatePeriod" + index).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('.place-period-end-date', $(periodLabel)).hide();
				}
				
				// on vérifie que la date de début soit <= à la date de fin
				if(!comparDatesYMD(startDatePeriod, endDatePeriod)){
					$('.place-period-incorrect-date', $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(index);
                        $('html,body').animate({scrollTop: $(namespaceAUI + "startDatePeriod" + index).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('.place-period-incorrect-date', $(periodLabel)).hide();
				}
			}
			setSlotValidators(index, periodLabel);
		}

        if(allValidate){
			$(namespaceAUI + 'periodsIndexes').val(periodsIndexes.substr(0, periodsIndexes.length -1));
        }
	}

	function setSlotValidators(indexPeriod, periodLabel) {
		for (var jour = 0; jour < 7; jour++) {
			var nbSlot = $(namespaceAUI + 'nbSlot' + indexPeriod
					+ '-' + jour).val();
			var slotsIndexes = "";
			for (var indexSlot = 0; indexSlot < nbSlot; indexSlot++) {
				slotsIndexes += indexSlot + ",";
				var startHour = $(namespaceAUI + 'startHour' + indexPeriod
						+ '-' + jour + '-' + indexSlot).val();
				var endHour = $(namespaceAUI + 'endHour' + indexPeriod
						+ '-' + jour + '-' + indexSlot).val();
				if(startHour == "") {
					$('#slotStartHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(indexPeriod);
                        $('html,body').animate({scrollTop: $(namespaceAUI + 'startHour' + indexPeriod + '-' + jour + '-' + indexSlot).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('#slotStartHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).hide();
				}
				if(endHour == "") {
					$('#slotEndHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(indexPeriod);
                        $('html,body').animate({scrollTop: $(namespaceAUI + 'endHour' + indexPeriod + '-' + jour + '-' + indexSlot).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('#slotEndHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).hide();
				}

				// on vérifie que l'heure de début soit < à l'heure de fin
				if(!comparHour(startHour, endHour)){
					$('#slotIncorrectHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).show();
                    if(allValidate){
                        activePeriod(indexPeriod);
                        $('html,body').animate({scrollTop: $(namespaceAUI + 'startHour' + indexPeriod + '-' + jour + '-' + indexSlot).offset().top - 100}, 'slow');
                        allValidate = false;
                    }
				}else{
					$('#slotIncorrectHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel)).hide();
				}
			}
			$(namespaceAUI + 'slotsIndexes' + indexPeriod + "-" + jour).val(slotsIndexes.substr(0, slotsIndexes.length -1));
		}
	}

	function setScheduleExceptionValidators(event) {
		var scheduleLabels = document
				.querySelectorAll('#date-fields .schedule-label');
		var periods = [];
		for (var i = 0; i < scheduleLabels.length; i++) {
			var scheduleLabel = scheduleLabels[i];
			var index = $(scheduleLabel).attr('id');
			// On ne lance la validation que si l'élément ne contient pas la
			// classe "hide"
			var startDateSchedule = $(namespaceAUI + "startDateScheduleException" + index).val();
			if (startDateSchedule != undefined
					&& $(scheduleLabel).parents('.lfr-form-row').attr('class')
							.indexOf('hide') == -1) {
				var scheduleExceptionDescription = $(
						namespaceAUI + "scheduleExceptionDescription" + index + "_fr_FR")
						.val();
				var endDateSchedule = $(namespaceAUI + "endDateScheduleException" + index).val();
                var startHour = $(namespaceAUI + "startHour1_" + index).val();
                var endHour = $(namespaceAUI + "endHour1_" + index).val();
				if(scheduleExceptionDescription != "" || startDateSchedule != "" || endDateSchedule != "" || startHour != "" || endHour != "") {
					if (scheduleExceptionDescription == "") {
						$('.place-schedule-description', $(scheduleLabel).parent()).show();
                        if(allValidate){
                            $('html,body').animate({scrollTop: $(namespaceAUI + "scheduleExceptionDescription" + index).offset().top - 100}, 'slow');
                            allValidate = false;
                        }
					}else{
						$('.place-schedule-description', $(scheduleLabel).parent()).hide();
					}

					if (startDateSchedule == "") {
						$('.place-schedule-start-date', $(scheduleLabel).parent()).show();
                        if(allValidate){
                            $('html,body').animate({scrollTop: $(namespaceAUI + "startDateScheduleException" + index).offset().top - 100}, 'slow');
                            allValidate = false;
                        }
					}else{
						$('.place-schedule-start-date', $(scheduleLabel).parent()).hide();
					}

					if (endDateSchedule == "") {
						$('.place-schedule-end-date', $(scheduleLabel).parent()).show();
                        if(allValidate){
                            $('html,body').animate({scrollTop: $(namespaceAUI + "endDateScheduleException" + index).offset().top - 100}, 'slow');
                            allValidate = false;
                        }
					}else{
						$('.place-schedule-end-date', $(scheduleLabel).parent()).hide();
                    }

					if (startDateSchedule != "" && endDateSchedule != "") {
						// on vérifie que cette période ne chevauche pas une autre période
						var nbPeriod = 0
						$('.place-schedule-period', $(scheduleLabel).parent()).hide();
						for (nbPeriod; nbPeriod < periods.length; nbPeriod++) {
							if(!(!(comparDatesYMD(startDateSchedule, periods[nbPeriod][1])) || (!comparDatesYMD(periods[nbPeriod][0], endDateSchedule)))){
								$('.place-schedule-period', $(scheduleLabel).parent()).show();
                                if(allValidate){
                                    $('html,body').animate({scrollTop: $(scheduleLabel).offset().top - 100}, 'slow');
                                    allValidate = false;
                                }
								break;
							}
						}

						// on vérifie que la date de début soit <= à la date de fin
						if(!comparDatesYMD(startDateSchedule, endDateSchedule)){
							$('.place-schedule-incorrect-date', $(scheduleLabel).parent()).show();
                            if(allValidate){
                                $('html,body').animate({scrollTop: $(namespaceAUI + "startDateScheduleException" + index).offset().top - 100}, 'slow');
                                allValidate = false;
                            }
						}else{
							$('.place-schedule-incorrect-date', $(scheduleLabel).parent()).hide();
						}

						periods[periods.length] = [startDateSchedule, endDateSchedule];
					}

					var fermeture = $(namespaceAUI + "closed" + index).get(0).checked;
					if (!fermeture) {
					    for(var j=1; j <= 5; j++){
                            var startHour = $(namespaceAUI + "startHour" + j + "_" + index).val();
                            var endHour = $(namespaceAUI + "endHour" + j + "_" + index).val();
                            if(j == 1 || startHour != "" || endHour != ""){
                                if(startHour == "") {
                                    $('.place-schedule-start-hour' + j, $(scheduleLabel).parent()).show();
                                    if(allValidate){
                                        $('html,body').animate({scrollTop: $(namespaceAUI + "startHour" + j + "_" + index).offset().top - 100}, 'slow');
                                        allValidate = false;
                                    }
                                }else{
                                    $('.place-schedule-start-hour' + j, $(scheduleLabel).parent()).hide();
                                }

                                if(endHour == "") {
                                    $('.place-schedule-end-hour' + j, $(scheduleLabel).parent()).show();
                                    if(allValidate){
                                        $('html,body').animate({scrollTop: $(namespaceAUI + "endHour" + j + "_" + index).offset().top - 100}, 'slow');
                                        allValidate = false;
                                    }
                                }else{
                                    $('.place-schedule-end-hour' + j, $(scheduleLabel).parent()).hide();
                                }

                                // on vérifie que l'heure de début soit < à l'heure de fin
                                if(startHour != "" && endHour != "" && !comparHour(startHour, endHour)){
                                    $('.place-schedule-incorrect-hour' + i, $(scheduleLabel).parent()).show();
                                    if(allValidate){
                                        $('html,body').animate({scrollTop: $(namespaceAUI + "startHour" + j + "_" + index).offset().top - 100}, 'slow');
                                        allValidate = false;
                                    }
                                }else{
                                    $('.place-schedule-incorrect-hour' + j, $(scheduleLabel).parent()).hide();
                                }
                            }
					    }
					}
				}
			}
		}
	}

	function activePeriod(indexPeriod){
        //cache les périodes non concernées
        $(".active", $("#period-time")).removeClass("active");
        // affiche la période concernée
        $("#onglet" + indexPeriod).addClass("active");
        $("#period" + indexPeriod).addClass("active in");
	}

});

// Schedules
var autoFields = undefined; // Référence au champ répétable (setté plus loin)
(function($) {
	var namespace = "_eu_strasbourg_portlet_place_PlaceBOPortlet_"; // Namespace du portlet

	// Configuration de l'autofield
	AUI().use('liferay-auto-fields', function(Y) {
		if (!!document.getElementById('date-fields')) {
			// Création de l'autofield
			autoFields = new Liferay.AutoFields({
				contentBox : '#date-fields',
				fieldIndexes : namespace + 'shedulesExceptionsIndexes',
				namespace : namespace,
				url : getscheduleExceptionRowJSPURL
			}).render();
		}
	});
})(jQuery);