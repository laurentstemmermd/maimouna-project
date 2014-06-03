<?xml version="1.0" encoding="UTF-8" ?>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title><decorator:title default="QOS Tracking" /></title>
<link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" />
<link href="/resources/css/main.css" rel="stylesheet" />
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
<script type="text/javascript" src="https://www.google.com/jsapi"></script>
<decorator:head />
</head>
<body>
	<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Quality of Service</a>
		</div>
		<div class="collapse navbar-collapse navbar-ex1-collapse">
			<div class="navbar-text pull-right">
				<c:choose>
					<c:when test="${cookie.user != null}">
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
        <div class="container" id="getting-started">
            <decorator:body />
        </div>
        <div>
	Projet fait par Maimouna, 2014
        </div>
            
</body>
</html>