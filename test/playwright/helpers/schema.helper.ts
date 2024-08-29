import Ajv from 'ajv';
import addFormats from "ajv-formats"
import eventSchema from '../../../modules/csmap/csmap-schemas/event/event-schema.json';
import definitionSchema from '../../../modules/csmap/csmap-schemas/definitions/definitions.json';
export class SchemaHelpers {

    readonly ajv: Ajv;

    constructor() {
        this.ajv = new Ajv({
            allErrors: true, verbose: true,
            schemas: [eventSchema, definitionSchema],
        });
        addFormats(this.ajv);
    }

    validateEventSchema(data: any) {
        const validate = this.ajv.getSchema("https://strasbourg.eu/schemas/event-schema.json")
        const valid = validate(data);
        if (!valid) {
            console.error(validate.errors);
            return false;
        }
        return true

    }

}
