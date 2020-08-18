//Initialisation de l'affichage des champs en fonction du type de recrutement,
// du type d'export, des filières et catégories et des directions
var namespace = "_eu_strasbourg_portlet_ejob_EjobBOPortlet_";
var publicationId = document.getElementById(namespace + "publicationId");
publicationId.disabled = true;
var typeRecrutements = document.getElementById(namespace + "ejobTypeRecrutement");
var typeExportTotem = document.getElementById("typeExportTotem");
var postNumber = document.getElementById(namespace + "postNumber");
var jobCreationDescription = document.querySelectorAll('[for=' + namespace + 'jobCreationDescription]')[0];
var startDate = document.querySelectorAll('[for=' + namespace + 'startDate]')[0];
var motif = document.querySelectorAll('[for=' + namespace + 'motif]')[0];
var permanentDescription = document.querySelectorAll('[for=' + namespace + 'permanentDescription]')[0];
// gestion de l'affichage des sélecteurs de service
var directions = document.getElementById(namespace + "ejobDirection");
var services = document.getElementById(namespace + "ejobService");
if(directions.value == "")
    services.parentNode.style.display='none';
directions.onchange = function(){
 services.parentNode.style.display = "block";
 Array.prototype.forEach.call(services.children, function(child, i){
     if(child.attributes["data-direction-id"] != undefined){
         if(child.attributes["data-direction-id"].value == directions.value ){
             child.style.display="block";
         }
         else{
             child.style.display="none";
         }
     }
 });

 services.options[0].selected = 'selected';
}
var blockFullTime = document.getElementById("blockFullTime");
// gestion de l'affichage de la description en fonction du temps du contrat
var fullTime = document.querySelectorAll('input[name=' + namespace + 'isFullTime]');
var fullTimeDescription = document.querySelectorAll('[for=' + namespace + 'fullTimeDescription]')[0];
if(document.querySelector('input[name="' + namespace + 'isFullTime"]:checked').value === "0")
    fullTimeDescription.parentNode.style.display="none";
function changeHandlerFullTime(event) {
    document.getElementById(namespace + "fullTimeDescription").value = "";
    if(document.querySelector('input[name="' + namespace + 'isFullTime"]:checked').value === "1"){
        fullTimeDescription.parentNode.style.display="block";
    }else{
        fullTimeDescription.parentNode.style.display="none";
    }
}
Array.prototype.forEach.call(fullTime, function(isFullTime) {
   isFullTime.addEventListener('change', changeHandlerFullTime);
});
var ejobFiliere = document.getElementById(namespace + "ejobFiliere");
var ejobCategorie = document.getElementById(namespace + "ejobCategorie");
if(ejobFiliere.value == "")
    ejobCategorie.parentNode.style.display='none';
var ejobGrade = document.getElementById(namespace + "ejobGrade");
if(ejobCategorie.value == "")
    ejobGrade.parentNode.style.display='none';
