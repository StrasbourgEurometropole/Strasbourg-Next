<div class="st-bloc st-bloc-infos-complementaires st-wrapper st--has-margin">
    <div class="st-component st-component-type-3">
        <div class="st-component-container">
            <p class="st-title-small">${name.getData()}</p>
            <ul class="st-liens">
                <li class="st-lien-container">
                    <a href="tel:${phone.getData()}" class="st-btn st--btn-secondary st--btn-small-padding">
                        ${phone.getData()}
                    </a>
                </li>
                <li class="st-lien-container">
                    <a href="${detailLink.getData()}" class="st-btn st--btn-secondary st--btn-small-padding">
                        <@liferay_ui.message key="contact.contact-us" />
                    </a>
                </li>
            </ul>
        </div>
    </div></div>