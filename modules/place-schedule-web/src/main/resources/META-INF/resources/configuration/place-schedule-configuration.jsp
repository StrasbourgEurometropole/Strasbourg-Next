<%@ include file="/place-schedule-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<div class="container-fluid-1280 main-content-body lfr-form-content">
	<aui:form action="${configurationActionURL}" method="post" name="fm">
	
		<aui:input name="cmd" type="hidden"
			value="update" />
	
		<aui:input name="redirect" type="hidden"
			value="${configurationRenderURL}" />
		
		<aui:fieldset>
			<select class="form-control" name="<portlet:namespace />categoryId" id="<portlet:namespace />categoryId">
				<c:forEach items="${categories}" var="category">
					<c:set var="selected" value="${category.categoryId eq categoryId ? 'selected' : ''}" />
					<option value="${category.categoryId}" ${selected}>${category.name}</option>
				</c:forEach>
			</select>
			<aui:input type="hidden" name="categoryId" />
		</aui:fieldset>
		
		<aui:fieldset>
			<aui:input name="textMap" value="${textSchedule}" localized="true" type="editor" label="text" />
		</aui:fieldset>
	
		<aui:fieldset>
			<strasbourg-picker:layout name="linksUuids" label="detail-page" multiple="false" required="true" value="${linksUuids}" />
		</aui:fieldset>

		<aui:fieldset>
			<!-- Mode d'affichage -->
			<aui:select name="template">
				<aui:option value="default" selected="${template eq 'default'}">
					<liferay-ui:message key="default" />
				</aui:option>
				<aui:option value="strasbourg" selected="${template eq 'strasbourg'}">
					Strasbourg.eu
				</aui:option>
				<aui:option value="strasbourg-table" selected="${template eq 'strasbourg-table'}">
					<liferay-ui:message key="strasbourg-table" />
				</aui:option>
				<aui:option value="strasbourg-int-table" selected="${template eq 'strasbourg-int-table'}">
					<liferay-ui:message key="strasbourg-int-table" />
				</aui:option>
			</aui:select>
		</aui:fieldset>

		<aui:fieldset>
            <aui:input type="checkbox" name="hideAffluence" value="${hideAffluence}" label="hide-affluence" />
        </aui:fieldset>
		
		<aui:button-row>
			<aui:button type="submit"></aui:button>
		</aui:button-row>
	</aui:form>
</div>
<style>
	fieldset {
		margin-bottom: 20px;
	}
</style>