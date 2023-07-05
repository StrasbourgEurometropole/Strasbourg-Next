// PAGE SINGLE SIT
function callbackMapSingleSIT(macarte) {
    macarte.zoomControl.setPosition('topright');
    macarte.setZoom(14);
    if (isTouchDevice()) {
        macarte.dragging.disable();
    }
}

// PAGE LISTING SIT
function callbackMapBlockSlider(macarte) {
    macarte.zoomControl.setPosition('topright');

    var markers = [];
    $('.js-results .card', $(macarte._container).parents('.bloc')).each(function () {
        const latlng = {lat: this.getAttribute('data-lat') * 1, lng: this.getAttribute('data-lng') * 1};
        const marker = th_maps.createMarker(macarte, latlng, 'default');

        macarte.on("click", function (e) {
            marker.setIcon(th_maps.markersIcons['default']);
        });

        // Lorsqu'on ouvre un popup on change l'icône pour ensuite remettre à la fermeture celle-là de default
        marker.on("popupopen", (e) => setMarkerState(marker, 'hover'));
        marker.on("popupclose", (e) => setMarkerState(marker, 'default'));

        // Lorsqu'on fait un hover sur un marqueur on change l'icône
        marker.on("mouseover", (e) => setMarkerState(marker, 'hover'));
        marker.on("mouseout", (e) => setMarkerState(marker, 'default'));

        // Lorsqu'on fait un hover sur une card, on change l'icône du marqueur
        this.addEventListener('mouseenter', (e) => setMarkerState(marker, 'hover'));
        this.addEventListener('mouseleave', (e) => setMarkerState(marker, 'default'));

        th_maps.createInfoWindow(this.outerHTML, marker, 260);
        markers.push(marker);
    });


    // Change l'état d'un marker
    function setMarkerState(marker, state) {
        if (state === 'hover') {
            marker.setIcon(th_maps.markersIcons['hover']);
            marker.setZIndexOffset(1000);        // passe le marker au-dessus des autres
        } else {
            marker.setIcon(th_maps.markersIcons['default']);
            marker.setZIndexOffset(0);
        }
    }

    // Recentre sur les points seulement s'il n'y a pas de KML (sinon centrage sur le KML par défaut)
    const el = macarte._container;

    if (!el.getAttribute('data-kml')) {
        const group = new L.featureGroup(markers);
        macarte.fitBounds(group.getBounds());
    }


    if (isTouchDevice()) {
        macarte.dragging.disable();
    }

}