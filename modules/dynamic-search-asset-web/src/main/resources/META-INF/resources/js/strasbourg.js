// 'Enum' de tous les classNames des entité pouvant être rencontrées
var numberFormat=new Intl.NumberFormat();

var EntityEnum = {
    OFFICIAL: 'eu.strasbourg.service.official.model.Official',
    EDITION: 'eu.strasbourg.service.edition.model.Edition',
    EVENT: 'eu.strasbourg.service.agenda.model.Event',
    MANIFESTATION: 'eu.strasbourg.service.agenda.model.Manifestation',
    EDITION_GALLERY: 'eu.strasbourg.service.edition.model.EditionGallery',
    PLACE: 'eu.strasbourg.service.place.model.Place',
    COURSE: 'eu.strasbourg.service.activity.model.ActivityCourse',
    ACTIVITY: 'eu.strasbourg.service.activity.model.Activity',
    ARTICLE: 'com.liferay.journal.model.JournalArticle',
}

// Define callback functions
const callbacks = {
    [EntityEnum.OFFICIAL]: createOfficialVignette,
    [EntityEnum.EDITION]: createEditionVignette,
    [EntityEnum.EVENT]: createEventVignette,
    [EntityEnum.MANIFESTATION]: createManifestationVignette,
    [EntityEnum.EDITION_GALLERY]: createEditionGalleryVignette,
    [EntityEnum.PLACE]: createPlaceVignette,
    [EntityEnum.COURSE]: createCourseVignette,
    [EntityEnum.ACTIVITY]: createActivityVignette,
    [EntityEnum.ARTICLE]: createArticleVignette,
};

function focusOnInput(inputId) {
    const inputElement = document.getElementById(inputId);

    if (inputElement) {
        setTimeout(() => inputElement.focus(), 200);
    } else {
        console.error(`Input element with ID ${inputId} not found.`);
    }
}

function createButtonFavorite(title, url, id, type, isFavorite = false) {
    return `
    <button class="st-btn-favorite-card ${isFavorite ? 'st-is-favorite' : ''}" 
    data-groupid="0" 
    data-title="${title}" 
    data-url="${url}" 
    data-id="${id}" 
    data-type="${type}"
    aria-pressed="false"> 
    ${Liferay.Language.get('eu.add-to-favorite')}
    </button>`;
}

function generateImage(imageURL, icon = "info") {
    if(imageURL) {
        return `
                <figure class="st-figure st-fit-cover" role="group">
                    <picture>
                        <img src="${imageURL}" alt="" loading="lazy">
                    </picture>
                </figure>
    `
    }
    return `
                <span class="st-icon st-icon-${icon}"></span>
    `

}

function createOfficialVignette(data) {
    return `
    <li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal st-card-person ${!data.imageURL ? 'st--with-icon' : ''}">
            <div class="st-caption">
                <h3 class="st-title-card">${data.firstName} ${data.lastName}</h3>
                ${data.fonctionEuro ? `<p class="st-surtitre-cat">${data.fonctionEuro}</p>` : ''}
                ${data.fonctionCity ? `<p class="st-role">${data.fonctionCity}</p>` : ''}
                ${data.description ? `<p class="st-text">${data.description}</p>`: ''}
            </div>
            <div class="st-image">
            ${generateImage(data.imageURL)}
            </div>
        </a>
    </div>
</li>
`;
}

function createEditionVignette(data) {
    return `
    <li>
     <div class="st-card st--card-horizontal st-card-magazine  ${!data.imageURL ? 'st--with-icon': ''}">
        <div class="st-caption">
            ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
            <div class="st-btns-wrapper">
                <a href="${data.link}" target="_blank"
                    class="st-btn st--btn-secondary st--btn-xs st--btn-small-padding">Visionner</a>
                    ${data.galeryEditionURL ?
                `<a href="${data.galeryEditionURL}" class="st-btn st--btn-primary st--btn-xs st--btn-small-padding">
                    Tous les ${data.galeryEditionName}
                </a>` : "" }
            </div>
        </div>
       <div class="st-image">
            ${generateImage(data.imageURL)}
            </div>
    </div>
</li>
    `;
}

