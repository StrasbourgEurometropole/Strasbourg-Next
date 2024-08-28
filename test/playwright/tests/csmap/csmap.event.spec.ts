import {expect, mergeTests} from '@playwright/test';
import helper from '../../helpers/helper'
import {apiHelpersTest} from "../../fixtures/api.helper.test";

export const test = mergeTests(
    apiHelpersTest
)

test.describe.parallel("API Event", () => {

    test('should return a list of events', async ({ apiHelpers }) => {

        const eventRep = await apiHelpers.csmapApi.getEvents().then(res => res.json());

        expect(eventRep).toEqual(helper.containingAddUpdateDelete())
        const events = eventRep.ADD

        const placeExpect = expect.objectContaining({
            accessForBlind: expect.any(Boolean),       // 'accessForBlind' should be a boolean
            accessForDeaf: expect.any(Boolean),        // 'accessForDeaf' should be a boolean
            accessForWheelchair: expect.any(Boolean),  // 'accessForWheelchair' should be a boolean
            accessForDeficient: expect.any(Boolean),   // 'accessForDeficient' should be a boolean
            accessForElder: expect.any(Boolean),        // 'accessForElder' should be a boolean
            name: helper.containingLocaleString()
        })

        expect(events).toEqual(expect.arrayContaining(
            [
                expect.objectContaining(
                    {
                        id: expect.any(String),
                        description: helper.containingLocaleString(),
                        title: helper.containingLocaleString(),
                        websiteName: helper.containingLocaleString(),
                        websiteURL: helper.containingLocaleString(),
                        price: helper.containingLocaleString(),
                        place: placeExpect
                    }
                )
            ]
        ))
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