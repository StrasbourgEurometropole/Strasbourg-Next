<%@ include file="/entity-detail-init.jsp" %>

<c:if test="${not empty entry}">
	<liferay-ddm:template-renderer
	    className="${entry.className}"
	    contextObjects="${contextObjects}"
	    displayStyle="${displayStyle}"
	    displayStyleGroupId="${displayStyleGroupId}"
	    entries="${entries}"
	>
		<liferay-asset:asset-display
			assetEntry="${entry}"
			assetRenderer="${entry.assetRenderer}"
			assetRendererFactory="${entry.assetRendererFactory}"
			template="full_content"
		/>

	</liferay-ddm:template-renderer>
</c:if>
<c:if test="${empty entry}">
	${notFoundHTML}
</c:if>