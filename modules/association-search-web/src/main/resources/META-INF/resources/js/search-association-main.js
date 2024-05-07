jQuery(function() {
	var namespace = "_eu_strasbourg_portlet_association_SearchAssociationPortlet_";
	var namespaceAUI = "#" + namespace;


    var domainsSelect = $('select.domains');
    var domainsSelectBarre = $('select.domainsBarre');

    var specialityWidget = $('.st-group-field.speciality');
    var specialitiesSelect = $('select.specialities');

    var specialityWidgetBarre = $('.st-group-field.specialityBarre');
    var specialitiesSelectBarre = $('select.specialitiesBarre');

    var subSpecialityWidget = $('.st-group-field.subSpeciality');
    var subSpecialitiesSelect = $('select.subSpecialities');

    var subSpecialityWidgetBarre = $('.st-group-field.subSpecialityBarre');
    var subSpecialitiesSelectBarre = $('select.subSpecialitiesBarre');

    var subSubSpecialityWidget = $('.st-group-field.subSubSpeciality');
    var subSubSpecialitiesSelect = $('select.subSubSpeciality');

    var subSubSpecialityWidgetBarre = $('.st-group-field.subSubSpecialityBarre');
    var subSubSpecialitiesSelectBarre = $('select.subSubSpecialityBarre');

    // Lors d'une selection de domaine
    domainsSelect.change(onDomainChange);
    domainsSelectBarre.change(onDomainChange);

    // Lors d'une selection de spécialité
    specialitiesSelect.change(onSpecialitiesChange);
    specialitiesSelectBarre.change(onSpecialitiesChange);

    // Lors d'une selection de sous-spécialité
    subSpecialitiesSelect.change(onSubSpecialitiesChange);
    subSpecialitiesSelectBarre.change(onSubSpecialitiesChange);

    function onDomainChange() {
        console.log("onDomainChange")
        if($(this).val() != ""){
            // on initialise le select des spécialités
            Liferay.Service(
                '/strasbourg.strasbourg/get-practice-categories', {
                    parentCategoryId: $(this).val(),
                    localeId: Liferay.ThemeDisplay.getLanguageId()
                },
                function(data) {
                    specialitiesSelect.empty();
                    specialityWidget.find('.customSelectInner').text("");
                    specialitiesSelect.append('<option class="" value="">Tout afficher</option>');
                    jQuery.each(data, function(index, categ){
                        specialitiesSelect.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                    });
                    // on affiche les spécialités
                    specialityWidget.show();

                    //DO THE SAME FOR THE BARRE
                    specialitiesSelectBarre.empty();
                    specialityWidgetBarre.find('.customSelectInner').text("");
                    specialitiesSelectBarre.append('<option class="" value="">Tout afficher</option>');
                    jQuery.each(data, function(index, categ){
                        specialitiesSelectBarre.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                    });
                    // on affiche les spécialités
                    specialityWidgetBarre.show();

                    // on déclenche le changement pour le select
                    specialitiesSelect.trigger( "change" );
                    specialitiesSelectBarre.trigger( "change" );


                })
            // on cache les autres select
            subSpecialityWidget.hide();
            subSubSpecialityWidget.hide();

            subSpecialityWidgetBarre.hide();
            subSubSpecialityWidgetBarre.hide();
        }else{
            specialityWidget.hide();
            subSpecialityWidget.hide();
            subSubSpecialityWidget.hide();

            specialityWidgetBarre.hide();
            subSpecialityWidgetBarre.hide();
            subSubSpecialityWidgetBarre.hide();
        }
    }

    function onSpecialitiesChange() {
        console.log("onSpecialitiesChange")
        if($(this).val() != ""){
            // on initialise le select des sous-spécialités
            Liferay.Service(
                '/strasbourg.strasbourg/get-practice-categories', {
                    parentCategoryId: $(this).val(),
                    localeId: Liferay.ThemeDisplay.getLanguageId()
                },
                function(data) {
                    // on réinistialise les sous-spécialités
                    subSpecialitiesSelect.empty();
                    subSpecialityWidget.find('.customSelectInner').text("");
                    subSpecialitiesSelect.append('<option class="" value="">Tout afficher</option>');
                    if(data.length > 0){
                        jQuery.each(data, function(index, categ){
                            subSpecialitiesSelect.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                        });
                        // on affiche les sous-spécialités
                        subSpecialityWidget.show();
                    }else{
                        // on cache les sous-spécialités
                        subSpecialityWidget.hide();
                        // on met à jour la valeur du select
                        subSpecialitiesSelect.val("");


                    }
                    // on déclenche le changement pour le select
                    subSpecialitiesSelect.trigger( "change" );

                    //DO THE SAME FOR THE BARRE
                    // on réinistialise les sous-spécialités
                    subSpecialitiesSelectBarre.empty();
                    subSpecialityWidgetBarre.find('.customSelectInner').text("");
                    subSpecialitiesSelectBarre.append('<option class="" value="">Tout afficher</option>');
                    if(data.length > 0){
                        jQuery.each(data, function(index, categ){
                            subSpecialitiesSelectBarre.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                        });
                        // on affiche les sous-spécialités
                        subSpecialityWidgetBarre.show();
                    }
                    else{
                        // on cache les sous-spécialités
                        subSpecialityWidgetBarre.hide();
                        // on met à jour la valeur du select
                        subSpecialityWidgetBarre.val("");

                    }
                    // on déclenche le changement pour le select
                    subSpecialityWidgetBarre.trigger( "change" );
                });

            // on cache les autres select
            subSubSpecialityWidget.hide();

            subSubSpecialityWidgetBarre.hide();
        }else{
            subSpecialityWidget.hide();
            subSubSpecialityWidget.hide();

            // on réinistialise les sous-spécialités
            subSpecialitiesSelect.empty();
            subSpecialityWidget.find('.customSelectInner').text("");
            subSpecialitiesSelect.append('<option class="" value="">Tout afficher</option>');

            subSpecialitiesSelectBarre.empty();
            subSpecialityWidgetBarre.find('.customSelectInner').text("");
            subSpecialitiesSelectBarre.append('<option class="" value="">Tout afficher</option>');

            subSpecialityWidgetBarre.hide();
            subSubSpecialityWidgetBarre.hide();


        }
    }

    function onSubSpecialitiesChange() {
        console.log("onSubSpecialitiesChange")
        if($(this).val() != ""){
            // on initialise le select des sous-sous-spécialités
            Liferay.Service(
                '/strasbourg.strasbourg/get-practice-categories', {
                    parentCategoryId: $(this).val(),
                    localeId: Liferay.ThemeDisplay.getLanguageId()
                },
                function(data) {
                    // on réinistialise les sous-sous-spécialités
                    subSubSpecialitiesSelect.empty();
                    subSubSpecialityWidget.find('.customSelectInner').text("");
                    subSubSpecialitiesSelect.append('<option class="" value="">Tout afficher</option>');
                    if(data.length > 0){
                        jQuery.each(data, function(index, categ){
                            subSubSpecialitiesSelect.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                        });
                        // on affiche les sous-sous-spécialités
                        subSubSpecialityWidget.show();
                    }else{
                        // on cache les sous-sous-spécialités
                        subSubSpecialityWidget.hide();
                        // on met à jour la valeur du select
                        subSubSpecialityWidget.val("");

                    }
                    // on déclenche le changement pour le select
                    subSubSpecialityWidget.trigger( "change" );

                    //DO THE SAME FOR THE BARRE
                    // on réinistialise les sous-sous-spécialités
                    subSubSpecialitiesSelectBarre.empty();
                    subSubSpecialityWidgetBarre.find('.customSelectInner').text("");
                    subSubSpecialitiesSelectBarre.append('<option class="" value="">Tout afficher</option>');
                    if(data.length > 0){
                        jQuery.each(data, function(index, categ){
                            subSubSpecialitiesSelectBarre.append('<option class="" value="' + categ.id + '">' + categ.title + ' </option>');
                        });
                        // on affiche les sous-sous-spécialités
                        subSubSpecialityWidgetBarre.show();
                    }
                    else{
                        // on cache les sous-sous-spécialités
                        subSubSpecialityWidgetBarre.hide();
                        // on met à jour la valeur du select
                        subSubSpecialityWidgetBarre.val("");

                    }
                    // on déclenche le changement pour le select
                    subSubSpecialityWidgetBarre.trigger( "change" );
                });
        }else{
            subSubSpecialityWidget.hide();

            // on réinistialise les sous-sous-spécialités
            subSubSpecialitiesSelect.empty();
            subSubSpecialityWidget.find('.customSelectInner').text("");
            subSubSpecialitiesSelect.append('<option class="" value="">Tout afficher</option>');


            // on réinistialise les sous-sous-spécialités
            subSubSpecialitiesSelectBarre.empty();
            subSubSpecialityWidgetBarre.find('.customSelectInner').text("");
            subSubSpecialitiesSelectBarre.append('<option class="" value="">Tout afficher</option>');

            subSubSpecialityWidgetBarre.hide();
        }
    }
});



selectA11yOnChange = function(selectClass, optionIndex) {
    var select = selectClass
    var id = select.id
    // check if the id the Barre at the end of the id
    if(id.indexOf("Barre") > -1) {
        // get the id of the filter`
        var filterId = id.replace("Barre", "");
        // get the filter
        selectA11lyClass.forEach(function (selectA11y) {
            if(selectA11y.id == filterId) {
                selectA11y._toggleSelection(optionIndex, true, false);
            }
        });

    }
    else {
        // get the id of the filter
        var filterId = id + "Barre";
        // get the filter
        selectA11lyClass.forEach(function (selectA11y) {
            if(selectA11y.id == filterId) {
                selectA11y._toggleSelection(optionIndex, true, false);
            }
        });
    }
}