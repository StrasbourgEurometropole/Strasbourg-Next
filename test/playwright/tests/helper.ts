import {expect} from "@playwright/test";
export default class helper {
    static containingLocaleString () {
        return expect.objectContaining({
            fr_FR: expect.any(String)
        })
    }

    static containingAddUpdateDelete () {
        return expect.objectContaining(
            {
                ADD: expect.any(Array),
                UPDATE: expect.any(Array),
                DELETE: expect.any(Array),
                responseCode: 200
            }
        )
    }
}