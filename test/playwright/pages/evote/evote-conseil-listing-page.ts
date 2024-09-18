import {Locator, Page} from '@playwright/test';

export class EvoteConseilListingPage {
    readonly addConseilButton: Locator;
    readonly page: Page;

    constructor(page: Page) {
        this.page = page;
        this.addConseilButton = this.page.getByLabel("Ajouter");
    }

    async clickAddConseilButton() {
        await this.addConseilButton.click();
    }

    async goto() {
        await this.page.goto('/web/evote');
        await this.page.getByRole('menuitem', {name: 'Contenu'}).click();
        await this.page.getByRole('menuitem', {name: 'Gestion des conseils'}).click();
        await this.page.waitForLoadState('networkidle');
        await this.page.getByRole('link', {name: 'Conseils'}).click();
    }

    async deleteConseil(conseilName: string) {
        await this.page.waitForTimeout(1500);

        await this.page.getByRole('row', {
            name: `Sélectionner ${conseilName} Conseil`
        }).getByLabel('<liferay-ui:message key=\'show').click();

        await this.page.getByRole('menuitem', {name: 'Supprimer'}).click();
    }
}