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
    <dt>Pizza's lijst</dt>
    <dd>${pizzaRequests}</dd>
    <dt>Pizza's Detail</dt>
    <dd>${pizzaDetailRequests}</dd>
    <dt>Statistieken</dt>
    <dd>${statistiekRequests}</dd>
    <dt>Tussen prijzen</dt>
    <dd>${pizzasTussenPrijzenDetailRequests}</dd>
    <dt>Voorkeur Pizza's</dt>
    <dd>${voorkeurPizzasRequests}</dd>

</dl>
</body>
</html>