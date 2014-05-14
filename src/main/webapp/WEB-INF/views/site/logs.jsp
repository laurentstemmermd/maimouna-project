<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Les dernières alertes pour le site ${site.name}</h3>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>Date</th>
                <th>Niveau de log</th>
                <th>Message</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${logs}" var="l">
             <tr>
                    <td><c:out value="${l.date}"/></td>
                    <td><c:out value="${l.level}"/></td>
                    <td><c:out value="${l.message}"/></td>
                </tr>

            </c:forEach>

        </tbody>
    </table>
</div>