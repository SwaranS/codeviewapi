<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script type="text/javascript" src="resources/js/jquery-2.1.1.js"></script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<div id="msgid">
</div>
<P>  The time on the server is ${serverTime}. </P>
<P>  The time on the server is ${jsonData.labels}. </P>
</body>
</html>
