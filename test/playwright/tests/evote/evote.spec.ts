import { test, expect, Page } from '@playwright/test';
import helper from '../../helpers/helper';
import {EvoteConseilListingPage} from "../../pages/evote/evote-conseil-listing-page";
import {EvoteConseilEditPage} from "../../pages/evote/evote-conseil-edit-page";


test.describe('add a conseil', () => {
    test.beforeEach(async ({ page }) => {
        await helper.login(page)
    })

    test("add conseil", async ({ page }) => {
        const consielListingPage = new EvoteConseilListingPage(page);
        await consielListingPage.goto();
        await consielListingPage.clickAddConseilButton()

        await page.waitForLoadState('domcontentloaded');
        expect(page.url()).toContain("editCouncilSession");

        const title = "Test Playwright Conseil"
        const conseilEditPage = new EvoteConseilEditPage(page);
        await conseilEditPage.fillForm(title, "Conseil municipal");
        await conseilEditPage.submitForm();
        await page.waitForLoadState('domcontentloaded');

        // Expect to have the title of the conseil
        const titleCount = await page.getByRole('link', { name: title }).count()
        expect(titleCount).toBe(1)

        await consielListingPage.goto();
        await page.waitForLoadState('domcontentloaded');
        await consielListingPage.deleteConseil("Test Playwright Conseil");
    })

})