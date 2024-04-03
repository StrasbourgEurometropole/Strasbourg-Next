<%@ include file="/init.jsp" %>

<%@page import="eu.strasbourg.service.csmap.model.PlaceCategories"%>

<%-- URL : definit le lien menant vers la sauvegarde de l'entite --%>
<liferay-portlet:actionURL name="savePlaceCategories" varImpl="savePlaceCategoriesURL">
	<portlet:param name="cmd" value="savePlaceCategories" />
	<portlet:param name="tab" value="placeCategories" />
</liferay-portlet:actionURL>


<%-- Composant : Body --%>
<div class="container-fluid container-fluid-max-xl main-content-body">

	<%-- Composant : formulaire de saisie de l'entite --%>
	<aui:form action="${savePlaceCategoriesURL}" method="post" name="fm" onSubmit="submitForm(event);">

		<%-- Propriete : definit l'entite de reference pour le formulaire--%>
		<aui:model-context bean="${dc.placeCategories}" model="<%=PlaceCategories.class %>" />
		<div class="sheet"><div class="panel-group panel-group-flush">

            <%-- Champ : (cache) PK de l'entite --%>
            <aui:input name="placeCategoriesId" type="hidden" />

            <%-- Champ : CategoriesIds --%>
            <aui:fieldset collapsed="false" collapsible="true" label="csmap.bo.place.categories.select.title">

                <p style="font-style:italic"><liferay-ui:message key="csmap.bo.place.categories.select" /></p>

                <liferay-asset:asset-categories-selector
                    className="${dc.className}"
                    hiddenInput="Vocabulary"
                    categoryIds="${dc.placeCategories.getCategoriesIds()}" />

            </aui:fieldset>

            <aui:fieldset collapsed="true" collapsible="true" label="csmap.bo.place.gradient.title">
                <p><liferay-ui:message key="csmap.bo.place.gradient" /></p>
            </aui:fieldset>

            <aui:fieldset collapsed="true" collapsible="true" label="csmap.bo.place.picto.title">
                <p><liferay-ui:message key="csmap.bo.place.picto" /></p>
            </aui:fieldset>

		</div></div>

		<%-- Composant : Menu de gestion de l'entite --%>
		<aui:button-row>

			<aui:input type="hidden" name="workflowAction" value="" />

			<%-- Test : Verification des droits d'edition et de sauvegarde --%>
			<aui:button cssClass="btn-lg" type="submit" value="save" />

		</aui:button-row>

	</aui:form>

</div>

<liferay-util:html-bottom>

	<style>
	    label[id^='<portlet:namespace />assetCategoriesLabel_']{
	        display:none;
        }
	    div[id^='<portlet:namespace />sxvx___assetCategoriesSelector_']{
	        display:none;
	        margin-bottom: 30px;
        }

        label[id^='<portlet:namespace />assetCategoriesLabel_'] .icon-asterisk {
            display: none;
        }

	    #<portlet:namespace />assetCategoriesLabel_${dc.typeVocabularyId}{
	        display:block;
        }
	    #<portlet:namespace />sxvx___assetCategoriesSelector_${dc.typeVocabularyId}{
	        display:block;
        }
	</style>

	<script	src="/o/csmapboplace/js/main.js" type="text/javascript"></script>
</liferay-util:html-bottom>