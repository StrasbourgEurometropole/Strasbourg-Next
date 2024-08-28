import {expect, mergeTests} from '@playwright/test';
import helper from "../../helpers/helper";
import {apiHelpersTest} from "../../fixtures/api.helper.test";

export const test = mergeTests(
    apiHelpersTest
)

test.describe.parallel("API Transport", () => {

    test("should return the schedule of a stop (Homme de fer)", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getTransportSchedule("275D", 0)

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

    test("should return alerts of the transport network", async ({ apiHelpers }) => {
        const rep = await apiHelpers.csmapApi.getTransportAlerts()

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

    test("should return the list of stops", async ({ apiHelpers }) => {

        const rep = await apiHelpers.csmapApi.getTransports()

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