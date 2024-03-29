<%@ include file="/project-popup-init.jsp" %>

<portlet:resourceURL id="getBudget" var="getBudgetURL" >
</portlet:resourceURL>

<portlet:actionURL name="editBudget" var="editBudgetURL">
	<portlet:param name="redirectURL" value="${redirectURL}"/>
</portlet:actionURL>
<liferay-ui:error key="user" message="modal.editbudget.error.user-unknow" />
<liferay-ui:error key="banned" message="modal.editbudget.error.user-banned" />
<liferay-ui:error key="pact" message="modal.editbudget.error.pact" />
<liferay-ui:error key="phase" message="modal.editbudget.error.phase" />
<liferay-ui:error key="title" message="modal.editbudget.error.title" />
<liferay-ui:error key="summary" message="modal.editbudget.error.summary" />
<liferay-ui:error key="description" message="modal.editbudget.error.description" />
<liferay-ui:error key="image" message="modal.editbudget.error.image" />
<liferay-ui:error key="too-much" message="modal.editbudget.error.too-much" />
<liferay-ui:error key="extension" message="modal.editbudget.error.extension" />
<liferay-ui:error key="big" >
    <liferay-ui:message key="modal.editbudget.error.big-x" arguments="${sizeFile}" />
</liferay-ui:error>
<liferay-ui:error key="unable-to-scan-file-for-viruses" message="modal.editbudget.error.unable-to-scan" />
<liferay-ui:error key="a-virus-was-detected-in-the-file" message="modal.editbudget.error.virus-detected" />
<liferay-ui:error key="an-unexpected-error-occurred-while-scanning-for-viruses" message="modal.editbudget.error.virus-error" />
<liferay-ui:error key="read" message="modal.editbudget.error.read" />


