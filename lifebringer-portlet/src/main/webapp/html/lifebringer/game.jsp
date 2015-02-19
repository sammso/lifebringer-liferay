<%@include file="init.jsp"%>
<%
	if (themeDisplay.isSignedIn()) {
%>
<portlet:actionURL name="gameOver" var="gameOverUrl">
	<portlet:param name="gameId" value="QWEQWE"/>
</portlet:actionURL>   
<portlet:resourceURL var="resourceUrl"/>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">

		<title>Ray's Life Bringer</title>

		<meta name="description" content="">
		<!-- 
		 <meta name="viewport" content="width=device-width, initial-scale=1">
		-->
		
		<script src="/lifebringer-portlet/js/jquery-2.1.3.js" type="text/javascript"></script>
		<script src="/lifebringer-portlet/js/phaser-2.2.2.js"></script>

		<link rel="stylesheet" href="/lifebringer-portlet/assets/fonts/badabb.css" type="text/css" charset="utf-8">
	
		<style>
			body {
				background-color: #3A3B43;
				margin: 0px 0px 1px 0px; /* the extra 1px allows the iOS inner/outer check to work */
			}

			#lzs {
				margin-left: auto;
				margin-right: auto;
			}

			#lzs canvas {
				margin-left: auto;
				margin-right: auto;
			}
			
			#orientation {
			    margin: 0 auto;
			    position: absolute;
			    top: 0;
			    left: 0;
			    width: 100%;
			    height: 100%;
			    background-image: url(/lifebringer-portlet/assets//images/change-orientation.png?t=<%=System.currentTimeMillis() %>); 
			    background-repeat: no-repeat;
			    background-position: center;
			    background-color: rgb(0, 0, 0);
			    z-index: 999;
			    display: none;
			}
		</style>
	</head>
	<body>
		<script type="lifebringer">
			{ 
				"gameOverPageUrl": <%="\"" + gameOverUrl + "\"" %>, 
				"groupId": <%=scopeGroupId %>,
				"sendScoreUrl": <%="\"" + resourceUrl + "\"" %>
			}
		</script>
		<div id="lzs"></div>
		<div id="orientation">
			<h1>Use portrait</h1>
		</div>
		<script src="/lifebringer-portlet/js/lzs.js?t=<%=System.currentTimeMillis() %>"></script>	
	</body>
</html>
<%
	}
	else {
%><html>
	<head>
		<meta charset="utf-8">
		<title>Ray's Life Bringer</title>
	</head>
	<body>
	<h1>Please login to play game</h1>
	</body>
</html>
<%
	}
%>


