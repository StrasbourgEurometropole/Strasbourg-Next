var th_video = {

    videoTemplates: {
        'vimeo': '<iframe src="https://player.vimeo.com/video/[VIDEO_ID]?&autoplay=[AUTOPLAY]&background=[MUTE]&dnt=1" width="640" height="360" frameborder="0" allow="autoplay; fullscreen" allowfullscreen></iframe>',
        'youtube': '<iframe width="560" height="315" src="https://www.youtube-nocookie.com/embed/[VIDEO_ID]?&autoplay=[AUTOPLAY]&mute=[MUTE]&start=[START]" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>'
    },

    init: function (el) {
        $(el).each(function () {
            var $elMask = $('.st-mask-video', this);
            var $elContainer = $('.st-embed-container', this);

            if ($elMask.length > 0) {
                $($elMask).click(function (e) {
                    th_video.displayVideo($elContainer, $elMask);
                });
            } else {
                th_video.observer($elContainer, $(this)[0]);
            }
        });
    },

    generateVideoIframe: function (videoId, plateforme, mute, autoplay, start) {
        if (!videoId) {
            return false;
        }
        if (!th_video.videoTemplates[plateforme]) {
            return false;
        }
        if (!mute) {
            mute = 0;
        }
        if (!autoplay) {
            autoplay = 0;
        }
        if (!start) {
            start = 0;
        }

        var html = th_video.videoTemplates[plateforme] + '';
        html = html.replace('[VIDEO_ID]', videoId);
        html = html.replace('[MUTE]', mute);
        html = html.replace('[AUTOPLAY]', autoplay);
        html = html.replace('[START]', start);
        return html;
    },

    displayVideo: function ($elContainer, $elMask) {

        var videoId = $elContainer.data('video_id');
        var plateforme = $elContainer.data('video_plateforme');
        var start = $elContainer.data('start');

        var mute = 0;
        var autoplay = 0;
        if ($elMask.length > 0) {
            autoplay = 1;
        }

        var iframeHtml = th_video.generateVideoIframe(videoId, plateforme, mute, autoplay, start);
        $elContainer.append(iframeHtml);
        if ($elMask !== false) {
            $elMask.addClass('st-hide-mask');
        }

        $elContainer.addClass("st-clicked-embed");
    },

    observer: function ($elContainer, $bloc) {
        if ('IntersectionObserver' in window) { // on vérifie si c'est compatible avec le navigateur
            var observer = new IntersectionObserver(th_video.obsCallback);
            observer.observe($bloc);
        } else {
            th_video.displayVideo($elContainer, false);
        }
    },

    // callback de l'intersection observer
    obsCallback: function (entries, observer) {
        for (var i = 0; i < entries.length; i++) {
            var entry = entries[i];
            var bloc = $(entry.target);
            var $elContainer = $('.st-embed-container', bloc);

            if (entry.isIntersecting) {
                if (!bloc.hasClass("st-iframe-loaded")) {
                    th_video.displayVideo($elContainer, false);
                    $elContainer.css("opacity", 1);
                    bloc.addClass("st-iframe-loaded");
                }
            }
        }
    }

};