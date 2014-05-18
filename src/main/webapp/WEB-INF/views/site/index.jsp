<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h1>Details du site ${site.name}</h1>

<table class="">
        <tbody>
             <tr>
                <td>Nom :</td>
                <td><c:out value="${site.name}"/></td>
            </tr>
             <tr>
                <td>Hote :</td>
                <td><c:out value="${site.host}"/></td>
            </tr>
             <tr>
                <td>Chemin des logs :</td>
                <td><c:out value="${site.logPath}"/></td>
            </tr>
             <tr>
                <td>Type de log :</td>
                <td><c:out value="${site.logType}"/></td>
            </tr>
             <tr>
                <td>Type de connexion :</td>
                <td><c:out value="${site.connectionType}"/></td>
            </tr>
             <tr>
                <td>Utilisateur :</td>
                <td><c:out value="${site.userName}"/></td>
            </tr>
             <tr>
                <td>Mot de passe :</td>
                <td>****************</td>
            </tr>
        </tbody>
</table>

<jsp:include page="logs.jsp" />
<jsp:include page="stats.jsp" />
