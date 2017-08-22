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
<h1>Headers</h1>

<dl>
    <dt>Browser</dt>
    <dd>${empty browser ? "Onbekend" : browser}</dd>
    <c:forEach var="h" items="${headers}">
        <dt>${h.key}</dt>
        <dd>${h.value}</dd>
    </c:forEach>
</dl>
</body>
</html>