import { test, expect } from '@playwright/test';

test('has title', async ({ page }) => {
  await page.goto('/');

  // Expect a title "to contain" a substring.
  await expect(page).toHaveTitle("Site de la Ville et l'Eurométropole de Strasbourg | Strasbourg.eu");
});