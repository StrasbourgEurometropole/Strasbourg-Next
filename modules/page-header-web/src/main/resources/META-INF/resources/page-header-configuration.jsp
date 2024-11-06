<%@ include file="/page-header-init.jsp"%>

<%@ page import="com.liferay.portal.kernel.util.Constants"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="<%=true%>"
	var="configurationRenderURL" />

<aui:form action="<%=configurationActionURL%>" method="post" name="fm">

    <aui:input name="<%=Constants.CMD%>" type="hidden"
        value="<%=Constants.UPDATE%>" />

    <aui:input name="redirect" type="hidden"
        value="<%=configurationRenderURL%>" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">
            <div class="sheet">
                <div class="panel-group panel-group-flush">
                    <aui:fieldset>
                        <aui:input name="imageCredit" type="text" value="${imageCredit}" />
                    </aui:fieldset>

                    <aui:fieldset>
                        <aui:input name="titleMap" type="text" value="${title}" localized="true" />
                    </aui:fieldset>


                    <aui:fieldset>
                        <aui:input name="subTitleMap" type="text" value="${subTitle}" localized="true" />
                    </aui:fieldset>

                    <aui:fieldset>
                        <aui:input name="imageUrlMap" type="text" value="${imageUrl}" localized="true" />
                    </aui:fieldset>




                    <aui:fieldset>
                        <div class="display-template">
                            <liferay-ddm:template-selector
                                className="<%= LayoutSet.class.getName() %>"
                                displayStyle="${displayStyle}"
                                displayStyleGroupId="${displayStyleGroupId}"
                                refreshURL="${refreshURL}"
                                showEmptyOption="<%= true %>"
                            />
                        </div>
                    </aui:fieldset>
                </div>
            </div>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>