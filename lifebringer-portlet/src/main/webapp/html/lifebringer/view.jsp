<%@include file="init.jsp"%>

<portlet:renderURL windowState="<%=LiferayWindowState.EXCLUSIVE.toString() %>" var="gameUrl">
	<portlet:param name="mvcPath" value="/html/lifebringer/game.jsp"/>
	<portlet:param name="lastGameId" value="QWEQWE" />
</portlet:renderURL>

<h3 class="aui">Ray's Lifebringer</h3>
<%
	if (themeDisplay.isSignedIn()) { 
		
		long gameId = ParamUtil.get(renderRequest, "gameId", -1);
		
		GameScore currentGameScore = null;
		if ( gameId!=-1 )
			currentGameScore = GameScoreLocalServiceUtil.getGameScore(gameId);
		
%>
<p><a href="<%=gameUrl %>" class="btn btn-primary btn-block">Start game</a></p>
<% if (currentGameScore!=null) { %>
<h3 class="aui">Your result</h3>
<ul>
	<li><b>Score: <%=currentGameScore.getGameScore() %></b></li>
	<li>Zombies killed:<%=(currentGameScore.getRedZombiesKilled() + currentGameScore.getGreenZombiesKilled()) %>
	<ul>
		<li>Red: <%=currentGameScore.getRedZombiesKilled() %></li>
		<li>Green: <%=currentGameScore.getGreenZombiesKilled() %></li>
	</ul>
	</li> 
	<li>Bullets Fired: <%=currentGameScore.getFired() %> <%=(((currentGameScore.getMissed() * 100)/currentGameScore.getFired())<10)? "<b>Nice ACCURATE</b>" : "" %>
		<ul>
			<li>Hit: <%=currentGameScore.getFired() - currentGameScore.getMissed() %></li>
			<li>Missed: <%=currentGameScore.getMissed() %></li>
		</ul>
	</li> 
	<li>Level: <%=currentGameScore.getLevel() %></li>
</ul>
<% }
%>
<h3 class="aui">Your games</h3>
<liferay-ui:search-container emptyResultsMessage="No games">
	<liferay-ui:search-container-results
		results="<%=GameScoreServiceUtil.findGameScoreByUserId(scopeGroupId, user.getUserId(),
				searchContainer.getStart(), 
				searchContainer.getEnd()) %>"
		total="<%=GameScoreServiceUtil.countGameScoreByUserId(scopeGroupId, user.getUserId()) %>" />

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
		<liferay-ui:search-container-column-text
			name="Red Zombies Killed"
			property="redZombiesKilled"
		/>
		<liferay-ui:search-container-column-text
			name="Green Zombies Killed"
			property="greenZombiesKilled"
		/>
		<liferay-ui:search-container-column-text
			name="Fired"
			property="fired"
		/>
		<liferay-ui:search-container-column-text
			name="Missed"
			property="missed"
		/>
		<liferay-ui:search-container-column-text
			name="Level"
			property="level"
		/>		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>
<%
	}
%>