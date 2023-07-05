var thVheight = {

    height: 0,

    init: function (key) {
        $(window).on('resize', function () {
            thVheight.update(key)
        });
        thVheight.update(key);
    },

    update: function (force) {

        if (thVheight.detectChange() || force) {

            $('[data-vheight],[data-m-vheight]').each(function () {
                var vheight = this.getAttribute('data-vheight');
                if (document.body.clientWidth < 600 && this.getAttribute('data-m-vheight')) {
                    vheight = this.getAttribute('data-m-vheight');
                }
                if (vheight) {
                    var vheightPercent;
                    var vheightMoin = 0;
                    if (vheight.match(/\ \-\ /)) {
                        var splitted = vheight.split(' - ');
                        vheightPercent = parseInt(splitted[0]);
                        vheightMoin = parseInt(splitted[1]);
                        var newHeight = ((thVheight.height / 100) * vheightPercent) - vheightMoin;
                    } else if (vheight.match(/\ \+\ /)) {
                        var splitted = vheight.split(' + ');
                        vheightPercent = parseInt(splitted[0]);
                        vheightMoin = parseInt(splitted[1]);
                        var newHeight = ((thVheight.height / 100) * vheightPercent) + vheightMoin;
                    } else {
                        vheightPercent = parseInt(vheight);
                        var newHeight = ((thVheight.height / 100) * vheightPercent) - vheightMoin;
                    }

                    $(this).height(newHeight);
                }
            });
        }

    },
    detectChange: function () {

        var newH = document.body.clientHeight;

        if ((newH - thVheight.height) > 150 || (thVheight.height - newH) > 150) {

            thVheight.height = newH;

            return true;
        }

        return false;
    }

};