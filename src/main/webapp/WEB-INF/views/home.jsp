<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
	<script src="/resources/js/home/home.js"></script>
</head>
<body>
<h2>Subtitle</h2>
<p id="server-time">The time on the server is ${serverTime}. </p>
<p><a href="#" id="toggle-time">Click to toggle server time</a></p>
</body>
</html>
