<p>
	Un nouvel enregistrement sur le formulaire de contact<#if type == "Event"> de l’événement "${title}"<#elseif type == "Place"> du lieu ${title}<#elseif type == "Official"> de l'élu ${title}</#if> a été réalisé le ${date} à ${time}. Voici le récapitulatif des données saisies :
</p>
<#if type == "Official">
	<p><strong>Élu</strong> : ${title}</p>
</#if>
<p><strong>Nom</strong> : ${lastName}</p>
<p><strong>Prénom</strong> : ${firstName}</p>
<p><strong>Mail</strong> : ${emailFrom}</p>
<p><strong>Message</strong> :</p>
<p>${content}</p>