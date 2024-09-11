<%@page import="eu.strasbourg.utils.LayoutHelper"%>
<%@include file="/picker-init.jsp" %>

<%-- Boucle pour chaque langue - si on n'est pas en multilingue, une seule langue existe (celle par d�faut) --%>
<c:forEach var="currentLocale" items="${availableLocales}" varStatus="status">
	<div class="strasbourg-layout-picker picker-${name} ${currentLocale} <c:if test="${currentLocale eq defaultLocale}">active</c:if> form-group">
		<p>
			<label>
				<liferay-ui:message key="${label}" />
				<c:if test="${localized}">
					(${currentLocale.displayLanguage})
				</c:if>
				<c:if test="${required}">
					<span class="icon-asterisk text-warning"> 
						<span class="sr-only"><liferay-ui:message key="required" /></span>
					</span>
				</c:if>
			</label>
		</p>
		<%--Boucle qui liste les layouts pour la langue courante --%>
		<ul id="layouts-thumbnails-${name}-${currentLocale}">
			<c:forEach items="${locale_layouts[currentLocale]}" var="layout">
				<li>
					${layoutHelper.getLayoutPath(layout, locale)} - <a href="#" class="remove-layout" data-entry-id="${layout.uuid}">Supprimer</a>
				</li>
			</c:forEach>
		</ul>
		<p>
			<aui:button name="choose-layout-${name}-${currentLocale}" id="choose-layout-${name}-${currentLocale}" value="${multiple ? 'add' : 'choose'}" />
		</p>
		<%-- Champ hidden contenant les donn�es qui seront utilis�es ensuite par le contr�leur --%>
		<div class="has-error">
			<c:if test="${localized}">
				<aui:input name="${name}_${currentLocale}" type="hidden" value="${locale_layoutsUuids[currentLocale]}">
					<c:if test="${required}">
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</c:if>
				</aui:input>
			</c:if>
			<c:if test="${not localized}">
				<aui:input name="${name}" type="hidden" value="${locale_layoutsUuids[currentLocale]}">
					<c:if test="${required}">
						<aui:validator name="required"
							errorMessage="this-field-is-required" />
					</c:if>
				</aui:input>
			</c:if>
		</div>
	</div>
	<aui:script>
	// JS g�rant l'ouverture du popup de selection du fichier
	$('#<portlet:namespace />choose-layout-${name}-${currentLocale}').on('click',
		function(event) {
			var multipleSelection = ${multiple};
			var localized = ${localized};
			var fieldName = localized ? '#<portlet:namespace />${name}_${currentLocale}' : '#<portlet:namespace />${name}';
			Liferay.Util.openSelectionModal(
				{
					selectEventName: 'itemSelected${name}${currentLocale.language}',
					// Ev�nement d�clench� lors de la s�lection d'un fichier
					onSelect: function(selectedItem) {
						if (!!selectedItem && !!selectedItem.id) {
							var htmlToAppend = '<li>'
								+ selectedItem.name + ' - <a href="#" class="remove-layout" data-entry-id="' + selectedItem.id + '">Supprimer</a>';
								+ '</li>';
							if (!multipleSelection) {
								$('#layouts-thumbnails-${name}-${currentLocale}').empty();
							}
							$('#layouts-thumbnails-${name}-${currentLocale}').append(htmlToAppend);
							if (!multipleSelection) {
								$(fieldName).val(selectedItem.id);
							} else {
								var currentValue = $(fieldName).val();
								var newValue = currentValue;
								if (currentValue.length > 0) {
									newValue += ',';
								}
								newValue += selectedItem.id;
								$(fieldName).val(newValue);
							}
						}
					},
					title: '<liferay-ui:message key="layout"/>',
					<c:set var="itemSelectorURLVarName" value="itemSelectorURL${currentLocale.language}" />
					url: '${requestScope[itemSelectorURLVarName]}'
				}
			);
		}
	);
	// Suppression d'un fichier
	$('#layouts-thumbnails-${name}-${currentLocale}').on('click', '.remove-layout', function(e) {
		e.preventDefault();
		var localized = ${localized};
		var fieldName = localized ? '#<portlet:namespace />${name}_${currentLocale}' : '#<portlet:namespace />${name}';
		var valueToRemove = $(this).data('entry-id');
		$(this).parent().remove();
		var currentValue = $(fieldName).val();
		var newValue = currentValue.replace(valueToRemove, '');
		newValue = newValue.replace(',,', ',');
		if (newValue[0] === ',') {
			newValue = newValue.slice(1);
		}
		if (newValue[newValue.length - 1] == ',') {
			newValue = newValue.slice(0, -1);
		}
		$(fieldName).val(newValue);
	});
	</aui:script>
</c:forEach>
<%-- 
	Si le champ est localis�, on masque les champs par d�faut et on affiche ceux qui ont la classe "active"
	La gestion du toggle de la classe "active" est g�r� par le JS du module utilisateur
--%>
<c:if test="${localized}">
	<style>
		.picker-${name} {
			display: none;
		}
		.picker-${name}.active {
			display: block;
		}
	</style>
</c:if>