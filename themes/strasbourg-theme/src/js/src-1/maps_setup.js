th_maps.onLoad(function () {

    th_maps.addMarkerIcon('default', {
        iconUrl: '' + document.location.origin + '/wp-content/themes/starter/assets/images/markers/ico-marker-map-2x.png',
        shadowUrl: null,
        iconSize: [12, 12],
        iconAnchor: [6, 6]
    });

    th_maps.addMarkerIcon('hover', {
        iconUrl: '' + document.location.origin + '/wp-content/themes/starter/assets/images/markers/ico-marker-map-hover-2x.png',
        shadowUrl: null,
        iconSize: [30, 30],
        iconAnchor: [15, 15]
    });

});

th_maps.init(thConfig.map.init);