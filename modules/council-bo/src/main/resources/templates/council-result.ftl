<!DOCTYPE html>
<html>
	<head>
		<style>
			@page {
				size: A4 landscape;
				margin: 0;
			}

			*{
				margin: 0;
			}

			html{
				margin: 50px 0;
				font-size: 16px;
				font-family: Helvetica;
				font-weight: bold;
				line-height: 22px;
			}

			.title{
				margin-bottom: 12px;
			}

			.subtitle{
				font-weight:normal;
				font-size: 18px;
			}

			table {
				border-collapse: collapse;
				width: 100%;
			}

			header table{
				margin-bottom: 90px;
				vertical-align: top;
			}

			header table tr td:last-child{
				text-align: center;
			}

			main table{
				margin-left: 3px;
			}

			main table .nb{
				border: solid black 3px;
				padding-top: 5px;
				vertical-align: top;
			}

			.pour .nb{
				background-color: #99cc00;
				height: ${hauteur_pour}px;
			}

			.contre .nb{
				background-color: #ff0000;
				height: ${hauteur_contre}px;
			}

			.abstention .nb{
				background-color: #558ed5;
				height: ${hauteur_abstention}px;
			}

			main .nb table{
				margin: 0;
				text-align: center;
				vertical-align: top;
			}

			main .nb table tr:first-child{
				font-size: 20px;
				vertical-align: top;
			}

			.pour table tr:first-child{
				height: ${(hauteur_pour - 45)/2}px;
			}

			.contre table tr:first-child{
				height: ${(hauteur_contre - 45)/2}px;
			}

			.abstention table tr:first-child{
				height: ${(hauteur_abstention - 45)/2}px;
			}

			main .nb table tr:last-child{
				font-size: 40px;
			}

			main table .name{
				padding-left: 5px;
			}

			.pour .name{
				color: #55683b;
			}

			.contre .name{
				color: #ff0000;
			}

			.abstention .name{
				color: #634d7c;
			}
		</style>
	</head>
	<body>
		<header>
			<table>
				<tr>
					<td>
						<img width="185px" src='${domaine}/o/councilbo/images/logo_strasbourg_vert.jpg' />
					</td>
					<td>
						<p class="title">${title}</p>
						<p class="subtitle">${subtitle}</p>
					</td>
				</tr>
			</table>
		</header>
		<main>
			<table>
				<tr class="pour">
					<td class="nb">
						<table>
							<tr>
								<td>Pour</td>
							</tr>
							<tr>
								<td>
									${pour?size}
								</td>
							</tr>
						</table>
					</td>
					<td class="name">${pour?join(", ")}</td>
				</tr>
				<tr class="contre">
					<td class="nb">
						<table>
							<tr>
								<td>Contre</td>
							</tr>
							<tr>
								<td>
									${contre?size}
								</td>
							</tr>
						</table>
					</td>
					<td class="name">${contre?join(", ")}</td>
				</tr>
				<tr class="abstention">
					<td class="nb">
						<table>
							<tr>
								<td>Abstention</td>
							</tr>
							<tr>
								<td>
									${abstention?size}
								</td>
							</tr>
						</table>
					</td>
					<td class="name">${abstention?join(", ")}</td>
				</tr>
			</table>
		</main>
	</body>
</html>