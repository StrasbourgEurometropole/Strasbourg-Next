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

    test("should return the categories", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getPlaceCategories().then(res => res.json());
        expect(rep).toEqual(helper.containingAddUpdateDelete())
        const categories = rep.ADD
        expect(categories).toEqual(
            expect.arrayContaining([
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        name: helper.containingLocaleString(),
                        color_gradient: expect.objectContaining(
                            {
                                start: expect.stringMatching("^#[0-9A-Fa-f]{6}$"),
                                end: expect.stringMatching("^#[0-9A-Fa-f]{6}$")
                            }),
                        parentId: expect.any(String),
                        picto: expect.objectContaining(
                            {
                                pictoURL: expect.stringMatching("^https://"),
                                maj: expect.any(Boolean)
                            }
                        )

                    }
                )
            ])
        )
    })

    test("should return the points of interest", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getPlacePOIs().then(res => res.json());
        expect(rep).toEqual(helper.containingAddUpdateDelete())

        const pois = rep.ADD
        expect(pois).toEqual(
            expect.arrayContaining([
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        name: helper.containingLocaleString(),
                        openDataURL: expect.stringMatching("^https://"),
                        picto: expect.objectContaining(
                            {
                                pictoURL: expect.stringMatching("^https://"),
                                maj: expect.any(Boolean)
                            }),
                        types: expect.any(Array)
                    }
                )
            ])
        )
    })

    test("should return the terroitories", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getPlaceTerritories().then(res => res.json());
        expect(rep).toEqual(helper.containingAddUpdateDelete())

        const territories = rep.ADD
        expect(territories).toEqual(
            expect.arrayContaining([
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        name: helper.containingLocaleString(),
                        parentId: expect.any(String)
                    }
                )
            ])
        )
    })


})