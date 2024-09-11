// Récupère la géolocalisation du user au click sur un bouton
(function () {
    const btnGeoloc = document.querySelectorAll('.st-js-btn-geolocation');
    btnGeoloc.forEach(btn => {
        btn.addEventListener('click', (e) => {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition,showError);
            } else {
                console.log('La Géolocalisation n’est pas prise en charge par ce navigateur.');
            }
        });
    });

    // Récupère la position
    function showPosition(pos) {
        const crd = pos.coords;
        console.log("Your current position is:");
        console.log(`Latitude : ${crd.latitude}`);
        console.log(`Longitude: ${crd.longitude}`);
        console.log(`More or less ${crd.accuracy} meters.`);
    }

    // Erreur (autorisation non accordée...)
    function showError(err) {
        console.log(`ERROR(${err.code}): ${err.message}`);
    }
})();