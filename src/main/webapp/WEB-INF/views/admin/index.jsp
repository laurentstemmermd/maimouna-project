<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Bienvenue <%=request.getSession().getAttribute(com.qos.filters.AuthFilter.CURRENT_USER_IN_REQUEST)%></h1>
    </body>
</html>
