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
<h1>Voorkeur Pizza's</h1>
<form>
    <ul class="zonderbolletjes">
        <c:forEach var="pizza" items="${pizzas}">
            <li>
                <label><input type="checkbox" name="id" value="${pizza.id}">
                    <c:out value="${pizza.naam}"/></label>
            </li>
        </c:forEach>
    </ul>
    <input value="Toon mijn resultaten" type="submit">
    <c:if test="${not empty voorkeurPizzas}">
        <h2>Jouw voorkeuren</h2>
        <ul class="zebra">
            <c:forEach var="pizza" items="${voorkeurPizzas}">
                <li>${pizza.id}: <c:out value="${pizza.naam}"/> €${pizza.prijs}
                    <c:if test="${pizza.pikant}">
                        <img src="../../images/chili.png" width="12" height="12">
                    </c:if>
                    <c:url value="detail.htm" var="detailURL">
                        <c:param name="id" value="${pizza.id}"/>
                    </c:url>
                    <a href="${detailURL}">Detail</a>
                </li>
            </c:forEach>
        </ul>
    </c:if>
</form>
</body>
</html>