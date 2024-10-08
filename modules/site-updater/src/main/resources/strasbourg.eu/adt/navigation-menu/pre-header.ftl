<ul class="st-nav-primary__menu">
                <#if entries?has_content>
                    <#list entries as navigationEntry>
											<#if navigationEntry.isBrowsable()>
												<#if navigationEntry?is_last>
													<li class="st-has-btn-compte">
														<a href="${navigationEntry.getURL()}" class="st-btn-compte">
													   ${navigationEntry.getName()}
														</a>
													</li>
													<#else>
												<li class="st-nav-primary__item">
                            <a href="${navigationEntry.getURL()}" class="st-nav-primary__link">${navigationEntry.getName()}</a>
                        </li>
												</#if>
												</#if>
                    </#list>

                </#if>
            </ul>