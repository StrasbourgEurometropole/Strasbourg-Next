import {test} from '@playwright/test';

import {ApiHelpers} from '../helpers/api.helper';

const apiHelpersTest = test.extend<{apiHelpers: ApiHelpers}>({
    apiHelpers: async ({ request }, use) => {
        await use(new ApiHelpers(request));
    },
});

export {apiHelpersTest};