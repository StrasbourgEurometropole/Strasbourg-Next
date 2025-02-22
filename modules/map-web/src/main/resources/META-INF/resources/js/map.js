(function($) {
    $(document).ready(function() {
        if ($('#aroundme').length) {
            var ame = {},
            $ame = $('#aroundme');
            ame.$ame = $('#aroundme'),
            ame.$trigger_side = ame.$ame.find('.side__trigger'),
            ame.$panel_side = ame.$ame.find('#aroundme__side'),
            ame.$trigger_top = ame.$ame.find('.top__trigger'),
            ame.$panel_top = ame.$ame.find('#aroundme__top'),
            ame.$filters = ame.$ame.find("#aroundme__top input[type='checkbox'], #aroundme__top select, #aroundme__top input[data-type='date']"),
            ame.$filters_dates = ame.$ame.find("#aroundme__top input[data-type='date']"),
            ame.$filters_categories = ame.$ame.find("#aroundme__top .categories input[type='checkbox']"),
            ame.$filters_categories_list = ame.$ame.find("#aroundme__top .categories select"),
            ame.$filters_interests = ame.$ame.find("#aroundme__top .interests input[type='checkbox']"),
            ame.$showFavoritesFilter = ame.$ame.find('[name=' + window.aroundMePortletNamespace + 'showFavorites]'),
            ame.$deleteFilters = ame.$ame.find('#deleteFilters');

            ame.close_panel_top = function() {
                $ame.removeClass('top-opened');
            },
            ame.open_panel_top = function() {
                $ame.addClass('top-opened');
            },
            ame.close_panel_side = function() {
                $ame.removeClass('side-opened');
            },
            ame.open_panel_side = function() {
                $ame.addClass('side-opened');
            };

            ame.$ui_fullscreen = $('.aroundme__ui--fullscreen'),
            ame.$ui_zoomin = $('.aroundme__ui--zoomin'),
            ame.$ui_zoomout = $('.aroundme__ui--zoomout'),
            ame.$ui_locate = $('.aroundme__ui--locate'),
            ame.$ui_home = $('.aroundme__ui--home'),

            // Ouverture/fermeture Panel
            ame.$trigger_side.on('click', function() {
                if ($ame.hasClass('side-opened')) {
                    // add aria-expanded attribute
                    ame.$trigger_side.attr('aria-expanded', 'false');
                    // change aria-label attribute
                    ame.$trigger_side.attr('aria-label', Liferay.Language.get('eu.aroundme.open-list'));
                    ame.close_panel_side();
                } else {
                    // add aria-expanded attribute
                    ame.$trigger_side.attr('aria-expanded', 'true');
                    // change aria-label attribute
                    ame.$trigger_side.attr('aria-label', Liferay.Language.get('eu.aroundme.close-list'));
                    ame.open_panel_side();
                }
            });

            ame.$trigger_top.on('click', function() {
                if ($ame.hasClass('top-opened')) {
                    ame.close_panel_top();
                } else {
                    ame.open_panel_top();
                }
            });

            function managePanelRwd(environment) {
                if (environment != 'desktop') { // Si tablette/mobile on ferme le panel de base
                    ame.close_panel_side();
                    ame.close_panel_top();
                } else {
                    ame.open_panel_side();
                    ame.open_panel_top();
                }
            }
            managePanelRwd(environment);
            $(document).on('environment:changed', function(data) {
                managePanelRwd(data.newEnvironment);
            });

            // Carte

            //Création de la carte au centre de strasbourg
            mymap = L.map('mapid', {
                // crs: L.CRS.EPSG4326, //Commenté car casse l'affichage de la carte
                center: [((window.cadrageX != "")?window.cadrageX:48.573) , ((window.cadrageY != "")?window.cadrageY:7.752)],
                maxBounds: [[48.327, 7.36], [48.82, 8.155]],
                zoom: (window.zoom != "")?window.zoom:13,
                minZoom: 11,
                zoomControl: false,
                attributionControl: false,
                gestureHandling: true
            });

            // Fonction qui update la liste des markers affichés sur la carte
            var updateList = function() {
                listControl._updateList();
            }

            // Couche gui gère le clustering des points
            var markers = L.markerClusterGroup({
                showCoverageOnHover: false,
                chunkProgress: updateList,
                maxClusterRadius: 55
            });

            // Ajout de la couche couleur 'gct_fond_de_carte_couleur' à la carte
            var wmsLayer = L.tileLayer.wms('https://adict.strasbourg.eu/mapproxy/service?', {
                layers: window.backgroundId
            }).addTo(mymap);

            // Contrôle correspondant à la liste des markers
            var listControl = new L.Control.ListMarkers({ layer: markers, itemIcon: null, minZoom: 17 });
            mymap.addControl(listControl);

            // Copie de ce contrôle dans la div prévue à cet effet
            $('.filtres--poi').append($('.list-markers .filtres__list'));

            // Création de la popup pour chaque type de POI
            var onEachFeature = function(feature, layer) {
                if (feature.properties) {
                    var popupMarkup = "";
                    // en fonction du type d'entité, le POI n'est pas le même
                    if (feature.properties["type"] !== '') {
                        switch (feature.properties["type"]){
                            // arret
                            case "14":
                                popupMarkup =
                                    '<div class="aroundme__infowindow infowindow">' +
                                    '     <button class="infowindow__close"></button>' +
                                    '     <div class="infowindow__content">' +
                                    '         <div class="infowindow__top">' +
                                    '             <div class="infowindow__title-block">' +
                                    '                 <div class="infowindow__name" role="heading" aria-level="3">' +
                                                          feature.properties["name"] +
                                    '                 </div>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '         <div class="infowindow__middle">' +
                                    '             <div class="infowindow__contenu">' +
                                    '                 <div class="popup-content-tram-list" >' +
                                    '                     <div class="loading">' +
                                    '                         <div class="loading-circle"></div>' +
                                    '                     </div>' +
                                    '                 </div>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '         <div class="infowindow__bottom">' +
                                    '             <div class="infowindow__type">' +
                                    '                 <a href="#" class="add-favorites" aria-pressed="false" ' +
                                    '                     role="button" style="display: flex; margin-bottom: 0px;" ' +
                                    '                     data-type="' + feature.properties['type'] + '" ' +
                                    '                     data-title="' + feature.properties['name'] + '" ' +
                                    '                     data-url="' + feature.properties['url'] + '" ' +
                                    '                     data-id="' + feature.properties['id'] +'">' +
                                    '                     <span>' + Liferay.Language.get("eu.add-to-favorite") + '</span>' +
                                    '                 </a>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '    </div>' +
                                    '    <div class="infowindow__url">' +
                                    '       <a href="' + feature.properties['url'] + '" ' +
                                                (window.newTab?'target="_blank"':'') +
                                                (feature.properties['alert']?' class="alert-arret"':'') +
                                    '           title="' + Liferay.Language.get('know-more') +
                                                (window.newTab? ' (' + Liferay.Language.get("eu.new-window") + ')':'') + '" >' +
                                    '           <span class="flexbox">' +
                                    '               <span class="btn-text">' +
                                                       Liferay.Language.get("know-more") +
                                    '               </span>' +
                                    '               <span class="btn-arrow"></span>' +
                                    '           </span>' +
                                    '       </a>' +
                                    '   </div>' +
                                    '</div>';
                                break;
                            // place
                            case "1":
                                popupMarkup =
                                    '<div class="aroundme__infowindow infowindow">' +
                                    '     <button class="infowindow__close"></button>' +
                                    '     <div class="infowindow__content">' +
                                            ((feature.properties["visual"] && !feature.properties["amount"])?
                                                '<div class="infowindow__visual">' +
                                                    '<div class="infowindow__visualImage" style="background-image: url(' +
                                                        feature.properties['visual'] +
                                                    ');"></div>' +
                                                '</div>'
                                            :
                                                '') +
                                    '         <div class="infowindow__top">' +
                                    '             <div class="infowindow__title-block">' +
                                    '                 <div class="infowindow__name" role="heading" aria-level="3">' +
                                                          feature.properties["name"] +
                                    '                 </div>' +
                                    '             </div>' +
                                    '             <div class="infowindow__address">' +
                                                      feature.properties["address"] +
                                    '             </div>' +
                                    '         </div>' +
                                    '         <div class="infowindow__middle">' +
                                                  ((!feature.properties["contenu"] && !!feature.properties["amount"]) ?
                                    '             <div class="infowindow__left">' +
                                    '                 <div class="popup-content-schedules">' +
                                    '                     <div class="loading">' +
                                    '                         <div class="loading-circle"></div>' +
                                    '                     </div>' +
                                    '                 </div>' +
                                    '             </div>' +
                                    '             <div class="infowindow__right">' +
                                    '                 <div class="infowindow__amount">' +
                                    '                     <div class="infowindow__opened">' +
                                                              feature.properties["amount"]["title"] +
                                    '                     </div>' +
                                    '                     <div class="infowindow__frequentation ' +
                                                              feature.properties["amount"]["color"] + '">' +
                                                              feature.properties["amount"]["frequentation"] +
                                    '                     </div>' +
                                    '                     <div class="crowded-label">' +
                                                              feature.properties["amount"]["label"] +
                                                              ((feature.properties["amount"]["label"] == "available-spots" || feature.properties["amount"]["label"] == "eu.place.available-velhop")?
                                                                  feature.properties["amount"]["frequentation"]
                                                              :
                                                                  '') +
                                    '                     </div>' +
                                    '                 </div>' +
                                    '             </div>'
                                                  :
                                                  ((!!feature.properties["contenu"])?
                                    '             <div class="infowindow__contenu">' +
                                                      feature.properties["contenu"] +
                                    '             </div>':'')) +
                                    '         </div>' +
                                    '         <div class="infowindow__bottom">' +
                                    '             <div class="infowindow__type">' +
                                    '                 <a href="#" class="add-favorites" aria-pressed="false" ' +
                                    '                     role="button" style="display: flex; margin-bottom: 0px;" ' +
                                    '                     data-type="' + feature.properties['type'] + '" ' +
                                    '                     data-title="' + feature.properties['name'] + '" ' +
                                    '                     data-url="' + feature.properties['url'] + '" ' +
                                    '                     data-id="' + feature.properties['id'] +'">' +
                                    '                     <span>' + Liferay.Language.get("eu.add-to-favorite") + '</span>' +
                                    '                 </a>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '    </div>' +
                                    '    <div class="infowindow__url">' +
                                    '       <a href="' + feature.properties['url'] + '" ' +
                                                (window.newTab?'target="_blank"':'') +
                                    '           title="' + Liferay.Language.get('know-more') +
                                                (window.newTab? ' (' + Liferay.Language.get("eu.new-window") + ')':'') + '" >' +
                                    '           <span class="flexbox">' +
                                    '               <span class="btn-text">' +
                                                        Liferay.Language.get("know-more") +
                                    '               </span>' +
                                    '               <span class="btn-arrow"></span>' +
                                    '           </span>' +
                                    '       </a>' +
                                    '   </div>' +
                                    '</div>';
                                break;
                            // event
                            case "2":
                                popupMarkup =
                                    '<div class="aroundme__infowindow infowindow">' +
                                    '     <button class="infowindow__close"></button>' +
                                    '     <div class="infowindow__content">' +
                                    '         <div class="infowindow__visual">' +
                                    '             <div class="infowindow__visualImage" style="background-image: url(' +
                                                      feature.properties['visual'] +
                                    '                 );"></div>' +
                                    '         </div>'+
                                    '         <div class="infowindow__top">' +
                                    '             <div class="infowindow__title-block">' +
                                    '                 <div class="infowindow__name" role="heading" aria-level="3">' +
                                                          feature.properties["name"] +
                                    '                 </div>' +
                                    '             </div>' +
                                    '             <div class="infowindow__address">' +
                                                      feature.properties["address"] +
                                    '             </div>' +
                                    '         </div>' +
                                    '         <div class="infowindow__middle">' +
                                    '             <div class="infowindow__left">' +
                                    '                 <div class="infowindow__opened">' +
                                                          ((!!feature.properties["opened"] && !!feature.properties["opened"]["url"] && feature.properties["opened"]["url"] != "")?
                                                          '<a href="' + feature.properties["opened"]["url"] + '">' + Liferay.Language.get("eu.see-times") + '</a>'
                                                          :
                                                          feature.properties["opened"]) +
                                    '                 </div>' +
                                    '                 <div class="infowindow__schedules">' +
                                                          ((!!feature.properties["schedules"])?feature.properties["schedules"]:'') +
                                    '                 </div>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '         <div class="infowindow__bottom">' +
                                    '             <div class="infowindow__type">' +
                                    '                 <a href="#" class="add-favorites" aria-pressed="false" ' +
                                    '                     role="button" style="display: flex; margin-bottom: 0px;" ' +
                                    '                     data-type="' + feature.properties['type'] + '" ' +
                                    '                     data-title="' + feature.properties['name'] + '" ' +
                                    '                     data-url="' + feature.properties['url'] + '" ' +
                                    '                     data-id="' + feature.properties['id'] +'">' +
                                    '                     <span>' + Liferay.Language.get("eu.add-to-favorite") + '</span>' +
                                    '                 </a>' +
                                    '             </div>' +
                                    '         </div>' +
                                    '    </div>' +
                                    '    <div class="infowindow__url">' +
                                    '       <a href="' + feature.properties['url'] + '" ' +
                                                (window.newTab?'target="_blank"':'') +
                                    '           title="' + Liferay.Language.get('know-more') +
                                                (window.newTab? ' (' + Liferay.Language.get("eu.new-window") + ')':'') + '" >' +
                                    '           <span class="flexbox">' +
                                    '               <span class="btn-text">' +
                                                        Liferay.Language.get("know-more") +
                                    '               </span>' +
                                    '               <span class="btn-arrow"></span>' +
                                    '           </span>' +
                                    '       </a>' +
                                    '   </div>' +
                                    '</div>';
                                break;
                        }
                    }
                    var popupElement = $.parseHTML(popupMarkup);
                    layer.bindPopup($(popupElement).html(), {closeButton: false});
                    layer.on('popupopen', function(e) {
                        // renseigne les info à la volée pour les arrêts et les lieux
                        if (feature.properties["type"] !== '') {
                            switch (feature.properties["type"]) {
                                // arret
                                case "14":
                                    // Chargement des prochains passages lors de l'ouverture de la popup
                                    var destinationList = $('.popup-content-tram-list', e.target._popup._contentNode);

                                    if(feature.properties.codeArret != "999"){
                                        Liferay.Service(
                                            '/gtfs.arret/get-arret-real-time', {
                                                stopCode: feature.properties.codeArret
                                            },
                                            function(json) {
                                                // On efface la liste
                                                $(destinationList).empty();

                                                if (Object.keys(json).length != 0) {
                                                    // Parcours des horaires
                                                    var destinations = '';
                                                    json.forEach(function(visit, i) {
                                                        // On affiche que les 4 premiers resultats
                                                        if (i >= 4) return false;

                                                        // Formatage de l'heure
                                                        var datestr = new Date(Date.parse(visit.MonitoredVehicleJourney.MonitoredCall.ExpectedDepartureTime));
                                                        var timestr = datestr.toLocaleTimeString(navigator.language, {
                                                            hour: '2-digit',
                                                            minute:'2-digit'
                                                        });

                                                        // Couleur de la ligne
                                                        var colors = findColors(visit.MonitoredVehicleJourney.LineRef);
                                                        var backgroundColor = colors != null && colors.backgroundColor != null ? colors.backgroundColor : "eeeeee";
                                                        var textColor = colors != null && colors.textColor != null ? colors.textColor : "000000";

                                                        // Formatage du nom de la destination
                                                        var destinationName = visit.MonitoredVehicleJourney.DestinationName
                                                        if (destinationName.length > 30) {
                                                            destinationName = destinationName.substring(0, 30) + '...';
                                                        }

                                                        // Ajout des horaires dans la liste
                                                        destinations +=
                                                            '<div class="row tram-destination">' +
                                                            '<p class="tram-destination-letter">' +
                                                            '<span class="transport-letters-icon"' +
                                                            'style="background:#' + backgroundColor + '; color:#' + textColor + ';">' +
                                                            visit.MonitoredVehicleJourney.PublishedLineName +
                                                            '</span>' +
                                                            '</p>' +
                                                            '<div class="tram-destination-name"><p>' +
                                                            destinationName +
                                                            '</p></div>' +
                                                            '<p class="tram-destination-schedule"><strong>' + timestr + '</strong></p>' +
                                                            '</div>';
                                                    });
                                                    $(destinationList).append(destinations);
                                                } else {
                                                    $(destinationList).append(
                                                        '<div class="row tram-destination">' +
                                                        '<div class="tram-destination-name">' +
                                                        '<p>' + Liferay.Language.get("eu.no-visit-found") + '</p>' +
                                                        '</div>' +
                                                        '</div>'
                                                    );
                                                }
                                            }
                                        );
                                    }else {
                                        $(destinationList).append(
                                            '<p>' + Liferay.Language.get("not-available-short") + '</p>'
                                        );
                                    }
                                    break;
                                // place
                                case "1":
                                    // Chargement des horaires lors de l'ouverture de la popup
                                    var scheduleInfo = $('.popup-content-schedules', e.target._popup._contentNode);

                                    Liferay.Service(
                                        '/place.place/get-cache-json-horaire', {
                                            sigId: feature.properties.sigId,
                                            localeId: Liferay.ThemeDisplay.getLanguageId()
                                        },
                                        function(json) {
                                            // On efface la liste
                                            $(scheduleInfo).empty();

                                            // Ajout des horaires dans la liste
                                            var schedules =
                                                '<div class="infowindow__opened">' + json.opened + '</div>' +
                                                '<div class="infowindow__schedules" >' + json.schedule + '</div>';
                                            $(scheduleInfo).append(schedules);
                                        }
                                    );
                                    break;
                            }
                        }

                        // réinitialise le bouton des favoris si jamais il a changé entre la création du POI et son affichage
                        var addFavoriteElement = $('.add-favorites', e.target._popup._contentNode);
                        var isFavorite = false;
                        var id = addFavoriteElement.data('id');
                        var type = addFavoriteElement.data('type');
                        var i;
                        if(window.userFavorites != undefined){
                            for (i = 0; i < window.userFavorites.length; i++) {
                                if(window.userFavorites[i].typeId == type && window.userFavorites[i].entityId == id){
                                    isFavorite = true;
                                    break;
                                }
                            }
                        }
                        if (isFavorite) {
                            addFavoriteElement.attr("aria-pressed", true);
                            addFavoriteElement.addClass('liked');
                        } else {
                            addFavoriteElement.attr("aria-pressed", false);
                            addFavoriteElement.removeClass('liked');
                        }
                    });
                    // Titre dans la liste des markers
                    layer.options['title'] = feature.properties.name;
                }
            }


            // Création de la popup pour chaque Alerte
            var popupAlerteMarkup =
                '<div class="aroundme__infowindow infowindow">' +
                '     <button class="infowindow__close"></button>' +
                '     <div class="infowindow__content">' +
                '         <div class="infowindow__visual"></div>'+
                '         <div class="infowindow__top" style="clear: both; padding-top:15px; padding-bottom: 30px;">' +
                '             <div class="infowindow__address"></div>' +
                '         </div>' +
                '    </div>' +
                '</div>';
            var popupAlerteElement = $.parseHTML(popupAlerteMarkup);
            var onEachFeatureAlerte = function(feature, layer) {
                if (feature.properties) {
                    var icone = feature.properties.type;
                    icone = icone.replace(new RegExp(' '.replace(/[|\\{}()[\]^$+*?.]/g, '\\$&'),'g'), '_').toLowerCase();
           	    	formated_info = '<img src="/o/mapweb/images/' + icone + '.png" align="left" style="margin-right: 25px;"><div class="infowindow__name">' + feature.properties.type + '</div>';
       	    		//formated_info = '<img src="' + feature.properties.url + '" align="left" style="margin-right: 25px;"><div class="infowindow__name">' + feature.properties.type + '</div>';
           	    	// On rempli les champs dans l'infowindow
                    $(popupAlerteElement).find('.infowindow__visual').html(formated_info);
                    $(popupAlerteElement).find('.infowindow__address').html(feature.properties.texte);
                    layer.bindPopup($(popupAlerteElement).html(), {closeButton: false});
                    layer.on('popupopen', function(e) {
                        $('.leaflet-popup-tip', $(e.target._popup._contentNode).parent().parent()).css('background', 'white');
                    });
                    // Titre dans la liste des markers
                    layer.options['title'] = feature.properties.lieu;
                }
            }

            // Supprime les doublons parmis les markers
            var removeDuplicates = function(markers) {
                var layers = markers.getLayers();
                var i = 0;
                while (i < layers.length) {
                    var j = i;
                    while (j < layers.length) {
                        if (i != j && layers[j].feature.properties.sigId
                            && layers[i].feature.properties.sigId == layers[j].feature.properties.sigId) {
                            markers.removeLayer(layers[j]);
                        };
                        j++;
                    }
                    i++;
                }
            }

            // Retourne l'objet marker pour un POI donné
            var pointToLayer = function(feature, latlng) {
                if (feature.properties.icon) {
                    if (feature.properties.amount) {
                        var divIcon = new L.divIcon({
                            html:  '<img width="35" height="49" style="width:35px; height:49px;" src="' + feature.properties.icon + '"><div class="aroundme__marker-amount '
                                + feature.properties.amount.color + '">'
                                + feature.properties.amount.frequentation + '</div>',
                            iconSize: [35,49],
                            iconAnchor: [17, 49],
                            popupAnchor: [1, -49]
                        });
                        return L.marker(latlng, { icon: divIcon })
                    } else if (feature.properties.alert) {
                           var divIcon = new L.divIcon({
                               html:  '<img width="35" height="49" style="width:35px; height:49px;" src="' + feature.properties.icon + '"><div class="aroundme__marker-alert"></div>',
                               iconSize: [35,49],
                               iconAnchor: [17, 49],
                               popupAnchor: [1, -49]
                           });
                           return L.marker(latlng, { icon: divIcon })
                    } else {
                        var markerIcon = new L.Icon({
                            iconUrl: feature.properties.icon,
                            iconSize: [35,49],
                            iconAnchor: [17, 49],
                            popupAnchor: [1, -50]
                        });
                        return L.marker(latlng, { icon: markerIcon })
                    }
                } else {
                	if(feature.properties.type){
                		switch (feature.properties.type) {
						case 2:
	                        var markerIcon = new L.Icon({
	                            iconUrl: '/o/mapweb/images/event.png',
	                            iconSize: [35,49],
	                            iconAnchor: [17, 49],
	                            popupAnchor: [1, -49]
	                        });
	                        return L.marker(latlng, { icon: markerIcon })
							break;
						default:
	                        var divIcon = new L.divIcon({
	                            //iconUrl: '/o/mapweb/images/default.png',
                                html:  '<div class="aroundme-icon-poi" style="background-image: url(\'/o/mapweb/images/default.png\'); height: 100%; background-size: contain;"></div>',
	                            iconSize: [35,49],
	                            iconAnchor: [17, 49],
	                            popupAnchor: [1, -49]
	                        });
                            return L.marker(latlng, { icon: divIcon })
							break;
						}
                	}
                }
            }

            var pointAlertToLayer = function(feature, latlng) {
            	var icone = feature.properties.type;
                var markerIcon = new L.Icon({
                    iconUrl: '/o/mapweb/images/' + icone.replace(new RegExp(' '.replace(/[|\\{}()[\]^$+*?.]/g, '\\$&'),'g'), '_').toLowerCase() + '.png',
                    iconSize: [43,'auto'],
                    iconAnchor: [17, 49],
                    popupAnchor: [1, -49]
                });
                return L.marker(latlng, { icon: markerIcon })
            }

            // Retient le nombre de requêtes en cours pour l'icône de chargement
            var requestsInProgress = 0;

            // Ajoute à la liste des markers ceux des favoris
            var addFavoriteMarkers = function(markers) {
                requestsInProgress++;
                showLoadingIcon();
                Liferay.Service(
                    '/strasbourg.strasbourg/get-favorites-pois', {
                        groupId: window.groupId,
                        typeContenu: window.typesContenu,
                        localeId: Liferay.ThemeDisplay.getLanguageId(),
                        alertsArret: alertsArret,
                        territoryVocabularyId: territoryVocabularyId,
                        placeTypeVocabularyId: placeTypeVocabularyId,
                        eventTypeVocabularyId: eventTypeVocabularyId
                    },
                    function(data) {
                        try {
                            // Convertion des données geoJSON en marker
                            var favoritesData = L.geoJson(data, {
                                pointToLayer: pointToLayer,
                                onEachFeature: onEachFeature
                            });
                            markers.addLayers(favoritesData);
                        } catch (e) {}
                        removeDuplicates(markers);
                        requestsInProgress--;
                        maybeHideLoadingIcon();
                    }
                );
            }

            // Ajoute à la liste des markers ceux des catégories
            var addCategoriesMarkers = function(markers, categories, vocabulariesEmptyIds) {
                requestsInProgress++;
                showLoadingIcon();
                ame.$filters_dates;
                Liferay.Service(
                    '/strasbourg.strasbourg/get-categories-pois', {
                        categories: categories,
                        vocabulariesEmptyIds: vocabulariesEmptyIds,
                        prefilters: window.prefilterCategoriesIds,
                        tags: window.prefilterTags,
                        groupId: window.groupId,
                        typeContenu: window.typesContenu,
                        dateField: window.dateField,
                        fromDate: $(ame.$filters_dates)[0]!=undefined?$(ame.$filters_dates)[0].value:'',
                        toDate: $(ame.$filters_dates)[1]!=undefined?$(ame.$filters_dates)[1].value:'',
                        localeId: Liferay.ThemeDisplay.getLanguageId(),
                        globalGroupId: window.globalGroupId,
                        alertsArret: alertsArret,
                        territoryVocabularyId: territoryVocabularyId,
                        placeTypeVocabularyId: placeTypeVocabularyId,
                        eventTypeVocabularyId: eventTypeVocabularyId
                    },
                    function(data) {
                        // Convertion des données geoJSON en marker
                        try {
                            var poisData = L.geoJson(data, {
                                pointToLayer: pointToLayer,
                                onEachFeature: onEachFeature
                            });
                            markers.addLayers(poisData);
                            removeDuplicates(markers);
                        } catch(e) {console.log(e)}
                        requestsInProgress--;
                        maybeHideLoadingIcon();
                    }
                );
            }

            // Ajoute à la liste des markers ceux des centres d'intérêt
            var addInterestsMarkers = function(markers, interests) {
                requestsInProgress++;
                showLoadingIcon();
                Liferay.Service(
                    '/strasbourg.strasbourg/get-interests-pois', {
                        interests: interests,
                        groupId: window.groupId,
                        typeContenu: window.typesContenu,
                        localeId: Liferay.ThemeDisplay.getLanguageId(),
                        globalGroupId: window.globalGroupId,
                        alertsArret: alertsArret,
                        territoryVocabularyId: territoryVocabularyId,
                        placeTypeVocabularyId: placeTypeVocabularyId,
                        eventTypeVocabularyId: eventTypeVocabularyId
                    },
                    function(data) {
                        // Convertion des données geoJSON en marker
                        try {
                            var poisData = L.geoJson(data, {
                                pointToLayer: pointToLayer,
                                onEachFeature: onEachFeature
                            });
                            markers.addLayers(poisData);
                            removeDuplicates(markers);
                        } catch(e) {}
                        requestsInProgress--;
                        maybeHideLoadingIcon();
                    }
                );
            }

            // Ajoute le traffic à la carte
            var addTraffic = function(markers) {
                requestsInProgress++;
                showLoadingIcon();
                Liferay.Service(
                    '/strasbourg.strasbourg/get-traffic', {
                    },
                    function(data) {
                        try {
                            // Convertion des données JSON en liner
                            var trafficData = L.geoJson(data, {
                                style: function (feature) {
                                    var color = feature.properties.color.replace('0x', '#');
                                    return {color: color};
                                }
                            });
                            markers.addLayers(trafficData);
                        } catch (e) {}
                        requestsInProgress--;
                        maybeHideLoadingIcon();
                    }
                );
            }

            // Ajoute les alertes à la carte
            var addAlerts = function(markers) {
                requestsInProgress++;
                showLoadingIcon();
                Liferay.Service(
                    '/strasbourg.strasbourg/get-alerts', {
                    },
                    function(data) {
                        try {
                            // Convertion des données geoJSON en marker
                            var alertesData = L.geoJson(data, {
                                pointToLayer: pointAlertToLayer,
                                onEachFeature: onEachFeatureAlerte
                            });
                            markers.addLayers(alertesData);
                        } catch (e) {}
                        requestsInProgress--;
                        maybeHideLoadingIcon();
                    }
                );
            }

            // Affichage des POIs
            var showPois = function() {
                // Clean de la carte
                mymap.removeLayer(markers);
                markers.clearLayers();

                // Récupération des catégories à afficher et des vocabulaires qui n'ont aucune catégorie cochées
                var categories = "";
                var vocabulariesEmptyIds = "";
                var vocabularyId = -1;
                var hasVocabulary = true;
                // checkbox
                $(ame.$filters_categories).each(function() {
                    if(vocabularyId != $(this).attr('data-vocabulary')){
                        if(!hasVocabulary){
                            if(vocabulariesEmptyIds.length > 0){
                                vocabulariesEmptyIds += ",";
                            }
                            vocabulariesEmptyIds += vocabularyId;
                        }
                        vocabularyId = $(this).attr('data-vocabulary');
                        hasVocabulary = false;
                    }
                    if ($(this).is(':checked')) {
                        hasVocabulary = true;
                        if (categories.length > 0) {
                            categories = categories + ",";
                        }
                        categories = categories + $(this).attr('value');
                    }
                })
                if(!hasVocabulary){
                    if(vocabulariesEmptyIds.length > 0){
                        vocabulariesEmptyIds += ",";
                    }
                    vocabulariesEmptyIds += vocabularyId;
                }

                // liste
                $(ame.$filters_categories_list).each(function() {
                    var allCategoriesVocabulary = "";
                    var categoriesVocabulary = "";
                    $(this).find('option').each(function(){
                        if (allCategoriesVocabulary.length > 0) {
                            allCategoriesVocabulary = allCategoriesVocabulary + ",";
                        }
                        allCategoriesVocabulary = allCategoriesVocabulary + this.value;
                        if ($(this).is(':selected')) {
                            if (categoriesVocabulary.length > 0) {
                                categoriesVocabulary = categoriesVocabulary + ",";
                            }
                            categoriesVocabulary = categoriesVocabulary + this.value;
                        }
                    });
                    if (categories.length > 0) {
                        categories = categories + ",";
                    }
                    // si aucune catégorie n'est cochée dans la liste,
                    // on ajoute toutes les catégories de la liste
                    if (categoriesVocabulary.length > 0) {
                        categories = categories + categoriesVocabulary;
                    }else{
                        categories = categories + allCategoriesVocabulary;
                    }
                });

                // Récupération des données concernant les catégories
                if (categories.length > 0) {
                    addCategoriesMarkers(markers, categories, vocabulariesEmptyIds);
                }

                // Récupération des centres d'intérêts à afficher
                var interests = "";
                if (window.isWidgetMode) {
                    interests =  window.interestsCheckedIds;
                } else {
                    var i;
                    for (i = 0; i < ame.$filters_interests.length; i++) {
                        var filter = $(ame.$filters_interests[i]);
                        if (filter.attr('name').indexOf("showFavorites") == -1 && filter.is(':checked')) {
                            if (interests.length > 0) {
                                interests = interests + ",";
                            }
                            interests = interests + filter.attr('value');
                        }
                    }
                }

                // Récupération des données concernant les centres d'intérêt
                if (interests.length > 0) {
                    addInterestsMarkers( markers, interests);
                }

                // Récupération des données concernant les favoris
                if ((window.isWidgetMode && window.showFavoritesByDefault)
                    || (ame.$showFavoritesFilter.length && ame.$showFavoritesFilter.is(':checked'))) {
                    addFavoriteMarkers(markers);
                }

                // Récupération des données concernant le trafic et les alertes
                // uniquement si choisi en configuration
                if (window.showTraffic) {
                	if(window.mode == "normal" ){
                        for (i = 0; i < ame.$filters_categories.length; i++) {
                            var filter = $(ame.$filters_categories[i]);
                            // et si la catégorie choisie est cochée en mode normal ou mon quartier
                            if (filter.attr('value') == window.linkCategoryId && filter.is(':checked')) {
                        		addTraffic(markers);
                        		addAlerts(markers);
                        		break;
                            }
                        }
                        var hasSelect = false;
                        for (i = 0; i < ame.$filters_categories_list.find("option:selected").length; i++) {
                            var filter = $(ame.$filters_categories_list.find("option:selected")[i]);
                            // et si la catégorie choisie est sélectionnée en mode normal ou mon quartier
                            hasSelect = true;
                            if (filter.attr('value') == window.linkCategoryId) {
                                addTraffic(markers);
                                addAlerts(markers);
                                break;
                            }
                        }
                        // ou si aucune sélection n'est faite
                        if (!hasSelect && ame.$filters_categories_list.find("option:selected").length > 0) {
                            addTraffic(markers);
                            addAlerts(markers);
                        }
                	}
                	if(window.mode == "aroundme" ){
                        for (i = 0; i < ame.$filters_interests.length; i++) {
                            var filter = $(ame.$filters_interests[i]);
                            // et si le centre d'intérêt choisi est coché en mode autour de moi
                            if (filter.attr('value') == window.linkInterestId && filter.is(':checked')) {
                        		addTraffic(markers);
                        		addAlerts(markers);
                        		break;
                            }
                        }
                	}
                }
                if (window.mode == "widget" && interests.length > 0) {
                    var interestIds = interests.split(',');
                    for (var i = 0; i < interestIds.length; i++) {
                        if (interestIds[i] === window.linkInterestId) {
                            addTraffic(markers);
                            addAlerts(markers);
                            break;
                        }
                    }
                }

                // Ajout à la map
                mymap.addLayer(markers);
            }

            // Suppression des filtres
            var deleteFilters = function() {
                // Checkbox
                $(ame.$filters_categories).each(function() {
                    $(this).prop('checked',false);
                })

                // liste
                $(ame.$filters_categories_list).each(function() {
                    $(this).val(null).trigger("change");
                });

                // Centres d'intérêts et favoris
                $(ame.$filters_interests).each(function() {
                    $(this).prop('checked',false);
                })

                // Dates
                $(ame.$filters_dates).each(function() {
                    if($(this).attr('name') == "from"){
                        $(this).val(window.fromDate).trigger("change");
                    }else{
                        $(this).val(window.toDate).trigger("change");
                    };
                })
            }


            /**
             *  Interface
             */
            ame.$ui_fullscreen.on('click', function() {
                $('body').toggleClass('aroundme--fullscreen');
                $('html').toggleClass('no-scroll');
                mymap.invalidateSize();
                if (environment == 'desktop') {
                    ame.open_panel_side();
                } else {
                    ame.close_panel_side();
                }
            });
            ame.$ui_zoomin.on('click', function() {
                mymap.zoomIn();
            });
            ame.$ui_zoomout.on('click', function() {
                mymap.zoomOut();
            });
            ame.$ui_locate.on('click', function() {
                moveToUserPosition();
            });
            ame.$ui_home.on('click', function() {
                moveToUserAddress();
            });

            ame.$filters.on('change', function() {
                if(mode != 'normal')
                    saveUserConfig();
                showPois();
            });

            ame.$deleteFilters.on('click', function(event) {
                deleteFilters();
                event.preventDefault();
            });

            $('#mapid').on('click', '.infowindow__close', function() {
                mymap.closePopup();
            });

            // Affichage de la zone
            var coordinatesZone = JSON.parse(window.coordinatesZone);
            if (coordinatesZone.coordinates != undefined) {
                // Récupération des coordonnées de la zone
                requestsInProgress++;
                showLoadingIcon();

                // Convertion des données geoJSON en polygon
                var coordinates = L.geoJson(coordinatesZone, {
                    // Add invert: true to invert the geometries in the GeoJSON file
                    invert: true,
                    style: function (feature) { // Style option
                        return {
                            'weight': 1,
                            'color': '#31455d',
                            'fillColor': 'black',
                            'fillOpacity': 0.2
                        }
                    }
                }).addTo(mymap);

                // centrer la carte sur le quartier
                var bounds = [];
                coordinatesZone.coordinates.forEach(function(zone){
                    if(zone.length == 1)
                        zone = zone[0];
                    zone.forEach(function(coordZone){
                        bounds.push([coordZone[1],coordZone[0]]);
                    });
                });
                mymap.fitBounds(bounds);
                requestsInProgress--;
                maybeHideLoadingIcon();
            }

            function saveUserConfig() {

                //Get form values
                var form = document.getElementById(window.aroundMePortletNamespace+'addItemForm');
                var data = $(form).serializeArray();
                var formData = new FormData(form);
                data.forEach(function(entry){
                    formData.append(entry.name, entry.value);
                });
                var request = new XMLHttpRequest();
                request.open('POST', window.interestPointUrl, true);
                //request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded; charset=UTF-8');

                request.onload = function() {
                    if (this.status >= 200 && this.status < 400) {
                        // Success!
                    }
                    else {
                        // We reached our target server, but it returned an error
                    }
                };
                request.send(formData);
            }

            function showLoadingIcon() {
                $('.aroundme__ui--loading').show();
            }

            function maybeHideLoadingIcon() {
                if (requestsInProgress == 0) {
                    $('.aroundme__ui--loading').hide();
                }
            }

            function moveToUserAddress() {
            	if(window.userAddress == ""){
    		        var agree = function() {
    		        	window.location = window.publikProfileURL;
    		        }
            		createPopinMap(Liferay.Language.get('center-to-address'), agree);
            	}else{
                    Liferay.Service('/strasbourg.strasbourg/get-coordinate-for-address', {
                        address: window.userAddress,
                        zipCode: window.zipCode,
                        city: window.city
                    }, function(data) {
                        var markerIcon = new L.Icon({
                            iconUrl: '/o/mapweb/images/home.png',
                            iconSize: [35,49],
                            iconAnchor: [17, 49]
                        });
                        var homeMarker = L.marker([data[0], data[1]], { icon: markerIcon }).addTo(mymap);
                        mymap = mymap.setView([data[0], data[1]], 18);
                    });
            	}
            }

            function destroyPopinMap(){
                $('#mapConfirm').remove().off('clickmapConfirm');
                $('.mseu').off('click.mapconfirm').removeClass('overlayed');
            }

            function createPopinMap(message, agree){
                var template = '<div id="mapConfirm"> \
                    <div class="mapMessage">##mapMessage##</div> \
                    <div class="mapActions"> \
                        <button class="btn-square--bordered--core deny"><span class="flexbox"><span class="btn-text">Annuler</span><span class="btn-arrow"></span></span></button> \
                        <button class="btn-square--filled--second confirm"><span class="flexbox"><span class="btn-text">Modifier mes informations</span><span class="btn-arrow"></span></span></button> \
                    </div> \
                </div>';

                template = template.replace('##mapMessage##', message);
                $('body').append(template);
                $('.mseu').addClass('overlayed');


                $('#mapConfirm .deny').on('click.mapConfirm', function(e){
                    destroyPopinMap();
                });
                $('#mapConfirm .confirm').on('click.mapConfirm', function(){
                    destroyPopinMap();
                    if(agree !== undefined){
                        agree();
                    }
                });
            }

            function moveToUserPosition() {
                navigator.geolocation.getCurrentPosition(function(position) {
                    var markerIcon = new L.Icon({
                        iconUrl: '/o/mapweb/images/gps.png',
                        iconSize: [35,35],
                        iconAnchor: [12, 12]
                    });
                    var homeMarker = L.marker([position.coords.latitude, position.coords.longitude], { icon: markerIcon }).addTo(mymap);
                    mymap.setView([position.coords.latitude, position.coords.longitude], 18);
                });
            }

            // Scroll sur la liste
            var list = document.getElementsByClassName('filtres--poi')[0];
            list.addEventListener('mouseover', function() {
                mymap.dragging.disable();
                mymap.scrollWheelZoom.disable();
            });
            list.addEventListener('mouseout', function() {
                mymap.dragging.enable();
                mymap.scrollWheelZoom.enable();
            });

            // récupération des alertes gtfs
            var alertsArret = new Array();
            var territoryVocabularyId = -1;
            var placeTypeVocabularyId = -1;
            var eventTypeVocabularyId = -1;
            Liferay.Service(
                '/assetvocabulary/get-groups-vocabularies', {
                    groupIds:[window.globalGroupId]
                },
                function(data) {
                    for (var i = 0; i < data.length; i++) {
                        var vocabulary = data[i];
                        switch (vocabulary.name) {
                            case "Territoire":
                                territoryVocabularyId = vocabulary.vocabularyId;
                                break;
                            case "Type de lieu":
                                placeTypeVocabularyId = vocabulary.vocabularyId;
                                break;
                            case "Type Agenda" :
                                eventTypeVocabularyId = vocabulary.vocabularyId;
                                break;
                        }
                    }

                    if (window.typesContenu.includes("eu.strasbourg.service.gtfs.model.Arret")) {
                        Liferay.Service(
                            '/gtfs.arret/get-alerts', {},
                            function (data) {
                                alertsArret = data;

                                // Affichage des POIs
                                showPois();
                            }
                        );
                    } else {
                        // Affichage des POIs
                        showPois();
                    }
                }
            );
            if (window.isWidgetMode) {
                ame.close_panel_side();
            }
        }
    });

    /**
     * Recuperation des couleurs de lignes
     */
    var ligneColors;
    if(window.typesContenu.includes('eu.strasbourg.service.gtfs.model.Arret')){
        Liferay.Service(
                '/gtfs.ligne/get-ligne-colors',
                {},
                function(json) {
                    ligneColors = json;
                }
        );
    }

    /**
     * Cherche la ligne dans la liste des couleurs de lignes
     */
    function findColors(stopShortName) {
    	for (var i = 0; i < ligneColors.length; i++) {
    	    var ligne = ligneColors[i];
    	    if (ligne.shortName === stopShortName) {
    	    	return ligne;
    	    }
    	}
    }

}(jQuery));