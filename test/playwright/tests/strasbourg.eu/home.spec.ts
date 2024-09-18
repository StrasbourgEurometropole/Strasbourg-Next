import { test, expect } from '@playwright/test';
import AxeBuilder from '@axe-core/playwright'; // 1
test.describe.parallel("Home page", () => {

  test('has title', async ({ page }) => {
    await page.goto('/');

    // Expect a title "to contain" a substring.
    await expect(page).toHaveTitle("Site de la Ville et l'Eurométropole de Strasbourg | Strasbourg.eu");
  });

  test('screen is conform', async ({ page }) => {
    await page.goto('/');

    await expect(page).toHaveScreenshot();
  });

  test("shows a detail place (Centre administratif)", async ({ page }) => {
    await page.goto('https://ems-recette-liferay2.sully-group.fr/');
    await page.getByRole('button', { name: ' J\'ai besoin d\'informations' }).click();
    await page.getByPlaceholder('Votre recherche').fill('Centre administratif');
    await page.getByRole('link', { name: 'Centre administratif -' }).click();
    await expect(page).toHaveScreenshot();
  })

  test("Accessibility check to the home page", async ({ page }) => {
    await page.goto('https://ems-recette-liferay2.sully-group.fr/');
    const accessibilityScanResults = await new AxeBuilder({ page })
        .disableRules(['aria-allowed-role', 'label-title-only','region', 'skip-link' , 'landmark-one-main', 'page-has-heading-one', 'presentation-role-conflict'])
        .analyze(); // 4
    console.log(accessibilityScanResults.violations)
    expect(accessibilityScanResults.violations).toEqual([]);
  })

  test("Accessibility check to the place detail page", async ({ page }) => {
    await page.goto('https://ems-recette-liferay2.sully-group.fr/');
    await page.getByRole('button', { name: ' J\'ai besoin d\'informations' }).click();
    await page.getByPlaceholder('Votre recherche').fill('Centre administratif');
    await page.getByRole('link', { name: 'Centre administratif -' }).click();
    const accessibilityScanResults = await new AxeBuilder({ page })
        .disableRules(['landmark-contentinfo-is-top-level', 'landmark-banner-is-top-level','aria-allowed-role', 'label-title-only','region', 'skip-link' , 'landmark-one-main', 'page-has-heading-one', 'presentation-role-conflict'])
        .analyze(); // 4
    console.log(accessibilityScanResults.violations)
    expect(accessibilityScanResults.violations).toEqual([]);
  })

});

