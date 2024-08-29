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

    test('should return a list of agendas', async ({ apiHelpers }) => {

        const agendaRep = await apiHelpers.csmapApi.getAgendas().then(res => res.json());

        if (agendaRep.principal) {
            expect(agendaRep.principal).toEqual(
                expect.objectContaining({
                        ids: expect.any(Array)
                    }
                )
            )
        }

        if (agendaRep.thematique) {
            expect(agendaRep.thematique).toEqual(
                expect.objectContaining({
                    ids: expect.any(Array),
                    title: helper.containingLocaleString(),
                    subtitle: helper.containingLocaleString(),
                    imageURL: expect.any(String)
                })
            )
        }

    });

    test("should return a list of themes", async ({ apiHelpers }) => {
        const req = await apiHelpers.csmapApi.getThemes();
        expect(req.ok()).toBeTruthy();
        const rep = await req.json();
        expect(rep).toEqual(helper.containingAddUpdateDelete())
        const themes = rep.ADD

        expect(themes).toEqual(expect.arrayContaining(
            [
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        name: helper.containingLocaleString()
                    }
                )
            ]
        ))

    })


    test("should return a list of types of event", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getTypes().then(res => res.json());
        expect(rep).toEqual(helper.containingAddUpdateDelete())
        const types = rep.ADD
        expect(types).toEqual(expect.arrayContaining(
            [
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        name: helper.containingLocaleString()
                    }
                )
            ]
        ))



    })

});