var namespace = '_eu_strasbourg_portlet_council_CouncilBOPortlet_';

jQuery(function() {
    /** Autocomplete des élus */
    var options = {
        type : "POST",
        serviceUrl : "/api/jsonws/council.official/get-official-by-full-name-and-type/",
        params : {
            fullName : '[fullName]',
            type : "",
            removedOfficialId : 0,
            groupId : currentGroupId,
            p_auth: Liferay.authToken
        },
        paramName : 'fullName',
        transformResult : function(response) {
            return {
                suggestions : jQuery.map(
                    JSON.parse(response), function(dataItem) {
                        return {
                            value : dataItem.fullName,
                            data : dataItem.officialId
                        };
                    })
            };
        },
        onSelect : function(suggestion) {
            $(this).val(suggestion.value);
            $(this).parent().siblings().val(suggestion.data);
        }
    };
    jQuery('.official-autocomplete-input-wrapper').each(function() {
    	$('.autocomplete-shown', this).autocomplete(options);
    });
 });