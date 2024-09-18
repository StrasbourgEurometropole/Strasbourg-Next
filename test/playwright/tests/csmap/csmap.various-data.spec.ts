import {expect, mergeTests} from '@playwright/test';
import helper from "../../helpers/helper";
import {apiHelpersTest} from "../../fixtures/api.helper.test";
import {schemaHelpersTest} from "../../fixtures/schema.helper.test";

export const test = mergeTests(
    apiHelpersTest,
    schemaHelpersTest
)

test.describe.parallel('API Various Data', () => {
    test("should return general conditions", async ({ apiHelpers, schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getGeneralConditions()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateGeneralConditionsSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return accessibilities", async ({ apiHelpers , schemaHelpers }) => {

        const response = await apiHelpers.csmapApi.getAccessibilities()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateAccessibilitySchema(jsonResponse)
        expect(valid).toBeTruthy()

    })

    test("should return news" , async ({ apiHelpers , schemaHelpers }) => {

        const response = await apiHelpers.csmapApi.getNews()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateNewsSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })

    test("should return emergency numbers" , async ({ apiHelpers , schemaHelpers }) => {

        const response = await apiHelpers.csmapApi.getEmergencies()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateEmergencySchema(jsonResponse)
        expect(valid).toBeTruthy()

    })

    test("should return social networks" , async ({ apiHelpers , schemaHelpers }) => {
        const response = await apiHelpers.csmapApi.getSocialNetworks()
        expect(response.ok()).toBeTruthy()
        const jsonResponse = await response.json()
        const valid = schemaHelpers.validateSocialNetworkSchema(jsonResponse)
        expect(valid).toBeTruthy()
    })
});