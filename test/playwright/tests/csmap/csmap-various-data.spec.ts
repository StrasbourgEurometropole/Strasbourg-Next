import {test, expect} from '@playwright/test';
import helper from "../helper";

test.describe('API Various Data', () => {
    test("should return general conditions", async ({request}) => {

        const rep = await request.get(`/o/csmap-ws/various-data/get-general-conditions/`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(expect.objectContaining(
            {
                responseCode: 200,
                ADD: expect.any(Object),
                UPDATE: expect.any(Object)
            }
        ))

        expect(body.ADD).toEqual(expect.objectContaining(
            {
                text: helper.containingLocaleString()
            }
        ))
    })

    test("should return accessibilities", async ({request}) => {

        const rep = await request.get(`/o/csmap-ws/various-data/get-accessibility/`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(expect.objectContaining(
            {
                responseCode: 200,
                ADD: expect.any(Object),
                UPDATE: expect.any(Object)
            }
        ))

        expect(body.ADD).toEqual(expect.objectContaining(
            {
                text: helper.containingLocaleString()
            }
        ))

    })

    test("should return news" , async ({request}) => {

        const rep = await request.post(`/o/csmap-ws/various-data/get-news/`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(helper.containingAddUpdateDelete())

        expect(body.ADD).toEqual(expect.arrayContaining([
            expect.objectContaining(
                {
                    id: expect.any(String),
                    date : expect.any(String),
                    title: helper.containingLocaleString(),
                    subtitle: helper.containingLocaleString(),
                    description: helper.containingLocaleString(),
                    url: expect.any(String)
                })
        ]))

    })

    test("should return emergency numbers" , async ({request}) => {

        const rep = await request.post(`/o/csmap-ws/various-data/get-emergencies/`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(helper.containingAddUpdateDelete())

        expect(body.ADD).toEqual(expect.arrayContaining([
            expect.objectContaining(
                {
                    emergencyNumbers: expect.arrayContaining([
                        expect.objectContaining({
                            id: expect.any(String),
                            title: helper.containingLocaleString(),
                            order: expect.any(String),
                            number: expect.any(String),
                            color: expect.objectContaining({
                                fontColor: expect.any(String), //TODO HEX
                                backgroundColor: expect.any(String), //TODO HEX
                            })
                        })
                    ]),
                    emergencyHelps: expect.arrayContaining([
                        expect.objectContaining({
                            categoryId: expect.any(String),
                            categoryOrder: expect.any(Number),
                            categoryTitle: helper.containingLocaleString(),
                            categoryContent: expect.arrayContaining([
                                expect.objectContaining({
                                    title: helper.containingLocaleString(),
                                    number: expect.any(String),
                                    order: expect.any(String),
                                })
                            ])
                        })
                        ])
                })
        ]))

    })

    test("should return social networks" , async ({request}) => {

        const rep = await request.post(`/o/csmap-ws/various-data/get-social-networks/`)

        expect(rep.ok()).toBeTruthy()

        const body = await rep.json()

        expect(body).toEqual(helper.containingAddUpdateDelete())

        expect(body.ADD).toEqual(expect.arrayContaining([
            expect.objectContaining(
                {
                   id: expect.any(String),
                    title: helper.containingLocaleString(),
                    order: expect.any(Number),
                    url: expect.any(String),
                    picto: expect.any(String),
                    color: expect.any(String)   // TODO HEX COLOR
                })
        ]))

    })
});