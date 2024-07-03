// Définition des textes de tarteaucitron
switch (window.tarteaucitronForceLanguage) {
    case 'fr':
        var tarteaucitronCustomText = {
            "alertBigPrivacy": "<p>Nous utilisons des cookies sur ce site pour améliorer votre expérience d’utilisation, fournir des services via des contenus animés et interactifs de réseaux sociaux et vidéos, des messages de communication personnalisés, ou encore effectuer des analyses de performance.</p><p>Vous pouvez à tout moment faire part de vos choix :</p>",
            "acceptAll" : "ACCEPTER TOUS LES COOKIES",
            "allowAll" : "ACCEPTER TOUS LES COOKIES",
            "denyAll" : "REFUSER TOUS LES COOKIES",
            "personalize" : "En savoir plus et personnaliser",
            "privacyUrl" : "En savoir plus sur la gestion des cookies",
            "allow" : "Accepter",
            "deny" : "Refuser",
            "disclaimer" : "<p>La Ville et l’Eurométropole de Strasbourg utilisent des cookies sur leur site internet Strasbourg.eu afin d’améliorer l’expérience d’utilisation, fournir des services via des contenus animés et interactifs de réseaux sociaux et vidéos, des messages de communication personnalisés ou effectuer des analyses d’audience.</p><p>Des traceurs provenant de tiers sont également utilisés sur ce site. Via des cookies, ces tiers collecteront et utiliseront vos données relatives à l’adresse IP, au terminal ou navigateur utilisé, et aux activités effectuées sur le site pour des finalités qui leur sont propres.</p><p>Cette fenêtre vous permet de donner ou retirer votre consentement, soit globalement (en cliquant sur le bouton \"Accepter tous les cookies\" ou \"Refuser tous les cookies\") soit par finalité (en cliquant sur le lien \"En savoir plus et personnaliser\").</p><p>Nous conservons votre choix pendant 13 mois. Vous pouvez changer d’avis à tout moment en cliquant sur \"Gestion des cookies\" en pied de page du site Strasbourg.eu.</p>",
        };
        tarteaucitron.parameters.privacyUrl="https://www.strasbourg.eu/politique-cookies";
        break;
    case 'de':
        var tarteaucitronCustomText = {
            "alertBigPrivacy": "Diese Website verwendet Cookies, um die Benutzererfahrung zu gewährleisten, Dienstleistungen über animierte und interaktive soziale Netzwerke und Videos, personalisierte Informationen und Benachrichtigungen bereitzustellen, oder Leistungsanalysen durchzuführen.  Sie können jederzeit Ihre Wünsche bezüglich Cookies äußern und ändern, und zwar auf folgende Weise:",
            "acceptAll" : "Cookies zulassen",
            "allowAll" : "Cookies zulassen",
            "denyAll" : "Cookies ablehnen",
            "personalize" : "Mehr Informationen & Cookies-Einstellungen",
            "privacyUrl" : "Mehr Informationen über Cookies-Einstellungen",
            "allow" : "Zulassen",
            "deny" : "Ablehnen",
            "disclaimer" : "Die Stadt und die Eurometropole Straßburg verwenden Cookies auf ihren Websites, um das Nutzererlebnis zu verbessern, Dienste über animierte und interaktive Inhalte aus sozialen Netzwerken und Videos sowie personalisierte Kommunikationsbotschaften anzubieten oder Datenverkehrsanalysen durchzuführen.</br>Auf dieser Website werden auch Tracer von Drittanbietern verwendet. Über Cookies sammeln und nutzen diese Dritten Ihre Daten bezüglich der IP-Adresse, des verwendeten Endgeräts oder Browsers und der auf der Website ausgeübten Aktivitäten für ihre eigenen Zwecke.</br></br>In diesem Fenster können Sie Ihre Zustimmung entweder global (durch Klicken auf die Schaltfläche „Cookies Zulassen“ oder „Cookies ablehnen“) oder zweckgebunden (durch Klicken auf den Link „Mehr Informationen & Cookies-Einstellungen“) erteilen oder widerrufen.</br>Wir bewahren Ihre Auswahl 13 Monate lang auf. Sie können Ihre Meinung jederzeit ändern, indem Sie auf „Cookies-Einstellungen“ in der Fußzeile der Website klicken.",
        };
        tarteaucitron.parameters.privacyUrl="https://int.strasbourg.eu/de/cookie-politik";
        break;
    case 'en':
    default:
        var tarteaucitronCustomText = {
            "alertBigPrivacy": "We use cookies on this website to give you the best possible experience, provide services via animated and interactive social network and video content, personalized communication messages, and for performance analysis. You can select/change/modify your cookie settings at any time:",
            "acceptAll" : "ACCEPT ALL COOKIES",
            "allowAll" : "ACCEPT ALL COOKIES",
            "denyAll" : "DECLINE ALL COOKIES",
            "personalize" : "Learn more & settings",
            "privacyUrl" : "Learn more about cookie management",
            "allow" : "Accept",
            "deny" : "Decline",
            "disclaimer" : "The City and the Eurometropolis of Strasbourg use cookies on their websites to improve the user experience, provide services via animated and interactive social media content and videos, personalised communication messages or conduct audience analyses.</br>Third-party trackers are also used on this website. Via cookies, these third parties will collect and use your data regarding the IP address, device or browser used and the activities carried out on the site for their own purposes.</br>This window allows you to give or withdraw your consent, either entirely (by clicking the “Accept all cookies” or “Decline all cookies” button) or depending on the purpose (by clicking the “Learn more & settings” link).</br>We store your choice for 13 months. You can change your mind at any time by clicking “Cookie settings” at the bottom of the website's page.",
        };
        tarteaucitron.parameters.privacyUrl="https://int.strasbourg.eu/en/cookie-policy";
}

