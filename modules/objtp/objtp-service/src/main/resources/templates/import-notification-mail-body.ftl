#### Import des catégories ####

<#if report.objectCategoryStatus == 0>
	L'import des catégories d'objets trouvés n'a pas pu être fait pour la raison suivante :
	
	${report.globalErrorCauseObjectCategory}
</#if>
<#if report.objectCategoryStatus != 0>
	L'import des catégories d'objets trouvés a été réalisé avec succès le ${report.endDate?date} à ${report.endDate?time}.

	${report.errorObjectCategoryCount} catégorie<#if (report.errorObjectCategoryCount > 1)>s</#if> d'objets trouvés en erreur

<#list report.reportLinesObjectCategory as category>
	- ${category.number} : ${category.logs}
</#list>

	<#assign createdObjectCategoryCount = report.totalObjectCategoryCount - report.errorObjectCategoryCount />
	${createdObjectCategoryCount} catégorie<#if (createdObjectCategoryCount > 1)>s</#if> d'objets trouvés créée<#if (createdObjectCategoryCount > 1)>s</#if>
</#if>


#### Import des objets trouvés ####
<#if report.foundObjectStatus == 0>
	L'import des objets trouvés n'a pas pu être fait pour la raison suivante :

	${report.globalErrorCauseFoundObject}
</#if>

<#if report.foundObjectStatus != 0>
	L'import des objets trouvés a été réalisé avec succès le ${report.endDate?date} à ${report.endDate?time}.

	${report.errorFoundObjectCount} objet<#if (report.errorFoundObjectCount > 1)>s</#if> en erreur

<#list report.reportLinesFoundObject as object>
	- ${object.number} : ${object.logs}
</#list>


	${report.createdFoundObjectCount} objet<#if (report.createdFoundObjectCount > 1)>s</#if> créé<#if (report.createdFoundObjectCount  > 1)>s</#if>

	${report.modifiedFoundObjectCount} objet<#if (report.modifiedFoundObjectCount > 1)>s</#if> modifié<#if (report.modifiedFoundObjectCount  > 1)>s</#if>

	${report.unmodifiedFoundObjectCount} objet<#if (report.unmodifiedFoundObjectCount > 1)>s</#if> non modifié<#if (report.unmodifiedFoundObjectCount  > 1)>s</#if>

	Détail par catégories :
<#list report.reportLinesImageCount?keys as category>
	<#assign counts = report.reportLinesImageCount[category] />
	- Catégorie « ${category} » : ${counts[0]} objets sans image pour ${counts[0] + counts[1]} objets au total
</#list>
</#if>