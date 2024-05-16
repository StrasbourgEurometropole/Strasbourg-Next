<#if headerImage?has_content>
	<img src="${headerImage}">
</#if>



<p>Bonjour,<br><br>

Vous venez de soumettre des informations sur le formulaire "${formName}". Vous trouverez ci-dessous la liste des informations saisies.</p>
<br>
<p><strong>Nom</strong> : ${lastName}</p>
<p><strong>Pr�nom</strong> : ${firstName}</p>
<p><strong>Mail</strong> : ${emailFrom}</p>
<p><strong>Message</strong> :</p>
<p>${content}</p>

<p>Date et heure de soumission du formulaire : ${date} ${time}</p>

<p>Votre demande sera trait�e dans les meilleurs d�lais.</p>

<p>
	Cordialement,<br><br>
	La Ville et l'Eurom�tropole de Strasbourg<br>
	
	<a href="https://www.strasbourg.eu">www.strasbourg.eu</a>
</p>

<#if footerImage?has_content>
	<img src="${headerImage}">
</#if>
