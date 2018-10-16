<%@ include file="/project-popup-init.jsp" %>
<portlet:resourceURL id="fileBudget" var="fileBudgetURL">
</portlet:resourceURL>
<!-- DEPOSER UN NOUVEAU BUDGET -->
<!-- HTML pour la modal de budget -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalBudget" tabindex="-1" role="dialog" aria-labelledby="modalProjet">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.filebudget.title"/></h3>
                <button id="closingButton" type="button" class="close" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>

            <form>
                <div class="pro-wrapper">
                    <h4><liferay-ui:message key="modal.filepetition.information"/></h4>
                    <div class="form-group">
                        <aui:input id="budgettitle" name="title" label="modal.filebudget.information.title" required="true" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="budgetdescription" type="textarea" name="description" label="modal.filebudget.information.description" value=""/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="quartiers"><liferay-ui:message key="modal.filebudget.information.territoire"/></label>
                            <select id="<portlet:namespace />quartier" name="<portlet:namespace />project">
                                <option value="0" selected></option>
                                <c:forEach var="quartier" items="${quartiers}">
                                    <option value="${quartier.categoryId}">${quartier.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="budgetlieux" name="budgetlieux" label="modal.filebudget.information.lieu" required="true" value=""/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="thematiques"><liferay-ui:message key="modal.filepetition.information.thematique"/></label>
                            <select id="<portlet:namespace />theme" name="<portlet:namespace />theme">
                                <option value="0" selected></option>
                                <c:forEach var="theme" items="${thematics}">
                                    <option value="${theme.categoryId}">${theme.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <label for="projets"><liferay-ui:message key="modal.filepetition.information.projet"/></label>
                            <select id="<portlet:namespace />project" name="<portlet:namespace />project">
                                <option value="0" selected ></option>
                                <c:forEach var="project" items="${projects}">
                                    <option value="${project.categoryId}">${project.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input id="copyright" name="copyright" label="modal.filebudget.copyright" value=""/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <div class="input-group input-file" name="Fichier1">
                                <aui:input id="budgetPhoto" name="budgetPhoto" cssClass="form-control" label="modal.filebudget.information.picture" value=""/>
                                <span class="browsePicture input-group-btn"><button class="btn btn-default btn-choose" type="button">Parcourir</button></span>
                            </div>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <aui:input id="budgetVideo" name="budgetVideo" label="modal.filebudget.information.video" value=""/>
                        </div>
                    </div>
                </div>
                <div class="pro-wrapper">
                    <h4><liferay-ui:message key="modal.filebudget.user"/></h4>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input name="username" label="modal.user.username" required="true" disabled="true"  value="${userConnected.get('last_name')}"/>
                        </div>
                        <div class="form-group form-half">
                            <aui:input name="firstname" label="modal.user.firstname" required="true" disabled="true"  value="${userConnected.get('first_name')}"/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input name="address" label="modal.user.address" required="true" />
                        </div>
                        <div class="form-group form-half">
                            <div class="form-city">
                                <aui:input name="city" label="modal.user.city" required="true" />
                            </div>
                            <div class="form-code">
                                <aui:input name="postalcode" label="modal.user.postalcode" required="true"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input name="mail" label="modal.user.mail" required="true" disabled="true" value="${userConnected.get('email')}"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input name="phone" label="modal.user.phone" value=""/>
                        </div>
                        <div class="form-group form-half">
                            <aui:input name="mobile" label="modal.user.mobile" value=""/>
                        </div>
                    </div>
                </div>
                <div class="pro-optin form-checkbox">
                    <div>
                        <input type="checkbox" id="file-budget-legalage" value="legalage">
                        <label for="file-budget-legalage" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_legalage"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="file-budget-cnil" value="cnil">
                        <label for="file-budget-cnil" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cnil2"/>
                        </label>
                    </div>
                </div>
                <div id="sendalert" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert"/></div>
                <div class="pro-form-submit">
                    <button id="sendBudget" type="submit" class="btn btn-default"><liferay-ui:message key="modal.filebudget.submit"/></button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- CONFIRMATION NOUVEAU BUDGET -->
<!-- HTML pour la modal de confirmation de nouvelle pétition -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalConfirmerBudget" tabindex="-1" role="dialog" aria-labelledby="modalConfirmerBudget">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='confirm-budget'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='file-budget-ok'/></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn" value=<liferay-ui:message key="button-petition-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>


<!-- ERREUR NOUVELLE BUDGET -->
<!-- HTML pour la modal d'erreur de nouvelle budget -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalErrorBudget" tabindex="-1" role="dialog" aria-labelledby="modalErrorBudget">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='error-budget'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn" value=<liferay-ui:message key="button-budget-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<!-- CONFIRMATION QUITTER BUDGET -->
<!-- HTML pour la modal de quitter le formulaire de budget -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalQuitBudget" tabindex="-1" role="dialog" aria-labelledby="modalQuitBudget">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='quit-budget'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='file-budget-quit'/></h4>
                <div class="centerButtonValidation">
                    <input id="buttonConfirm" type="submit" class="pro-btn" value=<liferay-ui:message key="button-budget-quit"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

	var namespace = "<portlet:namespace />";
	var saved_address = "${userConnected.get('address')}";
	var saved_zipCode = "${userConnected.get('zipcode')}";
	var saved_city = "${userConnected.get('city')}";
	var saved_dateNaiss = "${formattedDate}";
	var saved_phone = "${userConnected.get('phone')}";
	var saved_mobile = "${userConnected.get('mobile')}";

    $(document).ready(function(){
        $('#modalConfirmerBudget').modal('hide');
        $('#modalErrorBudget').modal('hide');
        $('#checkboxSaveInfo').hide();

        $('#buttonDeposer').click(function(event){
            resetValues();
        });
    });

    $("#sendBudget").click(function(event){
        event.preventDefault();

        var response = validateForm();
        if (response){
            var budgetTitleValue = $("#"+namespace+"budgettitle").val();
            var budgetDescriptionValue = $("#"+namespace+"budgetdescription").val();
            var addressValue = $("#"+namespace+"address").val();
            var cityValue = $("#"+namespace+"city").val();
            var postalcodeValue = $("#"+namespace+"postalcode").val();
            var phoneValue = $("#"+namespace+"phone").val();
            var mobileValue = $("#"+namespace+"mobile").val();
            var copyrightValue = $("#"+namespace+"copyright").val();
            var projectValue = $("#"+namespace+"project").val();
            var quartierValue = $("#"+namespace+"quartier").val();
            var themeValue = $("#"+namespace+"theme").val();
            var consultationPlacesTextValue = $("#"+namespace+"budgetlieux").val();
            var saveInfoValue = $("#save-info").is(":checked");
            var lastNameValue = $("#"+namespace+"username").val();
            var firstNameValue = $("#"+namespace+"firstname").val();
            var emailValue = $("#"+namespace+"mail").val();
            AUI().use('aui-io-request', function(A) {
                A.io.request('${fileBudgetURL}', {
                    method : 'POST',
                    dataType: 'json',
                    data:{
                        <portlet:namespace/>budgettitle:budgetTitleValue,
                        <portlet:namespace/>budgetdescription:budgetDescriptionValue,
                        <portlet:namespace/>address:addressValue,
                        <portlet:namespace/>city:cityValue,
                        <portlet:namespace/>postalcode:postalcodeValue,
                        <portlet:namespace/>phone:phoneValue,
                        <portlet:namespace/>mobile:mobileValue,
                        <portlet:namespace/>copyright:copyrightValue,
                        <portlet:namespace />project:projectValue,
                        <portlet:namespace />quartier:quartierValue,
                        <portlet:namespace />theme:themeValue,
                        <portlet:namespace />consultationPlacesText:consultationPlacesTextValue,
                        <portlet:namespace />saveinfo:saveInfoValue,
                        <portlet:namespace />lastname:lastNameValue,
                        <portlet:namespace />firstname:firstNameValue,
                        <portlet:namespace />email:emailValue
                    },
                    on: {
                        success: function(e) {
                            var data = this.get('responseData');
                            if(data.result){
                                $('#modalBudget').modal('hide');
                                if(data.savedInfo){
                                    saved_city = $("#"+namespace+"city").val();
                                    saved_address = $("#"+namespace+"address").val();
                                    saved_zipCode = $("#"+namespace+"postalcode").val();
                                    if($("#"+namespace+"phone").val() != "")
                                        saved_phone = $("#"+namespace+"phone").val();
                                    if($("#"+namespace+"mobile").val() != "")
                                        saved_mobile = $("#"+namespace+"mobile").val();
                                }
                                $('#modalConfirmerBudget').modal('show');
                            }else{
                                $("#modalErrorBudget h4").text(data.message);
                                $('#modalErrorBudget').modal('show');
                            }
                        }
                    }
                });
             });
        }
    });

    $('#modalConfirmerBudget #buttonConfirm').click(function(event){
        $('#modalConfirmerBudget').modal('hide');
    });

    $('#modalErrorBudget #buttonConfirm').click(function(event){
        $('#modalErrorBudget').modal('hide');
    });

    function resetValues()
    {
        $("#"+namespace+"budgettitle").val("");
        $("#"+namespace+"budgetdescription").val("");
        $("#"+namespace+"budgetlieux").val("");
        $("#"+namespace+"copyright").val("");
        $("#"+namespace+"project option[value='0']").prop('selected', true);
        $("#"+namespace+"project").selectric();
        $("#"+namespace+"quartier option[value='0']").prop('selected', true);
        $("#"+namespace+"quartier").selectric();
        $("#"+namespace+"theme option[value='0']").prop('selected', true);
        $("#"+namespace+"theme").selectric();
        $('#checkboxSaveInfo #save-info').prop('checked', false);
        $('#checkboxSaveInfo').hide();
        $("#file-budget-legalage").prop("checked", false);
        $("#file-budget-cnil").prop("checked", false);
        $("#"+namespace+"city").val(saved_city);
        $("#"+namespace+"address").val(saved_address);
        $("#"+namespace+"postalcode").val(saved_zipCode);
        $("#"+namespace+"phone").val(saved_phone);
        $("#"+namespace+"mobile").val(saved_mobile);
    }

    function checkValues(){
        if($("#"+namespace+"address").val() != saved_address ||
        $("#"+namespace+"city").val() != saved_city || $("#"+namespace+"postalcode").val() != saved_zipCode ||
        $("#"+namespace+"phone").val() != saved_phone || $("#"+namespace+"mobile").val() != saved_mobile){
            $('#checkboxSaveInfo #save-info').prop('checked', true);
            $('#checkboxSaveInfo').show();
        }else{
            $('#checkboxSaveInfo #save-info').prop('checked', false);
            $('#checkboxSaveInfo').hide();
        }
    }

    function validateForm()
    {
        var result = true;
        var budgettitle = $("#"+namespace+"budgettitle").val();
        var budgetdescription = $("#"+namespace+"budgetdescription").val();
        var city = $("#"+namespace+"city").val();
        var address = $("#"+namespace+"address").val();
        var postalcode = $("#"+namespace+"postalcode").val();
        var legalage = $("#file-budget-legalage").is(":checked");
        var cnil = $("#file-budget-cnil").is(":checked");
        var regex = new RegExp("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");

        if (budgettitle==null || budgettitle==""){
            $("#"+namespace+"budgettitle").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespace+"budgettitle").css({ "box-shadow" : "" });

        if (budgetdescription==null || budgetdescription==""){
            $("#"+namespace+"budgetdescription").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespace+"budgetdescription").css({ "box-shadow" : "" });

        if (city==null || city==""){
            $("#"+namespace+"city").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespace+"city").css({ "box-shadow" : "" });

        if (address==null || address==""){
            $("#"+namespace+"address").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespace+"address").css({ "box-shadow" : "" });

        if (postalcode==null || postalcode==""){
            $("#"+namespace+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else if(!regex.test(postalcode)){
            $("#"+namespace+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            alert("Merci de respecter la syntaxe d'un code postal");
            result = false;
        }
        else $("#"+namespace+"postalcode").css({ "box-shadow" : "" });

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