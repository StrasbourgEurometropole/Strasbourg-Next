function destroyPopin(){
    $('#favConfirm').remove().off('clickfavConfirm');
    $('.mseu').off('click.favconfirm').removeClass('overlayed');
}
function createPopin(message, agree, deny){
    var template = '<div id="favConfirm"> \
        <div class="favMessage">##favMessage##</div> \
        <div class="favActions"> ';
    if(deny !== undefined || agree == undefined){
        template = template + '<button class="btn-square--bordered--core deny"><span class="flexbox"><span class="btn-text">Annuler</span><span class="btn-arrow"></span></span></button>';
    }
    template = template + '<button class="btn-square--filled--second confirm"><span class="flexbox"><span class="btn-text"> ' + (deny !== undefined || agree == undefined ? 'Valider' : 'OK') + '</span><span class="btn-arrow"></span></span></button> \
        </div> \
    </div>';

    template = template.replace('##favMessage##', message);
    $('body').append(template);
    $('.mseu').addClass('overlayed');


    $('#favConfirm .deny').on('click.favConfirm', function(e){
        if(deny !== undefined){
            deny();
        }
        destroyPopin();
    });
    $('#favConfirm .confirm').on('click.favConfirm', function(){
        destroyPopin();
        if(agree !== undefined){
            agree();
        }
    });
}