<%@ include file="/search-activity-init.jsp"%>


<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<div class="container main-content-body">
	<aui:form action="<%=configurationActionURL%>" method="post" name="fm">
	
		<aui:input name="cmd" type="hidden"
			value="update" />
	
		<aui:input name="redirect" type="hidden"
			value="<%=configurationRenderURL%>" />
			
		<aui:fieldset>
<div class="row">
	<div class="col-8">
		<aui:select label="default-sort-field" name="sortingField" value="">
			<aui:option label="title" value="title" selected="${sortingField eq 'title'}"/>
			<aui:option label="order" value="order" selected="${sortingField eq 'order'}" />
		</aui:select>
	</div>
	<div class="col-4">
		<aui:select label="default-sort-type" name="sortingType" value="" >
			<aui:option label="desc" value="desc" selected="${sortingType eq 'desc'}"/>
			<aui:option label="asc" value="asc" selected="${sortingType eq 'asc'}" />
		</aui:select>
	</div>
</div>
			<!-- Affichage -->
			<aui:select name="template" label="display">
				<aui:option value="default" label="default" />
				<aui:option value="strasbourg" label="strasbourg" selected="${template eq 'strasbourg'}" />
				<aui:option value="strasbourg-no-schedule" label="strasbourg-no-schedule" selected="${template eq 'strasbourg-no-schedule'}" />
			</aui:select>
		
			<!-- ADT vignette -->
		    <div class="display-template">
		        <liferay-ddm:template-selector
		            className="<%= Activity.class.getName() %>"
		            displayStyle="${displayStyle}"
		            displayStyleGroupId="${displayStyleGroupId}"
		            refreshURL="${refreshURL}"
		            showEmptyOption="<%= true %>"
		        />
		    </div>
		    
		    <!-- Page de détail d'activité -->
			<strasbourg-picker:layout name="detailPageUuid" label="detail-page" 
				multiple="false" required="false" value="${detailPageUuid}" />
				
		    <!-- Page de détail de cours -->
			<strasbourg-picker:layout name="courseDetailPageUuid" label="course-detail-page" 
				multiple="false" required="false" value="${courseDetailPageUuid}" />

			<!-- Type d'activité -->
			<span class="categorySelector">
				<div id="activityTypeSelectorLabel">
					<label><liferay-ui:message key="activity-type" /></label>
				</div>
				<span>${courseTypeNames.replace('_CATEGORY_',' ')}</span>
				<aui:input type="hidden" name="activityTypeIds" value="${activityTypeIds}" />
			</div>

			<!-- Type de cours-->
			<div class="categorySelector">
				<div id="courseTypeSelectorLabel">
					<label><liferay-ui:message key="course-type" /></label>
				</div>
				<span>${activityTypeNames.replace('_CATEGORY_',' ')}</span>
				<aui:input type="hidden" name="courseTypeIds" value="${courseTypeIds}" />
			</div>

			<!-- Public -->
			<div class="categorySelector">
				<div id="publicSelectorLabel">
					<label><liferay-ui:message key="public" /></label>
				</div>
				<span>${publicNames.replace('_CATEGORY_',' ')}</span>
				<aui:input type="hidden" name="publicIds" value="${publicIds}" />
			</div>

			<!-- Territoire -->
			<div class="categorySelector">
				<div id="territorySelectorLabel">
					<label><liferay-ui:message key="territory" /></label>
				</div>
				<span>${territoryNames.replace('_CATEGORY_',' ')}</span>
				<aui:input type="hidden" name="territoryIds" value="${territoryIds}" />
			</div>
			
			<!-- Texte à afficher sous le moteur de recherche et avant les résultats -->
			<aui:input name="text" value="${textXML}" localized="true" type="editor" label="text" />
			
		</aui:fieldset>
	
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>


</div>
<style>
	.categorySelector {
		margin-bottom: 20px;
	}
</style>