<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Operator Page</title>
        <link href="//netdna.bootstrapcdn.com/bootstrap/2.3.2/css/bootstrap.min.css" rel="stylesheet">
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
        <link href="http://heroku.github.com/template-app-bootstrap/heroku.css" rel="stylesheet">
        
    </head>
    <body>
        <h1>Bienvenue <%=request.getSession().getAttribute(com.qos.filters.AuthFilter.CURRENT_USER_IN_REQUEST)%></h1>
        
        <table class="table table-striped">
		<thead>
                    <tr>
                        <th>Nom du site</th>
                        <th>Chemin des logs</th>
                        <th>Type de log</th>
                        <th></th>
                        <th></th>
                    </tr>
		</thead>
		<tbody>
                    <c:forEach items="${sites}" var="s">
                     <tr>
                            <td><c:out value="${s.name}"/></td>
                            <td><c:out value="${s.path}"/></td>
                            <td><c:out value="${s.parserType}"/></td>
                            <td>
                                <a class="btn btn-success" href="/"><i class="icon-signal"></i> Voir les logs</a>
                            </td>
                            <td>
                                <a class="btn btn-success" href="/"><i class="glyphicon glyphicon-stats"></i> Voir les statistiques</a>
                            </td>
                        </tr>
                    
                    </c:forEach>

		</tbody>
	</table>
    </body>
</html>
