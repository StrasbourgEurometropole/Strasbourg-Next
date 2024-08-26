import {test, expect} from '@playwright/test';
import helper from '../helper'

test('should return a list of places', async ({ request }) => {

    const placesRep = await request.get(`/o/csmap-ws/place/get-places`).then(res => res.json());

    expect(placesRep).toEqual(helper.containingAddUpdateDelete())

    const randomIndex = Math.floor(Math.random() * placesRep.ADD.length);
    const place = placesRep.ADD[randomIndex]

    expect(place).toEqual(
        expect.objectContaining(
            {
                idSurfs: expect.any(String),
                types: expect.any(Array),
                name: helper.containingLocaleString(),
                mercatorX: expect.any(String),
                mercatorY: expect.any(String),
                accessForDeficient: expect.any(Boolean),
                accessForElder: expect.any(Boolean),
                accessForBlind: expect.any(Boolean),
                accessForWheelchair: expect.any(Boolean),
                accessForDeaf: expect.any(Boolean),
                friendlyURL: expect.any(String)
            }
        )
    )

});