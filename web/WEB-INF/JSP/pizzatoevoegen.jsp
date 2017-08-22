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
<h1>Pizza toevoegen</h1>
<form method="post" id="toevoegform">
    <label>naam<span>${fouten.naam}</span>
        <input name="naam" value="${param.naam}" autofocus required></label>
    <label>Prijs<span>${fouten.prijs}</span>
        <input name="prijs" value="${param.prijs}" required type="number" min="0" max="100" step="0.01"></label>
    <div><label><input type="checkbox" name="pikant" value="pikant">Pikant ?</label></div>
    <input type="submit" value="Toevoegen !" id="toevoegknaop">
</form>
</body>
</html>