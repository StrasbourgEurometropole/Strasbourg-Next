<!DOCTYPE html>
<html>
	<head>
		<style>

			html{
				font-size: 14px;
				line-height: 18px;
				font-family: Helvetica;
			}

			header{
				font-size: 16px;
				font-weight: bold;
			}

			.title{
				margin: 14px 0;
			}

			.subtitle{
				margin-bottom: 14px;
			}

			.message{
				color: red;
				font-size: 13.5px;
				margin-bottom: 24px;
			}

			table {
				border-collapse: collapse;
				width: 100%;
				font-weight: normal;
				text-align: center;
				vertical-align: center;
			}

			table tr{
				min-height: 28px;
			}

			table td{
				border: solid black 1px;
			}

			.no-border{
				border: none;
			}

			.max-120{
				max-width: 120px;
			}

			.max-80{
				max-width: 80px;
			}

			.max-50{
				max-width: 50px;
			}

			.max-30{
				max-width: 30px;
			}

			.header{
				background-color: #dddddd;
			}

			.asterisk{
				font-weight: normal;
				font-style: italic;
				margin-top: 7px;
				font-size: 13px;
			}
		</style>
	</head>
	<body>
		<header>
			<center>
				<img width="190px" src='${domaine}/o/councilbo/images/logo_strasbourg_vert.jpg' />
				<p class="title">${title}</p>
				<p class="subtitle">Historique des procurations</p>
				<#if isStillOpen>
					<p class="message">Des procurations sont encore ouvertes, veuillez toutes les fermer en fin de conseil pour permettre le recalcul</p>
				</#if>
			</center>
		</header>
		<main>
			<table>
				<tr>
					<td colspan="4" class="no-border"></td>
					<td colspan="2" class="header">DEBUT</td>
					<td colspan="2" class="header">FIN</td>
				</tr>
				<tr>
					<td class="header max-120">Votant</td>
					<td class="header max-80">Mode de procuration</td>
					<td class="header max-50">Présentiel</td>
					<td class="header max-120">Bénéficiaire procuration</td>
					<td class="header max-30">Heure</td>
					<td class="header max-30">Du point</td>
					<td class="header max-30">Heure</td>
					<td class="header max-30">Au point</td>
				</tr>
				<#list procurations as procuration>
					<tr>
						<td>${procuration.votant}</td>
						<td>${procuration.procurationModeValue}</td>
						<td>${procuration.presential}</td>
						<td>${procuration.officialVoterValue}</td>
						<td>${procuration.startTime}</td>
						<td>${procuration.startDelibValue}</td>
						<td>${procuration.endTime}</td>
						<td>${procuration.endDelibValue}</td>
					</tr>
				</#list>
			</table>
		</main>
		<footer>
			<p class="asterisk">AV : Intervenu Après le vote</p>
		</footer>
	</body>
</html>