<%@ include file="/pacte-init.jsp"%>

<portlet:resourceURL id="pacteSignature" var="pacteSignatureURL">
</portlet:resourceURL>

<div id="content">
    <div class="pro-bloc-prefooter pro-sticky-bar">
        <div class="container">
            <div class="row pro-pencil">
                <div class="col-md-6 col-xs-12">
                    <div class="pro-bloc-pcs-form">
                        <form>
                            <div class="pro-optin form-checkbox pacte">
                                <div>
                                    <input type="checkbox" id="type_v_2" value="optin" <c:if test="${hasUserSigned}">checked="checked" </c:if>>
                                    <label for="type_v_2"><liferay-ui:message key="pacte.label"/></label>
                                </div>
                                <div>
                                    <input type="checkbox" id="listing_signataire" value="optin" <c:if test="${isDisplayListing}">checked="checked" </c:if>>
                                    <label id="listing_signataire_label" for="listing_signataire"><liferay-ui:message key="pacte.listing.signataire.cb"/></label>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-md-6 col-xs-12 pro-signature-btn">
                    <div>
                        <p><a href="/signataires">${nbSignataires} <liferay-ui:message key="pacte.adhere.personnes"/></a> <liferay-ui:message key="pacte.adhere"/></p>
                        <span class="pro-you"><liferay-ui:message key="pacte.adhere.and.you"/></span>
                    </div>
                    <c:if test="${hasUserSigned}">
                        <a id="SignerPacte" href="#" class="pro-btn-signer active"><liferay-ui:message key="pacte.already.adhere"/></a>
                    </c:if>
                    <c:if test="${!hasUserSigned}">
                        <a id="SignerPacte" title="<liferay-ui:message key="pacte.sign.title"/>" href="#" class="pro-btn-signer"><liferay-ui:message key="pacte.sign"/></a>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- CONFIRMATION QUITTER -->
<!-- HTML pour confirmer la resiliation du pacte -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalQuitPacte" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.quit.title"/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key="modal.quit.description" /></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirmQuit" onclick="callServeResource(true);" type="submit" class="pro-btn" value="<liferay-ui:message key='modal.quit.resilier'/>"/>
                    <input id="buttonCancelQuit" type="reset" class="pro-btn"  data-dismiss="modal" value="Annuler"/>
                </div>
            </div>
        </div>
    </div>
</div>

<aui:script>

$("#SignerPacte").click(function(e){
    if($(this).hasClass('active')){
        e.preventDefault();
        $("#modalQuitPacte").modal('show');
    }
    else {
    	if($("#type_v_2").is(':checked'))
    		callServeResource(true)
    	else 
			alert('<liferay-ui:message key="pacte.clauses.check" />');
   	};
});

function callServeResource(pactRead) {
	
	 var isDisplayListing = $('#listing_signataire').prop('checked');
	
	if(${isUserloggedIn}){
	    $('#modalQuitPacte').modal('hide');
           AUI().use('aui-io-request', function(A) {
               A.io.request('${pacteSignatureURL}', {
                   method : 'post',
                   data : {
                       <portlet:namespace/>clauses : true,
                       <portlet:namespace/>isDisplayListing : isDisplayListing
                   },
                   on: {
                       success: function(e) {
                           e.preventDefault();
                           $("#SignerPacte").toggleClass('active');
                           if($("#SignerPacte").hasClass('active')){
                              	$("#SignerPacte").text('<liferay-ui:message key="pacte.already.adhere" />');
                               
								// Recuperer l'URL complete.
								var currentURL = new URL(window.location.href);
								// Extraction du parametre contenant l'URL de redirection.
                               	var encodedRedirectURL = currentURL.searchParams.get("redirectURL");
                               
                               	if (encodedRedirectURL) {
       								// Decodage de l'URL de redirection.
                               		var redirectURL = decodeURIComponent(encodedRedirectURL);
       								// Changement de page
                               		window.location.href = redirectURL;
                           		}
                               
                           	}
                           	else{
                               	$("#SignerPacte").text('<liferay-ui:message key="pacte.sign" />');
                           	}
                       }
                    }
               });
           });
	}
	else {
		$("#myModal").modal();
	}
}
</aui:script>