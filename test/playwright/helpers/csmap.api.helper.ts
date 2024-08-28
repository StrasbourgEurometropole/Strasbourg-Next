
import {ApiHelpers} from './api.helper';

export class CsmapApiHelper {
    readonly apiHelpers: ApiHelpers;
    readonly basePath: string;

    constructor(apiHelpers: ApiHelpers) {
        this.apiHelpers = apiHelpers;
        this.basePath = '/o/csmap-ws/';
    }

    // Events

    async getEvents(lastUpdateTime: Number = 0) {
        return this.apiHelpers.getResponse(this.basePath  + "event/get-events/" + lastUpdateTime);
    }

    async getAgendas(lastUpdateTime: Number = 0) {
        return this.apiHelpers.getResponse(this.basePath  + "event/get-agendas/" + lastUpdateTime);
    }

    async getThemes(lastUpdateTime: Number = 0, themeIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath  + "event/get-themes/" + lastUpdateTime, {
            form: {
                ids_theme: themeIds.join(',')
            }
        });
    }

    async getTypes(lastUpdateTime: Number = 0, typeIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath  + "event/get-types/" + lastUpdateTime, {
            form: {
                ids_type: typeIds.join(',')
            }
        });
    }

    // Places

    async getPlaces(lastUpdateTime: Number = 0) {
        return this.apiHelpers.getResponse(this.basePath  + "place/get-places/" + lastUpdateTime);
    }

    async getPlaceSchedule(idSurfs: String) {
        return this.apiHelpers.getResponse(this.basePath  + "place/get-hours/" + idSurfs);
    }

    async getPlaceCategories(lastUpdateTime: Number = 0, categoryIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath  + "place/get-categories/" + lastUpdateTime, {
            form: {
                ids_category: categoryIds.join(',')
            }
        });
    }

    async getPlacePOIs(lastUpdateTime: Number = 0, poiIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath  + "place/get-simple-pois/" + lastUpdateTime, {
            form: {
                ids_simple_poi: poiIds.join(',')
            }
        });
    }

    async getPlaceTerritories(lastUpdateTime: Number = 0, territoryIds : Array<Number> = []) {
       return this.apiHelpers.postResponse(this.basePath  + "place/get-territoires/" + lastUpdateTime, {
         form: {
             ids_territoires: territoryIds.join(',')
         }
       })
    };

    // Transport

    async getTransportSchedule(stopCode: string, typeStop: 0 | 3) {
        return this.apiHelpers.getResponse(this.basePath  + "transport/get-hours/" + stopCode + "/" + typeStop);
    }

    async getTransportAlerts() {
        return this.apiHelpers.getResponse(this.basePath  + "transport/get-alerts");
    }

    async getTransports(lastUpdateTime: Number = 0, stopIds : Array<Number> = [], lineIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath  + "transport/get-transports/" + lastUpdateTime, {
            form: {
                ids_stop: stopIds.join(','),
                ids_line: lineIds.join(',')
            }
        });
    }

    // Various data

    async getGeneralConditions(lastUpdateTime: Number = 0) {
        return this.apiHelpers.getResponse(this.basePath  + "various-data/get-general-conditions/" + lastUpdateTime);
    }

    async getAccessibilities(lastUpdateTime: Number = 0) {
        return this.apiHelpers.getResponse(this.basePath  + "various-data/get-accessibility/" + lastUpdateTime);
    }

    async getNews(lastUpdateTime: Number = 0, newsIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath + "various-data/get-news/" + lastUpdateTime, {
            form: {
                ids_news: newsIds.join(',')
            }
        });
    }

    async getEmergencies(lastUpdateTime: Number = 0, emergencyNumberIds : Array<Number> = [], emergencyCategoryIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath + "various-data/get-emergencies/" + lastUpdateTime, {
            form: {
                ids_emergency_number: emergencyNumberIds.join(','),
                ids_emergency_help_category: emergencyCategoryIds.join(',')
            }
        });
    }

    async getSocialNetworks(lastUpdateTime: Number = 0, socialNetworkIds : Array<Number> = []) {
        return this.apiHelpers.postResponse(this.basePath + "various-data/get-social-networks/" + lastUpdateTime, {
            form: {
                ids_social_network: socialNetworkIds.join(',')
            }
        });
    }

}