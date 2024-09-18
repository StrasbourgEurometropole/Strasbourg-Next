import {expect, Page} from "@playwright/test";
export default class helper {
    static containingLocaleString () {
        return expect.objectContaining({
            fr_FR: expect.any(String)
        })
    }

    static stringMatchingDateTime () {
        // Spec ISO 8601
        return expect.stringMatching("^([\\+-]?\\d{4}(?!\\d{2}\\b))((-?)((0[1-9]|1[0-2])(\\3([12]\\d|0[1-9]|3[01]))?|W([0-4]\\d|5[0-2])(-?[1-7])?|(00[1-9]|0[1-9]\\d|[12]\\d{2}|3([0-5]\\d|6[1-6])))([T\\s]((([01]\\d|2[0-3])((:?)[0-5]\\d)?|24\\:?00)([\\.,]\\d+(?!:))?)?(\\17[0-5]\\d([\\.,]\\d+)?)?([zZ]|([\\+-])([01]\\d|2[0-3]):?([0-5]\\d)?)?)?)?$")

    }

    static containingAddUpdateDelete () {
        return expect.objectContaining(
            {
                ADD: expect.any(Array),
                UPDATE: expect.any(Array),
                DELETE: expect.any(Array)
            }
        )
    }

    static async login(page : Page) {
        await page.goto('/web/guest')
        await page.getByRole('button', {name: 'Ouvrir une session'}).click()
        await page.getByLabel('Adresse email').fill('thomas.tse@sully-group.com')
        await page.getByLabel('Mot de passe').fill('test')
        await page.getByLabel('Se souvenir de moi').check()
        await page.getByLabel('Authentification').getByRole('button', { name: 'Ouvrir une session' }).click()
    }
}