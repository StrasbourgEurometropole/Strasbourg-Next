import {test, expect} from '@playwright/test';
import helper from '../helper'
test.describe("API Place", () => {
    test('should return a list of places', async ({request}) => {

        const placesRep = await request.get(`/o/csmap-ws/place/get-places`).then(res => res.json());

        expect(placesRep).toEqual(helper.containingAddUpdateDelete())
        const places = placesRep.ADD

        expect(places).toEqual(
            expect.arrayContaining([
                expect.objectContaining(
                    {
                        idSurs: expect.any(String),
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
            ])

        )

    });

    test("should return the schedule of a place (462_SPC_38)", async ({request}) => {
        // We test the schedule of centre administratif
        const scheduleRep = await request.get(`/o/csmap-ws/place/get-hours/462_SPC_38`).then(res => res.json());
        expect(scheduleRep).toEqual(
            expect.objectContaining(
                {
                    schedules: expect.any(Array),
                    responseCode: 200
                }
            )
        )

        const schedules = scheduleRep.schedules
        expect(schedules).toEqual(
            expect.arrayContaining([
                expect.objectContaining(
                    {
                        alwaysOpen: expect.any(Boolean),
                        isClosed: expect.any(Boolean),
                        date: expect.any(String),
                        hours: expect.arrayContaining(
                            [
                                expect.objectContaining({
                                    startHour: expect.stringMatching("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$"),
                                    endHour: expect.stringMatching("^(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]$")
                                })
                            ]
                        )
                    }
                )
            ])
        )

    })

    test("should return the categories", async ({request}) => {
        const rep = await request.post(`/o/csmap-ws/place/get-categories/`).then(res => res.json());
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

    test("should return the points of interest", async ({request}) => {
        const rep = await request.post(`/o/csmap-ws/place/get-simple-pois/`).then(res => res.json());
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

    test("should return the terroitories", async ({request}) => {
        const rep = await request.post(`/o/csmap-ws/place/get-territoires/`).then(res => res.json());
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