import {Locator, Page} from '@playwright/test';

export class EvoteConseilEditPage {
    readonly page: Page;
    readonly titleInput: Locator;
    readonly conseilTypeSelect: Locator;
    readonly startDateInput: Locator;
    readonly conseilPresidentInput: Locator;
    readonly saveButton: Locator;

    constructor(page: Page) {
        this.page = page;
        this.titleInput = this.page.getByLabel('Titre Requis');
        this.conseilTypeSelect = this.page.getByLabel('Type de conseil');
        this.startDateInput = this.page.getByPlaceholder('jj/mm/aaaa');
        this.conseilPresidentInput = this.page.getByLabel('Président du conseil Requis');
        this.saveButton = this.page.getByRole('button', {name: 'Enregistrer'});
    }

    async fillForm(title: string, type: string) {
        await this.titleInput.fill(title);
        await this.conseilTypeSelect.selectOption({label: type});
        await this.fillPresident();
    }

    async fillPresident() {
        await this.conseilPresidentInput.fill("im");
        await this.page.getByText("RAMDANE Abdelkarim").click();
    }

    async submitForm() {
        await this.saveButton.click();
    }
}