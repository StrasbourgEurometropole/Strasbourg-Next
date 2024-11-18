<!DOCTYPE html>
<html>
	<head>
		<style>
			header, main .official:first-child, h2, h2 + article{
				page-break-before: avoid;
			}

			header, main, h2, h3, .fonction, .charge, .adjoint{
				page-break-after: avoid;
			}

			header, .official, article, .fonction, .charge, .adjoint, .groupe, footer{
				page-break-inside:avoid;
			}

			html, body{
				margin: 0;
				font-size: 16px;
				font-family: Helvetica;
			}

			header{
				margin-bottom:10px;
			}

			h1{
				text-transform:uppercase;
				font-size:27px;
				font-weight:bold;
			}

			h2{
				font-size:22px;
				font-weight:bold;
				margin:10px 0 40px;
			}

			h3{
				font-size:22px;
				font-weight:bold;
				margin-bottom: 10px;
			}

			a{
				text-decoration:underline;
				color:#007bff;
			}

			strong{
				margin: 20px 0;
			}

			.table {
				clear: both;
			}

			.table .col1{
				float:left;
				min-width:22%;
				width:22%;
			}

			.table .col2{
				float: right;
				width:78%;
			}

			main .col2{
				border-bottom:solid 1px;
				padding-bottom:20px;
			}

			footer{
				border-top: solid #97bf0c 1px;
			}

			footer .col2{
				text-align: right;
			}
		</style>
	</head>
	<body>
		<header>
			<img width='100%' src='${domaine}/o/searchassetv2web/images/bandeau.jpg' />
			<h1 id="h1">${title}</h1>
		</header>
		<main>
			<#list officials as official>
				<section class='official table'>
					<div class='col1'>
						<img width='90px' src='${domaine}${official.getImageURL()?replace("&","&amp;")}' />
					</div>
					<div class='col2'>
						<h2 id="${official.getFirstName()}_${official.getLastName()}">
							${official.getFirstName()} ${official.getLastName()?upper_case}
						</h2>
						<#if isEMS>
							<#if official.isEluEurometropole()>
								<article>
									<h3 id="${official.getFirstName()}_${official.getLastName()}_ems">
										EUROMETROPOLE DE STRASBOURG
									</h3>
									<div class="fonction">
										<strong>${official.getName(official.getFonctionEurometropole(), locale)}</strong>
										<#if official.getFonctionTown()??>
											, ${official.getName(official.getFonctionTown(), locale)}
										</#if>
										<#if official.getTown()??>
											${commune} ${official.getTown().getTitle(locale)}
										</#if>
									</div>
									<#if official.getMissions()??>
										<div class="charge">
											${charge} : ${official.getMissions(locale)?replace("<p>","","f")?replace("</p>","","f")}
										</div>
									</#if>
									<#if official.getPoliticalGroupEurometropole()??>
										<div class="groupe">
											<strong>${groupe} : </strong><br/>
											${official.getName(official.getPoliticalGroupEurometropole(), locale)?replace("&","&amp;")}
										</div>
									</#if>
								</article>
							</#if>
							<#if official.isEluMunicipal()>
								<article>
									<h3 id="${official.getFirstName()}_${official.getLastName()}_strasbourg">
										VILLE DE STRASBOURG
									</h3>
									<strong class="fonction"> ${official.getName(official.getFonctionCity(), locale)}</strong>
									<#if official.getThematicDelegation()??>
										<div class="charge">
											${charge} : ${official.getThematicDelegation(locale)?replace("<p>","","f")?replace("</p>","","f")}
										</div>
									</#if>
									<#assign districts = official.getDistricts()>
									<#if districts?? && districts?size gt 0>
										<div class="adjoint">
											<strong>${adjoint} : </strong>
											<#list districts as district>
												${district.getName()}<#sep>, </#sep>
											</#list>
										</div>
									</#if>
									<#if official.getPoliticalGroupCity()??>
										<div class="groupe">
											<strong>${groupe}</strong><br/>
											${official.getName(official.getPoliticalGroupCity(), locale)?replace("&","&amp;")}
										</div>
									</#if>
								</article>
							</#if>
						<#else>
							<#if official.isEluMunicipal()>
								<article>
									<h3 id="${official.getFirstName()}_${official.getLastName()}_strasbourg">
										VILLE DE STRASBOURG
									</h3>
									<strong> ${official.getName(official.getFonctionCity(), locale)}</strong>
									<#if official.getThematicDelegation()??>
										<div>
											${charge} : ${official.getThematicDelegation(locale)?replace("<p>","","f")?replace("</p>","","f")}
										</div>
									</#if>
									<#assign districts = official.getDistricts()>
									<#if districts?? && districts?size gt 0>
										<div>
											<strong>${adjoint} : </strong>
											<#list districts as district>
												${district.getName()}<#sep>, </#sep>
											</#list>
										</div>
									</#if>
									<#if official.getPoliticalGroupCity()??>
										<div>
											<strong>${groupe}</strong><br/>
											${official.getName(official.getPoliticalGroupCity(), locale)?replace("&","&amp;")}
										</div>
									</#if>
								</article>
							</#if>
							<#if official.isEluEurometropole()>
								<article>
									<h3 id="${official.getFirstName()}_${official.getLastName()}_ems">
										EUROMETROPOLE DE STRASBOURG
									</h3>
									<div>
										<strong>${official.getName(official.getFonctionEurometropole(), locale)}</strong>
										<#if official.getFonctionTown()??>
											, ${official.getName(official.getFonctionTown(), locale)}
										</#if>
										<#if official.getTown()??>
											${commune} ${official.getTown().getTitle(locale)}
										</#if>
									</div>
									<#if official.getMissions()??>
										<div>
											${charge} : ${official.getMissions(locale)?replace("<p>","","f")?replace("</p>","","f")}
										</div>
									</#if>
									<#if official.getPoliticalGroupEurometropole()??>
										<div>
											<strong>${groupe} : </strong><br/>
											${official.getName(official.getPoliticalGroupEurometropole(), locale)?replace("&","&amp;")}
										</div>
									</#if>
								</article>
							</#if>
						</#if>
					</div>
				</section>
			</#list>
		</main>
		<footer class='table'>
			<div class='col1'>
				<#assign date = .now>
				${date?date}
			</div>
			<div class='col2'>
				<strong>${footerTitle}</strong><br/>
				${footerContent}
			</div>
		</footer>
	</body>
</html>