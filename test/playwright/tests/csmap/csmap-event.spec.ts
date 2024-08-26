import {test, expect} from '@playwright/test';
import helper from '../helper'

test('should return a list of events', async ({request}) => {

    const eventRep = await request.get(`/o/csmap-ws/event/get-events`).then(res => res.json());

    expect(eventRep).toEqual(helper.containingAddUpdateDelete())

    const randomIndex = Math.floor(Math.random() * eventRep.ADD.length);
    const event = eventRep.ADD[randomIndex]
    // Check the 'description' object contains a 'fr_FR' key with a string value
    expect(event.description).toEqual(helper.containingLocaleString());

// Check the 'title' object contains a 'fr_FR' key with a string value
    expect(event.title).toEqual(helper.containingLocaleString());

    if (event.websiteName) {
        expect(event.websiteName).toEqual(helper.containingLocaleString());
    }

    if (event.websiteURL) {
        expect(event.websiteURL).toEqual(helper.containingLocaleString());
    }

    if (event.price) {
        expect(event.price).toEqual(helper.containingLocaleString());
    }

    expect(event.place).toEqual(expect.objectContaining({
        accessForBlind: expect.any(Boolean),       // 'accessForBlind' should be a boolean
        accessForDeaf: expect.any(Boolean),        // 'accessForDeaf' should be a boolean
        accessForWheelchair: expect.any(Boolean),  // 'accessForWheelchair' should be a boolean
        accessForDeficient: expect.any(Boolean),   // 'accessForDeficient' should be a boolean
        accessForElder: expect.any(Boolean),        // 'accessForElder' should be a boolean
        name: helper.containingLocaleString()
    }));
});

test('should return a list of agendas', async ({request}) => {

    const agendaRep = await request.get(`/o/csmap-ws/event/get-agendas`).then(res => res.json());

    if(agendaRep.principal) {
        expect(agendaRep.principal).toEqual(
            expect.objectContaining( {
                ids: expect.any(Array)
            }
            )
        )
    }

    if(agendaRep.thematique) {
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