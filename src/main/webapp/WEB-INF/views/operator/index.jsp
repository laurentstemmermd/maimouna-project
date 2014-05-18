<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Les sites existants : </h1>
<table class="table table-striped">
        <thead>
            <tr>
                <th>Nom du site</th>
                <th>Hote</th>
                <th>Chemin des logs</th>
                <th>Type de log</th>
                <th>Type de connexion</th>
                <th>Utilisateur</th>
                <th>Mot de passe</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${sites}" var="s">
             <tr>
                    <td><c:out value="${s.name}"/></td>
                    <td><c:out value="${s.host}"/></td>
                    <td><c:out value="${s.logPath}"/></td>
                    <td><c:out value="${s.logType}"/></td>
                    <td><c:out value="${s.connectionType}"/></td>
                    <td><c:out value="${s.userName}"/></td>
                    <td>****************</td>
                    <td>
                        <a class="btn btn-success" href="/site/detail?name=${s.name}"><i class="icon-eye"></i> Voir les détails</a>
                    </td>
                </tr>

            </c:forEach>

        </tbody>
</table>
