async function fetchCategoriesByGroupIds(groupIds) {
    try {
        const response = await fetch(
            '/api/jsonws/strasbourg.strasbourg/get-categories-by-group-ids' +
            '?groupIds=' + groupIds +
            '&p_auth=' + Liferay.authToken
        );

        return await response.json();
    } catch (e) {
        console.error(e);
        return []
    }
}
async function fetchCategoriesByGroupIdsAndClassName(groupIds, className) {
    try {
        const response = await fetch(
            '/api/jsonws/strasbourg.strasbourg/get-categories-by-class-name-and-group-ids' +
            '?groupIds=' + groupIds +
            '?className=' + className +
            '&p_auth=' + Liferay.authToken
        );

        return await response.json();
    } catch (e) {
        console.error(e);
        return []
    }
}

async function initCategorySelector(element, groupIds, values , classname = "") {
    const choice = new Choices(element, {
        removeItemButton: true,
        loadingText: 'Chargement...',
        noResultsText: 'Auncun résultat',
        noChoicesText: 'Pas de choix',
        itemSelectText: 'Cliquer pour sélectionner',
        searchResultLimit: 30,
        sorter: function(a, b) {
            if(a.customProperties != undefined)
                return a.customProperties.random < b.customProperties.random ? -1 : a.customProperties.random > b.customProperties.random;
        }
    });


    let categories;
    if(classname == "")
        categories = await fetchCategoriesByGroupIds(groupIds);
    else
        categories = await fetchCategoriesByGroupIdsAndClassName(groupIds, classname);
    choice.setChoices(categories, "value", "label", true);

    if(values.length > 0){
        // il faut transformer les long en String
        choice.setChoiceByValue(values.map(String));
    }
    return choice;
}