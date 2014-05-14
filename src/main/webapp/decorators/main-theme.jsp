<%@page import="sun.misc.JavaxSecurityAuthKerberosAccess"%>
<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default="Default title" /></title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/css/main.css" rel="stylesheet" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<decorator:head />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Link</a></li>
			</ul>
			<div class="navbar-text pull-right">
				<c:choose>
                                    <c:when test="${contains}">
                                            <jsp:include page="_greetings.jsp" >
                                                    <jsp:param value="${cookie.user.value}" name="user"/>
                                            </jsp:include>
                                    </c:when>
                                    <c:otherwise>
                                            <jsp:include page="_login.jsp" />
                                    </c:otherwise>
				</c:choose>
			</div>
		</div>
	</nav>
	<decorator:body />
	<hr />
	<h1>Footer</h1>
	<a class="navbar-brand" href="/logout">Déconnexion</a>
</body>
</html>