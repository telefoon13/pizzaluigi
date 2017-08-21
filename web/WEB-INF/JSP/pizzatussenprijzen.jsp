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
<h1>Pizza's tussen prijzen</h1>

<form>
    <label>Van prijs<span>${fouten.van}</span>
        <input name="van" autofocus type="number" min="0" required value="${param.van}"></label>
    <label>Tot prijs<span>${fouten.tot}</span>
        <input name="tot" type="number" min="0" required value="${param.tot}"></label>
    <input type="submit" value="Zoeken !">
</form>

<c:if test="${not empty pizzas}">
    <ul class="zebra">
        <c:forEach var="pizza" items="${pizzas}">
            <li>${pizza.id}: <c:out value="${pizza.naam}"/> €${pizza.prijs}
                <c:if test="${pizza.pikant}">
                    <img src="../../images/chili.png" width="12" height="12">
                </c:if>
                <c:url value="pizzas/detail.htm" var="detailURL">
                    <c:param name="id" value="${pizza.id}"/>
                </c:url>
                <a href="${detailURL}">Detail</a>
            </li>
        </c:forEach>
    </ul>
</c:if>
<c:if test="${not empty param and empty fouten and empty pizzas}">
    <div class="fout">Geen pizza's gevonden</div>
</c:if>
</body>
</html>