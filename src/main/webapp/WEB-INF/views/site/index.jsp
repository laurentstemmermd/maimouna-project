<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
