<%@page contentType='text/html' pageEncoding='UTF-8' session='false' %>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core' %>
<!DOCTYPE html>
<html lang="nl">
<head>
    <c:import url="/WEB-INF/JSP/head.jsp">
        <c:param name="title" value="Pizza Luigi : ${pizza.naam}"/>
    </c:import>
</head>
<body>
<c:import url="/WEB-INF/JSP/menu.jsp"/>

<c:choose>
    <c:when test="${not empty fout}">
        <div class="fout">${fout}</div>
    </c:when>
    <c:when test="${empty pizza}">
        <div class="fout">Pizza niet gevonden</div>
    </c:when>
    <c:otherwise>
        <h1>${pizza.naam}</h1>
        <dl>
            <dt>Nummer :</dt>
            <dd>${pizza.id}</dd>
            <dt>Naam :</dt>
            <dd>${pizza.naam}</dd>
            <dt>Prijs :</dt>
            <dd>${pizza.prijs}</dd>
            <dt>Pikant :</dt>
            <dd>${pizza.pikant ? "Ja" : "Neen"}</dd>
            <dt>Foto :</dt>
            <c:choose>
                <c:when test="${pizzaIdsMetFoto.contains(pizza.id)}">
                    <c:url value="/pizzafotos/${pizza.id}.jpg" var="fotoURL"/>
                    <img src="${fotoURL}" alt="Foto van een ${pizza.naam} pizza"/>
                </c:when>
                <c:otherwise>
                    <img src="/pizzafotos/no-image.jpg" alt="Geen afbeelding"/>
                </c:otherwise>
            </c:choose>
            <dd>
        </dl>
    </c:otherwise>
</c:choose>

</body>
</html>