function createEventVignette(data) {
    return `
    <li>
    <div class="st-card-container">
        <a href="${data.linkStras}" class="st-card st--card-horizontal st-card-agenda st--with-gradient  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
              ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.schedule ? `<p class="st-date">${data.schedule}</p>` : ''}
                ${!!data.city ? `<p class="st-location">${data.city}</p>` : ''}
            </div>
            <div class="st-image">
            ${generateImage(data.imageURL, "agenda")}
            </div>
        </a>
        ${createButtonFavorite(data.title, data.link, data.id, 2, data.isFavorite)}
    </div>
    
</li>
`;
}

function createManifestationVignette(data) {
    return `<li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal st-card-agenda st--with-gradient  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
              ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.schedule ? `<p class="st-date">${data.schedule}</p>` : ''}
            </div>
            <div class="st-image">
            ${generateImage(data.imageURL)}
            </div>
        </a>
    </div>
</li>
    `;
}

function createEditionGalleryVignette(data) {
    return `
<li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
               ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
               ${data.description ?`<p class="st-text">${data.description}</p>` : ''}
            </div>
          <div class="st-image">
                ${generateImage(data.imageURL)}
            </div>
        </a>
    </div>
</li>
    `;
}

function createPlaceVignette(data) {
    return `
<li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal st--with-gradient  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
                 ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
               ${data.city ?`<p class="st-location">${data.city}</p>` : ''}
            </div>

            <div class="st-image">
                ${generateImage(data.imageURL, "pin")}
                ${
        data.isOpen == null ? "" :
            `<p class="st-badge-ouverture ${!data.isOpen ? "st--closed": ""}">${data.isOpen ? "Ouvert": "Fermé"}</p>`
    }
               
            </div>
        </a>
        ${createButtonFavorite(data.title, data.link, data.id, 1, data.isFavorite)}
    </div>
</li>
`;
}

function createCourseVignette(data) {
    return `
    <li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
            ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
            </div>
           <div class="st-image">
                ${generateImage(data.imageURL)}
            </div>
        </a>
    </div>
</li>
    `;
}

function createActivityVignette(data) {
    return `
    <li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
               ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
               ${data.description ?`<p class="st-text">${data.description}</p>` : ''}
            </div>
          <div class="st-image">
                ${generateImage(data.imageURL)}
            </div>
        </a>
    </div>
</li>
    `;
}

function createArticleVignette(data) {
    return `
    <li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
               ${data.title ? `<h3 class="st-title-card">${data.title}</h3>` : ''}
                ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.chapo ? `<p class="st-text">${data.chapo}</p>` : ''}
                ${data.modifiedDate ? `<p class="st-date">Publié le ${data.modifiedDate}</p>` : ''}
            </div>
            <div class="st-image">
                ${generateImage(data.imageURL)}
            </div>
        </a>
        ${createButtonFavorite(data.title, data.link, data.id, 7, data.isFavorite)}
    </div>
</li>
    `;
}

function getVignette(entityType, object) {
    const callback = callbacks[entityType];
    if (callback) {
        return callback(object);
    }
    console.log('No callback found for entity type:', entityType);
    return "";
}

var activeRequest = null;

