var thConfig = {

    tabletPortraitBreakpoint: 980,
    tabletPaysageBreakpoint: 1024,
    desktopBreakpoint: 1280,
    mobileBreakpoint: 600,

    tagmanager: "",

    debug: true,

    // MAP IGN - 6mfxn9af26z1kmx9a9jwcpng / choisirgeoportail

    map: {
        init: {
            maps_class: '.st-maps:not(.no-autoload):not(.initialized)',
            tileLayerUrl: "https://wxs.ign.fr/{accessToken}/geoportail/wmts?" +
                "&REQUEST=GetTile&SERVICE=WMTS&VERSION=1.0.0" +
                "&STYLE=normal" +
                "&TILEMATRIXSET=PM" +
                "&FORMAT=image/png" +
                "&LAYER=GEOGRAPHICALGRIDSYSTEMS.PLANIGNV2" +
                "&TILEMATRIX={z}" +
                "&TILEROW={y}" +
                "&TILECOL={x}",
            accessToken: 'cartes',
            tileLayerOptions: {
                attribution: '',
                maxZoom: 16,
                accessToken: 'cartes'
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