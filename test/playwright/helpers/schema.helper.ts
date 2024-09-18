import Ajv from 'ajv';
import addFormats from "ajv-formats"
import generalConditionSchema from '../../../modules/csmap/csmap-schemas/various-data/general-condition-schema.json';
import accessibilitySchema from '../../../modules/csmap/csmap-schemas/various-data/accessibility-schema.json';
import newsSchema from '../../../modules/csmap/csmap-schemas/various-data/news-schema.json';
import emergencySchema from '../../../modules/csmap/csmap-schemas/various-data/emergency-schema.json';
import socialNetworkSchema from '../../../modules/csmap/csmap-schemas/various-data/social-network-schema.json';
import stopScheduleSchema from '../../../modules/csmap/csmap-schemas/transport/stop-schedule-schema.json';
import transportSchema from '../../../modules/csmap/csmap-schemas/transport/transport-schema.json';
import alertSchema from '../../../modules/csmap/csmap-schemas/transport/alert-schema.json';
import placeTerritorySchema from '../../../modules/csmap/csmap-schemas/place/place-territory-schema.json';
import placePOISchema from '../../../modules/csmap/csmap-schemas/place/place-poi-schema.json';
import placeCategorySchema from '../../../modules/csmap/csmap-schemas/place/place-category-schema.json';
import scheduleSchema from '../../../modules/csmap/csmap-schemas/place/schedule-schema.json';
import placeSchema from '../../../modules/csmap/csmap-schemas/place/place-schema.json';
import typeEventSchema from '../../../modules/csmap/csmap-schemas/event/type-event-schema.json';
import agendaSchema from '../../../modules/csmap/csmap-schemas/event/agenda-schema.json';
import eventSchema from '../../../modules/csmap/csmap-schemas/event/event-schema.json';
import definitionSchema from '../../../modules/csmap/csmap-schemas/definitions/definitions.json';
export class SchemaHelpers {

    readonly ajv: Ajv;

    constructor() {
        this.ajv = new Ajv({
            allErrors: true, verbose: true,
            schemas: [
                newsSchema,
                emergencySchema,
                socialNetworkSchema,
                generalConditionSchema,
                accessibilitySchema,
                stopScheduleSchema,
                transportSchema,
                alertSchema,
                placeTerritorySchema,
                placePOISchema,
                placeCategorySchema,
                scheduleSchema,
                placeSchema,
                typeEventSchema,
                agendaSchema,
                eventSchema,
                definitionSchema
            ],
        });
        addFormats(this.ajv);
    }

    validateSchema(schema: string, data: any) {
        const validate = this.ajv.getSchema(schema)
        const valid = validate(data);
        if (!valid) {
            console.error(validate.errors);
            return false;
        }
        return true
    }

    validateEventSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/event-schema.json", data);
    }

    validateAgendaSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/agenda-schema.json", data);
    }

    validateTypeEventSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/type-event-schema.json", data);
    }

    validatePlaceSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/place-schema.json", data);
    }

    validateScheduleSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/schedule-schema.json", data);
    }

    validatePlaceCategorySchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/place-category-schema.json", data);
    }

    validatePlacePOISchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/place-poi-schema.json", data);
    }

    validatePlaceTerritorySchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/place-territory-schema.json", data);
    }

    validateStopScheduleSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/stop-schedule-schema.json", data);
    }

    validateAlertSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/alert-schema.json", data);
    }

    validateTransportSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/transport-schema.json", data);
    }

    validateGeneralConditionsSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/general-condition-schema.json", data);
    }

    validateAccessibilitySchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/accessibility-schema.json", data);
    }

    validateNewsSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/news-schema.json", data);
    }

    validateEmergencySchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/emergency-schema.json", data);
    }

    validateSocialNetworkSchema(data: any) {
        return this.validateSchema("https://strasbourg.eu/schemas/social-network-schema.json", data);
    }
}
