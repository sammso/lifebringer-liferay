<%@include file="init.jsp"%>
<%
String sql = "SELECT {u.*}, (sum(lgs.missed) * 100 )/ sum(lgs.fired) as value FROM lifebringer_GameScore as lgs INNER JOIN User_ as u ON lgs.userId = u.userId  WHERE groupId = ? GROUP BY u.userId ORDER BY value ASC";
%>
<h1>Most accurate players</h1>
<liferay-ui:search-container emptyResultsMessage="No games">
	<liferay-ui:search-container-results
		results="<%=GameScoreLocalServiceUtil.findValues(scopeGroupId, sql, searchContainer.getStart(), searchContainer.getEnd()) %>" total="<%=GameScoreLocalServiceUtil.countTopPlayers(scopeGroupId) %>" />
		
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
			name="All games Miss %"
			property="value"
		/>
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
