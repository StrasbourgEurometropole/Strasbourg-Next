// Définition de la langue par défaut
window.tarteaucitronForceLanguage = document.documentElement.lang === undefined ? "en" : document.documentElement.lang.slice(0,2);

// Définition des textes de tarteaucitron
switch (window.tarteaucitronForceLanguage) {
    case 'fr':
        var tarteaucitronCustomText = {
            "alertBigPrivacy": "Nous utilisons des cookies sur ce site pour notamment améliorer votre expérience d’utilisation, fournir des services via des contenus animés et interactifs de réseaux sociaux et vidéos, des messages de communication personnalisés ou encore effectuer des analyses de performance. Vous pouvez à tout moment faire part de vos choix :",
            "acceptAll" : "ACCEPTER TOUS LES COOKIES",
            "allowAll" : "ACCEPTER TOUS LES COOKIES",
            "denyAll" : "REFUSER TOUS LES COOKIES",
            "personalize" : "En savoir plus et personnaliser",
            "privacyUrl" : "En savoir plus sur la gestion des cookies",
            "allow" : "Accepter",
            "deny" : "Refuser",
        };
        break;
    case 'de':
        var tarteaucitronCustomText = {
            "alertBigPrivacy": "Diese Website verwendet Cookies, um die Benutzererfahrung zu gewährleisten, Dienstleistungen über animierte und interaktive soziale Netzwerke und Videos, personalisierte Informationen und Benachrichtigungen bereitzustellen, oder Leistungsanalysen durchzuführen.  Sie können jederzeit Ihre Wünsche bezüglich Cookies äußern und ändern, und zwar auf folgende Weise:",
            "acceptAll" : "Cookies zulassen",
            "allowAll" : "Cookies zulassen",
            "denyAll" : "Cookies ablehnen",
            "personalize" : "Mehr Informationen & Cookies-Einstellungen",
            "privacyUrl" : "Mehr Informationen über Cookies-Einstellungen",
            "allow" : "Accept",
            "deny" : "Decline",
        };
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
            "allow" : "Zulassen",
            "deny" : "Ablehnen",
        };
}

// Initialisation de tarteaucitron
tarteaucitron.init({
    "privacyUrl": "https://www.strasbourg.eu/donnees-personnelles", /* Privacy policy url */

    "hashtag": "#tarteaucitron", /* Open the panel with this hashtag */
    "cookieName": "tarteaucitron", /* Cookie name */

    "orientation": "bottom", /* Banner position (top - bottom) */
    
    "showAlertSmall": false, /* Show the small banner on bottom right */
    "cookieslist": false, /* Show the cookie list */
    
    "closePopup": false, /* Show a close X on the banner */

    "showIcon": false, /* Show cookie icon to manage cookies */
    "iconPosition": "BottomRight", /* BottomRight, BottomLeft, TopRight and TopLeft */

    "adblocker": false, /* Show a Warning if an adblocker is detected */
    
    "DenyAllCta" : true, /* Show the deny all button */
    "AcceptAllCta" : true, /* Show the accept all button when highPrivacy on */
    "highPrivacy": true, /* HIGHLY RECOMMANDED Disable auto consent */
                     
    "handleBrowserDNTRequest": false, /* If Do Not Track == 1, disallow all */

    "removeCredit": true, /* Remove credit link */
    "moreInfoLink": false, /* Show more info link */

    "useExternalCss": false, /* If false, the tarteaucitron.css file will be loaded */
    "useExternalJs": false, /* If false, the tarteaucitron.js file will be loaded */

    //"cookieDomain": ".my-multisite-domaine.fr", /* Shared cookie for multisite */
                    
    "readmoreLink": "", /* Change the default readmore link */

    "mandatory": true, /* Show a message about mandatory cookies */

});

tarteaucitron.user.recaptchaapi = '6LeGvPkSAAAAAFcWK3UVF6zPlAxGUKBq3xaR5Xi6';