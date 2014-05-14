<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Site</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
        
    </head>
    <body>
        <h1>Details du site ${site.name}</h1>
        
        <table class="table table-striped">
		<thead>
                    <tr>
                        <th>Chemin des logs</th>
                        <th>Type de log</th>
                        <th></th>
                        <th></th>
                    </tr>
		</thead>
		<tbody>
                     <tr>
                        <td><c:out value="${site.path}"/></td>
                        <td><c:out value="${site.parserType}"/></td>
                    </tr>
		</tbody>
	</table>
                    
        <jsp:include page="logs.jsp" />
        <jsp:include page="stats.jsp" />
    </body>
</html>
