import {devices} from "@playwright/test";

export const config = [
    {
    name: 'Evote Safari',
    testDir: 'tests/evote',
     ...devices["Desktop Safari"]
    },
    {
        name: 'Evote Chrome',
        testDir: 'tests/evote',
        ...devices["Desktop Chrome"]
    },
    {
        name: 'Evote Firefox',
        testDir: 'tests/evote',
        ...devices["Desktop Firefox"]
    },
    ];