<%@ include file="/project-popup-init.jsp" %>

<portlet:resourceURL id="submitPetition" var="submitPetitionURL">
</portlet:resourceURL>

<!-- DEPOSER UNE NOUVELLE PETITION -->
<!-- HTML pour la modal de petition -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalPetition" tabindex="-1" role="dialog" aria-labelledby="modalPetition"
	data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.submitpetition.title"/></h3>
                <button type="button" class="close closefirstmodal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <form id="form-submit-petition">
                <div class="pro-wrapper">
                    <h4><liferay-ui:message key="modal.submitpetition.information"/></h4>
                    <div class="form-group">
                        <aui:input id="petitiontitle" name="title" label="modal.submitpetition.information.title" required="true" maxlength="256" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="petitiondescription" type="textarea" name="description" label="modal.submitpetition.information.description" required="true" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="petitionInTheNameOf" name="inTheNameOf" label="modal.submitpetition.information.inTheNameOf" required="false" maxlength="400" value=""/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-triple">
                            <label for="petition"><liferay-ui:message key="modal.submitpetition.information.projet"/></label>
                            <select id="<portlet:namespace />project" name="<portlet:namespace />project">
                                <option value="0" selected ></option>
                                <c:forEach var="project" items="${projects}">
                                    <option value="${project.categoryId}">${project.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-triple">
                            <label for="territoire"><liferay-ui:message key="modal.submitpetition.information.territoire"/></label>
                            <select id="<portlet:namespace />quartier" name="<portlet:namespace />quartier">
                                <option value="0" selected ><liferay-ui:message key="modal.submitpetition.information.territoire.town"/></option>
                                <c:forEach var="quartier" items="${quartiers}">
                                    <option value="${quartier.categoryId}">${quartier.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-triple">
                            <label for="thematique"><liferay-ui:message key="modal.submitpetition.information.thematique"/></label>
                            <select id="<portlet:namespace />theme" name="<portlet:namespace />theme">
                                <option value="0" selected ></option>
                                <c:forEach var="theme" items="${thematics}">
                                    <option value="${theme.categoryId}">${theme.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input id="petitionlieux" name="consultationPlacesText" label="modal.submitpetition.information.lieu" maxlength="256" value=""/>
                    </div>
                    <div class="pro-txt-form">
                        <p><liferay-ui:message key="modal.submitpetition.information.mayor"/></p>
                    </div>
                </div>
                <div class="pro-wrapper">
                    <h4><liferay-ui:message key="modal.submitpetition.user"/></h4>
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
                            <aui:input id="birthday" name="birthday" cssClass="frm_date" label="modal.user.birthday" required="true" placeholder="jj/mm/aaaa" maxlength="10" onInput="checkValuesSubmitPetition();" onChange="checkValuesSubmitPetition();"/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input id="address" name="address" label="modal.user.address" required="true" maxlength="256" onInput="checkValuesSubmitPetition();"/>
                        </div>
                        <div class="form-group form-half">
                            <div class="form-city">
                                <aui:input id="city" name="city" label="modal.user.city" required="true" placeholder="Strasbourg" maxlength="256" onInput="checkValuesSubmitPetition();"/>
                            </div>
                            <div class="form-code">
                                <aui:input id="postalcode" name="postalcode" label="modal.user.postalcode" required="true" type="number" maxlength="5" pattern="[0-9]{5}" placeholder="67XXX" onInput="checkValuesSubmitPetition();"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input type="email" name="mail" disabled="true" label="modal.user.mail" required="true" value="${userConnected.get('email')}"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input id="phone" name="phone" label="modal.user.phone" placeholder="0311111111" maxlength="20" onInput="checkValuesSubmitPetition();"/>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="mobile" name="mobile" label="modal.user.mobile" placeholder="0611111111" maxlength="20" onInput="checkValuesSubmitPetition();"/>
                        </div>
                    </div>
                    <div class="form-group form-checkbox" id="checkboxSaveInfo">
                        <div>
                            <input type="checkbox" id="save-info" value="save-info">
                            <label for="save-info"><liferay-ui:message key="modal.save.info"/></label>
                        </div>
                    </div>
                </div>
                <div class="pro-optin form-checkbox">
                    <div>
                        <input type="checkbox" id="submit-petition-legalage" value="legalage">
                        <label for="submit-petition-legalage" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_legalageSubmitPetition"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="submit-petition-cnil" value="cnil">
                        <label for="submit-petition-cnil" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cnilSubmitPetition"/>
                        </label>
                    </div>
                </div>
                <div class="pro-info-supp">
                    <p><i><liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_conditionsSubmitPetition"/></i></p>
                    <p><liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_contactSubmitPetition"/></p>
                </div>
                <div id="sendalert" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert"/></div>
                <div id="submitalertLegalage" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.legalage"/></div>
                <div id="submitalertcity" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.city"/></div>
                <div id="submitalertPostalCode" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert.postalcode"/></div>
                <div class="pro-form-submit">
                    <button id="sendPetition" type="submit" class="btn btn-default"><liferay-ui:message key="modal.submitpetition.submit"/></button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- CONFIRMATION NOUVELLE PETITION -->
<!-- HTML pour la modal de confirmation de nouvelle petition -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalConfirmerPetition" tabindex="-1" role="dialog" aria-labelledby="modalConfirmerPetition">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='confirm-petition'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='submit-petition-ok'/></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn-yellow" value=<liferay-ui:message key="button-petition-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>


<!-- ERREUR NOUVELLE PETITION -->
<!-- HTML pour la modal d'erreur de nouvelle petition -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalErrorPetition" tabindex="-1" role="dialog" aria-labelledby="modalErrorPetition">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='error-petition'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn-yellow" value=<liferay-ui:message key="button-petition-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

	var namespaceSubmitPetition = "<portlet:namespace />";
	var saved_address = "${userConnected.get('address')}";
	var saved_zipCode = "${userConnected.get('zipcode')}";
	var saved_city = "${userConnected.get('city')}";
	var saved_dateNaiss = "${formattedDate}";
	var saved_phone = "${userConnected.get('phone')}" != 'null' ? "${userConnected.get('phone')}" : "";
	var saved_mobile = "${userConnected.get('mobile')}" != 'null' ? "${userConnected.get('mobile')}" : "";
	
    $(document).ready(function(){
        $('#modalConfirmerPetition').modal('hide');
        $('#modalErrorPetition').modal('hide');
        $('#checkboxSaveInfo').hide();
		
        $('#buttonDeposer').click(function(event){
            resetValuesSubmitPetition();
        });
    });

    $("#sendPetition").click(function(event){
        event.preventDefault();

        var response = validateFormSubmitPetition();
        if (response){
            var petitionTitleValue = $("#"+namespaceSubmitPetition+"petitiontitle").val();
            var petitionDescriptionValue = $("#"+namespaceSubmitPetition+"petitiondescription").val();
            var birthdayValue = $("#"+namespaceSubmitPetition+"birthday").val();
            var addressValue = $("#"+namespaceSubmitPetition+"address").val();
            var cityValue = $("#"+namespaceSubmitPetition+"city").val();
            var postalcodeValue = $("#"+namespaceSubmitPetition+"postalcode").val();
            var phoneValue = $("#"+namespaceSubmitPetition+"phone").val();
            var mobileValue = $("#"+namespaceSubmitPetition+"mobile").val();
            var projectValue = $("#"+namespaceSubmitPetition+"project").val();
            var quartierValue = $("#"+namespaceSubmitPetition+"quartier").val();
            var themeValue = $("#"+namespaceSubmitPetition+"theme").val();
            var consultationPlacesTextValue = $("#"+namespaceSubmitPetition+"petitionlieux").val();
            var saveInfoValue = $("#save-info").is(":checked");
            var lastNameValue = $("#"+namespaceSubmitPetition+"username").val();
            var firstNameValue = $("#"+namespaceSubmitPetition+"firstname").val();
            var inTheNameOf = $("#"+namespaceSubmitPetition+"petitionInTheNameOf").val();
            var emailValue = $("#"+namespaceSubmitPetition+"mail").val();
            AUI().use('aui-io-request', function(A) {
                A.io.request('${submitPetitionURL}', {
                    method : 'POST',
                    dataType: 'json',
                    data:{
                        <portlet:namespace/>petitiontitle: petitionTitleValue,
                        <portlet:namespace/>petitiondescription: petitionDescriptionValue,
                        <portlet:namespace/>birthday: birthdayValue,
                        <portlet:namespace/>address: addressValue,
                        <portlet:namespace/>city: cityValue,
                        <portlet:namespace/>postalcode: postalcodeValue,
                        <portlet:namespace/>phone: phoneValue,
                        <portlet:namespace/>mobile: mobileValue,
                        <portlet:namespace />project: projectValue,
                        <portlet:namespace />quartier: quartierValue,
                        <portlet:namespace />theme: themeValue,
                        <portlet:namespace />consultationPlacesText: consultationPlacesTextValue,
                        <portlet:namespace />saveinfo: saveInfoValue,
                        <portlet:namespace />lastname: lastNameValue,
                        <portlet:namespace />firstname: firstNameValue,
                        <portlet:namespace />inTheNameOf: inTheNameOf,
                        <portlet:namespace />email: emailValue
                    },
                    on: {
                        success: function(e) {
                            var data = this.get('responseData');
                            if(data.result){
                                $('#modalPetition').modal('hide');
                                if(data.savedInfo){
                                    saved_dateNaiss = $("#"+namespaceSubmitPetition+"birthday").val();
                                    saved_city = $("#"+namespaceSubmitPetition+"city").val();
                                    saved_address = $("#"+namespaceSubmitPetition+"address").val();
                                    saved_zipCode = $("#"+namespaceSubmitPetition+"postalcode").val();
                                    if($("#"+namespaceSubmitPetition+"phone").val() != "")
                                        saved_phone = $("#"+namespaceSubmitPetition+"phone").val();
                                    if($("#"+namespaceSubmitPetition+"mobile").val() != "")
                                        saved_mobile = $("#"+namespaceSubmitPetition+"mobile").val();
                                }
                                $('#modalConfirmerPetition').modal('show');
                            }else{
                                $("#modalErrorPetition h4").text(data.message);
                                $('#modalErrorPetition').modal('show');
                            }
                            resetValuesSubmitPetition();
                        }
                    }
                });
             });
        }
    });

    $('#modalConfirmerPetition #buttonConfirm').click(function(event){
        $('#modalConfirmerPetition').modal('hide');
    });

    $('#modalErrorPetition #buttonConfirm').click(function(event){
        $('#modalErrorPetition').modal('hide');
    });

    function resetValuesSubmitPetition()
    {
        $("#"+namespaceSubmitPetition+"petitiontitle").val("");
        $("#"+namespaceSubmitPetition+"petitiondescription").val("");
        $("#"+namespaceSubmitPetition+"petitionInTheNameOf").val("");
        $("#"+namespaceSubmitPetition+"petitionlieux").val("");
        $("#"+namespaceSubmitPetition+"project option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitPetition+"project").selectric();
        $("#"+namespaceSubmitPetition+"quartier option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitPetition+"quartier").selectric();
        $("#"+namespaceSubmitPetition+"theme option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitPetition+"theme").selectric();
        $('#checkboxSaveInfo #save-info').prop('checked', false);
        $('#checkboxSaveInfo').hide();
        $("#submit-petition-legalage").prop("checked", false);
        $("#submit-petition-cnil").prop("checked", false);
        $("#"+namespaceSubmitPetition+"birthday").val(saved_dateNaiss);
        $("#"+namespaceSubmitPetition+"city").val(saved_city);
        $("#"+namespaceSubmitPetition+"address").val(saved_address);
        $("#"+namespaceSubmitPetition+"postalcode").val(saved_zipCode);
        $("#"+namespaceSubmitPetition+"phone").val(saved_phone);
        $("#"+namespaceSubmitPetition+"mobile").val(saved_mobile);
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

    function checkValuesSubmitPetition(){
        if($("#"+namespaceSubmitPetition+"birthday").val() != saved_dateNaiss || $("#"+namespaceSubmitPetition+"address").val() != saved_address ||
        $("#"+namespaceSubmitPetition+"city").val() != saved_city || $("#"+namespaceSubmitPetition+"postalcode").val() != saved_zipCode ||
        $("#"+namespaceSubmitPetition+"phone").val() != saved_phone || $("#"+namespaceSubmitPetition+"mobile").val() != saved_mobile){
            $('#checkboxSaveInfo #save-info').prop('checked', true);
            $('#checkboxSaveInfo').show();
        }else{
            $('#checkboxSaveInfo #save-info').prop('checked', false);
            $('#checkboxSaveInfo').hide();
        }
    }

    function validateFormSubmitPetition(){
        var result = true;
        var petitiontitle = $("#"+namespaceSubmitPetition+"petitiontitle").val();
        var petitiondescription = $("#"+namespaceSubmitPetition+"petitiondescription").val();
        var birthday = $("#"+namespaceSubmitPetition+"birthday").val();
        var city = $("#"+namespaceSubmitPetition+"city").val();
        var address = $("#"+namespaceSubmitPetition+"address").val();
        var postalcode = $("#"+namespaceSubmitPetition+"postalcode").val();
        var legalage = $("#submit-petition-legalage").is(":checked");
        var cnil = $("#submit-petition-cnil").is(":checked");
        var regex = new RegExp("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");

        if (petitiontitle==null || petitiontitle==""){
            $("#"+namespaceSubmitPetition+"petitiontitle").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitPetition+"petitiontitle").css({ "box-shadow" : "" });

        if (petitiondescription==null || petitiondescription==""){
            $("#"+namespaceSubmitPetition+"petitiondescription").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitPetition+"petitiondescription").css({ "box-shadow" : "" });

        if (birthday==null || birthday==""){
            $("#"+namespaceSubmitPetition+"birthday").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitPetition+"birthday").css({ "box-shadow" : "" });

        if (city==null || city==""){
            $("#"+namespaceSubmitPetition+"city").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitPetition+"city").css({ "box-shadow" : "" });

        /* if (city.toLowerCase()!=="strasbourg"){
            $("#submitalertcity").removeClass("hidden");
            $("#"+namespaceSubmitPetition+"city").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        } else $("#submitalertcity").addClass("hidden"); */

        if (address==null || address==""){
            $("#"+namespaceSubmitPetition+"address").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitPetition+"address").css({ "box-shadow" : "" });

        if (postalcode==null || postalcode==""){
            $("#"+namespaceSubmitPetition+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else if(!regex.test(postalcode)){
            $("#"+namespaceSubmitPetition+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            alert("Merci de respecter la syntaxe d'un code postal");
            result = false;
        }
        else $("#"+namespaceSubmitPetition+"postalcode").css({ "box-shadow" : "" });

        if (!legalage)
            result = false;

        if (!cnil)
            result = false;

        if (!result)
            $("#sendalert").removeClass("hidden");
        else $("#sendalert").addClass("hidden");
        
        return result;
    }
</script>