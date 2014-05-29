<%@page import="com.qos.models.LogStatus"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div>
    <h3>Les dernières alertes</h3>
    
    <table class="table table-striped">
        <thead>
            <tr>
                <th>service</th>
                <th>eventDate</th>
                <th>status</th>
                <th>attempt</th>
                <th>statusInfo</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${logs}" var="l">
             <tr class="DANGER">
                    <td><c:out value="${l.service}"/></td>
                    <td><c:out value="${l.eventDate}"/></td>
                    <td style='color:white;background-color:<c:choose><c:when test="${l.ok}">green</c:when><c:otherwise>red</c:otherwise></c:choose>'><c:out value="${l.status}"/></td>
                    <td><c:out value="${l.attempt}"/></td>
                    <td><c:out value="${l.statusInfo}"/></td>
                </tr>

            </c:forEach>

        </tbody>
    </table>
</div>

<script>
    $( document ).ready(function() {
        setTimeout(refresh, 10000);
    });

     function refresh() {
         console.log( "ready!" );
        window.location.reload(true);
        setTimeout(refresh, 10000);
     }
     
</script>