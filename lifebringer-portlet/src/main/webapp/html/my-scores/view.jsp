<%@include file="init.jsp"%>
<%
	if (themeDisplay.isSignedIn()) {
		int count = GameScoreServiceUtil.countGameScoreByUserId(scopeGroupId, user.getUserId());
		if (count > 0) {
%>
<liferay-ui:search-container emptyResultsMessage="No games" >
	<liferay-ui:search-container-results
		results="<%= GameScoreServiceUtil.findGameScoreByUserId(scopeGroupId, user.getUserId(),
				searchContainer.getStart(), 
				searchContainer.getEnd()) %>"
		total="<%=count %>" />

	<liferay-ui:search-container-row
		className="org.liferay.lifebringer.model.GameScore"
		keyProperty="gameId"
		modelVar="gameScore" escapedModel="<%= true %>"
	>
		<liferay-ui:search-container-column-text
			name="Time"
			property="createDate"
		/>

		<liferay-ui:search-container-column-text
			name="Score"
			property="gameScore"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%
		} else {
%>
	<h3> You haven't played yet!</h3>
<%	
		} }
%>