/* VIDEO */
/*********/
// Service Youtube
//<div class="youtube_player" videoID="video_id" width="width" height="height" theme="theme (dark | light)" rel="rel (1 | 0)" controls="controls (1 | 0)" showinfo="showinfo (1 | 0)" autoplay="autoplay (0 | 1)" mute="mute (0 | 1)" srcdoc="srcdoc" loop="loop (0 | 1)" loading="loading (0 | 1)" data-start="start" data-end="end"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('youtube');

// Service Dailymotion
//<div class="dailymotion_player" videoID="video_id" width="width" height="height" showinfo="showinfo (1 | 0)" autoplay="autoplay (0 | 1)" embedType="embedType (video | playlist)"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('dailymotion');

// Service Vimeo
//<div class="vimeo_player" videoID="video_id" width="width" height="height"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('vimeo');

// Service Calameo
//<div class="calameo-canvas" data-id="bkcode" width="width" height="height"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('calameo');

// Service SoundCloud
//<div class="soundcloud_player" data-playable-id="track_or_playlist_id" data-playable-type="type (playlists|sets)" data-height="iframe_height" data-color="accent_color" data-auto-play="autoplay (true|false)" data-hide-related="hide related (true|false)" data-show-comments="show comment (true|false)" data-show-user="show user (true|false)" data-show-reposts="show repost (true|false)" data-show-teaser="show teaser (true|false)" data-visual="visual (true|false)" data-artwork="artwork (true|false)"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('soundcloud');


/* API */
/*******/
// Service reCAPTCHA
//<div class="g-recaptcha" data-sitekey="sitekey"></div>calame
(tarteaucitron.job = tarteaucitron.job || []).push('recaptcha');
//old (tarteaucitron.job = tarteaucitron.job || []).push('recaptcha_ems');

// Service Timeline JS
//<div class="timelinejs-canvas" spreadsheet_id="spreadsheet_id" width="width" height="height" lang="lang_2_letter" font="font (Bevan-PotanoSans | Georgia-Helvetica | Arvo-PTSans)" map="map (toner | osm)" start_at_end="start_at_end (false | true)" hash_bookmark="hash_bookmark (false | true)" start_at_slide="start_at_slide (0 | ...)" start_zoom="start_zoom (0 | ... | 5)"></div>
(tarteaucitron.job = tarteaucitron.job || []).push('timelinejs');


// When windows is loaded and tarteaucitron is ready, everytime #tarteaucitronAlertBig attribute changes, we set the css variable --height-sticky to 240px
window.addEventListener('load', function() {
    // wait 500ms
    setTimeout(function() {
        let alertBig = document.querySelector('#tarteaucitronAlertBig');

        if (alertBig) {
            if(alertBig.style.display === 'block') {
                document.documentElement.style.setProperty('--height-sticky', '240px');
            }
            let observer = new MutationObserver(function(mutationsList, observer) {
                mutationsList.forEach(mutation => {
                    if (mutation.attributeName === 'style') {
                        let display = mutation.target.style.display;
                        if (display === 'block') {
                            document.documentElement.style.setProperty('--height-sticky', '240px');
                        }
                        else if (display === 'none') {
                            document.documentElement.style.setProperty('--height-sticky', '20px');
                        }
                    }

                });
            });
            observer.observe(alertBig, { attributes: true });
        }

    }, 500)

});