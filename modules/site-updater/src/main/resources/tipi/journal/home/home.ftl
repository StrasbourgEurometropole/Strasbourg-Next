<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign themeDisplay = serviceContext.getThemeDisplay() />
<#if !themeDisplay.scopeGroup.publicLayoutSet.virtualHostnames?has_content || themeDisplay.scopeGroup.isStagingGroup()>
	<#assign homeURL = "/web${layout.group.friendlyURL}/" />
<#else>
	<#assign homeURL = "/" />
</#if>

<div class="menu-container">
	<a class="childhood-menu" href="javascript:window.location.replace('${homeURL}facturation-petite-enfance')"
	   style="background-image: url(${childhood.getData()});">
		Facturation petite enfance
	</a>
	<a class="schoolRestaurantAfterSchool-menu" href="javascript:window.location.replace('${homeURL}facturation-enfance')"
	   style="background-image: url(${schoolRestaurantAfterSchool.getData()});">
		Facturation Enfance (Cantine, ALM et APM)
	</a>
	<a class="water-menu" href="javascript:window.location.replace('${homeURL}facturation-eau-et-assainissement')"
	   style="background-image: url(${water.getData()});">
		Facturation eau et assainissement
	</a>
	<a class="rs-menu" href="javascript:window.location.replace('${homeURL}facturation-redevance-speciale-dechets')"
	   style="background-image: url(${rs.getData()});">
		Facturation Déchet Redevance Spéciale
	</a>
</div>