jQuery(function() {

	$(":submit").on('click', function(e) {
		setInfosValidators(e);
	});

	function setInfosValidators(event) {
		// Validation des champs obligatoires conditionnels
		AUI().use('liferay-form',function() {
            var namespace = "_eu_strasbourg_portlet_activity_ActivityBOPortlet_";
            var namespaceAUI = "#" + namespace;

			var phoneHasValue = $(namespaceAUI + 'phone').val().length > 0;
			var siteURLHasValue = $(namespaceAUI + 'siteURL').val().length > 0;
			var mailHasValue = $(namespaceAUI + 'mail').val().length > 0;
			var facebookURLHasValue = $(namespaceAUI + 'facebookURL').val().length > 0;
			if (!phoneHasValue && !siteURLHasValue && !mailHasValue && !facebookURLHasValue) {
                $('.info-error').show();
                $('html,body').animate({scrollTop: $('.info-error').offset().top - 100}, 'slow');
                event.preventDefault();
			} else{
                $('.info-error').hide();
            }
		});
	}

});

// Activités
var autoFields = undefined; // Référence au champ répétable (setté plus loin)
(function($) {
	var namespace = "_eu_strasbourg_portlet_activity_ActivityBOPortlet_"; // Namespace du portlet

	// Configuration de l'autofield
	AUI().use('liferay-auto-fields', function(Y) {
		if (!!document.getElementById('practice-fields')) {
			// Création de l'autofield
			autoFields = new Liferay.AutoFields({
				contentBox : '#practice-fields',
				fieldIndexes : namespace + 'practiceIndexes',
				namespace : namespace,
				url : getPracticeRowURL
			}).render();
		}
	});
})(jQuery);
