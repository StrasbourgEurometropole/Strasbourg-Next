<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
	String randomId = StringUtil.randomId();
	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);
	if (Validator.isNull(backURL)) {
		backURL = request.getHeader(WebKeys.REFERER);
	}
	String languageId = LanguageUtil.getLanguageId(request);
	WorkflowTask workflowTask = workflowTaskDisplayContext.getWorkflowTask();
	long classPK = workflowTaskDisplayContext.getWorkflowContextEntryClassPK(workflowTask);
	WorkflowHandler<?> workflowHandler = workflowTaskDisplayContext.getWorkflowHandler(workflowTask);
	AssetRenderer<?> assetRenderer = workflowHandler.getAssetRenderer(classPK);
	AssetRendererFactory<?> assetRendererFactory = null;
	AssetEntry assetEntry = null;
	if (assetRenderer != null) {
		assetRendererFactory = assetRenderer.getAssetRendererFactory();
		if (assetRendererFactory != null) {
			assetEntry = assetRendererFactory.getAssetEntry(workflowHandler.getClassName(), assetRenderer.getClassPK());
		}
		String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();
		if (ArrayUtil.isNotEmpty(availableLanguageIds) && !ArrayUtil.contains(availableLanguageIds, languageId)) {
			languageId = assetRenderer.getDefaultLanguageId();
		}
	}
	portletDisplay.setShowBackIcon(true);
	portletDisplay.setURLBack(backURL);
	renderResponse.setTitle(workflowTaskDisplayContext.getHeaderTitle(workflowTask));
%>

