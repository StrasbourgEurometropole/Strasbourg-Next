<%@ include file="/social-init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />

<liferay-portlet:renderURL portletConfiguration="true"
	var="configurationRenderURL" />

<aui:form action="${configurationActionURL}" method="post" name="fm">
    <aui:input name="cmd" type="hidden"
        value="update" />

    <aui:input name="redirect" type="hidden"
        value="${configurationRenderURL}" />

    <div class="portlet-configuration-body-content">
        <div class="container-fluid-1280">
            <aui:fieldset-group markupView="lexicon">

                <aui:fieldset id="twitter" label="twitter">
                    <aui:input type="text" name="twitterAccount" value="${twitterAccount}" label="twitter-account" />
                </aui:fieldset>

                <aui:fieldset id="instagram" label="instagram">
                    <aui:input type="text" name="instagramToken" value="${instagramToken}" label="instagram-token" />
                    <aui:input type="text" name="instagramCreateDate" value="${instagramCreateDate}" label="instagram-create-date" />
                </aui:fieldset>

                <aui:fieldset id="dailymotion" label="dailymotion">
                    <aui:input type="text" name="dailymotionAccountId" value="${dailymotionAccountId}" label="dailymotion-account-id" />
                </aui:fieldset>

                <aui:fieldset id="facebook" label="facebook">
                    <aui:input type="text" name="facebookToken" value="${facebookToken}" label="facebook-token" />
                </aui:fieldset>

                <aui:fieldset id="general" label="general">
                    <aui:input type="number" name="postCount" value="${postCount}" label="post-count" />

                    <aui:select name="template" label="display">
                        <aui:option value="default" label="Strasbourg.eu" />
                        <aui:option value="christmas" label="christmas" selected="${template eq 'christmas'}"/>
                        <aui:option value="webmag" label="webmag" selected="${template eq 'webmag'}"/>
                    </aui:select>
                </aui:fieldset>

            </aui:fieldset-group>
        </div>
    </div>

    <aui:button-row>
        <aui:button type="submit"></aui:button>
    </aui:button-row>
</aui:form>