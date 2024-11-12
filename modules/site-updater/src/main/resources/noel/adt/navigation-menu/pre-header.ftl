<#if entries?has_content>
	<div class="menu">
		<#list entries as navigationEntry>
			<div>
				<${navigationEntry.hasBrowsableChildren()?then("span tabindex='0' role='button' aria-expanded='false' aria-controls='control-"+navigationEntry?counter+"'","a")}  ${navigationEntry.hasBrowsableChildren()?then("", "href='"+navigationEntry.getURL()+"'")} class="mns-w-fixe-2">${navigationEntry.getName()}</${navigationEntry.hasBrowsableChildren()?then("span","a")}>
				<#if navigationEntry.hasBrowsableChildren()>
					<ul class="sub-menu control-${navigationEntry?counter}">
						<#list navigationEntry.getBrowsableChildren() as nav_item>
							<li>
								<a href="${nav_item.isBrowsable()?then(nav_item.getURL(),"#")}" class="mns-w-fixe-2" >${nav_item.getName()}</a>
							</li>
						</#list>
					</ul>
				</#if>
			</div>
		</#list>
	</div>
</#if>