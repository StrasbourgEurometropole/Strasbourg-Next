<%@ include file="/contact-form-init.jsp" %>
<div class="container">
    <div id="breadcrumb" class="pro-bloc">
        <span>
            <span><a href="index.html">Accueil</a>
                <span class="breadcrumb_last">Nous contacter</span>
            </span>
        </span>
    </div>
</div>
<div class="container">
    <div class="pro-bloc pro-bloc-texte pro-max-900 aligncenter">
        <c:if test="${not empty title}">
            <h2>${title}</h2>
        </c:if>
        <c:if test="${not empty descriptionText}">
            <p>${descriptionText}</p>
        </c:if>
    </div>
</div>


<div class="pro-bloc-pcs-form pro-form-page-contact">
<c:choose>
	 <c:when test="${not param.mailSent}">
	    <liferay-portlet:actionURL name="contact" var="contactURL">
			<portlet:param name="placit" value="placit"></portlet:param>
	    </liferay-portlet:actionURL>
	        <form action="${contactURL}" method="post" class="seu-main-form" onsubmit="return checkForm();">
	            <liferay-ui:error key="unknown-error" message="eu.unknown-error" targetNode=".seu-main-form" />
	            <liferay-ui:error key="email-error" message="email-error" targetNode=".seu-main-form" />
	            <liferay-ui:error key="lastname-error" message="lastname-error" targetNode=".seu-main-form" />
	            <liferay-ui:error key="firstname-error" message="firstname-error" targetNode=".seu-main-form" />
	            <liferay-ui:error key="content-error" message="content-error" targetNode=".seu-main-form" />
	            <liferay-ui:error key="invalid-mail-error" message="eu.invalid-mail-error" targetNode=".seu-main-form" />
				<liferay-ui:error key="friendlycaptcha-error" message="eu.friendlycaptcha-error" targetNode=".seu-main-form" />
	
	            <div class="container pro-max-900">
	                <div class="pro-wrapper">
	                    <div class="pro-row">
	                        <div class="form-group form-half">
	                            <aui:input cssClass="form-control" name="contact.lastname" placeholder="Dupond" />
	                        </div>
	                        <div class="form-group form-half">
	                            <aui:input cssClass="form-control" name="contact.firstname" placeholder="Jean" />
	                        </div>
	                    </div>
	                    <div class="pro-row">
	                        <div class="form-group form-half">
	                            <aui:input cssClass="form-control" name="contact.mail" placeholder="jean.dupond@gmail.com" />
	                        </div>
	                        <div class="form-group form-half">
	                            <aui:input cssClass="form-control" name="contact.phone" />
	                        </div>
	                    </div>
	                     <div class="form-group">
	                        <aui:input cssClass="form-control" name="contact.object" />
	                    </div>
	                    <div class="form-group">
	                        <aui:input type="textarea" cssClass="form-control" name="contact.request"/>
	                    </div>

						<div class="recaptcha">
							<div class="frc-captcha"
								 data-puzzle-endpoint="${friendlycaptchaPuzzleURL}"
								 data-sitekey="${friendlycaptcha}"></div>
						</div>
	                </div>
	            </div>
	
	            <div class="pro-optin form-checkbox">
	                <div class="container pro-max-900">
	                    <input type="checkbox" name="sendCopy" id="sendCopy">
	                    <label for="sendCopy"><liferay-ui:message key="contact.receive-copy" /></label>
	                </div>
	            </div>
	            <div class="pro-optin form-checkbox">
	                <div class="container pro-max-900">
	                    <input type="checkbox" name="rgpdCheck" id="rgpdCheck">
	                    <label for="rgpdCheck"><liferay-ui:message key="contact.rgpd-check" /></label>
	                </div>
	            </div>
	            <div class="pro-form-submit">
	                <input type="hidden" id="placit" name="<portlet:namespace />placit"/>
	                <button id="submit_placit_form" type="submit" class="btn btn-default"><liferay-ui:message key="contact.send" /></button>
	            </div>
	        </form>
	    </c:when>
	    <c:otherwise>
	    	<div class="container pro-max-900">
	    		<div class="pro-wrapper">
		    		<p><liferay-ui:message key="success2" /></p>
	    		</div>
    		</div>
	    </c:otherwise>
    </c:choose>
</div>

<!-- VALIDATION RGPD -->
<!-- HTML pour la modal de vérification de la prise en compte de la mention RGPD -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalCheckRGPD" tabindex="-1" role="dialog" aria-labelledby="modalCheckRGPD">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='confirm-rgpd-top-message'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='confirm-rgpd-message'/></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn" value=<liferay-ui:message key="confirm-rgpd-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<script type="module" src="/o/0-global-theme/libs/friendlycaptcha/widget.module.min.js" async defer ></script>
<script nomodule src="/o/0-global-theme/libs/friendlycaptcha/widget.min.js" async defer></script>

<script type="text/javascript">

function checkForm()
{
	if($("#rgpdCheck").is(":checked"))
		return true;
	else {
		$('#modalCheckRGPD').modal('show');
		return false;
	}
}

$(document).ready(function(){
    $('#modalCheckRGPD').modal('hide');
});

$('#modalCheckRGPD').click(function(event){
    $('#modalCheckRGPD').modal('hide');
});
        
</script>