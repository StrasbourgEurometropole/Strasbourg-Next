import {expect, mergeTests} from '@playwright/test';
import helper from "../../helpers/helper";
import {apiHelpersTest} from "../../fixtures/api.helper.test";
import {schemaHelpersTest} from "../../fixtures/schema.helper.test";

export const test = mergeTests(
    apiHelpersTest,
    schemaHelpersTest
)

test.describe.parallel("API Transport", () => {

    test("should return the schedule of a stop (Homme de fer)", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getTransportSchedule("275D", 0)
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateStopScheduleSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return alerts of the transport network", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getTransportAlerts()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateAlertSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return the list of stops", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getTransports()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateTransportSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

})