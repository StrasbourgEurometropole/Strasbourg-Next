/*
* Gestion des likes/dislikes
*/
$(document).on("click", "[href$='-approuv'], [href$='like-pro']", function(e) {

    e.preventDefault();
    e.stopPropagation();

    // Sauvegarde de l'élément
    var element = $(this);

    // L'élément a t-il un affiche du compteur en texte ou en span ?
    var counterType = $(this).attr('href').endsWith('-approuv') ? "span" : "text" ;

    // Récupération des attributs du like
    var title = $(this).data("title");
    var isdislike = $(this).data("isdislike");
    var typeid = $(this).data("typeid");
    var entityid = $(this).data("entityid");
    var entitygroupid = $(this).data("entitygroupid") ? $(this).data("entitygroupid") : 0;

    // Appel au service remote Liferay
    Liferay.Service(
        '/like.like/add-like-link',
        {
            title: title,
            isDislike: isdislike,
            typeId: typeid,
            entityId: entityid,
            entityGroupId: entitygroupid
        },
        function(obj) {
            // En cas de succès, on effectue la modification des éléments visuels
            // selon la réponse et le type de l'élément
            if (obj.hasOwnProperty('success')) {
                switch(obj['success']) {
                    case "like added":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) + 1);
                        } else {
                            element.text(+parseInt(element.text()) + 1);
                        }
                        break;
                    case "dislike added":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) + 1);
                        } else {
                            element.text(+parseInt(element.text()) + 1);
                        }
                        break;
                    case "like mind changed added":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) + 1);
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                        } else {
                            element.text(+parseInt(element.text()) + 1);
                            element.siblings().first().text(+parseInt(element.siblings().first().text()) - 1);
                        }
                        break;
                    case "dislike mind changed added":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) + 1);
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                        } else {
                            element.text(+parseInt(element.text()) + 1);
                            element.siblings().first().text(+parseInt(element.siblings().first().text()) - 1);
                        }
                        break;
                    case "like deleted":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) - 1);
                        } else {
                            element.text(+parseInt(element.text()) - 1);
                        }
                        break;
                    case "dislike deleted":
                        element.toggleClass('active');
                        if (counterType === "span") {
                            element.find('strong').text(+parseInt(element.text()) - 1);
                        } else {
                            element.text(+parseInt(element.text()) - 1);
                        }
                        break;
                }

            }
            // Sinon on affiche un message d'erreur
            else if (obj.hasOwnProperty('error')) {
                if (obj['error'] == 'notConnected') {
                    // Si l'utilisateur n'est pas connecté
                    e.preventDefault();
                    $("#myModal").modal();
                } else if (obj['error'] == 'isBanned') {
                    // Si l'utilisateur est banni
                    $("#modalBanned").modal();
                } else {
                    // Autre erreur
                    alert('Une erreur est survenue.');
                }
            }
        }
    );

});

/*
* Gestion des participation à un événement
*/
$(document).on("click", "[href='#Participe'], span[name^='#Participe']", function(e) {

    e.preventDefault();
    e.stopPropagation();

    // Sauvegarde de l'élément
    var element = $(this);
    var elementType = $(this).attr('href') === '#Participe' ? 'a' : 'span';

    // Récupération des attributs du like
    var eventid = $(this).data("eventid");
    var groupid = $(this).data("groupid") ? $(this).data("groupid") : 0;

    // Met à jour le compteur de participant
    function updateCounter(num) {
        var stringNum = num.toString();
        var nbDigits = stringNum.length;
        stringNum = "0".repeat(6 - nbDigits) + stringNum;
        for (i = 1; i <= 6; i++) {
            $('.pro-compt span:nth-child('+i+')').text(stringNum[i-1]);
        }
    }

    // Appel au service remote Liferay
    Liferay.Service(
        '/agenda.eventparticipation/add-event-participation-link',
        {
            eventId: eventid,
            groupId: groupid
        },
        function(obj) {
            // En cas de succès, on effectue la modification des éléments visuels
            // selon la réponse et le type de l'élément
            if (obj.hasOwnProperty('success')) {
                switch(obj['success']) {
                    case "participation added":
                        element.toggleClass('active');
                        if (elementType === "a")
                            updateCounter(parseInt($('.pro-compt').text()) + 1);
                        else
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) + 1);
                        break;
                    case "participation deleted":
                        element.toggleClass('active');
                        if (elementType === "a")
                            updateCounter(parseInt($('.pro-compt').text()) - 1);
                        else
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                        break;
                }
            }

            // Sinon on affiche un message d'erreur
            else if (obj.hasOwnProperty('error')) {
                if (obj['error'] == 'notConnected') {
                    // Si l'utilisateur n'est pas connecté
                    e.preventDefault();
                    $("#myModal").modal();
                } else if (obj['error'] == 'isBanned') {
                    // Si l'utilisateur est banni
                    $("#modalBanned").modal();
                } else {
                    // Autre erreur
                    alert('Une erreur est survenue.');
                }
            }
        }
    );
});


/*
* Demande de signature du pacte
*/
$(document).on("click", "[name='#Pact-sign']", function(e) {
    e.preventDefault();
    e.stopPropagation();
    $("#myModal").modal();
});

/*
* Demande de signature du pacte
*/
$(document).on("click", "[name='#IsBanned']", function(e) {
    e.preventDefault();
    e.stopPropagation();
    $("#modalBanned").modal();
});

/*
* Gestion des suivi de projets
*/
$(document).on("click", "[href='#Suivre'], span[name^='#Suivre']", function(e) {

    e.preventDefault();
    e.stopPropagation();

    // Sauvegarde de l'élément
    var element = $(this);
    var elementType = $(this).attr('href') === '#Suivre' ? 'a' : 'span';

    // Récupération des attributs du like
    var projectid = $(this).data("projectid");
    var groupid = $(this).data("groupid") ? $(this).data("groupid") : 0;

    // Met à jour le compteur de followers
    function updateCounter(num) {
        var stringNum = num.toString();
        var nbDigits = stringNum.length;
        stringNum = "0".repeat(6 - nbDigits) + stringNum;
        for (i = 1; i <= 6; i++) {
            $('.pro-compt span:nth-child('+i+')').text(stringNum[i-1]);
        }
    }

    // Appel au service remote Liferay
    Liferay.Service(
        '/project.projectfollowed/add-follower-link',
        {
            projectId: projectid,
            groupId: groupid
        },
        function(obj) {
            // En cas de succès, on effectue la modification des éléments visuels
            // selon la réponse et le type de l'élément
            if (obj.hasOwnProperty('success')) {
                switch(obj['success']) {
                    case "follower added":
                        element.toggleClass('active');
                        element.text("Projet suivi");
                        if (elementType === "a")
                            updateCounter(parseInt($('.pro-compt').text()) + 1);
                        else
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) + 1);
                        break;
                    case "follower deleted":
                        element.toggleClass('active');
                        element.text("Suivre ce projet");
                        if (elementType === "a")
                            updateCounter(parseInt($('.pro-compt').text()) - 1);
                        else
                            element.siblings().first().find('strong').text(+parseInt(element.siblings().first().text()) - 1);
                        break;
                }
            }

            // Sinon on affiche un message d'erreur
            else if (obj.hasOwnProperty('error')) {
                if (obj['error'] == 'notConnected') {
                    // Si l'utilisateur n'est pas connecté
                    e.preventDefault();
                    $("#myModal").modal();
                } else {
                    // Autre erreur
                    alert('Une erreur est survenue.');
                }
            }
        }
    );
});

