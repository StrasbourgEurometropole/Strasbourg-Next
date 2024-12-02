// Debounce function
function debounce(func, delay) {
	let timeout;
	return function (...args) {
		const context = this;
		clearTimeout(timeout);
		timeout = setTimeout(() => func.apply(context, args), delay);
	};
}

function makeRequest(url, data) {
    return new Promise(function(resolve, reject) {
        AUI().use('aui-io-request', function(A) {
            A.io.request(url, {
                method : 'post',
                dataType: 'json',
                data : data,
                on: {
                    success: function(e) {
                        var data = this.get('responseData');
                        resolve(data);
                    }
                }
            });
        });
    });
}

async function fetchData(searchPage, url, body, start, delta) {
    try {
        const proListing = $('.pro-listing-' + searchPage);
		proListing.html(`<div class="loader-container"> <span class="spinner"></span>
 <b>Chargement en cours</b></div>`);

        const response = await makeRequest(url, {
            ...body,
            _eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_start: start,
            _eu_strasbourg_portlet_search_asset_v2_SearchAssetPortlet_delta: delta
        })

        proListing.html(``);
        getParticiperResult(searchPage, response, start, delta);
    } catch (error) {
        console.error('There has been a problem with your fetch operation:', error);
    }
}

/**
 * Returns the result.
 *
 * @param {string} searchPage - The current search page.
 * @param {Object} data - The data object containing entries.
 * @param {number} start - The starting index for pagination.
 * @param {number} delta - The number of items per page.
 */
function getParticiperResult(searchPage, data, start, delta) {
    if (!data) return;

    const totalElements = data.total;
    const proListing = $('.pro-listing-' + searchPage);
    let listing = '';

    // Start listing
    var row = proListing.data('row');
    if(row == true) {
        listing = '<div class="row pro-wi-grid unstyled">';
    } else {
        listing = '<div class="pro-wi-grid unstyled">';
    }
    let indexGrid = 2;

    // Iterate through each entry in the data
    $.each(data.entries, (index, json) => {
        if ((index > 0 && index % delta === 0)) {

            listing += '</div><div class="pro-wi-grid hidden unstyled" data-page="' + indexGrid + '">';
            indexGrid++;
        }

        // Handle different types of entries
       listing = handleEntryType(json, listing, searchPage);
    });

    listing += '</div>';
    proListing.html(listing);

    // Render pagination controls if there are multiple pages
    if (totalElements > delta) {
        renderPagination(searchPage, start, delta, totalElements);
    }
    else {
        $('.pro-pagination .pull-left').html("");
        $('.pro-pagination .pull-right').html("");
    }
}

/**
 * Handles different types of entries based on their class.
 *
 * @param {Object} json - The JSON object representing an entry.
 * @param {string} listing - The current HTML string being built.
 * @returns {string} - Updated HTML string with the new entry added.
 */
function handleEntryType(json, listing, searchPage) {
    switch (json.class) {
        case 'eu.strasbourg.service.video.model.Video': return listing += createVideo(json.json);
        case 'eu.strasbourg.service.project.model.Project': return listing += createProject(json.json);
        case 'eu.strasbourg.service.project.model.Participation': return listing += createParticipation(json.json);
        case 'eu.strasbourg.service.agenda.model.Event': return listing += createAgenda(json.json);
        case 'eu.strasbourg.service.project.model.Petition': return listing += createPetition(json.json);
        case 'eu.strasbourg.service.project.model.SaisineObservatoire': return listing += createSaisineObservatoire(json.json);
        case 'eu.strasbourg.service.project.model.BudgetParticipatif': return listing += createBudgetParticipatif(json.json);
        case 'eu.strasbourg.service.project.model.Initiative': return listing += createInitiative(json.json);
        case 'com.liferay.journal.model.JournalArticle':
            if (searchPage === "project-workshop") {
                return listing += createProjectWorkshop(json.json);
            } else {
                return listing += createNews(json.json);
            }
        default: return listing;
    }
}

