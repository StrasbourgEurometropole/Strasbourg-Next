// Champs conditionnelles
jQuery(function() {
	var namespace = "_eu_strasbourg_portlet_agenda_AgendaBOPortlet_";
	
	$('[name=imageType]').on('click change', function(e) {
		var classOfDivToShow = e.target.value;
		var classOfDivToHide = 'internalImageexternalImage'.replace(classOfDivToShow, '');
		$('.internalImage, .externalImage').hide();	
		$('.' + classOfDivToShow).show();
		$('.' + classOfDivToHide + ' input').val('');
		$('.' + classOfDivToHide + ' .image-thumbnail').remove();
		setConditionalValidators();
	});

	$(":submit").on('click', function(e) {
		allValidate = true;

		setConditionalValidators(e);
		setPeriodValidators(e);
	});
	
	function setConditionalValidators() {
		// Validation des champos obligatoires conditionnels
		AUI().use('liferay-form', function() {
			if (!!window.editManif) {
				var rules = Liferay.Form.get(namespace + 'fm').formValidator.get('rules');
				if (jQuery('.internalImage').is(':visible')) {
					rules[namespace + 'imageId'].required = true;
					rules[namespace + 'externalImageURL'].required = false;
					rules[namespace + 'externalImageCopyright'].required = false;
				} else {
					rules[namespace + 'imageId'].required = false;
					rules[namespace + 'externalImageURL'].required = true;
					rules[namespace + 'externalImageCopyright'].required = true;
				}
			}
		});
		
	}

	function setPeriodValidators(event) {
		var namespaceAUI = "#" + namespace;
		var allValidated = true;
		var startDateString = $(namespaceAUI + "startDate").val();
		if(startDateString == ""){
			$('.start-date-error').show();
			allValidated = false;
		}else{
			$('.start-date-error').hide();
		}
		var endDateString = $(namespaceAUI + "endDate").val();
		if(endDateString == ""){
			$('.end-date-error').show();
			allValidated = false;
		}else{
			$('.end-date-error').hide();
		}

		if(allValidated){
			// on vérifie que la date de début soit <= à la date de fin
			var startDate = moment(startDateString, 'DD/MM/YYYY');
			var endDate = moment(endDateString, 'DD/MM/YYYY');
			if(startDate.isSameOrAfter(endDate)){
				$('.incorrect-date-error').show();
				allValidated = false;
			}else{
				$('.incorrect-date-error').hide();
			}
		}

		if (!allValidated) {
			event.preventDefault();
		}
	}
	
});