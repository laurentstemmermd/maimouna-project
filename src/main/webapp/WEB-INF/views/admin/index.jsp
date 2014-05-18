<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Les sites existants : </h1>

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
                <td><c:out value="${s.host}"/></td>
                <td><c:out value="${s.logPath}"/></td>
                <td><c:out value="${s.logType}"/></td>
                <td><c:out value="${s.connectionType}"/></td>
                <td><c:out value="${s.userName}"/></td>
                <td>****************</td>
                <td>
                    <a class="btn btn-danger" href="/site/delete?name=${s.name}">Supprimer <span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>

        </c:forEach>

    </tbody>
</table>

<div>
    <form accept-charset="UTF-8" action="/site/new" class="new_site" id="new_site" method="post">
            <input id="name" name="name" size="10" type="text" placeholder="Nom">
            <input id="name" name="host" size="10" type="text" placeholder="Hote">
            <input id="path" name="logPath" size="70" type="text" placeholder="Chemin des logs">
            <select name="logType">
                <option value="CSV">CSV</option>
                <option value="XML">XML</option>
            </select>
            <select name="connectionType">
                <option value="SSH">SSH</option>
                <option value="FTP">FTP</option>
            </select>
            <input id="name" name="userName" size="10" type="text" placeholder="Utilisateur" autocomplete="off">
            <input id="name" name="password" size="10" type="password" placeholder="Mot de passe"autocomplete="off">
            <input class="btn btn-success" name="commit" type="submit" value="Ajouter site">
    </form>
    
</div>
