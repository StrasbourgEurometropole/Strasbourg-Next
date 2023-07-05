class thListingMap {

    map = null;
    cards = {};
    markers = {};
    bounds = [];
    cluster = null;
    popins = {};
    timeoutUpdate = null;
    markerBounds = null;
    isMobile = false;

    options = {
        selector: null,
        breakpointMobile: 980,
        markerIcon: 'default',
        markerIconHover: 'default',
        markerWidth: 300,
        layersMaxZoom: 18,
        useCluster: false,
        onlyMobile: false,
        onlyDesktop: false,
    };

    constructor(options) {

        options = $.extend(true, this.options, options);
        this.options = options;

        if (this.options.selector === null) {
            return;
        }

        if (document.body.clientWidth < this.options.breakpointMobile) {
            this.is_mobile = true;
        }

        var initmap = false;

        // on veut sur mobile et desktop du coup on se moque de savoir si on es sur mobile
        if (!this.options.onlyMobile && !this.options.onlyDesktop) {
            initmap = true;
        } else {
            if (this.options.onlyMobile) {
                if (this.is_mobile) {
                    initmap = true;
                }
            }
            if (this.options.onlyDesktop) {
                if (!this.is_mobile) {
                    initmap = true;
                }
            }
        }

        if (initmap) {
            this.initMap();
        }

    }

    initMap() {
        if (document.querySelector(this.options.selector)) {
            this.map = th_maps.initSingleMap(document.querySelector(this.options.selector));
        }
    }

    setCards($cards) {

        if (!this.map) {
            return;
        }

        var that = this;

        var cards = {};
        $cards.each(function () {
            var lat = this.getAttribute('data-lat') * 1;
            var lng = this.getAttribute('data-lng') * 1;
            if (lat != 0 && lng != 0) {

                var card = {
                    id: this.getAttribute('data-id'),
                    lat: lat,
                    lng: lng,
                    html: this.outerHTML.replace('data-src', 'src').replace('lazy', ''),
                };

                cards[this.getAttribute('data-id')] = card;

                $(this).on('mouseover', (e) => that.setMarkerState(that.markers[card.id], 'hover'));
                $(this).on('mouseout', (e) => that.setMarkerState(that.markers[card.id], 'default'));
            }
        });

        delete cards.null;

        this.cards = cards;
    }

    update() {

        if (!this.map) {
            return;
        }

        this.emptyMap();

        var cards = this.cards;
        var that = this;

        clearTimeout(this.timeoutUpdate);
        if (!this.map) {
            setTimeout(function () {
                this.update(cards);
            }, 500);
            return false;
        }

        if (this.isMobile) {
            fm._obj.mobileSliderManager = new mapSliderMarkerMobile(fm._map.map);
            fm._obj.mobileSliderManager.setIndexDataName('id');
            fm._obj.mobileSliderManager.init($('.js-listing-overlay-card-container'));
            fm._map.map = fm._obj.mobileSliderManager.map;
            fm._map.markerBounds = fm._obj.mobileSliderManager.markerBounds;
        } else {

            this.map._layersMaxZoom = this.options.layersMaxZoom;

            if (!this.options.useCluster) {
                $.each(cards, function (k, card) {
                    var marker = that.getMarker(card);
                    that.map.addLayer(marker);
                    that.bounds.push(marker.getLatLng());
                });

                this.markerBounds = L.latLngBounds(this.bounds);
            } else {

                this.cluster = L.markerClusterGroup({
                    showCoverageOnHover: false,
                    maxClusterRadius: function (mapZoom) {
                        if (mapZoom > 9) {
                            return 20;
                        } else {
                            return 80;
                        }
                    },
                });

                $.each(cards, function (k, card) {
                    that.cluster.addLayer(that.getMarker(card));
                });

                this.map.addLayer(this.cluster);
            }

        }

        setTimeout(() => {
            this.fitMap();

        }, 250);
    }

    emptyMap() {
        var that = this;

        if (this.options.useCluster) {
            that.hideCluster();
        }

        if (Object.keys(this.markers).length > 0) {
            $.each(this.markers, function (k, marker) {
                that.map.removeLayer(marker);
            })
            this.markers.bounds = [];
        }
    }

    fitMap() {

        if (this.map) {

            this.map.invalidateSize();

            if (!this.options.useCluster) {
                this.map.fitBounds(this.markerBounds, {padding: [25, 25]});
            } else {

                var cluster_bounds = this.cluster.getBounds();
                if (typeof cluster_bounds._southWest !== 'undefined') {
                    this.map.fitBounds(cluster_bounds, {padding: [25, 25]});
                }
            }

            if (this.map.getZoom() >= thConfig.map.init.tileLayerOptions.maxZoom) {
                this.map.setZoom(15);
            }
        }

    }

    getMarker(card) {
        if (!this.markers[card.id]) {
            this.createMarker(card);
        }
        return this.markers[card.id];
    }

    createMarker(card) {

        this.markers[card.id] = th_maps.createMarker(this.map, {lat: card.lat, lng: card.lng}, this.options.markerIcon);
        const marker = this.markers[card.id];

        marker.on('click', () => {
            // if (fm.callbacks.onClickMarker) {
            //     fm.callbacks.onClickMarker(card.id, marker, card);
            // }
        });
        marker.addEventListener('mouseover', () => this.setMarkerState(marker, 'hover'));
        marker.addEventListener('mouseout', () => this.setMarkerState(marker, 'default'));

        this.bounds.push(marker.getLatLng());

        var card_html = '';

        if (!this.isMobile) {
            card_html = card.html;
            // card_html = '<div class="card-wrapper">' + card.html + '</div>';
            card_html = card_html.replace('src="data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7', '');
            this.popins[card.id] = th_maps.createInfoWindow(card_html, marker, this.markerWidth);
        }
    }

    // Change l'état d'un marker
    setMarkerState(marker, state) {
        if (state === 'hover') {
            marker.setIcon(th_maps.markersIcons[this.options.markerIconHover]);
            marker.setZIndexOffset(1000);        // passe le marker au-dessus des autres
        } else {
            marker.setIcon(th_maps.markersIcons[this.options.markerIcon]);
            marker.setZIndexOffset(0);
        }
    }

    hideCluster() {
        if (!this.map) {
            return null;
        }

        if (this.cluster) {
            this.map.removeLayer(this.cluster);
        }
    }


}