/**
* Retourne une map Leaflet configurée pour la plateforme citoyenne
*/
function getLeafletMap() {

    //Création de la carte au centre de strasbourg
    var leafletMap = L.map('mapid', {
        // crs: L.CRS.EPSG4326, //Commenté car casse l'affichage de la carte
        center: [48.573, 7.752],
        maxBounds: [[48.42, 7.52], [48.72, 7.94]],
        minZoom: 13,
        zoom: 13,
        minZoom: 12,
        zoomControl: true,
        attributionControl: false,
        fullscreenControl: {
            pseudoFullscreen: false // if true, fullscreen to page width and height
        }
    });

    // Ajout de la couche couleur 'gct_fond_de_carte_couleur' à la carte
    var wmsLayer = L.tileLayer.wms('https://adict.strasbourg.eu/mapproxy/service?', {
        layers: 'monstrasbourg'
    }).addTo(leafletMap);

    return leafletMap;
}


/**
* Retourne l'icone de marqueur selon le type de l'entité
*/
function getMarkerIcon(entityType) {
    
    var entityType = (typeof entityType !== 'undefined') ? entityType : "default";

    switch (entityType) {
        case 'project':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-projet.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'participation':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-participation.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'event':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-event.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'petition':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-petition.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'saisine':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-saisine.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'initiative':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-initiative.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        case 'budget-participatif':
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/ico/ico-marker-budgetparticipatif.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
        default:
            return new L.Icon({
                iconUrl: '/o/plateforme-citoyenne-theme/images/logos/ico-marker-map-inte-2x-v2.png',
                iconSize: [75, 95],
                iconAnchor: [37, 78],
                popupAnchor: [1, -78]
            });
    }

    return

}


/**
* Retourne le marqueurs de leaflet sur le listing des événements
*/
function getEventListingMarker(mercators, link, publishDate, place, title) {
    var eventMarkerIcon = getMarkerIcon("event");
    var marker = L.marker(mercators, {icon: eventMarkerIcon})

    marker.bindPopup(
        '<a target="_blank" href="' + link + '" id="map-inte-container">' +
            '<div class="map-inte-content">' +
                '<div class="map-inte-header">' +
                    '<span class="pro-time">' + publishDate + '</time></span>' +
                    '<p>' + place + '</p>' +
                '</div>' +
                '<div class="map-inte-content-text"><h3>' + title + '</h3>' +
                    '<span class="pro-btn-yellow">En savoir plus</span>' +
                '</div>' +
            '</div> ' +
        '</a>'
    );

    return marker;
}

/**
* Retourne le marqueurs de leaflet d'un projet sur la carte intéractive
*/
function getProjectMarker(project, mercators) {
    var projectMarkerIcon = getMarkerIcon("project");
    var marker = L.marker(mercators, {icon: projectMarkerIcon});
    
    marker.bindPopup(
        '<div class="item pro-bloc-card-projet" data-linkall="a">' +
            '<a href="' + project.link + '"><div class="pro-header-projet">' +
                '<p>Quartier(s) concerné(s) :</p><p><strong>' + project.districtLabel + '</strong></p></div> ' +
                '<div class="pro-content-projet"><h3>' + project.title + '</h3>' +
                '<div class="pro-wrap-thematique"><span>' + project.thematicsLabel + '</span></div></div> ' +
                '<div class="pro-footer-projet"><p><strong>' + project.nbFollowers + '</strong> Citoyens-nes suivent ce projet</p></div> ' +
            '</a>' + 
        '</div>'
        ,{maxHeight: 240, minWidth: 330, maxWidth: 350}
    );

    return marker;
}

/**
* Retourne le marqueurs de leaflet d'une particiaption sur la carte intéractive
*/
function getParticipationMarker(participation, mercators) {

    var participationMarkerIcon = getMarkerIcon("participation");
    var marker = L.marker(mercators, {icon: participationMarkerIcon});

    var footerContent = '';

    if (participation.statusCode === "soon_arrived") {
        footerContent = 
            '<div class="pro-footer-participation pro-participation-soon">' + 
                '<div class="pro-avis"><span class="pro-like">' + participation.nbLikes + '</span><span class="pro-dislike">' + participation.nbDislikes + '</span></div>' + 
                '<p>Bientôt disponible</p>' +
            '</div>';
    } else if (participation.statusCode === "finished") {
        footerContent = 
            '<div class="pro-footer-participation pro-participation-deadline">' + 
                '<div class="pro-avis"><span class="pro-like">' + participation.nbLikes + '</span><span class="pro-dislike">' + participation.nbDislikes + '</span></div>' + 
                '<p>Participation terminée, merci de votre participation</p>' +
            '</div>';
    } else {
        footerContent = '<div class="pro-footer-participation"><span class="pro-form-style">Réagissez...</span></div>';
    }

    var colorHack = 
        '<style style="display: none" >' +
            '.type-color-hexa-' + participation.typeColor + '>div:before {' +
                'background:#'+ participation.typeColor + ' !important;' +
            '}' +
        '</style>';

    marker.bindPopup(
        '<div class="pro-vignette-map-inte">' +
            '<a href="' + participation.link + '" class="item pro-bloc-card-participation pro-theme-information type-color-hexa-' + participation.typeColor + '" data-linkall="a">' +
            '<div>' +
                '<div class="pro-header-participation">' + 
                    '<figure><img src="' + participation.authorImageURL + '" width="40" height="40" alt="Arrière plan page standard"/></figure>' +
                    '<p>Participation publiée par :</p><p><strong>' + participation.author + '</strong></p>' +
                    '<div class="pro-info-top-right"><span class="pro-encart-theme" style="background : #' + participation.typeColor + '">' + participation.typeLabel + '</span></div>' +
                '</div>' +
                '<div class="pro-content-participation">' +
                    '<div class="pro-meta"><span>' + participation.districtsLabel + '</span><span>' + participation.thematicsLabel + '</span>' +
                    '<span>' + participation.statusLabel + '</span><span>' + participation.projectName + '</span></div>' +
                    '<h3>' + participation.title + '</h3>' +
                    '<span class="pro-time">Publiée le <time datetime="2018-01-10">' + participation.createDate + '</time>' +
                    ' / <span class="pro-duree">' + participation.statusDetailLabel + '</span></span></div>' +
                    footerContent +
            '</div></a>' + 
        '</div>' + 
        colorHack
        ,{maxHeight: 280, minWidth: 477, maxWidth: 487}
    );

    return marker;

}

