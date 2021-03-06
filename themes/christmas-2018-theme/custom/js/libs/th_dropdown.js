var th_dropdown = {

    $last: null,

    init: function(){
        th_dropdown.parse($('body'));
    },

    parse: function(el){
        $('.dropdown > a',el).each(function(){
            $(this).on('click',function(e){
                e.preventDefault();
                if($(this).parent().hasClass('open')){
                    th_dropdown.close();
                }else{
                    th_dropdown.open($(this).parent());
                }
            });
        });
    },

    open: function($dropdown){
        if($dropdown == th_dropdown.$last){
            return false;
        }
        $('#shadow-bg').addClass('display-bloc');
        $dropdown.addClass('open');
        setTimeout(function(){
            th_dropdown.$last = $dropdown;
            $(document).on('click',th_dropdown.closeLastOnClick);
        },50);
    },

    closeLastOnClick: function(e){
        if($(e.target).parents('.dropdown').first() && th_dropdown.$last && ($(e.target).parents('.dropdown').first()[0] == th_dropdown.$last[0])) {
            return true;
            $('#shadow-bg').removeClass('display-bloc');
        }
        th_dropdown.close();
    },

    close: function(){
        th_dropdown.$last.removeClass('open');
        $('#shadow-bg').removeClass('display-bloc');

        $(document).off('click',th_dropdown.closeLastOnClick);
        th_dropdown.$last = null;
        $('#shadow-bg').removeClass('display-bloc');
    }

};

th_dropdown.init();