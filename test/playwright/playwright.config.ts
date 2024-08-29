import { defineConfig, devices } from '@playwright/test';
import { config as csmapConfig} from './tests/csmap/config';
import { config as strasbourgeuConfig} from "./tests/strasbourg.eu/config";
/**
 * Read environment variables from file.
 * https://github.com/motdotla/dotenv
 */
// import dotenv from 'dotenv';
// dotenv.config({ path: path.resolve(__dirname, '.env') });

/**
 * See https://playwright.dev/docs/test-configuration.
 */
export default defineConfig({
  testDir: './tests',
  /* Run tests in files in parallel */
  fullyParallel: true,
  /* Fail the build on CI if you accidentally left test.only in the source code. */
  forbidOnly: !!process.env.CI,
  /* Retry on CI only */
  retries: process.env.CI ? 2 : 0,
  /* Opt out of parallel tests on CI. */
  workers: process.env.CI ? 1 : undefined,

  outputDir: 'out/test-results',
  /* Reporter to use. See https://playwright.dev/docs/test-reporters */
  reporter: [
    ['html', { outputFolder: 'out/report', open: 'never' }],
      ['junit', { outputFile: 'results.xml' }]
  ],
  /* Shared settings for all the projects below. See https://playwright.dev/docs/api/class-testoptions. */
  use: {
    /* Base URL to use in actions like `await page.goto('/')`. */
    baseURL: 'https://ems-recette-liferay2.sully-group.fr',

    /* Collect trace when retrying the failed test. See https://playwright.dev/docs/trace-viewer */
    trace: 'on-first-retry',

    video: 'retain-on-failure',

    ...devices['Desktop Chrome'],

    viewport: { width: 1920, height: 1080 }
  },

  expect: {
    toHaveScreenshot: { maxDiffPixelRatio: 0.2, threshold: 0.1  },
  },

  /* Configure projects for major browsers */
  projects: [
      ...csmapConfig,
      ...strasbourgeuConfig
  ],
});
