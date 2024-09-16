import Ajv from 'ajv';
import addFormats from "ajv-formats"
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
            schemas: [placeCategorySchema, scheduleSchema, placeSchema ,typeEventSchema, agendaSchema, eventSchema, definitionSchema],
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

}