function callSearchUrl(url, data, callback) {
    if (activeRequest) {
        activeRequest.abort(); // Cancel the previous request
        activeRequest = null;  // Reset the active request
    }

    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            if (xhr.status === 200) {
                callback(JSON.parse(xhr.responseText));
            }
            // Remove the "loading" class when the request is complete
            document.querySelector('.st-results .loading-small-animation').classList.add('st-hide');
            document.querySelector('#resultList .loading-animation')?.classList.add('st-hide');

            // update aria-busy to false
            document.querySelector('.st-results').setAttribute("aria-busy", "false");
            document.querySelector('#resultList').setAttribute("aria-busy", "false");
        } else {
            // Add the "loading" class when the request is loading
            document.querySelector('.st-results .loading-small-animation').classList.remove('st-hide');
            document.querySelector('#resultList .loading-animation')?.classList.remove('st-hide');

            // update aria-busy to true
            document.querySelector('.st-results').setAttribute("aria-busy", "true");
            document.querySelector('#resultList').setAttribute("aria-busy", "true");
        }
    };
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);

    activeRequest = xhr;
}

function populateList(data) {
    var resultList = document.getElementById('results');
    resultList.innerHTML = ''; // Clear existing list items
    var totalResult = parseInt(data.find(item => item.totalResult).totalResult, 10)
    var resultTotal = document.getElementById('results-total');
    resultTotal.innerHTML = numberFormat.format(totalResult);
    var resultDisplay = document.getElementById('results-display');
    var delta = parseInt(data.find(item => item.displayResult).displayResult, 10)
    if(totalResult > delta)
        resultDisplay.style.display = "block";
    else
        resultDisplay.style.display = "none";
    data = data.filter(item => !item.totalResult);
    // Remove all click event from favorite buttons
    var favoriteButtons = document.querySelectorAll('.st-btn-favorite-card');
    favoriteButtons.forEach(function (button) {
        button.removeEventListener('click', toggleFavorite);
    });
    data.forEach(function (item) {
        if(item.description) {
            item.description = item.description.replace(/(<([^>]+)>)/ig,"");
        }
        var vignette = getVignette(item.className, item);
        resultList.insertAdjacentHTML('beforeend', vignette);
    });

    // permet de donner le focus aux résultats
    onOverlayOpen('st-overlay-search');

    setTimeout(() => {
        // Focus sur le champ de recherche
        document.querySelector("#recherche-input").focus();
    }, 150);

    addClickEventToFavoriteButtons();

    // remonte le scroll en haut
    if(resultList.querySelector("li") != undefined)
        resultList.querySelector("li").scrollIntoView(false);
}

var searchInput = document.getElementById('recherche-input');
var typingTimer;
var doneTypingInterval = 300;

searchInput.addEventListener('input', function () {
    clearTimeout(typingTimer);

    if (searchInput.value.length >= 3) {
        typingTimer = setTimeout(sendSearch, doneTypingInterval);
    }
});

sendSearch = function () {
    var searchTerm = searchInput.value;
    var postData = `${porletNamespace}keywords=${encodeURIComponent(searchTerm)}&${porletNamespace}selectedClassNames=${getSelectedClassNames()}`;

    callSearchUrl(searchSubmitURL, postData, populateList);
}

function getSelectedClassNames() {
	var results = "";
    const elements = document.querySelectorAll('[id^="dynamic_search_type"].st-is-active');

    elements.forEach(function (element) {
        results = results.concat(element.getAttribute("data-entity-classname"), ',');
    })

	return results;
}

function toggleStIsActive() {
    // Get a reference to the current element
    const currentElement = this;

    // Toggle the "st-is-active" class on the current element
    if (currentElement.classList.contains('st-is-active')) {
        currentElement.classList.remove('st-is-active');
        // set aria-pressed to false
        currentElement.setAttribute("aria-pressed", "false");
    } else {
        currentElement.classList.add('st-is-active');
        // set aria-pressed to true
        currentElement.setAttribute("aria-pressed", "true");
    }

    sendSearch();
}

// Add the click event listener to elements with a specific class
const elementsWithOnClick = document.querySelectorAll('.st-btn-filter-search');

// Attach the toggleStIsActive function to each selected element
elementsWithOnClick.forEach(function(element) {
    element.addEventListener('click', toggleStIsActive);

});