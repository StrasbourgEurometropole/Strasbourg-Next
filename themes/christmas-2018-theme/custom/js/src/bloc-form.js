// Select de la page de recherche général (pour le nobre d'articles par page)
$(document).ready(function(){
   $('.toCustomSelect, .form-select').customSelect();
}); 

// Gestion des input à l'intérieur de la modal expérience
$('.mns-modal .form-group input').focusin(function () {
    $(this).parents('.form-group:first').addClass('mns-on-focus');
});

$('.mns-modal .form-group input').focusout(function () {
    if ($(this).val().length < 1) {
        $(this).parent().removeClass('mns-on-focus');
    }
});

$('.mns-modal .form-group input').each(function(){
    if (this.value.length > 0 && this.value.length >= 1) {
        $(this).parent().addClass('mns-on-focus');
    }
});
