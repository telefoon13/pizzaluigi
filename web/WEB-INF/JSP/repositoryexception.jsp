<%@page contentType='text/html' pageEncoding='UTF-8' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!doctype html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi - 500"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>
<h1>Data fout (500)</h1>
<img src="../../images/datafout.jpg" alt="Data fout">
<p>Er is een data fout opgetreden in ons systeem gelieven de helpdesk te contacteren als dit probleem zich blijft
    voordoen.</p>
<div>Helpdesk : ${helpDeskTelefoon}</div>
</body>
</html>