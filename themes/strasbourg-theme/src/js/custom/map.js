function initMap() {
    th_maps.maps.forEach(function (map) {
        L.tileLayer.wms('https://adict.strasbourg.eu/mapproxy/service?', {
            layers: 'monstrasbourg'
        }).addTo(map);
    })
}