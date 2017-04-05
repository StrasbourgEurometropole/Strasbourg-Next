// Champs conditionnelles
jQuery(function() {
	var namespace = "_eu_strasbourg_portlet_place_PlaceBOPortlet_";
	var namespaceAUI = "#" + namespace;

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

	$(":submit").on('click', function(e) {
		setSiteConditionalValidators();
		setFacebookConditionalValidators();
		setScheduleExceptionValidators();
		setPeriodValidators();
	});

	Liferay.on('allPortletsReady', setSiteConditionalValidators);
	Liferay.on('allPortletsReady', setFacebookConditionalValidators);
	Liferay.on('allPortletsReady', setScheduleExceptionValidators);
	Liferay.on('allPortletsReady', setPeriodValidators);

	function setSiteConditionalValidators() {
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

	function setFacebookConditionalValidators() {
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

	function setPeriodValidators() {
		var allValidated = true;
		var periodLabels = document
				.querySelectorAll('#date-fields2 .period-label');
		var nbPeriodDefault = 0;
		for (var i = 0; i < periodLabels.length; i++) {
			var periodLabel = periodLabels[i];
			var index = $(periodLabel).attr('id');
			// On ne lance la validation que si l'élément ne contient pas la
			// classe "hide"
			var nom = $(namespaceAUI + "namePeriod" + index).val();
			if (nom != undefined
					&& $(periodLabel).parents('.lfr-form-row').attr('class')
								.indexOf('hide') == -1) {
				var labelHasValue = $(namespaceAUI + 'periodLabel' + index).val().length > 0;
				var URLHasValue = $(namespaceAUI + 'periodURL' + index).val().length > 0;
				var retour = setSlotValidators(index, periodLabel).split(";");
				
				if (nom == "") {
					if (labelHasValue || URLHasValue || retour[0] == "true") {
						$('.place-period-name', $(periodLabel).parent()).show();
						allValidated = false;
					}else{
						$('.place-period-name', $(periodLabel).parent()).hide();
					} 
				}else{
					$('.place-period-name', $(periodLabel).parent()).hide();
					if (labelHasValue && !URLHasValue) {
						$('.place-period-label', $(periodLabel).parent()).hide();
						$('.place-period-url', $(periodLabel).parent()).show();
						allValidated = false;
					} else {
						if (!labelHasValue && URLHasValue) {
							$('.place-period-label', $(periodLabel).parent()).show();
							$('.place-period-url', $(periodLabel).parent()).hide();
							allValidated = false;
						} else{
							$('.place-period-label', $(periodLabel).parent()).hide();
							$('.place-period-url', $(periodLabel).parent()).hide();
						}
					}
					var periodDefault = $(namespaceAUI + "defaultPeriod" + index).get(0).checked;
					if (periodDefault) {
						$('.place-period-start-date', $(periodLabel).parent()).hide();
						$('.place-period-end-date', $(periodLabel).parent()).hide();
						if (nbPeriodDefault == 0) {
							nbPeriodDefault++;
							$('.place-period-default', $(periodLabel).parent()).hide();
						} else {
							$('.place-period-default', $(periodLabel).parent()).show();
							allValidated = false;
						}
					} else{
						$('.place-period-default', $(periodLabel).parent()).hide();
						var startDatePeriod = $(namespaceAUI + "startDatePeriod" + index).val();
						if(startDatePeriod == ""){
							$('.place-period-start-date', $(periodLabel).parent()).show();
							allValidated = false;
						}else{
							$('.place-period-start-date', $(periodLabel).parent()).hide();
						}
						var endDatePeriod = $(namespaceAUI + "endDatePeriod" + index).val();
						if(endDatePeriod == ""){
							$('.place-period-end-date', $(periodLabel).parent()).show();
							allValidated = false;
						}else{
							$('.place-period-end-date', $(periodLabel).parent()).hide();
						}
					}
				}
				if(retour[1] == "false"){
					allValidated = false;
				}
			}
		}
		
		if (!allValidated) {
			event.preventDefault();
		}
	}

	function setSlotValidators(indexPeriod, periodLabel) {
		var renseigner = false;
		var allValidated = true;
		
		for (var jour = 0; jour < 7; jour++) {
			for (var indexSlot = 0; indexSlot < 3; indexSlot++) {
				var heureDebutHasValue = $(namespaceAUI + 'startHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot).val().length > 0;
				var heureFinHasValue = $(namespaceAUI + 'endHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot).val().length > 0;
				if (heureDebutHasValue && !heureFinHasValue) {
					$('#slotStartHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).hide();
					$('#slotEndHour' + indexPeriod
							+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).show();
					renseigner = true;
					allValidated = false;
				} else {
					if (!heureDebutHasValue && heureFinHasValue) {
						$('#slotStartHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).show();
						$('#slotEndHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).hide();
						renseigner = true;
						allValidated = false;
					} else {
						$('#slotStartHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).hide();
						$('#slotEndHour' + indexPeriod
								+ '-' + jour + '-' + indexSlot, $(periodLabel).parent()).hide();
						if(heureDebutHasValue && heureFinHasValue){
							renseigner = true;
						}
					}
				}
			}
		}
		return renseigner + ";" + allValidated;
	}

	function setScheduleExceptionValidators() {
		var allValidated = true;
		var scheduleLabels = document
				.querySelectorAll('#date-fields .schedule-label');
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
						namespaceAUI + "scheduleExceptionDescription" + index)
						.val();
				var endDateSchedule = $(namespaceAUI + "endDateScheduleException" + index).val();
				if(startDateSchedule == ""){
					var startHour = $(namespaceAUI + "startHour" + index).val();
					var endHour = $(namespaceAUI + "endHour" + index).val();
					if (endDateSchedule || scheduleExceptionDescription != "" || startHour != "" || endHour != "") {
						$('.place-schedule-start-date', $(scheduleLabel).parent()).show();
						allValidated = false;
					}else{
						$('.place-schedule-start-date', $(scheduleLabel).parent()).hide();
					}
				}else{
					if (endDateSchedule == "") {
						$('.place-schedule-end-date', $(scheduleLabel).parent()).show();
						allValidated = false;
					}else{
						$('.place-schedule-end-date', $(scheduleLabel).parent()).hide();
					}
					if (scheduleExceptionDescription == "") {
						$('.place-schedule-description', $(scheduleLabel).parent()).show();
						allValidated = false;
					}else{
						$('.place-schedule-description', $(scheduleLabel).parent()).hide();
					}
					var fermeture = $(namespaceAUI + "closed" + index).get(0).checked;
					if (!fermeture) {
						var startHour = $(namespaceAUI + "startHour" + index).val();
						var endHour = $(namespaceAUI + "endHour" + index).val();
						if(startHour == "") {
							$('.place-schedule-start-hour', $(scheduleLabel).parent()).show();
							allValidated = false;
						}else{
							$('.place-schedule-start-hour', $(scheduleLabel).parent()).hide();
						}
						if(endHour == "") {
							$('.place-schedule-end-hour', $(scheduleLabel).parent()).show();
							allValidated = false;
						}else{
							$('.place-schedule-end-hour', $(scheduleLabel).parent()).hide();
						}
					}
				}
			}
		}
		
		if (!allValidated) {
			event.preventDefault();
		}
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

// Périodes
var autoFields2 = undefined; // Référence au champ répétable (setté plus loin)
(function($) {
	var namespace = "_eu_strasbourg_portlet_place_PlaceBOPortlet_"; // Namespace du portlet

	// Configuration de l'autofield
	AUI().use('liferay-auto-fields', function(Y) {
		if (!!document.getElementById('date-fields2')) {
			// Création de l'autofield
			autoFields2 = new Liferay.AutoFields({
				contentBox : '#date-fields2',
				fieldIndexes : namespace + 'periodsIndexes',
				namespace : namespace,
				url : getperiodRowJSPURL,
				on: {
					'clone': function(event) {
						var index = event.details[0].guid;
						var html = "<div class='lfr-form-row lfr-form-row-inline' id='attendance" + index + "'>"
						+"<div class='row-fields'>"
						+"<div class='attendance-label' id='" + index + "' onCLick=\"$('.attendance-content" + index + "').toggle();\">"
						+"<label>Période " + event.details[0].guid + "</label>"
						+"</div>"
						+"<div class='attendance-content" + event.details[0].guid + "' >"
						+"<div class='form-group input-text-wrapper'>" 
						+"<label class='control-label' for='" + namespace + "RTGreenThreshold" + event.details[0].guid + "'> Seuil Vert - Orange </label> " 
						+"<input class='field form-control' id='" + namespace + "RTGreenThreshold" + event.details[0].guid + "' name='" + namespace + "RTGreenThreshold" + event.details[0].guid + "' type='text' >" 
						+"</div> " 
						+"<div class='form-group input-text-wrapper'> " 
						+"<label class='control-label' for='" + namespace + "RTOrangeThreshold" + event.details[0].guid + "'> Seuil Orange - Rouge </label>" 
						+"<input class='field form-control' id='" + namespace + "RTOrangeThreshold" + event.details[0].guid + "' name='" + namespace + "RTOrangeThreshold" + event.details[0].guid + "' type='text'> " 
						+"</div> " 
						+"<div class='form-group input-text-wrapper'> " 
						+"<label class='control-label' for='" + namespace + "RTRedThreshold" + event.details[0].guid + "'> Seuil Rouge - Noir </label> " 
						+"<input class='field form-control' id='" + namespace + "RTRedThreshold" + event.details[0].guid + "' name='" + namespace + "RTRedThreshold" + event.details[0].guid + "' type='text'> " 
						+"</div> " 
						+"<div class='form-group input-text-wrapper'> " 
						+"<label class='control-label' for='" + namespace + "RTMaxThreshold" + event.details[0].guid + "'> Capacité totale </label> " 
						+"<input class='field form-control' id='" + namespace + "RTMaxThreshold" + event.details[0].guid + "' name='" + namespace + "RTMaxThreshold" + event.details[0].guid + "' type='text'> " 
						+"</div>" 
						+"</div>"
						+"</div>"
						+"</div>";
						$('#attendanceContent').children().append(html);
					},
					'delete': function(event) {
						$('#attendance'+ event.deletedRow._node.innerText.trim().split(" ")[1]).remove();
					}
				},
			}).render();
		}
		
	});
})(jQuery);