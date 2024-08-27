import {test, expect} from '@playwright/test';
import helper from '../helper'

test.describe("API Event", () => {

    test('should return a list of events', async ({request}) => {

        const eventRep = await request.get(`/o/csmap-ws/event/get-events`).then(res => res.json());

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

    test('should return a list of agendas', async ({request}) => {

        const agendaRep = await request.get(`/o/csmap-ws/event/get-agendas`).then(res => res.json());

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

});