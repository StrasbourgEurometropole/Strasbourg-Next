// ajout le recaptcha et exec un callback si besoin
function addRecaptchaScriptBody(el) {
    var recaptchaScript = document.createElement('script');
    recaptchaScript.src = "https://www.google.com/recaptcha/api.js?render=explicit";
    recaptchaScript.setAttribute('defer', true);
    recaptchaScript.setAttribute('async', true);
    if (el) {
        recaptchaScript.addEventListener('load', function () {
            setTimeout(function () {
                loadRecaptcha(el)
            }, 500);
        });
    }
    document.body.appendChild(recaptchaScript);
}

// cas ou il y a pas du multi recaptcha
if ($('.g-recaptcha[data-sitekey]').length > 0) {
    addRecaptchaScriptBody('.g-recaptcha[data-sitekey]');
}

// cas ou il y a du multi recaptcha
$multiRecaptchaList = $('.frm-g-recaptcha[data-sitekey]');
if ($multiRecaptchaList.length > 0) {
    addRecaptchaScriptBody('.frm-g-recaptcha[data-sitekey]');
}

function loadRecaptcha(el) {
    $(el).each(function () {
        var isSubmittedOnce = false;
        var captchaid = null;
        var form = $(this).parents("form");
        var invisible = false;
        var _self = this;

        // check si c'est un visible ou invisible
        if (this.getAttribute("data-size") && this.getAttribute("data-size") === "invisible") {
            invisible = true;
        }

        // Implémentation de intersectionobserver, pour ne charger le recaptcha que lorsque le formulaire qui le contient est dans le viewport
        if ('IntersectionObserver' in window &&
            'IntersectionObserverEntry' in window &&
            'intersectionRatio' in window.IntersectionObserverEntry.prototype) {
            var observer = new IntersectionObserver(function (entries, observer) {
                $.each(entries, function () {
                    if (this.intersectionRatio > 0) {
                        captchaid = grecaptcha.render(_self.getAttribute('id'), {
                            'sitekey': _self.getAttribute('data-sitekey'),
                            'callback': function (token) {
                                $(".g-recaptcha-response", form).val(token);

                                // On timeout, au cas où
                                if (invisible) {
                                    setTimeout(function () {
                                        form.submit();
                                    }, 250);
                                }
                            }
                        });

                        if (form && invisible) {
                            form.on("submit", function (e) {
                                console.log("submit");
                                // Faut checker si le formulaire a déjà été submit une fois,
                                // sinon on rentre dans une loop
                                if (captchaid !== null && !isSubmittedOnce) {
                                    e.preventDefault();
                                    isSubmittedOnce = true;

                                    grecaptcha.execute(captchaid);
                                }
                            })
                        }

                        observer.unobserve(form[0]);
                    }
                });
            });

            observer.observe(form[0]);
        } else {
            // Faudrait peut-être bouger ce code dans une fonction
            // Mais je pense que ça fera une abstraction inutile en vrai donc je laisse comme ça
            // pour l'instant
            captchaid = grecaptcha.render(this.getAttribute('id'), {
                'sitekey': this.getAttribute('data-sitekey'),
                'callback': function (token) {
                    $(".g-recaptcha-response", form).val(token);

                    // On timeout, au cas où
                    if (invisible) {
                        setTimeout(function () {
                            form.submit();
                        }, 250);
                    }
                }
            });

            if (form && invisible) {
                form.on("submit", function (e) {
                    // Faut checker si le formulaire a déjà été submit une fois,
                    // sinon on rentre dans une loop
                    if (captchaid !== null && !isSubmittedOnce) {
                        e.preventDefault();
                        isSubmittedOnce = true;

                        grecaptcha.execute(captchaid);
                    }
                })
            }
        }
    });
}