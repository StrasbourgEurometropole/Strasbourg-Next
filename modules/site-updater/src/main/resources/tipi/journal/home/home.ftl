<#assign serviceContext = staticUtil["com.liferay.portal.kernel.service.ServiceContextThreadLocal"].getServiceContext() />
<#assign themeDisplay = serviceContext.getThemeDisplay() />

<div class="menu-container">
	<a class="childhood-menu" href="javascript:window.location.replace('${strasbourg.homeURL()}facturation-petite-enfance')"
	   style="background-image: url(${childhood.getData()});">
		Facturation petite enfance
	</a>
	<a class="schoolRestaurantAfterSchool-menu" href="javascript:window.location.replace('${strasbourg.homeURL()}facturation-enfance')"
	   style="background-image: url(${schoolRestaurantAfterSchool.getData()});">
		Facturation Enfance (Cantine, ALM et APM)
	</a>
	<a class="water-menu" href="javascript:window.location.replace('${strasbourg.homeURL()}facturation-eau-et-assainissement')"
	   style="background-image: url(${water.getData()});">
		Facturation eau et assainissement
	</a>
	<a class="rs-menu" href="javascript:window.location.replace('${strasbourg.homeURL()}facturation-redevance-speciale-dechets')"
	   style="background-image: url(${rs.getData()});">
		Facturation Déchet Redevance Spéciale
	</a>
</div>