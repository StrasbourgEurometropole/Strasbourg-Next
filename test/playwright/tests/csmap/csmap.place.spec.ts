import { expect, mergeTests} from '@playwright/test';
import helper from '../../helpers/helper'
import {apiHelpersTest} from "../../fixtures/api.helper.test";
import {schemaHelpersTest} from "../../fixtures/schema.helper.test";

export const test = mergeTests(
    apiHelpersTest,
    schemaHelpersTest
)

test.describe.parallel("API Place", () => {
    test('should return a list of places', async ({ apiHelpers , schemaHelpers}) => {

        const response = await apiHelpers.csmapApi.getPlaces()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validatePlaceSchema(jsonResponse)
        expect(valid).toBeTruthy()

    });

    test("should return the schedule of a place (462_SPC_38)", async ({ apiHelpers,schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getPlaceSchedule("462_SPC_38")
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateScheduleSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return the categories", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getPlaceCategories()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validatePlaceCategorySchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return the points of interest", async ({ apiHelpers , schemaHelpers}) => {
        const response = await apiHelpers.csmapApi.getPlacePOIs()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validatePlacePOISchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return the terroitories", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getPlaceTerritories()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validatePlaceTerritorySchema(jsonResponse)
        expect(valid).toBeTruthy()
    })


})