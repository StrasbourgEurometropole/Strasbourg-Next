<%@ include file="/project-popup-init.jsp" %>

<portlet:resourceURL id="submitSaisineObservatoire" var="submitSaisineObservatoireURL">
</portlet:resourceURL>

<!-- DEPOSER UNE NOUVELLE SAISINE -->
<!-- HTML pour la modal de saisine -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalSaisineObservatoire" tabindex="-1" role="dialog" aria-labelledby="modalSaisineObservatoire"
	data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.submitsaisineobservatoire.title"/></h3>
                <button type="button" class="close closefirstmodal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <form id="form-submit-saisine-observatoire">
                <div class="pro-wrapper">
                    <h4><liferay-ui:message key="modal.submitsaisineobservatoire.information"/></h4>
                    <div class="form-group">
                        <aui:input id="saisinetitle" name="title" label="modal.submitsaisineobservatoire.information.title" required="true" maxlength="45" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="saisineProjectTarget" type="text" name="projectTarget" label="modal.submitsaisineobservatoire.information.projectTarget" required="true" maxlength="150" value=""/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="dispositif"><liferay-ui:message key="modal.submitsaisineobservatoire.information.dispositif"/></label>
                            <select id="<portlet:namespace />dispositif" name="<portlet:namespace />dispositif" required="true" >
                                <option value="0" selected ></option>
                                <c:forEach var="dispositif" items="${dispositifs}">
                                    <option value="${dispositif.categoryId}">${dispositif.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-half">
                            <aui:input id="saisineOtherMechanism" type="text" name="otherMechanism" label="modal.submitsaisineobservatoire.information.otherMechanism" maxlength="150" value=""/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="quartier"><liferay-ui:message key="modal.submitsaisineobservatoire.information.territoire"/></label>
                            <select id="<portlet:namespace />quartier" name="<portlet:namespace />quartier">
                                <option value="0" selected ><liferay-ui:message key="modal.submitsaisineobservatoire.information.territoire.town"/></option>
                                <c:forEach var="quartier" items="${quartiers}">
                                    <option value="${quartier.categoryId}">${quartier.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <label for="theme"><liferay-ui:message key="modal.submitsaisineobservatoire.information.thematique"/></label>
                            <select id="<portlet:namespace />theme" name="<portlet:namespace />theme">
                                <option value="0" selected ></option>
                                <c:forEach var="theme" items="${thematics}">
                                    <option value="${theme.categoryId}">${theme.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input id="saisineobservatoirelieux" name="consultationPlacesText" label="modal.submitsaisineobservatoire.information.lieu" maxlength="256" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="saisinedescription" type="textarea" name="description" label="modal.submitsaisineobservatoire.information.description" required="true" value=""/>
                    </div>
                    <%-- Champ : Image --%>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <span class="browsePicture input-group-btn">
                                <aui:input name="photo" type="file" label="modal.submit.initiative.information.picture"
                                    cssClass="btn btn-default btn-choose">
                                    <aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
                                </aui:input>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="pro-wrapper last-wrapper">
                    <h4><liferay-ui:message key="modal.submitsaisineobservatoire.user"/></h4>
                    <div class="pro-row">
                        <div class="form-group form-triple">
                            <aui:input name="username" disabled="true" label="modal.user.username" required="true" value="${userConnected.get('last_name')}"/>
                        </div>
                        <div class="form-group form-triple">
                            <aui:input name="firstname" disabled="true" label="modal.user.firstname" required="true" value="${userConnected.get('first_name')}"/>
                        </div>
                        <div class="form-group form-triple">
	                        <c:if test="${userConnected.get('birthdate') ne 'null'}">
	                            <fmt:parseDate pattern="yyyy-MM-dd" value="${userConnected.get('birthdate')}" var="parsedStatusDate" />
					            <fmt:formatDate value="${parsedStatusDate}" var="formattedDate" type="date" pattern="dd/MM/yyyy" />
	                        </c:if>
                            <aui:input id="birthday" name="birthday" cssClass="frm_date" label="modal.user.birthday" required="true" placeholder="jj/mm/aaaa" maxlength="10" onInput="checkValuesSubmitSaisineObservatoire();" onChange="checkValuesSubmitSaisineObservatoire();"/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input id="address" name="address" label="modal.user.address" required="true" maxlength="256" onInput="checkValuesSubmitSaisineObservatoire();"/>
                        </div>
                        <div class="form-group form-half">
                            <div class="form-city">
                                <aui:input id="city" name="city" label="modal.user.city" required="true" placeholder="Strasbourg" maxlength="256" onInput="checkValuesSubmitSaisineObservatoire();"/>
                            </div>
                            <div class="form-code">
                                <aui:input id="postalcode" name="postalcode" label="modal.user.postalcode" required="true" type="number" maxlength="5" pattern="[0-9]{5}" placeholder="67XXX" onInput="checkValuesSubmitSaisineObservatoire();"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input type="email" name="mail" disabled="true" label="modal.user.mail" required="true" value="${userConnected.get('email')}"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input id="phone" name="phone" label="modal.user.phone" placeholder="0311111111" maxlength="20" onInput="checkValuesSubmitSaisineObservatoire();"/>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="mobile" name="mobile" label="modal.user.mobile" placeholder="0611111111" maxlength="20" onInput="checkValuesSubmitSaisineObservatoire();"/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="as"><liferay-ui:message key="modal.submitsaisineobservatoire.information.as"/></label>
                            <select id="<portlet:namespace />aka" name="<portlet:namespace />aka" required="true" >
                                <option value="0" selected ></option>
                                <c:forEach var="aka" items="${aka}">
                                    <option value="${aka.categoryId}">${aka.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="saisineCollectiveName" name="collectiveName" label="modal.submitsaisineobservatoire.information.collectiveName" required="false" maxlength="150" value=""/>
                        </div>
                    </div>
                    <div class="form-group form-checkbox" id="checkboxSaveInfo">
                        <div>
                            <input type="checkbox" id="save-info" value="save-info">
                            <label for="save-info"><liferay-ui:message key="modal.save.info"/></label>
                        </div>
                    </div>
                </div>
                <div class="top-slope"></div>
                <div class="pro-optin form-checkbox">
                    <div>
                        <input type="checkbox" id="submit-saisine-observatoire-legalage" value="legalage">
                        <label for="submit-saisine-observatoire-legalage" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_legalageSubmitSaisineObservatoire"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="submit-saisine-observatoire-understanding" value="understanding">
                        <label for="submit-saisine-observatoire-understanding" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_understandingSubmitSaisineObservatoire"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="submit-saisine-observatoire-cnil" value="cnil">
                        <label for="submit-saisine-observatoire-cnil" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cnilSubmitSaisineObservatoire"/>
                        </label>
                    </div>
                </div>
                <div class="pro-info-supp">
                    <p><i><liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_conditionsSubmitSaisineObservatoire"/></i></p>
                    <p><liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_contactSubmitSaisineObservatoire"/></p>
                </div>
                <div id="sendalert" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert"/></div>
                <div id="submitalertLegalage" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.legalage"/></div>
                <div id="submitalertcity" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.city"/></div>
                <div id="submitalertPostalCode" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.postalcode"/></div>
                <div class="pro-form-submit">
                    <button id="sendSaisineObservatoire" type="submit" class="btn btn-default"><liferay-ui:message key="modal.submitsaisineobservatoire.submit"/></button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- CONFIRMATION NOUVELLE SAISINE -->
<!-- HTML pour la modal de confirmation de nouvelle saisine -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalConfirmerSaisineObservatoire" tabindex="-1" role="dialog" aria-labelledby="modalConfirmerSaisineObservatoire">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='confirm-saisine-observatoire'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='submit-saisine-observatoire-ok'/></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn-yellow" value=<liferay-ui:message key="button-saisine-observatoire-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>


<!-- ERREUR NOUVELLE SAISINE -->
<!-- HTML pour la modal d'erreur de nouvelle saisine -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalErrorSaisineObservatoire" tabindex="-1" role="dialog" aria-labelledby="modalErrorSaisineObservatoire">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='error-saisine-observatoire'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn-yellow" value=<liferay-ui:message key="button-saisine-observatoire-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

	var namespaceSubmitSaisineObservatoire = "<portlet:namespace />";
	var saved_address = "${userConnected.get('address')}";
	var saved_zipCode = "${userConnected.get('zipcode')}";
	var saved_city = "${userConnected.get('city')}";
	var saved_dateNaiss = "${formattedDate}";
	var saved_phone = "${userConnected.get('phone')}" != 'null' ? "${userConnected.get('phone')}" : "";
	var saved_mobile = "${userConnected.get('mobile')}" != 'null' ? "${userConnected.get('mobile')}" : "";
	
    $(document).ready(function(){
        $('#modalConfirmerSaisineObservatoire').modal('hide');
        $('#modalErrorSaisineObservatoire').modal('hide');
        $('#checkboxSaveInfo').hide();
		
        $('#buttonDeposer').click(function(event){
            resetValuesSubmitSaisineObservatoire();
        });
    });

    $("#sendSaisineObservatoire").click(function(event){
        event.preventDefault();

        var response = validateFormSubmitSaisineObservatoire();
        if (response){

                        
            var request = new XMLHttpRequest();
            var formElement = $("#form-submit-saisine-observatoire");
            request.open('POST', '${submitSaisineObservatoireURL}', true);
            //request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');

            request.onload = function() {
                if (this.status >= 200 && this.status < 400) {
                    // Success!
                    var data = JSON.parse(this.response);
                    // var data = this.get('responseData');
                    //var data = JSON.parse(e.details[1].responseText);
                    if(data.result){
                        $('#modalSaisineObservatoire').modal('hide');
                        if(data.savedInfo){
                            saved_dateNaiss = $("#<portlet:namespace />birthday").val();
                            saved_city = $("#<portlet:namespace />city").val();
                            saved_address = $("#<portlet:namespace />address").val();
                            saved_zipCode = $("#<portlet:namespace />postalcode").val();
                            if($("#<portlet:namespace />phone").val() != "")
                                saved_phone = $("#<portlet:namespace />phone").val();
                            if($("#"+namespaceSubmitSaisineObservatoire+"mobile").val() != "")
                                saved_mobile = $("#<portlet:namespace />mobile").val();
                        }
                        $('#modalConfirmerSaisineObservatoire').modal('show');
                        resetValuesSubmitSaisineObservatoire();
                    }else{
                        $("#modalErrorSaisineObservatoire h4").text(data.message);
                        $('#modalErrorSaisineObservatoire').modal('show');
                    }
                } else {
                    console.log("petite erreur sans importance");
                    // We reached our target server, but it returned an error
                }
            };
            
            var formData = new FormData(formElement[0]);
            var emailValue = $("#"+namespaceSubmitSaisineObservatoire+"mail").val();
            var lastNameValue = $("#"+namespaceSubmitSaisineObservatoire+"username").val();
            var firstNameValue = $("#"+namespaceSubmitSaisineObservatoire+"firstname").val();
            formData.append("<portlet:namespace/>email", emailValue);
            formData.append("<portlet:namespace/>lastname", lastNameValue); 
            formData.append("<portlet:namespace/>firstname", firstNameValue);  
            request.send(formData);
        }
    });

    $('#modalConfirmerSaisineObservatoire #buttonConfirm').click(function(event){
        $('#modalConfirmerSaisineObservatoire').modal('hide');
    });

    $('#modalErrorSaisineObservatoire #buttonConfirm').click(function(event){
        $('#modalErrorSaisineObservatoire').modal('hide');
    });

    function resetValuesSubmitSaisineObservatoire()
    {
        $("#"+namespaceSubmitSaisineObservatoire+"saisinetitle").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"saisinedescription").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"photo").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"saisineProjectTarget").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"saisineOtherMechanism").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"saisineCollectiveName").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"saisinelieux").val("");
        $("#"+namespaceSubmitSaisineObservatoire+"project option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitSaisineObservatoire+"project").selectric();
        $("#"+namespaceSubmitSaisineObservatoire+"dispositif option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitSaisineObservatoire+"dispositif").selectric();
        $("#"+namespaceSubmitSaisineObservatoire+"aka option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitSaisineObservatoire+"aka").selectric();
        $("#"+namespaceSubmitSaisineObservatoire+"quartier option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitSaisineObservatoire+"quartier").selectric();
        $("#"+namespaceSubmitSaisineObservatoire+"theme option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitSaisineObservatoire+"theme").selectric();
        $('#checkboxSaveInfo #save-info').prop('checked', false);
        $('#checkboxSaveInfo').hide();
        $("#submit-saisine-observatoire-legalage").prop("checked", false);
        $("#submit-saisine-observatoire-cnil").prop("checked", false);
        $("#submit-saisine-observatoire-understanding").prop("checked", false);
        $("#"+namespaceSubmitSaisineObservatoire+"birthday").val(saved_dateNaiss);
        $("#"+namespaceSubmitSaisineObservatoire+"city").val(saved_city);
        $("#"+namespaceSubmitSaisineObservatoire+"address").val(saved_address);
        $("#"+namespaceSubmitSaisineObservatoire+"postalcode").val(saved_zipCode);
        $("#"+namespaceSubmitSaisineObservatoire+"phone").val(saved_phone);
        $("#"+namespaceSubmitSaisineObservatoire+"mobile").val(saved_mobile);
    }

    function getAge(dateString) {
        var from = dateString.split("/");
        var today = new Date();
        var birthDate = new Date(from[2],from[1]-1,from[0]);
        var age = today.getFullYear() - birthDate.getFullYear();
        var m = today.getMonth() - birthDate.getMonth();
        if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
          age--;
        }
        return age;
    }

    function checkValuesSubmitSaisineObservatoire(){
        if($("#"+namespaceSubmitSaisineObservatoire+"birthday").val() != saved_dateNaiss || $("#"+namespaceSubmitSaisineObservatoire+"address").val() != saved_address ||
        $("#"+namespaceSubmitSaisineObservatoire+"city").val() != saved_city || $("#"+namespaceSubmitSaisineObservatoire+"postalcode").val() != saved_zipCode ||
        $("#"+namespaceSubmitSaisineObservatoire+"phone").val() != saved_phone || $("#"+namespaceSubmitSaisineObservatoire+"mobile").val() != saved_mobile){
            $('#checkboxSaveInfo #save-info').prop('checked', true);
            $('#checkboxSaveInfo').show();
        }else{
            $('#checkboxSaveInfo #save-info').prop('checked', false);
            $('#checkboxSaveInfo').hide();
        }
    }

    function validateFormSubmitSaisineObservatoire(){
        var result = true;
        var saisinetitle = $("#"+namespaceSubmitSaisineObservatoire+"saisinetitle").val();
        var saisinedescription = $("#"+namespaceSubmitSaisineObservatoire+"saisinedescription").val();
        var saisineProjectTarget = $("#"+namespaceSubmitSaisineObservatoire+"saisineProjectTarget").val();
        var birthday = $("#"+namespaceSubmitSaisineObservatoire+"birthday").val();
        var city = $("#"+namespaceSubmitSaisineObservatoire+"city").val();
        var address = $("#"+namespaceSubmitSaisineObservatoire+"address").val();
        var postalcode = $("#"+namespaceSubmitSaisineObservatoire+"postalcode").val();
        var legalage = $("#submit-saisine-observatoire-legalage").is(":checked");
        var cnil = $("#submit-saisine-observatoire-cnil").is(":checked");
        var understanding = $("#submit-saisine-observatoire-understanding").is(":checked");
        var regex = new RegExp("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");
        var photo = $("#"+namespaceSubmitSaisineObservatoire+"photo").val();

        if (saisinetitle==null || saisinetitle==""){
            $("#"+namespaceSubmitSaisineObservatoire+"saisinetitle").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"saisinetitle").css({ "box-shadow" : "" });

        if (photo!=null && photo!==""){
            var ext = photo.split(".").pop().toLowerCase();
            if($.inArray(ext, ['png','jpg','jpeg']) == -1) {
            $("#"+namespaceSubmitSaisineObservatoire+"photo").css({ "box-shadow" : "0 0 10px #CC0000" });
                result = false;
            }else $("#"+namespaceSubmitSaisineObservatoire+"photo").css({ "box-shadow" : "" });
        }

        if (saisinedescription==null || saisinedescription==""){
            $("#"+namespaceSubmitSaisineObservatoire+"saisinedescription").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"saisinedescription").css({ "box-shadow" : "" });

        if (saisineProjectTarget==null || saisineProjectTarget==""){
            $("#"+namespaceSubmitSaisineObservatoire+"saisineProjectTarget").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"saisineProjectTarget").css({ "box-shadow" : "" });

        if (birthday==null || birthday==""){
            $("#"+namespaceSubmitSaisineObservatoire+"birthday").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"birthday").css({ "box-shadow" : "" });

        if (city==null || city==""){
            $("#"+namespaceSubmitSaisineObservatoire+"city").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"city").css({ "box-shadow" : "" });

        if (address==null || address==""){
            $("#"+namespaceSubmitSaisineObservatoire+"address").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitSaisineObservatoire+"address").css({ "box-shadow" : "" });

        if (postalcode==null || postalcode==""){
            $("#"+namespaceSubmitSaisineObservatoire+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else if(!regex.test(postalcode)){
            $("#"+namespaceSubmitSaisineObservatoire+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            alert("Merci de respecter la syntaxe d'un code postal");
            result = false;
        }
        else $("#"+namespaceSubmitSaisineObservatoire+"postalcode").css({ "box-shadow" : "" });

        if (!legalage)
            result = false;

        if (!cnil)
            result = false;

        if (!understanding)
            result = false;

        if (!result)
            $("#sendalert").removeClass("hidden");
        else $("#sendalert").addClass("hidden");
        
        return result;
    }
</script>