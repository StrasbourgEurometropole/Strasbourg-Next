var namespace = '_com_liferay_portlet_configuration_web_portlet_PortletConfigurationPortlet_';

var blocAssetType = "" +
"<div class='sheet'>" +
	"<div class='panel-group panel-group-flush'>" +
        "<fieldset class='panel panel-unstyled' id='assetType%%INDEX%%'>" +
			"<legend class='sr-only'>" + Liferay.Language.get('some-content') + "</legend>" +
		    "<a aria-controls='assetType%%INDEX%%Content' aria-expanded='true' class='collapse-icon collapse-icon-middle sheet-subtitle' data-toggle='liferay-collapse' href='#assetType%%INDEX%%Content' role='button'>" +
				"<span class='c-inner' tabindex='-1'>" +
					"<span>" +
						Liferay.Language.get('some-content') +
					"</span>" +
					"<span class='collapse-icon-closed' id='ffek____'>" +
						"<svg class='lexicon-icon lexicon-icon-angle-right' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
							"<path class='lexicon-icon-outline' d='M396.394 255.607c-0.22-6.936-2.973-13.81-8.272-19.111l-227.221-227.221c-11.026-11.059-28.94-11.059-39.999 0-11.058 11.026-11.058 28.941 0 39.999l206.333 206.333c0 0-206.333 206.333-206.333 206.333-11.058 11.058-11.058 28.973 0 39.999 11.059 11.059 28.972 11.059 39.999 0l227.221-227.221c5.3-5.3 8.053-12.175 8.272-19.111z'></path>" +
						"</svg>" +
					"</span>" +
					"<span class='collapse-icon-open' id='qcss____'>" +
						"<svg class='lexicon-icon lexicon-icon-angle-down' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
							"<path class='lexicon-icon-outline' d='M256 384c6.936-0.22 13.81-2.973 19.111-8.272l227.221-227.221c11.058-11.026 11.058-28.941 0-39.999-11.026-11.058-28.94-11.058-39.999 0l-206.333 206.333c0 0-206.333-206.333-206.333-206.333-11.059-11.058-28.973-11.058-39.999 0-11.059 11.058-11.059 28.972 0 39.999l227.221 227.221c5.3 5.3 12.174 8.053 19.111 8.272z'></path>" +
						"</svg>" +
					"</span>" +
				"</span>" +
			"</a>" +
	        "<div class='panel-collapse collapse show' id='assetType%%INDEX%%Content' role='presentation' style=''>" +
		        "<div class='panel-body'>" +
		            "<input class='field form-control' id='" + namespace + "numAssetType%%INDEX%%' name='" + namespace + "numAssetType%%INDEX%%' type='hidden' value='%%INDEX%%'>" +
                    "<div class='align-items-baseline c-gap-3 d-flex mb-0 panel-body'>" +
						"<div class='form-group form-group-inline input-select-wrapper'>" +
							"<select class='form-control' id='" + namespace + "classname_%%INDEX%%' name='" + namespace + "classname_%%INDEX%%' onchange='updateBloc(%%INDEX%%)' title='classname_%%INDEX%%'>" +
								"<option class='' selected='' value='" + Liferay.Language.get('some-content') + "'>" + Liferay.Language.get('select-asset-type') + "</option>";
								$.each(assetTypeNames.split(','), function(i, assetTypeName) {
									var assetType = assetTypeName.split('--');
									blocAssetType += "<option class='' value='" + assetType[0] + "'>" + assetType[1] + "</option>";
								});
	blocAssetType += "" +
							"</select>" +
						"</div>" +
						"<button class='form-group btn btn-icon icon icon-trash icon-2x btn-default' id='" + namespace + "epfa' onclick='deleteAssetType(%%INDEX%%);' type='button'></button>" +
					"</div>" +
		            "<!-- Portée -->" +
                    "<fieldset class='panel panel-unstyled' id='scope%%INDEX%%'>" +
						"<legend class='sr-only'>" + Liferay.Language.get('scope') + "</legend>" +
						"<a aria-controls='scope%%INDEX%%Content' aria-expanded='true' class='collapse-icon collapse-icon-middle sheet-subtitle' data-toggle='liferay-collapse' href='#scope%%INDEX%%Content' role='button'>" +
							"<span class='c-inner' tabindex='-1'>\n" +
								"<span>" + Liferay.Language.get('scope') + "</span>" +
								"<span class='collapse-icon-closed' id='ffek____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-right' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M396.394 255.607c-0.22-6.936-2.973-13.81-8.272-19.111l-227.221-227.221c-11.026-11.059-28.94-11.059-39.999 0-11.058 11.026-11.058 28.941 0 39.999l206.333 206.333c0 0-206.333 206.333-206.333 206.333-11.058 11.058-11.058 28.973 0 39.999 11.059 11.059 28.972 11.059 39.999 0l227.221-227.221c5.3-5.3 8.053-12.175 8.272-19.111z'></path>" +
									"</svg>" +
								"</span>" +
								"<span class='collapse-icon-open' id='qcss____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-down' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M256 384c6.936-0.22 13.81-2.973 19.111-8.272l227.221-227.221c11.058-11.026 11.058-28.941 0-39.999-11.026-11.058-28.94-11.058-39.999 0l-206.333 206.333c0 0-206.333-206.333-206.333-206.333-11.059-11.058-28.973-11.058-39.999 0-11.059 11.058-11.059 28.972 0 39.999l227.221 227.221c5.3 5.3 12.174 8.053 19.111 8.272z'></path>" +
									"</svg>" +
								"</span>" +
							"</span>" +
						"</a>" +
	                    "<div class='panel-collapse collapse show' id='scope%%INDEX%%Content' role='presentation' style=''>" +
		                    "<div class='panel-body'>" +
                                Liferay.Language.get('scope-explanations') +
                                "<select class='form-control' name='" + namespace + "scopeIds_%%INDEX%%' id='" + namespace + "scopeIds_%%INDEX%%' multiple onchange='updatePrefiltersStructureVocabulariesAndGroupBy(%%INDEX%%)'>" +
                                    "<option placeholder>" + Liferay.Language.get('select-scopes') +"</option>" +
                                "</select>" +
								"<div style='margin: 20px 0;'></div>" +
		                    "</div>" +
	                    "</div>" +
                    "</fieldset>" +
                    "<!-- Structure -->" +
                    "<fieldset class='panel panel-unstyled' id='structure%%INDEX%%' style='display: none;'>" +
						"<legend class='sr-only'>" + Liferay.Language.get('structure') + "</legend>" +
						"<a aria-controls='structure%%INDEX%%Content' aria-expanded='true' class='collapse-icon collapse-icon-middle sheet-subtitle' data-toggle='liferay-collapse' href='#structure%%INDEX%%Content' role='button'>" +
							"<span class='c-inner' tabindex='-1'>" +
								"<span>" + Liferay.Language.get('structure') + "</span>" +
								"<span class='collapse-icon-closed' id='ffek____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-right' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M396.394 255.607c-0.22-6.936-2.973-13.81-8.272-19.111l-227.221-227.221c-11.026-11.059-28.94-11.059-39.999 0-11.058 11.026-11.058 28.941 0 39.999l206.333 206.333c0 0-206.333 206.333-206.333 206.333-11.058 11.058-11.058 28.973 0 39.999 11.059 11.059 28.972 11.059 39.999 0l227.221-227.221c5.3-5.3 8.053-12.175 8.272-19.111z'></path>" +
									"</svg>" +
								"</span>" +
								"<span class='collapse-icon-open' id='qcss____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-down' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M256 384c6.936-0.22 13.81-2.973 19.111-8.272l227.221-227.221c11.058-11.026 11.058-28.941 0-39.999-11.026-11.058-28.94-11.058-39.999 0l-206.333 206.333c0 0-206.333-206.333-206.333-206.333-11.059-11.058-28.973-11.058-39.999 0-11.059 11.058-11.059 28.972 0 39.999l227.221 227.221c5.3 5.3 12.174 8.053 19.111 8.272z'></path>" +
									"</svg>" +
								"</span>" +
							"</span>" +
						"</a>" +
                        "<div class='in panel-collapse collapse ' id='structure%%INDEX%%Content' role='presentation'>" +
                            "<div class='panel-body'>" +
                                "<div class='align-items-baseline c-gap-3 d-flex mb-0 panel-body'>" +
									"<div class='form-group form-group-inline input-select-wrapper'>" +
										"<select class='form-control' id='" + namespace + "structure_%%INDEX%%' name='" + namespace + "structure_%%INDEX%%' title='structure_%%INDEX%%'>" +
											"<option>" + Liferay.Language.get('select-a-structure') + "</option>" +
										"</select>" +
									"</div>" +
								"</div>" +
                            "</div>" +
                        "</div>" +
                    "</fieldset>" +
                    "<!-- Template et URL -->" +
                    "<fieldset class='panel panel-unstyled' id='template-and-url%%INDEX%%'>" +
						"<legend class='sr-only'>" + Liferay.Language.get('template-and-url') + "</legend>" +
						"<a aria-controls='template-and-url%%INDEX%%Content' aria-expanded='true' class='collapse-icon collapse-icon-middle sheet-subtitle' data-toggle='liferay-collapse' href='#template-and-url%%INDEX%%Content' role='button'>" +
							"<span class='c-inner' tabindex='-1'>" +
								"<span>" + Liferay.Language.get('template-and-url') + "</span>" +
								"<span class='collapse-icon-closed' id='fehs____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-right' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M396.394 255.607c-0.22-6.936-2.973-13.81-8.272-19.111l-227.221-227.221c-11.026-11.059-28.94-11.059-39.999 0-11.058 11.026-11.058 28.941 0 39.999l206.333 206.333c0 0-206.333 206.333-206.333 206.333-11.058 11.058-11.058 28.973 0 39.999 11.059 11.059 28.972 11.059 39.999 0l227.221-227.221c5.3-5.3 8.053-12.175 8.272-19.111z'></path>" +
									"</svg>" +
								"</span>" +
								"<span class='collapse-icon-open' id='kwsw____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-down' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M256 384c6.936-0.22 13.81-2.973 19.111-8.272l227.221-227.221c11.058-11.026 11.058-28.941 0-39.999-11.026-11.058-28.94-11.058-39.999 0l-206.333 206.333c0 0-206.333-206.333-206.333-206.333-11.059-11.058-28.973-11.058-39.999 0-11.059 11.058-11.059 28.972 0 39.999l227.221 227.221c5.3 5.3 12.174 8.053 19.111 8.272z'></path>" +
									"</svg>" +
								"</span>" +
							"</span>" +
						"</a>" +
                        "<div class='panel-collapse collapse show' id='template-and-url%%INDEX%%Content' role='presentation' style=''>" +
		                    "<div class='panel-body'>" +
                                "<div class='align-items-baseline c-gap-3 d-flex mb-0 panel-body'>" +
									"<div class='form-group form-group-inline input-select-wrapper'>" +
										"<select class='form-control' id='" + namespace + "templateKey_%%INDEX%%' name='" + namespace + "templateKey_%%INDEX%%' title='template-key_%%INDEX%%'>" +
											"<option>" + Liferay.Language.get('select-a-template') + "</option>" +
										"</select>" +
									"</div>     " +
									"<div class='form-group form-group-inline input-text-wrapper'>" +
										"<input class='field form-control' id='" + namespace + "friendlyUrl_%%INDEX%%' name='" + namespace + "friendlyUrl_%%INDEX%%' placeholder='" + Liferay.Language.get('detail-friendly-url') + "' title='friendly-url_%%INDEX%%' type='text' value=''>" +
									"</div>" +
								"</div>" +
							"</div>" +
	                    "</div>" +
                    "</fieldset>" +
                    "<!-- Préfiltre -->" +
                    "<fieldset class='panel panel-unstyled' id='prefilter%%INDEX%%'>" +
						"<legend class='sr-only'>" + Liferay.Language.get('prefilter') + "</legend>" +
						"<a aria-controls='prefilter%%INDEX%%Content' aria-expanded='false' class='collapse-icon collapse-icon-middle sheet-subtitle collapsed' data-toggle='liferay-collapse' href='#prefilter%%INDEX%%Content' role='button'>" +
							"<span class='c-inner' tabindex='-1'>" +
								"<span>" + Liferay.Language.get('prefilter') + "</span>" +
								"<span class='collapse-icon-closed' id='ztie____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-right' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M396.394 255.607c-0.22-6.936-2.973-13.81-8.272-19.111l-227.221-227.221c-11.026-11.059-28.94-11.059-39.999 0-11.058 11.026-11.058 28.941 0 39.999l206.333 206.333c0 0-206.333 206.333-206.333 206.333-11.058 11.058-11.058 28.973 0 39.999 11.059 11.059 28.972 11.059 39.999 0l227.221-227.221c5.3-5.3 8.053-12.175 8.272-19.111z'></path>" +
									"</svg>" +
								"</span>" +
								"<span class='collapse-icon-open' id='jrxp____'>" +
									"<svg class='lexicon-icon lexicon-icon-angle-down' focusable='false' role='presentation' viewBox='0 0 512 512'>" +
										"<path class='lexicon-icon-outline' d='M256 384c6.936-0.22 13.81-2.973 19.111-8.272l227.221-227.221c11.058-11.026 11.058-28.941 0-39.999-11.026-11.058-28.94-11.058-39.999 0l-206.333 206.333c0 0-206.333-206.333-206.333-206.333-11.059-11.058-28.973-11.058-39.999 0-11.059 11.058-11.059 28.972 0 39.999l227.221 227.221c5.3 5.3 12.174 8.053 19.111 8.272z'></path>" +
									"</svg>" +
								"</span>" +
							"</span>" +
						"</a>" +
	                    "<div class='panel-collapse collapse' id='prefilter%%INDEX%%Content' role='presentation' style=''>" +
		                    "<div class='panel-body'>" +
		                        "<div id='prefilters-content%%INDEX%%'>" +
                                    "<input class='field form-control' id='" + namespace + "nbPrefiltre%%INDEX%%' name='" + namespace + "nbPrefiltre%%INDEX%%' type='hidden' value='0'>" +
                                    "<input class='field form-control' id='" + namespace + "prefilterIndexes%%INDEX%%' name='" + namespace + "prefilterIndexes%%INDEX%%' type='hidden'>" +
                                "</div>" +
                                "<button class='btn btn-icon icon icon-plus icon-2x btn-default' id='" + namespace + "famg' onclick='addPrefilter(%%INDEX%%);' type='button'></button>" +
		                    "</div>" +
	                    "</div>" +
                    "</fieldset>" +
		        "</div>" +
	        "</div>" +
        "</fieldset>" +
	"</div>" +
"</div>";