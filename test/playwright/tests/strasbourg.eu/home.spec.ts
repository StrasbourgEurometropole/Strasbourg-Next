import { test, expect } from '@playwright/test';

test.describe("Home page", () => {

  test('has title', async ({ page }) => {
    await page.goto('/');

    // Expect a title "to contain" a substring.
    await expect(page).toHaveTitle("Site de la Ville et l'Eurométropole de Strasbourg | Strasbourg.eu");
  });

  test('screen is conform', async ({ page }) => {
    await page.goto('/');

    await expect(page).toHaveScreenshot({
      fullPage: true
    });
  });

  test("shows a detail place (Centre administratif)", async ({ page }) => {
    await page.goto('https://ems-recette-liferay2.sully-group.fr/');
    await page.getByRole('button', { name: ' J\'ai besoin d\'informations' }).click();
    await page.getByPlaceholder('Votre recherche').fill('Centre administratif');
    await page.getByRole('link', { name: 'Centre administratif -' }).click();
    await expect(page).toHaveScreenshot({
      fullPage: true
    });
  })

});