<clay:container-fluid>
	<clay:col
			cssClass="lfr-asset-column lfr-asset-column-details"
	>
		<liferay-ui:success key='<%= workflowTaskDisplayContext.getPortletResource() + "requestProcessed" %>' message="your-request-completed-successfully" />

		<liferay-ui:error exception="<%= WorkflowTaskDueDateException.class %>" message="please-enter-a-valid-due-date" />

		<div class="sheet">
			<div class="panel-group panel-group-flush">
				<aui:fieldset>

					<%
						request.removeAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
					%>

					<liferay-util:include page="/workflow_task_action.jsp" servletContext="<%= application %>">
						<liferay-util:param name="mvcPath" value="/edit_workflow_task.jsp" />
					</liferay-util:include>

					<clay:col
							md="6"
					>
						<aui:field-wrapper label="assigned-to">
							<aui:fieldset>
								<div class="align-items-center card-row">
									<c:choose>
										<c:when test="<%= workflowTask.isAssignedToSingleUser() %>">
											<div class="card-col-field mr-2">
												<div class="list-group-card-icon">
													<liferay-ui:user-portrait
															userId="<%= workflowTask.getAssigneeUserId() %>"
													/>
												</div>
											</div>

											<div class="card-col-content card-col-gutters">
												<div class="lfr-asset-assigned">
													<%= HtmlUtil.escape(workflowTaskDisplayContext.getWorkflowTaskAssigneeUserName(workflowTask)) %>
												</div>
											</div>
										</c:when>
										<c:otherwise>
											<div class="card-col-content card-col-gutters lfr-asset-assigned">
												<div class="lfr-asset-assigned">
													<%= workflowTaskDisplayContext.getWorkflowTaskUnassignedUserName() %>
												</div>
											</div>
										</c:otherwise>
									</c:choose>
								</div>
							</aui:fieldset>
						</aui:field-wrapper>

						<aui:field-wrapper label="task-name">
							<aui:fieldset>
								<%= workflowTask.getLabel(workflowTaskDisplayContext.getTaskContentLocale()) %>
							</aui:fieldset>
						</aui:field-wrapper>
					</clay:col>

					<clay:col
							md="6"
					>
						<aui:field-wrapper label="create-date">
							<aui:fieldset>
								<%= workflowTaskDisplayContext.getCreateDateString(workflowTask) %>
							</aui:fieldset>
						</aui:field-wrapper>

						<aui:field-wrapper label="due-date">
							<aui:fieldset>
								<%= workflowTaskDisplayContext.getDueDateString(workflowTask) %>
							</aui:fieldset>
						</aui:field-wrapper>
					</clay:col>

					<c:if test="<%= Validator.isNotNull(workflowTask.getDescription()) %>">
						<clay:col>
							<aui:field-wrapper label="description">
								<aui:fieldset>
									<%= workflowTaskDisplayContext.getDescription(workflowTask) %>
								</aui:fieldset>
							</aui:field-wrapper>
						</clay:col>
					</c:if>
				</aui:fieldset>

				<liferay-ui:panel-container
						cssClass="task-panel-container"
						extended="<%= false %>"
				>
					<c:if test="<%= assetRenderer != null %>">
						<liferay-ui:panel
								extended="<%= true %>"
								markupView="lexicon"
								title="<%= workflowTaskDisplayContext.getPreviewOfTitle(workflowTask) %>"
						>
							<c:if test="<%= assetRenderer.isLocalizable() %>">
								<div class="locale-actions">
									<liferay-ui:language
											formAction="<%= currentURL %>"
											languageId="<%= languageId %>"
											languageIds="<%= assetRenderer.getAvailableLanguageIds() %>"
									/>
								</div>
							</c:if>

							<div class="task-content-actions">
								<c:if test="<%= assetRenderer.hasViewPermission(permissionChecker) %>">
									<portlet:renderURL var="viewFullContentURL">
										<portlet:param name="mvcPath" value="/view_content.jsp" />
										<portlet:param name="redirect" value="<%= currentURL %>" />
										<portlet:param name="languageId" value="<%= languageId %>" />

										<c:if test="<%= assetEntry != null %>">
											<portlet:param name="assetEntryId" value="<%= String.valueOf(assetEntry.getEntryId()) %>" />
											<portlet:param name="assetEntryClassPK" value="<%= String.valueOf(assetEntry.getClassPK()) %>" />
										</c:if>

										<c:if test="<%= assetRendererFactory != null %>">
											<portlet:param name="type" value="<%= assetRendererFactory.getType() %>" />
										</c:if>

										<portlet:param name="showEditURL" value="<%= String.valueOf(workflowTaskDisplayContext.isShowEditURL(workflowTask)) %>" />
										<portlet:param name="workflowTaskId" value="<%= String.valueOf(workflowTask.getWorkflowTaskId()) %>" />
									</portlet:renderURL>
									<!--  Modification SULLY-GROUP   -->
									<!-- Si possibilité d'avoir la prévisualisation dans le contexte, alors le bouton le fait directement -->
									<%
										String viewInContextURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, null);
									%>
									<c:choose>
										<c:when test="<%= viewInContextURL != null %>">
											<liferay-ui:icon
													data='<%= Collections.singletonMap("title", "View") %>'
													icon="view"
													label="<%= false %>"
													linkCssClass="btn btn-monospaced btn-outline-secondary"
													markupView="lexicon"
													message="view[action]"
													toolTip="<%= true %>"
													url="<%= viewInContextURL %>"
											/>
										</c:when>
										<c:when test="<%= viewInContextURL == null %>">
											<liferay-ui:icon
													data='<%= Collections.singletonMap("title", "View") %>'
													icon="view"
													label="<%= false %>"
													linkCssClass="btn btn-monospaced btn-outline-secondary"
													markupView="lexicon"
													message="view[action]"
													toolTip="<%= true %>"
													url="<%= viewFullContentURL.toString() %>"
											/>
										</c:when>
									</c:choose>
									<!-- Fin Modification SULLY-GROUP   -->



									<c:if test="<%= workflowTaskDisplayContext.hasViewDiffsPortletURL(workflowTask) %>">
										<liferay-ui:icon
												icon="paste"
												label="<%= false %>"
												linkCssClass="btn btn-monospaced btn-outline-secondary"
												markupView="lexicon"
												message="diffs"
												toolTip="<%= true %>"
												url="<%= workflowTaskDisplayContext.getTaglibViewDiffsURL(workflowTask) %>"
										/>
									</c:if>

									<c:if test="<%= assetEntry != null %>">
										<portlet:renderURL var="viewLayoutClassedModelUsagesURL">
											<portlet:param name="mvcPath" value="/view_layout_classed_model_usages.jsp" />
											<portlet:param name="redirect" value="<%= currentURL %>" />
											<portlet:param name="className" value="<%= assetEntry.getClassName() %>" />
											<portlet:param name="classPK" value="<%= String.valueOf(assetEntry.getClassPK()) %>" />
											<portlet:param name="workflowTaskId" value="<%= String.valueOf(workflowTask.getWorkflowTaskId()) %>" />
										</portlet:renderURL>

										<liferay-ui:icon
												icon="list"
												label="<%= false %>"
												linkCssClass="btn btn-monospaced btn-outline-secondary"
												markupView="lexicon"
												message="view-usages"
												toolTip="<%= true %>"
												url="<%= viewLayoutClassedModelUsagesURL %>"
										/>
									</c:if>
								</c:if>

								<c:if test="<%= workflowTaskDisplayContext.hasEditPortletURL(workflowTask) %>">
									<c:choose>
										<c:when test="<%= assetRenderer.hasEditPermission(permissionChecker) && workflowTaskDisplayContext.isShowEditURL(workflowTask) %>">
											<liferay-ui:icon
													icon="pencil"
													label="<%= false %>"
													linkCssClass="btn btn-monospaced btn-outline-secondary"
													markupView="lexicon"
													message="edit"
													toolTip="<%= true %>"
													url="<%= workflowTaskDisplayContext.getTaglibEditURL(workflowTask) %>"
											/>
										</c:when>
										<c:when test="<%= assetRenderer.hasEditPermission(permissionChecker) && !workflowTaskDisplayContext.isShowEditURL(workflowTask) && !workflowTask.isCompleted() %>">
											<liferay-ui:icon
													icon="question-circle-full"
													iconCssClass="btn btn-monospaced btn-outline-secondary"
													label="<%= false %>"
													markupView="lexicon"
													message="please-assign-the-task-to-yourself-to-be-able-to-edit-the-content"
													toolTip="<%= true %>"
											/>
										</c:when>
									</c:choose>
								</c:if>
							</div>

							<h3 class="task-content-title">
								<liferay-ui:icon
										icon="<%= workflowHandler.getIconCssClass() %>"
										label="<%= true %>"
										markupView="lexicon"
										message="<%= HtmlUtil.escape(workflowTaskDisplayContext.getAssetTitle(workflowTask)) %>"
								/>
							</h3>

							<liferay-asset:asset-display
									assetRenderer="<%= assetRenderer %>"
									template="<%= AssetRenderer.TEMPLATE_ABSTRACT %>"
							/>

							<c:if test="<%= assetEntry != null %>">
								<h4 class="task-content-author">
									<liferay-ui:message key="author" />
								</h4>

								<liferay-asset:asset-metadata
										className="<%= assetEntry.getClassName() %>"
										classPK="<%= assetEntry.getClassPK() %>"
										metadataFields='<%= new String[] {"author", "categories", "tags"} %>'
								/>
							</c:if>
						</liferay-ui:panel>

						<c:if test="<%= (assetEntry != null) && workflowHandler.isCommentable() %>">

							<%
								long discussionClassPK = workflowHandler.getDiscussionClassPK(workflowTask.getOptionalAttributes());
							%>

							<liferay-ui:panel
									extended="<%= true %>"
									markupView="lexicon"
									title="comments"
							>
								<liferay-comment:discussion
										assetEntryVisible="<%= false %>"
										className="<%= assetRenderer.getClassName() %>"
										classPK="<%= discussionClassPK %>"
										formName='<%= "fm" + discussionClassPK %>'
										ratingsEnabled="<%= false %>"
										redirect="<%= currentURL %>"
										userId="<%= user.getUserId() %>"
								/>
							</liferay-ui:panel>
						</c:if>
					</c:if>

					<liferay-ui:panel
							markupView="lexicon"
							title="activities"
					>
						<%@ include file="/workflow_logs.jspf" %>
					</liferay-ui:panel>
				</liferay-ui:panel-container>
			</div>
		</div>
	</clay:col>
</clay:container-fluid>

<aui:script use="liferay-workflow-tasks">
	var onTaskClickFn = A.rbind('onTaskClick', Liferay.WorkflowTasks, '');

	Liferay.delegateClick(
	'<portlet:namespace /><%= randomId %>taskAssignLink',
	onTaskClickFn
	);
</aui:script>