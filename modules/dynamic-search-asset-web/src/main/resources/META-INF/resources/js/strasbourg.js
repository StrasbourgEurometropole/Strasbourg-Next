// 'Enum' de tous les classNames des entité pouvant être rencontrées
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

function generateImage(imageURL, icon = "info") {
    if(imageURL) {
        return `
                <figure class="st-figure st-fit-cover" role="group">
                    <picture>
                        <img src="${imageURL}">
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
                <p class="st-title-card">${data.firstName} ${data.lastName}</p>
                ${data.fonctionEuro ? `<p class="st-surtitre-cat">${data.fonctionEuro}</p>` : ''}
                ${data.fonctionCity ? `<p class="st-role">${data.fonctionCity}</p>` : ''}
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
            ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
            <div class="st-btns-wrapper">
                <a href="${data.link}" target="_blank"
                    class="st-btn st--btn-secondary st--btn-xs st--btn-small-padding">Visionner</a>
                <a href="${data.downloadURL}" class="st-btn-icon st-btn-icon--bg-sub" download="">
                    <span class="st-icon-download" aria-hidden="true"></span>
                </a>
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
              ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.schedule ? `<p class="st-date">${data.schedule}</p>` : ''}
                ${!!data.city ? `<p class="st-location">${data.city}</p>` : ''}
            </div>
            <div class="st-image">
            ${generateImage(data.imageURL)}
            </div>
        </a>
        <button class="st-btn-favorite-card" data-addpanier="postID">
            Ajouter à mes favoris
        </button>
    </div>
</li>
`;
}

function createManifestationVignette(data) {
    return `<li>
    <div class="st-card-container">
        <a href="${data.link}" class="st-card st--card-horizontal st-card-agenda st--with-gradient  ${!data.imageURL ? 'st--with-icon': ''}">
            <div class="st-caption">
              ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.schedule ? `<p class="st-date">${data.schedule}</p>` : ''}
            </div>
            <div class="st-image">
            ${generateImage(data.imageURL)}
            </div>
        </a>
        <button class="st-btn-favorite-card" data-addpanier="postID">
            Ajouter à mes favoris
        </button>
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
               ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
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
                 ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
               ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
               ${data.city ?`<p class="st-location">${data.city}</p>` : ''}
            </div>

            <div class="st-image">
                ${generateImage(data.imageURL)}
                <p class="st-badge-ouverture ${!data.isOpen ? "st--closed": ""}">${data.isOpen ? "Ouvert": "Fermé"}</p>
            </div>
        </a>
        <button class="st-btn-favorite-card" data-addpanier="postID">
            Ajouter à mes favoris
        </button>
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
            ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
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
               ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
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
               ${data.title ? `<p class="st-title-card">${data.title}</p>` : ''}
                ${data.categories ? `<p class="st-surtitre-cat">${data.categories}</p>` : ''}
                ${data.chapo ? `<p class="st-text">${data.chapo}</p>` : ''}
                ${data.modifiedDate ? `<p class="st-date">Publié le ${data.modifiedDate}</p>` : ''}
            </div>
            <div class="st-image">
                ${generateImage(data.imageURL)}
            </div>
        </a>
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
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(JSON.parse(xhr.responseText));
        }
    };
    xhr.open('POST', url, true);
    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
    xhr.send(data);

    activeRequest = xhr;
}

function populateList(data) {
    var resultList = document.getElementById('resultList');
    resultList.innerHTML = ''; // Clear existing list items
    var totalResult = data.find(item => item.totalResult).totalResult
    var resultTotal = document.getElementById('results-total');
    resultTotal.innerHTML = totalResult;
    data = data.filter(item => !item.totalResult);
    data.forEach(function (item) {
        if(item.description) {
            item.description = item.description.replace(/(<([^>]+)>)/ig,"");
        }
        var vignette = getVignette(item.className, item);
        resultList.insertAdjacentHTML('beforeend', vignette);
    });
}

var searchInput = document.getElementById('recherche-input');
var typingTimer;
var doneTypingInterval = 300;

searchInput.addEventListener('input', function () {
    clearTimeout(typingTimer);

    if (searchInput.value.length >= 3) {
        typingTimer = setTimeout(function () {
            var searchTerm = searchInput.value;
            var postData = `${porletNamespace}keywords=` + encodeURIComponent(searchTerm);

            callSearchUrl(searchSubmitURL, postData, populateList);
        }, doneTypingInterval);
    }
});