/**
* Retourne le marqueurs de leaflet d'un événement sur la carte intéractive
*/
function getEventMarker(event) {
    //mercators, link, publishDate, place, title, isUserPart, nbPart) {

    var eventMarkerIcon = getMarkerIcon("event");
    var marker = L.marker([event.mercatorY, event.mercatorX], {icon: eventMarkerIcon});

    var activePart = event.isUserPart ? "active" : "";

    marker.bindPopup(
        '<div class="pro-vignette-map-inte">' + 
            '<a href="' + event.link + '" title="lien de la page" class="pro-bloc-card-event"><div>' +
                '<div class="pro-header-event">' +
                    '<span class="pro-ico"><span class="icon-ico-conference"></span></span>' +
                    '<span class="pro-time">' + event.firstDate + '</time></span>' +
                    '<p>À : ' + event.completeAddress + '</p>' +
                    '<h3>' + event.title.fr_FR + '</h3>' +
                '</div>' +
                '<div class="pro-footer-event">' +
                    '<span class="pro-btn-action ' + activePart + '">Je participe</span>' +
                    '<span class="pro-number"><strong>' + event.nbPart + '</strong> Participant(s)</span>' +
                '</div>' +
            '</div></a>' +
        '</div>'
        ,{maxHeight: 270, minWidth: 441, maxWidth: 451}
    );

    return marker;
}

/**
* Retourne le marqueurs de leaflet d'une pétition sur la carte intéractive
*/
function getPetitionMarker(petition, mercators) {

    var petitionMarkerIcon = getMarkerIcon("petition");
    var marker = L.marker(mercators, {icon: petitionMarkerIcon});

    marker.bindPopup(
        '<div class="item pro-bloc-card-petition"><a href="' + petition.link + '">' +
            '<div class="pro-header-petition">' +
                '<figure role="group">' +
                    '<img src="' + petition.authorImageURL + '" width="40" height="40" alt="Image petition"/>' +
                '</figure>' +
                '<p>Pétition publiée par :</p><p><strong>' + petition.author + '</strong></p>' +
            '</div>' +
            '<div class="pro-content-petition">' +
                '<h3>' + petition.title + '</h3><p>Pétition adressée à <u>Ville de Strasbourg</u></p>' +
                '<span class="pro-time">Publiée le <time datetime="' + petition.publicationDate + '">' + petition.publicationDate +
                '</time> / <span class="pro-duree">' + petition.proDureeFR + '</span></span>' +
            '</div> ' +
            '<div class="pro-footer-petition">' +
                '<div class="pro-progress-bar">' +
                    '<div class="pro-progress-container"><div style="width:' + petition.pourcentageSignature +'%"></div>' +
                '</div>' +
                '<p class="pro-txt-progress"><strong>' + petition.nombreSignature + '</strong> Signataire(s) sur ' + petition.quotaSignature + ' nécessaires</p> ' +
            '</div>' +
        '</div></a></div>'
        ,{maxHeight: 240, minWidth: 330, maxWidth: 350}
    );

    return marker;

}

/**
 * Retourne le marqueurs de leaflet d'une saisine sur la carte intéractive
 */
function getSaisineMarker(saisineObservatoire, mercators) {

    var saisineObservatoireMarkerIcon = getMarkerIcon("saisine");
    var marker = L.marker(mercators, {icon: saisineObservatoireMarkerIcon});

    console.log("saisine marker. createDate=" + saisineObservatoire.createDate);
    marker.bindPopup(
        '<div class="item pro-bloc-card-petition"><a href="' + saisineObservatoire.link + '">' +
            '<div class="pro-header-petition">' +
                '<figure role="group">' +
                    '<img src="' + saisineObservatoire.authorImageURL + '" width="40" height="40" alt="Image saisine"/>' +
                '</figure>' +
                '<p>Saisine publiée par :</p><p><strong>' + saisineObservatoire.author + '</strong></p>' +
            '</div>' +
            '<div class="pro-content-petition">' +
                '<h3>' + saisineObservatoire.title + '</h3><p>Saisine adressée à <u>Ville de Strasbourg</u></p>' +
                '<span class="pro-time">Publiée le <time datetime="' + saisineObservatoire.createDate + '">' + saisineObservatoire.createDate +
                '</time></span>' +
            '</div> ' +
            '</a></div>'
        ,{maxHeight: 240, minWidth: 330, maxWidth: 350}
    );

    return marker;

}

/**
* Retourne le marqueurs de leaflet d'un budget participatif sur la carte intéractive
*/
function getBudgetParticipatifMarker(budgetParticipatif, mercators) {

    var budgetParticipatifMarkerIcon = getMarkerIcon("budget-participatif");
    var marker = L.marker(mercators, {icon: budgetParticipatifMarkerIcon});
	
	var footer = "";
	var cssClassBPStatus = "";
	
	if(budgetParticipatif.isNotDoable)
	{
		footer = "<p>Ce projet a été étudié et déclaré \"" + budgetParticipatif.BPStatus + "\"</p>";
		cssClassBPStatus = "pro-theme-non-faisable";
	}
	else
	{

        footer = "<p><strong>" + budgetParticipatif.nbSupports + "</strong> vote(s) pour ce projet</p>";
        cssClassBPStatus = "pro-theme-faisable";
	}
	
    marker.bindPopup(
        '<div class="item pro-bloc-card-budget ' + cssClassBPStatus + '">' +
            '<a href="' + budgetParticipatif.link + '">' +
                '<div class="pro-header-budget">' +
                    '<figure role="group">' + 
                        '<img src="' + budgetParticipatif.authorImageURL + '" width="40" height="40" alt="Arrière plan page standard"/>' + 
                    '</figure>' +
                    '<p>Projet déposé par :</p><p><strong>' + budgetParticipatif.author + '</strong></p>' +
                    '<div class="pro-info-top-right">' + 
                        '<span class="pro-encart-theme" style="background:#' + budgetParticipatif.BPStatusColor + ';">' + budgetParticipatif.BPStatus + '</span>' + 
                    '</div>' + 
                '</div>' +
                '<div class="pro-content-budget">' + 
                    '<h3>' + budgetParticipatif.title + '</h3>' + 
                    '<span class="pro-time">Publiée le <time datetime="2018-01-10">' + budgetParticipatif.publicationDate + '</time></span>' + 
                '</div> ' +            
                '<div class="pro-footer-budget">' + footer +                    
                '</div>' +
            '</a>' +
        '</div>'
        ,{maxHeight: 350, minWidth: 330, maxWidth: 350}
    );

    return marker;
}

