<%@ include file="/project-popup-init.jsp" %>

<portlet:resourceURL id="submitBudget" var="submitBudgetURL">
</portlet:resourceURL>

<!-- DEPOSER UN NOUVEAU BUDGET -->
<!-- HTML pour la modal de budget -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalBudget" tabindex="-1" role="dialog" aria-labelledby="modalProjet"
	data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.submitbudget.title"/></h3>
                <button type="button" class="close closefirstmodal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>

            <aui:form name="uploadForm" enctype="multipart/form-data">
                <div id="uploadDiv" class="pro-wrapper">
                    <liferay-ui:message key="modal.submitbudget.text-preheader"/>

                    <h4><liferay-ui:message key="modal.submitbudget.information"/></h4>
                    <div class="form-group">
                        <aui:input helpMessage="modal.submitbudget.information.title.help" id="budgettitle" name="title" label="modal.submitbudget.information.title" maxlength="75" required="true" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="budgetsummary" helpMessage="modal.submitbudget.information.summary.help" cssClass="form-control pro-textarea-small" name="summary" type="textarea" label="modal.submitbudget.information.summary" maxlength="600" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="budgetdescription" name="description" type="hidden"/>
                        <aui:input name="squiredescription" type="textarea" cssClass="form-control form-squire-target" required="true"  helpMessage="modal.submitbudget.information.description.help" label="modal.submitbudget.information.description"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:select name="quartier" id="quartier" label="modal.submitbudget.information.territoire" helpMessage="modal.submitbudget.information.territoire.help" required="true">
                                <aui:option value="0" selected="true"><liferay-ui:message key="modal.submitbudget.information.territoire.not-specified"/> </aui:option>
                                <c:forEach var="quartier" items="${quartiers}">
                                    <aui:option value="${quartier.categoryId}">${quartier.name}</aui:option>
                                </c:forEach>
                            </aui:select>
                            <a class="link-location" target="_blank" href="https://data.opendatasoft.com/explore/dataset/quartiers_elus_2020%40eurometrostrasbourg/map/?location=11,48.55252,7.79995&basemap=jawg.streets"><liferay-ui:message key="modal.submitbudget.information.territoire.link-map"/></a>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="budgetlieux" name="budgetlieux" helpMessage="modal.submitbudget.information.lieu.help" label="modal.submitbudget.information.lieu" maxlength="256" value=""/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="thematiques"><liferay-ui:message key="modal.submitbudget.information.thematique"/></label>
                            <select id="<portlet:namespace />theme" name="<portlet:namespace />theme">
                                <option value="0" selected></option>
                                <c:forEach var="theme" items="${thematics}">
                                    <option value="${theme.categoryId}">${theme.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <label for="projets"><liferay-ui:message key="modal.submitbudget.information.projet"/></label>
                            <select id="<portlet:namespace />project" name="<portlet:namespace />project">
                                <option value="0" selected ></option>
                                <c:forEach var="project" items="${projects}">
                                    <option value="${project.categoryId}">${project.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <span class="browsePicture input-group-btn">
                                <aui:input name="budgetPhoto" type="file" helpMessage="modal.submitbudget.information.picture.help" label="modal.submitbudget.information.picture"
                                    cssClass="btn btn-default btn-choose upload-image">
							        <aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
                                </aui:input>
                            </span>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <aui:input id="budgetVideo" name="budgetVideo" label="modal.submitbudget.information.video" maxlength="256" value=""/>
                        </div>
                    </div>
                    <c:if test="${nbFiles gt 0}">
                        <label for="projets"><liferay-ui:message key="modal.submitbudget.information.sizeFile-x" arguments="${sizeFile}"/></label>
                        <div class="pro-row">
                            <div class="form-group form-two-tiers">
                                <span class="browsePicture input-group-btn">
                                    <aui:input name="budgetFile" type="file" label="modal.submitbudget.information.file"
                                        cssClass="btn btn-default btn-choose upload-file">
                                        <aui:validator name="acceptFiles">'${typesFiles}'</aui:validator>
                                    </aui:input>
                                </span>
                            </div>
                        </div>
                    </c:if>
                </div>
                <div class="pro-wrapper last-wrapper">
                    <h4><liferay-ui:message key="modal.submitbudget.user"/></h4>
                    <liferay-ui:message key="modal.submitbudget.user.text"/>
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
                            <aui:input id="birthday" name="birthday" cssClass="frm_date" label="modal.user.birthday" placeholder="jj/mm/aaaa" maxlength="10" onInput="checkValuesSubmitBudget();" onChange="checkValuesSubmitBudget();"/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input name="address" label="modal.user.address" maxlength="256" onInput="checkValuesSubmitBudget();" />
                        </div>
                        <div class="form-group form-half">
                            <div class="form-city">
                                <aui:input name="city" label="modal.user.city" maxlength="256" onInput="checkValuesSubmitBudget();" />
                            </div>
                            <div class="form-code">
                                <aui:input name="postalcode" label="modal.user.postalcode" maxlength="5" onInput="checkValuesSubmitBudget();"/>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <aui:input name="mail" label="modal.user.mail" required="true" disabled="true" value="${userConnected.get('email')}"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <aui:input name="phone" label="modal.user.phone" maxlength="20" value="" onInput="checkValuesSubmitBudget();"/>
                        </div>
                        <div class="form-group form-half">
                            <aui:input name="mobile" label="modal.user.mobile" maxlength="20" value="" onInput="checkValuesSubmitBudget();"/>
                        </div>
                    </div>

                    <div class="form-group form-checkbox" id="checkboxSaveInfo" >
                        <div>
                            <input type="checkbox" id="save-info" value="info">
                            <label for="save-info">
                            	<liferay-ui:message key="modal.save.info"/>
                            </label>
                        </div>
                    </div>

                    <div class="form-group"  >
                        <label><liferay-ui:message key="modal.submitbudget.commitement"/></label>
                        <aui:input type="radio" label="eu.participer.commitment.want-to-commit" value="want-to-commit" name="commitment"/>
                        <aui:input type="radio" label="eu.participer.commitment.dont-want-to-commit" value="dont-want-to-commit" name="commitment"/>
                        <aui:input type="radio" label="eu.participer.commitment.dont-know-yet" value="dont-know-yet" name="commitment"/>
                    </div>
                </div>
                <div class="top-slope"></div>
                <div class="pro-optin form-checkbox">
                    <div>
                        <input type="checkbox" id="submit-budget-legalage" value="legalage">
                        <label for="submit-budget-legalage" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_legalageSubmitBudget"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="submit-budget-cnil" value="cnil">
                        <label for="submit-budget-cnil" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cnilSubmitBudget"/>
                        </label>
                    </div>
                </div>
                <div id="sendalert" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert"/></div>
                <div class="pro-form-submit">
                    <button id="sendBudget" type="submit" class="btn btn-default"><liferay-ui:message key="modal.submitbudget.submit"/></button>
                </div>
            </aui:form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<!-- CONFIRMATION NOUVEAU BUDGET -->
<!-- HTML pour la modal de confirmation de soumission du projet -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalConfirmerBudget" tabindex="-1" role="dialog" aria-labelledby="modalConfirmerBudget">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key='confirm-budget'/></h3>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>
            <div class="pro-wrapper">
                <h4><liferay-ui:message key='submit-budget-ok'/></h4>
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
                    <input id="buttonConfirm" type="submit" class="pro-btn-yellow" value=<liferay-ui:message key="button-budget-ok"/> />
                </div>
            </div>
        </div>
    </div>
</div>

<script type="text/javascript">

	var namespaceSubmitBudget = "<portlet:namespace />";
	var saved_address = "${userConnected.get('address')}";
	var saved_zipCode = "${userConnected.get('zipcode')}";
	var saved_city = "${userConnected.get('city')}";
	var saved_dateNaiss = "${formattedDate}";
	var saved_phone = "${userConnected.get('phone')}" != 'null' ? "${userConnected.get('phone')}" : " ";
	var saved_mobile = "${userConnected.get('mobile')}" != 'null' ? "${userConnected.get('mobile')}" : " ";
	var saved_nbFiles = "${nbFiles}";
	var saved_typesFiles = "${typesFiles}";
	var saved_sizeFile = "${sizeFile}";

    $(document).ready(function(){
        $('#modalConfirmerBudget').modal('hide');
        $('#modalErrorBudget').modal('hide');
        $('#checkboxSaveInfo').hide();
        //if #deposerBudget has data-target="#modalPetition"
        if(document.location.hash == "#deposerBudget"){
            let target = $('#buttonDeposer').data('target');
            if(target != undefined && target != "") {
                $(target).modal('show');
            }

        }
    });
    
    $('#buttonDeposer').click(function(event){
        resetValuesSubmitBudget();
        document.location.hash = "#deposerBudget";
    });

    $("#sendBudget").click(function(event){
        event.preventDefault();
        var response = validateFormSubmitBudget();
        if (response){            
            var request = new XMLHttpRequest();
            var formElement = $("#<portlet:namespace />uploadForm");
            request.open('POST', '${submitBudgetURL}', true);
            //request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');

            request.onload = function() {
                if (this.status >= 200 && this.status < 400) {
                    // Success!
                    var data = JSON.parse(this.response);
                    // var data = this.get('responseData');
                    //var data = JSON.parse(e.details[1].responseText);
                    if(data.result){
                        $('#modalBudget').modal('hide');
                        if(data.savedInfo){
                            saved_dateNaiss = $("#<portlet:namespace />birthday").val();
                            saved_city = $("#<portlet:namespace />city").val();
                            saved_address = $("#<portlet:namespace />address").val();
                            saved_zipCode = $("#<portlet:namespace />postalcode").val();
                            if($("#<portlet:namespace />phone").val() != "")
                                saved_phone = $("#<portlet:namespace />phone").val();
                            if($("#<portlet:namespace />mobile").val() != "")
                                saved_mobile = $("#<portlet:namespace />mobile").val();
                        }
                        $('#modalConfirmerBudget').modal('show');
                        resetValuesSubmitBudget();
                    }else{
                        $("#modalErrorBudget h4").text(data.message);
                        $('#modalErrorBudget').modal('show');
                    }
                } else {
                    // We reached our target server, but it returned an error
                }
            };
            var formData = new FormData(formElement[0]);
            var nbFileMaxValue = saved_nbFiles;
            var typesFilesValue = saved_typesFiles;
            var videoValue = $("#"+namespaceSubmitBudget+"budgetVideo").val();
            var lieuValue =$("#"+namespaceSubmitBudget+"budgetlieux").val();
            var iframe = $('.Squire-UI').next('iframe').first()[0];
        	var editor = iframe.contentWindow.editor;       	
            var budgetDescriptionValue = editor.getHTML();
            $("#"+namespaceSubmitBudget+"budgetdescription").val(budgetDescriptionValue);
            var budgetDescription = $("#"+namespaceSubmitBudget+"budgetdescription").val();
            formData.append("<portlet:namespace/>video", videoValue);
            formData.append("<portlet:namespace/>budgetLieux", lieuValue);
            formData.append("<portlet:namespace/>squiredescription", budgetDescription);
            formData.append("<portlet:namespace/>nbFileMax", nbFileMaxValue); 
            formData.append("<portlet:namespace/>typesFiles", typesFilesValue); 
            request.send(formData);
        }
    });

    $('#modalConfirmerBudget #buttonConfirm').click(function(event){
        $('#modalConfirmerBudget').modal('hide');
    });

    $('#modalErrorBudget #buttonConfirm').click(function(event){
        $('#modalErrorBudget').modal('hide');
    });

    function gestionSelectSubmitBudget(){
        // ajoute un sélecteur s'il y a lieu
        if($(".upload-file").length < saved_nbFiles
            && $(".upload-file").length == $("#uploadDiv .deleteFile").length){
            selector =
                '<div class="pro-row"> ' +
                    '<div class="form-group form-two-tiers"> ' +
                        '<span class="browsePicture input-group-btn"> ' +
                            '<div class="form-group input-text-wrapper"> ' +
                                '<label class="control-label" for="'+namespaceSubmitBudget+'budgetFile"> Ajouter un document </label> ' +
                                '<input class="field btn btn-default btn-choose upload-file form-control" id="'+namespaceSubmitBudget+'budgetFile" ' +
                                    'name="'+namespaceSubmitBudget+'budgetFile" type="file" value="" aria-describedby="'+namespaceSubmitBudget+'budgetFileHelper" /> ' +
                            '</div> ' +
                        '</span> ' +
                    '</div> ' +
                '</div>'
            ;
            $("#uploadDiv").append(selector);
        }

        // gestion de la sélection d'un fichier
        inputs = $(".upload-file");
        inputs.each(function(){
            this.addEventListener('change', function (event) {
                selectFileSubmitBudget(this, event);
            });
        });
    };

    function deleteFileSubmitBudget(elt, e){
        // supprime le fichier
        $(elt).closest(".pro-row").remove();
        e.preventDefault();

        //gestion des sélecteurs
        gestionSelectSubmitBudget();
    };

    function selectFileSubmitBudget(elt, e){
        if($(elt).val() != ""){
            // ajout de la croix s'il y a lieu
            if($(elt).parent().find(".deleteFile").length == 0){
                $(elt).parent().append("<div class='deleteFile'></div>");
            }
            // gestion des suppressions
            btnsDeleteFiles = $(".deleteFile");
            btnsDeleteFiles.each(function(){
                this.addEventListener('click', function (event) {
                    deleteFileSubmitBudget(this, event);
                });
            });

            // Gestions des sélecteurs
            gestionSelectSubmitBudget();
        }else{
            // supprime le fichier
            deleteFileSubmitBudget(elt,e);
        }
    };

    // Gestions des sélecteurs de documents
    gestionSelectSubmitBudget();



    // gestion de la sélection d'une image
    $(".upload-image")[0].addEventListener('change', function (event) {
        if($(this).val() != ""){
            // ajout de la croix s'il y a lieu
            if($(this).parent().find(".deleteImage").length == 0){
                $(this).parent().append("<div class='deleteImage'></div>");
            }
            // gestion des suppressions
            $(".deleteImage")[0].addEventListener('click', function (event) {
                $("#"+namespaceSubmitBudget+"budgetPhoto").val("");
                $(".deleteImage").remove();
                $("#"+namespaceSubmitBudget+"budgetPhoto").css({ "box-shadow" : "" });
            });
        }else{
            $(".deleteImage").remove();
            $("#"+namespaceSubmitBudget+"budgetPhoto").css({ "box-shadow" : "" });
        }
    });

    function resetValuesSubmitBudget()
    {
        $("#"+namespaceSubmitBudget+"budgettitle").val("");
        $("#"+namespaceSubmitBudget+"budgettitle").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"budgetsummary").val("");
        $("#"+namespaceSubmitBudget+"budgetsummary").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"budgetdescription").val("");
        $("#"+namespaceSubmitBudget+"budgetlieux").val("");
        $("#"+namespaceSubmitBudget+"project option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitBudget+"project").selectric();
        $("#"+namespaceSubmitBudget+"quartier option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitBudget+"quartier").selectric();
        $("#"+namespaceSubmitBudget+"theme option[value='0']").prop('selected', true);
        $("#"+namespaceSubmitBudget+"theme").selectric();
        $('#checkboxSaveInfo #save-info').prop('checked', false);
        $('#checkboxSaveInfo').hide();
        $("#submit-budget-legalage").prop("checked", false);
        $("#submit-budget-cnil").prop("checked", false);
        $("#"+namespaceSubmitBudget+"city").val(saved_city);
        $("#"+namespaceSubmitBudget+"city").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"address").val(saved_address);
        $("#"+namespaceSubmitBudget+"address").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"budgetPhoto").val("");
        $("#"+namespaceSubmitBudget+"budgetPhoto").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"budgetVideo").val("");
        // on supprime les sélecteurs de document
        $(".upload-file").each(function(){
            $(this).closest(".pro-row").remove();
        });
        //on ajoute un sélecteur de document
        gestionSelectSubmitBudget();
        $("#"+namespaceSubmitBudget+"postalcode").val(saved_zipCode);
        $("#"+namespaceSubmitBudget+"postalcode").css({ "box-shadow" : "" });
        $("#"+namespaceSubmitBudget+"phone").val(saved_phone);
        $("#"+namespaceSubmitBudget+"mobile").val(saved_mobile);
        $("#"+namespaceSubmitBudget+"birthday").val(saved_dateNaiss);
        
        var iframe = $('.Squire-UI').next('iframe').first()[0];
    	var editor = iframe.contentWindow.editor;
    	editor.setHTML('');
        $(iframe).css({ "box-shadow" : "" });

    	$("#sendalert").addClass("hidden");
    }

    function checkValuesSubmitBudget(){
        if($("#"+namespaceSubmitBudget+"birthday").val() != saved_dateNaiss || $("#"+namespaceSubmitBudget+"address").val() != saved_address ||
        $("#"+namespaceSubmitBudget+"city").val() != saved_city || $("#"+namespaceSubmitBudget+"postalcode").val() != saved_zipCode ||
        $("#"+namespaceSubmitBudget+"phone").val() != saved_phone || $("#"+namespaceSubmitBudget+"mobile").val() != saved_mobile) {
            $('#checkboxSaveInfo #save-info').prop('checked', true);
            $('#checkboxSaveInfo').show();
        }else{
            $('#checkboxSaveInfo #save-info').prop('checked', false);
            $('#checkboxSaveInfo').hide();
        }
    }

    function validateFormSubmitBudget()
    {
        debugger;
        var result = true;
        var budgettitle = $("#"+namespaceSubmitBudget+"budgettitle").val();
        var budgetsummary = $("#"+namespaceSubmitBudget+"budgetsummary").val();
        var iframe = $('.Squire-UI').next('iframe').first()[0];
    	var editor = iframe.contentWindow.editor;       	
        var budgetdescription = editor.getHTML();
        var city = $("#"+namespaceSubmitBudget+"city").val();
        var address = $("#"+namespaceSubmitBudget+"address").val();
        var postalcode = $("#"+namespaceSubmitBudget+"postalcode").val();
        var legalage = $("#submit-budget-legalage").is(":checked");
        var cnil = $("#submit-budget-cnil").is(":checked");
        var photo = $("#"+namespaceSubmitBudget+"budgetPhoto").val();
        var files = $(".upload-file");
        var regex = new RegExp("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");

        if (photo!=null && photo!==""){
            var ext = photo.split(".").pop().toLowerCase();
            if($.inArray(ext, ['png','jpg','jpeg']) == -1) {
                $("#"+namespaceSubmitBudget+"budgetPhoto").css({ "box-shadow" : "0 0 10px #CC0000" });
                result = false;
            }else $("#"+namespaceSubmitBudget+"budgetPhoto").css({ "box-shadow" : "" });
        }

        files.each(function(){
            var file = $(this).val();
            if (file!=null && file!==""){
                var ext = file.split(".").pop().toLowerCase();
                if(saved_typesFiles.indexOf(ext) == -1 && saved_typesFiles != "") {
                    $(this).css({ "box-shadow" : "0 0 10px #CC0000" });
                    result = false;
                }else{
                    $(this).css({ "box-shadow" : "" });
                }
            }
        });

        if (budgettitle===null || budgettitle===""){
            $("#"+namespaceSubmitBudget+"budgettitle").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceSubmitBudget+"budgettitle").css({ "box-shadow" : "" });

        if ($(budgetdescription).text()===null || $(budgetdescription).text()===""){
            $(iframe).css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $(iframe).css({ "box-shadow" : "" });

        $("#"+namespaceSubmitBudget+"city").css({ "box-shadow" : "" });

         $("#"+namespaceSubmitBudget+"address").css({ "box-shadow" : "" });

         if((postalcode != null && postalcode != "") && !regex.test(postalcode)){
            $("#"+namespaceSubmitBudget+"postalcode").css({ "box-shadow" : "0 0 10px #CC0000" });
            alert("Merci de respecter la syntaxe d'un code postal");
            result = false;
        }
        else $("#"+namespaceSubmitBudget+"postalcode").css({ "box-shadow" : "" });

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

<style>
    label .required{
        color: red;
        font-size:1em;
    }

    .form-group a.link-location {
        display: block;
        font-size: 0.9em;
        color: grey;
        transition: color 0.3s;
    }

    .form-group a.link-location:hover {
        color: #f37021;
    }
</style>