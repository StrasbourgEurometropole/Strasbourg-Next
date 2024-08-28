import {devices} from "@playwright/test";

export const config = [
    {
        name: 'Strasbourg.eu Chrome',
        testDir: 'tests/strasbourg.eu',
        ...devices["Desktop Chrome"]
    },
    {
        name: 'Strasbourg.eu Firefox',
        testDir: 'tests/strasbourg.eu',
        ...devices["Desktop Firefox"]
    },
    {
        name: 'Strasbourg.eu Safari',
        testDir: 'tests/strasbourg.eu',
        ...devices["Desktop Safari"]
    }
];