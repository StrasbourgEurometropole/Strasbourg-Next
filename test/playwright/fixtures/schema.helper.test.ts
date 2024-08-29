import {test} from '@playwright/test';

import {SchemaHelpers} from '../helpers/schema.helper';

const schemaHelpersTest = test.extend<{schemaHelpers: SchemaHelpers}>({
    schemaHelpers: async ({ request }, use) => {
        await use(new SchemaHelpers());
    },
});

export {schemaHelpersTest};