<%@ include file="/mediatheque-init.jsp" %>

<section id="mediatheque">

	<c:if test="${dc.showDeleteButton()}">
		<button class="delete-wi" data-portlet-id="${themeDisplay.portletDisplay.id}"></button>
	</c:if>

    <h2>${title}</h2>
		<!-- Etape 2 Pas d'email renseigné -->
		<p align="center">
			<liferay-ui:message key="email-text" />
		</p>
	
		<div align="center">
			<a href="${dc.mediathequeURL}" class="btn-square--bordered--core" target="_blank" title="<liferay-ui:message key="site-mediatheques" /> (<liferay-ui:message key="eu.new-window" />)">
				<span class="flexbox">
					<span class="btn-text"><liferay-ui:message key="site-mediatheques" /></span>
					<span class="btn-arrow"></span>
				</span>
			</a>
		</div>
</section>