/**
* Retourne le marqueurs de leaflet d'une initiative sur la carte intéractive
*/
function getInitiativeMarker(initiative, mercators) {

    var initiativeMarkerIcon = getMarkerIcon("initiative");
    var marker = L.marker(mercators, {icon: initiativeMarkerIcon});

    marker.bindPopup(
        '<div class="item pro-bloc-card-initiative">' + 
            '<a href="' + initiative.link + '">' + 
                '<div class="wrapper-card-initiative"><div> ' +
                '<div class="pro-header-initiative">' + 
                    '<figure role="group"><img src="' + initiative.authorImageURL + '" width="40" height="40" alt="Arrière plan page standard"/></figure> ' +
                    '<p>Atelier publié par :</p><p><strong>' + initiative.author + '</strong></p>' +
                '</div> ' +
                '<div class="pro-content-initiative">' +
                    '<h3>' + initiative.title + '</h3>' +
                    '<span class="pro-time">Publié le <time datetime="' + initiative.unformatedPublishedDate + '">' + initiative.publishedDate + '</time></span>' +
                '</div> ' + 
                '</div></div>' +
                '<div class="pro-footer-initiative"><div class="pro-avis"><span>' + initiative.nbHelps + '</span></div><p>Citoyens-nes ont proposé leur aide</p>' +
                '</div>' +
            '</a>' +
        '</div>'
        ,{maxHeight: 350, minWidth: 330, maxWidth: 350}
    );

    return marker;

}

/**
 * Retoune le résultat
 */