<!-- MODIFIER UN BUDGET -->
<div class="pro-modal pro-bloc-pcs-form fade" id="modalEditBudget" tabindex="-1" role="dialog" aria-labelledby="modalEditBudget"
	data-backdrop="static" data-keyboard="false">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="pro-modal-top">
                <h3><liferay-ui:message key="modal.editbudget.title"/></h3>
                <button type="button" class="close closefirstmodal" aria-label="Close"><span aria-hidden="true"><span class="icon-multiply"></span></span></button>
            </div>

            <form id="uploadForm"  method="post" action="${editBudgetURL}" enctype="multipart/form-data">
                <div class="pro-wrapper last-wrapper">
                    <h4><liferay-ui:message key="modal.editbudget.information"/></h4>
                    <div class="form-group">
                        <aui:input id="budgettitle" name="title" label="modal.editbudget.information.title" maxlength="256" required="true" value=""/>
                    </div>
                    <div class="form-group">
                        <aui:input id="budgetsummary" cssClass="form-control pro-textarea-small" name="summary" type="textarea" label="modal.submitbudget.information.summary" maxlength="256" required="true" value=""/>
                    </div>
                    <div class="form-group">
                    	<aui:input id="budgetdescription" name="budgetdescription" type="hidden"/>
                        <aui:input name="squiredescription" type="textarea" required="true" cssClass="form-control form-squire-target" label="modal.submitbudget.information.description"/>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="quartiers"><liferay-ui:message key="modal.editbudget.information.territoire"/> <strong class="required" aria-required="true">*</strong></label>
                            <select id="<portlet:namespace />quartier" name="<portlet:namespace />quartier">
                                <c:forEach var="quartier" items="${quartiers}">
                                    <option value="${quartier.categoryId}">${quartier.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <aui:input id="budgetlieux" name="budgetlieux" label="modal.editbudget.information.lieu" maxlength="256" value=""/>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-half">
                            <label for="thematiques"><liferay-ui:message key="modal.editbudget.information.thematique"/></label>
                            <select id="<portlet:namespace />theme" name="<portlet:namespace />theme">
                                <option value="0" selected></option>
                                <c:forEach var="theme" items="${thematics}">
                                    <option value="${theme.categoryId}">${theme.name}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group form-half">
                            <label for="projets"><liferay-ui:message key="modal.editbudget.information.projet"/></label>
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
                        	<div id="budgetPhotoID">
	                            <span class="browsePicture input-group-btn">
	                                <aui:input name="budgetPhoto" type="file" label="modal.editbudget.information.picture"
	                                    cssClass="btn btn-default btn-choose">
								        <aui:validator name="acceptFiles">'jpg,png,jpeg'</aui:validator>
	                                </aui:input>
	                                <label style="color:#ff0000;font-weight:bold" id="budgetPhotoMessageID"><liferay-ui:message key="modal.editbudget.information.picture.edit.red.message.information"/></label>
	                            </span>
                            </div>
                            <div id="editPhotoID">
	                            <span class="input-group-btn">
	                                <aui:input name="editPhoto" type="button" value="Modifier ou supprimer" 
	                                label="modal.editbudget.information.picture.edit.message">
	                                </aui:input>
	                            </span>
                            </div>
                        </div>
                    </div>
                    <div class="pro-row">
                        <div class="form-group form-two-tiers">
                            <aui:input id="budgetVideo" name="budgetVideo" label="modal.editbudget.information.video" maxlength="256" value=""/>
                        </div>
                    </div>
                    <div class="form-group budgetDocuments">
                    </div>
                </div>
                <div class="top-slope"></div>
                <div class="pro-optin form-checkbox">
                    <div>
                        <input type="checkbox" id="edit-budget-legalage" value="legalage">
                        <label for="edit-budget-legalage" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_legalageEditBudget"/>
                        </label>
                    </div>
                </div>
                <div class="pro-optin form-checkbox" >
                    <div>
                        <input type="checkbox" id="edit-budget-cnil" value="cnil">
                        <label for="edit-budget-cnil" class="fontWhite">
                            <liferay-portlet:runtime portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet_INSTANCE_cnilEditBudget"/>
                        </label>
                    </div>
                </div>
                <div id="sendalert" class="hidden pro-info-supp alertMessage"><liferay-ui:message key="modal.alert"/></div>
                <!-- Champ cache : ID -->
                <input type="hidden" id="<portlet:namespace />deletePhoto" name="<portlet:namespace />deletePhoto" value="false"/>
                <input type="hidden" id="<portlet:namespace />entryId" name="<portlet:namespace />entryId" value="${entryId}"/>
                <div class="pro-form-submit">
                    <button id="sendBudget" type="button" class="btn btn-default"><liferay-ui:message key="modal.editbudget.submit"/></button>
                </div>
            </form>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->


<script type="text/javascript">

	var namespaceEditBudget = "<portlet:namespace />";
	var saved_nbFiles = "${nbFiles}";
	var saved_typesFiles = "${typesFiles}";


    function deleteFileEditBudget(elt, e){
        // supprime le fichier
        $(elt).closest(".documentSelected").remove();

        e.preventDefault();

        //gestion des sélecteurs
        gestionSelectEditBudget();
    };

    function selectFileEditBudget(elt, e){
        if($(elt).val() != ""){
            // ajout de la croix s'il y a lieu
            if($(elt).parent().find(".deleteFile").length == 0){
                $(elt).parent().append("<div class='deleteFile'></div>");
            }

            // Gestions des sélecteurs
            gestionSelectEditBudget();
        }else{
            // supprime le fichier
            deleteFileSeEditBudget(elt,e);
        }
    };

    function gestionSelectEditBudget(){
        // gestion des suppressions
        btnsDeleteFiles = $(".deleteFile");
        btnsDeleteFiles.each(function(){
            this.addEventListener('click', function (event) {
                deleteFileEditBudget(this, event);
            });
        });

        // ajoute un sélecteur s'il y a lieu
        if($(".upload-file").length < saved_nbFiles
            && $(".upload-file").length == $(".deleteFile").length){
            selector =
                '<div class="documentSelected"> ' +
                    '<span class="browsePicture input-group-btn"> ' +
                        '<div class="form-group input-text-wrapper"> ' +
                            '<input class="field btn btn-default btn-choose upload-file form-control download" id="'+namespaceEditBudget+'budgetFile" ' +
                                'name="'+namespaceEditBudget+'budgetFile" type="file" value="" aria-describedby="'+namespaceEditBudget+'budgetFileHelper" /> ' +
                        '</div> ' +
                    '</span> ' +
                '</div> '
            ;
            $(".budgetDocuments").append(selector);
        }

        // gestion de la sélection d'un fichier
        inputs = $(".upload-file.download");
        inputs.each(function(){
            this.addEventListener('change', function (event) {
                selectFileEditBudget(this, event);
            });
        });
    };
    
    
    /*
	* Lors du click sur le bouton d'ouverture de la popup
	*/
	$(document).on("click", "[href='#showModalEditBudget']", function(event) {
		event.preventDefault();
		resetValuesEditBudget();
		var entryId = $("#"+namespaceEditBudget+"entryId").val();
		
		AUI().use('aui-io-request', function(A) {
            try {
                A.io.request('${getBudgetURL}', {
                    method : 'POST',
                    dataType: 'json',
                    data:{
                    	<portlet:namespace/>entryId : entryId
                    },
                    on: {
                    	success: function(e) {
                            var data = this.get('responseData');

                            $("#"+namespaceEditBudget+"budgettitle").val(data.title);
                            var iframe = $('.Squire-UI').next('iframe').first()[0];
                            var editor = iframe.contentWindow.editor;
                            editor.setHTML(data.description);
                            $("#"+namespaceEditBudget+"budgetsummary").val(data.summary);
                            $("#"+namespaceEditBudget+"quartier").val(data.quartier).change().selectric('refresh');
                            $("#"+namespaceEditBudget+"budgetlieux").val(data.placeText);
                            $("#"+namespaceEditBudget+"project").val(data.projectId).change().selectric('refresh');
                            $("#"+namespaceEditBudget+"theme").val(data.themeId).change().selectric('refresh');
                            $("#"+namespaceEditBudget+"budgetVideo").val(data.videoURL);

                            if(data.hasImage) {
                                $("#budgetPhotoID").hide();
                                $("#editPhotoID").show();
                                $("#budgetPhotoMessageID").show();
                            }else {
                                $("#editPhotoID").hide();
                                $("#budgetPhotoMessageID").hide();
                                $("#budgetPhotoID").show();
                            }

                            //on initialise les documents
                            $('.budgetDocuments').html("");
                            var documentHTML = "";
                            // on affiche les documents si il peut y en avoir
                            if(saved_nbFiles > 0){
                                documentHTML = '<label class="control-label">Documents</label> ';
                            }
                            if(data.documents.length > 0) {
                                // on affiche les documents
                                $.each(data.documents, function(index, elt){
                                    documentHTML +=
                                        '<div class="documentSelected">' +
                                            '<input id="'+namespaceEditBudget+'budgetFileId" ' +
                                            'name="'+namespaceEditBudget+'budgetFileId" type="hidden" value="'+  elt.id  +'" /> ' +
                                            '<input class="field upload-file form-control" id="'+namespaceEditBudget+'budgetFile" ' +
                                            'name="'+namespaceEditBudget+'budgetFile" type="text" value="'+  elt.name  +'" readonly="true" /> ' +
                                            '<div class="deleteFile"></div>' +
                                        '</div>';
                                });
                            }
                            $(".budgetDocuments").append(documentHTML);

                            // gestion des sélecteurs/documents
                            gestionSelectEditBudget();
                        }
                     }
                });

            }
            catch(error) {
                if(!(error instanceof TypeError)){
                    console.log(error);
                } else console.log("petite erreur sans importance")
            }
        });
	});

	/*
	* Lors du click sur le bouton de validation du formulaire
	*/
    $("#sendBudget").click(function(event){
        var response = validateFormEditBudget();
        if (response){
        	var iframe = $('.Squire-UI').next('iframe').first()[0];
        	var editor = iframe.contentWindow.editor;
        	$("#"+namespaceEditBudget+"budgetdescription").val(editor.getHTML());
        	$("#uploadForm").submit();
        }
    });
	
    /*
	* Lors du click sur le bouton de pour modifier ou supprimer la photo
	*/
    $("#"+namespaceEditBudget+"editPhoto").click(function(event){
    	$("#"+namespaceEditBudget+"deletePhoto").val("true");
    	$("#editPhotoID").hide();
    	$("#budgetPhotoID").show();
    });

    function resetValuesEditBudget()
    {
        $("#"+namespaceEditBudget+"budgetdescription").val("");
        $("#"+namespaceEditBudget+"budgetPhoto").val("");
        $("#edit-budget-legalage").prop("checked", false);
        $("#edit-budget-cnil").prop("checked", false);
    }

    function validateFormEditBudget()
    {
        var result = true;
        var budgettitle = $("#"+namespaceEditBudget+"budgettitle").val();
        var budgetsummary = $("#"+namespaceEditBudget+"budgetsummary").val();
        var iframe = $('.Squire-UI').next('iframe').first()[0];
    	var editor = iframe.contentWindow.editor;       	
        var budgetdescription = editor.getHTML();
        var photo = $("#"+namespaceEditBudget+"budgetPhoto").val();
        var regex = new RegExp("^(([0-8][0-9])|(9[0-5]))[0-9]{3}$");
        var legalage = $("#edit-budget-legalage").is(":checked");
        var cnil = $("#edit-budget-cnil").is(":checked");
        var files = $(".upload-file.download");

        if (photo!=null && photo!==""){
            var ext = photo.split(".").pop().toLowerCase();
            if($.inArray(ext, ['png','jpg','jpeg']) == -1) {
            $("#"+namespaceEditBudget+"budgetPhoto").css({ "box-shadow" : "0 0 10px #CC0000" });
                result = false;
            }else $("#"+namespaceEditBudget+"budgetPhoto").css({ "box-shadow" : "" });
        }

        if (budgettitle===null || budgettitle===""){
            $("#"+namespaceEditBudget+"budgettitle").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceEditBudget+"budgettitle").css({ "box-shadow" : "" });
        
        if (budgetsummary===null || budgetsummary===""){
            $("#"+namespaceEditBudget+"budgetsummary").css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $("#"+namespaceEditBudget+"budgetsummary").css({ "box-shadow" : "" });

        if ($(budgetdescription).text()===null || $(budgetdescription).text()===""){
            $(iframe).css({ "box-shadow" : "0 0 10px #CC0000" });
            result = false;
        }else $(iframe).css({ "box-shadow" : "" });

        files.each(function(){
            var file = $(this).val();
            if (file!=null && file!==""){
                var ext = file.split(".").pop().toLowerCase();
                if(saved_typesFiles.indexOf(ext) == -1) {
                    $(this).css({ "box-shadow" : "0 0 10px #CC0000" });
                    result = false;
                }else $(this).css({ "box-shadow" : "" });
            }
        });

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
</style>