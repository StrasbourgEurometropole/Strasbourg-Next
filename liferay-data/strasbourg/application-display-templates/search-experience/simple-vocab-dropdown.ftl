<#assign vocabularyNames = assetCategoriesSearchFacetDisplayContext.getVocabularyNames() />
<#if vocabularyNames?has_content>
    <#list vocabularyNames as vocabularyName>

        <#assign terms = assetCategoriesSearchFacetDisplayContext.getBucketDisplayContexts(vocabularyName) />
        <div class="st-filtre st-group-field st--is-select">
            <label for="${vocabularyName + vocabularyName?index}" >
                ${vocabularyName}
            </label>
            <div class="st-field-select">
                <select id="${vocabularyName + vocabularyName?index}" name="${assetCategoriesSearchFacetDisplayContext.getParameterName()}">
                    <option value=""></option>
                    <#list terms as term>
                        <option value="${term.getFilterValue()}" ${term.isSelected()?string('selected', '')}>${term.getBucketText()}</option>
                    </#list>
                </select>
            </div>
        </div>
    </#list>
</#if>