// Champs conditionnelles
jQuery(function() {
	var namespace = "_eu_strasbourg_portlet_interest_InterestBOPortlet_";
    jQuery('#' + namespace + 'fm').submit( function(event) {
        // vérifi qu'au moins une catégorie a été selctionnée
        var listCateg = "";
        $("input[name^='" + namespace + "assetCategoryIds_']").each(function(index){
            console.log($(this).val());
            listCateg += $(this).val();
        });
        if(listCateg == ""){
            jQuery('#' + namespace + 'fm .condition').addClass('help-block');
            event.stopImmediatePropagation();
            event.preventDefault();
        }
    });


	
});