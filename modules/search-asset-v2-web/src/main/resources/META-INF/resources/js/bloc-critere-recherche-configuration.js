var blocVocabulary = "" +
"<div class='vocabulary-configuration' id='vocabulary%%INDEX%%'>" +
    "<input class='field form-control' id='" + namespace + "numVocabulary%%INDEX%%' name='" + namespace + "numVocabulary%%INDEX%%' type='hidden' value='%%INDEX%%'>" +
    "<div class='align-items-center c-gap-3 d-flex mb-0 panel-body'>" +
        "<div class='form-group form-group-inline input-select-wrapper2'>" +
            "<select class='form-control' name='" + namespace + "vocabularyIds_%%INDEX%%' id='" + namespace + "vocabularyIds_%%INDEX%%'>" +
                "<option value='false'>" + Liferay.Language.get('select-vocabulary') +"</option>" +
            "</select>" +
        "</div>" +
        "     <div class='form-group form-group-inline input-select-wrapper'>" +
            "<select class='form-control' id='" + namespace + "vocabularyControlType_%%INDEX%%' name='" + namespace + "vocabularyControlType_%%INDEX%%'>" +
                "<option class='' value='list'>" + Liferay.Language.get("dropdown-list") + "</option>" +
                "<option class='' value='radio'>" + Liferay.Language.get("radio-button") + "</option>" +
                "<option class='' value='check'>" + Liferay.Language.get("checkbox") + "</option>" +
            "</select>" +
        "</div>     " +
    `
			<button class="form-group btn btn-icon-only btn-monospaced btn-primary " id='${namespace}meht' onclick='deleteVocabulary(%%INDEX%%);'>
					<svg aria-hidden="true" class="lexicon-icon lexicon-icon-trash " focusable="false" role="presentation">
					  <use href="/o/admin-theme/images/clay/icons.svg#trash"></use>
					</svg>
			</button>
` +
        "</div>" +
"</div>";