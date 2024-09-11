th_maps.onLoad(function () {

    th_maps.addMarkerIcon('default', {
        iconUrl: '' + document.location.origin + '/o/strasbourg-theme/images/markers/default.png',
        shadowUrl: null,
        iconSize: [35,49],
        iconAnchor: [17, 49]
    });

    th_maps.addMarkerIcon('hover', {
        iconUrl: '' + document.location.origin + '/o/strasbourg-theme/images/markers/default-hover.png',
        shadowUrl: null,
        iconSize: [35,49],
        iconAnchor: [17, 49]
    });

});

th_maps.init(thConfig.map.init);