var thConfig = {

    tabletPortraitBreakpoint: 980,
    tabletPaysageBreakpoint: 1024,
    desktopBreakpoint: 1280,
    mobileBreakpoint: 600,

    debug: true,

    // MAP IGN - 6mfxn9af26z1kmx9a9jwcpng / choisirgeoportail

    map: {
        init: {
            maps_class: '.st-maps:not(.no-autoload):not(.initialized)',
            /*tileLayerUrl: "https://wxs.ign.fr/{accessToken}/geoportail/wmts?" +
                "&REQUEST=GetTile&SERVICE=WMTS&VERSION=1.0.0" +
                "&STYLE=normal" +
                "&TILEMATRIXSET=PM" +
                "&FORMAT=image/png" +
                "&LAYER=GEOGRAPHICALGRIDSYSTEMS.PLANIGNV2" +
                "&TILEMATRIX={z}" +
                "&TILEROW={y}" +
                "&TILECOL={x}",*/

            tileLayerUrl: "https://adict.strasbourg.eu/mapproxy/service?",
            accessToken: 'cartes',
            tileLayerOptions: {
                wms: true,
                layers: 'monstrasbourg'
            },
        },
        kmlBgColor: '00FFFFFF',
        kmlWeight: 2,
        kmlOpacity: 1,
        kmlColor: '#000',
        kmlBgOpacity: 0.0,
    }

};

if (typeof jsConfig == 'object') {
    for (var key in jsConfig) {
        if (typeof jsConfig[key] === 'object') {
            for (var subkey in jsConfig[key]) {
                thConfig[key][subkey] = jsConfig[key][subkey];
            }
        } else {
            thConfig[key] = jsConfig[key];
        }
    }
}



function isTouchDevice() {
    return 'ontouchstart' in document.documentElement;
}

function isNoHover() {
    if (isTouchDevice() && document.body.clientWidth <= thConfig.desktopBreakpoint) {
        return true;
    }
    return false;
}

function isTabletPaysageOrSmalller() {
    if (document.body.clientWidth < thConfig.tabletPaysageBreakpoint) {
        return true;
    }
    return false;
}

function isTabletPortraitOrSmalller() {
    if (document.body.clientWidth < thConfig.tabletPortraitBreakpoint) {
        return true;
    }
    return false;
}

function isMobileOrSmaller() {
    if (document.body.clientWidth <= thConfig.mobileBreakpoint) {
        return true;
    }
    return false;
}

function convertPxToRem(px) {
    return px / parseFloat(getComputedStyle(document.documentElement).fontSize.replace('px', ''));
}

var environment, environmentChanged, windowWidth, windowHeight;
testEnvironment();
testScrollMagic();

window.onresize = function(){
    testEnvironment();
    testScrollMagic();
}

function testEnvironment() {
    var currentEnvironment = environment;
    if (isTabletPaysageOrSmalller) {
        environment = 'tablette';
        if (isMobileOrSmaller) {
            environment = 'mobile';
        }
    } else {
        environment = 'desktop';
    }
    if (currentEnvironment != environment) {
        environmentChanged = true;
        $(document).trigger( "environment:changed", [{old_environment: currentEnvironment, new_environment: environment}] );
    } else {
        environmentChanged = false;
    }
}

function testScrollMagic(){
    if(environment != 'mobile' && $(window).height() > 720){
        $('body').addClass('can-scrollMagic');
    }else{
        $('body').removeClass('can-scrollMagic');
    }
}