// gestion de l'affichage des sélecteurs de catégories
ejobFiliere.onchange = function(){
    ejobCategorie.parentNode.style.display = "block";
    Array.prototype.forEach.call(ejobCategorie.children, function(child, i){
        if(child.attributes["data-filiere-id"] != undefined){
            if(child.attributes["data-filiere-id"].value == ejobFiliere.value ){
                child.style.display="block";
            }else{
                child.style.display="none";
            }
        }
    });
    Array.prototype.forEach.call(ejobGrade.children, function(child, i){
        child.style.display="none";
    });

    ejobCategorie.options[0].selected = 'selected';
    ejobGrade.options[0].selected = 'selected';
    ejobGrade.disabled = true;
}
// gestion de l'affichage des sélecteurs de grade
ejobCategorie.onchange = function(){
    ejobGrade.parentNode.style.display = "block";
    ejobGrade.disabled = false;
    Array.prototype.forEach.call(ejobGrade.children, function(child, i){
        if(child.attributes["data-filiere-id"] != undefined && child.attributes["data-categorie-id"] != undefined ){
            if(child.attributes["data-filiere-id"].value == ejobFiliere.value && child.attributes["data-categorie-id"].value == ejobCategorie.value ){
                child.style.display="block";
            }else{
                child.style.display="none";
            }
        }
    });

    ejobGrade.options[0].selected = 'selected';
}
var avantages = document.getElementById('avantages');
var ejobContact = document.getElementById(namespace + "ejobContact");
var contact = document.getElementById(namespace + "contact");
var emails = document.getElementById(namespace + "emails");
var shareLinkedin = document.getElementById(namespace + "shareLinkedin");
// gestion de l'affichage des champs en fonction du type d'export
var typesExport = document.querySelectorAll('input[name=' + namespace + 'exportTotem]');
function changeHandlerExport(event) {
    postNumber.parentNode.style.display="none";
    if(document.querySelector('input[name="' + namespace + 'exportTotem"]:checked').value === "interne"){
        ejobContact.parentNode.style.display="block";
        contact.parentNode.style.display="block";
        emails.parentNode.style.display="block";
        shareLinkedin.parentNode.parentNode.style.display="block";
    }else{
        ejobContact.options[0].selected = 'selected';
        ejobContact.parentNode.style.display="none";
        contact.value = "";
        contact.parentNode.style.display="none";
        emails.value = "";
        emails.parentNode.style.display="none";
        shareLinkedin.checked = "";
        shareLinkedin.parentNode.parentNode.style.display="none";
    }
}
Array.prototype.forEach.call(typesExport, function(typeExport) {
   typeExport.addEventListener('change', changeHandlerExport);
});
// gestion de l'affichage des champs en fonction du type de recrutement
function initialise(){
    var typeRecrutementsValue= typeRecrutements.children[typeRecrutements.selectedIndex].text;
    if (typeRecrutementsValue == "Stage"){
        typesExport[0].checked = "true";
        changeHandlerExport();
        typeExportTotem.style.display="none";
        postNumber.parentNode.style.display="block";
        document.getElementById(namespace + "jobCreationDescription").value = "";
        jobCreationDescription.parentNode.style.display="none";
        document.getElementById(namespace + "startDate").value = "";
        startDate.parentNode.style.display="none";
        document.getElementById(namespace + "motif").value = "";
        motif.parentNode.style.display="none";
        document.getElementById(namespace + "permanentDescription").value = "";
        permanentDescription.parentNode.style.display="none";
        fullTime[0].checked = "true";
        changeHandlerFullTime();
        blockFullTime.style.display="none";
        ejobFiliere.options[0].selected = 'selected';
        ejobFiliere.parentNode.style.display="none";
        ejobCategorie.options[0].selected = 'selected';
        ejobCategorie.parentNode.style.display="none";
        ejobGrade.options[0].selected = 'selected';
        ejobGrade.parentNode.style.display="none";
        if(CKEDITOR.instances[namespace + "avantagesEditor"] != undefined)
            CKEDITOR.instances[namespace + "avantagesEditor"].setData("");
        avantages.style.display="none";
        ejobContact.options[0].selected = 'selected';
        ejobContact.parentNode.style.display="none";
        contact.parentNode.style.display="block";
        emails.parentNode.style.display="block";
        shareLinkedin.parentNode.parentNode.style.display="block";
    }else{
        typeExportTotem.style.display="block";
        postNumber.value = "";
        postNumber.parentNode.style.display="none";
        changeHandlerExport();
        jobCreationDescription.parentNode.style.display="block";
        document.getElementById(namespace + "startDate").value = new Date().toLocaleString().split(" à ")[0];
        startDate.parentNode.style.display="block";
        motif.parentNode.style.display="block";
        permanentDescription.parentNode.style.display="block";
        blockFullTime.style.display="block";
        ejobFiliere.parentNode.style.display="block";
        avantages.style.display="block";
    }
}
typeRecrutements.addEventListener('change', initialise);
initialise();


//Gestion des validateurs
var allValidate = true;
var submitButton = document.getElementsByClassName('saveButton')[0];
submitButton.onclick = function(event){
    allValidate = true;

    setFiliereConditionalValidators(event);

    if (!allValidate) {
       // event.preventDefault();
    }
};



function setFiliereConditionalValidators(event) {
    // Validation des champos obligatoires conditionnels
    AUI().use('liferay-form',function() {
        var rules = Liferay.Form.get(namespace + 'fm').formValidator.get('rules');
        var typeRecrutementsValue = typeRecrutements.children[typeRecrutements.selectedIndex].text;
        var isStage = typeRecrutementsValue === "Stage";
        if (isStage) {
            rules[namespace + 'ejobFiliere'].required = false;
            rules[namespace + 'ejobCategorie'].required = false;
            rules[namespace + 'ejobGrade'].required = false;
            rules[namespace + 'contact'].required = true;
        } else {
            rules[namespace + 'ejobFiliere'].required = true;
            rules[namespace + 'ejobCategorie'].required = true;
            rules[namespace + 'ejobGrade'].required = true;
            var isInterne = document.querySelector('input[name="' + namespace + 'exportTotem"]:checked').value === "interne";
            if(isInterne){
                rules[namespace + 'contact'].required = true;
            }else{
                rules[namespace + 'contact'].required = false;
            }
        }
    });
}