var blocPrefilter = "" +
    "<div id='prefilter%%INDEXTYPE%%_%%INDEXPREFILTRE%%'>" +
    "<input class='field form-control' id='" + namespace + "numPrefiltre%%INDEXTYPE%%_%%INDEXPREFILTRE%%' name='" + namespace + "numPrefiltre%%INDEXTYPE%%_%%INDEXPREFILTRE%%' type='hidden' value='%%INDEXPREFILTRE%%'>" +
    "<div class='align-items-baseline c-gap-3 d-flex mb-0 panel-body'>" +
    "<div class='form-group form-group-inline input-select-wrapper'>" +
    "<select class='form-control' id='" + namespace + "includeOrExclude_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' name='" + namespace + "includeOrExclude_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' title='include-or-exclude_%%INDEXTYPE%%_%%INDEXPREFILTRE%%'>" +
    "<option class='' selected='' value='true'>" +
    Liferay.Language.get('eu.search.asset.web.configuration.contains') +
    "</option>" +
    "<option class='' value='false'>" +
    Liferay.Language.get('eu.search.asset.web.configuration.notContains') +
    "</option>" +
    "</select>" +
    "</div>     " +
    "<div class='form-group form-group-inline input-select-wrapper'>" +
    "<select class='form-control' id='" + namespace + "allOrAny_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' name='" + namespace + "allOrAny_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' title='all-or-any_%%INDEXTYPE%%_%%INDEXPREFILTRE%%'>" +
    "<option class='' selected='' value='all'>" +
    Liferay.Language.get('eu.search.asset.web.configuration.all') +
    "</option>" +
    "<option class='' value='any'>" +
    Liferay.Language.get('eu.search.asset.web.configuration.any') +
    "</option>" +
    "</select>" +
    "</div>     " +
    "<span class='form-group form-group-inline'>parmi</span>     " +
    "<div class='form-group form-group-inline input-select-wrapper'>" +
    "<select class='form-control' id='" + namespace + "categoriesOrTags_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' name='" + namespace + "categoriesOrTags_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' onchange='updatePrefilter(this)' title='categories-or-tags_%%INDEXTYPE%%_%%INDEXPREFILTRE%%'>" +
    "<option class='' value='categories'>" +
                    Liferay.Language.get('eu.search.asset.web.configuration.categories') +
                "</option>" +
                "<option class='' selected='' value='tags'>" +
                    Liferay.Language.get('eu.search.asset.web.configuration.tags') +
                "</option>" +
            "</select>" +
        "</div>     " +
    `
    <button class="form-group btn btn-icon-only btn-monospaced btn-primary " id='${namespace}meht' onclick='deletePrefilter(%%INDEXTYPE%%,%%INDEXPREFILTRE%%);'>
					<svg aria-hidden="true" class="lexicon-icon lexicon-icon-trash " focusable="false" role="presentation">
					  <use href="/o/admin-theme/images/clay/icons.svg#trash"></use>
					</svg>
			</button>
    `+
    "</div>" +
    "<select class='form-control' name='" + namespace + "prefilterIds_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' id='" + namespace + "prefilterIds_%%INDEXTYPE%%_%%INDEXPREFILTRE%%' multiple=''>" +
        "<option placeholder>" + Liferay.Language.get('select-prefilters') +"</option>" +
    "</select>" +
"</div>" +
"<div style='margin: 20px 0;'></div>";