/**
 * Renders the pagination controls.
 *
 * @param {string} searchPage - The current search page.
 * @param {number} start - The starting index for pagination.
 * @param {number} delta - The number of items per page.
 * @param {number} totalElements - Total elements available.
 */
function renderPagination(searchPage, start, delta, totalElements) {
    const currentPageIndex = Math.floor(start / delta) + 1;
    const totalPages = Math.ceil(totalElements / delta);

    let selecteur = `
        <form method="get">
            <select id="change-page" name="change-page">
    `;

    // Generate options for all pages
    for (let indexPage = 1; indexPage <= totalPages; indexPage++) {
        selecteur += `
            <option value="${indexPage}" ${currentPageIndex === indexPage ? "selected" : ""}>
                Page ${indexPage}
            </option>
        `;
    }

    selecteur += `
            </select>
        </form>
    `;

    selecteur += '<p class="hidden-xs"></p>';

    $('.pro-pagination .pull-left').html(selecteur);
    $('#change-page').selectric();

    const isFirstDisabled = start === 0;
    const isLastDisabled = (start + delta) >= totalElements;

    const link = `
        <ul>
            <li class="${isFirstDisabled ? 'pro-disabled' : ''}">
                <a href="#go-to-top" class="hidden-sm hidden-xs pro-first" title="Lien vers la première page du Listing" data-action="first">Premier</a>
            </li>
            <li class="${isFirstDisabled ? 'pro-disabled' : ''}">
                <a href="#go-to-top" title="Lien vers la page précédente du Listing" data-action="prev">Précédent</a>
            </li>
            <li class="${isLastDisabled ? 'pro-disabled' : ''}">
                <a href="#go-to-top" title="Lien vers la page suivante du Listing" data-action="next">Suivant</a>
            </li>
            <li class="${isLastDisabled ? 'pro-disabled' : ''}">
                <a href="#go-to-top" class="hidden-sm hidden-xs pro-last" title="Lien vers la dernière page du Listing" data-action="last">Dernier</a>
            </li>
        </ul>
    `;

    $('.pro-pagination .pull-right').html(link);

    updatePaginationText(start, delta, totalElements);
    buildParticiperPaginate(start, delta, totalElements);
}

/**
 * Updates the pagination text.
 *
 * @param {number} start - The starting index for pagination.
 * @param {number} delta - The number of items per page.
 * @param {number} totalElements - Total elements available.
 */
function updatePaginationText(start, delta, totalElements) {
    const endIndex = Math.min(start + delta, totalElements);
    const pageResult = `Affichage des résultats ${start + 1} - ${endIndex} parmi ${totalElements}`;
    $('.pro-pagination .pull-left .hidden-xs').text(pageResult);
}

/**
 * Builds the pagination.
 *
 * @param {number} start - The starting index for pagination.
 * @param {number} delta - The number of items per page.
 * @param {number} totalElements - Total elements available.
 */
function buildParticiperPaginate(start, delta, totalElements) {
    $('.pro-search-listing').each((index, widget) => {
        const wi = {
            $widget: $(widget),
            $list: $(widget).find('.pro-wi-grid'),
            $items: $(widget).find('.vignette'),
            itemsCount: totalElements,
            pageCount: Math.ceil(totalElements / delta),
        };

        let currentPageIndex = Math.floor(start / delta) + 1;

        const goToPage = (pageIndex) => {
            if (pageIndex < 1 || pageIndex > wi.pageCount) return;

            const startIndex = (pageIndex - 1) * delta;
            getSelectedEntries(startIndex);
        };

        wi.$widget.find('[data-action="first"]').on('click', () => goToPage(1));
        wi.$widget.find('[data-action="prev"]').on('click', () => goToPage(currentPageIndex - 1));
        wi.$widget.find('[data-action="next"]').on('click', () => goToPage(currentPageIndex + 1));
        wi.$widget.find('[data-action="last"]').on('click', () => goToPage(wi.pageCount));
        wi.$widget.find('#change-page').on('change', function () {
            const targetPage = parseInt($(this).val(), 10);
            goToPage(targetPage);
        });
    });

    th_linkAll();
}