function getResult(searchPage, data) {
    if(data != null){
        var nbEntries = data.entries.length;
        // afficahge résultat
        var proListing = $('.pro-listing-' + searchPage);
        var row = proListing.data('row');
        proListing.html('');
        var listing;
        if(row == true) {
            listing = '<div class="row pro-wi-grid unstyled" data-page="1">';
        } else {
            listing = '<div class="pro-wi-grid unstyled" data-page="1">';
        }
        var indexGrid = 2;
        $.each(data.entries,function(index, json) {
            if(index > 0 && index % delta == 0){
                if(row == true) {
                    listing += '</div><div class="row pro-wi-grid hidden unstyled" data-page="' + indexGrid + '">';
                } else {
                    listing += '</div><div class="pro-wi-grid hidden unstyled" data-page="' + indexGrid + '">';
                }
                indexGrid++;
            }

            if(json.class == "eu.strasbourg.service.video.model.Video"){
                listing += createVideo(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.Project"){
                listing += createProject(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.Participation"){
                listing += createParticipation(json.json);
            }

            if(json.class == "eu.strasbourg.service.agenda.model.Event"){
                listing += createAgenda(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.Petition"){
                listing += createPetition(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.SaisineObservatoire"){
                listing += createSaisineObservatoire(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.BudgetParticipatif"){
                listing += createBudgetParticipatif(json.json);
            }

            if(json.class == "eu.strasbourg.service.project.model.Initiative"){
                listing += createInitiative(json.json);
            }

            if(json.class == "com.liferay.journal.model.JournalArticle"){

                if(searchPage == "project-workshop"){
                    listing += createProjectWorkshop(json.json);
                }else{
                    listing += createNews(json.json);
                }
            }
			
        });
        listing += '</div>';
        $('.pro-listing-' + searchPage).html(listing);

        // gestion de la pagination
        // selecteur de page + Label
        selecteur = '';
        if(nbEntries > delta){
            selecteur =
            '<form method="get">' +
                '<select id="change-page" name="change-page">';
            var indexPage = 1;
            for (indexPage; indexPage <= nbEntries / delta; indexPage++) {
                selecteur +=
                    '<option value="' + indexPage + '">' +
                        'Page ' + indexPage + ' ( ' + delta + ' )' +
                    '</option>';
            }
            var nbEntitesRestantes = (nbEntries - delta * (indexPage - 1));
            if(nbEntitesRestantes > 0){
                selecteur +=
                    '<option value="' + indexPage + '">' +
                        'Page ' + indexPage + ' ( ' + nbEntitesRestantes + ' )' +
                    '</option>';
            }
            selecteur +=
                '</select>' +
            '</form>';
        }
        selecteur += '<p class="hidden-xs"></p>';
        $('.pro-pagination .pull-left').html(selecteur);
        $('#change-page').selectric();

        // liens de navigation
        link = '';
        if(nbEntries > delta){
            link =
            '<ul>' +
                '<!-- Lien vers la premiere page -->' +
                '<li class="pro-disabled" >' +
                    '<a href="#go-to-top" class="hidden-sm hidden-xs pro-first" title="Lien vers la premiere page du Listing" data-action="first">Premier</a>' +
                '</li>' +
                '<!-- Lien vers la page precedente page -->' +
                '<li class="pro-disabled" >' +
                    '<a href="#go-to-top" title="Lien vers la page precedente du Listing" data-action="prev">Précédent</a>' +
                '</li>' +
                '<!-- Lien vers la page suivante -->' +
                '<li>' +
                    '<a href="#go-to-top" title="Lien vers la page suivante du Listing" data-action="next">Suivant</a>' +
                '</li>' +
                '<!-- Lien vers la derniere page -->' +
                '<li>' +
                    '<a href="#go-to-top" class="hidden-sm hidden-xs pro-last" title="Lien vers la derniere page du Listing" data-action="last">Dernier</a>' +
                '</li>' +
            '</ul>';
        }
        $('.pro-pagination .pull-right').html(link);
    }
    buildPaginate();
}

/**
* Création de la vignette vidéo
* @return
*/
function createVideo(video){
    var vignette =
        '<div class="col-md-4 col-sm-6 col-xs-12">' +
            '<div class="pro-card pro-card-video vignette" data-linkall="> a">' +
                '<div class="pro-header">' +
                    '<figure class="fit-cover" role="group">' +
                        '<img alt="' + video.title["fr_FR"] + '" width="280" height="175" src="' + video.imageURL + (video.imageURL.includes('?') ? '&' : '?') + 'imagePreview=1" loading="lazy">' +
                    '</figure>' +
                    '<span class="icon-ico-lecteur"></span>' +
                '</div>' +
                '<div class="pro-meta-avis">' +
                    '<div class="pro-avis">' +
                        '<a href="#pro-avis-like-pro" class="pro-like"' +
                            'data-typeid="3" ' +
                            'data-isdislike="false"' +
                            'data-title="' + video.title["fr_FR"] + '"' +
                            'data-entityid="' + video.id + '"' +
                            'data-entitygroupid="' + video.groupId + '">' +
                            video.nbLikes +
                        '</a>' +
                        '<a href="#pro-avis-dislike-pro" class="pro-dislike"' +
                            'data-typeid="3" ' +
                            'data-isdislike="true"' +
                            'data-title="' + video.title["fr_FR"] + '"' +
                            'data-entityid="' + video.id + '"' +
                            'data-entitygroupid="' + video.groupId + '">' +
                            video.nbDislikes +
                        '</a>' +
                    '</div>';
                    if (video.nbViews != ""){
                        vignette +=
                        '<span class="pro-view">' +
                            video.nbViews + ' vues' +
                        '</span>';
                    }
                vignette +=
                '</div>' +
                '<a href="' + homeURL + 'detail-video/-/entity/id/' + video.id + '" title="Vers la page ' + video.title["fr_FR"] + '" class="pro-link-all"><h3>' + video.title["fr_FR"] + '</h3></a>' +
            '</div>' +
        '</div>';

    return vignette;
}

/**
* Création de la vignette projet
 * @return
*/
function createProject(project){
    var vignette =
        '<div class="col-md-4 col-sm-6 col-xs-12">' +
            '<div class="item bloc-card-projet vignette">' +
                '<a href="' + homeURL + project.detailURL + '" title="lien de la page">' +
                    '<div class="img">' +
                        '<figure role="group">' +
                            '<img src="' + project.imageURL + (project.imageURL.includes('?') ? '&' : '?') + 'imagePreview=1" loading="lazy" alt="Image projet" width="360" height="242" class="fit-cover"/>' +
                        '</figure>' +
                        '<span>Voir le projet</span>' +
                    '</div>' +
                    '<div class="content">' +
                        '<span class="location">' + project.districtLabel + '</span>' +
                        '<h3>' + project.title + '</h3>' +
                        '<div class="pro-wrap-thematique">' +
                            '<!-- Liste des thématiques de la participation -->';
                            for(var i = 0 ; i < project.jsonThematicCategoriesTitle.length ; i++){
                                vignette += '<span>' + project.jsonThematicCategoriesTitle[i]["fr_FR"] + '</span>';

                            }
    vignette +=         '</div>' +
                    '</div>' +
                '</a>' +
                '<ul>' +
                    '<li><a href="' + homeURL + project.detailURL + '#pro-link-participation" title="lien de la page" tabindex="-1">' + project.nbParticipations + ' démarche(s) publiée(s)</a></li>' +
                    '<li><a href="' + homeURL + project.detailURL + '#pro-link-evenement" title="lien de la page" tabindex="-1">' + project.nbEvents + ' Événement(s) à venir</a></li>' +
                '</ul>' +
            '</div>' +
        '</div>';
    return vignette;
}

/**
 * Obtient le pied de participation en fonction du statut de participation.
 * @param {string} participationStatus - Le statut de participation.
 * @returns {string} - Le pied de participation correspondant au statut.
 */
function getParticipationFooter(participation, participationStatus) {
    if (participationStatus === "À venir") {
        return `
        <div class="pro-footer-participation pro-participation-soon">
          <div class="pro-avis">
            <span class="pro-like">${participation.nbLikes}</span>
            <span class="pro-dislike">${participation.nbDislikes}</span>
          </div>
          <a href="${homeURL}detail-participation/-/entity/id/${participation.id}#pro-link-commentaire" class="pro-form-style" title="Lien vers la page détail Participation - Lien des commentaires">
            Concertation bientôt disponible...
          </a>
        </div>
      `;
    } else if (participationStatus === "Nouvelle" || participationStatus === "En cours" || participationStatus === "Bientôt terminée") {
        return `
        <div class="pro-footer-participation pro-participation-in-progress">
          <div class="pro-avis">
            ${
            participation.isJudgeable && participation.hasPactSigned
                ? `
              <a href="#pro-avis-like-pro" class="pro-like"
                data-typeid="15"
                data-isdislike="false"
                data-title="${participation.title}"
                data-entityid="${participation.id}"
                data-entitygroupid="${participation.groupId}">
                ${participation.nbLikes}
              </a>
              <a href="#pro-avis-dislike-pro" class="pro-dislike"
                data-typeid="15"
                data-isdislike="true"
                data-title="${participation.title}"
                data-entityid="${participation.id}"
                data-entitygroupid="${participation.groupId}">
                ${participation.nbDislikes}
              </a>
            `
                : participation.hasPactSigned
                    ? `
              <a class="pro-like" name="#Pact-sign">${participation.nbLikes}</a>
              <a class="pro-dislike" name="#Pact-sign">${participation.nbDislikes}</a>
            `
                    : `
              <a class="pro-like">${participation.nbLikes}</a>
              <a class="pro-dislike">${participation.nbDislikes}</a>
            `
        }
          </div>
          <a href="${homeURL}detail-participation/-/entity/id/${participation.id}#pro-link-commentaire" class="pro-form-style" title="Lien vers la page détail Participation - Lien des commentaires">
            <span class="icon-ico-comment"></span>
            Réagissez...
          </a>
        </div>
      `;
    } else if (participationStatus === "Terminée") {
        return `
        <div class="pro-footer-participation pro-participation-deadline">
          <div class="pro-avis">
            <span class="pro-like">${participation.nbLikes}</span>
            <span class="pro-dislike">${participation.nbDislikes}</span>
          </div>
          <p>Participation terminée, merci de votre participation</p>
        </div>
      `;
    }

    return "";
}

/**
 * Obtient le statut de participation en fonction du code de statut.
 * @param {string} statusCode - Le code de statut de la participation.
 * @returns {Object} - L'objet contenant le statut et la durée de la participation.
 */
function getParticipationStatus(participation, statusCode) {
    switch (statusCode) {
        case "new":
            return {
                status: "Nouvelle",
                duration: `Fin dans ${participation.todayExpirationDifferenceDays} jour(s)`
            };
        case "soon_arrived":
            return {
                status: "À venir",
                duration: `Début dans ${participation.todayPublicationDifferenceDays} jour(s)`
            };
        case "in_progress":
            return {
                status: "En cours",
                duration: `Fin dans ${participation.todayExpirationDifferenceDays} jour(s)`
            };
        case "soon_finished":
            return {
                status: "Bientôt terminée",
                duration: `Fin dans ${participation.todayExpirationDifferenceDays} jour(s)`
            };
        case "finished":
            return {
                status: "Terminée",
                duration: "Terminée"
            };
        default:
            return {
                status: "",
                duration: ""
            };
    }
}


/**
 * Création de la vignette participation
 * @return
 */
function createParticipation(participation) {



    const { status: participationStatus, duration: proDuree } = getParticipationStatus(participation, participation.statusCode);

    let vignette = `
    <div class="item pro-bloc-card-participation vignette type-color-hexa-${participation.typeColor}" data-linkall="a">
      <div>
        <div class="pro-header-participation">
            <figure role="group">
              <img src="${participation.authorImageURL}${participation.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" width="40" height="40" alt="Image participation"/>
            </figure>
            <div class="pro-header-author">
            <p>Participation publiée par :</p>
            <p><strong>${participation.author}</strong></p>
          </div>
          <div class="pro-comments">
            <span><span class="icon-ico-comment"></span>${participation.nbApprovedComments} Commentaire(s)</span>
          </div>
          <div class="pro-info-top">
            <span class="pro-encart-theme" style="background: #${participation.typeColor}">
              ${participation.typeLabel}
            </span>
          </div>
        </div>
        <div class="pro-content-participation">
          <div class="pro-content-header">
            <div class="pro-meta">
              <!-- Liste des thématiques de la participation -->
              ${participation.jsonThematicCategoriesTitle
        .map((thematic) => `<span class="pro-encart-theme">${thematic["fr_FR"]}</span>`)
        .join("")}
            </div>
            
            
          </div>
          <div>
          <!-- Liste des quartiers de la participation -->
          <span class="location-participation prefix-location">${participation.districtsLabel}</span>
            </div>
          <!-- Projet lié à la participation -->
          <span class="project-participation">${participation.projectName} :</span>
          <a href="${homeURL}detail-participation/-/entity/id/${participation.id}" title="Lien vers la page détail Participation - Lien des commentaires">
            <h3>${participation.title}</h3>
          </a>
          <span class="pro-time">
            Publiée le <time datetime="${participation.createDate}">${participation.createDate}</time> / <span class="pro-duree">${proDuree}</span>
          </span>
        </div>
         ${getParticipationFooter(participation, participationStatus)}
      </div>
    </div>
    <!-- Cree le style de couleur hexa a la volee pour l'application de la couleur !-->
  `;

    if (participation.typeColor !== "") {
        vignette += `
      <style style="display: none">
        .type-color-hexa-${participation.typeColor} > *:before {
          background: #${participation.typeColor};
        }
      </style>
    `;
    }

    return vignette;
}


/**
* Création de la vignette event (agenda)
 * @return
*/
function createAgenda(agenda){
    debugger;
    var vignette =
    '<div class="vignette">' +
        '<a href="' + homeURL + 'detail-evenement/-/entity/id/' + agenda.id + '/' + agenda.normalizedTitle + '" title="lien de la page" class="item pro-bloc-card-event"' + 
            'data-lat="' + agenda.mercatorY + '"' +  
            'data-lng="' + agenda.mercatorX + '"' + 
        '>' + 
            '<div>' + 
                '<div class="pro-header-event">' + 
                    '<span class="pro-ico"><span class="icon-ico-debat"></span></span>' + 
                    '<span class="pro-time"><time>' + agenda.eventScheduleDisplay + '</time></span>' + 
                    '<p>À : ' + agenda.placeAlias + '</p>' + 
                    '<h3>' + agenda.title["fr_FR"] + '</h3>' + 
                '</div>' + 
                '<div class="pro-footer-event">' + 
                    '<span class="pro-number"><strong>' + agenda.nbPart + '</strong> Participant(s)</span>' + 
                '</div>' + 
            '</div>' + 
        '</a>' +
    '</div>';

    return vignette;
}

/**
* Création de la vignette Atelier projet
 * @return
*/
function createProjectWorkshop(projectWorkshop){
    var vignette =
    '<div class="col-md-3 col-sm-6 col-xs-12 vignette">' + 
        '<a href="' + projectWorkshop.detailURL + '" title="Lien vers la page (' + projectWorkshop.title + ')" class="pro-bloc-actu">' +          
            '<div class="img">' +
                '<figure role="group">' +
                    '<img src="' + projectWorkshop.thumbnail + (projectWorkshop.thumbnail.includes('?') ? '&' : '?') + 'imagePreview=1" loading="lazy" alt="Image" width="360" height="174" class="fit-cover"/>' +
                '</figure>' +
                '<span>';
                    vignette += projectWorkshop.jsonVocabulariesTitle;

    vignette +=
                '</span>' +
            '</div>' +
            '<div class="content">' +
                '<span class="publication">Publié le ' + projectWorkshop.modifiedDate + '</span>' +
                '<h3>' + projectWorkshop.title + '</h3>' +
                '<p>' + projectWorkshop.chapo + (projectWorkshop.chapo.length > 100 ? '...' : '') + '</p>' +
                '<span class="link">Découvrir le projet</span>' +
            '</div>' +
        '</a>' +
    '</div>';

    return vignette;
}

/**
 * Création de la vignette actualité
 * @return
 */
function createNews(news) {
    var vignette = `
    <div class="col-md-4 col-sm-6 col-xs-12 vignette">
        <a href="${news.detailURL}" title="Lien vers la page (${news.title})" class="pro-bloc-actu">
            <div class="img">
                <figure role="group">
                    <img src="${news.thumbnail}${news.thumbnail.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" alt="Image" width="360" height="174" class="fit-cover"/>
                </figure>
            </div>
            <div class="content">
            <div class="content-wrapper">
                <span class="publication">Publiée le ${news.modifiedDate}</span>
                <h3>${news.title}</h3>
                <p>${news.chapo}${news.chapo.length > 100 ? '...' : ''}</p>
                <span>${news.jsonVocabulariesTitle}</span>
            </div>
            <div class="footer-news">
            <span class="link">Lire la suite</span>
            </div>
</div>
            
        </a>
    </div>`;

    return vignette;
}

function createPetition(petition) {
    let vignette = `
    <div class="item pro-bloc-card-participation vignette" data-linkall="a">
      <div>
        <div class="pro-header-participation">
            <figure role="group">
              <img src="${petition.authorImageURL}${petition.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" width="40" height="40" alt="Image petition"/>
            </figure>
            <div class="pro-header-author">
            <p>Pétition publiée par :</p>
            <p><strong>${petition.author} adressé à : Ville de Strasbourg</strong></p>
          </div>
          <div class="pro-comments">
            <span><span class="icon-ico-comment"></span>${petition.nbApprovedComments} Commentaire(s)</span>
          </div>
          <div class="pro-info-top">
            <span class="pro-encart-theme">
              ${petition.frontStatusFR}
            </span>
          </div>
        </div>
        <div class="pro-content-participation">
          <div class="pro-content-header">
            <div class="pro-meta">
              <!-- Liste des thématiques de la participation -->
              ${petition.jsonThematicCategoriesTitle
        .map((thematic) => `<span class="pro-encart-theme">${thematic["fr_FR"]}</span>`)
        .join("")}
            </div>
            
            
          </div>
          <div>
          <!-- Liste des quartiers de la participation -->
          <span class="location-participation prefix-location">${petition.districtLabel}</span>
            </div>
          <a href="${homeURL}detail-petition/-/entity/id/${petition.id}" title="Lien vers la page détail Participation - Lien des commentaires">
            <h3>${petition.title}</h3>
          </a>
          <span class="pro-time">
            Publiée le <time datetime="${petition.createDate}">${petition.createDate}</time> / <span class="pro-duree">${petition.proDureeFR}</span>
          </span>
        </div>
        <div class="pro-footer-petition">
            <div class="pro-progress-bar">
                <div class="pro-progress-container">
                    <div style="width: ${petition.pourcentageSignature}%"></div>
                </div>
                <p class="pro-txt-progress"><strong>${petition.nombreSignature} Signataire(s)</strong> sur ${petition.quotaSignature}  nécessaires</p>
            </div>

        </div>
      </div>
    </div>
    <!-- Cree le style de couleur hexa a la volee pour l'application de la couleur !-->
  `;

    return vignette;
}


function createSaisineObservatoire(saisineObservatoire) {
    let vignette = `
    <div class="item pro-bloc-card-participation vignette" data-linkall="a">
      <div>
        <div class="pro-header-participation">
            <figure role="group">
              <img src="${saisineObservatoire.authorImageURL}${saisineObservatoire.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" width="40" height="40" alt="Image saisine"/>
            </figure>
            <div class="pro-header-author">
            <p>Saisine publiée par :</p>
            <p><strong>${saisineObservatoire.author} adressée à : Ville de Strasbourg</strong></p>
          </div>
          <div class="pro-comments">
            <span><span class="icon-ico-comment"></span>${saisineObservatoire.nbApprovedComments} Commentaire(s)</span>
          </div>
          <div class="pro-info-top">
            <span class="pro-encart-theme">
              ${saisineObservatoire.frontStatusFR}
            </span>
          </div>
        </div>
        <div class="pro-content-participation">
          <div class="pro-content-header">
            <div class="pro-meta">
              <!-- Liste des thématiques de la participation -->
              ${saisineObservatoire.jsonThematicCategoriesTitle
        .map((thematic) => `<span class="pro-encart-theme">${thematic["fr_FR"]}</span>`)
        .join("")}
            </div>
            
            
          </div>
          <div>
          <!-- Liste des quartiers de la participation -->
          <span class="location-participation prefix-location">${saisineObservatoire.districtLabel}</span>
            </div>
          <a href="${homeURL}detail-saisine-observatoire/-/entity/id/${saisineObservatoire.id}" title="Lien vers la page détail Participation - Lien des commentaires">
            <h3>${saisineObservatoire.title}</h3>
          </a>
          <span class="pro-time">
            Publiée le <time datetime="${saisineObservatoire.createDate}">${saisineObservatoire.createDate}</time>
          </span>
        </div>
      </div>
    </div>
    <!-- Cree le style de couleur hexa a la volee pour l'application de la couleur !-->
  `;

    return vignette;
}


/**
* Création de la vignette budget participatif
 * @return
*/
function createBudgetParticipatif(budgetParticipatif) {
    var vignette = `
    <div class="item pro-bloc-card-budget vignette ${budgetParticipatif.isNotDoable ? 'pro-theme-non-faisable' : 'pro-theme-faisable'}" data-linkall="a">
      <div class="pro-budget">
        <div>
          <div class="pro-header-budget" ${budgetParticipatif.imageURL != "" ?
        `style="background-image: linear-gradient(to bottom, rgba(0, 0, 0, 0.7) 0%, transparent 45%), url('${budgetParticipatif.imageURL}${budgetParticipatif.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1')"`
        :
        ''
    }>
            <figure role="group">
              <img src="${budgetParticipatif.authorImageURL}${budgetParticipatif.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" width="40" height="40" alt="Arrière plan page standard"/>
            </figure>
            <p>Projet déposé par :</p>
            <p><strong>${budgetParticipatif.author}</strong></p>
          </div>
        </div>
        <div class="pro-content-header">
          <div class="pro-info-top">
          ${budgetParticipatif.isCrush ? '<div class="pro-encart-coeur"><span>Coup de cœur</span><span class="icon-ico-coeur"></span></div>' : ''}
            <div class="flex-grow-1"></div>
            <div class="pro-comments">
                <span><span class="icon-ico-comment"></span>${budgetParticipatif.nbApprovedComments} Commentaire(s)</span>
            </div>
            <span class="pro-encart-theme ${budgetParticipatif.isNotDoable ? 'pro-encart-negative' : ''}">${budgetParticipatif.BPStatus}</span>
          </div>
          <div class="pro-content-budget">
            <span class="pro-district prefix-location">${budgetParticipatif.districtsLabel}</span>
            <a href="${homeURL}detail-budget-participatif/-/entity/id/${budgetParticipatif.id}" title="lien détail du projet citoyen"><h3>${budgetParticipatif.title}</h3></a>
            <span class="pro-time">Publié le ${budgetParticipatif.publicationDate}</time></span>
            <p class="pro-summary">${budgetParticipatif.summary}</p>
          </div>
        </div>
      </div>
      <div class="pro-footer-budget">
        ${budgetParticipatif.isNotDoable ? `<p>Ce projet a été étudié et déclaré "${budgetParticipatif.BPStatus}"</p>` : `<p><strong>${budgetParticipatif.nbSupports} vote(s)</strong> pour ce projet</p>`}
      </div>
    </div>`;

    return vignette;
}

/**
 * Création de la vignette d'initiative
 */
function createInitiative(initiative) {
    var vignette = `
    <div class="item pro-bloc-card-budget vignette" data-linkall="a">
      <div class="pro-budget">
        <div>
          <div class="pro-header-budget" ${`style="background-image: linear-gradient(to bottom, rgba(0, 0, 0,  0.7) 0%, transparent 45%), url('${initiative.imageURL}${initiative.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1')"`}>
            <figure role="group">
              <img src="${initiative.authorImageURL}${initiative.authorImageURL.includes('?') ? '&' : '?'}imagePreview=1" loading="lazy" width="40" height="40" alt="Arrière plan page standard"/>
            </figure>
            <p>Atelier déposé par :</p>
            <p><strong>${initiative.author}</strong></p>
          </div>
        </div>
        <div class="pro-content-header">
          <div class="pro-info-top">
            <div class="flex-grow-1"></div>
            ${initiative.statusLabel != "" ? `<span class="pro-encart-theme">${initiative.statusLabel}</span>` : ""}
          </div>
          <div class="pro-content-budget">
            <span class="pro-district prefix-location">${initiative.districtsLabel}</span>
            <a href="${homeURL}detail-atelier/-/entity/id/${initiative.id}" title="lien détail du projet citoyen"><h3>${initiative.title}</h3></a>
            <span class="pro-time">Publiée le ${initiative.publishedDate}</time></span>
          </div>
        </div>
      </div>
      <div class="pro-footer-budget">
        <p><strong>${initiative.nbHelps} Citoyens-nes</strong> ont proposé leur aide</p>
      </div>
    </div>`;

    return vignette;
}



/**
* Création de la pagination
*/
function buildPaginate(){
    $('.pro-search-listing').each(function(index, widget){
        var wi = {
            $widget: $(widget),
            $list: $(widget).find('.pro-wi-grid'),
            $items: $(widget).find('.vignette')
        }

        // Récupérer le nombre de page
        wi.items_count = wi.$items.length;
        wi.page_count = Math.ceil(wi.items_count / delta);

        goToPage(wi, 1);
        wi.$widget.find('[data-action="first"]').on('click', function(){
            goToPage(wi, 1);
        });
        wi.$widget.find('[data-action="prev"]').on('click', function(){
            goToPage(wi, getCurrentPage(wi) - 1);
        });
        wi.$widget.find('[data-action="next"]').on('click', function(){
            goToPage(wi, getCurrentPage(wi) + 1);
        });
        wi.$widget.find('[data-action="last"]').on('click', function(){
            goToPage(wi, wi.page_count);
        });
        wi.$widget.find('#change-page').on('change', function(){
            var target = $(this).val(); 
            goToPage(wi, target);
        })
    });
	//Permet de recharger les liens des vignettes
    th_linkAll();
}

/**
 * @description Récupère la page courante en se basant sur l'état de la pagination
 * @param {*} wi 
 */
function getCurrentPage(wi){
    var page = parseInt(wi.$widget.find('#change-page').val());
    return page;
}

/**
 * @description Affiche la page ayant l'index demandé
 * @param {Object} wi - Objet de configuration
 * @param {Int} index - Index de la page cible
 */
function goToPage(wi, index){
    if(index <= wi.page_count){
        // Gestion de l'affichage des résultats
        wi.$widget.find('.pro-wi-grid').addClass('hidden');
        wi.$widget.find('.pro-wi-grid[data-page="'+index+'"]').removeClass('hidden');

        // Gestion des états first/prev/next/last pagination
        if(index == 1){
            wi.$widget.find('[data-action="first"]').parent('li').addClass('pro-disabled');
            wi.$widget.find('[data-action="prev"]').parent('li').addClass('pro-disabled');
        }else{
            wi.$widget.find('[data-action="first"]').parent('li').removeClass('pro-disabled');
            wi.$widget.find('[data-action="prev"]').parent('li').removeClass('pro-disabled');
        }
        if(index == wi.page_count){
            wi.$widget.find('[data-action="next"]').parent('li').addClass('pro-disabled');
            wi.$widget.find('[data-action="last"]').parent('li').addClass('pro-disabled');
        }else{
            wi.$widget.find('[data-action="next"]').parent('li').removeClass('pro-disabled');
            wi.$widget.find('[data-action="last"]').parent('li').removeClass('pro-disabled');
        }

        // Gestion de l'affichage du selecteur
        wi.$widget.find('#change-page option[value="' + index + '"]').prop('selected', true);
        wi.$widget.find('#change-page').selectric();
    }

    // Gestion affichage du résultat de la pagination
    var indexDernierItemPage = index * delta;
    var pageResult = 'Affichage des résultats ' +
                    (wi.items_count > 0 ? (index > 1 ? ((index-1)*delta+1) : '1') : '0') + ' - ' +
                    (wi.items_count < indexDernierItemPage ? wi.items_count : indexDernierItemPage) +
                    ' parmi ' + wi.items_count;
    wi.$widget.find('.pro-pagination .pull-left .hidden-xs').text(pageResult);
    
}

/* DANS LES LISTING DE FACETTE DANS LES BARRES LATERALES, AU CLICK SUR EFFACER, ON DESELECTIONNE LES CHECKBOX ENFANTS ET LA VALEUR DE LA DATE DANS INPUT TEXT */
$('.pro-remove').on('click',function(){
    
    // Utilisé pour les recherches ajax
    if($(this).hasClass('dynamic')){
        // Renvoi la liste des entités demandées
        getSelectedEntries();
    }
});


$(document).ready(function () {
	
    $('.closefirstmodal').click(function () {
        $('#WarningClosePopup').modal('show');
    });

    $('.confirmclosed').click(function () {
        $('#WarningClosePopup').modal('hide');
        $('.pro-modal').modal('hide');
    });


    
});

/**
 * Lors d'un clic d'un lien vers une autre page d'un listing
 */
$(document).on('click', "a[href='#go-to-top']", function(e){
    e.preventDefault();
    var target = $(this).attr('href');
    scrollToAnchor(target);
});

/**
 * Lors d'un clic d'une option sur selecteur de page de listing
 */
$(document).on('change', "#change-page", function(e){
    e.preventDefault();
    scrollToAnchor("#go-to-top");
});

/**
 * @description Scroll vers l'ancre donné en paramètre avec douceur
 * @param {string} wi - ID de l'ancre vers laquelle scroller
 */
function scrollToAnchor(anchorId) {
    // Le sélecteur $(html, body) permet de corriger un bug sur chrome et safari (webkit).
    $('html, body')
       // On arrête toutes les animations en cours. 
       .stop()
       // On fait maintenant l'animation vers le haut (scrollTop) vers notre ancre target.
       .animate({scrollTop: $(anchorId).offset().top}, 1000 );
}