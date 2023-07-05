function initform() {

    $('<span class="select-custom"></span>').insertAfter('.bloc-form select, .facettes select');

    if ($('.bloc-form').length > 0) {


        $('form select').on('change', function () {
            var value = $(this).val();
            var value_elem = $('option[value="' + value + '"]', this);
            if (value_elem.hasClass('frm_other_trigger')) {
                $('.frm_other_input').show();
            } else {
                $('.frm_other_input').hide();
            }
            $(this).parent().parent().parent().addClass('has-content');
        });

        $('.frm_single_upload input[type="file"]').addClass('jfilestyle');

        //effet entrée / sortie du label
        $(".bloc-form input, .bloc-form textarea").each(function () {
            if ($(this).val() != "") {
                $(this).parent().addClass("has-content");
            } else {
                $(this).parent().removeClass("has-content");
            }
        });


        $(".bloc-form input, .bloc-form textarea").focusout(function () {
            var _self = this;
            setTimeout(function () {
                if ($(_self).val() != "") {
                    $(_self).parent().addClass("has-content");
                } else {
                    $(_self).parent().removeClass("has-content");
                }
            }, 500);
        });


        $(".bloc-form input, .bloc-form textarea").focus(function () {
            $(this).parent().addClass("has-content");
        });


        /* Effet pour Selectric */
        $('.bloc-form select').each(function () {
            if ($(this).val() != "") {
                $(this).parents('.form-field').addClass("has-content");
            } else {
                $(this).parents('.form-field').removeClass("has-content");
            }
        });

        $(".bloc-form select").focusout(function () {
            if ($(this).val() != "") {
                $(this).parents('.form-field').addClass("has-content");
            } else {
                $(this).parents('.form-field').removeClass("has-content");
            }
        });


        $(".bloc-form select").focus(function () {
            $(this).parents('.form-field').addClass("has-content");
        });

        $('.bloc-form select , .bloc-form input[type="number"] , .bloc-form .frm_date').each(function () {
            $(this).parents('.form-field').addClass("label-stay");
        });

        $('.bloc-form .frm_opt_container').each(function () {
            $(this).parents('.form-field').addClass("label-relative");
        });

        $('.bloc-form .frm_date').each(function () {
            $(this).parents('.form-field').addClass('input-is-date');
        });

    }
}

initform();

// Scroll jusqu'au formulaire après soumission
var $scrollToEl = $('[data-scrolltothis="true"]');
if ($scrollToEl.length > 0) {
    var offsetScrollTo = $scrollToEl.offset();
    $(document).scrollTop(offsetScrollTo.top - 80);
}



// TYPE RADIO
$('.frm_radio > label').append('<span></span>');


// TYPE CHECKBOX
$('.frm_checkbox > label').append('<span></span>');


// TYPE NUMBER
if ($('.bloc-form input[type="number"]').length > 0) {

    $('.bloc-form input[type="number"]').each(function () {

        $(this).parent().append('<div class="inc cta-quantity"><span class="icon-plus"></span></div><div class="dec cta-quantity"><span class="icon-minus"></span></div>');


        var $cta_quantity = $(this).parent().find('.cta-quantity');

        $cta_quantity.on("click", function () {

            var $this = $(this);
            var oldValue = $cta_quantity.parent().find("input").val();

            if ($this.hasClass('inc')) {
                var newVal = parseFloat(oldValue) + 1;
            } else {
                // Don't allow decrementing below zero
                if (oldValue > 0) {
                    var newVal = parseFloat(oldValue) - 1;
                } else {
                    newVal = 0;
                }
            }

            $cta_quantity.parent().find("input").val(newVal);

        });

    });

}

// TYPE INPUT FILE
var currentLangFormidable = 'fr';
var buttonUploadText = {
    'fr': "Parcourir"
};

$('.frm_single_upload input[type="file"], .frm_multi_upload input[type="file"]').addClass('jfilestyle').attr('data-buttonText', buttonUploadText[currentLangFormidable]);
$('.frm_single_upload input[type="file"], .frm_multi_upload input[type="file"]').parents('.form-field').addClass('input-type-file');


$('.frm_single_upload input[type="file"], .frm_multi_upload input[type="file"]').on('click', function () {

    if ($(this).parents('.jfilestyle').first('input div').value != '') {
        $(this).parents('.form-field:first').addClass('has-content');
    } else {
        $(this).parents('.form-field:first').removeClass('has-content');
    }

});