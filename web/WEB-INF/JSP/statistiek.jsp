<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Statistieken</h1>
<dl>
    <dt>Welkom</dt>
    <dd>${indexRequests}</dd>
    <dt>Pizza's</dt>
    <dd>${pizzaRequests}</dd>
    <dt>Statistieken</dt>
    <dd>${statistiekRequests}</dd>
</dl>
</body>
</html>