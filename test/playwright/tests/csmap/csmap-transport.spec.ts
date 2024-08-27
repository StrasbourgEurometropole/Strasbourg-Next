import {test, expect} from '@playwright/test';
import helper from "../helper";

test.describe("API Transport", () => {

    test("should return the schedule of a stop (Homme de fer)", async ({ request }) => {
        const rep = await request.get(`/o/csmap-ws/transport/get-hours/275D/0`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(expect.objectContaining(
            {
                responseCode: 200,
                schedules: expect.any(Array)
            }
        ))

        expect(body.schedules).toEqual(expect.arrayContaining(
            [
                expect.objectContaining({
                    lineNumber: expect.any(String),
                    destinationName: expect.any(String),
                    departureTime: helper.stringMatchingDateTime()
                })
            ]
        ))


    })

    test("should return alerts of the transport network", async ({ request }) => {
        const rep = await request.get(`/o/csmap-ws/transport/get-alerts`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(expect.objectContaining(
            {
                responseCode: 200,
                alerts: expect.any(Array)
            }
        ))

        expect(body.alerts).toEqual(expect.arrayContaining(
            [
                expect.objectContaining({
                    linesNumber: expect.any(Array),
                    startDate: helper.stringMatchingDateTime(),
                    endDate: helper.stringMatchingDateTime(),
                    title: helper.containingLocaleString(),
                    period: helper.containingLocaleString(),
                    details: helper.containingLocaleString()
                })
            ]
        ))
    })

    test("should return the list of stops", async ({ request }) => {

        const rep = await request.post(`/o/csmap-ws/transport/get-transports`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(expect.objectContaining(
            {
                responseCode: 200,
                stops: helper.containingAddUpdateDelete(),
                lines: helper.containingAddUpdateDelete()
            }
        ))

        expect(body.stops.ADD).toEqual(expect.arrayContaining(
            [
                expect.objectContaining({
                    stopId: expect.any(String),
                    stopCode: expect.any(String),
                    type: expect.any(Number),
                    title: expect.any(String),
                    mercatorX: expect.any(String),
                    mercatorY: expect.any(String),
                    lines: expect.any(Array)
                })
            ]
        ))

    })

})