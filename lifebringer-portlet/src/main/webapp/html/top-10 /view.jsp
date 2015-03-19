<%@include file="init.jsp"%>
<%
String sql = "SELECT {u.*}, max(lgs.gameScore) as value FROM lifebringer_GameScore as lgs INNER JOIN User_ as u ON lgs.userId = u.userId  WHERE lgs.groupId = ? GROUP BY u.userId ORDER BY value DESC";

int count = GameScoreLocalServiceUtil.countTopPlayers(scopeGroupId);

count = count < 10 ? count : 10;

%>
<liferay-ui:search-container emptyResultsMessage="No games" >
	<liferay-ui:search-container-results
		results="<%=GameScoreLocalServiceUtil.findValues(scopeGroupId, sql, searchContainer.getStart(), searchContainer.getEnd()) %>" total="<%=count %>" />
		
	<liferay-ui:search-container-row
		className="org.liferay.lifebringer.model.UserValue"
		keyProperty="userId"
		modelVar="userValue" escapedModel="<%= false %>"
	>
		<%
			String name = HtmlUtil.escape(userValue.getUser().getFirstName() + " " + userValue.getUser().getLastName());
		%>

		<liferay-ui:search-container-column-text
			name="Player name"
			value="<%=name %>"
		/>
		<liferay-ui:search-container-column-text
			name="Score"
			property="value"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
