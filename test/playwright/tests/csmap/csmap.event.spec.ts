import {expect, mergeTests} from '@playwright/test';
import helper from '../../helpers/helper'
import {apiHelpersTest} from "../../fixtures/api.helper.test";
import {schemaHelpersTest} from "../../fixtures/schema.helper.test";

export const test = mergeTests(
    apiHelpersTest,
    schemaHelpersTest
)

test.describe.parallel("API Event", () => {

    test('should return a list of events', async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getEvents()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateEventSchema(jsonResponse)
        expect(valid).toBeTruthy()
    });

    test('should return a list of agendas', async ({ apiHelpers , schemaHelpers}) => {
        const response = await apiHelpers.csmapApi.getAgendas()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateAgendaSchema(jsonResponse)
        expect(valid).toBeTruthy()

    });

    test("should return a list of themes", async ({ apiHelpers , schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getThemes()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateTypeEventSchema(jsonResponse)
        expect(valid).toBeTruthy()

    })


    test("should return a list of types of event", async ({ apiHelpers , schemaHelpers}) => {
        const response = await apiHelpers.csmapApi.getTypes()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateTypeEventSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

});